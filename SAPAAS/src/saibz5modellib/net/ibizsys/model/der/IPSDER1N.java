package net.ibizsys.model.der;

import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.paas.core.IDER1N;



/**
 * 实体1：N关系对象接口
 * @author Administrator
 *
 */
public interface IPSDER1N extends IPSDERBase,IDER1N
{
//	
//	/**
//	*	导出基本数据（只建立不更新）
//	*/
//	public final static int EXPORTMAJORMODEL_SIMPLE = 1 ;
	
	
	/**
	 * 获取拷贝关联
	 * @return
	 */
	boolean isCloneRS();
	
	
	
	
	/**
	 * 是否主从关系
	 * @return
	 */
	int getMasterRS();
//	
//	
//	
//	/**
//	 * 是否支持扩展限制
//	 * @return
//	 */
//	boolean isEnableExtRestrict();
//	
//	
//	
//	
//	/**
//	 * 获取限制的主实体属性标识
//	 * @return
//	 */
//	String getERMajorPSDEFId();
//	
//	
//	/**
//	 * 获取限制的主实体属性名称
//	 * @return
//	 */
//	String getERMajorPSDEFName() throws Exception;
//	
//	
//	/**
//	 * 获取限制的主实体属性
//	 * @return
//	 */
//	IPSDEField getERMajorPSDEF()throws Exception;
//	
//	
//	/**
//	 * 获取限制的从实体属性标识
//	 * @return
//	 */
//	String getERMinorPSDEFId();
//	
//	
//	/**
//	 * 获取限制的从实体属性名称
//	 * @return
//	 */
//	String getERMinorPSDEFName() throws Exception;
//	
//	/**
//	 * 获取限制的从实体属性
//	 * @return
//	 */
//	IPSDEField getERMinorPSDEF()throws Exception;
	
	
	/**
	 * 获取删除次序
	 * @return
	 */
	int getRemoveOrder();
	
	
	
	/**
	 * 获取同步删除类型
	 * @return
	 */
	int getRemoveActionType();
	
	
//	
//	
//	/**
//	 * 获取引用的结果集合编号
//	 * @return
//	 */
//	String getRefPSDEDataSetId();
//	
//	
//	
//	/**
//	 * 获取引用的结果集合编号
//	 * @return
//	 */
//	String getRefPSDEDataSetName() throws Exception;
//	
//	
//	
//	/**
//	 * 获取引用的自动填充编号
//	 * @return
//	 */
//	String getRefPSDEACModeId();
//	
//	
//	
//	/**
//	 * 获取引用的自动填充编号
//	 * @return
//	 */
//	String getRefPSDEACModeName() throws Exception;
//	
//	/**
//	 * 获取引用的自动填充对象
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEACMode getRefPSDEACMode() throws Exception;
//	
//	
//	/**
//	 * 获取引用的结果集合
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEDataSet getRefPSDEDataSet() throws Exception;
//	
//	
//	
//	/**
//	 * 是否启用外键
//	 * @return
//	 */
//	boolean isEnableFKey();
	
	
	/**
	 * 获取克隆的次序
	 * @return
	 */
	int getCloneOrder();
//	
//	
//	
//	
//	/**
//	 * 获取临时数据的次序
//	 * @return
//	 */
//	int getTempDataOrder();
//	
//	
//	
//	
//	/**
//	 * 获取引用的拾取视图编号
//	 * @return
//	 */
//	String getRefPickupPSDEViewId();
//	
//	
//	
//	/**
//	 * 获取引用的拾取视图名称
//	 * @return
//	 */
//	String getRefPickupPSDEViewName();
//	
//	
//	/**
//	 * 获取引用的多选视图编号
//	 * @return
//	 */
//	String getRefMPickupPSDEViewId();
//	
//	
//	
//	/**
//	 * 获取引用的多选视图名称
//	 * @return
//	 */
//	String getRefMPickupPSDEViewName();
//	
//	
//	
//	/**
//	 * 是否支持父关系等价
//	 * @return
//	 */
//	boolean isEnablePDEREQ();
//	
//	
//	
//	/**
//	 * 获取主实体的父关系
//	 * @return
//	 */
//	IPSDER1N  getMajorPPSDER1N() throws Exception;
//	
//	
//	/**
//	 * 获取从实体的父关系
//	 * @return
//	 */
//	IPSDER1N  getMinorPPSDER1N() throws Exception;
//	
//	
//	
	
	/**
	 * 获取拾取属性
	 * @return
	 * @throws Exception
	 */
	IPSPickupDEField getPSPickupDEField()throws Exception;
	
	
	
//	
//	/**
//	 * 获取导出模型次序
//	 * @return
//	 */
//	int getExportModelOrder();
//	
//	
//	/**
//	 * 是否同步导出模型
//	 * @return
//	 */
//	int getSyncExportModelMode();
//	
//	
//	/**
//	 * 获取外键名称
//	 * @return
//	 */
//	String getFKeyName();
//	
//	
//	
//	
//	/**
//	 * 获取引用的链接视图编号
//	 * @return
//	 */
//	String getRefLinkPSDEViewId();
//	
//	
//	
//	/**
//	 * 获取引用的链接视图名称
//	 * @return
//	 */
//	String getRefLinkPSDEViewName();
//	
//	
//	
//	
//	/**
//	 * 获取子数据XML标记名称
//	 * @return
//	 */
//	String getMinorXmlTagName();
//	
//	
//	
//	
//	
//	/**
//	 * 获取关系映射属性集合
//	 * @return
//	 */
//	java.util.Iterator<IPSDER1NDEFieldMap> getPSDER1NDEFieldMaps();
//	
//	
//	
//	/**
//	 * 获取计数属性MAP
//	 * @return
//	 */
//	IPSDER1NDEFieldMap getCountPSDER1NDEFieldMap();
//	
//	
//	
//	/**
//	 * 获取属性映射的查询名称集合
//	 * @return
//	 */
//	java.util.Iterator<String> getPSDER1NDEFieldMapQueryNames();
//	
//	
//	
//	/**
//	 * 获取导出主模型关系
//	 * @return
//	 */
//	int getExportMajorModel();
	
}
