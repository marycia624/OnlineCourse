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

        <div class="form">
            <form action="/editPassword" method="post">
                <p><input class="data" type="password" name="old_password" placeholder="Введите старый пароль" required></p>
                <p><input class="data password" id="p1" type="password" name="password" placeholder="Введите новый пароль" required></p>
                <p><input class="data cor_password" id="p2" type="password" placeholder="Повтори новый пароль" required></p>
                <div class="error"></div>
                <p><input class="enter-btn" id="submit" type="submit" value="Сохранить"></p>


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