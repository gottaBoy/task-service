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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEMapDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEMapDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslatorBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMapDetailServiceBase
extends PSCoreSysServiceBase<PSDEMapDetail> {
    private static final Log log = LogFactory.getLog(PSDEMapDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEMapDetailDEModel pSDEMapDetailDEModel;
    private PSDEMapDetailDAO pSDEMapDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailService";
    }

    public PSDEMapDetailDEModel getPSDEMapDetailDEModel() {
        if (this.pSDEMapDetailDEModel == null) {
            try {
                this.pSDEMapDetailDEModel = (PSDEMapDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEMapDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMapDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEMapDetailDEModel();
    }

    public PSDEMapDetailDAO getPSDEMapDetailDAO() {
        if (this.pSDEMapDetailDAO == null) {
            try {
                this.pSDEMapDetailDAO = (PSDEMapDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEMapDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEMapDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEMapDetailDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDEMapDetail pSDEMapDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPDETAIL_PSDEFIELD_SRCPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEField);
            } else {
                iService.get(pSDEField);
            }
            this.onFillParentInfo_SrcPSDEF(pSDEMapDetail, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMapService", (SessionFactory)this.getSessionFactory());
            PSDEMap pSDEMap = (PSDEMap)iService.getDEModel().createEntity();
            pSDEMap.set("PSDEMAPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEMap);
            } else {
                iService.get(pSDEMap);
            }
            this.onFillParentInfo_PSDEMap(pSDEMapDetail, pSDEMap);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEMAPDETAIL_PSSYSTRANSLATOR_PSSYSTRANSLATORID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService", (SessionFactory)this.getSessionFactory());
            PSSysTranslator pSSysTranslator = (PSSysTranslator)iService.getDEModel().createEntity();
            pSSysTranslator.set("PSSYSTRANSLATORID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysTranslator);
            } else {
                iService.get(pSSysTranslator);
            }
            this.onFillParentInfo_PSSysTranslator(pSDEMapDetail, pSSysTranslator);
            return;
        }
        super.onFillParentInfo(pSDEMapDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_SrcPSDEF(PSDEMapDetail pSDEMapDetail, PSDEField pSDEField) throws Exception {
        pSDEMapDetail.setSrcPSDEFId(pSDEField.getPSDEFieldId());
        pSDEMapDetail.setSrcPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEMap(PSDEMapDetail pSDEMapDetail, PSDEMap pSDEMap) throws Exception {
        pSDEMapDetail.setPSDEId(pSDEMap.getPSDEId());
        pSDEMapDetail.setPSDEMapId(pSDEMap.getPSDEMapId());
        pSDEMapDetail.setPSDEMapName(pSDEMap.getPSDEMapName());
    }

    protected void onFillParentInfo_PSSysTranslator(PSDEMapDetail pSDEMapDetail, PSSysTranslator pSSysTranslator) throws Exception {
        pSDEMapDetail.setPSSysTranslatorId(pSSysTranslator.getPSSysTranslatorId());
        pSDEMapDetail.setPSSysTranslatorName(pSSysTranslator.getPSSysTranslatorName());
    }

    protected void onFillEntityFullInfo(PSDEMapDetail pSDEMapDetail, boolean bl) throws Exception {
        if (bl && pSDEMapDetail.getValidFlag() == null) {
            pSDEMapDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDEMapDetail, bl);
        this.onFillEntityFullInfo_SrcPSDEF(pSDEMapDetail, bl);
        this.onFillEntityFullInfo_PSDEMap(pSDEMapDetail, bl);
        this.onFillEntityFullInfo_PSSysTranslator(pSDEMapDetail, bl);
    }

    protected void onFillEntityFullInfo_SrcPSDEF(PSDEMapDetail pSDEMapDetail, boolean bl) throws Exception {
        if (pSDEMapDetail.isSrcPSDEFIdDirty()) {
            if (pSDEMapDetail.getSrcPSDEFId() != null) {
                if (pSDEMapDetail.getSrcPSDEFId() == null || pSDEMapDetail.getSrcPSDEFName() == null) {
                    PSDEField pSDEField = pSDEMapDetail.getSrcPSDEF();
                    pSDEMapDetail.setSrcPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEMapDetail.setSrcPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEMap(PSDEMapDetail pSDEMapDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysTranslator(PSDEMapDetail pSDEMapDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEMapDetail pSDEMapDetail, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEMapDetail, bl);
    }

    public ArrayList<PSDEMapDetail> selectBySrcPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectBySrcPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEMapDetail> selectBySrcPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectBySrcPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEMapDetail> selectBySrcPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SRCPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySrcPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySrcPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMapDetail> selectByPSDEMap(PSDEMapBase pSDEMapBase) throws Exception {
        return this.selectByPSDEMap(pSDEMapBase, "", -1);
    }

    public ArrayList<PSDEMapDetail> selectByPSDEMap(PSDEMapBase pSDEMapBase, String string) throws Exception {
        return this.selectByPSDEMap(pSDEMapBase, string, -1);
    }

    public ArrayList<PSDEMapDetail> selectByPSDEMap(PSDEMapBase pSDEMapBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAPID", (Object)pSDEMapBase.getPSDEMapId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEMapCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEMapCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMapDetail> selectTempByPSDEMap(PSDEMapBase pSDEMapBase) throws Exception {
        return this.selectTempByPSDEMap(pSDEMapBase, "");
    }

    public ArrayList<PSDEMapDetail> selectTempByPSDEMap(PSDEMapBase pSDEMapBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAPID", (Object)pSDEMapBase.getPSDEMapId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEMapCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEMapCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEMapDetail> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, "", -1);
    }

    public ArrayList<PSDEMapDetail> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string) throws Exception {
        return this.selectByPSSysTranslator(pSSysTranslatorBase, string, -1);
    }

    public ArrayList<PSDEMapDetail> selectByPSSysTranslator(PSSysTranslatorBase pSSysTranslatorBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTRANSLATORID", (Object)pSSysTranslatorBase.getPSSysTranslatorId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysTranslatorCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysTranslatorCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveBySrcPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEMapDetail> arrayList = this.selectBySrcPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAPDETAIL_PSDEFIELD_SRCPSDEFID", "", iDataEntityModel.getName(), "PSDEMAPDETAIL", iDataEntityModel.getDataInfo(pSDEField), arrayList.get(0)));
        }
    }

    public void resetSrcPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEMapDetail> arrayList = this.selectBySrcPSDEF(pSDEField);
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            PSDEMapDetail pSDEMapDetail2 = (PSDEMapDetail)this.getDEModel().createEntity();
            pSDEMapDetail2.setPSDEMapDetailId(pSDEMapDetail.getPSDEMapDetailId());
            pSDEMapDetail2.setSrcPSDEFId(null);
            this.update(pSDEMapDetail2);
        }
    }

    public void removeBySrcPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDetailServiceBase.this.onBeforeRemoveBySrcPSDEF(pSDEField2);
                PSDEMapDetailServiceBase.this.internalRemoveBySrcPSDEF(pSDEField2);
                PSDEMapDetailServiceBase.this.onAfterRemoveBySrcPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveBySrcPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveBySrcPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEMapDetail> arrayList = this.selectBySrcPSDEF(pSDEField);
        this.onBeforeRemoveBySrcPSDEF(pSDEField, arrayList);
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            this.remove(pSDEMapDetail);
        }
        this.onAfterRemoveBySrcPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveBySrcPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveBySrcPSDEF(PSDEField pSDEField, ArrayList<PSDEMapDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySrcPSDEF(PSDEField pSDEField, ArrayList<PSDEMapDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    public void resetPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDetail> arrayList = this.selectByPSDEMap(pSDEMap);
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            PSDEMapDetail pSDEMapDetail2 = (PSDEMapDetail)this.getDEModel().createEntity();
            pSDEMapDetail2.setPSDEMapDetailId(pSDEMapDetail.getPSDEMapDetailId());
            pSDEMapDetail2.setPSDEMapId(null);
            this.update(pSDEMapDetail2);
        }
    }

    public void resetTempPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDetail> arrayList = this.selectTempByPSDEMap(pSDEMap);
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            PSDEMapDetail pSDEMapDetail2 = (PSDEMapDetail)this.getDEModel().createEntity();
            pSDEMapDetail2.setPSDEMapDetailId(pSDEMapDetail.getPSDEMapDetailId());
            pSDEMapDetail2.setPSDEMapId(null);
            this.updateTemp(pSDEMapDetail2);
        }
    }

    public void removeByPSDEMap(PSDEMap pSDEMap) throws Exception {
        final PSDEMap pSDEMap2 = pSDEMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDetailServiceBase.this.onBeforeRemoveByPSDEMap(pSDEMap2);
                PSDEMapDetailServiceBase.this.internalRemoveByPSDEMap(pSDEMap2);
                PSDEMapDetailServiceBase.this.onAfterRemoveByPSDEMap(pSDEMap2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void internalRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDetail> arrayList = this.selectByPSDEMap(pSDEMap);
        this.onBeforeRemoveByPSDEMap(pSDEMap, arrayList);
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            this.remove(pSDEMapDetail);
        }
        this.onAfterRemoveByPSDEMap(pSDEMap, arrayList);
    }

    protected void onAfterRemoveByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEMapDetail> arrayList = this.selectByPSSysTranslator(pSSysTranslator, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTRANSLATOR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysTranslator);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEMAPDETAIL_PSSYSTRANSLATOR_PSSYSTRANSLATORID", "", iDataEntityModel.getName(), "PSDEMAPDETAIL", iDataEntityModel.getDataInfo(pSSysTranslator), arrayList.get(0)));
        }
    }

    public void resetPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEMapDetail> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            PSDEMapDetail pSDEMapDetail2 = (PSDEMapDetail)this.getDEModel().createEntity();
            pSDEMapDetail2.setPSDEMapDetailId(pSDEMapDetail.getPSDEMapDetailId());
            pSDEMapDetail2.setPSSysTranslatorId(null);
            this.update(pSDEMapDetail2);
        }
    }

    public void removeByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        final PSSysTranslator pSSysTranslator2 = pSSysTranslator;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDetailServiceBase.this.onBeforeRemoveByPSSysTranslator(pSSysTranslator2);
                PSDEMapDetailServiceBase.this.internalRemoveByPSSysTranslator(pSSysTranslator2);
                PSDEMapDetailServiceBase.this.onAfterRemoveByPSSysTranslator(pSSysTranslator2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void internalRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
        ArrayList<PSDEMapDetail> arrayList = this.selectByPSSysTranslator(pSSysTranslator);
        this.onBeforeRemoveByPSSysTranslator(pSSysTranslator, arrayList);
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            this.remove(pSDEMapDetail);
        }
        this.onAfterRemoveByPSSysTranslator(pSSysTranslator, arrayList);
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator) throws Exception {
    }

    protected void onBeforeRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEMapDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysTranslator(PSSysTranslator pSSysTranslator, ArrayList<PSDEMapDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEMapDetail pSDEMapDetail) throws Exception {
        super.onBeforeRemove(pSDEMapDetail);
    }

    public void removeTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
        final PSDEMap pSDEMap2 = pSDEMap;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEMapDetailServiceBase.this.onBeforeRemoveTempByPSDEMap(pSDEMap2);
                PSDEMapDetailServiceBase.this.internalRemoveTempByPSDEMap(pSDEMap2);
                PSDEMapDetailServiceBase.this.onAfterRemoveTempByPSDEMap(pSDEMap2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void internalRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
        ArrayList<PSDEMapDetail> arrayList = this.selectTempByPSDEMap(pSDEMap);
        this.onBeforeRemoveTempByPSDEMap(pSDEMap, arrayList);
        for (PSDEMapDetail pSDEMapDetail : arrayList) {
            this.removeTemp(pSDEMapDetail);
        }
        this.onAfterRemoveTempByPSDEMap(pSDEMap, arrayList);
    }

    protected void onAfterRemoveTempByPSDEMap(PSDEMap pSDEMap) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEMap(PSDEMap pSDEMap, ArrayList<PSDEMapDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEMapDetail pSDEMapDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEMapDetail, cloneSession);
        if (pSDEMapDetail.getSrcPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEMapDetail.getSrcPSDEFId())) != null) {
            this.onFillParentInfo_SrcPSDEF(pSDEMapDetail, (PSDEField)iEntity);
        }
        if (pSDEMapDetail.getPSDEMapId() != null && (iEntity = cloneSession.getEntity("PSDEMAP", (Object)pSDEMapDetail.getPSDEMapId())) != null) {
            this.onFillParentInfo_PSDEMap(pSDEMapDetail, (PSDEMap)iEntity);
        }
        if (pSDEMapDetail.getPSSysTranslatorId() != null && (iEntity = cloneSession.getEntity("PSSYSTRANSLATOR", (Object)pSDEMapDetail.getPSSysTranslatorId())) != null) {
            this.onFillParentInfo_PSSysTranslator(pSDEMapDetail, (PSSysTranslator)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEMapDetail pSDEMapDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEMapDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DstFieldName(bl, pSDEMapDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapDetailId(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapDetailName(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMapId(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysTranslatorId(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDEFId(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcPSDEFName(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcType(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SrcValue(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEMapDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEMapDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DstFieldName(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isDstFieldNameDirty() : !pSDEMapDetail.isDstFieldNameDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getDstFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DstFieldName_Default(pSDEMapDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DSTFIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isMemoDirty() : !pSDEMapDetail.isMemoDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEMapDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMapDetailId(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isPSDEMapDetailIdDirty() && !bl2 : !pSDEMapDetail.isPSDEMapDetailIdDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getPSDEMapDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapDetailId_Default(pSDEMapDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapDetailName(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isPSDEMapDetailNameDirty() : !pSDEMapDetail.isPSDEMapDetailNameDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getPSDEMapDetailName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapDetailName_Default(pSDEMapDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEMapId(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isPSDEMapIdDirty() : !pSDEMapDetail.isPSDEMapIdDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getPSDEMapId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMapId_Default(pSDEMapDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysTranslatorId(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isPSSysTranslatorIdDirty() : !pSDEMapDetail.isPSSysTranslatorIdDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getPSSysTranslatorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysTranslatorId_Default(pSDEMapDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTRANSLATORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDEFId(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isSrcPSDEFIdDirty() : !pSDEMapDetail.isSrcPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getSrcPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDEFId_Default(pSDEMapDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcPSDEFName(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isSrcPSDEFNameDirty() : !pSDEMapDetail.isSrcPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getSrcPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcPSDEFName_Default(pSDEMapDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcType(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isSrcTypeDirty() : !pSDEMapDetail.isSrcTypeDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getSrcType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcType_Default(pSDEMapDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SrcValue(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isSrcValueDirty() : !pSDEMapDetail.isSrcValueDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getSrcValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SrcValue_Default(pSDEMapDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRCVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isUserCatDirty() : !pSDEMapDetail.isUserCatDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEMapDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isUserTagDirty() : !pSDEMapDetail.isUserTagDirty()) {
            return null;
        }
        String string = pSDEMapDetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEMapDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isUserTag2Dirty() : !pSDEMapDetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEMapDetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEMapDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isUserTag3Dirty() : !pSDEMapDetail.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEMapDetail.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEMapDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isUserTag4Dirty() : !pSDEMapDetail.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEMapDetail.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEMapDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEMapDetail pSDEMapDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEMapDetail.isValidFlagDirty() : !pSDEMapDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEMapDetail.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEMapDetail, bl2, bl3);
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

    protected void onSyncEntity(PSDEMapDetail pSDEMapDetail, boolean bl) throws Exception {
        super.onSyncEntity(pSDEMapDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEMapDetail pSDEMapDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEMapDetail, bl);
    }

    public Object getDataContextValue(PSDEMapDetail pSDEMapDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEMapDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEMap pSDEMap = pSDEMapDetail.getPSDEMap();
        if (pSDEMap != null && pSDEMap.contains(string)) {
            return pSDEMap.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEMapDetail pSDEMapDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEMapDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DSTFIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DstFieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMapName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTRANSLATORNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysTranslatorName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRCVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SrcValue_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DstFieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DSTFIELDNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_PSDEMapDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMapDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMapId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMapName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTranslatorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysTranslatorName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTRANSLATORNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SrcValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SRCVALUE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected boolean onMergeChild(String string, String string2, PSDEMapDetail pSDEMapDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEMapDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEMapDetail pSDEMapDetail) throws Exception {
        super.onUpdateParent(pSDEMapDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEMapDetail pSDEMapDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEMAPDETAIL");
        if (!bl) {
            pSDEMapDetail.setPSDEMapName(null);
            pSDEMapDetail.setPSDEId(null);
            pSDEMapDetail.setPSDEMapId(null);
            pSDEMapDetail.setPSDEMapName(null);
            super.exportCurXmlModel(pSDEMapDetail, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEMapDetail pSDEMapDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEMapDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEMAP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEMAPDETAIL_PSDEMAP_PSDEMAPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEMAPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEMAP", (boolean)true) == 0) {
            iEntity.set("PSDEMAPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEMAPID"};
    }

    @Override
    public String getModelV2Tag(PSDEMapDetail pSDEMapDetail) {
        return super.getModelV2Tag(pSDEMapDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDEMapDetail pSDEMapDetail, String string) {
        return super.setModelV2Tag(pSDEMapDetail, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEMAPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEMapDetail pSDEMapDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEMapDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEMapDetail, true);
        return super.getModelV2Entity(pSDEMapDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEMapDetail pSDEMapDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEMapDetail, objectNode, string, string2, n);
    }
}

