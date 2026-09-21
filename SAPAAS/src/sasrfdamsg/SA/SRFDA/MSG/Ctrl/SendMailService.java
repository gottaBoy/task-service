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
 *  javax.activation.DataHandler
 *  javax.activation.DataSource
 *  javax.activation.FileDataSource
 *  javax.mail.Address
 *  javax.mail.Authenticator
 *  javax.mail.BodyPart
 *  javax.mail.Message
 *  javax.mail.Message$RecipientType
 *  javax.mail.Multipart
 *  javax.mail.PasswordAuthentication
 *  javax.mail.Session
 *  javax.mail.Transport
 *  javax.mail.internet.InternetAddress
 *  javax.mail.internet.MimeBodyPart
 *  javax.mail.internet.MimeMessage
 *  javax.mail.internet.MimeMultipart
 *  javax.mail.internet.MimeUtility
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
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

public class SendMailService
extends BaseService {
    private static Log log = LogFactory.getLog(SendMailService.class);
    private Timer sendmailTimer = null;
    protected String strQuerySQL = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL AND MSGTYPE = 2 ";
    protected String strQuerySQL2 = "select * from T_SRFMSGSendQUEUE where PROCESSTIME IS NULL  AND (PLANSENDTIME IS NULL OR PLANSENDTIME<? ) AND MSGTYPE = 2 ";
    protected String strSMTPServer = "";
    protected int nSMTPPort = 25;
    protected String strSMTPPort = "25";
    protected String strSMTPUser = "";
    protected String strSMTPPassword = "";
    protected String strMailFrom = "";
    protected boolean bSSL = false;
    boolean bSMTPAuth = true;
    int nSendTimer = 30000;
    protected boolean bSending = false;
    protected boolean bDebug = false;
    protected boolean bPlanSendTime = false;

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
        this.strSMTPServer = this.GetServiceParam("SMTPSERVER", "");
        this.nSMTPPort = Integer.parseInt(this.GetServiceParam("SMTPPORT", "25"));
        this.strSMTPPort = this.GetServiceParam("SMTPPORT", "25");
        this.strSMTPUser = this.GetServiceParam("SMTPUSER", "");
        this.strSMTPPassword = this.GetServiceParam("SMTPPASSWORD", "");
        this.strMailFrom = this.GetServiceParam("MAILFROM", this.strSMTPUser);
        this.bSMTPAuth = Boolean.parseBoolean(this.GetServiceParam("SMTPAUTH", "TRUE"));
        this.nSendTimer = Integer.parseInt(this.GetServiceParam("SENDTIMER", "30000"));
        this.bDebug = Boolean.parseBoolean(this.GetServiceParam("DEBUG", "FALSE"));
        this.bSSL = Boolean.parseBoolean(this.GetServiceParam("SSL", "FALSE"));
        this.strQuerySQL = daQueryModelHelper.GetPagingSQL(this.strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "", "");
        if (StringHelper.IsNullOrEmpty((String)this.strQuerySQL)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u672a\u53d1\u9001\u90ae\u4ef6\u67e5\u8be2SQL");
        }
        if (StringHelper.IsNullOrEmpty((String)this.strSMTPServer)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u90ae\u4ef6\u53d1\u9001\u670d\u52a1\u5668");
        }
        return callResult;
    }

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.sendmailTimer == null) {
            this.sendmailTimer = new Timer("MSGSENDQUEUE");
            this.sendmailTimer.schedule((TimerTask)((Object)this), this.nSendTimer, (long)this.nSendTimer);
        }
        log.info((Object)StringHelper.Format((String)"Send Mail Start"));
        return callResult;
    }

    protected CallResult OnStop() {
        log.info((Object)StringHelper.Format((String)"Send Mail Stop"));
        if (this.sendmailTimer != null) {
            this.sendmailTimer.cancel();
            this.sendmailTimer = null;
        }
        return super.OnStop();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        SendMailService sendMailService = this;
        synchronized (sendMailService) {
            if (this.bSending) {
                return;
            }
            this.bSending = true;
        }
        this.InternalSend();
        sendMailService = this;
        synchronized (sendMailService) {
            this.bSending = false;
        }
    }

    protected void InternalSend() {
        CallResult callResult;
        Vector sendMailQueueList = new Vector();
        CallParamList callParamList = new CallParamList();
        if (this.bPlanSendTime) {
            Date date = new Date();
            Timestamp sendTime = new Timestamp(date.getTime() + 30000L);
            callParamList.AddDateTime((Object)sendTime);
        }
        if ((callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strQuerySQL, (Vector)callParamList.GetList(), sendMailQueueList, (String)MsgSendQueue.class.getName())).IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u672a\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        if (sendMailQueueList.size() == 0) {
            return;
        }
        IDEDataCtrl iMsgSendQueueDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0077", "SYSTEM", null);
        if (iMsgSendQueueDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0077"));
            return;
        }
        IDEDataCtrl iMsgSendQueueHisDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0085", "SYSTEM", null);
        if (iMsgSendQueueHisDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0085"));
            return;
        }
        IDEDataCtrl msgAccountDataCtrl = null;
        Session session = null;
        try {
            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", this.bSSL ? "smtps" : "smtp");
            props.setProperty("mail.smtp.host", this.strSMTPServer);
            props.setProperty("mail.smtp.port", this.strSMTPPort);
            props.setProperty("mail.smtp.user", this.strSMTPUser);
            props.setProperty("mail.smtp.from", this.strMailFrom);
            props.setProperty("mail.smtp.password", this.strSMTPPassword);
            props.setProperty("mail.smtp.auth", this.bSMTPAuth ? "true" : "false");
            props.setProperty("mail.smtp.timeout", StringHelper.Format((String)"%1$s", (Object)600000));
            props.setProperty("mail.smtp.starttls.enable", "true");
            if (this.bSSL) {
                props.setProperty("mail.smtp.ssl.enable", "true");
                props.setProperty("mail.smtp.socketFactory.host", this.strSMTPServer);
                props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.setProperty("mail.smtp.socketFactory.fallback", "false");
            }
            session = Session.getDefaultInstance((Properties)props, (Authenticator)new Authenticator(){

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SendMailService.this.strSMTPUser, SendMailService.this.strSMTPPassword);
                }
            });
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u767b\u5f55\u90ae\u4ef6\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return;
        }
        for (MsgSendQueue msgSendQueue : sendMailQueueList) {
            msgSendQueue.SetParamValue("PROCESSTIME", (Object)DateParser.GetTimestampValue((Object)new Date()));
            try {
                String strDstUsers;
                MimeMessage mimemessage = new MimeMessage(session);
                mimemessage.setFrom((Address)new InternetAddress(this.strMailFrom));
                mimemessage.setSentDate(new Date());
                mimemessage.setSubject(msgSendQueue.getSUBJECT(), "GBK");
                Vector<InternetAddress> addressList = new Vector<InternetAddress>();
                String strDstAddresses = msgSendQueue.getDSTADDRESSES();
                if (!StringHelper.IsNullOrEmpty((String)strDstAddresses)) {
                    String[] addrs = strDstAddresses.split("[;]");
                    int i = 0;
                    while (i < addrs.length) {
                        if (!StringHelper.IsNullOrEmpty((String)addrs[i])) {
                            addressList.add(new InternetAddress(addrs[i]));
                        }
                        ++i;
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)(strDstUsers = msgSendQueue.getDSTUSERS()))) {
                    if (msgAccountDataCtrl == null && (msgAccountDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0070", "SYSTEM", null)) == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0070"));
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0070"));
                    }
                    MsgAccount msgAccount = new MsgAccount();
                    String[] addrs = strDstUsers.split("[;]");
                    int i = 0;
                    while (i < addrs.length) {
                        if (!StringHelper.IsNullOrEmpty((String)addrs[i])) {
                            msgAccount.setMSGACCOUNTID(addrs[i]);
                            callResult = msgAccountDataCtrl.Get((BaseDataEntity)msgAccount);
                            if (callResult.IsError()) {
                                msgSendQueue.setERRORINFO(StringHelper.Format((String)"\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef\uff0c\u83b7\u53d6\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25\uff0c%2$s", (Object)addrs[i], (Object)callResult.getErrorInfo()));
                                msgSendQueue.setISERROR(true);
                                log.error((Object)msgSendQueue.getERRORINFO());
                                iMsgSendQueueDataCtrl.Save(false, (BaseDataEntity)msgSendQueue);
                                throw new Exception(msgSendQueue.getERRORINFO());
                            }
                            if (msgAccount.getISLIST()) {
                                Vector msgAccountList = new Vector();
                                callResult = msgAccountDataCtrl.Select("LISTGROUPDETAIL", (BaseDataEntity)msgAccount, msgAccountList, MsgAccount.class.getName());
                                if (callResult.IsError()) {
                                    msgSendQueue.setERRORINFO(StringHelper.Format((String)"\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef\uff0c\u83b7\u53d6\u6d88\u606f\u8d26\u6237\u7ec4[%1$s]\u660e\u7ec6\u7528\u6237\u5931\u8d25\uff0c%2$s", (Object)addrs[i], (Object)callResult.getErrorInfo()));
                                    msgSendQueue.setISERROR(true);
                                    log.error((Object)msgSendQueue.getERRORINFO());
                                    iMsgSendQueueDataCtrl.Save(false, (BaseDataEntity)msgSendQueue);
                                    throw new Exception(msgSendQueue.getERRORINFO());
                                }
                                for (MsgAccount temp : msgAccountList) {
                                    if (StringHelper.IsNullOrEmpty((String)temp.getMAILADDRESS())) {
                                        msgSendQueue.setERRORINFO(StringHelper.Format((String)"\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef\uff0c\u6d88\u606f\u8d26\u6237[%1$s]\u4e2d\u4e0d\u5305\u542b\u90ae\u4ef6\u5730\u5740\u4fe1\u606f", (Object)temp.getMSGACCOUNTID()));
                                        msgSendQueue.setISERROR(true);
                                        log.error((Object)msgSendQueue.getERRORINFO());
                                        iMsgSendQueueDataCtrl.Save(false, (BaseDataEntity)msgSendQueue);
                                        throw new Exception(msgSendQueue.getERRORINFO());
                                    }
                                    addressList.add(new InternetAddress(temp.getMAILADDRESS()));
                                }
                            } else {
                                if (StringHelper.IsNullOrEmpty((String)msgAccount.getMAILADDRESS())) {
                                    msgSendQueue.setERRORINFO(StringHelper.Format((String)"\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef\uff0c\u6d88\u606f\u8d26\u6237[%1$s]\u4e2d\u4e0d\u5305\u542b\u90ae\u4ef6\u5730\u5740\u4fe1\u606f", (Object)addrs[i]));
                                    msgSendQueue.setISERROR(true);
                                    log.error((Object)msgSendQueue.getERRORINFO());
                                    iMsgSendQueueDataCtrl.Save(false, (BaseDataEntity)msgSendQueue);
                                    throw new Exception(msgSendQueue.getERRORINFO());
                                }
                                addressList.add(new InternetAddress(msgAccount.getMAILADDRESS()));
                            }
                        }
                        ++i;
                    }
                }
                String strTotalAddr = "";
                try {
                    InternetAddress[] iaddrs = new InternetAddress[addressList.size()];
                    addressList.toArray(iaddrs);
                    mimemessage.setRecipients(Message.RecipientType.TO, (Address[])iaddrs);
                    for (InternetAddress iAddr : addressList) {
                        if (!StringHelper.IsNullOrEmpty((String)strTotalAddr)) {
                            strTotalAddr = String.valueOf(strTotalAddr) + ";";
                        }
                        strTotalAddr = String.valueOf(strTotalAddr) + iAddr.getAddress();
                    }
                }
                catch (Exception exception1) {
                    log.error((Object)"\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef", (Throwable)exception1);
                    msgSendQueue.setERRORINFO(exception1.getMessage());
                    msgSendQueue.setISERROR(true);
                    iMsgSendQueueDataCtrl.Save(false, (BaseDataEntity)msgSendQueue);
                    throw exception1;
                }
                String strEncode = "text/html;charset=GBK";
                if (StringHelper.Compare((String)msgSendQueue.getCONTENTTYPE(), (String)"HTML", (boolean)true) != 0) {
                    strEncode = "text/plain;charset=GBK";
                }
                MimeBodyPart mimebodypart = new MimeBodyPart();
                mimebodypart.setContent((Object)msgSendQueue.getCONTENT(), strEncode);
                MimeMultipart mimemultipart = new MimeMultipart();
                mimemultipart.addBodyPart((BodyPart)mimebodypart);
                ArrayList<String> attachedFileList = new ArrayList<String>();
                if (!StringHelper.IsNullOrEmpty((String)msgSendQueue.getFILEAT())) {
                    attachedFileList.add(msgSendQueue.getFILEAT());
                }
                if (!StringHelper.IsNullOrEmpty((String)msgSendQueue.getFILEAT2())) {
                    attachedFileList.add(msgSendQueue.getFILEAT2());
                }
                if (!StringHelper.IsNullOrEmpty((String)msgSendQueue.getFILEAT3())) {
                    attachedFileList.add(msgSendQueue.getFILEAT3());
                }
                if (!StringHelper.IsNullOrEmpty((String)msgSendQueue.getFILEAT4())) {
                    attachedFileList.add(msgSendQueue.getFILEAT4());
                }
                if (attachedFileList.size() > 0) {
                    Iterator e = attachedFileList.iterator();
                    while (e.hasNext()) {
                        FileDataSource ds = new FileDataSource((String)e.next());
                        mimebodypart = new MimeBodyPart();
                        mimebodypart.setDataHandler(new DataHandler((DataSource)ds));
                        mimebodypart.setFileName(MimeUtility.encodeText((String)ds.getName()));
                        mimemultipart.addBodyPart((BodyPart)mimebodypart);
                    }
                }
                mimemessage.setContent((Multipart)mimemultipart);
                mimemessage.saveChanges();
                try {
                    Transport.send((Message)mimemessage);
                    MsgSendQueue msgSendQueue2 = new MsgSendQueue();
                    msgSendQueue.setISSEND(true);
                    msgSendQueue.setTOTALDSTADDRESSES(strTotalAddr);
                    msgSendQueue.CopyTo((BaseDataEntity)msgSendQueue2, true);
                    msgSendQueue2.SetParamValue("MSGSENDQUEUEHISID", (Object)msgSendQueue.getMSGSENDQUEUEID());
                    msgSendQueue2.SetParamValue("MSGSENDQUEUEHISNAME", (Object)msgSendQueue.getMSGSENDQUEUENAME());
                    callResult = iMsgSendQueueHisDataCtrl.Save(true, (BaseDataEntity)msgSendQueue2);
                    if (callResult.IsError()) {
                        throw new Exception(StringHelper.Format((String)"\u5c06\u53d1\u9001\u6570\u636e\u653e\u5165\u53d1\u9001\u5386\u53f2\u8bb0\u5f55\u961f\u5217\u4e2d\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    iMsgSendQueueDataCtrl.Remove((BaseDataEntity)msgSendQueue);
                }
                catch (Exception exception) {
                    log.error((Object)"\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef", (Throwable)exception);
                    exception.printStackTrace();
                    msgSendQueue.setERRORINFO(exception.getMessage());
                    msgSendQueue.setISERROR(true);
                    iMsgSendQueueDataCtrl.Save(false, (BaseDataEntity)msgSendQueue);
                    break;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class SmtpAuthenticator
    extends Authenticator {
        private PasswordAuthentication password_auth;

        public SmtpAuthenticator(String smtp_user, String smtp_password) {
            this.password_auth = new PasswordAuthentication(smtp_user, smtp_password);
        }

        public PasswordAuthentication getPasswordAuthentication() {
            return this.password_auth;
        }
    }
}

