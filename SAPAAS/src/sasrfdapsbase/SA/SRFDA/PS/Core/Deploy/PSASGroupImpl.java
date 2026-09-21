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

import SA.SRFDA.PS.Core.Deploy.IPSASGroup;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSASGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSASGroupImpl
extends PSObjectImpl
implements IPSASGroup {
    private static final Log log = LogFactory.getLog(PSASGroupImpl.class);
    protected PSASGroup psASGroup = null;
    private String strSSHIpAddr = null;
    private int nSSHPort = 22;
    private String strSSHUserName = null;
    private String strSSHPassword = null;
    private int nHttpPort = -1;
    private int nHttpsPort = -1;
    private String strASType = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSASGroup psASGroup) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psASGroup = psASGroup;
        this.setId(this.psASGroup.getPSASGROUPID());
        this.setName(this.psASGroup.getPSASGROUPNAME());
        this.setPSObjectData(this.psASGroup);
        if (!StringHelper.isNullOrEmpty((String)this.psASGroup.getSSHIPADDR())) {
            this.strSSHIpAddr = this.psASGroup.getSSHIPADDR();
            if (!this.psASGroup.isSSHPORTNull()) {
                this.nSSHPort = this.psASGroup.getSSHPORT();
            }
            this.strSSHUserName = this.psASGroup.getUSERNAME();
            this.strSSHPassword = this.psASGroup.getPASSWD();
        }
        this.strASType = this.psASGroup.getASTYPE();
        if (!this.psASGroup.isHTTPPORTNull()) {
            this.nHttpPort = this.psASGroup.getHTTPPORT();
        }
        if (!this.psASGroup.isHTTPSPORTNull()) {
            this.nHttpsPort = this.psASGroup.getHTTPSPORT();
        }
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getSSHIPAddr() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getSSHIPAddr", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strSSHIpAddr;
    }

    @Override
    public int getSSHPort() {
        return this.nSSHPort;
    }

    @Override
    public String getSSHUserName() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getSSHUserName", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strSSHUserName;
    }

    @Override
    public String getSSHPassword() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getSSHPassword", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strSSHPassword;
    }

    @Override
    public String getASType() {
        return this.strASType;
    }

    @Override
    public int getHttpPort() {
        return this.nHttpPort;
    }

    @Override
    public int getHttpsPort() {
        return this.nHttpsPort;
    }
}

