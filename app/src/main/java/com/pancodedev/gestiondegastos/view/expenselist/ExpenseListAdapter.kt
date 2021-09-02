package com.pancodedev.gestiondegastos.view.expenselist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pancodedev.gestiondegastos.databinding.ExpenseItemBinding
import com.pancodedev.gestiondegastos.model.db.expense.ExpenseEntity
import com.pancodedev.gestiondegastos.util.NumberFormat

class ExpenseListAdapter(private var ExpenseListDataSet: List<ExpenseEntity>):
    RecyclerView.Adapter<ExpenseListAdapter.ExpenseListViewHolder>() {

    inner class ExpenseListViewHolder(binding: ExpenseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var textviewExpenseName = binding.textviewExpenseName
        var textviewExpenseAmount = binding.textviewExpenseAmount

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseListViewHolder {
        val binding =
            ExpenseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpenseListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ExpenseListDataSet.size
    }

    override fun onBindViewHolder(holder: ExpenseListViewHolder, position: Int) {
        val post = ExpenseListDataSet[position]

        holder.textviewExpenseName.text = post.expenseName
        holder.textviewExpenseAmount.text = NumberFormat.formatFloat(post.expenseAmount)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDataSet(newDataSet: List<ExpenseEntity>) {
        ExpenseListDataSet = newDataSet
        notifyDataSetChanged()
    }

}