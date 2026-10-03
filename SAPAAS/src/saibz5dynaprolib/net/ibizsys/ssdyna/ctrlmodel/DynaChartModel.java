package net.ibizsys.ssdyna.ctrlmodel;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.chart.IPSChartDataItem;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartAxes;
import net.ibizsys.model.control.chart.IPSDEChartSeries;
import net.ibizsys.paas.control.chart.IChartDataItem;
import net.ibizsys.paas.ctrlmodel.ChartAxisModel;
import net.ibizsys.paas.ctrlmodel.ChartDataItemModel;
import net.ibizsys.paas.ctrlmodel.ChartModelBase;
import net.ibizsys.paas.ctrlmodel.ChartSeriesModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.view.IDynaViewModel;

import com.fasterxml.jackson.databind.node.ObjectNode;


public class DynaChartModel extends ChartModelBase  implements IDynaCtrlModel {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaChartModel.class);
	private IPSControl iPSControl = null;

	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iPSControl = iPSControl;
		this.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return this.iPSControl;
	}

	public IPSDEChart getPSDEChart() {
		return (IPSDEChart) getPSControl();
	}

	@Override
	public IDataEntityModel getDEModel() {
		try {
			if (getPSControl().getPSDataEntity() != null) {
				return ((IDynaViewModel)this.getViewController()).getDynaSysModel().getDynaDEModel(getPSControl().getPSDataEntity().getId());
			}
		} catch (Exception ex) {
			log.error(ex);
		}
		return super.getDEModel();
	}

	
	 /**
     * 准备图表数据项模型
     * @throws Exception
     */
   @Override
    protected void prepareChartDataItemModels()throws Exception
    {
   	 super.prepareChartDataItemModels();
   	 if(this.getPSDEChart().getChartDataItems()!=null){
   		 java.util.Iterator<IChartDataItem> chartDataItems = this.getPSDEChart().getChartDataItems();
   		 while(chartDataItems.hasNext()){
   			 IPSChartDataItem iPSChartDataItem = (IPSChartDataItem)chartDataItems.next();
   		// ${chartDataItem.name} 
   	        ChartDataItemModel chartDataItem = new ChartDataItemModel();
   	        if(!StringHelper.isNullOrEmpty(iPSChartDataItem.getName())){
   	        	chartDataItem.setName(iPSChartDataItem.getName());
   	        }

   	        chartDataItem.setDataType(iPSChartDataItem.getDataType());
   	        if(!StringHelper.isNullOrEmpty(iPSChartDataItem.getFormat())){
   	        	chartDataItem.setFormat(iPSChartDataItem.getFormat());
   	        }

   	        chartDataItem.init(this);
   	        this.registerChartDataItem(chartDataItem);
   		 }
   	 }

    }
    
    
   /**
   * 准备图表坐标轴模型
   * @throws Exception
   */
   @Override
  protected void prepareChartAxisModels()throws Exception
  {
 	 super.prepareChartAxisModels();
 	 java.util.Iterator<IPSDEChartAxes> psDEChartAxeses = this.getPSDEChart().getPSDEChartAxeses();
 	 if(psDEChartAxeses!=null){
 		 while(psDEChartAxeses.hasNext()){
 	 		IPSDEChartAxes iPSDEChartAxes = psDEChartAxeses.next();
 	 	// ${chartAxis.name} 
 	 	      ChartAxisModel chartAxisModel = new ChartAxisModel();
 			if(!StringHelper.isNullOrEmpty(iPSDEChartAxes.getName())){
 				chartAxisModel.setName(iPSDEChartAxes.getName());
 			}
 			if(!StringHelper.isNullOrEmpty(iPSDEChartAxes.getCaption())){
 				chartAxisModel.setCaption(iPSDEChartAxes.getCaption());
 			}
 			if(!StringHelper.isNullOrEmpty(iPSDEChartAxes.getAxesType())){
 				chartAxisModel.setAxisType(iPSDEChartAxes.getAxesType());
 			}      
 		
 			if(!StringHelper.isNullOrEmpty(iPSDEChartAxes.getAxesPos())){
 				chartAxisModel.setAxisPos(iPSDEChartAxes.getAxesPos());
 			} 
 			
 			chartAxisModel.init(this);
 	 	      this.registerChartAxisModel(chartAxisModel);
 	 	 }
 	 }
 	
	
  }
    
   /**
   * 准备图表序列模型
   * @throws Exception
   */
   @Override
   protected void prepareChartSeriesModels()throws Exception
   {
   	super.prepareChartSeriesModels();
   	
   	java.util.Iterator<IPSDEChartSeries> psDEChartSerieses = this.getPSDEChart().getPSDEChartSerieses();
	 if(psDEChartSerieses!=null){
		 while(psDEChartSerieses.hasNext()){
	 		IPSDEChartSeries iPSDEChartSeries = psDEChartSerieses.next();
	 	// ${chartSeries.name} 
	 	      ChartSeriesModel chartSeriesModel = new ChartSeriesModel();
			if(!StringHelper.isNullOrEmpty(iPSDEChartSeries.getName())){
				chartSeriesModel.setName(iPSDEChartSeries.getName());
			}
			if(!StringHelper.isNullOrEmpty(iPSDEChartSeries.getCaption())){
				chartSeriesModel.setCaption(iPSDEChartSeries.getCaption());
			}
			if(!StringHelper.isNullOrEmpty(iPSDEChartSeries.getSeriesType())){
				chartSeriesModel.setSeriesType(iPSDEChartSeries.getSeriesType());
			}      
			if(!StringHelper.isNullOrEmpty(iPSDEChartSeries.getSeriesField())){
				chartSeriesModel.setSeriesField(iPSDEChartSeries.getSeriesField());
			}
			if(!StringHelper.isNullOrEmpty(iPSDEChartSeries.getCatalogField())){
				chartSeriesModel.setCatalogField(iPSDEChartSeries.getCatalogField());
			}
			if(!StringHelper.isNullOrEmpty(iPSDEChartSeries.getValueField())){
				chartSeriesModel.setValueField(iPSDEChartSeries.getValueField());
			}
			if(!StringHelper.isNullOrEmpty(iPSDEChartSeries.getValue2Field())){
				chartSeriesModel.setValue2Field(iPSDEChartSeries.getValue2Field());
			}
			if(!StringHelper.isNullOrEmpty(iPSDEChartSeries.getTimeGroupMode())){
				chartSeriesModel.setTimeGroupMode(iPSDEChartSeries.getTimeGroupMode());
			}
			chartSeriesModel.init(this);
	 	      this.registerChartSeriesModel(chartSeriesModel);
	 	 }
	 }

   }
   
	@Override
	public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
		if(objectNode == null){
			objectNode = JsonNodeHelper.createObjectNode();
		}
		onFillJsonObject(objectNode);
		return objectNode;
	}
	
	protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
		if(getPSControl()!=null){
			DynaCtrlModelBase.toJsonObject(objectNode,getPSControl());
		}
	}
	
	@Override
	public boolean isDynaCtrl() {
		if(this.getPSControl()!=null){
			return this.getPSControl().isDynamicCtrl();
		}
		return false;
	}
}
