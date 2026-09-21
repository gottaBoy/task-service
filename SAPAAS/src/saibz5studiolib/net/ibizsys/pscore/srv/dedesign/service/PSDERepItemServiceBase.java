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
import net.ibizsys.pscore.srv.dedesign.dao.PSDERepItemDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDERepItemDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERepItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReportBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDERepItemServiceBase
extends PSCoreSysServiceBase<PSDERepItem> {
    private static final Log log = LogFactory.getLog(PSDERepItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDERepItemDEModel pSDERepItemDEModel;
    private PSDERepItemDAO pSDERepItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDERepItemService";
    }

    public PSDERepItemDEModel getPSDERepItemDEModel() {
        if (this.pSDERepItemDEModel == null) {
            try {
                this.pSDERepItemDEModel = (PSDERepItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDERepItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERepItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDERepItemDEModel();
    }

    public PSDERepItemDAO getPSDERepItemDAO() {
        if (this.pSDERepItemDAO == null) {
            try {
                this.pSDERepItemDAO = (PSDERepItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDERepItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERepItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDERepItemDAO();
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

    protected void onFillParentInfo(PSDERepItem pSDERepItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEREPITEM_PSDEREPORT_MAJORPSDEREPORTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEReportService", (SessionFactory)this.getSessionFactory());
            PSDEReport pSDEReport = (PSDEReport)iService.getDEModel().createEntity();
            pSDEReport.set("PSDEREPORTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEReport);
            } else {
                iService.get((IEntity)pSDEReport);
            }
            this.onFillParentInfo_MajorPSDEReport(pSDERepItem, pSDEReport);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEREPITEM_PSDEREPORT_MINORPSDEREPORTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEReportService", (SessionFactory)this.getSessionFactory());
            PSDEReport pSDEReport = (PSDEReport)iService.getDEModel().createEntity();
            pSDEReport.set("PSDEREPORTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEReport);
            } else {
                iService.get((IEntity)pSDEReport);
            }
            this.onFillParentInfo_MinorPSDEReport(pSDERepItem, pSDEReport);
            return;
        }
        super.onFillParentInfo((IEntity)pSDERepItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_MajorPSDEReport(PSDERepItem pSDERepItem, PSDEReport pSDEReport) throws Exception {
        pSDERepItem.setMajorPSDEReportId(pSDEReport.getPSDEReportId());
        pSDERepItem.setMajorPSDEReportName(pSDEReport.getPSDEReportName());
        pSDERepItem.setPSDEId(pSDEReport.getPSDEId());
    }

    protected void onFillParentInfo_MinorPSDEReport(PSDERepItem pSDERepItem, PSDEReport pSDEReport) throws Exception {
        pSDERepItem.setMinorPSDEReportId(pSDEReport.getPSDEReportId());
        pSDERepItem.setMinorPSDEReportName(pSDEReport.getPSDEReportName());
    }

    protected void onFillEntityFullInfo(PSDERepItem pSDERepItem, boolean bl) throws Exception {
        if (bl && pSDERepItem.getOrderValue() == null) {
            pSDERepItem.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "1000", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDERepItem, bl);
        this.onFillEntityFullInfo_MajorPSDEReport(pSDERepItem, bl);
        this.onFillEntityFullInfo_MinorPSDEReport(pSDERepItem, bl);
    }

    protected void onFillEntityFullInfo_MajorPSDEReport(PSDERepItem pSDERepItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MinorPSDEReport(PSDERepItem pSDERepItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDERepItem pSDERepItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDERepItem, bl);
    }

    public ArrayList<PSDERepItem> selectByMajorPSDEReport(PSDEReportBase pSDEReportBase) throws Exception {
        return this.selectByMajorPSDEReport(pSDEReportBase, "", -1);
    }

    public ArrayList<PSDERepItem> selectByMajorPSDEReport(PSDEReportBase pSDEReportBase, String string) throws Exception {
        return this.selectByMajorPSDEReport(pSDEReportBase, string, -1);
    }

    public ArrayList<PSDERepItem> selectByMajorPSDEReport(PSDEReportBase pSDEReportBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEREPORTID", (Object)pSDEReportBase.getPSDEReportId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMajorPSDEReportCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMajorPSDEReportCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDERepItem> selectTempByMajorPSDEReport(PSDEReportBase pSDEReportBase) throws Exception {
        return this.selectTempByMajorPSDEReport(pSDEReportBase, "");
    }

    public ArrayList<PSDERepItem> selectTempByMajorPSDEReport(PSDEReportBase pSDEReportBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAJORPSDEREPORTID", (Object)pSDEReportBase.getPSDEReportId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByMajorPSDEReportCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByMajorPSDEReportCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDERepItem> selectByMinorPSDEReport(PSDEReportBase pSDEReportBase) throws Exception {
        return this.selectByMinorPSDEReport(pSDEReportBase, "", -1);
    }

    public ArrayList<PSDERepItem> selectByMinorPSDEReport(PSDEReportBase pSDEReportBase, String string) throws Exception {
        return this.selectByMinorPSDEReport(pSDEReportBase, string, -1);
    }

    public ArrayList<PSDERepItem> selectByMinorPSDEReport(PSDEReportBase pSDEReportBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORPSDEREPORTID", (Object)pSDEReportBase.getPSDEReportId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorPSDEReportCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorPSDEReportCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    public void resetMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDERepItem> arrayList = this.selectByMajorPSDEReport(pSDEReport);
        for (PSDERepItem pSDERepItem : arrayList) {
            PSDERepItem pSDERepItem2 = (PSDERepItem)this.getDEModel().createEntity();
            pSDERepItem2.setPSDERepItemId(pSDERepItem.getPSDERepItemId());
            pSDERepItem2.setMajorPSDEReportId(null);
            this.update(pSDERepItem2);
        }
    }

    public void resetTempMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDERepItem> arrayList = this.selectTempByMajorPSDEReport(pSDEReport);
        for (PSDERepItem pSDERepItem : arrayList) {
            PSDERepItem pSDERepItem2 = (PSDERepItem)this.getDEModel().createEntity();
            pSDERepItem2.setPSDERepItemId(pSDERepItem.getPSDERepItemId());
            pSDERepItem2.setMajorPSDEReportId(null);
            this.updateTemp((IEntity)pSDERepItem2);
        }
    }

    public void removeByMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
        final PSDEReport pSDEReport2 = pSDEReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERepItemServiceBase.this.onBeforeRemoveByMajorPSDEReport(pSDEReport2);
                PSDERepItemServiceBase.this.internalRemoveByMajorPSDEReport(pSDEReport2);
                PSDERepItemServiceBase.this.onAfterRemoveByMajorPSDEReport(pSDEReport2);
            }
        });
    }

    protected void onBeforeRemoveByMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void internalRemoveByMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDERepItem> arrayList = this.selectByMajorPSDEReport(pSDEReport);
        this.onBeforeRemoveByMajorPSDEReport(pSDEReport, arrayList);
        for (PSDERepItem pSDERepItem : arrayList) {
            this.remove((IEntity)pSDERepItem);
        }
        this.onAfterRemoveByMajorPSDEReport(pSDEReport, arrayList);
    }

    protected void onAfterRemoveByMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void onBeforeRemoveByMajorPSDEReport(PSDEReport pSDEReport, ArrayList<PSDERepItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMajorPSDEReport(PSDEReport pSDEReport, ArrayList<PSDERepItem> arrayList) throws Exception {
    }

    public void testRemoveByMinorPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDERepItem> arrayList = this.selectByMinorPSDEReport(pSDEReport, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEREPORT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEReport);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEREPITEM_PSDEREPORT_MINORPSDEREPORTID", "", iDataEntityModel.getName(), "PSDEREPITEM", iDataEntityModel.getDataInfo((IEntity)pSDEReport), arrayList.get(0)));
        }
    }

    public void resetMinorPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDERepItem> arrayList = this.selectByMinorPSDEReport(pSDEReport);
        for (PSDERepItem pSDERepItem : arrayList) {
            PSDERepItem pSDERepItem2 = (PSDERepItem)this.getDEModel().createEntity();
            pSDERepItem2.setPSDERepItemId(pSDERepItem.getPSDERepItemId());
            pSDERepItem2.setMinorPSDEReportId(null);
            this.update(pSDERepItem2);
        }
    }

    public void removeByMinorPSDEReport(PSDEReport pSDEReport) throws Exception {
        final PSDEReport pSDEReport2 = pSDEReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERepItemServiceBase.this.onBeforeRemoveByMinorPSDEReport(pSDEReport2);
                PSDERepItemServiceBase.this.internalRemoveByMinorPSDEReport(pSDEReport2);
                PSDERepItemServiceBase.this.onAfterRemoveByMinorPSDEReport(pSDEReport2);
            }
        });
    }

    protected void onBeforeRemoveByMinorPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void internalRemoveByMinorPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDERepItem> arrayList = this.selectByMinorPSDEReport(pSDEReport);
        this.onBeforeRemoveByMinorPSDEReport(pSDEReport, arrayList);
        for (PSDERepItem pSDERepItem : arrayList) {
            this.remove((IEntity)pSDERepItem);
        }
        this.onAfterRemoveByMinorPSDEReport(pSDEReport, arrayList);
    }

    protected void onAfterRemoveByMinorPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void onBeforeRemoveByMinorPSDEReport(PSDEReport pSDEReport, ArrayList<PSDERepItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorPSDEReport(PSDEReport pSDEReport, ArrayList<PSDERepItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDERepItem pSDERepItem) throws Exception {
        super.onBeforeRemove(pSDERepItem);
    }

    public void removeTempByMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
        final PSDEReport pSDEReport2 = pSDEReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDERepItemServiceBase.this.onBeforeRemoveTempByMajorPSDEReport(pSDEReport2);
                PSDERepItemServiceBase.this.internalRemoveTempByMajorPSDEReport(pSDEReport2);
                PSDERepItemServiceBase.this.onAfterRemoveTempByMajorPSDEReport(pSDEReport2);
            }
        });
    }

    protected void onBeforeRemoveTempByMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void internalRemoveTempByMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDERepItem> arrayList = this.selectTempByMajorPSDEReport(pSDEReport);
        this.onBeforeRemoveTempByMajorPSDEReport(pSDEReport, arrayList);
        for (PSDERepItem pSDERepItem : arrayList) {
            this.removeTemp((IEntity)pSDERepItem);
        }
        this.onAfterRemoveTempByMajorPSDEReport(pSDEReport, arrayList);
    }

    protected void onAfterRemoveTempByMajorPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void onBeforeRemoveTempByMajorPSDEReport(PSDEReport pSDEReport, ArrayList<PSDERepItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByMajorPSDEReport(PSDEReport pSDEReport, ArrayList<PSDERepItem> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDERepItem pSDERepItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDERepItem, cloneSession);
        if (pSDERepItem.getMajorPSDEReportId() != null && (iEntity = cloneSession.getEntity("PSDEREPORT", (Object)pSDERepItem.getMajorPSDEReportId())) != null) {
            this.onFillParentInfo_MajorPSDEReport(pSDERepItem, (PSDEReport)iEntity);
        }
        if (pSDERepItem.getMinorPSDEReportId() != null && (iEntity = cloneSession.getEntity("PSDEREPORT", (Object)pSDERepItem.getMinorPSDEReportId())) != null) {
            this.onFillParentInfo_MinorPSDEReport(pSDERepItem, (PSDEReport)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDERepItem pSDERepItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDERepItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_MajorPSDEReportId(bl, pSDERepItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDERepItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorPSDEReportId(bl, pSDERepItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDERepItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERepItemId(bl, pSDERepItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDERepItemName(bl, pSDERepItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDERepItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDERepItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDERepItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDERepItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDERepItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDERepItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_MajorPSDEReportId(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isMajorPSDEReportIdDirty() && !bl2 : !pSDERepItem.isMajorPSDEReportIdDirty()) {
            return null;
        }
        String string = pSDERepItem.getMajorPSDEReportId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEREPORTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MajorPSDEReportId_Default((IEntity)pSDERepItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORPSDEREPORTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isMemoDirty() : !pSDERepItem.isMemoDirty()) {
            return null;
        }
        String string = pSDERepItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDERepItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorPSDEReportId(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isMinorPSDEReportIdDirty() && !bl2 : !pSDERepItem.isMinorPSDEReportIdDirty()) {
            return null;
        }
        String string = pSDERepItem.getMinorPSDEReportId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEREPORTID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorPSDEReportId_Default((IEntity)pSDERepItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORPSDEREPORTID");
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
                string3 = "MAJORPSDEREPORTID";
                String string4 = this.checkFieldDupRule(this.getPSDERepItemDEModel(), "MINORPSDEREPORTID", string3, pSDERepItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("MINORPSDEREPORTID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isOrderValueDirty() && !bl2 : !pSDERepItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDERepItem.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDERepItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDERepItemId(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isPSDERepItemIdDirty() && !bl2 : !pSDERepItem.isPSDERepItemIdDirty()) {
            return null;
        }
        String string = pSDERepItem.getPSDERepItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEREPITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERepItemId_Default((IEntity)pSDERepItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEREPITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDERepItemName(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isPSDERepItemNameDirty() && !bl2 : !pSDERepItem.isPSDERepItemNameDirty()) {
            return null;
        }
        String string = pSDERepItem.getPSDERepItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEREPITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDERepItemName_Default((IEntity)pSDERepItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEREPITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "MAJORPSDEREPORTID";
                String string4 = this.checkFieldDupRule(this.getPSDERepItemDEModel(), "PSDEREPITEMNAME", string3, pSDERepItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEREPITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isUserCatDirty() : !pSDERepItem.isUserCatDirty()) {
            return null;
        }
        String string = pSDERepItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDERepItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isUserTagDirty() : !pSDERepItem.isUserTagDirty()) {
            return null;
        }
        String string = pSDERepItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDERepItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isUserTag2Dirty() : !pSDERepItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDERepItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDERepItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isUserTag3Dirty() : !pSDERepItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDERepItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDERepItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDERepItem pSDERepItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDERepItem.isUserTag4Dirty() : !pSDERepItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDERepItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDERepItem, bl2, bl3);
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

    protected void onSyncEntity(PSDERepItem pSDERepItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDERepItem, bl);
    }

    protected void onSyncIndexEntities(PSDERepItem pSDERepItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDERepItem, bl);
    }

    public Object getDataContextValue(PSDERepItem pSDERepItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDERepItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEReport pSDEReport = pSDERepItem.getMajorPSDEReport();
        if (pSDEReport != null && pSDEReport.contains(string)) {
            return pSDEReport.get(string);
        }
        PSDEReport pSDEReport2 = pSDERepItem.getMinorPSDEReport();
        if (pSDEReport2 != null && pSDEReport2.contains(string)) {
            return pSDEReport2.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDERepItem pSDERepItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDERepItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEREPORTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEReportId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORPSDEREPORTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorPSDEReportName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEREPORTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEReportId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORPSDEREPORTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorPSDEReportName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEREPITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERepItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEREPITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDERepItemName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_MajorPSDEReportId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEREPORTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MajorPSDEReportName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAJORPSDEREPORTNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_MinorPSDEReportId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEREPORTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorPSDEReportName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORPSDEREPORTNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDERepItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEREPITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDERepItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEREPITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDEREPITEMNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDERepItem pSDERepItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDERepItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDERepItem pSDERepItem) throws Exception {
        super.onUpdateParent((IEntity)pSDERepItem);
    }

    @Override
    protected void exportCurXmlModel(PSDERepItem pSDERepItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEREPITEM");
        if (!bl) {
            pSDERepItem.setCreateDate(null);
            pSDERepItem.setCreateMan(null);
            pSDERepItem.setPSDERepItemId(null);
            pSDERepItem.setUpdateDate(null);
            pSDERepItem.setUpdateMan(null);
            pSDERepItem.setMajorPSDEReportId(null);
            pSDERepItem.setMajorPSDEReportName(null);
            pSDERepItem.setPSDEId(null);
            super.exportCurXmlModel(pSDERepItem, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDERepItem pSDERepItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDERepItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEREPORTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEREPORT#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEREPORTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEREPITEM_PSDEREPORT_MAJORPSDEREPORTID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEREPORTID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"MAJORPSDEREPORTNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEREPORT", (boolean)true) == 0) {
            iEntity.set("MAJORPSDEREPORTID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"MAJORPSDEREPORTID"};
    }

    @Override
    public String getModelV2Tag(PSDERepItem pSDERepItem) {
        if (!StringHelper.isNullOrEmpty((String)pSDERepItem.getPSDERepItemName())) {
            return pSDERepItem.getPSDERepItemName();
        }
        return super.getModelV2Tag(pSDERepItem);
    }

    @Override
    public boolean setModelV2Tag(PSDERepItem pSDERepItem, String string) {
        pSDERepItem.setPSDERepItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEREPITEMNAME", "");
        map.put("MAJORPSDEREPORTID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDERepItem pSDERepItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDERepItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDERepItem, true);
        pSDERepItem.set("PSDEREPITEMNAME", string);
        if (this.select(pSDERepItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDERepItem, true);
        return super.getModelV2Entity(pSDERepItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDERepItem pSDERepItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDERepItem, objectNode, string, string2, n);
    }
}

