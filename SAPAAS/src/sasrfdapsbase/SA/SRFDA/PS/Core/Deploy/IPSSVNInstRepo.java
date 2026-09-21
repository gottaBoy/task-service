/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSGitUser;
import SA.SRFDA.PS.Core.Deploy.IPSSVNServer;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSSVNInstRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSVNInstRepo
extends IPSDCResObject {
    public static final String CFG_REPO_TYPE = "repo.type";
    public static final String CFG_REPO_USER = "repo.user";
    public static final String CFG_REPO_PATH = "repo.path";
    public static final String CFG_REPO_BRANCH = "repo.branch";
    public static final String CFG_REPO_WSUSER = "repo.wsuser";
    public static final String CFG_REPO_WSPASS = "repo.wspass";
    public static final String SVNTYPE_SVN = "SVN";
    public static final String SVNTYPE_GIT = "GIT";
    public static final String GITREPO_IBIZ = "IBIZ";
    public static final String GITREPO_GITEE = "GITEE";
    public static final String GITREPO_GITLAB = "GITLAB";
    public static final String GITREPO_GITHUB = "GITHUB";
    public static final String GITREPO_OTHER = "OTHER";

    public void init(ISRFDAGlobalHelper var1, PSSVNInstRepo var2) throws Exception;

    public String getConnStr();

    public String getSVNType();

    public String getGitPath();

    public String getGitUserName();

    public String getGitBranch();

    public IPSGitUser getPSGitUser();

    public IPSSVNServer getPSSVNServer();

    public String getWSVCUserName();

    public String getWSVCPassword();

    public String getGitRepo();

    public String getGitProject();
}

