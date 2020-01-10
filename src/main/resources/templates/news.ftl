<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>DoWhile.Pro</title>
    <link rel="stylesheet" href="/static/style.css">
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
                    <li><a class="menu-link  menu-studing" href="#">Новости</a></li>
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

<div class="row-news row1">
    <#if nnews??>
        <#list nnews as one>
            <a class="column" href="/one-news/${one.id}">
                <div class="picture">${one.getImage()}</div>
                <div class="name-of-news news-title">
                    ${one.getShotNews()}
                </div>
            </a>
        </#list>
    </#if>
</div>


<div style="text-align: center">
 <#if roleAdmin??>
    <a class="menu-link" href="/addNews" style="font-size: 20px">Добавить новость</a>
 </#if>
</div>
</body>

</html>