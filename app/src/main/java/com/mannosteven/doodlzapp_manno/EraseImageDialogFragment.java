//On my honor, I have neither received nor given any unauthorized assistance on Assignment 4
//EraseImageDialogFragment.java
//Allows user to erase image
package com.mannosteven.doodlzapp_manno;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

//class for the Erase Image Dialog
public class EraseImageDialogFragment extends DialogFragment {

    //create an AlertDialog and return it
    @Override
    public Dialog onCreateDialog(Bundle bundle){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        //set the AlertDialog's message
        builder.setMessage(R.string.button_erase);
        //add Erase Button
        builder.setPositiveButton(R.string.button_erase,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDoodleFragment().getDoodleView().clear(); //clear image
                    }
                });
        //add cancel button
        builder.setNegativeButton(android.R.string.cancel, null);
        return builder.create(); //return dialog
    }

    //get a reference to the MainActivityFragment
    private MainActivityFragment getDoodleFragment(){
        return (MainActivityFragment) getFragmentManager().findFragmentById(
                R.id.doodleFragment);
    }

    //tell MainActivityFragment that dialog is now displayed
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        MainActivityFragment fragment = getDoodleFragment();

        if(fragment != null)
            fragment.setDialogOnScreen(true);
    }

    //tell MainActivityFragment that dialog is no longer displayed
    public void onDetach(){
        super.onDetach();
        MainActivityFragment fragment = getDoodleFragment();

        if(fragment != null)
            fragment.setDialogOnScreen(false);
    }

}
