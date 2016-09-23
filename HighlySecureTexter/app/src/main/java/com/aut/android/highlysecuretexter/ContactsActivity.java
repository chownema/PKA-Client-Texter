package com.aut.android.highlysecuretexter;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.value;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button refreshButton;
    private ListView contactsListView;
    private ArrayAdapter<String> adapter;
    ArrayList<String> contactsList = new ArrayList<String>() {{
        add("012123123");
        add("012123123");
        add("012123123");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        // Init List view
        contactsListView = (ListView) findViewById(R.id.contacts_list_view);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactsList);
        contactsListView.setAdapter(adapter);


        // Init Buttons
        refreshButton = (Button) findViewById(R.id.refresh_contacts_button);
        refreshButton.setOnClickListener(this);

        // Init on click list
        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(getApplicationContext(), contactsList.get(position) + "CLICKED", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(ContactsActivity.this, MainActivity.class);
                myIntent.putExtra("key", value); //Optional parameters
                ContactsActivity.this.startActivity(myIntent);
            }
        });


    }


    private void populateContacts()
    {
        // Fill List view with contacts
    }

    @Override
    public void onClick(View view) {
        if (view == refreshButton)
        {
            Log.d("Refresh Contacts", "Refreshing...");
            Toast.makeText(getApplicationContext(), "Refreshing Contacts", Toast.LENGTH_SHORT).show();
        }
    }
}