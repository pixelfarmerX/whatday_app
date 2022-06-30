package androidsamples.java.whatday;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  public EditText dateBar;
  public EditText monthBar;
  public EditText yearBar;
  public Button checkBtn;
  public TextView displayBar;

  public String year, month, date;

  public String message;

  /**
   *
   * @param savedInstanceState - Saved Instance State Bundle
   */

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    dateBar = findViewById(R.id.editDate);
    monthBar = findViewById(R.id.editMonth);
    yearBar = findViewById(R.id.editYear);

    checkBtn = findViewById(R.id.btn_check);

    displayBar = findViewById(R.id.txt_display);

    checkBtn.setOnClickListener(v -> {
      year = yearBar.getText().toString();
      month = monthBar.getText().toString();
      date = dateBar.getText().toString();

      DateModel datemodel = new DateModel(year,month,date);
      message = datemodel.getMessage();
      displayBar.setText(message);
    });
  }
}