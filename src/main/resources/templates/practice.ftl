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
                            <li><a class="menu-link" href="/studing">Теория</a></li>
                            <li><a class="menu-link" href="#">Практика</a></li>
                        </ul>
                    </li>
                    <#if roleAdmin??>
                        <li><a class="menu-link" href="/addPractice">Добавить</a></li>
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
        <a href="/task/1"><div class="task task-1" data-num="1">Задание 1</div></a>
        <a href="/task/2"><div class="task task-2" data-num="2">Задание 2</div></a>
        <a href="/task/3"><div class="task task-3" data-num="3">Задание 3</div></a>
        <a href="/task/4"><div class="task task-4" data-num="4">Задание 4</div></a>
        <a href="/task/5"><div class="task task-5" data-num="5">Задание 5</div></a>
        <a href="/task/6"><div class="task task-6" data-num="6">Задание 6</div></a>
        <a href="/task/7"><div class="task task-7" data-num="7">Задание 7</div></a>
        <a href="/task/8"><div class="task task-8" data-num="8">Задание 8</div></a>
        <a href="/task/9"><div class="task task-9" data-num="9">Задание 9</div></a>
        <a href="/task/10"><div class="task task-10" data-num="10">Задание 10</div></a>
        <a href="/task/11"><div class="task task-11" data-num="11">Задание 11</div></a>
        <a href="/task/12"><div class="task task-12" data-num="12">Задание 12</div></a>
        <a href="/task/13"><div class="task task-13" data-num="13">Задание 13</div></a>
        <a href="/task/14"><div class="task task-14" data-num="14">Задание 14</div></a>
        <a href="/task/15"><div class="task task-15" data-num="15">Задание 15</div></a>
        <a href="/task/16"><div class="task task-16" data-num="16">Задание 16</div></a>
        <a href="/task/17"><div class="task task-17" data-num="17">Задание 17</div></a>
        <a href="/task/18"><div class="task task-18" data-num="18">Задание 18</div></a>
        <a href="/task/19"><div class="task task-19" data-num="19">Задание 19</div></a>
        <a href="/task/20"><div class="task task-20" data-num="20">Задание 20</div></a>
        <a href="/task/21"><div class="task task-21" data-num="21">Задание 21</div></a>
        <a href="/task/22"><div class="task task-21" data-num="22">Задание 22</div></a>
        <a href="/task/23"><div class="task task-23" data-num="23">Задание 23</div></a>
        <a href="/task/24"><div class="task task-24" data-num="24">Задание 24</div></a>
        <a href="/task/25"><div class="task task-25" data-num="25">Задание 25</div></a>
        <a href="/task/26"><div class="task task-26" data-num="26">Задание 26</div></a>
        <a href="/task/27"><div class="task task-27" data-num="27">Задание 27</div></a>

    </div>

    <div class="theory-and-practice">
        <#if resolving??&&all??>
        <p style="margin: 20px">Вы решили ${resolving}/${all} заданий по этой теме</p>
        </#if>

        <#if error??>
            <p class="error" style="margin: 20px">${error}</p>
        </#if>

        <#if task??>
        <form action="/task/${task.number}" method="post">
            <p class="text-task">${task.task}</p>
            <input type="hidden" name="id" value="${task.id}"/>
            <div class="ans" > <textarea class="answer" name="answer" rows="1" placeholder="Введите ответ" required></textarea> <br>
                <input type="submit" class="answer-btn" value="Готово"/>
            </div>
        </form>
            <form action="/task/${task.number}" method="get">
                <input type="hidden" name="id" value="${task.id}"/>
                <input type="submit" class="answer-btn" value="Не знаю"/>
            </form>
        <#else>
            <p class="error" style="margin: 20px">Поздравляю! Ты решил все задния по этой теме</p>
        </#if>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<script>
    $(document).ready(function () {
        $('.task').click(function (event) {
            $('.practice').removeClass('active')
            $('.task').removeClass('active')
            var num = $(this).attr('data-num');
            $('#practice' + num).addClass('active')
            $('.task-' + num).addClass('active')
        });
    });
</script>


</body>

</html>