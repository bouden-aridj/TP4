package com.example.tp4;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void sendReview(View view) {
        EditText productName = findViewById(R.id.productName);
        EditText commentEditText = findViewById(R.id.commentEditText);

        String product = productName.getText().toString().trim();
        String comment = commentEditText.getText().toString().trim();

        if (product.isEmpty()) {
            productName.setError("Product name is required");
            productName.requestFocus();
            return;
        }

        if (comment.length() <= 20 || comment.length() >= 60) {
            commentEditText.setError("Comment must be between 21 and 59 characters");
            commentEditText.requestFocus();
            return;
        }

        Toast.makeText(this,
                "Thank you for giving your feedback",
                Toast.LENGTH_LONG).show();
    }
}