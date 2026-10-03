package net.ibizsys.model.der;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.paas.core.IDERBase;


/**
 * 实体关系接口基对象接口
 * @author Administrator
 *
 */
public interface IPSDERBase extends IPSModelObject,IDERBase
{
		
	
	
	/**
	 * 获取主实体
	 * @return
	 */
	IPSDataEntity getMajorPSDataEntity();
	
	
	
	
	/**
	 * 获取关系实体
	 * @return
	 */
	IPSDataEntity getMinorPSDataEntity();
	
	
	
	
	/**
	 * 获取主实体
	 * @return
	 */
	String getMajorPSDEId();
	
	
	
	
	/**
	 * 获取关系实体
	 * @return
	 */
	String getMinorPSDEId();
	
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	
	
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getMinorCodeName();
	
	
	
	
	
	
	
	/**
	 * 获取关系逻辑名称
	 * @return
	 */
	String getLogicName();
	
	
	
	
	/**
	 * 获取关系次序
	 * @return
	 */
	int getOrderValue();
	
	
	
}
