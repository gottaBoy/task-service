package net.ibizsys.paas.ctrlmodel.toolbar;

import net.ibizsys.paas.core.DynaModelBase;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaToolbarModel;
import net.ibizsys.paas.util.JsonNodeHelper;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态工具栏项模型接口实现基类
 * @author Administrator
 *
 */
public abstract class DynaToolbarItemModelBase extends DynaModelBase implements IDynaToolbarItemModel {

	private IDynaToolbarModel iDynaToolbarModel = null;
	private IDynaToolbarItemModel parentModel = null;
	private String strShowMode = null;
	private String strCaption = null;
	private String strCapLanResTag = null;
	private String strTooltip = null;
	private String strTooltipLanResTag = null;
	
	
	@Override
	public void init(IDynaToolbarModel iDynaToolbarModel, IDynaToolbarItemModel parentModel, Object modelObject) throws Exception {
		this.setToolbarModel(iDynaToolbarModel);
		this.setParentModel(parentModel);
		this.onInit();
		if(modelObject !=null ){
			if(modelObject instanceof ObjectNode){
				loadJsonObject((ObjectNode)modelObject);
				return;
			}
		}
	}

	

	@Override
	public IDynaToolbarModel getDynaToolbarModel() {
		return iDynaToolbarModel;
	}

	@Override
	public IDynaToolbarItemModel getParentModel() {
		return parentModel;
	}

	
	@Override
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		String strName = JsonNodeHelper.getString(jsonObject, IDynaCtrlModel.ATTR_NAME,"");
		this.setName(strName);
		
		
		super.onLoadJsonObject(jsonObject);
	}
	
	
	
	@Override
	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		super.onFillJsonObject(jo);
		JsonNodeHelper.put(jo, IDynaCtrlModel.ATTR_TYPE, this.getItemType());
		JsonNodeHelper.put(jo, IDynaCtrlModel.ATTR_NAME, this.getName());
		if(this.getModelJsonObject()!=null){
			JsonNodeHelper.copy(jo, getModelJsonObject(),true,new String[]{IDynaCtrlModel.ATTR_ITEMS});
		}
	}
	
	

	/**
	 * 设置动态表单模型
	 * @param iDynaToolbarModel
	 */
	public void setToolbarModel(IDynaToolbarModel iDynaToolbarModel) {
		this.iDynaToolbarModel = iDynaToolbarModel;
	}

	/**
	 * 设置父模型
	 * @param parentModel
	 */
	public void setParentModel(IDynaToolbarItemModel parentModel) {
		this.parentModel = parentModel;
	}
	
	/**
	 * 设置名称
	 * @param strName
	 */
	public void setName(String strName){
		this.strName = strName;
	}
	
	
	/**
	 * 设置项显示模式
	 * @param strShowMode
	 */
	public void setShowMode(String strShowMode){
		this.strShowMode = strShowMode;
	}
	
	
	
	/**
	 * 获取项显示模式
	 * @return
	 */
	public String getShowMode(){
		return this.strShowMode;
	}

	/**
	 * 获取项标题
	 * @return
	 */
	public String getCaption() {
		return strCaption;
	}

	/**
	 * 设置项标题
	 * @param strCaption
	 */
	public void setCaption(String strCaption) {
		this.strCaption = strCaption;
	}

	/**
	 * 获取标题语言资源标识
	 * @return
	 */
	public String getCapLanResTag() {
		return strCapLanResTag;
	}

	/**
	 * 设置标题语言资源标识
	 * @param strCapLanResTag
	 */
	public void setCapLanResTag(String strCapLanResTag) {
		this.strCapLanResTag = strCapLanResTag;
	}

	/**
	 * 获取项操作提示
	 * @return
	 */
	public String getTooltip() {
		return strTooltip;
	}

	/**
	 * 设置项操作提示
	 * @param strTooltip
	 */
	public void setTooltip(String strTooltip) {
		this.strTooltip = strTooltip;
	}

	/**
	 * 获取项操作提示语言资源标识
	 * @return
	 */
	public String getTooltipLanResTag() {
		return strTooltipLanResTag;
	}

	/**
	 * 设置项操作提示语言资源标识
	 * @param strTooltipLanResTag
	 */
	public void setTooltipLanResTag(String strTooltipLanResTag) {
		this.strTooltipLanResTag = strTooltipLanResTag;
	}
	
	
	

}
