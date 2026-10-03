package net.ibizsys.psop.zookeeper;

import org.apache.zookeeper.ZooKeeper;

/**
 * ZooKeeper对象接口
 * @author Administrator
 *
 */
public  interface IPSZooKeeper
{
	
	/**
	 * 获取ZooKeeper对象
	 * @return
	 */
	ZooKeeper getZooKeeper();
	
	
	
	/**
	 * 获取域名称
	 * @return
	 */
	String getDomain();
	
	

	
	
	
	/**
	 * 处理异常
	 * @param iPSObjectKeeper
	 * @param ex
	 * @return
	 * @throws Exception
	 */
	boolean dealException(IPSObjectKeeper iPSObjectKeeper,Exception ex) throws Exception;
	
	
	/**
	 * 是否已经连接 
	 * @return
	 */
	boolean isConnected();
	
}