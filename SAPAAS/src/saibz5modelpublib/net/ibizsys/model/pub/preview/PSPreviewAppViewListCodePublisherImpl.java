package net.ibizsys.model.pub.preview;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.util.StringHelper;
import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;

/**
 * 应用视图清单
 * 
 * @author lionlau
 *
 */
public class PSPreviewAppViewListCodePublisherImpl extends PSPreviewAppCodePublisherImpl
{
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		//合成require
		HashMap<String, IPSAppView> requireAppViewMap = new HashMap<String, IPSAppView>();
		ArrayList<IPSAppView> requireViewList = new ArrayList<IPSAppView> ();
		
		java.util.Iterator<IPSAppView> psAppViews =   this.iPSApplication.getAllPSAppViews();
		while(psAppViews.hasNext())
		{
			IPSAppView iPSAppView = psAppViews.next();
			if(!StringHelper.isNullOrEmpty(iPSAppView.getSubAppFolderName()))
				continue;
			if(!(iPSAppView instanceof IPSAppIndexView))
			{
				if(!iPSAppView.isUserRefMode())
					continue;
			}
			requireViewList.add(iPSAppView);
		}
		
		while(requireViewList.size()>0)
		{
			IPSAppView iPSAppView = requireViewList.remove(0);
			if(requireAppViewMap.containsKey(iPSAppView.getId()))
				continue;
			requireAppViewMap.put(iPSAppView.getId(), iPSAppView);
			
			ArrayList<IPSAppView> psAppViewList = new  ArrayList<IPSAppView>();
			iPSAppView.fillRelatedPSAppViews(psAppViewList);
			
			for(IPSAppView iPSAppView2 :psAppViewList)
			{
				if(requireAppViewMap.containsKey(iPSAppView2.getId()))
					continue;
				
				requireAppViewMap.put(iPSAppView2.getId(), iPSAppView2);
				requireViewList.add(iPSAppView2);
			}
		}
		
		requireViewList.clear();
		requireViewList.addAll(requireAppViewMap.values());
		params.put("requireviews", requireViewList);
	
	}	
}
