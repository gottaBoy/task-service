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
import net.ibizsys.pscore.srv.dedesign.dao.PSDENotifyTargetDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDENotifyTargetDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotify;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotifyBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotifyTarget;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTarget;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTargetBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDENotifyTargetServiceBase
extends PSCoreSysServiceBase<PSDENotifyTarget> {
    private static final Log log = LogFactory.getLog(PSDENotifyTargetServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDENotifyTargetDEModel pSDENotifyTargetDEModel;
    private PSDENotifyTargetDAO pSDENotifyTargetDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDENotifyTargetService";
    }

    public PSDENotifyTargetDEModel getPSDENotifyTargetDEModel() {
        if (this.pSDENotifyTargetDEModel == null) {
            try {
                this.pSDENotifyTargetDEModel = (PSDENotifyTargetDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDENotifyTargetDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDENotifyTargetDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDENotifyTargetDEModel();
    }

    public PSDENotifyTargetDAO getPSDENotifyTargetDAO() {
        if (this.pSDENotifyTargetDAO == null) {
            try {
                this.pSDENotifyTargetDAO = (PSDENotifyTargetDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDENotifyTargetDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDENotifyTargetDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDENotifyTargetDAO();
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

    protected void onFillParentInfo(PSDENotifyTarget pSDENotifyTarget, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFYTARGET_PSDEFIELD_TARGETPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TargetPSDEF(pSDENotifyTarget, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFYTARGET_PSDEFIELD_TARGETTYPEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TargetTypePSDEF(pSDENotifyTarget, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFYTARGET_PSDENOTIFY_PSDENOTIFYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService", (SessionFactory)this.getSessionFactory());
            PSDENotify pSDENotify = (PSDENotify)iService.getDEModel().createEntity();
            pSDENotify.set("PSDENOTIFYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDENotify);
            } else {
                iService.get((IEntity)pSDENotify);
            }
            this.onFillParentInfo_PSDENotify(pSDENotifyTarget, pSDENotify);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDENOTIFYTARGET_PSSYSMSGTARGET_PSSYSMSGTARGETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTargetService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTarget pSSysMsgTarget = (PSSysMsgTarget)iService.getDEModel().createEntity();
            pSSysMsgTarget.set("PSSYSMSGTARGETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysMsgTarget);
            } else {
                iService.get((IEntity)pSSysMsgTarget);
            }
            this.onFillParentInfo_PSSysMsgTarget(pSDENotifyTarget, pSSysMsgTarget);
            return;
        }
        super.onFillParentInfo((IEntity)pSDENotifyTarget, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_TargetPSDEF(PSDENotifyTarget pSDENotifyTarget, PSDEField pSDEField) throws Exception {
        pSDENotifyTarget.setTargetPSDEFId(pSDEField.getPSDEFieldId());
        pSDENotifyTarget.setTargetPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TargetTypePSDEF(PSDENotifyTarget pSDENotifyTarget, PSDEField pSDEField) throws Exception {
        pSDENotifyTarget.setTargetTypePSDEFId(pSDEField.getPSDEFieldId());
        pSDENotifyTarget.setTargetTypePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDENotify(PSDENotifyTarget pSDENotifyTarget, PSDENotify pSDENotify) throws Exception {
        pSDENotifyTarget.setPSDEId(pSDENotify.getPSDEId());
        pSDENotifyTarget.setPSDENotifyId(pSDENotify.getPSDENotifyId());
        pSDENotifyTarget.setPSDENotifyName(pSDENotify.getPSDENotifyName());
    }

    protected void onFillParentInfo_PSSysMsgTarget(PSDENotifyTarget pSDENotifyTarget, PSSysMsgTarget pSSysMsgTarget) throws Exception {
        pSDENotifyTarget.setPSSysMsgTargetId(pSSysMsgTarget.getPSSysMsgTargetId());
        pSDENotifyTarget.setPSSysMsgTargetName(pSSysMsgTarget.getPSSysMsgTargetName());
    }

    protected void onFillEntityFullInfo(PSDENotifyTarget pSDENotifyTarget, boolean bl) throws Exception {
        if (bl) {
            if (pSDENotifyTarget.getTargetType() == null) {
                pSDENotifyTarget.setTargetType((String)this.getDefaultValue(this.getWebContext(), "", "DEFIELD", 25));
            }
            if (pSDENotifyTarget.getValidFlag() == null) {
                pSDENotifyTarget.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDENotifyTarget, bl);
        this.onFillEntityFullInfo_TargetPSDEF(pSDENotifyTarget, bl);
        this.onFillEntityFullInfo_TargetTypePSDEF(pSDENotifyTarget, bl);
        this.onFillEntityFullInfo_PSDENotify(pSDENotifyTarget, bl);
        this.onFillEntityFullInfo_PSSysMsgTarget(pSDENotifyTarget, bl);
    }

    protected void onFillEntityFullInfo_TargetPSDEF(PSDENotifyTarget pSDENotifyTarget, boolean bl) throws Exception {
        if (pSDENotifyTarget.isTargetPSDEFIdDirty()) {
            if (pSDENotifyTarget.getTargetPSDEFId() != null) {
                if (pSDENotifyTarget.getTargetPSDEFId() == null || pSDENotifyTarget.getTargetPSDEFName() == null) {
                    PSDEField pSDEField = pSDENotifyTarget.getTargetPSDEF();
                    pSDENotifyTarget.setTargetPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDENotifyTarget.setTargetPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TargetTypePSDEF(PSDENotifyTarget pSDENotifyTarget, boolean bl) throws Exception {
        if (pSDENotifyTarget.isTargetTypePSDEFIdDirty()) {
            if (pSDENotifyTarget.getTargetTypePSDEFId() != null) {
                if (pSDENotifyTarget.getTargetTypePSDEFId() == null || pSDENotifyTarget.getTargetTypePSDEFName() == null) {
                    PSDEField pSDEField = pSDENotifyTarget.getTargetTypePSDEF();
                    pSDENotifyTarget.setTargetTypePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDENotifyTarget.setTargetTypePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDENotify(PSDENotifyTarget pSDENotifyTarget, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysMsgTarget(PSDENotifyTarget pSDENotifyTarget, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDENotifyTarget pSDENotifyTarget, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDENotifyTarget, bl);
    }

    public ArrayList<PSDENotifyTarget> selectByTargetPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTargetPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDENotifyTarget> selectByTargetPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTargetPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDENotifyTarget> selectByTargetPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TARGETPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTargetPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTargetPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotifyTarget> selectByTargetTypePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTargetTypePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDENotifyTarget> selectByTargetTypePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTargetTypePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDENotifyTarget> selectByTargetTypePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TARGETTYPEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTargetTypePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTargetTypePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotifyTarget> selectByPSDENotify(PSDENotifyBase pSDENotifyBase) throws Exception {
        return this.selectByPSDENotify(pSDENotifyBase, "", -1);
    }

    public ArrayList<PSDENotifyTarget> selectByPSDENotify(PSDENotifyBase pSDENotifyBase, String string) throws Exception {
        return this.selectByPSDENotify(pSDENotifyBase, string, -1);
    }

    public ArrayList<PSDENotifyTarget> selectByPSDENotify(PSDENotifyBase pSDENotifyBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDENOTIFYID", (Object)pSDENotifyBase.getPSDENotifyId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDENotifyCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDENotifyCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotifyTarget> selectTempByPSDENotify(PSDENotifyBase pSDENotifyBase) throws Exception {
        return this.selectTempByPSDENotify(pSDENotifyBase, "");
    }

    public ArrayList<PSDENotifyTarget> selectTempByPSDENotify(PSDENotifyBase pSDENotifyBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDENOTIFYID", (Object)pSDENotifyBase.getPSDENotifyId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDENotifyCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDENotifyCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDENotifyTarget> selectByPSSysMsgTarget(PSSysMsgTargetBase pSSysMsgTargetBase) throws Exception {
        return this.selectByPSSysMsgTarget(pSSysMsgTargetBase, "", -1);
    }

    public ArrayList<PSDENotifyTarget> selectByPSSysMsgTarget(PSSysMsgTargetBase pSSysMsgTargetBase, String string) throws Exception {
        return this.selectByPSSysMsgTarget(pSSysMsgTargetBase, string, -1);
    }

    public ArrayList<PSDENotifyTarget> selectByPSSysMsgTarget(PSSysMsgTargetBase pSSysMsgTargetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMSGTARGETID", (Object)pSSysMsgTargetBase.getPSSysMsgTargetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMsgTargetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMsgTargetCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByTargetPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFYTARGET_PSDEFIELD_TARGETPSDEFID", "", iDataEntityModel.getName(), "PSDENOTIFYTARGET", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTargetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByTargetPSDEF(pSDEField);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            PSDENotifyTarget pSDENotifyTarget2 = (PSDENotifyTarget)this.getDEModel().createEntity();
            pSDENotifyTarget2.setPSDENotifyTargetId(pSDENotifyTarget.getPSDENotifyTargetId());
            pSDENotifyTarget2.setTargetPSDEFId(null);
            this.update(pSDENotifyTarget2);
        }
    }

    public void removeByTargetPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyTargetServiceBase.this.onBeforeRemoveByTargetPSDEF(pSDEField2);
                PSDENotifyTargetServiceBase.this.internalRemoveByTargetPSDEF(pSDEField2);
                PSDENotifyTargetServiceBase.this.onAfterRemoveByTargetPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByTargetPSDEF(pSDEField);
        this.onBeforeRemoveByTargetPSDEF(pSDEField, arrayList);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            this.remove((IEntity)pSDENotifyTarget);
        }
        this.onAfterRemoveByTargetPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTargetPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTargetPSDEF(PSDEField pSDEField, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTargetPSDEF(PSDEField pSDEField, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
    }

    public void testRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByTargetTypePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFYTARGET_PSDEFIELD_TARGETTYPEPSDEFID", "", iDataEntityModel.getName(), "PSDENOTIFYTARGET", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByTargetTypePSDEF(pSDEField);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            PSDENotifyTarget pSDENotifyTarget2 = (PSDENotifyTarget)this.getDEModel().createEntity();
            pSDENotifyTarget2.setPSDENotifyTargetId(pSDENotifyTarget.getPSDENotifyTargetId());
            pSDENotifyTarget2.setTargetTypePSDEFId(null);
            this.update(pSDENotifyTarget2);
        }
    }

    public void removeByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyTargetServiceBase.this.onBeforeRemoveByTargetTypePSDEF(pSDEField2);
                PSDENotifyTargetServiceBase.this.internalRemoveByTargetTypePSDEF(pSDEField2);
                PSDENotifyTargetServiceBase.this.onAfterRemoveByTargetTypePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByTargetTypePSDEF(pSDEField);
        this.onBeforeRemoveByTargetTypePSDEF(pSDEField, arrayList);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            this.remove((IEntity)pSDENotifyTarget);
        }
        this.onAfterRemoveByTargetTypePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTargetTypePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTargetTypePSDEF(PSDEField pSDEField, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTargetTypePSDEF(PSDEField pSDEField, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
    }

    public void testRemoveByPSDENotify(PSDENotify pSDENotify) throws Exception {
    }

    public void resetPSDENotify(PSDENotify pSDENotify) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByPSDENotify(pSDENotify);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            PSDENotifyTarget pSDENotifyTarget2 = (PSDENotifyTarget)this.getDEModel().createEntity();
            pSDENotifyTarget2.setPSDENotifyTargetId(pSDENotifyTarget.getPSDENotifyTargetId());
            pSDENotifyTarget2.setPSDENotifyId(null);
            this.update(pSDENotifyTarget2);
        }
    }

    public void resetTempPSDENotify(PSDENotify pSDENotify) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectTempByPSDENotify(pSDENotify);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            PSDENotifyTarget pSDENotifyTarget2 = (PSDENotifyTarget)this.getDEModel().createEntity();
            pSDENotifyTarget2.setPSDENotifyTargetId(pSDENotifyTarget.getPSDENotifyTargetId());
            pSDENotifyTarget2.setPSDENotifyId(null);
            this.updateTemp((IEntity)pSDENotifyTarget2);
        }
    }

    public void removeByPSDENotify(PSDENotify pSDENotify) throws Exception {
        final PSDENotify pSDENotify2 = pSDENotify;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyTargetServiceBase.this.onBeforeRemoveByPSDENotify(pSDENotify2);
                PSDENotifyTargetServiceBase.this.internalRemoveByPSDENotify(pSDENotify2);
                PSDENotifyTargetServiceBase.this.onAfterRemoveByPSDENotify(pSDENotify2);
            }
        });
    }

    protected void onBeforeRemoveByPSDENotify(PSDENotify pSDENotify) throws Exception {
    }

    protected void internalRemoveByPSDENotify(PSDENotify pSDENotify) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByPSDENotify(pSDENotify);
        this.onBeforeRemoveByPSDENotify(pSDENotify, arrayList);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            this.remove((IEntity)pSDENotifyTarget);
        }
        this.onAfterRemoveByPSDENotify(pSDENotify, arrayList);
    }

    protected void onAfterRemoveByPSDENotify(PSDENotify pSDENotify) throws Exception {
    }

    protected void onBeforeRemoveByPSDENotify(PSDENotify pSDENotify, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDENotify(PSDENotify pSDENotify, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMsgTarget(PSSysMsgTarget pSSysMsgTarget) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByPSSysMsgTarget(pSSysMsgTarget, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTARGET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysMsgTarget);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDENOTIFYTARGET_PSSYSMSGTARGET_PSSYSMSGTARGETID", "", iDataEntityModel.getName(), "PSDENOTIFYTARGET", iDataEntityModel.getDataInfo((IEntity)pSSysMsgTarget), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgTarget(PSSysMsgTarget pSSysMsgTarget) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByPSSysMsgTarget(pSSysMsgTarget);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            PSDENotifyTarget pSDENotifyTarget2 = (PSDENotifyTarget)this.getDEModel().createEntity();
            pSDENotifyTarget2.setPSDENotifyTargetId(pSDENotifyTarget.getPSDENotifyTargetId());
            pSDENotifyTarget2.setPSSysMsgTargetId(null);
            this.update(pSDENotifyTarget2);
        }
    }

    public void removeByPSSysMsgTarget(PSSysMsgTarget pSSysMsgTarget) throws Exception {
        final PSSysMsgTarget pSSysMsgTarget2 = pSSysMsgTarget;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyTargetServiceBase.this.onBeforeRemoveByPSSysMsgTarget(pSSysMsgTarget2);
                PSDENotifyTargetServiceBase.this.internalRemoveByPSSysMsgTarget(pSSysMsgTarget2);
                PSDENotifyTargetServiceBase.this.onAfterRemoveByPSSysMsgTarget(pSSysMsgTarget2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgTarget(PSSysMsgTarget pSSysMsgTarget) throws Exception {
    }

    protected void internalRemoveByPSSysMsgTarget(PSSysMsgTarget pSSysMsgTarget) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectByPSSysMsgTarget(pSSysMsgTarget);
        this.onBeforeRemoveByPSSysMsgTarget(pSSysMsgTarget, arrayList);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            this.remove((IEntity)pSDENotifyTarget);
        }
        this.onAfterRemoveByPSSysMsgTarget(pSSysMsgTarget, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgTarget(PSSysMsgTarget pSSysMsgTarget) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgTarget(PSSysMsgTarget pSSysMsgTarget, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgTarget(PSSysMsgTarget pSSysMsgTarget, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDENotifyTarget pSDENotifyTarget) throws Exception {
        super.onBeforeRemove(pSDENotifyTarget);
    }

    public void removeTempByPSDENotify(PSDENotify pSDENotify) throws Exception {
        final PSDENotify pSDENotify2 = pSDENotify;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDENotifyTargetServiceBase.this.onBeforeRemoveTempByPSDENotify(pSDENotify2);
                PSDENotifyTargetServiceBase.this.internalRemoveTempByPSDENotify(pSDENotify2);
                PSDENotifyTargetServiceBase.this.onAfterRemoveTempByPSDENotify(pSDENotify2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDENotify(PSDENotify pSDENotify) throws Exception {
    }

    protected void internalRemoveTempByPSDENotify(PSDENotify pSDENotify) throws Exception {
        ArrayList<PSDENotifyTarget> arrayList = this.selectTempByPSDENotify(pSDENotify);
        this.onBeforeRemoveTempByPSDENotify(pSDENotify, arrayList);
        for (PSDENotifyTarget pSDENotifyTarget : arrayList) {
            this.removeTemp((IEntity)pSDENotifyTarget);
        }
        this.onAfterRemoveTempByPSDENotify(pSDENotify, arrayList);
    }

    protected void onAfterRemoveTempByPSDENotify(PSDENotify pSDENotify) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDENotify(PSDENotify pSDENotify, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDENotify(PSDENotify pSDENotify, ArrayList<PSDENotifyTarget> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDENotifyTarget pSDENotifyTarget, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDENotifyTarget, cloneSession);
        if (pSDENotifyTarget.getTargetPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDENotifyTarget.getTargetPSDEFId())) != null) {
            this.onFillParentInfo_TargetPSDEF(pSDENotifyTarget, (PSDEField)iEntity);
        }
        if (pSDENotifyTarget.getTargetTypePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDENotifyTarget.getTargetTypePSDEFId())) != null) {
            this.onFillParentInfo_TargetTypePSDEF(pSDENotifyTarget, (PSDEField)iEntity);
        }
        if (pSDENotifyTarget.getPSDENotifyId() != null && (iEntity = cloneSession.getEntity("PSDENOTIFY", (Object)pSDENotifyTarget.getPSDENotifyId())) != null) {
            this.onFillParentInfo_PSDENotify(pSDENotifyTarget, (PSDENotify)iEntity);
        }
        if (pSDENotifyTarget.getPSSysMsgTargetId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTARGET", (Object)pSDENotifyTarget.getPSSysMsgTargetId())) != null) {
            this.onFillParentInfo_PSSysMsgTarget(pSDENotifyTarget, (PSSysMsgTarget)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDENotifyTarget pSDENotifyTarget, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDENotifyTarget, bl);
    }

    protected void onCheckEntity(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Data(bl, pSDENotifyTarget, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Filter(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDENotifyId(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDENotifyTargetId(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDENotifyTargetName(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTargetId(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetPSDEFId(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetPSDEFName(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetType(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetTypePSDEFId(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetTypePSDEFName(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDENotifyTarget, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDENotifyTarget, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Data(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isDataDirty() : !pSDENotifyTarget.isDataDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Data_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Filter(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isFilterDirty() : !pSDENotifyTarget.isFilterDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Filter_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isMemoDirty() : !pSDENotifyTarget.isMemoDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDENotifyTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDENotifyId(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isPSDENotifyIdDirty() && !bl2 : !pSDENotifyTarget.isPSDENotifyIdDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getPSDENotifyId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDENotifyId_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDENotifyTargetId(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isPSDENotifyTargetIdDirty() && !bl2 : !pSDENotifyTarget.isPSDENotifyTargetIdDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getPSDENotifyTargetId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYTARGETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDENotifyTargetId_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYTARGETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDENotifyTargetName(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isPSDENotifyTargetNameDirty() && !bl2 : !pSDENotifyTarget.isPSDENotifyTargetNameDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getPSDENotifyTargetName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYTARGETNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDENotifyTargetName_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENOTIFYTARGETNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysMsgTargetId(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isPSSysMsgTargetIdDirty() : !pSDENotifyTarget.isPSSysMsgTargetIdDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getPSSysMsgTargetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTargetId_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTARGETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetPSDEFId(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isTargetPSDEFIdDirty() : !pSDENotifyTarget.isTargetPSDEFIdDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getTargetPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetPSDEFId_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetPSDEFName(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isTargetPSDEFNameDirty() : !pSDENotifyTarget.isTargetPSDEFNameDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getTargetPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetPSDEFName_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetType(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isTargetTypeDirty() && !bl2 : !pSDENotifyTarget.isTargetTypeDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getTargetType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetType_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetTypePSDEFId(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isTargetTypePSDEFIdDirty() : !pSDENotifyTarget.isTargetTypePSDEFIdDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getTargetTypePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetTypePSDEFId_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetTypePSDEFName(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isTargetTypePSDEFNameDirty() : !pSDENotifyTarget.isTargetTypePSDEFNameDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getTargetTypePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetTypePSDEFName_Default((IEntity)pSDENotifyTarget, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isUserCatDirty() : !pSDENotifyTarget.isUserCatDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDENotifyTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isUserTagDirty() : !pSDENotifyTarget.isUserTagDirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDENotifyTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isUserTag2Dirty() : !pSDENotifyTarget.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDENotifyTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isUserTag3Dirty() : !pSDENotifyTarget.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDENotifyTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isUserTag4Dirty() : !pSDENotifyTarget.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDENotifyTarget.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDENotifyTarget, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDENotifyTarget pSDENotifyTarget, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDENotifyTarget.isValidFlagDirty() && !bl2 : !pSDENotifyTarget.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDENotifyTarget.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDENotifyTarget, bl2, bl3);
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

    protected void onSyncEntity(PSDENotifyTarget pSDENotifyTarget, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDENotifyTarget, bl);
    }

    protected void onSyncIndexEntities(PSDENotifyTarget pSDENotifyTarget, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDENotifyTarget, bl);
    }

    public Object getDataContextValue(PSDENotifyTarget pSDENotifyTarget, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDENotifyTarget, string, iDataContextParam)) != null) {
            return object;
        }
        PSDENotify pSDENotify = pSDENotifyTarget.getPSDENotify();
        if (pSDENotify != null && pSDENotify.contains(string)) {
            return pSDENotify.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDENotifyTarget pSDENotifyTarget, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDENotifyTarget, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Data_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Filter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENOTIFYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDENotifyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENOTIFYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDENotifyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENOTIFYTARGETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDENotifyTargetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENOTIFYTARGETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDENotifyTargetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTARGETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTargetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTARGETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTargetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetTypePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetTypePSDEFName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_Data_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATA", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Filter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILTER", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_PSDENotifyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENOTIFYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDENotifyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENOTIFYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDENotifyTargetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENOTIFYTARGETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDENotifyTargetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENOTIFYTARGETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTargetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTARGETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTargetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTARGETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetTypePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetTypePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDENotifyTarget pSDENotifyTarget) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDENotifyTarget)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDENotifyTarget pSDENotifyTarget) throws Exception {
        super.onUpdateParent((IEntity)pSDENotifyTarget);
    }

    @Override
    protected void exportCurXmlModel(PSDENotifyTarget pSDENotifyTarget, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDENOTIFYTARGET");
        if (!bl) {
            pSDENotifyTarget.setCreateDate(null);
            pSDENotifyTarget.setCreateMan(null);
            pSDENotifyTarget.setPSDENotifyName(null);
            pSDENotifyTarget.setPSDENotifyTargetId(null);
            pSDENotifyTarget.setUpdateDate(null);
            pSDENotifyTarget.setUpdateMan(null);
            pSDENotifyTarget.setPSDEId(null);
            pSDENotifyTarget.setPSDENotifyId(null);
            pSDENotifyTarget.setPSDENotifyName(null);
            super.exportCurXmlModel(pSDENotifyTarget, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDENotifyTarget pSDENotifyTarget, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDENotifyTarget, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENOTIFYID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDENOTIFY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENOTIFYID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDENOTIFYTARGET_PSDENOTIFY_PSDENOTIFYID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENOTIFYID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENOTIFYNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDENOTIFY", (boolean)true) == 0) {
            iEntity.set("PSDENOTIFYID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDENOTIFYID"};
    }

    @Override
    public String getModelV2Tag(PSDENotifyTarget pSDENotifyTarget) {
        return super.getModelV2Tag(pSDENotifyTarget);
    }

    @Override
    public boolean setModelV2Tag(PSDENotifyTarget pSDENotifyTarget, String string) {
        return super.setModelV2Tag(pSDENotifyTarget, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDENOTIFYID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDENotifyTarget pSDENotifyTarget, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDENotifyTarget.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDENotifyTarget, true);
        return super.getModelV2Entity(pSDENotifyTarget, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDENotifyTarget pSDENotifyTarget, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDENotifyTarget, objectNode, string, string2, n);
    }
}

