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
import net.ibizsys.model.entity.PSSysPFPluginTempl;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.model.res.IPSSysPFPluginTempl;
import net.ibizsys.model.res.PSSysPFPluginTemplImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPFPluginTemplGlobalModel
extends PSSystemGlobalModelBase<String, PSSysPFPluginTempl, IPSSysPFPluginTempl> {
    private static final Log log = LogFactory.getLog(PSSysPFPluginTemplGlobalModel.class);

    @Override
    protected PSSysPFPluginTempl getObject(String strPSSysPFPluginTemplId) {
        PSSysPFPluginTempl psSysPFPluginTempl = new PSSysPFPluginTempl();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, psSysPFPluginTempl);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5e94\u7528\u63d2\u4ef6\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysPFPluginTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysPFPluginTempl;
    }

    @Override
    protected IPSSysPFPluginTempl onCreateModelHelper(PSSysPFPluginTempl vt) throws Exception {
        IPSSysPFPlugin iPSSysPFPlugin = this.getPSSystemRuntime().getPSSysPFPlugin(vt.getPSSYSPFPLUGINID());
        PSSysPFPluginTemplImpl iPSSysPFPluginTempl = new PSSysPFPluginTemplImpl();
        iPSSysPFPluginTempl.init(this.getPSModelStorageContext(), iPSSysPFPlugin, vt);
        return iPSSysPFPluginTempl;
    }

    @Override
    protected Boolean testObjectRenew(PSSysPFPluginTempl obj) {
        return false;
    }

    @Override
    protected IPSSysPFPluginTempl registerModel(PSSysPFPluginTempl vt) throws Exception {
        IPSSysPFPluginTempl iPSSysPFPluginTempl = (IPSSysPFPluginTempl)this.internalGetModelHelper(vt.getPSSYSPFPITEMPLID());
        if (iPSSysPFPluginTempl != null) {
            return iPSSysPFPluginTempl;
        }
        this.setModel(vt.getPSSYSPFPITEMPLID(), vt, null);
        iPSSysPFPluginTempl = (IPSSysPFPluginTempl)this.findModelHelper(vt.getPSSYSPFPITEMPLID());
        return iPSSysPFPluginTempl;
    }

    @Override
    protected Vector<PSSysPFPluginTempl> getAllModels() throws Exception {
        Vector<PSSysPFPluginTempl> list = new Vector<PSSysPFPluginTempl>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysPFPluginTempls(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u5e94\u7528\u63d2\u4ef6\u6a21\u677f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysPFPluginTempl vt) {
        return vt.getPSSYSPFPITEMPLID();
    }
}

