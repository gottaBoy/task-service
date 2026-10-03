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
 *  net.ibizsys.paas.service.IServicePlugin
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
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSys;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysBase;
import net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSysDAO;
import net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSysDEModel;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSys;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSysServiceBase
extends PSCoreSysServiceBase<PSDepSys> {
    private static final Log log = LogFactory.getLog(PSDepSysServiceBase.class);
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_SYNCSYSVER = "SyncSysVer";
    private PSDepSysDEModel pSDepSysDEModel;
    private PSDepSysDAO pSDepSysDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysService";
    }

    public PSDepSysDEModel getPSDepSysDEModel() {
        if (this.pSDepSysDEModel == null) {
            try {
                this.pSDepSysDEModel = (PSDepSysDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdeploy.demodel.PSDepSysDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSysDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDepSysDEModel();
    }

    public PSDepSysDAO getPSDepSysDAO() {
        if (this.pSDepSysDAO == null) {
            try {
                this.pSDepSysDAO = (PSDepSysDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdeploy.dao.PSDepSysDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDepSysDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDepSysDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_SYNCSYSVER, (boolean)true) == 0) {
            this.syncSysVer((PSDepSys)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void syncSysVer(PSDepSys pSDepSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_SYNCSYSVER, 0, pSDepSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDepSys, ACTION_SYNCSYSVER);
        final PSDepSys pSDepSys2 = pSDepSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDepSysServiceBase.this.getService(), PSDepSysServiceBase.ACTION_SYNCSYSVER, 40, pSDepSys2, null).getResult() != 1) {
                    PSDepSysServiceBase.this.onSyncSysVer(pSDepSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_SYNCSYSVER, 99, pSDepSys, null);
        }
    }

    protected void onSyncSysVer(PSDepSys pSDepSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[SyncSysVer]");
    }

    protected void onFillParentInfo(PSDepSys pSDepSys, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYS_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSDepSys, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYS_PSDEVCENTERSVN_ROPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_ROPSDevCenterSVN(pSDepSys, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYS_PSDEVCENTER_FROMPSDCID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_FromPSDC(pSDepSys, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYS_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenter);
            } else {
                iService.get(pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDepSys, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEPSYS_PSSAASSYS_PSSAASSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService", (SessionFactory)this.getSessionFactory());
            PSSaaSSys pSSaaSSys = (PSSaaSSys)iService.getDEModel().createEntity();
            pSSaaSSys.set("PSSAASSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSaaSSys);
            } else {
                iService.get(pSSaaSSys);
            }
            this.onFillParentInfo_PSSaaSSys(pSDepSys, pSSaaSSys);
            return;
        }
        super.onFillParentInfo(pSDepSys, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSDepSys pSDepSys, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDepSys.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDepSys.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_ROPSDevCenterSVN(PSDepSys pSDepSys, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDepSys.setROPSDevCenterSvnId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDepSys.setROPSDevCenterSvnName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_FromPSDC(PSDepSys pSDepSys, PSDevCenter pSDevCenter) throws Exception {
        pSDepSys.setFromPSDCId(pSDevCenter.getPSDevCenterId());
        pSDepSys.setFromPSDCName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDepSys pSDepSys, PSDevCenter pSDevCenter) throws Exception {
        pSDepSys.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDepSys.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSSaaSSys(PSDepSys pSDepSys, PSSaaSSys pSSaaSSys) throws Exception {
        pSDepSys.setPSSaaSSysId(pSSaaSSys.getPSSaaSSysId());
        pSDepSys.setPSSaaSSysName(pSSaaSSys.getPSSaaSSysName());
    }

    protected void onFillEntityFullInfo(PSDepSys pSDepSys, boolean bl) throws Exception {
        if (bl && pSDepSys.getValidFlag() == null) {
            pSDepSys.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSDepSys, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSDepSys, bl);
        this.onFillEntityFullInfo_ROPSDevCenterSVN(pSDepSys, bl);
        this.onFillEntityFullInfo_FromPSDC(pSDepSys, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDepSys, bl);
        this.onFillEntityFullInfo_PSSaaSSys(pSDepSys, bl);
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSDepSys pSDepSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ROPSDevCenterSVN(PSDepSys pSDepSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_FromPSDC(PSDepSys pSDepSys, boolean bl) throws Exception {
        if (pSDepSys.isFromPSDCIdDirty()) {
            if (pSDepSys.getFromPSDCId() != null) {
                if (pSDepSys.getFromPSDCId() == null || pSDepSys.getFromPSDCName() == null) {
                    PSDevCenter pSDevCenter = pSDepSys.getFromPSDC();
                    pSDepSys.setFromPSDCName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDepSys.setFromPSDCName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDepSys pSDepSys, boolean bl) throws Exception {
        if (pSDepSys.isPSDevCenterIdDirty()) {
            if (pSDepSys.getPSDevCenterId() != null) {
                if (pSDepSys.getPSDevCenterId() == null || pSDepSys.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDepSys.getPSDevCenter();
                    pSDepSys.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDepSys.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSaaSSys(PSDepSys pSDepSys, boolean bl) throws Exception {
        if (pSDepSys.isPSSaaSSysIdDirty()) {
            if (pSDepSys.getPSSaaSSysId() != null) {
                if (pSDepSys.getPSSaaSSysId() == null || pSDepSys.getPSSaaSSysName() == null) {
                    PSSaaSSys pSSaaSSys = pSDepSys.getPSSaaSSys();
                    pSDepSys.setPSSaaSSysName(pSSaaSSys.getPSSaaSSysName());
                }
            } else {
                pSDepSys.setPSSaaSSysName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDepSys pSDepSys, boolean bl) throws Exception {
        super.onWriteBackParent(pSDepSys, bl);
    }

    public ArrayList<PSDepSys> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDepSys> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDepSys> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSys> selectByROPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByROPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDepSys> selectByROPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByROPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDepSys> selectByROPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ROPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByROPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByROPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSys> selectByFromPSDC(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByFromPSDC(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDepSys> selectByFromPSDC(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByFromPSDC(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDepSys> selectByFromPSDC(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("FROMPSDCID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByFromPSDCCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByFromPSDCCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSys> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDepSys> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDepSys> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDepSys> selectByPSSaaSSys(PSSaaSSysBase pSSaaSSysBase) throws Exception {
        return this.selectByPSSaaSSys(pSSaaSSysBase, "", -1);
    }

    public ArrayList<PSDepSys> selectByPSSaaSSys(PSSaaSSysBase pSSaaSSysBase, String string) throws Exception {
        return this.selectByPSSaaSSys(pSSaaSSysBase, string, -1);
    }

    public ArrayList<PSDepSys> selectByPSSaaSSys(PSSaaSSysBase pSSaaSSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSAASSYSID", (Object)pSSaaSSysBase.getPSSaaSSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSaaSSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSaaSSysCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSYS_PSDEVCENTERSVN_PSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEPSYS", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSDepSys pSDepSys : arrayList) {
            PSDepSys pSDepSys2 = (PSDepSys)this.getDEModel().createEntity();
            pSDepSys2.setPSDepSysId(pSDepSys.getPSDepSysId());
            pSDepSys2.setPSDevCenterSVNId(null);
            this.update(pSDepSys2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDepSysServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDepSysServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDepSys pSDepSys : arrayList) {
            this.remove(pSDepSys);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDepSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDepSys> arrayList) throws Exception {
    }

    public void testRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByROPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSYS_PSDEVCENTERSVN_ROPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEPSYS", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByROPSDevCenterSVN(pSDevCenterSVN);
        for (PSDepSys pSDepSys : arrayList) {
            PSDepSys pSDepSys2 = (PSDepSys)this.getDEModel().createEntity();
            pSDepSys2.setPSDepSysId(pSDepSys.getPSDepSysId());
            pSDepSys2.setROPSDevCenterSvnId(null);
            this.update(pSDepSys2);
        }
    }

    public void removeByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysServiceBase.this.onBeforeRemoveByROPSDevCenterSVN(pSDevCenterSVN2);
                PSDepSysServiceBase.this.internalRemoveByROPSDevCenterSVN(pSDevCenterSVN2);
                PSDepSysServiceBase.this.onAfterRemoveByROPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByROPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByROPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDepSys pSDepSys : arrayList) {
            this.remove(pSDepSys);
        }
        this.onAfterRemoveByROPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDepSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByROPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDepSys> arrayList) throws Exception {
    }

    public void testRemoveByFromPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetFromPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByFromPSDC(pSDevCenter);
        for (PSDepSys pSDepSys : arrayList) {
            PSDepSys pSDepSys2 = (PSDepSys)this.getDEModel().createEntity();
            pSDepSys2.setPSDepSysId(pSDepSys.getPSDepSysId());
            pSDepSys2.setFromPSDCId(null);
            this.update(pSDepSys2);
        }
    }

    public void removeByFromPSDC(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysServiceBase.this.onBeforeRemoveByFromPSDC(pSDevCenter2);
                PSDepSysServiceBase.this.internalRemoveByFromPSDC(pSDevCenter2);
                PSDepSysServiceBase.this.onAfterRemoveByFromPSDC(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByFromPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByFromPSDC(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByFromPSDC(pSDevCenter);
        this.onBeforeRemoveByFromPSDC(pSDevCenter, arrayList);
        for (PSDepSys pSDepSys : arrayList) {
            this.remove(pSDepSys);
        }
        this.onAfterRemoveByFromPSDC(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByFromPSDC(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByFromPSDC(PSDevCenter pSDevCenter, ArrayList<PSDepSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByFromPSDC(PSDevCenter pSDevCenter, ArrayList<PSDepSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEPSYS_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDEPSYS", iDataEntityModel.getDataInfo(pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDepSys pSDepSys : arrayList) {
            PSDepSys pSDepSys2 = (PSDepSys)this.getDEModel().createEntity();
            pSDepSys2.setPSDepSysId(pSDepSys.getPSDepSysId());
            pSDepSys2.setPSDevCenterId(null);
            this.update(pSDepSys2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDepSysServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDepSysServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDepSys pSDepSys : arrayList) {
            this.remove(pSDepSys);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDepSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDepSys> arrayList) throws Exception {
    }

    public void testRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
    }

    public void resetPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByPSSaaSSys(pSSaaSSys);
        for (PSDepSys pSDepSys : arrayList) {
            PSDepSys pSDepSys2 = (PSDepSys)this.getDEModel().createEntity();
            pSDepSys2.setPSDepSysId(pSDepSys.getPSDepSysId());
            pSDepSys2.setPSSaaSSysId(null);
            this.update(pSDepSys2);
        }
    }

    public void removeByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
        final PSSaaSSys pSSaaSSys2 = pSSaaSSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDepSysServiceBase.this.onBeforeRemoveByPSSaaSSys(pSSaaSSys2);
                PSDepSysServiceBase.this.internalRemoveByPSSaaSSys(pSSaaSSys2);
                PSDepSysServiceBase.this.onAfterRemoveByPSSaaSSys(pSSaaSSys2);
            }
        });
    }

    protected void onBeforeRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
    }

    protected void internalRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
        ArrayList<PSDepSys> arrayList = this.selectByPSSaaSSys(pSSaaSSys);
        this.onBeforeRemoveByPSSaaSSys(pSSaaSSys, arrayList);
        for (PSDepSys pSDepSys : arrayList) {
            this.remove(pSDepSys);
        }
        this.onAfterRemoveByPSSaaSSys(pSSaaSSys, arrayList);
    }

    protected void onAfterRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys) throws Exception {
    }

    protected void onBeforeRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys, ArrayList<PSDepSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSaaSSys(PSSaaSSys pSSaaSSys, ArrayList<PSDepSys> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDepSys pSDepSys) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSys(pSDepSys);
        pSCoreSysServiceBase = (PSDepSysVerService)ServiceGlobal.getService(PSDepSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDepSys(pSDepSys);
        super.onBeforeRemove(pSDepSys);
    }

    protected void replaceParentInfo(PSDepSys pSDepSys, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDepSys, cloneSession);
        if (pSDepSys.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDepSys.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSDepSys, (PSDevCenterSVN)iEntity);
        }
        if (pSDepSys.getROPSDevCenterSvnId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDepSys.getROPSDevCenterSvnId())) != null) {
            this.onFillParentInfo_ROPSDevCenterSVN(pSDepSys, (PSDevCenterSVN)iEntity);
        }
        if (pSDepSys.getFromPSDCId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDepSys.getFromPSDCId())) != null) {
            this.onFillParentInfo_FromPSDC(pSDepSys, (PSDevCenter)iEntity);
        }
        if (pSDepSys.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDepSys.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDepSys, (PSDevCenter)iEntity);
        }
        if (pSDepSys.getPSSaaSSysId() != null && (iEntity = cloneSession.getEntity("PSSAASSYS", (Object)pSDepSys.getPSSaaSSysId())) != null) {
            this.onFillParentInfo_PSSaaSSys(pSDepSys, (PSSaaSSys)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDepSys pSDepSys, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDepSys, bl);
    }

    protected void onCheckEntity(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDepSys, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FromPSDCId(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FromPSDCName(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysId(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysName(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDepSysType(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysId(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSaaSSysName(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROPSDevCenterSvnId(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTag(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTag2(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTag3(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTag4(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDepSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDepSys, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isCodeNameDirty() : !pSDepSys.isCodeNameDirty()) {
            return null;
        }
        String string = pSDepSys.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FromPSDCId(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isFromPSDCIdDirty() : !pSDepSys.isFromPSDCIdDirty()) {
            return null;
        }
        String string = pSDepSys.getFromPSDCId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FromPSDCId_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMPSDCID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FromPSDCName(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isFromPSDCNameDirty() : !pSDepSys.isFromPSDCNameDirty()) {
            return null;
        }
        String string = pSDepSys.getFromPSDCName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FromPSDCName_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROMPSDCNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isMemoDirty() : !pSDepSys.isMemoDirty()) {
            return null;
        }
        String string = pSDepSys.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDepSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDepSysId(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isPSDepSysIdDirty() && !bl2 : !pSDepSys.isPSDepSysIdDirty()) {
            return null;
        }
        String string = pSDepSys.getPSDepSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysId_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysName(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isPSDepSysNameDirty() && !bl2 : !pSDepSys.isPSDepSysNameDirty()) {
            return null;
        }
        String string = pSDepSys.getPSDepSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysName_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDepSysType(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isPSDepSysTypeDirty() && !bl2 : !pSDepSys.isPSDepSysTypeDirty()) {
            return null;
        }
        String string = pSDepSys.getPSDepSysType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDepSysType_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPSYSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isPSDevCenterIdDirty() && !bl2 : !pSDepSys.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDepSys.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isPSDevCenterNameDirty() && !bl2 : !pSDepSys.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDepSys.getPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isPSDevCenterSVNIdDirty() : !pSDepSys.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDepSys.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysId(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isPSSaaSSysIdDirty() : !pSDepSys.isPSSaaSSysIdDirty()) {
            return null;
        }
        String string = pSDepSys.getPSSaaSSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysId_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSaaSSysName(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isPSSaaSSysNameDirty() : !pSDepSys.isPSSaaSSysNameDirty()) {
            return null;
        }
        String string = pSDepSys.getPSSaaSSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSaaSSysName_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSAASSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ROPSDevCenterSvnId(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isROPSDevCenterSvnIdDirty() : !pSDepSys.isROPSDevCenterSvnIdDirty()) {
            return null;
        }
        String string = pSDepSys.getROPSDevCenterSvnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROPSDevCenterSvnId_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysTag(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isSysTagDirty() : !pSDepSys.isSysTagDirty()) {
            return null;
        }
        String string = pSDepSys.getSysTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysTag_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysTag2(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isSysTag2Dirty() : !pSDepSys.isSysTag2Dirty()) {
            return null;
        }
        String string = pSDepSys.getSysTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysTag2_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysTag3(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isSysTag3Dirty() : !pSDepSys.isSysTag3Dirty()) {
            return null;
        }
        String string = pSDepSys.getSysTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysTag3_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysTag4(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isSysTag4Dirty() : !pSDepSys.isSysTag4Dirty()) {
            return null;
        }
        String string = pSDepSys.getSysTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysTag4_Default(pSDepSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isUserCatDirty() : !pSDepSys.isUserCatDirty()) {
            return null;
        }
        String string = pSDepSys.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDepSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isUserTagDirty() : !pSDepSys.isUserTagDirty()) {
            return null;
        }
        String string = pSDepSys.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDepSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isUserTag2Dirty() : !pSDepSys.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDepSys.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDepSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isUserTag3Dirty() : !pSDepSys.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDepSys.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDepSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isUserTag4Dirty() : !pSDepSys.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDepSys.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDepSys, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDepSys pSDepSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDepSys.isValidFlagDirty() : !pSDepSys.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDepSys.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDepSys, bl2, bl3);
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

    protected void onSyncEntity(PSDepSys pSDepSys, boolean bl) throws Exception {
        super.onSyncEntity(pSDepSys, bl);
    }

    protected void onSyncIndexEntities(PSDepSys pSDepSys, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDepSys, bl);
    }

    public Object getDataContextValue(PSDepSys pSDepSys, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDepSys, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDepSys pSDepSys, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDepSys, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMPSDCID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromPSDCId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROMPSDCNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FromPSDCName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPSYSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDepSysType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSAASSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSaaSSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSDevCenterSvnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSDevCenterSvnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTag4_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_FromPSDCId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FROMPSDCID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FromPSDCName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FROMPSDCNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDepSysType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPSYSTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSaaSSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSAASSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROPSDevCenterSvnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROPSDevCenterSvnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDepSys pSDepSys) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDepSys)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDepSys pSDepSys) throws Exception {
        super.onUpdateParent(pSDepSys);
    }

    @Override
    protected void exportCurXmlModel(PSDepSys pSDepSys, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEPSYS");
        if (!bl) {
            pSDepSys.setCodeName(null);
            pSDepSys.setCreateDate(null);
            pSDepSys.setCreateMan(null);
            pSDepSys.setPSDepSysId(null);
            pSDepSys.setPSDepSysType(null);
            pSDepSys.setPSDevCenterSVNName(null);
            pSDepSys.setROPSDevCenterSvnName(null);
            pSDepSys.setUpdateDate(null);
            pSDepSys.setUpdateMan(null);
            super.exportCurXmlModel(pSDepSys, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSDepSys pSDepSys) throws Exception {
        return pSDepSys.getPSDepSysType();
    }
}

