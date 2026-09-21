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

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.PSSysSFPluginTemplImpl;
import SA.SRFDA.PS.Data.PSSysSFPluginTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSFPluginTemplGlobalModel
extends PSSystemGlobalModelBase<String, PSSysSFPluginTempl, IPSSysSFPluginTempl> {
    private static final Log log = LogFactory.getLog(PSSysSFPluginTemplGlobalModel.class);

    @Override
    protected PSSysSFPluginTempl GetObject(String strPSSysSFPluginTemplId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysSFPluginTempl psSysSFPluginTempl = new PSSysSFPluginTempl();
        CallResult callResult = this.iPSModelHelper.getPSSysSFPluginTempl(strPSSysSFPluginTemplId, psSysSFPluginTempl);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1\u63d2\u4ef6\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysSFPluginTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysSFPluginTempl;
    }

    @Override
    protected IPSSysSFPluginTempl OnCreateModelHelper(PSSysSFPluginTempl vt) throws Exception {
        IPSSysSFPlugin iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(vt.getPSSYSSFPLUGINID());
        PSSysSFPluginTemplImpl iPSSysSFPluginTempl = new PSSysSFPluginTemplImpl();
        iPSSysSFPluginTempl.init(this.iDAGlobalHelper, iPSSysSFPlugin, vt);
        return iPSSysSFPluginTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysSFPluginTempl obj) {
        return false;
    }

    @Override
    protected IPSSysSFPluginTempl registerModel(PSSysSFPluginTempl vt) throws Exception {
        IPSSysSFPluginTempl iPSSysSFPluginTempl = (IPSSysSFPluginTempl)this.InternalGetModelHelper(vt.getPSSYSSFPITEMPLID());
        if (iPSSysSFPluginTempl != null) {
            return iPSSysSFPluginTempl;
        }
        this.setModel(vt.getPSSYSSFPITEMPLID(), vt, null);
        iPSSysSFPluginTempl = (IPSSysSFPluginTempl)this.FindModelHelper(vt.getPSSYSSFPITEMPLID());
        return iPSSysSFPluginTempl;
    }

    @Override
    protected Vector<PSSysSFPluginTempl> getAllModels() throws Exception {
        Vector<PSSysSFPluginTempl> list = new Vector<PSSysSFPluginTempl>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysSFPluginTempls(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u670d\u52a1\u63d2\u4ef6\u6a21\u677f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysSFPluginTempl vt) {
        return vt.getPSSYSSFPITEMPLID();
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

    protected String[] getObjectAliases(PSSysSFPluginTempl vt) {
        String strUniqueId = KeyValueHelper.genUniqueId((String)vt.getPSSYSSFPLUGINID(), (String)vt.getPSSFID());
        if (StringHelper.Compare((String)strUniqueId, (String)vt.getPSSYSSFPITEMPLID(), (boolean)false) != 0) {
            return new String[]{strUniqueId.toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

