package net.ibizsys.model.pub.preview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;

/**
 * 系统面板视图代码发布器对象
 * @author Administrator
 *
 */
public class PSPreviewSysPanelViewCodePublisherImpl extends PSPreviewCtrlCodePublisherImpl
{
	protected IPSPanel iPSPanel = null;
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSPanel = (IPSPanel)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		this.iPSPanel = (IPSPanel)this.iPSControl;
		super.onFillGenerateCodeParams(params);
		
		Object objViewCtrl = params.get("srfviewctrl");
		
		params.put("logics", new ArrayList<IPSGenerateCodeResult>());
		
		
		if(true)
		{
			ArrayList<IPSGenerateCodeResult> hiddenList = new ArrayList<IPSGenerateCodeResult> ();
//			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail("HIDDENFORMITEM").getPSPFCtrlPartCodePublisher();
//			//输出所有的隐藏项
//			Iterator<IPSSysPanelField> psSysPanelFields =  iPSSysPanel.getAllPSSysPanelFields();
//			while(psSysPanelFields.hasNext())
//			{
//				IPSSysPanelField iPSSysPanelField  = psSysPanelFields.next();
//				if(!iPSSysPanelField.isHidden())
//				{
//					continue;
//				}
//				
//				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSSysPanel,iPSSysPanelField);
//				hiddenList.add(iPSGenerateCodeResult);
//				
//			}
//			iPSPFCtrlPartCodePublisher.close();
			params.put("hiddens", hiddenList);
		}
		
		if(true)
		{
			
			ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult> ();
			Iterator<? extends IPSPanelItem> psPanelItems = iPSPanel.getRootPSPanelItems();
			while(psPanelItems.hasNext())
			{
				IPSPanelItem iPSPanelItem  = psPanelItems.next();
				IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
				
				HashMap<String,Object> rootParams = new HashMap<String,Object>();
				if(objViewCtrl!=null){
					rootParams.put("srfviewctrl", objViewCtrl);
				}
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, iPSPanel, iPSPanelItem, rootParams);
				itemList.add(iPSGenerateCodeResult);
			}
			params.put("rootitems", itemList);
		}
		
		if(true)
		{
			ArrayList<IPSGenerateCodeResult> itemList = new ArrayList<IPSGenerateCodeResult> ();
			//输出所有的隐藏项
			Iterator<? extends IPSPanelItem> psPanelItems = iPSPanel.getRootPSPanelItems();
			while(psPanelItems.hasNext())
			{
				IPSPanelItem iPSPanelItem  = psPanelItems.next();
				IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
				
				HashMap<String,Object> rootParams = new HashMap<String,Object>();
				if(objViewCtrl!=null){
					rootParams.put("srfviewctrl", objViewCtrl);
				}
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, iPSPanel, iPSPanelItem, rootParams);
				itemList.add(iPSGenerateCodeResult);
			}
			
			psPanelItems =  iPSPanel.getRootPSPanelItems();
			while(psPanelItems.hasNext())
			{
				HashMap<String,Object> rootParams = new HashMap<String,Object>();
				if(objViewCtrl!=null){
					rootParams.put("srfviewctrl", objViewCtrl);
				}
				
				IPSPanelItem iPSPanelItem  = psPanelItems.next();
				fillPSSysPanelItems(iPSPanelItem,itemList,rootParams);				
			}
			params.put("allitems", itemList);
		}
	}

	protected void fillPSSysPanelItems(IPSPanelItem iPSPanelItem,ArrayList<IPSGenerateCodeResult> formDetailList,HashMap<String,Object> params)throws Exception
	{
		if(iPSPanelItem instanceof IPSPanelContainer)
		{
			IPSPanelContainer iPSPanelContainer = (IPSPanelContainer)iPSPanelItem;
			java.util.Iterator<IPSPanelItem> psPanelItems = iPSPanelContainer.getPSPanelItems();
			while(psPanelItems.hasNext())
			{
				
				HashMap<String,Object> rootParams = new HashMap<String,Object>();
				if(params!=null){
					rootParams.putAll(params);
				}
				
				
				IPSPanelItem childPSPanelItem = psPanelItems.next();
				
				IPSPFCtrlPartCodePublisher	iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(childPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, iPSPanel, childPSPanelItem, rootParams);
				formDetailList.add(iPSGenerateCodeResult);
			}
			
			psPanelItems = iPSPanelContainer.getPSPanelItems();
			while(psPanelItems.hasNext())
			{
				IPSPanelItem childPSPanelItem = psPanelItems.next();
				fillPSSysPanelItems(childPSPanelItem,formDetailList,params);
			}
			return;
		}
	}
	

	
}
