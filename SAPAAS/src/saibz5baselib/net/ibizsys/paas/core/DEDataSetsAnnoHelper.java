package net.ibizsys.paas.core;

import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;

/**
 * 数据对象集合集合注解辅助对象
 * 
 * @author lionlau
 *
 */
public class DEDataSetsAnnoHelper {

	private HashMap<String, DEDataSet> deDataSetMap = new HashMap<String, DEDataSet>();

	private DEDataSets dedatasets = null;

	public DEDataSetsAnnoHelper(DEDataSets dedatasets) {
		this.dedatasets = dedatasets;

		for (DEDataSet dedataset : this.dedatasets.value()) {
			deDataSetMap.put(dedataset.id(), dedataset);
			deDataSetMap.put(dedataset.name(), dedataset);
		}
	}

	/**
	 * 获取指定数据集合对象
	 * 
	 * @param strName
	 * @param bTry
	 * @return
	 * @throws Exception
	 */
	public DEDataSet getDEDataSet(String strName, boolean bTry) throws Exception {
		DEDataSet dedataset = deDataSetMap.get(strName);
		if (dedataset == null) {
			if (!bTry) {
				throw new Exception(StringHelper.format("无法获取数据集合[%1$s]", strName));
			}
		}

		return dedataset;
	}

}
