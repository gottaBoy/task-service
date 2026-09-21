/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.UML;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.UML.IPSSysUCMap;
import SA.SRFDA.PS.Core.UML.PSSysUCMapImpl;
import SA.SRFDA.PS.Data.PSSysUCMap;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUCMapGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUCMap, IPSSysUCMap> {
    private static final Log log = LogFactory.getLog(PSSysUCMapGlobalModel.class);

    @Override
    protected PSSysUCMap GetObject(String strPSSysUCMapId) {
        return null;
    }

    @Override
    protected IPSSysUCMap OnCreateModelHelper(PSSysUCMap vt) throws Exception {
        PSSysUCMapImpl iPSSysUCMap = null;
        iPSSysUCMap = new PSSysUCMapImpl();
        iPSSysUCMap.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysUCMap;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUCMap obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysUCMap registerModel(PSSysUCMap vt) throws Exception {
        IPSSysUCMap iIPSSysUCMap = (IPSSysUCMap)this.InternalGetModelHelper(vt.getPSSYSUCMAPID());
        if (iIPSSysUCMap != null) {
            return iIPSSysUCMap;
        }
        this.setModel(vt.getPSSYSUCMAPID(), vt, null);
        return (IPSSysUCMap)this.FindModelHelper(vt.getPSSYSUCMAPID());
    }

    @Override
    protected Vector<PSSysUCMap> getAllModels() throws Exception {
        Vector<PSSysUCMap> list = new Vector<PSSysUCMap>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysUCMaps(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8UC\u56fe\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUCMap vt) {
        return vt.getPSSYSUCMAPID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysUCMap vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

