<!DOCTYPE html>
<html lang="ru" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>DoWhile.Pro</title>
    <link rel="stylesheet" th:href="@{/css/style.css}">
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
                <a class="menu-link" href="@{/}">Главная</a>
                <a class="menu-link menu-news" href="#">Новости</a>
                <a class="menu-link " href="/studing">Обучение</a>
                <a class="menu-link" href="personal-account">Личный кабинет</a>
                <a class="menu-link" href="/logout">Выход</a>
            </nav>
        </div>
    </div>
</header>
<style>

</style>
<div class="row-news row1">
    <div class="column hi">
        <div class="picture picture-news-1-1"></div>
        <div class="name-of-news">
            <h5 class="news-title">
                Новый язык программирования, основанный на Rust</h5>
            <p>Компания Microsoft развивает новый язык программирования на основе Rust. Как пишет издание ZDnet,
                проект...</p>
        </div>
    </div>
    <div class="column">
        <div class="picture picture-news-1-2"></div>
        <div class="name-of-news">
            <h5 class="news-title">Cтатья</h5>
            <p>Кусочек статьи/новости для ознакомления. При нажатии полная версия</p>
        </div>
    </div>
    <div class="column">
        <div class="picture picture-news-1-3"></div>
        <div class="name-of-news">
            <h5 class="news-title">Cтатья</h5>
            <p>Кусочек статьи/новости для ознакомления. При нажатии полная версия</p>
        </div>
    </div>
</div>

<div class="row-news row2">
    <div class="column">
        <div class="picture picture-news-2-1"></div>
        <div class="name-of-news">
            <h5 class="news-title">Cтатья</h5>
            <p>Кусочек статьи/новости для ознакомления. При нажатии полная версия</p>
        </div>
    </div>
    <div class="column">
        <div class="picture picture-news-2-2"></div>
        <div class="name-of-news">
            <h5 class="news-title">Cтатья</h5>
            <p>Кусочек статьи/новости для ознакомления. При нажатии полная версия</p>
        </div>
    </div>
</div>


</body>

</html>