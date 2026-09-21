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
import net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIElementAttrDAO;
import net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIElementAttrDEModel;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataType;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataTypeBase;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElement;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementAttr;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElementBase;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDEFieldService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIElementAttrServiceBase
extends PSCoreSysServiceBase<PSSysEAIElementAttr> {
    private static final Log log = LogFactory.getLog(PSSysEAIElementAttrServiceBase.class);
    public static final String DATASET_CURELEMENT = "CurElement";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysEAIElementAttrDEModel pSSysEAIElementAttrDEModel;
    private PSSysEAIElementAttrDAO pSSysEAIElementAttrDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementAttrService";
    }

    public PSSysEAIElementAttrDEModel getPSSysEAIElementAttrDEModel() {
        if (this.pSSysEAIElementAttrDEModel == null) {
            try {
                this.pSSysEAIElementAttrDEModel = (PSSysEAIElementAttrDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.eaidesign.demodel.PSSysEAIElementAttrDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIElementAttrDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysEAIElementAttrDEModel();
    }

    public PSSysEAIElementAttrDAO getPSSysEAIElementAttrDAO() {
        if (this.pSSysEAIElementAttrDAO == null) {
            try {
                this.pSSysEAIElementAttrDAO = (PSSysEAIElementAttrDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.eaidesign.dao.PSSysEAIElementAttrDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysEAIElementAttrDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysEAIElementAttrDAO();
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

    protected void onFillParentInfo(PSSysEAIElementAttr pSSysEAIElementAttr, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeService", (SessionFactory)this.getSessionFactory());
            PSSysEAIDataType pSSysEAIDataType = (PSSysEAIDataType)iService.getDEModel().createEntity();
            pSSysEAIDataType.set("PSSYSEAIDATATYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIDataType);
            } else {
                iService.get((IEntity)pSSysEAIDataType);
            }
            this.onFillParentInfo_PSSysEAIDataType(pSSysEAIElementAttr, pSSysEAIDataType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENT_PSSYSEAIELEMENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService", (SessionFactory)this.getSessionFactory());
            PSSysEAIElement pSSysEAIElement = (PSSysEAIElement)iService.getDEModel().createEntity();
            pSSysEAIElement.set("PSSYSEAIELEMENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIElement);
            } else {
                iService.get((IEntity)pSSysEAIElement);
            }
            this.onFillParentInfo_PSSysEAIElement(pSSysEAIElementAttr, pSSysEAIElement);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENT_REFPSSYSEAIELEMENTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService", (SessionFactory)this.getSessionFactory());
            PSSysEAIElement pSSysEAIElement = (PSSysEAIElement)iService.getDEModel().createEntity();
            pSSysEAIElement.set("PSSYSEAIELEMENTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEAIElement);
            } else {
                iService.get((IEntity)pSSysEAIElement);
            }
            this.onFillParentInfo_RefPSSysEAIElement(pSSysEAIElementAttr, pSSysEAIElement);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysEAIElementAttr, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysEAIDataType(PSSysEAIElementAttr pSSysEAIElementAttr, PSSysEAIDataType pSSysEAIDataType) throws Exception {
        pSSysEAIElementAttr.setPSSysEAIDataTypeId(pSSysEAIDataType.getPSSysEAIDataTypeId());
        pSSysEAIElementAttr.setPSSysEAIDataTypeName(pSSysEAIDataType.getPSSysEAIDataTypeName());
    }

    protected void onFillParentInfo_PSSysEAIElement(PSSysEAIElementAttr pSSysEAIElementAttr, PSSysEAIElement pSSysEAIElement) throws Exception {
        pSSysEAIElementAttr.setPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
        pSSysEAIElementAttr.setPSSysEAIElementName(pSSysEAIElement.getPSSysEAIElementName());
        pSSysEAIElementAttr.setPSSysEAISchemeId(pSSysEAIElement.getPSSysEAISchemeId());
    }

    protected void onFillParentInfo_RefPSSysEAIElement(PSSysEAIElementAttr pSSysEAIElementAttr, PSSysEAIElement pSSysEAIElement) throws Exception {
        pSSysEAIElementAttr.setRefPSSysEAIElementId(pSSysEAIElement.getPSSysEAIElementId());
        pSSysEAIElementAttr.setRefPSSysEAIElementName(pSSysEAIElement.getPSSysEAIElementName());
    }

    protected void onFillEntityFullInfo(PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl) throws Exception {
        if (bl) {
            if (pSSysEAIElementAttr.getCodeName() == null) {
                pSSysEAIElementAttr.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Attr", 25));
            }
            if (pSSysEAIElementAttr.getPSSysEAIElementAttrName() == null) {
                pSSysEAIElementAttr.setPSSysEAIElementAttrName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u5c5e\u6027", 25));
            }
            if (pSSysEAIElementAttr.getValidFlag() == null) {
                pSSysEAIElementAttr.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysEAIElementAttr, bl);
        this.onFillEntityFullInfo_PSSysEAIDataType(pSSysEAIElementAttr, bl);
        this.onFillEntityFullInfo_PSSysEAIElement(pSSysEAIElementAttr, bl);
        this.onFillEntityFullInfo_RefPSSysEAIElement(pSSysEAIElementAttr, bl);
    }

    protected void onFillEntityFullInfo_PSSysEAIDataType(PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEAIElement(PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSSysEAIElement(PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysEAIElementAttr, bl);
    }

    public ArrayList<PSSysEAIElementAttr> selectByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase) throws Exception {
        return this.selectByPSSysEAIDataType(pSSysEAIDataTypeBase, "", -1);
    }

    public ArrayList<PSSysEAIElementAttr> selectByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, String string) throws Exception {
        return this.selectByPSSysEAIDataType(pSSysEAIDataTypeBase, string, -1);
    }

    public ArrayList<PSSysEAIElementAttr> selectByPSSysEAIDataType(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysEAIElementAttr> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase) throws Exception {
        return this.selectByPSSysEAIElement(pSSysEAIElementBase, "", -1);
    }

    public ArrayList<PSSysEAIElementAttr> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string) throws Exception {
        return this.selectByPSSysEAIElement(pSSysEAIElementBase, string, -1);
    }

    public ArrayList<PSSysEAIElementAttr> selectByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysEAIElementAttr> selectTempByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase) throws Exception {
        return this.selectTempByPSSysEAIElement(pSSysEAIElementBase, "");
    }

    public ArrayList<PSSysEAIElementAttr> selectTempByPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEAIELEMENTID", (Object)pSSysEAIElementBase.getPSSysEAIElementId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysEAIElementCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysEAIElementCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysEAIElementAttr> selectByRefPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase) throws Exception {
        return this.selectByRefPSSysEAIElement(pSSysEAIElementBase, "", -1);
    }

    public ArrayList<PSSysEAIElementAttr> selectByRefPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string) throws Exception {
        return this.selectByRefPSSysEAIElement(pSSysEAIElementBase, string, -1);
    }

    public ArrayList<PSSysEAIElementAttr> selectByRefPSSysEAIElement(PSSysEAIElementBase pSSysEAIElementBase, String string, int n) throws Exception {
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
        ArrayList<PSSysEAIElementAttr> arrayList = this.selectByPSSysEAIDataType(pSSysEAIDataType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAIDATATYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEAIDataType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIDATATYPE_PSSYSEAIDATATYPEID", "", iDataEntityModel.getName(), "PSSYSEAIELEMENTATTR", iDataEntityModel.getDataInfo((IEntity)pSSysEAIDataType), arrayList.get(0)));
        }
    }

    public void resetPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        ArrayList<PSSysEAIElementAttr> arrayList = this.selectByPSSysEAIDataType(pSSysEAIDataType);
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            PSSysEAIElementAttr pSSysEAIElementAttr2 = (PSSysEAIElementAttr)this.getDEModel().createEntity();
            pSSysEAIElementAttr2.setPSSysEAIElementAttrId(pSSysEAIElementAttr.getPSSysEAIElementAttrId());
            pSSysEAIElementAttr2.setPSSysEAIDataTypeId(null);
            this.update(pSSysEAIElementAttr2);
        }
    }

    public void removeByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        final PSSysEAIDataType pSSysEAIDataType2 = pSSysEAIDataType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIElementAttrServiceBase.this.onBeforeRemoveByPSSysEAIDataType(pSSysEAIDataType2);
                PSSysEAIElementAttrServiceBase.this.internalRemoveByPSSysEAIDataType(pSSysEAIDataType2);
                PSSysEAIElementAttrServiceBase.this.onAfterRemoveByPSSysEAIDataType(pSSysEAIDataType2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
    }

    protected void internalRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
        ArrayList<PSSysEAIElementAttr> arrayList = this.selectByPSSysEAIDataType(pSSysEAIDataType);
        this.onBeforeRemoveByPSSysEAIDataType(pSSysEAIDataType, arrayList);
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            this.remove((IEntity)pSSysEAIElementAttr);
        }
        this.onAfterRemoveByPSSysEAIDataType(pSSysEAIDataType, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType, ArrayList<PSSysEAIElementAttr> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIDataType(PSSysEAIDataType pSSysEAIDataType, ArrayList<PSSysEAIElementAttr> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    public void resetPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementAttr> arrayList = this.selectByPSSysEAIElement(pSSysEAIElement);
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            PSSysEAIElementAttr pSSysEAIElementAttr2 = (PSSysEAIElementAttr)this.getDEModel().createEntity();
            pSSysEAIElementAttr2.setPSSysEAIElementAttrId(pSSysEAIElementAttr.getPSSysEAIElementAttrId());
            pSSysEAIElementAttr2.setPSSysEAIElementId(null);
            this.update(pSSysEAIElementAttr2);
        }
    }

    public void resetTempPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementAttr> arrayList = this.selectTempByPSSysEAIElement(pSSysEAIElement);
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            PSSysEAIElementAttr pSSysEAIElementAttr2 = (PSSysEAIElementAttr)this.getDEModel().createEntity();
            pSSysEAIElementAttr2.setPSSysEAIElementAttrId(pSSysEAIElementAttr.getPSSysEAIElementAttrId());
            pSSysEAIElementAttr2.setPSSysEAIElementId(null);
            this.updateTemp((IEntity)pSSysEAIElementAttr2);
        }
    }

    public void removeByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        final PSSysEAIElement pSSysEAIElement2 = pSSysEAIElement;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIElementAttrServiceBase.this.onBeforeRemoveByPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementAttrServiceBase.this.internalRemoveByPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementAttrServiceBase.this.onAfterRemoveByPSSysEAIElement(pSSysEAIElement2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void internalRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementAttr> arrayList = this.selectByPSSysEAIElement(pSSysEAIElement);
        this.onBeforeRemoveByPSSysEAIElement(pSSysEAIElement, arrayList);
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            this.remove((IEntity)pSSysEAIElementAttr);
        }
        this.onAfterRemoveByPSSysEAIElement(pSSysEAIElement, arrayList);
    }

    protected void onAfterRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementAttr> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementAttr> arrayList) throws Exception {
    }

    public void testRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementAttr> arrayList = this.selectByRefPSSysEAIElement(pSSysEAIElement, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEAIELEMENT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEAIElement);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENT_REFPSSYSEAIELEMENTID", "", iDataEntityModel.getName(), "PSSYSEAIELEMENTATTR", iDataEntityModel.getDataInfo((IEntity)pSSysEAIElement), arrayList.get(0)));
        }
    }

    public void resetRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementAttr> arrayList = this.selectByRefPSSysEAIElement(pSSysEAIElement);
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            PSSysEAIElementAttr pSSysEAIElementAttr2 = (PSSysEAIElementAttr)this.getDEModel().createEntity();
            pSSysEAIElementAttr2.setPSSysEAIElementAttrId(pSSysEAIElementAttr.getPSSysEAIElementAttrId());
            pSSysEAIElementAttr2.setRefPSSysEAIElementId(null);
            this.update(pSSysEAIElementAttr2);
        }
    }

    public void removeByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        final PSSysEAIElement pSSysEAIElement2 = pSSysEAIElement;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIElementAttrServiceBase.this.onBeforeRemoveByRefPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementAttrServiceBase.this.internalRemoveByRefPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementAttrServiceBase.this.onAfterRemoveByRefPSSysEAIElement(pSSysEAIElement2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void internalRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementAttr> arrayList = this.selectByRefPSSysEAIElement(pSSysEAIElement);
        this.onBeforeRemoveByRefPSSysEAIElement(pSSysEAIElement, arrayList);
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            this.remove((IEntity)pSSysEAIElementAttr);
        }
        this.onAfterRemoveByRefPSSysEAIElement(pSSysEAIElement, arrayList);
    }

    protected void onAfterRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void onBeforeRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementAttr> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementAttr> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysEAIElementAttr pSSysEAIElementAttr) throws Exception {
        PSSysEAIDEFieldService pSSysEAIDEFieldService = (PSSysEAIDEFieldService)ServiceGlobal.getService(PSSysEAIDEFieldService.class, (SessionFactory)this.getSessionFactory());
        pSSysEAIDEFieldService.testRemoveByPSSysEAIElementAttr(pSSysEAIElementAttr);
        super.onBeforeRemove(pSSysEAIElementAttr);
    }

    public void removeTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        final PSSysEAIElement pSSysEAIElement2 = pSSysEAIElement;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysEAIElementAttrServiceBase.this.onBeforeRemoveTempByPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementAttrServiceBase.this.internalRemoveTempByPSSysEAIElement(pSSysEAIElement2);
                PSSysEAIElementAttrServiceBase.this.onAfterRemoveTempByPSSysEAIElement(pSSysEAIElement2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void internalRemoveTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
        ArrayList<PSSysEAIElementAttr> arrayList = this.selectTempByPSSysEAIElement(pSSysEAIElement);
        this.onBeforeRemoveTempByPSSysEAIElement(pSSysEAIElement, arrayList);
        for (PSSysEAIElementAttr pSSysEAIElementAttr : arrayList) {
            this.removeTemp((IEntity)pSSysEAIElementAttr);
        }
        this.onAfterRemoveTempByPSSysEAIElement(pSSysEAIElement, arrayList);
    }

    protected void onAfterRemoveTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementAttr> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysEAIElement(PSSysEAIElement pSSysEAIElement, ArrayList<PSSysEAIElementAttr> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysEAIElementAttr pSSysEAIElementAttr, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysEAIElementAttr, cloneSession);
        if (pSSysEAIElementAttr.getPSSysEAIDataTypeId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIDATATYPE", (Object)pSSysEAIElementAttr.getPSSysEAIDataTypeId())) != null) {
            this.onFillParentInfo_PSSysEAIDataType(pSSysEAIElementAttr, (PSSysEAIDataType)iEntity);
        }
        if (pSSysEAIElementAttr.getPSSysEAIElementId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIELEMENT", (Object)pSSysEAIElementAttr.getPSSysEAIElementId())) != null) {
            this.onFillParentInfo_PSSysEAIElement(pSSysEAIElementAttr, (PSSysEAIElement)iEntity);
        }
        if (pSSysEAIElementAttr.getRefPSSysEAIElementId() != null && (iEntity = cloneSession.getEntity("PSSYSEAIELEMENT", (Object)pSSysEAIElementAttr.getRefPSSysEAIElementId())) != null) {
            this.onFillParentInfo_RefPSSysEAIElement(pSSysEAIElementAttr, (PSSysEAIElement)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysEAIElementAttr, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AllowEmpty(bl, pSSysEAIElementAttr, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrTag(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AttrTag2(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultValue(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EAIElementAttrType(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FixedValue(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIDataTypeId(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementAttrId(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementAttrName(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEAIElementId(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSSysEAIElementId(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysEAIElementAttr, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysEAIElementAttr, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AllowEmpty(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isAllowEmptyDirty() : !pSSysEAIElementAttr.isAllowEmptyDirty()) {
            return null;
        }
        Integer n = pSSysEAIElementAttr.getAllowEmpty();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AllowEmpty_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ALLOWEMPTY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrTag(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isAttrTagDirty() : !pSSysEAIElementAttr.isAttrTagDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getAttrTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrTag_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AttrTag2(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isAttrTag2Dirty() : !pSSysEAIElementAttr.isAttrTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getAttrTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AttrTag2_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ATTRTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isCodeNameDirty() && !bl2 : !pSSysEAIElementAttr.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysEAIElementAttrDEModel(), "CODENAME", string3, pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultValue(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isDefaultValueDirty() : !pSSysEAIElementAttr.isDefaultValueDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getDefaultValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DefaultValue_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_EAIElementAttrType(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isEAIElementAttrTypeDirty() && !bl2 : !pSSysEAIElementAttr.isEAIElementAttrTypeDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getEAIElementAttrType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIELEMENTATTRTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_EAIElementAttrType_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EAIELEMENTATTRTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FixedValue(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isFixedValueDirty() : !pSSysEAIElementAttr.isFixedValueDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getFixedValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FixedValue_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isMemoDirty() : !pSSysEAIElementAttr.isMemoDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isOrderValueDirty() : !pSSysEAIElementAttr.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysEAIElementAttr.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEAIDataTypeId(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isPSSysEAIDataTypeIdDirty() : !pSSysEAIElementAttr.isPSSysEAIDataTypeIdDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getPSSysEAIDataTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIDataTypeId_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEAIElementAttrId(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isPSSysEAIElementAttrIdDirty() && !bl2 : !pSSysEAIElementAttr.isPSSysEAIElementAttrIdDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getPSSysEAIElementAttrId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTATTRID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementAttrId_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTATTRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementAttrName(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isPSSysEAIElementAttrNameDirty() && !bl2 : !pSSysEAIElementAttr.isPSSysEAIElementAttrNameDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getPSSysEAIElementAttrName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTATTRNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementAttrName_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEAIELEMENTATTRNAME");
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
                String string4 = this.checkFieldDupRule(this.getPSSysEAIElementAttrDEModel(), "PSSYSEAIELEMENTATTRNAME", string3, pSSysEAIElementAttr, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSEAIELEMENTATTRNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysEAIElementId(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isPSSysEAIElementIdDirty() : !pSSysEAIElementAttr.isPSSysEAIElementIdDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getPSSysEAIElementId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEAIElementId_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefPSSysEAIElementId(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isRefPSSysEAIElementIdDirty() : !pSSysEAIElementAttr.isRefPSSysEAIElementIdDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getRefPSSysEAIElementId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSSysEAIElementId_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isUserCatDirty() : !pSSysEAIElementAttr.isUserCatDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isUserTagDirty() : !pSSysEAIElementAttr.isUserTagDirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isUserTag2Dirty() : !pSSysEAIElementAttr.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isUserTag3Dirty() : !pSSysEAIElementAttr.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isUserTag4Dirty() : !pSSysEAIElementAttr.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysEAIElementAttr.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysEAIElementAttr.isValidFlagDirty() && !bl2 : !pSSysEAIElementAttr.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysEAIElementAttr.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysEAIElementAttr, bl2, bl3);
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

    protected void onSyncEntity(PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysEAIElementAttr, bl);
    }

    protected void onSyncIndexEntities(PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysEAIElementAttr, bl);
    }

    public Object getDataContextValue(PSSysEAIElementAttr pSSysEAIElementAttr, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysEAIElementAttr, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysEAIElement pSSysEAIElement = pSSysEAIElementAttr.getPSSysEAIElement();
        if (pSSysEAIElement != null && pSSysEAIElement.contains(string)) {
            return pSSysEAIElement.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysEAIElementAttr pSSysEAIElementAttr, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysEAIElementAttr, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ALLOWEMPTY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AllowEmpty_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ATTRTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AttrTag2_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EAIELEMENTATTRTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EAIElementAttrType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIXEDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FixedValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTATTRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementAttrId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTATTRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementAttrName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEAIELEMENTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEAIElementName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_AllowEmpty_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_AttrTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AttrTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ATTRTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_EAIElementAttrType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EAIELEMENTATTRTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_PSSysEAIElementAttrId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTATTRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEAIElementAttrName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEAIELEMENTATTRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysEAIElementAttr pSSysEAIElementAttr) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysEAIElementAttr)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysEAIElementAttr pSSysEAIElementAttr) throws Exception {
        super.onUpdateParent((IEntity)pSSysEAIElementAttr);
    }

    @Override
    protected void exportCurXmlModel(PSSysEAIElementAttr pSSysEAIElementAttr, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSEAIELEMENTATTR");
        if (!bl) {
            pSSysEAIElementAttr.setCreateDate(null);
            pSSysEAIElementAttr.setCreateMan(null);
            pSSysEAIElementAttr.setPSSysEAIElementAttrId(null);
            pSSysEAIElementAttr.setUpdateDate(null);
            pSSysEAIElementAttr.setUpdateMan(null);
            pSSysEAIElementAttr.setPSSysEAIElementId(null);
            pSSysEAIElementAttr.setPSSysEAIElementName(null);
            pSSysEAIElementAttr.setPSSysEAISchemeId(null);
            super.exportCurXmlModel(pSSysEAIElementAttr, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysEAIElementAttr pSSysEAIElementAttr, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysEAIElementAttr, string);
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
            return "DER1N_PSSYSEAIELEMENTATTR_PSSYSEAIELEMENT_PSSYSEAIELEMENTID";
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
    public String getModelV2Tag(PSSysEAIElementAttr pSSysEAIElementAttr) {
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIElementAttr.getCodeName())) {
            return pSSysEAIElementAttr.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIElementAttr.getPSSysEAIElementAttrName())) {
            return pSSysEAIElementAttr.getPSSysEAIElementAttrName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysEAIElementAttr.getCodeName())) {
            return pSSysEAIElementAttr.getCodeName();
        }
        return super.getModelV2Tag(pSSysEAIElementAttr);
    }

    @Override
    public boolean setModelV2Tag(PSSysEAIElementAttr pSSysEAIElementAttr, String string) {
        pSSysEAIElementAttr.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSEAIELEMENTATTRNAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSEAIELEMENTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysEAIElementAttr pSSysEAIElementAttr, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysEAIElementAttr.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysEAIElementAttr, true);
        pSSysEAIElementAttr.set("CODENAME", string);
        if (this.select(pSSysEAIElementAttr, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysEAIElementAttr, true);
        return super.getModelV2Entity(pSSysEAIElementAttr, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysEAIElementAttr pSSysEAIElementAttr, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysEAIElementAttr, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysEAIElementAttr pSSysEAIElementAttr, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Attr");
        defaultValueMap.put("PSSYSEAIELEMENTATTRNAME", "\u5c5e\u6027");
    }
}

