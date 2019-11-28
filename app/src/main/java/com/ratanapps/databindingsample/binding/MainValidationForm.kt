package com.ratanapps.databindingsample.binding

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.ratanapps.databindingsample.R
import com.ratanapps.databindingsample.data.MoneySavedErrorField
import com.ratanapps.databindingsample.data.MoneySavedField

class MainValidationForm: BaseObservable()
{
    val moneySavedField:MoneySavedField = MoneySavedField()
    val moneySavedErrorField:MoneySavedErrorField = MoneySavedErrorField()


    @Bindable
    fun isValid():Boolean{
        val targetSaving = moneySavedField.targetSaving
        var targetValid: Boolean
        if(targetSaving!=null)
            targetValid = isTargetSavingValid()
        else
            targetValid = false

        val valid = isNumberOfCigratteValid() && isCostPerPackValid() && targetValid
        notifyPropertyChanged(BR.numOfCiggrateErr)
        notifyPropertyChanged(BR.costOfPackErr)
        notifyPropertyChanged(BR.targetErr)
        return valid
    }


    fun getMyTextWatcher() = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    fun isNumberOfCigratteValid():Boolean{
        val numOfCigrate:Int? = moneySavedField.numOfCiggrate?.toInt()
        if(!(numOfCigrate!=null&&numOfCigrate>0&&numOfCigrate<999)){
            moneySavedErrorField.numOfCiggrateErr = R.string.dashbrd_btm_sheet_numOfCigg_err
            notifyPropertyChanged(BR.valid)
            return false
        }else{
            moneySavedErrorField.numOfCiggrateErr = null
            notifyPropertyChanged(BR.valid)
            return true
        }
    }

    fun isCostPerPackValid():Boolean{
        val costPerPack:Int? = moneySavedField.costOfPack?.toInt()
        if(!(costPerPack!=null && costPerPack>0&& costPerPack<999)){
            moneySavedErrorField.costOfPackErr = R.string.dashbrd_btm_sheet_costOfPack_err
            notifyPropertyChanged(BR.valid)
            return false
        }else{
            moneySavedErrorField.costOfPackErr = null
            notifyPropertyChanged(BR.valid)
            return true
        }
    }


    fun isTargetSavingValid():Boolean{
        val targetSaving:Int? = moneySavedField.targetSaving?.toInt()
        if(!(targetSaving!=null && targetSaving>0&& targetSaving<99999)){
            moneySavedErrorField.targetErr = R.string.dashbrd_btm_sheet_targetprice_err
            notifyPropertyChanged(BR.valid)
            return false
        }else{
            moneySavedErrorField.targetErr = null
            notifyPropertyChanged(BR.valid)
            return true
        }
    }




    fun getBottomSheetField() = moneySavedField


    @Bindable
    fun getNumOfCiggrateErr() = moneySavedErrorField.numOfCiggrateErr

    @Bindable
    fun getCostOfPackErr() = moneySavedErrorField.costOfPackErr

    @Bindable
    fun getTargetErr() = moneySavedErrorField.targetErr


}