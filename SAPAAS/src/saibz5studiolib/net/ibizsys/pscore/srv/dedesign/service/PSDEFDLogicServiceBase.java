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
 *  net.ibizsys.paas.db.SqlParamList
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
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
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
import net.ibizsys.paas.db.SqlParamList;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOPBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFDLogicDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFDLogicDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetailBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFDLogicServiceBase
extends PSCoreSysServiceBase<PSDEFDLogic> {
    private static final Log log = LogFactory.getLog(PSDEFDLogicServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFDLogicDEModel pSDEFDLogicDEModel;
    private PSDEFDLogicDAO pSDEFDLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService";
    }

    public PSDEFDLogicDEModel getPSDEFDLogicDEModel() {
        if (this.pSDEFDLogicDEModel == null) {
            try {
                this.pSDEFDLogicDEModel = (PSDEFDLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFDLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFDLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFDLogicDEModel();
    }

    public PSDEFDLogicDAO getPSDEFDLogicDAO() {
        if (this.pSDEFDLogicDAO == null) {
            try {
                this.pSDEFDLogicDAO = (PSDEFDLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFDLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFDLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFDLogicDAO();
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

    protected void onFillParentInfo(PSDEFDLogic pSDEFDLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFDLOGIC_PSDBVALUEOP_PSDBVALUEOPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBValueOPService", (SessionFactory)this.getSessionFactory());
            PSDBValueOP pSDBValueOP = (PSDBValueOP)iService.getDEModel().createEntity();
            pSDBValueOP.set("PSDBVALUEOPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDBValueOP);
            } else {
                iService.get(pSDBValueOP);
            }
            this.onFillParentInfo_PSDBValueOp(pSDEFDLogic, pSDBValueOP);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFDLOGIC_PSDEFDLOGIC_PPSDEFDLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService", (SessionFactory)this.getSessionFactory());
            PSDEFDLogic pSDEFDLogic2 = (PSDEFDLogic)iService.getDEModel().createEntity();
            pSDEFDLogic2.set("PSDEFDLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFDLogic2);
            } else {
                iService.get(pSDEFDLogic2);
            }
            this.onFillParentInfo_PPSDEFDLogic(pSDEFDLogic, pSDEFDLogic2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFDLOGIC_PSDEFORMDETAIL_PSDEFORMDETAILID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService", (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail = (PSDEFormDetail)iService.getDEModel().createEntity();
            pSDEFormDetail.set("PSDEFORMDETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFormDetail);
            } else {
                iService.get(pSDEFormDetail);
            }
            this.onFillParentInfo_PSDEFormDetail(pSDEFDLogic, pSDEFormDetail);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFDLOGIC_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEFDLogic, pSDEForm);
            return;
        }
        super.onFillParentInfo(pSDEFDLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFDLOGIC_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", string2);
            return this.onSyncDER1NData_PSDEForm(pSDEForm, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDBValueOp(PSDEFDLogic pSDEFDLogic, PSDBValueOP pSDBValueOP) throws Exception {
        pSDEFDLogic.setPSDBValueOPId(pSDBValueOP.getPSDBValueOPId());
        pSDEFDLogic.setPSDBValueOPName(pSDBValueOP.getPSDBValueOPName());
    }

    protected void onFillParentInfo_PPSDEFDLogic(PSDEFDLogic pSDEFDLogic, PSDEFDLogic pSDEFDLogic2) throws Exception {
        pSDEFDLogic.setPPSDEFDLogicId(pSDEFDLogic2.getPSDEFDLogicId());
        pSDEFDLogic.setPPSDEFDLogicName(pSDEFDLogic2.getPSDEFDLogicName());
        if (pSDEFDLogic2.getPSDEFormDetail() != null) {
            this.onFillParentInfo_PSDEFormDetail(pSDEFDLogic, pSDEFDLogic2.getPSDEFormDetail());
        }
    }

    protected void onFillParentInfo_PSDEFormDetail(PSDEFDLogic pSDEFDLogic, PSDEFormDetail pSDEFormDetail) throws Exception {
        pSDEFDLogic.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
        pSDEFDLogic.setPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEFDLogic pSDEFDLogic, PSDEForm pSDEForm) throws Exception {
        pSDEFDLogic.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEFDLogic.setPSDEFormName(pSDEForm.getPSDEFormName());
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
            ArrayList<PSDEFDLogic> arrayList = this.selectByPSDEForm(pSDEForm);
            for (PSDEFDLogic pSDEFDLogic : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEFDLogic, (String)"PSDEFDLOGICID", (String)""))) continue;
                this.remove(pSDEFDLogic);
            }
        }
        return null;
    }

    protected void onFillEntityFullInfo(PSDEFDLogic pSDEFDLogic, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDEFDLogic, bl);
        this.onFillEntityFullInfo_PSDBValueOp(pSDEFDLogic, bl);
        this.onFillEntityFullInfo_PPSDEFDLogic(pSDEFDLogic, bl);
        this.onFillEntityFullInfo_PSDEFormDetail(pSDEFDLogic, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEFDLogic, bl);
    }

    protected void onFillEntityFullInfo_PSDBValueOp(PSDEFDLogic pSDEFDLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSDEFDLogic(PSDEFDLogic pSDEFDLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFormDetail(PSDEFDLogic pSDEFDLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEFDLogic pSDEFDLogic, boolean bl) throws Exception {
        if (pSDEFDLogic.isPSDEFormIdDirty()) {
            if (pSDEFDLogic.getPSDEFormId() != null) {
                if (pSDEFDLogic.getPSDEFormId() == null || pSDEFDLogic.getPSDEFormName() == null) {
                    PSDEForm pSDEForm = pSDEFDLogic.getPSDEForm();
                    pSDEFDLogic.setPSDEFormName(pSDEForm.getPSDEFormName());
                }
            } else {
                pSDEFDLogic.setPSDEFormName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDEFDLogic pSDEFDLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFDLogic, bl);
    }

    public ArrayList<PSDEFDLogic> selectByPSDBValueOp(PSDBValueOPBase pSDBValueOPBase) throws Exception {
        return this.selectByPSDBValueOp(pSDBValueOPBase, "", -1);
    }

    public ArrayList<PSDEFDLogic> selectByPSDBValueOp(PSDBValueOPBase pSDBValueOPBase, String string) throws Exception {
        return this.selectByPSDBValueOp(pSDBValueOPBase, string, -1);
    }

    public ArrayList<PSDEFDLogic> selectByPSDBValueOp(PSDBValueOPBase pSDBValueOPBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDBVALUEOPID", (Object)pSDBValueOPBase.getPSDBValueOPId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDBValueOpCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDBValueOpCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFDLogic> selectByPPSDEFDLogic(PSDEFDLogicBase pSDEFDLogicBase) throws Exception {
        return this.selectByPPSDEFDLogic(pSDEFDLogicBase, "", -1);
    }

    public ArrayList<PSDEFDLogic> selectByPPSDEFDLogic(PSDEFDLogicBase pSDEFDLogicBase, String string) throws Exception {
        return this.selectByPPSDEFDLogic(pSDEFDLogicBase, string, -1);
    }

    public ArrayList<PSDEFDLogic> selectByPPSDEFDLogic(PSDEFDLogicBase pSDEFDLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEFDLOGICID", (Object)pSDEFDLogicBase.getPSDEFDLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDEFDLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDEFDLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFDLogic> selectTempByPPSDEFDLogic(PSDEFDLogicBase pSDEFDLogicBase) throws Exception {
        return this.selectTempByPPSDEFDLogic(pSDEFDLogicBase, "");
    }

    public ArrayList<PSDEFDLogic> selectTempByPPSDEFDLogic(PSDEFDLogicBase pSDEFDLogicBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEFDLOGICID", (Object)pSDEFDLogicBase.getPSDEFDLogicId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSDEFDLogicCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSDEFDLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFDLogic> selectByPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase) throws Exception {
        return this.selectByPSDEFormDetail(pSDEFormDetailBase, "", -1);
    }

    public ArrayList<PSDEFDLogic> selectByPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string) throws Exception {
        return this.selectByPSDEFormDetail(pSDEFormDetailBase, string, -1);
    }

    public ArrayList<PSDEFDLogic> selectByPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMDETAILID", (Object)pSDEFormDetailBase.getPSDEFormDetailId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormDetailCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormDetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFDLogic> selectTempByPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase) throws Exception {
        return this.selectTempByPSDEFormDetail(pSDEFormDetailBase, "");
    }

    public ArrayList<PSDEFDLogic> selectTempByPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMDETAILID", (Object)pSDEFormDetailBase.getPSDEFormDetailId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFormDetailCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFormDetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFDLogic> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEFDLogic> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEFDLogic> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFDLogic> selectTempByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectTempByPSDEForm(pSDEFormBase, "");
    }

    public ArrayList<PSDEFDLogic> selectTempByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFormCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDBValueOp(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectByPSDBValueOp(pSDBValueOP, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBVALUEOP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDBValueOP);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFDLOGIC_PSDBVALUEOP_PSDBVALUEOPID", "", iDataEntityModel.getName(), "PSDEFDLOGIC", iDataEntityModel.getDataInfo(pSDBValueOP), arrayList.get(0)));
        }
    }

    public void resetPSDBValueOp(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectByPSDBValueOp(pSDBValueOP);
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            PSDEFDLogic pSDEFDLogic2 = (PSDEFDLogic)this.getDEModel().createEntity();
            pSDEFDLogic2.setPSDEFDLogicId(pSDEFDLogic.getPSDEFDLogicId());
            pSDEFDLogic2.setPSDBValueOPId(null);
            this.update(pSDEFDLogic2);
        }
    }

    public void removeByPSDBValueOp(PSDBValueOP pSDBValueOP) throws Exception {
        final PSDBValueOP pSDBValueOP2 = pSDBValueOP;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDLogicServiceBase.this.onBeforeRemoveByPSDBValueOp(pSDBValueOP2);
                PSDEFDLogicServiceBase.this.internalRemoveByPSDBValueOp(pSDBValueOP2);
                PSDEFDLogicServiceBase.this.onAfterRemoveByPSDBValueOp(pSDBValueOP2);
            }
        });
    }

    protected void onBeforeRemoveByPSDBValueOp(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void internalRemoveByPSDBValueOp(PSDBValueOP pSDBValueOP) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectByPSDBValueOp(pSDBValueOP);
        this.onBeforeRemoveByPSDBValueOp(pSDBValueOP, arrayList);
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            this.remove(pSDEFDLogic);
        }
        this.onAfterRemoveByPSDBValueOp(pSDBValueOP, arrayList);
    }

    protected void onAfterRemoveByPSDBValueOp(PSDBValueOP pSDBValueOP) throws Exception {
    }

    protected void onBeforeRemoveByPSDBValueOp(PSDBValueOP pSDBValueOP, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDBValueOp(PSDBValueOP pSDBValueOP, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    public void testRemoveByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
    }

    public void resetPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectByPPSDEFDLogic(pSDEFDLogic);
        for (PSDEFDLogic pSDEFDLogic2 : arrayList) {
            PSDEFDLogic pSDEFDLogic3 = (PSDEFDLogic)this.getDEModel().createEntity();
            pSDEFDLogic3.setPSDEFDLogicId(pSDEFDLogic2.getPSDEFDLogicId());
            pSDEFDLogic3.setPPSDEFDLogicId(null);
            this.update(pSDEFDLogic3);
        }
    }

    public void resetTempPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectTempByPPSDEFDLogic(pSDEFDLogic);
        for (PSDEFDLogic pSDEFDLogic2 : arrayList) {
            PSDEFDLogic pSDEFDLogic3 = (PSDEFDLogic)this.getDEModel().createEntity();
            pSDEFDLogic3.setPSDEFDLogicId(pSDEFDLogic2.getPSDEFDLogicId());
            pSDEFDLogic3.setPPSDEFDLogicId(null);
            this.updateTemp(pSDEFDLogic3);
        }
    }

    public void removeByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
        final PSDEFDLogic pSDEFDLogic2 = pSDEFDLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDLogicServiceBase.this.onBeforeRemoveByPPSDEFDLogic(pSDEFDLogic2);
                PSDEFDLogicServiceBase.this.internalRemoveByPPSDEFDLogic(pSDEFDLogic2);
                PSDEFDLogicServiceBase.this.onAfterRemoveByPPSDEFDLogic(pSDEFDLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
    }

    protected void internalRemoveByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectByPPSDEFDLogic(pSDEFDLogic);
        this.onBeforeRemoveByPPSDEFDLogic(pSDEFDLogic, arrayList);
        for (PSDEFDLogic pSDEFDLogic2 : arrayList) {
            this.remove(pSDEFDLogic2);
        }
        this.onAfterRemoveByPPSDEFDLogic(pSDEFDLogic, arrayList);
    }

    protected void onAfterRemoveByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
    }

    protected void onBeforeRemoveByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    public void resetPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectByPSDEFormDetail(pSDEFormDetail);
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            PSDEFDLogic pSDEFDLogic2 = (PSDEFDLogic)this.getDEModel().createEntity();
            pSDEFDLogic2.setPSDEFDLogicId(pSDEFDLogic.getPSDEFDLogicId());
            pSDEFDLogic2.setPSDEFormDetailId(null);
            this.update(pSDEFDLogic2);
        }
    }

    public void resetTempPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectTempByPSDEFormDetail(pSDEFormDetail);
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            PSDEFDLogic pSDEFDLogic2 = (PSDEFDLogic)this.getDEModel().createEntity();
            pSDEFDLogic2.setPSDEFDLogicId(pSDEFDLogic.getPSDEFDLogicId());
            pSDEFDLogic2.setPSDEFormDetailId(null);
            this.updateTemp(pSDEFDLogic2);
        }
    }

    public void removeByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDLogicServiceBase.this.onBeforeRemoveByPSDEFormDetail(pSDEFormDetail2);
                PSDEFDLogicServiceBase.this.internalRemoveByPSDEFormDetail(pSDEFormDetail2);
                PSDEFDLogicServiceBase.this.onAfterRemoveByPSDEFormDetail(pSDEFormDetail2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void internalRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectByPSDEFormDetail(pSDEFormDetail);
        this.onBeforeRemoveByPSDEFormDetail(pSDEFormDetail, arrayList);
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            this.remove(pSDEFDLogic);
        }
        this.onAfterRemoveByPSDEFormDetail(pSDEFormDetail, arrayList);
    }

    protected void onAfterRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            PSDEFDLogic pSDEFDLogic2 = (PSDEFDLogic)this.getDEModel().createEntity();
            pSDEFDLogic2.setPSDEFDLogicId(pSDEFDLogic.getPSDEFDLogicId());
            pSDEFDLogic2.setPSDEFormId(null);
            this.update(pSDEFDLogic2);
        }
    }

    public void resetTempPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectTempByPSDEForm(pSDEForm);
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            PSDEFDLogic pSDEFDLogic2 = (PSDEFDLogic)this.getDEModel().createEntity();
            pSDEFDLogic2.setPSDEFDLogicId(pSDEFDLogic.getPSDEFDLogicId());
            pSDEFDLogic2.setPSDEFormId(null);
            this.updateTemp(pSDEFDLogic2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDLogicServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEFDLogicServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEFDLogicServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            this.remove(pSDEFDLogic);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFDLogic pSDEFDLogic) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        pSDEFDLogicService.testRemoveByPPSDEFDLogic(pSDEFDLogic);
        pSDEFDLogicService.removeByPPSDEFDLogic(pSDEFDLogic);
        super.onBeforeRemove(pSDEFDLogic);
    }

    protected void onBeforeRemoveTemp(PSDEFDLogic pSDEFDLogic) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        pSDEFDLogicService.resetTempPPSDEFDLogic(pSDEFDLogic);
        super.onBeforeRemoveTemp(pSDEFDLogic);
    }

    public void removeTempByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
        final PSDEFDLogic pSDEFDLogic2 = pSDEFDLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDLogicServiceBase.this.onBeforeRemoveTempByPPSDEFDLogic(pSDEFDLogic2);
                PSDEFDLogicServiceBase.this.internalRemoveTempByPPSDEFDLogic(pSDEFDLogic2);
                PSDEFDLogicServiceBase.this.onAfterRemoveTempByPPSDEFDLogic(pSDEFDLogic2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
    }

    protected void internalRemoveTempByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectTempByPPSDEFDLogic(pSDEFDLogic);
        this.onBeforeRemoveTempByPPSDEFDLogic(pSDEFDLogic, arrayList);
        for (PSDEFDLogic pSDEFDLogic2 : arrayList) {
            this.removeTemp(pSDEFDLogic2);
        }
        this.onAfterRemoveTempByPPSDEFDLogic(pSDEFDLogic, arrayList);
    }

    protected void onAfterRemoveTempByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSDEFDLogic(PSDEFDLogic pSDEFDLogic, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    public void removeTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDLogicServiceBase.this.onBeforeRemoveTempByPSDEFormDetail(pSDEFormDetail2);
                PSDEFDLogicServiceBase.this.internalRemoveTempByPSDEFormDetail(pSDEFormDetail2);
                PSDEFDLogicServiceBase.this.onAfterRemoveTempByPSDEFormDetail(pSDEFormDetail2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void internalRemoveTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectTempByPSDEFormDetail(pSDEFormDetail);
        this.onBeforeRemoveTempByPSDEFormDetail(pSDEFormDetail, arrayList);
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            this.removeTemp(pSDEFDLogic);
        }
        this.onAfterRemoveTempByPSDEFormDetail(pSDEFormDetail, arrayList);
    }

    protected void onAfterRemoveTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    public void removeTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDLogicServiceBase.this.onBeforeRemoveTempByPSDEForm(pSDEForm2);
                PSDEFDLogicServiceBase.this.internalRemoveTempByPSDEForm(pSDEForm2);
                PSDEFDLogicServiceBase.this.onAfterRemoveTempByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFDLogic> arrayList = this.selectTempByPSDEForm(pSDEForm);
        this.onBeforeRemoveTempByPSDEForm(pSDEForm, arrayList);
        for (PSDEFDLogic pSDEFDLogic : arrayList) {
            this.removeTemp(pSDEFDLogic);
        }
        this.onAfterRemoveTempByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFDLogic> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEFDLogic pSDEFDLogic) throws Exception {
        super.getRelatedDataTempMajor(pSDEFDLogic);
    }

    protected void updateRelatedDataTempMajor(PSDEFDLogic pSDEFDLogic, PSDEFDLogic pSDEFDLogic2) throws Exception {
        super.updateRelatedDataTempMajor(pSDEFDLogic, pSDEFDLogic2);
    }

    protected void replaceParentInfo(PSDEFDLogic pSDEFDLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFDLogic, cloneSession);
        if (pSDEFDLogic.getPSDBValueOPId() != null && (iEntity = cloneSession.getEntity("PSDBVALUEOP", (Object)pSDEFDLogic.getPSDBValueOPId())) != null) {
            this.onFillParentInfo_PSDBValueOp(pSDEFDLogic, (PSDBValueOP)iEntity);
        }
        if (pSDEFDLogic.getPPSDEFDLogicId() != null && (iEntity = cloneSession.getEntity("PSDEFDLOGIC", (Object)pSDEFDLogic.getPPSDEFDLogicId())) != null) {
            this.onFillParentInfo_PPSDEFDLogic(pSDEFDLogic, (PSDEFDLogic)iEntity);
        }
        if (pSDEFDLogic.getPSDEFormDetailId() != null && (iEntity = cloneSession.getEntity("PSDEFORMDETAIL", (Object)pSDEFDLogic.getPSDEFormDetailId())) != null) {
            this.onFillParentInfo_PSDEFormDetail(pSDEFDLogic, (PSDEFormDetail)iEntity);
        }
        if (pSDEFDLogic.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEFDLogic.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEFDLogic, (PSDEForm)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFDLogic pSDEFDLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFDLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CondValue(bl, pSDEFDLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FDName(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupNotFlag(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupOP(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicCat(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicType(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDEFDLogicId(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDBValueOPId(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFDLogicId(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFDLogicName(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormDetailId(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormName(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEFDLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFDLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CondValue(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isCondValueDirty() : !pSDEFDLogic.isCondValueDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getCondValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CondValue_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONDVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isCustomCodeDirty() : !pSDEFDLogic.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isDynaModelFlagDirty() : !pSDEFDLogic.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEFDLogic.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEFDLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_FDName(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isFDNameDirty() : !pSDEFDLogic.isFDNameDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getFDName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FDName_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupNotFlag(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isGroupNotFlagDirty() : !pSDEFDLogic.isGroupNotFlagDirty()) {
            return null;
        }
        Integer n = pSDEFDLogic.getGroupNotFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupNotFlag_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPNOTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupOP(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isGroupOPDirty() : !pSDEFDLogic.isGroupOPDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getGroupOP();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupOP_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPOP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicCat(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isLogicCatDirty() : !pSDEFDLogic.isLogicCatDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getLogicCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicCat_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicType(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isLogicTypeDirty() && !bl2 : !pSDEFDLogic.isLogicTypeDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getLogicType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicType_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isOrderValueDirty() : !pSDEFDLogic.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEFDLogic.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEFDLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PPSDEFDLogicId(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isPPSDEFDLogicIdDirty() : !pSDEFDLogic.isPPSDEFDLogicIdDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getPPSDEFDLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDEFDLogicId_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEFDLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDBValueOPId(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isPSDBValueOPIdDirty() : !pSDEFDLogic.isPSDBValueOPIdDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getPSDBValueOPId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDBValueOPId_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDBVALUEOPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFDLogicId(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isPSDEFDLogicIdDirty() && !bl2 : !pSDEFDLogic.isPSDEFDLogicIdDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getPSDEFDLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFDLogicId_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFDLogicName(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isPSDEFDLogicNameDirty() : !pSDEFDLogic.isPSDEFDLogicNameDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getPSDEFDLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFDLogicName_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFDLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormDetailId(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isPSDEFormDetailIdDirty() && !bl2 : !pSDEFDLogic.isPSDEFormDetailIdDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getPSDEFormDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormDetailId_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isPSDEFormIdDirty() : !pSDEFDLogic.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSDEFDLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFormName(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isPSDEFormNameDirty() : !pSDEFDLogic.isPSDEFormNameDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getPSDEFormName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormName_Default(pSDEFDLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEFDLogic pSDEFDLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFDLogic.isPSDynaInstIdDirty() : !pSDEFDLogic.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEFDLogic.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEFDLogic, bl2, bl3);
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

    protected void onSyncEntity(PSDEFDLogic pSDEFDLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFDLogic, bl);
    }

    protected void onSyncIndexEntities(PSDEFDLogic pSDEFDLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFDLogic, bl);
    }

    public Object getDataContextValue(PSDEFDLogic pSDEFDLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFDLogic, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEFormDetail pSDEFormDetail = pSDEFDLogic.getPSDEFormDetail();
        if (pSDEFormDetail != null && pSDEFormDetail.contains(string)) {
            return pSDEFormDetail.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFDLogic pSDEFDLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFDLogic, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONDVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CondValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FDName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPNOTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupNotFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupOP_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEFDLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEFDLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEFDLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDEFDLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDBVALUEOPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDBValueOPName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFDLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFDLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFDLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFDLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CondValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONDVALUE", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FDName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FDNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupNotFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupOP_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPOP", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICCAT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPSDEFDLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEFDLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDEFDLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEFDLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBValueOPId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVALUEOPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDBValueOPName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDBVALUEOPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFDLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFDLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFDLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFDLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMDETAILNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
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

    protected boolean onMergeChild(String string, String string2, PSDEFDLogic pSDEFDLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFDLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFDLogic pSDEFDLogic) throws Exception {
        super.onUpdateParent(pSDEFDLogic);
    }

    protected void onCopyDetails(PSDEFDLogic pSDEFDLogic, Object object) throws Exception {
        PSDEFDLogic pSDEFDLogic2 = new PSDEFDLogic();
        pSDEFDLogic2.set("PSDEFDLOGICID", object);
        String string = DataObject.getStringValue((Object)pSDEFDLogic.get("PSDEFDLOGICID"));
        super.onCopyDetails(pSDEFDLogic, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEFDLogic pSDEFDLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFDLOGIC");
        if (!bl) {
            pSDEFDLogic.setPPSDEFDLogicId(null);
            pSDEFDLogic.setPSDEFormDetailId(null);
            pSDEFDLogic.setPSDEFormDetailName(null);
            pSDEFDLogic.setPSDEFormId(null);
            pSDEFDLogic.setPSDEFormName(null);
            super.exportCurXmlModel(pSDEFDLogic, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEFDLogic pSDEFDLogic, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEFDLogic(pSDEFDLogic, xmlNode);
        super.onExportRelatedXmlModel(pSDEFDLogic, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEFDLogic(PSDEFDLogic pSDEFDLogic, XmlNode xmlNode) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDLogic> arrayList = null;
        String string = pSDEFDLogic.getPSDEFDLogicId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEFDLogicService.selectByPPSDEFDLogic(pSDEFDLogic, "ORDER BY ORDERVALUE ASC") : pSDEFDLogicService.selectTempByPPSDEFDLogic(pSDEFDLogic, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEFDLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSDEFDLogic pSDEFDLogic2 : arrayList) {
                pSDEFDLogic2.set("ORDERVALUE", null);
                pSDEFDLogicService.exportXmlModel(pSDEFDLogic2, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEFDLogic pSDEFDLogic, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEFDLOGICS");
        this.importRelatedXmlModel_PSDEFDLogic(pSDEFDLogic, xmlNode2);
        super.onImportRelatedXmlModel(pSDEFDLogic, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEFDLogic(PSDEFDLogic pSDEFDLogic, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEFDLogic.getPSDEFDLogicId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEFDLogicService.removeByPPSDEFDLogic(pSDEFDLogic);
        } else {
            pSDEFDLogicService.removeTempByPPSDEFDLogic(pSDEFDLogic);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFDLogic pSDEFDLogic2 = new PSDEFDLogic();
                pSDEFDLogic2.setOrderValue(n);
                n += 100;
                pSDEFDLogicService.fillParentInfo(pSDEFDLogic2, "DER1N", "DER1N_PSDEFDLOGIC_PSDEFDLOGIC_PPSDEFDLOGICID", pSDEFDLogic.getPSDEFDLogicId());
                pSDEFDLogicService.importXmlModel(pSDEFDLogic2, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFDLogic pSDEFDLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFDLogic, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFDLOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFDLOGIC#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMDETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFORMDETAIL#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFORM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFDLOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFDLOGIC_PSDEFDLOGIC_PPSDEFDLOGICID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMDETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFDLOGIC_PSDEFORMDETAIL_PSDEFORMDETAILID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFDLOGIC_PSDEFORM_PSDEFORMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFDLOGICID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSDEFDLOGICNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMDETAILID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMDETAILNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFDLOGIC", (boolean)true) == 0) {
            iEntity.set("PPSDEFDLOGICID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMDETAIL", (boolean)true) == 0) {
            iEntity.set("PSDEFORMDETAILID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORM", (boolean)true) == 0) {
            iEntity.set("PSDEFORMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSDEFDLOGICID", "PSDEFORMDETAILID", "PSDEFORMID"};
    }

    @Override
    public String getModelV2Tag(PSDEFDLogic pSDEFDLogic) {
        return super.getModelV2Tag(pSDEFDLogic);
    }

    @Override
    public boolean setModelV2Tag(PSDEFDLogic pSDEFDLogic, String string) {
        return super.setModelV2Tag(pSDEFDLogic, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PPSDEFDLOGICID", "");
        map.put("PSDEFORMDETAILID", "");
        map.put("PSDEFORMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFDLogic pSDEFDLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFDLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFDLogic, true);
        return super.getModelV2Entity(pSDEFDLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFDLogic pSDEFDLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDEFDLogic.getPPSDEFDLogicId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFDLogic.getPSDEFormDetailId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdeformdetailid")) {
            objectNode.put("psdeformdetailid", "<PSDEFORMDETAIL>");
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFDLogic.getPSDEFormId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdeformid")) {
            objectNode.put("psdeformid", "<PSDEFORM>");
        }
        return super.testCompileCurModelV2(pSDEFDLogic, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDEFDLogic pSDEFDLogic, String string, Map<String, String> map) throws Exception {
        if (PSDEFDLogicServiceBase.isSimpleImportExportMode()) {
            map.put("PPSDEFDLOGICID", "");
            map.put("PSDEFORMDETAILID", "");
            map.put("PSDEFORMID", "");
        }
        return super.onFillModelV2(objectNode, pSDEFDLogic, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSDEFDLOGIC_PSDEFDLOGIC_PPSDEFDLOGICID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEFDLogic pSDEFDLogic, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEFDLogic, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEFDLogic pSDEFDLogic, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEFDLOGIC_PSDEFDLOGIC_PPSDEFDLOGICID")) {
            PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEFDLOGIC#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEFDLOGIC", (Object)pSDEFDLogic.getPSDEFDLogicId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty((String)line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString((String)line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEFDLOGIC#%1$s", (Object)pSDEFDLogic.getPSDEFDLogicId());
                for (PSDEFDLogic logic : pSDEFDLogicService.selectByPPSDEFDLogic(pSDEFDLogic)) {
                    String logicScope = pSDEFDLogicService.getModelV2ResScope(logic);
                    if (StringHelper.compare((String)scope, (String)logicScope, (boolean)false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(logic, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode output = objectNode.putArray(pSDEFDLogicService.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdefdlogicname")) {
                            string = objectNode.get("psdefdlogicname").asText();
                        }
                        if (objectNode2.has("psdefdlogicname")) {
                            string2 = objectNode2.get("psdefdlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode logicNode : arrayList) {
                    PSDEFDLogic logic = new PSDEFDLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)logic, logicNode, false);
                    logic.remove("ordervalue");
                    output.add((JsonNode)pSDEFDLogicService.exportModelV2(logic, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEFDLogic, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEFDLogic pSDEFDLogic) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDLogic> arrayList = pSDEFDLogicService.selectByPPSDEFDLogic(pSDEFDLogic);
        String string = StringHelper.format((String)"PSDEFDLOGIC#%1$s", (Object)pSDEFDLogic.getPSDEFDLogicId());
        for (PSDEFDLogic pSDEFDLogic2 : arrayList) {
            String string2 = pSDEFDLogicService.getModelV2ResScope(pSDEFDLogic2);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEFDLogicService.emptyModelV2(pSDEFDLogic2);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEFDLogic.getPSDEFDLogicId());
        pSDEFDLogicService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEFDLogicService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEFDLOGIC WHERE PPSDEFDLOGICID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEFDLogic);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEFDLogicService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEFDLogic pSDEFDLogic, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSDEFDLogic pSDEFDLogic2 = new PSDEFDLogic();
        pSDEFDLogic2.set("PPSDEFDLOGICID", pSDEFDLogic.getPSDEFDLogicId());
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSDEFDLogicService.getModelV2Entity(pSDEFDLogic2, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEFDLogic, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEFDLogic pSDEFDLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSDEFDLogicService.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSDEFDLogic pSDEFDLogic2 = new PSDEFDLogic();
                pSDEFDLogic2.setPPSDEFDLogicId(pSDEFDLogic.getPSDEFDLogicId());
                pSDEFDLogic2.setPPSDEFDLogicName(pSDEFDLogic.getPSDEFDLogicName());
                pSDEFDLogic2.setOrderValue(n2 += 10);
                pSDEFDLogicService.compileModelV2(pSDEFDLogic2, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSDEFDLogic pSDEFDLogic3 = new PSDEFDLogic();
                    pSDEFDLogic3.setPPSDEFDLogicId(pSDEFDLogic.getPSDEFDLogicId());
                    pSDEFDLogic3.setPPSDEFDLogicName(pSDEFDLogic.getPSDEFDLogicName());
                    pSDEFDLogicService.compileModelV2(pSDEFDLogic3, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEFDLogic, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEFDLogic pSDEFDLogic, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEFDLOGIC_PSDEFDLOGIC_PPSDEFDLOGICID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEFDLogics(pSDEFDLogic, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEFDLogic, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEFDLogics(PSDEFDLogic pSDEFDLogic, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEFDLOGIC", true), (boolean)false) == 0) {
            PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEFDLogic pSDEFDLogic2 = new PSDEFDLogic();
            pSDEFDLogic2.setPSDEFDLogicId(pSMOSFile.getPSModelId());
            if (!pSDEFDLogicService.get(pSDEFDLogic2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEFDLogic2.getPPSDEFDLogicId(), (String)pSDEFDLogic.getPSDEFDLogicId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEFDLogicService.exportModelV2(pSDEFDLogic2);
            pSDEFDLogic2.reset();
            if (!pSDEFDLogicService.setModelV2ResScope(pSDEFDLogic2, "PSDEFDLOGIC", pSDEFDLogic.getPSDEFDLogicId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEFDLogicService.importModelV2(pSDEFDLogic2, objectNode);
            SessionFactoryManager.commit();
            return pSDEFDLogicService.getFile(pSDEFDLogic2);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEFDLogic pSDEFDLogic, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEFDLogics(pSDEFDLogic, list);
        super.onFillPasteHelps(pSDEFDLogic, list);
    }

    protected void onFillPasteHelps_PSDEFDLogics(PSDEFDLogic pSDEFDLogic, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEFDLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDEFDLOGIC_PSDEFDLOGIC_PPSDEFDLOGICID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u8868\u5355\u6210\u5458\u903b\u8f91]\u7684[\u8868\u5355\u6210\u5458\u903b\u8f91]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSDEFDLogic pSDEFDLogic) throws Exception {
        return pSDEFDLogic.getLogicType();
    }
}
