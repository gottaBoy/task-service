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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEFIUDetailDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEFIUDetailDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetailBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFIUDetailServiceBase
extends PSCoreSysServiceBase<PSDEFIUDetail> {
    private static final Log log = LogFactory.getLog(PSDEFIUDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDEFIUDetailDEModel pSDEFIUDetailDEModel;
    private PSDEFIUDetailDAO pSDEFIUDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailService";
    }

    public PSDEFIUDetailDEModel getPSDEFIUDetailDEModel() {
        if (this.pSDEFIUDetailDEModel == null) {
            try {
                this.pSDEFIUDetailDEModel = (PSDEFIUDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFIUDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFIUDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEFIUDetailDEModel();
    }

    public PSDEFIUDetailDAO getPSDEFIUDetailDAO() {
        if (this.pSDEFIUDetailDAO == null) {
            try {
                this.pSDEFIUDetailDAO = (PSDEFIUDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEFIUDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFIUDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEFIUDetailDAO();
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

    protected void onFillParentInfo(PSDEFIUDetail pSDEFIUDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIUDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateService", (SessionFactory)this.getSessionFactory());
            PSDEFIUpdate pSDEFIUpdate = (PSDEFIUpdate)iService.getDEModel().createEntity();
            pSDEFIUpdate.set("PSDEFIUPDATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFIUpdate);
            } else {
                iService.get(pSDEFIUpdate);
            }
            this.onFillParentInfo_PSDEFIUpdate(pSDEFIUDetail, pSDEFIUpdate);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIUDETAIL_PSDEFORMDETAIL_PSDEFORMDETAILID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService", (SessionFactory)this.getSessionFactory());
            PSDEFormDetail pSDEFormDetail = (PSDEFormDetail)iService.getDEModel().createEntity();
            pSDEFormDetail.set("PSDEFORMDETAILID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFormDetail);
            } else {
                iService.get(pSDEFormDetail);
            }
            this.onFillParentInfo_PSDEFormDetail(pSDEFIUDetail, pSDEFormDetail);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEFIUDETAIL_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEForm);
            } else {
                iService.get(pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEFIUDetail, pSDEForm);
            return;
        }
        super.onFillParentInfo(pSDEFIUDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEFIUDETAIL_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", string2);
            return this.onSyncDER1NData_PSDEForm(pSDEForm, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEFIUpdate(PSDEFIUDetail pSDEFIUDetail, PSDEFIUpdate pSDEFIUpdate) throws Exception {
        pSDEFIUDetail.setPSDEFIUpdateId(pSDEFIUpdate.getPSDEFIUpdateId());
        pSDEFIUDetail.setPSDEFIUpdateName(pSDEFIUpdate.getPSDEFIUpdateName());
        if (pSDEFIUpdate.getPSDEForm() != null) {
            this.onFillParentInfo_PSDEForm(pSDEFIUDetail, pSDEFIUpdate.getPSDEForm());
        }
    }

    protected void onFillParentInfo_PSDEFormDetail(PSDEFIUDetail pSDEFIUDetail, PSDEFormDetail pSDEFormDetail) throws Exception {
        pSDEFIUDetail.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
        pSDEFIUDetail.setPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEFIUDetail pSDEFIUDetail, PSDEForm pSDEForm) throws Exception {
        pSDEFIUDetail.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEFIUDetail.setPSDEFormName(pSDEForm.getPSDEFormName());
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
            ArrayList<PSDEFIUDetail> arrayList = this.selectByPSDEForm(pSDEForm);
            for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEFIUDetail, (String)"PSDEFIUDETAILID", (String)""))) continue;
                this.remove(pSDEFIUDetail);
            }
        }
        return null;
    }

    protected boolean onFillEntityKeyValue(PSDEFIUDetail pSDEFIUDetail, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEFIUDetail.get("PSDEFIUPDATEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEFIUDetail.get("PSDEFORMDETAILID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEFIUDetail.set(this.getPSDEFIUDetailDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEFIUDetail pSDEFIUDetail, boolean bl) throws Exception {
        if (bl && pSDEFIUDetail.getPSDEFIUDetailName() == null) {
            pSDEFIUDetail.setPSDEFIUDetailName((String)this.getDefaultValue(this.getWebContext(), "", "\u540d\u79f0", 25));
        }
        super.onFillEntityFullInfo(pSDEFIUDetail, bl);
        this.onFillEntityFullInfo_PSDEFIUpdate(pSDEFIUDetail, bl);
        this.onFillEntityFullInfo_PSDEFormDetail(pSDEFIUDetail, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEFIUDetail, bl);
    }

    protected void onFillEntityFullInfo_PSDEFIUpdate(PSDEFIUDetail pSDEFIUDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFormDetail(PSDEFIUDetail pSDEFIUDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEFIUDetail pSDEFIUDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEFIUDetail pSDEFIUDetail, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEFIUDetail, bl);
    }

    public ArrayList<PSDEFIUDetail> selectByPSDEFIUpdate(PSDEFIUpdateBase pSDEFIUpdateBase) throws Exception {
        return this.selectByPSDEFIUpdate(pSDEFIUpdateBase, "", -1);
    }

    public ArrayList<PSDEFIUDetail> selectByPSDEFIUpdate(PSDEFIUpdateBase pSDEFIUpdateBase, String string) throws Exception {
        return this.selectByPSDEFIUpdate(pSDEFIUpdateBase, string, -1);
    }

    public ArrayList<PSDEFIUDetail> selectByPSDEFIUpdate(PSDEFIUpdateBase pSDEFIUpdateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFIUPDATEID", (Object)pSDEFIUpdateBase.getPSDEFIUpdateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFIUpdateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFIUDetail> selectTempByPSDEFIUpdate(PSDEFIUpdateBase pSDEFIUpdateBase) throws Exception {
        return this.selectTempByPSDEFIUpdate(pSDEFIUpdateBase, "");
    }

    public ArrayList<PSDEFIUDetail> selectTempByPSDEFIUpdate(PSDEFIUpdateBase pSDEFIUpdateBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFIUPDATEID", (Object)pSDEFIUpdateBase.getPSDEFIUpdateId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFIUpdateCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFIUpdateCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFIUDetail> selectByPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase) throws Exception {
        return this.selectByPSDEFormDetail(pSDEFormDetailBase, "", -1);
    }

    public ArrayList<PSDEFIUDetail> selectByPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string) throws Exception {
        return this.selectByPSDEFormDetail(pSDEFormDetailBase, string, -1);
    }

    public ArrayList<PSDEFIUDetail> selectByPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFIUDetail> selectTempByPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase) throws Exception {
        return this.selectTempByPSDEFormDetail(pSDEFormDetailBase, "");
    }

    public ArrayList<PSDEFIUDetail> selectTempByPSDEFormDetail(PSDEFormDetailBase pSDEFormDetailBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMDETAILID", (Object)pSDEFormDetailBase.getPSDEFormDetailId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFormDetailCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFormDetailCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEFIUDetail> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEFIUDetail> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEFIUDetail> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEFIUDetail> selectTempByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectTempByPSDEForm(pSDEFormBase, "");
    }

    public ArrayList<PSDEFIUDetail> selectTempByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEFormCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
    }

    public void resetPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectByPSDEFIUpdate(pSDEFIUpdate);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            PSDEFIUDetail pSDEFIUDetail2 = (PSDEFIUDetail)this.getDEModel().createEntity();
            pSDEFIUDetail2.setPSDEFIUDetailId(pSDEFIUDetail.getPSDEFIUDetailId());
            pSDEFIUDetail2.setPSDEFIUpdateId(null);
            this.update(pSDEFIUDetail2);
        }
    }

    public void resetTempPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectTempByPSDEFIUpdate(pSDEFIUpdate);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            PSDEFIUDetail pSDEFIUDetail2 = (PSDEFIUDetail)this.getDEModel().createEntity();
            pSDEFIUDetail2.setPSDEFIUDetailId(pSDEFIUDetail.getPSDEFIUDetailId());
            pSDEFIUDetail2.setPSDEFIUpdateId(null);
            this.updateTemp(pSDEFIUDetail2);
        }
    }

    public void removeByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        final PSDEFIUpdate pSDEFIUpdate2 = pSDEFIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIUDetailServiceBase.this.onBeforeRemoveByPSDEFIUpdate(pSDEFIUpdate2);
                PSDEFIUDetailServiceBase.this.internalRemoveByPSDEFIUpdate(pSDEFIUpdate2);
                PSDEFIUDetailServiceBase.this.onAfterRemoveByPSDEFIUpdate(pSDEFIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
    }

    protected void internalRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectByPSDEFIUpdate(pSDEFIUpdate);
        this.onBeforeRemoveByPSDEFIUpdate(pSDEFIUpdate, arrayList);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            this.remove(pSDEFIUDetail);
        }
        this.onAfterRemoveByPSDEFIUpdate(pSDEFIUpdate, arrayList);
    }

    protected void onAfterRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectByPSDEFormDetail(pSDEFormDetail, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORMDETAIL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFormDetail);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEFIUDETAIL_PSDEFORMDETAIL_PSDEFORMDETAILID", "", iDataEntityModel.getName(), "PSDEFIUDETAIL", iDataEntityModel.getDataInfo(pSDEFormDetail), arrayList.get(0)));
        }
    }

    public void resetPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectByPSDEFormDetail(pSDEFormDetail);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            PSDEFIUDetail pSDEFIUDetail2 = (PSDEFIUDetail)this.getDEModel().createEntity();
            pSDEFIUDetail2.setPSDEFIUDetailId(pSDEFIUDetail.getPSDEFIUDetailId());
            pSDEFIUDetail2.setPSDEFormDetailId(null);
            this.update(pSDEFIUDetail2);
        }
    }

    public void resetTempPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectTempByPSDEFormDetail(pSDEFormDetail);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            PSDEFIUDetail pSDEFIUDetail2 = (PSDEFIUDetail)this.getDEModel().createEntity();
            pSDEFIUDetail2.setPSDEFIUDetailId(pSDEFIUDetail.getPSDEFIUDetailId());
            pSDEFIUDetail2.setPSDEFormDetailId(null);
            this.updateTemp(pSDEFIUDetail2);
        }
    }

    public void removeByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIUDetailServiceBase.this.onBeforeRemoveByPSDEFormDetail(pSDEFormDetail2);
                PSDEFIUDetailServiceBase.this.internalRemoveByPSDEFormDetail(pSDEFormDetail2);
                PSDEFIUDetailServiceBase.this.onAfterRemoveByPSDEFormDetail(pSDEFormDetail2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void internalRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectByPSDEFormDetail(pSDEFormDetail);
        this.onBeforeRemoveByPSDEFormDetail(pSDEFormDetail, arrayList);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            this.remove(pSDEFIUDetail);
        }
        this.onAfterRemoveByPSDEFormDetail(pSDEFormDetail, arrayList);
    }

    protected void onAfterRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            PSDEFIUDetail pSDEFIUDetail2 = (PSDEFIUDetail)this.getDEModel().createEntity();
            pSDEFIUDetail2.setPSDEFIUDetailId(pSDEFIUDetail.getPSDEFIUDetailId());
            pSDEFIUDetail2.setPSDEFormId(null);
            this.update(pSDEFIUDetail2);
        }
    }

    public void resetTempPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectTempByPSDEForm(pSDEForm);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            PSDEFIUDetail pSDEFIUDetail2 = (PSDEFIUDetail)this.getDEModel().createEntity();
            pSDEFIUDetail2.setPSDEFIUDetailId(pSDEFIUDetail.getPSDEFIUDetailId());
            pSDEFIUDetail2.setPSDEFormId(null);
            this.updateTemp(pSDEFIUDetail2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIUDetailServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEFIUDetailServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEFIUDetailServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            this.remove(pSDEFIUDetail);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEFIUDetail pSDEFIUDetail) throws Exception {
        super.onBeforeRemove(pSDEFIUDetail);
    }

    public void removeTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIUDetailServiceBase.this.onBeforeRemoveTempByPSDEFormDetail(pSDEFormDetail2);
                PSDEFIUDetailServiceBase.this.internalRemoveTempByPSDEFormDetail(pSDEFormDetail2);
                PSDEFIUDetailServiceBase.this.onAfterRemoveTempByPSDEFormDetail(pSDEFormDetail2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void internalRemoveTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectTempByPSDEFormDetail(pSDEFormDetail);
        this.onBeforeRemoveTempByPSDEFormDetail(pSDEFormDetail, arrayList);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            this.removeTemp(pSDEFIUDetail);
        }
        this.onAfterRemoveTempByPSDEFormDetail(pSDEFormDetail, arrayList);
    }

    protected void onAfterRemoveTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEFormDetail(PSDEFormDetail pSDEFormDetail, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    public void removeTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        final PSDEFIUpdate pSDEFIUpdate2 = pSDEFIUpdate;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIUDetailServiceBase.this.onBeforeRemoveTempByPSDEFIUpdate(pSDEFIUpdate2);
                PSDEFIUDetailServiceBase.this.internalRemoveTempByPSDEFIUpdate(pSDEFIUpdate2);
                PSDEFIUDetailServiceBase.this.onAfterRemoveTempByPSDEFIUpdate(pSDEFIUpdate2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
    }

    protected void internalRemoveTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectTempByPSDEFIUpdate(pSDEFIUpdate);
        this.onBeforeRemoveTempByPSDEFIUpdate(pSDEFIUpdate, arrayList);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            this.removeTemp(pSDEFIUDetail);
        }
        this.onAfterRemoveTempByPSDEFIUpdate(pSDEFIUpdate, arrayList);
    }

    protected void onAfterRemoveTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEFIUpdate(PSDEFIUpdate pSDEFIUpdate, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    public void removeTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFIUDetailServiceBase.this.onBeforeRemoveTempByPSDEForm(pSDEForm2);
                PSDEFIUDetailServiceBase.this.internalRemoveTempByPSDEForm(pSDEForm2);
                PSDEFIUDetailServiceBase.this.onAfterRemoveTempByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEFIUDetail> arrayList = this.selectTempByPSDEForm(pSDEForm);
        this.onBeforeRemoveTempByPSDEForm(pSDEForm, arrayList);
        for (PSDEFIUDetail pSDEFIUDetail : arrayList) {
            this.removeTemp(pSDEFIUDetail);
        }
        this.onAfterRemoveTempByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveTempByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEFIUDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDEFIUDetail pSDEFIUDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEFIUDetail, cloneSession);
        if (pSDEFIUDetail.getPSDEFIUpdateId() != null && (iEntity = cloneSession.getEntity("PSDEFIUPDATE", (Object)pSDEFIUDetail.getPSDEFIUpdateId())) != null) {
            this.onFillParentInfo_PSDEFIUpdate(pSDEFIUDetail, (PSDEFIUpdate)iEntity);
        }
        if (pSDEFIUDetail.getPSDEFormDetailId() != null && (iEntity = cloneSession.getEntity("PSDEFORMDETAIL", (Object)pSDEFIUDetail.getPSDEFormDetailId())) != null) {
            this.onFillParentInfo_PSDEFormDetail(pSDEFIUDetail, (PSDEFormDetail)iEntity);
        }
        if (pSDEFIUDetail.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEFIUDetail.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEFIUDetail, (PSDEForm)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEFIUDetail pSDEFIUDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEFIUDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEFIUDetail pSDEFIUDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEFIUDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFIUDetailId(bl, pSDEFIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFIUDetailName(bl, pSDEFIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFIUpdateId(bl, pSDEFIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormDetailId(bl, pSDEFIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEFIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEFIUDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEFIUDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEFIUDetail pSDEFIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUDetail.isDynaModelFlagDirty() : !pSDEFIUDetail.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEFIUDetail.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEFIUDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFIUDetailId(boolean bl, PSDEFIUDetail pSDEFIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUDetail.isPSDEFIUDetailIdDirty() && !bl2 : !pSDEFIUDetail.isPSDEFIUDetailIdDirty()) {
            return null;
        }
        String string = pSDEFIUDetail.getPSDEFIUDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIUDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFIUDetailId_Default(pSDEFIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIUDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFIUDetailName(boolean bl, PSDEFIUDetail pSDEFIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUDetail.isPSDEFIUDetailNameDirty() : !pSDEFIUDetail.isPSDEFIUDetailNameDirty()) {
            return null;
        }
        String string = pSDEFIUDetail.getPSDEFIUDetailName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFIUDetailName_Default(pSDEFIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIUDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFIUpdateId(boolean bl, PSDEFIUDetail pSDEFIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUDetail.isPSDEFIUpdateIdDirty() && !bl2 : !pSDEFIUDetail.isPSDEFIUpdateIdDirty()) {
            return null;
        }
        String string = pSDEFIUDetail.getPSDEFIUpdateId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIUPDATEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFIUpdateId_Default(pSDEFIUDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFIUPDATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormDetailId(boolean bl, PSDEFIUDetail pSDEFIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUDetail.isPSDEFormDetailIdDirty() && !bl2 : !pSDEFIUDetail.isPSDEFormDetailIdDirty()) {
            return null;
        }
        String string = pSDEFIUDetail.getPSDEFormDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormDetailId_Default(pSDEFIUDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEFIUDetail pSDEFIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUDetail.isPSDEFormIdDirty() : !pSDEFIUDetail.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEFIUDetail.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default(pSDEFIUDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEFIUDetail pSDEFIUDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEFIUDetail.isPSDynaInstIdDirty() : !pSDEFIUDetail.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEFIUDetail.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEFIUDetail, bl2, bl3);
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

    protected void onSyncEntity(PSDEFIUDetail pSDEFIUDetail, boolean bl) throws Exception {
        super.onSyncEntity(pSDEFIUDetail, bl);
    }

    protected void onSyncIndexEntities(PSDEFIUDetail pSDEFIUDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEFIUDetail, bl);
    }

    public Object getDataContextValue(PSDEFIUDetail pSDEFIUDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEFIUDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEFIUpdate pSDEFIUpdate = pSDEFIUDetail.getPSDEFIUpdate();
        if (pSDEFIUpdate != null && pSDEFIUpdate.contains(string)) {
            return pSDEFIUpdate.get(string);
        }
        PSDEFormDetail pSDEFormDetail = pSDEFIUDetail.getPSDEFormDetail();
        if (pSDEFormDetail != null && pSDEFormDetail.contains(string)) {
            return pSDEFormDetail.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEFIUDetail pSDEFIUDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEFIUDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIUDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIUDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIUDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIUDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIUPDATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIUpdateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFIUPDATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFIUpdateName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEFIUDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIUDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFIUDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIUDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFIUpdateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIUPDATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFIUpdateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFIUPDATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEFIUDetail pSDEFIUDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEFIUDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEFIUDetail pSDEFIUDetail) throws Exception {
        super.onUpdateParent(pSDEFIUDetail);
    }

    @Override
    protected void exportCurXmlModel(PSDEFIUDetail pSDEFIUDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEFIUDETAIL");
        if (!bl) {
            pSDEFIUDetail.setPSDEFormDetailId(null);
            pSDEFIUDetail.setPSDEFIUpdateId(null);
            pSDEFIUDetail.setPSDEFIUpdateName(null);
            pSDEFIUDetail.setPSDEFormId(null);
            pSDEFIUDetail.setPSDEFormName(null);
            super.exportCurXmlModel(pSDEFIUDetail, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEFIUDetail pSDEFIUDetail, PSSystem pSSystem) throws Exception {
        PSDEFIUDetail pSDEFIUDetail2 = new PSDEFIUDetail();
        pSDEFIUDetail2.setPSDEFIUpdateId(pSDEFIUDetail.getPSDEFIUpdateId());
        pSDEFIUDetail2.setPSDEFormDetailId(pSDEFIUDetail.getPSDEFormDetailId());
        if (this.selectOne(pSDEFIUDetail2, true)) {
            return pSDEFIUDetail2.getPSDEFIUDetailId();
        }
        return super.getEntityFolderKeyValue(pSDEFIUDetail, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEFIUDetail pSDEFIUDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEFIUDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFIUPDATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEFIUPDATE#%1$s", (Object)string);
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFIUPDATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFIUDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEFIUDETAIL_PSDEFORM_PSDEFORMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFIUPDATEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFIUPDATENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEFORMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFIUPDATE", (boolean)true) == 0) {
            iEntity.set("PSDEFIUPDATEID", (Object)string2);
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
        return new String[]{"PSDEFIUPDATEID", "PSDEFORMID"};
    }

    @Override
    public String getModelV2Tag(PSDEFIUDetail pSDEFIUDetail) {
        return super.getModelV2Tag(pSDEFIUDetail);
    }

    @Override
    public boolean setModelV2Tag(PSDEFIUDetail pSDEFIUDetail, String string) {
        return super.setModelV2Tag(pSDEFIUDetail, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEFIUPDATEID", "");
        map.put("PSDEFORMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEFIUDetail pSDEFIUDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEFIUDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEFIUDetail, true);
        return super.getModelV2Entity(pSDEFIUDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEFIUDetail pSDEFIUDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSDEFIUDetail.getPSDEFIUpdateId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFIUDetail.getPSDEFormId())) {
            bl = true;
        } else if (bl && !objectNode.has("psdeformid")) {
            objectNode.put("psdeformid", "<PSDEFORM>");
        }
        return super.testCompileCurModelV2(pSDEFIUDetail, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSDEFIUDetail pSDEFIUDetail, String string, Map<String, String> map) throws Exception {
        if (PSDEFIUDetailServiceBase.isSimpleImportExportMode()) {
            map.put("PSDEFIUPDATEID", "");
            map.put("PSDEFORMID", "");
        }
        return super.onFillModelV2(objectNode, pSDEFIUDetail, string, map);
    }
}

