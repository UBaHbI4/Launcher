package softing.ubah4ukdev.launcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    AppCompatSpinner spinner;
    TextInputEditText arg1;
    TextInputEditText arg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        arg1 = findViewById(R.id.argumentOne);
        arg2 = findViewById(R.id.argumentTwo);

        findViewById(R.id.btnRunCalc).setOnClickListener(v -> {
            try {
                Intent intent = new Intent();
                Uri uri = Uri.parse("example://calc");
                Intent runEchoIntent = new Intent(Intent.ACTION_VIEW, uri);
                runEchoIntent.putExtra("arg1", Double.valueOf(arg1.getText().toString()));
                runEchoIntent.putExtra("arg2", Double.valueOf(arg2.getText().toString()));
                String op = (String) spinner.getItemAtPosition(spinner.getSelectedItemPosition());
                runEchoIntent.putExtra("operation",op);
                runEchoIntent.putExtra("inputText", arg1.getText() + " " + op + " " + arg2.getText());
                startActivity(runEchoIntent);
            } catch (Exception err) {
                Log.e("launcher", err.getMessage());
            }

        });
    }
}