package ${PACKAGE_NAME}

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    device = Devices.PHONE
)
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    device = Devices.PHONE
)
@Composable
fun ${Name_view}ViewPreview() {
    ${Name_theme} {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            val constraintsId = createRef()
            ${Name_view}View(modifier = Modifier.constrainAs(constraintsId) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            },
                viewModel = object : ${Name_view}ViewModel() {},
                navigateToExample = {}
            )
        }
    }
}

@Composable
fun ${Name_view}View(
    modifier: Modifier = Modifier,
    viewModel: ${Name_view}ViewModel = hiltViewModel(),
    navigateToExample: () -> Unit
) {
    //region stateObserver
    val currentState by viewModel.uiState.collectAsState(initial = ${Name_view}ViewModel.${Name_view}UIState())
    logicApplyInView(currentState= currentState)
    //endregion

    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (textId, progressId) = createRefs()
        //region ${Name_view}
        val guidelineEnd = createGuidelineFromEnd(0.06f)
        val guidelineStart = createGuidelineFromStart(0.06f)

        Text(
            //text = stringResource(id = R.string.jacs_long),
            text = "ViewExample",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.constrainAs(textId) {
                bottom.linkTo(parent.bottom)
                end.linkTo(guidelineEnd)
                start.linkTo(guidelineStart)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            },
            textAlign = TextAlign.Center
        )
        //endregion
    }
}

private fun logicApplyInView(currentState: ${Name_view}ViewModel.${Name_view}UIState) {

}