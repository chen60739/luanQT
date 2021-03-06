<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/14 0014
  Time: 上午 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
</head>

<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">采样管理</a>
                <a>
                    <cite>采样列表</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input" autocomplete="off" placeholder="开始日" name="start" id="start"></div>
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input" autocomplete="off" placeholder="截止日" name="end" id="end"></div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="sampleCode" placeholder="采样编码" autocomplete="off" class="layui-input"></div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-body ">
                    <table id="table" class="layui-table" lay-filter="test"></table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="switchTpl">
    <!-- 这里的checked的状态只是演示 -->
    <input type = "checkbox" name = "sex" value = "{{d.id}}" lay-skin = "switch"lay-text = "女|男" lay-filter = "sexDemo" {{ d.id == 10003 ? 'checked': ''}} >
</script>
<script>
    layui.use('laydate', function() {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start', //指定元素
            format:'yyyy-MM-dd HH:mm:ss',
            max:new Date().getTime()
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });

    });
</script>
<script type="text/html" id="titleTpl">
    {{#  if(d.state == 0){ }}
        刷卡
    {{# }else{ }}
        扫码
    {{#  } }}
</script>
<script type="text/html" id="tpl">
    {{#  if(d.mergeState == 0){ }}
        未合样
    {{# }else{ }}
        已合样
    {{#  } }}
</script>
<script>layui.use(['table','form'],function() {
    var table = layui.table;
    var form = layui.form;

    form.on('submit(sreach)', function(data){
        tableIns.reload({
            where:data.field
        });
        return false;
    });


    var tableIns = table.render({
        elem: '#table',
        url:'/sampling/listdata',
        cols: [[
            {field:'sampleCode', width:93, title: '采样编码', sort: true},
            {field:'cargoname', width:121, title: '货名'},
            {field:'sender', width:80, title: '来源地',width:180},
            {field:'type', width:80, title: '来源分类'},
            {field:'carnum', title: '车号', width: 100},
            {field:'departmentId', width:98, title: '厂区名称', sort: true},
            {field:'state', width:92, title: '状态', sort: true,templet:'#titleTpl'},
            {field:'mergeCode', width:136, title: '合样编码', sort: true},
            {field:'mergeState', width:81, title: '合样状态',templet:'#tpl'},
            {field:'mergeRule', width:80, title: '合样规则'}
        ]],
        page: true
    });

        //监听单元格编辑
        table.on('edit(test)',
            function(obj) {
                var value = obj.value //得到修改后的值
                    ,
                    data = obj.data //得到所在行所有键值
                    ,
                    field = obj.field; //得到字段
                layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：' + value);
            });

        //头工具栏事件
        table.on('toolbar(test)',
            function(obj) {
                var checkStatus = table.checkStatus(obj.config.id);
                switch (obj.event) {
                    case 'getCheckData':
                        var data = checkStatus.data;
                        layer.alert(JSON.stringify(data));
                        break;
                    case 'getCheckLength':
                        var data = checkStatus.data;
                        layer.msg('选中了：' + data.length + ' 个');
                        break;
                    case 'isAll':
                        layer.msg(checkStatus.isAll ? '全选': '未全选');
                        break;
                };
            });
    });
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>

</html>
