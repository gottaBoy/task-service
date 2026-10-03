package net.ibizsys.model.pub.ionic4;

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
public class PSIonic4AppDefaultPageCodePublisherImpl extends PSIonic4AppCodePublisherImpl {
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
		super.onFillGenerateCodeParams(params);
		
		IPSAppIndexView iPSAppIndexView = null;
		java.util.Iterator<IPSAppView> psAppViews =   this.iPSApplication.getAllPSAppViews();
		while(psAppViews.hasNext()) {
			IPSAppView iPSAppView = psAppViews.next();
			if(!(iPSAppView instanceof IPSAppIndexView)) {
				continue;
			}
			
			if(iPSAppIndexView == null) {
				iPSAppIndexView = (IPSAppIndexView)iPSAppView;
			}
			
			if(((IPSAppIndexView)iPSAppView).isDefaultPage()) {
				iPSAppIndexView = (IPSAppIndexView)iPSAppView;
				break;
			}
		}
		HashMap<String,IPSAppView> views= new HashMap<String, IPSAppView>();
		if (iPSAppIndexView != null) {
			views.put(iPSAppIndexView.getId(), iPSAppIndexView);
			this.addChildViews(views, iPSAppIndexView);
		}
		ArrayList<IPSAppView> arrList = new ArrayList<IPSAppView>();
		arrList.addAll(views.values());
		params.put("defaultview", iPSAppIndexView);
		params.put("referenceViews", arrList);
	}
	
	private void addChildViews(HashMap<String,IPSAppView> views, IPSAppView view) throws Exception {
		if (view != null) {			
			java.util.Iterator<IPSAppView> childViews = view.getAllRelatedPSAppViews();
			while(childViews.hasNext()) {
				IPSAppView iPSAppView = childViews.next();
				if (!views.containsKey(iPSAppView.getId())) {					
					views.put(iPSAppView.getId(), iPSAppView);
					this.addChildViews(views, iPSAppView);
				}
			}
		}
	}
	
}
