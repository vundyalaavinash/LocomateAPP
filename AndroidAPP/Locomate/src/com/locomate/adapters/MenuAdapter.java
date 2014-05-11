package com.locomate.adapters;

import java.util.List;

import com.locomate.R;
import com.locomate.listitems.MenuListItem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<MenuListItem> {
	
	Context context;
	
	public MenuAdapter(Context context, int resourceId,
            List<MenuListItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }
	
	/*private view holder class*/
    private class ViewHolder {
        TextView txtTitle;
        ImageView imageView;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        MenuListItem rowItem = getItem(position);        
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listltem_menu, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }
        	System.out.println(rowItem.getTitle());
        	System.out.println(convertView);
	        holder.txtTitle.setText(rowItem.getTitle());	
	        holder.imageView.setImageResource(rowItem.getImage()); 
	        
        return convertView;
    }
}