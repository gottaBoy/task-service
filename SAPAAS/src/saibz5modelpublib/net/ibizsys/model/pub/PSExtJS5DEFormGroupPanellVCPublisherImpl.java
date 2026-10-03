package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormDetailRuntime;
import net.ibizsys.model.control.form.IPSDEFormGroupPanel;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.paas.util.StringHelper;

/**
 * EXT JS 表单分组面板视图代码发布器对象
 * @author Administrator
 *
 */
public class PSExtJS5DEFormGroupPanellVCPublisherImpl extends PSExtJS5DEFormDetailVCPublisherImpl {
	public class ColumnLayoutGroup {
		private ArrayList<IPSGenerateCodeResult> itemCodeList = new ArrayList<IPSGenerateCodeResult>();

		public ArrayList<IPSGenerateCodeResult> getItems() {
			return this.itemCodeList;
		}
	}

	protected IPSDEFormGroupPanel iPSDEFormGroupPanel = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA
	 * .PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl,
	 * java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(  IPSControl iPSControl, Object object) throws Exception {
		iPSDEFormGroupPanel = (IPSDEFormGroupPanel) object;
		return super.generateCode( iPSControl, object);
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

		if (true) {
			ArrayList<IPSDEFormDetail> psDEFormDetailList = new ArrayList<IPSDEFormDetail>();
			java.util.Iterator<IPSDEFormDetail> psDEFormDetails = iPSDEFormGroupPanel.getPSDEFormDetails();
			while (psDEFormDetails.hasNext()) {
				IPSDEFormDetail iPSDEFormDetail = psDEFormDetails.next();
				if (iPSDEFormDetail instanceof IPSDEFormItem) {
					IPSDEFormItem iPSDEFormItem = (IPSDEFormItem) iPSDEFormDetail;
					if (StringHelper.compare(iPSDEFormItem.getEditorType(), "HIDDEN", true) == 0)
						continue;
				}
				psDEFormDetailList.add(iPSDEFormDetail);
			}

			String strLayoutType = iPSDEFormGroupPanel.getLayoutMode();
			if ((StringHelper.compare(strLayoutType, PSDEFormDetail.LAYOUTMODE_AUTOTABLE, true) == 0) || (StringHelper.compare(strLayoutType, PSDEFormDetail.LAYOUTMODE_TABLE, true) == 0)) {
				HashMap<Integer, ColumnLayoutGroup> columnLayoutGroupMap = new HashMap<Integer, ColumnLayoutGroup>();

				// 产生集合代码
				for (IPSDEFormDetail iPSDEFormDetail : psDEFormDetailList) {
				//	int nRowId =( (IPSDEFormDetailRuntime) iPSDEFormGroupPanel).getItemRowId(iPSDEFormDetail);
					int nRowId = 0;//( (IPSDEFormDetailRuntime) iPSDEFormGroupPanel).getItemRowId(iPSDEFormDetail);
					ColumnLayoutGroup columnLayoutGroup = null;
					if (columnLayoutGroupMap.containsKey(nRowId)) {
						columnLayoutGroup = columnLayoutGroupMap.get(nRowId);
					} else {
						columnLayoutGroup = new ColumnLayoutGroup();
						columnLayoutGroupMap.put(nRowId, columnLayoutGroup);
					}

					// 根据类型，获取对应的编辑器代码
					IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode( this.iPSControl, iPSDEFormDetail);

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
			} else if (StringHelper.compare(strLayoutType, PSDEFormDetail.LAYOUTMODE_BORDER, true) == 0) {
				ArrayList<IPSGenerateCodeResult> itemCodeList = new ArrayList<IPSGenerateCodeResult>();

				// 产生集合代码
				for (IPSDEFormDetail iPSDEFormDetail : psDEFormDetailList) {
					IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(iPSDEFormDetail.getDetailType()).getPSPFCtrlPartCodePublisher();
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode( this.iPSControl, iPSDEFormDetail);
				
					itemCodeList.add(iPSGenerateCodeResult);

				}

				params.put("items", itemCodeList);
			}

		}

	}



}
