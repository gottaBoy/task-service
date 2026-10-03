package net.ibizsys.paas.datasync;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.IDEDataSyncIn;

/**
 * 数据同步全局对象
 * 
 * @author lionlau
 *
 */
public class DataSyncGlobal {
	private static final Log log = LogFactory.getLog(DataSyncGlobal.class);
	private static HashMap<String, ArrayList<IDEDataSyncIn>> deDataSyncListMap = new HashMap<String, ArrayList<IDEDataSyncIn>>();

	/**
	 * 注册实体数据输入
	 * 
	 * @param iDEDataSyncIn
	 */
	public static void registerDEDataSyncIn(IDEDataSyncIn iDEDataSyncIn) {
		java.util.Iterator<String> deNames = iDEDataSyncIn.getDENames();
		if (deNames == null) {
			String strDEName = iDEDataSyncIn.getDataEntity().getName();
			ArrayList<IDEDataSyncIn> deDataSyncList = null;
			synchronized (deDataSyncListMap) {
				deDataSyncList = deDataSyncListMap.get(strDEName);
				if (deDataSyncList == null) {
					deDataSyncList = new ArrayList<IDEDataSyncIn>();
					deDataSyncListMap.put(strDEName, deDataSyncList);
				}
			}
			deDataSyncList.add(iDEDataSyncIn);
		} else {
			while (deNames.hasNext()) {
				String strDEName = deNames.next();
				ArrayList<IDEDataSyncIn> deDataSyncList = null;
				synchronized (deDataSyncListMap) {
					deDataSyncList = deDataSyncListMap.get(strDEName);
					if (deDataSyncList == null) {
						deDataSyncList = new ArrayList<IDEDataSyncIn>();
						deDataSyncListMap.put(strDEName, deDataSyncList);
					}
				}
				deDataSyncList.add(iDEDataSyncIn);
			}
		}

	}

	/**
	 * 通过输入数据实体名称获取相关数据同步（输入）集合
	 * 
	 * @param strDEName
	 * @return
	 */
	public static java.util.Iterator<IDEDataSyncIn> getDEDataSyncIns(String strDEName) {
		ArrayList<IDEDataSyncIn> deDataSyncList = null;
		synchronized (deDataSyncListMap) {
			deDataSyncList = deDataSyncListMap.get(strDEName);

		}
		if (deDataSyncList == null) return null;
		return deDataSyncList.iterator();
	}

}
