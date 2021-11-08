package models

import java.util.Date
import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

import _root_.app.repositories._

case class AccessCode(id: Int,
                      ticketNumber: String,
                      creationTime: Long,
                      startTime: Long,
                      endTime: Long,
                      queueId: Int,
                      visitorId: Int)

object AccessCode {
  implicit def toParameters: ToParameterList[AccessCode] =
    Macro.toParameters[AccessCode]
}
