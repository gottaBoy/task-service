package net.ibizsys.model.pub.ionic4;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Data.PSSysPanelItem;
import SA.SRFramework.Utility.StringHelper;

/**
 * EXT JS 系统面板容器成员视图代码发布器对象
 * @author Administrator
 *
 */
public class PSIonic4SysPanelContainerVCPublisherImpl extends PSIonic4SysPanelItemVCPublisherImpl {
	public class ColumnLayoutGroup {
		private ArrayList<IPSGenerateCodeResult> itemCodeList = new ArrayList<IPSGenerateCodeResult>();

		public ArrayList<IPSGenerateCodeResult> getItems() {
			return this.itemCodeList;
		}
	}

	protected IPSPanelContainer iPSPanelContainer = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA
	 * .PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl,
	 * java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception {
		iPSPanelContainer = (IPSPanelContainer) object;
		return super.generateCode(iPSPublisherContext, iPSControl, object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams
	 * (java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
		super.onFillGenerateCodeParams(params);

		Object objViewCtrl = params.get("srfviewctrl");
		
		if (true) {
			ArrayList<IPSPanelItem> psPanelItemList = new ArrayList<IPSPanelItem>();
			iPSPanelContainer = (IPSPanelContainer) object;
			java.util.Iterator<IPSPanelItem> psPanelItems = iPSPanelContainer.getPSPanelItems();
			while (psPanelItems.hasNext()) {
				IPSPanelItem iPSPanelItem = psPanelItems.next();
				if (iPSPanelItem instanceof IPSDEFormItem) {
					IPSDEFormItem iPSDEFormItem = (IPSDEFormItem) iPSPanelItem;
					if (StringHelper.Compare(iPSDEFormItem.getEditorType(), "HIDDEN", true) == 0)
						continue;
				}
				psPanelItemList.add(iPSPanelItem);
			}

			String strLayoutType = iPSPanelContainer.getLayoutMode();
			if ((StringHelper.Compare(strLayoutType, PSSysPanelItem.LAYOUTMODE_AUTOTABLE, true) == 0) || (StringHelper.Compare(strLayoutType, PSSysPanelItem.LAYOUTMODE_TABLE, true) == 0)) {
				HashMap<Integer, ColumnLayoutGroup> columnLayoutGroupMap = new HashMap<Integer, ColumnLayoutGroup>();

				// 产生集合代码
				for (IPSPanelItem iPSPanelItem : psPanelItemList) {
					int nRowId = iPSPanelContainer.getItemRowId(iPSPanelItem);
					ColumnLayoutGroup columnLayoutGroup = null;
					if (columnLayoutGroupMap.containsKey(nRowId)) {
						columnLayoutGroup = columnLayoutGroupMap.get(nRowId);
					} else {
						columnLayoutGroup = new ColumnLayoutGroup();
						columnLayoutGroupMap.put(nRowId, columnLayoutGroup);
					}

					// 根据类型，获取对应的编辑器代码
					
					HashMap<String,Object> rootParams = new HashMap<String,Object>();
					if(objViewCtrl!=null){
						rootParams.put("srfviewctrl", objViewCtrl);
					}
					
					IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, this.iPSControl, iPSPanelItem,rootParams);
					iPSPFCtrlPartCodePublisher.close();

					columnLayoutGroup.getItems().add(iPSGenerateCodeResult);
				}

				ArrayList<ColumnLayoutGroup> columnLayoutGroupList = new ArrayList<ColumnLayoutGroup>();
				for (int i = 0; i < 1000; i++) {
					ColumnLayoutGroup columnLayoutGroup = columnLayoutGroupMap.get(i);
					if (columnLayoutGroup == null)
						break;
					columnLayoutGroupList.add(columnLayoutGroup);
				}
				params.put("rows", columnLayoutGroupList);
			} else if (StringHelper.Compare(strLayoutType, PSSysPanelItem.LAYOUTMODE_BORDER, true) == 0) {
				ArrayList<IPSGenerateCodeResult> itemCodeList = new ArrayList<IPSGenerateCodeResult>();

				// 产生集合代码
				for (IPSPanelItem iPSPanelItem : psPanelItemList) {
					
					HashMap<String,Object> rootParams = new HashMap<String,Object>();
					if(objViewCtrl!=null){
						rootParams.put("srfviewctrl", objViewCtrl);
					}
					
					IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, this.iPSControl, iPSPanelItem,rootParams);
					iPSPFCtrlPartCodePublisher.close();

					itemCodeList.add(iPSGenerateCodeResult);

				}

				params.put("items", itemCodeList);
			} else {
				ArrayList<IPSGenerateCodeResult> itemCodeList = new ArrayList<IPSGenerateCodeResult>();

				// 产生集合代码
				for (IPSPanelItem iPSPanelItem : psPanelItemList) {
					
					HashMap<String,Object> rootParams = new HashMap<String,Object>();
					if(objViewCtrl!=null){
						rootParams.put("srfviewctrl", objViewCtrl);
					}
					
					IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSPanelItem.getItemType()).getPSPFCtrlPartCodePublisher();
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext, this.iPSControl, iPSPanelItem,rootParams);
					iPSPFCtrlPartCodePublisher.close();

					itemCodeList.add(iPSGenerateCodeResult);

				}

				params.put("items", itemCodeList);
			}

		}

	}

	@Override
	protected void onClose() {
		this.iPSPanelContainer = null;
		super.onClose();
	}

}
