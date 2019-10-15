package at.htl.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollBtn: Button = findViewById(R.id.roll_button)
        rollBtn.text= "Lets Roll";
        rollBtn.setOnClickListener{
            Toast.makeText(this,"Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
