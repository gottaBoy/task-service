package net.ibizsys.psmsg.core;

import net.ibizsys.paas.sysmodel.BackendServiceBase;

/**
 * 发送MSN消息
 * 
 * @author Administrator
 * 
 */
public class SendMsnMsgBackendService extends BackendServiceBase {
	// private static Log log = LogFactory.getLog(SendMsnMsgService.class);
	//
	// private Timer sendMsgTimer = null;
	//
	// protected String strQuerySQL = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL AND MSGTYPE = 8 ";
	// protected String strQuerySQL2 = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL AND (PLANSENDTIME IS NULL OR PLANSENDTIME<? ) AND MSGTYPE = 8 ";
	//
	//
	//
	// protected String strMSNUser = "";
	//
	// protected String strMSNPassword = "";
	//
	//
	// int nSendTimer = 30000;
	//
	// MsnMessenger messenger = null;
	//
	// private MsnAdapterEx msnAdapter = new MsnAdapterEx();
	//
	// protected boolean bPlanSendTime = false;
	// protected boolean bDebug = false;
	// protected boolean bSending = false;
	//
	// private class MsgStruct
	// {
	//
	// protected String strEmail = "";
	// protected String strContent = "";
	//
	// public MsgStruct(String strEmail,String strContent)
	// {
	// this.strEmail = strEmail;
	// this.strContent = strContent;
	// }
	//
	// /**
	// * @return the strEmail
	// */
	// public String getEmail()
	// {
	// return strEmail;
	// }
	//
	// /**
	// * @return the strContent
	// */
	// public String getContent()
	// {
	// return strContent;
	// }
	//
	// /**
	// * @param strEmail the strEmail to set
	// */
	// public void setEmail(String strEmail)
	// {
	// this.strEmail = strEmail;
	// }
	//
	// /**
	// * @param strContent the strContent to set
	// */
	// public void setContent(String strContent)
	// {
	// this.strContent = strContent;
	// }
	//
	//
	// }
	//
	// private Vector<MsgStruct> msgList = new Vector<MsgStruct>();
	// private Vector<MsgStruct> msgList2 = new Vector<MsgStruct>();
	//
	// private class MsnAdapterEx extends MsnAdapter
	// {
	// protected boolean bLogin = false;
	//
	// /* (non-Javadoc)
	// * @see net.sf.jml.event.MsnAdapter#loginCompleted(net.sf.jml.MsnMessenger)
	// */
	// @Override
	// public void loginCompleted(MsnMessenger arg0)
	// {
	// super.loginCompleted(arg0);
	// bLogin = true;
	// }
	//
	// /* (non-Javadoc)
	// * @see net.sf.jml.event.MsnAdapter#logout(net.sf.jml.MsnMessenger)
	// */
	// @Override
	// public void logout(MsnMessenger arg0)
	// {
	// super.logout(arg0);
	// bLogin = false;
	// }
	//
	//
	//
	// /**
	// * @return the bLogin
	// */
	// public boolean isLogin()
	// {
	// return bLogin;
	// }
	//
	// /* (non-Javadoc)
	// * @see net.sf.jml.event.MsnAdapter#switchboardStarted(net.sf.jml.MsnSwitchboard)
	// */
	// @Override
	// public void switchboardStarted(MsnSwitchboard arg0)
	// {
	// if(!(arg0.getAttachment() instanceof MsnSwitchboardObject))
	// {
	// arg0.close();
	// return ;
	// }
	//
	// MsnSwitchboardObject msb = (MsnSwitchboardObject)arg0.getAttachment();
	// arg0.inviteContact(msb.getEmail());
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see net.sf.jml.event.MsnAdapter#switchboardClosed(net.sf.jml.MsnSwitchboard)
	// */
	// @Override
	// public void switchboardClosed(MsnSwitchboard arg0)
	// {
	// // TODO Auto-generated method stub
	// super.switchboardClosed(arg0);
	// }
	//
	//
	//
	// public void contactJoinSwitchboard(MsnSwitchboard switchboard,
	// MsnContact contact) {
	//
	// if(!(switchboard.getAttachment() instanceof MsnSwitchboardObject))
	// {
	// switchboard.close();
	// return ;
	// }
	//
	// MsnSwitchboardObject msb = (MsnSwitchboardObject)switchboard.getAttachment();
	//
	// if(!contact.getEmail().equals(msb.getEmail()))
	// {
	// switchboard.close();
	// return ;
	// }
	//
	//
	// //typing message
	// MsnControlMessage typingMessage = new MsnControlMessage();
	// typingMessage.setTypingUser(switchboard.getMessenger()
	// .getOwner().getDisplayName());
	// switchboard.sendMessage(typingMessage);
	//
	// //text message
	// MsnInstantMessage message = new MsnInstantMessage();
	// message.setBold(false);
	// message.setItalic(false);
	//// message
	//// .setFontRGBColor((int) (Math.random() * 255 * 255 * 255));
	// message.setContent(msb.getMessage());
	// switchboard.sendMessage(message);
	// switchboard.close();
	// }
	//
	//// /* (non-Javadoc)
	//// * @see net.sf.jml.event.MsnAdapter#contactAddCompleted(net.sf.jml.MsnMessenger, net.sf.jml.MsnContact, net.sf.jml.MsnList)
	//// */
	//// @Override
	//// public void contactAddCompleted(MsnMessenger arg0, MsnContact arg1, MsnList arg2)
	//// {
	////
	//// // TODO Auto-generated method stub
	//// super.contactAddCompleted(arg0, arg1, arg2);
	//// }
	////
	//// /* (non-Javadoc)
	//// * @see net.sf.jml.event.MsnAdapter#contactListInitCompleted(net.sf.jml.MsnMessenger)
	//// */
	//// @Override
	//// public void contactListInitCompleted(MsnMessenger arg0)
	//// {
	//// arg0.getContactList().get
	//// // TODO Auto-generated method stub
	//// super.contactListInitCompleted(arg0);
	//// }
	////
	//// /* (non-Javadoc)
	//// * @see net.sf.jml.event.MsnAdapter#contactListSyncCompleted(net.sf.jml.MsnMessenger)
	//// */
	//// @Override
	//// public void contactListSyncCompleted(MsnMessenger arg0)
	//// {
	//// // TODO Auto-generated method stub
	//// super.contactListSyncCompleted(arg0);
	//// }
	//
	//
	//
	// }
	//
	//
	// private class MsnSwitchboardObject
	// {
	// protected Email email;
	// protected String strMessage;
	// public MsnSwitchboardObject(Email email,String strMessage)
	// {
	// this.email= email;
	// this.strMessage = strMessage;
	// }
	// /**
	// * @return the email
	// */
	// public Email getEmail()
	// {
	// return email;
	// }
	// /**
	// * @return the strMessage
	// */
	// public String getMessage()
	// {
	// return strMessage;
	// }
	//
	//
	//
	//
	// }
	// /*
	// * (non-Javadoc)
	// *
	// * @see SA.SRFDA.Ctrl.BaseService#OnInit()
	// */
	// @Override
	// protected CallResult OnInit()
	// {
	// CallResult callResult = super.OnInit();
	// if (callResult.IsError())
	// return callResult;
	//
	// if(this.iDAGlobalHelper.getDAModelVersion()>=DAModelVersion.VER_10111600)
	// {
	// strQuerySQL = strQuerySQL2;
	// bPlanSendTime = true;
	// }
	//
	// String strQMHelperObject = this.iDAGlobalHelper.getWebExConfig().GetValue(SRFDAGlobal.WEBCONFIG_SRFDA, "DAQUERYMODELHELPER", "");
	// if(StringHelper.IsNullOrEmpty(strQMHelperObject))
	// {
	// callResult.setRetCode(Errors.INTERNALERROR);
	// callResult.setErrorInfo(StringHelper.Format("没有指定查询查询辅助对象"));
	// return callResult;
	// }
	//
	// BaseDAQueryModelHelper daQueryModelHelper = (BaseDAQueryModelHelper) ObjectHelper.Create(strQMHelperObject);
	// if(daQueryModelHelper == null)
	// {
	// callResult.setRetCode(Errors.INTERNALERROR);
	// callResult.setErrorInfo(StringHelper.Format("无法建立查询辅助对象[%1$s]",strQMHelperObject));
	// return callResult;
	// }
	//
	// int nPageSize = Integer.parseInt(this.GetServiceParam("PAGESIZE", "100"));
	//
	//
	// strQuerySQL = this.GetServiceParam("QUERYSQL", strQuerySQL);
	// strMSNUser = this.GetServiceParam("MSNUSER", "");
	// strMSNPassword = this.GetServiceParam("MSNPASSWORD", "");
	// if (StringHelper.IsNullOrEmpty(strQuerySQL))
	// {
	// callResult.setRetCode(Errors.INTERNALERROR);
	// callResult.setErrorInfo("没有指定未发送MSN消息查询SQL");
	// }
	// bDebug = Boolean.parseBoolean(this.GetServiceParam("DEBUG", "FALSE"));
	// messenger = MsnMessengerFactory.createMsnMessenger(strMSNUser,
	// strMSNPassword);
	// messenger.getOwner().setInitStatus(MsnUserStatus.BUSY);
	// if(bDebug)
	// {
	// messenger.setLogIncoming(true);
	// messenger.setLogOutgoing(true);
	// }
	// messenger.addListener(msnAdapter);
	//
	//
	// strQuerySQL = daQueryModelHelper.GetPagingSQL(strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "","");
	//
	//// //MsnMessenger support all protocols by default
	//// //messenger.setSupportedProtocol(new MsnProtocol[] { MsnProtocol.MSNP8 });
	////
	//// //default init status is online,
	//// //
	////
	//// //log incoming message
	//// messenger.setLogIncoming(true);
	////
	//// //log outgoing message
	//// messenger.setLogOutgoing(true);
	//
	//
	// return callResult;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see SA.SRFDA.Ctrl.BaseService#OnStart()
	// */
	// @Override
	// protected CallResult OnStart()
	// {
	// CallResult callResult = super.OnStart();
	// if (callResult.IsError())
	// return callResult;
	//
	// if (sendMsgTimer == null)
	// {
	// sendMsgTimer = new Timer("MSNMSGSENDQUEUE");
	// sendMsgTimer.schedule(this, nSendTimer, nSendTimer);
	// }
	//
	// log.info(StringHelper.Format("Send MSN Msg Start"));
	//
	// messenger.login();
	//
	// return callResult;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see SA.SRFDA.Ctrl.BaseService#OnStop()
	// */
	// @Override
	// protected CallResult OnStop()
	// {
	// log.info(StringHelper.Format("Send MSN Msg Stop"));
	// if (sendMsgTimer != null)
	// {
	// sendMsgTimer.cancel();
	// sendMsgTimer = null;
	// }
	//
	// if(msnAdapter.isLogin())
	// {
	// this.DoSendMsg();
	// }
	//
	// messenger.logout();
	// return super.OnStop();
	// }
	//
	//
	// protected void InternalRun()
	// {
	// if(!msnAdapter.isLogin())
	// {
	// //没有登录
	// messenger.login();
	// return ;
	// }
	//
	// DoSendMsg();
	//
	// CallParamList callParamList = new CallParamList();
	// if(bPlanSendTime)
	// {
	// java.util.Date date = new java.util.Date();
	// java.sql.Timestamp sendTime = new java.sql.Timestamp(date.getTime()+30000);
	// callParamList.AddDateTime(sendTime);
	// }
	//
	//
	// // 查询待发送的MSN
	// Vector<MsgSendQueue> sendMSNQueueList = new Vector<MsgSendQueue>();
	//
	// CallResult callResult = BaseDEDataCtrl.SelectMulti(this.iDAGlobalHelper, strQuerySQL, callParamList.GetList(), sendMSNQueueList, MsgSendQueue.class.getName());
	// if (callResult.IsError())
	// {
	// log.error(StringHelper.Format("查询未发送邮件发生错误，%1$s", callResult.getErrorInfo()));
	// return;
	// }
	//
	// if (sendMSNQueueList.size() == 0)
	// {
	// return;
	// }
	//
	// IDEDataCtrl iMsgSendQueueDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_MSGSENDQUEUE, SRFDAGlobal.USER_SYSTEM, null);
	// if(iMsgSendQueueDataCtrl == null)
	// {
	// log.error(StringHelper.Format("无法获取实体[%1$s]数据访问对象",SRFDAGlobal.DEID_MSGSENDQUEUE));
	// return ;
	// }
	//
	// IDEDataCtrl iMsgSendQueueHisDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_MSGSENDQUEUEHIS, SRFDAGlobal.USER_SYSTEM, null);
	// if(iMsgSendQueueDataCtrl == null)
	// {
	// log.error(StringHelper.Format("无法获取实体[%1$s]数据访问对象",SRFDAGlobal.DEID_MSGSENDQUEUEHIS));
	// return ;
	// }
	//
	// for (MsgSendQueue msgSendQueue : sendMSNQueueList)
	// {
	// msgSendQueue.SetParamValue("PROCESSTIME", DateParser.GetTimestampValue(new Date()));
	// try
	// {
	// // set TO address
	// String strDstAddresses = msgSendQueue.getDSTADDRESSES();
	// if(!StringHelper.IsNullOrEmpty(strDstAddresses))
	// {
	// String[] addrs = strDstAddresses.split("[;]");
	// for (int i = 0; i < addrs.length; i++)
	// {
	// if(!StringHelper.IsNullOrEmpty(addrs[i]))
	// {
	// msgList.add(new MsgStruct(addrs[i],msgSendQueue.getCONTENT()));
	// }
	// }
	// }
	//
	// String strDstUsers = msgSendQueue.getDSTUSERS();
	// if(!StringHelper.IsNullOrEmpty(strDstUsers))
	// {
	// //获取MSN消息账户数据访问对象
	// IDEDataCtrl msgAccountDataCtrl =this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_MSGACCOUNT, SRFDAGlobal.USER_SYSTEM, null);
	// if(msgAccountDataCtrl == null)
	// {
	// log.error(StringHelper.Format("无法获取实体[%1$s]数据访问对象",SRFDAGlobal.DEID_MSGACCOUNT));
	// return ;
	// }
	// MsgAccount msgAccount = new MsgAccount();
	// String[] addrs = strDstUsers.split("[;]");
	// for (int i = 0; i < addrs.length; i++)
	// {
	// if(!StringHelper.IsNullOrEmpty(addrs[i]))
	// {
	// msgAccount.setMSGACCOUNTID(addrs[i]);
	// callResult = msgAccountDataCtrl.Get(msgAccount) ;
	// if(callResult.IsError())
	// {
	// msgSendQueue.setERRORINFO(StringHelper.Format("发送MSN消息发生错误，获取MSN消息账户[%1$s]失败，%2$s",addrs[i],callResult.getErrorInfo()));
	// msgSendQueue.setISERROR(true);
	// log.error(msgSendQueue.getERRORINFO());
	// iMsgSendQueueDataCtrl.Save(false, msgSendQueue);
	// throw new Exception (msgSendQueue.getERRORINFO());
	// }
	//
	// if(StringHelper.IsNullOrEmpty(msgAccount.getMSNEMAIL()))
	// {
	// msgSendQueue.setERRORINFO(StringHelper.Format("发送MSN消息发生错误，MSN消息账户[%1$s]中不包含MSN消息地址信息",addrs[i]));
	// msgSendQueue.setISERROR(true);
	// log.error(msgSendQueue.getERRORINFO());
	// iMsgSendQueueDataCtrl.Save(false, msgSendQueue);
	// throw new Exception (msgSendQueue.getERRORINFO());
	// }
	// msgList.add(new MsgStruct(msgAccount.getMSNEMAIL(),msgSendQueue.getCONTENT()));
	// }
	// }
	// }
	//
	// msgSendQueue.setISSEND(true);
	// iMsgSendQueueDataCtrl.Save(false, msgSendQueue);
	//
	// MsgSendQueue msgSendQueue2 = new MsgSendQueue();
	// //放入历史发送队列
	//
	// msgSendQueue.setISSEND(true);
	// msgSendQueue.CopyTo(msgSendQueue2, true);
	//
	// msgSendQueue2.SetParamValue("MSGSENDQUEUEHISID", msgSendQueue.getMSGSENDQUEUEID());
	// msgSendQueue2.SetParamValue("MSGSENDQUEUEHISNAME", msgSendQueue.getMSGSENDQUEUENAME());
	//
	// callResult = iMsgSendQueueHisDataCtrl.Save(true, msgSendQueue2);
	// if(callResult.IsError())
	// {
	// throw new Exception(StringHelper.Format("将发送数据放入发送历史记录队列中失败，%1$s",callResult.getErrorInfo()));
	// }
	// //删除当前队列
	// iMsgSendQueueDataCtrl.Remove(msgSendQueue);
	// }
	//
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// DoSendMsg();
	// }
	//
	//
	// private void DoSendMsg()
	// {
	// msgList2.clear();
	// for(MsgStruct msgStruct:msgList)
	// {
	// Email email = Email.parseStr(msgStruct.getEmail());
	// //判断邮件是否在邮件列表中
	// MsnContact msnContact = this.messenger.getContactList().getContactByEmail(email);
	// if(msnContact == null)
	// {
	// this.messenger.addFriend(email, msgStruct.getEmail());
	// msgList2.add(msgStruct);
	// }
	// else
	// {
	// //发送消息
	// MsnSwitchboardObject msb = new MsnSwitchboardObject(msnContact.getEmail(),msgStruct.getContent());
	// this.messenger.newSwitchboard(msb);
	// }
	// }
	// msgList.clear();
	// msgList.addAll(msgList2);
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// *
	// *
	// *
	//
	// * @see SA.SRFDA.Ctrl.BaseService#run()
	// */
	// @Override
	// public void run()
	// {
	// synchronized(this)
	// {
	// if(bSending)
	// return;
	// bSending = true;
	// }
	//
	// InternalRun();
	// synchronized(this)
	// {
	// bSending = false;
	// }
	// }

}
