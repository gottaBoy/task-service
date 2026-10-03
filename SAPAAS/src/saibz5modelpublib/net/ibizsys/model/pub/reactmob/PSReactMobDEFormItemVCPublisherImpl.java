package net.ibizsys.model.pub.reactmob;

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
 * JQ实体表单项视图代码发布对象
 * @author Administrator
 *
 */
public class PSReactMobDEFormItemVCPublisherImpl extends PSReactMobDEFormDetailVCPublisherImpl
{
	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(PSReactMobDEFormItemVCPublisherImpl.class);
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
				String strCodeName = "";
				String strCodeName2 = "";
				if(StringHelper.compare(this.getPSPFPubCode().getName(),"CONTROL",true)==0)
				{
					strCodeName = "CODE";
					strCodeName2 = "CODE2";
				}
				
				if(!StringHelper.isNullOrEmpty(strCodeName) && !StringHelper.isNullOrEmpty(strCodeName2))
				{
					String strCode = iPSSysPFPlugin.getCode(strCodeName, this.iPSPF.getId(), this.iPSPFStyle.getId(), this.iPSAppView, this.iPSControl, iPSDEFormItem);
					String strCode2 = iPSSysPFPlugin.getCode(strCodeName2, this.iPSPF.getId(), this.iPSPFStyle.getId(), this.iPSAppView, this.iPSControl, iPSDEFormItem);
					if(!StringHelper.isNullOrEmpty(strCode))
					{
						PSGenerateCodeResultImpl psGenerateCodeResult = new PSGenerateCodeResultImpl();
						psGenerateCodeResult.setObject(iPSDEFormItem);
						psGenerateCodeResult.setCode(strCode);
						psGenerateCodeResult.setCode2(strCode2);
						params.put("editor", psGenerateCodeResult);
						return;
					}
				}
			}
			if(true)
			{
				IPSPFEditorTempl  iPSPFEditorTempl = this.iPSApplication.getPSPFEditorTempl(iPSEditorType,PSPFEditorTempl.CONTAINERTYPE_FORMITEM,this.getPSPFPubCode(),iPSDEFormItem.getEditorStyle());
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
