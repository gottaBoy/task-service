package net.ibizsys.model.pub.ionic;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.PSFR7TemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFAppCodePublisherImpl;

public class PSIonicAppCodePublisherImpl extends PSPFAppCodePublisherImpl
{
	private static PSIonicFileNameMethod psIonicFileNameMethod = new PSIonicFileNameMethod();

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		PSFR7TemplHelper.fillParams(params);
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
		params.put("ionicclassname", psIonicFileNameMethod);
	}	
	
	
}
