package net.ibizsys.psop.zookeeper;

import net.ibizsys.paas.util.StringHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * 管理器基类
 * 
 * @author Administrator
 *
 */
public abstract class PSObjectKeeperBase  implements IPSObjectKeeper {
	private static final Log log = LogFactory.getLog(PSObjectKeeperBase.class);
	private IPSZooKeeper iPSZooKeeper = null;
	private boolean bClose = false;
//	private long nZooKeeperOpenTime = 0l;

	public PSObjectKeeperBase(IPSZooKeeper iPSZooKeeper) throws Exception {
		this.iPSZooKeeper = iPSZooKeeper;
//		this.nZooKeeperOpenTime = iPSZooKeeper.getOpenTime();
	}

	protected IPSZooKeeper getPSZooKeeper() {
		return this.iPSZooKeeper;
	}

	protected void processEvent(WatchedEvent event) {
		if (event.getType() != Watcher.Event.EventType.NodeDeleted){
			if(isClose())
				return;
			
			try {
				if (!StringHelper.isNullOrEmpty(event.getPath())) {
					getZooKeeper().exists(event.getPath(), new Watcher() {
						@Override
						public void process(WatchedEvent event) {
							processEvent(event);
						}
					});
				}
			} catch (Exception ex) {
				log.error(ex);
			}

		try {
			if (event.getPath() != null) {
				log.debug("已经触发了[" + event.getPath() + "] " + event.getType() + "事件！");
			} else {
				log.debug("已经触发了[未知路径] " + event.getType() + "事件！");
			}

			onProcessEvent(event);
		} catch (Exception ex) {
			log.error(ex);
		}
		}
		else{
			log.debug("已经触发了[" + event.getPath() + "] " + event.getType() + "事件！");
		}
	}

	protected void onProcessEvent(WatchedEvent event) throws Exception {
	}

	protected ZooKeeper getZooKeeper() {
		return getPSZooKeeper().getZooKeeper();
	}

	protected Stat exists(String strPath, byte[] data, boolean bCreateIfNotExists) throws KeeperException, InterruptedException {
		return exists(strPath, data, bCreateIfNotExists, true);
	}

	protected Stat exists(String strPath, byte[] data, boolean bCreateIfNotExists, boolean bListen) throws KeeperException, InterruptedException {
		Stat stat = getZooKeeper().exists(strPath, (bListen) ? new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				processEvent(event);
			}
		} : null);
		if ((stat == null) && (bCreateIfNotExists)) {
			getZooKeeper().create(strPath, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			log.debug(StringHelper.format("建立路径[%1$s]成功", strPath));
			return getZooKeeper().exists(strPath, (bListen) ? new Watcher() {
				@Override
				public void process(WatchedEvent event) {
					processEvent(event);
				}
			} : null);
		}
		return stat;
	}

	public static Stat exists(ZooKeeper zooKeeper, String strPath, byte[] data, boolean bCreateIfNotExists) throws KeeperException, InterruptedException {
		Stat stat = zooKeeper.exists(strPath, null);
		if ((stat == null) && (bCreateIfNotExists)) {
			zooKeeper.create(strPath, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			log.debug(StringHelper.format("建立路径[%1$s]成功", strPath));
			return zooKeeper.exists(strPath, null);
		}
		return stat;
	}

	protected Stat setData(String strPath, byte[] data) throws KeeperException, InterruptedException {
		return getZooKeeper().setData(strPath, data, -1);
	}

	protected Stat setData(String strPath, byte[] data, int nVersion) throws Exception {
		try{
			return getZooKeeper().setData(strPath, data, nVersion);
		}
		catch (Exception ex) {
			if(getPSZooKeeper().dealException(this, ex)){
				return getZooKeeper().setData(strPath, data, nVersion);
			}
			throw ex;
		}
	}

	public static Stat setData(ZooKeeper zooKeeper, String strPath, byte[] data, int nVersion) throws KeeperException, InterruptedException {
		try{
			return zooKeeper.setData(strPath, data, nVersion);
		}
		catch (Exception ex) {
			throw ex;
		}
	}

	protected byte[] getData(String strPath, Stat stat) throws Exception {
		try{
			return getZooKeeper().getData(strPath, false, stat);
		}
		catch (Exception ex) {
			if(getPSZooKeeper().dealException(this, ex)){
				return getData(strPath, stat);
			}
			throw ex;
		}
	}
	
	
	public void close(){
		this.bClose  = true;
	}
	
	/**
	 * 判断节点是否关闭
	 * @return
	 */
	public boolean isClose(){
		return this.bClose;
	}
	
	
}