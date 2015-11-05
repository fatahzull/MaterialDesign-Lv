package androidhive.info.materialdesign.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import androidhive.info.materialdesign.R;

public class LazyAdapterPakej extends BaseAdapter{
    
    private Activity activity;
    private static LayoutInflater inflater=null;
//    public ImageLoaderHD imageLoader; 

    int[] img = {R.drawable.pkj1,R.drawable.pkj2,R.drawable.pkj3,R.drawable.pkj4,R.drawable.pkj5};
    String[] title = {"Item 1","Item 2","Item 3","Item 4","Item 5"};
    String[] sub_title = {"Rm 130.00","Rm 130.00","Rm 130.00","Rm 130.00","Rm 130.00"};
    
    public LazyAdapterPakej(Activity a, ArrayList<HashMap<String, String>> data) {
        activity = a;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        imageLoader=new ImageLoaderHD(activity.getApplicationContext());
    }

    
    public int getCount() {
    	return title.length;
    }

    public Object getItem(int position) {
    	return title[position];
    }

    public long getItemId(int position) {
    	return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi=convertView;

    	ViewHolder holder;

    	if(vi==null){

    		vi = inflater.inflate(R.layout.lv_row_deal, null);

            holder = new ViewHolder();

			holder.title = (TextView)vi.findViewById(R.id.name); // title
			holder.id = (TextView)vi.findViewById(R.id.id); // title
            holder.pay_tv = (TextView)vi.findViewById(R.id.pay_tv); // title
            holder.pay_img = (ImageView)vi.findViewById(R.id.pay_img); // title
			holder.thumb_image=(ImageView)vi.findViewById(R.id.coverImg); // thumb image
			holder.txtViewEx = (TextView) vi.findViewById(R.id.short_des);

            vi.setTag(holder);

    	}
    	else{
    		holder = (ViewHolder) vi.getTag(); // recycle
    	}


        // Setting all values in listview
        holder.title.setText(title[position]);
        holder.id.setText(title[position]);
        holder.txtViewEx.setText(sub_title[position]);
        holder.pay_tv.setText("Promo");


        holder.thumb_image.setImageResource(img[position]);


    	return vi;
    }
    
    
    // define your holder class
    private static class ViewHolder{
    	TextView title;
		TextView id;
		ImageView thumb_image;
        ImageView pay_img;
        TextView pay_tv;
		TextView txtViewEx;
    }
	
	@Override
	public void notifyDataSetChanged() {
	    super.notifyDataSetChanged();
	}
	
}