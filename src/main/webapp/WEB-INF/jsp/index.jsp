<%--
  Created by IntelliJ IDEA.
  User: z'f'h
  Date: 2020/8/24
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <nobr>
        <div>
            <form method="POST" action="/management/transactionFlow/informationQuery1">
                <div class="row">
                    <div class="col-md-10">
                            <textarea name="sql" STYLE="width: 1000px;height: 100px" id="sql"
                                      οnfοcus="ClearDefault(this)" placeholder="输入查询语句"
                                      οnblur="AddDefault(this)">${sql}</textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <button type='submit' class="btn btn-primary btn-block" id="sure">确定
                        </button>
                    </div>
                    <div class="col-md-2">
                        <button id="back" type="reset" class="btn btn-primary btn-block">重置
                        </button>
                    </div>
                    <div class="col-md-2">
                        <p id="message" style="height: 28px" align="center"></p>
                    </div>
                </div>
            </form>
        </div>
    </nobr>
    <hr style="background-color: #0c0c0c;height: 1px;width: 2000px;">
    <%--引入jqGerid--%>
    <div>
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>
    <content tag="customJavascript">
        <script type="text/ecmascript" src="${pageContext.request.contextPath}/static/grid.locale-cn.js"></script>
        <script type="text/ecmascript" src="${pageContext.request.contextPath}/static/jquery.jqGrid.min.js"></script>

        <script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
        <script src="/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>

        <script type="text/javascript">

            //加载的主表（对表格进行遍历
            $(document).ready(function () {
                // var applicationId = $('#applicationId option:selected').val();
                $("#jqGrid").jqGrid({
                    url: "/management/transactionFlow/informationQuery",
                    mtype: "POST",
                    datatype: "json",
                    postData: {
                        'sql': function () {
                            return $('#sql').val().trim();
                        }
                    },
                    styleUI: 'Bootstrap',
                    colModel: [
                        <c:forEach items="${list3}" var="user" varStatus="status">
                        {label: '${user}', name: '${user}', autowidth: true, sortable: false},
                        </c:forEach>
                    ],
                    viewrecords: true,
                    height: 400,
                    shrinkToFit: false,
                    rowNum: 10,
                    autowidth: true,
                    pager: "#jqGridPager",
                    page: 1
                }).trigger("reloadGrid");
                return false;
                var len = $("#jqGrid").getGridParam("width");
//                $("#jqGrid").setGridParam().hideCol("id");
                $("#jqGrid").setGridWidth(len);
            });
            //点击重置按钮
            $("#back").click(function () {
                $("#sql").empty();
            });
        </script>
    </content>
</div>
</body>
</html>
