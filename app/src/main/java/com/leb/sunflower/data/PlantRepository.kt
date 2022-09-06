package com.leb.sunflower.data

import com.leb.sunflower.data.model.Plant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlantRepository @Inject constructor(){

    fun getPlants(): Flow<List<Plant>> {
        //TODO Flow?
        val p1 = Plant(
            "-1",
            "ShenZhen",
            "this is a very big city",
            7,
            7,
            "https://cdn.lingoace.com/homework/20220829/student-homework-0-lv1-16-1661814136219-92910-1191745360886615.jpeg"
        )
        val p2 = Plant(
            "-2",
            "Beijing",
            "this is a very big city",
            7,
            7,
            "https://cdn.lingoace.com/homework/20220829/student-homework-0-lv1-16-1661814136219-92910-1191745360886615.jpeg"
        )
        val p3 = Plant(
            "-3",
            "ShangHai",
            "this is a very big city",
            7,
            7,
            "https://cdn.lingoace.com/homework/20220829/student-homework-0-lv1-16-1661814136219-92910-1191745360886615.jpeg"
        )

        val data = mutableListOf<Plant>(p1, p2, p3).toList();
        return flowOf(data)
    }
}