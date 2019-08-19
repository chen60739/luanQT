<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/15 0015
  Time: 上午 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
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
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input"  autocomplete="off" placeholder="开始日" name="start" id="start">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input"  autocomplete="off" placeholder="截止日" name="end" id="end">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
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
    <!-- 这里的 checked 的状态只是演示 -->
    <input type="checkbox" name="locked" value="{{d.id}}" lay-skin="switch" lay-text="锁定|未锁定" lay-filter="sexDemo" {{ d.locked==true?'checked':'' }}>
</script>
<script type="text/html" id="barDemo">
    <a title="编辑"  onclick="xadmin.open('编辑','member-edit.html',600,400)" href="javascript:;">
        <i class="layui-icon">&#xe642;</i>
    </a>
    <a title="删除"  lay-event="del">
        <i class="layui-icon">&#xe640;</i>
    </a>
</script>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-danger" lay-event="delAll">批量删除</button>
        <button class="layui-btn" onclick="xadmin.open('添加用户','./useradd',600,400)"><i class="layui-icon"></i>添加</button>
    </div>
</script>
<script>
    function lockFormat(row){
        if (row.id ==${sessionUser.user.id}){
            return '<span>登录账号</span>';
        }else{
            var b = row.locked?'checked':'';
            return '<input type="checkbox" name="locked" lay-skin="switch" lay-text="锁定|未锁定" value='+row.id+' lay-filter="lockDemo" '+b+'/>';
        }
    }
</script>
<script>
    layui.use(['laydate','form','table'], function(){
        var laydate = layui.laydate;
        var form = layui.form;
        var table = layui.table;

        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                    $.getJSON("/user/del",{users:data},function (msg){
                        if (msg=="SUCCESS"){
                            layer.msg("删除成功");
                        }
                    })
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });


        form.on('submit(sreach)', function(data){
            tableIns.reload({
                where:data.field
            });
            return false;
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });

        form.on('switch(lockDemo)', function(obj){
            $.post("/user/update", { id: this.value, locked: obj.elem.checked },function (data) {
                console.log(data);
                if (data != null && data != ''){
                    location.href=data;
                }
            },"json");
           // layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        });

        var tableIns = table.render({
            elem: '#table',
            url:'/user/listdata',
            toolbar: '#toolbarDemo',
            cols: [[
                {type:'checkbox'},
                {field:'id', width:93, title: 'ID', sort: true},
                {field:'username', width:121, title: '账号'},
                {field:'realName', width:80, title: '真实名称',width:180},
                {field:'reateTime', width:80, title: '创建时间'},
                {field:'createId', title: '创建人', width: 100},
                {field:'locked', title:'是否锁定', width:110, templet: function(row){return lockFormat(row)}, unresize: true},
                {field: 'right', width:178, title:'操作', align:'center', toolbar: '#barDemo'}
            ]],
            page: true
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            if (obj.event=="delAll"){
                var data = checkStatus.data;
                /*$.getJSON("/user/del",{users:JSON.stringify(data)},function (msg) {
                    if (msg=="SUCCESS"){
                        layer.msg("删除成功");
                    }
                })*/
                $.ajax({
                    type: "POST",
                    url: "/user/del",
                    data: {'users':JSON.stringify(data)},
                    success: function(msg){
                        if (msg=="SUCCESS"){
                            layer.msg("删除成功");
                        }
                    }

                })

            }
            /*switch(obj.event){
                case 'delAll':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选');
                    break;
            };*/
        });

    });
</script>
</html>