package models

import java.util.Date
import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

case class Queue(   id: Int,
                    name: String,
                    logo: String,
                    attentionTime: Long,
                    minAttentionTime: Long,
                    active: Boolean,
                    var customers: Int) 
                    

object Queue {
  implicit def toParameters: ToParameterList[Queue] =
    Macro.toParameters[Queue]
}
