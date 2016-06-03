package com.example.utiltest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.utiltest.util.ToastUtils;
import com.example.utiltest.view.AbPullToRefreshView;
import com.example.utiltest.view.AbPullToRefreshView.OnFooterLoadListener;
import com.example.utiltest.view.AbPullToRefreshView.OnHeaderRefreshListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//((TextView) findViewById(R.id.tv)).setText("/");
		AbPullToRefreshView refreshView=(AbPullToRefreshView) findViewById(R.id.mPullRefreshView);
		ListView listView=(ListView) findViewById(R.id.mListView);
		refreshView.getHeaderView().setHeaderProgressBarDrawable(
				this.getResources().getDrawable(R.drawable.progress_circular));
		refreshView.getFooterView().setFooterProgressBarDrawable(
				this.getResources().getDrawable(R.drawable.progress_circular));
		refreshView.setOnFooterLoadListener(new OnFooterLoadListener() {
			
			@Override
			public void onFooterLoad(AbPullToRefreshView view) {
				ToastUtils.show(MainActivity.this, "onFooterLoad");
			}
		});
		refreshView.setOnHeaderRefreshListener(new OnHeaderRefreshListener() {
			
			@Override
			public void onHeaderRefresh(AbPullToRefreshView view) {
				ToastUtils.show(MainActivity.this, "onHeaderRefresh");
			}
		});
	}

}
