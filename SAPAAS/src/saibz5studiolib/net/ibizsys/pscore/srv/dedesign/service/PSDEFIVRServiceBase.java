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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFIVRDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFIVRDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIVR;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRuleBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetailBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRuleBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFIVRServiceBase
extends PSCoreSysServiceBase<PSDEFIVR> {
    private static final Log log = LogFactory.getLog(PSDEFIVRServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFIVRDEModel pSDEFIVRDEModel;
    private PSDEFIVRDAO pSDEFIVRDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRService";
    }

    public PSDEFIVRDEModel getPSDEFIVRDEModel() {
        if (this.pSDEFIVRDEModel == null) {
            try {
                this.pSDEFIVRDEModel = (PSDEFIVRDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFIVRDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFIVRDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFIVRDEModel();
    }

    public PSDEFIVRDAO getPSDEFIVRDAO() {
        if (this.pSDEFIVRDAO == null) {
            try {
                this.pSDEFIVRDAO = (PSDEFIVRDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFIVRDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFIVRDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFIVRDAO();
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

    protected void onFillParentInfo(PSDEFIVR pSDEFIVR, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIVR_PSDEFORMDETAIL_PSDEFIID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService", (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail = (PSDEFormDetail)iService.getDEModel().createEntity();
            pSDEFormDetail.set("PSDEFORMDETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFormDetail);
            } else {
                iService.get((IEntity)pSDEFormDetail);
            }
            this.onFillParentInfo_PSDEFI(pSDEFIVR, pSDEFormDetail);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIVR_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEFIVR, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIVR_PSDEFVALUERULE_PSDEFVRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService", (SessionFactory)this.getSessionFactory());
            PSDEFValueRule pSDEFValueRule = (PSDEFValueRule)iService.getDEModel().createEntity();
            pSDEFValueRule.set("PSDEFVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFValueRule);
            } else {
                iService.get((IEntity)pSDEFValueRule);
            }
            this.onFillParentInfo_PSDEFVR(pSDEFIVR, pSDEFValueRule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIVR_PSSYSVALUERULE_PSSYSVALUERULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService", (SessionFactory)this.getSessionFactory());
            PSSysValueRule pSSysValueRule = (PSSysValueRule)iService.getDEModel().createEntity();
            pSSysValueRule.set("PSSYSVALUERULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysValueRule);
            } else {
                iService.get((IEntity)pSSysValueRule);
            }
            this.onFillParentInfo_PSSysValueRule(pSDEFIVR, pSSysValueRule);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEFIVR, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFIVR_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", string2);
            return this.onSyncDER1NData_PSDEForm(pSDEForm, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEFI(PSDEFIVR pSDEFIVR, PSDEFormDetail pSDEFormDetail) throws Exception {
        pSDEFIVR.setPSDEFIId(pSDEFormDetail.getPSDEFormDetailId());
        pSDEFIVR.setPSDEFIName(pSDEFormDetail.getPSDEFormDetailName());
        if (pSDEFormDetail.getPSDEForm() != null) {
            this.onFillParentInfo_PSDEForm(pSDEFIVR, pSDEFormDetail.getPSDEForm());
        }
    }

    protected void onFillParentInfo_PSDEForm(PSDEFIVR pSDEFIVR, PSDEForm pSDEForm) throws Exception {
        pSDEFIVR.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEFIVR.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected String onSyncDER1NData_PSDEForm(PSDEForm pSDEForm, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEForm(pSDEForm);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEFIVR> arrayList = this.selectByPSDEForm(pSDEForm);
            for (PSDEFIVR pSDEFIVR : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEFIVR, (String)"PSDEFIVRID", (String)""))) continue;
                this.remove((IEntity)pSDEFIVR);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEFVR(PSDEFIVR pSDEFIVR, PSDEFValueRule pSDEFValueRule) throws Exception {
        pSDEFIVR.setPSDEFVRId(pSDEFValueRule.getPSDEFValueRuleId());
        pSDEFIVR.setPSDEFVRName(pSDEFValueRule.getPSDEFValueRuleName());
    }

    protected void onFillParentInfo_PSSysValueRule(PSDEFIVR pSDEFIVR, PSSysValueRule pSSysValueRule) throws Exception {
        pSDEFIVR.setPSSysValueRuleId(pSSysValueRule.getPSSysValueRuleId());
        pSDEFIVR.setPSSysValueRuleName(pSSysValueRule.getPSSysValueRuleName());
    }

    protected void onFillEntityFullInfo(PSDEFIVR pSDEFIVR, boolean bl) throws Exception {
        if (bl) {
            if (pSDEFIVR.getPSDEFIVRName() == null) {
                pSDEFIVR.setPSDEFIVRName((String)this.getDefaultValue(this.getWebContext(), "", "\u8868\u5355\u9879\u503c\u89c4\u5219", 25));
            }
            if (pSDEFIVR.getVRType() == null) {
                pSDEFIVR.setVRType((String)this.getDefaultValue(this.getWebContext(), "", "DEFVALUERULE", 25));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEFIVR, bl);
        this.onFillEntityFullInfo_PSDEFI(pSDEFIVR, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEFIVR, bl);
        this.onFillEntityFullInfo_PSDEFVR(pSDEFIVR, bl);
        this.onFillEntityFullInfo_PSSysValueRule(pSDEFIVR, bl);
    }

    protected void onFillEntityFullInfo_PSDEFI(PSDEFIVR pSDEFIVR, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEFIVR pSDEFIVR, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFVR(PSDEFIVR pSDEFIVR, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysValueRule(PSDEFIVR pSDEFIVR, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFIVR pSDEFIVR, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEFIVR, bl);
    }

    public ArrayList<PSDEFIVR> selectByPSDEFI(PSDEFormDetailBase pSDEFormDetailBase) throws Exception {
        return this.selectByPSDEFI(pSDEFormDetailBase, "", -1);
    }

    public ArrayList<PSDEFIVR> selectByPSDEFI(PSDEFormDetailBase pSDEFormDetailBase, String string) throws Exception {
        return this.selectByPSDEFI(pSDEFormDetailBase, string, -1);
    }

    public ArrayList<PSDEFIVR> selectByPSDEFI(PSDEFormDetailBase pSDEFormDetailBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFIID", (Object)pSDEFormDetailBase.getPSDEFormDetailId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFICond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFIVR> selectTempByPSDEFI(PSDEFormDetailBase pSDEFormDetailBase) throws Exception {
        return this.selectTempByPSDEFI(pSDEFormDetailBase, "");
    }

    public ArrayList<PSDEFIVR> selectTempByPSDEFI(PSDEFormDetailBase pSDEFormDetailBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFIID", (Object)pSDEFormDetailBase.getPSDEFormDetailId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFICond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFICond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFIVR> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEFIVR> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEFIVR> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFIVR> selectTempByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectTempByPSDEForm(pSDEFormBase, "");
    }

    public ArrayList<PSDEFIVR> selectTempByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFormCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFIVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFIVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string) throws Exception {
        return this.selectByPSDEFVR(pSDEFValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFIVR> selectByPSDEFVR(PSDEFValueRuleBase pSDEFValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFVRID", (Object)pSDEFValueRuleBase.getPSDEFValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFVRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFVRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFIVR> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, "", -1);
    }

    public ArrayList<PSDEFIVR> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string) throws Exception {
        return this.selectByPSSysValueRule(pSSysValueRuleBase, string, -1);
    }

    public ArrayList<PSDEFIVR> selectByPSSysValueRule(PSSysValueRuleBase pSSysValueRuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVALUERULEID", (Object)pSSysValueRuleBase.getPSSysValueRuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysValueRuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysValueRuleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    public void resetPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectByPSDEFI(pSDEFormDetail);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            PSDEFIVR pSDEFIVR2 = (PSDEFIVR)this.getDEModel().createEntity();
            pSDEFIVR2.setPSDEFIVRId(pSDEFIVR.getPSDEFIVRId());
            pSDEFIVR2.setPSDEFIId(null);
            this.update(pSDEFIVR2);
        }
    }

    public void resetTempPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectTempByPSDEFI(pSDEFormDetail);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            PSDEFIVR pSDEFIVR2 = (PSDEFIVR)this.getDEModel().createEntity();
            pSDEFIVR2.setPSDEFIVRId(pSDEFIVR.getPSDEFIVRId());
            pSDEFIVR2.setPSDEFIId(null);
            this.updateTemp((IEntity)pSDEFIVR2);
        }
    }

    public void removeByPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIVRServiceBase.this.onBeforeRemoveByPSDEFI(pSDEFormDetail2);
                PSDEFIVRServiceBase.this.internalRemoveByPSDEFI(pSDEFormDetail2);
                PSDEFIVRServiceBase.this.onAfterRemoveByPSDEFI(pSDEFormDetail2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void internalRemoveByPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectByPSDEFI(pSDEFormDetail);
        this.onBeforeRemoveByPSDEFI(pSDEFormDetail, arrayList);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            this.remove((IEntity)pSDEFIVR);
        }
        this.onAfterRemoveByPSDEFI(pSDEFormDetail, arrayList);
    }

    protected void onAfterRemoveByPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFI(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFI(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            PSDEFIVR pSDEFIVR2 = (PSDEFIVR)this.getDEModel().createEntity();
            pSDEFIVR2.setPSDEFIVRId(pSDEFIVR.getPSDEFIVRId());
            pSDEFIVR2.setPSDEFormId(null);
            this.update(pSDEFIVR2);
        }
    }

    public void resetTempPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectTempByPSDEForm(pSDEForm);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            PSDEFIVR pSDEFIVR2 = (PSDEFIVR)this.getDEModel().createEntity();
            pSDEFIVR2.setPSDEFIVRId(pSDEFIVR.getPSDEFIVRId());
            pSDEFIVR2.setPSDEFormId(null);
            this.updateTemp((IEntity)pSDEFIVR2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIVRServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEFIVRServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEFIVRServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            this.remove((IEntity)pSDEFIVR);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIVR_PSDEFVALUERULE_PSDEFVRID", "", iDataEntityModel.getName(), "PSDEFIVR", iDataEntityModel.getDataInfo((IEntity)pSDEFValueRule), arrayList.get(0)));
        }
    }

    public void resetPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            PSDEFIVR pSDEFIVR2 = (PSDEFIVR)this.getDEModel().createEntity();
            pSDEFIVR2.setPSDEFIVRId(pSDEFIVR.getPSDEFIVRId());
            pSDEFIVR2.setPSDEFVRId(null);
            this.update(pSDEFIVR2);
        }
    }

    public void removeByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        final PSDEFValueRule pSDEFValueRule2 = pSDEFValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIVRServiceBase.this.onBeforeRemoveByPSDEFVR(pSDEFValueRule2);
                PSDEFIVRServiceBase.this.internalRemoveByPSDEFVR(pSDEFValueRule2);
                PSDEFIVRServiceBase.this.onAfterRemoveByPSDEFVR(pSDEFValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void internalRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectByPSDEFVR(pSDEFValueRule);
        this.onBeforeRemoveByPSDEFVR(pSDEFValueRule, arrayList);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            this.remove((IEntity)pSDEFIVR);
        }
        this.onAfterRemoveByPSDEFVR(pSDEFValueRule, arrayList);
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFVR(PSDEFValueRule pSDEFValueRule, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    public void testRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectByPSSysValueRule(pSSysValueRule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVALUERULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysValueRule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIVR_PSSYSVALUERULE_PSSYSVALUERULEID", "", iDataEntityModel.getName(), "PSDEFIVR", iDataEntityModel.getDataInfo((IEntity)pSSysValueRule), arrayList.get(0)));
        }
    }

    public void resetPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            PSDEFIVR pSDEFIVR2 = (PSDEFIVR)this.getDEModel().createEntity();
            pSDEFIVR2.setPSDEFIVRId(pSDEFIVR.getPSDEFIVRId());
            pSDEFIVR2.setPSSysValueRuleId(null);
            this.update(pSDEFIVR2);
        }
    }

    public void removeByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        final PSSysValueRule pSSysValueRule2 = pSSysValueRule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIVRServiceBase.this.onBeforeRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFIVRServiceBase.this.internalRemoveByPSSysValueRule(pSSysValueRule2);
                PSDEFIVRServiceBase.this.onAfterRemoveByPSSysValueRule(pSSysValueRule2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void internalRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectByPSSysValueRule(pSSysValueRule);
        this.onBeforeRemoveByPSSysValueRule(pSSysValueRule, arrayList);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            this.remove((IEntity)pSDEFIVR);
        }
        this.onAfterRemoveByPSSysValueRule(pSSysValueRule, arrayList);
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule) throws Exception {
    }

    protected void onBeforeRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysValueRule(PSSysValueRule pSSysValueRule, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFIVR pSDEFIVR) throws Exception {
        super.onBeforeRemove(pSDEFIVR);
    }

    public void removeTempByPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIVRServiceBase.this.onBeforeRemoveTempByPSDEFI(pSDEFormDetail2);
                PSDEFIVRServiceBase.this.internalRemoveTempByPSDEFI(pSDEFormDetail2);
                PSDEFIVRServiceBase.this.onAfterRemoveTempByPSDEFI(pSDEFormDetail2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void internalRemoveTempByPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectTempByPSDEFI(pSDEFormDetail);
        this.onBeforeRemoveTempByPSDEFI(pSDEFormDetail, arrayList);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            this.removeTemp((IEntity)pSDEFIVR);
        }
        this.onAfterRemoveTempByPSDEFI(pSDEFormDetail, arrayList);
    }

    protected void onAfterRemoveTempByPSDEFI(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEFI(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEFI(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    public void removeTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIVRServiceBase.this.onBeforeRemoveTempByPSDEForm(pSDEForm2);
                PSDEFIVRServiceBase.this.internalRemoveTempByPSDEForm(pSDEForm2);
                PSDEFIVRServiceBase.this.onAfterRemoveTempByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIVR> arrayList = this.selectTempByPSDEForm(pSDEForm);
        this.onBeforeRemoveTempByPSDEForm(pSDEForm, arrayList);
        for (PSDEFIVR pSDEFIVR : arrayList) {
            this.removeTemp((IEntity)pSDEFIVR);
        }
        this.onAfterRemoveTempByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIVR> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEFIVR pSDEFIVR, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEFIVR, cloneSession);
        if (pSDEFIVR.getPSDEFIId() != null && (iEntity = cloneSession.getEntity("PSDEFORMDETAIL", (Object)pSDEFIVR.getPSDEFIId())) != null) {
            this.onFillParentInfo_PSDEFI(pSDEFIVR, (PSDEFormDetail)iEntity);
        }
        if (pSDEFIVR.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEFIVR.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEFIVR, (PSDEForm)iEntity);
        }
        if (pSDEFIVR.getPSDEFVRId() != null && (iEntity = cloneSession.getEntity("PSDEFVALUERULE", (Object)pSDEFIVR.getPSDEFVRId())) != null) {
            this.onFillParentInfo_PSDEFVR(pSDEFIVR, (PSDEFValueRule)iEntity);
        }
        if (pSDEFIVR.getPSSysValueRuleId() != null && (iEntity = cloneSession.getEntity("PSSYSVALUERULE", (Object)pSDEFIVR.getPSSysValueRuleId())) != null) {
            this.onFillParentInfo_PSSysValueRule(pSDEFIVR, (PSSysValueRule)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFIVR pSDEFIVR, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEFIVR, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CheckMode(bl, pSDEFIVR, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelState(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFIId(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFIVRId(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFIVRName(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFVRId(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysValueRuleId(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VRType(bl, pSDEFIVR, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEFIVR, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CheckMode(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isCheckModeDirty() : !pSDEFIVR.isCheckModeDirty()) {
            return null;
        }
        Integer n = pSDEFIVR.getCheckMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CheckMode_Default((IEntity)pSDEFIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHECKMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isDynaModelFlagDirty() : !pSDEFIVR.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEFIVR.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEFIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isMemoDirty() : !pSDEFIVR.isMemoDirty()) {
            return null;
        }
        String string = pSDEFIVR.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEFIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelState(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isModelStateDirty() : !pSDEFIVR.isModelStateDirty()) {
            return null;
        }
        Integer n = pSDEFIVR.getModelState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ModelState_Default((IEntity)pSDEFIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isOrderValueDirty() : !pSDEFIVR.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEFIVR.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEFIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFIId(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isPSDEFIIdDirty() && !bl2 : !pSDEFIVR.isPSDEFIIdDirty()) {
            return null;
        }
        String string = pSDEFIVR.getPSDEFIId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFIId_Default((IEntity)pSDEFIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFIVRId(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isPSDEFIVRIdDirty() && !bl2 : !pSDEFIVR.isPSDEFIVRIdDirty()) {
            return null;
        }
        String string = pSDEFIVR.getPSDEFIVRId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIVRID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFIVRId_Default((IEntity)pSDEFIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIVRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFIVRName(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isPSDEFIVRNameDirty() : !pSDEFIVR.isPSDEFIVRNameDirty()) {
            return null;
        }
        String string = pSDEFIVR.getPSDEFIVRName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFIVRName_Default((IEntity)pSDEFIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIVRNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isPSDEFormIdDirty() && !bl2 : !pSDEFIVR.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEFIVR.getPSDEFormId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default((IEntity)pSDEFIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFVRId(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isPSDEFVRIdDirty() : !pSDEFIVR.isPSDEFVRIdDirty()) {
            return null;
        }
        String string = pSDEFIVR.getPSDEFVRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFVRId_Default((IEntity)pSDEFIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFVRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isPSDynaInstIdDirty() : !pSDEFIVR.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEFIVR.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEFIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysValueRuleId(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isPSSysValueRuleIdDirty() : !pSDEFIVR.isPSSysValueRuleIdDirty()) {
            return null;
        }
        String string = pSDEFIVR.getPSSysValueRuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysValueRuleId_Default((IEntity)pSDEFIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVALUERULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isUserCatDirty() : !pSDEFIVR.isUserCatDirty()) {
            return null;
        }
        String string = pSDEFIVR.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEFIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isUserTagDirty() : !pSDEFIVR.isUserTagDirty()) {
            return null;
        }
        String string = pSDEFIVR.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEFIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isUserTag2Dirty() : !pSDEFIVR.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEFIVR.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEFIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isUserTag3Dirty() : !pSDEFIVR.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEFIVR.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEFIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isUserTag4Dirty() : !pSDEFIVR.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEFIVR.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEFIVR, bl2, bl3);
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

    protected EntityFieldError onCheckField_VRType(boolean bl, PSDEFIVR pSDEFIVR, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIVR.isVRTypeDirty() : !pSDEFIVR.isVRTypeDirty()) {
            return null;
        }
        String string = pSDEFIVR.getVRType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VRType_Default((IEntity)pSDEFIVR, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VRTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEFIVR pSDEFIVR, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEFIVR, bl);
    }

    protected void onSyncIndexEntities(PSDEFIVR pSDEFIVR, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEFIVR, bl);
    }

    public Object getDataContextValue(PSDEFIVR pSDEFIVR, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEFIVR, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEFormDetail pSDEFormDetail = pSDEFIVR.getPSDEFI();
        if (pSDEFormDetail != null && pSDEFormDetail.contains(string)) {
            return pSDEFormDetail.get(string);
        }
        PSDEForm pSDEForm = pSDEFIVR.getPSDEForm();
        if (pSDEForm != null && pSDEForm.contains(string)) {
            return pSDEForm.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFIVR pSDEFIVR, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDEFIVR, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CHECKMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CheckMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFINAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIVRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIVRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIVRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIVRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFVRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFVRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVALUERULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysValueRuleName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VRTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VRType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CheckMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ModelState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEFIId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFIName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFINAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFIVRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIVRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFIVRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIVRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDEFVRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFVRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFVRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysValueRuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVALUERULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_VRType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VRTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDEFIVR pSDEFIVR) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEFIVR)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFIVR pSDEFIVR) throws Exception {
        super.onUpdateParent((IEntity)pSDEFIVR);
    }

    @Override
    protected void exportCurXmlModel(PSDEFIVR pSDEFIVR, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFIVR");
        if (!bl) {
            pSDEFIVR.setCreateDate(null);
            pSDEFIVR.setCreateMan(null);
            pSDEFIVR.setPSDEFIVRId(null);
            pSDEFIVR.setUpdateDate(null);
            pSDEFIVR.setUpdateMan(null);
            pSDEFIVR.setPSDEFIId(null);
            pSDEFIVR.setPSDEFormId(null);
            pSDEFIVR.setPSDEFormName(null);
            super.exportCurXmlModel(pSDEFIVR, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFIVR pSDEFIVR, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFIVR, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFORM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFIVR_PSDEFORM_PSDEFORMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFORM", (boolean)true) == 0) {
            iEntity.set("PSDEFORMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEFORMID"};
    }

    @Override
    public String getModelV2Tag(PSDEFIVR pSDEFIVR) {
        return super.getModelV2Tag(pSDEFIVR);
    }

    @Override
    public boolean setModelV2Tag(PSDEFIVR pSDEFIVR, String string) {
        return super.setModelV2Tag(pSDEFIVR, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEFORMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFIVR pSDEFIVR, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFIVR.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFIVR, true);
        return super.getModelV2Entity(pSDEFIVR, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFIVR pSDEFIVR, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSDEFIVR, objectNode, string, string2, n);
    }
}

