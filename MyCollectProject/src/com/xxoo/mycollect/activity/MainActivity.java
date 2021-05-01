package com.xxoo.mycollect.activity;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xxoo.mycollect.BaseActivity;
import com.xxoo.mycollect.R;
import com.xxoo.mycollect.R.id;
import com.xxoo.mycollect.R.layout;
import com.xxoo.mycollect.model.MainModel;

public class MainActivity extends BaseActivity implements OnItemClickListener {
	private ListView lst;
	private List<MainModel> datas;
	private LayoutInflater layoutInflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		datas = new ArrayList<MainModel>();
		lst = (ListView) findViewById(R.id.lst);
		layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		addItem();

		lst.setAdapter(new MyAdapter());
		lst.setOnItemClickListener(this);
	}

	private void addItem() {
		// service
		MainModel model1 = new MainModel();
		model1.setTitle("service守护");
		model1.setIntent(new Intent(MainActivity.this, ServiceActivity.class));
		datas.add(model1);

		// webview
		MainModel model2 = new MainModel();
		model2.setTitle("webview");
		model2.setIntent(new Intent(MainActivity.this, WebViewActivity.class));
		datas.add(model2);

		// changeTheme
		MainModel model3 = new MainModel();
		model3.setTitle("主题变换");
		model3.setIntent(new Intent(MainActivity.this,
				ChangeThemeMainAcitivty.class));
		datas.add(model3);

	}

	private class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return datas == null ? 0 : datas.size();
		}

		@Override
		public Object getItem(int position) {
			return datas.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@SuppressLint("ViewHolder")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = layoutInflater.inflate(R.layout.item_lst, null);
			TextView txt = (TextView) convertView.findViewById(R.id.txt);
			MainModel model = datas.get(position);
			txt.setText(model.getTitle());
			return convertView;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		MainModel model = datas.get(position);
		Intent intent = model.getIntent();
		startActivity(intent);
	}
}
