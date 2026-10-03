package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.panel.IPanel;
import net.ibizsys.paas.data.IDataObject;
import net.sf.json.JSONObject;

/**
 * 面板部件模型接口
 * 
 * @author lionlau
 *
 */
public interface IPanelModel extends ICtrlModel,IPanel {

	/**
	 * 通过数据对象填充面板
	 * 
	 * @param iDataObject 当前数据对象
	 * @param outputData 输出数据对象
	 * @param outputConfig 输出配置对象
	 * @throws Exception
	 */
	void fillOutputDatas(IDataObject iDataObject, JSONObject outputData, JSONObject outputConfig) throws Exception;

}
