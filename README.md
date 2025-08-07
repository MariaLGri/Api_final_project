
<p align="center">
  <a href="https://reqres.in/" target="_blank" title="Официальный сайт" style="text-decoration: none;">
    <img src="media/pictures/logo_main_api.PNG" alt="HAR Logo" width="900" height="500" style="border: 0;">
    <br>
    <span style="color: #0066cc; font-size: 1.25rem; font-weight: 600; margin-top: 8px; display: inline-block;">
         </span>
  </a>
</p>

<div align="center">
  <h2> ПРОЕКТ API АВТОМАТИЗАЦИИ | <a href="https://reqres.in/" target="_blank" title="Официальный сайт" style="text-decoration: none;"> REQRES </a> </h2>
</div>

---
<table>
  <tr>
    <td style="background-color: #f5f9ff; padding: 20px; border: 1px solid #e0e8f5;">

## :scroll: Содержание:

- [Используемый стек](#используемый-стек)
- [Запуск автотестов](#запуск-автотестов)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Интеграция](#Интеграция)
- [Уведомления в Telegram](#уведомления-в-telegram)


---

<a id="используемый-стек"></a>

# :computer: Используемый стек

<br>

<p align="center">
  <a href="https://www.jetbrains.com/idea/" target="_blank"><img width="50px" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.png" alt="IntelliJ IDEA"></a>
  <a href="https://www.java.com/" target="_blank"><img width="50px" title="Java" src="media/icons/Java.png" alt="Java"></a>
  <a href="https://docs.qameta.io/allure/" target="_blank"><img width="50px" title="Allure Report" src="media/icons/Allure_Report.png" alt="Allure Report"></a>
  <a href="https://gradle.org/" target="_blank"><img width="50px" title="Gradle" src="media/icons/Gradle.png" alt="Gradle"></a>
  <a href="https://junit.org/junit5/" target="_blank"><img width="50px" title="JUnit5" src="media/icons/JUnit5.png" alt="JUnit5"></a>
  <a href="https://github.com/" target="_blank"><img width="50px" title="GitHub" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/github/github-original.svg" alt="GitHub"></a>
  <a href="https://www.jenkins.io/" target="_blank"><img width="50px" title="Jenkins" src="media/icons/Jenkins.png" alt="Jenkins"></a>
  <a href="https://rest-assured.io/" target="_blank"><img width="50px" title="RestAssured" src="media/icons/RestAssured.svg" alt="Jenkins"></a>
  <a href="https://docs.qameta.io/allure-testops/" target="_blank"><img width="50px" title="AllureTestOps" src="media/icons/AllureTestOps.svg" alt="Allure TestOps"></a>
  <a href="https://telegram.org/" target="_blank"><img width="50px" title="Telegram" src="media/icons/Telegram.png" alt="Telegram"></a>
</p>

<br>

Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка <code>
RestAssured</code>, сборщик - <code>Gradle</code>. <code>JUnit 5</code> задействован в качестве фреймворка модульного
тестирования.

При прогоне тестов применяется Allure-отчет с отправкой результатов в <code>Telegram</code> при помощи бота. Так же реализована интеграция с <code>Allure TestOps</code>


<br>

### ✅ Проверки

- ✔️ **Успешная регистрация пользователя с валидными данными**
- ✔️ **Параметризованная проверка валидных email**
- ✔️ **Проверка запроса на получение списка пользователей**
- ✔️ **Параметризированная проверка запроса на создание пользователей**
- ✔️ **Проверка запроса на редактирование пользователя**
- ✔️ **Проверка запроса на удаление пользователя**

<br>

<a id="запуск-автотестов"></a>

### ✨ | 🖥️ Запуск автотестов | ✨

```
 gradle clean test -Denv=local
 gradle clean test -Denv=remote


```

При выполнении данной команды в терминале IDE тесты запустятся на выполнение.

<br>

---

<a id="сборка-в-jenkins"></a>
<p align="center"> 

# <img width="40px" style="vertical-align:middle" src="media/pictures/Jenkins_logo.png" alt="Jenkins Logo"> Сборка в <a href="https://jenkins.autotests.cloud/job/035_Api_final_project_GrishinaML/" target="_blank"> Jenkins </a>

</p>

_Jenkins — инструмент для автоматизации:_

- _✔️ Сборка и тестирование кода при каждом изменении (CI);_

- _✔️ Развертывание (CD) в тестовые/prod-среды;_

- _✔️ Контроль качества (проверка компиляции, тесты, анализ);_

- _✔️ Экономия времени за счёт замены ручных процессов;_

_Работает с любыми языками, гибко настраивается через плагины и скрипты.
Подходит для командной разработки, чтобы быстро находить ошибки и ускорять выпуск версий._


Для запуска сборки необходимо перейти в раздел <code> Build with Parameters:</code> и нажать кнопку <code>Build</code>.
<p align="center">

<img title="Jenkins Build" src="media/pictures/buildAPI.PNG">
</p>

После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значки <code>Allure
Report</code>, при клике на которую откроется страница с сформированным отчетом.

<br>

---

<a id="пример-allure-отчета"></a>
<p align="center">



# <img width="38" style="vertical-align:middle" alt="Allure Report" src="media/icons/Allure_Report.png"> Пример <a href="https://jenkins.autotests.cloud/job/035_Api_final_project_GrishinaML/8/allure/" target="_blank" rel="noopener noreferrer">Allure  </a> отчета 
_Allure Report_ — это визуализированный отчёт о тестировании, который делает результаты запусков автотестов удобными для анализа.

### _Преимущества:_
- _Наглядность_
    - Дерево тестов, графики, скриншоты, шаги выполнения.
- _Детализация_
    - Логи, ошибки, параметры тестов (например, данные из CSV).
- _Интеграция_
    - Работает с JUnit, TestNG, pytest, Selenium и CI-инструментами (Jenkins, TeamCity).
- _История запусков_
    - Сравнение результатов по времени (тренды, регрессы).

<br>

### ✨ | 📑 Содержание Allure-отчета | ✨

* Шаги теста;
* Логи браузерной консоли;


<br>

### 🔍 Обзор

<p align="center">
  <a href="https://jenkins.autotests.cloud/job/035_Api_final_project_GrishinaML/8/allure/" target="_blank" rel="noopener noreferrer">
    <img src="media/pictures/allure0.PNG" alt="Allure Overview Dashboard" style="border: 1px solid #ddd; border-radius: 4px; padding: 5px;">
  </a>
</p>

### 📂 Группы тестов
<p align="center">
  <a href="https://jenkins.autotests.cloud/job/035_Api_final_project_GrishinaML/8/allure/#suites" target="_blank" rel="noopener noreferrer">
    <img src="media/pictures/allure1.PNG" alt="Allure Test Suites" style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; margin-top: 20px;">
  </a>
</p>

### 📈 Анализ тестов

<p align="center">
  <a href="https://jenkins.autotests.cloud/job/035_Api_final_project_GrishinaML/8/allure/#graph" target="_blank" rel="noopener noreferrer">
    <img src="media/pictures/allure2.PNG" alt="Allure Analytics Graph" style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; margin-top: 20px;">
  </a>
</p>

<br>

---

<a id="Интеграция"></a>

# <img width="38" src="media/icons/AllureTestOps.svg" alt="Allure TestOps"> Интеграция с <a href="https://allure.autotests.cloud/launch/47530/tree?search=W3siaWQiOiJzdGF0dXMiLCJ0eXBlIjoidGVzdFN0YXR1c0FycmF5IiwidmFsdWUiOlsicGFzc2VkIl19XQ%3D%3D&treeId=0" target="_blank">Allure TestOps</a>
_Allure TestOps_ — это платформа для управления тестированием на базе Allure Report с расширенными возможностями.

### _Основные функции:_
- _Централизованное_ хранение и анализ результатов тестов
- _Интеллектуальная_ аналитика и дашборды
- _Интеграция_ с популярными CI/CD и тест-фреймворками


<p align="center">
   <br>
<img src="media/pictures/allureTestOpsApi.PNG">
</p>

<br>

---

<a id="уведомления-в-telegram"></a>

# <img width="38" style="vertical-align:middle" title="Telegram" src="media/icons/Telegram.png"> Результат выполнения автотестов в Телеграм

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет
сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="600" title="Telegram Notifications" src="media/pictures/telegram.PNG">
</p>

<br>

---

   </td>
  </tr>
</table>