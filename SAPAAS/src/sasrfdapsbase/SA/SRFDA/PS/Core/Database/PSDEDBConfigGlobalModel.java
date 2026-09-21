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
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDBConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEDBConfigGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDBConfig, IPSDEDBConfig> {
    private static final Log log = LogFactory.getLog(PSDEDBConfigGlobalModel.class);
    private static final PSDEDBConfig PSDEDBCONFIG = new PSDEDBConfig();

    @Override
    protected PSDEDBConfig GetObject(String strPSDEDBConfigId) {
        return null;
    }

    @Override
    protected IPSDEDBConfig OnCreateModelHelper(PSDEDBConfig vt) throws Exception {
        IPSDBType iPSDBType = this.iPSModelStorage.getPSDBType(vt.getPSDEDBCFGNAME());
        IPSDEDBConfig iPSDEDBConfig = iPSDBType.createPSDEDBConfig(vt);
        iPSDEDBConfig.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDBConfig;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDBConfig obj) {
        return false;
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
    protected Vector<PSDEDBConfig> getAllModels() throws Exception {
        Vector<PSDEDBConfig> psDEDBConfigList = new Vector<PSDEDBConfig>();
        CallResult callResult = this.iPSModelHelper.getPSDEDBConfigs(this.getPSDataEntity().getId(), psDEDBConfigList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u5e93\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSDEDBConfig> psDEDBConfigList2 = new Vector<PSDEDBConfig>();
        for (PSDEDBConfig psDEDBConfig : psDEDBConfigList) {
            if (this.getPSDataEntity().getPSSystem().getPSSystemDBConfig(psDEDBConfig.getPSDEDBCFGNAME(), true) == null) continue;
            psDEDBConfigList2.add(psDEDBConfig);
        }
        return psDEDBConfigList2;
    }

    @Override
    protected IPSDEDBConfig registerModel(PSDEDBConfig vt) throws Exception {
        IPSDEDBConfig iPSDEDBConfig = (IPSDEDBConfig)this.InternalGetModelHelper(vt.getPSDEDBCFGNAME());
        if (iPSDEDBConfig != null) {
            return iPSDEDBConfig;
        }
        this.setModel(vt.getPSDEDBCFGNAME(), vt, null);
        iPSDEDBConfig = (IPSDEDBConfig)this.FindModelHelper(vt.getPSDEDBCFGNAME());
        this.setModel(vt.getPSDEDBCFGNAME(), PSDEDBCONFIG, iPSDEDBConfig);
        return iPSDEDBConfig;
    }

    @Override
    protected String getObjectId(PSDEDBConfig vt) {
        return vt.getPSDEDBCFGNAME();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.Format((String)"%1$s[%2$s]", (Object)super.getModelInfo(), (Object)this.getPSDataEntity().getName());
    }

    @Override
    public IPSDEDBConfig FindModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSDEDBConfig iPSDEDBConfig = (IPSDEDBConfig)super.FindModelHelper(objObjectId, true);
        if (iPSDEDBConfig != null) {
            return iPSDEDBConfig;
        }
        IPSDBType iPSDBType = this.iPSModelStorage.getPSDBType(objObjectId, true);
        if (iPSDBType == null) {
            if (bTryMode) {
                return null;
            }
            return (IPSDEDBConfig)super.FindModelHelper(objObjectId, bTryMode);
        }
        PSDEDBConfig psDEDBConfig = new PSDEDBConfig();
        psDEDBConfig.setPSDEDBCFGID(KeyValueHelper.genUniqueId((String)this.getPSDataEntity().getId(), (String)objObjectId));
        psDEDBConfig.setPSDEDBCFGNAME(objObjectId);
        psDEDBConfig.setPSDEID(this.getPSDataEntity().getId());
        psDEDBConfig.setPSDENAME(this.getPSDataEntity().getName());
        psDEDBConfig.set("AUTOMODEL", 1);
        iPSDEDBConfig = this.OnCreateModelHelper(psDEDBConfig);
        this.setModel(objObjectId, psDEDBConfig, iPSDEDBConfig);
        this.internalAddAllModelHelper(iPSDEDBConfig);
        return iPSDEDBConfig;
    }
}

