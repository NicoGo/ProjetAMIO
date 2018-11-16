package eu.telecomnancy.projetamio;

import android.text.InputFilter;
import android.text.Spanned;

    public class PreferencesNumberFilter implements InputFilter {

        private int min, max;

        public PreferencesNumberFilter(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                int input = Integer.parseInt(dest.toString() + source.toString());
                if (min<=input &&  max>=input)
                    return null;
            } catch (NumberFormatException nfe) { }
            return "";
        }
    }