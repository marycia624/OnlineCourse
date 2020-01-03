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
                <a class="menu-link" href="#">Новости</a>
                <a class="menu-link" href="#">Обучение</a>
                <a class="menu-link" href="#">Личный кабинет</a>
                <a class="menu-link" href="#">Выход</a>
            </nav>
        </div>
    </div>
</header>


<div class="training-progress">
    <h1>Твой прогресс</h1>
    <progress value="15" max="100">
        Загружено на <span id="value">25</span>%
    </progress>
</div>
<div class="personal-account">
    <div class="information">
        <h1> Личная информация </h1>
        <div class="account">
            <div class="first">
                <div class="photo"></div>
                <form>
                    <a href="#">Добавить
                </form>
                </a>
            </div>
            <div class="info">
                <p>${user.login}</p>
                <p>${user.email}</p>
            </div>
        </div>
        <a class="change" href="/userEdit">Изменить</a>
    </div>

    <div class="statistics">
        <h1>Статистика за месяц</h1>
    </div>
</div>

</body>
</html>