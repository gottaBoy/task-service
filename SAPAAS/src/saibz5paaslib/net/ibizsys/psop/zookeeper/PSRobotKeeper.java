package net.ibizsys.psop.zookeeper;

import java.sql.Timestamp;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;


/**
 * 云平台机器人管理对象
 * @author Administrator
 *
 */
public class PSRobotKeeper extends PSObjectKeeperBase implements IPSRobotKeeper {
	private static final Log log = LogFactory.getLog(PSObjectKeeperBase.class);
	public static final String strRobotPathPrefix = "/PSROBOT/";
	private static final String strRobotPathPrefix2 = "/PSROBOT";

	private String strPSTaskServerId = null;
	private String strPSRobotId = null;
	private String strWorkInfo = "";
	private String strRunPSTaskServerId = null;
	private long nLastRunTime = 0L;
	private String strRunWorkInfo = null;
	private String strRobotPath = null;
	private String strRobotEnergyPath = null;
	private int nLastVerion = 0;
	private int nLastEnergy = 0;
	private long nLastCalcTime = 0L;
	private int nMaxEnergy = 0;
	private int nMaxExtEnergy = 0;
	private int nExtEnergy = 0;
	private float fEnergyRate = 1.0F;
	private String strRobotName = null;
	private long nLastActiveTime = 0L;
	private int nOrderValue = 99999999;
	private int nRobotLevel = 1;

	public PSRobotKeeper(IPSZooKeeper iPSZooKeeper, String strPSRobotId, String strPSTaskServerId, IEntity psRobot) throws Exception {
		super(iPSZooKeeper);

		this.strPSRobotId = strPSRobotId;
		this.strPSTaskServerId = strPSTaskServerId;
		if (StringHelper.isNullOrEmpty(strPSTaskServerId)) {
			throw new Exception("机器人当前任务服务器没有指定");
		}

		this.strRobotName = DataObject.getStringValue(psRobot.get("psrobotname"));

		exists(iPSZooKeeper.getDomain() + strRobotPathPrefix2, "".getBytes(), true, false);
		this.strRobotPath = StringHelper.format("%1$s%2$s%3$s",iPSZooKeeper.getDomain(),strRobotPathPrefix, strPSRobotId);
		Stat stat = exists(this.strRobotPath, "".getBytes(), true);
		this.nLastVerion = stat.getVersion();
		stop();

		this.strRobotEnergyPath = StringHelper.format("%1$s/ENERGY", this.strRobotPath);

		this.nLastEnergy = DataObject.getIntegerValue(psRobot.get("lastenergy"), Integer.valueOf(this.nLastEnergy)).intValue();
		this.nMaxEnergy = DataObject.getIntegerValue(psRobot.get("maxenergy"), Integer.valueOf(this.nMaxEnergy)).intValue();
		this.nExtEnergy = DataObject.getIntegerValue(psRobot.get("lextenergy"), Integer.valueOf(this.nExtEnergy)).intValue();
		this.nMaxExtEnergy = DataObject.getIntegerValue(psRobot.get("maxextenergy"), Integer.valueOf(this.nMaxExtEnergy)).intValue();
		this.nOrderValue = DataObject.getIntegerValue(psRobot.get("ordervalue"), Integer.valueOf(this.nOrderValue)).intValue();
		this.nRobotLevel = DataObject.getIntegerValue(psRobot.get("level"), Integer.valueOf(this.nRobotLevel)).intValue();
		this.fEnergyRate = DataObject.getFloatValue(psRobot, "energyrate", this.fEnergyRate).floatValue();
		Timestamp lastTime = DataObject.getTimestampValue(psRobot, "lastcalctime", null);
		if (lastTime != null) {
			this.nLastCalcTime = lastTime.getTime();
		} else {
			this.nLastCalcTime = System.currentTimeMillis();
		}

		stat = exists(this.strRobotEnergyPath, getPSRobotEnergy(), true);
		updatePSRobotEnergy();
	}

	public synchronized boolean start() throws Exception {
		try {
			updatePSRobotInfo();
			if ((!(StringHelper.isNullOrEmpty(this.strRunPSTaskServerId))) && (System.currentTimeMillis() - this.nLastRunTime < 120000L)) {
				return false;
			}

			setData(this.strRobotPath, getPSRobotInfo(), this.nLastVerion);
			return true;
		} catch (Exception e) {
			log.error(e);
		}
		return false;
	}

