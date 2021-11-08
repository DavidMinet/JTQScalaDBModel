package app.repositories

import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

import _root_.models.DatabaseExecutionContext
import _root_.models.Visitor


@javax.inject.Singleton
class VisitorRepo @Inject()(dbapi: DBApi)(implicit ec: DatabaseExecutionContext) {

  private val db = dbapi.database("default")

  /**
   * Parse a Computer from a ResultSet
   */
  private val simple = {
    get[Int]("visitor.id") ~
      get[String]("visitor.username") ~
      get[String]("visitor.name") ~
      get[String]("visitor.phoneNumber") ~
      get[String]("visitor.password") ~
      get[Boolean]("visitor.acceptedCommercial") ~
      get[Boolean]("visitor.acceptedTerms") ~
      get[Boolean]("visitor.userType")  map {
      case id ~ username ~ name ~ phoneNumber ~ password ~ acceptedCommercial ~ acceptedTerms ~ userType =>
        Visitor(id, username, name, phoneNumber, password, acceptedCommercial, acceptedTerms, userType)
    }
  }

  /**
   * Insert a new visitor.
   *
   * @param visitor The visitor values.
   */
  def insert(visitor: Visitor): Future[Option[Long]] = Future {
    db.withConnection { implicit connection =>
      SQL("""
        insert into visitor values (
          (select next value for visitor_seq),
          {username}, {name}, {password}, {phoneNumber}, {acceptedCommercial}, {acceptedTerms}, {userType}
        )
      """).bind(visitor).executeInsert()
    }
  }(ec)

  /**
   * Delete a computer.
   *
   * @param id Id of the computer to delete.
   */
  def delete(id: Long) = Future {
    db.withConnection { implicit connection =>
      SQL"delete from visitor where id = ${id}".executeUpdate()
    }
  }(ec)
  
    /**
   * Retrieve a computer from the id.
   */
  def findById(id: Int): Future[Option[Visitor]] = Future {
    db.withConnection { implicit connection =>
      SQL"select * from visitor where id = $id".as(simple.singleOpt)
    }
  }(ec)
  
  def findByUsername(username: String): Visitor = {
    db.withConnection { implicit connection =>
      SQL"select * from visitor where username = $username".as(simple.single)
    }
  }

  def newId: Int = {
    db.withConnection { implicit connection =>
      SQL"SELECT MAX(id) FROM visitor;".as(SqlParser.scalar[Int].single) + 1
    }
  }
  
  def getPassword(username: String): Option[String] = {
    db.withConnection { implicit connection =>
      SQL"SELECT password FROM visitor WHERE username=$username;".as(SqlParser.scalar[String].singleOpt)
    }
  }  
}
