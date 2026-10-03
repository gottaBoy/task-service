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
import net.ibizsys.pscore.srv.sysdesign.dao.PSCtrlMsgItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSCtrlMsgItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlMsgItemServiceBase
extends PSCoreSysServiceBase<PSCtrlMsgItem> {
    private static final Log log = LogFactory.getLog(PSCtrlMsgItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSCtrlMsgItemDEModel pSCtrlMsgItemDEModel;
    private PSCtrlMsgItemDAO pSCtrlMsgItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgItemService";
    }

    public PSCtrlMsgItemDEModel getPSCtrlMsgItemDEModel() {
        if (this.pSCtrlMsgItemDEModel == null) {
            try {
                this.pSCtrlMsgItemDEModel = (PSCtrlMsgItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSCtrlMsgItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlMsgItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSCtrlMsgItemDEModel();
    }

    public PSCtrlMsgItemDAO getPSCtrlMsgItemDAO() {
        if (this.pSCtrlMsgItemDAO == null) {
            try {
                this.pSCtrlMsgItemDAO = (PSCtrlMsgItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSCtrlMsgItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCtrlMsgItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSCtrlMsgItemDAO();
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

    protected void onFillParentInfo(PSCtrlMsgItem pSCtrlMsgItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlMsg);
            } else {
                iService.get(pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSCtrlMsgItem, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSCTRLMSGITEM_PSLANGUAGERES_CONTENTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_ContentPSLanRes(pSCtrlMsgItem, pSLanguageRes);
            return;
        }
        super.onFillParentInfo(pSCtrlMsgItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlMsg(PSCtrlMsgItem pSCtrlMsgItem, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSCtrlMsgItem.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSCtrlMsgItem.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_ContentPSLanRes(PSCtrlMsgItem pSCtrlMsgItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSCtrlMsgItem.setContentPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSCtrlMsgItem.setContentPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillEntityFullInfo(PSCtrlMsgItem pSCtrlMsgItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSCtrlMsgItem, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSCtrlMsgItem, bl);
        this.onFillEntityFullInfo_ContentPSLanRes(pSCtrlMsgItem, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSCtrlMsgItem pSCtrlMsgItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ContentPSLanRes(PSCtrlMsgItem pSCtrlMsgItem, boolean bl) throws Exception {
        if (pSCtrlMsgItem.isContentPSLanResIdDirty()) {
            if (pSCtrlMsgItem.getContentPSLanResId() != null) {
                if (pSCtrlMsgItem.getContentPSLanResId() == null || pSCtrlMsgItem.getContentPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSCtrlMsgItem.getContentPSLanRes();
                    pSCtrlMsgItem.setContentPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSCtrlMsgItem.setContentPSLanResName(null);
            }
        }
    }

    protected void onWriteBackParent(PSCtrlMsgItem pSCtrlMsgItem, boolean bl) throws Exception {
        super.onWriteBackParent(pSCtrlMsgItem, bl);
    }

    public ArrayList<PSCtrlMsgItem> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSCtrlMsgItem> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSCtrlMsgItem> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLMSGID", (Object)pSCtrlMsgBase.getPSCtrlMsgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlMsgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlMsgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCtrlMsgItem> selectTempByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectTempByPSCtrlMsg(pSCtrlMsgBase, "");
    }

    public ArrayList<PSCtrlMsgItem> selectTempByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLMSGID", (Object)pSCtrlMsgBase.getPSCtrlMsgId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSCtrlMsgCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSCtrlMsgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSCtrlMsgItem> selectByContentPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByContentPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSCtrlMsgItem> selectByContentPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByContentPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSCtrlMsgItem> selectByContentPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CONTENTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByContentPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByContentPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSCtrlMsgItem> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
            PSCtrlMsgItem pSCtrlMsgItem2 = (PSCtrlMsgItem)this.getDEModel().createEntity();
            pSCtrlMsgItem2.setPSCtrlMsgItemId(pSCtrlMsgItem.getPSCtrlMsgItemId());
            pSCtrlMsgItem2.setPSCtrlMsgId(null);
            this.update(pSCtrlMsgItem2);
        }
    }

    public void resetTempPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSCtrlMsgItem> arrayList = this.selectTempByPSCtrlMsg(pSCtrlMsg);
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
            PSCtrlMsgItem pSCtrlMsgItem2 = (PSCtrlMsgItem)this.getDEModel().createEntity();
            pSCtrlMsgItem2.setPSCtrlMsgItemId(pSCtrlMsgItem.getPSCtrlMsgItemId());
            pSCtrlMsgItem2.setPSCtrlMsgId(null);
            this.updateTemp(pSCtrlMsgItem2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlMsgItemServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSCtrlMsgItemServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSCtrlMsgItemServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSCtrlMsgItem> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
            this.remove(pSCtrlMsgItem);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSCtrlMsgItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSCtrlMsgItem> arrayList) throws Exception {
    }

    public void testRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCtrlMsgItem> arrayList = this.selectByContentPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSCTRLMSGITEM_PSLANGUAGERES_CONTENTPSLANRESID", "", iDataEntityModel.getName(), "PSCTRLMSGITEM", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCtrlMsgItem> arrayList = this.selectByContentPSLanRes(pSLanguageRes);
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
            PSCtrlMsgItem pSCtrlMsgItem2 = (PSCtrlMsgItem)this.getDEModel().createEntity();
            pSCtrlMsgItem2.setPSCtrlMsgItemId(pSCtrlMsgItem.getPSCtrlMsgItemId());
            pSCtrlMsgItem2.setContentPSLanResId(null);
            this.update(pSCtrlMsgItem2);
        }
    }

    public void removeByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlMsgItemServiceBase.this.onBeforeRemoveByContentPSLanRes(pSLanguageRes2);
                PSCtrlMsgItemServiceBase.this.internalRemoveByContentPSLanRes(pSLanguageRes2);
                PSCtrlMsgItemServiceBase.this.onAfterRemoveByContentPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSCtrlMsgItem> arrayList = this.selectByContentPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByContentPSLanRes(pSLanguageRes, arrayList);
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
            this.remove(pSCtrlMsgItem);
        }
        this.onAfterRemoveByContentPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSCtrlMsgItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByContentPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSCtrlMsgItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSCtrlMsgItem pSCtrlMsgItem) throws Exception {
        super.onBeforeRemove(pSCtrlMsgItem);
    }

    public void removeTempByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCtrlMsgItemServiceBase.this.onBeforeRemoveTempByPSCtrlMsg(pSCtrlMsg2);
                PSCtrlMsgItemServiceBase.this.internalRemoveTempByPSCtrlMsg(pSCtrlMsg2);
                PSCtrlMsgItemServiceBase.this.onAfterRemoveTempByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveTempByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSCtrlMsgItem> arrayList = this.selectTempByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveTempByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSCtrlMsgItem pSCtrlMsgItem : arrayList) {
            this.removeTemp(pSCtrlMsgItem);
        }
        this.onAfterRemoveTempByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveTempByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveTempByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSCtrlMsgItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSCtrlMsgItem> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSCtrlMsgItem pSCtrlMsgItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSCtrlMsgItem, cloneSession);
        if (pSCtrlMsgItem.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSCtrlMsgItem.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSCtrlMsgItem, (PSCtrlMsg)iEntity);
        }
        if (pSCtrlMsgItem.getContentPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSCtrlMsgItem.getContentPSLanResId())) != null) {
            this.onFillParentInfo_ContentPSLanRes(pSCtrlMsgItem, (PSLanguageRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSCtrlMsgItem pSCtrlMsgItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSCtrlMsgItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Content(bl, pSCtrlMsgItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSLanResId(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentPSLanResName(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgItemId(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgItemName(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timeout(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSCtrlMsgItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSCtrlMsgItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isContentDirty() : !pSCtrlMsgItem.isContentDirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSCtrlMsgItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSLanResId(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isContentPSLanResIdDirty() : !pSCtrlMsgItem.isContentPSLanResIdDirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getContentPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSLanResId_Default(pSCtrlMsgItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentPSLanResName(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isContentPSLanResNameDirty() : !pSCtrlMsgItem.isContentPSLanResNameDirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getContentPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentPSLanResName_Default(pSCtrlMsgItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isMemoDirty() : !pSCtrlMsgItem.isMemoDirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSCtrlMsgItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isPSCtrlMsgIdDirty() : !pSCtrlMsgItem.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default(pSCtrlMsgItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlMsgItemId(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isPSCtrlMsgItemIdDirty() && !bl2 : !pSCtrlMsgItem.isPSCtrlMsgItemIdDirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getPSCtrlMsgItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgItemId_Default(pSCtrlMsgItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlMsgItemName(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isPSCtrlMsgItemNameDirty() && !bl2 : !pSCtrlMsgItem.isPSCtrlMsgItemNameDirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getPSCtrlMsgItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgItemName_Default(pSCtrlMsgItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSCTRLMSGID";
                String string4 = this.checkFieldDupRule(this.getPSCtrlMsgItemDEModel(), "PSCTRLMSGITEMNAME", string3, pSCtrlMsgItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSCTRLMSGITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Timeout(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isTimeoutDirty() : !pSCtrlMsgItem.isTimeoutDirty()) {
            return null;
        }
        Integer n = pSCtrlMsgItem.getTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timeout_Default(pSCtrlMsgItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isUserCatDirty() : !pSCtrlMsgItem.isUserCatDirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSCtrlMsgItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isUserTagDirty() : !pSCtrlMsgItem.isUserTagDirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSCtrlMsgItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isUserTag2Dirty() : !pSCtrlMsgItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSCtrlMsgItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isUserTag3Dirty() : !pSCtrlMsgItem.isUserTag3Dirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSCtrlMsgItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSCtrlMsgItem pSCtrlMsgItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSCtrlMsgItem.isUserTag4Dirty() : !pSCtrlMsgItem.isUserTag4Dirty()) {
            return null;
        }
        String string = pSCtrlMsgItem.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSCtrlMsgItem, bl2, bl3);
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

    protected void onSyncEntity(PSCtrlMsgItem pSCtrlMsgItem, boolean bl) throws Exception {
        super.onSyncEntity(pSCtrlMsgItem, bl);
    }

    protected void onSyncIndexEntities(PSCtrlMsgItem pSCtrlMsgItem, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSCtrlMsgItem, bl);
    }

    public Object getDataContextValue(PSCtrlMsgItem pSCtrlMsgItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSCtrlMsgItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSCtrlMsg pSCtrlMsg = pSCtrlMsgItem.getPSCtrlMsg();
        if (pSCtrlMsg != null && pSCtrlMsg.contains(string)) {
            return pSCtrlMsg.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSCtrlMsgItem pSCtrlMsgItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSCtrlMsgItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentPSLanResName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Timeout_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Timeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSCtrlMsgItem pSCtrlMsgItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSCtrlMsgItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSCtrlMsgItem pSCtrlMsgItem) throws Exception {
        super.onUpdateParent(pSCtrlMsgItem);
    }

    @Override
    protected void exportCurXmlModel(PSCtrlMsgItem pSCtrlMsgItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSCTRLMSGITEM");
        if (!bl) {
            pSCtrlMsgItem.setCreateDate(null);
            pSCtrlMsgItem.setCreateMan(null);
            pSCtrlMsgItem.setPSCtrlMsgItemId(null);
            pSCtrlMsgItem.setUpdateDate(null);
            pSCtrlMsgItem.setUpdateMan(null);
            pSCtrlMsgItem.setPSCtrlMsgId(null);
            pSCtrlMsgItem.setPSCtrlMsgName(null);
            super.exportCurXmlModel(pSCtrlMsgItem, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSCtrlMsgItem pSCtrlMsgItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSCtrlMsgItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSCTRLMSGID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSCTRLMSG#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSCTRLMSGID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSCTRLMSGITEM_PSCTRLMSG_PSCTRLMSGID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSCTRLMSGID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSCTRLMSGNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSCTRLMSG", (boolean)true) == 0) {
            iEntity.set("PSCTRLMSGID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSCTRLMSGID"};
    }

    @Override
    public String getModelV2Tag(PSCtrlMsgItem pSCtrlMsgItem) {
        if (!StringHelper.isNullOrEmpty((String)pSCtrlMsgItem.getPSCtrlMsgItemName())) {
            return pSCtrlMsgItem.getPSCtrlMsgItemName();
        }
        return super.getModelV2Tag(pSCtrlMsgItem);
    }

    @Override
    public boolean setModelV2Tag(PSCtrlMsgItem pSCtrlMsgItem, String string) {
        pSCtrlMsgItem.setPSCtrlMsgItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSCTRLMSGITEMNAME", "");
        map.put("PSCTRLMSGID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSCtrlMsgItem pSCtrlMsgItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSCtrlMsgItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSCtrlMsgItem, true);
        pSCtrlMsgItem.set("PSCTRLMSGITEMNAME", string);
        if (this.select(pSCtrlMsgItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSCtrlMsgItem, true);
        return super.getModelV2Entity(pSCtrlMsgItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSCtrlMsgItem pSCtrlMsgItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSCtrlMsgItem, objectNode, string, string2, n);
    }
}

