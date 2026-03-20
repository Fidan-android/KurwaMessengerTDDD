package feed.an.kurwa_messenger.login

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.rules.ActivityScenarioRule
import feed.an.kurwa_messenger.MainActivity

class LoginScreen(
    composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {

    private val scaffold = composeTestRule.onNode(
        matcher = hasTestTag("body screen")
                and hasClickAction()
    )

    private val emailInput = composeTestRule.onNode(
        matcher = hasTestTag("email input") and hasClickAction()
    )

    private val passwordInput =
        composeTestRule.onNode(
            matcher = hasTestTag("password input") and hasClickAction()
        )

    private val eyeButton = composeTestRule.onNode(
        matcher = hasTestTag("eye button")
                and hasClickAction()
    )

    private val loginButton = composeTestRule.onNode(
        matcher = hasTestTag("login button")
                and hasClickAction()
    )

    private val loader = composeTestRule.onNode(
        matcher = hasTestTag("loader")
    )

    private val errorMessage = composeTestRule.onNode(
        matcher = hasTestTag("error message")
    )

    fun onClickPasswordInput() {
        passwordInput.performClick()
    }

    fun assertPasswordInputFocus() {
        passwordInput.assertIsFocused()
    }

    fun onClickEmptyArea() {
        scaffold.performClick()
    }

    fun assertNoFocus() {
        emailInput.assertIsNotFocused()
        passwordInput.assertIsNotFocused()
    }

    fun onWriteToPasswordInput(text: String) {
        passwordInput.performTextInput(text)
    }

    fun assertPasswordInput(expected: String) {
        passwordInput.assertTextEquals(expected)
    }

    fun onClickEyeButton() {
        eyeButton.performClick()
    }

    fun onClickEmailInput() {
        emailInput.performClick()
    }

    fun assertEmailInputFocus() {
        emailInput.assertIsFocused()
    }

    fun onWriteToEmailInput(text: String) {
        emailInput.performTextInput(text)
    }

    fun assertLoginInput(expected: String) {
        emailInput.assertTextEquals(expected)
    }

    fun onClickLoginButton() {
        loginButton.performClick()
    }

    fun assertLoaderShowing() {
        loader.assertIsDisplayed()
    }

    fun assertLoaderNotShowing() {
        loader.assertIsNotDisplayed()
    }

    fun assertErrorMessage(expected: String) {
        errorMessage.assertTextEquals(expected)
    }

    fun onClearEmailInput() {
        emailInput.performTextInput("")
    }

    fun onClearPasswordInput() {
        passwordInput.performTextInput("")
    }
}