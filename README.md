# gitbucket-emoji-plugin [![build](https://github.com/gitbucket/gitbucket-emoji-plugin/workflows/build/badge.svg?branch=master)](https://github.com/gitbucket/gitbucket-emoji-plugin/actions?query=workflow%3Abuild+branch%3Amaster)

This plug-in provides Emoji support for GitBucket.

- Convert Emoji directives in Markdown or other places as images
- Suggest Emoji directives in the textarea

![Completion Emoji in textarea](emoji.png)

See [Emoji cheat sheet for Campfire and GitHub](https://www.webpagefx.com/tools/emoji-cheat-sheet/) to know what emoji are available.

Plugin version | GitBucket version
:--------------|:--------------------
4.6.x          | 4.23.x -
4.5.x          | 4.18.x -
4.4.x          | 4.10.x -
4.3.x          | 4.3.x - 4.9.x

## Installation

Download jar file from [Releases page](https://github.com/gitbucket/gitbucket-emoji-plugin/releases) and put into `GITBUCKET_HOME/plugins`.

## Build from source

Run `sbt assembly` and copy generated `/target/scala-2.13/gitbucket-emoji-plugin-x.x.x.jar` to `~/.gitbucket/plugins/` (If the directory does not exist, create it by hand before copying the jar), or just run `sbt install`.

Run `sbt downloadImages` to update images. It will download the latest images to `src/main/resources/gitbucket/emoji/assets` and update [EmojiUtil.scala](https://github.com/gitbucket/gitbucket-emoji-plugin/blob/master/src/main/scala/gitbucket/emoji/EmojiUtil.scala).