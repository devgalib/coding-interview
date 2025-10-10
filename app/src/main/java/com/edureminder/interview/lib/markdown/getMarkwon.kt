package com.edureminder.interview.lib.markdown

import android.content.Context
import android.graphics.Typeface
import android.text.util.Linkify
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.res.ResourcesCompat
import com.edureminder.interview.R
import io.noties.markwon.AbstractMarkwonPlugin
import io.noties.markwon.Markwon
import io.noties.markwon.core.CorePlugin
import io.noties.markwon.core.MarkwonTheme
import io.noties.markwon.ext.strikethrough.StrikethroughPlugin
import io.noties.markwon.ext.tables.TablePlugin
import io.noties.markwon.ext.tasklist.TaskListPlugin
import io.noties.markwon.linkify.LinkifyPlugin
import io.noties.markwon.syntax.Prism4jThemeDarkula
import io.noties.markwon.syntax.SyntaxHighlightPlugin
import io.noties.prism4j.Prism4j

fun getMarkwon(
    context: Context,
    codeTextColor: Color = Color.White,
    codeBackgroundColor: Color = Color.Black,
    codeFontSizePx: Int = 11
): Markwon {
    val prism4j = Prism4j(PrismGrammarLocator())
    val markwon =
        Markwon
            .builder(context)
            .usePlugin(CorePlugin.create())
            .usePlugin(TablePlugin.create(context)) // to render tables
            .usePlugin(TaskListPlugin.create(context)) // to render task lists
            .usePlugin(StrikethroughPlugin.create()) // to render strikethrough
            // enable syntax highlighting with prism4j
            .usePlugin(SyntaxHighlightPlugin.create(prism4j, Prism4jThemeDarkula.create()))
            .usePlugin(LinkifyPlugin.create(Linkify.WEB_URLS))
            .usePlugin(
                object : AbstractMarkwonPlugin() {
                    override fun configureTheme(builder: MarkwonTheme.Builder) {
                        val jetbrainsMonoFont = ResourcesCompat
                            .getFont(context, R.font.jetbrains_mono) ?: Typeface.MONOSPACE
                        builder
                            .codeBlockTypeface(jetbrainsMonoFont)
                            .codeBlockTextColor(codeTextColor.toArgb())
                            .codeBlockBackgroundColor(codeBackgroundColor.toArgb())
                            .codeBlockTextSize(codeFontSizePx)
                            .codeTypeface(jetbrainsMonoFont)
                            .codeTextColor(codeTextColor.toArgb())
                            .codeBackgroundColor(codeBackgroundColor.toArgb())
                            .codeTextSize(codeFontSizePx)
                            .isLinkUnderlined(true)
                    }
                },
            )
            .build()
    return markwon
}