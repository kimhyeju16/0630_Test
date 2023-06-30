package com.example.a0630_test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>todolist;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist);

        todolist = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.todlist_item, todolist);
        listView = findViewById(R.id.list_view);
        editText = findViewById(R.id.edit_text);

        listView.setAdapter(adapter);

        Button addbtn = findViewById(R.id.btn_add);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItemToList();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
    }
    public void addItemToList(){
        todolist.add(editText.getText().toString());

        adapter.notifyDataSetChanged();
        editText.setText(" ");
    }
}