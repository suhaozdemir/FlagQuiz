package com.suhaozdemir.flagquiz

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

     fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_argentina,
            "Australia",
            "Argentina",
            "Austria",
            "Angola",
            2
        )
        questionList.add(question1)

        val question2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_croatia,
            "Canada",
            "Cambodia",
            "Croatia",
            "Chile",
            3
        )
        questionList.add(question2)

        val question3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_finland,
            "Finland",
            "France",
            "Fiji",
            "Faroe Islands",
            1
        )
        questionList.add(question3)

        val question4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_georgia,
            "Guatemala",
            "Germany",
            "Ghana",
            "Georgia",
            4
        )
        questionList.add(question4)

        val question5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_lebanon,
            "Luxembourg",
            "Lebanon",
            "Latvia",
            "Lichtenstein",
            2
        )
        questionList.add(question5)

        val question6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_netherlands,
            "Netherlands",
            "Norway",
            "Nigeria",
            "New Zealand",
            1
        )
        questionList.add(question6)

        val question7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_portugal,
            "Pakistan",
            "Poland",
            "Portugal",
            "Paraguay",
            3
        )
        questionList.add(question7)

        val question8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_sweden,
            "Singapore",
            "Serbia",
            "Switzerland",
            "Sweden",
            4
        )
        questionList.add(question8)

        val question9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_switzerland,
            "Singapore",
            "Switzerland",
            "Singapore",
            "Sudan",
            2
        )
        questionList.add(question9)

        val question10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_turkey,
            "Turkey",
            "Tunisia",
            "Turkmenistan",
            "Tajikistan",
            1
        )
        questionList.add(question10)
        return questionList
    }
}