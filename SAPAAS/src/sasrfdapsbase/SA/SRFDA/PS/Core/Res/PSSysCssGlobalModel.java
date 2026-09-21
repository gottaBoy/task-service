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
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.PSSysCssImpl;
import SA.SRFDA.PS.Data.PSSysCss;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCssGlobalModel
extends PSSystemGlobalModelBase<String, PSSysCss, IPSSysCss> {
    private static final Log log = LogFactory.getLog(PSSysCssGlobalModel.class);

    @Override
    protected PSSysCss GetObject(String strPSSysCssId) {
        PSSysCss psSysCss = new PSSysCss();
        CallResult callResult = this.iPSModelHelper.getPSSysCss(strPSSysCssId, psSysCss);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6837\u5f0f\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysCssId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysCss;
    }

    @Override
    protected IPSSysCss OnCreateModelHelper(PSSysCss vt) throws Exception {
        PSSysCssImpl iPSSysCss = null;
        iPSSysCss = new PSSysCssImpl();
        iPSSysCss.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysCss;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysCss obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysCss registerModel(PSSysCss vt) throws Exception {
        IPSSysCss iIPSSysCss = (IPSSysCss)this.InternalGetModelHelper(vt.getPSSYSCSSID());
        if (iIPSSysCss != null) {
            return iIPSSysCss;
        }
        this.setModel(vt.getPSSYSCSSID(), vt, null);
        return (IPSSysCss)this.FindModelHelper(vt.getPSSYSCSSID());
    }

    @Override
    protected Vector<PSSysCss> getAllModels() throws Exception {
        Vector<PSSysCss> list = new Vector<PSSysCss>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysCsses(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6837\u5f0f\u8868\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysCss vt) {
        return vt.getPSSYSCSSID();
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

    protected String[] getObjectAliases(PSSysCss vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

