package net.ibizsys.model.pub.preview;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl;

/**
 * 索引文件清单
 * @author lionlau
 *
 */
public class PSPreviewIndexFileListCodePublisherImpl extends PSPFViewCodePublisherImpl
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
		HashMap<String, IPSAppView> requireAppViewMap = new HashMap<String, IPSAppView>();
		ArrayList<IPSAppView> requireViewList = new ArrayList<IPSAppView> ();
		requireViewList.add(this.iPSAppView);
		requireAppViewMap.put(this.iPSAppView.getId(), iPSAppView);
		while(requireViewList.size()>0)
		{
			IPSAppView iPSAppView = requireViewList.remove(0);
			//if(requireAppViewMap.containsKey(iPSAppView.getId()))
			//	continue;
			//requireAppViewMap.put(iPSAppView.getId(), iPSAppView);
			
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
