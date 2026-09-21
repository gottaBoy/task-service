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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataExport;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.DataExport.PSDEDataExportImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Data.PSDEDataExport;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEDataExportGlobalModel
extends PSAppDataEntityGlobalModelBase<String, PSDEDataExport, IPSAppDEDataExport> {
    private static final Log log = LogFactory.getLog(PSAppDEDataExportGlobalModel.class);
    private IPSAppDEDataExport defaultPSAppDEDataExport = null;

    @Override
    protected PSDEDataExport GetObject(String strPSDEDataExportId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataExportId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSAppDEDataExport OnCreateModelHelper(PSDEDataExport vt) throws Exception {
        PSDEDataExportImpl iPSAppDEDataExport = new PSDEDataExportImpl();
        iPSAppDEDataExport.init(this.iDAGlobalHelper, this.getPSAppDataEntity(), vt);
        return iPSAppDEDataExport;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDataExport obj) {
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
    protected Vector<PSDEDataExport> getAllModels() throws Exception {
        Vector<PSDEDataExport> psDEDataExport = new Vector<PSDEDataExport>();
        CallResult callResult = this.iPSModelHelper.getPSDEDataExports(this.getPSDataEntity().getId(), psDEDataExport);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataExport;
    }

    @Override
    protected IPSAppDEDataExport registerModel(PSDEDataExport vt) throws Exception {
        IPSAppDEDataExport iPSDEDataExport = (IPSAppDEDataExport)this.InternalGetModelHelper(vt.getPSDEDATAEXPID());
        if (iPSDEDataExport != null) {
            return iPSDEDataExport;
        }
        this.setModel(vt.getPSDEDATAEXPID(), vt, null);
        iPSDEDataExport = (IPSAppDEDataExport)this.FindModelHelper(vt.getPSDEDATAEXPID());
        if (iPSDEDataExport.isDefaultMode()) {
            this.defaultPSAppDEDataExport = iPSDEDataExport;
        }
        return iPSDEDataExport;
    }

    @Override
    protected String getObjectId(PSDEDataExport vt) {
        return vt.getPSDEDATAEXPID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20016, objObjectId);
    }

    public IPSAppDEDataExport getDefaultPSAppDEDataExport() {
        this.preloadModels();
        return this.defaultPSAppDEDataExport;
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDataExport vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

