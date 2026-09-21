/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.ER;

import SA.SRFDA.PS.Core.ER.IPSSysERMap;
import SA.SRFDA.PS.Core.ER.PSSysERMapImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysERMap;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysERMapGlobalModel
extends PSSystemGlobalModelBase<String, PSSysERMap, IPSSysERMap> {
    private static final Log log = LogFactory.getLog(PSSysERMapGlobalModel.class);

    @Override
    protected PSSysERMap GetObject(String strPSSysERMapId) {
        PSSysERMap psSysERMap = new PSSysERMap();
        CallResult callResult = this.iPSModelHelper.getPSSysERMap(strPSSysERMapId, psSysERMap);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edfER\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysERMapId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysERMap;
    }

    @Override
    protected IPSSysERMap OnCreateModelHelper(PSSysERMap vt) throws Exception {
        PSSysERMapImpl iPSSysERMap = null;
        iPSSysERMap = new PSSysERMapImpl();
        iPSSysERMap.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysERMap;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysERMap obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysERMap registerModel(PSSysERMap vt) throws Exception {
        IPSSysERMap iIPSSysERMap = (IPSSysERMap)this.InternalGetModelHelper(vt.getPSSYSERMAPID());
        if (iIPSSysERMap != null) {
            return iIPSSysERMap;
        }
        this.setModel(vt.getPSSYSERMAPID(), vt, null);
        return (IPSSysERMap)this.FindModelHelper(vt.getPSSYSERMAPID());
    }

    @Override
    protected Vector<PSSysERMap> getAllModels() throws Exception {
        Vector<PSSysERMap> list = new Vector<PSSysERMap>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysERMaps(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8ER\u56fe\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysERMap vt) {
        return vt.getPSSYSERMAPID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysERMap vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

