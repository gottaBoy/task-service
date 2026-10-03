package net.ibizsys.psop.zookeeper;

import java.util.HashMap;
import java.util.Properties;

import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;

/**
 * 云平台ZooKeeper实现对象
 * @author Administrator
 *
 */
public class PSZooKeeper implements IPSZooKeeper {
	
	private static final Log log = LogFactory.getLog(PSZooKeeper.class);
	private static IPSZooKeeper iPSZooKeeper = null;
	private static HashMap<String, IPSZooKeeper> psZooKeeperCatMap = new HashMap<String, IPSZooKeeper>();
	private int sessionTimeout = 3000;
	private ZooKeeper zk = null;
	private Properties cfg = new Properties();
	private String strDomain = "/PS";
	private static Object objPSZooKeeperLock = new Object();

	
	public PSZooKeeper() throws Exception {
		this.cfg.load(PSZooKeeper.class.getClassLoader().getResourceAsStream("saps-zookeeper.properties"));
		this.strDomain =  PropertiesHelper.getProperty(this.cfg, "zookeeper.domain",strDomain);
		open();
	}

	public void open() throws Exception {
		String strHosts = PropertiesHelper.getProperty(this.cfg, "zookeeper.hosts");
		if (StringHelper.isNullOrEmpty(strHosts)) {
			throw new Exception("没有定义ZooKeeper主机");
		}

		ZooKeeper zk = new ZooKeeper(strHosts, this.sessionTimeout, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				processEvent(event);
			}
		});

		Stat stat = zk.exists(strDomain,null);
		if (stat == null) {
			zk.create(strDomain, new String("").getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			log.debug(StringHelper.format("建立路径[%1$s]成功", strDomain));
		}
		this.zk = zk;
	}
	
	public void close() {
		if (this.zk != null) {
			try {
				this.zk.close();
				log.info("释放ZooKeeper连接成功！");
			} catch (InterruptedException e) {
				log.error(e);
			}
			this.zk = null;
		}
	}
	
	/**
	 * 重新连接
	 * @return
	 */
	protected synchronized boolean reopen(){
		
		try{
			final ZooKeeper zk = this.zk;
			if(zk!=null){
				if(zk.getState() == States.CONNECTED || zk.getState() == States.CONNECTEDREADONLY)
					return true;
			}
			
			close();
			open();
			return true;
		}
		catch(Exception ex){
			log.error(ex);
			return false;
		}
	}

	protected void processEvent(WatchedEvent event) {
		if ((event.getType() == null) || ("".equals(event.getType()))) {
			return;
		}

		if (event.getPath() != null) {
			log.debug("ZooKeeper 已经触发了[" + event.getPath() + "] " + event.getType() + "事件！");
		} else{
			log.debug("ZooKeeper 已经触发了" + event.getType() + "事件！");

			if(event.getState()!=null){
				log.debug("ZooKeeper 状态[" + event.getState()  + "]");
				if(event.getState() ==  KeeperState.Disconnected){
					return;
				}
				if(event.getState() ==  KeeperState.Expired){
					reopen();					
					return;
				}
				if(event.getState() ==  KeeperState.ConnectedReadOnly){
					return;
				}
			}
		}
	}

	public ZooKeeper getZooKeeper() {
		return this.zk;
	}

	public static  IPSZooKeeper getCurrent() throws Exception {
		if (iPSZooKeeper == null) {
			PSZooKeeper psZooKeeper = new PSZooKeeper();
			synchronized(objPSZooKeeperLock){
				if(iPSZooKeeper==null)
					iPSZooKeeper = psZooKeeper;
			}
		}

		return iPSZooKeeper;
	}
	
	public static IPSZooKeeper getInstance(String strCat) throws Exception {
		if(StringHelper.isNullOrEmpty(strCat)){
			return getCurrent();
		}
		else{
			IPSZooKeeper psZooKeeper = psZooKeeperCatMap.get(strCat);
			if(psZooKeeper == null){
				psZooKeeper = new PSZooKeeper();
				synchronized(psZooKeeperCatMap){
					IPSZooKeeper psZooKeeper2 = psZooKeeperCatMap.get(strCat);
					if(psZooKeeper2!=null){
						psZooKeeper = psZooKeeper2;
					}
					else
						psZooKeeperCatMap.put(strCat, psZooKeeper);
				}
				
			}
			return psZooKeeper;
		}
	}

	@Override
	public String getDomain() {
		return this.strDomain;
	}

	@Override
	public boolean dealException(IPSObjectKeeper iPSObjectKeeper, Exception ex) throws Exception {
		
		log.error(StringHelper.format("[%1$s]发生异常",iPSObjectKeeper.toString(),ex.getMessage()),ex);
		if(ex instanceof KeeperException.BadVersionException){
			//数据不一致
		}
		
		if(ex instanceof KeeperException.SessionExpiredException){
			//会话过期
		}
		
		if(ex instanceof KeeperException.ConnectionLossException){
			//连接丢失
		}
		
		throw new Exception("云平台协同发生异常，请联系管理员或稍后重试");
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psop.zookeeper.IPSZooKeeper#isConnected()
	 */
	@Override
	public boolean isConnected() {
		final ZooKeeper zk = this.zk;
		if(zk!=null){
			if(zk.getState() == States.CONNECTED || zk.getState() == States.CONNECTEDREADONLY)
				return true;
		}
		return false;
	}
	
	
	
	
}