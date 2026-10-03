package net.ibizsys.psop.zookeeper;

import java.util.HashMap;

public class PSTaskServerKeeper extends PSObjectKeeperBase {
	private static IPSUserKeeper iPSUserKeeper = null;
	private HashMap<String, String> userMap = new HashMap();
	public static final String strTaskServerPathPrefix = "/PSTASKSERVER/";
	private static final String strTaskServerPathPrefix2 = "/PSTASKSERVER";

	public PSTaskServerKeeper(IPSZooKeeper iPSZooKeeper) throws Exception {
		super(iPSZooKeeper);

		exists("/PSTASKSERVER", "".getBytes(), true, false);
	}
}