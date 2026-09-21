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
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Core.UML.PSSysActorImpl;
import SA.SRFDA.PS.Data.PSSysActor;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysActorGlobalModel
extends PSSystemGlobalModelBase<String, PSSysActor, IPSSysActor> {
    private static final Log log = LogFactory.getLog(PSSysActorGlobalModel.class);

    @Override
    protected PSSysActor GetObject(String strPSSysActorId) {
        PSSysActor psSysActor = new PSSysActor();
        CallResult callResult = this.iPSModelHelper.getPSSysActor(strPSSysActorId, psSysActor);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u64cd\u4f5c\u8005[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysActorId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysActor;
    }

    @Override
    protected IPSSysActor OnCreateModelHelper(PSSysActor vt) throws Exception {
        PSSysActorImpl iPSSysActor = null;
        iPSSysActor = new PSSysActorImpl();
        iPSSysActor.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysActor;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysActor obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysActor registerModel(PSSysActor vt) throws Exception {
        IPSSysActor iIPSSysActor = (IPSSysActor)this.InternalGetModelHelper(vt.getPSSYSACTORID());
        if (iIPSSysActor != null) {
            return iIPSSysActor;
        }
        this.setModel(vt.getPSSYSACTORID(), vt, null);
        return (IPSSysActor)this.FindModelHelper(vt.getPSSYSACTORID());
    }

    @Override
    protected Vector<PSSysActor> getAllModels() throws Exception {
        Vector<PSSysActor> list = new Vector<PSSysActor>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysActors(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u64cd\u4f5c\u8005\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysActor vt) {
        return vt.getPSSYSACTORID();
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

    protected String[] getObjectAliases(PSSysActor vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

