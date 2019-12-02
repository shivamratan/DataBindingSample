package com.ratanapps.databindingsample.binding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.ratanapps.databindingsample.BR
import com.ratanapps.databindingsample.R
import com.ratanapps.databindingsample.data.AccountErrorField
import com.ratanapps.databindingsample.data.AccountField

class MainValidationForm: BaseObservable()
{
    val myAccountField:AccountField = AccountField()
    val accountErrorField:AccountErrorField = AccountErrorField()


    @Bindable
    fun isValid():Boolean{
        val targetSaving = myAccountField.targetSaving
        var targetValid: Boolean
        if(targetSaving!=null)
            targetValid = isTargetSavingValid()
        else
            targetValid = false

        val valid = isNameValid() && isProfessionValid() && targetValid
        notifyPropertyChanged(BR.nameOfPersonErr)
        notifyPropertyChanged(BR.professionErr)
        notifyPropertyChanged(BR.targetSavingErr)
        return valid
    }

    fun isNameValid():Boolean{
        val nameOfPerson:String? = myAccountField.nameOfPerson
        if(!(nameOfPerson!=null&&!nameOfPerson.isEmpty()&&nameOfPerson.length<999)){
            accountErrorField.nameOfPersonErr = R.string.account_person_err
           // notifyPropertyChanged(BR.nameOfPersonErr)
            notifyPropertyChanged(BR.valid)
            return false
        }else{
            accountErrorField.nameOfPersonErr = null
           // notifyPropertyChanged(BR.nameOfPersonErr)
            notifyPropertyChanged(BR.valid)
            return true
        }
    }

    fun isProfessionValid():Boolean{
        val profession:String? = myAccountField.profession
        if(!(profession!=null && !profession.isEmpty())){
            accountErrorField.professionErr = R.string.account_profession_err
          //  notifyPropertyChanged(BR.professionErr)
            notifyPropertyChanged(BR.valid)
            return false
        }else{
            accountErrorField.professionErr = null
          //  notifyPropertyChanged(BR.professionErr)
            notifyPropertyChanged(BR.valid)
            return true
        }
    }


    fun isTargetSavingValid():Boolean{
        val targetSaving:String? = myAccountField.targetSaving
        if(!(targetSaving!=null && !targetSaving.isEmpty())){
            accountErrorField.targetSavingErr = R.string.account_targetSaving_err
           // notifyPropertyChanged(BR.targetSavingErr)
            notifyPropertyChanged(BR.valid)
            return false
        }else{

            val mytargetSaving:Long = targetSaving.toLong()
           if(mytargetSaving<9999||mytargetSaving>10_00_00000L){
               accountErrorField.targetSavingErr = R.string.account_targetSaving_less9999_err
              // notifyPropertyChanged(BR.targetSavingErr)
               notifyPropertyChanged(BR.valid)
               return false
           }else {
               accountErrorField.targetSavingErr = null
              // notifyPropertyChanged(BR.targetSavingErr)
               notifyPropertyChanged(BR.valid)
               return true
           }
        }
    }



    fun notifyPersonPropertyChanged() = notifyPropertyChanged(BR.nameOfPersonErr)
    fun notifyProfessionPropertyChanged() = notifyPropertyChanged(BR.professionErr)
    fun notifyTargetSavingChanged() = notifyPropertyChanged(BR.targetSavingErr)

    fun getAccountField() = myAccountField


    @Bindable
    fun getNameOfPersonErr() = accountErrorField.nameOfPersonErr

    @Bindable
    fun getProfessionErr() = accountErrorField.professionErr

    @Bindable
    fun getTargetSavingErr() = accountErrorField.targetSavingErr


}