package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;

/**
 * 动态门户部件模型对象接口
 * @author Administrator
 *
 */
public interface IDynaPortletModel extends IPortletModel,IDynaCtrlModel,IDynaModelJsonExporter,IDynaModelJsonLoader {

	
	/**
	 * 
	 * @return
	 */
	int getColXS();

	
	/**
	 * @return
	 */
	int getColSM();
	
	
	/**
	 * @return
	 */
	int getColMD();
	
	
	/**
	 * @return
	 */
	int getColLG();
	
	
	/**
	 * @return
	 */
	int getColXSOffset();

	/**
	 * @return
	 */
	int getColSMOffset();
	
	
	/**
	 * @return
	 */
	int getColMDOffset();
	
	
	/**
	 * 获取列偏移（大型界面）
	 * @return
	 */
	int getColLGOffset();
	
	
	
	/**
	 * 获取宽度
	 * @return
	 */
	double getWidth();
	
	
	
	/**
	 * 获取高度
	 * @return
	 */
	double getHeight();
	
	
	
	/**
	 * 是否显示标题
	 * @return
	 */
	boolean isShowTitle();
	
}
