package net.ibizsys.paas.ctrlmodel.form;

import java.util.ArrayList;

/**
 * 表单分组基础对象接口
 * @author Administrator
 *
 */
public interface IDynaFormGroupModelBase extends IDynaFormDetailModel{
	
	/**
	 * 获取子项模型集合
	 * @return
	 */
	java.util.Iterator<IDynaFormDetailModel> getItemModels();
	
	
	/**
	 * 填充分组中的动态表单项
	 * @param dynaFormItemModelList
	 * @throws Exception
	 */
	void fillDynaFormItemModels(ArrayList<IDynaFormItemModel> dynaFormItemModelList ) throws Exception;
}
