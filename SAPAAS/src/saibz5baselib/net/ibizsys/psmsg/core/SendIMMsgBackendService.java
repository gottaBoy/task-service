package net.ibizsys.psmsg.core;

import net.ibizsys.paas.sysmodel.BackendServiceBase;

/**
 * 发送IM消息
 * 
 * @author Enmaai
 */
public class SendIMMsgBackendService extends BackendServiceBase {
	/*
	 * private static Log log = LogFactory.getLog(SendIMMsgService.class); private Timer sendMsgTimer = null; private int nSendTimer = 30000; protected boolean bSending = false; protected boolean bPlanSendTime = false;
	 * 
	 * //消息有效期10天 private final static int EXPTIME = 864000000; private final static String DEFAULT_SENDER = "SYSTEM";
	 * 
	 * private final static String TAG_USER ="USER"; private final static String TAG_ALL ="ALL";
	 * 
	 * private final static String TAG_WF = "1001"; private final static String TAG_WFCANCEL = "1002";
	 * 
	 * private final static String TAG_CANCELED = "CANCELED";
	 * 
	 * private final static String TAG_IMACTION = "USERINFORM";
	 * 
	 *//**
		 * IM服务器地址
		 */
	/*
	 * public String strIMServerUrl = "";
	 * 
	 * 
	 * private Vector<MsgSendQueue> msgList = new Vector<MsgSendQueue>(); private Vector<MsgSendQueue> msgList2 = new Vector<MsgSendQueue>();
	 * 
	 * protected String strQuerySQL = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL AND MSGTYPE = 16 AND (USERDATA4 IS NULL OR USERDATA4 <> '1002') "; protected String strQuerySQL2 = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL  AND (PLANSENDTIME IS NULL OR PLANSENDTIME<? ) AND MSGTYPE = 16 AND (USERDATA4 IS NULL OR USERDATA4 <> '1002') ";
	 * 
	 * protected String strCancelQuerySQL = "select distinct userdata ,msgsendqueueid,createdate from T_SRFMSGSendQUEUE where MSGTYPE = 16  AND USERDATA3='1002'"; protected String strCancelQuerySQL2 = "delete from T_SRFMSGSendQUEUE where MSGTYPE = 16 and userdata = ? and createdate<?";
	 * 
	 * protected String strCancelQueryHisSQL = "select * from T_SRFMSGSendQUEUEHIS WHERE USERDATA =? AND ( USERDATA4 IS NULL OR USERDATA4 <> 'CANCELED')";
	 * 
	 * 
	 * @Override protected CallResult OnInit() { CallResult callResult = super.OnInit();
	 * 
	 * if (callResult.IsError()) return callResult;
	 * 
	 * if(this.iDAGlobalHelper.getDAModelVersion()>=DAModelVersion.VER_10111600) { strQuerySQL = strQuerySQL2; bPlanSendTime = true; }
	 * 
	 * nSendTimer = Integer.parseInt(this.GetServiceParam("SENDTIME", "30000"));
	 * 
	 * if(nSendTimer<10000) nSendTimer = 30000;
	 * 
	 * strIMServerUrl = this.GetServiceParam("IMSERVERURL", "");
	 * 
	 * if(StringHelper.IsNullOrEmpty(strIMServerUrl)) { callResult.setRetCode(Errors.INTERNALERROR); callResult.setErrorInfo(StringHelper.Format("没有指定IM服务器地址")); return callResult; }
	 * 
	 * if(this.iDAGlobalHelper.getDAModelVersion()>=DAModelVersion.VER_10111600) { strQuerySQL = strQuerySQL2; }
	 * 
	 * String strQMHelperObject = this.iDAGlobalHelper.getWebExConfig().GetValue(SRFDAGlobal.WEBCONFIG_SRFDA, "DAQUERYMODELHELPER", "");
	 * 
	 * if(StringHelper.IsNullOrEmpty(strQMHelperObject)) { callResult.setRetCode(Errors.INTERNALERROR); callResult.setErrorInfo(StringHelper.Format("没有指定查询查询辅助对象")); return callResult; }
	 * 
	 * BaseDAQueryModelHelper daQueryModelHelper = (BaseDAQueryModelHelper) ObjectHelper.Create(strQMHelperObject);
	 * 
	 * if(daQueryModelHelper == null) { callResult.setRetCode(Errors.INTERNALERROR); callResult.setErrorInfo(StringHelper.Format("无法建立查询辅助对象[%1$s]",strQMHelperObject)); return callResult; }
	 * 
	 * int nPageSize = Integer.parseInt(this.GetServiceParam("PAGESIZE", "100")); strQuerySQL = daQueryModelHelper.GetPagingSQL(strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "","");
	 * 
	 * 
	 * return callResult; }
	 * 
	 * @Override protected CallResult OnStart() { CallResult callResult = super.OnStart(); if (callResult.IsError()) return callResult;
	 * 
	 * if (sendMsgTimer == null) { sendMsgTimer = new Timer("IMMSGSENDQUEUE"); sendMsgTimer.schedule(this, nSendTimer, nSendTimer); }
	 * 
	 * log.info(StringHelper.Format("Send IM Msg Start"));
	 * 
	 * 
	 * return callResult; }
	 * 
	 * @Override public void run() { synchronized(this) { if(bSending) return; bSending = true; }
	 * 
	 * InternalRun(); synchronized(this) { bSending = false; } }
	 * 
	 * protected void InternalRun() { IDEDataCtrl iMsgSendQueueDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_MSGSENDQUEUE, SRFDAGlobal.USER_SYSTEM, null); if(iMsgSendQueueDataCtrl == null) { log.error(StringHelper.Format("无法获取实体[%1$s]数据访问对象",SRFDAGlobal.DEID_MSGSENDQUEUE)); return ; }
	 * 
	 * IDEDataCtrl iMsgSendQueueHisDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_MSGSENDQUEUEHIS, SRFDAGlobal.USER_SYSTEM, null); if(iMsgSendQueueHisDataCtrl == null) { log.error(StringHelper.Format("无法获取实体[%1$s]数据访问对象",SRFDAGlobal.DEID_MSGSENDQUEUEHIS)); return ; }
	 * 
	 * //取消消息 CallParamList cancelParamList = new CallParamList(); cancelParamList.Add(TAG_WFCANCEL); Vector<MsgSendQueue> sendIMQueueList2 = new Vector<MsgSendQueue>();
	 * 
	 * CallResult callResult2 = BaseDEDataCtrl.SelectMulti(this.iDAGlobalHelper, strCancelQuerySQL, null, sendIMQueueList2, MsgSendQueue.class.getName());
	 * 
	 * if(callResult2.IsOk()) { //针对每一条取消语句执行删除操作。 for(MsgSendQueue msg: sendIMQueueList2) { //1.删除队列中的数据 List<MsgSendQueue> tmpList = new ArrayList<MsgSendQueue>(); for(MsgSendQueue omsg:msgList) { if(StringHelper.Compare(omsg.getUSERDATA(),msg.getUSERDATA(),true)==0) { tmpList.add(omsg); } } msgList.removeAll(tmpList);
	 * 
	 * //2.删除其他数据 Vector<CallParam> vector = new Vector<CallParam>(); CallParam cp1 = new CallParam(); cp1.setValue(msg.getUSERDATA()); vector.add(cp1);
	 * 
	 * CallParam cp2 = new CallParam(); cp2.setValue(msg.getCREATEDATE()); vector.add(cp2); BaseDEDataCtrl.ExecuteWithoutResult(this.iDAGlobalHelper, strCancelQuerySQL2, vector);
	 * 
	 * //3.删除历史队列里面的数据 CallParamList cancelParamList2 = new CallParamList(); cancelParamList2.Add(msg.getUSERDATA());
	 * 
	 * Vector<MsgSendQueue> cancelHisList3 = new Vector<MsgSendQueue>();
	 * 
	 * CallResult callResult3 = BaseDEDataCtrl.SelectMulti(this.iDAGlobalHelper, strCancelQueryHisSQL, cancelParamList2.GetList(), cancelHisList3, MsgSendQueue.class.getName());
	 * 
	 * for(MsgSendQueue hmsg:cancelHisList3) { hmsg.setUSERDATA2(TAG_CANCELED);
	 * 
	 * String strMessageId = hmsg.getUSERDATA3();
	 * 
	 * if(!StringHelper.IsNullOrEmpty(strMessageId)) { this.cancelIMMessage(strMessageId); }
	 * 
	 * iMsgSendQueueHisDataCtrl.Save(false, hmsg); }
	 * 
	 * iMsgSendQueueDataCtrl.Remove(msg); } }
	 * 
	 * DoSendMsg();
	 * 
	 * CallParamList callParamList = new CallParamList(); if(bPlanSendTime) { java.util.Date date = new java.util.Date(); java.sql.Timestamp sendTime = new java.sql.Timestamp(date.getTime()+30000); callParamList.AddDateTime(sendTime); } // 查询待发送的IM消息 Vector<MsgSendQueue> sendIMQueueList = new Vector<MsgSendQueue>();
	 * 
	 * CallResult callResult = BaseDEDataCtrl.SelectMulti(this.iDAGlobalHelper, strQuerySQL, callParamList.GetList(), sendIMQueueList, MsgSendQueue.class.getName()); if (callResult.IsError()) { log.error(StringHelper.Format("查询未发送IM消息发生错误，%1$s", callResult.getErrorInfo())); return; }
	 * 
	 * if (sendIMQueueList.size() == 0) { return; }
	 * 
	 * for (MsgSendQueue msgSendQueue : sendIMQueueList) { msgSendQueue.SetParamValue("PROCESSTIME", DateParser.GetTimestampValue(new Date())); try { //将消息添加到系统 msgList.add(msgSendQueue);
	 * 
	 * msgSendQueue.setISSEND(true); iMsgSendQueueDataCtrl.Save(false, msgSendQueue);
	 * 
	 * MsgSendQueue msgSendQueue2 = new MsgSendQueue(); //放入历史发送队列
	 * 
	 * msgSendQueue.setISSEND(true); msgSendQueue.CopyTo(msgSendQueue2, true);
	 * 
	 * msgSendQueue2.SetParamValue("MSGSENDQUEUEHISID", msgSendQueue.getMSGSENDQUEUEID()); msgSendQueue2.SetParamValue("MSGSENDQUEUEHISNAME", msgSendQueue.getMSGSENDQUEUENAME());
	 * 
	 * callResult = iMsgSendQueueHisDataCtrl.Save(true, msgSendQueue2); if(callResult.IsError()) { throw new Exception(StringHelper.Format("将发送数据放入发送历史记录队列中失败，%1$s",callResult.getErrorInfo())); } //删除当前队列 iMsgSendQueueDataCtrl.Remove(msgSendQueue); }
	 * 
	 * catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * DoSendMsg(); }
	 * 
	 *//**
		 * 发送消息
		 */
	/*
	 * private void DoSendMsg() { msgList2.clear();
	 * 
	 * for(MsgSendQueue msg:msgList) { JSONObject jo = new JSONObject(); String strReceiver = msg.getDSTUSERS(); String strContent = msg.getCONTENT(); jo.put("subject",msg.getSUBJECT()); String[] arr = strContent.split("[|]"); String expiredtime = DateParser.toDateString(new Date(new Date().getTime()+EXPTIME)); if(arr.length == 2) { jo.put("content", arr[0]); jo.put("url", arr[1]); }else { jo.put("content", strContent); }
	 * 
	 * if(!StringHelper.IsNullOrEmpty(msg.getDSTADDRESSES())) { jo.put("url", msg.getDSTADDRESSES()); }
	 * 
	 * String msgId = ""; String strUserType = msg.getUSERDATA3(); String strReceiverType = msg.getUSERDATA2();
	 * 
	 * if(StringHelper.Compare(strReceiverType, TAG_ALL, true)!=0) { strReceiverType = TAG_USER; }
	 * 
	 * 
	 * msgId = SendIMMessage(this.strIMServerUrl,jo,DEFAULT_SENDER,strReceiverType,strReceiver,strUserType,expiredtime,TAG_IMACTION);
	 * 
	 * if(!StringHelper.IsNullOrEmpty(msgId)) { IDEDataCtrl iMsgSendQueueHisDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_MSGSENDQUEUEHIS, SRFDAGlobal.USER_SYSTEM, null); if(iMsgSendQueueHisDataCtrl == null) { log.error(StringHelper.Format("无法获取实体[%1$s]数据访问对象",SRFDAGlobal.DEID_MSGSENDQUEUEHIS)); return ; }
	 * 
	 * MsgSendQueue msgSendQueue2 = new MsgSendQueue(); msgSendQueue2.SetParamValue("MSGSENDQUEUEHISID", msg.getMSGSENDQUEUEID()); msgSendQueue2.setUSERDATA3(msgId); CallResult callResult = iMsgSendQueueHisDataCtrl.Save(false,msgSendQueue2);
	 * 
	 * if(callResult.IsError()) { log.error("保存IM消息Id到消息历史错误，"+callResult.getErrorInfo()); } } }
	 * 
	 * msgList.clear(); msgList.addAll(msgList2); }
	 * 
	 * @Override protected CallResult OnStop() { log.info(StringHelper.Format("Send IM Msg Stop")); if (sendMsgTimer != null) { sendMsgTimer.cancel(); sendMsgTimer = null; }
	 * 
	 * DoSendMsg();
	 * 
	 * return super.OnStop(); }
	 * 
	 *//**
		 * 取消消息
		 * 
		 * @param strMsgId
		 */
	/*
	 * public void cancelIMMessage(String strMsgId) {
	 * 
	 * }
	 *//**
		 * 发送消息到检务通
		 * 
		 * @param serverUrl IM服务器地址
		 * @param contentJO 内容
		 * @param sender 发送者
		 * @param receivertype 接受类型（ALL，USER）
		 * @param receiver 接受者
		 * @param infortype 消息类型
		 * @param expiredtime 过期时间
		 * @return 返回发送结果
		 *//*
		 * public String SendIMMessage(String serverUrl,JSONObject contentJO,String sender,String receivertype,String receiver,String informtype,String expiredtime,String imAction) { String strIMMsgId =null;
		 * 
		 * HttpClient client = null; PostMethod postMethod = null;
		 * 
		 * try { client = new HttpClient(); postMethod = new PostMethod(serverUrl);
		 * 
		 * String strParamString = StringHelper.Format("IMACTION=%6$s&SENDER=%1$s&RECEIVERTYPE=%2$s&RECEIVER=%3$s&INFORMTYPE=%4$s&EXPIREDTIME=%5$s", sender,receivertype,receiver,informtype,expiredtime,imAction);
		 * 
		 * //附加Request参数 postMethod.setQueryString(strParamString);
		 * 
		 * //附加post参数 if(contentJO !=null) { postMethod.setRequestEntity(new StringRequestEntity(contentJO.toString(), "text/xml","UTF-8")); }
		 * 
		 * int statusCode = client.executeMethod(postMethod);
		 * 
		 * if(statusCode == HttpStatus.SC_OK ) { String response = postMethod.getResponseBodyAsString(); JSONObject result = JSONObjectHelper.fromString(response); int nRetCode = 0; String strErrorInfo = ""; if(result.has("retcode")) { nRetCode = result.getInt("retcode"); }
		 * 
		 * if(result.has("retinfo")) { strErrorInfo = result.getString("retinfo"); }
		 * 
		 * if(nRetCode == Errors.OK) { //获取消息主键 strIMMsgId = toCallResult(result); }else { log.error("IM服务器处理消息错误，"+strErrorInfo); } }else { log.error(StringHelper.Format("发送消息到IM服务器请求错误，错误码[%1$s],%2$s",statusCode)); } } catch (Exception e) { log.error("发送消息到IM服务器错误,"+e.getMessage()); }finally { if(client !=null) client = null;
		 * 
		 * if(postMethod !=null) postMethod = null; }
		 * 
		 * return strIMMsgId; }
		 * 
		 * private String toCallResult(JSONObject result) { if(result.has("extinfo")) { JSONObject jo = result.getJSONObject("extinfo");
		 * 
		 * if(jo != null && jo.has("USERINFORMID")) { return jo.getString("USERINFORMID"); } } return ""; }
		 */

}
