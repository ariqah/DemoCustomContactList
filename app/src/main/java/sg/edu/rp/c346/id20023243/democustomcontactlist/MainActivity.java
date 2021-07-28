package sg.edu.rp.c346.id20023243.democustomcontactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ArrayList<Contact> alContactList;
    CustomAdapter caContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.listViewContacts);
        alContactList = new ArrayList<Contact>();
        Contact c1 = new Contact("Mary", 65, 1234567, 'F');
        Contact c2 = new Contact("Ken", 65, 7654321, 'M');
        Contact c3 = new Contact("Jenny", 65, 1243567,'Z');
        alContactList.add(c1);
        alContactList.add(c2);
        alContactList.add(c3);

        caContact = new CustomAdapter(MainActivity.this, R.layout.row, alContactList);
        lvContact.setAdapter(caContact);
    }
}