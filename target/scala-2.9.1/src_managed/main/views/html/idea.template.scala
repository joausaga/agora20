
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
object idea extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,String,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(ideaTitle: String, ideaText: String, ideaCreator: String, ideaVotes: String):play.api.templates.Html = {
        _display_ {

Seq(format.raw/*1.79*/("""

"""),_display_(Seq(/*3.2*/main(title = "Agora 2.0")/*3.27*/ {_display_(Seq(format.raw/*3.29*/("""
	<div class="container-fluid">
		<div class="row-fluid">
  			<div class="span8">
  				<div class="hero-unit">
  					<div class="row-fluid">
  						<div class="span2"><div class="label label-info"><h4 align="center">Score </h4><h3 align="center">"""),_display_(Seq(/*9.108*/ideaVotes)),format.raw/*9.117*/("""</h3></div></div>
  						<div class="span10"><p align="right"><span class="label label-inverse">Proposed by """),_display_(Seq(/*10.93*/ideaCreator)),format.raw/*10.104*/("""</span></p></div>
					</div>
					<br>	
					<h1>"""),_display_(Seq(/*13.11*/ideaTitle)),format.raw/*13.20*/("""</h1>
					<p>"""),_display_(Seq(/*14.10*/ideaText)),format.raw/*14.18*/("""</p>
					<p align="center">
							<button id="buttonVoteUp" class="btn btn-success btn-large"><i class="icon-white icon-thumbs-up"></i> Agree</button>
							<button id="buttonVoteDown" class="btn btn-danger btn-large"><i class="icon-white icon-thumbs-down"></i> Disagree</button>
							<button id="buttonChange" class="btn btn-warning btn-large"><i class="icon-white icon-refresh"></i> Change</button>
					</p>
  				</div>
  			</div>
  			<div class="span4">
    			<div class="hero-unit">
					<h2>Extra Info</h2>
					<p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
    			</div>
  			</div>
  		</div>
	</div>
""")))})))}
    }
    
    def render(ideaTitle:String,ideaText:String,ideaCreator:String,ideaVotes:String) = apply(ideaTitle,ideaText,ideaCreator,ideaVotes)
    
    def f:((String,String,String,String) => play.api.templates.Html) = (ideaTitle,ideaText,ideaCreator,ideaVotes) => apply(ideaTitle,ideaText,ideaCreator,ideaVotes)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun May 27 23:58:25 CEST 2012
                    SOURCE: /Users/jorgesaldivar/agora2.0/app/views/idea.scala.html
                    HASH: 02f372b5eea1748d07720fffd82b4ac1a698d701
                    MATRIX: 775->1|924->78|956->81|989->106|1023->108|1305->359|1336->368|1477->478|1511->489|1593->540|1624->549|1670->564|1700->572
                    LINES: 27->1|30->1|32->3|32->3|32->3|38->9|38->9|39->10|39->10|42->13|42->13|43->14|43->14
                    -- GENERATED --
                */
            