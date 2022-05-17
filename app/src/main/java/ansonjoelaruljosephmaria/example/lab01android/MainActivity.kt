package ansonjoelaruljosephmaria.example.lab01android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity(), ConfirmDialogFragment.SendMessages  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.text)
        tv.text = "Anson Joel"

        // Watch for button clicks.
        val button = findViewById<Button>(R.id.show)
        button.setOnClickListener { showDialog() }

        val button1 = findViewById<Button>(R.id.button)
        button1.setOnClickListener { showInstructions() }
    }

    fun showInstructions() {
        val intent = Intent(this, MainActivity2::class.java).apply {
        }
        startActivity(intent)
    }

    fun showDialog() {
        val newFragment: DialogFragment? = ConfirmDialogFragment
            .newInstance(R.string.alert_dialog_two_buttons_title)
        newFragment!!.show(supportFragmentManager, "dialog")
    }

    fun doPositiveClick() {
        Log.i("ConfirmDialogFragment", "Positive click!")
    }

    fun doNegativeClick() {
        Log.i("ConfirmDialogFragment", "Negative click!")
    }

    override fun choiceMade(msg: String?) {
        val tvChoices = findViewById<TextView>(R.id.tvMessage)
        tvChoices.text = "My choice is: $msg"
    }
}