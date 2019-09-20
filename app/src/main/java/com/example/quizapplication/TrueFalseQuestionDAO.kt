package com.example.quizapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TrueFalseQuestionDAO {
    @Query("Select * FROM trueFalseQuestions")
    fun getAll(): List<TrueFalseQuestionEntity>

    @Query("Select * FROM trueFalseQuestions WHERE question LIKE :question")
    fun findByQuestion(question: String): LiveData<List<TrueFalseQuestionEntity>>

    @Insert
    fun insertAll(vararg tfquestions: TrueFalseQuestionEntity)

    @Delete
    fun delete(tfquestion: TrueFalseQuestionEntity)

    @Update
    fun update(vararg tfquestions: TrueFalseQuestionEntity)

}