package net.ibizsys.psop.zookeeper;

import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

public class PSUserKeeper extends PSObjectKeeperBase implements IPSUserKeeper {
	private static IPSUserKeeper iPSUserKeeper = null;
	private HashMap<String, String> userMap = new HashMap();
	public static final String strUserPathPrefix = "/PSUSER/";
	private static final String strUserPathPrefix2 = "/PSUSER";

	public PSUserKeeper(IPSZooKeeper iPSZooKeeper) throws Exception {
		super(iPSZooKeeper);

		exists("/PSUSER", "".getBytes(), true, false);
	}

	public void loginUser(String strUserId, String strSessionId) throws Exception {
		String strUserPath = StringHelper.format("%1$s%2$s", "/PSUSER/", strUserId);
		Stat stat = exists(strUserPath, "".getBytes(), true);
		setData(strUserPath, strSessionId.getBytes("UTF-8"));
	}

	public void logoutUser(String strUserId, String strSessionId) throws Exception {
		String strUserPath = StringHelper.format("%1$s%2$s", "/PSUSER/", strUserId);
		Stat stat = exists(strUserPath, "".getBytes(), false);
		if (stat == null)
			return;

		byte[] data = getData(strUserPath, stat);
		if (data == null) {
			return;
		}

		String strLastSessionId = new String(data, "UTF-8");
		if (StringHelper.compare(strLastSessionId, strSessionId, true) == 0) {
			setData(strUserPath, "".getBytes());
		}
	}

	public boolean activeUser(String strUserId, String strSessionId) throws Exception {
		String strUserPath = StringHelper.format("%1$s%2$s", "/PSUSER/", strUserId);
		String strCurSessionId = null;
		synchronized (this.userMap) {
			strCurSessionId = (String) this.userMap.get(strUserPath);
		}
		return (StringHelper.compare(strCurSessionId, strSessionId, false) == 0);
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
			byte[] data = getData(event.getPath(), null);
			String strSessionId = null;
			if (data != null) {
				strSessionId = new String(data, "UTF-8");
			}

			synchronized (this.userMap) {
				this.userMap.put(event.getPath(), strSessionId);
			}
			return;
		}

		if (event.getType() == Watcher.Event.EventType.NodeDeleted) {
			synchronized (this.userMap) {
				this.userMap.remove(event.getPath());
			}
			return;
		}
	}

	public static synchronized IPSUserKeeper getCurrent() throws Exception {
		if (iPSUserKeeper == null) {
			PSUserKeeper PSUserKeeper = new PSUserKeeper(PSZooKeeper.getCurrent());
			iPSUserKeeper = PSUserKeeper;
		}

		return iPSUserKeeper;
	}
}