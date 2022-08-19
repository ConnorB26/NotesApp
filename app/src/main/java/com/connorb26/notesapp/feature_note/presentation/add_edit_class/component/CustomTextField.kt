package com.connorb26.notesapp.feature_note.presentation.add_edit_class.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import com.connorb26.notesapp.ui.theme.Blue
import com.connorb26.notesapp.ui.theme.Green
import com.connorb26.notesapp.ui.theme.LightGray

@Composable
fun CustomTextField(
    text: String,
    hint: String = "",
    labelColor: Color = Color.White,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = true,
    onValueChange: (String) -> Unit = { },
    iconComp: @Composable (() -> Unit)? = null,
    backgroundColor: Color = Color.Transparent,
    selectionColor: Color = LightGray,
    textColor: Color = Color.White,
    readOnly: Boolean = false,
    readOnlyColor: Color = Color.Gray
) {
    val customTextSelectionColors = TextSelectionColors(
        handleColor = selectionColor,
        backgroundColor = selectionColor.copy(alpha = 0.4f)
    )

    Box(
        modifier = modifier
    ) {
        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
            TextField(
                value = text,
                onValueChange = onValueChange,
                singleLine = singleLine,
                readOnly = readOnly,
                enabled = !readOnly,
                textStyle = textStyle.copy(color = textColor),
                modifier = Modifier.fillMaxWidth()
                    .background(backgroundColor),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    autoCorrect = true
                ),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = textColor,
                    backgroundColor = Color.Transparent,
                    textColor = if(readOnly) readOnlyColor else textColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                placeholder = { if(hint.isNotBlank()) Text(text = hint, style = textStyle, color = Color.DarkGray) },
                leadingIcon = iconComp
            )
        }
    }
}