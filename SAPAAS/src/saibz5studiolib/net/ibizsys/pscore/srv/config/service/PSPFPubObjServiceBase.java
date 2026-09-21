/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
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
package net.ibizsys.pscore.srv.config.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSPFPubObjDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFPubObjDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPubObj;
import net.ibizsys.pscore.srv.config.entity.PSPFPubObjBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.service.PSPFPubObjParamService;
import net.ibizsys.pscore.srv.config.service.PSPFPubObjParamServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPubObjService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPubObjServiceBase
extends PSCoreSysServiceBase<PSPFPubObj> {
    private static final Log log = LogFactory.getLog(PSPFPubObjServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFPubObjDEModel pSPFPubObjDEModel;
    private PSPFPubObjDAO pSPFPubObjDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFPubObjService";
    }

    public PSPFPubObjDEModel getPSPFPubObjDEModel() {
        if (this.pSPFPubObjDEModel == null) {
            try {
                this.pSPFPubObjDEModel = (PSPFPubObjDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPubObjDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPubObjDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFPubObjDEModel();
    }

    public PSPFPubObjDAO getPSPFPubObjDAO() {
        if (this.pSPFPubObjDAO == null) {
            try {
                this.pSPFPubObjDAO = (PSPFPubObjDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFPubObjDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPubObjDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFPubObjDAO();
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

    protected void onFillParentInfo(PSPFPubObj pSPFPubObj, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPUBOBJ_PSPFPUBOBJ_PPSPFPUBOBJID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubObjService", (SessionFactory)this.getSessionFactory());
            PSPFPubObj pSPFPubObj2 = (PSPFPubObj)iService.getDEModel().createEntity();
            pSPFPubObj2.set("PSPFPUBOBJID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFPubObj2);
            } else {
                iService.get((IEntity)pSPFPubObj2);
            }
            this.onFillParentInfo_Ppspfpubobj(pSPFPubObj, pSPFPubObj2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPUBOBJ_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFStyle);
            } else {
                iService.get((IEntity)pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSPFPubObj, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPUBOBJ_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPF);
            } else {
                iService.get((IEntity)pSPF);
            }
            this.onFillParentInfo_Pspf(pSPFPubObj, pSPF);
            return;
        }
        super.onFillParentInfo((IEntity)pSPFPubObj, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Ppspfpubobj(PSPFPubObj pSPFPubObj, PSPFPubObj pSPFPubObj2) throws Exception {
        pSPFPubObj.setPPSPFPubObjId(pSPFPubObj2.getPSPFPubObjId());
        pSPFPubObj.setPPSPFPubObjName(pSPFPubObj2.getPSPFPubObjName());
    }

    protected void onFillParentInfo_PSPFStyle(PSPFPubObj pSPFPubObj, PSPFStyle pSPFStyle) throws Exception {
        pSPFPubObj.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSPFPubObj.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_Pspf(PSPFPubObj pSPFPubObj, PSPF pSPF) throws Exception {
        pSPFPubObj.setPSPFId(pSPF.getPSPFId());
        pSPFPubObj.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillEntityFullInfo(PSPFPubObj pSPFPubObj, boolean bl) throws Exception {
        if (bl && pSPFPubObj.getValidFlag() == null) {
            pSPFPubObj.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSPFPubObj, bl);
        this.onFillEntityFullInfo_Ppspfpubobj(pSPFPubObj, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSPFPubObj, bl);
        this.onFillEntityFullInfo_Pspf(pSPFPubObj, bl);
    }

    protected void onFillEntityFullInfo_Ppspfpubobj(PSPFPubObj pSPFPubObj, boolean bl) throws Exception {
        if (pSPFPubObj.isPPSPFPubObjIdDirty()) {
            if (pSPFPubObj.getPPSPFPubObjId() != null) {
                if (pSPFPubObj.getPPSPFPubObjId() == null || pSPFPubObj.getPPSPFPubObjName() == null) {
                    PSPFPubObj pSPFPubObj2 = pSPFPubObj.getPpspfpubobj();
                    pSPFPubObj.setPPSPFPubObjName(pSPFPubObj2.getPSPFPubObjName());
                }
            } else {
                pSPFPubObj.setPPSPFPubObjName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSPFPubObj pSPFPubObj, boolean bl) throws Exception {
        if (pSPFPubObj.isPSPFStyleIdDirty()) {
            if (pSPFPubObj.getPSPFStyleId() != null) {
                if (pSPFPubObj.getPSPFStyleId() == null || pSPFPubObj.getPSPFStyleName() == null) {
                    PSPFStyle pSPFStyle = pSPFPubObj.getPSPFStyle();
                    pSPFPubObj.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                }
            } else {
                pSPFPubObj.setPSPFStyleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_Pspf(PSPFPubObj pSPFPubObj, boolean bl) throws Exception {
        if (pSPFPubObj.isPSPFIdDirty()) {
            if (pSPFPubObj.getPSPFId() != null) {
                if (pSPFPubObj.getPSPFId() == null || pSPFPubObj.getPSPFName() == null) {
                    PSPF pSPF = pSPFPubObj.getPspf();
                    pSPFPubObj.setPSPFName(pSPF.getPSPFName());
                }
            } else {
                pSPFPubObj.setPSPFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPFPubObj pSPFPubObj, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPFPubObj, bl);
    }

    public ArrayList<PSPFPubObj> selectByPpspfpubobj(PSPFPubObjBase pSPFPubObjBase) throws Exception {
        return this.selectByPpspfpubobj(pSPFPubObjBase, "", -1);
    }

    public ArrayList<PSPFPubObj> selectByPpspfpubobj(PSPFPubObjBase pSPFPubObjBase, String string) throws Exception {
        return this.selectByPpspfpubobj(pSPFPubObjBase, string, -1);
    }

    public ArrayList<PSPFPubObj> selectByPpspfpubobj(PSPFPubObjBase pSPFPubObjBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSPFPUBOBJID", (Object)pSPFPubObjBase.getPSPFPubObjId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPpspfpubobjCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPpspfpubobjCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFPubObj> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSPFPubObj> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSPFPubObj> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFSTYLEID", (Object)pSPFStyleBase.getPSPFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFPubObj> selectByPspf(PSPFBase pSPFBase) throws Exception {
        return this.selectByPspf(pSPFBase, "", -1);
    }

    public ArrayList<PSPFPubObj> selectByPspf(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPspf(pSPFBase, string, -1);
    }

    public ArrayList<PSPFPubObj> selectByPspf(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPspfCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPspfCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPpspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
        ArrayList<PSPFPubObj> arrayList = this.selectByPpspfpubobj(pSPFPubObj, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPUBOBJ");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPFPubObj);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPUBOBJ_PSPFPUBOBJ_PPSPFPUBOBJID", "", iDataEntityModel.getName(), "PSPFPUBOBJ", iDataEntityModel.getDataInfo((IEntity)pSPFPubObj), arrayList.get(0)));
        }
    }

    public void resetPpspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
        ArrayList<PSPFPubObj> arrayList = this.selectByPpspfpubobj(pSPFPubObj);
        for (PSPFPubObj pSPFPubObj2 : arrayList) {
            PSPFPubObj pSPFPubObj3 = (PSPFPubObj)this.getDEModel().createEntity();
            pSPFPubObj3.setPSPFPubObjId(pSPFPubObj2.getPSPFPubObjId());
            pSPFPubObj3.setPPSPFPubObjId(null);
            this.update(pSPFPubObj3);
        }
    }

    public void removeByPpspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
        final PSPFPubObj pSPFPubObj2 = pSPFPubObj;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPubObjServiceBase.this.onBeforeRemoveByPpspfpubobj(pSPFPubObj2);
                PSPFPubObjServiceBase.this.internalRemoveByPpspfpubobj(pSPFPubObj2);
                PSPFPubObjServiceBase.this.onAfterRemoveByPpspfpubobj(pSPFPubObj2);
            }
        });
    }

    protected void onBeforeRemoveByPpspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
    }

    protected void internalRemoveByPpspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
        ArrayList<PSPFPubObj> arrayList = this.selectByPpspfpubobj(pSPFPubObj);
        this.onBeforeRemoveByPpspfpubobj(pSPFPubObj, arrayList);
        for (PSPFPubObj pSPFPubObj2 : arrayList) {
            this.remove((IEntity)pSPFPubObj2);
        }
        this.onAfterRemoveByPpspfpubobj(pSPFPubObj, arrayList);
    }

    protected void onAfterRemoveByPpspfpubobj(PSPFPubObj pSPFPubObj) throws Exception {
    }

    protected void onBeforeRemoveByPpspfpubobj(PSPFPubObj pSPFPubObj, ArrayList<PSPFPubObj> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPpspfpubobj(PSPFPubObj pSPFPubObj, ArrayList<PSPFPubObj> arrayList) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFPubObj> arrayList = this.selectByPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPUBOBJ_PSPFSTYLE_PSPFSTYLEID", "", iDataEntityModel.getName(), "PSPFPUBOBJ", iDataEntityModel.getDataInfo((IEntity)pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFPubObj> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSPFPubObj pSPFPubObj : arrayList) {
            PSPFPubObj pSPFPubObj2 = (PSPFPubObj)this.getDEModel().createEntity();
            pSPFPubObj2.setPSPFPubObjId(pSPFPubObj.getPSPFPubObjId());
            pSPFPubObj2.setPSPFStyleId(null);
            this.update(pSPFPubObj2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPubObjServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSPFPubObjServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSPFPubObjServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFPubObj> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSPFPubObj pSPFPubObj : arrayList) {
            this.remove((IEntity)pSPFPubObj);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFPubObj> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFPubObj> arrayList) throws Exception {
    }

    public void testRemoveByPspf(PSPF pSPF) throws Exception {
        ArrayList<PSPFPubObj> arrayList = this.selectByPspf(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPUBOBJ_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSPFPUBOBJ", iDataEntityModel.getDataInfo((IEntity)pSPF), arrayList.get(0)));
        }
    }

    public void resetPspf(PSPF pSPF) throws Exception {
        ArrayList<PSPFPubObj> arrayList = this.selectByPspf(pSPF);
        for (PSPFPubObj pSPFPubObj : arrayList) {
            PSPFPubObj pSPFPubObj2 = (PSPFPubObj)this.getDEModel().createEntity();
            pSPFPubObj2.setPSPFPubObjId(pSPFPubObj.getPSPFPubObjId());
            pSPFPubObj2.setPSPFId(null);
            this.update(pSPFPubObj2);
        }
    }

    public void removeByPspf(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPubObjServiceBase.this.onBeforeRemoveByPspf(pSPF2);
                PSPFPubObjServiceBase.this.internalRemoveByPspf(pSPF2);
                PSPFPubObjServiceBase.this.onAfterRemoveByPspf(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPspf(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPspf(PSPF pSPF) throws Exception {
        ArrayList<PSPFPubObj> arrayList = this.selectByPspf(pSPF);
        this.onBeforeRemoveByPspf(pSPF, arrayList);
        for (PSPFPubObj pSPFPubObj : arrayList) {
            this.remove((IEntity)pSPFPubObj);
        }
        this.onAfterRemoveByPspf(pSPF, arrayList);
    }

    protected void onAfterRemoveByPspf(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPspf(PSPF pSPF, ArrayList<PSPFPubObj> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPspf(PSPF pSPF, ArrayList<PSPFPubObj> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFPubObj pSPFPubObj) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPFPubObjParamService)ServiceGlobal.getService(PSPFPubObjParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPubObjParamServiceBase)pSCoreSysServiceBase).testRemoveByPspfpubobj(pSPFPubObj);
        ((PSPFPubObjParamServiceBase)pSCoreSysServiceBase).removeByPspfpubobj(pSPFPubObj);
        pSCoreSysServiceBase = (PSPFPubObjService)ServiceGlobal.getService(PSPFPubObjService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPubObjServiceBase)pSCoreSysServiceBase).testRemoveByPpspfpubobj(pSPFPubObj);
        super.onBeforeRemove(pSPFPubObj);
    }

    protected void replaceParentInfo(PSPFPubObj pSPFPubObj, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPFPubObj, cloneSession);
        if (pSPFPubObj.getPPSPFPubObjId() != null && (iEntity = cloneSession.getEntity("PSPFPUBOBJ", (Object)pSPFPubObj.getPPSPFPubObjId())) != null) {
            this.onFillParentInfo_Ppspfpubobj(pSPFPubObj, (PSPFPubObj)iEntity);
        }
        if (pSPFPubObj.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSPFPubObj.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSPFPubObj, (PSPFStyle)iEntity);
        }
        if (pSPFPubObj.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFPubObj.getPSPFId())) != null) {
            this.onFillParentInfo_Pspf(pSPFPubObj, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFPubObj pSPFPubObj, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPFPubObj, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_MacroParams(bl, pSPFPubObj, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSPFPubObjId(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSPFPubObjName(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubObjId(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubObjName(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleName(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObjTag(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObjTag2(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Target(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetType(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSPFPubObj, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPFPubObj, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_MacroParams(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isMacroParamsDirty() : !pSPFPubObj.isMacroParamsDirty()) {
            return null;
        }
        String string = pSPFPubObj.getMacroParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MacroParams_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MACROPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isMemoDirty() : !pSPFPubObj.isMemoDirty()) {
            return null;
        }
        String string = pSPFPubObj.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPFPubObj, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSPFPubObjId(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPPSPFPubObjIdDirty() : !pSPFPubObj.isPPSPFPubObjIdDirty()) {
            return null;
        }
        String string = pSPFPubObj.getPPSPFPubObjId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSPFPubObjId_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSPFPUBOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSPFPubObjName(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPPSPFPubObjNameDirty() : !pSPFPubObj.isPPSPFPubObjNameDirty()) {
            return null;
        }
        String string = pSPFPubObj.getPPSPFPubObjName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSPFPubObjName_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSPFPUBOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPSPFIdDirty() : !pSPFPubObj.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFPubObj.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPSPFNameDirty() : !pSPFPubObj.isPSPFNameDirty()) {
            return null;
        }
        String string = pSPFPubObj.getPSPFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubObjId(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPSPFPubObjIdDirty() && !bl2 : !pSPFPubObj.isPSPFPubObjIdDirty()) {
            return null;
        }
        String string = pSPFPubObj.getPSPFPubObjId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBOBJID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubObjId_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBOBJID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubObjName(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPSPFPubObjNameDirty() && !bl2 : !pSPFPubObj.isPSPFPubObjNameDirty()) {
            return null;
        }
        String string = pSPFPubObj.getPSPFPubObjName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBOBJNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubObjName_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBOBJNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPSPFStyleIdDirty() : !pSPFPubObj.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSPFPubObj.getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleName(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPSPFStyleNameDirty() : !pSPFPubObj.isPSPFStyleNameDirty()) {
            return null;
        }
        String string = pSPFPubObj.getPSPFStyleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleName_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPubObjDirty() && !bl2 : !pSPFPubObj.isPubObjDirty()) {
            return null;
        }
        String string = pSPFPubObj.getPubObj();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObjTag(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPubObjTagDirty() : !pSPFPubObj.isPubObjTagDirty()) {
            return null;
        }
        String string = pSPFPubObj.getPubObjTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObjTag_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObjTag2(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isPubObjTag2Dirty() : !pSPFPubObj.isPubObjTag2Dirty()) {
            return null;
        }
        String string = pSPFPubObj.getPubObjTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObjTag2_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Target(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isTargetDirty() && !bl2 : !pSPFPubObj.isTargetDirty()) {
            return null;
        }
        String string = pSPFPubObj.getTarget();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGET");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Target_Default((IEntity)pSPFPubObj, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetType(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isTargetTypeDirty() && !bl2 : !pSPFPubObj.isTargetTypeDirty()) {
            return null;
        }
        String string = pSPFPubObj.getTargetType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetType_Default((IEntity)pSPFPubObj, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSPFPubObj pSPFPubObj, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubObj.isValidFlagDirty() && !bl2 : !pSPFPubObj.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSPFPubObj.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSPFPubObj, bl2, bl3);
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

    protected void onSyncEntity(PSPFPubObj pSPFPubObj, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPFPubObj, bl);
    }

    protected void onSyncIndexEntities(PSPFPubObj pSPFPubObj, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPFPubObj, bl);
    }

    public Object getDataContextValue(PSPFPubObj pSPFPubObj, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPFPubObj, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPFPubObj pSPFPubObj, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPFPubObj, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MACROPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MacroParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSPFPUBOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSPFPubObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSPFPUBOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSPFPubObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBOBJID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubObjId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBOBJNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubObjName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObjTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObjTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Target_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_MacroParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MACROPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSPFPubObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSPFPUBOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSPFPubObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSPFPUBOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubObjId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBOBJID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubObjName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBOBJNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObjTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubObjTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Target_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGET", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSPFPubObj pSPFPubObj) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPFPubObj)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFPubObj pSPFPubObj) throws Exception {
        super.onUpdateParent((IEntity)pSPFPubObj);
    }

    @Override
    protected void exportCurXmlModel(PSPFPubObj pSPFPubObj, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFPUBOBJ");
        if (!bl) {
            pSPFPubObj.setCreateDate(null);
            pSPFPubObj.setCreateMan(null);
            pSPFPubObj.setPSPFPubObjId(null);
            pSPFPubObj.setUpdateDate(null);
            pSPFPubObj.setUpdateMan(null);
            super.exportCurXmlModel(pSPFPubObj, xmlNode, bl);
        }
    }
}

