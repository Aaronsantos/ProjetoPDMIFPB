
package com.example.aaron.mapademisteriosdorecife

import android.content.Intent
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.example.aaron.mapademisteriosdorecife.entity.Assombracao
import com.example.aaron.mapademisteriosdorecife.util.HTTPService
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.constants.Style
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var mapView:MapView
    private lateinit var assombracoes:List<Assombracao>
    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, getString(R.string.access_token))
        setContentView(R.layout.activity_main)

        Log.wtf("DEBUG", "ON CREATE!")


        mapView = findViewById(R.id.mapView) as MapView
        mapView.onCreate(savedInstanceState)
        mapView.setStyleUrl(Style.DARK)

        this.botao = findViewById(R.id.btnVerLista)

        botao.setOnClickListener({

            var intent = Intent(this, ListaAssombracoesActivity::class.java)


            Log.e("DEBUG", "Entrou Click")
            startActivity(intent)

            true
        })

        Log.wtf("DEBUG", "ONCREATE!!!!")
        requestAssombracoes()
        Log.wtf("FLAG", "ON Create acabou.")
    }

    private fun requestAssombracoes() {

        val service = HTTPService().assombracaoService()
        val call = service.list()

        return call.enqueue(object : Callback<List<Assombracao>> {
            override fun onResponse(call: Call<List<Assombracao>>, response: Response<List<Assombracao>>) {
                Log.wtf("URL CALL", "Requisição feita" )
                generateMap(response.body()!!)
            }

            override fun onFailure(call: Call<List<Assombracao>>, t: Throwable) {
                Log.wtf("URL CALL", t.message)
                Toast.makeText(this@MainActivity, "Something went wrong...Error message: " + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun generateMap(assombracoes: List<Assombracao>) {

        this.assombracoes = assombracoes

        mapView.getMapAsync(object : OnMapReadyCallback {

            override fun onMapReady(mapboxMap: MapboxMap) {

                for(assombracao:Assombracao in assombracoes) {

                    var marker = mapboxMap.addMarker(MarkerOptions()
                            .position(LatLng(assombracao.coords.lat, assombracao.coords.lng))
                            .title(assombracao.nome)
                            .snippet(assombracao.local)
                    )

                    mapboxMap.setOnMarkerClickListener { marker ->
                        val intent = Intent(this@MainActivity, AssombracaoDetalheActivity::class.java)
                        intent.putExtra("ASSOMBRACAO", this@MainActivity.encontraAssombracao(marker.title))
                        startActivity(intent)
                        true
                    }

                }
            }
        })
    }

    public fun encontraAssombracao(title: String) : Assombracao {

        for(assombracao:Assombracao in this.assombracoes) {

            if(assombracao.nome.equals(title)) return assombracao

        }

        return Assombracao()

    }

    public override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    public override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    public override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    public override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }




}

