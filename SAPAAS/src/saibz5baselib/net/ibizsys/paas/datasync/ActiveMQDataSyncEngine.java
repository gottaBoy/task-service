package net.ibizsys.paas.datasync;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.BlobMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
import net.sf.json.JSONObject;

/**
 * Active MQ 数据同步引擎
 * 
 * @author LionLau
 *
 */
public class ActiveMQDataSyncEngine extends DataSyncEngineBase implements MessageListener {
	private Connection connection;
	private MessageProducer messageProducer = null;
	private MessageConsumer messageConsumer = null;
	private ActiveMQSession session;
	private Topic topic;
	private static Log log = LogFactory.getLog(ActiveMQDataSyncEngine.class);

	private String strFileLocalPath = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.DataSyncEngineBase#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();
		strFileLocalPath = PropertiesHelper.getProperty(this.getParams(), "FILEFOLDER", "");
		if (StringHelper.isNullOrEmpty(strFileLocalPath)) {
			log.warn("没有定义本地文件存储路径，文件同步时可能会发生错误");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFDA.Ctrl.DataSync.BaseDataSyncEngine#onSend(SA.SRFDA.Ctrl.DataSync.IDataSyncParam)
	 */
	@Override
	protected void onSend(IDataSyncParam param) throws Exception {
		try {
			PrepareMessageProducer();

			// 准备消息格式化
			JSONObject jo = new JSONObject();
			jo.put("syncid",JSONObjectHelper.stripQuotes(param.getDataSyncOut().getDataSyncOutId(),true));
			jo.put("deid", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getDEId(),true));
			jo.put("dename", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getDEName(),true));
			jo.put("eventtype", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getEventType(),true));
			jo.put("datakey", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getDataKey(),true));
			jo.put("data", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getData(),true));
			jo.put("logicdata", JSONObjectHelper.stripQuotes(param.getDataSyncOut().getLogicData(),true));

			TextMessage strMessage = this.session.createTextMessage(jo.toString());
			this.messageProducer.send(strMessage);

			if (!StringHelper.isNullOrEmpty(param.getDataSyncOut().getFileList())) {
				String[] fileList = param.getDataSyncOut().getFileList().split("[|]");
				for (String strFile : fileList) {
					String strTotalPath = strFileLocalPath + File.separator + strFile;
					File file = new File(strTotalPath);
					if (file.exists()) {
						BlobMessage blobMessage = session.createBlobMessage(file);
						blobMessage.setIntProperty("eventtype", param.getDataSyncOut().getEventType());
						blobMessage.setStringProperty("syncid", param.getDataSyncOut().getDataSyncOutId());
						blobMessage.setStringProperty("deid", param.getDataSyncOut().getDEId());
						blobMessage.setStringProperty("dename", param.getDataSyncOut().getDEName());
						blobMessage.setStringProperty("datakey", param.getDataSyncOut().getDataKey());
						blobMessage.setStringProperty("logicdata", param.getDataSyncOut().getLogicData());
						blobMessage.setStringProperty("filepath", strFile);
						this.messageProducer.send(blobMessage);
					}
				}
			}
		} catch (Exception ex) {
			log.error(StringHelper.format("发送消息出现异常，%1$s", ex.getMessage()), ex);
			closeMessageProducer();
			throw ex;
		}
	}

	/**
	 * 准备消息会话
	 * 
	 * @throws Exception
	 */
	protected void prepareMessageSession() throws Exception {
		if (session != null) return;

		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(this.dataSyncAgent.getServerPath());
		Connection connection = factory.createConnection();
		if (!StringHelper.isNullOrEmpty(this.dataSyncAgent.getClientId())) {
			connection.setClientID(this.dataSyncAgent.getClientId());
		} else {
			connection.setClientID(this.dataSyncAgent.getDataSyncAgentId());
		}
		session = (ActiveMQSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		this.connection = connection;
	}

	/**
	 * 关闭消息会话
	 * 
	 * @throws Exception
	 */
	protected void closeMessageSession() {
		try {
			if (session != null) {
				session.close();
			}
		} catch (Exception ex) {
			log.error(StringHelper.format("关闭消息会话发生异常，%1$s", ex.getMessage()), ex);
		}
		session = null;

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception ex) {
			log.error(StringHelper.format("关闭消息会话发生异常，%1$s", ex.getMessage()), ex);
		}
		connection = null;

	}

	/**
	 * 准备链接
	 * 
	 * @throws Exception
	 */
	protected void PrepareMessageProducer() throws Exception {
		if (messageProducer != null) return;

		prepareMessageSession();

		topic = session.createTopic(this.dataSyncAgent.getServiceName());
		messageProducer = session.createProducer(topic);
		messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
	}

	/**
	 * 准备链接
	 * 
	 * @throws Exception
	 */
	protected void prepareMessageConsumer() throws Exception {
		if (messageConsumer != null) return;

		prepareMessageSession();

		topic = session.createTopic(this.dataSyncAgent.getServiceName());
		messageConsumer = session.createDurableSubscriber(topic, this.dataSyncAgent.getDataSyncAgentId());
		connection.start();

	}

	/**
	 * 关闭消息发生者
	 */
	protected void closeMessageProducer() {
		try {
			if (messageProducer != null) {
				this.messageProducer.close();
			}
		} catch (Exception ex) {
			log.error(StringHelper.format("关闭消息发送者发生异常，%1$s", ex.getMessage()), ex);
		}
		messageProducer = null;

		topic = null;

		closeMessageSession();
	}

	/**
	 * 准备链接
	 * 
	 * @throws Exception
	 */
	protected void closeMessageConsumer() throws Exception {
		try {
			if (messageConsumer != null) {
				this.messageConsumer.close();
			}
		} catch (Exception ex) {
			log.error(StringHelper.format("关闭消息接收者发生异常，%1$s", ex.getMessage()), ex);
		}
		messageConsumer = null;

		topic = null;
		try {
			if (connection != null) connection.stop();
		} catch (Exception ex) {
			log.error(StringHelper.format("关闭消息接收者发生异常，%1$s", ex.getMessage()), ex);
		}
		closeMessageSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	public void onMessage(Message arg0) {
		if ((arg0 instanceof TextMessage)) {
			return;
		}

		try {

		} catch (Exception ex) {

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.DataSyncEngineBase#onCheckSend()
	 */
	@Override
	protected boolean onCheckSend() throws Exception {
		try {
			PrepareMessageProducer();
			this.messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			TextMessage strMessage = this.session.createTextMessage("");
			this.messageProducer.send(strMessage);
			this.messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
			return true;
		} catch (Exception ex) {
			log.error(StringHelper.format("测试发送消息出现异常，%1$s", ex.getMessage()), ex);
			closeMessageProducer();
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.DataSyncEngineBase#onQuit()
	 */
	@Override
	protected void onQuit() throws Exception {
		if (StringHelper.compare(this.getSyncDir(), IDataSyncEngine.SYNCDIR_IN, true) == 0) {
			closeMessageConsumer();
		} else {
			closeMessageProducer();
		}
		super.onQuit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.DataSyncEngineBase#onRecv(net.ibizsys.paas.datasync.IDataSyncParam)
	 */
	@Override
	protected void onRecv(IDataSyncParam iDataSyncParam) throws Exception {
		try {
			prepareMessageConsumer();
			int nCount = 100;
			while (nCount > 0) {
				nCount--;
				Message message = this.messageConsumer.receive(1000);
				if (message == null) {
					break;
				}
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					String strText = textMessage.getText();
					if (StringHelper.isNullOrEmpty(strText)) {
						continue;
					}
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

				if (message instanceof BlobMessage) {
					BlobMessage blobMessage = (BlobMessage) message;
					String strFilePath = blobMessage.getStringProperty("filepath");
					String strSyncId = blobMessage.getStringProperty("syncid");
					String strDEId = blobMessage.getStringProperty("deid");
					String strDEName = blobMessage.getStringProperty("dename");
					String strDataKey = blobMessage.getStringProperty("datakey");
					String strLogicData = blobMessage.getStringProperty("logicdata");
					int nEventType = blobMessage.getIntProperty("eventtype");

					String strTempFile = WebConfig.getCurrent().getTempPath() + KeyValueHelper.genGuidEx();
					try {
						OutputStream os = new FileOutputStream(new File(strTempFile));
						InputStream inputStream = blobMessage.getInputStream();
						// 写文件，你也可以使用其他方式
						byte[] buff = new byte[2048];
						int len = 0;
						while ((len = inputStream.read(buff)) > 0) {
							os.write(buff, 0, len);
						}
						os.close();
						inputStream.close();
					} catch (Exception ex) {
						log.error(StringHelper.format("写入同步文件发生异常，%1$s", ex.getMessage()), ex);
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
					continue;
				}
			}

		} catch (Exception ex) {
			log.error(StringHelper.format("接收消息出现异常，%1$s", ex.getMessage()), ex);
			closeMessageConsumer();
			throw ex;
		}
	}
}
