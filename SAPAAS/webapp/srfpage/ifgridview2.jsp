<%@page contentType="text/html; charset=GBK"%>
<jsp:useBean id="page1" scope="page" class="SA.SRFDA.Web.Default.IfGridViewPage2" />
<%	page1.Init(pageContext);page1.Load();if(page1.IsStop()) return; %>
<%=page1.Render("Iframe")%>
<%=page1.Render() %>
<script type="text/javascript">
Ext.onReady(function(){var A=Ext.getDom('<%=page1.getID()%>');
var _1 = A.style.height;if(_1 == '')A.style.height='100%';$P.iframe['<%=page1.GetCtrlUniqueId("Iframe")%>']='<%=page1.GetCtrlUniqueId("Iframe")%>';});
</script>