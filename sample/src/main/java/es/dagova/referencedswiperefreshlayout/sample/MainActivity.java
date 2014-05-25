package es.dagova.referencedswiperefreshlayout.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import es.dagova.referencedswiperefreshlayout.library.ReferencedSwipeRefreshLayout;


public class MainActivity extends Activity
{
	private ReferencedSwipeRefreshLayout mReferencedSwipeRefreshLayout;
	private ListView mListView;
	private ArrayAdapter mArrayAdapter;
	private static final ArrayList<String> ANDROID_VERSIONS = new ArrayList<String> (Arrays.asList ("Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "Kit Kat", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "Kit Kat", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "Kit Kat"));


	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_main);

		mReferencedSwipeRefreshLayout = (ReferencedSwipeRefreshLayout) findViewById (R.id.referenced_swipe_refresh_layout);
		mReferencedSwipeRefreshLayout.setOnRefreshListener (new ReferencedSwipeRefreshLayoutListener ());
		mReferencedSwipeRefreshLayout.setColorScheme (android.R.color.holo_green_light, android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_orange_light);

		mListView = (ListView) findViewById (R.id.list_view);
		mListView.setEmptyView (findViewById (android.R.id.empty));
		mArrayAdapter = new ArrayAdapter (this, android.R.layout.simple_list_item_1, (ArrayList<String>) ANDROID_VERSIONS.clone ());
		mListView.setAdapter (mArrayAdapter);
	}


	private class ReferencedSwipeRefreshLayoutListener implements SwipeRefreshLayout.OnRefreshListener
	{
		private boolean mShowVersions = false;


		@Override
		public void onRefresh ()
		{
			mReferencedSwipeRefreshLayout.setRefreshing (true);

			if (mShowVersions)
			{
				mArrayAdapter.addAll ((ArrayList<String>) ANDROID_VERSIONS.clone ());
			}
			else
			{
				mArrayAdapter.clear ();
			}

			mArrayAdapter.notifyDataSetChanged ();
			mShowVersions = !mShowVersions;

			mReferencedSwipeRefreshLayout.setRefreshing (false);
		}
	}
}
