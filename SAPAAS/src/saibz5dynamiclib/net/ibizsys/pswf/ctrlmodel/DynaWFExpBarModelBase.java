package net.ibizsys.pswf.ctrlmodel;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.expbar.ExpBarItem;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态工作流导航栏模型对象实现基类
 * @author Administrator
 *
 */
public abstract class DynaWFExpBarModelBase extends WFExpBarModelBase implements IDynaWFExpBarModel{
	
	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaWFExpBarModelBase.class);
	
	private IDynaViewControllerInst iDynaViewControllerInst = null;
	private ObjectNode modelJsonObject = null;
	
	
	@Override
	public void init(IDynaViewControllerInst iDynaViewControllerInst, Object modelObject) throws Exception {
		super.init(iDynaViewControllerInst);
		if(modelObject!=null){
			if(modelObject instanceof ObjectNode){
				this.loadJsonObject((ObjectNode)modelObject);
			}
		}
	}


	@Override
	protected void onInit() throws Exception {
		if(this.getViewController() instanceof IDynaViewControllerInst){
			iDynaViewControllerInst = (IDynaViewControllerInst)this.getViewController();
		}
		super.onInit();
	}
	
	
	@Override
	public IDynaViewControllerInst getDynaViewControllerInst() {
		return this.iDynaViewControllerInst;
	}

	


	@Override
	public void loadJsonObject(ObjectNode jsonObject) throws Exception {
		this.modelJsonObject = jsonObject;
		onLoadJsonObject(jsonObject);
	}
	
	
	
	/**
	 * 加载Json对象模型
	 * @param jsonObject
	 * @throws Exception
	 */
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		String strName = JsonNodeHelper.getString(jsonObject, ATTR_NAME, null);
		if(StringHelper.isNullOrEmpty(strName)){
			throw new Exception("部件模型中没有指定部件名称");
		}
		this.setName(strName);
	}
	

	@Override
	public ObjectNode toJsonObject(ObjectNode jo) throws Exception {
		if(jo==null)
		{
			jo = JsonNodeHelper.createObjectNode();
		}
		
		DynaCtrlModelBase.fillJsonObject(this,jo);
		onFillJsonObject(jo);
		return jo;
	}
	
	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		
		
	}


	@Override
	protected void onPrepareRootItem(ExpBarRootItem expBarRootItem) throws Exception {
		ExpBarItem myWorkExpBarItem = expBarRootItem.getItem(IWFExpBarModel.ITEM_MYWFWORK, true);
		if(myWorkExpBarItem!=null){
			ICodeList iCodeList = this.getWFVersionModel().getWFStepCodeList();
			if(iCodeList!=null && iCodeList.getCodeItems()!=null){
				java.util.Iterator<ICodeItem> codeItems = iCodeList.getCodeItems();
				while(codeItems.hasNext()){
					ICodeItem iCodeItem = codeItems.next();
					ExpBarItem expBarItem = expBarRootItem.addItem(StringHelper.format("%1$s:%2$s",IWFExpBarModel.ITEM_MYWFWORK,iCodeItem.getValue()),IWFExpBarModel.ITEM_MYWFWORK);
					expBarItem.setText(iCodeItem.getText());
				    expBarItem.setExpViewId(myWorkExpBarItem.getExpViewId());
				    expBarItem.setCounterId(StringHelper.format("%1$s%2$s","V",iCodeItem.getValue()));
				    expBarItem.setCounterMode(1);
				    expBarItem.setViewParam("srfwfstep",iCodeItem.getValue());
				    expBarItem.setViewParam("srfviewmode",iCodeItem.getValue());
				}
			}
		}
		
		super.onPrepareRootItem(expBarRootItem);
	}
	

	
}
