package controllers


import play.api.mvc._

import javax.inject._
import models._
import _root_.app.repositories._
import services.QueueService



@Singleton
class QueueController @Inject()(QueueService: QueueService, QueueRepo: QueueRepo, val controllerComponents: ControllerComponents) extends BaseController {

  def index = Action{ request =>
    val usernameOption = request.session.get("username")
    usernameOption.map{ username =>
      Ok(views.html.queueindex(QueueService.findAll)) 
    }.getOrElse(Redirect(routes.VisitorController.login))
  }

  def create = Action{
    Ok(views.html.createqueue()) 
  }

  def save = Action{ request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map {args =>
      val queueName = args("queueName").head
      QueueRepo.insert(new Queue(QueueService.newId, queueName, "", 36000, 36000, true, 0))
      Redirect(routes.QueueController.index)
    }.getOrElse(Ok("Oops"))
  }


  def edit(id: Integer): Action[AnyContent] = {
    TODO
  }

  def update: Action[AnyContent] = {
    TODO
  }

  def destroy(id: Int) = Action{
    QueueRepo.delete(id)
    Redirect(routes.QueueController.index)
  }

  def show(id: Int) = Action{
    Ok(views.html.queueshow(QueueService.findById(id)))
  }
}
