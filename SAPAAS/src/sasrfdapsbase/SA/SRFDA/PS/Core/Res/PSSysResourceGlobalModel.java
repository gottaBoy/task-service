/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.PSSysResourceImpl;
import SA.SRFDA.PS.Data.PSSysResource;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysResourceGlobalModel
extends PSSystemGlobalModelBase<String, PSSysResource, IPSSysResource> {
    private static final Log log = LogFactory.getLog(PSSysResourceGlobalModel.class);

    @Override
    protected PSSysResource GetObject(String strPSSysResourceId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysResource psSysResource = new PSSysResource();
        CallResult callResult = this.iPSModelHelper.getPSSysResource(strPSSysResourceId, psSysResource);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u8d44\u6e90[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysResourceId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysResource;
    }

    @Override
    protected IPSSysResource OnCreateModelHelper(PSSysResource vt) throws Exception {
        PSSysResourceImpl iPSSysResource = new PSSysResourceImpl();
        iPSSysResource.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysResource;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysResource obj) {
        return false;
    }

    @Override
    protected IPSSysResource registerModel(PSSysResource vt) throws Exception {
        IPSSysResource iPSSysResource = (IPSSysResource)this.InternalGetModelHelper(vt.getPSSYSRESOURCEID());
        if (iPSSysResource != null) {
            return iPSSysResource;
        }
        this.setModel(vt.getPSSYSRESOURCEID(), vt, null);
        iPSSysResource = (IPSSysResource)this.FindModelHelper(vt.getPSSYSRESOURCEID());
        return iPSSysResource;
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
    protected Vector<PSSysResource> getAllModels() throws Exception {
        Vector<PSSysResource> list = new Vector<PSSysResource>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysResources(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u9884\u7f6e\u8d44\u6e90\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysResource vt) {
        return vt.getPSSYSRESOURCEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysResource vt) {
        if (!net.ibizsys.paas.util.StringHelper.isNullOrEmpty((String)vt.getRESTAG())) {
            return new String[]{vt.getRESTAG().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

