package com.plexxoo.android.test;



import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class Androidexamples03listviewActivity extends ListActivity {
	private TestListAdapter adapter;
    private static String[] listItems = {"exploring", "android", 
            "list", "activities"};
    private Button remove;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.list_item);

		adapter=new TestListAdapter(this, listItems);
	setListAdapter(adapter);
	remove = (Button)findViewById(R.id.remove_last);
	remove.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			try{
				adapter.remove(adapter.getCount()-1);
				adapter.forceReload();
				
				Log.d("app", new Integer(adapter.getCount()).toString());
			}
			catch(Exception e){
				Log.d("miapp", "fallo al actualizar");
			}
		}
	});
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		adapter.add("Añadido");
		adapter.forceReload();
		Integer i=(Integer)adapter.getCount();
		Log.d("app", i.toString());
	}
}