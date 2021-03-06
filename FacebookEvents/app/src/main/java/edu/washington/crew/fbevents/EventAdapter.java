package edu.washington.crew.fbevents;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventAdapter extends ArrayAdapter<FbEvent> {
    public EventAdapter(Context context, ArrayList<FbEvent> events) {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        FbEvent event = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_item, parent, false);
        }
        // Lookup view for data population
        TextView eventName = (TextView) convertView.findViewById(R.id.event_name);
        TextView startTime = (TextView) convertView.findViewById(R.id.event_time);
        TextView location = (TextView) convertView.findViewById(R.id.event_location);
        // Populate the data into the template view using the data object
        eventName.setText(event.eventName);
        startTime.setText(event.startTime);
        // location.setText(event.location[0]);
        // Return the completed view to render on screen
        return convertView;
    }
}