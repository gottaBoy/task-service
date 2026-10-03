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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysASDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysASDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnAS;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASGroup;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnASGroupBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysAS;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysApp;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysAppBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysASServiceBase
extends PSCoreSysServiceBase<PSDepSlnSysAS> {
    private static final Log log = LogFactory.getLog(PSDepSlnSysASServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDepSlnSysASDEModel pSDepSlnSysASDEModel;
    private PSDepSlnSysASDAO pSDepSlnSysASDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysASService";
    }

    public PSDepSlnSysASDEModel getPSDepSlnSysASDEModel() {
        if (this.pSDepSlnSysASDEModel == null) {
            try {
                this.pSDepSlnSysASDEModel = (PSDepSlnSysASDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSlnSysASDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysASDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSlnSysASDEModel();
    }

    public PSDepSlnSysASDAO getPSDepSlnSysASDAO() {
        if (this.pSDepSlnSysASDAO == null) {
            try {
                this.pSDepSlnSysASDAO = (PSDepSlnSysASDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSlnSysASDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSlnSysASDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSlnSysASDAO();
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

    protected void onFillParentInfo(PSDepSlnSysAS pSDepSlnSysAS, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSAS_PSDEPSLNASGRP_PSDEPSLNASGRPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASGroupService", (SessionFactory)this.getSessionFactory());
            PSDepSlnASGroup pSDepSlnASGroup = (PSDepSlnASGroup)iService.getDEModel().createEntity();
            pSDepSlnASGroup.set("PSDEPSLNASGRPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnASGroup);
            } else {
                iService.get(pSDepSlnASGroup);
            }
            this.onFillParentInfo_PSDepSlnASGrp(pSDepSlnSysAS, pSDepSlnASGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSAS_PSDEPSLNAS_PSDEPSLNASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnASService", (SessionFactory)this.getSessionFactory());
            PSDepSlnAS pSDepSlnAS = (PSDepSlnAS)iService.getDEModel().createEntity();
            pSDepSlnAS.set("PSDEPSLNASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnAS);
            } else {
                iService.get(pSDepSlnAS);
            }
            this.onFillParentInfo_PSDepSlnAS(pSDepSlnSysAS, pSDepSlnAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSAS_PSDEPSLNSYS_PSDEPSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDepSlnSys pSDepSlnSys = (PSDepSlnSys)iService.getDEModel().createEntity();
            pSDepSlnSys.set("PSDEPSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSlnSys);
            } else {
                iService.get(pSDepSlnSys);
            }
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysAS, pSDepSlnSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSAS_PSDEPSLN_PSDEPSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService", (SessionFactory)this.getSessionFactory());
            PSDepSln pSDepSln = (PSDepSln)iService.getDEModel().createEntity();
            pSDepSln.set("PSDEPSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSln);
            } else {
                iService.get(pSDepSln);
            }
            this.onFillParentInfo_PSDepSln(pSDepSlnSysAS, pSDepSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSAS_PSDEPSYSAPP_NO2PSDEPSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppService", (SessionFactory)this.getSessionFactory());
            PSDepSysApp pSDepSysApp = (PSDepSysApp)iService.getDEModel().createEntity();
            pSDepSysApp.set("PSDEPSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSysApp);
            } else {
                iService.get(pSDepSysApp);
            }
            this.onFillParentInfo_No2PSDepSysApp(pSDepSlnSysAS, pSDepSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSLNSYSAS_PSDEPSYSAPP_PSDEPSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysAppService", (SessionFactory)this.getSessionFactory());
            PSDepSysApp pSDepSysApp = (PSDepSysApp)iService.getDEModel().createEntity();
            pSDepSysApp.set("PSDEPSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDepSysApp);
            } else {
                iService.get(pSDepSysApp);
            }
            this.onFillParentInfo_PSDepSysApp(pSDepSlnSysAS, pSDepSysApp);
            return;
        }
        super.onFillParentInfo(pSDepSlnSysAS, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDepSlnASGrp(PSDepSlnSysAS pSDepSlnSysAS, PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        pSDepSlnSysAS.setPSDepSlnASGroupId(pSDepSlnASGroup.getPSDepSlnASGroupId());
        pSDepSlnSysAS.setPSDepSlnASGroupName(pSDepSlnASGroup.getPSDepSlnASGroupName());
    }

    protected void onFillParentInfo_PSDepSlnAS(PSDepSlnSysAS pSDepSlnSysAS, PSDepSlnAS pSDepSlnAS) throws Exception {
        pSDepSlnSysAS.setPSDepSlnASId(pSDepSlnAS.getPSDepSlnASId());
        pSDepSlnSysAS.setPSDepSlnASName(pSDepSlnAS.getPSDepSlnASName());
    }

    protected void onFillParentInfo_PSDepSlnSys(PSDepSlnSysAS pSDepSlnSysAS, PSDepSlnSys pSDepSlnSys) throws Exception {
        pSDepSlnSysAS.setPSDepSlnSysId(pSDepSlnSys.getPSDepSlnSysId());
        pSDepSlnSysAS.setPSDepSlnSysName(pSDepSlnSys.getPSDepSlnSysName());
        if (pSDepSlnSys.getPSDepSln() != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnSysAS, pSDepSlnSys.getPSDepSln());
        }
    }

    protected void onFillParentInfo_PSDepSln(PSDepSlnSysAS pSDepSlnSysAS, PSDepSln pSDepSln) throws Exception {
        pSDepSlnSysAS.setPSDepSlnId(pSDepSln.getPSDepSlnId());
        pSDepSlnSysAS.setPSDepSlnName(pSDepSln.getPSDepSlnName());
    }

    protected void onFillParentInfo_No2PSDepSysApp(PSDepSlnSysAS pSDepSlnSysAS, PSDepSysApp pSDepSysApp) throws Exception {
        pSDepSlnSysAS.setNo2PSDepSysAppId(pSDepSysApp.getPSDepSysAppId());
        pSDepSlnSysAS.setNo2PSDepSysAppName(pSDepSysApp.getPSDepSysAppName());
    }

    protected void onFillParentInfo_PSDepSysApp(PSDepSlnSysAS pSDepSlnSysAS, PSDepSysApp pSDepSysApp) throws Exception {
        pSDepSlnSysAS.setPSDepSysAppId(pSDepSysApp.getPSDepSysAppId());
        pSDepSlnSysAS.setPSDepSysAppName(pSDepSysApp.getPSDepSysAppName());
    }

    protected void onFillEntityFullInfo(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDepSlnSysAS, bl);
        this.onFillEntityFullInfo_PSDepSlnASGrp(pSDepSlnSysAS, bl);
        this.onFillEntityFullInfo_PSDepSlnAS(pSDepSlnSysAS, bl);
        this.onFillEntityFullInfo_PSDepSlnSys(pSDepSlnSysAS, bl);
        this.onFillEntityFullInfo_PSDepSln(pSDepSlnSysAS, bl);
        this.onFillEntityFullInfo_No2PSDepSysApp(pSDepSlnSysAS, bl);
        this.onFillEntityFullInfo_PSDepSysApp(pSDepSlnSysAS, bl);
    }

    protected void onFillEntityFullInfo_PSDepSlnASGrp(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnAS(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSlnSys(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSln(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_No2PSDepSysApp(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDepSysApp(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSlnSysAS, bl);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSlnASGrp(PSDepSlnASGroupBase pSDepSlnASGroupBase) throws Exception {
        return this.selectByPSDepSlnASGrp(pSDepSlnASGroupBase, "", -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSlnASGrp(PSDepSlnASGroupBase pSDepSlnASGroupBase, String string) throws Exception {
        return this.selectByPSDepSlnASGrp(pSDepSlnASGroupBase, string, -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSlnASGrp(PSDepSlnASGroupBase pSDepSlnASGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNASGRPID", (Object)pSDepSlnASGroupBase.getPSDepSlnASGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnASGrpCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnASGrpCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSlnAS(PSDepSlnASBase pSDepSlnASBase) throws Exception {
        return this.selectByPSDepSlnAS(pSDepSlnASBase, "", -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSlnAS(PSDepSlnASBase pSDepSlnASBase, String string) throws Exception {
        return this.selectByPSDepSlnAS(pSDepSlnASBase, string, -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSlnAS(PSDepSlnASBase pSDepSlnASBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnSysAS> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, "", -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string) throws Exception {
        return this.selectByPSDepSlnSys(pSDepSlnSysBase, string, -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSlnSys(PSDepSlnSysBase pSDepSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSLNSYSID", (Object)pSDepSlnSysBase.getPSDepSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSln(PSDepSlnBase pSDepSlnBase) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, "", -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string) throws Exception {
        return this.selectByPSDepSln(pSDepSlnBase, string, -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSln(PSDepSlnBase pSDepSlnBase, String string, int n) throws Exception {
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

    public ArrayList<PSDepSlnSysAS> selectByNo2PSDepSysApp(PSDepSysAppBase pSDepSysAppBase) throws Exception {
        return this.selectByNo2PSDepSysApp(pSDepSysAppBase, "", -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByNo2PSDepSysApp(PSDepSysAppBase pSDepSysAppBase, String string) throws Exception {
        return this.selectByNo2PSDepSysApp(pSDepSysAppBase, string, -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByNo2PSDepSysApp(PSDepSysAppBase pSDepSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDEPSYSAPPID", (Object)pSDepSysAppBase.getPSDepSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSDepSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSDepSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSysApp(PSDepSysAppBase pSDepSysAppBase) throws Exception {
        return this.selectByPSDepSysApp(pSDepSysAppBase, "", -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSysApp(PSDepSysAppBase pSDepSysAppBase, String string) throws Exception {
        return this.selectByPSDepSysApp(pSDepSysAppBase, string, -1);
    }

    public ArrayList<PSDepSlnSysAS> selectByPSDepSysApp(PSDepSysAppBase pSDepSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPSYSAPPID", (Object)pSDepSysAppBase.getPSDepSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDepSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDepSysAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDepSlnASGrp(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSlnASGrp(pSDepSlnASGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNASGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnASGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSAS_PSDEPSLNASGRP_PSDEPSLNASGRPID", "", iDataEntityModel.getName(), "PSDEPSLNSYSAS", iDataEntityModel.getDataInfo(pSDepSlnASGroup), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnASGrp(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSlnASGrp(pSDepSlnASGroup);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            PSDepSlnSysAS pSDepSlnSysAS2 = (PSDepSlnSysAS)this.getDEModel().createEntity();
            pSDepSlnSysAS2.setPSDepSlnSysASId(pSDepSlnSysAS.getPSDepSlnSysASId());
            pSDepSlnSysAS2.setPSDepSlnASGroupId(null);
            this.update(pSDepSlnSysAS2);
        }
    }

    public void removeByPSDepSlnASGrp(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        final PSDepSlnASGroup pSDepSlnASGroup2 = pSDepSlnASGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysASServiceBase.this.onBeforeRemoveByPSDepSlnASGrp(pSDepSlnASGroup2);
                PSDepSlnSysASServiceBase.this.internalRemoveByPSDepSlnASGrp(pSDepSlnASGroup2);
                PSDepSlnSysASServiceBase.this.onAfterRemoveByPSDepSlnASGrp(pSDepSlnASGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnASGrp(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
    }

    protected void internalRemoveByPSDepSlnASGrp(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSlnASGrp(pSDepSlnASGroup);
        this.onBeforeRemoveByPSDepSlnASGrp(pSDepSlnASGroup, arrayList);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            this.remove(pSDepSlnSysAS);
        }
        this.onAfterRemoveByPSDepSlnASGrp(pSDepSlnASGroup, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnASGrp(PSDepSlnASGroup pSDepSlnASGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnASGrp(PSDepSlnASGroup pSDepSlnASGroup, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnASGrp(PSDepSlnASGroup pSDepSlnASGroup, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSlnAS(pSDepSlnAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSAS_PSDEPSLNAS_PSDEPSLNASID", "", iDataEntityModel.getName(), "PSDEPSLNSYSAS", iDataEntityModel.getDataInfo(pSDepSlnAS), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSlnAS(pSDepSlnAS);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            PSDepSlnSysAS pSDepSlnSysAS2 = (PSDepSlnSysAS)this.getDEModel().createEntity();
            pSDepSlnSysAS2.setPSDepSlnSysASId(pSDepSlnSysAS.getPSDepSlnSysASId());
            pSDepSlnSysAS2.setPSDepSlnASId(null);
            this.update(pSDepSlnSysAS2);
        }
    }

    public void removeByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        final PSDepSlnAS pSDepSlnAS2 = pSDepSlnAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysASServiceBase.this.onBeforeRemoveByPSDepSlnAS(pSDepSlnAS2);
                PSDepSlnSysASServiceBase.this.internalRemoveByPSDepSlnAS(pSDepSlnAS2);
                PSDepSlnSysASServiceBase.this.onAfterRemoveByPSDepSlnAS(pSDepSlnAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
    }

    protected void internalRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSlnAS(pSDepSlnAS);
        this.onBeforeRemoveByPSDepSlnAS(pSDepSlnAS, arrayList);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            this.remove(pSDepSlnSysAS);
        }
        this.onAfterRemoveByPSDepSlnAS(pSDepSlnAS, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnAS(PSDepSlnAS pSDepSlnAS, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSAS_PSDEPSLNSYS_PSDEPSLNSYSID", "", iDataEntityModel.getName(), "PSDEPSLNSYSAS", iDataEntityModel.getDataInfo(pSDepSlnSys), arrayList.get(0)));
        }
    }

    public void resetPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            PSDepSlnSysAS pSDepSlnSysAS2 = (PSDepSlnSysAS)this.getDEModel().createEntity();
            pSDepSlnSysAS2.setPSDepSlnSysASId(pSDepSlnSysAS.getPSDepSlnSysASId());
            pSDepSlnSysAS2.setPSDepSlnSysId(null);
            this.update(pSDepSlnSysAS2);
        }
    }

    public void removeByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        final PSDepSlnSys pSDepSlnSys2 = pSDepSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysASServiceBase.this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysASServiceBase.this.internalRemoveByPSDepSlnSys(pSDepSlnSys2);
                PSDepSlnSysASServiceBase.this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void internalRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSlnSys(pSDepSlnSys);
        this.onBeforeRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            this.remove(pSDepSlnSysAS);
        }
        this.onAfterRemoveByPSDepSlnSys(pSDepSlnSys, arrayList);
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSlnSys(PSDepSlnSys pSDepSlnSys, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSln(pSDepSln, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSLN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSln);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSAS_PSDEPSLN_PSDEPSLNID", "", iDataEntityModel.getName(), "PSDEPSLNSYSAS", iDataEntityModel.getDataInfo(pSDepSln), arrayList.get(0)));
        }
    }

    public void resetPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSln(pSDepSln);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            PSDepSlnSysAS pSDepSlnSysAS2 = (PSDepSlnSysAS)this.getDEModel().createEntity();
            pSDepSlnSysAS2.setPSDepSlnSysASId(pSDepSlnSysAS.getPSDepSlnSysASId());
            pSDepSlnSysAS2.setPSDepSlnId(null);
            this.update(pSDepSlnSysAS2);
        }
    }

    public void removeByPSDepSln(PSDepSln pSDepSln) throws Exception {
        final PSDepSln pSDepSln2 = pSDepSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysASServiceBase.this.onBeforeRemoveByPSDepSln(pSDepSln2);
                PSDepSlnSysASServiceBase.this.internalRemoveByPSDepSln(pSDepSln2);
                PSDepSlnSysASServiceBase.this.onAfterRemoveByPSDepSln(pSDepSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void internalRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSln(pSDepSln);
        this.onBeforeRemoveByPSDepSln(pSDepSln, arrayList);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            this.remove(pSDepSlnSysAS);
        }
        this.onAfterRemoveByPSDepSln(pSDepSln, arrayList);
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSln(PSDepSln pSDepSln, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByNo2PSDepSysApp(pSDepSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSAS_PSDEPSYSAPP_NO2PSDEPSYSAPPID", "", iDataEntityModel.getName(), "PSDEPSLNSYSAS", iDataEntityModel.getDataInfo(pSDepSysApp), arrayList.get(0)));
        }
    }

    public void resetNo2PSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByNo2PSDepSysApp(pSDepSysApp);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            PSDepSlnSysAS pSDepSlnSysAS2 = (PSDepSlnSysAS)this.getDEModel().createEntity();
            pSDepSlnSysAS2.setPSDepSlnSysASId(pSDepSlnSysAS.getPSDepSlnSysASId());
            pSDepSlnSysAS2.setNo2PSDepSysAppId(null);
            this.update(pSDepSlnSysAS2);
        }
    }

    public void removeByNo2PSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        final PSDepSysApp pSDepSysApp2 = pSDepSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysASServiceBase.this.onBeforeRemoveByNo2PSDepSysApp(pSDepSysApp2);
                PSDepSlnSysASServiceBase.this.internalRemoveByNo2PSDepSysApp(pSDepSysApp2);
                PSDepSlnSysASServiceBase.this.onAfterRemoveByNo2PSDepSysApp(pSDepSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
    }

    protected void internalRemoveByNo2PSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByNo2PSDepSysApp(pSDepSysApp);
        this.onBeforeRemoveByNo2PSDepSysApp(pSDepSysApp, arrayList);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            this.remove(pSDepSlnSysAS);
        }
        this.onAfterRemoveByNo2PSDepSysApp(pSDepSysApp, arrayList);
    }

    protected void onAfterRemoveByNo2PSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDepSysApp(PSDepSysApp pSDepSysApp, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDepSysApp(PSDepSysApp pSDepSysApp, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    public void testRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSysApp(pSDepSysApp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPSYSAPP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDepSysApp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSLNSYSAS_PSDEPSYSAPP_PSDEPSYSAPPID", "", iDataEntityModel.getName(), "PSDEPSLNSYSAS", iDataEntityModel.getDataInfo(pSDepSysApp), arrayList.get(0)));
        }
    }

    public void resetPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSysApp(pSDepSysApp);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            PSDepSlnSysAS pSDepSlnSysAS2 = (PSDepSlnSysAS)this.getDEModel().createEntity();
            pSDepSlnSysAS2.setPSDepSlnSysASId(pSDepSlnSysAS.getPSDepSlnSysASId());
            pSDepSlnSysAS2.setPSDepSysAppId(null);
            this.update(pSDepSlnSysAS2);
        }
    }

    public void removeByPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        final PSDepSysApp pSDepSysApp2 = pSDepSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSlnSysASServiceBase.this.onBeforeRemoveByPSDepSysApp(pSDepSysApp2);
                PSDepSlnSysASServiceBase.this.internalRemoveByPSDepSysApp(pSDepSysApp2);
                PSDepSlnSysASServiceBase.this.onAfterRemoveByPSDepSysApp(pSDepSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
    }

    protected void internalRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
        ArrayList<PSDepSlnSysAS> arrayList = this.selectByPSDepSysApp(pSDepSysApp);
        this.onBeforeRemoveByPSDepSysApp(pSDepSysApp, arrayList);
        for (PSDepSlnSysAS pSDepSlnSysAS : arrayList) {
            this.remove(pSDepSlnSysAS);
        }
        this.onAfterRemoveByPSDepSysApp(pSDepSysApp, arrayList);
    }

    protected void onAfterRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDepSysApp(PSDepSysApp pSDepSysApp, ArrayList<PSDepSlnSysAS> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSlnSysAS pSDepSlnSysAS) throws Exception {
        super.onBeforeRemove(pSDepSlnSysAS);
    }

    protected void replaceParentInfo(PSDepSlnSysAS pSDepSlnSysAS, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSlnSysAS, cloneSession);
        if (pSDepSlnSysAS.getPSDepSlnASGroupId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNASGRP", (Object)pSDepSlnSysAS.getPSDepSlnASGroupId())) != null) {
            this.onFillParentInfo_PSDepSlnASGrp(pSDepSlnSysAS, (PSDepSlnASGroup)iEntity);
        }
        if (pSDepSlnSysAS.getPSDepSlnASId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNAS", (Object)pSDepSlnSysAS.getPSDepSlnASId())) != null) {
            this.onFillParentInfo_PSDepSlnAS(pSDepSlnSysAS, (PSDepSlnAS)iEntity);
        }
        if (pSDepSlnSysAS.getPSDepSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEPSLNSYS", (Object)pSDepSlnSysAS.getPSDepSlnSysId())) != null) {
            this.onFillParentInfo_PSDepSlnSys(pSDepSlnSysAS, (PSDepSlnSys)iEntity);
        }
        if (pSDepSlnSysAS.getPSDepSlnId() != null && (iEntity = cloneSession.getEntity("PSDEPSLN", (Object)pSDepSlnSysAS.getPSDepSlnId())) != null) {
            this.onFillParentInfo_PSDepSln(pSDepSlnSysAS, (PSDepSln)iEntity);
        }
        if (pSDepSlnSysAS.getNo2PSDepSysAppId() != null && (iEntity = cloneSession.getEntity("PSDEPSYSAPP", (Object)pSDepSlnSysAS.getNo2PSDepSysAppId())) != null) {
            this.onFillParentInfo_No2PSDepSysApp(pSDepSlnSysAS, (PSDepSysApp)iEntity);
        }
        if (pSDepSlnSysAS.getPSDepSysAppId() != null && (iEntity = cloneSession.getEntity("PSDEPSYSAPP", (Object)pSDepSlnSysAS.getPSDepSysAppId())) != null) {
            this.onFillParentInfo_PSDepSysApp(pSDepSlnSysAS, (PSDepSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSlnSysAS, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ContainerType(bl, pSDepSlnSysAS, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSlnSysAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDepSysAppId(bl, pSDepSlnSysAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASGroupId(bl, pSDepSlnSysAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnASId(bl, pSDepSlnSysAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnId(bl, pSDepSlnSysAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysASId(bl, pSDepSlnSysAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysASName(bl, pSDepSlnSysAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSlnSysId(bl, pSDepSlnSysAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysAppId(bl, pSDepSlnSysAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceContainer(bl, pSDepSlnSysAS, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSlnSysAS, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ContainerType(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isContainerTypeDirty() && !bl2 : !pSDepSlnSysAS.isContainerTypeDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getContainerType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTAINERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContainerType_Default(pSDepSlnSysAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTAINERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isMemoDirty() : !pSDepSlnSysAS.isMemoDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSlnSysAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_No2PSDepSysAppId(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isNo2PSDepSysAppIdDirty() : !pSDepSlnSysAS.isNo2PSDepSysAppIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getNo2PSDepSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDepSysAppId_Default(pSDepSlnSysAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEPSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnASGroupId(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isPSDepSlnASGroupIdDirty() : !pSDepSlnSysAS.isPSDepSlnASGroupIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getPSDepSlnASGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASGroupId_Default(pSDepSlnSysAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnASId(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isPSDepSlnASIdDirty() : !pSDepSlnSysAS.isPSDepSlnASIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getPSDepSlnASId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnASId_Default(pSDepSlnSysAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnId(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isPSDepSlnIdDirty() && !bl2 : !pSDepSlnSysAS.isPSDepSlnIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getPSDepSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnId_Default(pSDepSlnSysAS, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSlnSysASId(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isPSDepSlnSysASIdDirty() && !bl2 : !pSDepSlnSysAS.isPSDepSlnSysASIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getPSDepSlnSysASId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSASID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysASId_Default(pSDepSlnSysAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysASName(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isPSDepSlnSysASNameDirty() && !bl2 : !pSDepSlnSysAS.isPSDepSlnSysASNameDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getPSDepSlnSysASName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSASNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysASName_Default(pSDepSlnSysAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSASNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSlnSysId(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isPSDepSlnSysIdDirty() && !bl2 : !pSDepSlnSysAS.isPSDepSlnSysIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getPSDepSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSlnSysId_Default(pSDepSlnSysAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysAppId(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isPSDepSysAppIdDirty() : !pSDepSlnSysAS.isPSDepSysAppIdDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getPSDepSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysAppId_Default(pSDepSlnSysAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceContainer(boolean bl, PSDepSlnSysAS pSDepSlnSysAS, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSlnSysAS.isServiceContainerDirty() : !pSDepSlnSysAS.isServiceContainerDirty()) {
            return null;
        }
        String string = pSDepSlnSysAS.getServiceContainer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceContainer_Default(pSDepSlnSysAS, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICECONTAINER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSlnSysAS, bl);
    }

    protected void onSyncIndexEntities(PSDepSlnSysAS pSDepSlnSysAS, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSlnSysAS, bl);
    }

    public Object getDataContextValue(PSDepSlnSysAS pSDepSlnSysAS, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSlnSysAS, string, iDataContextParam)) != null) {
            return object;
        }
        PSDepSln pSDepSln = pSDepSlnSysAS.getPSDepSln();
        if (pSDepSln != null && pSDepSln.contains(string)) {
            return pSDepSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSlnSysAS pSDepSlnSysAS, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSlnSysAS, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTAINERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContainerType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"NO2PSDEPSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDepSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEPSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDepSysAppName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEPSLNASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECONTAINER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceContainer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ContainerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTAINERTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDepSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if ((this.checkFieldSimpleRule("NO2PSDEPSYSAPPID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldSimpleRule("NO2PSDEPSYSAPPID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "PSDEPSYSAPPID", "", true)) && this.checkFieldStringLengthRule("NO2PSDEPSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDepSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEPSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDepSlnSysASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSLNSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceContainer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICECONTAINER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected boolean onMergeChild(String string, String string2, PSDepSlnSysAS pSDepSlnSysAS) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSlnSysAS)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSlnSysAS pSDepSlnSysAS) throws Exception {
        super.onUpdateParent(pSDepSlnSysAS);
    }

    @Override
    protected void exportCurXmlModel(PSDepSlnSysAS pSDepSlnSysAS, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSLNSYSAS");
        if (!bl) {
            pSDepSlnSysAS.setCreateDate(null);
            pSDepSlnSysAS.setCreateMan(null);
            pSDepSlnSysAS.setPSDepSlnSysASId(null);
            pSDepSlnSysAS.setUpdateDate(null);
            pSDepSlnSysAS.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSlnSysAS, xmlNode, bl);
        }
    }
}

