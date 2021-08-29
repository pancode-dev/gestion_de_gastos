package com.pancodedev.gestiondegastos.model.db.expense

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * DAO used to interact with ExpenseEntity
 */
@Dao
interface ExpenseDAO {

    /**
     * Returns a LiveData containing a List of all Expenses saved on Database.
     */
    @Query("SELECT * FROM expense ORDER BY id ASC")
    fun getAllExpenses(): LiveData<List<ExpenseEntity>>

    /**
     * Inserts a list of ExpenseEntity into Database.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpenseList(expenseList: List<ExpenseEntity>)
}