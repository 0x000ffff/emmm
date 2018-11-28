<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>

<script
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		Hello <br> <a
			href="${pageContext.request.contextPath}/emp/getEmps">试一下</a>
		<table class="table table-bordered table-hover">
			<thead style="background-color: #0D56A6">
				<tr>
					<td><a href="javascript:" id="CheckAll">反选</a></td>
					<td>ID</td>
					<td>NAME</td>
					<td>GENDER</td>
					<td>EAMIL</td>
					<td>DEPT</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="tb">
			</tbody>
		</table>
		<div style="margin: auto 30%">
			<button id="add" type="button" class="btn btn-primary"
				data-toggle="modal" data-target="#myModal">新增</button>
			<button id="del" type="button" class="btn btn-danger">删除</button>
			<button id="pre" type="button" class="btn btn-primary">上一页</button>
			当前:<input style="width: 20px" type="text" id="pageNumber"
				readonly="readonly">
			<button id="next" type="button" class="btn btn-success">下一页</button>
			总共:<input style="width: 20px" type="text" id="pageCount"
				readonly="readonly">
		</div>
		<script type="text/javascript">
		$("document").ready(()=>{
			getData();
			$("#CheckAll").click(()=>{
				$("input[name='choose']").prop("checked",(i,val)=>!val);
			});
			
			$("#pre").click(()=>{
				this.pageNumber = this.pageNumber-1;
				getData();
			});
			
			$("#next").click(()=>{
				this.pageNumber = this.pageNumber+1;
				getData();
			});
		});
		
		var pageNumber = 1;
		var pageSize = 10;
		var pre = 0;
		var next = 0;
		var total = 0;
		var pageCount = 0;
		//获取数据
		var getData=()=>{
			$.ajax({
				url:'${pageContext.request.contextPath}/emp/getEmps',
				type:'post',
				data:'pageNumber='+pageNumber+'&pageSize='+pageSize,
				dataType:'json',
				success:function(data){
					console.log(data);
					 var tr = "";
					 pre = data.pre;
					 next = data.next;
					 total = data.total;
					 pageCount = data.pageCount;
					 
					 if(pageNumber==1){
						 $("#pre").prop("disabled",true);
					 }else{
						 $("#pre").prop("disabled",false);
					 }
					 if(pageNumber==pageCount){
						 $("#next").prop("disabled",true);
					 }else{
						 $("#next").prop("disabled",false);
					 }
					 
					$.each(data.data, function(key, val) {
						var td = "<tr><td><input name='choose' type='checkbox' value='"+val.empId+"'</td><td>" + val.empId + "</td><td>" + val.empName
								+ "</td><td>" + (val.gender == 'f' ? "女" : "男")
								+ "</td><td>" + val.email + "</td><td>"
								+ val.dept.deptName + "</td><td><button type='button' class='btn btn-danger' onclick=delEmp('"+val.empId+"')>删除</button></td></tr>";
						tr+=td; 
					}) 
					console.info(tr);
					$("#tb").html(tr);
					$("#pageNumber").val(pageNumber);
					$("#pageCount").val(pageCount);
				}
			});
		}
		
		//批量删除
		$("#del").click(()=>{
			debugger
			var checked = new Array();
			var es = $("input[name='choose']");
			$.each(es,(index,item)=>{
				if(item.checked){
					console.log(item.getAttribute("value"));
					checked.push(item.getAttribute("value"));
				}
			})
			console.log(checked.length==0)
			if(checked.length==0){
				alert("您没有选中任何记录");
				return ;
			}
			$.ajax({
				url:'${pageContext.request.contextPath}/emp/deleteEmps',
				type:'post',
				data:'delList='+checked,
				dataType:'json',
				success:(data)=>{
					console.log(data);
					getData();
					alert(data.result);
				}
			});
		});
		//单个删除
		var delEmp=(arg)=>{
			$.ajax({
				url:'${pageContext.request.contextPath}/emp/deleteEmp',
				type:'post',
				data:'empId='+arg,
				dataType:'json',
				success:(data)=>{
					console.log(data);
					getData();
					alert(data.result);
				}
			});
		}
	</script>


		<!-- 新增用户模态框（Modal） start -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h6 class="modal-title" id="myModalLabel">新增用户</h6>
					</div>
					<div class="modal-body">
						<form id="addForm" class="form-horizontal">
							<div class="form-group">
								<label for="empName" class="col-sm-2 control-label">Name</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="empName"
										name="empName" placeholder="Name">
								</div>
							</div>
							<br>
							<div class="form-group">
								<label for="email" class="col-sm-2 control-label">Email</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="email" name="email"
										placeholder="Email">
								</div>
							</div>
							<br>
							<div class="form-group">
								<label for="Gender" class="col-sm-2 control-label">Gender</label>
								<div class="col-sm-10">
									<div id="Gender">
										<input name="gender" type="radio" class="form-control"
											value="f" checked="checked">女 <input name="gender"
											type="radio" class="form-control" value="m">男
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<label for="Dept" class="col-sm-2 control-label">Dept</label>
								<div class="col-sm-10">
									<div id="Dept">
										<select id="Department" name="deptId">
											<option value='-1' selected="selected">请选择部门</option>
										</select>
									</div>
								</div>
							</div>
							<br>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button id="submit" type="button" class="btn btn-success">提交</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<script type="text/javascript">
			$("#add").click(()=>{
				$.ajax({
					url:'${pageContext.request.contextPath}/dept/getDepts',
					type:'post',
					dataType:'json',
					success:(data)=>{
						console.log(data);
						var temp = "";
						$.each(data,(k,v)=>{
							temp+="<option value="+v.deptId+">"+v.deptName+"</option>";
						})
						console.log(temp);
						$("#Department").append(temp);
					}
				});
			});
			
			$("#submit").click(()=>{
				/* var empName = $("#empName").val();
				var email = $("#email").val();
				var gender = $("input[name='gender']:checked").val();
				var deptId = $("#Department").val();
				
				var fd = new FormData();
				fd.append("empName",empName);
				fd.append("email",email);
				fd.append("gender",gender);
				fd.append("deptId",deptId); */
				
				//var fd = new FormData(document.getElementById("addForm"));
				$.ajax({
					url:'${pageContext.request.contextPath}/emp/insertEmp',
					type:'post',
					async:false,
					data:$("#addForm").serialize(),
					dataType:'json',
					success:(data)=>{
						alert(data.result);
					}
				});
			});
			
	</script>

		<!-- 新增用户模态框（Modal） end -->

	</div>

</body>
</html>