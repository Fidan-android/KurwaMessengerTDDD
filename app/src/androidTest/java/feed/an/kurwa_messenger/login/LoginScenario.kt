package feed.an.kurwa_messenger.login

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import feed.an.kurwa_messenger.MainActivity
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginScenario {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val loginScreen = LoginScreen(composeTestRule)

    @Test
    fun check_focus() {
        loginScreen.onClickPasswordInput()
        loginScreen.assertPasswordInputFocus()

        loginScreen.onClickEmptyArea()
        loginScreen.assertNoFocus()
    }

    @Test
    fun show_password() {
        loginScreen.onClickPasswordInput()
        loginScreen.assertPasswordInputFocus()

        loginScreen.onWriteToPasswordInput(text = "123")
        loginScreen.assertPasswordInput(expected = "***")

        loginScreen.onClickEyeButton()
        loginScreen.assertPasswordInput(expected = "123")

        loginScreen.onClickEyeButton()
        loginScreen.assertPasswordInput(expected = "***")
    }

    @Test
    fun log_in() {
        loginScreen.onClickEmailInput()
        loginScreen.assertEmailInputFocus()

        loginScreen.onWriteToEmailInput(text = "fid")
        loginScreen.assertLoginInput(expected = "fid")

        loginScreen.onClickLoginButton()
        loginScreen.assertNoFocus()
        loginScreen.assertLoaderShowing()
        loginScreen.assertErrorMessage(expected = "Заполните все данные")
        loginScreen.assertLoaderNotShowing()

        loginScreen.onClickPasswordInput()
        loginScreen.assertPasswordInputFocus()

        loginScreen.onWriteToPasswordInput(text = "qwe")
        loginScreen.assertPasswordInput(expected = "***")

        loginScreen.onClickLoginButton()
        loginScreen.assertNoFocus()
        loginScreen.assertLoaderShowing()
        loginScreen.assertErrorMessage(expected = "Неверный формат почты")
        loginScreen.assertLoaderNotShowing()

        loginScreen.onClickEmailInput()
        loginScreen.assertEmailInputFocus()
        loginScreen.assertErrorMessage(expected = "")

        loginScreen.onClearEmailInput()
        loginScreen.assertLoginInput(expected = "")

        loginScreen.onWriteToEmailInput(text = "gum.fidan2017@yandex.ru")
        loginScreen.assertLoginInput(expected = "fidan2017")

        loginScreen.onClickLoginButton()
        loginScreen.assertNoFocus()
        loginScreen.assertLoaderShowing()
        loginScreen.assertErrorMessage(expected = "Пароль должен содержать не меньше 8 знаков")
        loginScreen.assertLoaderNotShowing()

        loginScreen.onClickPasswordInput()
        loginScreen.assertPasswordInputFocus()
        loginScreen.assertErrorMessage(expected = "")

        loginScreen.onWriteToPasswordInput(text = "rty123")
        loginScreen.assertPasswordInput(expected = "*********")

        loginScreen.onClickEyeButton()
        loginScreen.assertPasswordInput(expected = "qwerty123")

        loginScreen.onClickLoginButton()
        loginScreen.assertNoFocus()
        loginScreen.assertLoaderShowing()
        loginScreen.assertErrorMessage("")
    }
}