<!DOCTYPE html>
<html lang="ru" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>DoWhile.Pro</title>
    <link rel="stylesheet" type="text/css" th:href="@{/css/style.css}"/>
    <link href="https://fonts.googleapis.com/css?family=Alegreya+Sans:400,400i,500,500i,700,700i,800,800i,900,900i&display=swap"
          rel="stylesheet"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="//cdn.ckeditor.com/4.13.1/standard/ckeditor.js"></script>
</head>

<body>

<div class="editor">
    <form th:action="@{/addNewNews}" method="post">
        <textarea name="editor" id="editor"></textarea><br>
        <button class="success" id="btn-publish" type="submit">ОК</button>
        <button class="success" id="btn-cancel">Отчистить</button>
    </form>
    <p th:text="${imageUrl}"/>
</div>

<script>
    $(document).ready(function () {
        CKEDITOR.replace('editor', {
            filebrowserImageUploadUrl: '/image/upload',
            height: 400
        });

        CKEDITOR.on('dialogDefinition', function(e){
            var dialogName = e.data.name;
            var dialogDefinition = e.data.definition;
            
            switch (dialogName) {
                case 'image':
                    //dialogDefinition.removeContents('info');
                    dialogDefinition.removeContents('Link');
                    dialogDefinition.removeContents('advanced');
                    break;

            }
        });

        $('#btn-publish').click(function(){
            alert(CKEDITOR.instances.editor.getData());
        });

        $('#btn-cancel').click(function(){
            CKEDITOR.instances.editor.setData('');
        });
    });
</script>
</body>

</html>