/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFRoleUser
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.WF.IPSWFDEDataSetRole;
import SA.SRFDA.PS.Core.WF.IPSWFRole;
import SA.SRFDA.PS.Data.PSWFRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFRoleUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSWFRoleImpl
extends PSSystemObjectImpl
implements IPSWFRole,
IPSWFDEDataSetRole {
    private static final Log log = LogFactory.getLog(PSWFRoleImpl.class);
    protected PSWFRole psWFRole;
    private String strCodeName = "";
    private String strWFRoleType = "";
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEField wfUserIdPSDEF = null;
    private IPSDEField wfUserNamePSDEF = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSWFRole psWFRole) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psWFRole = psWFRole;
            this.setId(this.psWFRole.getPSWFROLEID());
            this.setName(this.psWFRole.getPSWFROLENAME());
            this.setPSObjectData(this.psWFRole);
            if (!StringHelper.isNullOrEmpty((String)this.psWFRole.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psWFRole.getPSMODULEID());
            }
            this.strWFRoleType = this.psWFRole.getWFROLETYPE();
            this.strCodeName = this.psWFRole.getCODENAME();
            if (StringHelper.compare((String)this.getWFRoleType(), (String)"DEDATASET", (boolean)false) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psWFRole.getPSDEID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7ed3\u679c\u96c6\u5408\u5b9e\u4f53\u5bf9\u8c61");
                }
                if (StringHelper.isNullOrEmpty((String)this.psWFRole.getPSDEDSID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7ed3\u679c\u96c6\u5408\u5bf9\u8c61");
                }
                if (StringHelper.isNullOrEmpty((String)this.psWFRole.getWFUSERIDPSDEFID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u7528\u6237\u6807\u8bc6\u5b58\u50a8\u5c5e\u6027");
                }
                if (StringHelper.isNullOrEmpty((String)this.psWFRole.getWFUSERNAMEPSDEFID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u7528\u6237\u540d\u79f0\u5b58\u50a8\u5c5e\u6027");
                }
                this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psWFRole.getPSDEID());
                this.iPSDEDataSet = this.iPSDataEntity.getPSDEDataSet(this.psWFRole.getPSDEDSID());
                this.wfUserIdPSDEF = this.iPSDataEntity.getPSDEField(this.psWFRole.getWFUSERIDPSDEFID());
                this.wfUserNamePSDEF = this.iPSDataEntity.getPSDEField(this.psWFRole.getWFUSERNAMEPSDEFID());
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
        String strPSSysSFPluginId = this.psWFRole.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
        this.registerToPSModelObject(this.iPSDataEntity);
        this.registerToPSModelObject(this.iPSDEDataSet);
        this.registerToPSModelObject(this.wfUserIdPSDEF);
        this.registerToPSModelObject(this.wfUserNamePSDEF);
    }

    @Override
    public String getLogicName() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    public ISystemModel getSystemModel() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u89d2\u8272\u7c7b\u578b", codelist="WFRoleType", group="\u57fa\u672c", order=125, fields={"WFROLETYPE"})
    public String getWFRoleType() {
        return this.strWFRoleType;
    }

    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u89d2\u8272\u6570\u636e", hideempty2=true, fields={"USERDATA"})
    public String getUserData() {
        return this.psWFRole.getUSERDATA();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u89d2\u8272\u6570\u636e2", hideempty2=true, fields={"USERDATA2"})
    public String getUserData2() {
        return this.psWFRole.getUSERDATA2();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u89d2\u8272\u7f16\u53f7", hideempty2=true, group="\u57fa\u672c", order=105, fields={"WFROLESN"})
    public String getWFRoleSN() {
        return this.psWFRole.getWFROLESN();
    }

    @Override
    public String getModelType() {
        return "PSWFROLE";
    }

    public Object getRuntimeId() {
        return this.getId();
    }

    public void setRuntimeId(Object objId) {
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u6e90\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u6e90\u6570\u636e\u96c6\u5408", hideempty=true, dumpref=true, from="IPSDataEntity", fields={"PSDEDSID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u7528\u6237\u6807\u8bc6\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity", fields={"WFUSERIDPSDEFID"})
    public IPSDEField getWFUserIdPSDEF() {
        return this.wfUserIdPSDEF;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u7528\u6237\u540d\u79f0\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity", fields={"WFUSERNAMEPSDEFID"})
    public IPSDEField getWFUserNamePSDEF() {
        return this.wfUserNamePSDEF;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, hideempty=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        String strRootDeployId = "";
        strRootDeployId = this.getPSSystemModule() != null ? this.getPSSystemModule().getDeployId() : this.getPSSystem().getDeployId();
        if (StringHelper.compare((String)this.getWFRoleType(), (String)"ORGSECTORGROUP", (boolean)true) == 0) {
            return KeyValueHelper.genUniqueId((String)strRootDeployId, (String)this.getPSSystemUtil().getDeploySysOrgId(), (String)this.getCodeName());
        }
        if (StringHelper.compare((String)this.getWFRoleType(), (String)"ORGUSERGROUP", (boolean)true) == 0) {
            return KeyValueHelper.genUniqueId((String)strRootDeployId, (String)this.getPSSystemUtil().getDeploySysOrgId(), (String)this.getCodeName());
        }
        if (StringHelper.compare((String)this.getWFRoleType(), (String)"ORGSECTORUSERGROUP", (boolean)true) == 0) {
            return KeyValueHelper.genUniqueId((String)strRootDeployId, (String)this.getPSSystemUtil().getDeploySysOrgId(), (String)this.getPSSystemUtil().getDeploySysOrgSectorId(), (String)this.getCodeName());
        }
        return KeyValueHelper.genUniqueId((String)strRootDeployId, (String)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u89d2\u8272\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        String strCodeName = this.getCodeName();
        if (StringHelper.isNullOrEmpty((String)strCodeName)) {
            strCodeName = this.getName();
        }
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), strCodeName);
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), strCodeName);
        }
        return strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }
}

