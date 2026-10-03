package net.ibizsys.model.pub.ionic4;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFramework.Utility.StringHelper;

/**
 * 首页视图
 * @author Administrator
 *
 */
public class PSIonic4IndexViewViewCodePublisherImpl extends PSIonic4ViewCodePublisherImpl {

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
		super.onFillGenerateCodeParams(params);
		//获取主菜单
		if(this.iPSAppView instanceof IPSAppIndexView) {
			IPSAppIndexView iPSAppIndexView =(IPSAppIndexView)this.iPSAppView;
			IPSAppMenu iPSAppMenu = iPSAppIndexView.getPSAppMenu();
			if(iPSAppMenu != null && iPSAppMenu.getPSAppMenuItems()!=null) {
				java.util.Iterator<IPSAppMenuItem> psAppMenuItems = iPSAppMenu.getPSAppMenuItems();
				while(psAppMenuItems.hasNext()) {
					IPSAppMenuItem psAppMenuItem = psAppMenuItems.next();
					if(psAppMenuItem.getPSAppFunc()!=null && psAppMenuItem.getPSAppFunc().getPSAppView()!=null) {
						IPSAppView subPSAppView = psAppMenuItem.getPSAppFunc().getPSAppView();
						//生成对应的代码
						PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(),null);
						//psPublishContextImpl.setPSSysModelInstId(this.iPSAppView.getPSDevSlnSysId());
						//找到对应的发布器
						java.util.Iterator<IPSPFViewTempl> psPFViewTempls= iPSPFStyle.getPSPFViewTempls(subPSAppView);
						while(psPFViewTempls.hasNext()) {
							IPSPFViewTempl iPSPFViewTempl = psPFViewTempls.next();
							if(StringHelper.Compare(iPSPFViewTempl.getPSPFPubCode().getId(), this.getPSPFPubCode().getId(), true)==0) {
								IPSPFViewCodePublisher	iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
								String strCode = iPSPFViewCodePublisher.generateCode2(psPublishContextImpl, subPSAppView,null);
								iPSPFViewCodePublisher.close();
								
								if(psSubCodeMethod!=null){
									psSubCodeMethod.registerSubCode(StringHelper.Format("CODE_%1$s",subPSAppView.getId()),strCode);
								}
								else{
									throw new Exception("子代码辅助方法无效");
								}
							}
						}
					}
				}
			}
			
			if(iPSAppMenu != null && iPSAppMenu.getPSAppMenuItems() != null) {
				ArrayList<IPSAppMenuItem> menuList = new ArrayList<IPSAppMenuItem>();
				this.getAppMenus(menuList, iPSAppMenu.getPSAppMenuItems());
				params.put("appmenus", menuList);
			}
			
			//合成require 
			HashMap<String, IPSAppView> requireAppViewMap = new HashMap<String, IPSAppView>();
			ArrayList<IPSAppView> requireViewList = new ArrayList<IPSAppView> ();
			requireViewList.add(this.iPSAppView);
			requireAppViewMap.put(this.iPSAppView.getId(), iPSAppView);
			while(requireViewList.size()>0) {
				IPSAppView iPSAppView = requireViewList.remove(0);
				ArrayList<IPSAppView> psAppViewList = new  ArrayList<IPSAppView>();
				iPSAppView.fillRelatedPSAppViews(psAppViewList);
				
				for(IPSAppView iPSAppView2 :psAppViewList) {
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

	protected void getAppMenus(ArrayList<IPSAppMenuItem> menuList, java.util.Iterator<IPSAppMenuItem> psAppMenuItems) throws Exception {
		while(psAppMenuItems.hasNext()) {
			IPSAppMenuItem psAppMenuItem = psAppMenuItems.next();
			if(psAppMenuItem.getPSAppFunc() != null && psAppMenuItem.getPSAppFunc().getPSAppView() != null) {
				menuList.add(psAppMenuItem);
			}
			if (psAppMenuItem.getPSAppMenuItems() != null) {
				this.getAppMenus(menuList, psAppMenuItem.getPSAppMenuItems());
			}
		}
	}

}