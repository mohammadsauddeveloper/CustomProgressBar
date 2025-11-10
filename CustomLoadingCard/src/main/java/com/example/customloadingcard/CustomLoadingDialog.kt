package com.example.customloadingcard

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CustomLoadingDialog(val context: Context) {
        private var dialog: Dialog? = null

        fun showCustomDialog(text:String="Loading....",setCancelable: Boolean,loadingIconVisible:Boolean,drawables:Int = R.drawable.loading_dialog_bg){
            if (dialog?.isShowing == true) return

            //if(dialog?.isShowing == true) return

            val view = LayoutInflater.from(context).inflate(R.layout.loading_dialog,null)
            val loadingIcon = view.findViewById<ProgressBar>(R.id.progressBar)
            val bgChange = view.findViewById<LinearLayout>(R.id.bg_change)
            bgChange.background = context.getDrawable(drawables)
            loadingIcon.visibility = if(loadingIconVisible) View.VISIBLE else View.GONE

            val id = view.findViewById<TextView>(R.id.tvLoading)
            id.text = text
            dialog = Dialog(context).apply {
                setContentView(view)
                setCancelable(setCancelable)
                setCanceledOnTouchOutside(setCancelable)
                window?.setBackgroundDrawableResource(android.R.color.transparent)
                window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                )
                show()
            }
        }

        fun hide(){
            dialog?.dismiss()
            dialog = null
        }

    }