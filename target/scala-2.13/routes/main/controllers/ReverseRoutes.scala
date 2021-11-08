// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:25
  class ReverseQueueController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def show(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "queue/show/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:29
    def destroy(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "queue/destroy/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:26
    def create: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "queue/create")
    }
  
    // @LINE:28
    def save: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "queue/create")
    }
  
    // @LINE:25
    def index: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "queue")
    }
  
  }

  // @LINE:6
  class ReverseVisitorController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def edit(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "visitor/edit/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:17
    def create(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "visitor/create")
    }
  
    // @LINE:32
    def joinQueue: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "queue/join")
    }
  
    // @LINE:18
    def show(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "visitor/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:15
    def validateLogin: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:22
    def destroy(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "visitor/delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:16
    def logout: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:21
    def save(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "visitor/create")
    }
  
    // @LINE:20
    def update(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "visitor/edit")
    }
  
    // @LINE:6
    def index: Call = {
    
      () match {
      
        // @LINE:6
        case ()  =>
          
          Call("GET", _prefix)
      
      }
    
    }
  
    // @LINE:14
    def login: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:10
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
