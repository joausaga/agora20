// @SOURCE:/Users/jorgesaldivar/agora2.0/conf/routes
// @HASH:2275c700f478659366c2ec7dfb5808911ff3d130
// @DATE:Sun May 27 19:54:18 CEST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Ideas_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:9
val controllers_Ideas_index1 = Route("GET", PathPattern(List(StaticPart("/ideas"))))
                    

// @LINE:10
val controllers_Ideas_voteUp2 = Route("POST", PathPattern(List(StaticPart("/ideas/voteUp"))))
                    

// @LINE:11
val controllers_Ideas_voteDown3 = Route("POST", PathPattern(List(StaticPart("/ideas/voteDown"))))
                    

// @LINE:12
val controllers_Ideas_change4 = Route("GET", PathPattern(List(StaticPart("/ideas/change"))))
                    

// @LINE:13
val controllers_Ideas_updateIdeaInfo5 = Route("GET", PathPattern(List(StaticPart("/ideas/update"))))
                    

// @LINE:16
val controllers_Assets_at6 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Ideas.index()"""),("""GET""","""/ideas""","""controllers.Ideas.index()"""),("""POST""","""/ideas/voteUp""","""controllers.Ideas.voteUp()"""),("""POST""","""/ideas/voteDown""","""controllers.Ideas.voteDown()"""),("""GET""","""/ideas/change""","""controllers.Ideas.change()"""),("""GET""","""/ideas/update""","""controllers.Ideas.updateIdeaInfo()"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Ideas_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Ideas.index(), HandlerDef(this, "controllers.Ideas", "index", Nil))
   }
}
                    

// @LINE:9
case controllers_Ideas_index1(params) => {
   call { 
        invokeHandler(_root_.controllers.Ideas.index(), HandlerDef(this, "controllers.Ideas", "index", Nil))
   }
}
                    

// @LINE:10
case controllers_Ideas_voteUp2(params) => {
   call { 
        invokeHandler(_root_.controllers.Ideas.voteUp(), HandlerDef(this, "controllers.Ideas", "voteUp", Nil))
   }
}
                    

// @LINE:11
case controllers_Ideas_voteDown3(params) => {
   call { 
        invokeHandler(_root_.controllers.Ideas.voteDown(), HandlerDef(this, "controllers.Ideas", "voteDown", Nil))
   }
}
                    

// @LINE:12
case controllers_Ideas_change4(params) => {
   call { 
        invokeHandler(_root_.controllers.Ideas.change(), HandlerDef(this, "controllers.Ideas", "change", Nil))
   }
}
                    

// @LINE:13
case controllers_Ideas_updateIdeaInfo5(params) => {
   call { 
        invokeHandler(_root_.controllers.Ideas.updateIdeaInfo(), HandlerDef(this, "controllers.Ideas", "updateIdeaInfo", Nil))
   }
}
                    

// @LINE:16
case controllers_Assets_at6(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                