package com.alhussein.gts

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.coroutines.NonCancellable.cancel


class BannerFragment : DialogFragment() {

//    /** The system calls this to get the DialogFragment's layout, regardless
//    of whether it's being displayed as a dialog or an embedded fragment. */
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        // Inflate the layout to use as dialog or embedded fragment
//        return inflater.inflate(R.layout.purchase_items, container, false)
//    }
//
//    /** The system calls this only when creating the layout in a dialog. */
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        // The only reason you might override this method when using onCreateView() is
//        // to modify any dialog characteristics. For example, the dialog includes a
//        // title by default, but your custom layout might not need it. So here you can
//        // remove the dialog title, but you must call the superclass to get the Dialog.
//        val dialog = super.onCreateDialog(savedInstanceState)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        return dialog
//    }

}