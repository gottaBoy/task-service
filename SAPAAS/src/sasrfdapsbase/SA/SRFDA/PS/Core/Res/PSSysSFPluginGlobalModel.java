/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.PSSysSFPluginImpl;
import SA.SRFDA.PS.Data.PSSysSFPlugin;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSFPluginGlobalModel
extends PSSystemGlobalModelBase<String, PSSysSFPlugin, IPSSysSFPlugin> {
    private static final Log log = LogFactory.getLog(PSSysSFPluginGlobalModel.class);

    @Override
    protected PSSysSFPlugin GetObject(String strPSSysSFPluginId) {
        PSSysSFPlugin psSysSFPlugin = new PSSysSFPlugin();
        CallResult callResult = this.iPSModelHelper.getPSSysSFPlugin(strPSSysSFPluginId, psSysSFPlugin);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1\u63d2\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysSFPluginId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysSFPlugin;
    }

    @Override
    protected IPSSysSFPlugin OnCreateModelHelper(PSSysSFPlugin vt) throws Exception {
        PSSysSFPluginImpl iPSSysSFPlugin = new PSSysSFPluginImpl();
        iPSSysSFPlugin.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysSFPlugin;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysSFPlugin obj) {
        return false;
    }

    @Override
    protected IPSSysSFPlugin registerModel(PSSysSFPlugin vt) throws Exception {
        IPSSysSFPlugin iPSSysSFPlugin = (IPSSysSFPlugin)this.InternalGetModelHelper(vt.getPSSYSSFPLUGINID());
        if (iPSSysSFPlugin != null) {
            return iPSSysSFPlugin;
        }
        this.setModel(vt.getPSSYSSFPLUGINID(), vt, null);
        iPSSysSFPlugin = (IPSSysSFPlugin)this.FindModelHelper(vt.getPSSYSSFPLUGINID());
        return iPSSysSFPlugin;
    }

    @Override
    protected Vector<PSSysSFPlugin> getAllModels() throws Exception {
        Vector<PSSysSFPlugin> list = new Vector<PSSysSFPlugin>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysSFPlugins(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u670d\u52a1\u63d2\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysSFPlugin vt) {
        return vt.getPSSYSSFPLUGINID();
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }
}

