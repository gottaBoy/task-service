/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpResource;
import SA.SRFDA.PS.Core.Help.PSHelpResourceImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSHelpResource;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpResourceGlobalModel
extends PSSystemGlobalModelBase<String, PSHelpResource, IPSHelpResource> {
    private static final Log log = LogFactory.getLog(PSHelpResourceGlobalModel.class);

    @Override
    protected PSHelpResource GetObject(String strPSHelpResourceId) {
        return null;
    }

    @Override
    protected IPSHelpResource OnCreateModelHelper(PSHelpResource vt) throws Exception {
        PSHelpResourceImpl iPSHelpResource = new PSHelpResourceImpl();
        iPSHelpResource.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSHelpResource;
    }

    @Override
    protected Boolean TestObjectRenew(PSHelpResource obj) {
        return false;
    }

    @Override
    protected IPSHelpResource registerModel(PSHelpResource vt) throws Exception {
        IPSHelpResource iPSHelpResource = (IPSHelpResource)this.InternalGetModelHelper(vt.getPSHELPRESOURCEID());
        if (iPSHelpResource != null) {
            return iPSHelpResource;
        }
        this.setModel(vt.getPSHELPRESOURCEID(), vt, null);
        iPSHelpResource = (IPSHelpResource)this.FindModelHelper(vt.getPSHELPRESOURCEID());
        return iPSHelpResource;
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
    protected Vector<PSHelpResource> getAllModels() throws Exception {
        Vector<PSHelpResource> list = new Vector<PSHelpResource>();
        CallResult callResult = this.iPSModelHelper.getAllPSHelpResources(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u5e2e\u52a9\u8d44\u6e90\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSHelpResource vt) {
        return vt.getPSHELPRESOURCEID();
    }
}

