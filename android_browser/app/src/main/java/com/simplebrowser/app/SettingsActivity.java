package com.simplebrowser.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity {
    
    private SharedPreferences sharedPreferences;
    private EditText customHomepageEditText;
    private Spinner homepageSpinner;
    private Spinner colorThemeSpinner;
    private Button saveButton;
    
    // Homepage presets
    private final String[] homepageOptions = {
        "Google", "DuckDuckGo", "Bing", "Yahoo", "Custom"
    };
    
    private final String[] homepageUrls = {
        "https://www.google.com",
        "https://duckduckgo.com",
        "https://www.bing.com", 
        "https://www.yahoo.com",
        ""
    };
    
    // Color theme options
    private final String[] colorThemes = {
        "Blue (Default)", "Green", "Purple", "Orange", "Red", "Dark"
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        
        setupToolbar();
        initializeViews();
        loadCurrentSettings();
        setupListeners();
    }
    
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Settings");
        }
    }
    
    private void initializeViews() {
        sharedPreferences = getSharedPreferences("BrowserSettings", MODE_PRIVATE);
        
        customHomepageEditText = findViewById(R.id.custom_homepage_edit_text);
        homepageSpinner = findViewById(R.id.homepage_spinner);
        colorThemeSpinner = findViewById(R.id.color_theme_spinner);
        saveButton = findViewById(R.id.save_button);
        
        // Setup spinners
        ArrayAdapter<String> homepageAdapter = new ArrayAdapter<>(this, 
            android.R.layout.simple_spinner_item, homepageOptions);
        homepageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        homepageSpinner.setAdapter(homepageAdapter);
        
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_item, colorThemes);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorThemeSpinner.setAdapter(colorAdapter);
    }
    
    private void loadCurrentSettings() {
        // Load homepage setting
        String currentHomepage = sharedPreferences.getString("homepage_url", "https://www.google.com");
        String customUrl = sharedPreferences.getString("custom_homepage", "");
        
        // Find matching preset or set to custom
        int homepageIndex = 0;
        for (int i = 0; i < homepageUrls.length - 1; i++) {
            if (homepageUrls[i].equals(currentHomepage)) {
                homepageIndex = i;
                break;
            }
        }
        
        // If no preset matches, it's custom
        if (homepageIndex == 0 && !homepageUrls[0].equals(currentHomepage)) {
            homepageIndex = homepageUrls.length - 1; // Custom option
            customHomepageEditText.setText(currentHomepage);
        } else if (!customUrl.isEmpty()) {
            customHomepageEditText.setText(customUrl);
        }
        
        homepageSpinner.setSelection(homepageIndex);
        updateCustomHomepageVisibility();
        
        // Load color theme
        String currentTheme = sharedPreferences.getString("color_theme", "Blue (Default)");
        for (int i = 0; i < colorThemes.length; i++) {
            if (colorThemes[i].equals(currentTheme)) {
                colorThemeSpinner.setSelection(i);
                break;
            }
        }
    }
    
    private void setupListeners() {
        homepageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateCustomHomepageVisibility();
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        
        saveButton.setOnClickListener(v -> saveSettings());
    }
    
    private void updateCustomHomepageVisibility() {
        int selectedPosition = homepageSpinner.getSelectedItemPosition();
        boolean isCustom = selectedPosition == homepageOptions.length - 1;
        customHomepageEditText.setVisibility(isCustom ? View.VISIBLE : View.GONE);
    }
    
    private void saveSettings() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        
        // Save homepage setting
        int homepageIndex = homepageSpinner.getSelectedItemPosition();
        String homepageUrl;
        
        if (homepageIndex == homepageOptions.length - 1) {
            // Custom homepage
            homepageUrl = customHomepageEditText.getText().toString().trim();
            if (homepageUrl.isEmpty()) {
                Toast.makeText(this, "Please enter a custom homepage URL", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!homepageUrl.startsWith("http://") && !homepageUrl.startsWith("https://")) {
                homepageUrl = "https://" + homepageUrl;
            }
            editor.putString("custom_homepage", homepageUrl);
        } else {
            homepageUrl = homepageUrls[homepageIndex];
            editor.putString("custom_homepage", "");
        }
        
        editor.putString("homepage_url", homepageUrl);
        editor.putString("homepage_name", homepageOptions[homepageIndex]);
        
        // Save color theme
        String selectedTheme = colorThemes[colorThemeSpinner.getSelectedItemPosition()];
        editor.putString("color_theme", selectedTheme);
        
        editor.apply();
        
        Toast.makeText(this, "Settings saved! Restart the app to see color changes.", Toast.LENGTH_LONG).show();
        finish();
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}