<h1> Дипломный проект по профессии «Тестировщик» </h1>
<h4> Aвтоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.</h4>

<h3> Подготовка к работе </h3>
<ol>
<li> Создать план работы в файле Plan.md, с указанием выполняемых тест сценариев </li>
<li> Установить Браузер Google Chrome </li>
<li> Установить Git - систему контроля версий </li>
<li> Зарегистрироваться на сайте GitHUB </li>
<li> Установить IntelliJ IDEA </li>
<li> Установить программу Postman </li>
<li> Установить программу DBeaver </li>
<li> Установить программу Docker Desktop </li>
<li> Открыть программу IntelliJ IDEA </li>
<li> Создать проект на языке Java с использованием Gradle </li>
<li> Установить openjdk version 17.0.9 </li>
<li> Установить Gradle  8.4 </li>
<li> Установить Maven Central Repository </li>
<li> Настроить allure version 2.16.1 </li>
<li> Настроить JUnit5 в Allure version 2.16.1 </li>
<li> Настроить кодировку исходного кода sourceCompatibility - UTF-8 </li>
<li> Скачать зависимости lombok version 5.3.0 </li>
<li> Скачать плагин junit-jupiter v 5.9.0 </li>
<li> Скачать плагин selenide v 6.18.0 </li>
<li> Скачать плагин javafaker v 1.0.2 </li>
<li> Скачать плагин Allure Selenide  v 2.13.3 </li>
<li> Скачать драйвер PostgreSQL  v 42.5.4 </li>
<li> Скачать драйвер MySQL Connector v 8.0.33</li>
<li> Скачать библиотеку REST Assured   v 5.3.1 </li>
<li> Скачать библиотеку Gson v 2.10.1 </li>
<li> Скачать библиотеку Commons DbUtils  v 1.7 </li>
</ol>
<h3> Начало работы </h3>
<ol>
<li> Проанализировать тестк сценарий, согласно указанному плану в файле Plan.md </li>
<li> Через терминал запустить Docker контейнер командой: docker-compose up --build </li>
<li> Через терминал открыть БД MySQL командой: <br> java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar aqa-shop.jar </li>
<li> В браузере Сhrome открыть URL http://localhost/8080 </li>
<li> Запустить DBeaver, проверить соединения с MySQL, PostgreSQL </li>


</ol>