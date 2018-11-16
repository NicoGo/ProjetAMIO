package eu.telecomnancy.projetamio;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MoteAdapter extends ArrayAdapter<Mote> {

    //tweets est la liste des models à afficher
    public MoteAdapter(Context context, List<Mote> modes) {
        super(context, 0, modes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mote,parent, false);
        }

        MoteHolder moteHolder = (MoteHolder) convertView.getTag();
        if(moteHolder == null){
            moteHolder = new MoteHolder();
            moteHolder.light = (ImageView) convertView.findViewById(R.id.light);
            moteHolder.mote = (TextView) convertView.findViewById(R.id.mote);
            moteHolder.infos = (TextView) convertView.findViewById(R.id.infos);
            convertView.setTag(moteHolder);
        }

        Mote mote = getItem(position);

        Log.d("MoteAdapter",mote.getMote() + " -> "+mote.getValue().toString());

        moteHolder.mote.setText("Capteur n° "+mote.getMote());
        moteHolder.infos.setText("Luminosité : "+Double.toString(mote.getValue())+" lm");
        moteHolder.light.setImageResource(mote.getLightToDraw());

        return convertView;
    }

}