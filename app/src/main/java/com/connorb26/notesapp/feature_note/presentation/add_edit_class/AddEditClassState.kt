package com.connorb26.notesapp.feature_note.presentation.add_edit_class

import com.connorb26.notesapp.feature_note.domain.model.ClassTime
import com.connorb26.notesapp.feature_note.domain.model.Exam
import com.connorb26.notesapp.feature_note.domain.model.Homework

data class AddEditClassState (
    val name: String = "",
    val location: String = "",
    var classTimes: List<ClassTime> = emptyList(),
    val exams: List<Exam> = emptyList(),
    val homeworkList: List<Homework> = emptyList()
)