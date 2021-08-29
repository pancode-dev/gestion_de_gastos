package com.pancodedev.gestiondegastos.model.db.expense

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity representing the "expense" table.
 */
@Entity(tableName = "expense")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "expense_name") val expenseName: String,
    @ColumnInfo(name = "expense_amount") val expenseAmount: Float)