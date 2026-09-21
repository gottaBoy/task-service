/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Priv;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPrivRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRoleOPPriv;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Data.PSDEOPPrivRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.core.IDataEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEOPPrivRoleImpl
extends PSDataEntityObjectImpl
implements IPSDEOPPrivRole,
IPSDEUserRoleOPPriv {
    private static final Log log = LogFactory.getLog(PSDEOPPrivRoleImpl.class);
    protected PSDEOPPrivRole psDEOPPrivRole;
    private String strRoleType = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private IPSDEDataQuery iPSDEDataQuery = null;
    private IPSDEUserRole iPSDEUserRole = null;
    private IPSSysUserRole iPSSysUserRole = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEOPPrivRole psDEOPPrivRole) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEOPPrivRole = psDEOPPrivRole;
            this.setId(psDEOPPrivRole.getPSDEOPPRIVROLEID());
            this.setName(psDEOPPrivRole.getPSDEOPPRIVROLENAME());
            this.setPSObjectData(this.psDEOPPrivRole);
            this.strRoleType = this.psDEOPPrivRole.getROLETYPE();
            if (!StringHelper.IsNullOrEmpty((String)this.psDEOPPrivRole.getPSDEOPPRIVID())) {
                this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psDEOPPrivRole.getPSDEOPPRIVID());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEOPPrivRole.getPSDEDQID())) {
                this.iPSDEDataQuery = this.getPSDataEntity().getPSDEDataQuery(this.psDEOPPrivRole.getPSDEDQID());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEOPPrivRole.getPSDEUSERROLEID())) {
                this.iPSDEUserRole = this.getPSDataEntity().getPSDEUserRole(this.psDEOPPrivRole.getPSDEUSERROLEID());
            } else if (!StringHelper.IsNullOrEmpty((String)this.psDEOPPrivRole.getPSSYSOPPRIVID())) {
                this.iPSSysUserRole = this.getPSSystem().getPSSysUserRole(this.psDEOPPrivRole.getPSSYSOPPRIVID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
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
    public String getDEOPPrivTag() {
        if (this.getPSDEOPPriv() == null) {
            return null;
        }
        return this.getPSDEOPPriv().getName();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u6807\u8bc6", hideempty2=true)
    public String getDataAccessAction() {
        return this.getDEOPPrivTag();
    }

    @Override
    @PSModelRTMeta(description="\u89d2\u8272\u7c7b\u578b", dump=false)
    public String getRoleType() {
        return this.strRoleType;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", ignorert=3, from="IPSDataEntity", fields={"PSDEOPPRIVID"})
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"PSDEDQID"})
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    public String getDEDataQueryId() {
        if (this.getPSDEDataQuery() == null) {
            return null;
        }
        return this.getPSDEDataQuery().getId();
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public String getSysUserRoleId() {
        if (this.getPSSysUserRole() != null) {
            return this.getPSSysUserRole().getId();
        }
        return null;
    }

    public String getDEUserRoleId() {
        if (this.getPSDEUserRole() != null) {
            return this.getPSDEUserRole().getId();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272", hideempty2=true, outputdoc="false")
    public IPSDEUserRole getPSDEUserRole() {
        return this.iPSDEUserRole;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u64cd\u4f5c\u89d2\u8272", hideempty2=true, outputdoc="false")
    public IPSSysUserRole getPSSysUserRole() {
        return this.iPSSysUserRole;
    }

    @Override
    public String getModelType() {
        return "PSDEOPPRIVROLE";
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6761\u4ef6", fields={"CUSTOMCOND"})
    public String getCustomCond() {
        return this.psDEOPPrivRole.getCUSTOMCOND();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

