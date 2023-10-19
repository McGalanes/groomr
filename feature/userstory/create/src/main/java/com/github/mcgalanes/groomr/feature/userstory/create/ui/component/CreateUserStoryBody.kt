package com.github.mcgalanes.groomr.feature.userstory.create.ui.component

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.feature.userstory.create.domain.GroomStep
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.BusinessValueForm
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.KpiForm
import com.github.mcgalanes.groomr.feature.userstory.create.ui.component.form.NeedForm

@Composable
fun CreateUserStoryBody(
    currentStep: GroomStep,
    modifier: Modifier = Modifier,
) {
    Crossfade(
        modifier = modifier.padding(16.dp),
        targetState = currentStep,
        label = "stepper_form_crossfade",
    ) { step ->
        when (step) {
            GroomStep.Need -> NeedForm()
            GroomStep.Kpi -> KpiForm()
            GroomStep.BusinessValue -> BusinessValueForm()
            else -> Unit
        }
    }
}
