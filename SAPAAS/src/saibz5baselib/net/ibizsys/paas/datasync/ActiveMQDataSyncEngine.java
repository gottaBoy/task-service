/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.jms.Connection
 *  javax.jms.Destination
 *  javax.jms.Message
 *  javax.jms.MessageConsumer
 *  javax.jms.MessageListener
 *  javax.jms.MessageProducer
 *  javax.jms.TextMessage
 *  javax.jms.Topic
 *  net.sf.json.JSONObject
 *  org.apache.activemq.ActiveMQConnectionFactory
 *  org.apache.activemq.ActiveMQSession
 *  org.apache.activemq.BlobMessage
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.datasync;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.jms.Topic;
import net.ibizsys.paas.datasync.DataSyncEngineBase;
import net.ibizsys.paas.datasync.IDataSyncParam;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
import net.sf.json.JSONObject;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.BlobMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ActiveMQDataSyncEngine
extends DataSyncEngineBase
implements MessageListener {
    private Connection connection;
    private MessageProducer messageProducer = null;
    private MessageConsumer messageConsumer = null;
    private ActiveMQSession session;
    private Topic topic;
    private static Log log = LogFactory.getLog(ActiveMQDataSyncEngine.class);
    private String strFileLocalPath = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strFileLocalPath = PropertiesHelper.getProperty(this.getParams(), "FILEFOLDER", "");
        if (StringHelper.isNullOrEmpty(this.strFileLocalPath)) {
            log.warn((Object)"\u6ca1\u6709\u5b9a\u4e49\u672c\u5730\u6587\u4ef6\u5b58\u50a8\u8def\u5f84\uff0c\u6587\u4ef6\u540c\u6b65\u65f6\u53ef\u80fd\u4f1a\u53d1\u751f\u9519\u8bef");
        }
    }

    @Override
    protected void onSend(IDataSyncParam param) throws Exception {
        try {
            this.PrepareMessageProducer();
            JSONObject jo = new JSONObject();
            jo.put("syncid", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getDataSyncOutId(), true));
            jo.put("deid", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getDEId(), true));
            jo.put("dename", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getDEName(), true));
            jo.put("eventtype", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getEventType(), true));
            jo.put("datakey", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getDataKey(), true));
            jo.put("data", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getData(), true));
            jo.put("logicdata", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getLogicData(), true));
            TextMessage strMessage = this.session.createTextMessage(jo.toString());
            this.messageProducer.send((Message)strMessage);
            if (!StringHelper.isNullOrEmpty(param.getDataSyncOut().getFileList())) {
                String[] fileList;
                String[] stringArray = fileList = param.getDataSyncOut().getFileList().split("[|]");
                int n = fileList.length;
                int n2 = 0;
                while (n2 < n) {
                    String strFile = stringArray[n2];
                    String strTotalPath = String.valueOf(this.strFileLocalPath) + File.separator + strFile;
                    File file = new File(strTotalPath);
                    if (file.exists()) {
                        BlobMessage blobMessage = this.session.createBlobMessage(file);
                        blobMessage.setIntProperty("eventtype", param.getDataSyncOut().getEventType().intValue());
                        blobMessage.setStringProperty("syncid", param.getDataSyncOut().getDataSyncOutId());
                        blobMessage.setStringProperty("deid", param.getDataSyncOut().getDEId());
                        blobMessage.setStringProperty("dename", param.getDataSyncOut().getDEName());
                        blobMessage.setStringProperty("datakey", param.getDataSyncOut().getDataKey());
                        blobMessage.setStringProperty("logicdata", param.getDataSyncOut().getLogicData());
                        blobMessage.setStringProperty("filepath", strFile);
                        this.messageProducer.send((Message)blobMessage);
                    }
                    ++n2;
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u53d1\u9001\u6d88\u606f\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            this.closeMessageProducer();
            throw ex;
        }
    }

    protected void prepareMessageSession() throws Exception {
        if (this.session != null) {
            return;
        }
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(this.dataSyncAgent.getServerPath());
        Connection connection = factory.createConnection();
        if (!StringHelper.isNullOrEmpty(this.dataSyncAgent.getClientId())) {
            connection.setClientID(this.dataSyncAgent.getClientId());
        } else {
            connection.setClientID(this.dataSyncAgent.getDataSyncAgentId());
        }
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
            log.error((Object)StringHelper.format("\u5173\u95ed\u6d88\u606f\u4f1a\u8bdd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
        }
        this.session = null;
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u5173\u95ed\u6d88\u606f\u4f1a\u8bdd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
        }
        this.connection = null;
    }

    protected void PrepareMessageProducer() throws Exception {
        if (this.messageProducer != null) {
            return;
        }
        this.prepareMessageSession();
        this.topic = this.session.createTopic(this.dataSyncAgent.getServiceName());
        this.messageProducer = this.session.createProducer((Destination)this.topic);
        this.messageProducer.setDeliveryMode(2);
    }

    protected void prepareMessageConsumer() throws Exception {
        if (this.messageConsumer != null) {
            return;
        }
        this.prepareMessageSession();
        this.topic = this.session.createTopic(this.dataSyncAgent.getServiceName());
        this.messageConsumer = this.session.createDurableSubscriber(this.topic, this.dataSyncAgent.getDataSyncAgentId());
        this.connection.start();
    }

    protected void closeMessageProducer() {
        try {
            if (this.messageProducer != null) {
                this.messageProducer.close();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u5173\u95ed\u6d88\u606f\u53d1\u9001\u8005\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
        }
        this.messageProducer = null;
        this.topic = null;
        this.closeMessageSession();
    }

    protected void closeMessageConsumer() throws Exception {
        try {
            if (this.messageConsumer != null) {
                this.messageConsumer.close();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u5173\u95ed\u6d88\u606f\u63a5\u6536\u8005\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
        }
        this.messageConsumer = null;
        this.topic = null;
        try {
            if (this.connection != null) {
                this.connection.stop();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u5173\u95ed\u6d88\u606f\u63a5\u6536\u8005\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
        }
        this.closeMessageSession();
    }

    public void onMessage(Message arg0) {
        if (arg0 instanceof TextMessage) {
            return;
        }
    }

    @Override
    protected boolean onCheckSend() throws Exception {
        try {
            this.PrepareMessageProducer();
            this.messageProducer.setDeliveryMode(1);
            TextMessage strMessage = this.session.createTextMessage("");
            this.messageProducer.send((Message)strMessage);
            this.messageProducer.setDeliveryMode(2);
            return true;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u6d4b\u8bd5\u53d1\u9001\u6d88\u606f\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            this.closeMessageProducer();
            return false;
        }
    }

    @Override
    protected void onQuit() throws Exception {
        if (StringHelper.compare(this.getSyncDir(), "IN", true) == 0) {
            this.closeMessageConsumer();
        } else {
            this.closeMessageProducer();
        }
        super.onQuit();
    }

    @Override
    protected void onRecv(IDataSyncParam iDataSyncParam) throws Exception {
        try {
            this.prepareMessageConsumer();
            int nCount = 100;
            while (nCount > 0) {
                --nCount;
                Message message = this.messageConsumer.receive(1000L);
                if (message == null) break;
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage)message;
                    String strText = textMessage.getText();
                    if (StringHelper.isNullOrEmpty(strText)) continue;
                    JSONObject jo = JSONObjectHelper.fromString(strText);
                    DataSyncIn dataSyncIn = new DataSyncIn();
                    dataSyncIn.setFileFlag(0);
                    dataSyncIn.setDataSyncInName(jo.getString("syncid"));
                    dataSyncIn.setDEId(jo.getString("deid"));
                    dataSyncIn.setDEName(jo.getString("dename"));
                    dataSyncIn.setEventType(jo.getInt("eventtype"));
                    dataSyncIn.setDataKey(jo.getString("datakey"));
                    dataSyncIn.setData(jo.getString("data"));
                    dataSyncIn.setLogicData(jo.getString("logicdata"));
                    dataSyncIn.setSyncAgent(this.getId());
                    iDataSyncParam.addDataSyncIn(dataSyncIn);
                    continue;
                }
                if (!(message instanceof BlobMessage)) continue;
                BlobMessage blobMessage = (BlobMessage)message;
                String strFilePath = blobMessage.getStringProperty("filepath");
                String strSyncId = blobMessage.getStringProperty("syncid");
                String strDEId = blobMessage.getStringProperty("deid");
                String strDEName = blobMessage.getStringProperty("dename");
                String strDataKey = blobMessage.getStringProperty("datakey");
                String strLogicData = blobMessage.getStringProperty("logicdata");
                int nEventType = blobMessage.getIntProperty("eventtype");
                String strTempFile = String.valueOf(WebConfig.getCurrent().getTempPath()) + KeyValueHelper.genGuidEx();
                try {
                    FileOutputStream os = new FileOutputStream(new File(strTempFile));
                    InputStream inputStream = blobMessage.getInputStream();
                    byte[] buff = new byte[2048];
                    int len = 0;
                    while ((len = inputStream.read(buff)) > 0) {
                        ((OutputStream)os).write(buff, 0, len);
                    }
                    ((OutputStream)os).close();
                    inputStream.close();
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.format("\u5199\u5165\u540c\u6b65\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
                }
                DataSyncIn dataSyncIn = new DataSyncIn();
                dataSyncIn.setFileFlag(1);
                dataSyncIn.setDataSyncInName(strSyncId);
                dataSyncIn.setDEId(strDEId);
                dataSyncIn.setDEName(strDEName);
                dataSyncIn.setEventType(nEventType);
                dataSyncIn.setDataKey(strDataKey);
                dataSyncIn.setData(strFilePath);
                dataSyncIn.setLogicData(strLogicData);
                dataSyncIn.setSyncAgent(this.getId());
                dataSyncIn.set("TEMPFILE", strTempFile);
                iDataSyncParam.addDataSyncIn(dataSyncIn);
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u63a5\u6536\u6d88\u606f\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            this.closeMessageConsumer();
            throw ex;
        }
    }
}

