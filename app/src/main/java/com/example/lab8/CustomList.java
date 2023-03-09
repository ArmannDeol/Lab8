package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }


    /**
     * Adds city object to list
     * @param city - city object to add
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * Checks if the city list contains a certain city
     * @param city
     *      City that is to be searched for
     * @return
     *      Boolean that is true if the city exists in the list, and
     *      false if not
     */
    public boolean hasCity(City city) {
        if (this.cities.contains(city)) {
            return true;
        }
        else {return false;}
    }

    /**
     * Deletes city from the city list if it exists
     * @param city
     *      City to be deleted
     * @throws IllegalArgumentException
     */
    public void delete(City city) {

    }
}
