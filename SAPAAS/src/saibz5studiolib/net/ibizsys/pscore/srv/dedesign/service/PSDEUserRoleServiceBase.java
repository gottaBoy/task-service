/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.db.SqlParamList
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
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.db.SqlParamList;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEUserRoleDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEUserRoleDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDR;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserDRBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleDataService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleDataServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUserRoleServiceBase
extends PSCoreSysServiceBase<PSDEUserRole> {
    private static final Log log = LogFactory.getLog(PSDEUserRoleServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEUserRoleDEModel pSDEUserRoleDEModel;
    private PSDEUserRoleDAO pSDEUserRoleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService";
    }

    public PSDEUserRoleDEModel getPSDEUserRoleDEModel() {
        if (this.pSDEUserRoleDEModel == null) {
            try {
                this.pSDEUserRoleDEModel = (PSDEUserRoleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUserRoleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUserRoleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEUserRoleDEModel();
    }

    public PSDEUserRoleDAO getPSDEUserRoleDAO() {
        if (this.pSDEUserRoleDAO == null) {
            try {
                this.pSDEUserRoleDAO = (PSDEUserRoleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEUserRoleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUserRoleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEUserRoleDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEUserRole pSDEUserRole, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUSERROLE_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEUserRole, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUSERROLE_PSDEDATASET_PSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDS(pSDEUserRole, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUSERROLE_PSDEFGROUP_PSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFGroup);
            } else {
                iService.get((IEntity)pSDEFGroup);
            }
            this.onFillParentInfo_PSDEFGroup(pSDEUserRole, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUSERROLE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysSFPlugin pSSysSFPlugin = (PSSysSFPlugin)iService.getDEModel().createEntity();
            pSSysSFPlugin.set("PSSYSSFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSFPlugin);
            } else {
                iService.get((IEntity)pSSysSFPlugin);
            }
            this.onFillParentInfo_PSSysSFPlugin(pSDEUserRole, pSSysSFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUSERROLE_PSSYSUSERDR_PSSYSUSERDRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService", (SessionFactory)this.getSessionFactory());
            PSSysUserDR pSSysUserDR = (PSSysUserDR)iService.getDEModel().createEntity();
            pSSysUserDR.set("PSSYSUSERDRID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUserDR);
            } else {
                iService.get((IEntity)pSSysUserDR);
            }
            this.onFillParentInfo_PSSysUserDR(pSDEUserRole, pSSysUserDR);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUSERROLE_PSSYSUSERDR_PSSYSUSERDRID2", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUserDRService", (SessionFactory)this.getSessionFactory());
            PSSysUserDR pSSysUserDR = (PSSysUserDR)iService.getDEModel().createEntity();
            pSSysUserDR.set("PSSYSUSERDRID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUserDR);
            } else {
                iService.get((IEntity)pSSysUserDR);
            }
            this.onFillParentInfo_PSSysUserDR2(pSDEUserRole, pSSysUserDR);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEUserRole, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEUserRole pSDEUserRole, PSDataEntity pSDataEntity) throws Exception {
        pSDEUserRole.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEUserRole.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEDS(PSDEUserRole pSDEUserRole, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEUserRole.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDEUserRole.setPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEFGroup(PSDEUserRole pSDEUserRole, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEUserRole.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEUserRole.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_PSSysSFPlugin(PSDEUserRole pSDEUserRole, PSSysSFPlugin pSSysSFPlugin) throws Exception {
        pSDEUserRole.setPSSysSFPluginId(pSSysSFPlugin.getPSSysSFPluginId());
        pSDEUserRole.setPSSysSFPluginName(pSSysSFPlugin.getPSSysSFPluginName());
    }

    protected void onFillParentInfo_PSSysUserDR(PSDEUserRole pSDEUserRole, PSSysUserDR pSSysUserDR) throws Exception {
        pSDEUserRole.setPSSysUserDRId(pSSysUserDR.getPSSysUserDRId());
        pSDEUserRole.setPSSysUserDRName(pSSysUserDR.getPSSysUserDRName());
    }

    protected void onFillParentInfo_PSSysUserDR2(PSDEUserRole pSDEUserRole, PSSysUserDR pSSysUserDR) throws Exception {
        pSDEUserRole.setPSSysUserDRId2(pSSysUserDR.getPSSysUserDRId());
        pSDEUserRole.setPSSysUserDRName2(pSSysUserDR.getPSSysUserDRName());
    }

    protected void onFillEntityFullInfo(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
        if (bl) {
            if (pSDEUserRole.getDefaultFlag() == null) {
                pSDEUserRole.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEUserRole.getPSDEUserRoleName() == null) {
                pSDEUserRole.setPSDEUserRoleName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u64cd\u4f5c\u89d2\u8272", 25));
            }
            if (pSDEUserRole.getSystemFlag() == null) {
                pSDEUserRole.setSystemFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEUserRole.getValidFlag() == null) {
                pSDEUserRole.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEUserRole, bl);
        this.onFillEntityFullInfo_PSDE(pSDEUserRole, bl);
        this.onFillEntityFullInfo_PSDEDS(pSDEUserRole, bl);
        this.onFillEntityFullInfo_PSDEFGroup(pSDEUserRole, bl);
        this.onFillEntityFullInfo_PSSysSFPlugin(pSDEUserRole, bl);
        this.onFillEntityFullInfo_PSSysUserDR(pSDEUserRole, bl);
        this.onFillEntityFullInfo_PSSysUserDR2(pSDEUserRole, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
        if (pSDEUserRole.isPSDEIdDirty()) {
            if (pSDEUserRole.getPSDEId() != null) {
                if (pSDEUserRole.getPSDEId() == null || pSDEUserRole.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEUserRole.getPSDE();
                    pSDEUserRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEUserRole.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDS(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFGroup(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSFPlugin(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUserDR(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUserDR2(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEUserRole, bl);
    }

    public ArrayList<PSDEUserRole> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUserRole> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUserRole> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEUserRole> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEUserRole> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEUserRole> selectByPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUserRole> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEUserRole> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEUserRole> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUserRole> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, "", -1);
    }

    public ArrayList<PSDEUserRole> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string) throws Exception {
        return this.selectByPSSysSFPlugin(pSSysSFPluginBase, string, -1);
    }

    public ArrayList<PSDEUserRole> selectByPSSysSFPlugin(PSSysSFPluginBase pSSysSFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSFPLUGINID", (Object)pSSysSFPluginBase.getPSSysSFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUserRole> selectByPSSysUserDR(PSSysUserDRBase pSSysUserDRBase) throws Exception {
        return this.selectByPSSysUserDR(pSSysUserDRBase, "", -1);
    }

    public ArrayList<PSDEUserRole> selectByPSSysUserDR(PSSysUserDRBase pSSysUserDRBase, String string) throws Exception {
        return this.selectByPSSysUserDR(pSSysUserDRBase, string, -1);
    }

    public ArrayList<PSDEUserRole> selectByPSSysUserDR(PSSysUserDRBase pSSysUserDRBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERDRID", (Object)pSSysUserDRBase.getPSSysUserDRId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserDRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserDRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUserRole> selectByPSSysUserDR2(PSSysUserDRBase pSSysUserDRBase) throws Exception {
        return this.selectByPSSysUserDR2(pSSysUserDRBase, "", -1);
    }

    public ArrayList<PSDEUserRole> selectByPSSysUserDR2(PSSysUserDRBase pSSysUserDRBase, String string) throws Exception {
        return this.selectByPSSysUserDR2(pSSysUserDRBase, string, -1);
    }

    public ArrayList<PSDEUserRole> selectByPSSysUserDR2(PSSysUserDRBase pSSysUserDRBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUSERDRID2", (Object)pSSysUserDRBase.getPSSysUserDRId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUserDR2Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUserDR2Cond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            PSDEUserRole pSDEUserRole2 = (PSDEUserRole)this.getDEModel().createEntity();
            pSDEUserRole2.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
            pSDEUserRole2.setPSDEId(null);
            this.update(pSDEUserRole2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUserRoleServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEUserRoleServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEUserRoleServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            this.remove((IEntity)pSDEUserRole);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUSERROLE_PSDEDATASET_PSDEDSID", "", iDataEntityModel.getName(), "PSDEUSERROLE", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSDEDS(pSDEDataSet);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            PSDEUserRole pSDEUserRole2 = (PSDEUserRole)this.getDEModel().createEntity();
            pSDEUserRole2.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
            pSDEUserRole2.setPSDEDSId(null);
            this.update(pSDEUserRole2);
        }
    }

    public void removeByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUserRoleServiceBase.this.onBeforeRemoveByPSDEDS(pSDEDataSet2);
                PSDEUserRoleServiceBase.this.internalRemoveByPSDEDS(pSDEDataSet2);
                PSDEUserRoleServiceBase.this.onAfterRemoveByPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByPSDEDS(pSDEDataSet, arrayList);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            this.remove((IEntity)pSDEUserRole);
        }
        this.onAfterRemoveByPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUSERROLE_PSDEFGROUP_PSDEFGROUPID", "", iDataEntityModel.getName(), "PSDEUSERROLE", iDataEntityModel.getDataInfo((IEntity)pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            PSDEUserRole pSDEUserRole2 = (PSDEUserRole)this.getDEModel().createEntity();
            pSDEUserRole2.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
            pSDEUserRole2.setPSDEFGroupId(null);
            this.update(pSDEUserRole2);
        }
    }

    public void removeByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUserRoleServiceBase.this.onBeforeRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEUserRoleServiceBase.this.internalRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEUserRoleServiceBase.this.onAfterRemoveByPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            this.remove((IEntity)pSDEUserRole);
        }
        this.onAfterRemoveByPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUSERROLE_PSSYSSFPLUGIN_PSSYSSFPLUGINID", "", iDataEntityModel.getName(), "PSDEUSERROLE", iDataEntityModel.getDataInfo((IEntity)pSSysSFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            PSDEUserRole pSDEUserRole2 = (PSDEUserRole)this.getDEModel().createEntity();
            pSDEUserRole2.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
            pSDEUserRole2.setPSSysSFPluginId(null);
            this.update(pSDEUserRole2);
        }
    }

    public void removeByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        final PSSysSFPlugin pSSysSFPlugin2 = pSSysSFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUserRoleServiceBase.this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEUserRoleServiceBase.this.internalRemoveByPSSysSFPlugin(pSSysSFPlugin2);
                PSDEUserRoleServiceBase.this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSSysSFPlugin(pSSysSFPlugin);
        this.onBeforeRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            this.remove((IEntity)pSDEUserRole);
        }
        this.onAfterRemoveByPSSysSFPlugin(pSSysSFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSFPlugin(PSSysSFPlugin pSSysSFPlugin, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSSysUserDR(pSSysUserDR, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERDR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUserDR);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUSERROLE_PSSYSUSERDR_PSSYSUSERDRID", "", iDataEntityModel.getName(), "PSDEUSERROLE", iDataEntityModel.getDataInfo((IEntity)pSSysUserDR), arrayList.get(0)));
        }
    }

    public void resetPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSSysUserDR(pSSysUserDR);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            PSDEUserRole pSDEUserRole2 = (PSDEUserRole)this.getDEModel().createEntity();
            pSDEUserRole2.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
            pSDEUserRole2.setPSSysUserDRId(null);
            this.update(pSDEUserRole2);
        }
    }

    public void removeByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        final PSSysUserDR pSSysUserDR2 = pSSysUserDR;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUserRoleServiceBase.this.onBeforeRemoveByPSSysUserDR(pSSysUserDR2);
                PSDEUserRoleServiceBase.this.internalRemoveByPSSysUserDR(pSSysUserDR2);
                PSDEUserRoleServiceBase.this.onAfterRemoveByPSSysUserDR(pSSysUserDR2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void internalRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSSysUserDR(pSSysUserDR);
        this.onBeforeRemoveByPSSysUserDR(pSSysUserDR, arrayList);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            this.remove((IEntity)pSDEUserRole);
        }
        this.onAfterRemoveByPSSysUserDR(pSSysUserDR, arrayList);
    }

    protected void onAfterRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserDR(PSSysUserDR pSSysUserDR, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSSysUserDR2(pSSysUserDR, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUSERDR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUserDR);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUSERROLE_PSSYSUSERDR_PSSYSUSERDRID2", "", iDataEntityModel.getName(), "PSDEUSERROLE", iDataEntityModel.getDataInfo((IEntity)pSSysUserDR), arrayList.get(0)));
        }
    }

    public void resetPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSSysUserDR2(pSSysUserDR);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            PSDEUserRole pSDEUserRole2 = (PSDEUserRole)this.getDEModel().createEntity();
            pSDEUserRole2.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
            pSDEUserRole2.setPSSysUserDRId2(null);
            this.update(pSDEUserRole2);
        }
    }

    public void removeByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        final PSSysUserDR pSSysUserDR2 = pSSysUserDR;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUserRoleServiceBase.this.onBeforeRemoveByPSSysUserDR2(pSSysUserDR2);
                PSDEUserRoleServiceBase.this.internalRemoveByPSSysUserDR2(pSSysUserDR2);
                PSDEUserRoleServiceBase.this.onAfterRemoveByPSSysUserDR2(pSSysUserDR2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void internalRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
        ArrayList<PSDEUserRole> arrayList = this.selectByPSSysUserDR2(pSSysUserDR);
        this.onBeforeRemoveByPSSysUserDR2(pSSysUserDR, arrayList);
        for (PSDEUserRole pSDEUserRole : arrayList) {
            this.remove((IEntity)pSDEUserRole);
        }
        this.onAfterRemoveByPSSysUserDR2(pSSysUserDR, arrayList);
    }

    protected void onAfterRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUserDR2(PSSysUserDR pSSysUserDR, ArrayList<PSDEUserRole> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEUserRole pSDEUserRole) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEOPPrivRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUserRole(pSDEUserRole);
        ((PSDEOPPrivRoleServiceBase)pSCoreSysServiceBase).removeByPSDEUserRole(pSDEUserRole);
        pSCoreSysServiceBase = (PSSysUserRoleDataService)ServiceGlobal.getService(PSSysUserRoleDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysUserRoleDataServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUserRole(pSDEUserRole);
        super.onBeforeRemove(pSDEUserRole);
    }

    protected void onBeforeRemoveTemp(PSDEUserRole pSDEUserRole) throws Exception {
        super.onBeforeRemoveTemp((IEntity)pSDEUserRole);
    }

    protected void getRelatedDataTempMajor(PSDEUserRole pSDEUserRole) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSDEUserRole);
    }

    protected void updateRelatedDataTempMajor(PSDEUserRole pSDEUserRole, PSDEUserRole pSDEUserRole2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSDEUserRole, (IEntity)pSDEUserRole2);
    }

    protected void replaceParentInfo(PSDEUserRole pSDEUserRole, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEUserRole, cloneSession);
        if (pSDEUserRole.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUserRole.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEUserRole, (PSDataEntity)iEntity);
        }
        if (pSDEUserRole.getPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEUserRole.getPSDEDSId())) != null) {
            this.onFillParentInfo_PSDEDS(pSDEUserRole, (PSDEDataSet)iEntity);
        }
        if (pSDEUserRole.getPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEUserRole.getPSDEFGroupId())) != null) {
            this.onFillParentInfo_PSDEFGroup(pSDEUserRole, (PSDEFGroup)iEntity);
        }
        if (pSDEUserRole.getPSSysSFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSSFPLUGIN", (Object)pSDEUserRole.getPSSysSFPluginId())) != null) {
            this.onFillParentInfo_PSSysSFPlugin(pSDEUserRole, (PSSysSFPlugin)iEntity);
        }
        if (pSDEUserRole.getPSSysUserDRId() != null && (iEntity = cloneSession.getEntity("PSSYSUSERDR", (Object)pSDEUserRole.getPSSysUserDRId())) != null) {
            this.onFillParentInfo_PSSysUserDR(pSDEUserRole, (PSSysUserDR)iEntity);
        }
        if (pSDEUserRole.getPSSysUserDRId2() != null && (iEntity = cloneSession.getEntity("PSSYSUSERDR", (Object)pSDEUserRole.getPSSysUserDRId2())) != null) {
            this.onFillParentInfo_PSSysUserDR2(pSDEUserRole, (PSSysUserDR)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEUserRole, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllDataFlag(bl, pSDEUserRole, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableOrgDR(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSecBC(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSecDR(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableUserDR(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrgDR(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDSId(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupId(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUserRoleId(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUserRoleName(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSFPluginId(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserDRId(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserDRId2(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SecBC(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SecDR(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SystemFlag(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysUserDR2Param(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysUserDRParam(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserRoleTag(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEUserRole, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEUserRole, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllDataFlag(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isAllDataFlagDirty() : !pSDEUserRole.isAllDataFlagDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getAllDataFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllDataFlag_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLDATAFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isCustomCondDirty() : !pSDEUserRole.isCustomCondDirty()) {
            return null;
        }
        String string = pSDEUserRole.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isCustomTypeDirty() : !pSDEUserRole.isCustomTypeDirty()) {
            return null;
        }
        String string = pSDEUserRole.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isDefaultFlagDirty() : !pSDEUserRole.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableOrgDR(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isEnableOrgDRDirty() : !pSDEUserRole.isEnableOrgDRDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getEnableOrgDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableOrgDR_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEORGDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSecBC(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isEnableSecBCDirty() : !pSDEUserRole.isEnableSecBCDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getEnableSecBC();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSecBC_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESECBC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSecDR(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isEnableSecDRDirty() : !pSDEUserRole.isEnableSecDRDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getEnableSecDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSecDR_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESECDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableUserDR(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isEnableUserDRDirty() : !pSDEUserRole.isEnableUserDRDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getEnableUserDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableUserDR_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEUSERDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isLockFlagDirty() : !pSDEUserRole.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isMemoDirty() : !pSDEUserRole.isMemoDirty()) {
            return null;
        }
        String string = pSDEUserRole.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrgDR(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isOrgDRDirty() : !pSDEUserRole.isOrgDRDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getOrgDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrgDR_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORGDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDSId(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isPSDEDSIdDirty() : !pSDEUserRole.isPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDEUserRole.getPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDSId_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFGroupId(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isPSDEFGroupIdDirty() : !pSDEUserRole.isPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEUserRole.getPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupId_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isPSDEIdDirty() && !bl2 : !pSDEUserRole.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEUserRole.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isPSDENameDirty() && !bl2 : !pSDEUserRole.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEUserRole.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUserRoleId(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isPSDEUserRoleIdDirty() && !bl2 : !pSDEUserRole.isPSDEUserRoleIdDirty()) {
            return null;
        }
        String string = pSDEUserRole.getPSDEUserRoleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUSERROLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUserRoleId_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUserRoleName(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isPSDEUserRoleNameDirty() && !bl2 : !pSDEUserRole.isPSDEUserRoleNameDirty()) {
            return null;
        }
        String string = pSDEUserRole.getPSDEUserRoleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUSERROLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUserRoleName_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUSERROLENAME");
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEUserRoleDEModel(), "PSDEUSERROLENAME", string3, pSDEUserRole, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEUSERROLENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSFPluginId(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isPSSysSFPluginIdDirty() : !pSDEUserRole.isPSSysSFPluginIdDirty()) {
            return null;
        }
        String string = pSDEUserRole.getPSSysSFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSFPluginId_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserDRId(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isPSSysUserDRIdDirty() : !pSDEUserRole.isPSSysUserDRIdDirty()) {
            return null;
        }
        String string = pSDEUserRole.getPSSysUserDRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserDRId_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERDRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserDRId2(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isPSSysUserDRId2Dirty() : !pSDEUserRole.isPSSysUserDRId2Dirty()) {
            return null;
        }
        String string = pSDEUserRole.getPSSysUserDRId2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserDRId2_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERDRID2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SecBC(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isSecBCDirty() : !pSDEUserRole.isSecBCDirty()) {
            return null;
        }
        String string = pSDEUserRole.getSecBC();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SecBC_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECBC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SecDR(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isSecDRDirty() : !pSDEUserRole.isSecDRDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getSecDR();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SecDR_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SECDR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SystemFlag(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isSystemFlagDirty() : !pSDEUserRole.isSystemFlagDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getSystemFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SystemFlag_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTEMFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysUserDR2Param(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isSysUserDR2ParamDirty() : !pSDEUserRole.isSysUserDR2ParamDirty()) {
            return null;
        }
        String string = pSDEUserRole.getSysUserDR2Param();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysUserDR2Param_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSUSERDR2PARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysUserDRParam(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isSysUserDRParamDirty() : !pSDEUserRole.isSysUserDRParamDirty()) {
            return null;
        }
        String string = pSDEUserRole.getSysUserDRParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysUserDRParam_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSUSERDRPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isUserCatDirty() : !pSDEUserRole.isUserCatDirty()) {
            return null;
        }
        String string = pSDEUserRole.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserRoleTag(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isUserRoleTagDirty() && !bl2 : !pSDEUserRole.isUserRoleTagDirty()) {
            return null;
        }
        String string = pSDEUserRole.getUserRoleTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLETAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserRoleTag_Default((IEntity)pSDEUserRole, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERROLETAG");
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEUserRoleDEModel(), "USERROLETAG", string3, pSDEUserRole, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("USERROLETAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isUserTagDirty() : !pSDEUserRole.isUserTagDirty()) {
            return null;
        }
        String string = pSDEUserRole.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isUserTag2Dirty() : !pSDEUserRole.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEUserRole.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isUserTag3Dirty() : !pSDEUserRole.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEUserRole.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isUserTag4Dirty() : !pSDEUserRole.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEUserRole.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEUserRole pSDEUserRole, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUserRole.isValidFlagDirty() && !bl2 : !pSDEUserRole.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEUserRole.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEUserRole, bl2, bl3);
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

    protected void onSyncEntity(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEUserRole, bl);
    }

    protected void onSyncIndexEntities(PSDEUserRole pSDEUserRole, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEUserRole, bl);
    }

    public Object getDataContextValue(PSDEUserRole pSDEUserRole, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEUserRole, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEUserRole.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEUserRole pSDEUserRole, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEUserRole, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLDATAFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllDataFlag_Default(iEntity, bl, bl2);
        }
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
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEORGDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableOrgDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESECBC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSecBC_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESECDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSecDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEUSERDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableUserDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORGDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrgDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRID2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRId2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERDRNAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserDRName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECBC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SecBC_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SECDR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SecDR_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTEMFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SystemFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSUSERDR2PARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysUserDR2Param_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSUSERDRPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysUserDRParam_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERROLETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserRoleTag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AllDataFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableOrgDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSecBC_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSecDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableUserDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_OrgDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysSFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRId2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRID2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserDRName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERDRNAME2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SecBC_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SECBC", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SecDR_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SystemFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysUserDR2Param_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSUSERDR2PARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysUserDRParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSUSERDRPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_UserRoleTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERROLETAG", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("USERROLETAG", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected boolean onMergeChild(String string, String string2, PSDEUserRole pSDEUserRole) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEUserRole)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEUserRole pSDEUserRole) throws Exception {
        Object object = pSDEUserRole.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEUSERROLE_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEUserRole);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEUserRole pSDEUserRole, Object object) throws Exception {
        PSDEUserRole pSDEUserRole2 = new PSDEUserRole();
        pSDEUserRole2.set("PSDEUSERROLEID", object);
        String string = DataObject.getStringValue((Object)pSDEUserRole.get("PSDEUSERROLEID"));
        super.onCopyDetails((IEntity)pSDEUserRole, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEUserRole pSDEUserRole, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEUSERROLE");
        if (!bl) {
            pSDEUserRole.setCreateDate(null);
            pSDEUserRole.setCreateMan(null);
            pSDEUserRole.setPSDEUserRoleId(null);
            pSDEUserRole.setUpdateDate(null);
            pSDEUserRole.setUpdateMan(null);
            super.exportCurXmlModel(pSDEUserRole, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEUserRole pSDEUserRole, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEOPPrivRole(pSDEUserRole, xmlNode);
        super.onExportRelatedXmlModel(pSDEUserRole, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEOPPrivRole(PSDEUserRole pSDEUserRole, XmlNode xmlNode) throws Exception {
        PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEOPPrivRole> arrayList = null;
        String string = pSDEUserRole.getPSDEUserRoleId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEOPPrivRoleService.selectByPSDEUserRole(pSDEUserRole) : pSDEOPPrivRoleService.selectTempByPSDEUserRole(pSDEUserRole);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEOPPRIVROLES");
            xmlNode.addNode(xmlNode2);
            for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
                pSDEOPPrivRoleService.exportXmlModel(pSDEOPPrivRole, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEUserRole pSDEUserRole, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEOPPRIVROLES");
        this.importRelatedXmlModel_PSDEOPPrivRole(pSDEUserRole, xmlNode2);
        super.onImportRelatedXmlModel(pSDEUserRole, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEOPPrivRole(PSDEUserRole pSDEUserRole, XmlNode xmlNode) throws Exception {
        PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEUserRole.getPSDEUserRoleId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEOPPrivRoleService.removeByPSDEUserRole(pSDEUserRole);
        } else {
            pSDEOPPrivRoleService.removeTempByPSDEUserRole(pSDEUserRole);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEOPPrivRole pSDEOPPrivRole = new PSDEOPPrivRole();
                pSDEOPPrivRoleService.fillParentInfo((IEntity)pSDEOPPrivRole, "DER1N", "DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID", pSDEUserRole.getPSDEUserRoleId());
                pSDEOPPrivRoleService.importXmlModel(pSDEOPPrivRole, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEUserRole pSDEUserRole, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEUserRole, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUSERROLE_PSDATAENTITY_PSDEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEUserRole pSDEUserRole) {
        if (!StringHelper.isNullOrEmpty((String)pSDEUserRole.getUserRoleTag())) {
            return pSDEUserRole.getUserRoleTag();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEUserRole.getPSDEUserRoleName())) {
            return pSDEUserRole.getPSDEUserRoleName();
        }
        return super.getModelV2Tag(pSDEUserRole);
    }

    @Override
    public boolean setModelV2Tag(PSDEUserRole pSDEUserRole, String string) {
        pSDEUserRole.setUserRoleTag(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("USERROLETAG", "");
        map.put("PSDEUSERROLENAME", "");
        map.put("PSDEUSERROLENAME", "");
        map.put("USERROLETAG", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEUserRole pSDEUserRole, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEUserRole.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEUserRole, true);
        pSDEUserRole.set("USERROLETAG", string);
        if (this.select(pSDEUserRole, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEUserRole, true);
        return super.getModelV2Entity(pSDEUserRole, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEUserRole pSDEUserRole, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEUserRole, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEUserRole pSDEUserRole, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEUserRole, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEUserRole pSDEUserRole, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID")) {
            Object object;
            PSDEOPPrivRole pSDEOPPrivRole2;
            Object object2;
            Object object3;
            Object object4;
            PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEOPPrivRole> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEUSERROLE#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEOPPRIVROLE", (Object)pSDEUserRole.getPSDEUserRoleId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        pSDEOPPrivRole2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add(pSDEOPPrivRole2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEOPPrivRole>();
                object4 = pSDEOPPrivRoleService.selectByPSDEUserRole(pSDEUserRole);
                object3 = StringHelper.format((String)"PSDEUSERROLE#%1$s", (Object)pSDEUserRole.getPSDEUserRoleId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    pSDEOPPrivRole2 = object2.next();
                    object = pSDEOPPrivRoleService.getModelV2ResScope((IEntity)pSDEOPPrivRole2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEOPPrivRole)PSModelV2Helper.toJSONObject((IEntity)pSDEOPPrivRole2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSDEOPPrivRoleService.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psdeopprivrolename")) {
                            string = objectNode.get("psdeopprivrolename").asText();
                        }
                        if (objectNode2.has("psdeopprivrolename")) {
                            string2 = objectNode2.get("psdeopprivrolename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (PSDEOPPrivRole pSDEOPPrivRole2 : arrayList) {
                    object = new PSDEOPPrivRole();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)pSDEOPPrivRole2, false);
                    object3.add((JsonNode)pSDEOPPrivRoleService.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEUserRole, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEUserRole pSDEUserRole) throws Exception {
        PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEOPPrivRole> arrayList = pSDEOPPrivRoleService.selectByPSDEUserRole(pSDEUserRole);
        String string = StringHelper.format((String)"PSDEUSERROLE#%1$s", (Object)pSDEUserRole.getPSDEUserRoleId());
        for (PSDEOPPrivRole pSDEOPPrivRole : arrayList) {
            String string2 = pSDEOPPrivRoleService.getModelV2ResScope((IEntity)pSDEOPPrivRole);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEOPPrivRoleService.emptyModelV2(pSDEOPPrivRole);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEUserRole.getPSDEUserRoleId());
        pSDEOPPrivRoleService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEOPPrivRoleService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEOPPRIVROLE WHERE PSDEUSERROLEID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEUserRole);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEOPPrivRoleService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEUserRole pSDEUserRole, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEOPPrivRole pSDEOPPrivRole = new PSDEOPPrivRole();
        pSDEOPPrivRole.set("PSDEUSERROLEID", pSDEUserRole.getPSDEUserRoleId());
        PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEOPPrivRoleService.getModelV2Entity(pSDEOPPrivRole, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEUserRole, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEUserRole pSDEUserRole, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEOPPrivRoleService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEOPPrivRole pSDEOPPrivRole = new PSDEOPPrivRole();
                pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                pSDEOPPrivRole.setPSDEUserRoleName(pSDEUserRole.getPSDEUserRoleName());
                pSDEOPPrivRoleService.compileModelV2(pSDEOPPrivRole, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEOPPrivRole pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEUserRoleName(pSDEUserRole.getPSDEUserRoleName());
                    pSDEOPPrivRoleService.compileModelV2(pSDEOPPrivRole, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEUserRole, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEUserRole pSDEUserRole, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEOPPrivRoles(pSDEUserRole, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEUserRole, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEOPPrivRoles(PSDEUserRole pSDEUserRole, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEOPPRIVROLE", true), (boolean)false) == 0) {
            PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
            PSDEOPPrivRole pSDEOPPrivRole = new PSDEOPPrivRole();
            pSDEOPPrivRole.setPSDEOPPrivRoleId(pSMOSFile.getPSModelId());
            if (!pSDEOPPrivRoleService.get((IEntity)pSDEOPPrivRole, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEOPPrivRole.getPSDEUserRoleId(), (String)pSDEUserRole.getPSDEUserRoleId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEOPPrivRoleService.exportModelV2(pSDEOPPrivRole);
            pSDEOPPrivRole.reset();
            if (!pSDEOPPrivRoleService.setModelV2ResScope((IEntity)pSDEOPPrivRole, "PSDEUSERROLE", pSDEUserRole.getPSDEUserRoleId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEOPPrivRoleService.importModelV2(pSDEOPPrivRole, objectNode);
            SessionFactoryManager.commit();
            return pSDEOPPrivRoleService.getFile((IEntity)pSDEOPPrivRole);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEUserRole pSDEUserRole, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEOPPrivRoles(pSDEUserRole, list);
        super.onFillPasteHelps(pSDEUserRole, list);
    }

    protected void onFillPasteHelps_PSDEOPPrivRoles(PSDEUserRole pSDEUserRole, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEOPPRIVROLE");
        pSHelpSection.setSectionParam2("DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272]\u7684[\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u89d2\u8272]");
        list.add(pSHelpSection);
    }

    @Override
    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        HashMap<String, PSMOSFile> hashMap = new HashMap<String, PSMOSFile>();
        if (this.isOutputDRDataFolder(pSMOSFile, string, iPSMOSFileFilter, null, "<\u64cd\u4f5c\u63a7\u5236>", "DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID", "PSDEUSERROLEID", pSMOSFile.getPSModelId(), "", "")) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            if (PSDEUserRoleServiceBase.getMOSVer() == 1) {
                pSMOSFile2.setPSMOSFileName("<\u64cd\u4f5c\u63a7\u5236>");
            } else if (PSDEUserRoleServiceBase.getMOSVer() == 2) {
                pSMOSFile2.setPSMOSFileName("psdeopprivroles");
            }
            pSMOSFile2.setFileTag("DR");
            pSMOSFile2.setFileTag2("DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID|PSDEUSERROLEID");
            pSMOSFile2.setFileTag3("PSDEOPPRIVROLE");
            pSMOSFile2.setMemo("");
            if (this.isCountDRDataFolder(pSMOSFile, iPSMOSFileFilter, "DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID", "PSDEUSERROLEID", pSMOSFile.getPSModelId(), "", "")) {
                PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEOPPrivRoleService, "DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID", "PSDEUSERROLEID", pSMOSFile.getPSModelId(), "", "");
                SelectField selectField = new SelectField();
                selectField.setFunc("COUNT");
                selectField.setAlias("CNT");
                selectContext.addSelectField((ISelectField)selectField);
                ArrayList arrayList = pSDEOPPrivRoleService.selectEx((ISelectContext)selectContext);
                pSMOSFile2.setFileCnt(DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0));
            }
            if (PSDEUserRoleServiceBase.getMOSVer() == 2 && iPSMOSFileFilter != null) {
                if (iPSMOSFileFilter.isStarQuery() || pSMOSFile2.getPSMOSFileName().indexOf(iPSMOSFileFilter.getQuery()) != -1) {
                    hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
                }
            } else {
                hashMap.put(pSMOSFile2.getPSMOSFileName(), pSMOSFile2);
            }
        }
        if (hashMap.size() > 0) {
            return PSMOSFileUtil.append(hashMap.values().toArray(new PSMOSFile[hashMap.size()]), super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter));
        }
        return super.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
    }

    @Override
    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        if (PSDEUserRoleServiceBase.getMOSVer() == 1 && StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string2, (String)"<\u64cd\u4f5c\u63a7\u5236>", (boolean)false) == 0 || PSDEUserRoleServiceBase.getMOSVer() == 2 && StringHelper.compare((String)string2, (String)"PSDEOPPrivRoles", (boolean)true) == 0) {
            PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = this.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, pSDEOPPrivRoleService, "DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID", "PSDEUSERROLEID", pSMOSFile.getPSModelId(), "", "");
            ArrayList arrayList2 = pSDEOPPrivRoleService.selectEx((ISelectContext)selectContext);
            for (PSDEOPPrivRole pSDEOPPrivRole : arrayList2) {
                PSMOSFile pSMOSFile2 = pSDEOPPrivRoleService.getFile(pSMOSFile, (IEntity)pSDEOPPrivRole, bl);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
            }
        }
        if (arrayList.size() > 0) {
            return PSMOSFileUtil.append(arrayList.toArray(new PSMOSFile[arrayList.size()]), super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl));
        }
        return super.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEOPPRIVROLE_PSDEUSERROLE_PSDEUSERROLEID", (boolean)false) == 0) {
            if (PSDEUserRoleServiceBase.getMOSVer() == 1) {
                return "<\u64cd\u4f5c\u63a7\u5236>";
            }
            if (PSDEUserRoleServiceBase.getMOSVer() == 2) {
                return "psdeopprivroles";
            }
        }
        return super.getDRFolderPath(string, iEntity, string2);
    }

    @Override
    public boolean isOutputDRFolders() {
        return true;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEUserRole pSDEUserRole, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("PSDEUSERROLENAME", "\u64cd\u4f5c\u89d2\u8272");
    }
}

