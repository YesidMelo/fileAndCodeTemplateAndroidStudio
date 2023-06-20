package ${PACKAGE_NAME}.ui.views.splashView

//file name: ui/splashView/SplashView

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import ${PACKAGE_NAME}.R
import ${PACKAGE_NAME}.ui.constants.LoadingState
import ${PACKAGE_NAME}.ui.theme.JacsTheme

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PHONE)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PHONE)
@Composable
fun SplashViewPreview() {
    JacsTheme {
        ConstraintLayout(modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondaryContainer)) {
            val constraintsId = createRef()
            SplashView(modifier = Modifier.constrainAs(constraintsId) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            },
                splashViewModel = object : SplashViewModel(){},
                navigateToLogin = {}
            )
        }
    }
}

@Composable
fun SplashView(
    modifier: Modifier = Modifier,
    splashViewModel: SplashViewModel = hiltViewModel(),
    navigateToLogin: ()->Unit
) {
    //region stateObserver
    val currentState by splashViewModel.uiState.collectAsState(initial = SplashViewModel.SplashUIState())
    //endregion

    //region check values state
    when(currentState.loadingState) {
        LoadingState.START -> splashViewModel.loadSplash()
        LoadingState.LOADED -> navigateToLogin.invoke()
        LoadingState.LOADING -> {}
    }
    //endregion
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (textId, progressId) = createRefs()
        //region text splash
        val guidelineEnd = createGuidelineFromEnd(0.06f)
        val guidelineStart = createGuidelineFromStart(0.06f)

        Text(
            text = stringResource(id = R.string.jacs_long),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.constrainAs(textId){
                bottom.linkTo(parent.bottom)
                end.linkTo(guidelineEnd)
                start.linkTo(guidelineStart)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            },
            textAlign = TextAlign.Center
        )
        //endregion

        //region text loading
        val guidelineBottomTextLoading = createGuidelineFromBottom(0.2f)
        Text(
            text = "status: ${currentState.loadingState}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.constrainAs(progressId){
                bottom.linkTo(guidelineBottomTextLoading)
                end.linkTo(guidelineEnd)
                start.linkTo(guidelineStart)
                width = Dimension.fillToConstraints
            },
            textAlign = TextAlign.Center
        )
        //endregion
    }
}