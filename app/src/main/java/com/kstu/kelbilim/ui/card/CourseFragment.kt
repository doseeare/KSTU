package com.kstu.kelbilim.ui.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.kstu.kelbilim.R
import com.kstu.kelbilim.adapter.studycard.StudyCardAdapter
import com.kstu.kelbilim.common.RetrofitHeader
import com.kstu.kelbilim.service.AppPreferences
import com.kstu.kelbilim.service.Status
import com.kstu.kelbilim.service.model.Authen
import com.kstu.kelbilim.service.model.StudyCardModel
import com.kstu.kelbilim.service.response.studycard.CardDiciplines
import kotlinx.android.synthetic.main.fragment_course.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class CourseFragment(course: Int) : Fragment() {
    private val course = course
    private val viewModel: CardViewModel by viewModel()
    private val header = RetrofitHeader()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        when (course) {
            1 -> {
                getStudyCard(1)
                course_btn1.text = "1 сем"
                course_btn2.text = "2 сем"
                course_btn3.text = "2 лет"
                course_semester_rg.setOnCheckedChangeListener { group, checkedId ->
                    when (checkedId) {
                        R.id.course_btn1 -> getStudyCard(1)
                        R.id.course_btn2 -> getStudyCard(2)
                        R.id.course_btn3 -> getStudyCard(18)
                    }
                }
            }
            2 -> {
                getStudyCard(1)
                course_btn1.text = "3 сем"
                course_btn2.text = "4 сем"
                course_btn3.text = "4 лет"
                course_semester_rg.setOnCheckedChangeListener { group, checkedId ->
                    when (checkedId) {
                        R.id.course_btn1 -> getStudyCard(3)
                        R.id.course_btn2 -> getStudyCard(4)
                        R.id.course_btn3 -> getStudyCard(19)
                    }
                }
            }
            3 -> {
                getStudyCard(1)
                course_btn1.text = "5 сем"
                course_btn2.text = "6 сем"
                course_btn3.text = "6 лет"

                course_semester_rg.setOnCheckedChangeListener { group, checkedId ->
                    when (checkedId) {
                        R.id.course_btn1 -> getStudyCard(5)
                        R.id.course_btn2 -> getStudyCard(6)
                        R.id.course_btn3 -> getStudyCard(7)
                    }
                }
            }

        }
    }

    private fun getStudyCard(id: Int) {
        viewModel.getStudyCard(
            header.header("125"),
            StudyCardModel(AppPreferences.studentId!!.toInt(), id, Authen())
        ).observe(viewLifecycleOwner, Observer { result ->
            val data = result.data
            val msg = result.msg
            when (result.status) {
                Status.SUCCESS -> {
                    if (data!!.studentID != 0){
                        course_card_rv.visibility = View.VISIBLE
                        course_card_rv.adapter =
                            StudyCardAdapter(data!!.cemesters[0].diciplines as ArrayList<CardDiciplines>)
                    }else{
                        course_card_rv.visibility = View.GONE
                    }
                }
                Status.ERROR -> {
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
                }
                Status.NETWORK -> {
                    Toast.makeText(context, "Проблемы с интернетом", Toast.LENGTH_LONG)
                        .show()
                }
                else -> {
                    Toast.makeText(context, "Произошла ошибка", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}

