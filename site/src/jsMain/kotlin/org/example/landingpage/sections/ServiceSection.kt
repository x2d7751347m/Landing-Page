package org.example.landingpage.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.landingpage.components.SectionTitle
import org.example.landingpage.components.ServiceCard
import org.example.landingpage.models.Section
import org.example.landingpage.models.Service
import org.example.landingpage.util.Constants.SECTION_WIDTH
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


@Composable
fun ServiceSection() {
    Box(
        modifier = Modifier
            .id(Section.Service.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        ServiceContent()
    }
}

@Composable
fun ServiceContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth().margin(bottom = 20.px),
            section = Section.Service,
            alignment = Alignment.CenterHorizontally
        )
        SimpleGrid(numColumns = numColumns(base = 1, sm = 2, md = 3)) {
            Service.values().forEach { service ->
                ServiceCard(service)
            }
        }
    }
}