package net.ibizsys.paas.demodel;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;

/**
 * 动态实体模型接口
 * 
 * @author Administrator
 *
 * @param <ET>
 */
public interface IDynamicDEModel<ET extends IEntity> extends IDataEntityModel<ET> {
	/**
	 * 初始化
	 * 
	 * @param iSystemModel
	 * @param dataEntity
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel, DataEntity dataEntity) throws Exception;
}
