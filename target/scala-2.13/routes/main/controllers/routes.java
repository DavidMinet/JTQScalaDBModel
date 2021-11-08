// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseQueueController QueueController = new controllers.ReverseQueueController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseVisitorController VisitorController = new controllers.ReverseVisitorController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseQueueController QueueController = new controllers.javascript.ReverseQueueController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseVisitorController VisitorController = new controllers.javascript.ReverseVisitorController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
