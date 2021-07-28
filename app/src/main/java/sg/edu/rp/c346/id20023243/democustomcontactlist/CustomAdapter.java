package sg.edu.rp.c346.id20023243.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context; //mainActivity
    int layout_id; //to store id for row.xml
    ArrayList<Contact> contactList;

    public CustomAdapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        contactList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //getting tools needed to inflate
        View rowView = inflater.inflate(layout_id, parent, false);
        //last parameter is ALWAYS false
        //inflate/convert from row.xml layout file into code which is view object;
        //so that can make changes to it and make use of it
        //parent --> put code under parent; which is listView
        //with t
        TextView tvName = rowView.findViewById(R.id.textViewName); //rowview refers to the extracted row from layout
        TextView tvCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvNum = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);

        Contact currentItem = contactList.get(position); //position --> index
        //get contact object from arrList of contact objects
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode()); //" use + to change int to string"
        tvNum.setText(currentItem.getPhoneNum()+"");
        if (currentItem.getGender()=='F'|| currentItem.getGender()=='f') {
            ivGender.setImageResource(R.drawable.female);
        }
        else if (currentItem.getGender()=='M'|| currentItem.getGender()=='m') {
            ivGender.setImageResource(R.drawable.male);
        }
        else {
            ivGender.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }

}
