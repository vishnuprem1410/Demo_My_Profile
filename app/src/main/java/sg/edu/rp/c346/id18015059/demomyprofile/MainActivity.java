package sg.edu.rp.c346.id18015059.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etGPA;
    private RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName =(EditText)findViewById(R.id.etName);
        etGPA =(EditText)findViewById(R.id.etGpa);
        rgGender=(RadioGroup)findViewById(R.id.genderradio);
    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float GPA = Float.valueOf(etGPA.getText().toString());

        int intGenderId = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("Name", strName);
        prefEdit.putFloat("GPA", GPA);
        prefEdit.putInt("genderId", intGenderId);

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String msg = prefs.getString("Name", "No name!");
        Float gpa = prefs.getFloat("GPA", 0);
        int intGenderId = prefs.getInt("genderId",R.id.malebtn);
        etName.setText(msg);
        String GpA = gpa.toString();
        etGPA.setText(GpA);
        rgGender.check(intGenderId);
    }

    public void btnSave (View view){
        String strName = etName.getText().toString();
        float GPA = Float.valueOf(etGPA.getText().toString());

        int intGenderId = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("Name", strName);
        prefEdit.putFloat("GPA", GPA);
        prefEdit.putInt("genderId", intGenderId);

        prefEdit.commit();
    }
}