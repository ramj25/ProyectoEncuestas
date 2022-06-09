package com.example.asus.proyectoencuestas;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }


/*

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);




        if(LoginActivity.switchMapas==3 || LoginActivity.switchMapas==4) {
            autocompleteFragment.setText(PantallaEncuesta1_Viaje.autoCompletado);
        }







        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {

              //  MainActivity.lugar = place.getLatLng().toString();

                if(LoginActivity.switchMapas==1){
                    PantallaEncuesta1_Persona.coordTrabajo=place.getLatLng().toString();
                }
                if(LoginActivity.switchMapas==2){
                    PantallaEncuesta1_Persona.coordEstudio=place.getLatLng().toString();
                }
                if(LoginActivity.switchMapas==3){
                    PantallaEncuesta1_Viaje.coordOrigen=place.getLatLng().toString();
                    PantallaEncuesta1_Viaje.lblCoordenadasOrigen.setText("Coordenadas: "+place.getLatLng().toString());
                }
                if(LoginActivity.switchMapas==4){
                    PantallaEncuesta1_Viaje.coordDestino=place.getLatLng().toString();
                    PantallaEncuesta1_Viaje.lblCoordenadasDestino.setText("Coordenadas: "+place.getLatLng().toString());
                }
                if(LoginActivity.switchMapas==5){
                    PantallaEncuesta1.coordUbicacion=place.getLatLng().toString();
                    PantallaEncuesta1.lblCoordenadasUbicacion.setText("Coordenadas: "+place.getLatLng().toString());
                }


                mMap.clear();

                Marker marker = mMap.addMarker(new MarkerOptions().position(place.getLatLng()));

                mMap.moveCamera(CameraUpdateFactory.newLatLng(place.getLatLng()));

               // System.out.println("aaa " + MainActivity.lugar+" "+place.getName());

                // Log.i(TAG, "Place: " + place.getName());
            }

            @Override
            public void onError(Status status) {

                // Log.i(TAG, "An error occurred: " + status);
            }
        });


    }



*/



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);




        if(LoginActivity.switchMapas==3 || LoginActivity.switchMapas==4) {
            autocompleteFragment.setText(PantallaEncuesta1_Viaje.autoCompletado);
        }





        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {

                //  MainActivity.lugar = place.getLatLng().toString();

                if(LoginActivity.switchMapas==1){
                    PantallaEncuesta1_Persona.coordTrabajo=place.getLatLng().toString();
                }
                if(LoginActivity.switchMapas==2){
                    PantallaEncuesta1_Persona.coordEstudio=place.getLatLng().toString();
                }
                if(LoginActivity.switchMapas==3){
                    PantallaEncuesta1_Viaje.coordOrigen=place.getLatLng().toString();
                    PantallaEncuesta1_Viaje.lblCoordenadasOrigen.setText("Coordenadas: "+place.getLatLng().toString());
                }
                if(LoginActivity.switchMapas==4){
                    PantallaEncuesta1_Viaje.coordDestino=place.getLatLng().toString();
                    PantallaEncuesta1_Viaje.lblCoordenadasDestino.setText("Coordenadas: "+place.getLatLng().toString());
                }
                if(LoginActivity.switchMapas==5){
                    PantallaEncuesta1.coordUbicacion=place.getLatLng().toString();
                    PantallaEncuesta1.lblCoordenadasUbicacion.setText("Coordenadas: "+place.getLatLng().toString());
                }


                mMap.clear();

                Marker marker = mMap.addMarker(new MarkerOptions().position(place.getLatLng()));

                mMap.moveCamera(CameraUpdateFactory.newLatLng(place.getLatLng()));

                // System.out.println("aaa " + MainActivity.lugar+" "+place.getName());

                // Log.i(TAG, "Place: " + place.getName());
            }

            @Override
            public void onError(Status status) {

                //CONTROLAR ERROR AQUI

            }

        });







/*

            // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
*/




    /*
        LocationManager l = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        Criteria crit = new Criteria();
        crit.setAccuracy(Criteria.ACCURACY_FINE);
        crit.setPowerRequirement(Criteria.POWER_LOW);

        Location loc=l.getLastKnownLocation(l.getBestProvider(crit,true));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));


        LATLNG DE MI UBICACION POR DEFECTO!

*/



        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");





        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-12.121806,-77.030407)));

        CameraPosition pos = new CameraPosition.Builder()
                .target(new LatLng(-12.121806,-77.030407)).zoom(90).build();

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(pos));






        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {

                MarkerOptions markerOptions = new MarkerOptions();

                markerOptions.position(latLng);

                //markerOptions.title(latLng.latitude + " : " + latLng.longitude);

                mMap.clear();

                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

                mMap.addMarker(markerOptions);



                if(LoginActivity.switchMapas==1){
                    PantallaEncuesta1_Persona.coordTrabajo=latLng.toString();
                }
                if(LoginActivity.switchMapas==2){
                    PantallaEncuesta1_Persona.coordEstudio=latLng.toString();
                }
                if(LoginActivity.switchMapas==3){
                    PantallaEncuesta1_Viaje.coordOrigen=latLng.toString();
                    PantallaEncuesta1_Viaje.lblCoordenadasOrigen.setText("Coordenadas: "+latLng.toString());
                }
                if(LoginActivity.switchMapas==4){
                    PantallaEncuesta1_Viaje.coordDestino=latLng.toString();
                    PantallaEncuesta1_Viaje.lblCoordenadasDestino.setText("Coordenadas: "+latLng.toString());
                }
                if(LoginActivity.switchMapas==5){
                    PantallaEncuesta1.coordUbicacion=latLng.toString();
                    PantallaEncuesta1.lblCoordenadasUbicacion.setText("Coordenadas: "+latLng.toString());
                }




            }
        });



    }











    @Override
    public void onBackPressed() {

        LoginActivity.switchMapas=0;

        finish();


    }
}
