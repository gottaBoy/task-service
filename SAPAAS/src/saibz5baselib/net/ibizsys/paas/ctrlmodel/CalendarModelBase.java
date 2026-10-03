package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext;
import net.ibizsys.paas.util.StringHelper;

/**
 * 日历部件模型对象
 * 
 * @author Administrator
 *
 */
public abstract class CalendarModelBase extends CtrlModelBase implements ICalendarModel {
	private HashMap<String, ICalendarItemModel> calendarItemModelMap = new HashMap<String, ICalendarItemModel>();
	private ArrayList<ICalendarItemModel> calendarItemModelList = new ArrayList<ICalendarItemModel>();
	
	@Override
	public String getControlType() {
		return ControlTypes.Calendar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.CtrlModelBase#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		onPrepareCalendarModel();
	}

	/**
	 * 准备日历模型
	 * 
	 * @throws Exception
	 */
	protected void onPrepareCalendarModel() throws Exception {

	}

	/**
	 * 注日历项模型对象
	 * 
	 * @param iCalendarItemTypeModel
	 * @throws Exception
	 */
	protected void registerCalendarItemModel(ICalendarItemModel iCalendarItemTypeModel) throws Exception {
		calendarItemModelMap.put(iCalendarItemTypeModel.getId(), iCalendarItemTypeModel);
		if(!StringHelper.isNullOrEmpty(iCalendarItemTypeModel.getItemType())){
			calendarItemModelMap.put(iCalendarItemTypeModel.getItemType(), iCalendarItemTypeModel);
		}
		this.calendarItemModelList.add(iCalendarItemTypeModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarModel#getCalendarItemModel(java.lang.String)
	 */
	@Override
	public ICalendarItemModel getCalendarItemModel(String strCalendarItemModelId) throws Exception {
		ICalendarItemModel iCalendarItemModel = calendarItemModelMap.get(strCalendarItemModelId);
		if (iCalendarItemModel == null) {
			// 无法获取指定日历项模型
			throw new Exception(StringHelper.format("无法获取指定日历项模型[%1$s]", strCalendarItemModelId));
		}
		return iCalendarItemModel;
	}

	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarModel#getCalendarItemModels()
	 */
	@Override
	public Iterator<ICalendarItemModel> getCalendarItemModels() {
		return this.calendarItemModelList.iterator();
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarModel#isOutputCalendarItem(net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext, net.ibizsys.paas.control.tree.ICalendarItem)
	 */
	@Override
	public boolean isOutputCalendarItem(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItem iCalendarItem) throws Exception {
		return true;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarModel#isOutputCalendarItemModel(net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext, net.ibizsys.paas.ctrlmodel.ICalendarItemModel)
	 */
	@Override
	public boolean isOutputCalendarItemModel(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItemModel iCalendarItemModel) throws Exception {
		return true;
	}

	
	
	
}
