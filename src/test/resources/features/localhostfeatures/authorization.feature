# language: ru

@Epic:Запросы_с_данными_из_JSON_файла
@Owner:Filimonova
Функция: Авторизация

  @Feature:Авторизация
  @Story:Авторизация_с_подменой_данных
  @allure.tms:2
  @regress @auth
  Структура сценария: Авторизация
    Дано регистрируемся
    Тогда статускод <code>
    Когда авторизуемся с измененным <userData>
    Тогда статускод <code1>
    Когда авторизуемся с измененным <userData1>
    Тогда статускод <code1>
    Когда авторизуемся с валидными данными
    Тогда статускод <code>
    Примеры:
      | userData   | userData1  | code | code1       |
      | "username" | "password" | "ok" | "not.found" |