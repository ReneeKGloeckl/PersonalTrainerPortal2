package com.bignerdranch.android.personaltrainerportal2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;




public class ClientListActivity extends AppCompatActivity {
    private static final String TAG = "ClientListActivity";

    ContactsTable contactsTable;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        contactsTable = new ContactsTable(getApplicationContext());
        contactsTable.openDB();
        cursor = contactsTable.getAllRecords();

        ListView listview = (ListView)findViewById(R.id.lvList);

        CustomAdapter customAdapter = new CustomAdapter();
        listview.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return cursor.getCount();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_layout,null);
            TextView tv_id = (TextView)view.findViewById(R.id.tv_id);
            TextView tv_cname = (TextView)view.findViewById(R.id.tv_cname);
            TextView tv_caddress = (TextView)view.findViewById(R.id.tv_caddress);
            TextView tv_cphone = (TextView)view.findViewById(R.id.tv_cphone);

            cursor.moveToPosition(i);
            tv_id.setText(cursor.getString(0));
            tv_cname.setText(cursor.getString(1));
            tv_caddress.setText(cursor.getString(2));
            tv_cphone.setText(cursor.getString(3));

            return view;
        }
    }

}
