package com.example.android.quakereport;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
 * {@link EarthQuakeAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link EarthQuakeAdapter} objects.
 * */
public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context     The current context. Used to inflate the layout file.
     * @param earthquakes A list of Place objects to display
     */
    public EarthQuakeAdapter(Activity context, ArrayList<EarthQuake> earthquakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews , the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link EarthQuake} object located at this position in the list
        EarthQuake currentEarthQuake = getItem(position);

        // Find the TextView in the list_item.xml layout which displays the magnitude
        // information
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // set the currentEarthQuake's magnitude in this mainTextView
        magnitudeTextView.setText(String.valueOf(currentEarthQuake.getMagnitude()));

        // Find the TextView in the list_item.xml layout which displays the place
        // information
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place);
        // set the currentEarthQuake's place on this TextView
        placeTextView.setText(currentEarthQuake.getPlace());

        // Find the TextView in the list_item.xml layout which displays the time
        // information
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        // set the currentEarthQuake's time on this TextView
        timeTextView.setText(currentEarthQuake.getDate());

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}