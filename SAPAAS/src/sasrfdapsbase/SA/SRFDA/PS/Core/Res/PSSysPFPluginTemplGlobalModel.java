/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSSysPFPluginTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPFPluginTemplGlobalModel
extends PSSystemGlobalModelBase<String, PSSysPFPluginTempl, IPSSysPFPluginTempl> {
    private static final Log log = LogFactory.getLog(PSSysPFPluginTemplGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSSysPFPluginTempl GetObject(String strPSSysPFPluginTemplId) {
        PSSysPFPluginTempl psSysPFPluginTempl = new PSSysPFPluginTempl();
        CallResult callResult = this.iPSModelHelper.getPSSysPFPluginTempl(strPSSysPFPluginTemplId, psSysPFPluginTempl);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5e94\u7528\u63d2\u4ef6\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysPFPluginTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        try {
            IPSPF iPSPF = this.getPSModelStorage().getPSPF(psSysPFPluginTempl.getPSPFID(), true);
            if (iPSPF == null) {
                log.error((Object)StringHelper.Format((String)"\u7cfb\u7edf\u5e94\u7528\u63d2\u4ef6\u6a21\u677f[%1$s]\u6846\u67b6[%2$s]\u4e0d\u5b58\u5728", (Object)strPSSysPFPluginTemplId, (Object)psSysPFPluginTempl.getPSPFID()));
                return null;
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
        return psSysPFPluginTempl;
    }

    @Override
    protected IPSSysPFPluginTempl OnCreateModelHelper(PSSysPFPluginTempl vt) throws Exception {
        IPSSysPFPlugin iPSSysPFPlugin = this.getPSSystem().getPSSysPFPlugin(vt.getPSSYSPFPLUGINID());
        IPSSysPFPluginTempl iPSSysPFPluginTempl = iPSSysPFPlugin.getPSPFPluginType().createPSSysPFPluginTempl(vt);
        iPSSysPFPluginTempl.init(this.iDAGlobalHelper, iPSSysPFPlugin, vt);
        return iPSSysPFPluginTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysPFPluginTempl obj) {
        return false;
    }

    @Override
    protected IPSSysPFPluginTempl registerModel(PSSysPFPluginTempl vt) throws Exception {
        IPSSysPFPluginTempl iPSSysPFPluginTempl = (IPSSysPFPluginTempl)this.InternalGetModelHelper(vt.getPSSYSPFPITEMPLID());
        if (iPSSysPFPluginTempl != null) {
            return iPSSysPFPluginTempl;
        }
        this.setModel(vt.getPSSYSPFPITEMPLID(), vt, null);
        iPSSysPFPluginTempl = (IPSSysPFPluginTempl)this.FindModelHelper(vt.getPSSYSPFPITEMPLID());
        return iPSSysPFPluginTempl;
    }

    @Override
    protected Vector<PSSysPFPluginTempl> getAllModels() throws Exception {
        Vector<PSSysPFPluginTempl> list2 = new Vector<PSSysPFPluginTempl>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysPFPluginTempls(this.iPSSystem.getId(), list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u5e94\u7528\u63d2\u4ef6\u6a21\u677f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSSysPFPluginTempl> list = new Vector<PSSysPFPluginTempl>();
        for (PSSysPFPluginTempl psSysPFPluginTempl : list2) {
            IPSPF iPSPF = this.getPSModelStorage().getPSPF(psSysPFPluginTempl.getPSPFID(), true);
            if (iPSPF == null) {
                log.error((Object)StringHelper.Format((String)"\u7cfb\u7edf\u5e94\u7528\u63d2\u4ef6\u6a21\u677f[%1$s]\u6846\u67b6[%2$s]\u4e0d\u5b58\u5728", (Object)psSysPFPluginTempl.getPSSYSPFPITEMPLID(), (Object)psSysPFPluginTempl.getPSPFID()));
                continue;
            }
            list.add(psSysPFPluginTempl);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysPFPluginTempl vt) {
        return vt.getPSSYSPFPITEMPLID();
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

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysPFPluginTempl vt) {
        String strUniqueId;
        if (StringHelper.IsNullOrEmpty((String)vt.getPSPFPUBCODEID()) && StringHelper.IsNullOrEmpty((String)vt.getPSPFPUBCODENAME()) && StringHelper.Compare((String)(strUniqueId = KeyValueHelper.genUniqueId((String)vt.getPSSYSPFPLUGINID(), (String)vt.getPSPFID())), (String)vt.getPSSYSPFPITEMPLID(), (boolean)false) != 0) {
            return new String[]{strUniqueId.toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

