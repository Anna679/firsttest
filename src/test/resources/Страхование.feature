#language: ru
  Функционал: Страхование

    Сценарий: Заявка на Страхование путешественников

      Когда выбран пункт меню "Застраховать себя "
      И выбран вид страхования "Страхование путешественников"
      Тогда выполнено нажатие на кнопку -Оформить онлайн
      Когда переключение в другое окно
      Когда выбрана сумма-программа страхования "Минимальная"
      Тогда заполняются поля:
        |Фамилия застрахованного|Petrov|
        |Имя застрахованного|Petr|
        |Дата рождения застрахованного|01.01.1990|
        |Фамилия|Иванов|
        |Имя|Иван|
        |Отчество|Иванович|
        |Дата рождения|01.01.1990|
        |Серия паспорта|4515|
        |Номер паспорта|111111|
        |Дата выдачи|01.01.2004|
        |Кем выдан|Москва|
     И проверяются поля, что заполненны правильными значениями:
       |Фамилия застрахованного|Petrov|
       |Имя застрахованного|Petr|
       |Дата рождения застрахованного|01.01.1990|
       |Фамилия|Иванов|
       |Имя|Иван|
       |Отчество|Иванович|
       |Дата рождения|01.01.1990|
       |Серия паспорта|4515|
       |Номер паспорта|111111|
       |Дата выдачи|01.01.2004|
       |Кем выдан|Москва|

      Когда нажата кнопка - Продолжить
      Тогда Вызов ошибки
