/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BI.PSSysBISchemeImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysBIScheme;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBISchemeGlobalModel
extends PSSystemGlobalModelBase<String, PSSysBIScheme, IPSSysBIScheme> {
    private static final Log log = LogFactory.getLog(PSSysBISchemeGlobalModel.class);

    @Override
    protected PSSysBIScheme GetObject(String strPSSysBISchemeId) {
        PSSysBIScheme psSysBIScheme = new PSSysBIScheme();
        CallResult callResult = this.iPSModelHelper.getPSSysBIScheme(strPSSysBISchemeId, psSysBIScheme);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u4f53\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysBISchemeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysBIScheme;
    }

    @Override
    protected IPSSysBIScheme OnCreateModelHelper(PSSysBIScheme vt) throws Exception {
        PSSysBISchemeImpl iPSSysBIScheme = new PSSysBISchemeImpl();
        iPSSysBIScheme.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysBIScheme;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBIScheme obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysBIScheme registerModel(PSSysBIScheme vt) throws Exception {
        IPSSysBIScheme iIPSSysBIScheme = (IPSSysBIScheme)this.InternalGetModelHelper(vt.getPSSYSBISCHEMEID());
        if (iIPSSysBIScheme != null) {
            return iIPSSysBIScheme;
        }
        this.setModel(vt.getPSSYSBISCHEMEID(), vt, null);
        return (IPSSysBIScheme)this.FindModelHelper(vt.getPSSYSBISCHEMEID());
    }

    @Override
    protected Vector<PSSysBIScheme> getAllModels() throws Exception {
        Vector<PSSysBIScheme> list = new Vector<PSSysBIScheme>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysBISchemes(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u667a\u80fd\u62a5\u8868\u4f53\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBIScheme vt) {
        return vt.getPSSYSBISCHEMEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysBIScheme vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

