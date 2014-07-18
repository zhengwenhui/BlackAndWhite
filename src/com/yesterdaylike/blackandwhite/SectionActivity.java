package com.yesterdaylike.blackandwhite;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SectionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_section);
		ListView sectionListview = (ListView)findViewById(R.id.section_listview);

		BaseAdapter adapter = new MyBaseAdapter(this, null);
		sectionListview.setAdapter(adapter);
	}
	
	public void onButtonClick(View view){
		int tag = (Integer) view.getTag();
		Log.i("zhengwenhui", "tag:"+tag);
	}

	public class MyBaseAdapter extends BaseAdapter {  
		private Context mContext;  
		private List<HashMap<String, Object>> dataList;  

		public MyBaseAdapter(Context context, List<HashMap<String, Object>> dataList) {  
			this.mContext = context;  
			this.dataList = dataList;  
		}  

		@Override  
		public int getCount() {  
			//return dataList.size();  
			return 12;
		}  

		@Override  
		public HashMap<String, Object> getItem(int position) {  
			//return dataList.get(position);  
			return null;
		}  

		@Override  
		public long getItemId(int position) {  
			return position;  
		}  

		@Override  
		public View getView(int position, View convertView, ViewGroup parent) {  
			ViewHolder holder = null;  
			if (convertView == null) {  
				holder = new ViewHolder();  
				convertView = LayoutInflater.from(mContext).inflate(  
						R.layout.section_item, null);
				holder.leftSection = (Button) convertView.findViewById(R.id.left_section);  
				holder.rightSection = (Button) convertView.findViewById(R.id.right_section);  

				// 将holder绑定到convertView
				convertView.setTag(holder);
			} else {  
				holder = (ViewHolder) convertView.getTag();
			}  

			if( position%3 == 0 ){
				holder.rightSection.setVisibility(View.INVISIBLE);
				holder.leftSection.setVisibility(View.VISIBLE);
				holder.leftSection.setTag(position);
			}
			else{
				holder.rightSection.setVisibility(View.VISIBLE);
				holder.rightSection.setTag(position);
				holder.leftSection.setVisibility(View.INVISIBLE);
			}

			return convertView;
		}  

		/** 
		 * ViewHolder类用以储存item中控件的引用 
		 */  
		final class ViewHolder {  
			Button leftSection;  
			Button rightSection;
		}
	}
}