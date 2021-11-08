package controllers

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
import utils.VisitorUtils

import scala.concurrent.{Await, ExecutionContext, Future}

case class CreateData( username: String, password: String, name: String, phoneNumber: String, acceptedCommercial: Boolean, acceptedTerms: Boolean) //This case class can't be in Utils

@Singleton
class VisitorController @Inject()(QueueService: QueueService, QueueRepo: QueueRepo, visitorService: VisitorService, visitorRepo: VisitorRepo, accessCodeService: AccessCodeService, accessCodeRepo: AccessCodeRepo, val controllerComponents: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesBaseController {
  val createForm = VisitorUtils.createForm
  
  def index: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.index())
  }

  def login = Action { implicit request =>
    Ok(views.html.visitorlogin())
  }

  def logout = Action{
    Redirect(routes.VisitorController.login).withNewSession
  }

  def validateLogin = Action{ implicit request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if (visitorService.validateLogin(username, password)){
        Redirect(routes.QueueController.index).withSession("username" -> username)
      } else {
        Redirect(routes.VisitorController.index).flashing("error" -> "Invalid username/password combination.")
      }
    }.getOrElse(Redirect(routes.VisitorController.login))
  }

  def create = Action{ implicit request =>
    Ok(views.html.visitorcreate(createForm)) //TODO Intellij not support play templates
  }

  def save = Action{ implicit request =>
    createForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.visitorcreate(formWithErrors)),
      ld => {
        if (!(visitorService.getPassword(ld.username).isEmpty)) Redirect(routes.VisitorController.index).flashing("error" -> "Username not available.")
        else {
          visitorRepo.insert(new Visitor(id = visitorService.newId, ld.username, ld.name, ld.phoneNumber, ld.password, ld.acceptedCommercial, ld.acceptedTerms, true))
          Redirect(routes.QueueController.index).withSession("username" -> ld.username)
        }
      })
  }

  def joinQueue = Action{ implicit request =>
    val visitorId = visitorService.findByUsername(request.session.get("username").get).id
    val queue = QueueService.findById(request.headers("referer").split("/").last.toInt)
    val newAC = new AccessCode(accessCodeService.newId,
      accessCodeService.generateTicket(queue),
      0,0,0, queue.id , visitorId)
    accessCodeRepo.insert(newAC)
    QueueRepo.updateCustomers(queue.id, queue)
    Ok(views.html.joinedqueue( newAC, queue))
  }


  def edit(id: Integer): Action[AnyContent] = {
    TODO
  }

  def update: Action[AnyContent] = {
    TODO
  }

  def destroy(id: Integer): Action[AnyContent] = {
    TODO
  }

  def show(id: Integer): Action[AnyContent] = {
    TODO
  }
}
