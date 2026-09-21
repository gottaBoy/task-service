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
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Core.Res.PSSysUnitImpl;
import SA.SRFDA.PS.Data.PSSysUnit;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUnitGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUnit, IPSSysUnit> {
    private static final Log log = LogFactory.getLog(PSSysUnitGlobalModel.class);

    @Override
    protected PSSysUnit GetObject(String strPSSysUnitId) {
        PSSysUnit psSysUnit = new PSSysUnit();
        CallResult callResult = this.iPSModelHelper.getPSSysUnit(strPSSysUnitId, psSysUnit);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5355\u4f4d[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysUnitId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysUnit;
    }

    @Override
    protected IPSSysUnit OnCreateModelHelper(PSSysUnit vt) throws Exception {
        PSSysUnitImpl iPSSysUnit = null;
        iPSSysUnit = new PSSysUnitImpl();
        iPSSysUnit.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysUnit;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUnit obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysUnit registerModel(PSSysUnit vt) throws Exception {
        IPSSysUnit iIPSSysUnit = (IPSSysUnit)this.InternalGetModelHelper(vt.getPSSYSUNITID());
        if (iIPSSysUnit != null) {
            return iIPSSysUnit;
        }
        this.setModel(vt.getPSSYSUNITID(), vt, null);
        return (IPSSysUnit)this.FindModelHelper(vt.getPSSYSUNITID());
    }

    @Override
    protected Vector<PSSysUnit> getAllModels() throws Exception {
        Vector<PSSysUnit> list = new Vector<PSSysUnit>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysUnits(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u7cfb\u7edf\u5355\u4f4d\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUnit vt) {
        return vt.getPSSYSUNITID();
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

    protected String[] getObjectAliases(PSSysUnit vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

