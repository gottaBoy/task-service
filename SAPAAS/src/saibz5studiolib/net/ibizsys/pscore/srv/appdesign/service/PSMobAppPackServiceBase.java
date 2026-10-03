/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.appdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSMobAppPackDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSMobAppPackDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSDCMobPackCert;
import net.ibizsys.pscore.srv.appdesign.entity.PSDCMobPackCertBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPackTD;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackTDService;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMobAppPackServiceBase
extends PSCoreSysServiceBase<PSMobAppPack> {
    private static final Log log = LogFactory.getLog(PSMobAppPackServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSMobAppPackDEModel pSMobAppPackDEModel;
    private PSMobAppPackDAO pSMobAppPackDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackService";
    }

    public PSMobAppPackDEModel getPSMobAppPackDEModel() {
        if (this.pSMobAppPackDEModel == null) {
            try {
                this.pSMobAppPackDEModel = (PSMobAppPackDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSMobAppPackDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMobAppPackDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSMobAppPackDEModel();
    }

    public PSMobAppPackDAO getPSMobAppPackDAO() {
        if (this.pSMobAppPackDAO == null) {
            try {
                this.pSMobAppPackDAO = (PSMobAppPackDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSMobAppPackDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMobAppPackDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSMobAppPackDAO();
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

    protected void onFillParentInfo(PSMobAppPack pSMobAppPack, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMOBAPPPACK_PSDCMOBPACKCERT_PSDCMOBPACKCERTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSDCMobPackCertService", (SessionFactory)this.getSessionFactory());
            PSDCMobPackCert pSDCMobPackCert = (PSDCMobPackCert)iService.getDEModel().createEntity();
            pSDCMobPackCert.set("PSDCMOBPACKCERTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCMobPackCert);
            } else {
                iService.get(pSDCMobPackCert);
            }
            this.onFillParentInfo_PSDCMobPackCert(pSMobAppPack, pSDCMobPackCert);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMOBAPPPACK_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSMobAppPack, pSSysApp);
            return;
        }
        super.onFillParentInfo(pSMobAppPack, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCMobPackCert(PSMobAppPack pSMobAppPack, PSDCMobPackCert pSDCMobPackCert) throws Exception {
        pSMobAppPack.setPSDCMobPackCertId(pSDCMobPackCert.getPSDCMobPackCertId());
        pSMobAppPack.setPSDCMobPackCertName(pSDCMobPackCert.getPSDCMobPackCertName());
    }

    protected void onFillParentInfo_PSSysApp(PSMobAppPack pSMobAppPack, PSSysApp pSSysApp) throws Exception {
        pSMobAppPack.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSMobAppPack.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillEntityFullInfo(PSMobAppPack pSMobAppPack, boolean bl) throws Exception {
        if (bl) {
            if (pSMobAppPack.getEnableAndroid() == null) {
                pSMobAppPack.setEnableAndroid((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSMobAppPack.getEnableEncryption() == null) {
                pSMobAppPack.setEnableEncryption((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSMobAppPack.getEnableIOS() == null) {
                pSMobAppPack.setEnableIOS((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSMobAppPack.getTDCnt() == null) {
                pSMobAppPack.setTDCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSMobAppPack, bl);
        this.onFillEntityFullInfo_PSDCMobPackCert(pSMobAppPack, bl);
        this.onFillEntityFullInfo_PSSysApp(pSMobAppPack, bl);
    }

    protected void onFillEntityFullInfo_PSDCMobPackCert(PSMobAppPack pSMobAppPack, boolean bl) throws Exception {
        if (pSMobAppPack.isPSDCMobPackCertIdDirty()) {
            if (pSMobAppPack.getPSDCMobPackCertId() != null) {
                if (pSMobAppPack.getPSDCMobPackCertId() == null || pSMobAppPack.getPSDCMobPackCertName() == null) {
                    PSDCMobPackCert pSDCMobPackCert = pSMobAppPack.getPSDCMobPackCert();
                    pSMobAppPack.setPSDCMobPackCertName(pSDCMobPackCert.getPSDCMobPackCertName());
                }
            } else {
                pSMobAppPack.setPSDCMobPackCertName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysApp(PSMobAppPack pSMobAppPack, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSMobAppPack pSMobAppPack, boolean bl) throws Exception {
        super.onWriteBackParent(pSMobAppPack, bl);
    }

    public ArrayList<PSMobAppPack> selectByPSDCMobPackCert(PSDCMobPackCertBase pSDCMobPackCertBase) throws Exception {
        return this.selectByPSDCMobPackCert(pSDCMobPackCertBase, "", -1);
    }

    public ArrayList<PSMobAppPack> selectByPSDCMobPackCert(PSDCMobPackCertBase pSDCMobPackCertBase, String string) throws Exception {
        return this.selectByPSDCMobPackCert(pSDCMobPackCertBase, string, -1);
    }

    public ArrayList<PSMobAppPack> selectByPSDCMobPackCert(PSDCMobPackCertBase pSDCMobPackCertBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMOBPACKCERTID", (Object)pSDCMobPackCertBase.getPSDCMobPackCertId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMobPackCertCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMobPackCertCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSMobAppPack> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSMobAppPack> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSMobAppPack> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
        ArrayList<PSMobAppPack> arrayList = this.selectByPSDCMobPackCert(pSDCMobPackCert, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMOBPACKCERT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCMobPackCert);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMOBAPPPACK_PSDCMOBPACKCERT_PSDCMOBPACKCERTID", "", iDataEntityModel.getName(), "PSMOBAPPPACK", iDataEntityModel.getDataInfo(pSDCMobPackCert), arrayList.get(0)));
        }
    }

    public void resetPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
        ArrayList<PSMobAppPack> arrayList = this.selectByPSDCMobPackCert(pSDCMobPackCert);
        for (PSMobAppPack pSMobAppPack : arrayList) {
            PSMobAppPack pSMobAppPack2 = (PSMobAppPack)this.getDEModel().createEntity();
            pSMobAppPack2.setPSMobAppPackId(pSMobAppPack.getPSMobAppPackId());
            pSMobAppPack2.setPSDCMobPackCertId(null);
            this.update(pSMobAppPack2);
        }
    }

    public void removeByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
        final PSDCMobPackCert pSDCMobPackCert2 = pSDCMobPackCert;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMobAppPackServiceBase.this.onBeforeRemoveByPSDCMobPackCert(pSDCMobPackCert2);
                PSMobAppPackServiceBase.this.internalRemoveByPSDCMobPackCert(pSDCMobPackCert2);
                PSMobAppPackServiceBase.this.onAfterRemoveByPSDCMobPackCert(pSDCMobPackCert2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
    }

    protected void internalRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
        ArrayList<PSMobAppPack> arrayList = this.selectByPSDCMobPackCert(pSDCMobPackCert);
        this.onBeforeRemoveByPSDCMobPackCert(pSDCMobPackCert, arrayList);
        for (PSMobAppPack pSMobAppPack : arrayList) {
            this.remove(pSMobAppPack);
        }
        this.onAfterRemoveByPSDCMobPackCert(pSDCMobPackCert, arrayList);
    }

    protected void onAfterRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert, ArrayList<PSMobAppPack> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert, ArrayList<PSMobAppPack> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSMobAppPack> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSMobAppPack pSMobAppPack : arrayList) {
            PSMobAppPack pSMobAppPack2 = (PSMobAppPack)this.getDEModel().createEntity();
            pSMobAppPack2.setPSMobAppPackId(pSMobAppPack.getPSMobAppPackId());
            pSMobAppPack2.setPSSysAppId(null);
            this.update(pSMobAppPack2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMobAppPackServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSMobAppPackServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSMobAppPackServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSMobAppPack> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSMobAppPack pSMobAppPack : arrayList) {
            this.remove(pSMobAppPack);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSMobAppPack> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSMobAppPack> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSMobAppPack pSMobAppPack) throws Exception {
        super.onBeforeRemove(pSMobAppPack);
    }

    protected void replaceParentInfo(PSMobAppPack pSMobAppPack, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSMobAppPack, cloneSession);
        if (pSMobAppPack.getPSDCMobPackCertId() != null && (iEntity = cloneSession.getEntity("PSDCMOBPACKCERT", (Object)pSMobAppPack.getPSDCMobPackCertId())) != null) {
            this.onFillParentInfo_PSDCMobPackCert(pSMobAppPack, (PSDCMobPackCert)iEntity);
        }
        if (pSMobAppPack.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSMobAppPack.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSMobAppPack, (PSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSMobAppPack pSMobAppPack, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSMobAppPack, bl);
    }

    protected void onCheckEntity(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AndroidPermissions(bl, pSMobAppPack, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAndroid(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableEncryption(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableIOS(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IOSDevices(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IOSPrivacies(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OSType(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OSTypes(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PackType(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PkgName(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobPackCertId(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobPackCertName(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackId(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackName(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceUrl(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TDCnt(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Version(bl, pSMobAppPack, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSMobAppPack, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AndroidPermissions(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isAndroidPermissionsDirty() : !pSMobAppPack.isAndroidPermissionsDirty()) {
            return null;
        }
        String string = pSMobAppPack.getAndroidPermissions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AndroidPermissions_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ANDROIDPERMISSIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isCodeNameDirty() : !pSMobAppPack.isCodeNameDirty()) {
            return null;
        }
        String string = pSMobAppPack.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSMobAppPack, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSMobAppPackDEModel(), "CODENAME", string3, pSMobAppPack, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableAndroid(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isEnableAndroidDirty() && !bl2 : !pSMobAppPack.isEnableAndroidDirty()) {
            return null;
        }
        Integer n = pSMobAppPack.getEnableAndroid();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEANDROID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EnableAndroid_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEANDROID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableEncryption(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isEnableEncryptionDirty() && !bl2 : !pSMobAppPack.isEnableEncryptionDirty()) {
            return null;
        }
        Integer n = pSMobAppPack.getEnableEncryption();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEENCRYPTION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EnableEncryption_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEENCRYPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableIOS(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isEnableIOSDirty() && !bl2 : !pSMobAppPack.isEnableIOSDirty()) {
            return null;
        }
        Integer n = pSMobAppPack.getEnableIOS();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEIOS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EnableIOS_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEIOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IOSDevices(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isIOSDevicesDirty() : !pSMobAppPack.isIOSDevicesDirty()) {
            return null;
        }
        String string = pSMobAppPack.getIOSDevices();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IOSDevices_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IOSDEVICES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IOSPrivacies(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isIOSPrivaciesDirty() : !pSMobAppPack.isIOSPrivaciesDirty()) {
            return null;
        }
        String string = pSMobAppPack.getIOSPrivacies();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IOSPrivacies_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IOSPRIVACIES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isMemoDirty() : !pSMobAppPack.isMemoDirty()) {
            return null;
        }
        String string = pSMobAppPack.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSMobAppPack, bl2, bl3);
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

    protected EntityFieldError onCheckField_OSType(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isOSTypeDirty() : !pSMobAppPack.isOSTypeDirty()) {
            return null;
        }
        String string = pSMobAppPack.getOSType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OSType_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OSTypes(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isOSTypesDirty() : !pSMobAppPack.isOSTypesDirty()) {
            return null;
        }
        String string = pSMobAppPack.getOSTypes();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OSTypes_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OSTYPES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PackType(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isPackTypeDirty() : !pSMobAppPack.isPackTypeDirty()) {
            return null;
        }
        String string = pSMobAppPack.getPackType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PackType_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PACKTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PkgName(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isPkgNameDirty() : !pSMobAppPack.isPkgNameDirty()) {
            return null;
        }
        String string = pSMobAppPack.getPkgName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PkgName_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMobPackCertId(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isPSDCMobPackCertIdDirty() : !pSMobAppPack.isPSDCMobPackCertIdDirty()) {
            return null;
        }
        String string = pSMobAppPack.getPSDCMobPackCertId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobPackCertId_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBPACKCERTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMobPackCertName(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isPSDCMobPackCertNameDirty() && !bl2 : !pSMobAppPack.isPSDCMobPackCertNameDirty()) {
            return null;
        }
        String string = pSMobAppPack.getPSDCMobPackCertName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBPACKCERTNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobPackCertName_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBPACKCERTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackId(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isPSMobAppPackIdDirty() && !bl2 : !pSMobAppPack.isPSMobAppPackIdDirty()) {
            return null;
        }
        String string = pSMobAppPack.getPSMobAppPackId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackId_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackName(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isPSMobAppPackNameDirty() && !bl2 : !pSMobAppPack.isPSMobAppPackNameDirty()) {
            return null;
        }
        String string = pSMobAppPack.getPSMobAppPackName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackName_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSMobAppPackDEModel(), "PSMOBAPPPACKNAME", string3, pSMobAppPack, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSMOBAPPPACKNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isPSSysAppIdDirty() && !bl2 : !pSMobAppPack.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSMobAppPack.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSMobAppPack, bl2, bl3);
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

    protected EntityFieldError onCheckField_ServiceUrl(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isServiceUrlDirty() : !pSMobAppPack.isServiceUrlDirty()) {
            return null;
        }
        String string = pSMobAppPack.getServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceUrl_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TDCnt(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isTDCntDirty() : !pSMobAppPack.isTDCntDirty()) {
            return null;
        }
        Integer n = pSMobAppPack.getTDCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TDCnt_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TDCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isUserParamsDirty() : !pSMobAppPack.isUserParamsDirty()) {
            return null;
        }
        String string = pSMobAppPack.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSMobAppPack, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isUserTagDirty() : !pSMobAppPack.isUserTagDirty()) {
            return null;
        }
        String string = pSMobAppPack.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSMobAppPack, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isUserTag2Dirty() : !pSMobAppPack.isUserTag2Dirty()) {
            return null;
        }
        String string = pSMobAppPack.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSMobAppPack, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isUserTag3Dirty() : !pSMobAppPack.isUserTag3Dirty()) {
            return null;
        }
        String string = pSMobAppPack.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSMobAppPack, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isUserTag4Dirty() : !pSMobAppPack.isUserTag4Dirty()) {
            return null;
        }
        String string = pSMobAppPack.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSMobAppPack, bl2, bl3);
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

    protected EntityFieldError onCheckField_Version(boolean bl, PSMobAppPack pSMobAppPack, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPack.isVersionDirty() && !bl2 : !pSMobAppPack.isVersionDirty()) {
            return null;
        }
        String string = pSMobAppPack.getVersion();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Version_Default(pSMobAppPack, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSMobAppPack pSMobAppPack, boolean bl) throws Exception {
        super.onSyncEntity(pSMobAppPack, bl);
    }

    protected void onSyncIndexEntities(PSMobAppPack pSMobAppPack, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSMobAppPack, bl);
    }

    public Object getDataContextValue(PSMobAppPack pSMobAppPack, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSMobAppPack, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSMobAppPack pSMobAppPack, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSMobAppPack, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ANDROIDPERMISSIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AndroidPermissions_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ENABLEANDROID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAndroid_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEENCRYPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableEncryption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEIOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableIOS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IOSDEVICES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IOSDevices_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IOSPRIVACIES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IOSPrivacies_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OSType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OSTYPES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OSTypes_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PACKTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PackType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PkgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBPACKCERTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobPackCertId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBPACKCERTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobPackCertName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TDCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TDCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Version_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AndroidPermissions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ANDROIDPERMISSIONS", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_EnableAndroid_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableEncryption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableIOS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_IOSDevices_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IOSDEVICES", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IOSPrivacies_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("IOSPRIVACIES", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
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

    protected String onTestValueRule_OSType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OSTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OSTypes_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OSTYPES", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PackType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PACKTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PkgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMobPackCertId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMOBPACKCERTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMobPackCertName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMOBPACKCERTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICEURL", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TDCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_Version_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERSION", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSMobAppPack pSMobAppPack) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSMobAppPack)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSMobAppPack pSMobAppPack) throws Exception {
        super.onUpdateParent(pSMobAppPack);
    }

    @Override
    protected void exportCurXmlModel(PSMobAppPack pSMobAppPack, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMOBAPPPACK");
        if (!bl) {
            pSMobAppPack.setCreateDate(null);
            pSMobAppPack.setCreateMan(null);
            pSMobAppPack.setPSMobAppPackId(null);
            pSMobAppPack.setUpdateDate(null);
            pSMobAppPack.setUpdateMan(null);
            super.exportCurXmlModel(pSMobAppPack, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSMobAppPack pSMobAppPack, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSMobAppPack, string);
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
            return "DER1N_PSMOBAPPPACK_PSSYSAPP_PSSYSAPPID";
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
    public String getModelV2Tag(PSMobAppPack pSMobAppPack) {
        if (!StringHelper.isNullOrEmpty((String)pSMobAppPack.getPSMobAppPackName())) {
            return pSMobAppPack.getPSMobAppPackName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSMobAppPack.getCodeName())) {
            return pSMobAppPack.getCodeName();
        }
        return super.getModelV2Tag(pSMobAppPack);
    }

    @Override
    public boolean setModelV2Tag(PSMobAppPack pSMobAppPack, String string) {
        pSMobAppPack.setPSMobAppPackName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSMOBAPPPACKNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSMOBAPPPACKNAME", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSMobAppPack pSMobAppPack, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSMobAppPack.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSMobAppPack, true);
        pSMobAppPack.set("PSMOBAPPPACKNAME", string);
        if (this.select(pSMobAppPack, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSMobAppPack, true);
        return super.getModelV2Entity(pSMobAppPack, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSMobAppPack pSMobAppPack, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSMobAppPack, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSMOBAPPPACKTD_PSMOBAPPPACK_PSMOBAPPPACKID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        return true;
    }

    @Override
    protected void onExportRelatedModelV2(PSMobAppPack pSMobAppPack, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSMOBAPPPACKTD_PSMOBAPPPACK_PSMOBAPPPACKID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSMOBAPPPACK#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSMOBAPPPACKTD", (Object)pSMobAppPack.getPSMobAppPackId()))).exists()) {
            PSMobAppPackTDService pSMobAppPackTDService = (PSMobAppPackTDService)ServiceGlobal.getService(PSMobAppPackTDService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSMobAppPackTDService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSMobAppPackTD pSMobAppPackTD = new PSMobAppPackTD();
                PSModelV2Helper.fromJSONObject((IDataObject)pSMobAppPackTD, objectNode, false);
                String string6 = pSMobAppPackTDService.getModelV2Tag(pSMobAppPackTD);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSMOBAPPPACKTD", (Object)pSMobAppPackTD.getPSMobAppPackTDId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSMobAppPackTDService.exportModelV2(pSMobAppPackTD, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSMobAppPack, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSMobAppPack pSMobAppPack, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSMOBAPPPACKTD_PSMOBAPPPACK_PSMOBAPPPACKID")) {
            Object object;
            PSMobAppPackTD pSMobAppPackTD2;
            Object object2;
            Object object3;
            Object object4;
            PSMobAppPackTDService pSMobAppPackTDService = (PSMobAppPackTDService)ServiceGlobal.getService(PSMobAppPackTDService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSMOBAPPPACK#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSMOBAPPPACKTD", (Object)pSMobAppPack.getPSMobAppPackId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        object2 = line;
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)object2));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                object4 = pSMobAppPackTDService.selectByPSMobAppPack(pSMobAppPack);
                object3 = StringHelper.format((String)"PSMOBAPPPACK#%1$s", (Object)pSMobAppPack.getPSMobAppPackId());
                for (PSMobAppPackTD item : (ArrayList<PSMobAppPackTD>)object4) {
                    pSMobAppPackTD2 = item;
                    object = pSMobAppPackTDService.getModelV2ResScope(pSMobAppPackTD2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(pSMobAppPackTD2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSMobAppPackTDService.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("psmobapppacktdname")) {
                            string = objectNode.get("psmobapppacktdname").asText();
                        }
                        if (objectNode2.has("psmobapppacktdname")) {
                            string2 = objectNode2.get("psmobapppacktdname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode json : arrayList) {
                    PSMobAppPackTD entity = new PSMobAppPackTD();
                    PSModelV2Helper.fromJSONObject((IDataObject)entity, json, false);
                    ((ArrayNode)object3).add((JsonNode)pSMobAppPackTDService.exportModelV2(entity, string));
                }
            }
        }
        super.onExportCurModelV2(pSMobAppPack, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSMobAppPack pSMobAppPack) throws Exception {
        super.onEmptyModelV2(pSMobAppPack);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSMobAppPackTDService pSMobAppPackTDService = (PSMobAppPackTDService)ServiceGlobal.getService(PSMobAppPackTDService.class, (SessionFactory)this.getSessionFactory());
        if (pSMobAppPackTDService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSMobAppPack pSMobAppPack, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSMobAppPackTD pSMobAppPackTD = new PSMobAppPackTD();
        pSMobAppPackTD.set("PSMOBAPPPACKID", pSMobAppPack.getPSMobAppPackId());
        PSMobAppPackTDService pSMobAppPackTDService = (PSMobAppPackTDService)ServiceGlobal.getService(PSMobAppPackTDService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSMobAppPackTDService.getModelV2Entity(pSMobAppPackTD, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSMobAppPack, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSMobAppPack pSMobAppPack, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (!PSMobAppPackServiceBase.isSimpleImportExportMode("")) {
            PSMobAppPackTDService pSMobAppPackTDService = (PSMobAppPackTDService)ServiceGlobal.getService(PSMobAppPackTDService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSMobAppPackTDService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSMobAppPackTD pSMobAppPackTD = new PSMobAppPackTD();
                    pSMobAppPackTD.setPSMobAppPackId(pSMobAppPack.getPSMobAppPackId());
                    pSMobAppPackTD.setPSMobAppPackName(pSMobAppPack.getPSMobAppPackName());
                    pSMobAppPackTDService.compileModelV2(pSMobAppPackTD, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSMobAppPackTD pSMobAppPackTD = new PSMobAppPackTD();
                        pSMobAppPackTD.setPSMobAppPackId(pSMobAppPack.getPSMobAppPackId());
                        pSMobAppPackTD.setPSMobAppPackName(pSMobAppPack.getPSMobAppPackName());
                        pSMobAppPackTDService.compileModelV2(pSMobAppPackTD, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSMobAppPack, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSMobAppPack pSMobAppPack, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSMobAppPack, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSMobAppPack pSMobAppPack, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSMobAppPack, list);
    }
}

