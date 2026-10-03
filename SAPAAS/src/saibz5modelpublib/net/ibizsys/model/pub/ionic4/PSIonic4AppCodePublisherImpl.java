package net.ibizsys.model.pub.ionic4;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;

public class PSIonic4AppCodePublisherImpl extends PSPFAppCodePublisherImpl {

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		PSIonic4TemplHelper.fillParams(params);
		//合成require
		HashMap<String, String> requireClassMap = new HashMap<String, String>();
		ArrayList<String> requireClasses = new ArrayList<String> ();
		
//		java.util.Iterator<IPSAppView> psAppViews =   this.iPSApplication.getAllPSAppViews();
//		while(psAppViews.hasNext())
//		{
//			IPSAppView iPSAppView = psAppViews.next();
//			
//			ArrayList<String> psAppViewIdList = new  ArrayList<String>();
//			iPSAppView.fillRelatedPSAppViewIds(psAppViewIdList);
//			
//			String strFullClassName = this.iPSApplication.getPKGCodeName();
//			if(!StringHelper.IsNullOrEmpty(this.getPSPFPubCode().getPKGCodeName()))
//			{
//				strFullClassName += StringHelper.Format(".%1$s",this.getPSPFPubCode().getPKGCodeName());
//			}
//			
//			if(!StringHelper.IsNullOrEmpty(strFullClassName))
//			{
//				strFullClassName += StringHelper.Format(".");
//			}
//			
//			for(String strPSAppViewId :psAppViewIdList)
//			{
//				IPSAppView iPSAppView2 = this.iPSApplication.getPSAppView(strPSAppViewId);
//				String strAppViewClassName = strFullClassName + iPSAppView2.getFullCodeName();
//				requireClassMap.put(strAppViewClassName, "");
//			}
//		}
		
		requireClasses.addAll(requireClassMap.keySet());
		params.put("requires", requireClasses);
	}	
	
	
}
