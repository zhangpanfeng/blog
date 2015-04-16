<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AjaxTest</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
     $.get("darren/ajaxTest",function(data){
         console.log("data = " + data);
        var array = JSON.parse(data);
        var length = array.length;
        for(var i = 0; i < length; i++){
            var item = array[i];
            console.log("id = " + item.id);
            console.log("name = " + item.name);
        }
    }); 
    
    
});
</script>
</head>
<body>

</body>
</html>