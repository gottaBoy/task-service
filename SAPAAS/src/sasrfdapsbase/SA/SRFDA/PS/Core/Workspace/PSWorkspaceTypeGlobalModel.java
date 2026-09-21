/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Workspace;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspaceType;
import SA.SRFDA.PS.Core.Workspace.PSWorkspaceTypeImpl;
import SA.SRFDA.PS.Data.PSWorkspaceType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkspaceTypeGlobalModel
extends PSGlobalModelBase<String, PSWorkspaceType, IPSWorkspaceType> {
    private static final Log log = LogFactory.getLog(PSWorkspaceTypeGlobalModel.class);

    @Override
    protected PSWorkspaceType GetObject(String strPSWorkspaceTypeId) {
        PSWorkspaceType PSWorkspaceType2 = new PSWorkspaceType();
        CallResult callResult = this.iPSModelHelper.getPSWorkspaceType(strPSWorkspaceTypeId, PSWorkspaceType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u751f\u4ea7\u7ebf\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWorkspaceTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSWorkspaceType2;
    }

    @Override
    protected IPSWorkspaceType OnCreateModelHelper(PSWorkspaceType vt) throws Exception {
        PSWorkspaceTypeImpl iPSWorkspaceType = new PSWorkspaceTypeImpl();
        iPSWorkspaceType.init(this.iDAGlobalHelper, vt);
        return iPSWorkspaceType;
    }

    @Override
    protected Boolean TestObjectRenew(PSWorkspaceType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSWorkspaceType vt) {
        return vt.getPSWORKSPACETYPEID();
    }
}

