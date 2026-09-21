/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.PSSysModelGroupImpl;
import SA.SRFDA.PS.Data.PSSysModelGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysModelGroupGlobalModel
extends PSSystemGlobalModelBase<String, PSSysModelGroup, IPSSysModelGroup> {
    private static final Log log = LogFactory.getLog(PSSysModelGroupGlobalModel.class);

    @Override
    protected PSSysModelGroup GetObject(String strPSSysModelGroupId) {
        PSSysModelGroup psSysModelGroup = new PSSysModelGroup();
        CallResult callResult = this.iPSModelHelper.getPSSysModelGroup(strPSSysModelGroupId, psSysModelGroup);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6a21\u578b\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysModelGroupId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysModelGroup;
    }

    @Override
    protected IPSSysModelGroup OnCreateModelHelper(PSSysModelGroup vt) throws Exception {
        PSSysModelGroupImpl iPSSysModelGroup = new PSSysModelGroupImpl();
        iPSSysModelGroup.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysModelGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysModelGroup obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            Iterator iterator = this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected IPSSysModelGroup registerModel(PSSysModelGroup vt) throws Exception {
        IPSSysModelGroup iPSSysModelGroup = (IPSSysModelGroup)this.InternalGetModelHelper(vt.getPSSYSMODELGROUPID());
        if (iPSSysModelGroup != null) {
            return iPSSysModelGroup;
        }
        this.setModel(vt.getPSSYSMODELGROUPID(), vt, null);
        return (IPSSysModelGroup)this.FindModelHelper(vt.getPSSYSMODELGROUPID());
    }

    @Override
    protected Vector<PSSysModelGroup> getAllModels() throws Exception {
        Vector<PSSysModelGroup> list = new Vector<PSSysModelGroup>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysModelGroups(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6a21\u578b\u7ec4\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysModelGroup vt) {
        return vt.getPSSYSMODELGROUPID();
    }
}

