
package views.html.helper

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object date extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[play.api.data.Field,Array[scala.Tuple2[Symbol, Any]],FieldConstructor,play.api.i18n.MessagesProvider,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(field: play.api.data.Field, args: (Symbol,Any)*)(implicit handler: FieldConstructor, messages: play.api.i18n.MessagesProvider):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*3.2*/inputType/*3.11*/ = {{ "date" }};
Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.25*/("""

"""),_display_(/*5.2*/input(field, args.filter(_._1 != Symbol("type")):_*)/*5.54*/ { (id, name, value, htmlArgs) =>_display_(Seq[Any](format.raw/*5.87*/("""
  """),format.raw/*6.3*/("""<input type=""""),_display_(/*6.17*/inputType),format.raw/*6.26*/("""" id=""""),_display_(/*6.33*/id),format.raw/*6.35*/("""" name=""""),_display_(/*6.44*/name),format.raw/*6.48*/("""" value=""""),_display_(/*6.58*/value),format.raw/*6.63*/("""" """),_display_(/*6.66*/toHtmlArgs(htmlArgs)),format.raw/*6.86*/("""/>
""")))}),format.raw/*7.2*/("""
"""))
      }
    }
  }

  def render(field:play.api.data.Field,args:Array[scala.Tuple2[Symbol, Any]],handler:FieldConstructor,messages:play.api.i18n.MessagesProvider): play.twirl.api.HtmlFormat.Appendable = apply(field,args.toIndexedSeq:_*)(handler,messages)

  def f:((play.api.data.Field,Array[scala.Tuple2[Symbol, Any]]) => (FieldConstructor,play.api.i18n.MessagesProvider) => play.twirl.api.HtmlFormat.Appendable) = (field,args) => (handler,messages) => apply(field,args.toIndexedSeq:_*)(handler,messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/helper/date.scala.html
                  HASH: 1a414f9a4b12ae571b4a03e56cf9e9c5f67e2146
                  MATRIX: 829->1|1034->131|1051->140|1094->129|1122->154|1150->157|1210->209|1280->242|1309->245|1349->259|1378->268|1411->275|1433->277|1468->286|1492->290|1528->300|1553->305|1582->308|1622->328|1655->332
                  LINES: 21->1|25->3|25->3|26->2|27->3|29->5|29->5|29->5|30->6|30->6|30->6|30->6|30->6|30->6|30->6|30->6|30->6|30->6|30->6|31->7
                  -- GENERATED --
              */
          