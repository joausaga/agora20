
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Integer,Form[ExtraInfo],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Integer, extraInfoForm: Form[ExtraInfo]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq(format.raw/*1.47*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq(/*7.2*/main(title = "Agora 2.0 - Edit Extra Information")/*7.52*/ {_display_(Seq(format.raw/*7.54*/("""
    
    """),_display_(Seq(/*9.6*/form(routes.ExtraInfos.update(id))/*9.40*/ {_display_(Seq(format.raw/*9.42*/("""
        <div class="container">
        <div class="hero-unit">
        
        <fieldset>
            <h2>Edit Extra Information</h2>
            
            """),_display_(Seq(/*16.14*/inputText(
                extraInfoForm("title"), 
                '_label -> "Title", 
                '_help -> "Insert the title for the extra information.",
                '_error -> extraInfoForm.globalError
            ))),format.raw/*21.14*/("""
            
            """),_display_(Seq(/*23.14*/textarea(
                extraInfoForm("content"), 
                '_label -> "Text", 
                '_help -> "Insert the text for the extra information.",
                '_error -> extraInfoForm.globalError
            ))),format.raw/*28.14*/("""
            
            """),_display_(Seq(/*30.14*/select(
                extraInfoForm("idea.id"), 
                options = options(Idea.options),
                '_default -> "--- Choose an Idea ---",
                '_label -> "Idea",
                '_error -> extraInfoForm("idea.id").error.map(_.withMessage("Please select an idea"))
            ))),format.raw/*36.14*/("""
            

        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Save" class="btn btn-primary">
            <a href=""""),_display_(Seq(/*43.23*/routes/*43.29*/.ExtraInfos.list())),format.raw/*43.47*/("""" class="btn">Cancel</a>
            <a href=""""),_display_(Seq(/*44.23*/routes/*44.29*/.ExtraInfos.delete(id))),format.raw/*44.51*/("""" class="btn btn-danger">Delete</a>
        </div>
        
        </div>
        
        </div>
        
    """)))})),format.raw/*51.6*/("""
    
""")))})),format.raw/*53.2*/("""
"""))}
    }
    
    def render(id:Integer,extraInfoForm:Form[ExtraInfo]) = apply(id,extraInfoForm)
    
    def f:((Integer,Form[ExtraInfo]) => play.api.templates.Html) = (id,extraInfoForm) => apply(id,extraInfoForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Jun 17 17:30:14 CEST 2012
                    SOURCE: /Users/jorgesaldivar/workspace/Agora 2.0/app/views/editForm.scala.html
                    HASH: 26e0840942fe7e06c268f894de5a536d30d344aa
                    MATRIX: 775->1|905->67|937->91|1016->46|1044->65|1072->145|1105->149|1163->199|1197->201|1237->212|1279->246|1313->248|1507->411|1757->639|1815->666|2064->893|2122->920|2449->1225|2647->1392|2662->1398|2702->1416|2780->1463|2795->1469|2839->1491|2983->1604|3021->1611
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|38->9|38->9|38->9|45->16|50->21|52->23|57->28|59->30|65->36|72->43|72->43|72->43|73->44|73->44|73->44|80->51|82->53
                    -- GENERATED --
                */
            