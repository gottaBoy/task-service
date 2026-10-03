package net.ibizsys.paas.log;

import java.util.ArrayList;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * 日志对象
 * 
 * @author Administrator
 * 
 */
public class JMSQueueAppender extends AppenderSkeleton implements Appender {
	public final static String SHUTDOWNCMD = "WebFilter destroy";

	public class TaskThread extends Thread {
		public TaskThread() {

		}

		@Override
		public void run() {
			while (isRunning()) {
				if (runTask())
					continue;
				else {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

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

	protected ArrayList<String> logList = new ArrayList<String>();
	protected ArrayList<String> logList2 = new ArrayList<String>();
	
	private Object objRunningLock = new Object();

	@Override
	public void close() {
		if (this.closed) return;

		this.closed = true;

		setRunning(false);

		closeMessageProducer();

		try {
			if (taskThread != null) taskThread.join();
		} catch (Exception ex) {

		}
		taskThread = null;
	}

	@Override
	public boolean requiresLayout() {
		return false;
	}

	@Override
	protected synchronized void append(LoggingEvent event) {
		if (!this.isRunning()) return;

		if (StringHelper.isNullOrEmpty(this.brokerUri)) return;

		try {
			appendLogList(getTextMessage(event));
		} catch (Exception ex) {
			if (StringHelper.compare(ex.getMessage(), SHUTDOWNCMD, true) == 0) {
				setRunning(false);
				closeMessageProducer();
			}
		}
	}

	/**
	 * 附加日志
	 * 
	 * @param strLogMessage
	 */
	protected void appendLogList(String strLogMessage) {
		synchronized (logList) {
			if (logList.size() > 1000) logList.clear();
			logList.add(strLogMessage);

			if (taskThread == null) {
				setRunning(true);
				taskThread = new TaskThread();
				taskThread.setName("PSSYSRUNLOGSERVICE");
				taskThread.start();
			}
		}

	}

	protected boolean runTask() {
		try {
			synchronized (logList) {
				logList2.addAll(logList);
				logList.clear();
			}

			if (logList2.size() == 0) return false;

			prepareMessageProducer();
			while (logList2.size() > 0 && this.isRunning()) {
				String strMessage = logList2.remove(0);
				TextMessage message = session.createTextMessage(strMessage);
				this.messageProducer.send(message);
			}
			return true;
		} catch (Exception e) {
			closeMessageProducer();
			e.printStackTrace();
			return false;
		}
	}

	protected void prepareMessageSession() throws Exception {
		if (session != null) return;

		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(this.getBrokerUri());
		Connection connection = factory.createConnection();

		connection.setClientID(this.getLoggerParam3());

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
			// log.error(StringHelper.format("关闭消息会话发生异常，%1$s",ex.getMessage()),ex);
		}
		session = null;

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception ex) {
			// log.error(StringHelper.Format("关闭消息会话发生异常，%1$s",ex.getMessage()),ex);
		}
		connection = null;

	}

	/**
	 * 准备链接
	 * 
	 * @throws Exception
	 */
	protected void prepareMessageProducer() throws Exception {
		if (messageProducer != null) return;

		prepareMessageSession();

		topic = session.createTopic(this.getTopicName());
		messageProducer = session.createProducer(topic);
		messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
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
			ex.printStackTrace();
			// log.error(StringHelper.Format("关闭消息发送者发生异常，%1$s",ex.getMessage()),ex);
		}
		messageProducer = null;

		topic = null;

		closeMessageSession();
	}

	protected boolean isRunning() {
		synchronized (this.objRunningLock) {
			return this.bRunning;
		}
	}

	/**
	 * @param bRunning
	 */
	protected void setRunning(boolean bRunning) {
		synchronized (this.objRunningLock) {
			this.bRunning = bRunning;
		}
	}

	public void setBrokerUri(String brokerUri) {
		this.brokerUri = brokerUri;
	}

	public String getBrokerUri() {
		return brokerUri;
	}

	public void setTopicName(String strTopicName) {
		this.strTopicName = strTopicName;
	}

	public String getTopicName() {
		return strTopicName;
	}

	protected String getTextMessage(LoggingEvent event) throws Exception {
		JSONObject jo = new JSONObject();

		if (!StringHelper.isNullOrEmpty(getLoggerType())) jo.put("type", this.getLoggerType());
		if (!StringHelper.isNullOrEmpty(getLoggerParam())) jo.put("param", this.getLoggerParam());
		if (!StringHelper.isNullOrEmpty(getLoggerParam2())) jo.put("param2", this.getLoggerParam2());
		if (!StringHelper.isNullOrEmpty(getLoggerParam3())) jo.put("param3", this.getLoggerParam3());
		if (!StringHelper.isNullOrEmpty(getLoggerParam4())) jo.put("param4", this.getLoggerParam4());
		jo.put("name", event.getLoggerName());
		jo.put("time", event.timeStamp);
		jo.put("level", event.getLevel().toString());
		jo.put("level2", event.getLevel().toInt());

		String strLogInfo = null;
		if (event.getMessage() != null) {
			if (event.getMessage() instanceof String) strLogInfo = (String) event.getMessage();
		}

		if (!StringHelper.isNullOrEmpty(strLogInfo)) {
			jo.put("info", strLogInfo);
			if (StringHelper.compare(strLogInfo, SHUTDOWNCMD, true) == 0) {
				throw new Exception(SHUTDOWNCMD);
			}
		}

		return jo.toString();
	}

	/**
	 * @return the strLoggerType
	 */
	public String getLoggerType() {
		return strLoggerType;
	}

	/**
	 * @param strLoggerType the strLoggerType to set
	 */
	public void setLoggerType(String strLoggerType) {
		this.strLoggerType = strLoggerType;
	}

	/**
	 * @return the strLoggerParam
	 */
	public String getLoggerParam() {
		return strLoggerParam;
	}

	/**
	 * @param strLoggerParam the strLoggerParam to set
	 */
	public void setLoggerParam(String strLoggerParam) {
		this.strLoggerParam = strLoggerParam;
	}

	/**
	 * @return the strLoggerParam2
	 */
	public String getLoggerParam2() {
		return strLoggerParam2;
	}

	/**
	 * @param strLoggerParam2 the strLoggerParam2 to set
	 */
	public void setLoggerParam2(String strLoggerParam2) {
		this.strLoggerParam2 = strLoggerParam2;
	}

	/**
	 * @return the strLoggerParam3
	 */
	public String getLoggerParam3() {
		return strLoggerParam3;
	}

	/**
	 * @param strLoggerParam3 the strLoggerParam3 to set
	 */
	public void setLoggerParam3(String strLoggerParam3) {
		this.strLoggerParam3 = strLoggerParam3;
	}

	/**
	 * @return the strLoggerParam4
	 */
	public String getLoggerParam4() {
		return strLoggerParam4;
	}

	/**
	 * @param strLoggerParam4 the strLoggerParam4 to set
	 */
	public void setLoggerParam4(String strLoggerParam4) {
		this.strLoggerParam4 = strLoggerParam4;
	}

}
