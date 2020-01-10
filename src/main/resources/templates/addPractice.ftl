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
<form action="/addPractice" method="post">
    <p><label>Номер задания</label><input type="text" name="number" required/></p>
    <p><label>Количество баллов</label><input type="text" name="points" required/></p>
    <p><label>Текст задания</label><textarea row="3" name="task" required></textarea> </p>
    <p><label>Ответ</label><input type="text" name="answer" required/></p>
    <p><input type="file" name="file" /></p>
    <p><input type="submit"/></p>
</form>
</body>
</html>