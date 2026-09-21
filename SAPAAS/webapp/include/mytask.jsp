<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="saeam.include.MyTask" />
<%
	page1.Init(pageContext);
	page1.Load();
%>
<table width="160" border="0" align="center" cellpadding="0"
	cellspacing="0">
	 
	<tr>
		<td>

		<TABLE   cellSpacing="0" width="100%" align="center" > 
			<TR>
				<TD  >
				<div class="sx-panel" id="dt"></div>
				</TD>
			</TR> 
		</TABLE>
		</td>
	</tr>
</table>
<%=page1.Render()%>

<SCRIPT type="text/javascript">
				 
			d = new dTree('d');
		d.config.target = "mainFrame";

//id, pid, name, url, title, target, icon, iconOpen, open 
				d.add(0,"-1",'<span class=sx-normaltext10-blue><%=page1.getWebContext().getCurUserName()%></span><span class=sx-normaltext10>的个人文件夹</span>','','个人文件夹','_self','../images/icon_task_pd.gif','../images/icon_task_pd.gif');
			             d.add(2,"0",'我的申请','','我的申请','_self','../images/icon_apply_ap.gif','../images/icon_apply_ap.gif',true);
		                d.add(3,"0",'我的工单','','我的工单','_self','../images/icon_task_wo.gif','../images/icon_task_wo.gif',true);
		                
		                 
		        
		                d.add(21,"2",'待审核申请','../emwomgr/mMAssetTypeSearchAction.jsp','待审核申请','_self','../images/icon_apply_wa.gif','../images/icon_apply_wa.gif'); 
		                d.add(22,"2",'待处理申请','../emwomgr/mMAssetListSearchAction.jsp','待处理申请','_self','../images/icon_apply_wd.gif','../images/icon_apply_wd.gif');
		                d.add(13,"2",'已完成申请','','已完成申请','_self','../images/icon_apply_fn.gif','../images/icon_apply_fn.gif');
		                d.add(23,"13",'已关闭申请','../emwomgr/mMAssetDetailSearchAction.jsp','已关闭申请','_self','../images/icon_apply_cl.gif','../images/icon_apply_cl.gif');
		                d.add(24,"13",'未通过申请','../emwomgr/mMAssetAccountSearchAction.jsp','未通过申请','_self','../images/icon_task_an.gif','../images/icon_task_an.gif'); 
		                
		
		                d.add(31,"3",'待审核工单','../emwomgr/mMEquipSearchAction.jsp','待审核工单','_self','../images/icon_task_wa.gif','../images/icon_task_wa.gif');
		              	d.add(32,"3",'未通过工单','../emwomgr/mMEquipSearchAction.jsp','未通过工单','_self','../images/icon_task_an.gif','../images/icon_task_an.gif');
		                d.add(33,"3",'待指派工单','../emwomgr/mMSoftSearchAction.jsp','待指派工单','_self','../images/icon_task_ws.gif','../images/icon_task_ws.gif');
		                d.add(34,"3",'待接收工单','../emwomgr/mMEquipKeepSearchAction.jsp','待接收工单','_self','../images/icon_task_wr.gif','../images/icon_task_wr.gif');
		                d.add(35,"3",'正在执行工单','../emwomgr/mMEquipRepairSearchAction.jsp','正在执行工单','_self','../images/icon_task_ex.gif','../images/icon_task_ex.gif');
		                d.add(36,"3",'执行完毕工单','../emwomgr/mMEquipCheckSearchAction.jsp','执行完毕工单','_self','../images/icon_task_ov.gif','../images/icon_task_ov.gif');
		                d.add(17,"3",'已关闭工单','','已关闭工单','_self','../images/icon_task_fn.gif','../images/icon_task_fn.gif');
		                d.add(37,"17",'正常结束工单','../emwomgr/mMEquipUseSearchAction.jsp','正常结束工单','_self','../images/icon_task_cl.gif','../images/icon_task_cl.gif');
		          		d.add(38,"17",'非正常结束工单','../emwomgr/mMEquipUseSearchAction.jsp','非正常结束工单','_self','../images/icon_task_st.gif','../images/icon_task_st.gif'); 
		           
				dt.innerHTML=d;  
		 
</SCRIPT>
