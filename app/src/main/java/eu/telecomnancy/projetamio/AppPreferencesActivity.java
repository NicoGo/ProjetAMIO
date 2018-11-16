package eu.telecomnancy.projetamio;


import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.text.InputFilter;
import android.widget.EditText;

public class AppPreferencesActivity extends PreferenceActivity {

    private int ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText minWeek = (EditText) findViewById();
        minWeek.setFilters(new InputFilter[]{ new PreferencesNumberFilter(0, 23)});
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

}