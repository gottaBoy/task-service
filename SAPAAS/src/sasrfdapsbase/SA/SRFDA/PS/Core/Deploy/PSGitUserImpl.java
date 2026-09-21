/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSGitUser;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Data.PSGitUser;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;

public class PSGitUserImpl
extends PSDCResObjectImplBase
implements IPSGitUser {
    protected PSGitUser psGitUser = null;
    private String strGitPath = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSGitUser psGitUser) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psGitUser = psGitUser;
        this.setId(this.psGitUser.getPSGITUSERID());
        this.setName(this.psGitUser.getPSGITUSERNAME());
        this.setPSObjectData(this.psGitUser);
        this.strGitPath = this.psGitUser.getGITPATH();
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getModelType() {
        return "PSGITUSER";
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        params.put("git.user", this.psGitUser.getPSGITUSERNAME());
        params.put("git.pass", this.psGitUser.getPASSWD());
        params.put("git.path", this.getGitPath());
    }

    @Override
    public String getGitPath() {
        return this.strGitPath;
    }
}

