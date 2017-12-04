<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/materialize.min.js"></script>
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="/resources/css/materialize.min.css" media="screen,projection"/>
<head>
    <title>Справочником БИК</title>
</head>
<body>

<div class="container col-md-10"></div>

<div class="container col-md-6">
    <div class="col-sm-6 col-sm-offset-3">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h1 class="panel-title">Панель фильтрации</h1>
            <span class="pull-right clickable"><i class="glyphicon glyphicon-chevron-down"></i></span>
        </div>
        <div class="panel-body">
            <form class="form-horizontal">
                <input type="text" class="form-control" name="newNum" id="newNumFilter"
                       value="${newNum}" placeholder="БИК">
                <br/>
                <input type="text" class="form-control" name="rgn" id="rgn"
                       value="${rgn}" placeholder="Регион">
                <br/>
                <select class="form-control" id="pzn" name="pzn">
                        <c:forEach var="pzn" items="${pznList}">
                            <option value="${pzn.pzn}" ${pzn.pzn == pzn.pzn ? 'selected="selected"' : ''}>${pzn.name}</option>
                        </c:forEach>
                </select>
                <br/>
                <button type="button" id="getFilter" class="btn btn-default">Найти</button>
                <button type="button" id="searchAll" class="btn btn-default">Сбросить</button>
            </form>
        </div>
    </div>
        <div class="form-group">
            <button type="button" class="btn btn-success btn-block" id="btnAdd" data-toggle="modal" data-target="#modelEdit">Добавить</button>
        </div>
    </div>
    <br>

    <br>

    <c:if test="${fields.isEmpty()}">
        <div style="color: #EF3B3A; text-align: center; font-size: 14pt">
            Ни одна запись не найдена.
        </div>
    </c:if>

    <table class="table table-striped" style="font-size: 8pt" align="left">
        <thead/>
        <tbody>
        <tr>
            <th>Редактировать</th>
            <th>Удалить</th>
            <th>БИК</th>
            <th>Код контроля допустимости проведения расчетных операций</th>
            <th>Код типа участника расчетов</th>
            <th>Код типа учатника системы электронных расчетов</th>
            <th>Код территории РФ</th>
            <th>Индекс</th>
            <th>Код типа населенного пункта</th>
            <th width="50%">Населенный пункт</th>
            <th>Адрес</th>
            <th>БИК РКЦ(ГРКЦ)</th>
            <th>Наименование участника расчетов</th>
            <th>Телефон</th>
            <th>Регистрационный номер</th>
            <th>Код ОКПО</th>
            <th>Дата последнего изменения записи</th>
            <th>Номер счета</th>
            <th>Дата включения информации об участнике расчетов в ЭБД</th>
            <th>Дата контроля</th>
        </tr>
        <c:forEach items="${fields}" var="field">
            <tr>
                <th> <button type="button" id="${field.id}" class="buttonEdit btn btn-success btn-sm" data-toggle="modal" data-target="#modelEdit">Редактировать</button></th>
                <th> <button type="button" id="${field.id}" class="buttonDelete btn btn-danger btn-sm" data-toggle="modal" data-target="#modalDelete">Удалить</button></th>
                <td><c:out value="${field.newNum}"/></td>
                <td><c:out value="${field.real}"/></td>
                <td><c:out value="${field.pzn}"/></td>
                <td><c:out value="${field.uer}"/></td>
                <td><c:out value="${field.rgn}"/></td>
                <td><c:out value="${field.ind}"/></td>
                <td><c:out value="${field.tnp}"/></td>
                <td width="50%"><c:out value="${field.nnp}"/></td>
                <td><c:out value="${field.adr}"/></td>
                <td><c:out value="${field.rkc}"/></td>
                <td><c:out value="${field.namep}"/></td>
                <td><c:out value="${field.telef}"/></td>
                <td><c:out value="${field.regn}"/></td>
                <td><c:out value="${field.okpo}"/></td>
                <td><c:out value="${field.dt_izm}"/></td>
                <td><c:out value="${field.ksnp}"/></td>
                <td><c:out value="${field.date_in}"/></td>
                <td><c:out value="${field.date_ch}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="container col-md-3"></div>

