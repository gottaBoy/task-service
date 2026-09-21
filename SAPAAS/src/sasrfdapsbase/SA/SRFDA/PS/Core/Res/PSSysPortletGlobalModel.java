/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;
import SA.SRFDA.PS.Data.PSSysPortlet;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPortletGlobalModel
extends PSSystemGlobalModelBase<String, PSSysPortlet, IPSSysPortlet> {
    private static final Log log = LogFactory.getLog(PSSysPortletGlobalModel.class);

    @Override
    protected PSSysPortlet GetObject(String strPSSysPortletId) {
        PSSysPortlet psSysPortlet = new PSSysPortlet();
        CallResult callResult = this.iPSModelHelper.getPSSysPortlet(strPSSysPortletId, psSysPortlet);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysPortletId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysPortlet;
    }

    @Override
    protected IPSSysPortlet OnCreateModelHelper(PSSysPortlet vt) throws Exception {
        IPSSysPortlet iPSSysPortlet = this.iPSModelStorage.getPSPortletType(vt.getPORTLETTYPE()).createPSSysPortlet(vt);
        iPSSysPortlet.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysPortlet;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysPortlet obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysPortlet registerModel(PSSysPortlet vt) throws Exception {
        IPSSysPortlet iIPSSysPortlet = (IPSSysPortlet)this.InternalGetModelHelper(vt.getPSSYSPORTLETID());
        if (iIPSSysPortlet != null) {
            return iIPSSysPortlet;
        }
        this.setModel(vt.getPSSYSPORTLETID(), vt, null);
        return (IPSSysPortlet)this.FindModelHelper(vt.getPSSYSPORTLETID());
    }

    @Override
    protected Vector<PSSysPortlet> getAllModels() throws Exception {
        Vector<PSSysPortlet> list = new Vector<PSSysPortlet>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysPortlets(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u95e8\u6237\u90e8\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysPortlet vt) {
        return vt.getPSSYSPORTLETID();
    }
}

