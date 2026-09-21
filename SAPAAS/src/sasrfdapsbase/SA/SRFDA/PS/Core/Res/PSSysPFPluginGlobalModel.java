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

import SA.SRFDA.PS.Core.PF.IPSPFPluginType;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSSysPFPlugin;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPFPluginGlobalModel
extends PSSystemGlobalModelBase<String, PSSysPFPlugin, IPSSysPFPlugin> {
    private static final Log log = LogFactory.getLog(PSSysPFPluginGlobalModel.class);

    @Override
    protected PSSysPFPlugin GetObject(String strPSSysPFPluginId) {
        PSSysPFPlugin psSysPFPlugin = new PSSysPFPlugin();
        CallResult callResult = this.iPSModelHelper.getPSSysPFPlugin(strPSSysPFPluginId, psSysPFPlugin);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5e94\u7528\u63d2\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysPFPluginId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysPFPlugin;
    }

    @Override
    protected IPSSysPFPlugin OnCreateModelHelper(PSSysPFPlugin vt) throws Exception {
        IPSPFPluginType iPSPFPluginType = this.iPSModelStorage.getPSPFPluginType(vt.getPLUGINTYPE());
        IPSSysPFPlugin iPSSysPFPlugin = iPSPFPluginType.createPSSysPFPlugin(vt);
        iPSSysPFPlugin.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysPFPlugin;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysPFPlugin obj) {
        return false;
    }

    @Override
    protected IPSSysPFPlugin registerModel(PSSysPFPlugin vt) throws Exception {
        IPSSysPFPlugin iPSSysPFPlugin = (IPSSysPFPlugin)this.InternalGetModelHelper(vt.getPSSYSPFPLUGINID());
        if (iPSSysPFPlugin != null) {
            return iPSSysPFPlugin;
        }
        this.setModel(vt.getPSSYSPFPLUGINID(), vt, null);
        iPSSysPFPlugin = (IPSSysPFPlugin)this.FindModelHelper(vt.getPSSYSPFPLUGINID());
        return iPSSysPFPlugin;
    }

    @Override
    protected Vector<PSSysPFPlugin> getAllModels() throws Exception {
        Vector<PSSysPFPlugin> list = new Vector<PSSysPFPlugin>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysPFPlugins(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u5e94\u7528\u63d2\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysPFPlugin vt) {
        return vt.getPSSYSPFPLUGINID();
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

