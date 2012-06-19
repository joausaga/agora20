
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq(format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="description" content="Project Agora 2.0">
    	<meta name="author" content="Group 1">
        <title>"""),_display_(Seq(/*11.17*/title)),format.raw/*11.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*12.54*/routes/*12.60*/.Assets.at("bootstrap/css/bootstrap.min.css"))),format.raw/*12.105*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*13.48*/routes/*13.54*/.Assets.at("stylesheets/main.css"))),format.raw/*13.88*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*14.48*/routes/*14.54*/.Assets.at("stylesheets/interface.css"))),format.raw/*14.93*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq(/*15.59*/routes/*15.65*/.Assets.at("images/favicon.png"))),format.raw/*15.97*/("""">
        <style type="text/css">
      		body """),format.raw("""{"""),format.raw/*17.15*/("""
        		padding-top: 60px;
        		padding-bottom: 40px;
      		"""),format.raw("""}"""),format.raw/*20.10*/("""
    	</style>
    	<link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*22.51*/routes/*22.57*/.Assets.at("bootstrap/css/bootstrap-responsive.min.css"))),format.raw/*22.113*/("""">
        <script src=""""),_display_(Seq(/*23.23*/routes/*23.29*/.Assets.at("bootstrap/js/bootstrap.min.js"))),format.raw/*23.72*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq(/*24.23*/routes/*24.29*/.Assets.at("bootstrap/js/bootstrap-alert.js"))),format.raw/*24.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq(/*25.23*/routes/*25.29*/.Assets.at("bootstrap/js/bootstrap-modal.js"))),format.raw/*25.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq(/*26.23*/routes/*26.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*26.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq(/*27.23*/routes/*27.29*/.Assets.at("javascripts/agora20.js"))),format.raw/*27.65*/("""" type="text/javascript"></script>
    </head>
    <body>
    	<div class="modal hide" id="modalWindow">
  			<div class="modal-header label label-success">
    			<button type="button" class="close" data-dismiss="modal">×</button>
    			<h2>Agora 2.0</h2>
  			</div>
  			<div id="modalMessage" class="modal-body"></div>
  			<div class="modal-footer"></div>
  		</div>
  		<div class="headerSection"> 
			<img src=""""),_display_(Seq(/*39.15*/routes/*39.21*/.Assets.at("images/LOGOunitn.gif"))),format.raw/*39.55*/("""" width="140" height="146" class="floatLeft" />
			<img src=""""),_display_(Seq(/*40.15*/routes/*40.21*/.Assets.at("images/URP_medium.jpg"))),format.raw/*40.56*/("""" width="150" height="179" class="floatRight" />
			<div class="brand"> 
				<div class="brandTitle">  Agora 2.0 </div>
				<h3>Uno strumento per la partecipazione civia </h3>
			</div>
		</div>
	<div class="headerdivider"></div>
  		
    	<div id="alert-area"></div>
    	<div>
    		"""),_display_(Seq(/*50.8*/content)),format.raw/*50.15*/("""
    		<footer>
        		<h6 align="center">Powered by IdeaScale /---/ University of Trento</h6>
      		</footer>
    	</div>
    	
	<!-- 
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src=""""),_display_(Seq(/*59.19*/routes/*59.25*/.Assets.at("bootstrap/js/jquery.js"))),format.raw/*59.61*/(""""></script>
    <script src=""""),_display_(Seq(/*60.19*/routes/*60.25*/.Assets.at("bootstrap/js/bootstrap-transition.js"))),format.raw/*60.75*/(""""></script>
    <script src=""""),_display_(Seq(/*61.19*/routes/*61.25*/.Assets.at("bootstrap/js/bootstrap-alert.js"))),format.raw/*61.70*/(""""></script>
    <script src=""""),_display_(Seq(/*62.19*/routes/*62.25*/.Assets.at("bootstrap/js/bootstrap-modal.js"))),format.raw/*62.70*/(""""></script>
    <script src=""""),_display_(Seq(/*63.19*/routes/*63.25*/.Assets.at("bootstrap/js/bootstrap-dropdown.js"))),format.raw/*63.73*/(""""></script>
    <script src=""""),_display_(Seq(/*64.19*/routes/*64.25*/.Assets.at("bootstrap/js/bootstrap-scrollspy.js"))),format.raw/*64.74*/(""""></script>
    <script src=""""),_display_(Seq(/*65.19*/routes/*65.25*/.Assets.at("bootstrap/js/bootstrap-tab.js"))),format.raw/*65.68*/(""""></script>
    <script src=""""),_display_(Seq(/*66.19*/routes/*66.25*/.Assets.at("bootstrap/js/bootstrap-tooltip.js"))),format.raw/*66.72*/(""""></script>
    <script src=""""),_display_(Seq(/*67.19*/routes/*67.25*/.Assets.at("bootstrap/js/bootstrap-popover.js"))),format.raw/*67.72*/(""""></script>
    <script src=""""),_display_(Seq(/*68.19*/routes/*68.25*/.Assets.at("bootstrap/js/bootstrap-button.js"))),format.raw/*68.71*/(""""></script>
    <script src=""""),_display_(Seq(/*69.19*/routes/*69.25*/.Assets.at("bootstrap/js/bootstrap-collapse.js"))),format.raw/*69.73*/(""""></script>
    <script src=""""),_display_(Seq(/*70.19*/routes/*70.25*/.Assets.at("bootstrap/js/bootstrap-carousel.js"))),format.raw/*70.73*/(""""></script>
    <script src=""""),_display_(Seq(/*71.19*/routes/*71.25*/.Assets.at("bootstrap/js/bootstrap-typeahead.js"))),format.raw/*71.74*/(""""></script>
	        
    </body>
</html>"""))}
    }
    
    def render(title:String,content:Html) = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 19 17:46:25 CEST 2012
                    SOURCE: /Users/jorgesaldivar/workspace/Agora 2.0/app/views/main.scala.html
                    HASH: 8c481f857b2d7bcc68bc74f2a50a1ad52904ee88
                    MATRIX: 759->1|861->31|1152->291|1179->296|1272->358|1287->364|1355->409|1436->459|1451->465|1507->499|1588->549|1603->555|1664->594|1756->655|1771->661|1825->693|1921->742|2039->813|2135->878|2150->884|2229->940|2285->965|2300->971|2365->1014|2453->1071|2468->1077|2535->1122|2623->1179|2638->1185|2705->1230|2793->1287|2808->1293|2875->1338|2963->1395|2978->1401|3036->1437|3487->1857|3502->1863|3558->1897|3651->1959|3666->1965|3723->2000|4039->2286|4068->2293|4389->2583|4404->2589|4462->2625|4523->2655|4538->2661|4610->2711|4671->2741|4686->2747|4753->2792|4814->2822|4829->2828|4896->2873|4957->2903|4972->2909|5042->2957|5103->2987|5118->2993|5189->3042|5250->3072|5265->3078|5330->3121|5391->3151|5406->3157|5475->3204|5536->3234|5551->3240|5620->3287|5681->3317|5696->3323|5764->3369|5825->3399|5840->3405|5910->3453|5971->3483|5986->3489|6056->3537|6117->3567|6132->3573|6203->3622
                    LINES: 27->1|30->1|40->11|40->11|41->12|41->12|41->12|42->13|42->13|42->13|43->14|43->14|43->14|44->15|44->15|44->15|46->17|49->20|51->22|51->22|51->22|52->23|52->23|52->23|53->24|53->24|53->24|54->25|54->25|54->25|55->26|55->26|55->26|56->27|56->27|56->27|68->39|68->39|68->39|69->40|69->40|69->40|79->50|79->50|88->59|88->59|88->59|89->60|89->60|89->60|90->61|90->61|90->61|91->62|91->62|91->62|92->63|92->63|92->63|93->64|93->64|93->64|94->65|94->65|94->65|95->66|95->66|95->66|96->67|96->67|96->67|97->68|97->68|97->68|98->69|98->69|98->69|99->70|99->70|99->70|100->71|100->71|100->71
                    -- GENERATED --
                */
            