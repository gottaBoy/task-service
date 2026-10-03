package net.ibizsys.paas.core;

import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;

/**
 * 实体查询注解辅助对象
 * 
 * @author lionlau
 *
 */
public class DEDataQueriesAnnoHelper {

	private HashMap<String, DEDataQuery> deDataQueryMap = new HashMap<String, DEDataQuery>();

	private DEDataQueries dedataqueries = null;

	public DEDataQueriesAnnoHelper(DEDataQueries dedataqueries) {
		this.dedataqueries = dedataqueries;

		for (DEDataQuery dedataquery : this.dedataqueries.value()) {
			deDataQueryMap.put(dedataquery.id(), dedataquery);
		}
	}

	/**
	 * 获取数据查询注解
	 * 
	 * @param strName
	 * @param strDBType
	 * @param bTry
	 * @return
	 * @throws Exception
	 */
	public DEDataQuery getDEDataQuery(String strName, String strDBType, boolean bTry) throws Exception {
		String strFullName = StringHelper.format("%1$s_%2$s", strName, strDBType);
		DEDataQuery dedataquery = deDataQueryMap.get(strFullName);
		if (dedataquery == null) {
			if (!bTry) {
				throw new Exception(StringHelper.format("无法获取数据查询[%1$s]", strFullName));
			}
		}

		return dedataquery;
	}
}
