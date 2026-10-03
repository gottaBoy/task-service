package net.ibizsys.psmsg.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.BackendServiceBase;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueueHis;
import net.ibizsys.psrt.srv.common.service.MsgAccountService;
import net.ibizsys.psrt.srv.common.service.MsgSendQueueHisService;
import net.ibizsys.psrt.srv.common.service.MsgSendQueueService;

/**
 * 发送邮件服务
 * 
 * @author Administrator
 */
public class SendMailBackendService extends BackendServiceBase {
	private static Log log = LogFactory.getLog(SendMailBackendService.class);

	private Timer sendmailTimer = null;

	// protected String strQuerySQL = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL AND MSGTYPE = 2 ";

	protected String strQuerySQL = "SELECT * FROM T_SRFMSGSENDQUEUE where PROCESSTIME IS NULL  AND (PLANSENDTIME IS NULL OR PLANSENDTIME<? ) AND MSGTYPE = 2 ";
	protected String strQuerySQLLowCase = "select content,contenttype,createdate,createman,dstaddresses,dstusers,errorinfo,fileat,fileat2,fileat3,fileat4,importanceflag,iserror,issend,msgsendqueueid,msgsendqueuename,msgtype,plansendtime,processtime,sendtag,subject,totaldstaddresses,updatedate,updateman,userdata,userdata2,userdata3,userdata4 from t_srfmsgsendqueue where processtime is null  and (plansendtime is null or plansendtime<? ) and msgtype = 2 ";
	protected String strSMTPServer = "";

	protected int nSMTPPort = 25;

	protected String strSMTPPort = "25";

	protected String strSMTPUser = "";

	protected String strSMTPPassword = "";

	protected String strMailFrom = "";

	protected boolean bSSL = false;

	boolean bSMTPAuth = true;

	int nSendTimer = 30000;

	// protected boolean bSending = false;

	protected boolean bDebug = false;

	protected boolean bPlanSendTime = false;

	private MsgSendQueueService msgSendQueueService = null;
	private MsgSendQueueHisService msgSendQueueHisService = null;
	private MsgAccountService msgAccountService = null;

	public class SmtpAuthenticator extends Authenticator {
		private PasswordAuthentication password_auth;

		public SmtpAuthenticator(String smtp_user, String smtp_password) {
			password_auth = new PasswordAuthentication(smtp_user, smtp_password);
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return password_auth;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		bPlanSendTime = true;

		// String strQMHelperObject = this.iDAGlobalHelper.getWebExConfig().GetValue(SRFDAGlobal.WEBCONFIG_SRFDA, "DAQUERYMODELHELPER", "");
		// if(StringHelper.isNullOrEmpty(strQMHelperObject))
		// {
		// callResult.setRetCode(Errors.INTERNALERROR);
		// throw new Exception(StringHelper.format("没有指定查询查询辅助对象"));
		//
		// }
		//
		// BaseDAQueryModelHelper daQueryModelHelper = (BaseDAQueryModelHelper) ObjectHelper.Create(strQMHelperObject);
		// if(daQueryModelHelper == null)
		// {
		// callResult.setRetCode(Errors.INTERNALERROR);
		// throw new Exception(StringHelper.format("无法建立查询辅助对象[%1$s]",strQMHelperObject));
		//
		// }

		// SystemRTHelper.

		int nPageSize = Integer.parseInt(this.getServiceParam("PAGESIZE", "100"));
		if(WebConfig.getCurrent().isLowCaseSql() ) {
			strQuerySQL = this.getServiceParam("QUERYSQL", strQuerySQLLowCase);
		}else {
			strQuerySQL = this.getServiceParam("QUERYSQL", strQuerySQL);
		}
		
		strSMTPServer = this.getServiceParam("SMTPSERVER", "");
		nSMTPPort = Integer.parseInt(this.getServiceParam("SMTPPORT", "25"));
		strSMTPPort = this.getServiceParam("SMTPPORT", "25");
		strSMTPUser = this.getServiceParam("SMTPUSER", "");
		strSMTPPassword = this.getServiceParam("SMTPPASSWORD", "");
		strMailFrom = this.getServiceParam("MAILFROM", strSMTPUser);
		bSMTPAuth = Boolean.parseBoolean(this.getServiceParam("SMTPAUTH", "TRUE"));
		nSendTimer = Integer.parseInt(this.getServiceParam("SENDTIMER", "30000"));
		bDebug = Boolean.parseBoolean(this.getServiceParam("DEBUG", "FALSE"));
		bSSL = Boolean.parseBoolean(this.getServiceParam("SSL", "FALSE"));

		msgSendQueueService = (MsgSendQueueService) ServiceGlobal.getService(MsgSendQueueService.class);
		msgSendQueueHisService = (MsgSendQueueHisService) ServiceGlobal.getService(MsgSendQueueHisService.class);
		msgAccountService = (MsgAccountService) ServiceGlobal.getService(MsgAccountService.class);

		strQuerySQL = msgSendQueueService.getDAO().getRealDBDialect().getPagingSQL(strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "", "");
		if (StringHelper.isNullOrEmpty(strQuerySQL)) {
			throw new Exception("没有指定未发送邮件查询SQL");
		}

		if (StringHelper.isNullOrEmpty(strSMTPServer)) {
			throw new Exception("没有指定邮件发送服务器");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onStart()
	 */
	@Override
	protected void onStart() throws Exception {
		super.onStart();

		if (sendmailTimer == null) {
			sendmailTimer = new Timer("MSGSENDQUEUE");
			sendmailTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					runTask();
				}
			}, nSendTimer, nSendTimer);
		}

