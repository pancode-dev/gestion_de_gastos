package com.pancodedev.gestiondegastos.view.expenselist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.pancodedev.gestiondegastos.databinding.FragmentExpenseListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ExpenseListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExpenseListFragment : Fragment() {
    private lateinit var binding: FragmentExpenseListBinding
    private lateinit var viewModel: ExpenseListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExpenseListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExpenseListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ExpenseListFragment.
         */
        @JvmStatic
        fun newInstance() =
            ExpenseListFragment()
    }
}