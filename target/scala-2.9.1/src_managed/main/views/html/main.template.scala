
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
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq(/*13.59*/routes/*13.65*/.Assets.at("images/favicon.png"))),format.raw/*13.97*/("""">
        <style type="text/css">
      		body """),format.raw("""{"""),format.raw/*15.15*/("""
        		padding-top: 60px;
        		padding-bottom: 40px;
      		"""),format.raw("""}"""),format.raw/*18.10*/("""
    	</style>
    	<link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*20.51*/routes/*20.57*/.Assets.at("bootstrap/css/bootstrap-responsive.min.css"))),format.raw/*20.113*/("""">
        <script src=""""),_display_(Seq(/*21.23*/routes/*21.29*/.Assets.at("bootstrap/js/bootstrap.min.js"))),format.raw/*21.72*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq(/*22.23*/routes/*22.29*/.Assets.at("bootstrap/js/bootstrap-alert.js"))),format.raw/*22.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq(/*23.23*/routes/*23.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*23.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq(/*24.23*/routes/*24.29*/.Assets.at("javascripts/agora20.js"))),format.raw/*24.65*/("""" type="text/javascript"></script>
    </head>
    <body>
    	<div id="alert-area"></div>
    	<div class="navbar navbar-fixed-top">
      		<div class="navbar-inner">
        		<div class="container">
          			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            			<span class="icon-bar"></span>
            			<span class="icon-bar"></span>
            			<span class="icon-bar"></span>
          			</a>
          			<a class="brand" href="#">Agora 2.0</a>
        			</div>
      			</div>
    	</div>
    	<div id="ideaContainer">
    		"""),_display_(Seq(/*41.8*/content)),format.raw/*41.15*/("""
    		<footer>
        		<h6 align="center">Powered by IdeaScale /---/ University of Trento</h6>
      		</footer>
    	</div>
    	
	<!-- 
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src=""""),_display_(Seq(/*50.19*/routes/*50.25*/.Assets.at("bootstrap/js/jquery.js"))),format.raw/*50.61*/(""""></script>
    <script src=""""),_display_(Seq(/*51.19*/routes/*51.25*/.Assets.at("bootstrap/js/bootstrap-transition.js"))),format.raw/*51.75*/(""""></script>
    <script src=""""),_display_(Seq(/*52.19*/routes/*52.25*/.Assets.at("bootstrap/js/bootstrap-alert.js"))),format.raw/*52.70*/(""""></script>
    <script src=""""),_display_(Seq(/*53.19*/routes/*53.25*/.Assets.at("bootstrap/js/bootstrap-modal.js"))),format.raw/*53.70*/(""""></script>
    <script src=""""),_display_(Seq(/*54.19*/routes/*54.25*/.Assets.at("bootstrap/js/bootstrap-dropdown.js"))),format.raw/*54.73*/(""""></script>
    <script src=""""),_display_(Seq(/*55.19*/routes/*55.25*/.Assets.at("bootstrap/js/bootstrap-scrollspy.js"))),format.raw/*55.74*/(""""></script>
    <script src=""""),_display_(Seq(/*56.19*/routes/*56.25*/.Assets.at("bootstrap/js/bootstrap-tab.js"))),format.raw/*56.68*/(""""></script>
    <script src=""""),_display_(Seq(/*57.19*/routes/*57.25*/.Assets.at("bootstrap/js/bootstrap-tooltip.js"))),format.raw/*57.72*/(""""></script>
    <script src=""""),_display_(Seq(/*58.19*/routes/*58.25*/.Assets.at("bootstrap/js/bootstrap-popover.js"))),format.raw/*58.72*/(""""></script>
    <script src=""""),_display_(Seq(/*59.19*/routes/*59.25*/.Assets.at("bootstrap/js/bootstrap-button.js"))),format.raw/*59.71*/(""""></script>
    <script src=""""),_display_(Seq(/*60.19*/routes/*60.25*/.Assets.at("bootstrap/js/bootstrap-collapse.js"))),format.raw/*60.73*/(""""></script>
    <script src=""""),_display_(Seq(/*61.19*/routes/*61.25*/.Assets.at("bootstrap/js/bootstrap-carousel.js"))),format.raw/*61.73*/(""""></script>
    <script src=""""),_display_(Seq(/*62.19*/routes/*62.25*/.Assets.at("bootstrap/js/bootstrap-typeahead.js"))),format.raw/*62.74*/(""""></script>
	
        
    </body>
</html>"""))}
    }
    
    def render(title:String,content:Html) = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun May 27 23:23:17 CEST 2012
                    SOURCE: /Users/jorgesaldivar/agora2.0/app/views/main.scala.html
                    HASH: cb9d7195cd79d7c85218109b12397f8798838430
                    MATRIX: 759->1|861->31|1152->291|1179->296|1272->358|1287->364|1355->409|1447->470|1462->476|1516->508|1612->557|1730->628|1826->693|1841->699|1920->755|1976->780|1991->786|2056->829|2144->886|2159->892|2226->937|2314->994|2329->1000|2396->1045|2484->1102|2499->1108|2557->1144|3173->1730|3202->1737|3523->2027|3538->2033|3596->2069|3657->2099|3672->2105|3744->2155|3805->2185|3820->2191|3887->2236|3948->2266|3963->2272|4030->2317|4091->2347|4106->2353|4176->2401|4237->2431|4252->2437|4323->2486|4384->2516|4399->2522|4464->2565|4525->2595|4540->2601|4609->2648|4670->2678|4685->2684|4754->2731|4815->2761|4830->2767|4898->2813|4959->2843|4974->2849|5044->2897|5105->2927|5120->2933|5190->2981|5251->3011|5266->3017|5337->3066
                    LINES: 27->1|30->1|40->11|40->11|41->12|41->12|41->12|42->13|42->13|42->13|44->15|47->18|49->20|49->20|49->20|50->21|50->21|50->21|51->22|51->22|51->22|52->23|52->23|52->23|53->24|53->24|53->24|70->41|70->41|79->50|79->50|79->50|80->51|80->51|80->51|81->52|81->52|81->52|82->53|82->53|82->53|83->54|83->54|83->54|84->55|84->55|84->55|85->56|85->56|85->56|86->57|86->57|86->57|87->58|87->58|87->58|88->59|88->59|88->59|89->60|89->60|89->60|90->61|90->61|90->61|91->62|91->62|91->62
                    -- GENERATED --
                */
            