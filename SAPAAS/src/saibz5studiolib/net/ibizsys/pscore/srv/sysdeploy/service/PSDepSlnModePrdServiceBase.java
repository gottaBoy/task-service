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
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnModePrdDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnModePrdDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASGroup;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASGroupBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnMode;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnModeBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnModePrd;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrd;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrdBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnModePrdServiceBase
extends PSCoreSysServiceBase<PSDepSlnModePrd> {
    private static final Log log = LogFactory.getLog(PSDepSlnModePrdServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnModePrdDEModel pSDepSlnModePrdDEModel;
    private PSDepSlnModePrdDAO pSDepSlnModePrdDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModePrdService";
    }

    public PSDepSlnModePrdDEModel getPSDepSlnModePrdDEModel() {
        if (this.pSDepSlnModePrdDEModel == null) {
            try {
                this.pSDepSlnModePrdDEModel = (PSDepSlnModePrdDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnModePrdDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnModePrdDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnModePrdDEModel();
    }

    public PSDepSlnModePrdDAO getPSDepSlnModePrdDAO() {
        if (this.pSDepSlnModePrdDAO == null) {
            try {
                this.pSDepSlnModePrdDAO = (PSDepSlnModePrdDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnModePrdDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnModePrdDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnModePrdDAO();
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

    protected void onFillParentInfo(PSDepSlnModePrd pSDepSlnModePrd, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNMODEPRD_PSDEPSLNASGRP_PSDEPSLNASGRPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupService", (SessionFactory)this.getSessionFactory());
            PSDepSlnASGroup pSDepSlnASGroup = (PSDepSlnASGroup)iService.getDEModel().createEntity();
            pSDepSlnASGroup.set("PSDEPSLNASGRPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnASGroup);
            } else {
                iService.get((IEntity)pSDepSlnASGroup);
            }
            this.onFillParentInfo_PSDepSlnASGroup(pSDepSlnModePrd, pSDepSlnASGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNMODEPRD_PSDEPSLNMODE_PSDEPSLNMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModeService", (SessionFactory)this.getSessionFactory());
            PSDepSlnMode pSDepSlnMode = (PSDepSlnMode)iService.getDEModel().createEntity();
            pSDepSlnMode.set("PSDEPSLNMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnMode);
            } else {
                iService.get((IEntity)pSDepSlnMode);
            }
            this.onFillParentInfo_PSDepSlnMode(pSDepSlnModePrd, pSDepSlnMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNMODEPRD_PSDEPSLNPRD_PSDEPSLNPRDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdService", (SessionFactory)this.getSessionFactory());
            PSDepSlnPrd pSDepSlnPrd = (PSDepSlnPrd)iService.getDEModel().createEntity();
            pSDepSlnPrd.set("PSDEPSLNPRDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDepSlnPrd);
            } else {
                iService.get((IEntity)pSDepSlnPrd);
            }
            this.onFillParentInfo_PSDepSlnPrd(pSDepSlnModePrd, pSDepSlnPrd);
            return;
        }
        super.onFillParentInfo((IEntity)pSDepSlnModePrd, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnASGroup(PSDepSlnModePrd pSDepSlnModePrd, PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        pSDepSlnModePrd.setPSDepSlnASGroupId(pSDepSlnASGroup.getPSDepSlnASGroupId());
        pSDepSlnModePrd.setPSDepSlnASGroupName(pSDepSlnASGroup.getPSDepSlnASGroupName());
    }

    protected void onFillParentInfo_PSDepSlnMode(PSDepSlnModePrd pSDepSlnModePrd, PSDepSlnMode pSDepSlnMode) throws Exception {
        pSDepSlnModePrd.setPSDepSlnModeId(pSDepSlnMode.getPSDepSlnModeId());
        pSDepSlnModePrd.setPSDepSlnModeName(pSDepSlnMode.getPSDepSlnModeName());
    }

    protected void onFillParentInfo_PSDepSlnPrd(PSDepSlnModePrd pSDepSlnModePrd, PSDepSlnPrd pSDepSlnPrd) throws Exception {
        pSDepSlnModePrd.setPSDepSlnPrdId(pSDepSlnPrd.getPSDepSlnPrdId());
        pSDepSlnModePrd.setPSDepSlnPrdName(pSDepSlnPrd.getPSDepSlnPrdName());
    }

    protected boolean onFillEntityKeyValue(PSDepSlnModePrd pSDepSlnModePrd, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDepSlnModePrd.get("PSDEPSLNMODEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDepSlnModePrd.get("PSDEPSLNPRDID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSDepSlnModePrd.get("PSDEPSLNASGRPID");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        String string = stringBuilderEx.toString();
        pSDepSlnModePrd.set(this.getPSDepSlnModePrdDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDepSlnModePrd pSDepSlnModePrd, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDepSlnModePrd, bl);
        this.onFillEntityFullInfo_PSDepSlnASGroup(pSDepSlnModePrd, bl);
        this.onFillEntityFullInfo_PSDepSlnMode(pSDepSlnModePrd, bl);
        this.onFillEntityFullInfo_PSDepSlnPrd(pSDepSlnModePrd, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnASGroup(PSDepSlnModePrd pSDepSlnModePrd, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnMode(PSDepSlnModePrd pSDepSlnModePrd, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnPrd(PSDepSlnModePrd pSDepSlnModePrd, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnModePrd pSDepSlnModePrd, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDepSlnModePrd, bl);
    }

    public ArrayList<PSDepSlnModePrd> selectByPSDepSlnASGroup(PSDepSlnASGroupBase pSDepSlnASGroupBase) throws Exception {
        return this.selectByPSDepSlnASGroup(pSDepSlnASGroupBase, "", -1);
    }

    public ArrayList<PSDepSlnModePrd> selectByPSDepSlnASGroup(PSDepSlnASGroupBase pSDepSlnASGroupBase, String string) throws Exception {
        return this.selectByPSDepSlnASGroup(pSDepSlnASGroupBase, string, -1);
    }

    public ArrayList<PSDepSlnModePrd> selectByPSDepSlnASGroup(PSDepSlnASGroupBase pSDepSlnASGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnModePrd> selectByPSDepSlnMode(PSDepSlnModeBase pSDepSlnModeBase) throws Exception {
        return this.selectByPSDepSlnMode(pSDepSlnModeBase, "", -1);
    }

    public ArrayList<PSDepSlnModePrd> selectByPSDepSlnMode(PSDepSlnModeBase pSDepSlnModeBase, String string) throws Exception {
        return this.selectByPSDepSlnMode(pSDepSlnModeBase, string, -1);
    }

    public ArrayList<PSDepSlnModePrd> selectByPSDepSlnMode(PSDepSlnModeBase pSDepSlnModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNMODEID", (Object)pSDepSlnModeBase.getPSDepSlnModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnModePrd> selectByPSDepSlnPrd(PSDepSlnPrdBase pSDepSlnPrdBase) throws Exception {
        return this.selectByPSDepSlnPrd(pSDepSlnPrdBase, "", -1);
    }

    public ArrayList<PSDepSlnModePrd> selectByPSDepSlnPrd(PSDepSlnPrdBase pSDepSlnPrdBase, String string) throws Exception {
        return this.selectByPSDepSlnPrd(pSDepSlnPrdBase, string, -1);
    }

    public ArrayList<PSDepSlnModePrd> selectByPSDepSlnPrd(PSDepSlnPrdBase pSDepSlnPrdBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNPRDID", (Object)pSDepSlnPrdBase.getPSDepSlnPrdId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnPrdCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnPrdCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        ArrayList<PSDepSlnModePrd> arrayList = this.selectByPSDepSlnASGroup(pSDepSlnASGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNASGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnASGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNMODEPRD_PSDEPSLNASGRP_PSDEPSLNASGRPID", "", iDataEntityModel.getName(), "PSDEPSLNMODEPRD", iDataEntityModel.getDataInfo((IEntity)pSDepSlnASGroup), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        ArrayList<PSDepSlnModePrd> arrayList = this.selectByPSDepSlnASGroup(pSDepSlnASGroup);
        for (PSDepSlnModePrd pSDepSlnModePrd : arrayList) {
            PSDepSlnModePrd pSDepSlnModePrd2 = (PSDepSlnModePrd)this.getDEModel().createEntity();
            pSDepSlnModePrd2.setPSDepSlnModePrdId(pSDepSlnModePrd.getPSDepSlnModePrdId());
            pSDepSlnModePrd2.setPSDepSlnASGroupId(null);
            this.update(pSDepSlnModePrd2);
        }
    }

    public void removeByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        final PSDepSlnASGroup pSDepSlnASGroup2 = pSDepSlnASGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnModePrdServiceBase.this.onBeforeRemoveByPSDepSlnASGroup(pSDepSlnASGroup2);
                PSDepSlnModePrdServiceBase.this.internalRemoveByPSDepSlnASGroup(pSDepSlnASGroup2);
                PSDepSlnModePrdServiceBase.this.onAfterRemoveByPSDepSlnASGroup(pSDepSlnASGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
    }

    protected void internalRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        ArrayList<PSDepSlnModePrd> arrayList = this.selectByPSDepSlnASGroup(pSDepSlnASGroup);
        this.onBeforeRemoveByPSDepSlnASGroup(pSDepSlnASGroup, arrayList);
        for (PSDepSlnModePrd pSDepSlnModePrd : arrayList) {
            this.remove((IEntity)pSDepSlnModePrd);
        }
        this.onAfterRemoveByPSDepSlnASGroup(pSDepSlnASGroup, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup, ArrayList<PSDepSlnModePrd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnASGroup(PSDepSlnASGroup pSDepSlnASGroup, ArrayList<PSDepSlnModePrd> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
        ArrayList<PSDepSlnModePrd> arrayList = this.selectByPSDepSlnMode(pSDepSlnMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNMODEPRD_PSDEPSLNMODE_PSDEPSLNMODEID", "", iDataEntityModel.getName(), "PSDEPSLNMODEPRD", iDataEntityModel.getDataInfo((IEntity)pSDepSlnMode), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
        ArrayList<PSDepSlnModePrd> arrayList = this.selectByPSDepSlnMode(pSDepSlnMode);
        for (PSDepSlnModePrd pSDepSlnModePrd : arrayList) {
            PSDepSlnModePrd pSDepSlnModePrd2 = (PSDepSlnModePrd)this.getDEModel().createEntity();
            pSDepSlnModePrd2.setPSDepSlnModePrdId(pSDepSlnModePrd.getPSDepSlnModePrdId());
            pSDepSlnModePrd2.setPSDepSlnModeId(null);
            this.update(pSDepSlnModePrd2);
        }
    }

    public void removeByPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
        final PSDepSlnMode pSDepSlnMode2 = pSDepSlnMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnModePrdServiceBase.this.onBeforeRemoveByPSDepSlnMode(pSDepSlnMode2);
                PSDepSlnModePrdServiceBase.this.internalRemoveByPSDepSlnMode(pSDepSlnMode2);
                PSDepSlnModePrdServiceBase.this.onAfterRemoveByPSDepSlnMode(pSDepSlnMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
    }

    protected void internalRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
        ArrayList<PSDepSlnModePrd> arrayList = this.selectByPSDepSlnMode(pSDepSlnMode);
        this.onBeforeRemoveByPSDepSlnMode(pSDepSlnMode, arrayList);
        for (PSDepSlnModePrd pSDepSlnModePrd : arrayList) {
            this.remove((IEntity)pSDepSlnModePrd);
        }
        this.onAfterRemoveByPSDepSlnMode(pSDepSlnMode, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode, ArrayList<PSDepSlnModePrd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnMode(PSDepSlnMode pSDepSlnMode, ArrayList<PSDepSlnModePrd> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        ArrayList<PSDepSlnModePrd> arrayList = this.selectByPSDepSlnPrd(pSDepSlnPrd, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNPRD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDepSlnPrd);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNMODEPRD_PSDEPSLNPRD_PSDEPSLNPRDID", "", iDataEntityModel.getName(), "PSDEPSLNMODEPRD", iDataEntityModel.getDataInfo((IEntity)pSDepSlnPrd), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        ArrayList<PSDepSlnModePrd> arrayList = this.selectByPSDepSlnPrd(pSDepSlnPrd);
        for (PSDepSlnModePrd pSDepSlnModePrd : arrayList) {
            PSDepSlnModePrd pSDepSlnModePrd2 = (PSDepSlnModePrd)this.getDEModel().createEntity();
            pSDepSlnModePrd2.setPSDepSlnModePrdId(pSDepSlnModePrd.getPSDepSlnModePrdId());
            pSDepSlnModePrd2.setPSDepSlnPrdId(null);
            this.update(pSDepSlnModePrd2);
        }
    }

    public void removeByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        final PSDepSlnPrd pSDepSlnPrd2 = pSDepSlnPrd;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnModePrdServiceBase.this.onBeforeRemoveByPSDepSlnPrd(pSDepSlnPrd2);
                PSDepSlnModePrdServiceBase.this.internalRemoveByPSDepSlnPrd(pSDepSlnPrd2);
                PSDepSlnModePrdServiceBase.this.onAfterRemoveByPSDepSlnPrd(pSDepSlnPrd2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
    }

    protected void internalRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        ArrayList<PSDepSlnModePrd> arrayList = this.selectByPSDepSlnPrd(pSDepSlnPrd);
        this.onBeforeRemoveByPSDepSlnPrd(pSDepSlnPrd, arrayList);
        for (PSDepSlnModePrd pSDepSlnModePrd : arrayList) {
            this.remove((IEntity)pSDepSlnModePrd);
        }
        this.onAfterRemoveByPSDepSlnPrd(pSDepSlnPrd, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd, ArrayList<PSDepSlnModePrd> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnPrd(PSDepSlnPrd pSDepSlnPrd, ArrayList<PSDepSlnModePrd> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnModePrd pSDepSlnModePrd) throws Exception {
        super.onBeforeRemove(pSDepSlnModePrd);
    }

    protected void replaceParentInfo(PSDepSlnModePrd pSDepSlnModePrd, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDepSlnModePrd, cloneSession);
        if (pSDepSlnModePrd.getPSDepSlnASGroupId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNASGRP", (Object)pSDepSlnModePrd.getPSDepSlnASGroupId())) != null) {
            this.onFillParentInfo_PSDepSlnASGroup(pSDepSlnModePrd, (PSDepSlnASGroup)iEntity);
        }
        if (pSDepSlnModePrd.getPSDepSlnModeId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNMODE", (Object)pSDepSlnModePrd.getPSDepSlnModeId())) != null) {
            this.onFillParentInfo_PSDepSlnMode(pSDepSlnModePrd, (PSDepSlnMode)iEntity);
        }
        if (pSDepSlnModePrd.getPSDepSlnPrdId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNPRD", (Object)pSDepSlnModePrd.getPSDepSlnPrdId())) != null) {
            this.onFillParentInfo_PSDepSlnPrd(pSDepSlnModePrd, (PSDepSlnPrd)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnModePrd pSDepSlnModePrd, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDepSlnModePrd, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnModePrd pSDepSlnModePrd, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSDepSlnModePrd, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASGroupId(bl, pSDepSlnModePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnModeId(bl, pSDepSlnModePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnModePrdId(bl, pSDepSlnModePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnModePrdName(bl, pSDepSlnModePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnPrdId(bl, pSDepSlnModePrd, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDepSlnModePrd, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnModePrd pSDepSlnModePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnModePrd.isMemoDirty() : !pSDepSlnModePrd.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnModePrd.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDepSlnModePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnASGroupId(boolean bl, PSDepSlnModePrd pSDepSlnModePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnModePrd.isPSDepSlnASGroupIdDirty() && !bl2 : !pSDepSlnModePrd.isPSDepSlnASGroupIdDirty()) {
            return null;
        }
        String string = pSDepSlnModePrd.getPSDepSlnASGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASGRPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASGroupId_Default((IEntity)pSDepSlnModePrd, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnModeId(boolean bl, PSDepSlnModePrd pSDepSlnModePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnModePrd.isPSDepSlnModeIdDirty() && !bl2 : !pSDepSlnModePrd.isPSDepSlnModeIdDirty()) {
            return null;
        }
        String string = pSDepSlnModePrd.getPSDepSlnModeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnModeId_Default((IEntity)pSDepSlnModePrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnModePrdId(boolean bl, PSDepSlnModePrd pSDepSlnModePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnModePrd.isPSDepSlnModePrdIdDirty() && !bl2 : !pSDepSlnModePrd.isPSDepSlnModePrdIdDirty()) {
            return null;
        }
        String string = pSDepSlnModePrd.getPSDepSlnModePrdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODEPRDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnModePrdId_Default((IEntity)pSDepSlnModePrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODEPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnModePrdName(boolean bl, PSDepSlnModePrd pSDepSlnModePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnModePrd.isPSDepSlnModePrdNameDirty() && !bl2 : !pSDepSlnModePrd.isPSDepSlnModePrdNameDirty()) {
            return null;
        }
        String string = pSDepSlnModePrd.getPSDepSlnModePrdName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODEPRDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnModePrdName_Default((IEntity)pSDepSlnModePrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNMODEPRDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnPrdId(boolean bl, PSDepSlnModePrd pSDepSlnModePrd, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnModePrd.isPSDepSlnPrdIdDirty() && !bl2 : !pSDepSlnModePrd.isPSDepSlnPrdIdDirty()) {
            return null;
        }
        String string = pSDepSlnModePrd.getPSDepSlnPrdId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPRDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnPrdId_Default((IEntity)pSDepSlnModePrd, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNPRDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnModePrd pSDepSlnModePrd, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDepSlnModePrd, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnModePrd pSDepSlnModePrd, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDepSlnModePrd, bl);
    }

    public Object getDataContextValue(PSDepSlnModePrd pSDepSlnModePrd, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDepSlnModePrd, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSlnMode pSDepSlnMode = pSDepSlnModePrd.getPSDepSlnMode();
        if (pSDepSlnMode != null && pSDepSlnMode.contains(string)) {
            return pSDepSlnMode.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnModePrd pSDepSlnModePrd, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDepSlnModePrd, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASGRPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASGRPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMODEPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnModePrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNMODEPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnModePrdName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNPRDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnPrdId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNPRDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnPrdName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDepSlnModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnModePrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMODEPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnModePrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNMODEPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnPrdId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNPRDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnPrdName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNPRDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnModePrd pSDepSlnModePrd) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDepSlnModePrd)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnModePrd pSDepSlnModePrd) throws Exception {
        super.onUpdateParent((IEntity)pSDepSlnModePrd);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnModePrd pSDepSlnModePrd, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNMODEPRD");
        if (!bl) {
            super.exportCurXmlModel(pSDepSlnModePrd, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSDepSlnModePrd pSDepSlnModePrd, PSSystem pSSystem) throws Exception {
        PSDepSlnModePrd pSDepSlnModePrd2 = new PSDepSlnModePrd();
        pSDepSlnModePrd2.setPSDepSlnModeId(pSDepSlnModePrd.getPSDepSlnModeId());
        pSDepSlnModePrd2.setPSDepSlnPrdId(pSDepSlnModePrd.getPSDepSlnPrdId());
        pSDepSlnModePrd2.setPSDepSlnASGroupId(pSDepSlnModePrd.getPSDepSlnASGroupId());
        if (this.selectOne((IEntity)pSDepSlnModePrd2, true)) {
            return pSDepSlnModePrd2.getPSDepSlnModePrdId();
        }
        return super.getEntityFolderKeyValue(pSDepSlnModePrd, pSSystem);
    }
}

