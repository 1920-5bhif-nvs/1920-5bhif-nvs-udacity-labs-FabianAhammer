package at.htl.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import at.htl.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    public lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_btn).setOnClickListener {
            addNickname(it)
        }
    }
    private fun addNickname(view: View){
        var editText = findViewById<EditText>(R.id.nick_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nick_text)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


}
