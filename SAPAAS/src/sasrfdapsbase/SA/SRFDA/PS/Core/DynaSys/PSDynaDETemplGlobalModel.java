/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaSys;

import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.DynaSys.PSDynaDETemplImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSDynaDETempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDynaDETemplGlobalModel
extends PSSystemGlobalModelBase<String, PSDynaDETempl, IPSDynaDETempl> {
    private static final Log log = LogFactory.getLog(PSDynaDETemplGlobalModel.class);

    @Override
    protected PSDynaDETempl GetObject(String strPSDynaDETemplId) {
        PSDynaDETempl psDynaDETempl = new PSDynaDETempl();
        CallResult callResult = this.iPSModelHelper.getPSDynaDETempl(strPSDynaDETemplId, psDynaDETempl);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f53\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDynaDETemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDynaDETempl;
    }

    @Override
    protected IPSDynaDETempl OnCreateModelHelper(PSDynaDETempl vt) throws Exception {
        PSDynaDETemplImpl iPSDynaDETempl = null;
        iPSDynaDETempl = new PSDynaDETemplImpl();
        iPSDynaDETempl.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSDynaDETempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSDynaDETempl obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSDynaDETempl registerModel(PSDynaDETempl vt) throws Exception {
        IPSDynaDETempl iIPSDynaDETempl = (IPSDynaDETempl)this.InternalGetModelHelper(vt.getPSDYNADETEMPLID());
        if (iIPSDynaDETempl != null) {
            return iIPSDynaDETempl;
        }
        this.setModel(vt.getPSDYNADETEMPLID(), vt, null);
        iIPSDynaDETempl = (IPSDynaDETempl)this.FindModelHelper(vt.getPSDYNADETEMPLID());
        return iIPSDynaDETempl;
    }

    @Override
    protected Vector<PSDynaDETempl> getAllModels() throws Exception {
        Vector<PSDynaDETempl> list = new Vector<PSDynaDETempl>();
        CallResult callResult = this.iPSModelHelper.getAllPSDynaDETempls(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u52a8\u6001\u5b9e\u4f53\u6a21\u677f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDynaDETempl vt) {
        return vt.getPSDYNADETEMPLID();
    }
}

