package com.example.garcia_labexer4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String[] oName, oCountry, oIndustry, oCeo, oMess;
    int[] logo = {R.drawable.icbc, R.drawable.jpmorgan, R.drawable.chinacons, R.drawable.agricultural, R.drawable.bankofamer, R.drawable.apple, R.drawable.pingan, R.drawable.bankofchina, R.drawable.shell, R.drawable.wells, R.drawable.exxon, R.drawable.att, R.drawable.samsung, R.drawable.citi};
    ArrayList<AndroidVersions> versions = new ArrayList<>();
    ListView lstVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TOP GLOBAL COMPANIES");

        oName = getResources().getStringArray(R.array.cName);
        oCountry = getResources().getStringArray(R.array.cCountry);
        oIndustry = getResources().getStringArray(R.array.cIndustry);
        oCeo = getResources().getStringArray(R.array.cCeo);
        oMess = getResources().getStringArray(R.array.cMess);

        for (int i = 0; i < oName.length; i++) {
            versions.add(new AndroidVersions(logo[i], oName[i], oCountry[i], oIndustry[i], oCeo[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.item, versions);
        lstVersions = findViewById(R.id.lv);
        lstVersions.setAdapter(adapter);
        lstVersions.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
        final File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) ;
        File file = new File (folder, "read.txt");
        File read = new File(folder, "write.txt");
        try {
            final FileOutputStream fos = new FileOutputStream(file);
            final FileOutputStream show = new FileOutputStream(read);
            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            String choice = versions.get(i).getoName() + "\n"
                    + versions.get(i).getoCountry() + "\n"
                    + versions.get(i).getoIndustry() + "\n"
                    + versions.get(i).getoCeo() + "\n";
            String sChoice = versions.get(i).getoName() + "\n" + versions.get(i).getoCountry();
            show.write(sChoice.getBytes());
            fos.write(choice.getBytes());
            dialog.setTitle(versions.get(i).getoName());
            dialog.setIcon(versions.get(i).getLogo());

            dialog.setMessage(oMess[i]);

            dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    try {
                        FileInputStream fin;
                        fin = new FileInputStream(new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/write.txt"));
                        int i;
                        String str = "";
                        while ((i = fin.read()) != -1) {
                            str += Character.toString((char) i);
                        }
                        fin.close();
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
            dialog.create().show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "File not found.", Toast.LENGTH_LONG ).show();
        } catch (IOException e) {
            Toast.makeText(this, "Cannot Write...", Toast.LENGTH_LONG).show();
        }


        }
}
