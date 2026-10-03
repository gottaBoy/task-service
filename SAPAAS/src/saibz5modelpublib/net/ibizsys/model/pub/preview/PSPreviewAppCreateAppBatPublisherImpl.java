package net.ibizsys.model.pub.preview;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;

/**
 * 默认视图
 * 
 * @author lionlau
 *
 */
public class PSPreviewAppCreateAppBatPublisherImpl extends PSPreviewAppCodePublisherImpl
{
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		ArrayList<IPSAppView> indexViewList = new ArrayList<IPSAppView> ();
		java.util.Iterator<IPSAppView> psAppViews = this.iPSApplication.getAllPSAppViews();
		while(psAppViews.hasNext())
		{
			IPSAppView iPSAppView = psAppViews.next();
			if(!this.iPSApplication.isPubRefViewOnly() || iPSAppView.getRefFlag()){
				if(iPSAppView instanceof IPSAppIndexView)
				{
					indexViewList.add(iPSAppView);
				}
			}
		}
			
		
		params.put("indexviews", indexViewList);
	
	}	
}
