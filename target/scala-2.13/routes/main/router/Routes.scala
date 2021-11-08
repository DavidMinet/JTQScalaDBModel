// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  VisitorController_1: controllers.VisitorController,
  // @LINE:9
  Assets_0: controllers.Assets,
  // @LINE:25
  QueueController_2: controllers.QueueController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    VisitorController_1: controllers.VisitorController,
    // @LINE:9
    Assets_0: controllers.Assets,
    // @LINE:25
    QueueController_2: controllers.QueueController
  ) = this(errorHandler, VisitorController_1, Assets_0, QueueController_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, VisitorController_1, Assets_0, QueueController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.VisitorController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """visitor""", """controllers.VisitorController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.VisitorController.login"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.VisitorController.validateLogin"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.VisitorController.logout"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """visitor/create""", """controllers.VisitorController.create()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """visitor/""" + "$" + """id<[^/]+>""", """controllers.VisitorController.show(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """visitor/edit/""" + "$" + """id<[^/]+>""", """controllers.VisitorController.edit(id:Integer)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """visitor/edit""", """controllers.VisitorController.update()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """visitor/create""", """controllers.VisitorController.save()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """visitor/delete/""" + "$" + """id<[^/]+>""", """controllers.VisitorController.destroy(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """queue""", """controllers.QueueController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """queue/create""", """controllers.QueueController.create"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """queue/create""", """controllers.QueueController.save"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """queue/destroy/""" + "$" + """id<[^/]+>""", """controllers.QueueController.destroy(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """queue/show/""" + "$" + """id<[^/]+>""", """controllers.QueueController.show(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """queue/join""", """controllers.VisitorController.joinQueue"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_VisitorController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_VisitorController_index0_invoker = createInvoker(
    VisitorController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Default path will just redirect to the computer list""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_at1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Assets_versioned2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned2_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_VisitorController_index3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("visitor")))
  )
  private[this] lazy val controllers_VisitorController_index3_invoker = createInvoker(
    VisitorController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "index",
      Nil,
      "GET",
      this.prefix + """visitor""",
      """VisitorController""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_VisitorController_login4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_VisitorController_login4_invoker = createInvoker(
    VisitorController_1.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_VisitorController_validateLogin5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_VisitorController_validateLogin5_invoker = createInvoker(
    VisitorController_1.validateLogin,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "validateLogin",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_VisitorController_logout6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_VisitorController_logout6_invoker = createInvoker(
    VisitorController_1.logout,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_VisitorController_create7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("visitor/create")))
  )
  private[this] lazy val controllers_VisitorController_create7_invoker = createInvoker(
    VisitorController_1.create(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "create",
      Nil,
      "GET",
      this.prefix + """visitor/create""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_VisitorController_show8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("visitor/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_VisitorController_show8_invoker = createInvoker(
    VisitorController_1.show(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "show",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """visitor/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_VisitorController_edit9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("visitor/edit/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_VisitorController_edit9_invoker = createInvoker(
    VisitorController_1.edit(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "edit",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """visitor/edit/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_VisitorController_update10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("visitor/edit")))
  )
  private[this] lazy val controllers_VisitorController_update10_invoker = createInvoker(
    VisitorController_1.update(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "update",
      Nil,
      "POST",
      this.prefix + """visitor/edit""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_VisitorController_save11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("visitor/create")))
  )
  private[this] lazy val controllers_VisitorController_save11_invoker = createInvoker(
    VisitorController_1.save(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "save",
      Nil,
      "POST",
      this.prefix + """visitor/create""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_VisitorController_destroy12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("visitor/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_VisitorController_destroy12_invoker = createInvoker(
    VisitorController_1.destroy(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "destroy",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """visitor/delete/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_QueueController_index13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("queue")))
  )
  private[this] lazy val controllers_QueueController_index13_invoker = createInvoker(
    QueueController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QueueController",
      "index",
      Nil,
      "GET",
      this.prefix + """queue""",
      """QueueController""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_QueueController_create14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("queue/create")))
  )
  private[this] lazy val controllers_QueueController_create14_invoker = createInvoker(
    QueueController_2.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QueueController",
      "create",
      Nil,
      "GET",
      this.prefix + """queue/create""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_QueueController_save15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("queue/create")))
  )
  private[this] lazy val controllers_QueueController_save15_invoker = createInvoker(
    QueueController_2.save,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QueueController",
      "save",
      Nil,
      "POST",
      this.prefix + """queue/create""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:29
  private[this] lazy val controllers_QueueController_destroy16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("queue/destroy/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_QueueController_destroy16_invoker = createInvoker(
    QueueController_2.destroy(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QueueController",
      "destroy",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """queue/destroy/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_QueueController_show17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("queue/show/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_QueueController_show17_invoker = createInvoker(
    QueueController_2.show(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QueueController",
      "show",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """queue/show/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_VisitorController_joinQueue18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("queue/join")))
  )
  private[this] lazy val controllers_VisitorController_joinQueue18_invoker = createInvoker(
    VisitorController_1.joinQueue,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.VisitorController",
      "joinQueue",
      Nil,
      "POST",
      this.prefix + """queue/join""",
      """""",
      Seq("""nocsrf""")
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_VisitorController_index0_route(params@_) =>
      call { 
        controllers_VisitorController_index0_invoker.call(VisitorController_1.index)
      }
  
    // @LINE:9
    case controllers_Assets_at1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_0.at(path, file))
      }
  
    // @LINE:10
    case controllers_Assets_versioned2_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned2_invoker.call(Assets_0.versioned(path, file))
      }
  
    // @LINE:13
    case controllers_VisitorController_index3_route(params@_) =>
      call { 
        controllers_VisitorController_index3_invoker.call(VisitorController_1.index)
      }
  
    // @LINE:14
    case controllers_VisitorController_login4_route(params@_) =>
      call { 
        controllers_VisitorController_login4_invoker.call(VisitorController_1.login)
      }
  
    // @LINE:15
    case controllers_VisitorController_validateLogin5_route(params@_) =>
      call { 
        controllers_VisitorController_validateLogin5_invoker.call(VisitorController_1.validateLogin)
      }
  
    // @LINE:16
    case controllers_VisitorController_logout6_route(params@_) =>
      call { 
        controllers_VisitorController_logout6_invoker.call(VisitorController_1.logout)
      }
  
    // @LINE:17
    case controllers_VisitorController_create7_route(params@_) =>
      call { 
        controllers_VisitorController_create7_invoker.call(VisitorController_1.create())
      }
  
    // @LINE:18
    case controllers_VisitorController_show8_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_VisitorController_show8_invoker.call(VisitorController_1.show(id))
      }
  
    // @LINE:19
    case controllers_VisitorController_edit9_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_VisitorController_edit9_invoker.call(VisitorController_1.edit(id))
      }
  
    // @LINE:20
    case controllers_VisitorController_update10_route(params@_) =>
      call { 
        controllers_VisitorController_update10_invoker.call(VisitorController_1.update())
      }
  
    // @LINE:21
    case controllers_VisitorController_save11_route(params@_) =>
      call { 
        controllers_VisitorController_save11_invoker.call(VisitorController_1.save())
      }
  
    // @LINE:22
    case controllers_VisitorController_destroy12_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_VisitorController_destroy12_invoker.call(VisitorController_1.destroy(id))
      }
  
    // @LINE:25
    case controllers_QueueController_index13_route(params@_) =>
      call { 
        controllers_QueueController_index13_invoker.call(QueueController_2.index)
      }
  
    // @LINE:26
    case controllers_QueueController_create14_route(params@_) =>
      call { 
        controllers_QueueController_create14_invoker.call(QueueController_2.create)
      }
  
    // @LINE:28
    case controllers_QueueController_save15_route(params@_) =>
      call { 
        controllers_QueueController_save15_invoker.call(QueueController_2.save)
      }
  
    // @LINE:29
    case controllers_QueueController_destroy16_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_QueueController_destroy16_invoker.call(QueueController_2.destroy(id))
      }
  
    // @LINE:30
    case controllers_QueueController_show17_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_QueueController_show17_invoker.call(QueueController_2.show(id))
      }
  
    // @LINE:32
    case controllers_VisitorController_joinQueue18_route(params@_) =>
      call { 
        controllers_VisitorController_joinQueue18_invoker.call(VisitorController_1.joinQueue)
      }
  }
}
