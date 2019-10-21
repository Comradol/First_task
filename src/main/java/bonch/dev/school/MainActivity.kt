package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import bonch.dev.school.models.Counter
import bonch.dev.school.models.IndicatorButton
import android.content.Intent
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var counterButton: Button
    private lateinit var counterTextView: TextView
    private lateinit var counter: Counter
    private lateinit var nextActivityButton: Button
    private lateinit var indicatorButton: Button
    private lateinit var editorText: EditText
    private lateinit var indicatorButtonLogic: IndicatorButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstactivity)
        initializeViews()
        if(savedInstanceState==null){
            counter = Counter()
            indicatorButtonLogic = IndicatorButton()
        } else {
            counter = Counter(savedInstanceState.getInt("TAP_AMOUNTS"))
            indicatorButtonLogic = IndicatorButton(savedInstanceState.getBoolean("LOGIC_AMOUNT"))
        }
        counterTextView.text = "Counter was tapped ${counter.currentCounter} times"

        //counter=Counter()
        setListeners()
    }

    private fun initializeViews(){
        counterButton=findViewById(R.id.counter_button)
        counterTextView=findViewById(R.id.counter_text_view)
        nextActivityButton=findViewById(R.id.next_activity_button)
        indicatorButton=findViewById(R.id.indicator_button)
        editorText=findViewById(R.id.text_field)
    }
   // private fun initializeCounter(){
      //  counter=Counter()
   // }
  private fun setListeners(){
    counterButton.setOnClickListener(){
    counter.increment()

    counterTextView.text="Button was tapped ${counter.currentCounter} times"
}
       indicatorButton.setOnClickListener() {
           indicatorButtonLogic.negative()
       }
       nextActivityButton.setOnClickListener() {
        val intent=Intent(this@MainActivity, SecondActivity::class.java)

           intent.putExtra("COUNTER_KEY",counter.currentCounter)
           intent.putExtra("INDICATOR_KEY", indicatorButtonLogic.currentIndicator)
           intent.putExtra("TEXT_EDITOR_KEY", editorText.getText().toString())

            startActivity(intent)

       }

  }




    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_AMOUNTS", counter.currentCounter)
        outState.putString("USER_ENTER_TEXT", editorText.getText().toString())
        outState.putBoolean("LOGIC_AMOUNT",indicatorButtonLogic.currentIndicator)
    }


}
