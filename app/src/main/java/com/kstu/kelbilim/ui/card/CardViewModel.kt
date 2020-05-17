package com.kstu.kelbilim.ui.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kstu.kelbilim.service.NetworkRepository
import com.kstu.kelbilim.service.Resource
import com.kstu.kelbilim.service.model.StudyCardModel
import com.kstu.kelbilim.service.response.studycard.StudyCardResponse

class CardViewModel : ViewModel() {
    private val repository = NetworkRepository()

    fun getStudyCard(
        headerMap: HashMap<String, String>,
        body: StudyCardModel
    ): LiveData<Resource<StudyCardResponse>> {
        return repository.getStudyCard(headerMap, body)
    }

}