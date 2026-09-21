/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.sys.IPSSystemModule
 *  net.ibizsys.model.wf.IPSWFDEDataSetRole
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFRoleUser
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSWFRole;
import net.ibizsys.model.sys.IPSSystemModule;
import net.ibizsys.model.wf.IPSWFDEDataSetRole;
import net.ibizsys.model.wf.IPSWFRoleRuntime;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFRoleUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFRoleImpl
extends PSSystemObjectImpl
implements IPSWFRoleRuntime,
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

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSWFRole psWFRole) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psWFRole = psWFRole;
            this.setId(this.psWFRole.getPSWFROLEID());
            this.setName(this.psWFRole.getPSWFROLENAME());
            this.setPSObjectData(this.psWFRole);
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
                this.iPSDataEntity = this.getPSSystem().getPSDataEntity(this.psWFRole.getPSDEID());
                this.iPSDEDataSet = this.iPSDataEntity.getPSDEDataSet(this.psWFRole.getPSDEDSID());
                this.wfUserIdPSDEF = this.iPSDataEntity.getPSDEField(this.psWFRole.getWFUSERIDPSDEFID());
                this.wfUserNamePSDEF = this.iPSDataEntity.getPSDEField(this.psWFRole.getWFUSERNAMEPSDEFID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public String getLogicName() {
        return this.getName();
    }

    @Override
    public String getCodeName() {
        return this.strCodeName;
    }

    public ISystemModel getSystemModel() {
        return null;
    }

    public String getWFRoleType() {
        return this.strWFRoleType;
    }

    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception {
        return null;
    }

    public String getUserData() {
        return this.psWFRole.getUSERDATA();
    }

    public String getUserData2() {
        return this.psWFRole.getUSERDATA2();
    }

    public String getWFRoleSN() {
        return this.psWFRole.getWFROLESN();
    }

    public Object getRuntimeId() {
        return this.getId();
    }

    public void setRuntimeId(Object objId) {
    }

    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    public IPSDEField getWFUserIdPSDEF() {
        return this.wfUserIdPSDEF;
    }

    public IPSDEField getWFUserNamePSDEF() {
        return this.wfUserNamePSDEF;
    }
}

