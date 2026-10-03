package net.ibizsys.model.pub.preview;

import java.util.HashMap;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFramework.Utility.StringHelper;

public class PSPreviewIndexJspCodePublisherImpl extends PSPreviewViewCodePublisherImpl
{
	@Override
	protected String getPSAppViewCodeName(IPSAppView iPSAppView)
	{
		return iPSAppView.getCodeName().toLowerCase();
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		//合成require
//		ArrayList<String> psAppViewIdList = new  ArrayList<String>();
//		this.iPSAppView.fillRelatedPSAppViewIds(psAppViewIdList);
		
		String strFullClassName = this.iPSApplication.getPKGCodeName();
		strFullClassName += StringHelper.Format(".view");
		
		if(!StringHelper.IsNullOrEmpty(strFullClassName))
		{
			strFullClassName += StringHelper.Format(".");
		}
		strFullClassName+= this.iPSAppView.getFullCodeName();
		
		params.put("viewportname", strFullClassName);
	}
}
