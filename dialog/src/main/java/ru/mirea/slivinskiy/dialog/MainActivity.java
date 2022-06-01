package ru.mirea.slivinskiy.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMyDateDialogFragment(View view) {
        MyDateDialogFragment datePicker = new MyDateDialogFragment();
        datePicker.show(getSupportFragmentManager(), "date picker");
    }

    public void onClickShowDialog(View view) {
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }

    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }

    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }


    public void onClickMyTimeDialogFragment(View view) {
        MyTimeDialogFragment timedialog = new MyTimeDialogFragment();
        timedialog.show(getSupportFragmentManager(), "time picker");
    }


    MyProgressDialogFragment loadingDialogBar;

    public void onClickMyProgressDialogFragment(View view) {
        loadingDialogBar = new MyProgressDialogFragment(this);
        loadingDialogBar.ShowDialog("Loading");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Hour: " + hourOfDay + " Minute: " + minute);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar Date = Calendar.getInstance();
        Date.set(Calendar.YEAR, year);
        Date.set(Calendar.MONTH, month);
        Date.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(Date.getTime());

        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(currentDateString);
    }


}
