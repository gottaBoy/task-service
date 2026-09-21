/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Mob;

import SA.SRFDA.PS.Core.App.Mob.IPSMobAppIcon;
import SA.SRFDA.PS.Core.App.Mob.PSMobAppIconImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSMobAppStartPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMobAppIconGlobalModel
extends PSApplicationGlobalModelBase<String, PSMobAppStartPage, IPSMobAppIcon> {
    private static final Log log = LogFactory.getLog(PSMobAppIconGlobalModel.class);

    @Override
    protected PSMobAppStartPage GetObject(String strPSMobAppStartPageId) {
        PSMobAppStartPage psMobAppStartPage = new PSMobAppStartPage();
        CallResult callResult = this.iPSModelHelper.getPSMobAppStartPage(strPSMobAppStartPageId, psMobAppStartPage);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u79fb\u52a8\u5e94\u7528\u56fe\u6807[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSMobAppStartPageId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.Compare((String)psMobAppStartPage.getRESTYPE(), (String)"ICON", (boolean)true) == 0) {
            return psMobAppStartPage;
        }
        return null;
    }

    @Override
    protected IPSMobAppIcon OnCreateModelHelper(PSMobAppStartPage vt) throws Exception {
        PSMobAppIconImpl iPSMobAppStartPage = new PSMobAppIconImpl();
        iPSMobAppStartPage.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSMobAppStartPage;
    }

    @Override
    protected Boolean TestObjectRenew(PSMobAppStartPage obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSMobAppStartPage vt) {
        return vt.getPSMOBAPPSTARTPAGEID();
    }

    @Override
    protected IPSMobAppIcon registerModel(PSMobAppStartPage vt) throws Exception {
        IPSMobAppIcon iPSMobAppStartPage = (IPSMobAppIcon)this.InternalGetModelHelper(vt.getPSMOBAPPSTARTPAGEID());
        if (iPSMobAppStartPage != null) {
            return iPSMobAppStartPage;
        }
        this.setModel(vt.getPSMOBAPPSTARTPAGEID(), vt, null);
        return (IPSMobAppIcon)this.FindModelHelper(vt.getPSMOBAPPSTARTPAGEID());
    }

    @Override
    protected Vector<PSMobAppStartPage> getAllModels() throws Exception {
        Vector<PSMobAppStartPage> list2 = new Vector<PSMobAppStartPage>();
        CallResult callResult = this.iPSModelHelper.getAllPSMobAppStartPages(this.iPSApplication.getId(), list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u79fb\u52a8\u5e94\u7528\u56fe\u6807\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSMobAppStartPage> list = new Vector<PSMobAppStartPage>();
        for (PSMobAppStartPage psMobAppStartPage : list2) {
            if (StringHelper.Compare((String)psMobAppStartPage.getRESTYPE(), (String)"ICON", (boolean)true) != 0) continue;
            list.add(psMobAppStartPage);
        }
        for (PSMobAppStartPage psMobAppStartPage : list) {
            this.setModel(psMobAppStartPage.getPSMOBAPPSTARTPAGEID(), psMobAppStartPage, null);
            this.setModel(psMobAppStartPage.getPSMOBAPPSTARTPAGENAME(), psMobAppStartPage, null);
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40010, objObjectId);
    }
}

