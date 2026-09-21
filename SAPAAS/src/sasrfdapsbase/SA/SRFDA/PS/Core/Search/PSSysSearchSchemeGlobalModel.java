/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Core.Search.PSSysSearchSchemeImpl;
import SA.SRFDA.PS.Data.PSSysSearchScheme;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSearchSchemeGlobalModel
extends PSSystemGlobalModelBase<String, PSSysSearchScheme, IPSSysSearchScheme> {
    private static final Log log = LogFactory.getLog(PSSysSearchSchemeGlobalModel.class);

    @Override
    protected PSSysSearchScheme GetObject(String strPSSysSearchSchemeId) {
        PSSysSearchScheme psSysSearchScheme = new PSSysSearchScheme();
        CallResult callResult = this.iPSModelHelper.getPSSysSearchScheme(strPSSysSearchSchemeId, psSysSearchScheme);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5168\u6587\u68c0\u7d22\u4f53\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysSearchSchemeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysSearchScheme;
    }

    @Override
    protected IPSSysSearchScheme OnCreateModelHelper(PSSysSearchScheme vt) throws Exception {
        PSSysSearchSchemeImpl iPSSysSearchScheme = new PSSysSearchSchemeImpl();
        iPSSysSearchScheme.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysSearchScheme;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysSearchScheme obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysSearchScheme registerModel(PSSysSearchScheme vt) throws Exception {
        IPSSysSearchScheme iIPSSysSearchScheme = (IPSSysSearchScheme)this.InternalGetModelHelper(vt.getPSSYSSEARCHSCHEMEID());
        if (iIPSSysSearchScheme != null) {
            return iIPSSysSearchScheme;
        }
        this.setModel(vt.getPSSYSSEARCHSCHEMEID(), vt, null);
        return (IPSSysSearchScheme)this.FindModelHelper(vt.getPSSYSSEARCHSCHEMEID());
    }

    @Override
    protected Vector<PSSysSearchScheme> getAllModels() throws Exception {
        Vector<PSSysSearchScheme> list = new Vector<PSSysSearchScheme>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysSearchSchemes(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5168\u6587\u68c0\u7d22\u4f53\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysSearchScheme vt) {
        return vt.getPSSYSSEARCHSCHEMEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysSearchScheme vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

