package com.rk.riggle_sales.utils

import android.graphics.Color
import android.os.Handler
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.util.regex.Pattern

class FieldsValidator {

    fun isEmailAddress(editText: EditText, required: Boolean): Boolean {
        return isValid(editText, EMAIL_REGEX, EMAIL_MSG, required)
    }

    fun isPostalCodeValid(editText: EditText, required: Boolean): Boolean {
        return isValid(editText, Postal_code_regex, POSTAL_CODE_MSG, required)
    }

    fun isValidPassword(editText: EditText, required: Boolean): Boolean {
        return if (editText.text.toString().length < 8) {
            editText.error = NEW_PASS_MSG
            false
        } else {
            true
        }
    }

    fun isEmailAddress(editText: String?, required: Boolean): Boolean {
        return isEmailValid(editText, EMAIL_REGEX, required)
    }

    fun isPhoneNumber(editText: EditText, required: Boolean): Boolean {
        return isValid(editText, PHONE_REGEX, PHONE_MSG, required)
    }

    fun isNameValid(editText: EditText, required: Boolean): Boolean {
        return isValid(editText, "[a-zA-Z]+", NAME_MSG, required)
    }


    private fun isValid(
        editText: EditText,
        regex: String?,
        errMsg: String?,
        required: Boolean
    ): Boolean {
        val text = editText.text.toString().trim { it <= ' ' }
        editText.error = null
        if (required && !hasText(editText)) return false
        if (!Pattern.matches(regex, text)) {
            //editText.error = errMsg
            return false
        }
        return true
    }

    fun isEmailValid(editText: String?, regex: String?, required: Boolean): Boolean {
        return Pattern.matches(regex, editText)
    }

    fun hasText(editText: TextView): Boolean {
        val text = editText.text.toString().trim { it <= ' ' }
        editText.error = null
        if (text.isEmpty()) {
            editText.error = REQUIRED_MSG
            return false
        }
        return true
    }

    fun hasText(editText: EditText, errMsg: String?): Boolean {
        val text = editText.text.toString().trim { it <= ' ' }
        editText.error = null
        if (text.isEmpty()) {
            editText.error = errMsg
            return false
        }
        return true
    }

    fun isTextWithInRange(
        editText: EditText,
        minLimit: Int,
        maxLimit: Int,
        error: String?
    ): Boolean {
        val text = editText.text.toString().trim { it <= ' ' }
        editText.error = null
        if (text.isEmpty()) {
            editText.error = REQUIRED_MSG
            return false
        }
        return if (text.length in minLimit..maxLimit) {
            true
        } else {
            editText.error = error
            false
        }
    }

    fun isMatching(editText1: EditText, editText2: EditText): Boolean {
        return if (editText1.text.toString().equals(
                editText2.text.toString(),
                ignoreCase = true
            )
        ) {
            true
        } else {
            editText2.error = "Old password and confirmation password don't match"
            false
        }
    }

    fun haveAtLeastOneDigitAndUpperAlpha(
        editText: EditText,
        regex: String?,
        errMsg: String?,
        required: Boolean
    ): Boolean {
        val text = editText.text.toString().trim { it <= ' ' }
        editText.error = null
        if (required && !hasText(editText)) return false
        if (required && !Pattern.matches(regex, text)) {
            editText.error = errMsg
            return false
        }
        return true
    }

    fun haveAtLeastOneSymbolAndUpperAlpha(
        editText: EditText,
        regex: String?,
        errMsg: String?,
        required: Boolean
    ): Boolean {
        val text = editText.text.toString().trim { it <= ' ' }
        editText.error = null
        if (required && !hasText(editText)) return false
        if (required && !Pattern.matches(regex, text)) {
            editText.error = errMsg
            return false
        }
        return true
    }

    @Synchronized
    private fun clearError(view: EditText) {
        Handler().postDelayed({ view.error = null }, 1000)
    }

    @Synchronized
    fun validateEmail(view: EditText, message: String?): Boolean {
        var message = message
        if (message == null || message.isEmpty()) message = "Please enter a valid email"
        val fgColorSpan = ForegroundColorSpan(Color.WHITE)
        val sBuilder = SpannableStringBuilder(message)
        sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
        if (!Patterns.EMAIL_ADDRESS.matcher(
                view.text.toString()
            ).matches()
        ) {
            view.requestFocus()
            view.error = sBuilder
            clearError(view)
            return true
        }
        return false
    }

