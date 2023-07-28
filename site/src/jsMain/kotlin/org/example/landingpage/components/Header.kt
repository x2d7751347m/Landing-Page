package org.example.landingpage.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.landingpage.models.Section
import org.example.landingpage.models.Theme
import org.example.landingpage.styles.LogoStyle
import org.example.landingpage.styles.NavigationItemStyle
import org.example.landingpage.util.Constants.FONT_FAMILY
import org.example.landingpage.util.Res
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun Header() {
    val breakpoint = rememberBreakpoint()
    Row (
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 80.percent else 90.percent)
            .margin(topBottom = 50.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        LeftSide(breakpoint = breakpoint)
        if(breakpoint > Breakpoint.MD) {
        RightSide()
        }
    }
}

@Composable
fun LeftSide(breakpoint: Breakpoint) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (breakpoint <= Breakpoint.MD) {
            FaBars(
                modifier = Modifier.margin(right = 15.px),
                size = IconSize.XL
            )
        }
        Image(
            modifier = LogoStyle.toModifier(),
            src = Res.Image.logo,
            desc = "Logo Image",
        )
    }
}

@Composable
fun RightSide() {
    Row (
        modifier = Modifier.fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(all = 20.px),
        horizontalArrangement = Arrangement.End
    ){
        Section.values().take(6).forEach { section ->
            Link(
                modifier = NavigationItemStyle.toModifier()
                    .padding(right = 30.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None),
                path = section.path,
                text = section.title
            )
        }
    }
}