package net.ibizsys.model.pub.angularga;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.control.grid.IPSDEGridGroupColumn;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.PSJQDEGridViewCodePublisherImpl;
import net.ibizsys.model.res.IPSSysEditorStyleRuntime;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.model.entity.PSPFEditorTempl;

/**
 * JQ实体表格列视图代码发布器对象
 * 
 * @author Administrator
 *
 */
public class PSAngularDEGridColVCPublisherImpl extends PSAngularCtrlPartCodePublisherImpl {
	protected IPSDEGridColumn iPSDEGridColumn = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.
	 * Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl,
	 * java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSControl iPSControl,
			Object object) throws Exception {
		iPSDEGridColumn = (IPSDEGridColumn) object;
		return super.generateCode(iPSControl, object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.
	 * util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
		super.onFillGenerateCodeParams(params);

		if (iPSDEGridColumn.isEnableRowEdit()) {
			IPSDEGridEditItem iPSDEGridEditItem = iPSDEGridColumn.getPSDEGridEditItem();
			// 根据类型，获取对应的编辑器代码
			IPSSysPFPlugin iPSSysPFPlugin = null;
			IPSEditorType iPSEditorType = this.getPSModelStorageContext().getPSEditorType(iPSDEGridEditItem.getEditorType());
			if (iPSDEGridEditItem.getPSSysEditorStyle() != null) {
				iPSSysPFPlugin = ((IPSSysEditorStyleRuntime)iPSDEGridEditItem.getPSSysEditorStyle()).getPSSysPFPlugin();
			}

			if (iPSSysPFPlugin != null) {
				String strCodeName = "";
				if (StringHelper.compare(this.getPSPFPubCode().getName(), "HTML", true) == 0) {
					strCodeName = "CODE";
				} else if (StringHelper.compare(this.getPSPFPubCode().getName(), "CONTROL_TS", true) == 0) {
					strCodeName = "CODE2";
				}

				if (!StringHelper.isNullOrEmpty(strCodeName)) {
					String strCode = iPSSysPFPlugin.getCode(strCodeName, this.iPSPF.getId(), this.iPSPFStyle.getId(),
							this.iPSAppView, this.iPSControl, iPSDEGridEditItem);
					if (!StringHelper.isNullOrEmpty(strCode)) {
						PSGenerateCodeResultImpl psGenerateCodeResult = new PSGenerateCodeResultImpl();
						psGenerateCodeResult.setObject(iPSDEGridEditItem);
						psGenerateCodeResult.setCode(strCode);
						params.put("editor", psGenerateCodeResult);
						return;
					}
				}
			}

			if (true) {
				IPSPFEditorTempl iPSPFEditorTempl = this.iPSPFStyle.getPSPFEditorTempl(iPSEditorType,
						PSPFEditorTempl.CONTAINERTYPE_GRIDCOLUMN, this.getPSPFPubCode());
				if(iPSPFEditorTempl != null) {
					IPSPFEditorCodePublisher psPFEditorCodePublisher = iPSPFEditorTempl.getPSPFEditorCodePublisher();
					if(psPFEditorCodePublisher != null) {
						params.put("editor", psPFEditorCodePublisher.generateCode(this.iPSControl, iPSDEGridEditItem));
					}
				}
			}

		} else if (iPSDEGridColumn instanceof IPSDEGridGroupColumn) {
			IPSDEGridGroupColumn iPSDEGridGroupColumn = (IPSDEGridGroupColumn) iPSDEGridColumn;
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl()
					.getPSPFCtrlTemplDetail(PSJQDEGridViewCodePublisherImpl.CTRLPART_COLUMN)
					.getPSPFCtrlPartCodePublisher();
			ArrayList<IPSGenerateCodeResult> gridColumnList = new ArrayList<IPSGenerateCodeResult>();
			java.util.Iterator<IPSDEGridColumn> psDEGridColumns = iPSDEGridGroupColumn.getPSDEGridColumns();
			while (psDEGridColumns.hasNext()) {
				IPSDEGridColumn iPSDEGridColumn = psDEGridColumns.next();

				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher
						.generateCode(iPSDEGridGroupColumn.getPSDEGrid(), iPSDEGridColumn);
				gridColumnList.add(iPSGenerateCodeResult);
			}

			params.put("columns", gridColumnList);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#onClose()
	 */


}
