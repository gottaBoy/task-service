/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppRedirectView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.app.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppRedirectView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.PSAppViewImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSAppRedirectViewImpl
extends PSAppViewImpl
implements IPSAppRedirectView {
    private HashMap<String, IPSAppView> redirectPSAppViewMap = new HashMap();
    private HashMap<String, IPSAppView> refRedirectPSAppViewMap = new HashMap();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public boolean isEnableDP() {
        return true;
    }

    public boolean isEnableWF() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u5b9a\u5411\u89c6\u56fe")
    public boolean isRedirectView() {
        return true;
    }

    protected void registerRedirectPSAppView(String strRDMode, IPSAppView iPSAppView) {
        this.redirectPSAppViewMap.put(strRDMode.toUpperCase(), iPSAppView);
    }

    public Iterator<IPSAppView> getRedirectPSAppViews() {
        if (this.redirectPSAppViewMap.size() == 0) {
            return null;
        }
        return this.redirectPSAppViewMap.values().iterator();
    }

    public Iterator<String> getRedirectModes() {
        if (this.redirectPSAppViewMap.size() == 0) {
            return null;
        }
        return this.redirectPSAppViewMap.keySet().iterator();
    }

    public IPSAppView getRedirectPSAppView(String strRDMode, boolean bTryMode) throws Exception {
        IPSAppView iPSAppView = this.redirectPSAppViewMap.get(strRDMode.toUpperCase());
        if (iPSAppView == null && !bTryMode) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a[%1$s]\u91cd\u5b9a\u5411\u89c6\u56fe", (Object)strRDMode));
        }
        return iPSAppView;
    }

    @Override
    protected void onPreparePSAppViewRefs() throws Exception {
        super.onPreparePSAppViewRefs();
        String strRefHeader = "RDITEM:";
        Iterator<String> refModes = this.getAppViewRefModes();
        if (refModes != null) {
            while (refModes.hasNext()) {
                String strRefMode = refModes.next();
                if (strRefMode.indexOf(strRefHeader) != 0) continue;
                IPSAppView refPSAppView = this.getRefPSAppView(strRefMode, false);
                String strRDMode = strRefMode.substring(strRefHeader.length());
                this.registerRedirectPSAppView(strRDMode, refPSAppView);
                this.refRedirectPSAppViewMap.put(strRDMode, refPSAppView);
            }
        }
    }

    @Override
    public String getModelType() {
        return null;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        relatedAppViewList.addAll(this.redirectPSAppViewMap.values());
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    public Iterator<String> getRefRedirectModes() {
        if (this.refRedirectPSAppViewMap.size() == 0) {
            return null;
        }
        return this.refRedirectPSAppViewMap.keySet().iterator();
    }
}

