/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.kafka.clients.producer.KafkaProducer
 *  org.apache.kafka.clients.producer.ProducerRecord
 *  org.apache.kafka.common.serialization.StringSerializer
 */
package net.ibizsys.pscore.srv.util.kafka;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.pscore.srv.util.kafka.IPSKafkaPlugin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public abstract class PSKafkaPluginImplBase
implements IPSKafkaPlugin {
    private static final Log log = LogFactory.getLog(PSKafkaPluginImplBase.class);
    private Properties properties = new Properties();
    private String strTopicOfPSSysModelChgLog = "pssysmodelchglog";
    private String strTopicOfPSBKTaskLog = "psbktasklog";
    private KafkaProducer<String, String> producer = null;
    private ThreadPoolExecutor threadPoolExecutor = null;

    public PSKafkaPluginImplBase() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("saps-kafka.properties");
        if (inputStream != null) {
            try {
                this.properties.load(inputStream);
            }
            catch (IOException iOException) {
                log.error((Object)iOException);
            }
            this.strTopicOfPSSysModelChgLog = PropertiesHelper.getProperty((Properties)this.properties, (String)"topic.pssysmodelchglog", (String)this.strTopicOfPSSysModelChgLog);
            this.strTopicOfPSBKTaskLog = PropertiesHelper.getProperty((Properties)this.properties, (String)"topic.psbktasklog", (String)this.strTopicOfPSBKTaskLog);
        }
        if (!this.properties.containsKey("key.serializer")) {
            this.properties.put("key.serializer", StringSerializer.class.getName());
        }
        if (!this.properties.containsKey("value.serializer")) {
            this.properties.put("value.serializer", StringSerializer.class.getName());
        }
        this.producer = new KafkaProducer(this.properties);
        this.threadPoolExecutor = this.createWorkThreadPoolExecutor();
    }

    protected ThreadPoolExecutor createWorkThreadPoolExecutor() {
        return new ThreadPoolExecutor(1, 5, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000), new ThreadPoolExecutor.AbortPolicy());
    }

    public String getTopicOfPSSysModelChgLog() {
        return this.strTopicOfPSSysModelChgLog;
    }

    public String getTopicOfPSBKTaskLog() {
        return this.strTopicOfPSBKTaskLog;
    }

    @Override
    public void sendPSSysModelChgLog(String string) {
        try {
            this.onSend(this.getTopicOfPSSysModelChgLog(), string);
        }
        catch (Exception exception) {
            log.error((Object)String.format("\u53d1\u9001\u7cfb\u7edf\u6a21\u578b\u53d8\u66f4\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), (Throwable)exception);
        }
    }

    @Override
    public void sendPSBKTaskLog(String string) {
        try {
            this.onSend(this.getTopicOfPSBKTaskLog(), string);
        }
        catch (Exception exception) {
            log.error((Object)String.format("\u53d1\u9001\u540e\u53f0\u4efb\u52a1\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), (Throwable)exception);
        }
    }

    protected void onSend(final String string, final String string2) throws Exception {
        if (this.threadPoolExecutor == null || this.getProducer() == null) {
            return;
        }
        this.threadPoolExecutor.execute(new Runnable(){

            @Override
            public void run() {
                PSKafkaPluginImplBase.this.getProducer().send(new ProducerRecord(string, (Object)string2));
            }
        });
    }

    protected KafkaProducer<String, String> getProducer() {
        return this.producer;
    }
}