    @Synchronized
    fun validateNotEmpty(view: TextView, message: String?): Boolean {
        var message = message
        if (message == null || message.isEmpty()) message = "This field should not be empty"
        val fgColorSpan = ForegroundColorSpan(Color.WHITE)
        val sBuilder = SpannableStringBuilder(message)
        sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
        if (view.text.toString().isEmpty()) {
            view.requestFocus()
            view.error = sBuilder
            Handler().postDelayed({ view.error = null }, 1000)
            return true
        }
        return false
    }

    //fgColorSpan
    @Synchronized
    fun validateNotEmpty(view: EditText, message: String?): Boolean {
        var message = message
        if (message == null || message.isEmpty() || message.equals("", ignoreCase = true)
        ) message = "This field should not be empty"
        val fgColorSpan = ForegroundColorSpan(Color.WHITE)
        val sBuilder = SpannableStringBuilder(message)
        sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
        if (view.text.toString().isEmpty()) {
            view.requestFocus()
            view.error = sBuilder
            clearError(view)
            return true
        }
        return false
    }

    @Synchronized
    fun validateLength(
        view: EditText,
        minLength: Int,
        maxLength: Int,
        message: String?
    ): Boolean {
        var message = message
        if (view.text.toString() == "" || view.text.toString().length < minLength) {
            if (message == null || message.isEmpty()) message =
                ("Input should be more than " + minLength + " characters.")
            val fgColorSpan = ForegroundColorSpan(Color.WHITE)
            val sBuilder = SpannableStringBuilder(message)
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.requestFocus()
            view.error = sBuilder
            clearError(view)
            return true
        }
        if (view.text.toString().length > maxLength) {
            if (message == null || message.isEmpty()) message =
                ("Input should be less than " + maxLength + " characters.")
            val fgColorSpan = ForegroundColorSpan(Color.WHITE)
            val sBuilder = SpannableStringBuilder(
                message

            )
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.requestFocus()
            view.error = sBuilder
            clearError(view)
            return true
        }
        return false
    }

    //    fun validateLength(etOtp: OtpEditText, i: Int): Boolean {
//        return etOtp.text.toString().length == i
//    }
    @Synchronized
    fun validateLength(
        view: TextView, minLength: Int, maxLength: Int,
        message: String?
    ): Boolean {
        var message = message
        if (view.text.toString() == "" || view.text.toString().length < minLength) {
            if (message == null || message.isEmpty()) message =
                ("Input should be more than " + minLength
                        + " characters.")
            val fgColorSpan =
                ForegroundColorSpan(Color.WHITE)
            val sBuilder =
                SpannableStringBuilder(
                    message
                )
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.error = sBuilder
            return true
        }
        if (view.text.toString().length > maxLength) {
            if (message == null || message.isEmpty()) message =
                ("Input should be less than " + maxLength
                        + " characters.")
            val fgColorSpan =
                ForegroundColorSpan(Color.WHITE)
            val sBuilder =
                SpannableStringBuilder(
                    message
                )
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.error = sBuilder
            return true
        }
        return false
    }

    @Synchronized
    fun validateValidCharacters(
        view: EditText, pattern: Pattern,
        message: String?
    ): Boolean {
        var message = message
        if (!pattern.matcher(view.text.toString()).matches()) {
            if (message == null || message.isEmpty()) message =
                "This input does not fit the requiered pattern."
            val fgColorSpan =
                ForegroundColorSpan(Color.WHITE)
            val sBuilder =
                SpannableStringBuilder(
                    message
                )
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.requestFocus()
            view.error = sBuilder
            clearError(view)
            return true
        }
        return false
    }

    @Synchronized
    fun validateUsernameWithoutSpace(
        view: EditText,
        message: String?
    ): Boolean {
        var message = message
        if (view.text.toString().contains(" ")) {
            if (message == null || message.isEmpty()) message =
                "This input does not fit the requiered pattern."
            val fgColorSpan =
                ForegroundColorSpan(Color.WHITE)
            val sBuilder =
                SpannableStringBuilder(message)
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.requestFocus()
            view.error = sBuilder
            clearError(view)
            return true
        }
        return false
    }

    @Synchronized
    fun validateUsernameSpace(
        view: EditText,
        message: String?
    ): Boolean {
        var message = message
        if (view.text.toString().trim { it <= ' ' }.equals(
                "",
                ignoreCase = true
            )
        ) {
            if (message == null || message.isEmpty()) message =
                "This field should not be empty."
            val fgColorSpan =
                ForegroundColorSpan(Color.WHITE)
            val sBuilder =
                SpannableStringBuilder(message)
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.requestFocus()
            view.error = sBuilder
            clearError(view)
            return true
        }
        return false
    }

