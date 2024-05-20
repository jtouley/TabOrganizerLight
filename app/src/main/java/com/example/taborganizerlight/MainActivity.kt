package com.example.taborganizerlight

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Browser
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            Log.d("MainActivity", "Button clicked")
            if (ContextCompat.checkSelfPermission(this, "com.android.chrome.permission.READ_HISTORY_BOOKMARKS") != PackageManager.PERMISSION_GRANTED) {
                Log.d("MainActivity", "Permission not granted, requesting permission")
                ActivityCompat.requestPermissions(this, arrayOf("com.android.chrome.permission.READ_HISTORY_BOOKMARKS"), 1)
            } else {
                Log.d("MainActivity", "Permission already granted, fetching tabs")
                val openTabs = getOpenTabUrls()
                Log.d("MainActivity", "Fetched open tabs: $openTabs")
                textView.text = openTabs.joinToString("\n")
            }
        }
    }

    private fun getOpenTabUrls(): List<String> {
        Log.d("MainActivity", "getOpenTabUrls called")
        val urls = mutableListOf<String>()
        val projection = arrayOf("url") // Use "url" instead of Browser.BookmarkColumns.URL
        val cursor = contentResolver.query(
            Uri.parse("content://com.android.chrome.browser/bookmarks"),
            projection,
            "bookmark = 0",  // Use "bookmark = 0" to get only open tabs
            null,
            null
        )

        cursor?.use {
            while (it.moveToNext()) {
                val url = it.getString(it.getColumnIndex("url")) // Use "url" instead of Browser.BookmarkColumns.URL
                Log.d("MainActivity", "Found URL: $url")
                urls.add(url)
            }
        }

        Log.d("MainActivity", "getOpenTabUrls returned: $urls")
        return urls
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d("MainActivity", "onRequestPermissionsResult called with requestCode: $requestCode")
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.d("MainActivity", "Permission granted, fetching tabs")
            val textView = findViewById<TextView>(R.id.textView)
            val openTabs = getOpenTabUrls()
            Log.d("MainActivity", "Fetched open tabs: $openTabs")
            textView.text = openTabs.joinToString("\n")
        } else {
            Log.d("MainActivity", "Permission denied")
        }
    }
}
