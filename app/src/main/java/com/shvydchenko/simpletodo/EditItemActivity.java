package com.shvydchenko.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String currentItem = getIntent().getStringExtra("current_text");
        EditText etEdit = (EditText)findViewById(R.id.etEdit);
        etEdit.setText(currentItem, TextView.BufferType.EDITABLE);
        etEdit.setSelection(etEdit.getText().length());
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    public void onSave(View v) {
        EditText etEdit = (EditText)findViewById(R.id.etEdit);
        Intent data = new Intent();
        data.putExtra("new_text", etEdit.getText().toString());
        data.putExtra("pos", getIntent().getIntExtra("pos", 0));
        setResult(RESULT_OK, data);
        finish();
    }
}
