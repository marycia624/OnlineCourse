
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
                    <li><a class="menu-link" href="/news">Новости</a></li>
                    <li><a class="menu-link" href="#">Обучение</a>
                        <ul class="fall">
                            <li><a class="menu-link" href="/studing">Теория</a></li>
                            <li><a class="menu-link" href="/practice">Практика</a></li>
                        </ul>
                    </li>
                    <li><a class="menu-link  menu-studing" href="/#">Личный кабинет</a></li>

                    <li><a class="menu-link" href="/logout">Выход</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<div style="text-align: center; padding-top: 190px">
    <#if user.activationCode??>
        <p class="error"> Ваш аккаунт не активирован </p>
    </#if>
</div>
<div class="personal-account">
    <div class="information">
        <h1> Личная информация </h1>
        <div class="account">
            <div class="first">
                    <#if user.photo??>
                    <img alt="nothing" class="photo" src="/img/${user.photo}" >
                    </#if>
                <form id="upload-container"  action="/image" method="post" enctype="multipart/form-data">
                    <div>
                        <input id="file-input" type="file" name="file">
                        <label for="file-input">Загрузить фото</label>
                        <input type="submit" name="submit" value="Изменить" />
                    </div>
                </form>
            </div>
            <div class="info">
                <p>${user.login}</p>
                <p>${user.email}</p>
            </div>
        </div>
        <a class="change" href="/userEdit">Изменить</a>
    </div>

    <div class="statistics">
        <h1>Твой прогресс</h1>
        <progress value="${points}" max="${maxvalue}">
            Загружено на <span id="value">25</span>%
        </progress>
    </div>
</div>

</body>
</html>