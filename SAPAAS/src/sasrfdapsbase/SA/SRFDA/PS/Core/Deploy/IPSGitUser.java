/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSGitUser;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSGitUser
extends IPSDCResObject,
IPSRemoteResObject {
    public static final String CFG_GIT_USER = "git.user";
    public static final String CFG_GIT_PASS = "git.pass";
    public static final String CFG_GIT_PATH = "git.path";

    public void init(ISRFDAGlobalHelper var1, PSGitUser var2) throws Exception;

    public String getGitPath();
}

