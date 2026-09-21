/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.SubSys.IPSSubDE;
import SA.SRFDA.PS.Core.SubSys.PSSubDEImpl;
import SA.SRFDA.PS.Core.SubSys.PSSubSysGlobalModelBase;
import SA.SRFDA.PS.Data.PSSubDE;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubDEGlobalModel
extends PSSubSysGlobalModelBase<String, PSSubDE, IPSSubDE> {
    private static final Log log = LogFactory.getLog(PSSubDEGlobalModel.class);

    @Override
    protected PSSubDE GetObject(String strPSSubDEId) {
        PSSubDE psSubDE = new PSSubDE();
        CallResult callResult = this.iPSModelHelper.getPSSubDE(strPSSubDEId, psSubDE);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b50\u7cfb\u7edf\u5b9e\u4f53[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSubDEId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSubDE;
    }

    @Override
    protected IPSSubDE OnCreateModelHelper(PSSubDE vt) throws Exception {
        PSSubDEImpl iPSSubDE = new PSSubDEImpl();
        iPSSubDE.init(this.iDAGlobalHelper, this.getPSSubSys(), vt);
        return iPSSubDE;
    }

    @Override
    protected Boolean TestObjectRenew(PSSubDE obj) {
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
    protected IPSSubDE registerModel(PSSubDE vt) throws Exception {
        IPSSubDE iPSSubDE = (IPSSubDE)this.InternalGetModelHelper(vt.getPSSUBDEID());
        if (iPSSubDE != null) {
            return iPSSubDE;
        }
        this.setModel(vt.getPSSUBDEID(), vt, null);
        return (IPSSubDE)this.FindModelHelper(vt.getPSSUBDEID());
    }

    @Override
    protected Vector<PSSubDE> getAllModels() throws Exception {
        Vector<PSSubDE> list = new Vector<PSSubDE>();
        CallResult callResult = this.iPSModelHelper.getAllPSSubDEs(this.getPSSubSys().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSubDE vt) {
        return vt.getPSSUBDEID();
    }
}

