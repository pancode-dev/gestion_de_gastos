package com.pancodedev.gestiondegastos.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pancodedev.gestiondegastos.model.db.expense.ExpenseDAO
import com.pancodedev.gestiondegastos.model.db.expense.ExpenseEntity

/**
 * This class holds the database of this project.
 */
@Database(entities = [ExpenseEntity::class], version = 1)
abstract class ExpenseManagerDatabase : RoomDatabase() {
    abstract fun expenseDAO() : ExpenseDAO

    companion object {
        @Volatile
        private var INSTANCE: ExpenseManagerDatabase? = null

        /**
         * returns a single instance of this database
         */
        fun getDatabase(context: Context): ExpenseManagerDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseManagerDatabase::class.java,
                    "expense_manager_database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}