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
import net.ibizsys.pscore.srv.appdesign.dao.PSAppDERSViewDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppDERSViewDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDERS;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDERSBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDERSView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEViewBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppDERSViewServiceBase
extends PSCoreSysServiceBase<PSAppDERSView> {
    private static final Log log = LogFactory.getLog(PSAppDERSViewServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppDERSViewDEModel pSAppDERSViewDEModel;
    private PSAppDERSViewDAO pSAppDERSViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppDERSViewService";
    }

    public PSAppDERSViewDEModel getPSAppDERSViewDEModel() {
        if (this.pSAppDERSViewDEModel == null) {
            try {
                this.pSAppDERSViewDEModel = (PSAppDERSViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppDERSViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppDERSViewDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppDERSViewDEModel();
    }

    public PSAppDERSViewDAO getPSAppDERSViewDAO() {
        if (this.pSAppDERSViewDAO == null) {
            try {
                this.pSAppDERSViewDAO = (PSAppDERSViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppDERSViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppDERSViewDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppDERSViewDAO();
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

    protected void onFillParentInfo(PSAppDERSView pSAppDERSView, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPDERSVIEW_PSAPPDERS_PSAPPDERSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppDERSService", (SessionFactory)this.getSessionFactory());
            PSAppDERS pSAppDERS = (PSAppDERS)iService.getDEModel().createEntity();
            pSAppDERS.set("PSAPPDERSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppDERS);
            } else {
                iService.get((IEntity)pSAppDERS);
            }
            this.onFillParentInfo_PSAppDERS(pSAppDERSView, pSAppDERS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPDERSVIEW_PSAPPDEVIEW_PSAPPDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService", (SessionFactory)this.getSessionFactory());
            PSAppDEView pSAppDEView = (PSAppDEView)iService.getDEModel().createEntity();
            pSAppDEView.set("PSAPPDEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppDEView);
            } else {
                iService.get((IEntity)pSAppDEView);
            }
            this.onFillParentInfo_PSAppDEView(pSAppDERSView, pSAppDEView);
            return;
        }
        super.onFillParentInfo((IEntity)pSAppDERSView, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppDERS(PSAppDERSView pSAppDERSView, PSAppDERS pSAppDERS) throws Exception {
        pSAppDERSView.setPSAppDERSId(pSAppDERS.getPSAppDERSId());
        pSAppDERSView.setPSAppDERSName(pSAppDERS.getPSAppDERSName());
        pSAppDERSView.setPSSysAppId(pSAppDERS.getPSSysAppId());
    }

    protected void onFillParentInfo_PSAppDEView(PSAppDERSView pSAppDERSView, PSAppDEView pSAppDEView) throws Exception {
        pSAppDERSView.setPSAppDEViewId(pSAppDEView.getPSAppDEViewId());
        pSAppDERSView.setPSAppDEViewName(pSAppDEView.getPSAppDEViewName());
    }

    protected void onFillEntityFullInfo(PSAppDERSView pSAppDERSView, boolean bl) throws Exception {
        if (bl && pSAppDERSView.getValidFlag() == null) {
            pSAppDERSView.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSAppDERSView, bl);
        this.onFillEntityFullInfo_PSAppDERS(pSAppDERSView, bl);
        this.onFillEntityFullInfo_PSAppDEView(pSAppDERSView, bl);
    }

    protected void onFillEntityFullInfo_PSAppDERS(PSAppDERSView pSAppDERSView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppDEView(PSAppDERSView pSAppDERSView, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppDERSView pSAppDERSView, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSAppDERSView, bl);
    }

    public ArrayList<PSAppDERSView> selectByPSAppDERS(PSAppDERSBase pSAppDERSBase) throws Exception {
        return this.selectByPSAppDERS(pSAppDERSBase, "", -1);
    }

    public ArrayList<PSAppDERSView> selectByPSAppDERS(PSAppDERSBase pSAppDERSBase, String string) throws Exception {
        return this.selectByPSAppDERS(pSAppDERSBase, string, -1);
    }

    public ArrayList<PSAppDERSView> selectByPSAppDERS(PSAppDERSBase pSAppDERSBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPDERSID", (Object)pSAppDERSBase.getPSAppDERSId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppDERSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppDERSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppDERSView> selectByPSAppDEView(PSAppDEViewBase pSAppDEViewBase) throws Exception {
        return this.selectByPSAppDEView(pSAppDEViewBase, "", -1);
    }

    public ArrayList<PSAppDERSView> selectByPSAppDEView(PSAppDEViewBase pSAppDEViewBase, String string) throws Exception {
        return this.selectByPSAppDEView(pSAppDEViewBase, string, -1);
    }

    public ArrayList<PSAppDERSView> selectByPSAppDEView(PSAppDEViewBase pSAppDEViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPDEVIEWID", (Object)pSAppDEViewBase.getPSAppDEViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppDEViewCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppDERS(PSAppDERS pSAppDERS) throws Exception {
    }

    public void resetPSAppDERS(PSAppDERS pSAppDERS) throws Exception {
        ArrayList<PSAppDERSView> arrayList = this.selectByPSAppDERS(pSAppDERS);
        for (PSAppDERSView pSAppDERSView : arrayList) {
            PSAppDERSView pSAppDERSView2 = (PSAppDERSView)this.getDEModel().createEntity();
            pSAppDERSView2.setPSAppDERSViewId(pSAppDERSView.getPSAppDERSViewId());
            pSAppDERSView2.setPSAppDERSId(null);
            this.update(pSAppDERSView2);
        }
    }

    public void removeByPSAppDERS(PSAppDERS pSAppDERS) throws Exception {
        final PSAppDERS pSAppDERS2 = pSAppDERS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppDERSViewServiceBase.this.onBeforeRemoveByPSAppDERS(pSAppDERS2);
                PSAppDERSViewServiceBase.this.internalRemoveByPSAppDERS(pSAppDERS2);
                PSAppDERSViewServiceBase.this.onAfterRemoveByPSAppDERS(pSAppDERS2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppDERS(PSAppDERS pSAppDERS) throws Exception {
    }

    protected void internalRemoveByPSAppDERS(PSAppDERS pSAppDERS) throws Exception {
        ArrayList<PSAppDERSView> arrayList = this.selectByPSAppDERS(pSAppDERS);
        this.onBeforeRemoveByPSAppDERS(pSAppDERS, arrayList);
        for (PSAppDERSView pSAppDERSView : arrayList) {
            this.remove((IEntity)pSAppDERSView);
        }
        this.onAfterRemoveByPSAppDERS(pSAppDERS, arrayList);
    }

    protected void onAfterRemoveByPSAppDERS(PSAppDERS pSAppDERS) throws Exception {
    }

    protected void onBeforeRemoveByPSAppDERS(PSAppDERS pSAppDERS, ArrayList<PSAppDERSView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppDERS(PSAppDERS pSAppDERS, ArrayList<PSAppDERSView> arrayList) throws Exception {
    }

    public void testRemoveByPSAppDEView(PSAppDEView pSAppDEView) throws Exception {
    }

    public void resetPSAppDEView(PSAppDEView pSAppDEView) throws Exception {
        ArrayList<PSAppDERSView> arrayList = this.selectByPSAppDEView(pSAppDEView);
        for (PSAppDERSView pSAppDERSView : arrayList) {
            PSAppDERSView pSAppDERSView2 = (PSAppDERSView)this.getDEModel().createEntity();
            pSAppDERSView2.setPSAppDERSViewId(pSAppDERSView.getPSAppDERSViewId());
            pSAppDERSView2.setPSAppDEViewId(null);
            this.update(pSAppDERSView2);
        }
    }

    public void removeByPSAppDEView(PSAppDEView pSAppDEView) throws Exception {
        final PSAppDEView pSAppDEView2 = pSAppDEView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppDERSViewServiceBase.this.onBeforeRemoveByPSAppDEView(pSAppDEView2);
                PSAppDERSViewServiceBase.this.internalRemoveByPSAppDEView(pSAppDEView2);
                PSAppDERSViewServiceBase.this.onAfterRemoveByPSAppDEView(pSAppDEView2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppDEView(PSAppDEView pSAppDEView) throws Exception {
    }

    protected void internalRemoveByPSAppDEView(PSAppDEView pSAppDEView) throws Exception {
        ArrayList<PSAppDERSView> arrayList = this.selectByPSAppDEView(pSAppDEView);
        this.onBeforeRemoveByPSAppDEView(pSAppDEView, arrayList);
        for (PSAppDERSView pSAppDERSView : arrayList) {
            this.remove((IEntity)pSAppDERSView);
        }
        this.onAfterRemoveByPSAppDEView(pSAppDEView, arrayList);
    }

    protected void onAfterRemoveByPSAppDEView(PSAppDEView pSAppDEView) throws Exception {
    }

    protected void onBeforeRemoveByPSAppDEView(PSAppDEView pSAppDEView, ArrayList<PSAppDERSView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppDEView(PSAppDEView pSAppDEView, ArrayList<PSAppDERSView> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppDERSView pSAppDERSView) throws Exception {
        super.onBeforeRemove(pSAppDERSView);
    }

    protected void replaceParentInfo(PSAppDERSView pSAppDERSView, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSAppDERSView, cloneSession);
        if (pSAppDERSView.getPSAppDERSId() != null && (iEntity = cloneSession.getEntity("PSAPPDERS", (Object)pSAppDERSView.getPSAppDERSId())) != null) {
            this.onFillParentInfo_PSAppDERS(pSAppDERSView, (PSAppDERS)iEntity);
        }
        if (pSAppDERSView.getPSAppDEViewId() != null && (iEntity = cloneSession.getEntity("PSAPPDEVIEW", (Object)pSAppDERSView.getPSAppDEViewId())) != null) {
            this.onFillParentInfo_PSAppDEView(pSAppDERSView, (PSAppDEView)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppDERSView pSAppDERSView, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSAppDERSView, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppDERSView pSAppDERSView, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSAppDERSView, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppDERSId(bl, pSAppDERSView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppDERSViewId(bl, pSAppDERSView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppDERSViewName(bl, pSAppDERSView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppDEViewId(bl, pSAppDERSView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSAppDERSView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSAppDERSView, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppDERSView pSAppDERSView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDERSView.isMemoDirty() : !pSAppDERSView.isMemoDirty()) {
            return null;
        }
        String string = pSAppDERSView.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSAppDERSView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppDERSId(boolean bl, PSAppDERSView pSAppDERSView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDERSView.isPSAppDERSIdDirty() : !pSAppDERSView.isPSAppDERSIdDirty()) {
            return null;
        }
        String string = pSAppDERSView.getPSAppDERSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppDERSId_Default((IEntity)pSAppDERSView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDERSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppDERSViewId(boolean bl, PSAppDERSView pSAppDERSView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDERSView.isPSAppDERSViewIdDirty() && !bl2 : !pSAppDERSView.isPSAppDERSViewIdDirty()) {
            return null;
        }
        String string = pSAppDERSView.getPSAppDERSViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDERSVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppDERSViewId_Default((IEntity)pSAppDERSView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDERSVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppDERSViewName(boolean bl, PSAppDERSView pSAppDERSView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDERSView.isPSAppDERSViewNameDirty() && !bl2 : !pSAppDERSView.isPSAppDERSViewNameDirty()) {
            return null;
        }
        String string = pSAppDERSView.getPSAppDERSViewName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDERSVIEWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppDERSViewName_Default((IEntity)pSAppDERSView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDERSVIEWNAME");
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
                string3 = "PSAPPDERSID";
                String string4 = this.checkFieldDupRule(this.getPSAppDERSViewDEModel(), "PSAPPDERSVIEWNAME", string3, pSAppDERSView, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPDERSVIEWNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppDEViewId(boolean bl, PSAppDERSView pSAppDERSView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDERSView.isPSAppDEViewIdDirty() && !bl2 : !pSAppDERSView.isPSAppDEViewIdDirty()) {
            return null;
        }
        String string = pSAppDERSView.getPSAppDEViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDEVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppDEViewId_Default((IEntity)pSAppDERSView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPDEVIEWID");
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
                string3 = "PSAPPDERSID";
                String string4 = this.checkFieldDupRule(this.getPSAppDERSViewDEModel(), "PSAPPDEVIEWID", string3, pSAppDERSView, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSAPPDEVIEWID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSAppDERSView pSAppDERSView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppDERSView.isValidFlagDirty() && !bl2 : !pSAppDERSView.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSAppDERSView.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSAppDERSView, bl2, bl3);
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

    protected void onSyncEntity(PSAppDERSView pSAppDERSView, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSAppDERSView, bl);
    }

    protected void onSyncIndexEntities(PSAppDERSView pSAppDERSView, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSAppDERSView, bl);
    }

    public Object getDataContextValue(PSAppDERSView pSAppDERSView, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSAppDERSView, string, iDataContextParam)) != null) {
            return object;
        }
        PSAppDERS pSAppDERS = pSAppDERSView.getPSAppDERS();
        if (pSAppDERS != null && pSAppDERS.contains(string)) {
            return pSAppDERS.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppDERSView pSAppDERSView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSAppDERSView, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPDERSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppDERSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPDERSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppDERSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPDERSVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppDERSViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPDERSVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppDERSViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSAppDERSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPDERSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppDERSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPDERSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppDERSViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPDERSVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppDERSViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPDERSVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSAppDERSView pSAppDERSView) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSAppDERSView)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppDERSView pSAppDERSView) throws Exception {
        super.onUpdateParent((IEntity)pSAppDERSView);
    }

    @Override
    protected void exportCurXmlModel(PSAppDERSView pSAppDERSView, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPDERSVIEW");
        if (!bl) {
            pSAppDERSView.setCreateDate(null);
            pSAppDERSView.setCreateMan(null);
            pSAppDERSView.setPSAppDERSName(null);
            pSAppDERSView.setPSAppDERSViewId(null);
            pSAppDERSView.setUpdateDate(null);
            pSAppDERSView.setUpdateMan(null);
            super.exportCurXmlModel(pSAppDERSView, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppDERSView pSAppDERSView, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppDERSView, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPDERSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSAPPDERS#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPDERSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPDERSVIEW_PSAPPDERS_PSAPPDERSID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPDERSID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSAPPDERSNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSAPPDERS", (boolean)true) == 0) {
            iEntity.set("PSAPPDERSID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSAPPDERSID"};
    }

    @Override
    public String getModelV2Tag(PSAppDERSView pSAppDERSView) {
        if (!StringHelper.isNullOrEmpty((String)pSAppDERSView.getPSAppDERSViewName())) {
            return pSAppDERSView.getPSAppDERSViewName();
        }
        return super.getModelV2Tag(pSAppDERSView);
    }

    @Override
    public boolean setModelV2Tag(PSAppDERSView pSAppDERSView, String string) {
        return super.setModelV2Tag(pSAppDERSView, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSAPPDERSVIEWNAME", "");
        map.put("PSAPPDERSID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppDERSView pSAppDERSView, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppDERSView.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppDERSView, true);
        pSAppDERSView.set("PSAPPDERSVIEWNAME", string);
        if (this.select(pSAppDERSView, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppDERSView, true);
        return super.getModelV2Entity(pSAppDERSView, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppDERSView pSAppDERSView, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSAppDERSView, objectNode, string, string2, n);
    }
}

