package net.ibizsys.ssdyna.sysmodel;

import org.hibernate.SessionFactory;

import net.ibizsys.model.IPSModelStorage;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.ssdyna.core.IDynaDETemplModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.service.IDynaService;

/**
 * 动态系统模型对象
 * @author Administrator
 *
 */
public interface IDynaSysModel extends net.ibizsys.saas.sysmodel.ISaaSSystemModel,ISystemRuntime {

	/**
	 * 获取模型存储对象
	 * @return
	 */
	IPSModelStorage getDynaModelStorage();
	
	
	/**
	 * 获取系统模型对象
	 * @return
	 */
	IPSSystem getPSSystem() throws Exception;
	
	
	/**
	 * 获取服务对象
	 * @param strDEId
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	IDynaService getDynaService(String strDEId,SessionFactory sessionFactory)throws Exception;
	
	
	
	/**
	 * 获取指定实体动态实体对象
	 * @param strDEId
	 * @return
	 * @throws Exception
	 */
	IDynaDEModel getDynaDEModel(String strDEId)throws Exception;
	
	
	
	
	/**
	 *   动态实体模板模型
	 * @param iDynaDETemplModel
	 * @throws Exception
	 */
	void registerDynaDETemplModel(IDynaDETemplModel iDynaDETemplModel) throws Exception;
	
	
	
	
	/**
	 *  获取动态实体模板对象
	 * 
	 * @param strDynaDETemplModelId
	 * @return
	 * @throws Exception
	 */
	IDynaDETemplModel getDynaDETemplModel(String strDynaDETemplModelId) throws Exception;
	
	
	
	/**
	 * 获取系统全部
	 * @return
	 */
	java.util.Iterator<IDynaDETemplModel> getDynaDETemplModels();
	
	
	
	/**
	 * 获取动态实例模型对象
	 * @param strDynaInstId
	 * @return
	 * @throws Exception
	 */
	IDynaInstModel getDynaInstModel(String strDynaInstId)throws Exception;
	
	
	/**
	 * 重置动态实例模型
	 * @param strDynaInstId
	 */
	void resetDynaInstModel(String strDynaInstId);
}
