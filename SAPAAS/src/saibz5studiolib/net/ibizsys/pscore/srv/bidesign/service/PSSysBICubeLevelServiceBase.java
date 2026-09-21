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
package net.ibizsys.pscore.srv.bidesign.service;

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
import net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeLevelDAO;
import net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeLevelDEModel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimensionBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeLevel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIHierarchy;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIHierarchyBase;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBILevel;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBILevelBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggColumnServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeLevelServiceBase
extends PSCoreSysServiceBase<PSSysBICubeLevel> {
    private static final Log log = LogFactory.getLog(PSSysBICubeLevelServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysBICubeLevelDEModel pSSysBICubeLevelDEModel;
    private PSSysBICubeLevelDAO pSSysBICubeLevelDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeLevelService";
    }

    public PSSysBICubeLevelDEModel getPSSysBICubeLevelDEModel() {
        if (this.pSSysBICubeLevelDEModel == null) {
            try {
                this.pSSysBICubeLevelDEModel = (PSSysBICubeLevelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.bidesign.demodel.PSSysBICubeLevelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeLevelDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysBICubeLevelDEModel();
    }

    public PSSysBICubeLevelDAO getPSSysBICubeLevelDAO() {
        if (this.pSSysBICubeLevelDAO == null) {
            try {
                this.pSSysBICubeLevelDAO = (PSSysBICubeLevelDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.bidesign.dao.PSSysBICubeLevelDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysBICubeLevelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysBICubeLevelDAO();
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

    protected void onFillParentInfo(PSSysBICubeLevel pSSysBICubeLevel, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBELEVEL_PSDEFIELD_PSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_PSDEF(pSSysBICubeLevel, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBELEVEL_PSSYSBICUBEDIMENSION_PSSYSBICUBEDIMENSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService", (SessionFactory)this.getSessionFactory());
            PSSysBICubeDimension pSSysBICubeDimension = (PSSysBICubeDimension)iService.getDEModel().createEntity();
            pSSysBICubeDimension.set("PSSYSBICUBEDIMENSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBICubeDimension);
            } else {
                iService.get((IEntity)pSSysBICubeDimension);
            }
            this.onFillParentInfo_PSSysBICubeDimension(pSSysBICubeLevel, pSSysBICubeDimension);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBELEVEL_PSSYSBIHIERARCHY_PSSYSBIHIERARCHYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyService", (SessionFactory)this.getSessionFactory());
            PSSysBIHierarchy pSSysBIHierarchy = (PSSysBIHierarchy)iService.getDEModel().createEntity();
            pSSysBIHierarchy.set("PSSYSBIHIERARCHYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBIHierarchy);
            } else {
                iService.get((IEntity)pSSysBIHierarchy);
            }
            this.onFillParentInfo_PSSysBIHierarchy(pSSysBICubeLevel, pSSysBIHierarchy);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSBICUBELEVEL_PSSYSBILEVEL_PSSYSBILEVELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBILevelService", (SessionFactory)this.getSessionFactory());
            PSSysBILevel pSSysBILevel = (PSSysBILevel)iService.getDEModel().createEntity();
            pSSysBILevel.set("PSSYSBILEVELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysBILevel);
            } else {
                iService.get((IEntity)pSSysBILevel);
            }
            this.onFillParentInfo_PSSysBILevel(pSSysBICubeLevel, pSSysBILevel);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysBICubeLevel, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEF(PSSysBICubeLevel pSSysBICubeLevel, PSDEField pSDEField) throws Exception {
        pSSysBICubeLevel.setPSDEFId(pSDEField.getPSDEFieldId());
        pSSysBICubeLevel.setPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSSysBICubeDimension(PSSysBICubeLevel pSSysBICubeLevel, PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        pSSysBICubeLevel.setPSDEId(pSSysBICubeDimension.getPSDEId());
        pSSysBICubeLevel.setPSSysBICubeDimensionId(pSSysBICubeDimension.getPSSysBICubeDimensionId());
        pSSysBICubeLevel.setPSSysBICubeDimensionName(pSSysBICubeDimension.getPSSysBICubeDimensionName());
        pSSysBICubeLevel.setPSSysBIDimensionId(pSSysBICubeDimension.getPSSysBIDimensionId());
    }

    protected void onFillParentInfo_PSSysBIHierarchy(PSSysBICubeLevel pSSysBICubeLevel, PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        pSSysBICubeLevel.setPSSysBIHierarchyId(pSSysBIHierarchy.getPSSysBIHierarchyId());
        pSSysBICubeLevel.setPSSysBIHierarchyName(pSSysBIHierarchy.getPSSysBIHierarchyName());
    }

    protected void onFillParentInfo_PSSysBILevel(PSSysBICubeLevel pSSysBICubeLevel, PSSysBILevel pSSysBILevel) throws Exception {
        pSSysBICubeLevel.setPSSysBILevelId(pSSysBILevel.getPSSysBILevelId());
        pSSysBICubeLevel.setPSSysBILevelName(pSSysBILevel.getPSSysBILevelName());
    }

    protected void onFillEntityFullInfo(PSSysBICubeLevel pSSysBICubeLevel, boolean bl) throws Exception {
        if (bl) {
            if (pSSysBICubeLevel.getCodeName() == null) {
                pSSysBICubeLevel.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DimensionLevel", 25));
            }
            if (pSSysBICubeLevel.getValidFlag() == null) {
                pSSysBICubeLevel.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysBICubeLevel, bl);
        this.onFillEntityFullInfo_PSDEF(pSSysBICubeLevel, bl);
        this.onFillEntityFullInfo_PSSysBICubeDimension(pSSysBICubeLevel, bl);
        this.onFillEntityFullInfo_PSSysBIHierarchy(pSSysBICubeLevel, bl);
        this.onFillEntityFullInfo_PSSysBILevel(pSSysBICubeLevel, bl);
    }

    protected void onFillEntityFullInfo_PSDEF(PSSysBICubeLevel pSSysBICubeLevel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBICubeDimension(PSSysBICubeLevel pSSysBICubeLevel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBIHierarchy(PSSysBICubeLevel pSSysBICubeLevel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysBILevel(PSSysBICubeLevel pSSysBICubeLevel, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysBICubeLevel pSSysBICubeLevel, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysBICubeLevel, bl);
    }

    public ArrayList<PSSysBICubeLevel> selectByPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSSysBICubeLevel> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSSysBICubeLevel> selectByPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeLevel> selectByPSSysBICubeDimension(PSSysBICubeDimensionBase pSSysBICubeDimensionBase) throws Exception {
        return this.selectByPSSysBICubeDimension(pSSysBICubeDimensionBase, "", -1);
    }

    public ArrayList<PSSysBICubeLevel> selectByPSSysBICubeDimension(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, String string) throws Exception {
        return this.selectByPSSysBICubeDimension(pSSysBICubeDimensionBase, string, -1);
    }

    public ArrayList<PSSysBICubeLevel> selectByPSSysBICubeDimension(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBICUBEDIMENSIONID", (Object)pSSysBICubeDimensionBase.getPSSysBICubeDimensionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBICubeDimensionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBICubeDimensionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeLevel> selectByPSSysBIHierarchy(PSSysBIHierarchyBase pSSysBIHierarchyBase) throws Exception {
        return this.selectByPSSysBIHierarchy(pSSysBIHierarchyBase, "", -1);
    }

    public ArrayList<PSSysBICubeLevel> selectByPSSysBIHierarchy(PSSysBIHierarchyBase pSSysBIHierarchyBase, String string) throws Exception {
        return this.selectByPSSysBIHierarchy(pSSysBIHierarchyBase, string, -1);
    }

    public ArrayList<PSSysBICubeLevel> selectByPSSysBIHierarchy(PSSysBIHierarchyBase pSSysBIHierarchyBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBIHIERARCHYID", (Object)pSSysBIHierarchyBase.getPSSysBIHierarchyId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBIHierarchyCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBIHierarchyCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysBICubeLevel> selectByPSSysBILevel(PSSysBILevelBase pSSysBILevelBase) throws Exception {
        return this.selectByPSSysBILevel(pSSysBILevelBase, "", -1);
    }

    public ArrayList<PSSysBICubeLevel> selectByPSSysBILevel(PSSysBILevelBase pSSysBILevelBase, String string) throws Exception {
        return this.selectByPSSysBILevel(pSSysBILevelBase, string, -1);
    }

    public ArrayList<PSSysBICubeLevel> selectByPSSysBILevel(PSSysBILevelBase pSSysBILevelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSBILEVELID", (Object)pSSysBILevelBase.getPSSysBILevelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysBILevelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysBILevelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBELEVEL_PSDEFIELD_PSDEFID", "", iDataEntityModel.getName(), "PSSYSBICUBELEVEL", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSDEF(pSDEField);
        for (PSSysBICubeLevel pSSysBICubeLevel : arrayList) {
            PSSysBICubeLevel pSSysBICubeLevel2 = (PSSysBICubeLevel)this.getDEModel().createEntity();
            pSSysBICubeLevel2.setPSSysBICubeLevelId(pSSysBICubeLevel.getPSSysBICubeLevelId());
            pSSysBICubeLevel2.setPSDEFId(null);
            this.update(pSSysBICubeLevel2);
        }
    }

    public void removeByPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeLevelServiceBase.this.onBeforeRemoveByPSDEF(pSDEField2);
                PSSysBICubeLevelServiceBase.this.internalRemoveByPSDEF(pSDEField2);
                PSSysBICubeLevelServiceBase.this.onAfterRemoveByPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSDEF(pSDEField);
        this.onBeforeRemoveByPSDEF(pSDEField, arrayList);
        for (PSSysBICubeLevel pSSysBICubeLevel : arrayList) {
            this.remove((IEntity)pSSysBICubeLevel);
        }
        this.onAfterRemoveByPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBICubeLevel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEF(PSDEField pSDEField, ArrayList<PSSysBICubeLevel> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
    }

    public void resetPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSSysBICubeDimension(pSSysBICubeDimension);
        for (PSSysBICubeLevel pSSysBICubeLevel : arrayList) {
            PSSysBICubeLevel pSSysBICubeLevel2 = (PSSysBICubeLevel)this.getDEModel().createEntity();
            pSSysBICubeLevel2.setPSSysBICubeLevelId(pSSysBICubeLevel.getPSSysBICubeLevelId());
            pSSysBICubeLevel2.setPSSysBICubeDimensionId(null);
            this.update(pSSysBICubeLevel2);
        }
    }

    public void removeByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        final PSSysBICubeDimension pSSysBICubeDimension2 = pSSysBICubeDimension;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeLevelServiceBase.this.onBeforeRemoveByPSSysBICubeDimension(pSSysBICubeDimension2);
                PSSysBICubeLevelServiceBase.this.internalRemoveByPSSysBICubeDimension(pSSysBICubeDimension2);
                PSSysBICubeLevelServiceBase.this.onAfterRemoveByPSSysBICubeDimension(pSSysBICubeDimension2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
    }

    protected void internalRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSSysBICubeDimension(pSSysBICubeDimension);
        this.onBeforeRemoveByPSSysBICubeDimension(pSSysBICubeDimension, arrayList);
        for (PSSysBICubeLevel pSSysBICubeLevel : arrayList) {
            this.remove((IEntity)pSSysBICubeLevel);
        }
        this.onAfterRemoveByPSSysBICubeDimension(pSSysBICubeDimension, arrayList);
    }

    protected void onAfterRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension, ArrayList<PSSysBICubeLevel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBICubeDimension(PSSysBICubeDimension pSSysBICubeDimension, ArrayList<PSSysBICubeLevel> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSSysBIHierarchy(pSSysBIHierarchy, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBIHIERARCHY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBIHierarchy);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBELEVEL_PSSYSBIHIERARCHY_PSSYSBIHIERARCHYID", "", iDataEntityModel.getName(), "PSSYSBICUBELEVEL", iDataEntityModel.getDataInfo((IEntity)pSSysBIHierarchy), arrayList.get(0)));
        }
    }

    public void resetPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSSysBIHierarchy(pSSysBIHierarchy);
        for (PSSysBICubeLevel pSSysBICubeLevel : arrayList) {
            PSSysBICubeLevel pSSysBICubeLevel2 = (PSSysBICubeLevel)this.getDEModel().createEntity();
            pSSysBICubeLevel2.setPSSysBICubeLevelId(pSSysBICubeLevel.getPSSysBICubeLevelId());
            pSSysBICubeLevel2.setPSSysBIHierarchyId(null);
            this.update(pSSysBICubeLevel2);
        }
    }

    public void removeByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        final PSSysBIHierarchy pSSysBIHierarchy2 = pSSysBIHierarchy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeLevelServiceBase.this.onBeforeRemoveByPSSysBIHierarchy(pSSysBIHierarchy2);
                PSSysBICubeLevelServiceBase.this.internalRemoveByPSSysBIHierarchy(pSSysBIHierarchy2);
                PSSysBICubeLevelServiceBase.this.onAfterRemoveByPSSysBIHierarchy(pSSysBIHierarchy2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
    }

    protected void internalRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSSysBIHierarchy(pSSysBIHierarchy);
        this.onBeforeRemoveByPSSysBIHierarchy(pSSysBIHierarchy, arrayList);
        for (PSSysBICubeLevel pSSysBICubeLevel : arrayList) {
            this.remove((IEntity)pSSysBICubeLevel);
        }
        this.onAfterRemoveByPSSysBIHierarchy(pSSysBIHierarchy, arrayList);
    }

    protected void onAfterRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy, ArrayList<PSSysBICubeLevel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBIHierarchy(PSSysBIHierarchy pSSysBIHierarchy, ArrayList<PSSysBICubeLevel> arrayList) throws Exception {
    }

    public void testRemoveByPSSysBILevel(PSSysBILevel pSSysBILevel) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSSysBILevel(pSSysBILevel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSBILEVEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysBILevel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSBICUBELEVEL_PSSYSBILEVEL_PSSYSBILEVELID", "", iDataEntityModel.getName(), "PSSYSBICUBELEVEL", iDataEntityModel.getDataInfo((IEntity)pSSysBILevel), arrayList.get(0)));
        }
    }

    public void resetPSSysBILevel(PSSysBILevel pSSysBILevel) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSSysBILevel(pSSysBILevel);
        for (PSSysBICubeLevel pSSysBICubeLevel : arrayList) {
            PSSysBICubeLevel pSSysBICubeLevel2 = (PSSysBICubeLevel)this.getDEModel().createEntity();
            pSSysBICubeLevel2.setPSSysBICubeLevelId(pSSysBICubeLevel.getPSSysBICubeLevelId());
            pSSysBICubeLevel2.setPSSysBILevelId(null);
            this.update(pSSysBICubeLevel2);
        }
    }

    public void removeByPSSysBILevel(PSSysBILevel pSSysBILevel) throws Exception {
        final PSSysBILevel pSSysBILevel2 = pSSysBILevel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysBICubeLevelServiceBase.this.onBeforeRemoveByPSSysBILevel(pSSysBILevel2);
                PSSysBICubeLevelServiceBase.this.internalRemoveByPSSysBILevel(pSSysBILevel2);
                PSSysBICubeLevelServiceBase.this.onAfterRemoveByPSSysBILevel(pSSysBILevel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysBILevel(PSSysBILevel pSSysBILevel) throws Exception {
    }

    protected void internalRemoveByPSSysBILevel(PSSysBILevel pSSysBILevel) throws Exception {
        ArrayList<PSSysBICubeLevel> arrayList = this.selectByPSSysBILevel(pSSysBILevel);
        this.onBeforeRemoveByPSSysBILevel(pSSysBILevel, arrayList);
        for (PSSysBICubeLevel pSSysBICubeLevel : arrayList) {
            this.remove((IEntity)pSSysBICubeLevel);
        }
        this.onAfterRemoveByPSSysBILevel(pSSysBILevel, arrayList);
    }

    protected void onAfterRemoveByPSSysBILevel(PSSysBILevel pSSysBILevel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysBILevel(PSSysBILevel pSSysBILevel, ArrayList<PSSysBICubeLevel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysBILevel(PSSysBILevel pSSysBILevel, ArrayList<PSSysBICubeLevel> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysBIAggColumnService)ServiceGlobal.getService(PSSysBIAggColumnService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIAggColumnServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICubeLevel(pSSysBICubeLevel);
        pSCoreSysServiceBase = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysBICubeLevel(pSSysBICubeLevel);
        super.onBeforeRemove(pSSysBICubeLevel);
    }

    protected void replaceParentInfo(PSSysBICubeLevel pSSysBICubeLevel, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysBICubeLevel, cloneSession);
        if (pSSysBICubeLevel.getPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSSysBICubeLevel.getPSDEFId())) != null) {
            this.onFillParentInfo_PSDEF(pSSysBICubeLevel, (PSDEField)iEntity);
        }
        if (pSSysBICubeLevel.getPSSysBICubeDimensionId() != null && (iEntity = cloneSession.getEntity("PSSYSBICUBEDIMENSION", (Object)pSSysBICubeLevel.getPSSysBICubeDimensionId())) != null) {
            this.onFillParentInfo_PSSysBICubeDimension(pSSysBICubeLevel, (PSSysBICubeDimension)iEntity);
        }
        if (pSSysBICubeLevel.getPSSysBIHierarchyId() != null && (iEntity = cloneSession.getEntity("PSSYSBIHIERARCHY", (Object)pSSysBICubeLevel.getPSSysBIHierarchyId())) != null) {
            this.onFillParentInfo_PSSysBIHierarchy(pSSysBICubeLevel, (PSSysBIHierarchy)iEntity);
        }
        if (pSSysBICubeLevel.getPSSysBILevelId() != null && (iEntity = cloneSession.getEntity("PSSYSBILEVEL", (Object)pSSysBICubeLevel.getPSSysBILevelId())) != null) {
            this.onFillParentInfo_PSSysBILevel(pSSysBICubeLevel, (PSSysBILevel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysBICubeLevel pSSysBICubeLevel, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysBICubeLevel, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllLevelFlag(bl, pSSysBICubeLevel, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BICubeLevelTag(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BICubeLevelTag2(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFId(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeDimensionId(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeLevelId(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBICubeLevelName(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBIHierarchyId(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysBILevelId(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysBICubeLevel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysBICubeLevel, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllLevelFlag(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isAllLevelFlagDirty() : !pSSysBICubeLevel.isAllLevelFlagDirty()) {
            return null;
        }
        Integer n = pSSysBICubeLevel.getAllLevelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllLevelFlag_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLLEVELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BICubeLevelTag(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isBICubeLevelTagDirty() : !pSSysBICubeLevel.isBICubeLevelTagDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getBICubeLevelTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BICubeLevelTag_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BICUBELEVELTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BICubeLevelTag2(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isBICubeLevelTag2Dirty() : !pSSysBICubeLevel.isBICubeLevelTag2Dirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getBICubeLevelTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BICubeLevelTag2_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BICUBELEVELTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isCodeNameDirty() && !bl2 : !pSSysBICubeLevel.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
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
                string3 = "PSSYSBICUBEDIMENSIONID";
                String string4 = this.checkFieldDupRule(this.getPSSysBICubeLevelDEModel(), "CODENAME", string3, pSSysBICubeLevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isMemoDirty() : !pSSysBICubeLevel.isMemoDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFId(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isPSDEFIdDirty() : !pSSysBICubeLevel.isPSDEFIdDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFId_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeDimensionId(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isPSSysBICubeDimensionIdDirty() && !bl2 : !pSSysBICubeLevel.isPSSysBICubeDimensionIdDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getPSSysBICubeDimensionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEDIMENSIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeDimensionId_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBEDIMENSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeLevelId(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isPSSysBICubeLevelIdDirty() && !bl2 : !pSSysBICubeLevel.isPSSysBICubeLevelIdDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getPSSysBICubeLevelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBELEVELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeLevelId_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBELEVELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBICubeLevelName(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isPSSysBICubeLevelNameDirty() && !bl2 : !pSSysBICubeLevel.isPSSysBICubeLevelNameDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getPSSysBICubeLevelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBELEVELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBICubeLevelName_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBICUBELEVELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBIHierarchyId(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isPSSysBIHierarchyIdDirty() && !bl2 : !pSSysBICubeLevel.isPSSysBIHierarchyIdDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getPSSysBIHierarchyId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIHIERARCHYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBIHierarchyId_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBIHIERARCHYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysBILevelId(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isPSSysBILevelIdDirty() : !pSSysBICubeLevel.isPSSysBILevelIdDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getPSSysBILevelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysBILevelId_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSBILEVELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isUserCatDirty() : !pSSysBICubeLevel.isUserCatDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isUserTagDirty() : !pSSysBICubeLevel.isUserTagDirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isUserTag2Dirty() : !pSSysBICubeLevel.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isUserTag3Dirty() : !pSSysBICubeLevel.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isUserTag4Dirty() : !pSSysBICubeLevel.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysBICubeLevel.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysBICubeLevel pSSysBICubeLevel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysBICubeLevel.isValidFlagDirty() && !bl2 : !pSSysBICubeLevel.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysBICubeLevel.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysBICubeLevel, bl2, bl3);
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

    protected void onSyncEntity(PSSysBICubeLevel pSSysBICubeLevel, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysBICubeLevel, bl);
    }

    protected void onSyncIndexEntities(PSSysBICubeLevel pSSysBICubeLevel, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysBICubeLevel, bl);
    }

    public Object getDataContextValue(PSSysBICubeLevel pSSysBICubeLevel, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysBICubeLevel, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysBICubeLevel pSSysBICubeLevel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysBICubeLevel, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLLEVELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllLevelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BICUBELEVELTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BICubeLevelTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BICUBELEVELTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BICubeLevelTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEDIMENSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeDimensionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEDIMENSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeDimensionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBELEVELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeLevelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBELEVELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBICubeLevelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIDIMENSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIDimensionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIHIERARCHYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIHierarchyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBIHIERARCHYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBIHierarchyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBILEVELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBILevelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSBILEVELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysBILevelName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AllLevelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BICubeLevelTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BICUBELEVELTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BICubeLevelTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BICUBELEVELTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysBICubeDimensionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEDIMENSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeDimensionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBEDIMENSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeLevelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBELEVELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBICubeLevelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBICUBELEVELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIDimensionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIDIMENSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIHierarchyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIHIERARCHYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBIHierarchyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBIHIERARCHYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBILevelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBILEVELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysBILevelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSBILEVELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysBICubeLevel)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysBICubeLevel pSSysBICubeLevel) throws Exception {
        super.onUpdateParent((IEntity)pSSysBICubeLevel);
    }

    @Override
    protected void exportCurXmlModel(PSSysBICubeLevel pSSysBICubeLevel, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSBICUBELEVEL");
        if (!bl) {
            pSSysBICubeLevel.setCreateDate(null);
            pSSysBICubeLevel.setCreateMan(null);
            pSSysBICubeLevel.setPSSysBICubeLevelId(null);
            pSSysBICubeLevel.setUpdateDate(null);
            pSSysBICubeLevel.setUpdateMan(null);
            super.exportCurXmlModel(pSSysBICubeLevel, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysBICubeLevel pSSysBICubeLevel, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysBICubeLevel, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBICUBEDIMENSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSBICUBEDIMENSION#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBICUBEDIMENSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSBICUBELEVEL_PSSYSBICUBEDIMENSION_PSSYSBICUBEDIMENSIONID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBICUBEDIMENSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSBICUBEDIMENSIONNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSBICUBEDIMENSION", (boolean)true) == 0) {
            iEntity.set("PSSYSBICUBEDIMENSIONID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSBICUBEDIMENSIONID"};
    }

    @Override
    public String getModelV2Tag(PSSysBICubeLevel pSSysBICubeLevel) {
        if (!StringHelper.isNullOrEmpty((String)pSSysBICubeLevel.getCodeName())) {
            return pSSysBICubeLevel.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysBICubeLevel.getCodeName())) {
            return pSSysBICubeLevel.getCodeName();
        }
        return super.getModelV2Tag(pSSysBICubeLevel);
    }

    @Override
    public boolean setModelV2Tag(PSSysBICubeLevel pSSysBICubeLevel, String string) {
        pSSysBICubeLevel.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSBICUBEDIMENSIONID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysBICubeLevel pSSysBICubeLevel, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysBICubeLevel.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysBICubeLevel, true);
        pSSysBICubeLevel.set("CODENAME", string);
        if (this.select(pSSysBICubeLevel, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysBICubeLevel, true);
        return super.getModelV2Entity(pSSysBICubeLevel, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysBICubeLevel pSSysBICubeLevel, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysBICubeLevel, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysBICubeLevel pSSysBICubeLevel, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DimensionLevel");
    }
}

