package com.example.calorietracker

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    private lateinit var logFoodButton: Button
    private lateinit var totalCaloriesText: TextView
    private var dailyCalories = 0
    private val foodEntries = mutableListOf<FoodEntry>()
    
    data class FoodEntry(
        val name: String,
        val calories: Int
    )
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize views
        logFoodButton = findViewById(R.id.logFoodButton)
        totalCaloriesText = findViewById(R.id.totalCaloriesText)
        
        // Update total calories display
        updateTotalCaloriesDisplay()
        
        // Set up button click listener
        logFoodButton.setOnClickListener {
            showLogFoodDialog()
        }
    }
    
    private fun showLogFoodDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_log_food, null)
        val foodNameEditText = dialogView.findViewById<EditText>(R.id.foodNameEditText)
        val caloriesEditText = dialogView.findViewById<EditText>(R.id.caloriesEditText)
        
        val dialog = AlertDialog.Builder(this)
            .setTitle("Log Food")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val foodName = foodNameEditText.text.toString().trim()
                val caloriesText = caloriesEditText.text.toString().trim()
                
                if (foodName.isNotEmpty() && caloriesText.isNotEmpty()) {
                    try {
                        val calories = caloriesText.toInt()
                        if (calories > 0) {
                            addFoodEntry(foodName, calories)
                        } else {
                            Toast.makeText(this, "Please enter a positive number for calories", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: NumberFormatException) {
                        Toast.makeText(this, "Please enter a valid number for calories", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
        
        dialog.show()
    }
    
    private fun addFoodEntry(name: String, calories: Int) {
        val foodEntry = FoodEntry(name, calories)
        foodEntries.add(foodEntry)
        dailyCalories += calories
        updateTotalCaloriesDisplay()
        
        Toast.makeText(this, "Added $name ($calories calories)", Toast.LENGTH_SHORT).show()
    }
    
    private fun updateTotalCaloriesDisplay() {
        totalCaloriesText.text = "Total Calories Today: $dailyCalories"
    }
}
