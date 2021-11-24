package com.rohyme.testingmultiblebackstack.testingFragmentA

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.rohyme.testingmultiblebackstack.R

/**
 * Created by rohyme on 24/11/2021.
 **/
class TestingFragmentA1: Fragment(R.layout.test_fragment) {
    val navArgs by navArgs<TestingFragmentA1Args>()
    val testingTextView by lazy {
        requireView().findViewById<TextView>(R.id.testTextView).apply {
            text = navArgs.defaultArgument
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testingTextView.setOnClickListener {
             findNavController().navigate(R.id.action_testingFragmentA1_to_testingFragmentA2)
        }
    }
}