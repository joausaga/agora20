// @SOURCE:/Users/jorgesaldivar/agora2.0/conf/routes
// @HASH:2275c700f478659366c2ec7dfb5808911ff3d130
// @DATE:Sun May 27 19:54:18 CEST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:16
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
// @LINE:6
class ReverseIdeas {
    


 
// @LINE:12
def change() = {
   Call("GET", "/ideas/change")
}
                                                        
 
// @LINE:11
def voteDown() = {
   Call("POST", "/ideas/voteDown")
}
                                                        
 
// @LINE:13
def updateIdeaInfo() = {
   Call("GET", "/ideas/update")
}
                                                        
 
// @LINE:9
// @LINE:6
def index() = {
   () match {
// @LINE:6
case () if true => Call("GET", "/")
                                                                
// @LINE:9
case () if true => Call("GET", "/ideas")
                                                                    
   }
}
                                                        
 
// @LINE:10
def voteUp() = {
   Call("POST", "/ideas/voteUp")
}
                                                        

                      
    
}
                            

// @LINE:16
class ReverseAssets {
    


 
// @LINE:16
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            
}
                    


// @LINE:16
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
// @LINE:6
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
                                                        
 
// @LINE:11
def voteDown = JavascriptReverseRoute(
   "controllers.Ideas.voteDown",
   """
      function() {
      return _wA({method:"POST", url:"/ideas/voteDown"})
      }
   """
)
                                                        
 
// @LINE:13
def updateIdeaInfo = JavascriptReverseRoute(
   "controllers.Ideas.updateIdeaInfo",
   """
      function() {
      return _wA({method:"GET", url:"/ideas/update"})
      }
   """
)
                                                        
 
// @LINE:9
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Ideas.index",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"/"})
      }
      if (true) {
      return _wA({method:"GET", url:"/ideas"})
      }
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
                            

// @LINE:16
class ReverseAssets {
    


 
// @LINE:16
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
                    


// @LINE:16
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
// @LINE:6
class ReverseIdeas {
    


 
// @LINE:12
def change() = new play.api.mvc.HandlerRef(
   controllers.Ideas.change(), HandlerDef(this, "controllers.Ideas", "change", Seq())
)
                              
 
// @LINE:11
def voteDown() = new play.api.mvc.HandlerRef(
   controllers.Ideas.voteDown(), HandlerDef(this, "controllers.Ideas", "voteDown", Seq())
)
                              
 
// @LINE:13
def updateIdeaInfo() = new play.api.mvc.HandlerRef(
   controllers.Ideas.updateIdeaInfo(), HandlerDef(this, "controllers.Ideas", "updateIdeaInfo", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Ideas.index(), HandlerDef(this, "controllers.Ideas", "index", Seq())
)
                              
 
// @LINE:10
def voteUp() = new play.api.mvc.HandlerRef(
   controllers.Ideas.voteUp(), HandlerDef(this, "controllers.Ideas", "voteUp", Seq())
)
                              

                      
    
}
                            

// @LINE:16
class ReverseAssets {
    


 
// @LINE:16
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                