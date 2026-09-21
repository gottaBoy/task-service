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
import SA.SRFDA.PS.Core.Res.IPSSysChartTheme;
import SA.SRFDA.PS.Core.Res.PSSysChartThemeImpl;
import SA.SRFDA.PS.Data.PSSysChartTheme;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysChartThemeGlobalModel
extends PSSystemGlobalModelBase<String, PSSysChartTheme, IPSSysChartTheme> {
    private static final Log log = LogFactory.getLog(PSSysChartThemeGlobalModel.class);
    private IPSSysChartTheme defaultPSSysChartTheme = null;

    @Override
    protected PSSysChartTheme GetObject(String strPSSysChartThemeId) {
        PSSysChartTheme psSysChartTheme = new PSSysChartTheme();
        CallResult callResult = this.iPSModelHelper.getPSSysChartTheme(strPSSysChartThemeId, psSysChartTheme);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u56fe\u8868\u4e3b\u9898[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysChartThemeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysChartTheme;
    }

    @Override
    protected IPSSysChartTheme OnCreateModelHelper(PSSysChartTheme vt) throws Exception {
        PSSysChartThemeImpl iPSSysChartTheme = new PSSysChartThemeImpl();
        iPSSysChartTheme.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysChartTheme;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysChartTheme obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysChartTheme registerModel(PSSysChartTheme vt) throws Exception {
        IPSSysChartTheme iPSSysChartTheme = (IPSSysChartTheme)this.InternalGetModelHelper(vt.getPSSYSCHARTTHEMEID());
        if (iPSSysChartTheme != null) {
            return iPSSysChartTheme;
        }
        this.setModel(vt.getPSSYSCHARTTHEMEID(), vt, null);
        iPSSysChartTheme = (IPSSysChartTheme)this.FindModelHelper(vt.getPSSYSCHARTTHEMEID());
        if (iPSSysChartTheme.isDefaultMode()) {
            this.defaultPSSysChartTheme = iPSSysChartTheme;
        }
        return iPSSysChartTheme;
    }

    @Override
    protected Vector<PSSysChartTheme> getAllModels() throws Exception {
        Vector<PSSysChartTheme> list = new Vector<PSSysChartTheme>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysChartThemes(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u56fe\u8868\u4e3b\u9898\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysChartTheme vt) {
        return vt.getPSSYSCHARTTHEMEID();
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
    protected boolean isEnableObjectAlias() {
        return true;
    }

    public IPSSysChartTheme getDefaultPSSysChartTheme() {
        this.preloadModels();
        return this.defaultPSSysChartTheme;
    }

    protected String[] getObjectAliases(PSSysChartTheme vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

