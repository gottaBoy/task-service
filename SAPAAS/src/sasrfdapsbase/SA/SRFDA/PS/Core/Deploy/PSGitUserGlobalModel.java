/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSGitUser;
import SA.SRFDA.PS.Core.Deploy.PSGitUserImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSGitUser;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSGitUserGlobalModel
extends PSGlobalModelBase<String, PSGitUser, IPSGitUser> {
    private static final Log log = LogFactory.getLog(PSGitUserGlobalModel.class);

    @Override
    protected PSGitUser GetObject(String strPSGitUserId) {
        PSGitUser psGitUser = new PSGitUser();
        CallResult callResult = this.iPSModelHelper.getPSGitUser(strPSGitUserId, psGitUser);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0GIT\u7528\u6237[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSGitUserId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psGitUser;
    }

    @Override
    protected IPSGitUser OnCreateModelHelper(PSGitUser vt) throws Exception {
        PSGitUserImpl iPSGitUser = new PSGitUserImpl();
        iPSGitUser.init(this.iDAGlobalHelper, vt);
        return iPSGitUser;
    }

    @Override
    protected Boolean TestObjectRenew(PSGitUser obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSGitUser vt) {
        return vt.getPSGITUSERID();
    }
}

