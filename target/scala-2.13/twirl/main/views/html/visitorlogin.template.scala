
package views.html

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

object visitorlogin extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader, flash:Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/mainjtq("Login")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
  """),format.raw/*4.3*/("""<h2>Login</h2>
  
	<form method="post" action=""""),_display_(/*6.31*/routes/*6.37*/.VisitorController.validateLogin),format.raw/*6.69*/("""">
		"""),_display_(/*7.4*/helper/*7.10*/.CSRF.formField),format.raw/*7.25*/("""
		"""),format.raw/*8.3*/("""Username: <input type="text" name="username"></input><br>
		Password: <input type="password" name="password"></input><br>
		<input type="submit"></input>
	</form>
  """),_display_(/*12.4*/flash/*12.9*/.get("error")),format.raw/*12.22*/("""
""")))}),format.raw/*13.2*/("""
"""))
      }
    }
  }

  def render(request:RequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply()(request,flash)

  def f:(() => (RequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = () => (request,flash) => apply()(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/visitorlogin.scala.html
                  HASH: ec368961d9630195d3e67ea0e9035085d2ba94e3
                  MATRIX: 749->1|891->50|918->52|942->68|981->70|1010->73|1084->121|1098->127|1150->159|1181->165|1195->171|1230->186|1259->189|1451->355|1464->360|1498->373|1530->375
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|30->6|30->6|30->6|31->7|31->7|31->7|32->8|36->12|36->12|36->12|37->13
                  -- GENERATED --
              */
          