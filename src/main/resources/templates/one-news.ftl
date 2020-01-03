<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>DoWhile.Pro</title>
    <link rel="stylesheet" href="../static/style.css">
    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans:400,400i,500,500i,700,700i,800,800i,900,900i&display=swap"
          rel="stylesheet">
</head>

<body>
<header>
    <div class="container">
        <div class="header-inner">
            <div class="logo">
                <h1>DoWhile.Pro</h1>
            </div>
            <nav class="main-menu">
                <a class="menu-link" href="/">Главная</a>
                <a class="menu-link menu-news" href="#">Новости</a>
                <a class="menu-link " href="/studing">Обучение</a>
                <a class="menu-link" href="/personal-account">Личный кабинет</a>
                <a class="menu-link" href="/logout">Выход</a>
            </nav>
        </div>
    </div>
</header>

<div class="read-news">
    <div class="container">
        <p>Привет, комментируй!</p>
        <!--h1 class="title"> Microsoft создаёт новый язык программирования, основанный на Rust </h1>
        <p>Компания Microsoft развивает новый язык программирования на основе Rust. Как пишет издание ZDnet, проект
            получил название Verona. Планируется, что на его основе Microsoft перепишет некоторые компоненты Windows 10,
            чтобы решить проблемы с безопасностью.</p>
        <p>Как указывает ZDnet со ссылкой на Мэтта Миллера, специалиста Microsoft по безопасности, около 70% всех
            уязвимостей, которые были обнаружены в продуктах Microsoft в последние годы, были связаны с ошибками
            управления памятью. Это происходит потому, что языки C и C++, которые традиционно используют для создания
            системного ПО, передают управление оперативной памятью разработчику. Это неизбежно приводит к ошибкам.
        </p>
        <p>Новый язык Microsoft на базе Rust должен, в отличие от C и C++, реализовывать механизм автоматического
            управления памятью. Отличие нового языка от Rust заключается в применении концепции владения не единичными
            объектами, а группами объектов. Репозиторий проекта уже опубликован на Github.
        </p>
        <p>Rust был разработан в 2006 году Грейдоном Хоаром, работавшим в Mozilla. Через три года Mozilla начала
            вкладывать деньги в развитие Rust и расширила команду по его разработке. Заинтересованность Mozilla в Rust
            была связана, как пишет ZDnet, с большим числом критических уязвимостей в браузере Firefox — более 4 млн
            строк браузера было написано на C++. </p>
        <p>В августе 2019 года Джош Триплетт, ведущий инженер Intel, сообщил о том, что Intel заинтересована в том,
            чтобы впоследствии Rust стал равноценен языку C. Кроме Mozilla и Microsoft, языком Rust пользуются в Google,
            Dropbox, Facebook, Amazon, Fastly и других компаниях.</p>
        <p class="date-of-news">вчера в 12:34</p-->
    </div>
</div>

<div class="comments">
    <div class="container">
        <form name="comment" action="/comment" method="post">

            <p>
                <textarea name="message" placeholder="Оставь свой комментарий" rows="5"></textarea>
            </p>
            <p>
                <input type="submit" class="enter-btn comment-btn" value="Отправить комментарий"/>
            </p>
        </form>
    </div>

    <#list comments as comment>
        <div>
            <b>${comment.id}</b>
            <span>${comment.message}</span>
            <strong>${comment.author}</strong>
        </div>
    <#else>
        No comments
    </#list>
</div>
</body>
</html>