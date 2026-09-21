/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.SF.IPSSFCodeTempl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.PSSFCodeTemplImpl;
import SA.SRFDA.PS.Data.PSSFCodeTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFCodeTemplGlobalModel
extends PSGlobalModelBase<String, PSSFCodeTempl, IPSSFCodeTempl> {
    private static final Log log = LogFactory.getLog(PSSFCodeTemplGlobalModel.class);
    protected IPSSFCodeType iPSSFCodeType = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFCodeType iPSSFCodeType) {
        this.iPSSFCodeType = iPSSFCodeType;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSSFCodeTempl GetObject(String strPSSFCodeTemplId) {
        return null;
    }

    @Override
    protected IPSSFCodeTempl OnCreateModelHelper(PSSFCodeTempl vt) throws Exception {
        PSSFCodeTemplImpl iPSSFCodeTempl = new PSSFCodeTemplImpl();
        iPSSFCodeTempl.init(this.iDAGlobalHelper, this.iPSSFCodeType, vt);
        return iPSSFCodeTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFCodeTempl obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSFCodeType.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSSFCodeTempl vt) {
        return vt.getPSSFCODETEMPLID();
    }

    @Override
    protected IPSSFCodeTempl registerModel(PSSFCodeTempl vt) throws Exception {
        IPSSFCodeTempl iPSSFCodeTempl = (IPSSFCodeTempl)this.InternalGetModelHelper(vt.getPSSFCODETEMPLID());
        if (iPSSFCodeTempl != null) {
            return iPSSFCodeTempl;
        }
        this.setModel(vt.getPSSFCODETEMPLID(), vt, null);
        return (IPSSFCodeTempl)this.FindModelHelper(vt.getPSSFCODETEMPLID());
    }

    @Override
    protected Vector<PSSFCodeTempl> getAllModels() throws Exception {
        Vector<PSSFCodeTempl> list2 = new Vector<PSSFCodeTempl>();
        CallResult callResult = this.iPSModelHelper.getPSSFCodeTempls(this.iPSSFCodeType.getId(), list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u540e\u53f0\u670d\u52a1\u6846\u67b6\u4ee3\u7801\u6a21\u677f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSSFCodeTempl> list = new Vector<PSSFCodeTempl>();
        for (PSSFCodeTempl psSFCodeTempl : list2) {
            if (!psSFCodeTempl.isVALIDFLAGNull() && !psSFCodeTempl.getVALIDFLAG()) continue;
            list.add(psSFCodeTempl);
        }
        return list;
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

