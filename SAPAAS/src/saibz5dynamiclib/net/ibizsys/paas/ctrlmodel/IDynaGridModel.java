package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;

/**
 * 动态表格模型对象接口
 * @author Administrator
 *
 */
public interface IDynaGridModel  extends IGridModel,IDynaCtrlModel,IDynaModelJsonExporter,IDynaModelJsonLoader {

	/**
	 * 获取源表格模型对象
	 * @return
	 */
	IGridModel getSourceGridModel();
	
}
