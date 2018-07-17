$(function() {
	// Waves初始化
	//Waves.displayEffect();
	// 数据表格动态高度
	$(window).resize(function () {
		$('#table').bootstrapTable('resetView', {
			height: getHeight()
		});
	});
});
// 动态高度
function getHeight() {
	return $(window).height() - 20;
};
// 数据表格展开内容
function detailFormatter(index, row) {
	var html = [];
	$.each(row, function (key, value) {
		html.push('<p><b>' + key + ':</b> ' + value + '</p>');
	});
	return html.join('');
};

$.extend({
	dropdown:function(url,params,domid,text){
        $.ajax({
            url: url,type: "post",data: params,dataType: "json",async:false,
            success:function(result){
                if(result != null && result.length != 0){
                    var htmls = "";
                	if(text) {
                        htmls = "<option value=\"\">" + text + "</option>";
                    }
                    $.each(result,function(index,dom){
                        htmls += "<option value=\""+dom.code+"\">"+dom.text+"</option>";
                    });
                    $(domid).html(htmls);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                toastr.error(textStatus);
            }
        });
	},
    inputType:function(name,type){
        if(type == "textarea"){
            return "<textarea cols=\"5\" class=\"form-control\" name=\""+name+"\" id=\""+name+"\"></textarea>";
        }else if(type == "select"){
            return "<select class=\"form-control\" name=\""+name+"\" id=\""+name+"\"></select>";
        }else if(type == "radio"){
            return "<div id=\""+name+"\"></div>";
        }else if(type == "check"){
            return "<div id=\""+name+"\"></div>";
        }else if(type == "file"){
            return "<div id=\""+name+"\"></div>";
        }else if(type == "password"){
            return "<input type=\"password\" class=\"form-control\" name=\""+name+"\" id=\""+name+"\" placeholder=\""+name+"\">";
        }else{
            return "<input type=\"text\" class=\"form-control\" name=\""+name+"\" id=\""+name+"\" placeholder=\""+name+"\">";
        }
	},
    create:function(title){
        var columns = $('#table').bootstrapTable('getOptions').columns[0];
        var htmls = "<form id=\"tableForm\" class=\"form-horizontal\">";
        $.each(columns,function(index,data){
            if(data.edit) {
                htmls += "<div class=\"form-group\">" +
                    "<label for=\"" + data.field + "\" class=\"col-sm-2 control-label\">"+data.title+"</label>" +
                    "<div class=\"col-sm-10\">"+$.inputType(data.field, data.type) +
                    "</div>" +
                    "</div>";
            }
        });
        htmls+="</form>";
        $("#modal #myModalLabel").html(title);
        $("#modal .modal-body").html(htmls);
        $("#modal").modal("show");
	},
    modal:function(){
        var htmls = "<div class=\"modal fade\" id=\"modal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">"+
                        "<div class=\"modal-dialog\" role=\"document\">"+
                            "<div class=\"modal-content\">"+
                                "<div class=\"modal-header\">"+
                                    "<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>"+
                                    "<h4 class=\"modal-title\" id=\"myModalLabel\"></h4>"+
                                "</div>"+
                                "<div class=\"modal-body\"></div>"+
                                "<div class=\"modal-footer\">"+
                                    "<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>"+
                                    "<button type=\"button\" class=\"btn btn-primary submit\">Save changes</button>"+
                                "</div>"+
                            "</div>"+
                        "</div>"+
                    "</div>";
        return htmls;
    },
    confirm:function(){
        var htmls = "<div class=\"modal fade bs-example-modal-sm\" id=\"confirm\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalConfirm\">"+
                        "<div class=\"modal-dialog modal-sm\" role=\"document\">"+
                            "<div class=\"modal-content\">"+
                                "<div class=\"modal-body\">确认删除？</div>"+
                                "<div class=\"modal-footer\">"+
                                    "<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>"+
                                    "<button type=\"button\" class=\"btn btn-primary delSubmit\">Save changes</button>"+
                                "</div>"+
                            "</div>"+
                        "</div>"+
                    "</div>";
        return htmls;
    }
});