/**
 * Created by jk on 16/7/26.
 */
$(function(){
    //格式化日期原型
    Date.prototype.pattern=function(fmt) {
        var o = {
            "M+" : this.getMonth()+1, //月份
            "d+" : this.getDate(), //日
            "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
            "H+" : this.getHours(), //小时
            "m+" : this.getMinutes(), //分
            "s+" : this.getSeconds(), //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S" : this.getMilliseconds() //毫秒
        };
        var week = {
            "0" : "/u65e5",
            "1" : "/u4e00",
            "2" : "/u4e8c",
            "3" : "/u4e09",
            "4" : "/u56db",
            "5" : "/u4e94",
            "6" : "/u516d"
        };
        if(/(y+)/.test(fmt)){
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        }
        if(/(E+)/.test(fmt)){
            fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);
        }
        for(var k in o){
            if(new RegExp("("+ k +")").test(fmt)){
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            }
        }
        return fmt;
    }
});

$.extend({
    timestamp:function(url){
        var getTimestamp=new Date().getTime();
        if(url.indexOf("?")>-1){
            url=url+"&timestamp="+getTimestamp
        }else{
            url=url+"?timestamp="+getTimestamp
        }
        return url;
    },
    getServerURL:function (url){//获取服务端地址
        return "http://127.0.0.1:8083/" +url;
    },
    doAjaxCall:function(functionNo,data,successCallback,failCallback){//ajax请求
        $.ajax({
            url:$.getServerURL(functionNo+".json"),
            type:"get",
            dataType :"jsonp",
            jsonp: "jsonp",
            data:data,
            timeout:2000000,
            error:function(){
                failCallback && failCallback.call(this,"系统异常");
            },
            success:function(json){
                if (json.successfull){
                    successCallback && successCallback.call(this,json.result);
                }else{
                    failCallback && failCallback.call(this,json.errormsg);
                }
            }
        });
    }
});