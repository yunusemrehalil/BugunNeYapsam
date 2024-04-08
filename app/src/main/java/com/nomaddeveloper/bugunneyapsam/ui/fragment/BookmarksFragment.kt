package com.nomaddeveloper.bugunneyapsam.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nomaddeveloper.bugunneyapsam.BaseFragment
import com.nomaddeveloper.bugunneyapsam.databinding.FragmentBookmarksBinding

class BookmarksFragment : BaseFragment() {
    private lateinit var binding: FragmentBookmarksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookmarksBinding.inflate(layoutInflater)
        return binding.root
    }
}