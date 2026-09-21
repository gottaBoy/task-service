/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.BackendServiceBase
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.psrt.srv.common.entity.MsgAccount
 *  net.ibizsys.psrt.srv.common.entity.MsgSendQueue
 *  net.ibizsys.psrt.srv.common.entity.MsgSendQueueHis
 *  net.ibizsys.psrt.srv.common.service.MsgAccountService
 *  net.ibizsys.psrt.srv.common.service.MsgSendQueueHisService
 *  net.ibizsys.psrt.srv.common.service.MsgSendQueueService
 *  net.ibizsys.pswx.bean.WXOutMsg
 *  net.ibizsys.pswx.bean.WXOutNewsMsg
 *  net.ibizsys.pswx.bean.WXOutNewsMsg$Article
 *  net.ibizsys.pswx.core.IWXAccountModel
 *  net.ibizsys.pswx.core.IWXEntAppModel
 *  net.ibizsys.pswx.core.WXGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswx.core;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
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
import net.ibizsys.pswx.bean.WXOutMsg;
import net.ibizsys.pswx.bean.WXOutNewsMsg;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.WXGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendWXMSGBackendService
extends BackendServiceBase {
    private static Log log = LogFactory.getLog(SendWXMSGBackendService.class);
    private Timer sendWXTimer = null;
    protected String strQuerySQL = "select * from T_SRFMSGSENDQUEUE where PROCESSTIME IS NULL  AND (PLANSENDTIME IS NULL OR PLANSENDTIME<? ) AND MSGTYPE = 32 ";
    protected String strQuerySQLLowCase = "select content,contenttype,createdate,createman,dstaddresses,dstusers,errorinfo,fileat,fileat2,fileat3,fileat4,importanceflag,iserror,issend,msgsendqueueid,msgsendqueuename,msgtype,plansendtime,processtime,sendtag,subject,totaldstaddresses,updatedate,updateman,userdata,userdata2,userdata3,userdata4 from t_srfmsgsendqueue where processtime is null  and (plansendtime is null or plansendtime<? ) and msgtype = 32 ";
    int nSendTimer = 30000;
    protected boolean bPlanSendTime = false;
    protected String strWXAccountId = "";
    protected int nWXEntAppAgentId = -1;
    protected String strWXWFRedirectUrl = "";
    private MsgSendQueueService msgSendQueueService = null;
    private MsgSendQueueHisService msgSendQueueHisService = null;
    private MsgAccountService msgAccountService = null;
    private IWXEntAppModel iWXEntAppModel = null;

    protected void onInit() throws Exception {
        super.onInit();
        this.bPlanSendTime = true;
        int nPageSize = Integer.parseInt(this.getServiceParam("PAGESIZE", "100"));
        this.strQuerySQL = WebConfig.getCurrent().isLowCaseSql() ? this.getServiceParam("QUERYSQL", this.strQuerySQLLowCase) : this.getServiceParam("QUERYSQL", this.strQuerySQL);
        this.nSendTimer = Integer.parseInt(this.getServiceParam("SENDTIMER", "30000"));
        this.msgSendQueueService = (MsgSendQueueService)ServiceGlobal.getService(MsgSendQueueService.class);
        this.msgSendQueueHisService = (MsgSendQueueHisService)ServiceGlobal.getService(MsgSendQueueHisService.class);
        this.msgAccountService = (MsgAccountService)ServiceGlobal.getService(MsgAccountService.class);
        this.strQuerySQL = this.msgSendQueueService.getDAO().getRealDBDialect().getPagingSQL(this.strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "", "");
        if (StringHelper.isNullOrEmpty((String)this.strQuerySQL)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u672a\u53d1\u9001\u5fae\u4fe1\u6d88\u606f\u67e5\u8be2SQL");
        }
        this.strWXAccountId = this.getServiceParam("WXENTACCOUNTID", "");
        this.nWXEntAppAgentId = Integer.parseInt(this.getServiceParam("WXENTAPPAGENTID", "-1"));
        this.strWXWFRedirectUrl = this.getServiceParam("WXWFREDIRECTURL", "");
        if (StringHelper.isNullOrEmpty((String)this.strWXWFRedirectUrl)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u516c\u4f17\u53f7\u5de5\u4f5c\u6d41\u4ee3\u529e\u91cd\u5b9a\u5411\u5730\u5740[WXWFREDIRECTURL]");
        }
        if (StringHelper.isNullOrEmpty((String)this.strWXAccountId) || this.nWXEntAppAgentId < 1) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u516c\u4f17\u53f7\u6807\u8bc6[WXENTACCOUNTID][WXENTAPPAGENTID]");
        }
        IWXAccountModel iWXAccountModel = WXGlobal.getWXAccountModel((String)this.strWXAccountId);
        if (iWXAccountModel == null) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u4f01\u4e1a\u53f7[" + this.strWXAccountId + "]\u5bf9\u8c61");
        }
        this.iWXEntAppModel = iWXAccountModel.getWXEntAppModel(this.nWXEntAppAgentId);
        if (this.iWXEntAppModel == null) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u4f01\u4e1a\u53f7\u5e94\u7528[" + this.nWXEntAppAgentId + "]\u5bf9\u8c61");
        }
    }

    protected void onStart() throws Exception {
        super.onStart();
        if (this.sendWXTimer == null) {
            this.sendWXTimer = new Timer("WXSENDQUEUE");
            this.sendWXTimer.schedule(new TimerTask(){

                @Override
                public void run() {
                    SendWXMSGBackendService.this.runTask();
                }
            }, this.nSendTimer, (long)this.nSendTimer);
        }
        log.info((Object)StringHelper.format((String)"\u5fae\u4fe1\u53d1\u9001\u670d\u52a1\u542f\u52a8"));
    }

    protected void onStop() throws Exception {
        log.info((Object)StringHelper.format((String)"\u5fae\u4fe1\u53d1\u9001\u670d\u52a1\u505c\u6b62"));
        if (this.sendWXTimer != null) {
            this.sendWXTimer.cancel();
            this.sendWXTimer = null;
        }
        super.onStop();
    }

    protected void onRun() throws Exception {
        ArrayList sendMailQueueList;
        SqlParamList sqlParamList = new SqlParamList();
        if (this.bPlanSendTime) {
            Date date = new Date();
            Timestamp sendTime = new Timestamp(date.getTime() + 30000L);
            sqlParamList.addDateTime((Object)sendTime);
        }
        if ((sendMailQueueList = this.msgSendQueueService.selectRaw(this.strQuerySQL, sqlParamList)).size() == 0) {
            return;
        }
        for (IEntity iEntity : sendMailQueueList) {
            MsgSendQueue msgSendQueue = new MsgSendQueue();
            iEntity.copyTo((IDataObject)msgSendQueue, false);
            msgSendQueue.set("PROCESSTIME", (Object)DateHelper.getTimestampValue((Object)new Date()));
            try {
                String strDstUsers;
                HashSet<String> addressList = new HashSet<String>();
                String strDstAddresses = msgSendQueue.getDstAddresses();
                if (!StringHelper.isNullOrEmpty((String)strDstAddresses)) {
                    String[] addrs = strDstAddresses.split("[;]");
                    int i = 0;
                    while (i < addrs.length) {
                        if (!StringHelper.isNullOrEmpty((String)addrs[i])) {
                            addressList.add(addrs[i]);
                        }
                        ++i;
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)(strDstUsers = msgSendQueue.getDstUsers()))) {
                    MsgAccount msgAccount = new MsgAccount();
                    String[] addrs = strDstUsers.split("[;]");
                    int i = 0;
                    while (i < addrs.length) {
                        if (!StringHelper.isNullOrEmpty((String)addrs[i])) {
                            msgAccount.setMsgAccountId(addrs[i]);
                            if (!this.msgAccountService.get((IEntity)msgAccount, true)) {
                                msgSendQueue.setErrorInfo(StringHelper.format((String)"\u53d1\u9001\u5fae\u4fe1\u6d88\u606f\u53d1\u751f\u9519\u8bef\uff0c\u83b7\u53d6\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25", (Object)addrs[i]));
                                msgSendQueue.setIsError(Integer.valueOf(1));
                                log.error((Object)msgSendQueue.getErrorInfo());
                                this.msgSendQueueService.update((IEntity)msgSendQueue);
                                throw new Exception(msgSendQueue.getErrorInfo());
                            }
                            if (!DataObject.getBoolValue((Integer)msgAccount.getIsList(), (boolean)false)) {
                                if (StringHelper.isNullOrEmpty((String)msgAccount.getWXAddr())) {
                                    msgSendQueue.setErrorInfo(StringHelper.format((String)"\u53d1\u9001\u5fae\u4fe1\u6d88\u606f\u53d1\u751f\u9519\u8bef\uff0c\u6d88\u606f\u8d26\u6237[%1$s]\u4e2d\u4e0d\u5305\u542b\u5fae\u4fe1\u6d88\u606f\u5730\u5740\u4fe1\u606f", (Object)addrs[i]));
                                    msgSendQueue.setIsError(Integer.valueOf(1));
                                    log.error((Object)msgSendQueue.getErrorInfo());
                                    this.msgSendQueueService.update((IEntity)msgSendQueue);
                                    throw new Exception(msgSendQueue.getErrorInfo());
                                }
                                addressList.add(msgAccount.getWXAddr());
                            }
                        }
                        ++i;
                    }
                }
                String strTotalAddr = "";
                for (String strAddr : addressList) {
                    if (!StringHelper.isNullOrEmpty((String)strTotalAddr)) {
                        strTotalAddr = String.valueOf(strTotalAddr) + "|";
                    }
                    strTotalAddr = String.valueOf(strTotalAddr) + strAddr;
                }
                ArrayList<WXOutNewsMsg.Article> articles = new ArrayList<WXOutNewsMsg.Article>();
                WXOutNewsMsg.Article article = new WXOutNewsMsg.Article();
                article.setTitle("\u4ee3\u529e");
                article.setDescription(msgSendQueue.getContent());
                article.setUrl(String.valueOf(this.strWXWFRedirectUrl) + "?wfinstanceid=" + msgSendQueue.getUserData());
                articles.add(article);
                WXOutNewsMsg msg = new WXOutNewsMsg();
                msg.setAgentid(this.nWXEntAppAgentId);
                msg.setTouser(strTotalAddr);
                msg.setSafe(0);
                msg.setArticles(articles);
                CallResult callResult = this.iWXEntAppModel.sendMsg((WXOutMsg)msg);
                try {
                    MsgSendQueueHis msgSendQueue2 = new MsgSendQueueHis();
                    msgSendQueue.setIsSend(Integer.valueOf(1));
                    msgSendQueue.setIsError(Integer.valueOf(callResult.getRetCode() == 0 ? 0 : 1));
                    msgSendQueue.setTotalDstAddresses(strTotalAddr);
                    msgSendQueue.copyTo((IDataObject)msgSendQueue2, true);
                    msgSendQueue2.set("MSGSENDQUEUEHISID", (Object)msgSendQueue.getMsgSendQueueId());
                    msgSendQueue2.set("MSGSENDQUEUEHISNAME", (Object)msgSendQueue.getMsgSendQueueName());
                    try {
                        this.msgSendQueueHisService.create((IEntity)msgSendQueue2);
                    }
                    catch (Exception ex) {
                        this.msgSendQueueService.remove((IEntity)msgSendQueue);
                        throw new Exception(StringHelper.format((String)"\u5c06\u53d1\u9001\u6570\u636e\u653e\u5165\u53d1\u9001\u5386\u53f2\u8bb0\u5f55\u961f\u5217\u4e2d\u5931\u8d25\uff0c%1$s", (Object)ex.getMessage()));
                    }
                    this.msgSendQueueService.remove((IEntity)msgSendQueue);
                }
                catch (Exception exception) {
                    log.error((Object)"\u53d1\u9001\u5fae\u4fe1\u6d88\u606f\u53d1\u751f\u9519\u8bef", (Throwable)exception);
                    exception.printStackTrace();
                    msgSendQueue.setErrorInfo(exception.getMessage());
                    msgSendQueue.setIsError(Integer.valueOf(1));
                    this.msgSendQueueService.update((IEntity)msgSendQueue);
                    break;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

