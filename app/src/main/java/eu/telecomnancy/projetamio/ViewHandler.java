package eu.telecomnancy.projetamio;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewHandler {

    private static Context context;
    private static  ListView mListView;

    public static void setView(Context c,ListView m)
    {
        context=c;
        mListView=m;
    }

    public static void updateView(ArrayList<Mote> motes)
    {
        MoteAdapter adapter = new MoteAdapter(context, motes);
        mListView.setAdapter(adapter);
    }

}
