
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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Page[ExtraInfo],String,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[ExtraInfo], currentSortBy: String, currentOrder: String, currentFilter: String):play.api.templates.Html = {
        _display_ {
def /*32.2*/header/*32.8*/(key:String, title:String):play.api.templates.Html = {_display_(

Seq(format.raw/*32.38*/("""
    <th class=""""),_display_(Seq(/*33.17*/key/*33.20*/.replace(".","_"))),format.raw/*33.37*/(""" header """),_display_(Seq(/*33.46*/if(currentSortBy == key){/*33.72*/{if(currentOrder == "asc") "headerSortDown" else "headerSortUp"}})),format.raw/*33.136*/("""">
        <a href=""""),_display_(Seq(/*34.19*/link(0, key))),format.raw/*34.31*/("""">"""),_display_(Seq(/*34.34*/title)),format.raw/*34.39*/("""</a>
    </th>
""")))};def /*6.2*/link/*6.6*/(newPage:Int, newSortBy:String) = {{
    
    var sortBy = currentSortBy
    var order = currentOrder
    
    if(newSortBy != null) {
        sortBy = newSortBy
        if(currentSortBy == newSortBy) {
            if(currentOrder == "asc") {
                order = "desc"
            } else {
                order = "asc"
            }
        } else {
            order = "asc"
        }
    }
    
    // Generate the link
    routes.ExtraInfos.list(newPage, sortBy, order, currentFilter)
    
}};
Seq(format.raw/*1.100*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*27.2*/("""

"""),format.raw/*31.37*/("""
"""),format.raw/*36.2*/("""

"""),_display_(Seq(/*38.2*/main(title = "Agora 2.0 - Extra Information")/*38.47*/ {_display_(Seq(format.raw/*38.49*/("""
    <div class="container">
    <h1 id="homeTitle">Extra Information</h1>

    """),_display_(Seq(/*42.6*/if(flash.containsKey("success"))/*42.38*/ {_display_(Seq(format.raw/*42.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq(/*44.37*/flash/*44.42*/.get("success"))),format.raw/*44.57*/("""
        </div>
    """)))})),format.raw/*46.6*/(""" 

    <div id="actions">
        <form action=""""),_display_(Seq(/*49.24*/link(0, "name"))),format.raw/*49.39*/("""" method="GET">
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq(/*50.66*/currentFilter)),format.raw/*50.79*/("""" placeholder="Search by title...">
            <input type="submit" id="searchsubmit" value="Search" class="btn btn-primary">
        </form>
        
        <a class="btn btn-success" id="add" href=""""),_display_(Seq(/*54.52*/routes/*54.58*/.ExtraInfos.create())),format.raw/*54.78*/("""">Create Extra Information</a>
    </div>
    
    """),_display_(Seq(/*57.6*/if(currentPage.getTotalRowCount == 0)/*57.43*/ {_display_(Seq(format.raw/*57.45*/("""
        
        <div class="well">
            <em>Nothing to display</em>
        </div>
        
    """)))}/*63.7*/else/*63.12*/{_display_(Seq(format.raw/*63.13*/("""
        
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    """),_display_(Seq(/*68.22*/header("title", "Title"))),format.raw/*68.46*/("""
                    """),_display_(Seq(/*69.22*/header("idea.title", "Idea"))),format.raw/*69.50*/("""
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq(/*74.18*/for(extraInfo <- currentPage.getList) yield /*74.55*/ {_display_(Seq(format.raw/*74.57*/("""
                    <tr>
                        <td><a href=""""),_display_(Seq(/*76.39*/routes/*76.45*/.ExtraInfos.edit(extraInfo.id))),format.raw/*76.75*/("""">"""),_display_(Seq(/*76.78*/extraInfo/*76.87*/.title)),format.raw/*76.93*/("""</a></td>
                        <td>
                            """),_display_(Seq(/*78.30*/if(extraInfo.idea == null)/*78.56*/ {_display_(Seq(format.raw/*78.58*/("""
                                <em>-</em>
                            """)))}/*80.31*/else/*80.36*/{_display_(Seq(format.raw/*80.37*/("""
                                """),_display_(Seq(/*81.34*/extraInfo/*81.43*/.idea.title)),format.raw/*81.54*/("""
                            """)))})),format.raw/*82.30*/("""
                        </td>
                    </tr>
                """)))})),format.raw/*85.18*/("""

            </tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(Seq(/*92.18*/if(currentPage.hasPrev)/*92.41*/ {_display_(Seq(format.raw/*92.43*/("""
                    <li class="prev">
                        <a href=""""),_display_(Seq(/*94.35*/link(currentPage.getPageIndex - 1, null))),format.raw/*94.75*/("""">&larr; Previous</a>
                    </li>
                """)))}/*96.19*/else/*96.24*/{_display_(Seq(format.raw/*96.25*/("""
                    <li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))})),format.raw/*100.18*/("""
                <li class="current">
                    <a>Displaying """),_display_(Seq(/*102.36*/currentPage/*102.47*/.getDisplayXtoYofZ(" to "," of "))),format.raw/*102.80*/("""</a>
                </li>
                """),_display_(Seq(/*104.18*/if(currentPage.hasNext)/*104.41*/ {_display_(Seq(format.raw/*104.43*/("""
                    <li class="next">
                        <a href=""""),_display_(Seq(/*106.35*/link(currentPage.getPageIndex + 1, null))),format.raw/*106.75*/("""">Next &rarr;</a>
                    </li>
                """)))}/*108.19*/else/*108.24*/{_display_(Seq(format.raw/*108.25*/("""
                    <li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))})),format.raw/*112.18*/("""
            </ul>
        </div>
        
        </div>
        
    """)))})),format.raw/*118.6*/("""
        
""")))})),format.raw/*120.2*/("""

            """))}
    }
    
    def render(currentPage:Page[ExtraInfo],currentSortBy:String,currentOrder:String,currentFilter:String) = apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def f:((Page[ExtraInfo],String,String,String) => play.api.templates.Html) = (currentPage,currentSortBy,currentOrder,currentFilter) => apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Jun 17 17:23:59 CEST 2012
                    SOURCE: /Users/jorgesaldivar/workspace/Agora 2.0/app/views/list.scala.html
                    HASH: d284d14d7cb066500ceaa4293c2607170bbcaeba
                    MATRIX: 784->1|943->844|957->850|1046->880|1094->897|1106->900|1145->917|1185->926|1219->952|1307->1016|1359->1037|1393->1049|1427->1052|1454->1057|1492->228|1503->232|2029->99|2058->226|2086->732|2116->842|2144->1073|2177->1076|2231->1121|2266->1123|2377->1204|2418->1236|2453->1238|2565->1319|2579->1324|2616->1339|2668->1360|2748->1409|2785->1424|2897->1505|2932->1518|3166->1721|3181->1727|3223->1747|3305->1799|3351->1836|3386->1838|3510->1945|3523->1950|3557->1951|3719->2082|3765->2106|3818->2128|3868->2156|3981->2238|4034->2275|4069->2277|4164->2341|4179->2347|4231->2377|4265->2380|4283->2389|4311->2395|4410->2463|4445->2489|4480->2491|4572->2565|4585->2570|4619->2571|4684->2605|4702->2614|4735->2625|4797->2655|4903->2729|5058->2853|5090->2876|5125->2878|5229->2951|5291->2991|5375->3057|5388->3062|5422->3063|5593->3201|5698->3274|5719->3285|5775->3318|5851->3362|5884->3385|5920->3387|6025->3460|6088->3500|6169->3562|6183->3567|6218->3568|6385->3702|6489->3774|6532->3785
                    LINES: 27->1|29->32|29->32|31->32|32->33|32->33|32->33|32->33|32->33|32->33|33->34|33->34|33->34|33->34|35->6|35->6|57->1|59->5|60->27|62->31|63->36|65->38|65->38|65->38|69->42|69->42|69->42|71->44|71->44|71->44|73->46|76->49|76->49|77->50|77->50|81->54|81->54|81->54|84->57|84->57|84->57|90->63|90->63|90->63|95->68|95->68|96->69|96->69|101->74|101->74|101->74|103->76|103->76|103->76|103->76|103->76|103->76|105->78|105->78|105->78|107->80|107->80|107->80|108->81|108->81|108->81|109->82|112->85|119->92|119->92|119->92|121->94|121->94|123->96|123->96|123->96|127->100|129->102|129->102|129->102|131->104|131->104|131->104|133->106|133->106|135->108|135->108|135->108|139->112|145->118|147->120
                    -- GENERATED --
                */
            