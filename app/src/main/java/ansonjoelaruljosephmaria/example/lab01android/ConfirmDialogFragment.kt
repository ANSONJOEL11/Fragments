package ansonjoelaruljosephmaria.example.lab01android

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val checkedItem = 1
var Levels = arrayOf("Level 1", "Level 2", "Level 3", "Level 4")


/**
 * A simple [Fragment] subclass.
 * Use the [ConfirmDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class ConfirmDialogFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var sendMessages: SendMessages? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ConfirmDialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        open fun newInstance(title: Int): ConfirmDialogFragment? {
            val fragment = ConfirmDialogFragment()
            val args = Bundle()
            args.putInt("title", title)
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments!!.getInt("title")
        return AlertDialog.Builder(activity)
            .setTitle(title)
            .setSingleChoiceItems(Levels, checkedItem,
                DialogInterface.OnClickListener { dialog, which ->
                    sendMessages!!.choiceMade(Levels[which])
                })
            .setPositiveButton(R.string.alert_dialog_ok,
                DialogInterface.OnClickListener { dialog, whichButton ->
                    (activity as MainActivity?)
                        ?.doPositiveClick()
                })
            .setNegativeButton(R.string.alert_dialog_cancel,
                DialogInterface.OnClickListener { dialog, whichButton ->
                    (activity as MainActivity?)
                        ?.doNegativeClick()
                }).create()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        sendMessages = context as SendMessages
    }

    //Interface - send message from this fragment to main activity
    internal interface SendMessages {
        fun choiceMade(msg: String?)
    }
}