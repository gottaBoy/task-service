package net.ibizsys.model.pub;

import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.res.IPSSysEditorStyleRuntime;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.paas.util.StringHelper;

/**
 * NG实体表单项视图代码发布对象
 * @author Administrator
 *
 */
public class PSNGDEFormItemVCPublisherImpl extends PSNGDEFormDetailVCPublisherImpl
{
	protected IPSDEFormItem iPSDEFormItem = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEFormItem = (IPSDEFormItem)object;
		return super.generateCode(iPSControl, object);
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
			IPSEditorType iPSEditorType = this.getPSModelStorageContext().getPSEditorType(iPSDEFormItem.getEditorType());
			IPSSysPFPlugin iPSSysPFPlugin = null;
			if(iPSDEFormItem.getPSSysEditorStyle()!=null)
			{
				iPSSysPFPlugin = ((IPSSysEditorStyleRuntime) iPSDEFormItem.getPSSysEditorStyle()).getPSSysPFPlugin();
			}
			
			if(iPSSysPFPlugin!=null)
			{
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
//			if(true)
//			{
//				IPSPFEditorTempl  iPSPFEditorTempl = this.iPSApplication.getPSPFEditorTempl(iPSEditorType,PSPFEditorTempl.CONTAINERTYPE_FORMITEM,this.getPSPFPubCode(),iPSDEFormItem.getEditorStyle());
//				IPSPFEditorCodePublisher psPFEditorCodePublisher =iPSPFEditorTempl.getPSPFEditorCodePublisher();
//				IPSGenerateCodeResult iPSGenerateCodeResult = psPFEditorCodePublisher.generateCode(iPSPublisherContext, this.iPSControl,iPSDEFormItem);		
//				params.put("editor", iPSGenerateCodeResult);
//				psPFEditorCodePublisher.close();
//			}
		}
		
	}
	

}
