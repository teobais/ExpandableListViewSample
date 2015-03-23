package com.toubou91.expandablelistview;

import com.example.expandablelist.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class ExpandablelistActivity extends Activity {
	final Context context = this;
	private static final String[][] data = {
			{ "Μηχ. Πληροφορικής & Τηλ/νιών", "Μηχανολόγων Μηχανικών" },
			{ "ΗΜΜΥ", "Αρχιτεκτόνων Μηχανικών", "Μηχανικών Περιβάλλοντος" },
			{ "Μηχανολόγων Μηχανικών", "ΗΜΜΥ" },
			{ "Μηχ. Παραγωγής & Διοίκησης" },
			{ "HMMY", "Μηχ. Μεταλλείων", "Χημικών Μηχανικών",
					"Μηχανολόγων Μηχανικών" },
			{ "Μηχ. Πληροφοριακών & Επικοινωνιακών Συστ." },
			{ "Γαλλικής Φιλολογίας" }, { "Παιδαγωγικό" }, { "Πληροφορικής" },
			{ "Ιατρική", "Παιδαγωγικό" } };
	private ExpandableListView expandableListView;

	SampleExpandableListAdapter listAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandablelist);

		expandableListView = (ExpandableListView) findViewById(R.id.expandableListView1);
		expandableListView.setAdapter(new SampleExpandableListAdapter(context,
				this, data));

		listAdapter = new SampleExpandableListAdapter(context, this, data);
		expandableListView.setAdapter(listAdapter);

		// Listview on child click listener
		expandableListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {

				Toast.makeText(getApplicationContext(),
						"Hi from element " + groupPosition + " " + childPosition,
						Toast.LENGTH_SHORT).show();

				return false;
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_expandablelist, menu);
		return true;
	}

}
