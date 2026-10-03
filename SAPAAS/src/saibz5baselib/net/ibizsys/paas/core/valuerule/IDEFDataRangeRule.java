package net.ibizsys.paas.core.valuerule;

/**
 * 属性数据范围规则接口
 * 
 * @author Administrator
 *
 */
public interface IDEFDataRangeRule extends IDEFValueRule {
	/**
	 * 实体数据集合
	 */
	static final String DATARANGE_DEDATASET = "DEDATASET";

	/**
	 * 获取 属性值规则实体结果集合
	 * 
	 * @return
	 */
	IDEFVRDEDataSet getDEFVRDEDataSet();
}
