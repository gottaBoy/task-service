/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.DynaModel.PSJsonSchemaImpl;
import SA.SRFDA.PS.Core.DynaModel.PSLiquibaseChangeLogModelImpl;
import SA.SRFDA.PS.Core.DynaModel.PSOpenAPI3SchemaModelImpl;
import SA.SRFDA.PS.Core.DynaModel.PSSysDynaModelImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysDynaModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDynaModelGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDynaModel, IPSSysDynaModel> {
    private static final Log log = LogFactory.getLog(PSSysDynaModelGlobalModel.class);
    private IPSSysDynaModel defaultPSSysDynaModel = null;
    private HashMap<String, IPSSysDynaModel> defaultModuleModelMap = new HashMap();

    @Override
    protected PSSysDynaModel GetObject(String strPSSysDynaModelId) {
        PSSysDynaModel psSysDynaModel = new PSSysDynaModel();
        CallResult callResult = this.iPSModelHelper.getPSSysDynaModel(strPSSysDynaModelId, psSysDynaModel);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u52a8\u6001\u6a21\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysDynaModelId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysDynaModel;
    }

    @Override
    protected IPSSysDynaModel OnCreateModelHelper(PSSysDynaModel vt) throws Exception {
        PSSysDynaModelImpl iPSSysDynaModel = null;
        String strDynaModelUsage = vt.getDYNAMODELUSAGE();
        iPSSysDynaModel = StringHelper.Compare((String)"JSONSCHEMA", (String)strDynaModelUsage, (boolean)false) == 0 ? new PSJsonSchemaImpl() : (StringHelper.Compare((String)"OPENAPI3SCHEMA", (String)strDynaModelUsage, (boolean)false) == 0 ? new PSOpenAPI3SchemaModelImpl() : (StringHelper.Compare((String)"LIQUIBASECHANGELOG", (String)strDynaModelUsage, (boolean)false) == 0 ? new PSLiquibaseChangeLogModelImpl() : new PSSysDynaModelImpl()));
        iPSSysDynaModel.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysDynaModel;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDynaModel obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysDynaModel registerModel(PSSysDynaModel vt) throws Exception {
        IPSSysDynaModel iPSSysDynaModel = (IPSSysDynaModel)this.InternalGetModelHelper(vt.getPSSYSDYNAMODELID());
        if (iPSSysDynaModel != null) {
            return iPSSysDynaModel;
        }
        this.setModel(vt.getPSSYSDYNAMODELID(), vt, null);
        iPSSysDynaModel = (IPSSysDynaModel)this.FindModelHelper(vt.getPSSYSDYNAMODELID());
        if (iPSSysDynaModel.isSystemDefault()) {
            this.defaultPSSysDynaModel = iPSSysDynaModel;
        } else if (iPSSysDynaModel.isModuleDefault() && iPSSysDynaModel.getPSSystemModule() != null) {
            this.defaultModuleModelMap.put(iPSSysDynaModel.getPSSystemModule().getId(), iPSSysDynaModel);
        }
        return iPSSysDynaModel;
    }

    @Override
    protected Vector<PSSysDynaModel> getAllModels() throws Exception {
        Vector<PSSysDynaModel> list = new Vector<PSSysDynaModel>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysDynaModels(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u52a8\u6001\u6a21\u578b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDynaModel vt) {
        return vt.getPSSYSDYNAMODELID();
    }

    public IPSSysDynaModel getSystemPSSysDynaModel() {
        this.preloadModels();
        return this.defaultPSSysDynaModel;
    }

    public IPSSysDynaModel getModulePSSysDynaModel(String strPSModuleId) {
        this.preloadModels();
        return this.defaultModuleModelMap.get(strPSModuleId);
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
}

