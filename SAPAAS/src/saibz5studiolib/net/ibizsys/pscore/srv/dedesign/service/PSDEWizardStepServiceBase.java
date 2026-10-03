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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardStepDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardStepDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStep;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEWizardStepServiceBase
extends PSCoreSysServiceBase<PSDEWizardStep> {
    private static final Log log = LogFactory.getLog(PSDEWizardStepServiceBase.class);
    public static final String DATASET_CURDEWIZARD = "CurDEWizard";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEWizardStepDEModel pSDEWizardStepDEModel;
    private PSDEWizardStepDAO pSDEWizardStepDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService";
    }

    public PSDEWizardStepDEModel getPSDEWizardStepDEModel() {
        if (this.pSDEWizardStepDEModel == null) {
            try {
                this.pSDEWizardStepDEModel = (PSDEWizardStepDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEWizardStepDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardStepDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEWizardStepDEModel();
    }

    public PSDEWizardStepDAO getPSDEWizardStepDAO() {
        if (this.pSDEWizardStepDAO == null) {
            try {
                this.pSDEWizardStepDAO = (PSDEWizardStepDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEWizardStepDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEWizardStepDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEWizardStepDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEWIZARD, (boolean)true) == 0) {
            return this.fetchCurDEWizard(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEWIZARD, (boolean)true) == 0) {
            return this.fetchTempCurDEWizard(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDEWizard(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEWIZARD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEWizard(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEWIZARD, true);
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

    protected void onFillParentInfo(PSDEWizardStep pSDEWizardStep, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDSTEP_PSDEACTION_INITPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_InitPSDEAction(pSDEWizardStep, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDSTEP_PSDEACTION_NEXTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEAction);
            } else {
                iService.get(pSDEAction);
            }
            this.onFillParentInfo_NextPSDEAction(pSDEWizardStep, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDSTEP_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEWizardStep, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDSTEP_PSDEWIZARD_PSDEWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService", (SessionFactory)this.getSessionFactory());
            PSDEWizard pSDEWizard = (PSDEWizard)iService.getDEModel().createEntity();
            pSDEWizard.set("PSDEWIZARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEWizard);
            } else {
                iService.get(pSDEWizard);
            }
            this.onFillParentInfo_PSDEWizard(pSDEWizardStep, pSDEWizard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDSTEP_PSLANGUAGERES_LNPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_LNPSLanRes(pSDEWizardStep, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDSTEP_PSLANGUAGERES_SUBTITLEPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_SubTitlePSLanRes(pSDEWizardStep, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDSTEP_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEWizardStep, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEWIZARDSTEP_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEWizardStep, pSSysImage);
            return;
        }
        super.onFillParentInfo(pSDEWizardStep, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEWIZARDSTEP_PSDEWIZARD_PSDEWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService", (SessionFactory)this.getSessionFactory());
            PSDEWizard pSDEWizard = (PSDEWizard)iService.getDEModel().createEntity();
            pSDEWizard.set("PSDEWIZARDID", string2);
            return this.onSyncDER1NData_PSDEWizard(pSDEWizard, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_InitPSDEAction(PSDEWizardStep pSDEWizardStep, PSDEAction pSDEAction) throws Exception {
        pSDEWizardStep.setInitPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEWizardStep.setInitPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_NextPSDEAction(PSDEWizardStep pSDEWizardStep, PSDEAction pSDEAction) throws Exception {
        pSDEWizardStep.setNextPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEWizardStep.setNextPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEWizardStep pSDEWizardStep, PSDEForm pSDEForm) throws Exception {
        pSDEWizardStep.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEWizardStep.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEWizard(PSDEWizardStep pSDEWizardStep, PSDEWizard pSDEWizard) throws Exception {
        pSDEWizardStep.setPSDEId(pSDEWizard.getPSDEId());
        pSDEWizardStep.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
        pSDEWizardStep.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
    }

    protected String onSyncDER1NData_PSDEWizard(PSDEWizard pSDEWizard, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEWizard(pSDEWizard);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEWizardStep> arrayList = this.selectByPSDEWizard(pSDEWizard);
            for (PSDEWizardStep pSDEWizardStep : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEWizardStep, (String)"PSDEWIZARDSTEPID", (String)""))) continue;
                this.remove(pSDEWizardStep);
            }
        }
        return null;
    }

    protected void onFillParentInfo_LNPSLanRes(PSDEWizardStep pSDEWizardStep, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEWizardStep.setLNPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEWizardStep.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_SubTitlePSLanRes(PSDEWizardStep pSDEWizardStep, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEWizardStep.setSubTitlePSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEWizardStep.setSubTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEWizardStep pSDEWizardStep, PSSysCss pSSysCss) throws Exception {
        pSDEWizardStep.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEWizardStep.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEWizardStep pSDEWizardStep, PSSysImage pSSysImage) throws Exception {
        pSDEWizardStep.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEWizardStep.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillEntityFullInfo(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDEWizardStep, bl);
        this.onFillEntityFullInfo_InitPSDEAction(pSDEWizardStep, bl);
        this.onFillEntityFullInfo_NextPSDEAction(pSDEWizardStep, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEWizardStep, bl);
        this.onFillEntityFullInfo_PSDEWizard(pSDEWizardStep, bl);
        this.onFillEntityFullInfo_LNPSLanRes(pSDEWizardStep, bl);
        this.onFillEntityFullInfo_SubTitlePSLanRes(pSDEWizardStep, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEWizardStep, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEWizardStep, bl);
    }

    protected void onFillEntityFullInfo_InitPSDEAction(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NextPSDEAction(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEWizard(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
        if (pSDEWizardStep.isPSDEWizardIdDirty()) {
            if (pSDEWizardStep.getPSDEWizardId() != null) {
                if (pSDEWizardStep.getPSDEWizardId() == null || pSDEWizardStep.getPSDEWizardName() == null) {
                    PSDEWizard pSDEWizard = pSDEWizardStep.getPSDEWizard();
                    pSDEWizardStep.setPSDEId(pSDEWizard.getPSDEId());
                    pSDEWizardStep.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
                }
            } else {
                pSDEWizardStep.setPSDEId(null);
                pSDEWizardStep.setPSDEWizardName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_LNPSLanRes(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
        if (pSDEWizardStep.isLNPSLanResIdDirty()) {
            if (pSDEWizardStep.getLNPSLanResId() != null) {
                if (pSDEWizardStep.getLNPSLanResId() == null || pSDEWizardStep.getLNPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEWizardStep.getLNPSLanRes();
                    pSDEWizardStep.setLNPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEWizardStep.setLNPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SubTitlePSLanRes(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
        if (pSDEWizardStep.isSubTitlePSLanResIdDirty()) {
            if (pSDEWizardStep.getSubTitlePSLanResId() != null) {
                if (pSDEWizardStep.getSubTitlePSLanResId() == null || pSDEWizardStep.getSubTitlePSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEWizardStep.getSubTitlePSLanRes();
                    pSDEWizardStep.setSubTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEWizardStep.setSubTitlePSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEWizardStep, bl);
    }

    public ArrayList<PSDEWizardStep> selectByInitPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByInitPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEWizardStep> selectByInitPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByInitPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEWizardStep> selectByInitPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("INITPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByInitPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByInitPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardStep> selectByNextPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByNextPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEWizardStep> selectByNextPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByNextPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEWizardStep> selectByNextPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NEXTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNextPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNextPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardStep> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEWizardStep> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEWizardStep> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardStep> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase) throws Exception {
        return this.selectByPSDEWizard(pSDEWizardBase, "", -1);
    }

    public ArrayList<PSDEWizardStep> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string) throws Exception {
        return this.selectByPSDEWizard(pSDEWizardBase, string, -1);
    }

    public ArrayList<PSDEWizardStep> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDID", (Object)pSDEWizardBase.getPSDEWizardId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEWizardCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEWizardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardStep> selectTempByPSDEWizard(PSDEWizardBase pSDEWizardBase) throws Exception {
        return this.selectTempByPSDEWizard(pSDEWizardBase, "");
    }

    public ArrayList<PSDEWizardStep> selectTempByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDID", (Object)pSDEWizardBase.getPSDEWizardId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEWizardCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEWizardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardStep> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEWizardStep> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByLNPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEWizardStep> selectByLNPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LNPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLNPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLNPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardStep> selectBySubTitlePSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectBySubTitlePSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEWizardStep> selectBySubTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectBySubTitlePSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEWizardStep> selectBySubTitlePSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SUBTITLEPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySubTitlePSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySubTitlePSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardStep> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEWizardStep> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEWizardStep> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEWizardStep> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEWizardStep> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEWizardStep> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByInitPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDSTEP_PSDEACTION_INITPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEWIZARDSTEP", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByInitPSDEAction(pSDEAction);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            PSDEWizardStep pSDEWizardStep2 = (PSDEWizardStep)this.getDEModel().createEntity();
            pSDEWizardStep2.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
            pSDEWizardStep2.setInitPSDEActionId(null);
            this.update(pSDEWizardStep2);
        }
    }

    public void removeByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardStepServiceBase.this.onBeforeRemoveByInitPSDEAction(pSDEAction2);
                PSDEWizardStepServiceBase.this.internalRemoveByInitPSDEAction(pSDEAction2);
                PSDEWizardStepServiceBase.this.onAfterRemoveByInitPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByInitPSDEAction(pSDEAction);
        this.onBeforeRemoveByInitPSDEAction(pSDEAction, arrayList);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            this.remove(pSDEWizardStep);
        }
        this.onAfterRemoveByInitPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByInitPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByInitPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByInitPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    public void testRemoveByNextPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByNextPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDSTEP_PSDEACTION_NEXTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEWIZARDSTEP", iDataEntityModel.getDataInfo(pSDEAction), arrayList.get(0)));
        }
    }

    public void resetNextPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByNextPSDEAction(pSDEAction);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            PSDEWizardStep pSDEWizardStep2 = (PSDEWizardStep)this.getDEModel().createEntity();
            pSDEWizardStep2.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
            pSDEWizardStep2.setNextPSDEActionId(null);
            this.update(pSDEWizardStep2);
        }
    }

    public void removeByNextPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardStepServiceBase.this.onBeforeRemoveByNextPSDEAction(pSDEAction2);
                PSDEWizardStepServiceBase.this.internalRemoveByNextPSDEAction(pSDEAction2);
                PSDEWizardStepServiceBase.this.onAfterRemoveByNextPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByNextPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByNextPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByNextPSDEAction(pSDEAction);
        this.onBeforeRemoveByNextPSDEAction(pSDEAction, arrayList);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            this.remove(pSDEWizardStep);
        }
        this.onAfterRemoveByNextPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByNextPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByNextPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNextPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDSTEP_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDEWIZARDSTEP", iDataEntityModel.getDataInfo(pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            PSDEWizardStep pSDEWizardStep2 = (PSDEWizardStep)this.getDEModel().createEntity();
            pSDEWizardStep2.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
            pSDEWizardStep2.setPSDEFormId(null);
            this.update(pSDEWizardStep2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardStepServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEWizardStepServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEWizardStepServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            this.remove(pSDEWizardStep);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    public void testRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    public void resetPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSDEWizard(pSDEWizard);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            PSDEWizardStep pSDEWizardStep2 = (PSDEWizardStep)this.getDEModel().createEntity();
            pSDEWizardStep2.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
            pSDEWizardStep2.setPSDEWizardId(null);
            this.update(pSDEWizardStep2);
        }
    }

    public void resetTempPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectTempByPSDEWizard(pSDEWizard);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            PSDEWizardStep pSDEWizardStep2 = (PSDEWizardStep)this.getDEModel().createEntity();
            pSDEWizardStep2.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
            pSDEWizardStep2.setPSDEWizardId(null);
            this.updateTemp(pSDEWizardStep2);
        }
    }

    public void removeByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        final PSDEWizard pSDEWizard2 = pSDEWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardStepServiceBase.this.onBeforeRemoveByPSDEWizard(pSDEWizard2);
                PSDEWizardStepServiceBase.this.internalRemoveByPSDEWizard(pSDEWizard2);
                PSDEWizardStepServiceBase.this.onAfterRemoveByPSDEWizard(pSDEWizard2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void internalRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSDEWizard(pSDEWizard);
        this.onBeforeRemoveByPSDEWizard(pSDEWizard, arrayList);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            this.remove(pSDEWizardStep);
        }
        this.onAfterRemoveByPSDEWizard(pSDEWizard, arrayList);
    }

    protected void onAfterRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void onBeforeRemoveByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    public void testRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByLNPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDSTEP_PSLANGUAGERES_LNPSLANRESID", "", iDataEntityModel.getName(), "PSDEWIZARDSTEP", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            PSDEWizardStep pSDEWizardStep2 = (PSDEWizardStep)this.getDEModel().createEntity();
            pSDEWizardStep2.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
            pSDEWizardStep2.setLNPSLanResId(null);
            this.update(pSDEWizardStep2);
        }
    }

    public void removeByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardStepServiceBase.this.onBeforeRemoveByLNPSLanRes(pSLanguageRes2);
                PSDEWizardStepServiceBase.this.internalRemoveByLNPSLanRes(pSLanguageRes2);
                PSDEWizardStepServiceBase.this.onAfterRemoveByLNPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByLNPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByLNPSLanRes(pSLanguageRes, arrayList);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            this.remove(pSDEWizardStep);
        }
        this.onAfterRemoveByLNPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLNPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    public void testRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectBySubTitlePSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDSTEP_PSLANGUAGERES_SUBTITLEPSLANRESID", "", iDataEntityModel.getName(), "PSDEWIZARDSTEP", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetSubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectBySubTitlePSLanRes(pSLanguageRes);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            PSDEWizardStep pSDEWizardStep2 = (PSDEWizardStep)this.getDEModel().createEntity();
            pSDEWizardStep2.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
            pSDEWizardStep2.setSubTitlePSLanResId(null);
            this.update(pSDEWizardStep2);
        }
    }

    public void removeBySubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardStepServiceBase.this.onBeforeRemoveBySubTitlePSLanRes(pSLanguageRes2);
                PSDEWizardStepServiceBase.this.internalRemoveBySubTitlePSLanRes(pSLanguageRes2);
                PSDEWizardStepServiceBase.this.onAfterRemoveBySubTitlePSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectBySubTitlePSLanRes(pSLanguageRes);
        this.onBeforeRemoveBySubTitlePSLanRes(pSLanguageRes, arrayList);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            this.remove(pSDEWizardStep);
        }
        this.onAfterRemoveBySubTitlePSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySubTitlePSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDSTEP_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEWIZARDSTEP", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            PSDEWizardStep pSDEWizardStep2 = (PSDEWizardStep)this.getDEModel().createEntity();
            pSDEWizardStep2.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
            pSDEWizardStep2.setPSSysCssId(null);
            this.update(pSDEWizardStep2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardStepServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEWizardStepServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEWizardStepServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            this.remove(pSDEWizardStep);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEWIZARDSTEP_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEWIZARDSTEP", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            PSDEWizardStep pSDEWizardStep2 = (PSDEWizardStep)this.getDEModel().createEntity();
            pSDEWizardStep2.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
            pSDEWizardStep2.setPSSysImageId(null);
            this.update(pSDEWizardStep2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardStepServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEWizardStepServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEWizardStepServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            this.remove(pSDEWizardStep);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEWizardStep pSDEWizardStep) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).testRemoveByPSDEWizardStep(pSDEWizardStep);
        pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEWizardStep(pSDEWizardStep);
        super.onBeforeRemove(pSDEWizardStep);
    }

    protected void onBeforeRemoveTemp(PSDEWizardStep pSDEWizardStep) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).resetTempPSDEWizardStep(pSDEWizardStep);
        pSCoreSysServiceBase = (PSDEWizardFormService)ServiceGlobal.getService(PSDEWizardFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardFormServiceBase)pSCoreSysServiceBase).resetTempPSDEWizardStep(pSDEWizardStep);
        super.onBeforeRemoveTemp(pSDEWizardStep);
    }

    public void removeTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        final PSDEWizard pSDEWizard2 = pSDEWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEWizardStepServiceBase.this.onBeforeRemoveTempByPSDEWizard(pSDEWizard2);
                PSDEWizardStepServiceBase.this.internalRemoveTempByPSDEWizard(pSDEWizard2);
                PSDEWizardStepServiceBase.this.onAfterRemoveTempByPSDEWizard(pSDEWizard2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void internalRemoveTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEWizardStep> arrayList = this.selectTempByPSDEWizard(pSDEWizard);
        this.onBeforeRemoveTempByPSDEWizard(pSDEWizard, arrayList);
        for (PSDEWizardStep pSDEWizardStep : arrayList) {
            this.removeTemp(pSDEWizardStep);
        }
        this.onAfterRemoveTempByPSDEWizard(pSDEWizard, arrayList);
    }

    protected void onAfterRemoveTempByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEWizardStep> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEWizardStep pSDEWizardStep) throws Exception {
        super.getRelatedDataTempMajor(pSDEWizardStep);
    }

    protected void updateRelatedDataTempMajor(PSDEWizardStep pSDEWizardStep, PSDEWizardStep pSDEWizardStep2) throws Exception {
        super.updateRelatedDataTempMajor(pSDEWizardStep, pSDEWizardStep2);
    }

    protected void replaceParentInfo(PSDEWizardStep pSDEWizardStep, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEWizardStep, cloneSession);
        if (pSDEWizardStep.getInitPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEWizardStep.getInitPSDEActionId())) != null) {
            this.onFillParentInfo_InitPSDEAction(pSDEWizardStep, (PSDEAction)iEntity);
        }
        if (pSDEWizardStep.getNextPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEWizardStep.getNextPSDEActionId())) != null) {
            this.onFillParentInfo_NextPSDEAction(pSDEWizardStep, (PSDEAction)iEntity);
        }
        if (pSDEWizardStep.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEWizardStep.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEWizardStep, (PSDEForm)iEntity);
        }
        if (pSDEWizardStep.getPSDEWizardId() != null && (iEntity = cloneSession.getEntity("PSDEWIZARD", (Object)pSDEWizardStep.getPSDEWizardId())) != null) {
            this.onFillParentInfo_PSDEWizard(pSDEWizardStep, (PSDEWizard)iEntity);
        }
        if (pSDEWizardStep.getLNPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEWizardStep.getLNPSLanResId())) != null) {
            this.onFillParentInfo_LNPSLanRes(pSDEWizardStep, (PSLanguageRes)iEntity);
        }
        if (pSDEWizardStep.getSubTitlePSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEWizardStep.getSubTitlePSLanResId())) != null) {
            this.onFillParentInfo_SubTitlePSLanRes(pSDEWizardStep, (PSLanguageRes)iEntity);
        }
        if (pSDEWizardStep.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEWizardStep.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEWizardStep, (PSSysCss)iEntity);
        }
        if (pSDEWizardStep.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEWizardStep.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEWizardStep, (PSSysImage)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEWizardStep, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_EnableLink(bl, pSDEWizardStep, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLogic(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InitPSDEActionId(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResId(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LNPSLanResName(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextPSDEActionId(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardId(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardName(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardStepId(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardStepName(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StepAction(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StepTag(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubTitle(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubTitlePSLanResId(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubTitlePSLanResName(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VisibleLogic(bl, pSDEWizardStep, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEWizardStep, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_EnableLink(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isEnableLinkDirty() : !pSDEWizardStep.isEnableLinkDirty()) {
            return null;
        }
        Integer n = pSDEWizardStep.getEnableLink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableLink_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLELINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableLogic(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isEnableLogicDirty() : !pSDEWizardStep.isEnableLogicDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getEnableLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnableLogic_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InitPSDEActionId(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isInitPSDEActionIdDirty() : !pSDEWizardStep.isInitPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getInitPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InitPSDEActionId_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INITPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResId(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isLNPSLanResIdDirty() : !pSDEWizardStep.isLNPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getLNPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResId_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LNPSLanResName(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isLNPSLanResNameDirty() : !pSDEWizardStep.isLNPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getLNPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LNPSLanResName_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LNPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isLogicNameDirty() : !pSDEWizardStep.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isMemoDirty() : !pSDEWizardStep.isMemoDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEWizardStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_NextPSDEActionId(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isNextPSDEActionIdDirty() : !pSDEWizardStep.isNextPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getNextPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NextPSDEActionId_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isOrderValueDirty() && !bl2 : !pSDEWizardStep.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEWizardStep.getOrderValue();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEWizardStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isPSDEFormIdDirty() : !pSDEWizardStep.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardId(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isPSDEWizardIdDirty() : !pSDEWizardStep.isPSDEWizardIdDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getPSDEWizardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardId_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardName(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isPSDEWizardNameDirty() : !pSDEWizardStep.isPSDEWizardNameDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getPSDEWizardName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardName_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardStepId(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isPSDEWizardStepIdDirty() && !bl2 : !pSDEWizardStep.isPSDEWizardStepIdDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getPSDEWizardStepId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDSTEPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardStepId_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDSTEPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardStepName(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isPSDEWizardStepNameDirty() && !bl2 : !pSDEWizardStep.isPSDEWizardStepNameDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getPSDEWizardStepName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDSTEPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardStepName_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDSTEPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEWIZARDID";
                String string4 = this.checkFieldDupRule(this.getPSDEWizardStepDEModel(), "PSDEWIZARDSTEPNAME", string3, pSDEWizardStep, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEWIZARDSTEPNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isPSSysCssIdDirty() : !pSDEWizardStep.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isPSSysImageIdDirty() : !pSDEWizardStep.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StepAction(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isStepActionDirty() : !pSDEWizardStep.isStepActionDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getStepAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StepAction_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StepTag(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isStepTagDirty() && !bl2 : !pSDEWizardStep.isStepTagDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getStepTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPTAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_StepTag_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STEPTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEWIZARDID";
                String string4 = this.checkFieldDupRule(this.getPSDEWizardStepDEModel(), "STEPTAG", string3, pSDEWizardStep, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("STEPTAG");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubTitle(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isSubTitleDirty() : !pSDEWizardStep.isSubTitleDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getSubTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubTitle_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBTITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubTitlePSLanResId(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isSubTitlePSLanResIdDirty() : !pSDEWizardStep.isSubTitlePSLanResIdDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getSubTitlePSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubTitlePSLanResId_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBTITLEPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubTitlePSLanResName(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isSubTitlePSLanResNameDirty() : !pSDEWizardStep.isSubTitlePSLanResNameDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getSubTitlePSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubTitlePSLanResName_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBTITLEPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isUserCatDirty() : !pSDEWizardStep.isUserCatDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEWizardStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isUserTagDirty() : !pSDEWizardStep.isUserTagDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEWizardStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isUserTag2Dirty() : !pSDEWizardStep.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEWizardStep.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEWizardStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isUserTag3Dirty() : !pSDEWizardStep.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEWizardStep.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEWizardStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isUserTag4Dirty() : !pSDEWizardStep.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEWizardStep.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEWizardStep, bl2, bl3);
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

    protected EntityFieldError onCheckField_VisibleLogic(boolean bl, PSDEWizardStep pSDEWizardStep, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEWizardStep.isVisibleLogicDirty() : !pSDEWizardStep.isVisibleLogicDirty()) {
            return null;
        }
        String string = pSDEWizardStep.getVisibleLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VisibleLogic_Default(pSDEWizardStep, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VISIBLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
        super.onSyncEntity(pSDEWizardStep, bl);
    }

    protected void onSyncIndexEntities(PSDEWizardStep pSDEWizardStep, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEWizardStep, bl);
    }

    public Object getDataContextValue(PSDEWizardStep pSDEWizardStep, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEWizardStep, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEWizard pSDEWizard = pSDEWizardStep.getPSDEWizard();
        if (pSDEWizard != null && pSDEWizard.contains(string)) {
            return pSDEWizard.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEWizardStep pSDEWizardStep, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_LNPSLanRes(pSDEWizardStep, arrayList, n);
        this.onExportMajorModel_SubTitlePSLanRes(pSDEWizardStep, arrayList, n);
        super.onExportMajorModel(pSDEWizardStep, arrayList, n);
    }

    protected void onExportMajorModel_LNPSLanRes(PSDEWizardStep pSDEWizardStep, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEWizardStep.getLNPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEWizardStep.getLNPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_SubTitlePSLanRes(PSDEWizardStep pSDEWizardStep, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEWizardStep.getSubTitlePSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDEWizardStep.getSubTitlePSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLELINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LNPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LNPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDSTEPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardStepId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDSTEPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardStepName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STEPTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StepTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBTITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubTitle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBTITLEPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubTitlePSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBTITLEPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubTitlePSLanResName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VISIBLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VisibleLogic_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_EnableLink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENABLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LNPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LNPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LNPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_NextPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NextPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEWizardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardStepId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDSTEPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardStepName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDSTEPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPACTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StepTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STEPTAG", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("STEPTAG", iEntity, bl2, "[a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubTitle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBTITLE", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubTitlePSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBTITLEPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubTitlePSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBTITLEPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_VisibleLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VISIBLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEWizardStep pSDEWizardStep) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEWizardStep)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEWizardStep pSDEWizardStep) throws Exception {
        super.onUpdateParent(pSDEWizardStep);
    }

    protected void onCopyDetails(PSDEWizardStep pSDEWizardStep, Object object) throws Exception {
        PSDEWizardStep pSDEWizardStep2 = new PSDEWizardStep();
        pSDEWizardStep2.set("PSDEWIZARDSTEPID", object);
        String string = DataObject.getStringValue((Object)pSDEWizardStep.get("PSDEWIZARDSTEPID"));
        super.onCopyDetails(pSDEWizardStep, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEWizardStep pSDEWizardStep, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEWIZARDSTEP");
        if (!bl) {
            pSDEWizardStep.setCreateDate(null);
            pSDEWizardStep.setCreateMan(null);
            pSDEWizardStep.setPSDEWizardStepId(null);
            pSDEWizardStep.setUpdateDate(null);
            pSDEWizardStep.setUpdateMan(null);
            pSDEWizardStep.setPSDEId(null);
            pSDEWizardStep.setPSDEWizardId(null);
            pSDEWizardStep.setPSDEWizardName(null);
            super.exportCurXmlModel(pSDEWizardStep, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEWizardStep pSDEWizardStep, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEWizardStep, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEWizardStep pSDEWizardStep, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEWizardStep, xmlNode);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEWizardStep pSDEWizardStep, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEWizardStep, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEWIZARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEWIZARD#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEWIZARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEWIZARDSTEP_PSDEWIZARD_PSDEWIZARDID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEWIZARDID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEWIZARDNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEWIZARD", (boolean)true) == 0) {
            iEntity.set("PSDEWIZARDID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEWIZARDID"};
    }

    @Override
    public String getModelV2Tag(PSDEWizardStep pSDEWizardStep) {
        if (!StringHelper.isNullOrEmpty((String)pSDEWizardStep.getPSDEWizardStepName())) {
            return pSDEWizardStep.getPSDEWizardStepName();
        }
        return super.getModelV2Tag(pSDEWizardStep);
    }

    @Override
    public boolean setModelV2Tag(PSDEWizardStep pSDEWizardStep, String string) {
        pSDEWizardStep.setPSDEWizardStepName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEWIZARDSTEPNAME", "");
        map.put("PSDEWIZARDID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEWizardStep pSDEWizardStep, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEWizardStep.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEWizardStep, true);
        pSDEWizardStep.set("PSDEWIZARDSTEPNAME", string);
        if (this.select(pSDEWizardStep, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEWizardStep, true);
        return super.getModelV2Entity(pSDEWizardStep, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEWizardStep pSDEWizardStep, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEWizardStep, objectNode, string, string2, n);
    }
}

