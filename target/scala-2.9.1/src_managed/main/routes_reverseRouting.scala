// @SOURCE:/Users/jorgesaldivar/workspace/Agora 2.0/conf/routes
// @HASH:5b2234d84268c094b43b749d078697c4b5bea99f
// @DATE:Sun Jun 17 16:44:02 CEST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:32
// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseIdeas {
    


 
// @LINE:12
def change() = {
   Call("GET", "/ideas/change")
}
                                                        
 
// @LINE:13
def show() = {
   Call("GET", "/ideas/show")
}
                                                        
 
// @LINE:11
def voteDown() = {
   Call("POST", "/ideas/voteDown")
}
                                                        
 
// @LINE:9
def index() = {
   Call("GET", "/ideas")
}
                                                        
 
// @LINE:10
def voteUp() = {
   Call("POST", "/ideas/voteUp")
}
                                                        

                      
    
}
                            

// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
class ReverseExtraInfos {
    


 
// @LINE:26
def update(id:Integer) = {
   Call("POST", "/extrainfo/" + implicitly[PathBindable[Integer]].unbind("id", id))
}
                                                        
 
// @LINE:25
def edit(id:Integer) = {
   Call("GET", "/extrainfo/" + implicitly[PathBindable[Integer]].unbind("id", id))
}
                                                        
 
// @LINE:29
def delete(id:Integer) = {
   Call("POST", "/extrainfo/" + implicitly[PathBindable[Integer]].unbind("id", id) + "/delete")
}
                                                        
 
// @LINE:21
def create() = {
   Call("GET", "/extrainfo/new")
}
                                                        
 
// @LINE:18
def list(p:Int = 0, s:String = "title", o:String = "asc", f:String = "") = {
   Call("GET", "/extrainfo" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(s == "title") None else Some(implicitly[QueryStringBindable[String]].unbind("s", s)), if(o == "asc") None else Some(implicitly[QueryStringBindable[String]].unbind("o", o)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)))))
}
                                                        
 
// @LINE:22
def save() = {
   Call("POST", "/extrainfo/save")
}
                                                        

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        

                      
    
}
                            

// @LINE:32
class ReverseAssets {
    


 
// @LINE:32
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            
}
                    


// @LINE:32
// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseIdeas {
    


 
// @LINE:12
def change = JavascriptReverseRoute(
   "controllers.Ideas.change",
   """
      function() {
      return _wA({method:"GET", url:"/ideas/change"})
      }
   """
)
                                                        
 
// @LINE:13
def show = JavascriptReverseRoute(
   "controllers.Ideas.show",
   """
      function() {
      return _wA({method:"GET", url:"/ideas/show"})
      }
   """
)
                                                        
 
// @LINE:11
def voteDown = JavascriptReverseRoute(
   "controllers.Ideas.voteDown",
   """
      function() {
      return _wA({method:"POST", url:"/ideas/voteDown"})
      }
   """
)
                                                        
 
// @LINE:9
def index = JavascriptReverseRoute(
   "controllers.Ideas.index",
   """
      function() {
      return _wA({method:"GET", url:"/ideas"})
      }
   """
)
                                                        
 
// @LINE:10
def voteUp = JavascriptReverseRoute(
   "controllers.Ideas.voteUp",
   """
      function() {
      return _wA({method:"POST", url:"/ideas/voteUp"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
class ReverseExtraInfos {
    


 
// @LINE:26
def update = JavascriptReverseRoute(
   "controllers.ExtraInfos.update",
   """
      function(id) {
      return _wA({method:"POST", url:"/extrainfo/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:25
def edit = JavascriptReverseRoute(
   "controllers.ExtraInfos.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"/extrainfo/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:29
def delete = JavascriptReverseRoute(
   "controllers.ExtraInfos.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"/extrainfo/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:21
def create = JavascriptReverseRoute(
   "controllers.ExtraInfos.create",
   """
      function() {
      return _wA({method:"GET", url:"/extrainfo/new"})
      }
   """
)
                                                        
 
// @LINE:18
def list = JavascriptReverseRoute(
   "controllers.ExtraInfos.list",
   """
      function(p,s,o,f) {
      return _wA({method:"GET", url:"/extrainfo" + _qS([(p == """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (s == """ +  implicitly[JavascriptLitteral[String]].to("title") + """ ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("s", s)), (o == """ +  implicitly[JavascriptLitteral[String]].to("asc") + """ ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("o", o)), (f == """ +  implicitly[JavascriptLitteral[String]].to("") + """ ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f))])})
      }
   """
)
                                                        
 
// @LINE:22
def save = JavascriptReverseRoute(
   "controllers.ExtraInfos.save",
   """
      function() {
      return _wA({method:"POST", url:"/extrainfo/save"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:32
class ReverseAssets {
    


 
// @LINE:32
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:32
// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseIdeas {
    


 
// @LINE:12
def change() = new play.api.mvc.HandlerRef(
   controllers.Ideas.change(), HandlerDef(this, "controllers.Ideas", "change", Seq())
)
                              
 
// @LINE:13
def show() = new play.api.mvc.HandlerRef(
   controllers.Ideas.show(), HandlerDef(this, "controllers.Ideas", "show", Seq())
)
                              
 
// @LINE:11
def voteDown() = new play.api.mvc.HandlerRef(
   controllers.Ideas.voteDown(), HandlerDef(this, "controllers.Ideas", "voteDown", Seq())
)
                              
 
// @LINE:9
def index() = new play.api.mvc.HandlerRef(
   controllers.Ideas.index(), HandlerDef(this, "controllers.Ideas", "index", Seq())
)
                              
 
// @LINE:10
def voteUp() = new play.api.mvc.HandlerRef(
   controllers.Ideas.voteUp(), HandlerDef(this, "controllers.Ideas", "voteUp", Seq())
)
                              

                      
    
}
                            

// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:18
class ReverseExtraInfos {
    


 
// @LINE:26
def update(id:Integer) = new play.api.mvc.HandlerRef(
   controllers.ExtraInfos.update(id), HandlerDef(this, "controllers.ExtraInfos", "update", Seq(classOf[Integer]))
)
                              
 
// @LINE:25
def edit(id:Integer) = new play.api.mvc.HandlerRef(
   controllers.ExtraInfos.edit(id), HandlerDef(this, "controllers.ExtraInfos", "edit", Seq(classOf[Integer]))
)
                              
 
// @LINE:29
def delete(id:Integer) = new play.api.mvc.HandlerRef(
   controllers.ExtraInfos.delete(id), HandlerDef(this, "controllers.ExtraInfos", "delete", Seq(classOf[Integer]))
)
                              
 
// @LINE:21
def create() = new play.api.mvc.HandlerRef(
   controllers.ExtraInfos.create(), HandlerDef(this, "controllers.ExtraInfos", "create", Seq())
)
                              
 
// @LINE:18
def list(p:Int, s:String, o:String, f:String) = new play.api.mvc.HandlerRef(
   controllers.ExtraInfos.list(p, s, o, f), HandlerDef(this, "controllers.ExtraInfos", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String]))
)
                              
 
// @LINE:22
def save() = new play.api.mvc.HandlerRef(
   controllers.ExtraInfos.save(), HandlerDef(this, "controllers.ExtraInfos", "save", Seq())
)
                              

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:32
class ReverseAssets {
    


 
// @LINE:32
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                