<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="modal fade" id="userInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<div class="form-group" id="didDiv">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;查看部门领导信息</strong></h3>
				</div>
			</div>
			<div class="modal-body">
				<div id="costBasicInfo">
					<div class="row">
						<div class="col-xs-3">
							<img id="modal-photo" src="upload/member/nophoto.png" style="width:200px;">
						</div>
						<div class="col-xs-8">
							<table class="table table-condensed" style="width:700px;">
								<tr>
								<%-- <c:forEach items="${allDeptName}" var="dept">${dept.dname }</c:forEach> --%>
								 
									<td style="width:30%;"><strong>雇员姓名：</strong></td>
									<td><span id="modal-name">老李</span></td>
								</tr>
								<tr>
									<td><strong>雇员职务：</strong></td>
									<td id="modal-level">部门经理</td>
								</tr>
								<tr>
									<td><strong>所属部门：</strong></td>
									<td id="modal-dept">技术部</td>
								</tr>
								<tr>
									<td><strong>联系电话：</strong></td>
									<td id="modal-tel">123432890</td>
								</tr>
								<tr>
									<td><strong>雇佣日期：</strong></td>
									<td id="modal-date">2019-10-10</td>
								</tr>
								<tr>
									<td><strong>备注信息：</strong></td>
									<td id="modal-note"><pre class="pre-scrollable" style="width:400px;height:210px;">发神经阿德里飞洒抵抗力 范德克鲁斯建立开放撒 方力申搭建了开发商的 发动机萨拉空间来看 234uop富士达会计分录款手机范德萨进来进来看范德萨克利夫兰斯顿卡机了开发商大量了快捷方式的拉开建立开放撒酒 刘嘉玲发撒旦机立刻地方撒刻录机弗拉基反抗螺丝钉</pre></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>
