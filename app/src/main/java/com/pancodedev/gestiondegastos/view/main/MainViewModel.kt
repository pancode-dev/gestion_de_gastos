package com.pancodedev.gestiondegastos.view.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pancodedev.gestiondegastos.model.ExpenseManagerRepository
import com.pancodedev.gestiondegastos.model.db.expense.ExpenseEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * AndroidViewModel used to communicate MainActivity with ExpenseManagerRepository
 */
class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository = ExpenseManagerRepository(application)
    private val expenseList = repository.getExpenseList()

    /**
     * Returns a LiveData containing a List of all Expenses saved on Database.
     */
    fun getExpenseList() = expenseList

    /**
     * Inserts a list of ExpenseEntity into Database.
     */
    fun insertExpenseList(expenseList: List<ExpenseEntity>) = CoroutineScope(Dispatchers.IO).launch {
        repository.insertExpenseList(expenseList)
    }
}