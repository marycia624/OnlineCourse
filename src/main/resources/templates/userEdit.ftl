<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>DoWhile.Pro</title>
    <link rel="stylesheet" href="/static/style.css"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans:400,400i,500,500i,700,700i,800,800i,900,900i&display=swap"
          rel="stylesheet">
</head>

<body>
<div class="sign-in user-edit">
    <div class="empty"></div>

    <div class="center">

        <#if duplicateLogin??>
            <h2 class="error">${duplicateLogin}</h2>
        </#if>
        <#if duplicatEmail??>
            <h2 class="error">${duplicateEmail}</h2>
        </#if>
        <div class="form">
            <form action="/userEdit" method="post">
                <input type="hidden" name="id"/>
                <p><input class="data" type="text" name="login" placeholder="Введи логин" value="${user.login}" required></p>
                <p><input class="data" type="text" name="email" placeholder="Введи Email" value="${user.email}" required></p>
                <p><input class="enter-btn" id="submit" type="submit" value="Сохранить"></p>
            </form>
        </div>
    </div>
    <div class="pic-sign-in"></div>
</div>

</body>

</html>