package net.ibizsys.model.pub.reactmob;

import java.util.HashMap;

import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;

/**
 * 默认视图
 * 
 * @author lionlau
 *
 */
public class PSReactMobAppDefaultPageCodePublisherImpl extends PSReactMobAppCodePublisherImpl
{
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		IPSAppIndexView iPSAppIndexView = null;
		java.util.Iterator<IPSAppView> psAppViews =   this.iPSApplication.getAllPSAppViews();
		while(psAppViews.hasNext())
		{
			IPSAppView iPSAppView = psAppViews.next();
			if(!(iPSAppView instanceof IPSAppIndexView))
			{
				continue;
			}
			
			if(iPSAppIndexView == null)
			{
				iPSAppIndexView = (IPSAppIndexView)iPSAppView;
			}
			
			if(((IPSAppIndexView)iPSAppView).isDefaultPage())
			{
				iPSAppIndexView = (IPSAppIndexView)iPSAppView;
				break;
			}
		}
		
		params.put("defaultview", iPSAppIndexView);
	
	}	
}
