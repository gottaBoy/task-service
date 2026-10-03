package net.ibizsys.paas.ctrlmodel.form;

import net.ibizsys.paas.core.DynaModelBase;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaFormModel;
import net.ibizsys.paas.util.JsonNodeHelper;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态表单成员模型对象实现基类
 * @author Administrator
 *
 */
public abstract class DynaFormDetailModelBase  extends DynaModelBase implements IDynaFormDetailModel{

	private IDynaFormModel iDynaFormModel = null;
	private IDynaFormDetailModel parentModel = null;
	private boolean bShowCaption = true;
	private String strCaption = null;
	private int nColXS = -1;
	private int nColSM = -1;
	private int nColMD = -1;
	private int nColLG = -1;
	private int nColXSOffset = -1;
	private int nColSMOffset = -1;
	private int nColMDOffset = -1;
	private int nColLGOffset = -1;
	protected double fContentWidth = 0;
	protected double fWidth = 0;
	protected double fContentHeight = 0;
	protected double fHeight = 0;

	
	
	@Override
	public void init(IDynaFormModel iDynaFormModel, IDynaFormDetailModel parentModel, Object modelObject) throws Exception {
		this.setFormModel(iDynaFormModel);
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
	public IDynaFormModel getDynaFormModel() {
		return iDynaFormModel;
	}

	@Override
	public IDynaFormDetailModel getParentModel() {
		return parentModel;
	}


	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		super.onFillJsonObject(jo);
		fillJsonObject(this,jo);
		if(this.getModelJsonObject()!=null){
			JsonNodeHelper.copy(jo, getModelJsonObject(),true,new String[]{IDynaFormModel.ATTR_PAGES,IDynaCtrlModel.ATTR_ITEMS});
		}
	}

	/**
	 * 设置动态表单模型
	 * @param iDynaFormModel
	 */
	public void setFormModel(IDynaFormModel iDynaFormModel) {
		this.iDynaFormModel = iDynaFormModel;
	}

	/**
	 * 设置父模型
	 * @param parentModel
	 */
	public void setParentModel(IDynaFormDetailModel parentModel) {
		this.parentModel = parentModel;
	}
	
	/**
	 * 设置名称
	 * @param strName
	 */
	public void setName(String strName){
		this.strName = strName;
	}
	
	@Override
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		
		String strName = JsonNodeHelper.getString(jsonObject, IDynaCtrlModel.ATTR_NAME, null);
		this.setName(strName);
		super.onLoadJsonObject(jsonObject);
	}
	
	
	public static void fillJsonObject(IDynaFormDetailModel iDynaFormDetailModel,ObjectNode jo) throws Exception {
		JsonNodeHelper.put(jo, ATTR_TYPE, iDynaFormDetailModel.getDetailType());
		JsonNodeHelper.put(jo, ATTR_NAME, iDynaFormDetailModel.getName());
	}




	@Override
	public int getColXS() {
		return this.nColXS;
	}


	@Override
	public int getColSM() {
		return this.nColSM;
	}


	@Override
	public int getColMD() {
		return this.nColMD;
	}


	@Override
	public int getColLG() {
		return this.nColLG;
	}


	@Override
	public int getColXSOffset() {
		return this.nColXSOffset;
	}

	
	@Override
	public int getColSMOffset() {
		return this.nColSMOffset;
	}

	
	@Override
	public int getColMDOffset() {
		return this.nColMDOffset;
	}

	
	@Override
	public int getColLGOffset() {
		return this.nColLGOffset;
	}



	@Override
	public String getCaption() {
		return this.strCaption;
	}



	@Override
	public boolean isShowCaption() {
		return this.bShowCaption;
	}
	
	
	
//	@Override
//	public double getContentWidth() {
//		return this.fContentWidth;
//	}
//
//
//	@Override
//	public double getContentHeight() {
//		return this.fContentHeight;
//	}


	@Override
	public double getWidth() {
		return this.fWidth;
	}


	@Override
	public double getHeight() {
		return this.fHeight;
	}
	
	/**
	 * 设置是否显示标题
	 * @param bShowCaption
	 */
	public void setShowCaption(boolean bShowCaption) {
		this.bShowCaption = bShowCaption;
	}


	public void setColXS(int nColXS) {
		this.nColXS = nColXS;
	}

	public void setColSM(int nColSM) {
		this.nColSM = nColSM;
	}

	public void setColMD(int nColMD) {
		this.nColMD = nColMD;
	}

	public void setColLG(int nColLG) {
		this.nColLG = nColLG;
	}

	public void setColXSOffset(int nColXSOffset) {
		this.nColXSOffset = nColXSOffset;
	}

	public void setColSMOffset(int nColSMOffset) {
		this.nColSMOffset = nColSMOffset;
	}

	public void setColMDOffset(int nColMDOffset) {
		this.nColMDOffset = nColMDOffset;
	}

	public void setColLGOffset(int nColLGOffset) {
		this.nColLGOffset = nColLGOffset;
	}

	public void setWidth(double fWidth) {
		this.fWidth = fWidth;
	}

	public void setHeight(double fHeight) {
		this.fHeight = fHeight;
	}
	
	public void setCaption(String strCaption){
		this.strCaption = strCaption;
	}
}
