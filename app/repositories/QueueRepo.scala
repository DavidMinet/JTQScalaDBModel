package app.repositories

import java.util.Date
import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

import _root_.models.Queue
import _root_.models.DatabaseExecutionContext

@javax.inject.Singleton
class QueueRepo @Inject()(dbapi: DBApi)(implicit ec: DatabaseExecutionContext) {

  private val db = dbapi.database("default")

  /**
   * Parse a Queue from a ResultSet
   */
  private val simple = {
    get[Int]("queue.id") ~
      get[String]("queue.name") ~
      get[String]("queue.logo") ~
      get[Long]("queue.attentionTime") ~
      get[Long]("queue.minAttentionTime") ~
      get[Boolean]("queue.active") ~
      get[Int]("customers") map {
      case id ~ name ~ logo ~ attentionTime ~ minAttentionTime ~ active ~ customers =>
        Queue(id, name, logo, attentionTime, minAttentionTime, active, customers)
    }
  }

  /**
   * Parse a (Queue) from a ResultSet
   */
  private val withqueue = simple  map {
    case queue => queue
  }

  /**
   * Update a queue.
   *
   * @param id The queue id
   * @param queue The queue values.
   */
   def updateCustomers(id: Long, queue: Queue) = Future {
    db.withConnection { implicit connection =>
      SQL("""
        update queue set id = {id}, name = {name},
          logo = {logo}, attentionTime = {attentionTime},
          minAttentionTime = {minAttentionTime}, active = {active},
          customers = {customers}
        where id = {id}
      """).bind(queue.copy(customers = queue.customers+1)).executeUpdate()
    }
  }(ec)

  /**
   * Insert a new queue.
   *
   * @param queue The queue values.
   */
  def insert(queue: Queue): Future[Option[Long]] = Future {
    db.withConnection { implicit connection =>
      SQL("""
        insert into queue values (
          (select next value for queue_seq),
          {id}, {name}, {logo}, {attentionTime}, {minAttentionTime}, {active}, {customers}
        )
      """).bind(queue).executeInsert()
    }
  }(ec)

  /**
   * Delete a queue.
   *
   * @param id Id of the queue to delete.
   */
  def delete(id: Long) = Future {
    db.withConnection { implicit connection =>
      SQL"delete from queue where id = ${id}".executeUpdate()
    }
  }(ec)

  
    def findById(id: Int): Queue = {
    db.withConnection { implicit connection =>
      SQL"select * from queue where id = $id".as(simple.single)
    }
  }
  
    def findAll: Seq[Queue] = {
    db.withConnection { implicit connection =>
      SQL"select * from queue".as(simple.*)
    }
  }
    

    def newId: Int = {
    db.withConnection { implicit connection =>
      SQL"SELECT MAX(id) FROM queue;".as(SqlParser.scalar[Int].single) + 1
    }
  }
  
}