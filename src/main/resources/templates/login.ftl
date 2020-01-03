<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>DoWhile.Pro</title>
    <link rel="stylesheet" href="/static/style.css">
    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans:400,400i,500,500i,700,700i,800,800i,900,900i&display=swap"
          rel="stylesheet">
    </div>
</head>

<body>
<div class="sign-in">
    <div class="empty"></div>

    <div class="center">
        <div class="title">
            <div class="main-icon"></div>
            <h1>Добро пожаловать на DoWhile.Pro</h1>
            <p>Нет аккаунта? <a href=/signUp> Зарегистрироваться</a></p>
        </div>

        <#if RequestParameters.error??>
            <div class="error">
                Неверный логин или пароль
            </div>
        </#if>

        <#if message??>
            <p> class="error">${message}</p>
        </#if>

        <div class="form">
            <form action="/login" method="post">
                <p><input class="data" type="text" name="username" placeholder="Введите логин" /></p>
                <p><input class="data" type="password" name="password" placeholder="Введите пароль" /></p>
                <p><input class="enter-btn" type="submit" value="Вход"></p>
            </form>
        </div>
    </div>
    <div class="pic-sign-in"></div>
</div>

</body>

</html>