package es.dagova.referencedswiperefreshlayout.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.widget.AdapterView;

/**
 * Created by david on 11/05/14.
 */
public class ReferencedSwipeRefreshLayout extends SwipeRefreshLayout
{
	AdapterView mAdapterView;
	int mAdapterViewId;


	public ReferencedSwipeRefreshLayout (Context context, AttributeSet attrs)
	{
		super (context, attrs);

		TypedArray mStyledAttributes = context.getTheme ().obtainStyledAttributes (attrs, R.styleable.ReferencedSwipeRefreshLayout, 0, 0);
		mAdapterViewId = mStyledAttributes.getResourceId (R.styleable.ReferencedSwipeRefreshLayout_adapter_view, -1);
		mStyledAttributes.recycle ();
	}


	@Override
	protected void onFinishInflate ()
	{
		super.onFinishInflate ();

		mAdapterView = (AdapterView) findViewById (mAdapterViewId);
	}


	@Override
	public boolean canChildScrollUp ()
	{
		return mAdapterView.canScrollVertically (-1);
	}
}
