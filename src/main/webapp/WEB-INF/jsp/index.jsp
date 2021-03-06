<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>飞行零部件全生命周期管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap 3.3.4 -->
    <link href="../resources/Public/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- FontAwesome 4.3.0 -->
    <link href="../resources/Public/bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons 2.0.0 --
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css"/>
    <!-- Theme style -->
    <link href="../resources/Public/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <link href="../resources/Public/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="../resources/Public/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery 2.1.4 -->
    <script src="../resources/Public/plugins/jQuery/jquery-3.2.1.min.js"></script>
    <script src="../resources/Public/js/global.js"></script>
    <script src="../resources/Public/js/upgrade.js"></script>
    <script src="../resources/Public/js/layer/layer.js"></script><!--弹窗js 参考文档 http://layer.layui.com/-->
    <style type="text/css">
        #riframe{min-height:inherit !important}
    </style>
    <meta name="__hash__" content="40390ff8c1de6e5b5f80bd80d3196959_8f39a041787ac9854b174964cdc80849" /></head>
<body class="skin-green-light sidebar-mini" style="overflow-y:hidden;">
<div class="wrapper">
    <header class="main-header">
        <!-- Logo -->
        <a href="/index/Admin/Index/index" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b></b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><img src="../resources/Public/img/logo02.png" width="40" height="30">&nbsp;&nbsp;<b>飞行零部件全生命周期管理系统</b></span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!--服务器升级-->
            <textarea id="textarea_upgrade" style="display:none;"></textarea>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!--  <img src="Public/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">-->
                            <i class="glyphicon glyphicon-user"></i>
                            <span  id="user-name" class="hidden-xs"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="/blockchainDemo/localauth/tocancel" class="btn btn-default btn-flat">安全退出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                    <li><a href="#" data-toggle="control-sidebar"><i class="fa fa-street-view"></i>换肤</a></li>
                </ul>
            </div>
        </nav>
    </header>

    <aside class="main-sidebar" style="overflow-y:auto;">
        <section class="sidebar">
            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
            </span>
                </div>
                <input type="hidden" name="__hash__" value="40390ff8c1de6e5b5f80bd80d3196959_8f39a041787ac9854b174964cdc80849" /></form>
            <!-- /.search form -->
            <ul class="sidebar-menu">
                <li class="treeview">
                    <a href="javascript:void(0)">
                        <i class="fa fa-cog"></i><span>零部件供应商信息管理</span><i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li onclick="makecss(this)" data-id="index_Admin">
                            <a href='/blockchainDemo/am/showam' target='rightContent'><i class="fa fa-circle-o"></i>零部件供应商信息列表</a>
                        </li></ul>
                </li>

            </ul>
        </section>
    </aside>

    <section class="content-wrapper right-side" id="riframe" style="margin:0px;padding:0px;margin-left:230px;">
        <iframe id='rightContent' name='rightContent' src="/blockchainDemo/admin/welcome" width='100%' frameborder="0"></iframe>
    </section>


    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <!--
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
          <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-at"></i></a></li>
          <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        -->
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane" id="control-sidebar-home-tab">
            </div><!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div><!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
            </div>
        </div>
    </aside>
    <div class="control-sidebar-bg"></div>
</div>
<script src="../resources/Public/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="../resources/Public/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../resources/Public/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="../resources/Public/plugins/fastclick/fastclick.min.js" type="text/javascript"></script>
<script src="../resources/Public/dist/js/app.js" type="text/javascript"></script>
<script src="../resources/Public/dist/js/demo.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function(){
        $("#riframe").height($(window).height()-100);//浏览器当前窗口可视区域高度
        $("#rightContent").height($(window).height()-100);
        $('.main-sidebar').height($(window).height()-50);

    });

    var tmpmenu = 'index_Index';
    function makecss(obj){
        $('li[data-id="'+tmpmenu+'"]').removeClass('active');
        $(obj).addClass('active');
        tmpmenu = $(obj).attr('data-id');
    }

    function callUrl(url){
        layer.closeAll('iframe');
        rightContent.location.href = url;
    }
    var now_num = 0; //现在的数量
    var is_close=0;
    function ajaxOrderNotice(){
        var url = '/index/Admin/Order/ajaxOrderNotice';
        if(is_close > 0) return;
        $.get(url,function(data){
            //有新订单且数量不跟上次相等 弹出提示
            if(data > 0 && data != now_num){
                now_num = data;
                if(document.getElementById('ordfoo').style.display == 'none'){
                    $('#orderAmount').text(data);
                    $('#ordfoo').show();
                }
            }
        })
//        setTimeout('ajaxOrderNotice()',5000);
    }
    //setTimeout('ajaxOrderNotice()',5000);
</script>
</body>
</html>