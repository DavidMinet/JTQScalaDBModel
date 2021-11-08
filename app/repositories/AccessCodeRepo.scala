package app.repositories

import java.util.Date
import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

import models.AccessCode
import _root_.app.repositories._
import _root_.models.DatabaseExecutionContext

@javax.inject.Singleton
class AccessCodeRepo @Inject()(dbapi: DBApi, visitorRepository: VisitorRepo, queueRepository: QueueRepo)(implicit ec: DatabaseExecutionContext) {

  private val db = dbapi.database("default")

  /**
   * Parse a AccessCode from a ResultSet
   */
  private val simple = {
    get[Int]("accessCode.id") ~
      get[String]("accessCode.ticketNumber") ~
      get[Long]("accessCode.creationTime") ~
      get[Long]("accessCode.startTime") ~
      get[Long]("accessCode.endTime") ~
      get[Int]("accessCode.queue_id") ~
      get[Int]("accessCode.visitor_id") map {
      case id ~ ticketNumber ~ creationTime ~ startTime ~ endTime ~ queueId ~ visitorId =>
        AccessCode(id, ticketNumber, creationTime, startTime, endTime, queueId, visitorId)
    }
  }

  /**
   * Insert a new accesscode.
   *
   * @param accessCode The accessCode values.
   */
  def insert(accessCode: AccessCode): Future[Option[Long]] = Future {
    db.withConnection { implicit connection =>
      SQL("""
        insert into accesscode(id, ticketnumber, creationtime, starttime, endtime, queueid, visitorid) 
        values ({id}, {ticketNumber}, {creationTime}, {startTime}, {endTime}, {queueId}, {visitorId})
      """).bind(accessCode).executeInsert()
    }
  }(ec)

  /**
   * Delete a accessCode.
   *
   * @param id Id of the computer to delete.
   */
  def delete(id: Int) = Future {
    db.withConnection { implicit connection =>
      SQL"delete from accesscode where id = ${id}".executeUpdate()
    }
  }(ec)

  /**
   * Retrieve a accesscode from the id.
   */
  def findById(id: Int): Future[Option[AccessCode]] = Future {
    db.withConnection { implicit connection =>
      SQL"select * from accesscode where id = $id".as(simple.singleOpt)
    }
  }(ec)  
  
  def newId: Int = {
    db.withConnection { implicit connection =>
      SQL"SELECT MAX(id) FROM accesscode;".as(SqlParser.scalar[Int].single) + 1
    }
  }  
}
