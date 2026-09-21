/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.jms.Connection
 *  javax.jms.Destination
 *  javax.jms.Message
 *  javax.jms.MessageProducer
 *  javax.jms.TextMessage
 *  javax.jms.Topic
 *  net.sf.json.JSONObject
 *  org.apache.activemq.ActiveMQConnectionFactory
 *  org.apache.activemq.ActiveMQSession
 *  org.apache.log4j.Appender
 *  org.apache.log4j.AppenderSkeleton
 *  org.apache.log4j.spi.LoggingEvent
 */
package net.ibizsys.paas.log;

import java.util.ArrayList;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.jms.Topic;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class JMSQueueAppender
extends AppenderSkeleton
implements Appender {
    public static final String SHUTDOWNCMD = "WebFilter destroy";
    private TaskThread taskThread = null;
    private Boolean bRunning = true;
    private String brokerUri;
    private String strTopicName;
    private String strLoggerType = null;
    private String strLoggerParam = null;
    private String strLoggerParam2 = null;
    private String strLoggerParam3 = null;
    private String strLoggerParam4 = null;
    private Connection connection;
    private MessageProducer messageProducer = null;
    private ActiveMQSession session;
    private Topic topic;
    protected ArrayList<String> logList = new ArrayList();
    protected ArrayList<String> logList2 = new ArrayList();
    private Object objRunningLock = new Object();

    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.setRunning(false);
        this.closeMessageProducer();
        try {
            if (this.taskThread != null) {
                this.taskThread.join();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.taskThread = null;
    }

    public boolean requiresLayout() {
        return false;
    }

    protected synchronized void append(LoggingEvent event) {
        block4: {
            if (!this.isRunning()) {
                return;
            }
            if (StringHelper.isNullOrEmpty(this.brokerUri)) {
                return;
            }
            try {
                this.appendLogList(this.getTextMessage(event));
            }
            catch (Exception ex) {
                if (StringHelper.compare(ex.getMessage(), SHUTDOWNCMD, true) != 0) break block4;
                this.setRunning(false);
                this.closeMessageProducer();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void appendLogList(String strLogMessage) {
        ArrayList<String> arrayList = this.logList;
        synchronized (arrayList) {
            if (this.logList.size() > 1000) {
                this.logList.clear();
            }
            this.logList.add(strLogMessage);
            if (this.taskThread == null) {
                this.setRunning(true);
                this.taskThread = new TaskThread();
                this.taskThread.setName("PSSYSRUNLOGSERVICE");
                this.taskThread.start();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean runTask() {
        block7: {
            ArrayList<String> arrayList = this.logList;
            synchronized (arrayList) {
                this.logList2.addAll(this.logList);
                this.logList.clear();
            }
            if (this.logList2.size() != 0) break block7;
            return false;
        }
        try {
            this.prepareMessageProducer();
            while (this.logList2.size() > 0 && this.isRunning()) {
                String strMessage = this.logList2.remove(0);
                TextMessage message = this.session.createTextMessage(strMessage);
                this.messageProducer.send((Message)message);
            }
            return true;
        }
        catch (Exception e) {
            this.closeMessageProducer();
            e.printStackTrace();
            return false;
        }
    }

    protected void prepareMessageSession() throws Exception {
        if (this.session != null) {
            return;
        }
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(this.getBrokerUri());
        Connection connection = factory.createConnection();
        connection.setClientID(this.getLoggerParam3());
        this.session = (ActiveMQSession)connection.createSession(false, 1);
        this.connection = connection;
    }

    protected void closeMessageSession() {
        try {
            if (this.session != null) {
                this.session.close();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.session = null;
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.connection = null;
    }

    protected void prepareMessageProducer() throws Exception {
        if (this.messageProducer != null) {
            return;
        }
        this.prepareMessageSession();
        this.topic = this.session.createTopic(this.getTopicName());
        this.messageProducer = this.session.createProducer((Destination)this.topic);
        this.messageProducer.setDeliveryMode(1);
    }

    protected void closeMessageProducer() {
        try {
            if (this.messageProducer != null) {
                this.messageProducer.close();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        this.messageProducer = null;
        this.topic = null;
        this.closeMessageSession();
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

    public void setBrokerUri(String brokerUri) {
        this.brokerUri = brokerUri;
    }

    public String getBrokerUri() {
        return this.brokerUri;
    }

    public void setTopicName(String strTopicName) {
        this.strTopicName = strTopicName;
    }

    public String getTopicName() {
        return this.strTopicName;
    }

    protected String getTextMessage(LoggingEvent event) throws Exception {
        JSONObject jo = new JSONObject();
        if (!StringHelper.isNullOrEmpty(this.getLoggerType())) {
            jo.put("type", (Object)this.getLoggerType());
        }
        if (!StringHelper.isNullOrEmpty(this.getLoggerParam())) {
            jo.put("param", (Object)this.getLoggerParam());
        }
        if (!StringHelper.isNullOrEmpty(this.getLoggerParam2())) {
            jo.put("param2", (Object)this.getLoggerParam2());
        }
        if (!StringHelper.isNullOrEmpty(this.getLoggerParam3())) {
            jo.put("param3", (Object)this.getLoggerParam3());
        }
        if (!StringHelper.isNullOrEmpty(this.getLoggerParam4())) {
            jo.put("param4", (Object)this.getLoggerParam4());
        }
        jo.put("name", (Object)event.getLoggerName());
        jo.put("time", event.timeStamp);
        jo.put("level", (Object)event.getLevel().toString());
        jo.put("level2", event.getLevel().toInt());
        String strLogInfo = null;
        if (event.getMessage() != null && event.getMessage() instanceof String) {
            strLogInfo = (String)event.getMessage();
        }
        if (!StringHelper.isNullOrEmpty(strLogInfo)) {
            jo.put("info", strLogInfo);
            if (StringHelper.compare(strLogInfo, SHUTDOWNCMD, true) == 0) {
                throw new Exception(SHUTDOWNCMD);
            }
        }
        return jo.toString();
    }

    public String getLoggerType() {
        return this.strLoggerType;
    }

    public void setLoggerType(String strLoggerType) {
        this.strLoggerType = strLoggerType;
    }

    public String getLoggerParam() {
        return this.strLoggerParam;
    }

    public void setLoggerParam(String strLoggerParam) {
        this.strLoggerParam = strLoggerParam;
    }

    public String getLoggerParam2() {
        return this.strLoggerParam2;
    }

    public void setLoggerParam2(String strLoggerParam2) {
        this.strLoggerParam2 = strLoggerParam2;
    }

    public String getLoggerParam3() {
        return this.strLoggerParam3;
    }

    public void setLoggerParam3(String strLoggerParam3) {
        this.strLoggerParam3 = strLoggerParam3;
    }

    public String getLoggerParam4() {
        return this.strLoggerParam4;
    }

    public void setLoggerParam4(String strLoggerParam4) {
        this.strLoggerParam4 = strLoggerParam4;
    }

    public class TaskThread
    extends Thread {
        @Override
        public void run() {
            while (JMSQueueAppender.this.isRunning()) {
                if (JMSQueueAppender.this.runTask()) continue;
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

