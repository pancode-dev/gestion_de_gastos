package com.pancodedev.gestiondegastos.model

import android.content.Context
import com.pancodedev.gestiondegastos.model.db.ExpenseManagerDatabase
import com.pancodedev.gestiondegastos.model.db.expense.ExpenseEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ExpenseManagerRepository(context: Context) {
    private val db: ExpenseManagerDatabase = ExpenseManagerDatabase.getDatabase(context)
    private val expenseList = db.expenseDAO().getAllExpenses()

    /**
     * Returns a LiveData containing a List of all Expenses saved on Database.
     */
    fun getExpenseList() = expenseList

    /**
     * Inserts a list of ExpenseEntity into Database.
     */
    suspend fun insertExpenseList(expenseList: List<ExpenseEntity>) = db.expenseDAO().insertExpenseList(expenseList)

}