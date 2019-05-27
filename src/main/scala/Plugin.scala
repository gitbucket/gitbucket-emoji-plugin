import gitbucket.core.controller.Context
import gitbucket.core.plugin._
import gitbucket.core.service.RepositoryService.RepositoryInfo
import gitbucket.emoji.EmojiUtil
import io.github.gitbucket.solidbase.model.Version

class Plugin extends gitbucket.core.plugin.Plugin {

  override val pluginId: String = "emoji"

  override val pluginName: String = "Emoji Plugin"

  override val description: String = "Provides Emoji support for GitBucket."

  override val versions: List[Version] = List(
    new Version("4.3.0"),
    new Version("4.4.0"),
    new Version("4.5.0"),
    new Version("4.5.1"),
    new Version("4.5.2")
  )

  override val assetsMappings = Seq("/emoji" -> "/gitbucket/emoji/assets")

  override val textDecorators = Seq(
    new TextDecorator {
      override def decorate(text: String, repository: RepositoryInfo)(implicit context: Context): String = EmojiUtil.convertEmojis(text)
    }
  )

  override val suggestionProviders = Seq(
    new SuggestionProvider {
      override val id: String = "emoji"
      override val prefix: String = ":"
      override val suffix: String = ": "
      override val context: Seq[String] = Seq("wiki", "issues")
      override def values(repository: RepositoryInfo): Seq[String] = EmojiUtil.emojis.toSeq
      override def template(implicit context: Context): String =
        s"""'<img src=\"${context.path}/plugin-assets/emoji/' + option.value + '.png\" class=\"emoji\"></img>' + option.value"""
    }
  )
}
