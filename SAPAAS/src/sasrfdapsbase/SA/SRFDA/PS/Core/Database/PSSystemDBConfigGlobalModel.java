/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSystemDBConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSystemDBConfigGlobalModel
extends PSSystemGlobalModelBase<String, PSSystemDBConfig, IPSSystemDBConfig> {
    private static final Log log = LogFactory.getLog(PSSystemDBConfigGlobalModel.class);
    private IPSSystemDBConfig defaultPSSystemDBConfig = null;

    @Override
    protected PSSystemDBConfig GetObject(String strPSSystemDBConfigId) {
        return null;
    }

    @Override
    protected IPSSystemDBConfig OnCreateModelHelper(PSSystemDBConfig vt) throws Exception {
        IPSDBType iPSDBType = this.iPSModelStorage.getPSDBType(vt.getPSSYSTEMDBCFGNAME());
        IPSSystemDBConfig iPSSystemDBConfig = iPSDBType.createPSSystemDBConfig(vt);
        iPSSystemDBConfig.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSystemDBConfig;
    }

    @Override
    protected Boolean TestObjectRenew(PSSystemDBConfig obj) {
        return false;
    }

    @Override
    protected IPSSystemDBConfig registerModel(PSSystemDBConfig vt) throws Exception {
        IPSSystemDBConfig iPSSystemDBConfig = (IPSSystemDBConfig)this.InternalGetModelHelper(vt.getPSSYSTEMDBCFGID());
        if (iPSSystemDBConfig != null) {
            return iPSSystemDBConfig;
        }
        this.setModel(vt.getPSSYSTEMDBCFGID(), vt, null);
        this.setModel(vt.getPSSYSTEMDBCFGNAME(), vt, null);
        iPSSystemDBConfig = (IPSSystemDBConfig)this.FindModelHelper(vt.getPSSYSTEMDBCFGID());
        if (this.defaultPSSystemDBConfig == null || iPSSystemDBConfig.isDefaultMode()) {
            this.defaultPSSystemDBConfig = iPSSystemDBConfig;
        }
        return iPSSystemDBConfig;
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
    protected Vector<PSSystemDBConfig> getAllModels() throws Exception {
        Vector<PSSystemDBConfig> list = new Vector<PSSystemDBConfig>();
        CallResult callResult = this.iPSModelHelper.getAllPSSystemDBConfigs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u652f\u6301\u6570\u636e\u5e93\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSystemDBConfig vt) {
        return vt.getPSSYSTEMDBCFGID();
    }

    public IPSSystemDBConfig getDefaultPSSystemDBConfig() {
        this.preloadModels();
        return this.defaultPSSystemDBConfig;
    }
}

