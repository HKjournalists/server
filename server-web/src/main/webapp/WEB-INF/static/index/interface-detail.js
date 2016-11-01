/**
 * Created by jk on 16/7/26.
 */
$(function () {
    var indexForm = {
        init : function(){

            // 加载数据
            this.loadData();
            // 绑定事件
            this.bindEvent();
        },
        loadData : function () {
            $.doAjaxCall("interface/query/by/interfaceId","",function(jsonResult){
                for(var i = 0; i < jsonResult.length;i++) {
                    var item = jsonResult[i];
                    var html = "<dl>";
                    html += "<dt id= '" + item.enName + "' moduleId='" + item.id + "'><i class='Hui-iconfont'>&#xe616;</i> " + item.zhName + "(" + item.enName + ")" + "<i class='Hui-iconfont menu_dropdown-arrow'>&#xe6d5;</i></dt>";
                    html += "<dd><ul id='moduleId_" + item.id + "_ul'></ul></dl>";
                    $("#menus").append(html);
                }
            },function(errorMsg){
                alert(errorMsg);
            });
        },
        bindEvent : function(){
            $(document).on("click","#menus dl > dt",function(){
                var moduleId = $(this).attr("moduleId");
                var isSelected = $(this).hasClass("selected");
                if (!isSelected){
                    $(this).addClass("selected");
                    $("#moduleId_" + moduleId +"_ul").parent().css({"display":"block"});
                }else{
                    $(this).removeClass("selected");
                    $("#moduleId_" + moduleId +"_ul").parent().css({"display":"none"});
                }
                var data = "moduleId=" + moduleId;
                $.doAjaxCall("interface/query/by/moduleId",data,function(jsonResult){
                    var html = "";
                    for(var i = 0; i < jsonResult.length;i++) {
                        var item = jsonResult[i];
                        html+="<li><a _href='interface-detail.html?interfaceId=" + item.id + "&url= " + item.url + "' data-title='" + item.name + "(" + item.url + ")" + "'>" + item.name + "(" + item.url + ")" + "</a></li>";
                    }
                    if (html.length == 0){
                        html = "<li><a>该模块暂无接口</a></li>";
                    }
                    $("#moduleId_" + moduleId +"_ul").html(html);
                },function(errorMsg){

                });
            });

            $.Huifold("#Huifold1 .item h4","#Huifold1 .item .info","fast",3,"click");
        }
    };
    indexForm.init();
});