	public synchronized void stop() throws Exception {
		try {
			updatePSRobotInfo();
			if (StringHelper.compare(this.strRunPSTaskServerId, this.strPSTaskServerId, true) != 0)
				return;
			setData(this.strRobotPath, "".getBytes(), this.nLastVerion);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void setRunWork(String strWorkInfo) {
		this.strRunWorkInfo = strWorkInfo;
	}

	public void close() {
	}

	public synchronized byte[] getPSRobotInfo() throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("taskserverid", this.strPSTaskServerId);
		jo.put("workinfo", this.strWorkInfo);
		jo.put("activetime", System.currentTimeMillis());
		return jo.toString().getBytes("UTF-8");
	}

	public synchronized byte[] getPSRobotEnergy() throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("maxenergy", this.nMaxEnergy);
		jo.put("lastenergy", this.nLastEnergy);
		jo.put("maxextenergy", this.nMaxExtEnergy);
		jo.put("extenergy", this.nExtEnergy);
		jo.put("lastcalctime", this.nLastCalcTime);
		jo.put("energyrate", this.fEnergyRate);
		jo.put("level", this.nRobotLevel);
		jo.put("ordervalue", this.nOrderValue);
		return jo.toString().getBytes("UTF-8");
	}

	protected synchronized void updatePSRobotInfo() throws Exception {
		Stat stat = new Stat();
		byte[] bytes = getData(this.strRobotPath, stat);
		JSONObject jo = null;
		if ((bytes != null) && (bytes.length != 0))
			jo = JSONObject.fromString(new String(bytes, "UTF-8"));

		this.nLastVerion = stat.getVersion();
		if (jo == null) {
			this.strRunPSTaskServerId = null;
			this.nLastRunTime = 0L;
		} else {
			this.strRunPSTaskServerId = jo.optString("taskserverid");
			this.nLastRunTime = jo.optLong("activetime");
		}

		log.debug(StringHelper.format("平台机器人[%1$s]运行变化:[%2$s]", this.strRobotName, this.strRunPSTaskServerId));
	}

	protected synchronized void updatePSRobotEnergy() throws Exception {
		Stat stat = new Stat();
		byte[] bytes = getData(this.strRobotEnergyPath, stat);
		JSONObject jo = null;
		if ((bytes != null) && (bytes.length != 0)) {
			jo = JSONObject.fromString(new String(bytes, "UTF-8"));
		}

		if (jo != null) {
			this.nMaxEnergy = jo.optInt("maxenergy");
			this.nLastEnergy = jo.optInt("lastenergy");
			this.nMaxExtEnergy = jo.optInt("maxextenergy");
			this.nExtEnergy = jo.optInt("extenergy");
			this.nRobotLevel = jo.optInt("level");
			this.nOrderValue = jo.optInt("ordervalue");
			this.nLastCalcTime = jo.optLong("lastcalctime");
			this.fEnergyRate = (float) jo.optDouble("energyrate");
			log.debug(StringHelper.format("平台机器人[%1$s]能量变化", this.strRobotName));
		}
	}

	protected void onProcessEvent(WatchedEvent event) throws Exception {
		super.onProcessEvent(event);
		if (StringHelper.isNullOrEmpty(event.getType())) {
			return;
		}

		if (event.getType() == Watcher.Event.EventType.NodeCreated) {
			return;
		}

		if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {
			if (StringHelper.compare(event.getPath(), this.strRobotPath, true) == 0) {
				updatePSRobotInfo();
				return;
			}
			if (StringHelper.compare(event.getPath(), this.strRobotEnergyPath, true) == 0) {
				updatePSRobotEnergy();
				return;
			}
			return;
		}

		if (event.getType() == Watcher.Event.EventType.NodeDeleted)
			return;
	}

	public synchronized int getCurrentEnergy() throws Exception {
		int nEnergy = (int) ((float) ((System.currentTimeMillis() - this.nLastCalcTime) / 1000L) * this.fEnergyRate) + this.nLastEnergy;
		int nCurExtEnergy = this.nExtEnergy;
		if(nCurExtEnergy>nMaxExtEnergy){
			nCurExtEnergy = nMaxExtEnergy;
		}
		if (nEnergy > this.nMaxEnergy)
			return this.nMaxEnergy + nCurExtEnergy;
		return nEnergy + nCurExtEnergy;
	}

