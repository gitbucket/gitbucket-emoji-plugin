organization := "io.github.gitbucket"
name := "gitbucket-emoji-plugin"
version := "4.6.0"
scalaVersion := "2.13.8"
gitbucketVersion := "4.37.2"

val donwloadImagesKey = TaskKey[Unit]("downloadImages")

donwloadImagesKey := {
  import java.io.File
  import java.net.URL
  import java.nio.charset.StandardCharsets
  import org.jsoup.Jsoup
  import scala.jdk.CollectionConverters._

  val baseUrl       = "https://www.webfx.com/tools/emoji-cheat-sheet/"
  val assetsDir     = Keys.sourceDirectory.value / "main" / "resources" / "gitbucket" / "emoji" / "assets"
  val existingFiles = assetsDir.listFiles().map(_.getName())
  val doc           = Jsoup.connect(baseUrl).get()
  doc.select(".emojis > li .emoji[data-src]").asScala.foreach { e =>
    val name = e.nextElementSibling().text()
    if (!existingFiles.contains(s"${name}.png")) {
      val image = e.dataset().get("src")
      IO.transfer(new URL(s"${baseUrl}${image}").openStream(), new File(assetsDir, s"${name}.png"))
    }
  }

  val files  = assetsDir.listFiles().map(_.getName().split("\\.")(0)).sorted
  val emojis = files.map { file => s""""${file}"""" }.mkString(",\n    ")
  val source = s"""package gitbucket.emoji
    |
    |/**
    | * Converts an Emoji like :smiley: to its related image
    | */
    |object EmojiUtil {
    |
    |  val emojis = Set(
    |    ${emojis}
    |  )
    |
    |  private val emojiPattern = ${"\"\"\""}\\:[a-z0-9_\\-\\+]+\\:${"\"\"\""}.r
    |
    |  def convertEmojis(text: String)(implicit context: gitbucket.core.controller.Context): String =
    |    emojiPattern.replaceAllIn(text, e => {
    |      val emoji = e.group(0).replaceAll(":", "")
    |      if (!emojis.contains(emoji)) s":$$emoji:"
    |      else s${"\"\"\""}<img src="$${context.baseUrl}/plugin-assets/emoji/$${emoji}.png" alt=":$$emoji:" class="emoji" />${"\"\"\""}
    |    })
    |
    |}
    |""".stripMargin

  val sourceFile = Keys.sourceDirectory.value / "main" / "scala" / "gitbucket" / "emoji" / "EmojiUtil.scala"
  IO.write(sourceFile, source, StandardCharsets.UTF_8)

}
