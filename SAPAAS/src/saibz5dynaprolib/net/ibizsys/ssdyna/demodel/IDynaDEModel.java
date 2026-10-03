package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.saas.demodel.ISaaSDEModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * 动态实体模型接口
 * @author Administrator
 *
 * @param <ET>
 */
public interface IDynaDEModel<ET extends IEntity> extends ISaaSDEModel<ET> {

	
	/**
	 * 初始化
	 * @param iDynaSysModel
	 * @param ipsDataEntity
	 * @throws Exception
	 */
	void init(IDynaSysModel iDynaSysModel,IPSDataEntity ipsDataEntity)throws Exception;
	
	
//	/**
//	 * 获取实体模型对象
//	 * @return
//	 */
//	IPSDataEntity getPSDataEntity();
	
	/**
	 * 获取动态系统模型
	 * @return
	 */
	IDynaSysModel getDynaSysModel();
	
	
	/**
	 * 是否为动态实体模板模式
	 * @return
	 */
	boolean isDynaDETemplMode();
	
	
}