	public synchronized String getRunPSTaskServerId() {
		if ((!(StringHelper.isNullOrEmpty(this.strRunPSTaskServerId))) && (System.currentTimeMillis() - this.nLastRunTime > 120000L)) {
			this.strRunPSTaskServerId = null;
			log.debug(StringHelper.format("平台机器人[%1$s]在约定时间内没有接收到占用任务服务器激活信息，取消占位", this.strRobotName));
		}

		return this.strRunPSTaskServerId;
	}

	public synchronized float getEnergyRate() {
		return this.fEnergyRate;
	}
	
	public synchronized int getOrderValue() {
		return this.nOrderValue;
	}
	
	public synchronized int getRobotLevel() {
		return this.nRobotLevel;
	}

	public static void updatePSRobotEnergy(IEntity psRobot) throws Exception {
		IPSZooKeeper iPSZooKeeper = PSZooKeeper.getCurrent();
		if (exists(iPSZooKeeper.getZooKeeper(),iPSZooKeeper.getDomain()+ "/PSROBOT", "".getBytes(), false) == null) {
			return;
		}
		String strPSRobotId = DataObject.getStringValue(psRobot.get("psrobotid"));
		String strRobotPath = StringHelper.format("%1$s%2$s%3$s",iPSZooKeeper.getDomain(), strRobotPathPrefix, strPSRobotId);
		if (exists(iPSZooKeeper.getZooKeeper(), strRobotPath, "".getBytes(), false) == null) {
			return;
		}

		String strRobotEnergyPath = StringHelper.format("%1$s/ENERGY", strRobotPath);
		if (exists(iPSZooKeeper.getZooKeeper(), strRobotEnergyPath, "".getBytes(), false) == null)
		{
			return;
		}

		int nLastEnergy = DataObject.getIntegerValue(psRobot.get("lastenergy"), Integer.valueOf(0)).intValue();
		int nMaxEnergy = DataObject.getIntegerValue(psRobot.get("maxenergy"), Integer.valueOf(0)).intValue();
		int nMaxExtEnergy = DataObject.getIntegerValue(psRobot.get("maxextenergy"), Integer.valueOf(0)).intValue();
		int nExtEnergy = DataObject.getIntegerValue(psRobot.get("extenergy"), Integer.valueOf(0)).intValue();
		int nOrderValue = DataObject.getIntegerValue(psRobot.get("ordervalue"), Integer.valueOf(999999999)).intValue();
		int nRobotLevel = DataObject.getIntegerValue(psRobot.get("level"), Integer.valueOf(1)).intValue();
		float fEnergyRate = DataObject.getFloatValue(psRobot, "energyrate", 1.0F).floatValue();
		Timestamp lastTime = DataObject.getTimestampValue(psRobot, "lastcalctime", null);

		JSONObject jo = new JSONObject();
		jo.put("maxenergy", nMaxEnergy);
		jo.put("lastenergy", nLastEnergy);
		jo.put("maxextenergy", nMaxExtEnergy);
		jo.put("extenergy", nExtEnergy);
		jo.put("ordervalue", nOrderValue);
		jo.put("level", nRobotLevel);
		jo.put("lastcalctime", lastTime.getTime());
		jo.put("energyrate", fEnergyRate);
		byte[] data = jo.toString().getBytes("UTF-8");
		setData(iPSZooKeeper.getZooKeeper(), strRobotEnergyPath, data, -1);
	}

	public synchronized void active() throws Exception {
		if (StringHelper.compare(this.strPSTaskServerId, getRunPSTaskServerId(), false) == 0) {
			long nCurTime = System.currentTimeMillis();
			if (nCurTime - this.nLastActiveTime > 20000L)
				try {
					updatePSRobotInfo();
					if (StringHelper.compare(this.strRunPSTaskServerId, this.strPSTaskServerId, true) == 0)
						setData(this.strRobotPath, getPSRobotInfo(), this.nLastVerion);

					this.nLastActiveTime = nCurTime;
				} catch (Exception e) {
					log.error(e);
				}
		}
	}
}