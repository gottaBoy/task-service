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
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppPortletDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppPortletDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDEBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortlet;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortletBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppPortletServiceBase
extends PSCoreSysServiceBase<PSAppPortlet> {
    private static final Log log = LogFactory.getLog(PSAppPortletServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppPortletDEModel pSAppPortletDEModel;
    private PSAppPortletDAO pSAppPortletDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppPortletService";
    }

    public PSAppPortletDEModel getPSAppPortletDEModel() {
        if (this.pSAppPortletDEModel == null) {
            try {
                this.pSAppPortletDEModel = (PSAppPortletDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppPortletDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppPortletDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppPortletDEModel();
    }

    public PSAppPortletDAO getPSAppPortletDAO() {
        if (this.pSAppPortletDAO == null) {
            try {
                this.pSAppPortletDAO = (PSAppPortletDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppPortletDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppPortletDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppPortletDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSAppPortlet pSAppPortlet, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPORTLET_PSAPPLOCALDE_PSAPPLOCALDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService", (SessionFactory)this.getSessionFactory());
            PSAppLocalDE pSAppLocalDE = (PSAppLocalDE)iService.getDEModel().createEntity();
            pSAppLocalDE.set("PSAPPLOCALDEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppLocalDE);
            } else {
                iService.get(pSAppLocalDE);
            }
            this.onFillParentInfo_PSAppLocalDE(pSAppPortlet, pSAppLocalDE);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppPortlet, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPPORTLET_PSSYSPORTLET_PSSYSPORTLETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService", (SessionFactory)this.getSessionFactory());
            PSSysPortlet pSSysPortlet = (PSSysPortlet)iService.getDEModel().createEntity();
            pSSysPortlet.set("PSSYSPORTLETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPortlet);
            } else {
                iService.get(pSSysPortlet);
            }
            this.onFillParentInfo_PSSysPortlet(pSAppPortlet, pSSysPortlet);
            return;
        }
        super.onFillParentInfo(pSAppPortlet, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppLocalDE(PSAppPortlet pSAppPortlet, PSAppLocalDE pSAppLocalDE) throws Exception {
        pSAppPortlet.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
        pSAppPortlet.setPSAppLocalDEName(pSAppLocalDE.getPSAppLocalDEName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppPortlet pSAppPortlet, PSSysApp pSSysApp) throws Exception {
        pSAppPortlet.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppPortlet.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysPortlet(PSAppPortlet pSAppPortlet, PSSysPortlet pSSysPortlet) throws Exception {
        pSAppPortlet.setPSSysPortletId(pSSysPortlet.getPSSysPortletId());
        pSAppPortlet.setPSSysPortletName(pSSysPortlet.getPSSysPortletName());
    }

    protected void onFillEntityFullInfo(PSAppPortlet pSAppPortlet, boolean bl) throws Exception {
        if (bl && pSAppPortlet.getValidFlag() == null) {
            pSAppPortlet.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSAppPortlet, bl);
        this.onFillEntityFullInfo_PSAppLocalDE(pSAppPortlet, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppPortlet, bl);
        this.onFillEntityFullInfo_PSSysPortlet(pSAppPortlet, bl);
    }

    protected void onFillEntityFullInfo_PSAppLocalDE(PSAppPortlet pSAppPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppPortlet pSAppPortlet, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPortlet(PSAppPortlet pSAppPortlet, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppPortlet pSAppPortlet, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppPortlet, bl);
    }

    public ArrayList<PSAppPortlet> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase) throws Exception {
        return this.selectByPSAppLocalDE(pSAppLocalDEBase, "", -1);
    }

    public ArrayList<PSAppPortlet> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string) throws Exception {
        return this.selectByPSAppLocalDE(pSAppLocalDEBase, string, -1);
    }

    public ArrayList<PSAppPortlet> selectByPSAppLocalDE(PSAppLocalDEBase pSAppLocalDEBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPLOCALDEID", (Object)pSAppLocalDEBase.getPSAppLocalDEId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppLocalDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppLocalDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPortlet> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppPortlet> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppPortlet> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppPortlet> selectByPSSysPortlet(PSSysPortletBase pSSysPortletBase) throws Exception {
        return this.selectByPSSysPortlet(pSSysPortletBase, "", -1);
    }

    public ArrayList<PSAppPortlet> selectByPSSysPortlet(PSSysPortletBase pSSysPortletBase, String string) throws Exception {
        return this.selectByPSSysPortlet(pSSysPortletBase, string, -1);
    }

    public ArrayList<PSAppPortlet> selectByPSSysPortlet(PSSysPortletBase pSSysPortletBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPORTLETID", (Object)pSSysPortletBase.getPSSysPortletId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPortletCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPortletCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppPortlet> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPLOCALDE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppLocalDE);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPORTLET_PSAPPLOCALDE_PSAPPLOCALDEID", "", iDataEntityModel.getName(), "PSAPPPORTLET", iDataEntityModel.getDataInfo(pSAppLocalDE), arrayList.get(0)));
        }
    }

    public void resetPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppPortlet> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE);
        for (PSAppPortlet pSAppPortlet : arrayList) {
            PSAppPortlet pSAppPortlet2 = (PSAppPortlet)this.getDEModel().createEntity();
            pSAppPortlet2.setPSAppPortletId(pSAppPortlet.getPSAppPortletId());
            pSAppPortlet2.setPSAppLocalDEId(null);
            this.update(pSAppPortlet2);
        }
    }

    public void removeByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        final PSAppLocalDE pSAppLocalDE2 = pSAppLocalDE;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPortletServiceBase.this.onBeforeRemoveByPSAppLocalDE(pSAppLocalDE2);
                PSAppPortletServiceBase.this.internalRemoveByPSAppLocalDE(pSAppLocalDE2);
                PSAppPortletServiceBase.this.onAfterRemoveByPSAppLocalDE(pSAppLocalDE2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void internalRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
        ArrayList<PSAppPortlet> arrayList = this.selectByPSAppLocalDE(pSAppLocalDE);
        this.onBeforeRemoveByPSAppLocalDE(pSAppLocalDE, arrayList);
        for (PSAppPortlet pSAppPortlet : arrayList) {
            this.remove(pSAppPortlet);
        }
        this.onAfterRemoveByPSAppLocalDE(pSAppLocalDE, arrayList);
    }

    protected void onAfterRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE) throws Exception {
    }

    protected void onBeforeRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<PSAppPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppLocalDE(PSAppLocalDE pSAppLocalDE, ArrayList<PSAppPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppPortlet> arrayList = this.selectByPSSysApp(pSSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID", "", iDataEntityModel.getName(), "PSAPPPORTLET", iDataEntityModel.getDataInfo(pSSysApp), arrayList.get(0)));
        }
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppPortlet> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppPortlet pSAppPortlet : arrayList) {
            PSAppPortlet pSAppPortlet2 = (PSAppPortlet)this.getDEModel().createEntity();
            pSAppPortlet2.setPSAppPortletId(pSAppPortlet.getPSAppPortletId());
            pSAppPortlet2.setPSSysAppId(null);
            this.update(pSAppPortlet2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPortletServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppPortletServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppPortletServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppPortlet> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppPortlet pSAppPortlet : arrayList) {
            this.remove(pSAppPortlet);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppPortlet> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        ArrayList<PSAppPortlet> arrayList = this.selectByPSSysPortlet(pSSysPortlet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPORTLET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPortlet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPPORTLET_PSSYSPORTLET_PSSYSPORTLETID", "", iDataEntityModel.getName(), "PSAPPPORTLET", iDataEntityModel.getDataInfo(pSSysPortlet), arrayList.get(0)));
        }
    }

    public void resetPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        ArrayList<PSAppPortlet> arrayList = this.selectByPSSysPortlet(pSSysPortlet);
        for (PSAppPortlet pSAppPortlet : arrayList) {
            PSAppPortlet pSAppPortlet2 = (PSAppPortlet)this.getDEModel().createEntity();
            pSAppPortlet2.setPSAppPortletId(pSAppPortlet.getPSAppPortletId());
            pSAppPortlet2.setPSSysPortletId(null);
            this.update(pSAppPortlet2);
        }
    }

    public void removeByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        final PSSysPortlet pSSysPortlet2 = pSSysPortlet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppPortletServiceBase.this.onBeforeRemoveByPSSysPortlet(pSSysPortlet2);
                PSAppPortletServiceBase.this.internalRemoveByPSSysPortlet(pSSysPortlet2);
                PSAppPortletServiceBase.this.onAfterRemoveByPSSysPortlet(pSSysPortlet2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
    }

    protected void internalRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
        ArrayList<PSAppPortlet> arrayList = this.selectByPSSysPortlet(pSSysPortlet);
        this.onBeforeRemoveByPSSysPortlet(pSSysPortlet, arrayList);
        for (PSAppPortlet pSAppPortlet : arrayList) {
            this.remove(pSAppPortlet);
        }
        this.onAfterRemoveByPSSysPortlet(pSSysPortlet, arrayList);
    }

    protected void onAfterRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet, ArrayList<PSAppPortlet> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPortlet(PSSysPortlet pSSysPortlet, ArrayList<PSAppPortlet> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppPortlet pSAppPortlet) throws Exception {
        super.onBeforeRemove(pSAppPortlet);
    }

    protected void replaceParentInfo(PSAppPortlet pSAppPortlet, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppPortlet, cloneSession);
        if (pSAppPortlet.getPSAppLocalDEId() != null && (iEntity = cloneSession.getEntity("PSAPPLOCALDE", (Object)pSAppPortlet.getPSAppLocalDEId())) != null) {
            this.onFillParentInfo_PSAppLocalDE(pSAppPortlet, (PSAppLocalDE)iEntity);
        }
        if (pSAppPortlet.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppPortlet.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppPortlet, (PSSysApp)iEntity);
        }
        if (pSAppPortlet.getPSSysPortletId() != null && (iEntity = cloneSession.getEntity("PSSYSPORTLET", (Object)pSAppPortlet.getPSSysPortletId())) != null) {
            this.onFillParentInfo_PSSysPortlet(pSAppPortlet, (PSSysPortlet)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppPortlet pSAppPortlet, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppPortlet, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSAppPortlet, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppLocalDEId(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppPortletId(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppPortletName(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPortletId(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSAppPortlet, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppPortlet, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isCodeNameDirty() && !bl2 : !pSAppPortlet.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppPortlet.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSAppPortlet, bl2, bl3);
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
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppPortletDEModel(), "CODENAME", string3, pSAppPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isMemoDirty() : !pSAppPortlet.isMemoDirty()) {
            return null;
        }
        String string = pSAppPortlet.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppLocalDEId(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isPSAppLocalDEIdDirty() : !pSAppPortlet.isPSAppLocalDEIdDirty()) {
            return null;
        }
        String string = pSAppPortlet.getPSAppLocalDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppLocalDEId_Default(pSAppPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPLOCALDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppPortletId(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isPSAppPortletIdDirty() && !bl2 : !pSAppPortlet.isPSAppPortletIdDirty()) {
            return null;
        }
        String string = pSAppPortlet.getPSAppPortletId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPORTLETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppPortletId_Default(pSAppPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPORTLETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppPortletName(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isPSAppPortletNameDirty() && !bl2 : !pSAppPortlet.isPSAppPortletNameDirty()) {
            return null;
        }
        String string = pSAppPortlet.getPSAppPortletName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPORTLETNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppPortletName_Default(pSAppPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPPORTLETNAME");
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
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppPortletDEModel(), "PSAPPPORTLETNAME", string3, pSAppPortlet, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPPORTLETNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isPSSysAppIdDirty() && !bl2 : !pSAppPortlet.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppPortlet.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPortletId(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isPSSysPortletIdDirty() && !bl2 : !pSAppPortlet.isPSSysPortletIdDirty()) {
            return null;
        }
        String string = pSAppPortlet.getPSSysPortletId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPORTLETID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPortletId_Default(pSAppPortlet, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPORTLETID");
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
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppPortletDEModel(), "PSSYSPORTLETID", string3, pSAppPortlet, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSPORTLETID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isUserCatDirty() : !pSAppPortlet.isUserCatDirty()) {
            return null;
        }
        String string = pSAppPortlet.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSAppPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isUserTagDirty() : !pSAppPortlet.isUserTagDirty()) {
            return null;
        }
        String string = pSAppPortlet.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSAppPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isUserTag2Dirty() : !pSAppPortlet.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppPortlet.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSAppPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isUserTag3Dirty() : !pSAppPortlet.isUserTag3Dirty()) {
            return null;
        }
        String string = pSAppPortlet.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSAppPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isUserTag4Dirty() : !pSAppPortlet.isUserTag4Dirty()) {
            return null;
        }
        String string = pSAppPortlet.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSAppPortlet, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSAppPortlet pSAppPortlet, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppPortlet.isValidFlagDirty() && !bl2 : !pSAppPortlet.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSAppPortlet.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSAppPortlet, bl2, bl3);
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

    protected void onSyncEntity(PSAppPortlet pSAppPortlet, boolean bl) throws Exception {
        super.onSyncEntity(pSAppPortlet, bl);
    }

    protected void onSyncIndexEntities(PSAppPortlet pSAppPortlet, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppPortlet, bl);
    }

    public Object getDataContextValue(PSAppPortlet pSAppPortlet, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppPortlet, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSAppPortlet pSAppPortlet, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppPortlet, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPLOCALDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppLocalDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPPORTLETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppPortletId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPPORTLETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppPortletName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPORTLETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPortletId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPORTLETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPortletName_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSAppLocalDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPLOCALDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppLocalDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPLOCALDENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppPortletId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPPORTLETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppPortletName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPPORTLETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPortletId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPORTLETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPortletName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPORTLETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSAppPortlet pSAppPortlet) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppPortlet)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppPortlet pSAppPortlet) throws Exception {
        super.onUpdateParent(pSAppPortlet);
    }

    @Override
    protected void exportCurXmlModel(PSAppPortlet pSAppPortlet, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPPORTLET");
        if (!bl) {
            pSAppPortlet.setCreateDate(null);
            pSAppPortlet.setCreateMan(null);
            pSAppPortlet.setPSAppPortletId(null);
            pSAppPortlet.setUpdateDate(null);
            pSAppPortlet.setUpdateMan(null);
            super.exportCurXmlModel(pSAppPortlet, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppPortlet pSAppPortlet, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppPortlet, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAPP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPPORTLET_PSSYSAPP_PSSYSAPPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSAPP", (boolean)true) == 0) {
            iEntity.set("PSSYSAPPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSAPPID"};
    }

    @Override
    public String getModelV2Tag(PSAppPortlet pSAppPortlet) {
        if (!StringHelper.isNullOrEmpty((String)pSAppPortlet.getPSAppPortletName())) {
            return pSAppPortlet.getPSAppPortletName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSAppPortlet.getCodeName())) {
            return pSAppPortlet.getCodeName();
        }
        return super.getModelV2Tag(pSAppPortlet);
    }

    @Override
    public boolean setModelV2Tag(PSAppPortlet pSAppPortlet, String string) {
        pSAppPortlet.setPSAppPortletName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSAPPPORTLETNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSAPPPORTLETNAME", "");
        map.put("PSSYSPORTLETID", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppPortlet pSAppPortlet, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppPortlet.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppPortlet, true);
        pSAppPortlet.set("PSAPPPORTLETNAME", string);
        if (this.select(pSAppPortlet, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppPortlet, true);
        return super.getModelV2Entity(pSAppPortlet, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppPortlet pSAppPortlet, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSAppPortlet, objectNode, string, string2, n);
    }
}

