var Dialog = function(){};

Dialog.showDialog = function(option){
    var defautOption = {
            title : "确认对话框",
            resizable : false,
            height : "auto",
            modal : true,
            buttons: {
                Ok: function() {
                    $(this).dialog('close');
                    alert("yyy");
                },
                Cancel: function() {
                    $(this).dialog('close');
                }
            }
        };

        option = $.extend(true, defautOption, option);
        
    $("#dialog-message").dialog(option);
};

var Callback = function(){};

Callback.callback = function(params){
    alert(params);
};