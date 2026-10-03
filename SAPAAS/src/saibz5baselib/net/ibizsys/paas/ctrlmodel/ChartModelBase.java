package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.chart.IChartDataItem;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

/**
 * 图表部件模型
 * 
 * @author lionlau
 *
 */
public abstract class ChartModelBase extends CtrlModelBase implements IChartModel {
	private ArrayList<IChartDataItem> chartDataItemList = new ArrayList<IChartDataItem>();
	private ArrayList<IChartAxisModel> chartAxisModelList = new ArrayList<IChartAxisModel>();
	private ArrayList<IChartSeriesModel> chartSeriesModelList = new ArrayList<IChartSeriesModel>();

	@Override
	protected void onInit() throws Exception {
		super.onInit();
		prepareChartAxisModels();
		prepareChartSeriesModels();
		prepareChartDataItemModels();
	}

	@Override
	public String getControlType() {
		return ControlTypes.Chart;
	}

	/**
	 * 准备图表图形序列
	 * 
	 * @throws Exception
	 */
	protected void prepareChartSeriesModels() throws Exception {

	}

	/**
	 * 准备图表坐标轴
	 * 
	 * @throws Exception
	 */
	protected void prepareChartAxisModels() throws Exception {

	}

	/**
	 * 准备图表数据项
	 * 
	 * @throws Exception
	 */
	protected void prepareChartDataItemModels() throws Exception {

	}

	/**
	 * 增加图表坐标轴
	 * 
	 * @param iChartAxisModel
	 */
	protected void registerChartAxisModel(IChartAxisModel iChartAxisModel) {
		this.chartAxisModelList.add(iChartAxisModel);
	}

	/**
	 * 增加图表序列
	 * 
	 * @param iChartSeriesModel
	 */
	protected void registerChartSeriesModel(IChartSeriesModel iChartSeriesModel) {
		this.chartSeriesModelList.add(iChartSeriesModel);
	}

	/**
	 * 增加图表数据项
	 * 
	 * @param iChartDataItem
	 */
	protected void registerChartDataItem(IChartDataItem iChartDataItem) {
		this.chartDataItemList.add(iChartDataItem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.chart.IChart#getChartDataItems()
	 */
	@Override
	public Iterator<IChartDataItem> getChartDataItems() {
		return this.chartDataItemList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#fillFetchResult(net.ibizsys.paas.web.MDAjaxActionResult, net.ibizsys.paas.db.IDataTable)
	 */
	@Override
	public void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		if (dt.getCachedRowCount() == -1) {
			while (true) {
				IDataRow iDataRow = dt.next();
				if (iDataRow == null) break;

				JSONObject jo = new JSONObject();
				for (IChartDataItem iChartDataItem : this.chartDataItemList) {
					Object objValue = getChartDataItemValue(iChartDataItem, iDataRow);
					JSONObjectHelper.put(jo, iChartDataItem.getName(), objValue);
				}
				fetchResult.getRows().add(jo);
			}
		} else {
			int nRows = dt.getCachedRowCount();
			for (int i = 0; i < nRows; i++) {
				IDataRow iDataRow = dt.getCachedRow(i);

				JSONObject jo = new JSONObject();
				for (IChartDataItem iChartDataItem : this.chartDataItemList) {
					Object objValue = getChartDataItemValue(iChartDataItem, iDataRow);
					JSONObjectHelper.put(jo, iChartDataItem.getName(), objValue);
				}
				fetchResult.getRows().add(jo);
			}
		}
	}

	/**
	 * 获取图表数据项值
	 * 
	 * @param iChartDataItem
	 * @param iDataRow
	 * @return
	 * @throws Exception
	 */
	protected Object getChartDataItemValue(IChartDataItem iChartDataItem, IDataRow iDataRow) throws Exception {
		return iChartDataItem.getValue(this.getViewController().getWebContext(), iDataRow);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IChartModel#getChartAxisModel()
	 */
	@Override
	public Iterator<IChartAxisModel> getChartAxisModels() {
		return this.chartAxisModelList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IChartModel#getChartSerieModels()
	 */
	@Override
	public Iterator<IChartSeriesModel> getChartSeriesModels() {
		return this.chartSeriesModelList.iterator();
	}
}
