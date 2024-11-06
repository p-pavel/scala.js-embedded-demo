//> using platform js
//> using scala 3.5.1
//> using options -Wunused:all
//> using dep in.nvilla::monadic-html::0.5.0-RC1
import mhtml.*
import scala.xml.Node
import org.scalajs.dom
import scala.scalajs.js.annotation.*
import org.scalajs.dom.Element


@JSExportTopLevel("MyApp")
object MyApp:
  @JSExport
  def main(topElem: String) =

    val count = Var(0)

    val doge: Node =
      <img style="width: 100px;" src="https://ih1.redbubble.net/image.2118290427.2033/st,small,507x507-pad,600x600,f8f8f8.jpg"/>

    val rxDoges: Rx[Seq[Node]] =
      count.map(i => Seq.fill(i)(doge))

    val component = 
    //format: off
      <div>
        <button class="button is-primary is-small is-outlined" onclick={ () => count.update(_ + 1) }>Add doges!</button>
        <button class="button is-small" onclick = {() => count := 0}>Reset</button> 
        { count.map(i => if (i <= 0) <div></div> else <h2>WOW WOW!!!</h2>) }
        { count.map(i => if (i <= 2) <div></div> else <h2>MUCH REACTIVE!!!</h2>) }
        { count.map(i => if (i <= 5) <div></div> else <h2>SUCH BINDING!!!</h2>) }
        <h2>Here will be doges</h2>
        { rxDoges }
      </div>
    //format: on

    val div: Element = dom.document.createElement("div")
    val el = dom.document.getElementById(topElem)
    el.append(div)

    mount(div, component)
  end main
end MyApp
