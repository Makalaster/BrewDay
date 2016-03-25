package com.example.android.brewday;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * Created by Makalaster on 3/6/16.
 */
public class BrewDayOnItemSelectedListener extends Activity implements OnItemSelectedListener {

    View cleanLayout;
    View mashLayout;
    View boilLayout;
    View fermentLayout;
    View packageLayout;

    /**
     * Constructor method to build a new listener for the spinner
     * @param v1 first choice on spinner
     * @param v2 second choice on spinner
     * @param v3 third choice on spinner
     * @param v4 fourth choice on spinner
     * @param v5 fifth choice on spinner
     */
    public BrewDayOnItemSelectedListener(View v1, View v2, View v3, View v4, View v5) {
        cleanLayout = v1;
        mashLayout = v2;
        boilLayout = v3;
        fermentLayout = v4;
        packageLayout = v5;
    }

    /**
     * Display the appropriate page based on the selected spinner option
     * @param parent parent activity
     * @param view current view object
     * @param pos spinner selection index
     * @param id id of the spinner
     */
    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        cleanLayout.setVisibility(View.GONE);
        mashLayout.setVisibility(View.GONE);
        boilLayout.setVisibility(View.GONE);
        fermentLayout.setVisibility(View.GONE);
        packageLayout.setVisibility(View.GONE);

        switch (parent.getItemAtPosition(pos).toString()) {
            case "Clean and sanitize!" : cleanLayout.setVisibility(View.VISIBLE);
                break;
            case "Mash the grain!" : mashLayout.setVisibility(View.VISIBLE);
                break;
            case "Boil the malt!" : boilLayout.setVisibility(View.VISIBLE);
                break;
            case "Ferment the wort!" : fermentLayout.setVisibility(View.VISIBLE);
                break;
            case "Package your beer!" : packageLayout.setVisibility(View.VISIBLE);
                break;
            default:
                cleanLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

}