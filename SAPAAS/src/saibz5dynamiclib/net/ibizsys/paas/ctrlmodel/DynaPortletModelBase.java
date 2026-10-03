package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态门户部件模型基类
 * @author Administrator
 *
 */
public abstract class DynaPortletModelBase extends PortletModelBase implements IDynaPortletModel {

	private int nColXS = -1;
	private int nColSM = -1;
	private int nColMD = -1;
	private int nColLG = -1;
	private int nColXSOffset = -1;
	private int nColSMOffset = -1;
	private int nColMDOffset = -1;
	private int nColLGOffset = -1;
	protected double fWidth = 0;
	protected double fHeight = 0;
	private boolean bShowTitle = true;
	
	
	private IDynaViewControllerInst iDynaViewControllerInst = null;
	private ObjectNode modelJsonObject = null;
	
	
	@Override
	public void init(IDynaViewControllerInst iDynaViewControllerInst, Object modelObject) throws Exception {
		this.setEnableDynaCtrl(true);
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
	public ObjectNode toJsonObject(ObjectNode jo) throws Exception {
		if(jo==null)
		{
			jo = JsonNodeHelper.createObjectNode();
		}
		
		fillJsonObject(this,jo);
		onFillJsonObject(jo);
		return jo;
	}
	

	/**
	 * 填充JSON对象
	 * @param jo
	 * @throws Exception
	 */
	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		
	}


	
	public static void fillJsonObject(IDynaCtrlModel iDynaCtrlModel,ObjectNode jo) throws Exception {
		JsonNodeHelper.put(jo, ATTR_TYPE, iDynaCtrlModel.getControlType());
		JsonNodeHelper.put(jo, ATTR_NAME, iDynaCtrlModel.getName());
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
	
	/**
	 * 获取最后导入的模型对象（json）
	 * @return
	 */
	protected ObjectNode getModelJsonObject(){
		return this.modelJsonObject;
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
	public boolean isShowTitle() {
		return this.bShowTitle;
	}
	

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
	 * @param bShowTitle
	 */
	public void setShowTitle(boolean bShowTitle) {
		this.bShowTitle = bShowTitle;
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
	
	
}
