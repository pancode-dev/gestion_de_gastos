package com.pancodedev.gestiondegastos.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.pancodedev.gestiondegastos.R
import com.pancodedev.gestiondegastos.model.db.expense.ExpenseEntity

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getExpenseList().observe(this, { list ->
            if(list.isNotEmpty())
                list.forEach {
                    Log.d(this.localClassName, "${it.expenseName} - ${it.expenseAmount}")
                }
            else
                Log.d(this.localClassName, "empty database u.u")
        })

        //Test DB by inserting expenses list and reading from DB
        val expenseList = listOf(
            ExpenseEntity(expenseName = "Borgir", expenseAmount = 2.17f),
            ExpenseEntity(expenseName = "Keck", expenseAmount = 7.83f),
            ExpenseEntity(expenseName = "Geim", expenseAmount = 35.99f),
        )

        viewModel.insertExpenseList(expenseList)

    }

}