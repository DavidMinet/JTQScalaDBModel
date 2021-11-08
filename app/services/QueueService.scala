package services

import java.util.Date
import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

import _root_.models.Queue
import _root_.models.DatabaseExecutionContext
import _root_.app.repositories.QueueRepo

@javax.inject.Singleton
class QueueService @Inject()(QueueRepo: QueueRepo, dbapi: DBApi)(implicit ec: DatabaseExecutionContext) {

  private val db = dbapi.database("default")

  def findById(id: Int): Queue = {
    QueueRepo.findById(id)
  }

  def findAll: Seq[Queue] = {
    QueueRepo.findAll
  }
    
  def newId: Int = {
    QueueRepo.newId
  }

  def showCurrentNumber(queue: Queue): String = {
    val currentNumber = queue.customers
    if (currentNumber == 0) "Q000"
    else if (currentNumber <10) s"Q00$currentNumber"
    else if (currentNumber < 100) s"Q0$currentNumber"
    else s"Q$currentNumber"
  }

}