//> using scala 3.5.1
//> using options -Wunused:all 

/**
  * Creates index.html with embedded scala.js code.
  * 
  * Usage: `scala-cli package --js -f --js-mode full start.scala && scala-cli run gen_index.scala && open index.html`
  */
@main def gen_doc = 
  import FileOps.*
  val template = read("index.in")
  val jsCode = read("start.js")
  val marker = "PutMyScriptHere"
  val endOfTemplate = template.indexOf(marker)
  write("index.html",
    template.take(endOfTemplate),
    jsCode,
    template.drop(endOfTemplate + marker.length())
  )

object FileOps:
  import java.nio.file.{Files, Path}
  def read(name: String) = 
    Files.readString(Path.of(name))
  def write(name: String, parts: String*) = 
    Files.writeString(Path.of(name), parts.mkString)
