package com.example.yourteacher.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.yourteacher.domain.model.TeacherUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _teachers = MutableStateFlow<List<TeacherUiModel>>(emptyList())
    val teachers: StateFlow<List<TeacherUiModel>> = _teachers

    init {
        loadFakeData()
    }

    private fun loadFakeData() {
        _teachers.value = listOf(
            TeacherUiModel(
                id = "1",
                name = "أ. أحمد سمير",
                subject = "رياضيات",
                grade = "ثالث ثانوي",
                price = "100 ج / الحصة",
                schedule = "السبت - 4 م",
                location = "القاهرة - مدينة نصر",
                imageUrl = "https://picsum.photos/200/300",
            ),
            TeacherUiModel(
                id = "2",
                name = "أ. فاطمة علي",
                subject = "لغة إنجليزية",
                grade = "ثاني إعدادي",
                price = "80 ج / الحصة",
                schedule = "الأحد - 6 م",
                location = "أونلاين",
                imageUrl = "https://picsum.photos/200/300",
            )
        )
    }
}
