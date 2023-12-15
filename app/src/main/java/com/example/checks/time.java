package com.example.checks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Date;
public class time extends Activity implements View.OnClickListener {
    Button button;
    Button btn;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_time);
        String selectedItem = getIntent().getStringExtra("selectedItem");

        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
        updateTime();
    }
    public void onClick(View view) {
        updateTime();
    }
    private void updateTime() {
        btn.setText(new Date().toString());
    }

    public void metodoOn(View theButton) {
// do something useful here
    }

}