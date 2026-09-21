/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSGitUser;
import SA.SRFDA.PS.Core.Deploy.IPSSVNInstRepo;
import SA.SRFDA.PS.Core.Deploy.IPSSVNServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSSVNInstRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSVNInstRepoImpl
extends PSDCResObjectImplBase
implements IPSSVNInstRepo {
    private static final Log log = LogFactory.getLog(PSSVNInstRepoImpl.class);
    protected PSSVNInstRepo psSVNInstRepo = null;
    private String strSVNType = "SVN";
    private String strConnStr = "";
    private String strGitPath = "";
    private String strGitUserName = "";
    private IPSGitUser iPSGitUser = null;
    private IPSSVNServer iPSSVNServer = null;
    private String strWSVCUserName = null;
    private String strWSVCPassword = null;
    private String strGitBranch = null;
    private String strGitRepo = "IBIZ";
    private String strGitProject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSVNInstRepo psSVNInstRepo) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psSVNInstRepo = psSVNInstRepo;
        this.setId(this.psSVNInstRepo.getPSSVNINSTREPOID());
        this.setName(this.psSVNInstRepo.getPSSVNINSTREPONAME());
        this.setPSObjectData(this.psSVNInstRepo);
        this.strWSVCUserName = psSVNInstRepo.getParamStringValue("VCUSER", "");
        this.strWSVCPassword = psSVNInstRepo.getParamStringValue("VCPASSWORD", "");
        this.strConnStr = this.psSVNInstRepo.getCONNSTR();
        if (!StringHelper.isNullOrEmpty((String)this.psSVNInstRepo.getSVNTYPE())) {
            this.strSVNType = this.psSVNInstRepo.getSVNTYPE();
        }
        if (StringHelper.compare((String)this.strSVNType, (String)"GIT", (boolean)true) == 0) {
            this.strGitPath = this.psSVNInstRepo.getGITPATH();
            this.strGitUserName = this.psSVNInstRepo.getPSGITUSERNAME();
            if (!StringHelper.isNullOrEmpty((String)this.psSVNInstRepo.getPSGITUSERID())) {
                this.iPSGitUser = this.getPSModelStorage().getPSGitUser(this.psSVNInstRepo.getPSGITUSERID());
            }
            this.strGitBranch = this.psSVNInstRepo.getGITBRANCH();
        }
        if (!this.psSVNInstRepo.isLOCALRESNull()) {
            this.setLocalRes(this.psSVNInstRepo.getLOCALRES());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSVNInstRepo.getPSSVNSERVERID())) {
            this.setPSSVNServer(this.getPSModelStorage().getPSSVNServer(this.psSVNInstRepo.getPSSVNSERVERID()));
        }
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u4e32")
    public String getConnStr() {
        return this.strConnStr;
    }

    protected void setConnStr(String strConnStr) {
        this.strConnStr = strConnStr;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u5e93\u7c7b\u578b")
    public String getSVNType() {
        return this.strSVNType;
    }

    protected void setSVNType(String strSVNType) {
        this.strSVNType = strSVNType;
    }

    @Override
    @PSModelRTMeta(description="Git\u8def\u5f84", hideempty2=true)
    public String getGitPath() {
        return this.strGitPath;
    }

    protected void setGitPath(String strGitPath) {
        this.strGitPath = strGitPath;
    }

    @Override
    @PSModelRTMeta(description="Git\u5206\u652f", hideempty2=true)
    public String getGitBranch() {
        return this.strGitBranch;
    }

    protected void setGitBranch(String strGitBranch) {
        this.strGitBranch = strGitBranch;
    }

    @Override
    @PSModelRTMeta(description="Git\u7528\u6237\u540d", hideempty2=true)
    public String getGitUserName() {
        return this.strGitUserName;
    }

    protected void setGitUserName(String strGitUserName) {
        this.strGitUserName = strGitUserName;
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getSVNType() != null) {
            params.put("repo.type", this.getSVNType());
        }
        if (StringHelper.compare((String)this.getSVNType(), (String)"SVN", (boolean)true) == 0) {
            if (this.getConnStr() != null) {
                params.put("repo.path", this.getConnStr());
            }
        } else {
            if (this.getGitPath() != null) {
                params.put("repo.path", this.getGitPath());
            }
            if (this.getGitBranch() != null) {
                params.put("repo.branch", this.getGitBranch());
            }
            if (this.getGitUserName() != null) {
                params.put("repo.user", this.getGitUserName());
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getWSVCUserName())) {
            params.put("repo.wsuser", this.getWSVCUserName());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getWSVCPassword())) {
            params.put("repo.wspass", this.getWSVCPassword());
        }
    }

    @Override
    public String getModelType() {
        return "PSSVNINSTREPO";
    }

    @Override
    public IPSGitUser getPSGitUser() {
        return this.iPSGitUser;
    }

    protected void setPSGitUser(IPSGitUser iPSGitUser) {
        this.iPSGitUser = iPSGitUser;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u5e93\u670d\u52a1\u5668", hideempty2=true)
    public IPSSVNServer getPSSVNServer() {
        return this.iPSSVNServer;
    }

    protected void setPSSVNServer(IPSSVNServer iPSSVNServer) {
        this.iPSSVNServer = iPSSVNServer;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u670d\u52a1\u5668\u7248\u672c\u5e93\u7528\u6237", debugmode=true)
    public String getWSVCUserName() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getWSVCPassword", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strWSVCUserName;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u670d\u52a1\u5668\u7248\u672c\u5e93\u7528\u6237\u5bc6\u7801", debugmode=true, displayvalue="********")
    public String getWSVCPassword() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getWSVCPassword", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strWSVCPassword;
    }

    @Override
    @PSModelRTMeta(description="Git\u4ed3\u5e93\u7c7b\u578b", debugmode=true)
    public String getGitRepo() {
        return this.strGitRepo;
    }

    protected void setGitRepo(String strGitRepo) {
        this.strGitRepo = strGitRepo;
    }

    @Override
    @PSModelRTMeta(description="Git\u9879\u76ee", debugmode=true)
    public String getGitProject() {
        return this.strGitProject;
    }

    protected void setGitProject(String strGitProject) {
        this.strGitProject = strGitProject;
    }
}

