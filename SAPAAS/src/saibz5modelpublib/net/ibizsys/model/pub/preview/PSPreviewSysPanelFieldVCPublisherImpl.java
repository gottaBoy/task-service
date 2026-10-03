package net.ibizsys.model.pub.preview;

import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelField;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSPFEditorTempl;

/**
 * 系统面板属性视图代码发布器对象
 * @author Administrator
 *
 */
public class PSPreviewSysPanelFieldVCPublisherImpl extends PSPreviewSysPanelItemVCPublisherImpl
{
	protected IPSSysPanelField iPSSysPanelField = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception
	{
		iPSSysPanelField = (IPSSysPanelField)object;
		return super.generateCode(iPSPublisherContext, iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		iPSSysPanelField = (IPSSysPanelField)object;
		if(true)
		{
			//根据类型，获取对应的编辑器代码
			IPSEditorType iPSEditorType = this.getPSModelStorage().getPSEditorType(iPSSysPanelField.getEditorType());
			IPSSysPFPlugin iPSSysPFPlugin = null;
			if(iPSSysPanelField.getPSSysEditorStyle()!=null && !iPSSysPanelField.getPSSysPanel().isDesignMode())
			{
				iPSSysPFPlugin = iPSSysPanelField.getPSSysEditorStyle().getPSSysPFPlugin();
			}
			
			if(iPSSysPFPlugin!=null)
			{
				String strCodeName = "";
				if(StringHelper.compare(this.getPSPFPubCode().getName(),"VIEW",true)==0)
				{
					strCodeName = "CODE";
				}
				else if(StringHelper.compare(this.getPSPFPubCode().getName(),"CONTROLLER",true)==0)
				{
					strCodeName = "CODE2";
				}
				
				if(!StringHelper.isNullOrEmpty(strCodeName))
				{
					String strCode = iPSSysPFPlugin.getCode(strCodeName, this.iPSPF.getId(), this.iPSPFStyle.getId(), this.iPSAppView, this.iPSControl, iPSSysPanelField);
					if(!StringHelper.isNullOrEmpty(strCode))
					{
						PSGenerateCodeResultImpl psGenerateCodeResult = new PSGenerateCodeResultImpl();
						psGenerateCodeResult.setObject(iPSSysPanelField);
						psGenerateCodeResult.setCode(strCode);
						params.put("editor", psGenerateCodeResult);
						return;
					}
				}
			}
			
			IPSPFEditorTempl  iPSPFEditorTempl = null;
			if(this.iPSControl.isDesignMode()){
				iPSPFEditorTempl =  this.getPSPFStyle().getPSPFEditorTempl(iPSEditorType, PSPFEditorTempl.CONTAINERTYPE_PANELFIELD, this.getPSPFPubCode());
			}
			else{
				iPSPFEditorTempl = this.iPSApplication.getPSPFEditorTempl(iPSEditorType,PSPFEditorTempl.CONTAINERTYPE_PANELFIELD,this.getPSPFPubCode(),iPSSysPanelField.getEditorStyle());
			}
			
			IPSPFEditorCodePublisher psPFEditorCodePublisher =iPSPFEditorTempl.getPSPFEditorCodePublisher();
			IPSGenerateCodeResult iPSGenerateCodeResult = psPFEditorCodePublisher.generateCode(iPSPublisherContext, this.iPSControl,iPSSysPanelField);		
			params.put("editor", iPSGenerateCodeResult);
			psPFEditorCodePublisher.close();
		}
		
	}
	
	
	@Override
	protected void onClose() {
		this.iPSSysPanelField = null;
		super.onClose();
	}


}
