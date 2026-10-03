package net.ibizsys.psmsg.core;

import net.ibizsys.paas.sysmodel.BackendServiceBase;

/**
 * 发送FTP后台服务
 * 
 * @author Administrator
 */
public class FtpUploadBackendService extends BackendServiceBase {
	/*
	 * private static Log log = LogFactory.getLog(FtpUploadService.class);
	 * 
	 * private Timer sendFtpTimer = null;
	 * 
	 * protected String strQuerySQL = "select * from T_SRFFTPSENDQUEUE where PROCESSTIME IS NULL  AND (PLANSENDTIME IS NULL OR PLANSENDTIME<? ) ";
	 * 
	 * int nSendTimer = 30000;
	 * 
	 * protected boolean bSending = false;
	 * 
	 * protected boolean bDebug = false;
	 * 
	 * protected boolean bPlanSendTime = false;
	 * 
	 * protected IDEDataCtrl iFtpSendQueueDataCtrl = null; protected IDEDataCtrl iFtpSendQueueHisDataCtrl = null; protected IDEDataCtrl iFtpServerDataCtrl = null;
	 * 
	 * 
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFDA.Ctrl.BaseService#OnInit()
	 * 
	 * @Override protected CallResult OnInit() { CallResult callResult = super.OnInit(); if (callResult.IsError()) return callResult;
	 * 
	 * bPlanSendTime = true;
	 * 
	 * String strQMHelperObject = this.iDAGlobalHelper.getWebExConfig().GetValue(SRFDAGlobal.WEBCONFIG_SRFDA, "DAQUERYMODELHELPER", ""); if(StringHelper.IsNullOrEmpty(strQMHelperObject)) { callResult.setRetCode(Errors.INTERNALERROR); callResult.setErrorInfo(StringHelper.Format("没有指定查询查询辅助对象")); return callResult; }
	 * 
	 * BaseDAQueryModelHelper daQueryModelHelper = (BaseDAQueryModelHelper) ObjectHelper.Create(strQMHelperObject); if(daQueryModelHelper == null) { callResult.setRetCode(Errors.INTERNALERROR); callResult.setErrorInfo(StringHelper.Format("无法建立查询辅助对象[%1$s]",strQMHelperObject)); return callResult; }
	 * 
	 * int nPageSize = Integer.parseInt(this.GetServiceParam("PAGESIZE", "10"));
	 * 
	 * strQuerySQL = this.GetServiceParam("QUERYSQL", strQuerySQL);
	 * 
	 * strQuerySQL = daQueryModelHelper.GetPagingSQL(strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "",""); if (StringHelper.IsNullOrEmpty(strQuerySQL)) { callResult.setRetCode(Errors.INTERNALERROR); callResult.setErrorInfo("没有指定未上传文件查询SQL"); }
	 * 
	 * 
	 * iFtpSendQueueDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_FTPSENDQUEUE, SRFDAGlobal.USER_SYSTEM, null); if(iFtpSendQueueDataCtrl == null) { callResult.setRetCode(Errors.INTERNALERROR); callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]数据访问对象",SRFDAGlobal.DEID_FTPSENDQUEUE)); return callResult; }
	 * 
	 * iFtpSendQueueHisDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_FTPSENDQUEUEHIS, SRFDAGlobal.USER_SYSTEM, null); if(iFtpSendQueueDataCtrl == null) { callResult.setRetCode(Errors.INTERNALERROR); callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]数据访问对象",SRFDAGlobal.DEID_FTPSENDQUEUEHIS)); return callResult; }
	 * 
	 * iFtpServerDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_FTPSERVER, SRFDAGlobal.USER_SYSTEM, null); if(iFtpServerDataCtrl == null) { callResult.setRetCode(Errors.INTERNALERROR); callResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]数据访问对象",SRFDAGlobal.DEID_FTPSERVER)); return callResult; }
	 * 
	 * 
	 * 
	 * return callResult; }
	 * 
	 * 
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFDA.Ctrl.BaseService#OnStart()
	 * 
	 * @Override protected CallResult OnStart() { CallResult callResult = super.OnStart(); if (callResult.IsError()) return callResult;
	 * 
	 * if (sendFtpTimer == null) { sendFtpTimer = new Timer("FTPSENDQUEUE"); sendFtpTimer.schedule(this, nSendTimer, nSendTimer); }
	 * 
	 * log.info(StringHelper.Format("FTP Upload Start")); return callResult; }
	 * 
	 * 
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFDA.Ctrl.BaseService#OnStop()
	 * 
	 * @Override protected CallResult OnStop() { log.info(StringHelper.Format("FTP Upload Stop")); if (sendFtpTimer != null) { sendFtpTimer.cancel(); sendFtpTimer = null; }
	 * 
	 * return super.OnStop(); }
	 * 
	 * 
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFDA.Ctrl.BaseService#run()
	 * 
	 * @Override public void run() { synchronized(this) { if(bSending) return; bSending = true; }
	 * 
	 * InternalSend(); synchronized(this) { bSending = false; } }
	 * 
	 * 
	 * protected void InternalSend() { // 查询待发送的邮件 Vector<FtpSendQueue> ftpSendQueueList = new Vector<FtpSendQueue>();
	 * 
	 * CallParamList callParamList = new CallParamList(); if(bPlanSendTime) { java.util.Date date = new java.util.Date(); java.sql.Timestamp sendTime = new java.sql.Timestamp(date.getTime()+30000); callParamList.AddDateTime(sendTime); }
	 * 
	 * CallResult callResult = BaseDEDataCtrl.SelectMulti(this.iDAGlobalHelper, strQuerySQL, callParamList.GetList(), ftpSendQueueList, FtpSendQueue.class.getName()); if (callResult.IsError()) { log.error(StringHelper.Format("查询未发送邮件发生错误，%1$s", callResult.getErrorInfo())); return; }
	 * 
	 * if (ftpSendQueueList.size() == 0) { return; }
	 * 
	 * 
	 * Hashtable<String,FtpServer> ftpServerMap = new Hashtable<String,FtpServer>();
	 * 
	 * for(FtpSendQueue ftpSendQueue:ftpSendQueueList) { ftpSendQueue.SetParamValue("PROCESSTIME", DateParser.GetTimestampValue(new Date())); FtpServer ftpServer = null; if(ftpServerMap.containsKey(ftpSendQueue.getFTPSERVERID())) ftpServer = ftpServerMap.get(ftpSendQueue.getFTPSERVERID()); else { ftpServer = new FtpServer(); ftpServer.setFTPSERVERID(ftpSendQueue.getFTPSERVERID()); callResult = iFtpServerDataCtrl.Get(ftpServer); if(callResult.IsError()) { ftpSendQueue.setISERROR(true); ftpSendQueue.setERRORINFO(StringHelper.Format("获取FTPServer信息发生错误，%1$s",callResult.getErrorInfo())); iFtpSendQueueDataCtrl.Save(false, ftpSendQueue); continue; }
	 * 
	 * ftpServerMap.put(ftpSendQueue.getFTPSERVERID(), ftpServer); }
	 * 
	 * FTPClient ftpClient = new FTPClient(); ftpClient.setControlEncoding("GBK"); try { if(ftpServer.getSERVERPORT()>0) { ftpClient.connect(ftpServer.getSERVERPATH(), ftpServer.getSERVERPORT()); } else { ftpClient.connect(ftpServer.getSERVERPATH()); }
	 * 
	 * // success. int reply = ftpClient.getReplyCode();
	 * 
	 * if (!FTPReply.isPositiveCompletion(reply)) { ftpClient.disconnect(); ftpSendQueue.setISERROR(true); ftpSendQueue.setERRORINFO(StringHelper.Format("连接服务器发生错误")); iFtpSendQueueDataCtrl.Save(false, ftpSendQueue); continue; }
	 * 
	 * 
	 * if (!ftpClient.login(ftpServer.getFTPUSER(), ftpServer.getFTPPWD())) { ftpClient.disconnect(); ftpSendQueue.setISERROR(true); ftpSendQueue.setERRORINFO(StringHelper.Format("登录服务器发生错误")); iFtpSendQueueDataCtrl.Save(false, ftpSendQueue); continue; }
	 * 
	 * // System.out.println("Remote system is " + ftp.getSystemType());
	 * 
	 * ftpClient.setFileType(FTP.BINARY_FILE_TYPE); if(ftpServer.getLOCALPASSIVE()) { ftpClient.enterLocalPassiveMode(); } else { ftpClient.enterLocalActiveMode(); } ftpClient.setUseEPSVwithIPv4(ftpServer.getEPSVWITHIP4());
	 * 
	 * 
	 * InputStream input;
	 * 
	 * input = new FileInputStream(ftpSendQueue.getLOCALFILE());
	 * 
	 * 
	 * //合成远程路径 String strRemoteFile = ftpServer.getINITPATH(); if(!StringHelper.IsNullOrEmpty(strRemoteFile)) { if(strRemoteFile.charAt(strRemoteFile.length()-1)!='/') strRemoteFile+="/"; } else strRemoteFile+="/";
	 * 
	 * String strRemoteFolder = ftpSendQueue.getREMOTEFOLDER(); if(!StringHelper.IsNullOrEmpty(strRemoteFolder)) { if(strRemoteFolder.charAt(0)=='/') { strRemoteFolder = strRemoteFolder.substring(1); } } strRemoteFile+=strRemoteFolder; if(strRemoteFile.charAt(strRemoteFile.length()-1)!='/') strRemoteFile+="/";
	 * 
	 * if(strRemoteFile.charAt(0)=='/') { strRemoteFile = strRemoteFile.substring(1); }
	 * 
	 * 
	 * if(!ftpClient.makeDirectory(strRemoteFile)) { ftpClient.disconnect(); input.close(); ftpSendQueue.setISERROR(true); ftpSendQueue.setERRORINFO(StringHelper.Format("建立文件目录发生错误，%1$s",ftpClient.getReplyString())); iFtpSendQueueDataCtrl.Save(false, ftpSendQueue); continue; }
	 * 
	 * reply = ftpClient.cwd(strRemoteFile); if (!FTPReply.isPositiveCompletion(reply)) { ftpClient.disconnect(); ftpSendQueue.setISERROR(true); ftpSendQueue.setERRORINFO(StringHelper.Format("改变工作目录发生错误，%1$s",GetFtpError(ftpClient))); iFtpSendQueueDataCtrl.Save(false, ftpSendQueue); continue; } //strRemoteFile+=ftpSendQueue.getREMOTEFILE();
	 * 
	 * 
	 * if(!ftpClient.storeFile(ftpSendQueue.getREMOTEFILE(), input)) { ftpClient.disconnect(); input.close(); ftpSendQueue.setISERROR(true); ftpSendQueue.setERRORINFO(StringHelper.Format("上传文件发生错误，%1$s",GetFtpError(ftpClient))); iFtpSendQueueDataCtrl.Save(false, ftpSendQueue); continue; }
	 * 
	 * 
	 * input.close();
	 * 
	 * 
	 * FtpSendQueue ftpSendQueue2 = new FtpSendQueue(); //放入历史发送队列
	 * 
	 * ftpSendQueue.setISSEND(true); ftpSendQueue.CopyTo(ftpSendQueue2, true);
	 * 
	 * ftpSendQueue2.SetParamValue("FTPSENDQUEUEHISID", ftpSendQueue.getFTPSENDQUEUEID()); ftpSendQueue2.SetParamValue("FTPSENDQUEUEHISNAME", ftpSendQueue.getFTPSENDQUEUENAME());
	 * 
	 * callResult = iFtpSendQueueHisDataCtrl.Save(true, ftpSendQueue2); if(callResult.IsError()) { throw new Exception(StringHelper.Format("将发送数据放入发送历史记录队列中失败，%1$s",callResult.getErrorInfo())); } //删除当前队列 iFtpSendQueueDataCtrl.Remove(ftpSendQueue); ftpClient.disconnect(); } catch(Exception ex) { log.error(ex); try { ftpClient.disconnect(); } catch (IOException e) { e.printStackTrace(); } ftpSendQueue.setISERROR(true); ftpSendQueue.setERRORINFO(StringHelper.Format("上传文件发生错误，%1$s",ex.getMessage())); iFtpSendQueueDataCtrl.Save(false, ftpSendQueue); continue; }
	 * 
	 * } }
	 * 
	 * 
	 * protected String GetFtpError(FTPClient ftpClient) { String strError = ""; if(ftpClient.getReplyString()!=null) { strError += ftpClient.getReplyString(); } if(ftpClient.getReplyStrings()!=null) { for(int i=0;i<ftpClient.getReplyStrings().length;i++) { if(!StringHelper.IsNullOrEmpty(strError)) { strError+="."; } strError+=ftpClient.getReplyStrings()[i]; } }
	 * 
	 * return strError;
	 * 
	 * }
	 */
}
