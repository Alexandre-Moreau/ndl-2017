package com.example.joffrey.tmel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by joffrey on 16/10/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private JSONArray jArray;

    public ListViewAdapter(Context context, int layout, JSONArray jArray) {
        this.context = context;
        this.layout = layout;
        this.jArray = jArray;
    }

    @Override
    public int getCount() {
        return jArray.length();
    }

    @Override
    public JSONArray getItem(int position) {
        try {
            return (JSONArray) jArray.get(position);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView tvTitreElement;
        TextView tvDetailsElements;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = new ViewHolder();

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.tvTitreElement = (TextView) row.findViewById(R.id.tvTitreElement);
            holder.tvDetailsElements = (TextView) row.findViewById(R.id.tvDetailsElements);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        try {
            holder.tvTitreElement.setText(jArray.getJSONObject(position).getString("Titre"));
            holder.tvDetailsElements.setText(jArray.getJSONObject(position).getString("Details"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return row;
    }

}
