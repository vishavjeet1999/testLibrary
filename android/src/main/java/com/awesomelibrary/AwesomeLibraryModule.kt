package com.awesomelibrary

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.bridge.Promise
import android.content.Context
import android.os.BatteryManager

@ReactModule(name = AwesomeLibraryModule.NAME)
class AwesomeLibraryModule(reactContext: ReactApplicationContext) :
  NativeAwesomeLibrarySpec(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  override fun multiply(a: Double, b: Double): Double {
    return a * b
  }

  override fun square(a: Double): Double {
    return a * a
  }

  
  override fun getBatteryHealth(promise: Promise) {
  try {
    val batteryManager = reactContext.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
    val health = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_HEALTH)
    val batteryHealth = when (health) {
      BatteryManager.BATTERY_HEALTH_GOOD -> "good"
      BatteryManager.BATTERY_HEALTH_COLD -> "cold"
      BatteryManager.BATTERY_HEALTH_DEAD -> "dead"
      BatteryManager.BATTERY_HEALTH_OVERHEAT -> "overheat"
      BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> "over_voltage"
      BatteryManager.BATTERY_HEALTH_UNKNOWN -> "unknown"
      BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> "unspecified_failure"
      else -> "unknown"
    }

    promise.resolve(batteryHealth)
  } catch (e: Exception) {
    promise.reject("ERROR_BATTERY_HEALTH", "Failed to get battery health", e)
  }
}



  companion object {
    const val NAME = "AwesomeLibrary"
  }
}
