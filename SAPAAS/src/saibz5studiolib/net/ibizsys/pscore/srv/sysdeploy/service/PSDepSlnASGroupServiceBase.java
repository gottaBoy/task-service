/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
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
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdeploy.service;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDCASGroup;
import net.ibizsys.pscore.srv.config.entity.PSDCASGroupBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnASGroupDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnASGroupDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASGroup;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASItem;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHost;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnHostBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASItemService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASItemServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModePrdService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModePrdServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnASGroupServiceBase
extends PSCoreSysServiceBase<PSDepSlnASGroup> {
    private static final Log log = LogFactory.getLog(PSDepSlnASGroupServiceBase.class);
    public static final String DATASET_CURDEPSLN = "CurDepSln";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnASGroupDEModel pSDepSlnASGroupDEModel;
    private PSDepSlnASGroupDAO pSDepSlnASGroupDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupService";
    }

    public PSDepSlnASGroupDEModel getPSDepSlnASGroupDEModel() {
        if (this.pSDepSlnASGroupDEModel == null) {
            try {
                this.pSDepSlnASGroupDEModel = (PSDepSlnASGroupDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnASGroupDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnASGroupDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnASGroupDEModel();
    }

    public PSDepSlnASGroupDAO getPSDepSlnASGroupDAO() {
        if (this.pSDepSlnASGroupDAO == null) {
            try {
                this.pSDepSlnASGroupDAO = (PSDepSlnASGroupDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnASGroupDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnASGroupDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnASGroupDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEPSLN, (boolean)true) == 0) {
            return this.fetchCurDepSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDEPSLN, (boolean)true) == 0) {
            return this.fetchTempCurDepSln(iDEDataSetFetchContext);
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

    public DBFetchResult fetchCurDepSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEPSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDepSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEPSLN, true);
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

    protected void onFillParentInfo(PSDepSlnASGroup pSDepSlnASGroup, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNASGRP_PSDCASGROUP_PSDCASGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDCASGroupService", (SessionFactory)this.getSessionFactory());
            PSDCASGroup pSDCASGroup = (PSDCASGroup)iService.getDEModel().createEntity();
            pSDCASGroup.set("PSDCASGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCASGroup);
            } else {
                iService.get(pSDCASGroup);
            }
            this.onFillParentInfo_PSDCASGroup(pSDepSlnASGroup, pSDCASGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNASGRP_PSDEPSLNHOST_PSDEPSLNHOSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnHostService", (SessionFactory)this.getSessionFactory());
            PSDepSlnHost pSDepSlnHost = (PSDepSlnHost)iService.getDEModel().createEntity();
            pSDepSlnHost.set("PSDEPSLNHOSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnHost);
            } else {
                iService.get(pSDepSlnHost);
            }
            this.onFillParentInfo_PSDepSlnHost(pSDepSlnASGroup, pSDepSlnHost);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNASGRP_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSln);
            } else {
                iService.get(pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnASGroup, pSDepSln);
            return;
        }
        super.onFillParentInfo(pSDepSlnASGroup, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCASGroup(PSDepSlnASGroup pSDepSlnASGroup, PSDCASGroup pSDCASGroup) throws Exception {
        pSDepSlnASGroup.setPSDCASGroupId(pSDCASGroup.getPSDCASGroupId());
        pSDepSlnASGroup.setPSDCASGroupName(pSDCASGroup.getPSDCASGroupName());
    }

    protected void onFillParentInfo_PSDepSlnHost(PSDepSlnASGroup pSDepSlnASGroup, PSDepSlnHost pSDepSlnHost) throws Exception {
        pSDepSlnASGroup.setPSDepSlnHostId(pSDepSlnHost.getPSDepSlnHostId());
        pSDepSlnASGroup.setPSDepSlnHostName(pSDepSlnHost.getPSDepSlnHostName());
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnASGroup pSDepSlnASGroup, PSDepSln pSDepSln) throws Exception {
        pSDepSlnASGroup.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnASGroup.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillEntityFullInfo(PSDepSlnASGroup pSDepSlnASGroup, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnASGroup, bl);
        this.onFillEntityFullInfo_PSDCASGroup(pSDepSlnASGroup, bl);
        this.onFillEntityFullInfo_PSDepSlnHost(pSDepSlnASGroup, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnASGroup, bl);
    }

    protected void onFillEntityFullInfo_PSDCASGroup(PSDepSlnASGroup pSDepSlnASGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnHost(PSDepSlnASGroup pSDepSlnASGroup, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnASGroup pSDepSlnASGroup, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnASGroup pSDepSlnASGroup, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnASGroup, bl);
    }

    public ArrayList<PSDepSlnASGroup> selectByPSDCASGroup(PSDCASGroupBase pSDCASGroupBase) throws Exception {
        return this.selectByPSDCASGroup(pSDCASGroupBase, "", -1);
    }

    public ArrayList<PSDepSlnASGroup> selectByPSDCASGroup(PSDCASGroupBase pSDCASGroupBase, String string) throws Exception {
        return this.selectByPSDCASGroup(pSDCASGroupBase, string, -1);
    }

    public ArrayList<PSDepSlnASGroup> selectByPSDCASGroup(PSDCASGroupBase pSDCASGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCASGROUPID", (Object)pSDCASGroupBase.getPSDCASGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCASGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCASGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnASGroup> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase) throws Exception {
        return this.selectByPSDepSlnHost(pSDepSlnHostBase, "", -1);
    }

    public ArrayList<PSDepSlnASGroup> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase, String string) throws Exception {
        return this.selectByPSDepSlnHost(pSDepSlnHostBase, string, -1);
    }

    public ArrayList<PSDepSlnASGroup> selectByPSDepSlnHost(PSDepSlnHostBase pSDepSlnHostBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNHOSTID", (Object)pSDepSlnHostBase.getPSDepSlnHostId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnHostCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnHostCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnASGroup> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnASGroup> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnASGroup> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNID", (Object)pSDepSlnBase.getPSDepSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCASGroup(PSDCASGroup pSDCASGroup) throws Exception {
        ArrayList<PSDepSlnASGroup> arrayList = this.selectByPSDCASGroup(pSDCASGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCASGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCASGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNASGRP_PSDCASGROUP_PSDCASGROUPID", "", iDataEntityModel.getName(), "PSDEPSLNASGRP", iDataEntityModel.getDataInfo(pSDCASGroup), arrayList.get(0)));
        }
    }

    public void resetPSDCASGroup(PSDCASGroup pSDCASGroup) throws Exception {
        ArrayList<PSDepSlnASGroup> arrayList = this.selectByPSDCASGroup(pSDCASGroup);
        for (PSDepSlnASGroup pSDepSlnASGroup : arrayList) {
            PSDepSlnASGroup pSDepSlnASGroup2 = (PSDepSlnASGroup)this.getDEModel().createEntity();
            pSDepSlnASGroup2.setPSDepSlnASGroupId(pSDepSlnASGroup.getPSDepSlnASGroupId());
            pSDepSlnASGroup2.setPSDCASGroupId(null);
            this.update(pSDepSlnASGroup2);
        }
    }

    public void removeByPSDCASGroup(PSDCASGroup pSDCASGroup) throws Exception {
        final PSDCASGroup pSDCASGroup2 = pSDCASGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnASGroupServiceBase.this.onBeforeRemoveByPSDCASGroup(pSDCASGroup2);
                PSDepSlnASGroupServiceBase.this.internalRemoveByPSDCASGroup(pSDCASGroup2);
                PSDepSlnASGroupServiceBase.this.onAfterRemoveByPSDCASGroup(pSDCASGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCASGroup(PSDCASGroup pSDCASGroup) throws Exception {
    }

    protected void internalRemoveByPSDCASGroup(PSDCASGroup pSDCASGroup) throws Exception {
        ArrayList<PSDepSlnASGroup> arrayList = this.selectByPSDCASGroup(pSDCASGroup);
        this.onBeforeRemoveByPSDCASGroup(pSDCASGroup, arrayList);
        for (PSDepSlnASGroup pSDepSlnASGroup : arrayList) {
            this.remove(pSDepSlnASGroup);
        }
        this.onAfterRemoveByPSDCASGroup(pSDCASGroup, arrayList);
    }

    protected void onAfterRemoveByPSDCASGroup(PSDCASGroup pSDCASGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDCASGroup(PSDCASGroup pSDCASGroup, ArrayList<PSDepSlnASGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCASGroup(PSDCASGroup pSDCASGroup, ArrayList<PSDepSlnASGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnASGroup> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNHOST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnHost);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNASGRP_PSDEPSLNHOST_PSDEPSLNHOSTID", "", iDataEntityModel.getName(), "PSDEPSLNASGRP", iDataEntityModel.getDataInfo(pSDepSlnHost), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnASGroup> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost);
        for (PSDepSlnASGroup pSDepSlnASGroup : arrayList) {
            PSDepSlnASGroup pSDepSlnASGroup2 = (PSDepSlnASGroup)this.getDEModel().createEntity();
            pSDepSlnASGroup2.setPSDepSlnASGroupId(pSDepSlnASGroup.getPSDepSlnASGroupId());
            pSDepSlnASGroup2.setPSDepSlnHostId(null);
            this.update(pSDepSlnASGroup2);
        }
    }

    public void removeByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        final PSDepSlnHost pSDepSlnHost2 = pSDepSlnHost;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnASGroupServiceBase.this.onBeforeRemoveByPSDepSlnHost(pSDepSlnHost2);
                PSDepSlnASGroupServiceBase.this.internalRemoveByPSDepSlnHost(pSDepSlnHost2);
                PSDepSlnASGroupServiceBase.this.onAfterRemoveByPSDepSlnHost(pSDepSlnHost2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
    }

    protected void internalRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
        ArrayList<PSDepSlnASGroup> arrayList = this.selectByPSDepSlnHost(pSDepSlnHost);
        this.onBeforeRemoveByPSDepSlnHost(pSDepSlnHost, arrayList);
        for (PSDepSlnASGroup pSDepSlnASGroup : arrayList) {
            this.remove(pSDepSlnASGroup);
        }
        this.onAfterRemoveByPSDepSlnHost(pSDepSlnHost, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost, ArrayList<PSDepSlnASGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnHost(PSDepSlnHost pSDepSlnHost, ArrayList<PSDepSlnASGroup> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnASGroup> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnASGroup pSDepSlnASGroup : arrayList) {
            PSDepSlnASGroup pSDepSlnASGroup2 = (PSDepSlnASGroup)this.getDEModel().createEntity();
            pSDepSlnASGroup2.setPSDepSlnASGroupId(pSDepSlnASGroup.getPSDepSlnASGroupId());
            pSDepSlnASGroup2.setPSDepSlnId(null);
            this.update(pSDepSlnASGroup2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnASGroupServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnASGroupServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnASGroupServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnASGroup> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnASGroup pSDepSlnASGroup : arrayList) {
            this.remove(pSDepSlnASGroup);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnASGroup> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnASGroup> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnASItemService)ServiceGlobal.getService(PSDepSlnASItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnASItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnASGroup(pSDepSlnASGroup);
        ((PSDepSlnASItemServiceBase)pSCoreSysServiceBase).removeByPSDepSlnASGroup(pSDepSlnASGroup);
        pSCoreSysServiceBase = (PSDepSlnModePrdService)ServiceGlobal.getService(PSDepSlnModePrdService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnModePrdServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnASGroup(pSDepSlnASGroup);
        pSCoreSysServiceBase = (PSDepSlnSysASService)ServiceGlobal.getService(PSDepSlnSysASService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysASServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSlnASGrp(pSDepSlnASGroup);
        super.onBeforeRemove(pSDepSlnASGroup);
    }

    protected void onBeforeRemoveTemp(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        PSDepSlnASItemService pSDepSlnASItemService = (PSDepSlnASItemService)ServiceGlobal.getService(PSDepSlnASItemService.class, (SessionFactory)this.getSessionFactory());
        pSDepSlnASItemService.removeTempByPSDepSlnASGroup(pSDepSlnASGroup);
        super.onBeforeRemoveTemp(pSDepSlnASGroup);
    }

    protected void getRelatedDataTempMajor(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        this.getRelatedDataTempMajor_PSDepSlnASItem(pSDepSlnASGroup);
        super.getRelatedDataTempMajor(pSDepSlnASGroup);
    }

    protected void getRelatedDataTempMajor_PSDepSlnASItem(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        PSDepSlnASItemService pSDepSlnASItemService = (PSDepSlnASItemService)ServiceGlobal.getService(PSDepSlnASItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDepSlnASItem> arrayList = null;
        String string = pSDepSlnASGroup.getPSDepSlnASGroupId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDepSlnASItemService.selectByPSDepSlnASGroup(pSDepSlnASGroup) : pSDepSlnASItemService.selectTempByPSDepSlnASGroup(pSDepSlnASGroup);
        for (PSDepSlnASItem pSDepSlnASItem : arrayList) {
            pSDepSlnASItemService.getTempMajor(pSDepSlnASItem);
        }
    }

    protected void updateRelatedDataTempMajor(PSDepSlnASGroup pSDepSlnASGroup, PSDepSlnASGroup pSDepSlnASGroup2) throws Exception {
        ArrayList<PSDepSlnASItem> arrayList = this.updateRelatedDataTempMajor_removePSDepSlnASItem(pSDepSlnASGroup, pSDepSlnASGroup2);
        this.updateRelatedDataTempMajor_updatePSDepSlnASItem(pSDepSlnASGroup, pSDepSlnASGroup2, arrayList);
        super.updateRelatedDataTempMajor(pSDepSlnASGroup, pSDepSlnASGroup2);
    }

    protected ArrayList<PSDepSlnASItem> updateRelatedDataTempMajor_removePSDepSlnASItem(PSDepSlnASGroup pSDepSlnASGroup, PSDepSlnASGroup pSDepSlnASGroup2) throws Exception {
        PSDepSlnASItemService pSDepSlnASItemService = (PSDepSlnASItemService)ServiceGlobal.getService(PSDepSlnASItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDepSlnASItem> arrayList = pSDepSlnASItemService.selectTempByPSDepSlnASGroup(pSDepSlnASGroup);
        ArrayList<PSDepSlnASItem> arrayList2 = pSDepSlnASItemService.selectByPSDepSlnASGroup(pSDepSlnASGroup2);
        HashMap<String, PSDepSlnASItem> hashMap = new HashMap<String, PSDepSlnASItem>();
        for (PSDepSlnASItem pSDepSlnASItem : arrayList2) {
            hashMap.put(pSDepSlnASItem.getPSDepSlnASItemId(), pSDepSlnASItem);
        }
        for (PSDepSlnASItem pSDepSlnASItem : arrayList) {
            Object object = pSDepSlnASItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDepSlnASItem pSDepSlnASItem : hashMap.values()) {
            pSDepSlnASItemService.remove(pSDepSlnASItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDepSlnASItem(PSDepSlnASGroup pSDepSlnASGroup, PSDepSlnASGroup pSDepSlnASGroup2, ArrayList<PSDepSlnASItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDepSlnASItemService pSDepSlnASItemService = (PSDepSlnASItemService)ServiceGlobal.getService(PSDepSlnASItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSDepSlnASItem pSDepSlnASItem : arrayList) {
            pSDepSlnASItemService.updateTempMajor(pSDepSlnASItem);
        }
    }

    protected void replaceParentInfo(PSDepSlnASGroup pSDepSlnASGroup, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnASGroup, cloneSession);
        if (pSDepSlnASGroup.getPSDCASGroupId() != null && (iEntity = cloneSession.getEntity("PSDCASGROUP", (Object)pSDepSlnASGroup.getPSDCASGroupId())) != null) {
            this.onFillParentInfo_PSDCASGroup(pSDepSlnASGroup, (PSDCASGroup)iEntity);
        }
        if (pSDepSlnASGroup.getPSDepSlnHostId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNHOST", (Object)pSDepSlnASGroup.getPSDepSlnHostId())) != null) {
            this.onFillParentInfo_PSDepSlnHost(pSDepSlnASGroup, (PSDepSlnHost)iEntity);
        }
        if (pSDepSlnASGroup.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnASGroup.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnASGroup, (PSDepSln)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnASGroup pSDepSlnASGroup, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnASGroup, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ASType(bl, pSDepSlnASGroup, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLocalMode(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableRemoteMode(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMode(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpPort(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HttpsPort(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCASGroupId(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASGroupId(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASGroupName(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnHostId(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnASGroup, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnASGroup, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ASType(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isASTypeDirty() : !pSDepSlnASGroup.isASTypeDirty()) {
            return null;
        }
        String string = pSDepSlnASGroup.getASType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ASType_Default(pSDepSlnASGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableLocalMode(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isEnableLocalModeDirty() : !pSDepSlnASGroup.isEnableLocalModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnASGroup.getEnableLocalMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableLocalMode_Default(pSDepSlnASGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLELOCALMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableRemoteMode(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isEnableRemoteModeDirty() : !pSDepSlnASGroup.isEnableRemoteModeDirty()) {
            return null;
        }
        Integer n = pSDepSlnASGroup.getEnableRemoteMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableRemoteMode_Default(pSDepSlnASGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEREMOTEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMode(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isGroupModeDirty() : !pSDepSlnASGroup.isGroupModeDirty()) {
            return null;
        }
        String string = pSDepSlnASGroup.getGroupMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMode_Default(pSDepSlnASGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpPort(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isHttpPortDirty() : !pSDepSlnASGroup.isHttpPortDirty()) {
            return null;
        }
        Integer n = pSDepSlnASGroup.getHttpPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpPort_Default(pSDepSlnASGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HttpsPort(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isHttpsPortDirty() : !pSDepSlnASGroup.isHttpsPortDirty()) {
            return null;
        }
        Integer n = pSDepSlnASGroup.getHttpsPort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HttpsPort_Default(pSDepSlnASGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTTPSPORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isMemoDirty() : !pSDepSlnASGroup.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnASGroup.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSlnASGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCASGroupId(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isPSDCASGroupIdDirty() : !pSDepSlnASGroup.isPSDCASGroupIdDirty()) {
            return null;
        }
        String string = pSDepSlnASGroup.getPSDCASGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCASGroupId_Default(pSDepSlnASGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCASGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnASGroupId(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isPSDepSlnASGroupIdDirty() && !bl2 : !pSDepSlnASGroup.isPSDepSlnASGroupIdDirty()) {
            return null;
        }
        String string = pSDepSlnASGroup.getPSDepSlnASGroupId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASGRPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASGroupId_Default(pSDepSlnASGroup, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnASGroupName(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isPSDepSlnASGroupNameDirty() && !bl2 : !pSDepSlnASGroup.isPSDepSlnASGroupNameDirty()) {
            return null;
        }
        String string = pSDepSlnASGroup.getPSDepSlnASGroupName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASGRPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASGroupName_Default(pSDepSlnASGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNASGRPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnHostId(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isPSDepSlnHostIdDirty() : !pSDepSlnASGroup.isPSDepSlnHostIdDirty()) {
            return null;
        }
        String string = pSDepSlnASGroup.getPSDepSlnHostId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnHostId_Default(pSDepSlnASGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNHOSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnASGroup pSDepSlnASGroup, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnASGroup.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnASGroup.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnASGroup.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSlnASGroup, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnASGroup pSDepSlnASGroup, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnASGroup, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnASGroup pSDepSlnASGroup, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnASGroup, bl);
    }

    public Object getDataContextValue(PSDepSlnASGroup pSDepSlnASGroup, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnASGroup, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSln pSDepSln = pSDepSlnASGroup.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnASGroup pSDepSlnASGroup, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnASGroup, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ASTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ASType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLELOCALMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLocalMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEREMOTEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableRemoteMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTTPSPORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HttpsPort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCASGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCASGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCASGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCASGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASGRPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASGRPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNHOSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnHostId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNHOSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnHostName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ASType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected String onTestValueRule_EnableLocalMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableRemoteMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMODE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HttpPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HttpsPort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDCASGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCASGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCASGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCASGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDepSlnHostId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNHOSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnHostName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNHOSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnASGroup)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        super.onUpdateParent(pSDepSlnASGroup);
    }

    protected void onCopyDetails(PSDepSlnASGroup pSDepSlnASGroup, Object object) throws Exception {
        PSDepSlnASGroup pSDepSlnASGroup2 = new PSDepSlnASGroup();
        pSDepSlnASGroup2.set("PSDEPSLNASGRPID", object);
        String string = DataObject.getStringValue((Object)pSDepSlnASGroup.get("PSDEPSLNASGRPID"));
        super.onCopyDetails(pSDepSlnASGroup, object);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnASGroup pSDepSlnASGroup, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNASGROUP");
        if (!bl) {
            super.exportCurXmlModel(pSDepSlnASGroup, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDepSlnASGroup pSDepSlnASGroup, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDepSlnASGroup, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDepSlnASGroup pSDepSlnASGroup, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDepSlnASGroup, xmlNode);
    }
}

