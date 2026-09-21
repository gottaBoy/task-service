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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEPrint;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.Print.PSDEPrintImpl;
import SA.SRFDA.PS.Data.PSDEPrint;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEPrintGlobalModel
extends PSAppDataEntityGlobalModelBase<String, PSDEPrint, IPSAppDEPrint> {
    private static final Log log = LogFactory.getLog(PSAppDEPrintGlobalModel.class);
    private IPSAppDEPrint defaultPSAppDEPrint = null;

    @Override
    protected PSDEPrint GetObject(String strPSDEPrintId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6253\u5370[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEPrintId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSAppDEPrint OnCreateModelHelper(PSDEPrint vt) throws Exception {
        PSDEPrintImpl IPSAppDEPrint2 = new PSDEPrintImpl();
        IPSAppDEPrint2.init(this.iDAGlobalHelper, this.getPSAppDataEntity(), vt);
        return IPSAppDEPrint2;
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
    protected IPSAppDEPrint registerModel(PSDEPrint vt) throws Exception {
        IPSAppDEPrint IPSAppDEPrint2 = (IPSAppDEPrint)this.InternalGetModelHelper(vt.getPSDEPRINTID());
        if (IPSAppDEPrint2 != null) {
            return IPSAppDEPrint2;
        }
        this.setModel(vt.getPSDEPRINTID(), vt, null);
        IPSAppDEPrint2 = (IPSAppDEPrint)this.FindModelHelper(vt.getPSDEPRINTID());
        if (IPSAppDEPrint2.isDefaultMode()) {
            this.defaultPSAppDEPrint = IPSAppDEPrint2;
        }
        return IPSAppDEPrint2;
    }

    @Override
    protected String getObjectId(PSDEPrint vt) {
        return vt.getPSDEPRINTID();
    }

    public IPSAppDEPrint getDefaultPSAppDEPrint() {
        this.preloadModels();
        return this.defaultPSAppDEPrint;
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20031, objObjectId);
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
}

