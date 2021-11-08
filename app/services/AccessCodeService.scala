package services

import java.util.Date
import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

import _root_.models.AccessCode
import _root_.models.Visitor
import _root_.models.Queue
import _root_.app.repositories._
import _root_.models.DatabaseExecutionContext
import _root_.app.repositories.AccessCodeRepo

@javax.inject.Singleton
class AccessCodeService @Inject()(dbapi: DBApi, AccessCodeRepo: AccessCodeRepo, visitorRepository: VisitorRepo, queueRepository: QueueRepo)(implicit ec: DatabaseExecutionContext) {

  private val db = dbapi.database("default")

  /**
   * Retrieve a accesscode from the id.
   */
  def findById(id: Int): Future[Option[AccessCode]] = {
    AccessCodeRepo.findById(id)
  }
  
  def newId: Int = {
    AccessCodeRepo.newId
  }

  def generateTicket(queue: Queue): String = {
    if (queue.customers == 0) "Q001"
    else {
      val newticket = (queue.customers+1).toString
      if (newticket.length == 1) s"Q00$newticket"
      else if (newticket.length == 2) s"Q0$newticket"
      else s"Q$newticket"
    }
  }
}
