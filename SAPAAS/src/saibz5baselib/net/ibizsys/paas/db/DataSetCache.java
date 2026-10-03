package net.ibizsys.paas.db;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.StringHelper;

/**
 * 数据集合缓存
 * 
 * @author Administrator
 *
 */
public class DataSetCache {
	private static final Log log = LogFactory.getLog(DataSetCache.class);

	private static ThreadLocal<ArrayList<IDataSet>> dataSetMap = new ThreadLocal<ArrayList<IDataSet>>();

	/**
	 * 启用当前
	 * 
	 * @throws Exception
	 */
	public static void enableCurrent() {
		ArrayList<IDataSet> curList = dataSetMap.get();
		if (curList != null) return;

		dataSetMap.set(new ArrayList<IDataSet>());
	}

	/**
	 * 释放当前
	 * 
	 * @throws Exception
	 */
	public static void resetCurrent() {
		ArrayList<IDataSet> curList = dataSetMap.get();
		if (curList != null) {
			dataSetMap.set(null);
			for (IDataSet iDataSet : curList) {
				log.warn(StringHelper.format("结果集合没有释放\r\n%1$s\r\n", iDataSet.getSqlInfo()));
				try {
					iDataSet.close();
				} catch (Exception ex) {

				}
			}
			curList.clear();
		}
	}

	/**
	 * 注册结果集合
	 * 
	 * @param iDataSet
	 */
	public static void register(IDataSet iDataSet) {
		ArrayList<IDataSet> curList = dataSetMap.get();
		if (curList == null || iDataSet == null) return;

		curList.add(iDataSet);
	}

	/**
	 * 注销结果集合
	 * 
	 * @param iDataSet
	 */
	public static void unregister(IDataSet iDataSet) {
		ArrayList<IDataSet> curList = dataSetMap.get();
		if (curList == null || iDataSet == null) return;

		curList.remove(iDataSet);
	}
}
