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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdeploy.service;

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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnASItemDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnASItemDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnAS;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASGroup;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASGroupBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnASItemServiceBase
extends PSCoreSysServiceBase<PSDepSlnASItem> {
    private static final Log log = LogFactory.getLog(PSDepSlnASItemServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnASItemDEModel pSDepSlnASItemDEModel;
    private PSDepSlnASItemDAO pSDepSlnASItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASItemService";
    }

    public PSDepSlnASItemDEModel getPSDepSlnASItemDEModel() {
        if (this.pSDepSlnASItemDEModel == null) {
            try {
                this.pSDepSlnASItemDEModel = (PSDepSlnASItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnASItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnASItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnASItemDEModel();
    }

    public PSDepSlnASItemDAO getPSDepSlnASItemDAO() {
        if (this.pSDepSlnASItemDAO == null) {
            try {
                this.pSDepSlnASItemDAO = (PSDepSlnASItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnASItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnASItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnASItemDAO();
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

    protected void onFillParentInfo(PSDepSlnASItem pSDepSlnASItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNASITEM_PSDEPSLNASGRP_PSDEPSLNASGRPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupService", (SessionFactory)this.getSessionFactory());
            PSDepSlnASGroup pSDepSlnASGroup = (PSDepSlnASGroup)iService.getDEModel().createEntity();
            pSDepSlnASGroup.set("PSDEPSLNASGRPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnASGroup);
            } else {
                iService.get((IEntity)pSDepSlnASGroup);
            }
            this.onFillParentInfo_PSDepSlnASGroup(pSDepSlnASItem, pSDepSlnASGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNASITEM_PSDEPSLNAS_PSDEPSLNASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASService", (SessionFactory)this.getSessionFactory());
            PSDepSlnAS pSDepSlnAS = (PSDepSlnAS)iService.getDEModel().createEntity();
            pSDepSlnAS.set("PSDEPSLNASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnAS);
            } else {
                iService.get((IEntity)pSDepSlnAS);
            }
            this.onFillParentInfo_PSDepSlnAS(pSDepSlnASItem, pSDepSlnAS);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnASItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnASGroup(PSDepSlnASItem pSDepSlnASItem, PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        pSDepSlnASItem.setPSDepSlnASGroupId(pSDepSlnASGroup.getPSDepSlnASGroupId());
        pSDepSlnASItem.setPSDepSlnASGroupName(pSDepSlnASGroup.getPSDepSlnASGroupName());
    }

    protected void onFillParentInfo_PSDepSlnAS(PSDepSlnASItem pSDepSlnASItem, PSDepSlnAS pSDepSlnAS) throws Exception {
        pSDepSlnASItem.setPSDepSlnASId(pSDepSlnAS.getPSDepSlnASId());
        pSDepSlnASItem.setPSDepSlnASName(pSDepSlnAS.getPSDepSlnASName());
    }

    protected boolean onFillEntityKeyValue(PSDepSlnASItem pSDepSlnASItem, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDepSlnASItem.get("PSDEPSLNASGRPID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDepSlnASItem.get("PSDEPSLNASID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDepSlnASItem.set(this.getPSDepSlnASItemDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDepSlnASItem pSDepSlnASItem, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnASItem, bl);
        this.onFillEntityFullInfo_PSDepSlnASGroup(pSDepSlnASItem, bl);
        this.onFillEntityFullInfo_PSDepSlnAS(pSDepSlnASItem, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnASGroup(PSDepSlnASItem pSDepSlnASItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnAS(PSDepSlnASItem pSDepSlnASItem, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnASItem pSDepSlnASItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnASItem, bl);
    }

    public ArrayList<PSDepSlnASItem> selectByPSDepSlnASGroup(PSDepSlnASGroupBase pSDepSlnASGroupBase) throws Exception {
        return this.selectByPSDepSlnASGroup(pSDepSlnASGroupBase, "", -1);
    }

    public ArrayList<PSDepSlnASItem> selectByPSDepSlnASGroup(PSDepSlnASGroupBase pSDepSlnASGroupBase, String string) throws Exception {
        return this.selectByPSDepSlnASGroup(pSDepSlnASGroupBase, string, -1);
    }

    public ArrayList<PSDepSlnASItem> selectByPSDepSlnASGroup(PSDepSlnASGroupBase pSDepSlnASGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNASGRPID", (Object)pSDepSlnASGroupBase.getPSDepSlnASGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnASGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnASGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnASItem> selectTempByPSDepSlnASGroup(PSDepSlnASGroupBase pSDepSlnASGroupBase) throws Exception {
        return this.selectTempByPSDepSlnASGroup(pSDepSlnASGroupBase, "");
    }

    public ArrayList<PSDepSlnASItem> selectTempByPSDepSlnASGroup(PSDepSlnASGroupBase pSDepSlnASGroupBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNASGRPID", (Object)pSDepSlnASGroupBase.getPSDepSlnASGroupId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDepSlnASGroupCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDepSlnASGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnASItem> selectByPSDepSlnAS(PSDepSlnASBase pSDepSlnASBase) throws Exception {
        return this.selectByPSDepSlnAS(pSDepSlnASBase, "", -1);
    }

    public ArrayList<PSDepSlnASItem> selectByPSDepSlnAS(PSDepSlnASBase pSDepSlnASBase, String string) throws Exception {
        return this.selectByPSDepSlnAS(pSDepSlnASBase, string, -1);
    }

    public ArrayList<PSDepSlnASItem> selectByPSDepSlnAS(PSDepSlnASBase pSDepSlnASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNASID", (Object)pSDepSlnASBase.getPSDepSlnASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnASCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnASCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
    }

    public void resetPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        ArrayList<PSDepSlnASItem> arrayList = this.selectByPSDepSlnASGroup(pSDepSlnASGroup);
        for (PSDepSlnASItem pSDepSlnASItem : arrayList) {
            PSDepSlnASItem pSDepSlnASItem2 = (PSDepSlnASItem)this.getDEModel().createEntity();
            pSDepSlnASItem2.setPSDepSlnASItemId(pSDepSlnASItem.getPSDepSlnASItemId());
            pSDepSlnASItem2.setPSDepSlnASGroupId(null);
            this.update(pSDepSlnASItem2);
        }
    }

    public void resetTempPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        ArrayList<PSDepSlnASItem> arrayList = this.selectTempByPSDepSlnASGroup(pSDepSlnASGroup);
        for (PSDepSlnASItem pSDepSlnASItem : arrayList) {
            PSDepSlnASItem pSDepSlnASItem2 = (PSDepSlnASItem)this.getDEModel().createEntity();
            pSDepSlnASItem2.setPSDepSlnASItemId(pSDepSlnASItem.getPSDepSlnASItemId());
            pSDepSlnASItem2.setPSDepSlnASGroupId(null);
            this.updateTemp((IEntity)pSDepSlnASItem2);
        }
    }

    public void removeByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        final PSDepSlnASGroup pSDepSlnASGroup2 = pSDepSlnASGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnASItemServiceBase.this.onBeforeRemoveByPSDepSlnASGroup(pSDepSlnASGroup2);
                PSDepSlnASItemServiceBase.this.internalRemoveByPSDepSlnASGroup(pSDepSlnASGroup2);
                PSDepSlnASItemServiceBase.this.onAfterRemoveByPSDepSlnASGroup(pSDepSlnASGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
    }

    protected void internalRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        ArrayList<PSDepSlnASItem> arrayList = this.selectByPSDepSlnASGroup(pSDepSlnASGroup);
        this.onBeforeRemoveByPSDepSlnASGroup(pSDepSlnASGroup, arrayList);
        for (PSDepSlnASItem pSDepSlnASItem : arrayList) {
            this.remove((IEntity)pSDepSlnASItem);
        }
        this.onAfterRemoveByPSDepSlnASGroup(pSDepSlnASGroup, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup, ArrayList<PSDepSlnASItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup, ArrayList<PSDepSlnASItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        ArrayList<PSDepSlnASItem> arrayList = this.selectByPSDepSlnAS(pSDepSlnAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNASITEM_PSDEPSLNAS_PSDEPSLNASID", "", iDataEntityModel.getName(), "PSDEPSLNASITEM", iDataEntityModel.getDataInfo((IEntity)pSDepSlnAS), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        ArrayList<PSDepSlnASItem> arrayList = this.selectByPSDepSlnAS(pSDepSlnAS);
        for (PSDepSlnASItem pSDepSlnASItem : arrayList) {
            PSDepSlnASItem pSDepSlnASItem2 = (PSDepSlnASItem)this.getDEModel().createEntity();
            pSDepSlnASItem2.setPSDepSlnASItemId(pSDepSlnASItem.getPSDepSlnASItemId());
            pSDepSlnASItem2.setPSDepSlnASId(null);
            this.update(pSDepSlnASItem2);
        }
    }

    public void removeByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        final PSDepSlnAS pSDepSlnAS2 = pSDepSlnAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnASItemServiceBase.this.onBeforeRemoveByPSDepSlnAS(pSDepSlnAS2);
                PSDepSlnASItemServiceBase.this.internalRemoveByPSDepSlnAS(pSDepSlnAS2);
                PSDepSlnASItemServiceBase.this.onAfterRemoveByPSDepSlnAS(pSDepSlnAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
    }

    protected void internalRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        ArrayList<PSDepSlnASItem> arrayList = this.selectByPSDepSlnAS(pSDepSlnAS);
        this.onBeforeRemoveByPSDepSlnAS(pSDepSlnAS, arrayList);
        for (PSDepSlnASItem pSDepSlnASItem : arrayList) {
            this.remove((IEntity)pSDepSlnASItem);
        }
        this.onAfterRemoveByPSDepSlnAS(pSDepSlnAS, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS, ArrayList<PSDepSlnASItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS, ArrayList<PSDepSlnASItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnASItem pSDepSlnASItem) throws Exception {
        super.onBeforeRemove(pSDepSlnASItem);
    }

    public void removeTempByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        final PSDepSlnASGroup pSDepSlnASGroup2 = pSDepSlnASGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnASItemServiceBase.this.onBeforeRemoveTempByPSDepSlnASGroup(pSDepSlnASGroup2);
                PSDepSlnASItemServiceBase.this.internalRemoveTempByPSDepSlnASGroup(pSDepSlnASGroup2);
                PSDepSlnASItemServiceBase.this.onAfterRemoveTempByPSDepSlnASGroup(pSDepSlnASGroup2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
    }

    protected void internalRemoveTempByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        ArrayList<PSDepSlnASItem> arrayList = this.selectTempByPSDepSlnASGroup(pSDepSlnASGroup);
        this.onBeforeRemoveTempByPSDepSlnASGroup(pSDepSlnASGroup, arrayList);
        for (PSDepSlnASItem pSDepSlnASItem : arrayList) {
            this.removeTemp((IEntity)pSDepSlnASItem);
        }
        this.onAfterRemoveTempByPSDepSlnASGroup(pSDepSlnASGroup, arrayList);
    }

    protected void onAfterRemoveTempByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup, ArrayList<PSDepSlnASItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup, ArrayList<PSDepSlnASItem> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSDepSlnASItem pSDepSlnASItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnASItem, cloneSession);
        if (pSDepSlnASItem.getPSDepSlnASGroupId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNASGRP", (Object)pSDepSlnASItem.getPSDepSlnASGroupId())) != null) {
            this.onFillParentInfo_PSDepSlnASGroup(pSDepSlnASItem, (PSDepSlnASGroup)iEntity);
        }
        if (pSDepSlnASItem.getPSDepSlnASId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNAS", (Object)pSDepSlnASItem.getPSDepSlnASId())) != null) {
            this.onFillParentInfo_PSDepSlnAS(pSDepSlnASItem, (PSDepSlnAS)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnASItem pSDepSlnASItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnASItem, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnASItem pSDepSlnASItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BackupMode(bl, pSDepSlnASItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FailTimeout(bl, pSDepSlnASItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxFails(bl, pSDepSlnASItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnASItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASGroupId(bl, pSDepSlnASItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASId(bl, pSDepSlnASItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASItemId(bl, pSDepSlnASItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASItemName(bl, pSDepSlnASItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Weight(bl, pSDepSlnASItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnASItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BackupMode(boolean bl, PSDepSlnASItem pSDepSlnASItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASItem.isBackupModeDirty() : !pSDepSlnASItem.isBackupModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnASItem.getBackupMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BackupMode_Default((IEntity)pSDepSlnASItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BACKUPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FailTimeout(boolean bl, PSDepSlnASItem pSDepSlnASItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASItem.isFailTimeoutDirty() : !pSDepSlnASItem.isFailTimeoutDirty()) {
            return null;
        }
        Integer n = pSDepSlnASItem.getFailTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FailTimeout_Default((IEntity)pSDepSlnASItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FAILTIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxFails(boolean bl, PSDepSlnASItem pSDepSlnASItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASItem.isMaxFailsDirty() : !pSDepSlnASItem.isMaxFailsDirty()) {
            return null;
        }
        Integer n = pSDepSlnASItem.getMaxFails();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxFails_Default((IEntity)pSDepSlnASItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXFAILS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnASItem pSDepSlnASItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASItem.isMemoDirty() : !pSDepSlnASItem.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnASItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnASItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnASGroupId(boolean bl, PSDepSlnASItem pSDepSlnASItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASItem.isPSDepSlnASGroupIdDirty() && !bl2 : !pSDepSlnASItem.isPSDepSlnASGroupIdDirty()) {
            return null;
        }
        String string = pSDepSlnASItem.getPSDepSlnASGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASGRPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASGroupId_Default((IEntity)pSDepSlnASItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASGRPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnASId(boolean bl, PSDepSlnASItem pSDepSlnASItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASItem.isPSDepSlnASIdDirty() && !bl2 : !pSDepSlnASItem.isPSDepSlnASIdDirty()) {
            return null;
        }
        String string = pSDepSlnASItem.getPSDepSlnASId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASId_Default((IEntity)pSDepSlnASItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnASItemId(boolean bl, PSDepSlnASItem pSDepSlnASItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASItem.isPSDepSlnASItemIdDirty() && !bl2 : !pSDepSlnASItem.isPSDepSlnASItemIdDirty()) {
            return null;
        }
        String string = pSDepSlnASItem.getPSDepSlnASItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASItemId_Default((IEntity)pSDepSlnASItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnASItemName(boolean bl, PSDepSlnASItem pSDepSlnASItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASItem.isPSDepSlnASItemNameDirty() && !bl2 : !pSDepSlnASItem.isPSDepSlnASItemNameDirty()) {
            return null;
        }
        String string = pSDepSlnASItem.getPSDepSlnASItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASItemName_Default((IEntity)pSDepSlnASItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEPSLNASGRPID";
                String string4 = this.checkFieldDupRule(this.getPSDepSlnASItemDEModel(), "PSDEPSLNASITEMNAME", string3, pSDepSlnASItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEPSLNASITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Weight(boolean bl, PSDepSlnASItem pSDepSlnASItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASItem.isWeightDirty() : !pSDepSlnASItem.isWeightDirty()) {
            return null;
        }
        Integer n = pSDepSlnASItem.getWeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Weight_Default((IEntity)pSDepSlnASItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnASItem pSDepSlnASItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnASItem, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnASItem pSDepSlnASItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnASItem, bl);
    }

    public Object getDataContextValue(PSDepSlnASItem pSDepSlnASItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnASItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSlnASGroup pSDepSlnASGroup = pSDepSlnASItem.getPSDepSlnASGroup();
        if (pSDepSlnASGroup != null && pSDepSlnASGroup.contains(string)) {
            return pSDepSlnASGroup.get(string);
        }
        PSDepSlnAS pSDepSlnAS = pSDepSlnASItem.getPSDepSlnAS();
        if (pSDepSlnAS != null && pSDepSlnAS.contains(string)) {
            return pSDepSlnAS.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnASItem pSDepSlnASItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnASItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BACKUPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BackupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FAILTIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FailTimeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXFAILS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxFails_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASGRPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASGRPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Weight_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BackupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_FailTimeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxFails_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_PSDepSlnASGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNASGRPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnASGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNASGRPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnASItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNASITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnASItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNASITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_Weight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDepSlnASItem pSDepSlnASItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnASItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnASItem pSDepSlnASItem) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnASItem);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnASItem pSDepSlnASItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNASITEM");
        if (!bl) {
            pSDepSlnASItem.setPSDepSlnASGroupId(null);
            pSDepSlnASItem.setPSDepSlnASGroupName(null);
            super.exportCurXmlModel(pSDepSlnASItem, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDepSlnASItem pSDepSlnASItem, PSSystem pSSystem) throws Exception {
        PSDepSlnASItem pSDepSlnASItem2 = new PSDepSlnASItem();
        pSDepSlnASItem2.setPSDepSlnASGroupId(pSDepSlnASItem.getPSDepSlnASGroupId());
        pSDepSlnASItem2.setPSDepSlnASId(pSDepSlnASItem.getPSDepSlnASId());
        if (this.selectOne((IEntity)pSDepSlnASItem2, true)) {
            return pSDepSlnASItem2.getPSDepSlnASItemId();
        }
        return super.getEntityFolderKeyValue(pSDepSlnASItem, pSSystem);
    }
}

