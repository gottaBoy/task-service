/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.PSSysDBSchemeImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysDBScheme;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysDBSchemeGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDBScheme, IPSSysDBScheme> {
    private static final Log log = LogFactory.getLog(PSSysDBSchemeGlobalModel.class);

    @Override
    protected PSSysDBScheme GetObject(String strPSSysDBSchemeId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysDBScheme psSysDBScheme = new PSSysDBScheme();
        CallResult callResult = this.iPSModelHelper.getPSSysDBScheme(strPSSysDBSchemeId, psSysDBScheme);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5173\u7cfb\u6570\u636e\u5e93\u67b6\u6784[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysDBSchemeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysDBScheme;
    }

    @Override
    protected IPSSysDBScheme OnCreateModelHelper(PSSysDBScheme vt) throws Exception {
        PSSysDBSchemeImpl iPSSysDBScheme = new PSSysDBSchemeImpl();
        iPSSysDBScheme.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysDBScheme;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDBScheme obj) {
        return false;
    }

    @Override
    protected IPSSysDBScheme registerModel(PSSysDBScheme vt) throws Exception {
        IPSSysDBScheme iPSSysDBScheme = (IPSSysDBScheme)this.InternalGetModelHelper(vt.getPSSYSDBSCHEMEID());
        if (iPSSysDBScheme != null) {
            return iPSSysDBScheme;
        }
        this.setModel(vt.getPSSYSDBSCHEMEID(), vt, null);
        iPSSysDBScheme = (IPSSysDBScheme)this.FindModelHelper(vt.getPSSYSDBSCHEMEID());
        return iPSSysDBScheme;
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
    protected Vector<PSSysDBScheme> getAllModels() throws Exception {
        Vector<PSSysDBScheme> list = new Vector<PSSysDBScheme>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysDBSchemes(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5173\u7cfb\u6570\u636e\u5e93\u67b6\u6784\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDBScheme vt) {
        return vt.getPSSYSDBSCHEMEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysDBScheme vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getDSLINK())) {
            if (StringHelper.IsNullOrEmpty((String)vt.getPSSYSMODELGROUPID())) {
                return new String[]{vt.getDSLINK().toUpperCase()};
            }
            return new String[]{KeyValueHelper.genUniqueId((String)vt.getPSSYSMODELGROUPID(), (String)vt.getDSLINK()).toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

