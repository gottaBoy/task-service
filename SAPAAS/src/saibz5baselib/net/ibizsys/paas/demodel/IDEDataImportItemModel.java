package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDataImportItem;
import net.ibizsys.paas.core.IModelBase3;

/**
 * 实体数据导入项模型对象接口
 * @author Administrator
 *
 */
public interface IDEDataImportItemModel  extends IDEDataImportItem,IModelBase3{

	/**
	 * 获取对应的实体属性模型
	 * @return
	 */
	IDEFieldModel getDEFieldModel();
}
