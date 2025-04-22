package com.github.radch_enko.effectiveandroidcontest.providers

import android.annotation.SuppressLint
import android.content.Context
import android.location.Criteria
import android.location.Location
import android.location.LocationManager
import android.os.SystemClock
import android.util.Log

class MockLocationManager(private val context: Context) {

    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    private val providerName = LocationManager.GPS_PROVIDER

    @SuppressLint("WrongConstant")
    fun setMockLocation() {
        try {
            // Нужные координаты из секретов
            val latitude = 37.7749
            val longitude = -122.4194

            // Проверяем, существует ли тестовый провайдер
            try {
                // Используем числовые значения для совместимости со старыми API
                locationManager.addTestProvider(
                    providerName,
                    false, true, false, false, true,
                    true, true, 1, 1
                )
            } catch (e: IllegalArgumentException) {
                Log.d("MockLocation", "Provider already exists")
            }

            // Включаем тестовый провайдер
            locationManager.setTestProviderEnabled(providerName, true)

            // Создаем фиктивную локацию
            val mockLocation = Location(providerName)
            mockLocation.latitude = latitude
            mockLocation.longitude = longitude
            mockLocation.altitude = 0.0
            mockLocation.accuracy = 1.0f
            mockLocation.time = System.currentTimeMillis()
            mockLocation.elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos()

            // Устанавливаем локацию для тестового провайдера
            locationManager.setTestProviderLocation(providerName, mockLocation)

            Log.d("MockLocation", "Mock location set to: $latitude, $longitude")
        } catch (e: SecurityException) {
            Log.e("MockLocation", "Security Exception: ${e.message}")
        } catch (e: Exception) {
            Log.e("MockLocation", "Exception: ${e.message}")
        }
    }

    fun stopMockLocation() {
        try {
            locationManager.removeTestProvider(providerName)
        } catch (e: Exception) {
            Log.e("MockLocation", "Error stopping mock location: ${e.message}")
        }
    }
}