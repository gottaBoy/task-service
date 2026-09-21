/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.psrt.srv.common.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.PSRuntimeSysServiceBase;
import net.ibizsys.psrt.srv.common.dao.PPModelDAO;
import net.ibizsys.psrt.srv.common.demodel.PPModelDEModel;
import net.ibizsys.psrt.srv.common.entity.PPModel;
import net.ibizsys.psrt.srv.common.entity.PVPart;
import net.ibizsys.psrt.srv.common.entity.PVPartBase;
import net.ibizsys.psrt.srv.common.entity.PortalPage;
import net.ibizsys.psrt.srv.common.entity.PortalPageBase;
import net.ibizsys.psrt.srv.common.service.PPModelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PPModelServiceBase
extends PSRuntimeSysServiceBase<PPModel> {
    private static final Log log = LogFactory.getLog(PPModelServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PPModelDEModel pPModelDEModel;
    private PPModelDAO pPModelDAO;

    public static PPModelService getInstance() throws Exception {
        return PPModelServiceBase.getInstance(null);
    }

    public static PPModelService getInstance(SessionFactory sessionFactory) throws Exception {
        return (PPModelService)ServiceGlobal.getService(PPModelService.class, sessionFactory);
    }

    @Override
    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService(this.getServiceId(), this);
    }

    @Override
    protected String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.PPModelService";
    }

    public PPModelDEModel getPPModelDEModel() {
        if (this.pPModelDEModel == null) {
            try {
                this.pPModelDEModel = (PPModelDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.PPModelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pPModelDEModel;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.getPPModelDEModel();
    }

    public PPModelDAO getPPModelDAO() {
        if (this.pPModelDAO == null) {
            try {
                this.pPModelDAO = (PPModelDAO)DAOGlobal.getDAO("net.ibizsys.psrt.srv.common.dao.PPModelDAO", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pPModelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPPModelDAO();
    }

    @Override
    protected DBFetchResult onfetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare(strDataSetName, DATASET_DEFAULT, true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(strDataSetName, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String strAction, IEntity entity) throws Exception {
        super.onExecuteAction(strAction, entity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dbFetchResult;
    }

    @Override
    protected void onFillParentInfo(PPModel et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PORTALPAGE_PORTALPAGEID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PortalPageService", this.getSessionFactory());
            PortalPage parentEntity = (PortalPage)iService.getDEModel().createEntity();
            parentEntity.set("PORTALPAGEID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_PortalPage(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_C1PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_C1PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_C2PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_C2PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_C3PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_C3PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_C4PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_C4PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_L1PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_L1PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_L2PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_L2PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_L3PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_L3PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_L4PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_L4PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_R1PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_R1PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_R2PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_R2PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_R3PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_R3PVPart(et, parentEntity);
            return;
        }
        if ((StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0 || StringHelper.compare(strParentType, "DER11", true) == 0 || StringHelper.compare(strParentType, "SYSDER11", true) == 0) && StringHelper.compare(strTypeParam, "DER1N_PPMODEL_PVPART_R4PVPARTID", true) == 0) {
            IService iService = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PVPartService", this.getSessionFactory());
            PVPart parentEntity = (PVPart)iService.getDEModel().createEntity();
            parentEntity.set("PVPARTID", DataTypeHelper.parse(25, strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_R4PVPart(et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    @Override
    protected String onSyncDER1NData(String strDER1NId, String strParentKey, String strDatas) throws Exception {
        return super.onSyncDER1NData(strDER1NId, strParentKey, strDatas);
    }

    protected void onFillParentInfo_PortalPage(PPModel et, PortalPage parentEntity) throws Exception {
        et.setPortalPageId(parentEntity.getPortalPageId());
        et.setPortalPageName(parentEntity.getPortalPageName());
    }

    protected void onFillParentInfo_C1PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setC1PVPartCtrlId(parentEntity.getCtrlId());
        et.setC1PVPartId(parentEntity.getPVPartId());
        et.setC1PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_C2PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setC2PVPartCtrlId(parentEntity.getCtrlId());
        et.setC2PVPartId(parentEntity.getPVPartId());
        et.setC2PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_C3PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setC3PVPartCtrlId(parentEntity.getCtrlId());
        et.setC3PVPartId(parentEntity.getPVPartId());
        et.setC3PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_C4PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setC4PVPartCtrlId(parentEntity.getCtrlId());
        et.setC4PVPartId(parentEntity.getPVPartId());
        et.setC4PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_L1PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setL1PVPartCtrlId(parentEntity.getCtrlId());
        et.setL1PVPartId(parentEntity.getPVPartId());
        et.setL1PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_L2PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setL2PVPartCtrlId(parentEntity.getCtrlId());
        et.setL2PVPartId(parentEntity.getPVPartId());
        et.setL2PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_L3PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setL3PVPartCtrlId(parentEntity.getCtrlId());
        et.setL3PVPartId(parentEntity.getPVPartId());
        et.setL3PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_L4PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setL4PVPartCtrlId(parentEntity.getCtrlId());
        et.setL4PVPartId(parentEntity.getPVPartId());
        et.setL4PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_R1PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setR1PVPartCtrlId(parentEntity.getCtrlId());
        et.setR1PVPartId(parentEntity.getPVPartId());
        et.setR1PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_R2PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setR2PVPartCtrlId(parentEntity.getCtrlId());
        et.setR2PVPartId(parentEntity.getPVPartId());
        et.setR2PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_R3PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setR3PVPartCtrlId(parentEntity.getCtrlId());
        et.setR3PVPartId(parentEntity.getPVPartId());
        et.setR3PVPartName(parentEntity.getPVPartName());
    }

    protected void onFillParentInfo_R4PVPart(PPModel et, PVPart parentEntity) throws Exception {
        et.setR4PVPartCtrlId(parentEntity.getCtrlId());
        et.setR4PVPartId(parentEntity.getPVPartId());
        et.setR4PVPartName(parentEntity.getPVPartName());
    }

    @Override
    protected boolean onFillEntityKeyValue(PPModel et, boolean bTempMode) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        Object objPortalPageId = et.get("PORTALPAGEID");
        if (objPortalPageId == null) {
            objPortalPageId = "__EMTPY__";
        }
        sb.append("%1$s", objPortalPageId);
        sb.append("||");
        Object objOwnerId = et.get("OWNERID");
        if (objOwnerId == null) {
            objOwnerId = "__EMTPY__";
        }
        sb.append("%1$s", objOwnerId);
        String strValue = sb.toString();
        et.set(this.getPPModelDEModel().getUniTagDEField().getName(), KeyValueHelper.genUniqueId(strValue));
        return true;
    }

    @Override
    protected void onFillEntityFullInfo(PPModel et, boolean bCreate) throws Exception {
        if (bCreate) {
            if (et.getIsSystem() == null) {
                et.setIsSystem((Integer)DefaultValueHelper.getValue(this.getWebContext(), "", "0", 9));
            }
            if (et.getPPModelName() == null) {
                et.setPPModelName((String)DefaultValueHelper.getValue(this.getWebContext(), "", "\u95e8\u6237\u89c6\u56fe\u7528\u6237\u81ea\u5b9a\u4e49", 25));
            }
            if (et.getPPMVersion() == null) {
                et.setPPMVersion((Integer)DefaultValueHelper.getValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(et, bCreate);
        this.onFillEntityFullInfo_PortalPage(et, bCreate);
        this.onFillEntityFullInfo_C1PVPart(et, bCreate);
        this.onFillEntityFullInfo_C2PVPart(et, bCreate);
        this.onFillEntityFullInfo_C3PVPart(et, bCreate);
        this.onFillEntityFullInfo_C4PVPart(et, bCreate);
        this.onFillEntityFullInfo_L1PVPart(et, bCreate);
        this.onFillEntityFullInfo_L2PVPart(et, bCreate);
        this.onFillEntityFullInfo_L3PVPart(et, bCreate);
        this.onFillEntityFullInfo_L4PVPart(et, bCreate);
        this.onFillEntityFullInfo_R1PVPart(et, bCreate);
        this.onFillEntityFullInfo_R2PVPart(et, bCreate);
        this.onFillEntityFullInfo_R3PVPart(et, bCreate);
        this.onFillEntityFullInfo_R4PVPart(et, bCreate);
    }

    protected void onFillEntityFullInfo_PortalPage(PPModel et, boolean bCreate) throws Exception {
        if (et.isPortalPageIdDirty()) {
            if (et.getPortalPageId() != null) {
                if (et.getPortalPageId() == null || et.getPortalPageName() == null) {
                    PortalPage parentEntity = et.getPortalPage();
                    et.setPortalPageName(parentEntity.getPortalPageName());
                }
            } else {
                et.setPortalPageName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_C1PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isC1PVPartIdDirty()) {
            if (et.getC1PVPartId() != null) {
                if (et.getC1PVPartCtrlId() == null || et.getC1PVPartId() == null || et.getC1PVPartName() == null) {
                    PVPart parentEntity = et.getC1PVPart();
                    et.setC1PVPartCtrlId(parentEntity.getCtrlId());
                    et.setC1PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setC1PVPartCtrlId(null);
                et.setC1PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_C2PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isC2PVPartIdDirty()) {
            if (et.getC2PVPartId() != null) {
                if (et.getC2PVPartCtrlId() == null || et.getC2PVPartId() == null || et.getC2PVPartName() == null) {
                    PVPart parentEntity = et.getC2PVPart();
                    et.setC2PVPartCtrlId(parentEntity.getCtrlId());
                    et.setC2PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setC2PVPartCtrlId(null);
                et.setC2PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_C3PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isC3PVPartIdDirty()) {
            if (et.getC3PVPartId() != null) {
                if (et.getC3PVPartCtrlId() == null || et.getC3PVPartId() == null || et.getC3PVPartName() == null) {
                    PVPart parentEntity = et.getC3PVPart();
                    et.setC3PVPartCtrlId(parentEntity.getCtrlId());
                    et.setC3PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setC3PVPartCtrlId(null);
                et.setC3PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_C4PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isC4PVPartIdDirty()) {
            if (et.getC4PVPartId() != null) {
                if (et.getC4PVPartCtrlId() == null || et.getC4PVPartId() == null || et.getC4PVPartName() == null) {
                    PVPart parentEntity = et.getC4PVPart();
                    et.setC4PVPartCtrlId(parentEntity.getCtrlId());
                    et.setC4PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setC4PVPartCtrlId(null);
                et.setC4PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_L1PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isL1PVPartIdDirty()) {
            if (et.getL1PVPartId() != null) {
                if (et.getL1PVPartCtrlId() == null || et.getL1PVPartId() == null || et.getL1PVPartName() == null) {
                    PVPart parentEntity = et.getL1PVPart();
                    et.setL1PVPartCtrlId(parentEntity.getCtrlId());
                    et.setL1PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setL1PVPartCtrlId(null);
                et.setL1PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_L2PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isL2PVPartIdDirty()) {
            if (et.getL2PVPartId() != null) {
                if (et.getL2PVPartCtrlId() == null || et.getL2PVPartId() == null || et.getL2PVPartName() == null) {
                    PVPart parentEntity = et.getL2PVPart();
                    et.setL2PVPartCtrlId(parentEntity.getCtrlId());
                    et.setL2PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setL2PVPartCtrlId(null);
                et.setL2PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_L3PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isL3PVPartIdDirty()) {
            if (et.getL3PVPartId() != null) {
                if (et.getL3PVPartCtrlId() == null || et.getL3PVPartId() == null || et.getL3PVPartName() == null) {
                    PVPart parentEntity = et.getL3PVPart();
                    et.setL3PVPartCtrlId(parentEntity.getCtrlId());
                    et.setL3PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setL3PVPartCtrlId(null);
                et.setL3PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_L4PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isL4PVPartIdDirty()) {
            if (et.getL4PVPartId() != null) {
                if (et.getL4PVPartCtrlId() == null || et.getL4PVPartId() == null || et.getL4PVPartName() == null) {
                    PVPart parentEntity = et.getL4PVPart();
                    et.setL4PVPartCtrlId(parentEntity.getCtrlId());
                    et.setL4PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setL4PVPartCtrlId(null);
                et.setL4PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_R1PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isR1PVPartIdDirty()) {
            if (et.getR1PVPartId() != null) {
                if (et.getR1PVPartCtrlId() == null || et.getR1PVPartId() == null || et.getR1PVPartName() == null) {
                    PVPart parentEntity = et.getR1PVPart();
                    et.setR1PVPartCtrlId(parentEntity.getCtrlId());
                    et.setR1PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setR1PVPartCtrlId(null);
                et.setR1PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_R2PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isR2PVPartIdDirty()) {
            if (et.getR2PVPartId() != null) {
                if (et.getR2PVPartCtrlId() == null || et.getR2PVPartId() == null || et.getR2PVPartName() == null) {
                    PVPart parentEntity = et.getR2PVPart();
                    et.setR2PVPartCtrlId(parentEntity.getCtrlId());
                    et.setR2PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setR2PVPartCtrlId(null);
                et.setR2PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_R3PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isR3PVPartIdDirty()) {
            if (et.getR3PVPartId() != null) {
                if (et.getR3PVPartCtrlId() == null || et.getR3PVPartId() == null || et.getR3PVPartName() == null) {
                    PVPart parentEntity = et.getR3PVPart();
                    et.setR3PVPartCtrlId(parentEntity.getCtrlId());
                    et.setR3PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setR3PVPartCtrlId(null);
                et.setR3PVPartName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_R4PVPart(PPModel et, boolean bCreate) throws Exception {
        if (et.isR4PVPartIdDirty()) {
            if (et.getR4PVPartId() != null) {
                if (et.getR4PVPartCtrlId() == null || et.getR4PVPartId() == null || et.getR4PVPartName() == null) {
                    PVPart parentEntity = et.getR4PVPart();
                    et.setR4PVPartCtrlId(parentEntity.getCtrlId());
                    et.setR4PVPartName(parentEntity.getPVPartName());
                }
            } else {
                et.setR4PVPartCtrlId(null);
                et.setR4PVPartName(null);
            }
        }
    }

    @Override
    protected void onWriteBackParent(PPModel et, boolean bCreate) throws Exception {
        super.onWriteBackParent(et, bCreate);
    }

    public ArrayList<PPModel> selectByPortalPage(PortalPageBase parentEntity) throws Exception {
        return this.selectByPortalPage(parentEntity, "");
    }

    public ArrayList<PPModel> selectByPortalPage(PortalPageBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PORTALPAGEID", parentEntity.getPortalPageId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByPortalPageCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByPortalPageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByC1PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByC1PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByC1PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("C1PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByC1PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByC1PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByC2PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByC2PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByC2PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("C2PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByC2PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByC2PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByC3PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByC3PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByC3PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("C3PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByC3PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByC3PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByC4PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByC4PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByC4PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("C4PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByC4PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByC4PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByL1PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByL1PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByL1PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("L1PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByL1PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByL1PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByL2PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByL2PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByL2PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("L2PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByL2PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByL2PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByL3PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByL3PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByL3PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("L3PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByL3PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByL3PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByL4PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByL4PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByL4PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("L4PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByL4PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByL4PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByR1PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByR1PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByR1PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("R1PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByR1PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByR1PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByR2PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByR2PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByR2PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("R2PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByR2PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByR2PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByR3PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByR3PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByR3PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("R3PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByR3PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByR3PVPartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PPModel> selectByR4PVPart(PVPartBase parentEntity) throws Exception {
        return this.selectByR4PVPart(parentEntity, "");
    }

    public ArrayList<PPModel> selectByR4PVPart(PVPartBase parentEntity, String strOrderInfo) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("R4PVPARTID", parentEntity.getPVPartId());
        selectCond.setOrderInfo(strOrderInfo);
        this.onFillSelectByR4PVPartCond(selectCond);
        return this.select(selectCond);
    }

    protected void onFillSelectByR4PVPartCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPortalPage(PortalPage parentEntity) throws Exception {
    }

    public void resetPortalPage(PortalPage parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByPortalPage(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setPortalPageId(null);
            this.update(item2);
        }
    }

    public void removeByPortalPage(PortalPage parentEntity) throws Exception {
        final PortalPage parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByPortalPage(parentEntity2);
                PPModelServiceBase.this.internalRemoveByPortalPage(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByPortalPage(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPortalPage(PortalPage parentEntity) throws Exception {
    }

    protected void internalRemoveByPortalPage(PortalPage parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByPortalPage(parentEntity);
        this.onBeforeRemoveByPortalPage(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByPortalPage(parentEntity, removeList);
    }

    protected void onAfterRemoveByPortalPage(PortalPage parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByPortalPage(PortalPage parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByPortalPage(PortalPage parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByC1PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetC1PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByC1PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setC1PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByC1PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByC1PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByC1PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByC1PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByC1PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByC1PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByC1PVPart(parentEntity);
        this.onBeforeRemoveByC1PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByC1PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByC1PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByC1PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByC1PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByC2PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetC2PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByC2PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setC2PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByC2PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByC2PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByC2PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByC2PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByC2PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByC2PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByC2PVPart(parentEntity);
        this.onBeforeRemoveByC2PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByC2PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByC2PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByC2PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByC2PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByC3PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetC3PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByC3PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setC3PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByC3PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByC3PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByC3PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByC3PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByC3PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByC3PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByC3PVPart(parentEntity);
        this.onBeforeRemoveByC3PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByC3PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByC3PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByC3PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByC3PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByC4PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetC4PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByC4PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setC4PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByC4PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByC4PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByC4PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByC4PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByC4PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByC4PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByC4PVPart(parentEntity);
        this.onBeforeRemoveByC4PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByC4PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByC4PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByC4PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByC4PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByL1PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetL1PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByL1PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setL1PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByL1PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByL1PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByL1PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByL1PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByL1PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByL1PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByL1PVPart(parentEntity);
        this.onBeforeRemoveByL1PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByL1PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByL1PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByL1PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByL1PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByL2PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetL2PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByL2PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setL2PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByL2PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByL2PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByL2PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByL2PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByL2PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByL2PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByL2PVPart(parentEntity);
        this.onBeforeRemoveByL2PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByL2PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByL2PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByL2PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByL2PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByL3PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetL3PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByL3PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setL3PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByL3PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByL3PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByL3PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByL3PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByL3PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByL3PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByL3PVPart(parentEntity);
        this.onBeforeRemoveByL3PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByL3PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByL3PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByL3PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByL3PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByL4PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetL4PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByL4PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setL4PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByL4PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByL4PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByL4PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByL4PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByL4PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByL4PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByL4PVPart(parentEntity);
        this.onBeforeRemoveByL4PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByL4PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByL4PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByL4PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByL4PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByR1PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetR1PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByR1PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setR1PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByR1PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByR1PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByR1PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByR1PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByR1PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByR1PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByR1PVPart(parentEntity);
        this.onBeforeRemoveByR1PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByR1PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByR1PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByR1PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByR1PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByR2PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetR2PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByR2PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setR2PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByR2PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByR2PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByR2PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByR2PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByR2PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByR2PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByR2PVPart(parentEntity);
        this.onBeforeRemoveByR2PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByR2PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByR2PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByR2PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByR2PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByR3PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetR3PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByR3PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setR3PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByR3PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByR3PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByR3PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByR3PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByR3PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByR3PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByR3PVPart(parentEntity);
        this.onBeforeRemoveByR3PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByR3PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByR3PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByR3PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByR3PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    public void testRemoveByR4PVPart(PVPart parentEntity) throws Exception {
    }

    public void resetR4PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> list = this.selectByR4PVPart(parentEntity);
        for (PPModel item : list) {
            PPModel item2 = (PPModel)this.getDEModel().createEntity();
            item2.setPPModelId(item.getPPModelId());
            item2.setR4PVPartId(null);
            this.update(item2);
        }
    }

    public void removeByR4PVPart(PVPart parentEntity) throws Exception {
        final PVPart parentEntity2 = parentEntity;
        this.doServiceWork(new IServiceWork(){

            @Override
            public void execute(ITransaction iTransaction) throws Exception {
                PPModelServiceBase.this.onBeforeRemoveByR4PVPart(parentEntity2);
                PPModelServiceBase.this.internalRemoveByR4PVPart(parentEntity2);
                PPModelServiceBase.this.onAfterRemoveByR4PVPart(parentEntity2);
            }
        });
    }

    protected void onBeforeRemoveByR4PVPart(PVPart parentEntity) throws Exception {
    }

    protected void internalRemoveByR4PVPart(PVPart parentEntity) throws Exception {
        ArrayList<PPModel> removeList = this.selectByR4PVPart(parentEntity);
        this.onBeforeRemoveByR4PVPart(parentEntity, removeList);
        for (PPModel item : removeList) {
            this.remove(item);
        }
        this.onAfterRemoveByR4PVPart(parentEntity, removeList);
    }

    protected void onAfterRemoveByR4PVPart(PVPart parentEntity) throws Exception {
    }

    protected void onBeforeRemoveByR4PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    protected void onAfterRemoveByR4PVPart(PVPart parentEntity, ArrayList<PPModel> removeList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PPModel et) throws Exception {
        super.onBeforeRemove(et);
    }

    @Override
    protected void replaceParentInfo(PPModel et, CloneSession cloneSession) throws Exception {
        IEntity entity;
        super.replaceParentInfo(et, cloneSession);
        if (et.getPortalPageId() != null && (entity = cloneSession.getEntity("PORTALPAGE", et.getPortalPageId())) != null) {
            this.onFillParentInfo_PortalPage(et, (PortalPage)entity);
        }
        if (et.getC1PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getC1PVPartId())) != null) {
            this.onFillParentInfo_C1PVPart(et, (PVPart)entity);
        }
        if (et.getC2PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getC2PVPartId())) != null) {
            this.onFillParentInfo_C2PVPart(et, (PVPart)entity);
        }
        if (et.getC3PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getC3PVPartId())) != null) {
            this.onFillParentInfo_C3PVPart(et, (PVPart)entity);
        }
        if (et.getC4PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getC4PVPartId())) != null) {
            this.onFillParentInfo_C4PVPart(et, (PVPart)entity);
        }
        if (et.getL1PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getL1PVPartId())) != null) {
            this.onFillParentInfo_L1PVPart(et, (PVPart)entity);
        }
        if (et.getL2PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getL2PVPartId())) != null) {
            this.onFillParentInfo_L2PVPart(et, (PVPart)entity);
        }
        if (et.getL3PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getL3PVPartId())) != null) {
            this.onFillParentInfo_L3PVPart(et, (PVPart)entity);
        }
        if (et.getL4PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getL4PVPartId())) != null) {
            this.onFillParentInfo_L4PVPart(et, (PVPart)entity);
        }
        if (et.getR1PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getR1PVPartId())) != null) {
            this.onFillParentInfo_R1PVPart(et, (PVPart)entity);
        }
        if (et.getR2PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getR2PVPartId())) != null) {
            this.onFillParentInfo_R2PVPart(et, (PVPart)entity);
        }
        if (et.getR3PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getR3PVPartId())) != null) {
            this.onFillParentInfo_R3PVPart(et, (PVPart)entity);
        }
        if (et.getR4PVPartId() != null && (entity = cloneSession.getEntity("PVPART", et.getR4PVPartId())) != null) {
            this.onFillParentInfo_R4PVPart(et, (PVPart)entity);
        }
    }

    @Override
    protected void onRemoveEntityUncopyValues(PPModel et, boolean bTempMode) throws Exception {
        super.onRemoveEntityUncopyValues(et, bTempMode);
    }

    @Override
    protected void onCheckEntity(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_C1PVPartCtrlId(bBaseMode, et, bCreate, bTempMode);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C1PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C1PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C2PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C2PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C2PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C3PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C3PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C3PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C4PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C4PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_C4PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IsSystem(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L1PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L1PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L1PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L2PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L2PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L2PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L3PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L3PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L3PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L4PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L4PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_L4PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PortalPageId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PortalPageName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPModel(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPModelDetail(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPModelId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPModelName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPMVersion(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R1PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R1PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R1PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R2PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R2PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R2PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R3PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R3PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R3PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R4PVPartCtrlId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R4PVPartId(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_R4PVPartName(bBaseMode, et, bCreate, bTempMode)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bBaseMode, et, bCreate, bTempMode, entityError);
    }

    protected EntityFieldError onCheckField_C1PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC1PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getC1PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C1PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C1PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C1PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC1PVPartIdDirty()) {
            return null;
        }
        String value = et.getC1PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C1PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C1PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C1PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC1PVPartNameDirty()) {
            return null;
        }
        String value = et.getC1PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C1PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C1PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C2PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC2PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getC2PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C2PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C2PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C2PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC2PVPartIdDirty()) {
            return null;
        }
        String value = et.getC2PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C2PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C2PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C2PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC2PVPartNameDirty()) {
            return null;
        }
        String value = et.getC2PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C2PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C2PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C3PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC3PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getC3PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C3PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C3PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C3PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC3PVPartIdDirty()) {
            return null;
        }
        String value = et.getC3PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C3PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C3PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C3PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC3PVPartNameDirty()) {
            return null;
        }
        String value = et.getC3PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C3PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C3PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C4PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC4PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getC4PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C4PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C4PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C4PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC4PVPartIdDirty()) {
            return null;
        }
        String value = et.getC4PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C4PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C4PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_C4PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isC4PVPartNameDirty()) {
            return null;
        }
        String value = et.getC4PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_C4PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("C4PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IsSystem(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isIsSystemDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSYSTEM");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        Integer value = et.getIsSystem();
        if (bBaseMode) {
            if (bCreate && value == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSYSTEM");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_IsSystem_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ISSYSTEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L1PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL1PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getL1PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L1PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L1PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L1PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL1PVPartIdDirty()) {
            return null;
        }
        String value = et.getL1PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L1PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L1PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L1PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL1PVPartNameDirty()) {
            return null;
        }
        String value = et.getL1PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L1PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L1PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L2PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL2PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getL2PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L2PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L2PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L2PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL2PVPartIdDirty()) {
            return null;
        }
        String value = et.getL2PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L2PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L2PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L2PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL2PVPartNameDirty()) {
            return null;
        }
        String value = et.getL2PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L2PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L2PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L3PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL3PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getL3PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L3PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L3PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L3PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL3PVPartIdDirty()) {
            return null;
        }
        String value = et.getL3PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L3PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L3PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L3PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL3PVPartNameDirty()) {
            return null;
        }
        String value = et.getL3PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L3PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L3PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L4PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL4PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getL4PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L4PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L4PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L4PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL4PVPartIdDirty()) {
            return null;
        }
        String value = et.getL4PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L4PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L4PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_L4PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isL4PVPartNameDirty()) {
            return null;
        }
        String value = et.getL4PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_L4PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("L4PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OwnerId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isOwnerIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getOwnerId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_OwnerId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PortalPageId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPortalPageIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTALPAGEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getPortalPageId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTALPAGEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PortalPageId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTALPAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PortalPageName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPortalPageNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTALPAGENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getPortalPageName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTALPAGENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PortalPageName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PORTALPAGENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPModel(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPPModelDirty()) {
            return null;
        }
        String value = et.getPPModel();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PPModel_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPModelDetail(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPPModelDetailDirty()) {
            return null;
        }
        String value = et.getPPModelDetail();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PPModelDetail_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMODELDETAIL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPModelId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPPModelIdDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getPPModelId();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMODELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PPModelId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPModelName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPPModelNameDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        String value = et.getPPModelName();
        if (bBaseMode) {
            if (bCreate && StringHelper.isNullOrEmpty(value)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMODELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PPModelName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPMVersion(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isPPMVersionDirty()) {
            if (bBaseMode && bCreate) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMVERSION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            return null;
        }
        Integer value = et.getPPMVersion();
        if (bBaseMode) {
            if (bCreate && value == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMVERSION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_PPMVersion_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPMVERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R1PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR1PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getR1PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R1PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R1PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R1PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR1PVPartIdDirty()) {
            return null;
        }
        String value = et.getR1PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R1PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R1PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R1PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR1PVPartNameDirty()) {
            return null;
        }
        String value = et.getR1PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R1PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R1PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R2PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR2PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getR2PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R2PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R2PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R2PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR2PVPartIdDirty()) {
            return null;
        }
        String value = et.getR2PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R2PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R2PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R2PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR2PVPartNameDirty()) {
            return null;
        }
        String value = et.getR2PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R2PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R2PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R3PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR3PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getR3PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R3PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R3PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R3PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR3PVPartIdDirty()) {
            return null;
        }
        String value = et.getR3PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R3PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R3PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R3PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR3PVPartNameDirty()) {
            return null;
        }
        String value = et.getR3PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R3PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R3PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R4PVPartCtrlId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR4PVPartCtrlIdDirty()) {
            return null;
        }
        String value = et.getR4PVPartCtrlId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R4PVPartCtrlId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R4PVPARTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R4PVPartId(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR4PVPartIdDirty()) {
            return null;
        }
        String value = et.getR4PVPartId();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R4PVPartId_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R4PVPARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_R4PVPartName(boolean bBaseMode, PPModel et, boolean bCreate, boolean bTempMode) throws Exception {
        if (!et.isR4PVPartNameDirty()) {
            return null;
        }
        String value = et.getR4PVPartName();
        if (bBaseMode) {
            String strRuleInfo = null;
            strRuleInfo = this.onTestValueRule_R4PVPartName_Default(et, bCreate, bTempMode);
            if (!StringHelper.isNullOrEmpty(strRuleInfo)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("R4PVPARTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(strRuleInfo);
                return entityFieldError;
            }
        }
        return null;
    }

    @Override
    protected void onSyncEntity(PPModel et, boolean bRemove) throws Exception {
        super.onSyncEntity(et, bRemove);
    }

    @Override
    protected void onSyncIndexEntities(PPModel et, boolean bRemove) throws Exception {
        super.onSyncIndexEntities(et, bRemove);
    }

    @Override
    public Object getDataContextValue(PPModel et, String strField, IDataContextParam iDataContextParam) throws Exception {
        Object objValue = null;
        objValue = super.getDataContextValue(et, strField, iDataContextParam);
        if (objValue != null) {
            return objValue;
        }
        return null;
    }

    @Override
    protected String onTestValueRule(String strDEFieldName, String strRule, IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        if (StringHelper.compare(strDEFieldName, "C1PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C1PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C1PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C1PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C1PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C1PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C2PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C2PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C2PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C2PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C2PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C2PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C3PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C3PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C3PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C3PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C3PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C3PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C4PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C4PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C4PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C4PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "C4PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_C4PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "CREATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_CreateMan_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "ISSYSTEM", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_IsSystem_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L1PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L1PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L1PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L1PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L1PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L1PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L2PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L2PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L2PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L2PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L2PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L2PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L3PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L3PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L3PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L3PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L3PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L3PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L4PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L4PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L4PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L4PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "L4PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_L4PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "OWNERID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_OwnerId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PORTALPAGEID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PortalPageId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PORTALPAGENAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PortalPageName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PPMODEL", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PPModel_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PPMODELDETAIL", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PPModelDetail_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PPMODELID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PPModelId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PPMODELNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PPModelName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "PPMVERSION", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_PPMVersion_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R1PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R1PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R1PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R1PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R1PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R1PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R2PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R2PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R2PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R2PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R2PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R2PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R3PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R3PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R3PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R3PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R3PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R3PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R4PVPARTCTRLID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R4PVPartCtrlId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R4PVPARTID", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R4PVPartId_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "R4PVPARTNAME", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_R4PVPartName_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEDATE", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(et, bCreate, bTempMode);
        }
        if (StringHelper.compare(strDEFieldName, "UPDATEMAN", true) == 0 && StringHelper.compare(strRule, DATASET_DEFAULT, true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(et, bCreate, bTempMode);
        }
        return super.onTestValueRule(strDEFieldName, strRule, et, bCreate, bTempMode);
    }

    protected String onTestValueRule_C1PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C1PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C1PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C1PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C1PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C1PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C2PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C2PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C2PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C2PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C2PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C2PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C3PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C3PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C3PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C3PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C3PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C3PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C4PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C4PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C4PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C4PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_C4PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("C4PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", et, bTempMode, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_IsSystem_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_L1PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L1PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L1PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L1PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L1PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L1PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L2PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L2PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L2PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L2PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L2PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L2PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L3PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L3PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L3PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L3PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L3PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L3PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L4PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L4PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L4PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L4PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_L4PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("L4PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_OwnerId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PortalPageId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PORTALPAGEID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PortalPageName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PORTALPAGENAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PPModel_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPMODEL", et, bTempMode, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PPModelDetail_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPMODELDETAIL", et, bTempMode, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PPModelId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPMODELID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PPModelName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPMODELNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_PPMVersion_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_R1PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R1PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R1PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R1PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R1PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R1PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R2PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R2PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R2PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R2PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R2PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R2PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R3PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R3PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R3PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R3PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R3PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R3PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R4PVPartCtrlId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R4PVPARTCTRLID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R4PVPartId_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R4PVPARTID", et, bTempMode, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_R4PVPartName_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("R4PVPARTNAME", et, bTempMode, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity et, boolean bCreate, boolean bTempMode) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", et, bTempMode, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected boolean onMergeChild(String strChildType, String strTypeParam, PPModel et) throws Exception {
        boolean bRet = false;
        if (super.onMergeChild(strChildType, strTypeParam, et)) {
            bRet = true;
        }
        return bRet;
    }

    @Override
    protected void onUpdateParent(PPModel et) throws Exception {
        super.onUpdateParent(et);
    }
}

