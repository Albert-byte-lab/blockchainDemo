<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>飞机制造商工程部门页面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="rfid_tb" title="航材设备" fitColumns="true" pagination="true" rownumbers="true"
    url="${pageContext.request.contextPath}/supplier/list.do" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="#" checkbox="true" align="center"></th>
        <th field="#" width="100" align="center" hidden="true">RFID标签号</th>
        <th field="#" width="100" align="center">零部件名称</th>
        <th field="#" width="100" align="center">设计定稿日期</th>
        <th field="#" width="100" align="center">设计厂家</th>
        <th field="#" width="100" align="center">零部件说明</th>
        <th field="#" width="100" align="center">设计类别</th>
        <th field="#" width="100" align="center">预览</th>
        <th field="#" width="120" align="center">状态</th>
    </tr>
    <tr>
       <td width="100">t001</td>
        <td width="100">铆钉</td>
        <td width="100">2021年7月2日</td>
        <td width="100">东风制造商</td>
        <td width="100">这是用于链接飞机机翼的</td>
        <td width="100">机翼</td>
        <td width="100">预览图</td>
        <td width="120">已出厂</td>
    </tr>
    </thead>
</table>

<div id="tb">
    <div>
        <a href="javascript:addSupplier()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:supplierModify()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteSupplier()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>

</div>

</body>
</html>