    @Synchronized
    fun validatedateofbirth(
        view: EditText,
        message: String?
    ): Boolean {
        var message = message
        if (view.text.toString().trim { it <= ' ' }.equals(
                "",
                ignoreCase = true
            )
        ) {
            if (message == null || message.isEmpty()) message =
                "This field should not be empty."
            val fgColorSpan =
                ForegroundColorSpan(Color.WHITE)
            val sBuilder =
                SpannableStringBuilder(message)
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.requestFocus()
            view.error = sBuilder
            clearError(view)
            return true
        }
        return false
    }

    @Synchronized
    fun validateGender(view: Spinner, message: String?): Boolean {
        var message = message
        val spinnerview = view.selectedView
        val selectedTextView = spinnerview as TextView
        val gender = view.selectedItem as String
        if (gender.equals("sex", ignoreCase = true)) {
            if (message == null || message.isEmpty()) message = "Please choose Gender."
            val fgColorSpan =
                ForegroundColorSpan(Color.WHITE)
            val sBuilder =
                SpannableStringBuilder(message)
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.requestFocus()
            //((TextView) spinnerview).setError(sBuilder);
            selectedTextView.error = sBuilder
            return true
        }
        return false
    }

    @Synchronized
    fun validatePhoneNumberSpace(
        view: EditText,
        message: String?
    ): Boolean {
        var message = message
        if (view.text.toString().trim { it <= ' ' }.equals(
                "",
                ignoreCase = true
            )
        ) {
            if (message == null || message.isEmpty()) message =
                "This field should not be empty."
            val fgColorSpan =
                ForegroundColorSpan(Color.WHITE)
            val sBuilder =
                SpannableStringBuilder(message)
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.requestFocus()
            view.error = sBuilder
            clearError(view)
            return true
        }
        if (view.text.toString().length < 10 || view.text.toString().length > 13) {
            message = "Please enter the right phone number."
            val fgColorSpan =
                ForegroundColorSpan(Color.WHITE)
            val sBuilder =
                SpannableStringBuilder(message)
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            view.requestFocus()
            view.error = sBuilder
            clearError(view)
            return true
        }
        return false
    }

    @Synchronized
    fun validatePasswordMatch(
        password: EditText,
        confirmPassword: EditText,
        message: String?
    ): Boolean {
        var message = message
        if (!password.text.toString().equals(
                confirmPassword.text.toString(),
                ignoreCase = true
            )
        ) {
            if (message == null || message.isEmpty()) message = "Password Mismatch"
            val fgColorSpan =
                ForegroundColorSpan(Color.WHITE)
            val sBuilder =
                SpannableStringBuilder(
                    message
                )
            sBuilder.setSpan(fgColorSpan, 0, message.length, 0)
            confirmPassword.requestFocus()
            confirmPassword.error = sBuilder
            clearError(confirmPassword)
            return true
        }
        return false
    }

    companion object {
        // regular Expression
        const val EMAIL_REGEX =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        const val PHONE_REGEX = "\\d{3}-\\d{7}"
        const val PASSWORD_REGEX =
            "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d][A-Za-z\\d!@#$%^&*()_+]{7,19}$"
        const val PASSWORD_REGEX_NEW = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{6,}$"
        const val AT_LEAST_ONE_DIGIT_AND_UPPER_ALPHA_REGEX =
            "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$"
        const val AT_LEAST_ONE_SYMBOL_AND_UPPER_ALPHA_REGEX =
            "^(?=.*[$@$!%*#?&])(?=.*[a-z])(?=.*[A-Z]).{6,20}$"
        const val Postal_code_regex = "^[A-Z][0-9][A-Z] ?[0-9][A-Z][0-9]$"

        // Error Messages
        const val REQUIRED_MSG = "Required"
        const val EMAIL_MSG = "Email address is required and in correct format"
        const val POSTAL_CODE_MSG = "Postal Code  is required and in correct format"
        const val PHONE_MSG = "###-#######"
        const val PASSWORD_MSG =
            "Password must be of 8 character and include atleast one uppercase, lowercase and special character"
        const val TEXT_LIMIT = "Nickname cannot be greater than 18"
        const val NEW_PASS_MSG = "Password must have at least 8 characters"
        const val NAME_MSG = "Please enter valid Name"
    }
}