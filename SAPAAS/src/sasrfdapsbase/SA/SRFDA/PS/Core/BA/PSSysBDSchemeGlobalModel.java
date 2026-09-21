/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.PSSysBDSchemeImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysBDScheme;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDSchemeGlobalModel
extends PSSystemGlobalModelBase<String, PSSysBDScheme, IPSSysBDScheme> {
    private static final Log log = LogFactory.getLog(PSSysBDSchemeGlobalModel.class);

    @Override
    protected PSSysBDScheme GetObject(String strPSSysBDSchemeId) {
        PSSysBDScheme psSysBDScheme = new PSSysBDScheme();
        CallResult callResult = this.iPSModelHelper.getPSSysBDScheme(strPSSysBDSchemeId, psSysBDScheme);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5927\u6570\u636e\u67b6\u6784[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysBDSchemeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysBDScheme;
    }

    @Override
    protected IPSSysBDScheme OnCreateModelHelper(PSSysBDScheme vt) throws Exception {
        PSSysBDSchemeImpl iPSSysBDScheme = new PSSysBDSchemeImpl();
        iPSSysBDScheme.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysBDScheme;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBDScheme obj) {
        return false;
    }

    @Override
    protected IPSSysBDScheme registerModel(PSSysBDScheme vt) throws Exception {
        IPSSysBDScheme iPSSysBDScheme = (IPSSysBDScheme)this.InternalGetModelHelper(vt.getPSSYSBDSCHEMEID());
        if (iPSSysBDScheme != null) {
            return iPSSysBDScheme;
        }
        this.setModel(vt.getPSSYSBDSCHEMEID(), vt, null);
        iPSSysBDScheme = (IPSSysBDScheme)this.FindModelHelper(vt.getPSSYSBDSCHEMEID());
        return iPSSysBDScheme;
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
    protected Vector<PSSysBDScheme> getAllModels() throws Exception {
        Vector<PSSysBDScheme> list = new Vector<PSSysBDScheme>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysBDSchemes(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2 \u7cfb\u7edf\u5168\u90e8\u5927\u6570\u636e\u67b6\u6784\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBDScheme vt) {
        return vt.getPSSYSBDSCHEMEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysBDScheme vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

