
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
object idea extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template6[String,String,String,Integer,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(ideaTitle: String, ideaText: String, ideaCreator: String, ideaVotes: Integer, eiTitle: String, eiContent: String):play.api.templates.Html = {
        _display_ {

Seq(format.raw/*1.116*/("""

"""),_display_(Seq(/*3.2*/main(title = "Agora 2.0")/*3.27*/ {_display_(Seq(format.raw/*3.29*/("""
	<div id = "ideaContainer" class="container-fluid">
		<div class="row-fluid">
  			<div class="span8">
  				<div class="hero-unit">
					<br>	
					<h2 align="center"> <i>	La domanda di questo momento: </i></h2>
					<div id="ideaTitle"><h1 align="center">"""),_display_(Seq(/*10.46*/ideaTitle)),format.raw/*10.55*/("""</h1></div> 
                    <br />
					<div id="ideaText"><h2 align="center">"""),_display_(Seq(/*12.45*/ideaText)),format.raw/*12.53*/("""</h2></div>
					<!--<div class="span10"><p align="right"><span class="label label-inverse">Proposed by """),_display_(Seq(/*13.94*/ideaCreator)),format.raw/*13.105*/("""</span></p></div>-->
					<br /> <br />
                    <h3 align="center"> Contribuisci anche tu alla discussione di oggi!</h3>
                    <p align="center"><b> E' facile e semplice <br /> Basta schiacciare il pulsante qui lato</b></p>
                    <br /> <br />
					<p align="center">
							<button id="buttonVoteUp" class="btn btn-success btn-large"><i class="icon-white icon-thumbs-up"></i> Tasto Verde Si</button>
							<button id="buttonVoteDown" class="btn btn-danger btn-large"><i class="icon-white icon-thumbs-down"></i> Tasto Rosso No</button>
							<button id="buttonChange" class="btn btn-warning btn-large"><i class="icon-white icon-refresh"></i> Change</button>
					</p>
  				</div>
				<div class="hero-unit">
					<div class="row-fluid">
  						<div class="span9"><h4 align="left"> """),_display_(Seq(/*26.47*/ideaVotes)),format.raw/*26.56*/(""" persone hanno votato, vota anche tu e scopri i risultati in temo reale! </h4></div>	
					</div>
  				</div>
                <div class="hero-unit">
					<div class="row-fluid">
  						<div class="span9"><h4 align="left"> Disclaimer: </h4></div>  						
					</div>
  				</div>
  			</div>
  			<div class="span4">
    			<div class="hero-unit">
					<div id = "extraInfoTitle"><h3 align="center">"""),_display_(Seq(/*37.53*/eiTitle)),format.raw/*37.60*/("""</h3></div>
					<div id = "extraInfoContent"><p>"""),_display_(Seq(/*38.39*/eiContent)),format.raw/*38.48*/("""</p></div>
    			</div>
  			</div>
            <div class="span4">	
				<img src=""""),_display_(Seq(/*42.16*/routes/*42.22*/.Assets.at("images/festival-economia.jpg"))),format.raw/*42.64*/("""" width="340" height="346" class="floatLeft" />
    		</div>
  		</div>
	</div>
""")))})))}
    }
    
    def render(ideaTitle:String,ideaText:String,ideaCreator:String,ideaVotes:Integer,eiTitle:String,eiContent:String) = apply(ideaTitle,ideaText,ideaCreator,ideaVotes,eiTitle,eiContent)
    
    def f:((String,String,String,Integer,String,String) => play.api.templates.Html) = (ideaTitle,ideaText,ideaCreator,ideaVotes,eiTitle,eiContent) => apply(ideaTitle,ideaText,ideaCreator,ideaVotes,eiTitle,eiContent)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 19 17:31:27 CEST 2012
                    SOURCE: /Users/jorgesaldivar/workspace/Agora 2.0/app/views/idea.scala.html
                    HASH: 3a2f9cc09e81082fbafd7bac8178e9d0b7f2ee39
                    MATRIX: 790->1|977->115|1009->118|1042->143|1076->145|1373->411|1404->420|1521->506|1551->514|1688->620|1722->631|2592->1470|2623->1479|3065->1890|3094->1897|3175->1947|3206->1956|3324->2043|3339->2049|3403->2091
                    LINES: 27->1|30->1|32->3|32->3|32->3|39->10|39->10|41->12|41->12|42->13|42->13|55->26|55->26|66->37|66->37|67->38|67->38|71->42|71->42|71->42
                    -- GENERATED --
                */
            