package net.ibizsys.model.der;

import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.field.IPSDEField;


/**
 * 实体关系(1:N)属性映射接口
 * 
 * @author Administrator
 *
 */
public interface IPSDER1NDEFieldMap extends IPSDERDEFieldMap {

	/**
	 * 关系属性映射：摘要
	 */
	public final static String MAPTYPE_DIGEST = "DIGEST";

	/**
	 * 关系属性映射：合计
	 */
	public final static String MAPTYPE_SUM = "SUM";

	/**
	 * 关系属性映射：平均
	 */
	public final static String MAPTYPE_AVG = "AVG";

	/**
	 * 关系属性映射：最大值
	 */
	public final static String MAPTYPE_MAX = "MAX";

	/**
	 * 关系属性映射：最小值
	 */
	public final static String MAPTYPE_MIN = "MIN";

	/**
	 * 关系属性映射：计数
	 */
	public final static String MAPTYPE_COUNT = "COUNT";

	/**
	 * 获取映射类型，具体参考
	 * SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NDEFieldMap.MAPTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getMapType();

	/**
	 * 获取主实体属性对象
	 * 
	 * @return
	 */
	IPSDEField getMajorPSDEField() throws Exception;

	/**
	 * 获取从实体属性对象
	 * 
	 * @return
	 */
	IPSDEField getMinorPSDEField() throws Exception;

	/**
	 * 获取1:N关系对象
	 * 
	 * @return
	 */
	IPSDER1N getPSDER1N();

	/**
	 * 获取从实体的查询
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSDEDataQuery getMinorPSDEDataQuery() throws Exception;

	/**
	 * 获取从实体的数据查询标识
	 * 
	 * @return
	 */
	String getMinorPSDEDataQueryId();
}
