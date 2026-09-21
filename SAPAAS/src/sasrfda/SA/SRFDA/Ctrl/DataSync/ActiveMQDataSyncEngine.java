/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
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
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.Data.DataSyncIn;
import SA.SRFDA.Ctrl.DataSync.BaseDataSyncEngine;
import SA.SRFDA.Ctrl.DataSync.IDataSyncEngineParam;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
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
import net.sf.json.JSONObject;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.BlobMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ActiveMQDataSyncEngine
extends BaseDataSyncEngine
implements MessageListener {
    private Connection connection;
    private MessageProducer messageProducer = null;
    private MessageConsumer messageConsumer = null;
    private ActiveMQSession session;
    private Topic topic;
    private static Log log = LogFactory.getLog(ActiveMQDataSyncEngine.class);
    private String strFileLocalPath = "";

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.strFileLocalPath = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
        if (StringHelper.IsNullOrEmpty((String)this.strFileLocalPath)) {
            log.warn((Object)"\u6ca1\u6709\u5b9a\u4e49\u672c\u5730\u6587\u4ef6\u5b58\u50a8\u8def\u5f84\uff0c\u6587\u4ef6\u540c\u6b65\u65f6\u4f1a\u53d1\u751f\u9519\u8bef");
        }
    }

    @Override
    protected void OnSend(IDataSyncEngineParam param) throws Exception {
        try {
            this.PrepareMessageProducer();
            JSONObject jo = new JSONObject();
            jo.put("syncid", (Object)param.getDataSyncOut().getDATASYNCOUTID());
            jo.put("deid", (Object)param.getDataSyncOut().getDEID());
            jo.put("eventtype", param.getDataSyncOut().getEVENTTYPE());
            jo.put("datakey", (Object)param.getDataSyncOut().getDATAKEY());
            jo.put("data", (Object)param.getDataSyncOut().getDATA());
            jo.put("logicdata", (Object)param.getDataSyncOut().getLOGICDATA());
            TextMessage strMessage = this.session.createTextMessage(jo.toString());
            this.messageProducer.send((Message)strMessage);
            if (!StringHelper.IsNullOrEmpty((String)param.getDataSyncOut().getFILELIST())) {
                String[] fileList;
                String[] stringArray = fileList = param.getDataSyncOut().getFILELIST().split("[|]");
                int n = fileList.length;
                int n2 = 0;
                while (n2 < n) {
                    String strFile = stringArray[n2];
                    String strTotalPath = String.valueOf(this.strFileLocalPath) + File.separator + strFile;
                    File file = new File(strTotalPath);
                    if (file.exists()) {
                        BlobMessage blobMessage = this.session.createBlobMessage(file);
                        blobMessage.setIntProperty("eventtype", param.getDataSyncOut().getEVENTTYPE());
                        blobMessage.setStringProperty("syncid", param.getDataSyncOut().getDATASYNCOUTID());
                        blobMessage.setStringProperty("deid", param.getDataSyncOut().getDEID());
                        blobMessage.setStringProperty("datakey", param.getDataSyncOut().getDATAKEY());
                        blobMessage.setStringProperty("logicdata", param.getDataSyncOut().getLOGICDATA());
                        blobMessage.setStringProperty("filepath", strFile);
                        this.messageProducer.send((Message)blobMessage);
                    }
                    ++n2;
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u9001\u6d88\u606f\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            this.CloseMessageProducer();
            throw ex;
        }
    }

    protected void PrepareMessageSession() throws Exception {
        if (this.session != null) {
            return;
        }
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(this.dataSyncAgent.getSERVERPATH());
        Connection connection = factory.createConnection();
        if (!this.dataSyncAgent.isCLIENTIDNull()) {
            connection.setClientID(this.dataSyncAgent.getCLIENTID());
        } else {
            connection.setClientID(this.dataSyncAgent.getDATASYNCAGENTID());
        }
        this.session = (ActiveMQSession)connection.createSession(false, 1);
        this.connection = connection;
    }

    protected void CloseMessageSession() {
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

    protected void PrepareMessageProducer() throws Exception {
        if (this.messageProducer != null) {
            return;
        }
        this.PrepareMessageSession();
        this.topic = this.session.createTopic(this.dataSyncAgent.getSERVICENAME());
        this.messageProducer = this.session.createProducer((Destination)this.topic);
        this.messageProducer.setDeliveryMode(2);
    }

    protected void PrepareMessageConsumer() throws Exception {
        if (this.messageConsumer != null) {
            return;
        }
        this.PrepareMessageSession();
        this.topic = this.session.createTopic(this.dataSyncAgent.getSERVICENAME());
        this.messageConsumer = this.session.createDurableSubscriber(this.topic, this.dataSyncAgent.getDATASYNCAGENTID());
        this.connection.start();
    }

    protected void CloseMessageProducer() {
        try {
            if (this.messageProducer != null) {
                this.messageProducer.close();
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5173\u95ed\u6d88\u606f\u53d1\u9001\u8005\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        this.messageProducer = null;
        this.topic = null;
        this.CloseMessageSession();
    }

    protected void CloseMessageConsumer() throws Exception {
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
        this.CloseMessageSession();
    }

    public void onMessage(Message arg0) {
        if (arg0 instanceof TextMessage) {
            return;
        }
    }

    @Override
    protected boolean OnCheckSend() {
        try {
            this.PrepareMessageProducer();
            this.messageProducer.setDeliveryMode(1);
            TextMessage strMessage = this.session.createTextMessage("");
            this.messageProducer.send((Message)strMessage);
            this.messageProducer.setDeliveryMode(2);
            return true;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u6d4b\u8bd5\u53d1\u9001\u6d88\u606f\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            this.CloseMessageProducer();
            return false;
        }
    }

    @Override
    protected void OnQuit() throws Exception {
        if (StringHelper.Compare((String)this.getSyncDir(), (String)"IN", (boolean)true) == 0) {
            this.CloseMessageConsumer();
        } else {
            this.CloseMessageProducer();
        }
        super.OnQuit();
    }

    @Override
    protected void OnRecv(IDataSyncEngineParam iDataSyncEngineParam) throws Exception {
        try {
            this.PrepareMessageConsumer();
            int nCount = 100;
            while (nCount > 0) {
                --nCount;
                Message message = this.messageConsumer.receive(1000L);
                if (message == null) break;
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage)message;
                    String strText = textMessage.getText();
                    if (StringHelper.IsNullOrEmpty((String)strText)) continue;
                    JSONObject jo = JSONObject.fromString((String)strText);
                    DataSyncIn dataSyncIn = new DataSyncIn();
                    dataSyncIn.setFILEFLAG(false);
                    dataSyncIn.setDATASYNCINNAME(jo.getString("syncid"));
                    dataSyncIn.setDEID(jo.getString("deid"));
                    dataSyncIn.setEVENTTYPE(jo.getInt("eventtype"));
                    dataSyncIn.setDATAKEY(jo.getString("datakey"));
                    dataSyncIn.setDATA(jo.getString("data"));
                    dataSyncIn.setLOGICDATA(jo.getString("logicdata"));
                    dataSyncIn.setSYNCAGENT(this.getId());
                    iDataSyncEngineParam.AddDataSyncIn(dataSyncIn);
                    continue;
                }
                if (!(message instanceof BlobMessage)) continue;
                BlobMessage blobMessage = (BlobMessage)message;
                String strFilePath = blobMessage.getStringProperty("filepath");
                String strSyncId = blobMessage.getStringProperty("syncid");
                String strDEId = blobMessage.getStringProperty("deid");
                String strDataKey = blobMessage.getStringProperty("datakey");
                String strLogicData = blobMessage.getStringProperty("logicdata");
                int nEventType = blobMessage.getIntProperty("eventtype");
                String strTempFile = String.valueOf(this.getDAGlobalHelper().GetTempPath()) + Helper.GenGuidEx();
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
                    log.error((Object)StringHelper.Format((String)"\u5199\u5165\u540c\u6b65\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                }
                DataSyncIn dataSyncIn = new DataSyncIn();
                dataSyncIn.setFILEFLAG(true);
                dataSyncIn.setDATASYNCINNAME(strSyncId);
                dataSyncIn.setDEID(strDEId);
                dataSyncIn.setEVENTTYPE(nEventType);
                dataSyncIn.setDATAKEY(strDataKey);
                dataSyncIn.setDATA(strFilePath);
                dataSyncIn.setLOGICDATA(strLogicData);
                dataSyncIn.setSYNCAGENT(this.getId());
                dataSyncIn.SetParamValue("TEMPFILE", strTempFile);
                iDataSyncEngineParam.AddDataSyncIn(dataSyncIn);
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u63a5\u6536\u6d88\u606f\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            this.CloseMessageConsumer();
            throw ex;
        }
    }
}

