/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSSysPFPlugin;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.model.res.PSSysPFPluginImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPFPluginGlobalModel
extends PSSystemGlobalModelBase<String, PSSysPFPlugin, IPSSysPFPlugin> {
    private static final Log log = LogFactory.getLog(PSSysPFPluginGlobalModel.class);

    @Override
    protected PSSysPFPlugin getObject(String strPSSysPFPluginId) {
        PSSysPFPlugin psSysPFPlugin = new PSSysPFPlugin();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysPFPlugin(strPSSysPFPluginId, psSysPFPlugin);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5e94\u7528\u63d2\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysPFPluginId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysPFPlugin;
    }

    @Override
    protected IPSSysPFPlugin onCreateModelHelper(PSSysPFPlugin vt) throws Exception {
        PSSysPFPluginImpl iPSSysPFPlugin = new PSSysPFPluginImpl();
        iPSSysPFPlugin.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSysPFPlugin;
    }

    @Override
    protected Boolean testObjectRenew(PSSysPFPlugin obj) {
        return false;
    }

    @Override
    protected IPSSysPFPlugin registerModel(PSSysPFPlugin vt) throws Exception {
        IPSSysPFPlugin iPSSysPFPlugin = (IPSSysPFPlugin)this.internalGetModelHelper(vt.getPSSYSPFPLUGINID());
        if (iPSSysPFPlugin != null) {
            return iPSSysPFPlugin;
        }
        this.setModel(vt.getPSSYSPFPLUGINID(), vt, null);
        iPSSysPFPlugin = (IPSSysPFPlugin)this.findModelHelper(vt.getPSSYSPFPLUGINID());
        return iPSSysPFPlugin;
    }

    @Override
    protected Vector<PSSysPFPlugin> getAllModels() throws Exception {
        Vector<PSSysPFPlugin> list = new Vector<PSSysPFPlugin>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysPFPlugins(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u5e94\u7528\u63d2\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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

