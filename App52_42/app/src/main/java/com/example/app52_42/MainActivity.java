package com.example.app52_42;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.content.Intent;
import
        android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import
        android.view.ViewGroup;
import android.widget.AdapterView;
import
        android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import
        android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ViewPager view1;
    private
    LinearLayout pagina1;
    private LinearLayout pagina2;
    private
    LinearLayout pagina3;

    @Override
    protected void onCreate(Bundle
                                    savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 = (ViewPager) findViewById(R.id.view);
        view1.setAdapter(new
                AdminPageAdapter());
    }

    class AdminPageAdapter extends
            PagerAdapter {
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            View paginaactual = null;
            switch (position) {
                case 0:
                    if (pagina1 == null) {
                        pagina1 = (LinearLayout)
                                LayoutInflater.from(MainActivity.this).inflate(R.layout.pagina1, null);
                        cargarBuscadores();
                    }
                    paginaactual = pagina1;
                    break;
                case 1:
                    if (pagina2 == null) {
                        pagina2 = (LinearLayout)
                                LayoutInflater.from(MainActivity.this).inflate(R.layout.pagina2, null);
                        cargarPeriodicos();
                    }
                    paginaactual = pagina2;
                    break;
                case 2:
                    if (pagina3 == null) {
                        pagina3 = (LinearLayout)
                                LayoutInflater.from(MainActivity.this).inflate(R.layout.pagina3, null);
                    }
                    paginaactual = pagina3;
                    break;
            }
            ViewPager vp = (ViewPager) collection;
            vp.addView(paginaactual, 0);
            return paginaactual;
        }

        @Override
        public boolean isViewFromObject(View view, Object
                object) {
            return view == object;
        }

        @Override
        public void destroyItem(View collection, int position,
                                Object view) {
            ((ViewPager)
                    collection).removeView((View) view);
        }
    }

    private void
    cargarBuscadores() {
        final String
                [] sitios = {"google.com.mx", "yahoo.com.mx", "youtube.com.mx"};
        ArrayAdapter<String> adaptador1 = new
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sitios);
        ListView lv1 = (ListView) pagina1.findViewById(R.id.listView);
        lv1.setAdapter(adaptador1);
        lv1.setOnItemClickListener(new
                                           AdapterView.OnItemClickListener() {
                                               @Override
                                               public void onItemClick(AdapterView<?> parent, View view, int position,
                                                                       long id) {
                                                   Intent intento1 = new Intent(Intent.ACTION_VIEW,
                                                           Uri.parse("http://www." + sitios[position]));
                                                   startActivity(intento1);
                                               }
                                           });
    }

    private void cargarPeriodicos() {
        final String
                [] sitios = {"lanacion.com.ar", "clarin.com.ar", "lavoz.com.ar"};
        ArrayAdapter<String> adaptador1 = new
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sitios);
        ListView lv1 = (ListView) pagina2.findViewById(R.id.listView2);
        lv1.setAdapter(adaptador1);
        lv1.setOnItemClickListener(new
                                           AdapterView.OnItemClickListener() {
                                               @Override
                                               public void onItemClick(AdapterView<?> parent, View view, int position,
                                                                       long id) {
                                                   Intent intento1 = new Intent(Intent.ACTION_VIEW,
                                                           Uri.parse("http://www." + sitios[position]));
                                                   startActivity(intento1);
                                               }
                                           });
    }

    public void irPagina1(View v) {
        view1.setCurrentItem(0);
    }

    public void irPagina2(View v) {
        view1.setCurrentItem(1);
    }

    public void irPagina3(View v) {
        view1.setCurrentItem(2);
    }
}
