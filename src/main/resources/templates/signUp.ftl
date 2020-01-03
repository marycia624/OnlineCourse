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
<div class="sign-in">
    <div class="empty"></div>

    <div class="center">
        <div class="title">
            <div class="main-icon"></div>
            <h1>Добро пожаловать на DoWhile.Pro</h1>
            <p>Уже есть аккаунт? <a href="/login"> Войти</a></p>
        </div>
        <h2>${duplicateLogin}</h2>
        <h2>${duplicateEmail}</h2>
        <div class="form">
            <form action="signUp" method="post">
                <input type="hidden" name="id"/>
                <p><input class="data" type="text" name="login" placeholder="Придумай логин"
                          pattern="[a-z,A-Z,0-9]{5-20}" required></p>
                <p><input class="data" type="email" name="email" placeholder="Введи Email" pattern="[a-z,A-Z,0-9]{5-20}"
                          required></p>
                <p><input class="data password" id="p1" type="password" name="password" placeholder="Придумай пароль"
                          pattern="[a-z,A-Z,0-9]{5-20}" required></p>
                <p><input class="data cor_password" id="p2" type="password" placeholder="Повтори пароль"
                          pattern="[a-z,A-Z,0-9]{5-20}" required></p>
                <div class="error"></div>
                <p><input class="enter-btn" id="submit" type="submit" value="Зарегистрироваться"></p>


                <script>
                    $(".cor_password").on("keyup", function () { // Выполняем скрипт при изменении содержимого 2-го поля

                        var value_input1 = $(".password").val(); // Получаем содержимое 1-го поля
                        var value_input2 = $(this).val(); // Получаем содержимое 2-го поля

                        if (value_input1 != value_input2) { // Условие, если поля не совпадают

                            $(".error").html("Пароли не совпадают!"); // Выводим сообщение
                            $("#submit").attr("disabled", "disabled"); // Запрещаем отправку формы

                        } else { // Условие, если поля совпадают

                            $("#submit").removeAttr("disabled");  // Разрешаем отправку формы
                            $(".error").html(""); // Скрываем сообщение

                        }

                    });

                </script>


            </form>
        </div>
    </div>
    <div class="pic-sign-in"></div>
</div>

</body>

</html>