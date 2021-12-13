package com.rohyme.testingmultiblebackstack.tetingFragmentB

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rohyme.testingmultiblebackstack.R

/**
 * Created by rohyme on 24/11/2021.
 **/
class TestingFragmentB3: Fragment(R.layout.test_fragment) {
    val navArgs by navArgs<TestingFragmentB3Args>()
    val testingTextView by lazy {
        requireView().findViewById<TextView>(R.id.testTextView).apply {
            text = navArgs.defaultArgument
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testingTextView.setOnClickListener {
        }
    }
}