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
                <ul>
                    <#if roleHost??>
                        <li><a class="menu-link" href="/">Главная</a></li>
                    </#if>
                    <li><a class="menu-link  menu-studing" href="/news">Новости</a></li>
                    <#if roleUser??>
                        <li><a class="menu-link" href="#">Обучение</a>
                            <ul class="fall">
                                <li><a class="menu-link" href="/studing">Теория</a></li>
                                <li><a class="menu-link" href="/practice">Практика</a></li>
                            </ul>
                        </li>
                        <li><a class="menu-link" href="/personal-account">Личный кабинет</a></li>
                        <li><a class="menu-link" href="/logout">Выход</a></li>
                    </#if>
                    <#if roleHost??>
                        <li><a class="menu-link" href="/login">Вход</a></li>
                    </#if>
                </ul>
            </nav>
        </div>
    </div>
</header>

<div class="read-news">
    <div class="container">
        ${news.text}
        <#if roleAdmin??>
            <div style="text-align: right">
            <a class="menu-link" href="/editNews/${news.id}" style="font-size: 20px">Редактировать новость</a>
                <a class="menu-link" href="/deleteNews/${news.id}" style="font-size: 20px">Удалить новость</a>
            </div>
        </#if>
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
        <#if error??>
            <p class="error">${error}</p>
        </#if>
        <form name="comment" action="/comment/news/${news.id}" method="post">

            <p>
                <textarea name="message" placeholder="Оставь свой комментарий" rows="5"></textarea>
            </p>
            <p>
                <input type="submit" class="enter-btn comment-btn" value="Отправить комментарий"/>
            </p>
        </form>

        <#if comments??>
            <#list comments as comment>
                <div class="onecomment">
                    <strong>${comment.author.login}</strong>
                    <p>${comment.message}</p>
                </div>
            <#else>
                <div class="onecomment">
                    <p>No comments</p>
                </div>
            </#list>
        <#else>
        <div class="onecomment">
            <p>Пока нет комментариев... Будь первым!</p>
        </div>
        </#if>
    </div>

</div>
</body>
</html>