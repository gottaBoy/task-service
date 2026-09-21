/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataImport;

import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.PSDEDataImportImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDataImport;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataImportGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDataImport, IPSDEDataImport> {
    private static final Log log = LogFactory.getLog(PSDEDataImportGlobalModel.class);
    private IPSDEDataImport defaultPSDEDataImport = null;

    @Override
    protected PSDEDataImport GetObject(String strPSDEDataImportId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u5165[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataImportId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDataImport OnCreateModelHelper(PSDEDataImport vt) throws Exception {
        PSDEDataImportImpl iPSDEDataImport = new PSDEDataImportImpl();
        iPSDEDataImport.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDataImport;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDataImport obj) {
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
    protected Vector<PSDEDataImport> getAllModels() throws Exception {
        Vector<PSDEDataImport> psDEDataImportList = new Vector<PSDEDataImport>();
        CallResult callResult = this.iPSModelHelper.getPSDEDataImports(this.getPSDataEntity().getId(), psDEDataImportList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataImportList;
    }

    @Override
    protected IPSDEDataImport registerModel(PSDEDataImport vt) throws Exception {
        IPSDEDataImport iPSDEDataImport = (IPSDEDataImport)this.InternalGetModelHelper(vt.getPSDEDATAIMPID());
        if (iPSDEDataImport != null) {
            return iPSDEDataImport;
        }
        this.setModel(vt.getPSDEDATAIMPID(), vt, null);
        iPSDEDataImport = (IPSDEDataImport)this.FindModelHelper(vt.getPSDEDATAIMPID());
        if (iPSDEDataImport.isDefault()) {
            this.defaultPSDEDataImport = iPSDEDataImport;
        }
        return iPSDEDataImport;
    }

    @Override
    protected String getObjectId(PSDEDataImport vt) {
        return vt.getPSDEDATAIMPID();
    }

    public IPSDEDataImport getDefaultPSDEDataImport() {
        this.preloadModels();
        return this.defaultPSDEDataImport;
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20017, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDataImport vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