		log.info(StringHelper.format("Send Mail Start"));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.BackendServiceBase#onStop()
	 */
	@Override
	protected void onStop() throws Exception {
		log.info(StringHelper.format("Send Mail Stop"));
		if (sendmailTimer != null) {
			sendmailTimer.cancel();
			sendmailTimer = null;
		}

		super.onStop();
	}

	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.sysmodel.BackendServiceBase#run()
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
	// try
	// {
	// internalSend();
	// }
	// catch(Exception ex)
	// {
	// log.error(StringHelper.format("发送邮件发生错误，%1$s",ex.getMessage()),ex);
	// }
	//
	// synchronized(this)
	// {
	// bSending = false;
	// }
	// }

	/**
	 * 内部发送处理
	 * 
	 * @throws Exception
	 */
	@Override
	protected void onRun() throws Exception {
		// 查询待发送的邮件
		SqlParamList sqlParamList = new SqlParamList();
		if (bPlanSendTime) {
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp sendTime = new java.sql.Timestamp(date.getTime() + 30000);
			sqlParamList.addDateTime(sendTime);
		}

		ArrayList<IEntity> sendMailQueueList = msgSendQueueService.selectRaw(strQuerySQL, sqlParamList);
		if (sendMailQueueList.size() == 0) {
			return;
		}

		Session session = null;
		try {
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", this.bSSL ? "smtps" : "smtp");
			props.setProperty("mail.smtp.host", strSMTPServer);
			props.setProperty("mail.smtp.port", strSMTPPort);
			props.setProperty("mail.smtp.user", strSMTPUser); // 发送方邮件地址。
			props.setProperty("mail.smtp.from", strMailFrom);
			props.setProperty("mail.smtp.password", strSMTPPassword); // 邮件密码。
			props.setProperty("mail.smtp.auth", bSMTPAuth ? "true" : "false");
			// props.put("mail.smtp.sendpartial",true);
			props.setProperty("mail.smtp.timeout", StringHelper.format("%1$s", 1000 * 60 * 10));
			props.setProperty("mail.smtp.starttls.enable", "true");

			if (this.bSSL) {
				props.setProperty("mail.smtp.ssl.enable", "true");
				props.setProperty("mail.smtp.socketFactory.host", strSMTPServer);
				props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.setProperty("mail.smtp.socketFactory.fallback", "false");
			}

			session = Session.getDefaultInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(strSMTPUser, strSMTPPassword);
				}
			});

