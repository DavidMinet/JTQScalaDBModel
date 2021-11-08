package services

import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

import _root_.models.DatabaseExecutionContext
import _root_.models.Visitor
import _root_.app.repositories.VisitorRepo

@javax.inject.Singleton
class VisitorService @Inject()(VisitorRepo: VisitorRepo, dbapi: DBApi)(implicit ec: DatabaseExecutionContext) {

  private val db = dbapi.database("default")

  /**
   * Retrieve a computer from the id.
   */
  def findById(id: Int): Future[Option[Visitor]] = {
    VisitorRepo.findById(id)
  }

  def findByUsername(username: String): Visitor = {
    VisitorRepo.findByUsername(username)
  }

  def newId: Int = {
    VisitorRepo.newId
  }

  /**
   * Validate login.
   */
  def validateLogin(username: String, password: String): Boolean = {
    if (!(getPassword(username).isEmpty)) {
       if (password == getPassword(username).get) {
         true
       } else false
    } else false
  }

  def getPassword(username: String): Option[String] = {
    VisitorRepo.getPassword(username)
  }
  
}
