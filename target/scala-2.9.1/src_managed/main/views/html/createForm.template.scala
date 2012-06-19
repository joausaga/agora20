
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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ExtraInfo],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(extraInfoForm: Form[ExtraInfo]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq(format.raw/*1.34*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq(/*7.2*/main(title = "Agora 2.0 - Create Extra Information")/*7.54*/ {_display_(Seq(format.raw/*7.56*/("""
    
    """),_display_(Seq(/*9.6*/form(routes.ExtraInfos.save())/*9.36*/ {_display_(Seq(format.raw/*9.38*/("""
    <div class="container">
        <div class="hero-unit">
        
        <fieldset>
            <h2>Create Extra Information</h2>
        
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
            <input type="submit" value="Create" class="btn btn-primary"> 
            <a href=""""),_display_(Seq(/*43.23*/routes/*43.29*/.ExtraInfos.list())),format.raw/*43.47*/("""" class="btn">Cancel</a> 
        </div>
        
        </div>
        
        </div>
        
    """)))})),format.raw/*50.6*/("""
    
""")))})))}
    }
    
    def render(extraInfoForm:Form[ExtraInfo]) = apply(extraInfoForm)
    
    def f:((Form[ExtraInfo]) => play.api.templates.Html) = (extraInfoForm) => apply(extraInfoForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Jun 17 17:24:46 CEST 2012
                    SOURCE: /Users/jorgesaldivar/workspace/Agora 2.0/app/views/createForm.scala.html
                    HASH: 90ef28a7530efced681c4cedd818aee8687626b6
                    MATRIX: 769->1|886->54|918->78|997->33|1025->52|1053->132|1086->136|1146->188|1180->190|1220->201|1258->231|1292->233|1480->390|1730->618|1788->645|2037->872|2095->899|2422->1204|2623->1374|2638->1380|2678->1398|2812->1501
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|38->9|38->9|38->9|45->16|50->21|52->23|57->28|59->30|65->36|72->43|72->43|72->43|79->50
                    -- GENERATED --
                */
            