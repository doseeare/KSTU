package com.kstu.kelbilim.ui.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kstu.kelbilim.R
import com.kstu.kelbilim.adapter.viewpager.FragmentVPAdapter
import kotlinx.android.synthetic.main.fragment_card.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardFragment : Fragment() {

    private val cardViewModel: CardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val vpAdapter = FragmentVPAdapter(childFragmentManager)
        vpAdapter.addFragment(CourseFragment(1), "1 курс")
        vpAdapter.addFragment(CourseFragment(2), "2 курс")
        vpAdapter.addFragment(CourseFragment(3), "3 курс")

        card_vp.adapter = vpAdapter
        card_tabs!!.setupWithViewPager(card_vp)
    }
}
