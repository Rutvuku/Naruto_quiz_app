package com.example.naruto

object constants{

    const val USER_NAME: String ="User_name"
    const val TOTAL_QUESTIONS: String= "total_quesions"
    const val CORRECT_ANSWERS: String= "correct_answers"
    fun getquestions(): ArrayList<Questions>{
        val questionList = ArrayList<Questions>()
        val que1 = Questions(1,
            "what is sakura",
            R.drawable.sakura,
            "trash",
            "waifu",
            "dumbo",
            "sasuke's simp",
            1
        )
        questionList.add(que1)

        val que2 = Questions(2,
            "who's the ghost of uchiha",
            R.drawable.uchiha_clan,
            "madara",
            "itachi",
            "tobirama",
            "sasuke",
            1
        )
        questionList.add(que2)

        val que3 = Questions(3,
            "what's the favourite number of all naruto fans",
            R.drawable.tsunade,
            "28",
            "7",
            "106",
            "46",
            3
        )
        questionList.add(que3)

        val que4 = Questions(4,
            "what's the colour of shishui's susano",
            R.drawable.susano,
            "blue",
            "red",
            "pink",
            "green",
            4
        )
        questionList.add(que4)

        val que5 = Questions(5,
            "who is the taijutsu god",
            R.drawable.might_guy,
            "rock lee",
            "madara",
            "might guy",
            "might dai",
            3
        )
        questionList.add(que5)
        return questionList

    }
}