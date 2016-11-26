# gitbucket-emoji-plugin

This plug-in provides Emoji support for GitBucket.

- Convert Emoji directives in Markdown or other places as images
- Suggest Emoji directives in the textarea

![Completion Emoji in textarea](emoji.png)

Plugin version | GitBucket version
:--------------|:--------------------
4.3.x          | 4.3.x, 4.4.x, 4.5.x, 4.6.x, 4.7.x

## Installation

Download jar file from [the release page](https://github.com/gitbucket/gitbucket-emoji-plugin/releases) and put into `GITBUCKET_HOME/plugins`.

## Build from source

1. Hit `./sbt.sh package` in the root directory of this repository.
2. Copy `target/scala-2.11/gitbucket-emoji-plugin_2.11-x.x.x.jar` into `GITBUCKET_HOME/plugins`.
3. Restart GitBucket.
