package khanhnqph27525.fpoly.assignment_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;

public class HelloActivity extends AppCompatActivity {
    private Runnable runnable;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                    startActivity(new Intent(getBaseContext(), LoginActivity.class));
                    HelloActivity.this.finish();
            }
        },2000);
    }
}