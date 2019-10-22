# TODO List

### Подготовка к запуску
Перед сборкой проекта нужно создать базу данных(я использовал PosgreSQL) и добавить ее параметры в файл application.properties

### Запуск
Для запуска, нужен установленный Maven.

В директории todo_list_project выполните следующие команды из терминала:
- mvn clean package
- java -jar target/todo_list_project-0.0.1-SNAPSHOT.jar

Swagger лежит на http://localhost:8080/swagger-ui.html

