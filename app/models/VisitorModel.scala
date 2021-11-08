package models

import javax.inject.Inject

import anorm.SqlParser.{ get, scalar }
import anorm._
import play.api.db.DBApi

import scala.concurrent.Future

case class Visitor(id: Int,
                   username: String,
                   name: String,
                   phoneNumber: String,
                   password: String,
                   acceptedCommercial: Boolean,
                   acceptedTerms: Boolean,
                   userType: Boolean = true)

object Visitor {
  implicit def toParameters: ToParameterList[Visitor] =
    Macro.toParameters[Visitor]
}
