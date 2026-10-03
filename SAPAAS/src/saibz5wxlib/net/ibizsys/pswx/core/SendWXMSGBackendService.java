package net.ibizsys.pswx.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
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
import net.ibizsys.psrt.srv.wx.entity.WXAccount;
import net.ibizsys.psrt.srv.wx.service.WXAccountService;
import net.ibizsys.pswx.bean.WXOutNewsMsg;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 发送微信消息服务
 * 
 * @author Administrator
 */
public class SendWXMSGBackendService extends BackendServiceBase {
	private static Log log = LogFactory.getLog(SendWXMSGBackendService.class);

	private Timer sendWXTimer = null;
	protected String strQuerySQL = "select * from T_SRFMSGSENDQUEUE where PROCESSTIME IS NULL  AND (PLANSENDTIME IS NULL OR PLANSENDTIME<? ) AND MSGTYPE = 32 ";
	protected String strQuerySQLLowCase = "select content,contenttype,createdate,createman,dstaddresses,dstusers,errorinfo,fileat,fileat2,fileat3,fileat4,importanceflag,iserror,issend,msgsendqueueid,msgsendqueuename,msgtype,plansendtime,processtime,sendtag,subject,totaldstaddresses,updatedate,updateman,userdata,userdata2,userdata3,userdata4 from t_srfmsgsendqueue where processtime is null  and (plansendtime is null or plansendtime<? ) and msgtype = 32 ";
	int nSendTimer = 30000;
	protected boolean bPlanSendTime = false;

	// 公众号标识
	protected String strWXAccountId = "";
	// 应用AgentId
	protected int nWXEntAppAgentId = -1;
	// 工作流代办消息跳转链接
	protected String strWXWFRedirectUrl = "";

	private MsgSendQueueService msgSendQueueService = null;
	private MsgSendQueueHisService msgSendQueueHisService = null;
	private MsgAccountService msgAccountService = null;

	private IWXEntAppModel iWXEntAppModel = null;

	@Override
	protected void onInit() throws Exception {
		super.onInit();

		bPlanSendTime = true;

		int nPageSize = Integer.parseInt(this.getServiceParam("PAGESIZE", "100"));
		if(WebConfig.getCurrent().isLowCaseSql() ) {
			strQuerySQL = this.getServiceParam("QUERYSQL", strQuerySQLLowCase);
		}else {
			strQuerySQL = this.getServiceParam("QUERYSQL", strQuerySQL);
		}
		nSendTimer = Integer.parseInt(this.getServiceParam("SENDTIMER", "30000"));

		msgSendQueueService = (MsgSendQueueService) ServiceGlobal.getService(MsgSendQueueService.class);
		msgSendQueueHisService = (MsgSendQueueHisService) ServiceGlobal.getService(MsgSendQueueHisService.class);
		msgAccountService = (MsgAccountService) ServiceGlobal.getService(MsgAccountService.class);

		strQuerySQL = msgSendQueueService.getDAO().getRealDBDialect().getPagingSQL(strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "", "");
		if (StringHelper.isNullOrEmpty(strQuerySQL)) {
			throw new Exception("没有指定未发送微信消息查询SQL");
		}

		this.strWXAccountId = this.getServiceParam("WXENTACCOUNTID", "");
		this.nWXEntAppAgentId = Integer.parseInt(this.getServiceParam("WXENTAPPAGENTID", "-1"));
		this.strWXWFRedirectUrl = this.getServiceParam("WXWFREDIRECTURL", "");

		if (StringHelper.isNullOrEmpty(this.strWXWFRedirectUrl)) {
			throw new Exception("无法获取微信公众号工作流代办重定向地址[WXWFREDIRECTURL]");
		}

		if (StringHelper.isNullOrEmpty(this.strWXAccountId) || this.nWXEntAppAgentId < 1) {
			throw new Exception("无法获取微信公众号标识[WXENTACCOUNTID][WXENTAPPAGENTID]");
		}

		IWXAccountModel iWXAccountModel = WXGlobal.getWXAccountModel(this.strWXAccountId);

		if (iWXAccountModel == null) {
			throw new Exception("无法获取微信企业号[" + this.strWXAccountId + "]对象");
		}

		this.iWXEntAppModel = iWXAccountModel.getWXEntAppModel(this.nWXEntAppAgentId);

		if (this.iWXEntAppModel == null) {
			throw new Exception("无法获取微信企业号应用[" + this.nWXEntAppAgentId + "]对象");
		}
	}

