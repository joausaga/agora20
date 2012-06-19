// @SOURCE:/Users/jorgesaldivar/workspace/Agora 2.0/conf/routes
// @HASH:5b2234d84268c094b43b749d078697c4b5bea99f
// @DATE:Sun Jun 17 16:44:02 CEST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:9
val controllers_Ideas_index1 = Route("GET", PathPattern(List(StaticPart("/ideas"))))
                    

// @LINE:10
val controllers_Ideas_voteUp2 = Route("POST", PathPattern(List(StaticPart("/ideas/voteUp"))))
                    

// @LINE:11
val controllers_Ideas_voteDown3 = Route("POST", PathPattern(List(StaticPart("/ideas/voteDown"))))
                    

// @LINE:12
val controllers_Ideas_change4 = Route("GET", PathPattern(List(StaticPart("/ideas/change"))))
                    

// @LINE:13
val controllers_Ideas_show5 = Route("GET", PathPattern(List(StaticPart("/ideas/show"))))
                    

// @LINE:18
val controllers_ExtraInfos_list6 = Route("GET", PathPattern(List(StaticPart("/extrainfo"))))
                    

// @LINE:21
val controllers_ExtraInfos_create7 = Route("GET", PathPattern(List(StaticPart("/extrainfo/new"))))
                    

// @LINE:22
val controllers_ExtraInfos_save8 = Route("POST", PathPattern(List(StaticPart("/extrainfo/save"))))
                    

// @LINE:25
val controllers_ExtraInfos_edit9 = Route("GET", PathPattern(List(StaticPart("/extrainfo/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:26
val controllers_ExtraInfos_update10 = Route("POST", PathPattern(List(StaticPart("/extrainfo/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:29
val controllers_ExtraInfos_delete11 = Route("POST", PathPattern(List(StaticPart("/extrainfo/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:32
val controllers_Assets_at12 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index()"""),("""GET""","""/ideas""","""controllers.Ideas.index()"""),("""POST""","""/ideas/voteUp""","""controllers.Ideas.voteUp()"""),("""POST""","""/ideas/voteDown""","""controllers.Ideas.voteDown()"""),("""GET""","""/ideas/change""","""controllers.Ideas.change()"""),("""GET""","""/ideas/show""","""controllers.Ideas.show()"""),("""GET""","""/extrainfo""","""controllers.ExtraInfos.list(p:Int ?= 0, s:String ?= "title", o:String ?= "asc", f:String ?= "")"""),("""GET""","""/extrainfo/new""","""controllers.ExtraInfos.create()"""),("""POST""","""/extrainfo/save""","""controllers.ExtraInfos.save()"""),("""GET""","""/extrainfo/$id<[^/]+>""","""controllers.ExtraInfos.edit(id:Integer)"""),("""POST""","""/extrainfo/$id<[^/]+>""","""controllers.ExtraInfos.update(id:Integer)"""),("""POST""","""/extrainfo/$id<[^/]+>/delete""","""controllers.ExtraInfos.delete(id:Integer)"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil))
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
case controllers_Ideas_show5(params) => {
   call { 
        invokeHandler(_root_.controllers.Ideas.show(), HandlerDef(this, "controllers.Ideas", "show", Nil))
   }
}
                    

// @LINE:18
case controllers_ExtraInfos_list6(params) => {
   call(params.fromQuery[Int]("p", Some(0)), params.fromQuery[String]("s", Some("title")), params.fromQuery[String]("o", Some("asc")), params.fromQuery[String]("f", Some(""))) { (p, s, o, f) =>
        invokeHandler(_root_.controllers.ExtraInfos.list(p, s, o, f), HandlerDef(this, "controllers.ExtraInfos", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:21
case controllers_ExtraInfos_create7(params) => {
   call { 
        invokeHandler(_root_.controllers.ExtraInfos.create(), HandlerDef(this, "controllers.ExtraInfos", "create", Nil))
   }
}
                    

// @LINE:22
case controllers_ExtraInfos_save8(params) => {
   call { 
        invokeHandler(_root_.controllers.ExtraInfos.save(), HandlerDef(this, "controllers.ExtraInfos", "save", Nil))
   }
}
                    

// @LINE:25
case controllers_ExtraInfos_edit9(params) => {
   call(params.fromPath[Integer]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.ExtraInfos.edit(id), HandlerDef(this, "controllers.ExtraInfos", "edit", Seq(classOf[Integer])))
   }
}
                    

// @LINE:26
case controllers_ExtraInfos_update10(params) => {
   call(params.fromPath[Integer]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.ExtraInfos.update(id), HandlerDef(this, "controllers.ExtraInfos", "update", Seq(classOf[Integer])))
   }
}
                    

// @LINE:29
case controllers_ExtraInfos_delete11(params) => {
   call(params.fromPath[Integer]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.ExtraInfos.delete(id), HandlerDef(this, "controllers.ExtraInfos", "delete", Seq(classOf[Integer])))
   }
}
                    

// @LINE:32
case controllers_Assets_at12(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                