<h1> Отчет о тестировании </h1>
<h3> Автоматизация тестирования сервиса для покупки тура, взаимодействующего с СУБД и API Банка.</h3>
<h4> Описание: </h4>
Проведено тестирование веб-сервиса покупки тура, который взаимодействует с СУБД. Все тестовые сценарии автоматизированы. <br>
<h5>Веб-сервис тестировался по двум способам оплаты:</h5>
<ol>
<li> Оплата по дебетовой карте (Купить)</li>
<li> Оплата в кредит по данным банковской карты (Купить в кредит)</li>
</ol>
<h5> Протестирована поддержка двух СУБД:</h5>
<ol>
<li> MySQL </li>
<li> PostgreSQL </li>
</ol>
<h5> Тестовое окружение: </h5>
<ol>
<li> Операционная система: Ubuntu 23.10 </li>
<li> Java: OpenJDK version 11.0.21 </li>
<li> IDE: IntelliJ IDEA 2023.3.2 </li>
<li> DBeaver Version 23.2.0</li>
<li> Docker Desktop: version 4.26.0 </li>
<li> Google Chrome: Version 119.0.6045.159  (Официальная сборка), (64 бит)</li>
<li> ChromeDriver: Version 119.0.6045.105</li>
</ol>
<h3>Статистика успешных/неуспешных кейсов:</h3>
Было выполнено 56 автоматизированных тест-кейсов, из них:<br>
<ol>
   <li> Успешных(passed): 40 (63.15 %) </li>
   <li> Неуспешных(failed): 16 (36.85 %) </li>
   <li> Итого 71.42% </li>
   </ol>

Отчет по результатам тестирования (Allure Report): <br>

![Allure report1](https://github.com/Pexini/Diplom/assets/129457583/9ea52c14-6a8f-4a9e-b4b9-fba8d880ce5a)
![Allure Graphs](https://github.com/Pexini/Diplom/assets/129457583/a8fd0ac5-ec4f-4061-a9f5-3c409f2511a8)
![AllureSuites](https://github.com/Pexini/Diplom/assets/129457583/a7661d60-6ae9-447f-ac71-0568d7997411)
![AllurePackages Api](https://github.com/Pexini/Diplom/assets/129457583/2234edcc-0a0d-44d7-bc15-1b1849a24ff9)
![AllurePackagesCreditUiTest](https://github.com/Pexini/Diplom/assets/129457583/772a156f-75eb-47ef-9fda-d48fb0a91d4b)
![AllurePackedgesPayUiTest](https://github.com/Pexini/Diplom/assets/129457583/146d3093-a992-4f08-b9ec-80397faa54f3)

<h5> Созданы баг-репорты по найденным дефектам. </h5>
<li> Баги указаны в <a href="https://github.com/Pexini/Diplom/issues"> Issue </a> </li>

<h4> Общие рекомендации: </h4>
 <ol>
<li> Исправить баги указанные в <a href="https://github.com/Pexini/Diplom/issues"> Issue </a>  </li>
<li> Добавить в код тестовые метки (test-id)</li>
<li> Настроить изменение цвета при нажатии "Купить" и "Купить в кредит"</li>
</ol>




