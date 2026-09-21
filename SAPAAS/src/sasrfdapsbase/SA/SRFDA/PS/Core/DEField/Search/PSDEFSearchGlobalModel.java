/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField.Search;

import SA.SRFDA.PS.Core.DEField.PSDEFieldGlobalModelBase;
import SA.SRFDA.PS.Core.DEField.Search.IPSDEFSearch;
import SA.SRFDA.PS.Core.DEField.Search.PSDEFSearchImpl;
import SA.SRFDA.PS.Data.PSSysSearchDEField;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFSearchGlobalModel
extends PSDEFieldGlobalModelBase<String, PSSysSearchDEField, IPSDEFSearch> {
    private static final Log log = LogFactory.getLog(PSDEFSearchGlobalModel.class);

    @Override
    protected PSSysSearchDEField GetObject(String strPSSysSearchDEFieldId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u5168\u6587\u68c0\u7d22[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysSearchDEFieldId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEFSearch OnCreateModelHelper(PSSysSearchDEField vt) throws Exception {
        PSDEFSearchImpl iPSDEFSearch = new PSDEFSearchImpl();
        iPSDEFSearch.init(this.iDAGlobalHelper, this.iPSDEField, vt);
        return iPSDEFSearch;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysSearchDEField obj) {
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
    protected IPSDEFSearch registerModel(PSSysSearchDEField vt) throws Exception {
        IPSDEFSearch iPSDEFSearch = (IPSDEFSearch)this.InternalGetModelHelper(vt.getPSSYSSEARCHDEFIELDID());
        if (iPSDEFSearch != null) {
            return iPSDEFSearch;
        }
        this.setModel(vt.getPSSYSSEARCHDEFIELDID(), vt, null);
        return (IPSDEFSearch)this.FindModelHelper(vt.getPSSYSSEARCHDEFIELDID());
    }

    @Override
    protected Vector<PSSysSearchDEField> getAllModels() throws Exception {
        Vector<PSSysSearchDEField> psSysSearchDEFieldList = new Vector<PSSysSearchDEField>();
        ArrayList<PSSysSearchDEField> psSysSearchDEFieldList2 = this.getPSDEField().getPSDEFieldData().getPSSysSearchDEFields(false);
        if (psSysSearchDEFieldList2 != null) {
            psSysSearchDEFieldList.addAll(psSysSearchDEFieldList2);
        }
        return psSysSearchDEFieldList;
    }

    @Override
    protected String getObjectId(PSSysSearchDEField vt) {
        return vt.getPSSYSSEARCHDEFIELDID();
    }
}

