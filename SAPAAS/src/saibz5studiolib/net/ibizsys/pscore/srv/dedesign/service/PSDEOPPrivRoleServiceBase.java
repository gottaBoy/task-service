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
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEOPPrivRoleDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEOPPrivRoleDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRoleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPriv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPrivBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEOPPrivRoleServiceBase
extends PSCoreSysServiceBase<PSDEOPPrivRole> {
    private static final Log log = LogFactory.getLog(PSDEOPPrivRoleServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEOPPrivRoleDEModel pSDEOPPrivRoleDEModel;
    private PSDEOPPrivRoleDAO pSDEOPPrivRoleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleService";
    }

    public PSDEOPPrivRoleDEModel getPSDEOPPrivRoleDEModel() {
        if (this.pSDEOPPrivRoleDEModel == null) {
            try {
                this.pSDEOPPrivRoleDEModel = (PSDEOPPrivRoleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEOPPrivRoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEOPPrivRoleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEOPPrivRoleDEModel();
    }

    public PSDEOPPrivRoleDAO getPSDEOPPrivRoleDAO() {
        if (this.pSDEOPPrivRoleDAO == null) {
            try {
                this.pSDEOPPrivRoleDAO = (PSDEOPPrivRoleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEOPPrivRoleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEOPPrivRoleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEOPPrivRoleDAO();
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

    protected void onFillParentInfo(PSDEOPPrivRole pSDEOPPrivRole, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIVROLE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEOPPrivRole, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIVROLE_PSDEDATAQUERY_PSDEDQID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService", (SessionFactory)this.getSessionFactory());
            PSDEDataQuery pSDEDataQuery = (PSDEDataQuery)iService.getDEModel().createEntity();
            pSDEDataQuery.set("PSDEDATAQUERYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataQuery);
            } else {
                iService.get((IEntity)pSDEDataQuery);
            }
            this.onFillParentInfo_PSDEDQ(pSDEOPPrivRole, pSDEDataQuery);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIVROLE_PSDEOPPRIV_PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEOPPriv);
            } else {
                iService.get((IEntity)pSDEOPPriv);
            }
            this.onFillParentInfo_PSDEOPPriv(pSDEOPPrivRole, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService", (SessionFactory)this.getSessionFactory());
            PSDEUserRole pSDEUserRole = (PSDEUserRole)iService.getDEModel().createEntity();
            pSDEUserRole.set("PSDEUSERROLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUserRole);
            } else {
                iService.get((IEntity)pSDEUserRole);
            }
            this.onFillParentInfo_PSDEUserRole(pSDEOPPrivRole, pSDEUserRole);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEOPPRIVROLE_PSSYSOPPRIV_PSSYSOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService", (SessionFactory)this.getSessionFactory());
            PSSysOPPriv pSSysOPPriv = (PSSysOPPriv)iService.getDEModel().createEntity();
            pSSysOPPriv.set("PSSYSOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysOPPriv);
            } else {
                iService.get((IEntity)pSSysOPPriv);
            }
            this.onFillParentInfo_PSSysOPPriv(pSDEOPPrivRole, pSSysOPPriv);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEOPPrivRole, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEOPPrivRole pSDEOPPrivRole, PSDataEntity pSDataEntity) throws Exception {
        pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDQ(PSDEOPPrivRole pSDEOPPrivRole, PSDEDataQuery pSDEDataQuery) throws Exception {
        pSDEOPPrivRole.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
        pSDEOPPrivRole.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
    }

    protected void onFillParentInfo_PSDEOPPriv(PSDEOPPrivRole pSDEOPPrivRole, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
        if (pSDEOPPriv.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEOPPrivRole, pSDEOPPriv.getPSDE());
        }
    }

    protected void onFillParentInfo_PSDEUserRole(PSDEOPPrivRole pSDEOPPrivRole, PSDEUserRole pSDEUserRole) throws Exception {
        pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
        pSDEOPPrivRole.setPSDEUserRoleName(pSDEUserRole.getPSDEUserRoleName());
        if (pSDEUserRole.getPSDE() != null) {
            this.onFillParentInfo_PSDE(pSDEOPPrivRole, pSDEUserRole.getPSDE());
        }
    }

    protected void onFillParentInfo_PSSysOPPriv(PSDEOPPrivRole pSDEOPPrivRole, PSSysOPPriv pSSysOPPriv) throws Exception {
        pSDEOPPrivRole.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
        pSDEOPPrivRole.setPSSysOPPrivName(pSSysOPPriv.getPSSysOPPrivName());
    }

    protected void onFillEntityFullInfo(PSDEOPPrivRole pSDEOPPrivRole, boolean bl) throws Exception {
        if (bl) {
            if (pSDEOPPrivRole.getDynaModelFlag() == null) {
                pSDEOPPrivRole.setDynaModelFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEOPPrivRole.getRoleType() == null) {
                pSDEOPPrivRole.setRoleType((String)this.getDefaultValue(this.getWebContext(), "", "DEROLE", 25));
            }
            if (pSDEOPPrivRole.getValidFlag() == null) {
                pSDEOPPrivRole.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEOPPrivRole, bl);
        this.onFillEntityFullInfo_PSDE(pSDEOPPrivRole, bl);
        this.onFillEntityFullInfo_PSDEDQ(pSDEOPPrivRole, bl);
        this.onFillEntityFullInfo_PSDEOPPriv(pSDEOPPrivRole, bl);
        this.onFillEntityFullInfo_PSDEUserRole(pSDEOPPrivRole, bl);
        this.onFillEntityFullInfo_PSSysOPPriv(pSDEOPPrivRole, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEOPPrivRole pSDEOPPrivRole, boolean bl) throws Exception {
        if (pSDEOPPrivRole.isPSDEIdDirty()) {
            if (pSDEOPPrivRole.getPSDEId() != null) {
                if (pSDEOPPrivRole.getPSDEId() == null || pSDEOPPrivRole.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEOPPrivRole.getPSDE();
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEOPPrivRole.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDQ(PSDEOPPrivRole pSDEOPPrivRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEOPPriv(PSDEOPPrivRole pSDEOPPrivRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUserRole(PSDEOPPrivRole pSDEOPPrivRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysOPPriv(PSDEOPPrivRole pSDEOPPrivRole, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEOPPrivRole pSDEOPPrivRole, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEOPPrivRole, bl);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEOPPrivRole> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, "", -1);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string) throws Exception {
        return this.selectByPSDEDQ(pSDEDataQueryBase, string, -1);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDEDQ(PSDEDataQueryBase pSDEDataQueryBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDQID", (Object)pSDEDataQueryBase.getPSDEDataQueryId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDQCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDQCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDEUserRole(PSDEUserRoleBase pSDEUserRoleBase) throws Exception {
        return this.selectByPSDEUserRole(pSDEUserRoleBase, "", -1);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDEUserRole(PSDEUserRoleBase pSDEUserRoleBase, String string) throws Exception {
        return this.selectByPSDEUserRole(pSDEUserRoleBase, string, -1);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSDEUserRole(PSDEUserRoleBase pSDEUserRoleBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEOPPrivRole> selectTempByPSDEUserRole(PSDEUserRoleBase pSDEUserRoleBase) throws Exception {
        return this.selectTempByPSDEUserRole(pSDEUserRoleBase, "");
    }

    public ArrayList<PSDEOPPrivRole> selectTempByPSDEUserRole(PSDEUserRoleBase pSDEUserRoleBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUSERROLEID", (Object)pSDEUserRoleBase.getPSDEUserRoleId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEUserRoleCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEUserRoleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEOPPrivRole> selectByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase) throws Exception {
        return this.selectByPSSysOPPriv(pSSysOPPrivBase, "", -1);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase, String string) throws Exception {
        return this.selectByPSSysOPPriv(pSSysOPPrivBase, string, -1);
    }

    public ArrayList<PSDEOPPrivRole> selectByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            PSDEOPPrivRole pSDEOPPrivRole2 = (PSDEOPPrivRole)this.getDEModel().createEntity();
            pSDEOPPrivRole2.setPSDEOPPrivRoleId(pSDEOPPrivRole.getPSDEOPPrivRoleId());
            pSDEOPPrivRole2.setPSDEId(null);
            this.update(pSDEOPPrivRole2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivRoleServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEOPPrivRoleServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEOPPrivRoleServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            this.remove((IEntity)pSDEOPPrivRole);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSDEDQ(pSDEDataQuery, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAQUERY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataQuery);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEOPPRIVROLE_PSDEDATAQUERY_PSDEDQID", "", iDataEntityModel.getName(), "PSDEOPPRIVROLE", iDataEntityModel.getDataInfo((IEntity)pSDEDataQuery), arrayList.get(0)));
        }
    }

    public void resetPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            PSDEOPPrivRole pSDEOPPrivRole2 = (PSDEOPPrivRole)this.getDEModel().createEntity();
            pSDEOPPrivRole2.setPSDEOPPrivRoleId(pSDEOPPrivRole.getPSDEOPPrivRoleId());
            pSDEOPPrivRole2.setPSDEDQId(null);
            this.update(pSDEOPPrivRole2);
        }
    }

    public void removeByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivRoleServiceBase.this.onBeforeRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEOPPrivRoleServiceBase.this.internalRemoveByPSDEDQ(pSDEDataQuery2);
                PSDEOPPrivRoleServiceBase.this.onAfterRemoveByPSDEDQ(pSDEDataQuery2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void internalRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSDEDQ(pSDEDataQuery);
        this.onBeforeRemoveByPSDEDQ(pSDEDataQuery, arrayList);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            this.remove((IEntity)pSDEOPPrivRole);
        }
        this.onAfterRemoveByPSDEDQ(pSDEDataQuery, arrayList);
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    public void testRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEOPPRIVROLE_PSDEOPPRIV_PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEOPPRIVROLE", iDataEntityModel.getDataInfo((IEntity)pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            PSDEOPPrivRole pSDEOPPrivRole2 = (PSDEOPPrivRole)this.getDEModel().createEntity();
            pSDEOPPrivRole2.setPSDEOPPrivRoleId(pSDEOPPrivRole.getPSDEOPPrivRoleId());
            pSDEOPPrivRole2.setPSDEOPPrivId(null);
            this.update(pSDEOPPrivRole2);
        }
    }

    public void removeByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivRoleServiceBase.this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEOPPrivRoleServiceBase.this.internalRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEOPPrivRoleServiceBase.this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            this.remove((IEntity)pSDEOPPrivRole);
        }
        this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
    }

    public void resetPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSDEUserRole(pSDEUserRole);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            PSDEOPPrivRole pSDEOPPrivRole2 = (PSDEOPPrivRole)this.getDEModel().createEntity();
            pSDEOPPrivRole2.setPSDEOPPrivRoleId(pSDEOPPrivRole.getPSDEOPPrivRoleId());
            pSDEOPPrivRole2.setPSDEUserRoleId(null);
            this.update(pSDEOPPrivRole2);
        }
    }

    public void removeByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
        final PSDEUserRole pSDEUserRole2 = pSDEUserRole;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivRoleServiceBase.this.onBeforeRemoveByPSDEUserRole(pSDEUserRole2);
                PSDEOPPrivRoleServiceBase.this.internalRemoveByPSDEUserRole(pSDEUserRole2);
                PSDEOPPrivRoleServiceBase.this.onAfterRemoveByPSDEUserRole(pSDEUserRole2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
    }

    protected void internalRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSDEUserRole(pSDEUserRole);
        this.onBeforeRemoveByPSDEUserRole(pSDEUserRole, arrayList);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            this.remove((IEntity)pSDEOPPrivRole);
        }
        this.onAfterRemoveByPSDEUserRole(pSDEUserRole, arrayList);
    }

    protected void onAfterRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUserRole(PSDEUserRole pSDEUserRole, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    public void testRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSSysOPPriv(pSSysOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEOPPRIVROLE_PSSYSOPPRIV_PSSYSOPPRIVID", "", iDataEntityModel.getName(), "PSDEOPPRIVROLE", iDataEntityModel.getDataInfo((IEntity)pSSysOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSSysOPPriv(pSSysOPPriv);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            PSDEOPPrivRole pSDEOPPrivRole2 = (PSDEOPPrivRole)this.getDEModel().createEntity();
            pSDEOPPrivRole2.setPSDEOPPrivRoleId(pSDEOPPrivRole.getPSDEOPPrivRoleId());
            pSDEOPPrivRole2.setPSSysOPPrivId(null);
            this.update(pSDEOPPrivRole2);
        }
    }

    public void removeByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        final PSSysOPPriv pSSysOPPriv2 = pSSysOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivRoleServiceBase.this.onBeforeRemoveByPSSysOPPriv(pSSysOPPriv2);
                PSDEOPPrivRoleServiceBase.this.internalRemoveByPSSysOPPriv(pSSysOPPriv2);
                PSDEOPPrivRoleServiceBase.this.onAfterRemoveByPSSysOPPriv(pSSysOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    protected void internalRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectByPSSysOPPriv(pSSysOPPriv);
        this.onBeforeRemoveByPSSysOPPriv(pSSysOPPriv, arrayList);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            this.remove((IEntity)pSDEOPPrivRole);
        }
        this.onAfterRemoveByPSSysOPPriv(pSSysOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEOPPrivRole pSDEOPPrivRole) throws Exception {
        super.onBeforeRemove(pSDEOPPrivRole);
    }

    public void removeTempByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
        final PSDEUserRole pSDEUserRole2 = pSDEUserRole;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEOPPrivRoleServiceBase.this.onBeforeRemoveTempByPSDEUserRole(pSDEUserRole2);
                PSDEOPPrivRoleServiceBase.this.internalRemoveTempByPSDEUserRole(pSDEUserRole2);
                PSDEOPPrivRoleServiceBase.this.onAfterRemoveTempByPSDEUserRole(pSDEUserRole2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
    }

    protected void internalRemoveTempByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
        ArrayList<PSDEOPPrivRole> arrayList = this.selectTempByPSDEUserRole(pSDEUserRole);
        this.onBeforeRemoveTempByPSDEUserRole(pSDEUserRole, arrayList);
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            this.removeTemp((IEntity)pSDEOPPrivRole);
        }
        this.onAfterRemoveTempByPSDEUserRole(pSDEUserRole, arrayList);
    }

    protected void onAfterRemoveTempByPSDEUserRole(PSDEUserRole pSDEUserRole) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEUserRole(PSDEUserRole pSDEUserRole, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEUserRole(PSDEUserRole pSDEUserRole, ArrayList<PSDEOPPrivRole> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEOPPrivRole pSDEOPPrivRole, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEOPPrivRole, cloneSession);
        if (pSDEOPPrivRole.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEOPPrivRole.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEOPPrivRole, (PSDataEntity)iEntity);
        }
        if (pSDEOPPrivRole.getPSDEDQId() != null && (iEntity = cloneSession.getEntity("PSDEDATAQUERY", (Object)pSDEOPPrivRole.getPSDEDQId())) != null) {
            this.onFillParentInfo_PSDEDQ(pSDEOPPrivRole, (PSDEDataQuery)iEntity);
        }
        if (pSDEOPPrivRole.getPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEOPPrivRole.getPSDEOPPrivId())) != null) {
            this.onFillParentInfo_PSDEOPPriv(pSDEOPPrivRole, (PSDEOPPriv)iEntity);
        }
        if (pSDEOPPrivRole.getPSDEUserRoleId() != null && (iEntity = cloneSession.getEntity("PSDEUSERROLE", (Object)pSDEOPPrivRole.getPSDEUserRoleId())) != null) {
            this.onFillParentInfo_PSDEUserRole(pSDEOPPrivRole, (PSDEUserRole)iEntity);
        }
        if (pSDEOPPrivRole.getPSSysOPPrivId() != null && (iEntity = cloneSession.getEntity("PSSYSOPPRIV", (Object)pSDEOPPrivRole.getPSSysOPPrivId())) != null) {
            this.onFillParentInfo_PSSysOPPriv(pSDEOPPrivRole, (PSSysOPPriv)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEOPPrivRole pSDEOPPrivRole, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEOPPrivRole, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CustomCond(bl, pSDEOPPrivRole, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FilterModel(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDQId(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivRoleId(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivRoleName(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUserRoleId(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysOPPrivId(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RoleType(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEOPPrivRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEOPPrivRole, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isCustomCondDirty() : !pSDEOPPrivRole.isCustomCondDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isCustomTypeDirty() : !pSDEOPPrivRole.isCustomTypeDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isDynaModelFlagDirty() : !pSDEOPPrivRole.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEOPPrivRole.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FilterModel(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isFilterModelDirty() : !pSDEOPPrivRole.isFilterModelDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getFilterModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FilterModel_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILTERMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isLockFlagDirty() : !pSDEOPPrivRole.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEOPPrivRole.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isMemoDirty() : !pSDEOPPrivRole.isMemoDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDQId(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isPSDEDQIdDirty() : !pSDEOPPrivRole.isPSDEDQIdDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getPSDEDQId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDQId_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDQID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isPSDEIdDirty() && !bl2 : !pSDEOPPrivRole.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isPSDENameDirty() && !bl2 : !pSDEOPPrivRole.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isPSDEOPPrivIdDirty() && !bl2 : !pSDEOPPrivRole.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getPSDEOPPrivId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEOPPrivRoleId(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isPSDEOPPrivRoleIdDirty() && !bl2 : !pSDEOPPrivRole.isPSDEOPPrivRoleIdDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getPSDEOPPrivRoleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVROLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivRoleId_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVROLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEOPPrivRoleName(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isPSDEOPPrivRoleNameDirty() && !bl2 : !pSDEOPPrivRole.isPSDEOPPrivRoleNameDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getPSDEOPPrivRoleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVROLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivRoleName_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVROLENAME");
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
                string3 = "PSDEUSERROLEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSOPPRIVID";
                String string4 = this.checkFieldDupRule(this.getPSDEOPPrivRoleDEModel(), "PSDEOPPRIVROLENAME", string3, pSDEOPPrivRole, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEOPPRIVROLENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUserRoleId(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isPSDEUserRoleIdDirty() : !pSDEOPPrivRole.isPSDEUserRoleIdDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getPSDEUserRoleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUserRoleId_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUSERROLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isPSDynaInstIdDirty() : !pSDEOPPrivRole.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysOPPrivId(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isPSSysOPPrivIdDirty() : !pSDEOPPrivRole.isPSSysOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getPSSysOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysOPPrivId_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_RoleType(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isRoleTypeDirty() && !bl2 : !pSDEOPPrivRole.isRoleTypeDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getRoleType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROLETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_RoleType_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROLETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isUserCatDirty() : !pSDEOPPrivRole.isUserCatDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isUserTagDirty() : !pSDEOPPrivRole.isUserTagDirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isUserTag2Dirty() : !pSDEOPPrivRole.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isUserTag3Dirty() : !pSDEOPPrivRole.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isUserTag4Dirty() : !pSDEOPPrivRole.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEOPPrivRole.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEOPPrivRole pSDEOPPrivRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEOPPrivRole.isValidFlagDirty() && !bl2 : !pSDEOPPrivRole.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEOPPrivRole.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEOPPrivRole, bl2, bl3);
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

    protected void onSyncEntity(PSDEOPPrivRole pSDEOPPrivRole, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEOPPrivRole, bl);
    }

    protected void onSyncIndexEntities(PSDEOPPrivRole pSDEOPPrivRole, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEOPPrivRole, bl);
    }

    public Object getDataContextValue(PSDEOPPrivRole pSDEOPPrivRole, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEOPPrivRole, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEOPPrivRole.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEOPPrivRole pSDEOPPrivRole, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEOPPrivRole, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILTERMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilterModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDQNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDQName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVROLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivRoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVROLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivRoleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUSERROLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUserRoleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUSERROLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUserRoleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROLETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RoleType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CustomCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCOND", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FilterModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILTERMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDEDQId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDQName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDQNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivRoleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVROLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivRoleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVROLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_RoleType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROLETYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected boolean onMergeChild(String string, String string2, PSDEOPPrivRole pSDEOPPrivRole) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEOPPrivRole)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEOPPrivRole pSDEOPPrivRole) throws Exception {
        Object object = pSDEOPPrivRole.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEOPPRIVROLE_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEOPPrivRole);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEOPPrivRole pSDEOPPrivRole, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEOPPRIVROLE");
        if (!bl) {
            pSDEOPPrivRole.setCreateDate(null);
            pSDEOPPrivRole.setCreateMan(null);
            pSDEOPPrivRole.setPSDEOPPrivName(null);
            pSDEOPPrivRole.setPSDEOPPrivRoleId(null);
            pSDEOPPrivRole.setUpdateDate(null);
            pSDEOPPrivRole.setUpdateMan(null);
            pSDEOPPrivRole.setPSDEUserRoleId(null);
            super.exportCurXmlModel(pSDEOPPrivRole, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEOPPrivRole pSDEOPPrivRole, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEOPPrivRole, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEUSERROLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEUSERROLE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSOPPRIV#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEUSERROLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEOPPRIVROLE_PSSYSOPPRIV_PSSYSOPPRIVID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEOPPRIVROLE_PSDATAENTITY_PSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEUSERROLEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEUSERROLENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEUSERROLE", (boolean)true) == 0) {
            iEntity.set("PSDEUSERROLEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIV", (boolean)true) == 0) {
            iEntity.set("PSSYSOPPRIVID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEUSERROLEID", "PSSYSOPPRIVID", "PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEOPPrivRole pSDEOPPrivRole) {
        if (!StringHelper.isNullOrEmpty((String)pSDEOPPrivRole.getPSDEOPPrivRoleName())) {
            return pSDEOPPrivRole.getPSDEOPPrivRoleName();
        }
        return super.getModelV2Tag(pSDEOPPrivRole);
    }

    @Override
    public boolean setModelV2Tag(PSDEOPPrivRole pSDEOPPrivRole, String string) {
        pSDEOPPrivRole.setPSDEOPPrivRoleName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEOPPRIVROLENAME", "");
        map.put("PSDEUSERROLEID", "");
        map.put("PSSYSOPPRIVID", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEOPPrivRole pSDEOPPrivRole, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEOPPrivRole.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEOPPrivRole, true);
        pSDEOPPrivRole.set("PSDEOPPRIVROLENAME", string);
        if (this.select(pSDEOPPrivRole, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEOPPrivRole, true);
        return super.getModelV2Entity(pSDEOPPrivRole, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEOPPrivRole pSDEOPPrivRole, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEOPPrivRole, objectNode, string, string2, n);
    }
}

