package com.example.mapistasjava

import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager
import android.os.Bundle
import com.example.mapistasjava.databinding.ActivityMainBinding
import com.mapbox.geojson.Point
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val symbolManager: SymbolManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.mapView.getMapboxMap().loadStyleUri(Style.OUTDOORS)
        // Create an instance of the Annotation API and get the PointAnnotationManager.
        val annotationApi = binding!!.mapView?.annotations
        val pointAnnotationManager = annotationApi?.createPointAnnotationManager(binding!!.mapView)
// Set options for the resulting symbol layer.
        val pointAnnotationOptions: PointAnnotationOptions = PointAnnotationOptions()
            // Define a geographic coordinate.
            .withPoint(Point.fromLngLat(-70.6467607, -33.445226))
// Add the resulting pointAnnotation to the map.
        pointAnnotationManager?.create(pointAnnotationOptions)
    }

    override fun onStart() {
        super.onStart()
        binding!!.mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        binding!!.mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding!!.mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding!!.mapView.onDestroy()
    }
}