/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataImport;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.DataImport.PSDEDataImportImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Data.PSDEDataImport;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEDataImportGlobalModel
extends PSAppDataEntityGlobalModelBase<String, PSDEDataImport, IPSAppDEDataImport> {
    private static final Log log = LogFactory.getLog(PSAppDEDataImportGlobalModel.class);
    private IPSAppDEDataImport defaultPSAppDEDataImport = null;

    @Override
    protected PSDEDataImport GetObject(String strPSDEDataImportId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u5165[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataImportId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSAppDEDataImport OnCreateModelHelper(PSDEDataImport vt) throws Exception {
        PSDEDataImportImpl IPSAppDEDataImport2 = new PSDEDataImportImpl();
        IPSAppDEDataImport2.init(this.iDAGlobalHelper, this.getPSAppDataEntity(), vt);
        return IPSAppDEDataImport2;
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
        Vector<PSDEDataImport> psDEDataImport = new Vector<PSDEDataImport>();
        CallResult callResult = this.iPSModelHelper.getPSDEDataImports(this.getPSDataEntity().getId(), psDEDataImport);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataImport;
    }

    @Override
    protected IPSAppDEDataImport registerModel(PSDEDataImport vt) throws Exception {
        IPSAppDEDataImport IPSAppDEDataImport2 = (IPSAppDEDataImport)this.InternalGetModelHelper(vt.getPSDEDATAIMPID());
        if (IPSAppDEDataImport2 != null) {
            return IPSAppDEDataImport2;
        }
        this.setModel(vt.getPSDEDATAIMPID(), vt, null);
        IPSAppDEDataImport2 = (IPSAppDEDataImport)this.FindModelHelper(vt.getPSDEDATAIMPID());
        if (IPSAppDEDataImport2.isDefault()) {
            this.defaultPSAppDEDataImport = IPSAppDEDataImport2;
        }
        return IPSAppDEDataImport2;
    }

    @Override
    protected String getObjectId(PSDEDataImport vt) {
        return vt.getPSDEDATAIMPID();
    }

    public IPSAppDEDataImport getDefaultPSAppDEDataImport() {
        this.preloadModels();
        return this.defaultPSAppDEDataImport;
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

