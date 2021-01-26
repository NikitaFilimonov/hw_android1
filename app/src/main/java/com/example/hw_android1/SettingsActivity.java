package com.example.hw_android1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends AppCompatActivity {

    private static final String NameSharedPreference = "LOGIN";

    private static final String AppTheme = "APP_THEME";

    private static final int MainThemeCodeStyle = 0;
    private static final int DarkThemeCodeStyle = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.Main_Theme));
        setContentView(R.layout.activity_settings);

//        initializeViewVariables();
    }

        private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonMainTheme),
                MainThemeCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonDarkTheme),
                DarkThemeCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(MainThemeCodeStyle))).setChecked(true);
    }
    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);
                recreate();
            }
        });
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case DarkThemeCodeStyle:
                return R.style.AppThemeDark;
            default:
                return R.style.Main_Theme;
        }
    }

}