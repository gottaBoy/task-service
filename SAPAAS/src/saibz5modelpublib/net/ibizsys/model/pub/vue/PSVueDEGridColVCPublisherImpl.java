package net.ibizsys.model.pub.vue;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridGroupColumn;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSJQDEGridViewCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSPFEditorTempl;

/**
 * JQ实体表格列视图代码发布器对象
 * 
 * @author Administrator
 *
 */
public class PSVueDEGridColVCPublisherImpl extends PSVueCtrlPartCodePublisherImpl {
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
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl,
			Object object) throws Exception {
		iPSDEGridColumn = (IPSDEGridColumn) object;
		return super.generateCode(iPSPublisherContext, iPSControl, object);
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
			IPSEditorType iPSEditorType = this.getPSModelStorage().getPSEditorType(iPSDEGridEditItem.getEditorType());
			if (iPSDEGridEditItem.getPSSysEditorStyle() != null) {
				iPSSysPFPlugin = iPSDEGridEditItem.getPSSysEditorStyle().getPSSysPFPlugin();
			}

			if (iPSSysPFPlugin != null) {
				String strCodeName = "";
				if (StringHelper.compare(this.getPSPFPubCode().getName(), "HTML", true) == 0) {
					strCodeName = "CODE";
				} else if (StringHelper.compare(this.getPSPFPubCode().getName(), "SERVICE_TS", true) == 0) {
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
				IPSPFEditorTempl iPSPFEditorTempl = this.iPSApplication.getPSPFEditorTempl(iPSEditorType,
						PSPFEditorTempl.CONTAINERTYPE_GRIDCOLUMN, this.getPSPFPubCode(),
						iPSDEGridEditItem.getEditorStyle());
				IPSPFEditorCodePublisher psPFEditorCodePublisher = iPSPFEditorTempl.getPSPFEditorCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = psPFEditorCodePublisher.generateCode(iPSPublisherContext,
						this.iPSControl, iPSDEGridEditItem);
				params.put("editor", iPSGenerateCodeResult);
				psPFEditorCodePublisher.close();
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
						.generateCode(iPSPublisherContext, iPSDEGridGroupColumn.getPSDEGrid(), iPSDEGridColumn);
				gridColumnList.add(iPSGenerateCodeResult);
			}

			iPSPFCtrlPartCodePublisher.close();
			params.put("columns", gridColumnList);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose() {
		this.iPSDEGridColumn = null;
		super.onClose();
	}

}
