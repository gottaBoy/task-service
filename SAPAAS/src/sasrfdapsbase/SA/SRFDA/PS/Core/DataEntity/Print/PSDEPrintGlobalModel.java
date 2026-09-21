/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Print;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.DataEntity.Print.PSDEPrintImpl;
import SA.SRFDA.PS.Data.PSDEPrint;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEPrintGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEPrint, IPSDEPrint> {
    private static final Log log = LogFactory.getLog(PSDEPrintGlobalModel.class);
    private IPSDEPrint defaultPSDEPrint = null;

    @Override
    protected PSDEPrint GetObject(String strPSDEPrintId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6253\u5370[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEPrintId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEPrint OnCreateModelHelper(PSDEPrint vt) throws Exception {
        PSDEPrintImpl iPSDEPrint = new PSDEPrintImpl();
        iPSDEPrint.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEPrint;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEPrint obj) {
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
    protected Vector<PSDEPrint> getAllModels() throws Exception {
        Vector<PSDEPrint> psDEPrint = new Vector<PSDEPrint>();
        CallResult callResult = this.iPSModelHelper.getPSDEPrints(this.getPSDataEntity().getId(), psDEPrint);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6253\u5370\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEPrint;
    }

    @Override
    protected IPSDEPrint registerModel(PSDEPrint vt) throws Exception {
        IPSDEPrint iPSDEPrint = (IPSDEPrint)this.InternalGetModelHelper(vt.getPSDEPRINTID());
        if (iPSDEPrint != null) {
            return iPSDEPrint;
        }
        this.setModel(vt.getPSDEPRINTID(), vt, null);
        iPSDEPrint = (IPSDEPrint)this.FindModelHelper(vt.getPSDEPRINTID());
        if (iPSDEPrint.isDefaultMode()) {
            this.defaultPSDEPrint = iPSDEPrint;
        }
        return iPSDEPrint;
    }

    @Override
    protected String getObjectId(PSDEPrint vt) {
        return vt.getPSDEPRINTID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEPrint vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }

    public IPSDEPrint getDefaultPSDEPrint() {
        this.preloadModels();
        return this.defaultPSDEPrint;
    }
}

