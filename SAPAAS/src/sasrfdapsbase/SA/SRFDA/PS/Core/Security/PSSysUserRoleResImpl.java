/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Security;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Core.Security.IPSSysUserRoleRes;
import SA.SRFDA.PS.Data.PSSysUserRoleRes;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUserRoleResImpl
extends PSObjectImpl
implements IPSSysUserRoleRes {
    private static final Log log = LogFactory.getLog(PSSysUserRoleResImpl.class);
    protected PSSysUserRoleRes psSysUserRoleRes = null;
    private IPSSysUserRole iPSSysUserRole = null;
    private IPSSysUniRes iPSSysUniRes = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysUserRole iPSSysUserRole, PSSysUserRoleRes psSysUserRoleRes) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psSysUserRoleRes = psSysUserRoleRes;
            this.setId(this.psSysUserRoleRes.getPSSYSUSERROLERESID());
            this.setName(this.psSysUserRoleRes.getPSSYSUSERROLERESNAME());
            this.setPSObjectData(this.psSysUserRoleRes);
            this.iPSSysUserRole = iPSSysUserRole;
            if (!StringHelper.isNullOrEmpty((String)psSysUserRoleRes.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.iPSSysUserRole.getPSSystem().getPSSysUniRes(psSysUserRoleRes.getPSSYSUNIRESID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u64cd\u4f5c\u89d2\u8272")
    public IPSSysUserRole getPSSysUserRole() {
        return this.iPSSysUserRole;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90", dumpref=true, fields={"PSSYSUNIRESID"})
    public IPSSysUniRes getPSSysUniRes() {
        return this.iPSSysUniRes;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSysUserRole.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSYSUSERROLERES";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysUserRole().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysUserRole().getModelId(), (Object)super.getModelId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysUserRole().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90\u4ee3\u7801", doc="\u6765\u81ea{@link #getPSSysUniRes}.{@link net.ibizsys.model.security.IPSSysUniRes#getResCode}")
    public String getSysUniResCode() {
        if (this.getPSSysUniRes() == null) {
            return null;
        }
        return this.getPSSysUniRes().getResCode();
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

