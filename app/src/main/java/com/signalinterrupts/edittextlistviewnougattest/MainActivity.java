package com.signalinterrupts.edittextlistviewnougattest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.testListView);

        listView.setAdapter(new TestAdapter(this));
    }

    private class TestAdapter extends ArrayAdapter {
        public TestAdapter(Context context) {
            super(context, 0);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.row_edit_text, parent, false);
            }

            TextView title = (TextView) convertView.findViewById(R.id.textViewRow);
            title.setText("At " + position);

            int numberOfTypes = 4;

            EditText editText = (EditText) convertView.findViewById(R.id.editTextRow);
            if (position % numberOfTypes == 0) {
                editText.setRawInputType(InputType.TYPE_CLASS_PHONE);
                editText.setHint("Phone Number for " + position);
            } else if (position % numberOfTypes == 1) {
                editText.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                editText.setHint("Number for " + position);
            } else if (position % numberOfTypes == 2) {
                editText.setRawInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                editText.setHint("Email for " + position);
            } else {
                editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
                editText.setHint("Text for " + position);
            }

            return convertView;
        }

        @Override
        public int getCount() {
            return 20;
        }
    }
}
