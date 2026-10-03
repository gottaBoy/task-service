package net.ibizsys.pswf.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.pswf.control.expbar.IWFExpBar;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

/**
 * 流程导航栏模型接口
 * 
 * @author lionlau
 *
 */
public interface IWFExpBarModel extends IExpBarModel, IWFExpBar {
	
	/**
	 * 导航项：我的工作
	 */
	public final static String ITEM_MYWFWORK = "MYWFWORK";
	
	/**
	 * 导航项：我的数据
	 */
	public final static String ITEM_MY = "MY";
	
	/**
	 * 导航项：全部数据
	 */
	public final static String ITEM_ALL = "ALL";
	
	/**
	 * 获取流程模型对象
	 * 
	 * @return the IWFModel
	 */
	IWFModel getWFModel();

	/**
	 * 获取流程版本模型对象
	 * 
	 * @return the IWFVersionModel
	 */
	IWFVersionModel getWFVersionModel();
}
