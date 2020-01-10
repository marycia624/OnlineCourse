<!DOCTYPE html>
<html lang="ru" >
<head>
    <meta charset="utf-8">
    <title>DoWhile.Pro</title>
    <link rel="stylesheet" href="/static/style.css"/>
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
                    <li><a class="menu-link menu-studing" href="#">Обучение</a>
                        <ul class="fall">
                            <li><a class="menu-link" href="#">Теория</a></li>
                            <li><a class="menu-link" href="/practice">Практика</a></li>
                        </ul>
                    </li>
                    <#if roleAdmin??>
                        <li><a class="menu-link" href="/addTheory">Добавить</a></li>
                    </#if>
                    <li><a class="menu-link" href="/personal-account">Личный кабинет</a></li>

                    <li><a class="menu-link" href="/logout">Выход</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>



<div class="studing">
    <div class="tasks">
        <div class="task task-1" data-num="1">Задание 1</div>
        <div class="task task-2" data-num="2">Задание 2</div>
        <div class="task task-3" data-num="3">Задание 3</div>
        <div class="task task-4" data-num="4">Задание 4</div>
        <div class="task task-5" data-num="5">Задание 5</div>
        <div class="task task-6" data-num="6">Задание 6</div>
        <div class="task task-7" data-num="7">Задание 7</div>
        <div class="task task-8" data-num="8">Задание 8</div>
        <div class="task task-9" data-num="9">Задание 9</div>
        <div class="task task-10" data-num="10">Задание 10</div>
        <div class="task task-11" data-num="11">Задание 11</div>
        <div class="task task-12" data-num="12">Задание 12</div>
        <div class="task task-13" data-num="13">Задание 13</div>
        <div class="task task-14" data-num="14">Задание 14</div>
        <div class="task task-15" data-num="15">Задание 15</div>
        <div class="task task-16" data-num="16">Задание 16</div>
        <div class="task task-17" data-num="17">Задание 17</div>
        <div class="task task-18" data-num="18">Задание 18</div>
        <div class="task task-19" data-num="19">Задание 19</div>
        <div class="task task-20" data-num="20">Задание 20</div>
        <div class="task task-21" data-num="21">Задание 21</div>
        <div class="task task-21" data-num="22">Задание 22</div>
        <div class="task task-23" data-num="23">Задание 23</div>
        <div class="task task-24" data-num="24">Задание 24</div>
        <div class="task task-25" data-num="25">Задание 25</div>
        <div class="task task-26" data-num="26">Задание 26</div>
        <div class="task task-27" data-num="27">Задание 27</div>

    </div>

    <div class="theory-and-practice">
        <div class="theories">
            <div class="theory" id="theory1">
                <img src="/img/41dcaff7-5cbe-4e22-a2db-880a0a23e54b.1.png" />
                <img src="/img/fcfa5595-d6eb-4297-bbd2-3ebfab5c5850.2.png" />
            </div>
            <div class="theory" id="theory2">
                <img src="/img/25a96f7b-87a9-492f-b471-0387394ca0e5.1.png" />
                <img src="/img/53aeabd4-b35a-40bc-8248-cc7840b510b2.2.png" />
            </div>
            <div class="theory" id="theory3"></div>
            <div class="theory" id="theory4"></div>
            <div class="theory" id="theory5"></div>
            <div class="theory" id="theory6"></div>
            <div class="theory" id="theory7"></div>
            <div class="theory" id="theory8"></div>
            <div class="theory" id="theory9"></div>
            <div class="theory" id="theory10"></div>
            <div class="theory" id="theory11"></div>
            <div class="theory" id="theory12"></div>
            <div class="theory" id="theory13"></div>
            <div class="theory" id="theory14"></div>
            <div class="theory" id="theory15"></div>
            <div class="theory" id="theory16"></div>
            <div class="theory" id="theory17"></div>
            <div class="theory" id="theory18"></div>
            <div class="theory" id="theory19"></div>
            <div class="theory" id="theory20"></div>
            <div class="theory" id="theory21"></div>
            <div class="theory" id="theory22"></div>
            <div class="theory" id="theory23"></div>
            <div class="theory" id="theory24"></div>
            <div class="theory" id="theory25"></div>
            <div class="theory" id="theory26"></div>
            <div class="theory" id="theory27"></div>
        </div>
        <div class="practice">
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<script>
    $(document).ready(function () {
        $('.task').click(function (event) {
            $('.theory').removeClass('active')
            $('.task').removeClass('active')
            var num = $(this).attr('data-num');
            $('#theory' + num).addClass('active')
            $('.task-' + num).addClass('active')
        });
    });
</script>


</body>

</html>