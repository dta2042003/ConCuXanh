package com.example.triolingo_mobile;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.triolingo_mobile.DAO.UserDAO;
import com.example.triolingo_mobile.Model.UserEntity;
import com.example.triolingo_mobile.Model.UserNote;
import com.google.gson.Gson;

public class IntroStep2Activity extends AppCompatActivity {

    private Button continueButton;
    private ImageView backButton;
    private TextView chatBubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_step2);

        continueButton = findViewById(R.id.continueButton);
        backButton = findViewById(R.id.backButton);
        chatBubble = findViewById(R.id.chatBubble);

        // Gán đoạn chat với phần chữ đậm
        String htmlText = "Chỉ cần trả lời <b>2 câu hỏi</b> nhanh thôi, rồi mình bắt đầu bài học đầu tiên nhé!";
        chatBubble.setText(Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY));

        continueButton.setOnClickListener(v -> {
            startActivity(new Intent(IntroStep2Activity.this, SelectLanguageActivity.class));
            finish();
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(IntroStep2Activity.this, IntroActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }
}
