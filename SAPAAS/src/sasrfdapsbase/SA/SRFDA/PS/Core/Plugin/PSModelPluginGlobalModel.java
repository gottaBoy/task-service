/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Plugin;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.Plugin.IPSModelPlugin;
import SA.SRFDA.PS.Core.Plugin.PSModelPluginImpl;
import SA.SRFDA.PS.Data.PSModelPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelPluginGlobalModel
extends PSGlobalModelBase<String, PSModelPlugin, IPSModelPlugin> {
    private static final Log log = LogFactory.getLog(PSModelPluginGlobalModel.class);

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.bEnableEmptyMap = true;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSModelPlugin GetObject(String strPSModelPluginId) {
        return null;
    }

    @Override
    protected IPSModelPlugin OnCreateModelHelper(PSModelPlugin vt) throws Exception {
        PSModelPluginImpl iPSModelPlugin = new PSModelPluginImpl();
        iPSModelPlugin.init(this.iDAGlobalHelper, vt);
        return iPSModelPlugin;
    }

    @Override
    protected Boolean TestObjectRenew(PSModelPlugin obj) {
        return false;
    }

    @Override
    protected IPSModelPlugin registerModel(PSModelPlugin vt) throws Exception {
        IPSModelPlugin iPSModelPlugin = (IPSModelPlugin)this.InternalGetModelHelper(vt.getPSMODELPLUGINID());
        if (iPSModelPlugin != null) {
            return iPSModelPlugin;
        }
        this.setModel(vt.getPSMODELPLUGINID(), vt, null);
        iPSModelPlugin = (IPSModelPlugin)this.FindModelHelper(vt.getPSMODELPLUGINID());
        return iPSModelPlugin;
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelperCount();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSModelPlugin> getAllModels() throws Exception {
        Vector<PSModelPlugin> list = new Vector<PSModelPlugin>();
        CallResult callResult = this.iPSModelHelper.getAllPSModelPlugins(list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u6a21\u578b\u63d2\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSModelPlugin vt) {
        return vt.getPSMODELPLUGINID();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

