/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package net.ibizsys.psmsg.core;

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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendMailBackendService
extends BackendServiceBase {
    private static Log log = LogFactory.getLog(SendMailBackendService.class);
    private Timer sendmailTimer = null;
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
    protected boolean bDebug = false;
    protected boolean bPlanSendTime = false;
    private MsgSendQueueService msgSendQueueService = null;
    private MsgSendQueueHisService msgSendQueueHisService = null;
    private MsgAccountService msgAccountService = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.bPlanSendTime = true;
        int nPageSize = Integer.parseInt(this.getServiceParam("PAGESIZE", "100"));
        this.strQuerySQL = WebConfig.getCurrent().isLowCaseSql() ? this.getServiceParam("QUERYSQL", this.strQuerySQLLowCase) : this.getServiceParam("QUERYSQL", this.strQuerySQL);
        this.strSMTPServer = this.getServiceParam("SMTPSERVER", "");
        this.nSMTPPort = Integer.parseInt(this.getServiceParam("SMTPPORT", "25"));
        this.strSMTPPort = this.getServiceParam("SMTPPORT", "25");
        this.strSMTPUser = this.getServiceParam("SMTPUSER", "");
        this.strSMTPPassword = this.getServiceParam("SMTPPASSWORD", "");
        this.strMailFrom = this.getServiceParam("MAILFROM", this.strSMTPUser);
        this.bSMTPAuth = Boolean.parseBoolean(this.getServiceParam("SMTPAUTH", "TRUE"));
        this.nSendTimer = Integer.parseInt(this.getServiceParam("SENDTIMER", "30000"));
        this.bDebug = Boolean.parseBoolean(this.getServiceParam("DEBUG", "FALSE"));
        this.bSSL = Boolean.parseBoolean(this.getServiceParam("SSL", "FALSE"));
        this.msgSendQueueService = (MsgSendQueueService)ServiceGlobal.getService(MsgSendQueueService.class);
        this.msgSendQueueHisService = (MsgSendQueueHisService)ServiceGlobal.getService(MsgSendQueueHisService.class);
        this.msgAccountService = (MsgAccountService)ServiceGlobal.getService(MsgAccountService.class);
        this.strQuerySQL = this.msgSendQueueService.getDAO().getRealDBDialect().getPagingSQL(this.strQuerySQL, 0, nPageSize, "CREATEDATE", "ASC", "", "");
        if (StringHelper.isNullOrEmpty(this.strQuerySQL)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u672a\u53d1\u9001\u90ae\u4ef6\u67e5\u8be2SQL");
        }
        if (StringHelper.isNullOrEmpty(this.strSMTPServer)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u90ae\u4ef6\u53d1\u9001\u670d\u52a1\u5668");
        }
    }

    @Override
    protected void onStart() throws Exception {
        super.onStart();
        if (this.sendmailTimer == null) {
            this.sendmailTimer = new Timer("MSGSENDQUEUE");
            this.sendmailTimer.schedule(new TimerTask(){

                @Override
                public void run() {
                    SendMailBackendService.this.runTask();
                }
            }, this.nSendTimer, (long)this.nSendTimer);
        }
        log.info((Object)StringHelper.format("Send Mail Start"));
    }

    @Override
    protected void onStop() throws Exception {
        log.info((Object)StringHelper.format("Send Mail Stop"));
        if (this.sendmailTimer != null) {
            this.sendmailTimer.cancel();
            this.sendmailTimer = null;
        }
        super.onStop();
    }

    @Override
    protected void onRun() throws Exception {
        ArrayList<IEntity> sendMailQueueList;
        SqlParamList sqlParamList = new SqlParamList();
        if (this.bPlanSendTime) {
            Date date = new Date();
            Timestamp sendTime = new Timestamp(date.getTime() + 30000L);
            sqlParamList.addDateTime(sendTime);
        }
        if ((sendMailQueueList = this.msgSendQueueService.selectRaw(this.strQuerySQL, sqlParamList)).size() == 0) {
            return;
        }
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
            props.setProperty("mail.smtp.timeout", StringHelper.format("%1$s", 600000));
            props.setProperty("mail.smtp.starttls.enable", "true");
            if (this.bSSL) {
                props.setProperty("mail.smtp.ssl.enable", "true");
                props.setProperty("mail.smtp.socketFactory.host", this.strSMTPServer);
                props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.setProperty("mail.smtp.socketFactory.fallback", "false");
            }
            session = Session.getDefaultInstance((Properties)props, (Authenticator)new Authenticator(){

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SendMailBackendService.this.strSMTPUser, SendMailBackendService.this.strSMTPPassword);
                }
            });
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u767b\u5f55\u90ae\u4ef6\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            return;
        }
        for (IEntity iEntity : sendMailQueueList) {
            MsgSendQueue msgSendQueue = new MsgSendQueue();
            iEntity.copyTo(msgSendQueue, false);
            msgSendQueue.set("PROCESSTIME", DateHelper.getTimestampValue(new Date()));
            try {
                String strDstUsers;
                MimeMessage mimemessage = new MimeMessage(session);
                mimemessage.setFrom((Address)new InternetAddress(this.strMailFrom));
                mimemessage.setSentDate(new Date());
                mimemessage.setSubject(msgSendQueue.getSubject(), "GBK");
                Vector<InternetAddress> addressList = new Vector<InternetAddress>();
                String strDstAddresses = msgSendQueue.getDstAddresses();
                if (!StringHelper.isNullOrEmpty(strDstAddresses)) {
                    String[] addrs = strDstAddresses.split("[;]");
                    int i = 0;
                    while (i < addrs.length) {
                        if (!StringHelper.isNullOrEmpty(addrs[i])) {
                            addressList.add(new InternetAddress(addrs[i]));
                        }
                        ++i;
                    }
                }
                if (!StringHelper.isNullOrEmpty(strDstUsers = msgSendQueue.getDstUsers())) {
                    MsgAccount msgAccount = new MsgAccount();
                    String[] addrs = strDstUsers.split("[;]");
                    int i = 0;
                    while (i < addrs.length) {
                        if (!StringHelper.isNullOrEmpty(addrs[i])) {
                            msgAccount.setMsgAccountId(addrs[i]);
                            if (!this.msgAccountService.get(msgAccount, true)) {
                                msgSendQueue.setErrorInfo(StringHelper.format("\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef\uff0c\u83b7\u53d6\u6d88\u606f\u8d26\u6237[%1$s]\u5931\u8d25", addrs[i]));
                                msgSendQueue.setIsError(1);
                                log.error((Object)msgSendQueue.getErrorInfo());
                                this.msgSendQueueService.update(msgSendQueue);
                                throw new Exception(msgSendQueue.getErrorInfo());
                            }
                            if (!DataObject.getBoolValue(msgAccount.getIsList(), false)) {
                                if (StringHelper.isNullOrEmpty(msgAccount.getMailAddress())) {
                                    msgSendQueue.setErrorInfo(StringHelper.format("\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef\uff0c\u6d88\u606f\u8d26\u6237[%1$s]\u4e2d\u4e0d\u5305\u542b\u90ae\u4ef6\u5730\u5740\u4fe1\u606f", addrs[i]));
                                    msgSendQueue.setIsError(1);
                                    log.error((Object)msgSendQueue.getErrorInfo());
                                    this.msgSendQueueService.update(msgSendQueue);
                                    throw new Exception(msgSendQueue.getErrorInfo());
                                }
                                addressList.add(new InternetAddress(msgAccount.getMailAddress()));
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
                        if (!StringHelper.isNullOrEmpty(strTotalAddr)) {
                            strTotalAddr = String.valueOf(strTotalAddr) + ";";
                        }
                        strTotalAddr = String.valueOf(strTotalAddr) + iAddr.getAddress();
                    }
                }
                catch (Exception exception1) {
                    log.error((Object)"\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef", (Throwable)exception1);
                    msgSendQueue.setErrorInfo(exception1.getMessage());
                    msgSendQueue.setIsError(1);
                    this.msgSendQueueService.update(msgSendQueue);
                    throw exception1;
                }
                String strEncode = "text/html;charset=GBK";
                if (StringHelper.compare(msgSendQueue.getContentType(), "HTML", true) != 0) {
                    strEncode = "text/plain;charset=GBK";
                }
                MimeBodyPart mimebodypart = new MimeBodyPart();
                mimebodypart.setContent((Object)msgSendQueue.getContent(), strEncode);
                MimeMultipart mimemultipart = new MimeMultipart();
                mimemultipart.addBodyPart((BodyPart)mimebodypart);
                ArrayList<String> attachedFileList = new ArrayList<String>();
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
                    MsgSendQueueHis msgSendQueue2 = new MsgSendQueueHis();
                    msgSendQueue.setIsSend(1);
                    msgSendQueue.setIsError(0);
                    msgSendQueue.setTotalDstAddresses(strTotalAddr);
                    msgSendQueue.copyTo(msgSendQueue2, true);
                    msgSendQueue2.set("MSGSENDQUEUEHISID", msgSendQueue.getMsgSendQueueId());
                    msgSendQueue2.set("MSGSENDQUEUEHISNAME", msgSendQueue.getMsgSendQueueName());
                    try {
                        this.msgSendQueueHisService.create(msgSendQueue2);
                    }
                    catch (Exception ex) {
                        this.msgSendQueueService.remove(msgSendQueue);
                        throw new Exception(StringHelper.format("\u5c06\u53d1\u9001\u6570\u636e\u653e\u5165\u53d1\u9001\u5386\u53f2\u8bb0\u5f55\u961f\u5217\u4e2d\u5931\u8d25\uff0c%1$s", ex.getMessage()));
                    }
                    this.msgSendQueueService.remove(msgSendQueue);
                }
                catch (Exception exception) {
                    log.error((Object)"\u53d1\u9001\u90ae\u4ef6\u53d1\u751f\u9519\u8bef", (Throwable)exception);
                    exception.printStackTrace();
                    msgSendQueue.setErrorInfo(exception.getMessage());
                    msgSendQueue.setIsError(1);
                    this.msgSendQueueService.update(msgSendQueue);
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

