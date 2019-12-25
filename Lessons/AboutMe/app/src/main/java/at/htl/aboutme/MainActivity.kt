package at.htl.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import at.htl.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    public lateinit var  binding: ActivityMainBinding
    private val myName: MyName = MyName("Fabian Ahammer")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneBtn.setOnClickListener {
            addNickname(it)
        }
    }
    private fun addNickname(view: View){
        binding.apply {
            myName?.nickname = nickEdit.text.toString()
            invalidateAll()

            nickEdit.visibility = View.GONE
            doneBtn.visibility = View.GONE
            nickText.visibility = View.VISIBLE

            // Hide the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


}
data class MyName(var name: String = "", var nickname: String = "")
