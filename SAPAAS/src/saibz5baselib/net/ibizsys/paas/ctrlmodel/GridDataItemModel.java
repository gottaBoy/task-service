package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.grid.IGrid;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

/**
 * 表格数据项模型
 * 
 * @author lionlau
 *
 */
public class GridDataItemModel extends DataItemModel implements IGridDataItem {
	private IGrid iGrid = null;
	private boolean bDataAccessAction = false;
	private IGridModel iGridModel = null;
	private String strPrivilegeId = null;
	private String strGroupItem = null;

	public GridDataItemModel() {

	}

	/**
	 * 初始化
	 * 
	 * @param iGrid
	 * @throws Exception
	 */
	public void init(IGrid iGrid) throws Exception {
		this.setGrid(iGrid);
		this.onInit();
	}

	/**
	 * 获取表格对象
	 * 
	 * @return the iGrid
	 */
	protected IGrid getGrid() {
		return iGrid;
	}

	/**
	 * 获取表格模型对象
	 * 
	 * @return
	 */
	protected IGridModel getGridModel() {
		return this.iGridModel;
	}

	/**
	 * 设置表格对象
	 * 
	 * @param iGrid the iGrid to set
	 */
	protected void setGrid(IGrid iGrid) {
		this.iGrid = iGrid;
		if (this.iGrid == null) {
			this.iGridModel = null;
		} else if (this.iGrid instanceof IGridModel) {
			this.iGridModel = (IGridModel) this.iGrid;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.impl.DataItemImpl#getCurSystem(net.ibizsys.paas.core.IActionContext)
	 */
	@Override
	public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
		return this.getGrid().getDataEntity().getSystem();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.grid.IGridDataItem#isDataAccessAction()
	 */
	@Override
	public boolean isDataAccessAction() {
		return this.bDataAccessAction;
	}

	/**
	 * 设置界面操作数据项
	 * 
	 * @param bDataAccessAction
	 */
	public void setDataAccessAction(boolean bDataAccessAction) {
		this.bDataAccessAction = bDataAccessAction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.impl.DataItemImpl#getValue(net.ibizsys.paas.web.IWebContext, java.lang.Object)
	 */
	@Override
	public Object getValue(IWebContext iWebContext, Object object) throws Exception {
		if (isDataAccessAction()) {
			if (this.getGridModel() == null) {
				throw new Exception(StringHelper.format("当前表格模型对象无效"));
			}

			final IDataEntityModel iDataEntityModel = this.getGridModel().getDEModel();
			if (iDataEntityModel == null) {
				return "{}";
			}
			
			final IViewController iViewController = this.getGridModel().getViewController();
			String strKeyName = this.getDataItemParams()[0].getName();
			java.util.Iterator<String> deDataAccessActions = iViewController.getDEDataAccessActions(iDataEntityModel.getName());
			if (deDataAccessActions != null) {
				JSONObject jo = new JSONObject();
				
				/**
				 * 20170911 添加，优先处理IDataRow
				 */
				if(object instanceof IDataRow){
					IEntity iEntity = this.getGridModel().getDEModel().createEntity();
					DataObject.fromDataRow(iEntity, (IDataRow)object);
					while (deDataAccessActions.hasNext()) {
						String strAccessAction = deDataAccessActions.next();
						if(StringHelper.compare(iDataEntityModel.getDEOPPrivTarget(strAccessAction), IDataEntityModel.DEOPPRIVTARGET_NONE,true)!=0){
							CallResult callResult = iViewController.testDEDataAccessAction(iDataEntityModel,iEntity, strAccessAction, true);
							if (callResult.isOk()) {
								jo.put(strAccessAction, 1);
							} else {
								jo.put(strAccessAction, 0);
							}
						}
					}
				}
				else
					if (object instanceof ISimpleDataObject) {
						Object objKey = ((ISimpleDataObject) object).get(strKeyName);
						while (deDataAccessActions.hasNext()) {
							String strAccessAction = deDataAccessActions.next();
							if(StringHelper.compare(iDataEntityModel.getDEOPPrivTarget(strAccessAction), IDataEntityModel.DEOPPRIVTARGET_NONE,true)!=0){
								CallResult callResult = iViewController.testDEDataAccessAction(iDataEntityModel,objKey, strAccessAction, true);
								if (callResult.isOk()) {
									jo.put(strAccessAction, 1);
								} else {
									jo.put(strAccessAction, 0);
								}
							}
						}
					}
				return jo.toString();
			}
			return "{}";
		} else {
			return super.getValue(iWebContext, object);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.data.impl.DataItemImpl#getDEModel()
	 */
	@Override
	protected IDataEntityModel getDEModel() throws Exception {
		return (IDataEntityModel) this.getGrid().getDataEntity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.grid.IGridDataItem#getPrivilegeId()
	 */
	@Override
	public String getPrivilegeId() {
		return this.strPrivilegeId;
	}

	/**
	 * 设置列控制标识
	 * 
	 * @param strPrivilegeId
	 */
	public void setPrivilegeId(String strPrivilegeId) {
		this.strPrivilegeId = strPrivilegeId;
	}

	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.control.grid.IGridDataItem#getGroupItem()
	// */
	// @Override
	// public String getGroupItem() {
	// return this.strGroupItem;
	// }
	//
	// /**
	// * 设置分组项
	// * @param strGroupItem
	// */
	// public void setGroupItem(String strGroupItem){
	// this.strGroupItem = strGroupItem;
	// }
	//

}
