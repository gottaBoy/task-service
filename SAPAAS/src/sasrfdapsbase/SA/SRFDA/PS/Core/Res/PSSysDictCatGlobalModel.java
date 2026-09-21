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
import SA.SRFDA.PS.Core.Res.IPSSysDictCat;
import SA.SRFDA.PS.Core.Res.PSSysDictCatImpl;
import SA.SRFDA.PS.Data.PSSysDictCat;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDictCatGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDictCat, IPSSysDictCat> {
    private static final Log log = LogFactory.getLog(PSSysDictCatGlobalModel.class);

    @Override
    protected PSSysDictCat GetObject(String strPSSysDictCatId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysDictCat psSysDictCat = new PSSysDictCat();
        CallResult callResult = this.iPSModelHelper.getPSSysDictCat(strPSSysDictCatId, psSysDictCat);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u7528\u6237\u8bcd\u5178\u5206\u7c7b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysDictCatId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysDictCat;
    }

    @Override
    protected IPSSysDictCat OnCreateModelHelper(PSSysDictCat vt) throws Exception {
        PSSysDictCatImpl iPSSysDictCat = new PSSysDictCatImpl();
        iPSSysDictCat.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysDictCat;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDictCat obj) {
        return false;
    }

    @Override
    protected IPSSysDictCat registerModel(PSSysDictCat vt) throws Exception {
        IPSSysDictCat iIPSSysDictCat = (IPSSysDictCat)this.InternalGetModelHelper(vt.getPSSYSDICTCATID());
        if (iIPSSysDictCat != null) {
            return iIPSSysDictCat;
        }
        this.setModel(vt.getPSSYSDICTCATID(), vt, null);
        return (IPSSysDictCat)this.FindModelHelper(vt.getPSSYSDICTCATID());
    }

    @Override
    protected Vector<PSSysDictCat> getAllModels() throws Exception {
        Vector<PSSysDictCat> list = new Vector<PSSysDictCat>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysDictCats(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u7528\u6237\u8bcd\u5178\u5206\u7c7b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDictCat vt) {
        return vt.getPSSYSDICTCATID();
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

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysDictCat vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

