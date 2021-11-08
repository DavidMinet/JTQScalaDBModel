package utils

import javax.inject._
import play.api._
import play.api.mvc._
import models._
import play.api.data._
import play.api.data.Forms._
import services.QueueService
import services.VisitorService
import services.AccessCodeService
import _root_.app.repositories.QueueRepo
import _root_.app.repositories.VisitorRepo
import _root_.app.repositories.AccessCodeRepo
import _root_.controllers.CreateData

import scala.concurrent.{Await, ExecutionContext, Future}

object VisitorUtils {
    val createForm: Form[CreateData] = Form(mapping(
    "Username" -> email,
    "Password" -> text(8),
    "Name" -> nonEmptyText,
    "PhoneNumber" -> nonEmptyText,
    "AcceptedCommercial" -> boolean,
    "AcceptedTerms" -> boolean
  )(CreateData.apply)(CreateData.unapply))
}