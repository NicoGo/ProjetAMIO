package eu.telecomnancy.projetamio;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

public class Mote {
        private String mote;
        private Double value;

        public Mote(String m, Double v) {
                this.mote = m;
                this.value = v;
        }


        public void setMote(String mote) {
                this.mote = mote;
        }

        public void setValue(Double v) {
                this.value = v;
        }


        public String getMote() {
                return mote;
        }

        public Double getValue() {
                return value;
        }

        public int getLightToDraw()
        {
                return value>250 ? R.drawable.lighton : R.drawable.lightoff;
        }
}