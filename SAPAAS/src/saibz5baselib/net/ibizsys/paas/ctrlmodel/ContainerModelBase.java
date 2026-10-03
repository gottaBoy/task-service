package net.ibizsys.paas.ctrlmodel;

/**
 * 容器控件
 * 
 * @author lionlau
 *
 */
public abstract class ContainerModelBase extends CtrlModelBase implements IContainerModel {
	// protected HashMap<String, ICtrlModel> ctrlModelMap = new HashMap<String, ICtrlModel>();
	//
	// /**
	// * 准备部件模型
	// * @throws Exception
	// */
	// protected void prepareCtrlModels()throws Exception{
	//
	// }
	//
	//
	// /**
	// * 获取控件模型
	// * @param strName
	// * @return
	// * @throws Exception
	// */
	// @Override
	// public ICtrlModel getCtrlModel(String strName)throws Exception
	// {
	// ICtrlModel iCtrlModel = this.ctrlModelMap.get(strName);
	// if(iCtrlModel == null)
	// throw new Exception(StringHelper.format("无法获取指定部件模型[%1$s]", strName));
	// return iCtrlModel;
	// }
}
