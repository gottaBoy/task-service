package net.ibizsys.model.pub.preview;

import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSPFEditorTempl;

/**
 * PreViewPC实体表单项视图代码发布对象
 * @author Administrator
 *
 */
public class PSPreviewDEFormItemVCPublisherImpl extends PSPreviewDEFormDetailVCPublisherImpl
{
	protected IPSDEFormItem iPSDEFormItem = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEFormItem = (IPSDEFormItem)object;
		return super.generateCode(iPSPublisherContext, iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		if(true)
		{
			//根据类型，获取对应的编辑器代码
			IPSEditorType iPSEditorType = this.getPSModelStorage().getPSEditorType(iPSDEFormItem.getEditorType());
			IPSSysPFPlugin iPSSysPFPlugin = null;
			if(iPSDEFormItem.getPSSysEditorStyle()!=null)
			{
				iPSSysPFPlugin = iPSDEFormItem.getPSSysEditorStyle().getPSSysPFPlugin();
			}
			
			if(iPSSysPFPlugin!=null)
			{
				if(iPSSysPFPlugin.getPSPFPluginTempl(this.iPSPF.getId(), null, true)!=null){
					String strCodeName = "";
					if(StringHelper.compare(this.getPSPFPubCode().getName(),"PART",true)==0)
					{
						strCodeName = "CODE";
					}
					else if(StringHelper.compare(this.getPSPFPubCode().getName(),"CONTROLLER",true)==0)
					{
						strCodeName = "CODE2";
					}
					
					if(!StringHelper.isNullOrEmpty(strCodeName))
					{
						String strCode = iPSSysPFPlugin.getCode(strCodeName, this.iPSPF.getId(), this.iPSPFStyle.getId(), this.iPSAppView, this.iPSControl, iPSDEFormItem);
						if(!StringHelper.isNullOrEmpty(strCode))
						{
							PSGenerateCodeResultImpl psGenerateCodeResult = new PSGenerateCodeResultImpl();
							psGenerateCodeResult.setObject(iPSDEFormItem);
							psGenerateCodeResult.setCode(strCode);
							params.put("editor", psGenerateCodeResult);
							return;
						}
					}
				}
			}
			if(true)
			{
				IPSPFEditorTempl  iPSPFEditorTempl = null;
				if(this.iPSControl.isDesignMode()){
					iPSPFEditorTempl =  this.getPSPFStyle().getPSPFEditorTempl(iPSEditorType, PSPFEditorTempl.CONTAINERTYPE_FORMITEM, this.getPSPFPubCode());
				}
				else{
					iPSPFEditorTempl = this.iPSApplication.getPSPFEditorTempl(iPSEditorType,PSPFEditorTempl.CONTAINERTYPE_FORMITEM,this.getPSPFPubCode(),iPSDEFormItem.getEditorStyle());
				}
				
				IPSPFEditorCodePublisher psPFEditorCodePublisher =iPSPFEditorTempl.getPSPFEditorCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = psPFEditorCodePublisher.generateCode(iPSPublisherContext, this.iPSControl,iPSDEFormItem);		
				params.put("editor", iPSGenerateCodeResult);
				psPFEditorCodePublisher.close();
			}
		}
		
	}
	

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDEFormItem = null;
		super.onClose();
	}

}
