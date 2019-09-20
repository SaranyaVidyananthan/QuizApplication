package com.example.quizapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trueFalseQuestions")
data class TrueFalseQuestionEntity(
    @PrimaryKey(autoGenerate = true)
    var qid: Int,

    @ColumnInfo(name = "question") var question: String,

    @ColumnInfo(name = "answer") var answer: Boolean
)

