package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged

// Это однострочный комментарий
// MainActivity - класс, отвечающий за логику на нашем экране
class MainActivity : AppCompatActivity() {

    /*
    Это многострочный комментарий

    Обьявим и проинициализируем две переменные etTextInput и tvTextOutput
    Их мы будем использовать для представления элементов для ввода и отображения текста
    В данном случае переменные инициализируется при помощи делегата "lazy", то есть, лениво
    Это позволяет проинизиализировать переменную лишь однажды при обращении к ней
     */

    // Чтобы найти нужный элемент вызовем функцию findViewById с параметром типа этого элемента
    // В данном случае EditText
    // Также передадим в качестве аргумента присвоенный элементу Id таким образом: R.id.etTextInput
    private val etTextInput by lazy { findViewById<EditText>(R.id.etTextInput) }
    private val tvTextOutput by lazy { findViewById<TextView>(R.id.tvTextOutput) }

    // Функция обратного вызова жизненного цикла активности, в которой обьявим нашу логику
    // Создадим функцию "initTextWatching()" и вызовем её из метода onCreate()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTextWatching()
    }

    private fun initTextWatching() {
        // Здесь из нашего EditText вызываем функцию doOnTextChanged(), которая
        // принимает в качестве аргумента лямбду и будет вызывать её в момент изменения текста
        // Лямба принимает 4 аргмента, но нам нужен лишь первый "text"
        // Данный аргумент возвращает символьную последовательность с измененным текстом
        etTextInput.doOnTextChanged { text, _, _, _ ->

            // Здесь мы обновляем текст в TextView
            tvTextOutput.text = text
        }
    }
}
