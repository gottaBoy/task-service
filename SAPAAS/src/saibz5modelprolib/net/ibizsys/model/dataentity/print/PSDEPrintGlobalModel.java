/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.print.IPSDEPrint
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.print;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.print.IPSDEPrint;
import net.ibizsys.model.dataentity.print.PSDEPrintImpl;
import net.ibizsys.model.entity.PSDEPrint;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEPrintGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEPrint, IPSDEPrint> {
    private static final Log log = LogFactory.getLog(PSDEPrintGlobalModel.class);

    @Override
    protected PSDEPrint getObject(String strPSDEPrintId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6253\u5370[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEPrintId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEPrint onCreateModelHelper(PSDEPrint vt) throws Exception {
        PSDEPrintImpl iPSDEPrint = new PSDEPrintImpl();
        iPSDEPrint.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEPrint;
    }

    @Override
    protected Boolean testObjectRenew(PSDEPrint obj) {
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
        CallResult callResult = this.getPSModelQueryHelper().getPSDEPrints(this.getPSDataEntity().getId(), psDEPrint);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6253\u5370\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEPrint;
    }

    @Override
    protected IPSDEPrint registerModel(PSDEPrint vt) throws Exception {
        IPSDEPrint iPSDEPrint = (IPSDEPrint)this.internalGetModelHelper(vt.getPSDEPRINTID());
        if (iPSDEPrint != null) {
            return iPSDEPrint;
        }
        this.setModel(vt.getPSDEPRINTID(), vt, null);
        return (IPSDEPrint)this.findModelHelper(vt.getPSDEPRINTID());
    }

    @Override
    protected String getObjectId(PSDEPrint vt) {
        return vt.getPSDEPRINTID();
    }
}

