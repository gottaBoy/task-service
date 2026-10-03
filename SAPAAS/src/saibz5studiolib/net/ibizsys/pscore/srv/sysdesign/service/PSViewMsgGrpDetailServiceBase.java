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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSViewMsgGrpDetailDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSViewMsgGrpDetailDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGrpDetail;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewMsgGrpDetailServiceBase
extends PSCoreSysServiceBase<PSViewMsgGrpDetail> {
    private static final Log log = LogFactory.getLog(PSViewMsgGrpDetailServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSViewMsgGrpDetailDEModel pSViewMsgGrpDetailDEModel;
    private PSViewMsgGrpDetailDAO pSViewMsgGrpDetailDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGrpDetailService";
    }

    public PSViewMsgGrpDetailDEModel getPSViewMsgGrpDetailDEModel() {
        if (this.pSViewMsgGrpDetailDEModel == null) {
            try {
                this.pSViewMsgGrpDetailDEModel = (PSViewMsgGrpDetailDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSViewMsgGrpDetailDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewMsgGrpDetailDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSViewMsgGrpDetailDEModel();
    }

    public PSViewMsgGrpDetailDAO getPSViewMsgGrpDetailDAO() {
        if (this.pSViewMsgGrpDetailDAO == null) {
            try {
                this.pSViewMsgGrpDetailDAO = (PSViewMsgGrpDetailDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSViewMsgGrpDetailDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewMsgGrpDetailDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSViewMsgGrpDetailDAO();
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

    protected void onFillParentInfo(PSViewMsgGrpDetail pSViewMsgGrpDetail, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSViewMsgGrpDetail, pSViewMsgGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSG_PSVIEWMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService", (SessionFactory)this.getSessionFactory());
            PSViewMsg pSViewMsg = (PSViewMsg)iService.getDEModel().createEntity();
            pSViewMsg.set("PSVIEWMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsg);
            } else {
                iService.get(pSViewMsg);
            }
            this.onFillParentInfo_PSViewMsg(pSViewMsgGrpDetail, pSViewMsg);
            return;
        }
        super.onFillParentInfo(pSViewMsgGrpDetail, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", string2);
            return this.onSyncDER1NData_PSViewMsgGroup(pSViewMsgGroup, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSViewMsgGrpDetail pSViewMsgGrpDetail, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSViewMsgGrpDetail.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSViewMsgGrpDetail.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected String onSyncDER1NData_PSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSViewMsgGroup(pSViewMsgGroup);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSViewMsgGrpDetail> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
            for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSViewMsgGrpDetail, (String)"PSVIEWMSGGRPDETAILID", (String)""))) continue;
                this.remove(pSViewMsgGrpDetail);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSViewMsg(PSViewMsgGrpDetail pSViewMsgGrpDetail, PSViewMsg pSViewMsg) throws Exception {
        pSViewMsgGrpDetail.setDynamicMode(pSViewMsg.getDynamicMode());
        pSViewMsgGrpDetail.setPSViewMsgId(pSViewMsg.getPSViewMsgId());
        pSViewMsgGrpDetail.setPSViewMsgName(pSViewMsg.getPSViewMsgName());
    }

    protected void onFillEntityFullInfo(PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl) throws Exception {
        if (bl) {
            if (pSViewMsgGrpDetail.getOrderValue() == null) {
                pSViewMsgGrpDetail.setOrderValue((Integer)this.getDefaultValue(this.getWebContext(), "", "100", 9));
            }
            if (pSViewMsgGrpDetail.getValidFlag() == null) {
                pSViewMsgGrpDetail.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSViewMsgGrpDetail, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSViewMsgGrpDetail, bl);
        this.onFillEntityFullInfo_PSViewMsg(pSViewMsgGrpDetail, bl);
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsg(PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl) throws Exception {
        super.onWriteBackParent(pSViewMsgGrpDetail, bl);
    }

    public ArrayList<PSViewMsgGrpDetail> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSViewMsgGrpDetail> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSViewMsgGrpDetail> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWMSGGROUPID", (Object)pSViewMsgGroupBase.getPSViewMsgGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewMsgGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewMsgGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsgGrpDetail> selectTempByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectTempByPSViewMsgGroup(pSViewMsgGroupBase, "");
    }

    public ArrayList<PSViewMsgGrpDetail> selectTempByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWMSGGROUPID", (Object)pSViewMsgGroupBase.getPSViewMsgGroupId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSViewMsgGroupCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSViewMsgGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSViewMsgGrpDetail> selectByPSViewMsg(PSViewMsgBase pSViewMsgBase) throws Exception {
        return this.selectByPSViewMsg(pSViewMsgBase, "", -1);
    }

    public ArrayList<PSViewMsgGrpDetail> selectByPSViewMsg(PSViewMsgBase pSViewMsgBase, String string) throws Exception {
        return this.selectByPSViewMsg(pSViewMsgBase, string, -1);
    }

    public ArrayList<PSViewMsgGrpDetail> selectByPSViewMsg(PSViewMsgBase pSViewMsgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWMSGID", (Object)pSViewMsgBase.getPSViewMsgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewMsgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewMsgCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSViewMsgGrpDetail> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
            PSViewMsgGrpDetail pSViewMsgGrpDetail2 = (PSViewMsgGrpDetail)this.getDEModel().createEntity();
            pSViewMsgGrpDetail2.setPSViewMsgGrpDetailId(pSViewMsgGrpDetail.getPSViewMsgGrpDetailId());
            pSViewMsgGrpDetail2.setPSViewMsgGroupId(null);
            this.update(pSViewMsgGrpDetail2);
        }
    }

    public void resetTempPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSViewMsgGrpDetail> arrayList = this.selectTempByPSViewMsgGroup(pSViewMsgGroup);
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
            PSViewMsgGrpDetail pSViewMsgGrpDetail2 = (PSViewMsgGrpDetail)this.getDEModel().createEntity();
            pSViewMsgGrpDetail2.setPSViewMsgGrpDetailId(pSViewMsgGrpDetail.getPSViewMsgGrpDetailId());
            pSViewMsgGrpDetail2.setPSViewMsgGroupId(null);
            this.updateTemp(pSViewMsgGrpDetail2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgGrpDetailServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSViewMsgGrpDetailServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSViewMsgGrpDetailServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSViewMsgGrpDetail> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
            this.remove(pSViewMsgGrpDetail);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSViewMsgGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSViewMsgGrpDetail> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
        ArrayList<PSViewMsgGrpDetail> arrayList = this.selectByPSViewMsg(pSViewMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSG_PSVIEWMSGID", "", iDataEntityModel.getName(), "PSVIEWMSGGRPDETAIL", iDataEntityModel.getDataInfo(pSViewMsg), arrayList.get(0)));
        }
    }

    public void resetPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
        ArrayList<PSViewMsgGrpDetail> arrayList = this.selectByPSViewMsg(pSViewMsg);
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
            PSViewMsgGrpDetail pSViewMsgGrpDetail2 = (PSViewMsgGrpDetail)this.getDEModel().createEntity();
            pSViewMsgGrpDetail2.setPSViewMsgGrpDetailId(pSViewMsgGrpDetail.getPSViewMsgGrpDetailId());
            pSViewMsgGrpDetail2.setPSViewMsgId(null);
            this.update(pSViewMsgGrpDetail2);
        }
    }

    public void removeByPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
        final PSViewMsg pSViewMsg2 = pSViewMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgGrpDetailServiceBase.this.onBeforeRemoveByPSViewMsg(pSViewMsg2);
                PSViewMsgGrpDetailServiceBase.this.internalRemoveByPSViewMsg(pSViewMsg2);
                PSViewMsgGrpDetailServiceBase.this.onAfterRemoveByPSViewMsg(pSViewMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
    }

    protected void internalRemoveByPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
        ArrayList<PSViewMsgGrpDetail> arrayList = this.selectByPSViewMsg(pSViewMsg);
        this.onBeforeRemoveByPSViewMsg(pSViewMsg, arrayList);
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
            this.remove(pSViewMsgGrpDetail);
        }
        this.onAfterRemoveByPSViewMsg(pSViewMsg, arrayList);
    }

    protected void onAfterRemoveByPSViewMsg(PSViewMsg pSViewMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsg(PSViewMsg pSViewMsg, ArrayList<PSViewMsgGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsg(PSViewMsg pSViewMsg, ArrayList<PSViewMsgGrpDetail> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSViewMsgGrpDetail pSViewMsgGrpDetail) throws Exception {
        super.onBeforeRemove(pSViewMsgGrpDetail);
    }

    public void removeTempByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSViewMsgGrpDetailServiceBase.this.onBeforeRemoveTempByPSViewMsgGroup(pSViewMsgGroup2);
                PSViewMsgGrpDetailServiceBase.this.internalRemoveTempByPSViewMsgGroup(pSViewMsgGroup2);
                PSViewMsgGrpDetailServiceBase.this.onAfterRemoveTempByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveTempByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSViewMsgGrpDetail> arrayList = this.selectTempByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveTempByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSViewMsgGrpDetail pSViewMsgGrpDetail : arrayList) {
            this.removeTemp(pSViewMsgGrpDetail);
        }
        this.onAfterRemoveTempByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveTempByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveTempByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSViewMsgGrpDetail> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSViewMsgGrpDetail> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSViewMsgGrpDetail pSViewMsgGrpDetail, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSViewMsgGrpDetail, cloneSession);
        if (pSViewMsgGrpDetail.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSViewMsgGrpDetail.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSViewMsgGrpDetail, (PSViewMsgGroup)iEntity);
        }
        if (pSViewMsgGrpDetail.getPSViewMsgId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSG", (Object)pSViewMsgGrpDetail.getPSViewMsgId())) != null) {
            this.onFillParentInfo_PSViewMsg(pSViewMsgGrpDetail, (PSViewMsg)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSViewMsgGrpDetail, bl);
    }

    protected void onCheckEntity(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_EnableMode(bl, pSViewMsgGrpDetail, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MsgPos(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGrpDetailId(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGrpDetailName(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgId(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TestCustomCode(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSViewMsgGrpDetail, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSViewMsgGrpDetail, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_EnableMode(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isEnableModeDirty() : !pSViewMsgGrpDetail.isEnableModeDirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getEnableMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnableMode_Default(pSViewMsgGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isMemoDirty() : !pSViewMsgGrpDetail.isMemoDirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSViewMsgGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_MsgPos(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isMsgPosDirty() : !pSViewMsgGrpDetail.isMsgPosDirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getMsgPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MsgPos_Default(pSViewMsgGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSGPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isOrderValueDirty() : !pSViewMsgGrpDetail.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSViewMsgGrpDetail.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSViewMsgGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isPSViewMsgGroupIdDirty() && !bl2 : !pSViewMsgGrpDetail.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getPSViewMsgGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(pSViewMsgGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGrpDetailId(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isPSViewMsgGrpDetailIdDirty() && !bl2 : !pSViewMsgGrpDetail.isPSViewMsgGrpDetailIdDirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getPSViewMsgGrpDetailId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGRPDETAILID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGrpDetailId_Default(pSViewMsgGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGRPDETAILID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGrpDetailName(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isPSViewMsgGrpDetailNameDirty() && !bl2 : !pSViewMsgGrpDetail.isPSViewMsgGrpDetailNameDirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getPSViewMsgGrpDetailName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGRPDETAILNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGrpDetailName_Default(pSViewMsgGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGRPDETAILNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgId(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isPSViewMsgIdDirty() && !bl2 : !pSViewMsgGrpDetail.isPSViewMsgIdDirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getPSViewMsgId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgId_Default(pSViewMsgGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSVIEWMSGGROUPID";
                String string4 = this.checkFieldDupRule(this.getPSViewMsgGrpDetailDEModel(), "PSVIEWMSGID", string3, pSViewMsgGrpDetail, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSVIEWMSGID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TestCustomCode(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isTestCustomCodeDirty() : !pSViewMsgGrpDetail.isTestCustomCodeDirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getTestCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TestCustomCode_Default(pSViewMsgGrpDetail, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TESTCUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isUserCatDirty() : !pSViewMsgGrpDetail.isUserCatDirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSViewMsgGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isUserTagDirty() : !pSViewMsgGrpDetail.isUserTagDirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSViewMsgGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isUserTag2Dirty() : !pSViewMsgGrpDetail.isUserTag2Dirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSViewMsgGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isUserTag3Dirty() : !pSViewMsgGrpDetail.isUserTag3Dirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSViewMsgGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isUserTag4Dirty() : !pSViewMsgGrpDetail.isUserTag4Dirty()) {
            return null;
        }
        String string = pSViewMsgGrpDetail.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSViewMsgGrpDetail, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSViewMsgGrpDetail.isValidFlagDirty() : !pSViewMsgGrpDetail.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSViewMsgGrpDetail.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSViewMsgGrpDetail, bl2, bl3);
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

    protected void onSyncEntity(PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl) throws Exception {
        super.onSyncEntity(pSViewMsgGrpDetail, bl);
    }

    protected void onSyncIndexEntities(PSViewMsgGrpDetail pSViewMsgGrpDetail, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSViewMsgGrpDetail, bl);
    }

    public Object getDataContextValue(PSViewMsgGrpDetail pSViewMsgGrpDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSViewMsgGrpDetail, string, iDataContextParam)) != null) {
            return object;
        }
        PSViewMsgGroup pSViewMsgGroup = pSViewMsgGrpDetail.getPSViewMsgGroup();
        if (pSViewMsgGroup != null && pSViewMsgGroup.contains(string)) {
            return pSViewMsgGroup.get(string);
        }
        PSViewMsg pSViewMsg = pSViewMsgGrpDetail.getPSViewMsg();
        if (pSViewMsg != null && pSViewMsg.contains(string)) {
            return pSViewMsg.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSViewMsgGrpDetail pSViewMsgGrpDetail, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSViewMsgGrpDetail, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMICMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynamicMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSGPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MsgPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGRPDETAILID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGrpDetailId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGRPDETAILNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGrpDetailName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TESTCUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TestCustomCode_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_DynamicMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENABLEMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_MsgPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSGPOS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
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

    protected String onTestValueRule_PSViewMsgGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGrpDetailId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGRPDETAILID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGrpDetailName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGRPDETAILNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TestCustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TESTCUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSViewMsgGrpDetail pSViewMsgGrpDetail) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSViewMsgGrpDetail)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSViewMsgGrpDetail pSViewMsgGrpDetail) throws Exception {
        super.onUpdateParent(pSViewMsgGrpDetail);
    }

    @Override
    protected void exportCurXmlModel(PSViewMsgGrpDetail pSViewMsgGrpDetail, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVIEWMSGGRPDETAIL");
        if (!bl) {
            pSViewMsgGrpDetail.setCreateDate(null);
            pSViewMsgGrpDetail.setCreateMan(null);
            pSViewMsgGrpDetail.setPSViewMsgGrpDetailId(null);
            pSViewMsgGrpDetail.setUpdateDate(null);
            pSViewMsgGrpDetail.setUpdateMan(null);
            pSViewMsgGrpDetail.setPSViewMsgGroupId(null);
            pSViewMsgGrpDetail.setPSViewMsgGroupName(null);
            super.exportCurXmlModel(pSViewMsgGrpDetail, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSViewMsgGrpDetail pSViewMsgGrpDetail, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSViewMsgGrpDetail, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSVIEWMSGGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSVIEWMSGGROUP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSVIEWMSGGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSVIEWMSGGRPDETAIL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSVIEWMSGGROUPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSVIEWMSGGROUPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUP", (boolean)true) == 0) {
            iEntity.set("PSVIEWMSGGROUPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSVIEWMSGGROUPID"};
    }

    @Override
    public String getModelV2Tag(PSViewMsgGrpDetail pSViewMsgGrpDetail) {
        return super.getModelV2Tag(pSViewMsgGrpDetail);
    }

    @Override
    public boolean setModelV2Tag(PSViewMsgGrpDetail pSViewMsgGrpDetail, String string) {
        return super.setModelV2Tag(pSViewMsgGrpDetail, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSVIEWMSGGROUPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSViewMsgGrpDetail pSViewMsgGrpDetail, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSViewMsgGrpDetail.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSViewMsgGrpDetail, true);
        return super.getModelV2Entity(pSViewMsgGrpDetail, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSViewMsgGrpDetail pSViewMsgGrpDetail, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSViewMsgGrpDetail, objectNode, string, string2, n);
    }
}

