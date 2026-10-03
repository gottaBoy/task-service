/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.BaseService
 *  SA.SRFDA.Ctrl.Data.MsgAccount
 *  SA.SRFDA.Ctrl.Data.MsgSendQueue
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.sf.jml.Email
 *  net.sf.jml.MsnContact
 *  net.sf.jml.MsnMessenger
 *  net.sf.jml.MsnSwitchboard
 *  net.sf.jml.MsnUserStatus
 *  net.sf.jml.event.MsnAdapter
 *  net.sf.jml.impl.MsnMessengerFactory
 *  net.sf.jml.message.MsnControlMessage
 *  net.sf.jml.message.MsnInstantMessage
 *  net.sf.jml.message.MsnMimeMessage
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.MSG.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.BaseService;
import SA.SRFDA.Ctrl.Data.MsgAccount;
import SA.SRFDA.Ctrl.Data.MsgSendQueue;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import net.sf.jml.Email;
import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnSwitchboard;
import net.sf.jml.MsnUserStatus;
import net.sf.jml.event.MsnAdapter;
import net.sf.jml.impl.MsnMessengerFactory;
import net.sf.jml.message.MsnControlMessage;
import net.sf.jml.message.MsnInstantMessage;
import net.sf.jml.message.MsnMimeMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendWeChatMsgService
extends BaseService {
    private static Log log = LogFactory.getLog(SendWeChatMsgService.class);
    private Timer sendMsgTimer = null;
    protected String strQuerySQL = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL AND MSGTYPE = 32  ";
    protected String strQuerySQL2 = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL  AND (PLANSENDTIME IS NULL OR PLANSENDTIME<? ) AND MSGTYPE = 32  ";
    protected String strMSNUser = "";
    protected String strMSNPassword = "";
    int nSendTimer = 30000;
    MsnMessenger messenger = null;
    private MsnAdapterEx msnAdapter = new MsnAdapterEx();
    protected boolean bPlanSendTime = false;
    protected boolean bDebug = false;
    protected boolean bSending = false;
    private Vector<MsgStruct> msgList = new Vector();
    private Vector<MsgStruct> msgList2 = new Vector();

    protected CallResult OnInit() {
        String strQMHelperObject;
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 10111600) {
            this.strQuerySQL = this.strQuerySQL2;
            this.bPlanSendTime = true;
        }
        if (StringHelper.IsNullOrEmpty((String)(strQMHelperObject = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "")))) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u67e5\u8be2\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61"));
            return callResult;
        }
        BaseDAQueryModelHelper daQueryModelHelper = (BaseDAQueryModelHelper)ObjectHelper.Create((String)strQMHelperObject);
        if (daQueryModelHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strQMHelperObject));
            return callResult;
        }
        int nPageSize = Integer.parseInt(this.GetServiceParam("PAGESIZE", "100"));
        this.strQuerySQL = this.GetServiceParam("QUERYSQL", this.strQuerySQL);
        this.strMSNUser = this.GetServiceParam("MSNUSER", "");
        this.strMSNPassword = this.GetServiceParam("MSNPASSWORD", "");
        if (StringHelper.IsNullOrEmpty((String)this.strQuerySQL)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u672a\u53d1\u9001MSN\u6d88\u606f\u67e5\u8be2SQL");
        }
        this.bDebug = Boolean.parseBoolean(this.GetServiceParam("DEBUG", "FALSE"));
        this.messenger = MsnMessengerFactory.createMsnMessenger((String)this.strMSNUser, (String)this.strMSNPassword);
        this.messenger.getOwner().setInitStatus(MsnUserStatus.BUSY);
        if (this.bDebug) {
            this.messenger.setLogIncoming(true);
            this.messenger.setLogOutgoing(true);
        }
        this.messenger.addListener((MsnAdapter)this.msnAdapter);
        this.strQuerySQL = daQueryModelHelper.GetPagingSQL(this.strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "", "");
        return callResult;
    }

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.sendMsgTimer == null) {
            this.sendMsgTimer = new Timer("MSNMSGSENDQUEUE");
            this.sendMsgTimer.schedule((TimerTask)((Object)this), this.nSendTimer, (long)this.nSendTimer);
        }
        log.info((Object)StringHelper.Format((String)"Send MSN Msg Start"));
        this.messenger.login();
        return callResult;
    }

    protected CallResult OnStop() {
        log.info((Object)StringHelper.Format((String)"Send MSN Msg Stop"));
        if (this.sendMsgTimer != null) {
            this.sendMsgTimer.cancel();
            this.sendMsgTimer = null;
        }
        if (this.msnAdapter.isLogin()) {
            this.DoSendMsg();
        }
        this.messenger.logout();
        return super.OnStop();
    }

    protected void InternalRun() {
        if (!this.msnAdapter.isLogin()) {
            this.messenger.login();
            return;
        }
        this.DoSendMsg();
        CallParamList callParamList = new CallParamList();
        if (this.bPlanSendTime) {
            Date date = new Date();
            Timestamp sendTime = new Timestamp(date.getTime() + 30000L);
            callParamList.AddDateTime((Object)sendTime);
        }
        Vector<MsgSendQueue> sendMSNQueueList = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strQuerySQL, (Vector)callParamList.GetList(), sendMSNQueueList, (String)MsgSendQueue.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u672a\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        if (sendMSNQueueList.size() == 0) {
            return;
        }
        IDEDataCtrl iMsgSendQueueDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0077", "SYSTEM", null);
        if (iMsgSendQueueDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0077"));
            return;
        }
        IDEDataCtrl iMsgSendQueueHisDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0085", "SYSTEM", null);
        if (iMsgSendQueueDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0085"));
            return;
        }
        for (MsgSendQueue msgSendQueue : sendMSNQueueList) {
            msgSendQueue.SetParamValue("PROCESSTIME", (Object)DateParser.GetTimestampValue((Object)new Date()));
            try {
                String strDstUsers;
                String strDstAddresses = msgSendQueue.getDSTADDRESSES();
                if (!StringHelper.IsNullOrEmpty((String)strDstAddresses)) {
                    String[] addrs = strDstAddresses.split("[;]");
                    int i = 0;
                    while (i < addrs.length) {
                        if (!StringHelper.IsNullOrEmpty((String)addrs[i])) {
                            this.msgList.add(new MsgStruct(addrs[i], msgSendQueue.getCONTENT()));
                        }
                        ++i;
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)(strDstUsers = msgSendQueue.getDSTUSERS()))) {
                    IDEDataCtrl msgAccountDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0070", "SYSTEM", null);
                    if (msgAccountDataCtrl == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0070"));
                        return;
                    }
                    MsgAccount msgAccount = new MsgAccount();
                    String[] addrs = strDstUsers.split("[;]");
                    int i = 0;
                    while (i < addrs.length) {
                        if (!StringHelper.IsNullOrEmpty((String)addrs[i])) {
                            msgAccount.setMSGACCOUNTID(addrs[i]);
                            callResult = msgAccountDataCtrl.Get((BaseDataEntity)msgAccount);
                            if (callResult.IsError()) {
                                msgSendQueue.setERRORINFO(StringHelper.Format((String)"\u53d1\u9001MSN\u6d88\u606f\u53d1\u751f\u9519\u8bef\uff0c\u83b7\u53d6MSN\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25\uff0c%2$s", (Object)addrs[i], (Object)callResult.getErrorInfo()));
                                msgSendQueue.setISERROR(true);
                                log.error((Object)msgSendQueue.getERRORINFO());
                                iMsgSendQueueDataCtrl.Save(false, (BaseDataEntity)msgSendQueue);
                                throw new Exception(msgSendQueue.getERRORINFO());
                            }
                            if (StringHelper.IsNullOrEmpty((String)msgAccount.getMSNEMAIL())) {
                                msgSendQueue.setERRORINFO(StringHelper.Format((String)"\u53d1\u9001MSN\u6d88\u606f\u53d1\u751f\u9519\u8bef\uff0cMSN\u6d88\u606f\u8d26\u6237[%1$s]\u4e2d\u4e0d\u5305\u542bMSN\u6d88\u606f\u5730\u5740\u4fe1\u606f", (Object)addrs[i]));
                                msgSendQueue.setISERROR(true);
                                log.error((Object)msgSendQueue.getERRORINFO());
                                iMsgSendQueueDataCtrl.Save(false, (BaseDataEntity)msgSendQueue);
                                throw new Exception(msgSendQueue.getERRORINFO());
                            }
                            this.msgList.add(new MsgStruct(msgAccount.getMSNEMAIL(), msgSendQueue.getCONTENT()));
                        }
                        ++i;
                    }
                }
                msgSendQueue.setISSEND(true);
                iMsgSendQueueDataCtrl.Save(false, (BaseDataEntity)msgSendQueue);
                MsgSendQueue msgSendQueue2 = new MsgSendQueue();
                msgSendQueue.setISSEND(true);
                msgSendQueue.CopyTo((BaseDataEntity)msgSendQueue2, true);
                msgSendQueue2.SetParamValue("MSGSENDQUEUEHISID", (Object)msgSendQueue.getMSGSENDQUEUEID());
                msgSendQueue2.SetParamValue("MSGSENDQUEUEHISNAME", (Object)msgSendQueue.getMSGSENDQUEUENAME());
                callResult = iMsgSendQueueHisDataCtrl.Save(true, (BaseDataEntity)msgSendQueue2);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u5c06\u53d1\u9001\u6570\u636e\u653e\u5165\u53d1\u9001\u5386\u53f2\u8bb0\u5f55\u961f\u5217\u4e2d\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                iMsgSendQueueDataCtrl.Remove((BaseDataEntity)msgSendQueue);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.DoSendMsg();
    }

    private void DoSendMsg() {
        this.msgList2.clear();
        for (MsgStruct msgStruct : this.msgList) {
            Email email = Email.parseStr((String)msgStruct.getEmail());
            MsnContact msnContact = this.messenger.getContactList().getContactByEmail(email);
            if (msnContact == null) {
                this.messenger.addFriend(email, msgStruct.getEmail());
                this.msgList2.add(msgStruct);
                continue;
            }
            MsnSwitchboardObject msb = new MsnSwitchboardObject(msnContact.getEmail(), msgStruct.getContent());
            this.messenger.newSwitchboard((Object)msb);
        }
        this.msgList.clear();
        this.msgList.addAll(this.msgList2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        SendWeChatMsgService sendWeChatMsgService = this;
        synchronized (sendWeChatMsgService) {
            if (this.bSending) {
                return;
            }
            this.bSending = true;
        }
        this.InternalRun();
        sendWeChatMsgService = this;
        synchronized (sendWeChatMsgService) {
            this.bSending = false;
        }
    }

    private class MsgStruct {
        protected String strEmail = "";
        protected String strContent = "";

        public MsgStruct(String strEmail, String strContent) {
            this.strEmail = strEmail;
            this.strContent = strContent;
        }

        public String getEmail() {
            return this.strEmail;
        }

        public String getContent() {
            return this.strContent;
        }

        public void setEmail(String strEmail) {
            this.strEmail = strEmail;
        }

        public void setContent(String strContent) {
            this.strContent = strContent;
        }
    }

    private class MsnAdapterEx
    extends MsnAdapter {
        protected boolean bLogin = false;

        private MsnAdapterEx() {
        }

        public void loginCompleted(MsnMessenger arg0) {
            super.loginCompleted(arg0);
            this.bLogin = true;
        }

        public void logout(MsnMessenger arg0) {
            super.logout(arg0);
            this.bLogin = false;
        }

        public boolean isLogin() {
            return this.bLogin;
        }

        public void switchboardStarted(MsnSwitchboard arg0) {
            if (!(arg0.getAttachment() instanceof MsnSwitchboardObject)) {
                arg0.close();
                return;
            }
            MsnSwitchboardObject msb = (MsnSwitchboardObject)arg0.getAttachment();
            arg0.inviteContact(msb.getEmail());
        }

        public void switchboardClosed(MsnSwitchboard arg0) {
            super.switchboardClosed(arg0);
        }

        public void contactJoinSwitchboard(MsnSwitchboard switchboard, MsnContact contact) {
            if (!(switchboard.getAttachment() instanceof MsnSwitchboardObject)) {
                switchboard.close();
                return;
            }
            MsnSwitchboardObject msb = (MsnSwitchboardObject)switchboard.getAttachment();
            if (!contact.getEmail().equals((Object)msb.getEmail())) {
                switchboard.close();
                return;
            }
            MsnControlMessage typingMessage = new MsnControlMessage();
            typingMessage.setTypingUser(switchboard.getMessenger().getOwner().getDisplayName());
            switchboard.sendMessage((MsnMimeMessage)typingMessage);
            MsnInstantMessage message = new MsnInstantMessage();
            message.setBold(false);
            message.setItalic(false);
            message.setContent(msb.getMessage());
            switchboard.sendMessage((MsnMimeMessage)message);
            switchboard.close();
        }
    }

    private class MsnSwitchboardObject {
        protected Email email;
        protected String strMessage;

        public MsnSwitchboardObject(Email email, String strMessage) {
            this.email = email;
            this.strMessage = strMessage;
        }

        public Email getEmail() {
            return this.email;
        }

        public String getMessage() {
            return this.strMessage;
        }
    }
}

