
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object modal extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq(format.raw/*1.1*/("""<!DOCTYPE html> 
<html> 
<head> 
<meta charset="utf-8"> 
<title>Twitter Bootstrap Modals Example</title> 
<meta name="description" content="Creating Modal Window with Twitter Bootstrap">
<link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*7.46*/routes/*7.52*/.Assets.at("bootstrap/css/bootstrap.min.css"))),format.raw/*7.97*/(""""> 
</head>
<body>
<div class="container">
<h2>Example of creating Modals with Twitter Bootstrap</h2>
<div id="example" class="modal hide fade in" style="display: none; ">
<div class="modal-header">
<a class="close" data-dismiss="modal">×</a>
<h3>This is a Modal Heading</h3>
</div>
<div class="modal-body">
<h4>Text in a modal</h4>
<p>You can add some text here.</p>		        
</div>
<div class="modal-footer">
<a href="#" class="btn btn-success">Call to action</a>
<a href="#" class="btn" data-dismiss="modal">Close</a>
</div>
</div>
<p><a data-toggle="modal" href="#example" class="btn btn-primary btn-large">Launch demo modal</a></p>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src=""""),_display_(Seq(/*28.15*/routes/*28.21*/.Assets.at("bootstrap/js/bootstrap-modal.js"))),format.raw/*28.66*/("""" type="text/javascript"></script>
</body>
</html>
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat May 26 19:17:43 CEST 2012
                    SOURCE: /Users/jorgesaldivar/agora2.0/app/views/modal.scala.html
                    HASH: 451820a83cb1162fe87321fa45f67e98bfbd91ad
                    MATRIX: 814->0|1076->232|1090->238|1156->283|1928->1024|1943->1030|2010->1075
                    LINES: 30->1|36->7|36->7|36->7|57->28|57->28|57->28
                    -- GENERATED --
                */
            