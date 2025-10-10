package com.edureminder.interview.lib.markdown

import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import io.noties.markwon.Markwon

/**
 *
 * Renders Markdown text using the provided [Markwon] instance
 *
 * @param markdownString The markdown string to be rendered
 * @param markwon The [Markwon] instance to be used for rendering the markdown
 * @param modifier The modifier to be applied to the layout
 * @param textSizeSp The text size in sp to be applied to the markdown text
 * @param textColor The color to be applied to the markdown text
 * @param linkTextColor The color to be applied to the links in the markdown text
 */
@Composable
fun MarkdownText(
    markdownString: String,
    markwon: Markwon,
    modifier: Modifier = Modifier,
    textSizeSp: Float = 16f,
    textColor: Color = Color.Black,
    linkTextColor: Color = Color.Blue,
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            val textView = TextView(context)
            textView.textSize = textSizeSp
            textView.setTextColor(textColor.toArgb())
            // enable Linkify to auto-detect web-URLs in
            // the rendered text
            textView.movementMethod = LinkMovementMethod.getInstance()
            textView.linksClickable = true
            textView.autoLinkMask = Linkify.WEB_URLS
            textView.setLinkTextColor(linkTextColor.toArgb())
            textView
        },
        update = {
            it.text = markwon.render(markwon.parse(markdownString))
        }
    )
}