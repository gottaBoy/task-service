/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppRedirectView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSAppViewRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSAppRedirectViewImpl
extends PSAppViewImpl
implements IPSAppRedirectView {
    private Map<String, IPSAppView> redirectPSAppViewMap = new LinkedHashMap<String, IPSAppView>();
    private Map<String, IPSAppViewRef> redirectPSAppViewRefMap = new LinkedHashMap<String, IPSAppViewRef>();
    private Map<String, IPSAppView> refRedirectPSAppViewMap = new LinkedHashMap<String, IPSAppView>();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public boolean isEnableDP() {
        return true;
    }

    @Override
    public boolean isEnableWF() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u5b9a\u5411\u89c6\u56fe")
    public boolean isRedirectView() {
        return true;
    }

    protected void registerRedirectPSAppView(String strRDMode, IPSAppView iPSAppView) throws Exception {
        this.registerRedirectPSAppView(strRDMode, iPSAppView, null);
    }

    protected void registerRedirectPSAppView(String strRDMode, IPSAppView iPSAppView, PSAppViewRef psAppViewRef) throws Exception {
        strRDMode = strRDMode.toUpperCase();
        this.redirectPSAppViewMap.put(strRDMode, iPSAppView);
        if (psAppViewRef == null) {
            psAppViewRef = new PSAppViewRef();
        }
        psAppViewRef.setPSAPPVIEWREFNAME(strRDMode);
        psAppViewRef.setPSAPPVIEWREFID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strRDMode));
        psAppViewRef.setMINORPSAPPVIEWID(iPSAppView.getId());
        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
        psAppViewRefImpl.init(this.getDAGlobalHelper(), this, psAppViewRef);
        psAppViewRefImpl.setRefPSAppView(iPSAppView);
        this.redirectPSAppViewRefMap.put(strRDMode, psAppViewRefImpl);
    }

    @Override
    public Iterator<IPSAppView> getRedirectPSAppViews() {
        if (this.redirectPSAppViewMap.size() == 0) {
            return null;
        }
        return this.redirectPSAppViewMap.values().iterator();
    }

    @Override
    public Iterator<String> getRedirectModes() {
        if (this.redirectPSAppViewMap.size() == 0) {
            return null;
        }
        return this.redirectPSAppViewMap.keySet().iterator();
    }

    @Override
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

    @Override
    public Iterator<String> getRefRedirectModes() {
        if (this.refRedirectPSAppViewMap.size() == 0) {
            return null;
        }
        return this.refRedirectPSAppViewMap.keySet().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u5b9a\u5411\u89c6\u56fe\u5f15\u7528\u96c6\u5408", child=true)
    public Iterator<IPSAppViewRef> getRedirectPSAppViewRefs() {
        if (this.redirectPSAppViewRefMap.size() == 0) {
            return null;
        }
        return this.redirectPSAppViewRefMap.values().iterator();
    }
}

