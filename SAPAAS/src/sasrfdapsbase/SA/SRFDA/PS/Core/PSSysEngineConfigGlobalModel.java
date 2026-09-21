/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSSysEngineConfigImpl;
import SA.SRFDA.PS.Data.PSSysEngineCfg;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEngineConfigGlobalModel
extends PSGlobalModelBase<String, PSSysEngineCfg, IPSSysEngineConfig> {
    private static final Log log = LogFactory.getLog(PSSysEngineConfigGlobalModel.class);

    @Override
    protected PSSysEngineCfg GetObject(String strPSSysEngineCfgId) {
        PSSysEngineCfg psSysEngineCfg = new PSSysEngineCfg();
        CallResult callResult = this.iPSModelHelper.getPSSysEngineConfig(strPSSysEngineCfgId, psSysEngineCfg);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6a21\u578b\u5f15\u64ce\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysEngineCfgId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysEngineCfg;
    }

    @Override
    protected IPSSysEngineConfig OnCreateModelHelper(PSSysEngineCfg vt) throws Exception {
        PSSysEngineConfigImpl iPSSysEngineConfig = new PSSysEngineConfigImpl();
        iPSSysEngineConfig.init(this.iDAGlobalHelper, vt);
        return iPSSysEngineConfig;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysEngineCfg obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSSysEngineCfg vt) {
        return vt.getPSSYSENGINECFGID();
    }
}

