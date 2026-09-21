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

import SA.SRFDA.PS.Core.Deploy.IPSSVNServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSSVNServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSVNServerImpl
extends PSDCResObjectImplBase
implements IPSSVNServer {
    private static final Log log = LogFactory.getLog(PSSVNServerImpl.class);
    protected PSSVNServer psSVNServer = null;
    private boolean bRemoteDeploy = false;
    private String strVSType = null;
    private String strUploadMode = "SSH";
    private String strGitPath = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSVNServer psSVNServer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psSVNServer = psSVNServer;
        this.setId(this.psSVNServer.getPSSVNSERVERID());
        this.setName(this.psSVNServer.getPSSVNSERVERNAME());
        this.setPSObjectData(this.psSVNServer);
        this.strVSType = this.psSVNServer.getSVNTYPE();
        if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getIPADDR())) {
            String strSSHIpAddr = this.psSVNServer.getIPADDR();
            this.setRemoteAddress(strSSHIpAddr);
            String strSSHUserName = this.psSVNServer.getUSERNAME();
            String strSSHPassword = this.psSVNServer.getPASSWD();
            this.setRemoteUserName(strSSHUserName);
            this.setRemotePassword(strSSHPassword);
            this.bRemoteDeploy = true;
        }
        this.strGitPath = this.psSVNServer.getGITPATH();
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public boolean isRemoteDeploy() {
        return this.bRemoteDeploy;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u670d\u52a1\u5668\u7c7b\u578b")
    public String getVSType() {
        return this.strVSType;
    }

    @Override
    public String getModelType() {
        return "PSSVNSERVER";
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getVSType() != null) {
            params.put("vs.type", this.getVSType());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getGITPATH())) {
            params.put("vs.gitpath", this.psSVNServer.getGITPATH());
            if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getGITUSERNAME())) {
                params.put("vs.gituser", this.psSVNServer.getGITUSERNAME());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getGITPASSWORD())) {
                params.put("vs.gitpass", this.psSVNServer.getGITPASSWORD());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getGITADMINUSER())) {
                params.put("vs.gitadminuser", this.psSVNServer.getGITADMINUSER());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getGITADMINPASS())) {
                params.put("vs.gitadminpass", this.psSVNServer.getGITADMINPASS());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getGITTOKEN())) {
                params.put("vs.gittoken", this.psSVNServer.getGITTOKEN());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getUSERTAG())) {
                params.put("vs.usertag", this.psSVNServer.getUSERTAG());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getUSERTAG2())) {
                params.put("vs.usertag2", this.psSVNServer.getUSERTAG2());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getUSERTAG3())) {
                params.put("vs.usertag3", this.psSVNServer.getUSERTAG3());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSVNServer.getUSERTAG4())) {
                params.put("vs.usertag4", this.psSVNServer.getUSERTAG4());
            }
        }
        params.put("vs.remote", Boolean.toString(this.isRemoteDeploy()));
    }

    @Override
    @PSModelRTMeta(description="Git\u8bbf\u95ee\u8def\u5f84", hideempty2=true)
    public String getGitPath() {
        return this.strGitPath;
    }

    @Override
    @PSModelRTMeta(description="Git\u7528\u6237", debugmode=true)
    public String getGitUserName() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getGitUserName", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.psSVNServer.getGITUSERNAME();
    }

    @Override
    @PSModelRTMeta(description="Git\u5bc6\u7801", debugmode=true, displayvalue="******")
    public String getGitPassword() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getGitPassword", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.psSVNServer.getGITPASSWORD();
    }

    @Override
    @PSModelRTMeta(description="Git\u7ba1\u7406\u5458", debugmode=true)
    public String getGitAdminUser() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getGitAdminUser", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.psSVNServer.getGITADMINUSER();
    }

    @Override
    @PSModelRTMeta(description="Git\u7ba1\u7406\u5458\u5bc6\u7801", debugmode=true, displayvalue="******")
    public String getGitAdminPass() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getGitAdminPass", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.psSVNServer.getGITADMINPASS();
    }

    @Override
    @PSModelRTMeta(description="Git\u8bbf\u95eeToken", debugmode=true, displayvalue="******")
    public String getGitToken() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getGitToken", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.psSVNServer.getGITTOKEN();
    }
}