<!-- Modal -->
<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Удаление объекта</h4>
            </div>
            <div class="modal-body">

                Вы действительно хотите удалить?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Нет</button>
                <button type="button" id="buttonToDelete" data-dismiss="modal" class="btn btn-danger">Да</button>
                <input id="forDelete" type="hidden" >
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modelEdit" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-body">
                <form role="form">
                    <div class="form-group" style="display: none;">
                        <input type="text" class="form-control" id="bnkseekId" >
                    </div>
                    <div class="form-group">
                        <label>БИК</label>
                        <input type="text" class="form-control" id="newNumInput" placeholder="Введите БИК">
                    </div>
                    <div class="input-group">
                        <label>Код типа учатника системы электронных расчетов</label>
                        <select name="uer" class="form-control">
                            <c:forEach var="uer" items="${uerList}">
                                <option value="${uer.uer}" ${uer.uer == uer.uer ? 'selected="selected"' : ''}>${uer.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br />
                    <div class="input-group">
                        <label>Код типа участника расчетов</label>
                        <select name="pzn" class="form-control">
                            <c:forEach var="pzn" items="${pznList}">
                                <option value="${pzn.pzn}" ${pzn.pzn == pzn.pzn ? 'selected="selected"' : ''}>${pzn.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br />
                    <div class="input-group">
                        <label>Код территории РФ</label>
                        <select name="pzn" class="form-control">
                            <c:forEach var="rgn" items="${rgnList}">
                                <option value="${rgn.rgn}" ${rgn.rgn == rgn.rgn ? 'selected="selected"' : ''}>${rgn.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br />
                    <div class="form-group">
                        <label>Адрес</label>
                        <input type="text" class="form-control" id="adr" placeholder="Введите адрес">
                    </div>
                    <button id="saveChange" type="button" class="btn btn-default btn-success btn-block" data-dismiss="modal"><span class="glyphicon glyphicon-off"></span>Сохранить</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"> Закрыть</button>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).on('click', '.panel-heading span.clickable', function (e) {
        var $this = $(this);
        if (!$this.hasClass('panel-collapsed')) {
            $this.parents('.panel').find('.panel-body').slideUp();
            $this.addClass('panel-collapsed');
            $this.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
        } else {
            $this.parents('.panel').find('.panel-body').slideDown();
            $this.removeClass('panel-collapsed');
            $this.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
        }
    });

    $("#getFilter").click(function(event) {
        var newNum = $("#newNumFilter").val();
        var rgn = $("#rgn").val();
        var pzn = $("#pzn").val();

        $.ajax({
            url: "/",
            data: {newNum: newNum, pzn: pzn, rgn: rgn},
            success: function (data) {
                alert(data);
            },
            error: function (e) {
            }
        });
    });

    $("#saveChange").click(function(event) {
        var newNum = $("#newNumInput").val();
        var adr = $("#adr").val();
        var id = $("#field.id").val();
        var pzn = $("#pzn").val();
        var uer = $("#uer").val();
        var uer = $("#rgn").val();
        $.ajax({
            url: "save",
            data: {id: id, newNum: newNum, adr: adr, pzn: pzn, uer: uer, rgn: rgn},
//            success: function (data) {
//                alert(data);
//            },
            error: function (e) {
            }
        });
    });

    $(".buttonEdit").click(function (event) {
        $.ajax({
            url: "get-json-bnkseek",
            data: ({id:$(this).attr("id")}),
            success: function (bnkseek) {
                $("#newNumInput").val(bnkseek.newNum);
                $("#adr").val(bnkseek.adr);
                $("#bnkseekId").val(bnkseek.id);
                $("#pzn").val(bnkseek.pzn);
                $("#uer").val(bnkseek.uer);
            },
            error: function (e) {
                alert();
            }
        });
    });

    $(".buttonDelete").click(function () {
        $("#forDelete").val($(this).attr("id"));
    });

    $("#buttonToDelete").click(function (event) {
        var rowId=$("#forDelete").val();
        $.ajax({
            url: "delete/" + rowId,
            data: ({id:rowId}),
            success: function () {
                $("#"+rowId+"row").remove();
                alert("Запись удалена!");
            },
            error: function (e) {

            }
        });
    });

</script>
</body>
</html>