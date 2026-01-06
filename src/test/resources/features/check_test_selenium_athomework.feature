# language: ru

@bug @ui
Функция: Поиск задачи

  Структура сценария: Поиск задачи и проверка атрибутов
    Дано пользователь авторизован
    И пользователь переходит на страницу Тест
    Тогда открыта тестовая страница
    Когда пользователь ищет задачу <nametask>
    Тогда статус задачи <expected>
    И версия фикса <expected1>
    Примеры:
      | nametask         | expected             | expected1                |
      | "TEST_TASK_NAME" | "STATUS_VALUE_TO_DO" | "EXPECTED_VERSION_VALUE" |