			/*
			 * if(bDebug) { session.getProperties().setProperty("mail.debug","true"); session.setDebug(true); }
			 */
			// if(this.bSSL)
			// {
			// transport = session.getTransport("smtps");
			// }
			// else
			// transport = session.getTransport("smtp");
			//
			// // transport.connect(strSMTPUser, strSMTPPassword);
			// transport.connect(strSMTPServer, nSMTPPort, strSMTPUser, strSMTPPassword);
		} catch (Exception ex) {
			log.error(StringHelper.format("登录邮件服务器发生错误，%1$s", ex.getMessage()), ex);
			return;
		}
		for (IEntity iEntity : sendMailQueueList) {
			MsgSendQueue msgSendQueue = new MsgSendQueue();
			iEntity.copyTo(msgSendQueue, false);
			msgSendQueue.set("PROCESSTIME", DateHelper.getTimestampValue(new Date()));
			try {
				MimeMessage mimemessage = new MimeMessage(session);
				mimemessage.setFrom(new InternetAddress(strMailFrom));
				mimemessage.setSentDate(new Date());
				// set SUBJECT

				// 标题转码
				// String strSubject= MimeUtility.encodeText(msgSendQueue.getSubject(), "GBK", "B");

				mimemessage.setSubject(msgSendQueue.getSubject(), "GBK");

				Vector<InternetAddress> addressList = new Vector<InternetAddress>();

				// set TO address
				String strDstAddresses = msgSendQueue.getDstAddresses();
				if (!StringHelper.isNullOrEmpty(strDstAddresses)) {
					String[] addrs = strDstAddresses.split("[;]");
					for (int i = 0; i < addrs.length; i++) {
						if (!StringHelper.isNullOrEmpty(addrs[i])) {
							addressList.add(new InternetAddress(addrs[i]));
						}
					}
				}

				String strDstUsers = msgSendQueue.getDstUsers();
				if (!StringHelper.isNullOrEmpty(strDstUsers)) {
					MsgAccount msgAccount = new MsgAccount();
					String[] addrs = strDstUsers.split("[;]");
					for (int i = 0; i < addrs.length; i++) {
						if (!StringHelper.isNullOrEmpty(addrs[i])) {
							msgAccount.setMsgAccountId(addrs[i]);
							if (!msgAccountService.get(msgAccount, true)) {
								msgSendQueue.setErrorInfo(StringHelper.format("发送邮件发生错误，获取消息账户[%1$s]失败", addrs[i]));
								msgSendQueue.setIsError(1);
								log.error(msgSendQueue.getErrorInfo());
								msgSendQueueService.update(msgSendQueue);
								throw new Exception(msgSendQueue.getErrorInfo());
							}

							// 判断是否为组用户
							if (DataObject.getBoolValue(msgAccount.getIsList(), false)) {
								// Vector<MsgAccount > msgAccountList = new Vector<MsgAccount >();
								// callResult = msgAccountDataCtrl.Select(MsgAccount.SELECTMODE_LISTGROUPDETAIL, msgAccount, msgAccountList,MsgAccount.class.getName()) ;
								// if(callResult.IsError())
								// {
								// msgSendQueue.setErrorInfo(StringHelper.format("发送邮件发生错误，获取消息账户组[%1$s]明细用户失败，%2$s",addrs[i],callResult.getErrorInfo()));
								// msgSendQueue.setIsError(1);
								// log.error(msgSendQueue.getErrorInfo());
								// msgSendQueueService.update( msgSendQueue);
								// throw new Exception (msgSendQueue.getErrorInfo());
								// }
								//
								// for(MsgAccount temp:msgAccountList)
								// {
								// if(StringHelper.isNullOrEmpty(temp.getMailAddress()))
								// {
								// msgSendQueue.setErrorInfo(StringHelper.format("发送邮件发生错误，消息账户[%1$s]中不包含邮件地址信息",temp.getMSGACCOUNTID()));
								// msgSendQueue.setIsError(1);
								// log.error(msgSendQueue.getErrorInfo());
								// msgSendQueueService.update( msgSendQueue);
								// throw new Exception (msgSendQueue.getErrorInfo());
								// }
								// addressList.add(new InternetAddress(temp.getMailAddress()));
								// }
							} else {
								if (StringHelper.isNullOrEmpty(msgAccount.getMailAddress())) {
									msgSendQueue.setErrorInfo(StringHelper.format("发送邮件发生错误，消息账户[%1$s]中不包含邮件地址信息", addrs[i]));
									msgSendQueue.setIsError(1);
									log.error(msgSendQueue.getErrorInfo());
									msgSendQueueService.update(msgSendQueue);
									throw new Exception(msgSendQueue.getErrorInfo());
								}
								addressList.add(new InternetAddress(msgAccount.getMailAddress()));
							}
						}
					}
				}
				String strTotalAddr = "";
				try {
					InternetAddress[] iaddrs = new InternetAddress[addressList.size()];
					addressList.toArray(iaddrs);
					mimemessage.setRecipients(javax.mail.Message.RecipientType.TO, iaddrs);

					for (InternetAddress iAddr : addressList) {
						if (!StringHelper.isNullOrEmpty(strTotalAddr)) strTotalAddr += ";";
						strTotalAddr += iAddr.getAddress();
					}

				} catch (Exception exception1) {
					log.error("发送邮件发生错误", exception1);
					msgSendQueue.setErrorInfo(exception1.getMessage());
					msgSendQueue.setIsError(1);
					msgSendQueueService.update(msgSendQueue);
					throw exception1;
				}

				String strEncode = "text/html;charset=GBK";
				if (StringHelper.compare(msgSendQueue.getContentType(), "HTML", true) != 0) {
					strEncode = "text/plain;charset=GBK";
				}

				// set message BODY
				MimeBodyPart mimebodypart = new MimeBodyPart();
				mimebodypart.setContent(msgSendQueue.getContent(), strEncode);

				// attach message BODY
				MimeMultipart mimemultipart = new MimeMultipart();
				mimemultipart.addBodyPart(mimebodypart);

				ArrayList attachedFileList = new ArrayList();
				if (!StringHelper.isNullOrEmpty(msgSendQueue.getFileAT())) {
					attachedFileList.add(msgSendQueue.getFileAT());
				}
				if (!StringHelper.isNullOrEmpty(msgSendQueue.getFileAT2())) {
					attachedFileList.add(msgSendQueue.getFileAT2());
				}
				if (!StringHelper.isNullOrEmpty(msgSendQueue.getFileAT3())) {
					attachedFileList.add(msgSendQueue.getFileAT3());
				}
				if (!StringHelper.isNullOrEmpty(msgSendQueue.getFileAT4())) {
					attachedFileList.add(msgSendQueue.getFileAT4());
				}

				if (attachedFileList.size() > 0) {
					for (Iterator e = attachedFileList.iterator(); e.hasNext();) {
						FileDataSource ds = new FileDataSource((String) e.next());

						mimebodypart = new MimeBodyPart();
						try {
							mimebodypart.setDataHandler(new DataHandler(ds));
						} catch (Exception exception3) {
							throw exception3;
						}
						mimebodypart.setFileName(MimeUtility.encodeText(ds.getName())); // set
																						// FILENAME
						mimemultipart.addBodyPart(mimebodypart);
					}
				}

				mimemessage.setContent(mimemultipart);
				// mimemessage.setSubject(msgSendQueue.getSubject(),"GBK");
				mimemessage.saveChanges();
				try {
					// transport.send(mimemessage);
					// transport.sendMessage(mimemessage, mimemessage
					// .getRecipients(javax.mail.Message.RecipientType.TO) );

					Transport.send(mimemessage);

					MsgSendQueueHis msgSendQueue2 = new MsgSendQueueHis();
					// 放入历史发送队列

					msgSendQueue.setIsSend(1);
					msgSendQueue.setIsError(0);
					msgSendQueue.setTotalDstAddresses(strTotalAddr);
					msgSendQueue.copyTo(msgSendQueue2, true);

					msgSendQueue2.set("MSGSENDQUEUEHISID", msgSendQueue.getMsgSendQueueId());
					msgSendQueue2.set("MSGSENDQUEUEHISNAME", msgSendQueue.getMsgSendQueueName());

					try {
						msgSendQueueHisService.create(msgSendQueue2);
					} catch (Exception ex) {
						// 删除当前队列
						msgSendQueueService.remove(msgSendQueue);
						throw new Exception(StringHelper.format("将发送数据放入发送历史记录队列中失败，%1$s", ex.getMessage()));
					}
					// 删除当前队列
					msgSendQueueService.remove(msgSendQueue);

				} catch (Exception exception) {
					log.error("发送邮件发生错误", exception);
					exception.printStackTrace();
					msgSendQueue.setErrorInfo(exception.getMessage());
					msgSendQueue.setIsError(1);
					msgSendQueueService.update(msgSendQueue);
					break;
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
