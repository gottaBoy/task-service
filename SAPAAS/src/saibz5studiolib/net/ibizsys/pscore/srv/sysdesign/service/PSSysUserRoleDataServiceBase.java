/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRoleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysUserRoleDataDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserRoleDataDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPriv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPrivBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleData;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUserRoleDataServiceBase
extends PSCoreSysServiceBase<PSSysUserRoleData> {
    private static final Log log = LogFactory.getLog(PSSysUserRoleDataServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysUserRoleDataDEModel pSSysUserRoleDataDEModel;
    private PSSysUserRoleDataDAO pSSysUserRoleDataDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleDataService";
    }

    public PSSysUserRoleDataDEModel getPSSysUserRoleDataDEModel() {
        if (this.pSSysUserRoleDataDEModel == null) {
            try {
                this.pSSysUserRoleDataDEModel = (PSSysUserRoleDataDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserRoleDataDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUserRoleDataDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysUserRoleDataDEModel();
    }

    public PSSysUserRoleDataDAO getPSSysUserRoleDataDAO() {
        if (this.pSSysUserRoleDataDAO == null) {
            try {
                this.pSSysUserRoleDataDAO = (PSSysUserRoleDataDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysUserRoleDataDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUserRoleDataDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysUserRoleDataDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysUserRoleData pSSysUserRoleData, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERROLEDATA_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysUserRoleData, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERROLEDATA_PSDEUSERROLE_PSDEUSERROLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService", (SessionFactory)this.getSessionFactory());
            PSDEUserRole pSDEUserRole = (PSDEUserRole)iService.getDEModel().createEntity();
            pSDEUserRole.set("PSDEUSERROLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUserRole);
            } else {
                iService.get(pSDEUserRole);
            }
            this.onFillParentInfo_PSDEUserRole(pSSysUserRoleData, pSDEUserRole);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService", (SessionFactory)this.getSessionFactory());
            PSSysOPPriv pSSysOPPriv = (PSSysOPPriv)iService.getDEModel().createEntity();
            pSSysOPPriv.set("PSSYSOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysOPPriv);
            } else {
                iService.get(pSSysOPPriv);
            }
            this.onFillParentInfo_PSSysOPPriv(pSSysUserRoleData, pSSysOPPriv);
            return;
        }
        super.onFillParentInfo(pSSysUserRoleData, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysUserRoleData pSSysUserRoleData, PSDataEntity pSDataEntity) throws Exception {
        pSSysUserRoleData.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysUserRoleData.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEUserRole(PSSysUserRoleData pSSysUserRoleData, PSDEUserRole pSDEUserRole) throws Exception {
        pSSysUserRoleData.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
        pSSysUserRoleData.setPSDEUserRoleName(pSDEUserRole.getPSDEUserRoleName());
        if (pSDEUserRole.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSSysUserRoleData, pSDEUserRole.getPSDE());
        }
    }

    protected void onFillParentInfo_PSSysOPPriv(PSSysUserRoleData pSSysUserRoleData, PSSysOPPriv pSSysOPPriv) throws Exception {
        pSSysUserRoleData.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
        pSSysUserRoleData.setPSSysOPPrivName(pSSysOPPriv.getPSSysOPPrivName());
    }

    protected void onFillEntityFullInfo(PSSysUserRoleData pSSysUserRoleData, boolean bl) throws Exception {
        if (bl && pSSysUserRoleData.getValidFlag() == null) {
            pSSysUserRoleData.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSSysUserRoleData, bl);
        this.onFillEntityFullInfo_PSDE(pSSysUserRoleData, bl);
        this.onFillEntityFullInfo_PSDEUserRole(pSSysUserRoleData, bl);
        this.onFillEntityFullInfo_PSSysOPPriv(pSSysUserRoleData, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysUserRoleData pSSysUserRoleData, boolean bl) throws Exception {
        if (pSSysUserRoleData.isPSDEIdDirty()) {
            if (pSSysUserRoleData.getPSDEId() != null) {
                if (pSSysUserRoleData.getPSDEId() == null || pSSysUserRoleData.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysUserRoleData.getPSDE();
                    pSSysUserRoleData.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysUserRoleData.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEUserRole(PSSysUserRoleData pSSysUserRoleData, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysOPPriv(PSSysUserRoleData pSSysUserRoleData, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysUserRoleData pSSysUserRoleData, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysUserRoleData, bl);
    }

    public ArrayList<PSSysUserRoleData> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysUserRoleData> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysUserRoleData> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUserRoleData> selectByPSDEUserRole(PSDEUserRoleBase pSDEUserRoleBase) throws Exception {
        return this.selectByPSDEUserRole(pSDEUserRoleBase, "", -1);
    }

    public ArrayList<PSSysUserRoleData> selectByPSDEUserRole(PSDEUserRoleBase pSDEUserRoleBase, String string) throws Exception {
        return this.selectByPSDEUserRole(pSDEUserRoleBase, string, -1);
    }

    public ArrayList<PSSysUserRoleData> selectByPSDEUserRole(PSDEUserRoleBase pSDEUserRoleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUSERROLEID", (Object)pSDEUserRoleBase.getPSDEUserRoleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUserRoleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUserRoleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUserRoleData> selectByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase) throws Exception {
        return this.selectByPSSysOPPriv(pSSysOPPrivBase, "", -1);
    }

    public ArrayList<PSSysUserRoleData> selectByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase, String string) throws Exception {
        return this.selectByPSSysOPPriv(pSSysOPPrivBase, string, -1);
    }

    public ArrayList<PSSysUserRoleData> selectByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSOPPRIVID", (Object)pSSysOPPrivBase.getPSSysOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUserRoleData> selectTempByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase) throws Exception {
        return this.selectTempByPSSysOPPriv(pSSysOPPrivBase, "");
    }

    public ArrayList<PSSysUserRoleData> selectTempByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSOPPRIVID", (Object)pSSysOPPrivBase.getPSSysOPPrivId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysOPPrivCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUserRoleData> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUSERROLEDATA_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSUSERROLEDATA", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUserRoleData> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysUserRoleData pSSysUserRoleData : arrayList) {
            PSSysUserRoleData pSSysUserRoleData2 = (PSSysUserRoleData)this.getDEModel().createEntity();
            pSSysUserRoleData2.setPSSysUserRoleDataId(pSSysUserRoleData.getPSSysUserRoleDataId());
            pSSysUserRoleData2.setPSDEId(null);
            this.update(pSSysUserRoleData2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserRoleDataServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysUserRoleDataServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysUserRoleDataServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysUserRoleData> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysUserRoleData pSSysUserRoleData : arrayList) {
            this.remove(pSSysUserRoleData);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysUserRoleData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysUserRoleData> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
        ArrayList<PSSysUserRoleData> arrayList = this.selectByPSDEUserRole(pSDEUserRole, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUSERROLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUserRole);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUSERROLEDATA_PSDEUSERROLE_PSDEUSERROLEID", "", iDataEntityModel.getName(), "PSSYSUSERROLEDATA", iDataEntityModel.getDataInfo(pSDEUserRole), arrayList.get(0)));
        }
    }

    public void resetPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
        ArrayList<PSSysUserRoleData> arrayList = this.selectByPSDEUserRole(pSDEUserRole);
        for (PSSysUserRoleData pSSysUserRoleData : arrayList) {
            PSSysUserRoleData pSSysUserRoleData2 = (PSSysUserRoleData)this.getDEModel().createEntity();
            pSSysUserRoleData2.setPSSysUserRoleDataId(pSSysUserRoleData.getPSSysUserRoleDataId());
            pSSysUserRoleData2.setPSDEUserRoleId(null);
            this.update(pSSysUserRoleData2);
        }
    }

    public void removeByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
        final PSDEUserRole pSDEUserRole2 = pSDEUserRole;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserRoleDataServiceBase.this.onBeforeRemoveByPSDEUserRole(pSDEUserRole2);
                PSSysUserRoleDataServiceBase.this.internalRemoveByPSDEUserRole(pSDEUserRole2);
                PSSysUserRoleDataServiceBase.this.onAfterRemoveByPSDEUserRole(pSDEUserRole2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
    }

    protected void internalRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
        ArrayList<PSSysUserRoleData> arrayList = this.selectByPSDEUserRole(pSDEUserRole);
        this.onBeforeRemoveByPSDEUserRole(pSDEUserRole, arrayList);
        for (PSSysUserRoleData pSSysUserRoleData : arrayList) {
            this.remove(pSSysUserRoleData);
        }
        this.onAfterRemoveByPSDEUserRole(pSDEUserRole, arrayList);
    }

    protected void onAfterRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole, ArrayList<PSSysUserRoleData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole, ArrayList<PSSysUserRoleData> arrayList) throws Exception {
    }

    public void testRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    public void resetPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        ArrayList<PSSysUserRoleData> arrayList = this.selectByPSSysOPPriv(pSSysOPPriv);
        for (PSSysUserRoleData pSSysUserRoleData : arrayList) {
            PSSysUserRoleData pSSysUserRoleData2 = (PSSysUserRoleData)this.getDEModel().createEntity();
            pSSysUserRoleData2.setPSSysUserRoleDataId(pSSysUserRoleData.getPSSysUserRoleDataId());
            pSSysUserRoleData2.setPSSysOPPrivId(null);
            this.update(pSSysUserRoleData2);
        }
    }

    public void removeByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        final PSSysOPPriv pSSysOPPriv2 = pSSysOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserRoleDataServiceBase.this.onBeforeRemoveByPSSysOPPriv(pSSysOPPriv2);
                PSSysUserRoleDataServiceBase.this.internalRemoveByPSSysOPPriv(pSSysOPPriv2);
                PSSysUserRoleDataServiceBase.this.onAfterRemoveByPSSysOPPriv(pSSysOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    protected void internalRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        ArrayList<PSSysUserRoleData> arrayList = this.selectByPSSysOPPriv(pSSysOPPriv);
        this.onBeforeRemoveByPSSysOPPriv(pSSysOPPriv, arrayList);
        for (PSSysUserRoleData pSSysUserRoleData : arrayList) {
            this.remove(pSSysUserRoleData);
        }
        this.onAfterRemoveByPSSysOPPriv(pSSysOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv, ArrayList<PSSysUserRoleData> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv, ArrayList<PSSysUserRoleData> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysUserRoleData pSSysUserRoleData) throws Exception {
        super.onBeforeRemove(pSSysUserRoleData);
    }

    public void removeTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        final PSSysOPPriv pSSysOPPriv2 = pSSysOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserRoleDataServiceBase.this.onBeforeRemoveTempByPSSysOPPriv(pSSysOPPriv2);
                PSSysUserRoleDataServiceBase.this.internalRemoveTempByPSSysOPPriv(pSSysOPPriv2);
                PSSysUserRoleDataServiceBase.this.onAfterRemoveTempByPSSysOPPriv(pSSysOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    protected void internalRemoveTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        ArrayList<PSSysUserRoleData> arrayList = this.selectTempByPSSysOPPriv(pSSysOPPriv);
        this.onBeforeRemoveTempByPSSysOPPriv(pSSysOPPriv, arrayList);
        for (PSSysUserRoleData pSSysUserRoleData : arrayList) {
            this.removeTemp(pSSysUserRoleData);
        }
        this.onAfterRemoveTempByPSSysOPPriv(pSSysOPPriv, arrayList);
    }

    protected void onAfterRemoveTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv, ArrayList<PSSysUserRoleData> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv, ArrayList<PSSysUserRoleData> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysUserRoleData pSSysUserRoleData, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysUserRoleData, cloneSession);
        if (pSSysUserRoleData.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysUserRoleData.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysUserRoleData, (PSDataEntity)iEntity);
        }
        if (pSSysUserRoleData.getPSDEUserRoleId() != null && (iEntity = cloneSession.getEntity("PSDEUSERROLE", (Object)pSSysUserRoleData.getPSDEUserRoleId())) != null) {
            this.onFillParentInfo_PSDEUserRole(pSSysUserRoleData, (PSDEUserRole)iEntity);
        }
        if (pSSysUserRoleData.getPSSysOPPrivId() != null && (iEntity = cloneSession.getEntity("PSSYSOPPRIV", (Object)pSSysUserRoleData.getPSSysOPPrivId())) != null) {
            this.onFillParentInfo_PSSysOPPriv(pSSysUserRoleData, (PSSysOPPriv)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysUserRoleData pSSysUserRoleData, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysUserRoleData, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysUserRoleData, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUserRoleId(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysOPPrivId(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserRoleDataId(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserRoleDataName(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysUserRoleData, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysUserRoleData, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isMemoDirty() : !pSSysUserRoleData.isMemoDirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isPSDEIdDirty() && !bl2 : !pSSysUserRoleData.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isPSDENameDirty() : !pSSysUserRoleData.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUserRoleId(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isPSDEUserRoleIdDirty() && !bl2 : !pSSysUserRoleData.isPSDEUserRoleIdDirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getPSDEUserRoleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUSERROLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUserRoleId_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUSERROLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSOPPRIVID";
                String string4 = this.checkFieldDupRule(this.getPSSysUserRoleDataDEModel(), "PSDEUSERROLEID", string3, pSSysUserRoleData, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEUSERROLEID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysOPPrivId(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isPSSysOPPrivIdDirty() && !bl2 : !pSSysUserRoleData.isPSSysOPPrivIdDirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getPSSysOPPrivId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOPPRIVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysOPPrivId_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserRoleDataId(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isPSSysUserRoleDataIdDirty() && !bl2 : !pSSysUserRoleData.isPSSysUserRoleDataIdDirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getPSSysUserRoleDataId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERROLEDATAID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserRoleDataId_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERROLEDATAID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserRoleDataName(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isPSSysUserRoleDataNameDirty() && !bl2 : !pSSysUserRoleData.isPSSysUserRoleDataNameDirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getPSSysUserRoleDataName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERROLEDATANAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserRoleDataName_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERROLEDATANAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isUserCatDirty() : !pSSysUserRoleData.isUserCatDirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isUserTagDirty() : !pSSysUserRoleData.isUserTagDirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isUserTag2Dirty() : !pSSysUserRoleData.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isUserTag3Dirty() : !pSSysUserRoleData.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isUserTag4Dirty() : !pSSysUserRoleData.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysUserRoleData.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysUserRoleData pSSysUserRoleData, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleData.isValidFlagDirty() && !bl2 : !pSSysUserRoleData.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysUserRoleData.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSSysUserRoleData, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysUserRoleData pSSysUserRoleData, boolean bl) throws Exception {
        super.onSyncEntity(pSSysUserRoleData, bl);
    }

    protected void onSyncIndexEntities(PSSysUserRoleData pSSysUserRoleData, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysUserRoleData, bl);
    }

    public Object getDataContextValue(PSSysUserRoleData pSSysUserRoleData, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysUserRoleData, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysOPPriv pSSysOPPriv = pSSysUserRoleData.getPSSysOPPriv();
        if (pSSysOPPriv != null && pSSysOPPriv.contains(string)) {
            return pSSysOPPriv.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysUserRoleData pSSysUserRoleData, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysUserRoleData, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUSERROLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUserRoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUSERROLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUserRoleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERROLEDATAID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserRoleDataId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERROLEDATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserRoleDataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUserRoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUSERROLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUserRoleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUSERROLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserRoleDataId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERROLEDATAID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserRoleDataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERROLEDATANAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysUserRoleData pSSysUserRoleData) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysUserRoleData)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysUserRoleData pSSysUserRoleData) throws Exception {
        super.onUpdateParent(pSSysUserRoleData);
    }

    @Override
    protected void exportCurXmlModel(PSSysUserRoleData pSSysUserRoleData, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSUSERROLEDATA");
        if (!bl) {
            pSSysUserRoleData.setCreateDate(null);
            pSSysUserRoleData.setCreateMan(null);
            pSSysUserRoleData.setPSSysUserRoleDataId(null);
            pSSysUserRoleData.setUpdateDate(null);
            pSSysUserRoleData.setUpdateMan(null);
            pSSysUserRoleData.setPSSysOPPrivId(null);
            super.exportCurXmlModel(pSSysUserRoleData, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysUserRoleData pSSysUserRoleData, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysUserRoleData, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSOPPRIV#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUSERROLEDATA_PSSYSOPPRIV_PSSYSOPPRIVID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIV", (boolean)true) == 0) {
            iEntity.set("PSSYSOPPRIVID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSOPPRIVID"};
    }

    @Override
    public String getModelV2Tag(PSSysUserRoleData pSSysUserRoleData) {
        return super.getModelV2Tag(pSSysUserRoleData);
    }

    @Override
    public boolean setModelV2Tag(PSSysUserRoleData pSSysUserRoleData, String string) {
        return super.setModelV2Tag(pSSysUserRoleData, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSOPPRIVID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysUserRoleData pSSysUserRoleData, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysUserRoleData.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysUserRoleData, true);
        return super.getModelV2Entity(pSSysUserRoleData, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysUserRoleData pSSysUserRoleData, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysUserRoleData, objectNode, string, string2, n);
    }
}

