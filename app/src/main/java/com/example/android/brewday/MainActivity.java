package com.example.android.brewday;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Spinner step_spinner;
    View cleanLayout;
    View mashLayout;
    View boilLayout;
    View fermentLayout;
    View packageLayout;
    double originalGravity;
    double finalGravity;
    int boilTime;
    int hopAdditions;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cleanLayout = findViewById(R.id.clean_layout);
        mashLayout = findViewById(R.id.mash_layout);
        boilLayout  = findViewById(R.id.boil_layout);
        fermentLayout = findViewById(R.id.ferment_layout);
        packageLayout = findViewById(R.id.package_layout);

        originalGravity = 0.0;
        finalGravity = 0.0;

        setupSpinner();
        addListenerOnSpinnerItemSelection();

        boilTime = 0;
        hopAdditions = 0;

        res = getResources();
    }

    /**
     * Set up the spinner at the top of the app
     */
    public void setupSpinner() {
        step_spinner = (Spinner) findViewById(R.id.step_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.steps_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        step_spinner.setAdapter(adapter);
    }

    /**
     * Add the listener to the spinner to allow the page to change based on
     * spinner selection
     */
    public void addListenerOnSpinnerItemSelection() {
        step_spinner.setOnItemSelectedListener(new BrewDayOnItemSelectedListener(cleanLayout, mashLayout, boilLayout, fermentLayout, packageLayout));
    }

    /**
     * Activate checkbox presets based on currently checked box
     * @param view the current activity
     */
    public void setCleanPageCheckBoxPresets (View view) {
        CheckBox fermentationCheckbox = (CheckBox) findViewById(R.id.fermentation_preset_checkbox);
        CheckBox packagingCheckbox = (CheckBox) findViewById(R.id.packaging_preset_checkbox);

        if (fermentationCheckbox.isChecked() && !packagingCheckbox.isChecked()) {
            setFermentationPreset();
        } else if (!fermentationCheckbox.isChecked() && packagingCheckbox.isChecked()) {
            setPackagingPreset();
        } else if (fermentationCheckbox.isChecked() && packagingCheckbox.isChecked()) {
            setFermentationPreset();
            setPackagingPreset();
        }
    }

    /**
     * Activate a set of checkboxes specific to the fermentation step of brewing
     */
    public void setFermentationPreset() {
        CheckBox item1 = (CheckBox) findViewById(R.id.clean_page_item_1);
        CheckBox item2 = (CheckBox) findViewById(R.id.clean_page_item_2);
        CheckBox item3 = (CheckBox) findViewById(R.id.clean_page_item_3);
        CheckBox item4 = (CheckBox) findViewById(R.id.clean_page_item_4);
        CheckBox item5 = (CheckBox) findViewById(R.id.clean_page_item_5);
        CheckBox item6 = (CheckBox) findViewById(R.id.clean_page_item_6);
        CheckBox item7 = (CheckBox) findViewById(R.id.clean_page_item_7);
        CheckBox item8 = (CheckBox) findViewById(R.id.clean_page_item_8);
        CheckBox item9 = (CheckBox) findViewById(R.id.clean_page_item_9);

        CheckBox[] fermentationPreset = {item1, item2, item3, item4, item5, item6, item7, item8, item9};

        for (CheckBox box : fermentationPreset) {
            box.setTextAppearance(this, R.style.unchecked);
        }

    }

    /**
     * Activate a set of checkboxes specific to the packaging step of brewing
     */
    public void setPackagingPreset() {
        CheckBox item1 = (CheckBox) findViewById(R.id.clean_page_item_1);
        CheckBox item2 = (CheckBox) findViewById(R.id.clean_page_item_2);
        CheckBox item8 = (CheckBox) findViewById(R.id.clean_page_item_8);
        CheckBox item9 = (CheckBox) findViewById(R.id.clean_page_item_9);
        CheckBox item10 = (CheckBox) findViewById(R.id.clean_page_item_10);
        CheckBox item11 = (CheckBox) findViewById(R.id.clean_page_item_11);
        CheckBox item12 = (CheckBox) findViewById(R.id.clean_page_item_12);

        CheckBox[] fermentationPreset = {item1, item2, item8, item9, item10, item11, item12};

        for (CheckBox box : fermentationPreset) {
            box.setTextAppearance(this, R.style.unchecked);
        }
    }

    /**
     * Handler to adjust the checkbox theme based on whether or not the box is checked
     * @param view the current activity
     */
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
                if (checked) ((CheckBox) view).setTextAppearance(this, R.style.checked);
                else ((CheckBox) view).setTextAppearance(this, R.style.unchecked);
    }

    /**
     * Reset all checkboxes to the default inactive state
     * @param view the current activity
     */
    public void resetCleanCheckBoxes (View view) {
        CheckBox fermentationCheckbox = (CheckBox) findViewById(R.id.fermentation_preset_checkbox);
        CheckBox packagingCheckbox = (CheckBox) findViewById(R.id.packaging_preset_checkbox);
        CheckBox item1 = (CheckBox) findViewById(R.id.clean_page_item_1);
        CheckBox item2 = (CheckBox) findViewById(R.id.clean_page_item_2);
        CheckBox item3 = (CheckBox) findViewById(R.id.clean_page_item_3);
        CheckBox item4 = (CheckBox) findViewById(R.id.clean_page_item_4);
        CheckBox item5 = (CheckBox) findViewById(R.id.clean_page_item_5);
        CheckBox item6 = (CheckBox) findViewById(R.id.clean_page_item_6);
        CheckBox item7 = (CheckBox) findViewById(R.id.clean_page_item_7);
        CheckBox item8 = (CheckBox) findViewById(R.id.clean_page_item_8);
        CheckBox item9 = (CheckBox) findViewById(R.id.clean_page_item_9);
        CheckBox item10 = (CheckBox) findViewById(R.id.clean_page_item_10);
        CheckBox item11 = (CheckBox) findViewById(R.id.clean_page_item_11);
        CheckBox item12 = (CheckBox) findViewById(R.id.clean_page_item_12);

        CheckBox[] fermentationPreset = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12};

        for (CheckBox box : fermentationPreset) {
            box.setTextAppearance(this, R.style.checked);
            box.setChecked(false);
        }
        fermentationCheckbox.setChecked(false);
        packagingCheckbox.setChecked(false);
    }

    /**
     * Store the value for the original gravity in the originalGravity global variable
     * Displays a toast to confirm the value has been set
     * @param view the current activity
     */
    public void setOriginalGravity(View view) {
        EditText ogEditText = (EditText) findViewById(R.id.original_gravity_editText);
        String originalGravityString = ogEditText.getText().toString();
        if (originalGravityString.equals("")){
            Context context = getApplicationContext();
            CharSequence text = res.getString(R.string.original_gravity_error);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            float originalGravity = Float.parseFloat(originalGravityString);
            this.originalGravity = originalGravity;

            Context context = getApplicationContext();
            CharSequence text = res.getString(R.string.OG_entered) + originalGravity;
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            TextView displayOG = (TextView) findViewById(R.id.display_OG);
            String ogString = res.getString(R.string.OG_colon) + originalGravityString;
            displayOG.setText(ogString);
        }
    }

    /**
     * Accessor method for the originalGravity variable
     * @return the value for original gravity
     */
    public double getOriginalGravity() {
        return originalGravity;
    }

    /**
     * Store the value for the final gravity in the finalGravity global variable
     * Displays a toast to confirm the value has been set
     * @param view the current activity
     */
    public void setFinalGravity (View view) {
        EditText fgEditText = (EditText) findViewById(R.id.final_gravity_editText);
        String finalGravityString = fgEditText.getText().toString();
        if (finalGravityString.equals("")) {
            Context context = getApplicationContext();
            CharSequence text = res.getString(R.string.final_gravity_error);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            float finalGravity = Float.parseFloat(finalGravityString);
            this.finalGravity = finalGravity;

            Context context = getApplicationContext();
            CharSequence text = res.getString(R.string.FG_entered) + finalGravity;
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            TextView displayFG = (TextView) findViewById(R.id.display_FG);
            String fgString = res.getString(R.string.FG_colon) + finalGravityString;
            displayFG.setText(fgString);

            getEstimatedABV();
        }
    }

    /**
     * Accessor method for the finalGravity variable
     * @return the value for final gravity
     */
    public double getFinalGravity () {
        return finalGravity;
    }

    /**
     * Calculate the estimated alcohol by volume (ABV) based on the input original and final gravities
     */
    public void getEstimatedABV() {
        TextView abvTextView = (TextView) findViewById(R.id.abv_text_view);
        double og = getOriginalGravity();
        double fg = getFinalGravity();

        double abv = (og - fg) * 105.0 * 1.25;
        String abvFinal = String.format("%5.2f", abv);

        String abvString = abvFinal + res.getString(R.string.percent_abv);
        abvTextView.setText(abvString);
    }

    /**
     * Add a reminder to the calendar based on the number of days from the current day entered by the user
     * @param view the current activity
     */
    public void addReminderToCalendar(View view) {
        EditText daysEditText = (EditText) findViewById(R.id.number_of_days);
        String daysString = daysEditText.getText().toString();
        if (daysString.equals("")) {
            Context context = getApplicationContext();
            CharSequence text = res.getString(R.string.days_to_ferment_error);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            int days = Integer.parseInt(daysString);
            long daysInMillis = TimeUnit.MILLISECONDS.convert(days, TimeUnit.DAYS);
            String title = getString(R.string.fermentation_done);
            long today = System.currentTimeMillis();
            long eventStart = daysInMillis + today;

            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setData(CalendarContract.Events.CONTENT_URI);
            intent.putExtra(CalendarContract.Events.TITLE, title);
            intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
            intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, eventStart);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    /**
     * Sets the initial values for the boil timer and associated variables
     * @param view the current activity
     */
    public void setInitialBoilValues(View view) {
        TextView remainingBoilTimeTextView = (TextView) findViewById(R.id.total_remaining_time);
        TextView remainingHopAdditionsTextView = (TextView) findViewById(R.id.total_remaining_additions);

        EditText initialBoilTimeEditText = (EditText) findViewById(R.id.initial_total_boil_time);
        EditText initialHopAdditionsEditText = (EditText) findViewById(R.id.initial_hop_additions);

        String boilText = initialBoilTimeEditText.getText().toString();
        String additionsText = initialHopAdditionsEditText.getText().toString();

        if (boilText.equals("") || additionsText.equals("")){
            Context context = getApplicationContext();
            CharSequence text = res.getString(R.string.set_boil_error);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            boilTime = Integer.parseInt(boilText);
            hopAdditions = Integer.parseInt(additionsText);

            String remainingTime = res.getString(R.string.remaining_time) + boilTime;
            String remainingHops = res.getString(R.string.remaining_hops) + hopAdditions;
            remainingBoilTimeTextView.setText(remainingTime);
            remainingHopAdditionsTextView.setText(remainingHops);
        }
    }

    /**
     * Start a timer for the current hop addition
     * Decrement the number of additions remaining and the total boil time remaining
     * @param view the current activity
     */
    public void startTimer(View view) {
        final int SECONDS_PER_MINUTE = 60;

        EditText currentIncrement = (EditText) findViewById(R.id.hop_addition_current_increment);

        String timerText = currentIncrement.getText().toString();
        if (timerText.equals("")) {
            Context context = getApplicationContext();
            CharSequence text = res.getString(R.string.set_timer_error);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            int minutes = Integer.parseInt(timerText);
            int seconds = minutes * SECONDS_PER_MINUTE;

            String message = res.getString(R.string.boil_timer);

            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

            TextView remainingBoilTimeTextView = (TextView) findViewById(R.id.total_remaining_time);
            TextView remainingHopAdditionsTextView = (TextView) findViewById(R.id.total_remaining_additions);

            boilTime -= minutes;
            if (hopAdditions > 1) {
                hopAdditions--;
                String remainingHops = res.getString(R.string.remaining_hops) + hopAdditions;
                remainingHopAdditionsTextView.setText(remainingHops);
            } else {
                remainingHopAdditionsTextView.setText(R.string.hops_done);
            }

            Context context = getApplicationContext();
            CharSequence text = res.getString(R.string.timer_set_for) + minutes + res.getString(R.string.space_minutes);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            String remainingTime = res.getString(R.string.remaining_time) + boilTime;
            currentIncrement.setText("");
            remainingBoilTimeTextView.setText(remainingTime);
        }
    }
}
