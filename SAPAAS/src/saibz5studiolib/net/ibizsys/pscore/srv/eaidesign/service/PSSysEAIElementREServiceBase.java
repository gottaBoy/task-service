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
package net.ibizsys.pscore.srv.eaidesign.service;

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
import net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIElementREDAO;
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIElementREDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataType;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataTypeBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElement;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementRE;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEFieldService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEFieldServiceBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDERService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDERServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIElementREServiceBase
extends PSCoreSysServiceBase<PSSysEAIElementRE> {
    private static final Log log = LogFactory.getLog(PSSysEAIElementREServiceBase.class);
    public static final String DATASET_CURELEMENT = "CurElement";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysEAIElementREDEModel pSSysEAIElementREDEModel;
    private PSSysEAIElementREDAO pSSysEAIElementREDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREService";
    }

    public PSSysEAIElementREDEModel getPSSysEAIElementREDEModel() {
        if (this.pSSysEAIElementREDEModel == null) {
            try {
                this.pSSysEAIElementREDEModel = (PSSysEAIElementREDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIElementREDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIElementREDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysEAIElementREDEModel();
    }

    public PSSysEAIElementREDAO getPSSysEAIElementREDAO() {
        if (this.pSSysEAIElementREDAO == null) {
            try {
                this.pSSysEAIElementREDAO = (PSSysEAIElementREDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIElementREDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIElementREDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysEAIElementREDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURELEMENT, (boolean)true) == 0) {
            return this.fetchCurElement(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURELEMENT, (boolean)true) == 0) {
            return this.fetchTempCurElement(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurElement(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURELEMENT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurElement(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURELEMENT, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysEAIElementRE pSSysEAIElementRE, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIELEMENTRE_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeService", (SessionFactory)this.getSessionFactory());
            PSSysEAIDataType pSSysEAIDataType = (PSSysEAIDataType)iService.getDEModel().createEntity();
            pSSysEAIDataType.set("PSSYSEAIDATATYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIDataType);
            } else {
                iService.get((IEntity)pSSysEAIDataType);
            }
            this.onFillParentInfo_PSSysEAIDataType(pSSysEAIElementRE, pSSysEAIDataType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIELEMENTRE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService", (SessionFactory)this.getSessionFactory());
            PSSysEAIElement pSSysEAIElement = (PSSysEAIElement)iService.getDEModel().createEntity();
            pSSysEAIElement.set("PSSYSEAIELEMENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIElement);
            } else {
                iService.get((IEntity)pSSysEAIElement);
            }
            this.onFillParentInfo_PSSysEAIElement(pSSysEAIElementRE, pSSysEAIElement);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIELEMENTRE_PSSYSEAIELEMENT_REFPSSYSEAIELEMENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService", (SessionFactory)this.getSessionFactory());
            PSSysEAIElement pSSysEAIElement = (PSSysEAIElement)iService.getDEModel().createEntity();
            pSSysEAIElement.set("PSSYSEAIELEMENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIElement);
            } else {
                iService.get((IEntity)pSSysEAIElement);
            }
            this.onFillParentInfo_RefPSSysEAIElement(pSSysEAIElementRE, pSSysEAIElement);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysEAIElementRE, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysEAIDataType(PSSysEAIElementRE pSSysEAIElementRE, PSSysEAIDataType pSSysEAIDataType) throws Exception {
        pSSysEAIElementRE.setPSSysEAIDataTypeId(pSSysEAIDataType.getPSSysEAIDataTypeId());
        pSSysEAIElementRE.setPSSysEAIDataTypeName(pSSysEAIDataType.getPSSysEAIDataTypeName());
    }

    protected void onFillParentInfo_PSSysEAIElement(PSSysEAIElementRE pSSysEAIElementRE, PSSysEAIElement pSSysEAIElement) throws Exception {
        pSSysEAIElementRE.setPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
        pSSysEAIElementRE.setPSSysEAIElementName(pSSysEAIElement.getPSSysEAIElementName());
        pSSysEAIElementRE.setPSSysEAISchemeId(pSSysEAIElement.getPSSysEAISchemeId());
    }

    protected void onFillParentInfo_RefPSSysEAIElement(PSSysEAIElementRE pSSysEAIElementRE, PSSysEAIElement pSSysEAIElement) throws Exception {
        pSSysEAIElementRE.setRefPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
        pSSysEAIElementRE.setRefPSSysEAIElementName(pSSysEAIElement.getPSSysEAIElementName());
    }

    protected void onFillEntityFullInfo(PSSysEAIElementRE pSSysEAIElementRE, boolean bl) throws Exception {
        if (bl) {
            if (pSSysEAIElementRE.getCodeName() == null) {
                pSSysEAIElementRE.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Element", 25));
            }
            if (pSSysEAIElementRE.getPSSysEAIElementREName() == null) {
                pSSysEAIElementRE.setPSSysEAIElementREName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5f15\u7528\u5143\u7d20", 25));
            }
            if (pSSysEAIElementRE.getValidFlag() == null) {
                pSSysEAIElementRE.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysEAIElementRE, bl);
        this.onFillEntityFullInfo_PSSysEAIDataType(pSSysEAIElementRE, bl);
        this.onFillEntityFullInfo_PSSysEAIElement(pSSysEAIElementRE, bl);
        this.onFillEntityFullInfo_RefPSSysEAIElement(pSSysEAIElementRE, bl);
    }

    protected void onFillEntityFullInfo_PSSysEAIDataType(PSSysEAIElementRE pSSysEAIElementRE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEAIElement(PSSysEAIElementRE pSSysEAIElementRE, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSSysEAIElement(PSSysEAIElementRE pSSysEAIElementRE, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysEAIElementRE pSSysEAIElementRE, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysEAIElementRE, bl);
    }

    public ArrayList<PSSysEAIElementRE> selectByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase) throws Exception {
        return this.selectByPSSysEAIDataType(pSSysEAIDataTypeBase, "", -1);
    }

    public ArrayList<PSSysEAIElementRE> selectByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, String string) throws Exception {
        return this.selectByPSSysEAIDataType(pSSysEAIDataTypeBase, string, -1);
    }

    public ArrayList<PSSysEAIElementRE> selectByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIDATATYPEID", (Object)pSSysEAIDataTypeBase.getPSSysEAIDataTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAIDataTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAIDataTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIElementRE> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase) throws Exception {
        return this.selectByPSSysEAIElement(pSSysEAIElementBase, "", -1);
    }

    public ArrayList<PSSysEAIElementRE> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string) throws Exception {
        return this.selectByPSSysEAIElement(pSSysEAIElementBase, string, -1);
    }

    public ArrayList<PSSysEAIElementRE> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIELEMENTID", (Object)pSSysEAIElementBase.getPSSysEAIElementId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEAIElementCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEAIElementCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIElementRE> selectTempByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase) throws Exception {
        return this.selectTempByPSSysEAIElement(pSSysEAIElementBase, "");
    }

    public ArrayList<PSSysEAIElementRE> selectTempByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIELEMENTID", (Object)pSSysEAIElementBase.getPSSysEAIElementId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysEAIElementCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysEAIElementCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIElementRE> selectByRefPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase) throws Exception {
        return this.selectByRefPSSysEAIElement(pSSysEAIElementBase, "", -1);
    }

    public ArrayList<PSSysEAIElementRE> selectByRefPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string) throws Exception {
        return this.selectByRefPSSysEAIElement(pSSysEAIElementBase, string, -1);
    }

    public ArrayList<PSSysEAIElementRE> selectByRefPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSSYSEAIELEMENTID", (Object)pSSysEAIElementBase.getPSSysEAIElementId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSSysEAIElementCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSSysEAIElementCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.selectByPSSysEAIDataType(pSSysEAIDataType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAIDATATYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEAIDataType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIELEMENTRE_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID", "", iDataEntityModel.getName(), "PSSYSEAIELEMENTRE", iDataEntityModel.getDataInfo((IEntity)pSSysEAIDataType), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.selectByPSSysEAIDataType(pSSysEAIDataType);
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            PSSysEAIElementRE pSSysEAIElementRE2 = (PSSysEAIElementRE)this.getDEModel().createEntity();
            pSSysEAIElementRE2.setPSSysEAIElementREId(pSSysEAIElementRE.getPSSysEAIElementREId());
            pSSysEAIElementRE2.setPSSysEAIDataTypeId(null);
            this.update(pSSysEAIElementRE2);
        }
    }

    public void removeByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        final PSSysEAIDataType pSSysEAIDataType2 = pSSysEAIDataType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIElementREServiceBase.this.onBeforeRemoveByPSSysEAIDataType(pSSysEAIDataType2);
                PSSysEAIElementREServiceBase.this.internalRemoveByPSSysEAIDataType(pSSysEAIDataType2);
                PSSysEAIElementREServiceBase.this.onAfterRemoveByPSSysEAIDataType(pSSysEAIDataType2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
    }

    protected void internalRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.selectByPSSysEAIDataType(pSSysEAIDataType);
        this.onBeforeRemoveByPSSysEAIDataType(pSSysEAIDataType, arrayList);
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            this.remove((IEntity)pSSysEAIElementRE);
        }
        this.onAfterRemoveByPSSysEAIDataType(pSSysEAIDataType, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType, ArrayList<PSSysEAIElementRE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType, ArrayList<PSSysEAIElementRE> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    public void resetPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.selectByPSSysEAIElement(pSSysEAIElement);
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            PSSysEAIElementRE pSSysEAIElementRE2 = (PSSysEAIElementRE)this.getDEModel().createEntity();
            pSSysEAIElementRE2.setPSSysEAIElementREId(pSSysEAIElementRE.getPSSysEAIElementREId());
            pSSysEAIElementRE2.setPSSysEAIElementId(null);
            this.update(pSSysEAIElementRE2);
        }
    }

    public void resetTempPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.selectTempByPSSysEAIElement(pSSysEAIElement);
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            PSSysEAIElementRE pSSysEAIElementRE2 = (PSSysEAIElementRE)this.getDEModel().createEntity();
            pSSysEAIElementRE2.setPSSysEAIElementREId(pSSysEAIElementRE.getPSSysEAIElementREId());
            pSSysEAIElementRE2.setPSSysEAIElementId(null);
            this.updateTemp((IEntity)pSSysEAIElementRE2);
        }
    }

    public void removeByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        final PSSysEAIElement pSSysEAIElement2 = pSSysEAIElement;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIElementREServiceBase.this.onBeforeRemoveByPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementREServiceBase.this.internalRemoveByPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementREServiceBase.this.onAfterRemoveByPSSysEAIElement(pSSysEAIElement2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void internalRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.selectByPSSysEAIElement(pSSysEAIElement);
        this.onBeforeRemoveByPSSysEAIElement(pSSysEAIElement, arrayList);
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            this.remove((IEntity)pSSysEAIElementRE);
        }
        this.onAfterRemoveByPSSysEAIElement(pSSysEAIElement, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementRE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementRE> arrayList) throws Exception {
    }

    public void testRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.selectByRefPSSysEAIElement(pSSysEAIElement, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAIELEMENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEAIElement);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIELEMENTRE_PSSYSEAIELEMENT_REFPSSYSEAIELEMENTID", "", iDataEntityModel.getName(), "PSSYSEAIELEMENTRE", iDataEntityModel.getDataInfo((IEntity)pSSysEAIElement), arrayList.get(0)));
        }
    }

    public void resetRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.selectByRefPSSysEAIElement(pSSysEAIElement);
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            PSSysEAIElementRE pSSysEAIElementRE2 = (PSSysEAIElementRE)this.getDEModel().createEntity();
            pSSysEAIElementRE2.setPSSysEAIElementREId(pSSysEAIElementRE.getPSSysEAIElementREId());
            pSSysEAIElementRE2.setRefPSSysEAIElementId(null);
            this.update(pSSysEAIElementRE2);
        }
    }

    public void removeByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        final PSSysEAIElement pSSysEAIElement2 = pSSysEAIElement;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIElementREServiceBase.this.onBeforeRemoveByRefPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementREServiceBase.this.internalRemoveByRefPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementREServiceBase.this.onAfterRemoveByRefPSSysEAIElement(pSSysEAIElement2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void internalRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.selectByRefPSSysEAIElement(pSSysEAIElement);
        this.onBeforeRemoveByRefPSSysEAIElement(pSSysEAIElement, arrayList);
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            this.remove((IEntity)pSSysEAIElementRE);
        }
        this.onAfterRemoveByRefPSSysEAIElement(pSSysEAIElement, arrayList);
    }

    protected void onAfterRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementRE> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementRE> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIDEFieldServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIElementRE(pSSysEAIElementRE);
        pSCoreSysServiceBase = (PSSysEAIDERService)ServiceGlobal.getService(PSSysEAIDERService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEAIDERServiceBase)pSCoreSysServiceBase).testRemoveByPSSysEAIElementRE(pSSysEAIElementRE);
        super.onBeforeRemove(pSSysEAIElementRE);
    }

    public void removeTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        final PSSysEAIElement pSSysEAIElement2 = pSSysEAIElement;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIElementREServiceBase.this.onBeforeRemoveTempByPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementREServiceBase.this.internalRemoveTempByPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementREServiceBase.this.onAfterRemoveTempByPSSysEAIElement(pSSysEAIElement2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void internalRemoveTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementRE> arrayList = this.selectTempByPSSysEAIElement(pSSysEAIElement);
        this.onBeforeRemoveTempByPSSysEAIElement(pSSysEAIElement, arrayList);
        for (PSSysEAIElementRE pSSysEAIElementRE : arrayList) {
            this.removeTemp((IEntity)pSSysEAIElementRE);
        }
        this.onAfterRemoveTempByPSSysEAIElement(pSSysEAIElement, arrayList);
    }

    protected void onAfterRemoveTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementRE> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementRE> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysEAIElementRE pSSysEAIElementRE, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysEAIElementRE, cloneSession);
        if (pSSysEAIElementRE.getPSSysEAIDataTypeId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIDATATYPE", (Object)pSSysEAIElementRE.getPSSysEAIDataTypeId())) != null) {
            this.onFillParentInfo_PSSysEAIDataType(pSSysEAIElementRE, (PSSysEAIDataType)iEntity);
        }
        if (pSSysEAIElementRE.getPSSysEAIElementId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIELEMENT", (Object)pSSysEAIElementRE.getPSSysEAIElementId())) != null) {
            this.onFillParentInfo_PSSysEAIElement(pSSysEAIElementRE, (PSSysEAIElement)iEntity);
        }
        if (pSSysEAIElementRE.getRefPSSysEAIElementId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIELEMENT", (Object)pSSysEAIElementRE.getRefPSSysEAIElementId())) != null) {
            this.onFillParentInfo_RefPSSysEAIElement(pSSysEAIElementRE, (PSSysEAIElement)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysEAIElementRE pSSysEAIElementRE, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysEAIElementRE, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysEAIElementRE, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIElementREType(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FixedValue(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxOccurs(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinOccurs(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDataTypeId(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementId(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementREId(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementREName(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSysEAIElementId(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RETag(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RETag2(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysEAIElementRE, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysEAIElementRE, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isCodeNameDirty() && !bl2 : !pSSysEAIElementRE.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
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
                string3 = "PSSYSEAIELEMENTID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIElementREDEModel(), "CODENAME", string3, pSSysEAIElementRE, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isDefaultValueDirty() : !pSSysEAIElementRE.isDefaultValueDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EAIElementREType(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isEAIElementRETypeDirty() && !bl2 : !pSSysEAIElementRE.isEAIElementRETypeDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getEAIElementREType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIELEMENTRETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIElementREType_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIELEMENTRETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FixedValue(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isFixedValueDirty() : !pSSysEAIElementRE.isFixedValueDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getFixedValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FixedValue_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIXEDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxOccurs(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isMaxOccursDirty() : !pSSysEAIElementRE.isMaxOccursDirty()) {
            return null;
        }
        Integer n = pSSysEAIElementRE.getMaxOccurs();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxOccurs_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXOCCURS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isMemoDirty() : !pSSysEAIElementRE.isMemoDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinOccurs(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isMinOccursDirty() : !pSSysEAIElementRE.isMinOccursDirty()) {
            return null;
        }
        Integer n = pSSysEAIElementRE.getMinOccurs();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MinOccurs_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINOCCURS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isOrderValueDirty() : !pSSysEAIElementRE.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysEAIElementRE.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEAIDataTypeId(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isPSSysEAIDataTypeIdDirty() : !pSSysEAIElementRE.isPSSysEAIDataTypeIdDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getPSSysEAIDataTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDataTypeId_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIDATATYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementId(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isPSSysEAIElementIdDirty() : !pSSysEAIElementRE.isPSSysEAIElementIdDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getPSSysEAIElementId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementId_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementREId(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isPSSysEAIElementREIdDirty() && !bl2 : !pSSysEAIElementRE.isPSSysEAIElementREIdDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getPSSysEAIElementREId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTREID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementREId_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTREID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementREName(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isPSSysEAIElementRENameDirty() && !bl2 : !pSSysEAIElementRE.isPSSysEAIElementRENameDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getPSSysEAIElementREName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTRENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementREName_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTRENAME");
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
                string3 = "PSSYSEAIELEMENTID";
                String string4 = this.checkFieldDupRule(this.getPSSysEAIElementREDEModel(), "PSSYSEAIELEMENTRENAME", string3, pSSysEAIElementRE, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSEAIELEMENTRENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSSysEAIElementId(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isRefPSSysEAIElementIdDirty() : !pSSysEAIElementRE.isRefPSSysEAIElementIdDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getRefPSSysEAIElementId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSysEAIElementId_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSSYSEAIELEMENTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RETag(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isRETagDirty() : !pSSysEAIElementRE.isRETagDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getRETag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RETag_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RETag2(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isRETag2Dirty() : !pSSysEAIElementRE.isRETag2Dirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getRETag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RETag2_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isUserCatDirty() : !pSSysEAIElementRE.isUserCatDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isUserTagDirty() : !pSSysEAIElementRE.isUserTagDirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isUserTag2Dirty() : !pSSysEAIElementRE.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isUserTag3Dirty() : !pSSysEAIElementRE.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isUserTag4Dirty() : !pSSysEAIElementRE.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysEAIElementRE.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysEAIElementRE pSSysEAIElementRE, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementRE.isValidFlagDirty() && !bl2 : !pSSysEAIElementRE.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysEAIElementRE.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysEAIElementRE, bl2, bl3);
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

    protected void onSyncEntity(PSSysEAIElementRE pSSysEAIElementRE, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysEAIElementRE, bl);
    }

    protected void onSyncIndexEntities(PSSysEAIElementRE pSSysEAIElementRE, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysEAIElementRE, bl);
    }

    public Object getDataContextValue(PSSysEAIElementRE pSSysEAIElementRE, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysEAIElementRE, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysEAIElement pSSysEAIElement = pSSysEAIElementRE.getPSSysEAIElement();
        if (pSSysEAIElement != null && pSSysEAIElement.contains(string)) {
            return pSSysEAIElement.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysEAIElementRE pSSysEAIElementRE, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysEAIElementRE, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIELEMENTRETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIElementREType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIXEDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FixedValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXOCCURS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxOccurs_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINOCCURS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinOccurs_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDATATYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDataTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIDATATYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIDataTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTREID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementREId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTRENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementREName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAISCHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAISchemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSEAIELEMENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysEAIElementId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSSYSEAIELEMENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSSysEAIElementName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RETag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RETag2_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DefaultValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEFAULTVALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EAIElementREType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIELEMENTRETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FixedValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIXEDVALUE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxOccurs_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_MinOccurs_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysEAIDataTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDATATYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIDataTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIDATATYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementREId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTREID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementREName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTRENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAISchemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAISCHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysEAIElementId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSEAIELEMENTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSSysEAIElementName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSSYSEAIELEMENTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RETag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RETAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RETag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RETAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysEAIElementRE)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysEAIElementRE pSSysEAIElementRE) throws Exception {
        super.onUpdateParent((IEntity)pSSysEAIElementRE);
    }

    @Override
    protected void exportCurXmlModel(PSSysEAIElementRE pSSysEAIElementRE, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSEAIELEMENTRE");
        if (!bl) {
            pSSysEAIElementRE.setCreateDate(null);
            pSSysEAIElementRE.setCreateMan(null);
            pSSysEAIElementRE.setPSSysEAIElementREId(null);
            pSSysEAIElementRE.setUpdateDate(null);
            pSSysEAIElementRE.setUpdateMan(null);
            pSSysEAIElementRE.setPSSysEAIElementId(null);
            pSSysEAIElementRE.setPSSysEAIElementName(null);
            pSSysEAIElementRE.setPSSysEAISchemeId(null);
            super.exportCurXmlModel(pSSysEAIElementRE, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysEAIElementRE pSSysEAIElementRE, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysEAIElementRE, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIELEMENTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSEAIELEMENT#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIELEMENTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSEAIELEMENTRE_PSSYSEAIELEMENT_PSSYSEAIELEMENTID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIELEMENTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSEAIELEMENTNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENT", (boolean)true) == 0) {
            iEntity.set("PSSYSEAIELEMENTID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSEAIELEMENTID"};
    }

    @Override
    public String getModelV2Tag(PSSysEAIElementRE pSSysEAIElementRE) {
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIElementRE.getCodeName())) {
            return pSSysEAIElementRE.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIElementRE.getPSSysEAIElementREName())) {
            return pSSysEAIElementRE.getPSSysEAIElementREName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIElementRE.getCodeName())) {
            return pSSysEAIElementRE.getCodeName();
        }
        return super.getModelV2Tag(pSSysEAIElementRE);
    }

    @Override
    public boolean setModelV2Tag(PSSysEAIElementRE pSSysEAIElementRE, String string) {
        pSSysEAIElementRE.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSEAIELEMENTRENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSEAIELEMENTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysEAIElementRE pSSysEAIElementRE, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysEAIElementRE.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysEAIElementRE, true);
        pSSysEAIElementRE.set("CODENAME", string);
        if (this.select(pSSysEAIElementRE, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysEAIElementRE, true);
        return super.getModelV2Entity(pSSysEAIElementRE, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysEAIElementRE pSSysEAIElementRE, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysEAIElementRE, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysEAIElementRE pSSysEAIElementRE, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Element");
        defaultValueMap.put("PSSYSEAIELEMENTRENAME", "\u5f15\u7528\u5143\u7d20");
    }
}

