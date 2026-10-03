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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDRGroupDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDRGroupDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDRGroupServiceBase
extends PSCoreSysServiceBase<PSDEDRGroup> {
    private static final Log log = LogFactory.getLog(PSDEDRGroupServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEDRGroupDEModel pSDEDRGroupDEModel;
    private PSDEDRGroupDAO pSDEDRGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService";
    }

    public PSDEDRGroupDEModel getPSDEDRGroupDEModel() {
        if (this.pSDEDRGroupDEModel == null) {
            try {
                this.pSDEDRGroupDEModel = (PSDEDRGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDRGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDRGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDRGroupDEModel();
    }

    public PSDEDRGroupDAO getPSDEDRGroupDAO() {
        if (this.pSDEDRGroupDAO == null) {
            try {
                this.pSDEDRGroupDAO = (PSDEDRGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDRGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDRGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDRGroupDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
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

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEDRGroup pSDEDRGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRGROUP_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEDRGroup, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRGROUP_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEDRGroup, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRGROUP_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSDEDRGroup, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRGROUP_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCounter);
            } else {
                iService.get(pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSDEDRGroup, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRGROUP_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEDRGroup, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDRGROUP_PSSYSPFPLUGIN_HEADERPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_HeaderPSSysPFPlugin(pSDEDRGroup, pSSysPFPlugin);
            return;
        }
        super.onFillParentInfo(pSDEDRGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEDRGroup pSDEDRGroup, PSDataEntity pSDataEntity) throws Exception {
        pSDEDRGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDRGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEDRGroup pSDEDRGroup, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEDRGroup.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEDRGroup.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSDEDRGroup pSDEDRGroup, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEDRGroup.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEDRGroup.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCounter(PSDEDRGroup pSDEDRGroup, PSSysCounter pSSysCounter) throws Exception {
        pSDEDRGroup.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSDEDRGroup.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEDRGroup pSDEDRGroup, PSSysImage pSSysImage) throws Exception {
        pSDEDRGroup.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEDRGroup.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_HeaderPSSysPFPlugin(PSDEDRGroup pSDEDRGroup, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEDRGroup.setHeaderPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEDRGroup.setHeaderPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillEntityFullInfo(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
        if (bl && pSDEDRGroup.getCodeName() == null) {
            pSDEDRGroup.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DRGroup", 25));
        }
        super.onFillEntityFullInfo(pSDEDRGroup, bl);
        this.onFillEntityFullInfo_PSDE(pSDEDRGroup, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEDRGroup, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSDEDRGroup, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSDEDRGroup, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEDRGroup, bl);
        this.onFillEntityFullInfo_HeaderPSSysPFPlugin(pSDEDRGroup, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
        if (pSDEDRGroup.isPSDEIdDirty()) {
            if (pSDEDRGroup.getPSDEId() != null) {
                if (pSDEDRGroup.getPSDEId() == null || pSDEDRGroup.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEDRGroup.getPSDE();
                    pSDEDRGroup.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEDRGroup.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
        if (pSDEDRGroup.isCapPSLanResIdDirty()) {
            if (pSDEDRGroup.getCapPSLanResId() != null) {
                if (pSDEDRGroup.getCapPSLanResId() == null || pSDEDRGroup.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEDRGroup.getCapPSLanRes();
                    pSDEDRGroup.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEDRGroup.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
        if (pSDEDRGroup.isTipPSLanResIdDirty()) {
            if (pSDEDRGroup.getTipPSLanResId() != null) {
                if (pSDEDRGroup.getTipPSLanResId() == null || pSDEDRGroup.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEDRGroup.getTipPSLanRes();
                    pSDEDRGroup.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEDRGroup.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_HeaderPSSysPFPlugin(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEDRGroup, bl);
    }

    public ArrayList<PSDEDRGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDRGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDRGroup> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDRGroup> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEDRGroup> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEDRGroup> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRGroup> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEDRGroup> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEDRGroup> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTipPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTipPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRGroup> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSDEDRGroup> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSDEDRGroup> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCOUNTERID", (Object)pSSysCounterBase.getPSSysCounterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCounterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCounterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRGroup> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEDRGroup> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEDRGroup> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDRGroup> selectByHeaderPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByHeaderPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEDRGroup> selectByHeaderPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByHeaderPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEDRGroup> selectByHeaderPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("HEADERPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByHeaderPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByHeaderPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            PSDEDRGroup pSDEDRGroup2 = (PSDEDRGroup)this.getDEModel().createEntity();
            pSDEDRGroup2.setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
            pSDEDRGroup2.setPSDEId(null);
            this.update(pSDEDRGroup2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRGroupServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEDRGroupServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEDRGroupServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            this.remove(pSDEDRGroup);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRGROUP_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEDRGROUP", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            PSDEDRGroup pSDEDRGroup2 = (PSDEDRGroup)this.getDEModel().createEntity();
            pSDEDRGroup2.setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
            pSDEDRGroup2.setCapPSLanResId(null);
            this.update(pSDEDRGroup2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRGroupServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEDRGroupServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEDRGroupServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            this.remove(pSDEDRGroup);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRGROUP_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSDEDRGROUP", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            PSDEDRGroup pSDEDRGroup2 = (PSDEDRGroup)this.getDEModel().createEntity();
            pSDEDRGroup2.setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
            pSDEDRGroup2.setTipPSLanResId(null);
            this.update(pSDEDRGroup2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRGroupServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEDRGroupServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEDRGroupServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            this.remove(pSDEDRGroup);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRGROUP_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSDEDRGROUP", iDataEntityModel.getDataInfo(pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            PSDEDRGroup pSDEDRGroup2 = (PSDEDRGroup)this.getDEModel().createEntity();
            pSDEDRGroup2.setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
            pSDEDRGroup2.setPSSysCounterId(null);
            this.update(pSDEDRGroup2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRGroupServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSDEDRGroupServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSDEDRGroupServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            this.remove(pSDEDRGroup);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            PSDEDRGroup pSDEDRGroup2 = (PSDEDRGroup)this.getDEModel().createEntity();
            pSDEDRGroup2.setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
            pSDEDRGroup2.setPSSysImageId(null);
            this.update(pSDEDRGroup2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRGroupServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEDRGroupServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEDRGroupServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            this.remove(pSDEDRGroup);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    public void testRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByHeaderPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDRGROUP_PSSYSPFPLUGIN_HEADERPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEDRGROUP", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByHeaderPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            PSDEDRGroup pSDEDRGroup2 = (PSDEDRGroup)this.getDEModel().createEntity();
            pSDEDRGroup2.setPSDEDRGroupId(pSDEDRGroup.getPSDEDRGroupId());
            pSDEDRGroup2.setHeaderPSSysPFPluginId(null);
            this.update(pSDEDRGroup2);
        }
    }

    public void removeByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDRGroupServiceBase.this.onBeforeRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDRGroupServiceBase.this.internalRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDRGroupServiceBase.this.onAfterRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDRGroup> arrayList = this.selectByHeaderPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEDRGroup pSDEDRGroup : arrayList) {
            this.remove(pSDEDRGroup);
        }
        this.onAfterRemoveByHeaderPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByHeaderPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDRGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDRGroup pSDEDRGroup) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDRGroup(pSDEDRGroup);
        pSCoreSysServiceBase = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDRGroup(pSDEDRGroup);
        super.onBeforeRemove(pSDEDRGroup);
    }

    protected void replaceParentInfo(PSDEDRGroup pSDEDRGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEDRGroup, cloneSession);
        if (pSDEDRGroup.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDRGroup.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEDRGroup, (PSDataEntity)iEntity);
        }
        if (pSDEDRGroup.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEDRGroup.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEDRGroup, (PSLanguageRes)iEntity);
        }
        if (pSDEDRGroup.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEDRGroup.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSDEDRGroup, (PSLanguageRes)iEntity);
        }
        if (pSDEDRGroup.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSDEDRGroup.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSDEDRGroup, (PSSysCounter)iEntity);
        }
        if (pSDEDRGroup.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEDRGroup.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEDRGroup, (PSSysImage)iEntity);
        }
        if (pSDEDRGroup.getHeaderPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEDRGroup.getHeaderPSSysPFPluginId())) != null) {
            this.onFillParentInfo_HeaderPSSysPFPlugin(pSDEDRGroup, (PSSysPFPlugin)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEDRGroup, bl);
        pSDEDRGroup.resetCodeName();
    }

    protected void onCheckEntity(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEDRGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterId(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTag2(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderPSSysPFPluginId(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HiddenFlag(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRGroupId(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRGroupName(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDRGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEDRGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isCapPSLanResIdDirty() : !pSDEDRGroup.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isCapPSLanResNameDirty() : !pSDEDRGroup.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isCodeNameDirty() : !pSDEDRGroup.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEDRGroupDEModel(), "CODENAME", string3, pSDEDRGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CounterId(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isCounterIdDirty() : !pSDEDRGroup.isCounterIdDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CounterId_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isDynaModelFlagDirty() : !pSDEDRGroup.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEDRGroup.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEDRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupTag(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isGroupTagDirty() : !pSDEDRGroup.isGroupTagDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getGroupTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTag2(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isGroupTag2Dirty() : !pSDEDRGroup.isGroupTag2Dirty()) {
            return null;
        }
        String string = pSDEDRGroup.getGroupTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTag2_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderPSSysPFPluginId(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isHeaderPSSysPFPluginIdDirty() : !pSDEDRGroup.isHeaderPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getHeaderPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderPSSysPFPluginId_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HiddenFlag(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isHiddenFlagDirty() : !pSDEDRGroup.isHiddenFlagDirty()) {
            return null;
        }
        Integer n = pSDEDRGroup.getHiddenFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HiddenFlag_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HIDDENFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isLockFlagDirty() : !pSDEDRGroup.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEDRGroup.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEDRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isMemoDirty() : !pSDEDRGroup.isMemoDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEDRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isOrderValueDirty() : !pSDEDRGroup.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEDRGroup.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDRGroupId(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isPSDEDRGroupIdDirty() && !bl2 : !pSDEDRGroup.isPSDEDRGroupIdDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getPSDEDRGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRGroupId_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDRGroupName(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isPSDEDRGroupNameDirty() && !bl2 : !pSDEDRGroup.isPSDEDRGroupNameDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getPSDEDRGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRGROUPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRGroupName_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRGROUPNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSDEDRGroupDEModel(), "PSDEDRGROUPNAME", string3, pSDEDRGroup, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDRGROUPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isPSDEIdDirty() && !bl2 : !pSDEDRGroup.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEDRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isPSDENameDirty() && !bl2 : !pSDEDRGroup.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEDRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isPSDynaInstIdDirty() : !pSDEDRGroup.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEDRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isPSSysCounterIdDirty() : !pSDEDRGroup.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCOUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isPSSysImageIdDirty() : !pSDEDRGroup.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isSRFSysPubDirty() : !pSDEDRGroup.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSDEDRGroup.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFSYSPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isTipPSLanResIdDirty() : !pSDEDRGroup.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isTipPSLanResNameDirty() : !pSDEDRGroup.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isTooltipInfoDirty() : !pSDEDRGroup.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLTIPINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isUserCatDirty() : !pSDEDRGroup.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEDRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isUserParamsDirty() : !pSDEDRGroup.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDEDRGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isUserTagDirty() : !pSDEDRGroup.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDRGroup.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEDRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isUserTag2Dirty() : !pSDEDRGroup.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDRGroup.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEDRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isUserTag3Dirty() : !pSDEDRGroup.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDRGroup.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEDRGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDRGroup pSDEDRGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDRGroup.isUserTag4Dirty() : !pSDEDRGroup.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDRGroup.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEDRGroup, bl2, bl3);
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

    protected void onSyncEntity(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
        super.onSyncEntity(pSDEDRGroup, bl);
    }

    protected void onSyncIndexEntities(PSDEDRGroup pSDEDRGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEDRGroup, bl);
    }

    public Object getDataContextValue(PSDEDRGroup pSDEDRGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEDRGroup, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDEDRGroup pSDEDRGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEDRGroup, arrayList, n);
        super.onExportMajorModel(pSDEDRGroup, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEDRGroup pSDEDRGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEDRGroup.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEDRGroup.getCapPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HIDDENFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HiddenFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TooltipInfo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COUNTERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HeaderPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HeaderPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HiddenFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDRGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysCounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCounterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SRFSysPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TipPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TooltipInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLTIPINFO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEDRGroup pSDEDRGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEDRGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDRGroup pSDEDRGroup) throws Exception {
        Object object = pSDEDRGroup.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDRGROUP_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEDRGroup);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEDRGroup pSDEDRGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDRGROUP");
        if (!bl) {
            pSDEDRGroup.setCreateDate(null);
            pSDEDRGroup.setCreateMan(null);
            pSDEDRGroup.setPSDEDRGroupId(null);
            pSDEDRGroup.setUpdateDate(null);
            pSDEDRGroup.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDRGroup, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDRGroup pSDEDRGroup, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDRGroup, string);
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
            return "DER1N_PSDEDRGROUP_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEDRGroup pSDEDRGroup) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDRGroup.getCodeName())) {
            return pSDEDRGroup.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDRGroup.getPSDEDRGroupName())) {
            return pSDEDRGroup.getPSDEDRGroupName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDRGroup.getCodeName())) {
            return pSDEDRGroup.getCodeName();
        }
        return super.getModelV2Tag(pSDEDRGroup);
    }

    @Override
    public boolean setModelV2Tag(PSDEDRGroup pSDEDRGroup, String string) {
        pSDEDRGroup.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSDEDRGROUPNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEDRGROUPNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDRGroup pSDEDRGroup, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDRGroup.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDRGroup, true);
        pSDEDRGroup.set("CODENAME", string);
        if (this.select(pSDEDRGroup, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDRGroup, true);
        return super.getModelV2Entity(pSDEDRGroup, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDRGroup pSDEDRGroup, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDRGroup, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEDRGroup pSDEDRGroup, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DRGroup");
    }
}

