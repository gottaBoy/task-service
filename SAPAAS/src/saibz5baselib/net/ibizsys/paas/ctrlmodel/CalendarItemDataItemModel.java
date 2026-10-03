package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.calendar.ICalendarItemDataItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

/**
 * 日历项数据项模型
 * 
 * @author lionlau
 *
 */
public class CalendarItemDataItemModel extends DataItemModel implements ICalendarItemDataItem {
	
	private ICalendarItemModel iCalendarItemModel = null;
	private boolean bDataAccessAction = false;
	private ICalendarModel iCalendarModel = null;
	private String strPrivilegeId = null;
	private IDataEntityModel iDEModel = null;

	public CalendarItemDataItemModel() {

	}

	/**
	 * 初始化
	 * 
	 * @param iCalendarItemModel
	 * @throws Exception
	 */
	public void init(ICalendarItemModel iCalendarItemModel) throws Exception {
		this.setCalendarItemModel(iCalendarItemModel);
		this.onInit();
	}


	/**
	 * 获取日历项模型对象
	 * @return
	 */
	protected ICalendarItemModel getCalendarItemModel() {
		return iCalendarItemModel;
	}

	/**
	 * 获取日历视图模型对象
	 * 
	 * @return
	 */
	protected ICalendarModel getCalendarModel() {
		return this.iCalendarModel;
	}


	/**
	 * 设置日历项模型对象
	 * @param iCalendarItemModel
	 */
	protected void setCalendarItemModel(ICalendarItemModel iCalendarItemModel) throws Exception{
		this.iCalendarItemModel = iCalendarItemModel;
		if(this.iCalendarItemModel!=null){
			this.iCalendarModel = this.iCalendarItemModel.getCalendarModel();
			if(this.iCalendarModel!=null){
				this.iDEModel = this.iCalendarModel.getDEModel();
			}
			if(!StringHelper.isNullOrEmpty(this.iCalendarItemModel.getDEName())){
				if(this.iDEModel!=null){
					if(StringHelper.compare(this.iDEModel.getName(), this.iCalendarItemModel.getDEName(),true) !=0){
						this.iDEModel = this.iDEModel.getSystemModel().getDataEntityModel(this.iCalendarItemModel.getDEName());
					}
				}
				else{
					this.iDEModel = DEModelGlobal.getDEModel(this.iCalendarItemModel.getDEName());
				}
			}
		}
		else{
			this.iCalendarModel = null;
			this.iDEModel = null;
		}
		
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.data.impl.DataItemImpl#getCurSystem(net.ibizsys.paas.core.IActionContext)
	 */
	@Override
	public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
		if(this.getDEModel()!=null)
			return this.getDEModel().getSystemModel();
		return null;
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
			if (this.getCalendarModel() == null) {
				throw new Exception(StringHelper.format("当前日历视图模型对象无效"));
			}

			final IDataEntityModel iDataEntityModel = this.getDEModel();
			if (iDataEntityModel == null) {
				return "{}";
			}
			
			final IViewController iViewController = this.getCalendarModel().getViewController();
			String strKeyName = this.getDataItemParams()[0].getName();
			java.util.Iterator<String> deDataAccessActions = iViewController.getDEDataAccessActions(iDataEntityModel.getName());
			if (deDataAccessActions != null) {
				JSONObject jo = new JSONObject();
				
				if(object instanceof IDataRow){
					IEntity iEntity = iDataEntityModel.createEntity();
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
		return this.iDEModel;
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
}
