package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarItemModel;

/**
 * 动态工具栏模型对象接口
 * @author Administrator
 *
 */
public interface IDynaToolbarModel extends IDynaCtrlModel,IToolbarModel,IDynaModelJsonExporter,IDynaModelJsonLoader {

	/**
	 * 获取成员对象集合
	 * @return
	 */
	java.util.Iterator<IDynaToolbarItemModel> getItemModels();
	
	
	
	
	/**
	 * 根据工具栏项类型建立项对象
	 * @param strType
	 * @return
	 * @throws Exception
	 */
	IDynaToolbarItemModel createDynaToolbarItemModel(String strType)throws Exception;
}
