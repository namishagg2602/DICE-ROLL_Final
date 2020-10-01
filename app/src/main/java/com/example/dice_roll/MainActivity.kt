package com.example.dice_roll

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val headtext: TextView = findViewById(R.id.textView2)
        headtext.setText("Dice Roller")

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
             val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
             toast.show()

              diceRoll()
            }

        }
/*
    var speaktext : TextToSpeech? = null
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(
        requestCode: Int, resultCode: Int, data: Intent?
    ) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                speaktext = TextToSpeech(this, this)
            } else {
                // missing data, install it
                val installIntent = Intent()
                installIntent.action = TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA
                startActivity(installIntent)
            }
        }
    }

    speaktext.isLanguageAvailable(Locale.UK))

*/

    private fun diceRoll() {
        val dice1 = Dice(6)
        val dicenum: Int = dice1.roll()
        //  This is code to display the rolled number on screen
       // val rtext: TextView = findViewById(R.id.textView)
       // rtext.text = dicenum.toString()

        // Code to update the image once dice is rolled
        val diceimage: ImageView=findViewById(R.id.imageView)

        val rolldiceid = when(dicenum)
        {
           1-> R.drawable.dice_1
           2-> R.drawable.dice_2
           3-> R.drawable.dice_3
           4-> R.drawable.dice_4
           5-> R.drawable.dice_5
           else-> R.drawable.dice_6
        }
       diceimage.setImageResource(rolldiceid)
        diceimage.contentDescription=dicenum.toString()
        //    speaktext.speak("hello", TextToSpeech.QUEUE_ADD, null);
    }


    fun sendMessage(view: View)
    {
        val message = "Welcome"
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}



/*   dice class */
class Dice(private val x: Int)
{
    fun roll() : Int
    {
        return (1..x).random()
    }
}