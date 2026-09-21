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

import SA.SRFDA.PS.Core.Deploy.IPSDCRegistryRepo;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSDCRegistryRepo;
import SA.SRFDA.PS.Data.PSRegistryRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCRegistryRepoImpl
extends PSDCResObjectImplBase
implements IPSDCRegistryRepo {
    private static final Log log = LogFactory.getLog(PSDCRegistryRepoImpl.class);
    protected PSDCRegistryRepo psDCRegistryRepo = null;
    private String strRegistryType = "REGISTRY";
    private String strConnStr = "";
    private String strUserName = null;
    private String strPassword = null;
    private String strAdminUserName = null;
    private String strAdminPassword = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCRegistryRepo psDCRegistryRepo) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCRegistryRepo = psDCRegistryRepo;
        this.setId(this.psDCRegistryRepo.getPSDCREGISTRYREPOID());
        this.setName(this.psDCRegistryRepo.getPSDCREGISTRYREPONAME());
        this.setPSObjectData(this.psDCRegistryRepo);
        this.strUserName = psDCRegistryRepo.getROUSERNAME();
        this.strPassword = psDCRegistryRepo.getROPASSWD();
        this.strAdminUserName = psDCRegistryRepo.getREGISTRYUSERNAME();
        this.strAdminPassword = psDCRegistryRepo.getREGISTRYPASSWD();
        this.strConnStr = this.psDCRegistryRepo.getCONNSTR();
        this.setLocalRes(false);
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
    @PSModelRTMeta(description="\u955c\u50cf\u5e93\u7c7b\u578b")
    public String getRegistryType() {
        return this.strRegistryType;
    }

    protected void setRegistryType(String strRegistryType) {
        this.strRegistryType = strRegistryType;
    }

    @Override
    public String getUserName() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getUserName", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strUserName;
    }

    @Override
    public String getPassword() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getPassword", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strPassword;
    }

    protected void setUserName(String strUserName) {
        this.strUserName = strUserName;
    }

    protected void setPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    @Override
    public String getAdminUserName() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getAdminUserName", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strAdminUserName;
    }

    @Override
    public String getAdminPassword() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getAdminPassword", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strAdminPassword;
    }

    protected void setAdminUserName(String strAdminUserName) {
        this.strAdminUserName = strAdminUserName;
    }

    protected void setAdminPassword(String strAdminPassword) {
        this.strAdminPassword = strAdminPassword;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSRegistryRepo psRegistryRepo) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getModelType() {
        return "PSDCREGISTRYREPO";
    }
}

