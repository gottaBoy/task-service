/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Report;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.DataEntity.Report.PSDEReportImpl;
import SA.SRFDA.PS.Data.PSDEReport;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEReportGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEReport, IPSDEReport> {
    private static final Log log = LogFactory.getLog(PSDEReportGlobalModel.class);

    @Override
    protected PSDEReport GetObject(String strPSDEReportId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u62a5\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEReportId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEReport OnCreateModelHelper(PSDEReport vt) throws Exception {
        PSDEReportImpl iPSDEReport = new PSDEReportImpl();
        iPSDEReport.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEReport;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEReport obj) {
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
    protected Vector<PSDEReport> getAllModels() throws Exception {
        Vector<PSDEReport> psDEReport = new Vector<PSDEReport>();
        CallResult callResult = this.iPSModelHelper.getPSDEReports(this.getPSDataEntity().getId(), psDEReport);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u62a5\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEReport;
    }

    @Override
    protected IPSDEReport registerModel(PSDEReport vt) throws Exception {
        IPSDEReport iPSDEReport = (IPSDEReport)this.InternalGetModelHelper(vt.getPSDEREPORTID());
        if (iPSDEReport != null) {
            return iPSDEReport;
        }
        this.setModel(vt.getPSDEREPORTID(), vt, null);
        return (IPSDEReport)this.FindModelHelper(vt.getPSDEREPORTID());
    }

    @Override
    protected String getObjectId(PSDEReport vt) {
        return vt.getPSDEREPORTID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEReport vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

