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

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Core.Security.IPSSysUserRoleData;
import SA.SRFDA.PS.Data.PSSysUserRoleData;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUserRoleDataImpl
extends PSObjectImpl
implements IPSSysUserRoleData {
    private static final Log log = LogFactory.getLog(PSSysUserRoleDataImpl.class);
    protected PSSysUserRoleData psSysUserRoleData = null;
    private IPSSysUserRole iPSSysUserRole = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEUserRole iPSDEUserRole = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysUserRole iPSSysUserRole, PSSysUserRoleData psSysUserRoleData) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psSysUserRoleData = psSysUserRoleData;
            this.setId(this.psSysUserRoleData.getPSSYSUSERROLEDATAID());
            this.setName(this.psSysUserRoleData.getPSSYSUSERROLEDATANAME());
            this.setPSObjectData(this.psSysUserRoleData);
            this.iPSSysUserRole = iPSSysUserRole;
            if (StringHelper.isNullOrEmpty((String)psSysUserRoleData.getPSDEID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u80fd\u529b\u7684\u5b9e\u4f53\u5bf9\u8c61");
            }
            this.iPSDataEntity = this.iPSSysUserRole.getPSSystem().getPSDataEntity2(psSysUserRoleData.getPSDEID());
            if (StringHelper.isNullOrEmpty((String)psSysUserRoleData.getPSDEUSERROLEID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u80fd\u529b\u5bf9\u8c61");
            }
            this.iPSDEUserRole = this.getPSDataEntity().getPSDEUserRole(psSysUserRoleData.getPSDEUSERROLEID());
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
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u80fd\u529b\u89d2\u8272", dumpref=true, fields={"PSDEUSERROLEID"})
    public IPSDEUserRole getPSDEUserRole() {
        return this.iPSDEUserRole;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSysUserRole.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSYSUSERROLEDATA";
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
    public String getModelRefId() {
        return null;
    }
}

