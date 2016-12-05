package com.vp3000r.yourfuelconsumption;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.htmlcleaner.TagNode;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by P on 05.12.16.
 */
public class ParseSite extends AsyncTask<String, Void, List<String>> {
    //Фоновая операция
    protected void onPreExecute() {
        super.onPreExecute();

    }

    protected List<String> doInBackground(String... arg) {
        List<String> output = new ArrayList<String>();
        try
        {
            HtmlHelper hh = new HtmlHelper(new URL(arg[0]));
            List<TagNode> links = hh.getLinksByClass();

            for (Iterator<TagNode> iterator = links.iterator(); iterator.hasNext();)
            {
                TagNode divElement = (TagNode) iterator.next();
                output.add(divElement.getText().toString());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return output;
    }

    //Событие по окончанию парсинга
    protected void onPostExecute(List<String> output) {
        Model.writePrices(output);

            super.onPreExecute();



    }
}