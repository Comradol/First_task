package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import bonch.dev.school.models.Counter

class SecondActivity : AppCompatActivity() {
private lateinit var textViewForSecondActivity: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondactivity)
        textViewForSecondActivity=findViewById(R.id.text_view_second)
        //initializeSecondViews()
        val counterValue=intent.getIntExtra("COUNTER_KEY", 0)
        val indicatorValue=intent.getBooleanExtra("INDICATOR_KEY", false)
        val textEditorValue=intent.getStringExtra("TEXT_EDITOR_KEY")
        textViewForSecondActivity.text="Indicator was tapped: ${indicatorValue}; Counter was tapped: ${counterValue}; Entered text:${textEditorValue}"
    }
}

