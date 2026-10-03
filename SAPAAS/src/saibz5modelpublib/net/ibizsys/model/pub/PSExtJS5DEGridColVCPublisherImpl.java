package net.ibizsys.model.pub;

import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.entity.PSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFEditorTempl;

/**
 * ExtJS 5.0 实体表格列视图代码发布器对象
 * @author Administrator
 *
 */
public class PSExtJS5DEGridColVCPublisherImpl extends PSExtJS5CtrlPartCodePublisherImpl
{
	protected IPSDEGridColumn iPSDEGridColumn = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode( IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEGridColumn = (IPSDEGridColumn)object;
		return super.generateCode( iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		if(iPSDEGridColumn.isEnableRowEdit())
		{
			IPSDEGridEditItem iPSDEGridEditItem = iPSDEGridColumn.getPSDEGridEditItem();
			//根据类型，获取对应的编辑器代码
			IPSEditorType iPSEditorType = this.getPSModelStorageContext().getPSEditorType(iPSDEGridEditItem.getEditorType());
			
//			IPSPFEditorTempl  iPSPFEditorTempl = this.iPSApplication.getPSPFEditorTempl(iPSEditorType,PSPFEditorTempl.CONTAINERTYPE_GRIDCOLUMN,this.getPSPFPubCode(),iPSDEGridEditItem.getEditorStyle());
//			IPSPFEditorCodePublisher psPFEditorCodePublisher =iPSPFEditorTempl.getPSPFEditorCodePublisher();
//			IPSGenerateCodeResult iPSGenerateCodeResult = psPFEditorCodePublisher.generateCode( this.iPSControl,iPSDEGridEditItem);		
//			params.put("editor", iPSGenerateCodeResult);
//			psPFEditorCodePublisher.close();
		}
	}

}
