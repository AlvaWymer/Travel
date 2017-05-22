$(function(){
	$("button[id*='edit-']").each(function(){
		$(this).on("click",function(){
			did = this.id.split("-")[1] ;
			console.log("部门编号：" +  did) ;
			dname = $("#dname-" + did).val() ;
			console.log("部门名称：" +  dname) ;

			
			if (dname == "") { 
				operateAlert(false,"","部门名称不允许为空，请确认后再提交更新！") ;
			} else {
				// 编写Ajax异步更新操作
				$.post("pages/back/admin/dept/edit.action",{"did":did,"dname":dname},function(data){
					operateAlert(data.trim() != "true","栏目信息修改成功！","栏目信息修改失败！") ;
				},"text") ;
//				operateAlert(true,"部门名称更新成功！","") ;
//				
				
			}
		}) ;
	}) ;
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
//			eid =  this.id.split("-")[1] +this.id.split("-")[2] ;
			eid =this.id.replace("eid-","");
			console.log("雇员编号：" + eid) ;
			
//			// 编写Ajax异步更新操作
			$.post("pages/back/admin/emp/get.action",{"eid":eid},function(data){
//				operateAlert(data.trim() != "true","栏目信息修改成功！","栏目信息修改失败！") ;
			},"text") ;
			
			
			$("#userInfo").modal("toggle") ;
			
			
		}) ;
	}) ;
}) ;