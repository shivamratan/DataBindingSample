package com.ratanapps.databindingsample.viewmodel

import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.ratanapps.databindingsample.binding.MainValidationForm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class MainViewModel:ViewModel()
{

    /**
     * This is the job for all coroutines started by this ViewModel.
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    private val viewModelJob = SupervisorJob()

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     * Since we pass viewModelJob, you can cancel all coroutines
     * launched by uiScope by calling viewModelJob.cancel()
     */
    private val uiScope = CoroutineScope(Dispatchers.Default + viewModelJob)

    /**
     * Cancel all coroutines when the ViewModel is cleared
     */


    var moneySavedForm:MainValidationForm

    val numOfCiggrateFocusListener: View.OnFocusChangeListener
    val costOfCiggrateFocusListener: View.OnFocusChangeListener
    val targetPriceFocusListener: View.OnFocusChangeListener

    init {
        moneySavedForm = MainValidationForm()
        numOfCiggrateFocusListener = object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                val editText = v as EditText
                if(!editText.text.isEmpty() && !hasFocus)
                    moneySavedForm.isNumberOfCigratteValid()
            }
        }

        costOfCiggrateFocusListener = object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                val editText = v as EditText
                if(!editText.text.isEmpty() && !hasFocus)
                    moneySavedForm.isCostPerPackValid()
            }
        }


        targetPriceFocusListener = object : View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                val editText = v as EditText
                if(!editText.text.isEmpty() && !hasFocus)
                    moneySavedForm.isTargetSavingValid()
            }
        }
    }


    fun getBottomNumOfCiggrateListener() = numOfCiggrateFocusListener

    fun getBottomCostOfCiggrateListener() = costOfCiggrateFocusListener

    fun getBottomTargetCostListener() = targetPriceFocusListener



    companion object {
        @BindingAdapter("error")
        @JvmStatic
        fun setError(editText: EditText, strOrResId: Any?) {

            if(strOrResId != null){
                if (strOrResId is Int) {
                    editText.error = editText.context.getString(strOrResId)
                } else {
                    editText.error = strOrResId as String
                }
            }else{
                editText.error = null
            }
        }


        @BindingAdapter("focus")
        @JvmStatic
        fun setFocus(editText: EditText,onFocusChangeListener: View.OnFocusChangeListener?){
            if(onFocusChangeListener!=null)
                editText.setOnFocusChangeListener(onFocusChangeListener)
        }



    }





}