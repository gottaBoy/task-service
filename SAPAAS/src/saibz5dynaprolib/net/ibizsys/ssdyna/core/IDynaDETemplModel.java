package net.ibizsys.ssdyna.core;

/**
 * 动态实体模板对象接口
 * @author Administrator
 *
 */
public interface IDynaDETemplModel extends IDynaDETempl{

	/**
	 * 注册动态实体视图模板对象
	 * @param iDynaDEViewTemplModel
	 */
	void registerDynaDEViewTemplModel(IDynaDEViewTemplModel iDynaDEViewTemplModel) throws Exception;
	
	
	/**
	 * 获取指定动态实体模板视图对象
	 * @param strDynaDEViewTemplModelId
	 * @return
	 * @throws Exception
	 */
	IDynaDEViewTemplModel getDynaDEViewTemplModel(String  strDynaDEViewTemplModelId)throws Exception;
	
	
	
	/**
	 * 获取动态实体视图模板对象集合
	 * @return
	 */
	java.util.Iterator<IDynaDEViewTemplModel> getDynaDEViewTemplModels();
	
	
	
	/**
	 * 注册动态实体表单模板对象
	 * @param iDynaDEFormTemplModel
	 */
	void registerDynaDEFormTemplModel(IDynaDEFormTemplModel iDynaDEFormTemplModel) throws Exception;
	
	
	/**
	 * 获取指定动态实体模板表单对象
	 * @param strDynaDEFormTemplModelId
	 * @return
	 * @throws Exception
	 */
	IDynaDEFormTemplModel getDynaDEFormTemplModel(String  strDynaDEFormTemplModelId)throws Exception;
	
	
	
	/**
	 * 获取动态实体表单模板对象集合
	 * @return
	 */
	java.util.Iterator<IDynaDEFormTemplModel> getDynaDEFormTemplModels();
}
