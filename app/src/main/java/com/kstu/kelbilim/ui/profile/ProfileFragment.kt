package com.kstu.kelbilim.ui.profile

import Payments
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.kstu.kelbilim.R
import com.kstu.kelbilim.adapter.profile.ProfileAdapter
import com.kstu.kelbilim.common.RetrofitHeader
import com.kstu.kelbilim.service.AppPreferences
import com.kstu.kelbilim.service.Status
import com.kstu.kelbilim.service.model.Authen
import com.kstu.kelbilim.service.model.UserInfoModel
import com.kstu.kelbilim.service.response.payments.PaymentsResponse
import com.kstu.kelbilim.ui.start.StartActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : Fragment() {
    private val viewModel: ProfileViewModel by viewModel()
    private val header = RetrofitHeader()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    private fun initViews(data: PaymentsResponse) {
        profile_name.text = data.fullName
        profile_code.text = "Код платежа: ${data.account}"
        profile_debt.text = "Долг: ${data.dolg}"
        profile_group.text = data.groupName
        profile_payments_rv.adapter =
            ProfileAdapter(data.payments as ArrayList<Payments>)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewModel.getPayments(
            header.header("125"),
            UserInfoModel(AppPreferences.studentId!!.toInt(), Authen())
        ).observe(viewLifecycleOwner, Observer { result ->
            val data = result.data
            val msg = result.msg
            when (result.status) {
                Status.SUCCESS -> {
                    profile_name.text = data!!.fullName
                    profile_code.text = "Код платежа: ${data.account}"
                    profile_debt.text = "Долг: ${data.dolg.toInt()}"
                    profile_group.text = data.groupName
                    profile_payments_rv.adapter =
                        ProfileAdapter(data.payments)
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

        Glide.with(requireContext())
            .load("http://85.113.28.182:8086/api/studentphoto/" + AppPreferences.studentId + "/" + AppPreferences.mobileLogin + "/" + AppPreferences.mobilePassword)
            .error(R.drawable.ic_person)
            .into(profile_imageview)

        profile_exit_btn.setOnClickListener {
            val builder = AlertDialog.Builder(activity, R.style.AlertDialogCustom)

            builder.setTitle("Выйти?")
                .setPositiveButton("да") { dialog, which ->
                    AppPreferences.exit()
                    startActivity(Intent(context, StartActivity::class.java))
                }
                .setNegativeButton("нет") { dialog, which ->
                    dialog.dismiss()
                }
                .show()
        }
    }

}
