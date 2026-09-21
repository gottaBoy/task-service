/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCSVNInstRepo;
import SA.SRFDA.PS.Core.Deploy.IPSGitUser;
import SA.SRFDA.PS.Core.Deploy.PSSVNInstRepoImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSDevCenterSVN;
import SA.SRFDA.PS.Data.PSSVNInstRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCSVNInstRepoImpl
extends PSSVNInstRepoImpl
implements IPSDCSVNInstRepo {
    private static final Log log = LogFactory.getLog(PSDCSVNInstRepoImpl.class);
    private PSDevCenterSVN psDevCenterSVN = null;
    private PSSVNInstRepo psSVNInstRepo = null;
    private String strWSVCUserName = null;
    private String strWSVCPassword = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDevCenterSVN psDevCenterSVN) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevCenterSVN = psDevCenterSVN;
        if (this.psDevCenterSVN.getEXPRIEDTIME() != null) {
            this.setExpiredTime(new Timestamp(this.psDevCenterSVN.getEXPRIEDTIME().getTime()));
        }
        this.strWSVCUserName = psDevCenterSVN.getParamStringValue("VCUSER", "");
        this.strWSVCPassword = psDevCenterSVN.getParamStringValue("VCPASSWORD", "");
        String strGitRepoType = psDevCenterSVN.getParamStringValue("GITREPO", "");
        if (!StringHelper.IsNullOrEmpty((String)psDevCenterSVN.getPSSVNINSTREPOID())) {
            if (StringHelper.IsNullOrEmpty((String)strGitRepoType)) {
                strGitRepoType = "IBIZ";
            }
        } else if (StringHelper.IsNullOrEmpty((String)strGitRepoType)) {
            strGitRepoType = "OTHER";
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevCenterSVN.getPSSVNINSTREPOID())) {
            this.psSVNInstRepo = new PSSVNInstRepo();
            CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSSVNInstRepoByDevCenterSVNId(psDevCenterSVN.getPSDEVCENTERSVNID(), this.psSVNInstRepo);
            if (callResult.isError()) {
                String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                throw new Exception(strInfo);
            }
            this.psSVNInstRepo.setPSSVNINSTREPOID(this.psDevCenterSVN.getPSDEVCENTERSVNID());
            this.psSVNInstRepo.setPSSVNINSTREPONAME(this.psDevCenterSVN.getPSDEVCENTERSVNNAME());
            if (!StringHelper.IsNullOrEmpty((String)this.psDevCenterSVN.getSVNTYPE())) {
                this.psSVNInstRepo.setSVNTYPE(this.psDevCenterSVN.getSVNTYPE());
            }
            if (StringHelper.Compare((String)this.psDevCenterSVN.getSVNTYPE(), (String)"GIT", (boolean)true) == 0) {
                this.psSVNInstRepo.setGITPATH(psDevCenterSVN.getGITPATH());
                this.psSVNInstRepo.setPSGITUSERNAME(psDevCenterSVN.getPSGITUSERNAME());
                this.psSVNInstRepo.setPSGITUSERID(psDevCenterSVN.getPSGITUSERID());
                this.setGitRepo(strGitRepoType);
                if (StringHelper.Compare((String)this.getGitRepo(), (String)"IBIZ", (boolean)false) != 0) {
                    this.setGitProject(this.psDevCenterSVN.getGITPRJ());
                }
            }
            this.init(iDAGlobalHelper, this.psSVNInstRepo);
            this.setPSObjectData(this.psDevCenterSVN);
        } else {
            this.setId(this.psDevCenterSVN.getPSDEVCENTERSVNID());
            this.setName(this.psDevCenterSVN.getPSDEVCENTERSVNNAME());
            this.setPSObjectData(this.psDevCenterSVN);
            if (!StringHelper.IsNullOrEmpty((String)this.psDevCenterSVN.getSVNTYPE())) {
                this.setSVNType(this.psDevCenterSVN.getSVNTYPE());
            }
            if (StringHelper.Compare((String)this.getSVNType(), (String)"GIT", (boolean)true) == 0) {
                this.setGitPath(this.psDevCenterSVN.getGITPATH());
                this.setGitUserName(this.psDevCenterSVN.getPSGITUSERNAME());
                if (!StringHelper.IsNullOrEmpty((String)this.psDevCenterSVN.getPSGITUSERID())) {
                    IPSGitUser iPSGitUser = this.getPSModelStorage().getPSGitUser(this.psDevCenterSVN.getPSGITUSERID());
                    this.setPSGitUser(iPSGitUser);
                }
                this.setGitRepo(strGitRepoType);
                this.setGitProject(this.psDevCenterSVN.getGITPRJ());
                this.setGitBranch(this.psDevCenterSVN.getGITBRANCH());
            }
            this.onInit();
        }
    }

    @Override
    public String getModelType() {
        return "PSDEVCENTERSVN";
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u670d\u52a1\u5668\u7248\u672c\u5e93\u7528\u6237", debugmode=true)
    public String getWSVCUserName() {
        return this.strWSVCUserName;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u7a0b\u670d\u52a1\u5668\u7248\u672c\u5e93\u7528\u6237\u5bc6\u7801", debugmode=true, displayvalue="********")
    public String getWSVCPassword() {
        return this.strWSVCPassword;
    }
}