	@Override
	protected void onStart() throws Exception {
		super.onStart();

		if (sendWXTimer == null) {
			sendWXTimer = new Timer("WXSENDQUEUE");
			sendWXTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					runTask();
				}
			}, nSendTimer, nSendTimer);
		}

		log.info(StringHelper.format("微信发送服务启动"));
	}

	@Override
	protected void onStop() throws Exception {
		log.info(StringHelper.format("微信发送服务停止"));
		if (sendWXTimer != null) {
			sendWXTimer.cancel();
			sendWXTimer = null;
		}

		super.onStop();
	}

	@Override
	protected void onRun() throws Exception {
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

		for (IEntity iEntity : sendMailQueueList) {
			MsgSendQueue msgSendQueue = new MsgSendQueue();
			iEntity.copyTo(msgSendQueue, false);
			msgSendQueue.set("PROCESSTIME", DateHelper.getTimestampValue(new Date()));
			try {
				HashSet<String> addressList = new HashSet<String>();
				String strDstAddresses = msgSendQueue.getDstAddresses();
				if (!StringHelper.isNullOrEmpty(strDstAddresses)) {
					String[] addrs = strDstAddresses.split("[;]");
					for (int i = 0; i < addrs.length; i++) {
						if (!StringHelper.isNullOrEmpty(addrs[i])) {
							addressList.add(addrs[i]);
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
								msgSendQueue.setErrorInfo(StringHelper.format("发送微信消息发生错误，获取消息账户[%1$s]失败", addrs[i]));
								msgSendQueue.setIsError(1);
								log.error(msgSendQueue.getErrorInfo());
								msgSendQueueService.update(msgSendQueue);
								throw new Exception(msgSendQueue.getErrorInfo());
							}

							// 判断是否为组用户
							if (DataObject.getBoolValue(msgAccount.getIsList(), false)) {
								// 將用戶組拆分出用戶進行發送
							} else {
								if (StringHelper.isNullOrEmpty(msgAccount.getWXAddr())) {
									msgSendQueue.setErrorInfo(StringHelper.format("发送微信消息发生错误，消息账户[%1$s]中不包含微信消息地址信息", addrs[i]));
									msgSendQueue.setIsError(1);
									log.error(msgSendQueue.getErrorInfo());
									msgSendQueueService.update(msgSendQueue);

									throw new Exception(msgSendQueue.getErrorInfo());
								}

								addressList.add(msgAccount.getWXAddr());
							}
						}
					}
				}
				String strTotalAddr = "";
				for (String strAddr : addressList) {
					if (!StringHelper.isNullOrEmpty(strTotalAddr)) strTotalAddr += "|";
					strTotalAddr += strAddr;
				}

				List<WXOutNewsMsg.Article> articles = new ArrayList<WXOutNewsMsg.Article>();
				WXOutNewsMsg.Article article = new WXOutNewsMsg.Article();
				article.setTitle("代办");
				article.setDescription(msgSendQueue.getContent());
				article.setUrl(strWXWFRedirectUrl + "?wfinstanceid=" + msgSendQueue.getUserData());
				articles.add(article);

				WXOutNewsMsg msg = new WXOutNewsMsg();
				msg.setAgentid(this.nWXEntAppAgentId);
				msg.setTouser(strTotalAddr);
				msg.setSafe(0);
				msg.setArticles(articles);

				CallResult callResult = this.iWXEntAppModel.sendMsg(msg);
				try {
					MsgSendQueueHis msgSendQueue2 = new MsgSendQueueHis();
					msgSendQueue.setIsSend(1);
					msgSendQueue.setIsError(callResult.getRetCode() == 0 ? 0 : 1);
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
					log.error("发送微信消息发生错误", exception);
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
