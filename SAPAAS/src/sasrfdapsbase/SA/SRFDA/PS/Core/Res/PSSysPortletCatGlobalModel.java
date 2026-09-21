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
import SA.SRFDA.PS.Core.Res.IPSSysPortletCat;
import SA.SRFDA.PS.Core.Res.PSSysPortletCatImpl;
import SA.SRFDA.PS.Data.PSSysPortletCat;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPortletCatGlobalModel
extends PSSystemGlobalModelBase<String, PSSysPortletCat, IPSSysPortletCat> {
    private static final Log log = LogFactory.getLog(PSSysPortletCatGlobalModel.class);

    @Override
    protected PSSysPortletCat GetObject(String strPSSysPortletCatId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysPortletCat psSysPortletCat = new PSSysPortletCat();
        CallResult callResult = this.iPSModelHelper.getPSSysPortletCat(strPSSysPortletCatId, psSysPortletCat);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysPortletCatId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysPortletCat;
    }

    @Override
    protected IPSSysPortletCat OnCreateModelHelper(PSSysPortletCat vt) throws Exception {
        PSSysPortletCatImpl iPSSysPortletCat = new PSSysPortletCatImpl();
        iPSSysPortletCat.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysPortletCat;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysPortletCat obj) {
        return false;
    }

    @Override
    protected IPSSysPortletCat registerModel(PSSysPortletCat vt) throws Exception {
        IPSSysPortletCat iIPSSysPortletCat = (IPSSysPortletCat)this.InternalGetModelHelper(vt.getPSSYSPORTLETCATID());
        if (iIPSSysPortletCat != null) {
            return iIPSSysPortletCat;
        }
        this.setModel(vt.getPSSYSPORTLETCATID(), vt, null);
        return (IPSSysPortletCat)this.FindModelHelper(vt.getPSSYSPORTLETCATID());
    }

    @Override
    protected Vector<PSSysPortletCat> getAllModels() throws Exception {
        Vector<PSSysPortletCat> list = new Vector<PSSysPortletCat>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysPortletCats(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u95e8\u6237\u90e8\u4ef6\u5206\u7c7b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysPortletCat vt) {
        return vt.getPSSYSPORTLETCATID();
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }
}

