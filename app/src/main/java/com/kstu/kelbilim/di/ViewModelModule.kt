package com.kstu.kelbilim.di


import com.kstu.kelbilim.ui.card.CardViewModel
import com.kstu.kelbilim.ui.login.LoginViewModel
import com.kstu.kelbilim.ui.profile.ProfileViewModel
import com.kstu.kelbilim.ui.schedule.ScheduleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    // viewModel { ProfileViewModel()}
    viewModel { LoginViewModel() }
    viewModel { ScheduleViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { CardViewModel() }
}