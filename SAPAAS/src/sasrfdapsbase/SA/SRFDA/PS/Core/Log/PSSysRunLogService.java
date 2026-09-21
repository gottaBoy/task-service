/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseService
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  javax.jms.Connection
 *  javax.jms.Message
 *  javax.jms.MessageConsumer
 *  javax.jms.MessageProducer
 *  javax.jms.TextMessage
 *  javax.jms.Topic
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunLog
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysRunLogService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.sf.json.JSONObject
 *  org.apache.activemq.ActiveMQConnectionFactory
 *  org.apache.activemq.ActiveMQSession
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Log;

import SA.SRFDA.Ctrl.BaseService;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.jms.Topic;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunLog;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.sf.json.JSONObject;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysRunLogService
extends BaseService {
    private TaskThread taskThread = null;
    private Boolean bRunning = false;
    private Connection connection;
    private MessageProducer messageProducer = null;
    private MessageConsumer messageConsumer = null;
    private ActiveMQSession session;
    private Topic topic;
    private static Log log = LogFactory.getLog(PSSysRunLogService.class);
    private String strBrokerUri;
    private String strQueueName;
    private String strConsumer = null;
    public static final String PARAM_QUEUENAME = "QUEUENAME";
    public static final String PARAM_BROKERURI = "BROKERURI";
    public static final String PARAM_CONSUMER = "CONSUMER";
    private String strFileLocalPath = "";
    private Object objRunningLock = new Object();

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        this.strQueueName = this.GetServiceParam(PARAM_QUEUENAME, "");
        this.strBrokerUri = this.GetServiceParam(PARAM_BROKERURI, "");
        this.strConsumer = this.GetServiceParam(PARAM_CONSUMER, "");
        if (StringHelper.IsNullOrEmpty((String)this.strQueueName) || StringHelper.IsNullOrEmpty((String)this.strBrokerUri)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e5\u5fd7\u961f\u5217\u53c2\u6570\u4e0d\u6b63\u786e"));
            return callResult;
        }
        try {
            PSObjectFactory.getPSModelStorage(this.getGlobalHelper());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)ex.getMessage()));
            return callResult;
        }
        this.setRunning(true);
        this.taskThread = new TaskThread();
        this.taskThread.setName("PSSYSRUNLOGSERVICE");
        this.taskThread.start();
        log.info((Object)StringHelper.Format((String)"PSSysRunLogService Start"));
        return callResult;
    }

    protected CallResult OnStop() {
        log.info((Object)StringHelper.Format((String)"PSSysRunLogService Stop"));
        this.setRunning(false);
        try {
            if (this.taskThread != null) {
                this.taskThread.join();
            }
            this.closeMessageConsumer();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        this.taskThread = null;
        return super.OnStop();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean isRunning() {
        Object object = this.objRunningLock;
        synchronized (object) {
            return this.bRunning;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setRunning(boolean bRunning) {
        Object object = this.objRunningLock;
        synchronized (object) {
            this.bRunning = bRunning;
        }
    }

    protected boolean runTask() {
        try {
            this.prepareMessageConsumer();
            int nCount = 100;
            while (nCount > 0) {
                TextMessage textMessage;
                String strText;
                --nCount;
                Message message = this.messageConsumer.receive(100L);
                if (message == null) break;
                if (!(message instanceof TextMessage) || StringHelper.IsNullOrEmpty((String)(strText = (textMessage = (TextMessage)message).getText()))) continue;
                JSONObject jo = JSONObject.fromString((String)strText);
                this.saveLog(jo);
            }
            return true;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u63a5\u6536\u6d88\u606f\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            try {
                this.closeMessageConsumer();
            }
            catch (Exception e) {
                log.error((Object)StringHelper.Format((String)"\u63a5\u6536\u6d88\u606f\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
            return false;
        }
    }

    protected void prepareMessageConsumer() throws Exception {
        if (this.messageConsumer != null) {
            return;
        }
        this.prepareMessageSession();
        this.topic = this.session.createTopic(this.strQueueName);
        this.messageConsumer = this.session.createDurableSubscriber(this.topic, this.strConsumer);
        this.connection.start();
    }

    protected void closeMessageConsumer() throws Exception {
        try {
            if (this.messageConsumer != null) {
                this.messageConsumer.close();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5173\u95ed\u6d88\u606f\u63a5\u6536\u8005\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        this.messageConsumer = null;
        this.topic = null;
        try {
            if (this.connection != null) {
                this.connection.stop();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5173\u95ed\u6d88\u606f\u63a5\u6536\u8005\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        this.closeMessageSession();
    }

    protected void prepareMessageSession() throws Exception {
        if (this.session != null) {
            return;
        }
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(this.strBrokerUri);
        Connection connection = factory.createConnection();
        connection.setClientID(this.strConsumer);
        this.session = (ActiveMQSession)connection.createSession(false, 1);
        this.connection = connection;
    }

    protected void closeMessageSession() {
        try {
            if (this.session != null) {
                this.session.close();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5173\u95ed\u6d88\u606f\u4f1a\u8bdd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        this.session = null;
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5173\u95ed\u6d88\u606f\u4f1a\u8bdd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        this.connection = null;
    }

    protected void saveLog(JSONObject jo) {
        try {
            String strPSSystemId = jo.optString("param");
            String strPSSysModelInstId = jo.optString("param2");
            String strPSSysRunSessionId = jo.optString("param3");
            String strPSSystemName = jo.optString("param4");
            String strName = jo.optString("name");
            long nTime = jo.optLong("time", 0L);
            String strLevel = jo.optString("level");
            int nLevel = jo.optInt("level2", -1);
            String strInfo = jo.optString("info");
            net.ibizsys.pscore.srv.sysdesign.service.PSSysRunLogService psSysRunLogService = null;
            psSysRunLogService = StringHelper.IsNullOrEmpty((String)strPSSysModelInstId) ? (net.ibizsys.pscore.srv.sysdesign.service.PSSysRunLogService)ServiceGlobal.getService(net.ibizsys.pscore.srv.sysdesign.service.PSSysRunLogService.class) : (net.ibizsys.pscore.srv.sysdesign.service.PSSysRunLogService)ServiceGlobal.getService(net.ibizsys.pscore.srv.sysdesign.service.PSSysRunLogService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)strPSSysModelInstId));
            PSSysRunLog psSysRunLog = new PSSysRunLog();
            psSysRunLog.setLogLevel(strLevel);
            psSysRunLog.setLogLevel2(Integer.valueOf(nLevel));
            psSysRunLog.setPSSysRunLogName(strName);
            psSysRunLog.setPSSystemId(strPSSystemId);
            psSysRunLog.setPSSystemName(strPSSystemName);
            psSysRunLog.setPSSysRunSessionId(strPSSysRunSessionId);
            psSysRunLog.setPSSysRunSessionName("\u7cfb\u7edf\u8fd0\u884c");
            psSysRunLog.setLogTime(new Timestamp(nTime));
            psSysRunLog.set("SRF_PERSONID", (Object)"SYSTEM");
            psSysRunLog.set("SRF_LOGINNAME", (Object)"SYSTEM");
            if (!StringHelper.IsNullOrEmpty((String)strInfo)) {
                if (strInfo.length() >= 2000) {
                    psSysRunLog.setLogInfo(String.valueOf(strInfo.substring(0, 1990)) + "...");
                    psSysRunLog.setLogInfo2(strInfo);
                } else {
                    psSysRunLog.setLogInfo(strInfo);
                }
            }
            psSysRunLogService.create((IEntity)psSysRunLog, false);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u6d88\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
        }
    }

    public class TaskThread
    extends Thread {
        @Override
        public void run() {
            while (PSSysRunLogService.this.isRunning()) {
                if (PSSysRunLogService.this.runTask()) continue;
                try {
                    Thread.sleep(100L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

