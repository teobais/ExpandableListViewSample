package com.toubou91.expandablelistview;

import java.util.HashMap;

import com.example.expandablelist.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ExpandableListAdapter;

public class SampleExpandableListAdapter extends BaseExpandableListAdapter
		implements ExpandableListAdapter {

	public Context context;
	private LayoutInflater myInflater;
	private String[][] data;
	int _objInt;
	public static Boolean checked[] = new Boolean[1];

	HashMap<Long, Boolean> checkboxMap = new HashMap<Long, Boolean>();
	private static final int GROUP_ITEM_RESOURCE = R.layout.group_item;
	private static final int CHILD_ITEM_RESOURCE = R.layout.child_item;
	public String[] check_string_array;

	public SampleExpandableListAdapter(Context context, Activity activity,
			String[][] data) {
		this.data = data;
		this.context = context;
		myInflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		_objInt = data.length;
		check_string_array = new String[_objInt];
	}

	public String getChild(int groupPosition, int childPosition) {
		return data[groupPosition][childPosition];
	}

	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	public int getChildrenCount(int groupPosition) {
		return data[groupPosition].length;
	}

	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		View v = convertView;
		String child = getChild(groupPosition, childPosition);
		int id_res = 0;
		boolean go = false;
		if (groupPosition == 0) {
			if (childPosition == 0)
				id_res = R.drawable.icte;
			if (childPosition == 1)
				id_res = R.drawable.mech_uowm;
		} else if (groupPosition == 1) {
			if (childPosition == 0)
				id_res = R.drawable.eece_duth;
			if (childPosition == 1)
				id_res = R.drawable.arch_duth;
			if (childPosition == 2)
				id_res = R.drawable.env_duth;
		} else if (groupPosition == 2) {
			if (childPosition == 0)
				id_res = R.drawable.mech_uth;
			if (childPosition == 1)
				id_res = R.drawable.eece_oth;
		} else if (groupPosition == 3) {
			if (childPosition == 0)
				id_res = R.drawable.dpem_tuc;
		} else if (groupPosition == 4) {
			if (childPosition == 0)
				id_res = R.drawable.eece_ntua;
			if (childPosition == 1)
				id_res = R.drawable.metal_ntua;
			if (childPosition == 2)
				id_res = R.drawable.chem_ntua;
			if (childPosition == 3)
				id_res = R.drawable.mech_ntua;
		} else if (groupPosition == 5) {
			if (childPosition == 0)
				go = true;
		} else if (groupPosition == 6) {
			if (childPosition == 0)
				id_res = R.drawable.france;
		} else if (groupPosition == 7) {
			if (childPosition == 0)
				id_res = R.drawable.eled_uoc;
		} else if (groupPosition == 8) {
			if (childPosition == 0)
				id_res = R.drawable.cs_ionian;
		} else if (groupPosition == 9) {
			if (childPosition == 0)
				id_res = R.drawable.med_uoi;
			if (childPosition == 1)
				id_res = R.drawable.ptde_uoi;
		}

		if (child != null) {
			v = myInflater.inflate(CHILD_ITEM_RESOURCE, null);
			ViewHolder holder = new ViewHolder(v);
			holder.text.setText(Html.fromHtml(child));

			if (go != true)
				holder.imageview.setImageResource(id_res); // kane comment afto
															// an dn 9es eikona
															// sta children
			else
				holder.imageview.setVisibility(View.INVISIBLE);
		}
		return v;
	}

	public String getGroup(int groupPosition) {
		return "group-" + groupPosition;
	}

	public int getGroupCount() {
		return data.length;
	}

	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		View v = convertView;
		String group = null;
		int id_res = 0;
		long group_id = getGroupId(groupPosition);
		if (group_id == 0) {
			group = "Πανεπιστήμιο Δυτικής Μακεδονίας";
			id_res = R.drawable.uowm;
		} else if (group_id == 1) {
			group = "Δημοκρίτειο Πανεπιστήμιο Θράκης";
			id_res = R.drawable.duth;
		} else if (group_id == 2) {
			group = "Πανεπιστήμιο Θεσσαλίας";
			id_res = R.drawable.uoth2;
		} else if (group_id == 3) {
			group = "Πολυτεχνείο Κρήτης";
			id_res = R.drawable.tuc;
		} else if (group_id == 4) {
			group = "Εθνικό Μετσόβειο Πολυτεχνείο";
			id_res = R.drawable.ntua;
		} else if (group_id == 5) {
			group = "Πανεπιστήμιου Αιγαίου";
			id_res = R.drawable.aegean;
		} else if (group_id == 6) {
			group = "Ε.Κ.Π.Α.";
			id_res = R.drawable.uoa;
		} else if (group_id == 7) {
			group = "Πανεπιστήμιο Κρήτης";
			id_res = R.drawable.uoc;
		} else if (group_id == 8) {
			group = "Ιόνιο Πανεπιστήμιο";
			id_res = R.drawable.ionian;
		} else if (group_id == 9) {
			group = "Πανεπιστήμιο Ιωαννίνων";
			id_res = R.drawable.uoi;
		}

		if (group != null) {
			v = myInflater.inflate(GROUP_ITEM_RESOURCE, null);
			ViewHolder holder = new ViewHolder(v);

			holder.text.setText(Html.fromHtml(group));
			holder.imageview.setImageResource(id_res);

		}
		return v;
	}

	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	public boolean hasStableIds() {
		return true;
	}
}