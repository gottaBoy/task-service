/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppIndexView
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu
 *  SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem
 *  SA.SRFDA.PS.Core.PF.IPSPFViewTempl
 *  SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFDA.PS.Core.Pub.PSPublishContextImpl
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.ReactMob;

import SA.SRFDA.PS.Core.App.View.IPSAppIndexView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.Pub.ReactMob.PSReactMobViewCodePublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSReactMobIndexViewViewCodePublisherImpl
extends PSReactMobViewCodePublisherImpl {
    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        if (this.iPSAppView instanceof IPSAppIndexView) {
            IPSAppIndexView iPSAppIndexView = (IPSAppIndexView)this.iPSAppView;
            IPSAppMenu iPSAppMenu = iPSAppIndexView.getPSAppMenu();
            if (iPSAppMenu != null && iPSAppMenu.getPSAppMenuItems() != null) {
                Iterator psAppMenuItems = iPSAppMenu.getPSAppMenuItems();
                while (psAppMenuItems.hasNext()) {
                    IPSAppMenuItem psAppMenuItem = (IPSAppMenuItem)psAppMenuItems.next();
                    if (psAppMenuItem.getPSAppFunc() == null || psAppMenuItem.getPSAppFunc().getPSAppView() == null) continue;
                    IPSAppView subPSAppView = psAppMenuItem.getPSAppFunc().getPSAppView();
                    PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl(this.getDAGlobalHelper(), null);
                    Iterator psPFViewTempls = this.iPSPFStyle.getPSPFViewTempls(subPSAppView);
                    while (psPFViewTempls.hasNext()) {
                        IPSPFViewTempl iPSPFViewTempl = (IPSPFViewTempl)psPFViewTempls.next();
                        if (StringHelper.Compare((String)iPSPFViewTempl.getPSPFPubCode().getId(), (String)this.getPSPFPubCode().getId(), (boolean)true) != 0) continue;
                        IPSPFViewCodePublisher iPSPFViewCodePublisher = iPSPFViewTempl.getPSPFViewCodePublisher();
                        String strCode = iPSPFViewCodePublisher.generateCode2((IPSPublisherContext)psPublishContextImpl, subPSAppView, null);
                        iPSPFViewCodePublisher.close();
                        this.psSubCodeMethod.registerSubCode(StringHelper.Format((String)"CODE_%1$s", (Object)subPSAppView.getId()), strCode);
                    }
                }
            }
            HashMap<String, IPSAppView> requireAppViewMap = new HashMap<String, IPSAppView>();
            ArrayList<Object> requireViewList = new ArrayList<Object>();
            requireViewList.add(this.iPSAppView);
            requireAppViewMap.put(this.iPSAppView.getId(), this.iPSAppView);
            while (requireViewList.size() > 0) {
                IPSAppView iPSAppView = (IPSAppView)requireViewList.remove(0);
                ArrayList psAppViewList = new ArrayList();
                iPSAppView.fillRelatedPSAppViews(psAppViewList);
                for (IPSAppView iPSAppView2 : psAppViewList) {
                    if (requireAppViewMap.containsKey(iPSAppView2.getId())) continue;
                    requireAppViewMap.put(iPSAppView2.getId(), iPSAppView2);
                    requireViewList.add(iPSAppView2);
                }
            }
            requireViewList.clear();
            requireViewList.addAll(requireAppViewMap.values());
            params.put("requireviews", requireViewList);
        }
    }
}

