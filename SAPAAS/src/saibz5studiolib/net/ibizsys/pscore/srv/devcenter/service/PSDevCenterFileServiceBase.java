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
package net.ibizsys.pscore.srv.devcenter.service;

import java.sql.Timestamp;
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
import net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterFileDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterFileDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFileBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFile;
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFileBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPackService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPackServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterFileServiceBase
extends PSCoreSysServiceBase<PSDevCenterFile> {
    private static final Log log = LogFactory.getLog(PSDevCenterFileServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCFOLDERSIZE = "CALCFOLDERSIZE";
    private PSDevCenterFileDEModel pSDevCenterFileDEModel;
    private PSDevCenterFileDAO pSDevCenterFileDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService";
    }

    public PSDevCenterFileDEModel getPSDevCenterFileDEModel() {
        if (this.pSDevCenterFileDEModel == null) {
            try {
                this.pSDevCenterFileDEModel = (PSDevCenterFileDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDevCenterFileDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterFileDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevCenterFileDEModel();
    }

    public PSDevCenterFileDAO getPSDevCenterFileDAO() {
        if (this.pSDevCenterFileDAO == null) {
            try {
                this.pSDevCenterFileDAO = (PSDevCenterFileDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDevCenterFileDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevCenterFileDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevCenterFileDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCFOLDERSIZE, (boolean)true) == 0) {
            this.calcFolderSize((PSDevCenterFile)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public void calcFolderSize(PSDevCenterFile pSDevCenterFile) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCFOLDERSIZE, 0, (IEntity)pSDevCenterFile, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDevCenterFile, ACTION_CALCFOLDERSIZE);
        final PSDevCenterFile pSDevCenterFile2 = pSDevCenterFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevCenterFileServiceBase.this.getService(), PSDevCenterFileServiceBase.ACTION_CALCFOLDERSIZE, 40, (IEntity)pSDevCenterFile2, null).getResult() != 1) {
                    PSDevCenterFileServiceBase.this.onCalcFolderSize(pSDevCenterFile2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCFOLDERSIZE, 99, (IEntity)pSDevCenterFile, null);
        }
    }

    protected void onCalcFolderSize(PSDevCenterFile pSDevCenterFile) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CALCFOLDERSIZE]");
    }

    protected void onFillParentInfo(PSDevCenterFile pSDevCenterFile, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERFILE_PSDEVCENTERFILE_PPSDEVCENTERFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService", (SessionFactory)this.getSessionFactory());
            PSDevCenterFile pSDevCenterFile2 = (PSDevCenterFile)iService.getDEModel().createEntity();
            pSDevCenterFile2.set("PSDEVCENTERFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterFile2);
            } else {
                iService.get((IEntity)pSDevCenterFile2);
            }
            this.onFillParentInfo_PPSDevCenterFile(pSDevCenterFile, pSDevCenterFile2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERFILE_PSDEVCENTERFILE_ROOTPSDEVCENTERFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService", (SessionFactory)this.getSessionFactory());
            PSDevCenterFile pSDevCenterFile3 = (PSDevCenterFile)iService.getDEModel().createEntity();
            pSDevCenterFile3.set("PSDEVCENTERFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenterFile3);
            } else {
                iService.get((IEntity)pSDevCenterFile3);
            }
            this.onFillParentInfo_RootPSDevCenterFile(pSDevCenterFile, pSDevCenterFile3);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERFILE_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDevCenterFile, pSDevCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERFILE_PSNDFILE_PSNDFILEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSNDFileService", (SessionFactory)this.getSessionFactory());
            PSNDFile pSNDFile = (PSNDFile)iService.getDEModel().createEntity();
            pSNDFile.set("PSNDFILEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSNDFile);
            } else {
                iService.get((IEntity)pSNDFile);
            }
            this.onFillParentInfo_PSNDFile(pSDevCenterFile, pSNDFile);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVCENTERFILE_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSTaskServer);
            } else {
                iService.get((IEntity)pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSDevCenterFile, pSTaskServer);
            return;
        }
        super.onFillParentInfo((IEntity)pSDevCenterFile, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PPSDevCenterFile(PSDevCenterFile pSDevCenterFile, PSDevCenterFile pSDevCenterFile2) throws Exception {
        pSDevCenterFile.setPPSDevCenterFileId(pSDevCenterFile2.getPSDevCenterFileId());
        pSDevCenterFile.setPPSDevCenterFileName(pSDevCenterFile2.getPSDevCenterFileName());
    }

    protected void onFillParentInfo_RootPSDevCenterFile(PSDevCenterFile pSDevCenterFile, PSDevCenterFile pSDevCenterFile2) throws Exception {
        pSDevCenterFile.setRootPSDevCenterFileId(pSDevCenterFile2.getPSDevCenterFileId());
        pSDevCenterFile.setRootPSDevCenterFileName(pSDevCenterFile2.getPSDevCenterFileName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDevCenterFile pSDevCenterFile, PSDevCenter pSDevCenter) throws Exception {
        pSDevCenterFile.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevCenterFile.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillParentInfo_PSNDFile(PSDevCenterFile pSDevCenterFile, PSNDFile pSNDFile) throws Exception {
        pSDevCenterFile.setPSNDFileId(pSNDFile.getPSNDFileId());
        pSDevCenterFile.setPSNDFileName(pSNDFile.getPSNDFileName());
    }

    protected void onFillParentInfo_PSTaskServer(PSDevCenterFile pSDevCenterFile, PSTaskServer pSTaskServer) throws Exception {
        pSDevCenterFile.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSDevCenterFile.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSDevCenterFile pSDevCenterFile, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDevCenterFile, bl);
        this.onFillEntityFullInfo_PPSDevCenterFile(pSDevCenterFile, bl);
        this.onFillEntityFullInfo_RootPSDevCenterFile(pSDevCenterFile, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDevCenterFile, bl);
        this.onFillEntityFullInfo_PSNDFile(pSDevCenterFile, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSDevCenterFile, bl);
    }

    protected void onFillEntityFullInfo_PPSDevCenterFile(PSDevCenterFile pSDevCenterFile, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RootPSDevCenterFile(PSDevCenterFile pSDevCenterFile, boolean bl) throws Exception {
        if (pSDevCenterFile.isRootPSDevCenterFileIdDirty()) {
            if (pSDevCenterFile.getRootPSDevCenterFileId() != null) {
                if (pSDevCenterFile.getRootPSDevCenterFileId() == null || pSDevCenterFile.getRootPSDevCenterFileName() == null) {
                    PSDevCenterFile pSDevCenterFile2 = pSDevCenterFile.getRootPSDevCenterFile();
                    pSDevCenterFile.setRootPSDevCenterFileName(pSDevCenterFile2.getPSDevCenterFileName());
                }
            } else {
                pSDevCenterFile.setRootPSDevCenterFileName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDevCenterFile pSDevCenterFile, boolean bl) throws Exception {
        if (pSDevCenterFile.isPSDevCenterIdDirty()) {
            if (pSDevCenterFile.getPSDevCenterId() != null) {
                if (pSDevCenterFile.getPSDevCenterId() == null || pSDevCenterFile.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDevCenterFile.getPSDevCenter();
                    pSDevCenterFile.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDevCenterFile.setPSDevCenterName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSNDFile(PSDevCenterFile pSDevCenterFile, boolean bl) throws Exception {
        if (pSDevCenterFile.isPSNDFileIdDirty()) {
            if (pSDevCenterFile.getPSNDFileId() != null) {
                if (pSDevCenterFile.getPSNDFileId() == null || pSDevCenterFile.getPSNDFileName() == null) {
                    PSNDFile pSNDFile = pSDevCenterFile.getPSNDFile();
                    pSDevCenterFile.setPSNDFileName(pSNDFile.getPSNDFileName());
                }
            } else {
                pSDevCenterFile.setPSNDFileName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSDevCenterFile pSDevCenterFile, boolean bl) throws Exception {
        if (pSDevCenterFile.isPSTaskServerIdDirty()) {
            if (pSDevCenterFile.getPSTaskServerId() != null) {
                if (pSDevCenterFile.getPSTaskServerId() == null || pSDevCenterFile.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSDevCenterFile.getPSTaskServer();
                    pSDevCenterFile.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSDevCenterFile.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevCenterFile pSDevCenterFile, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDevCenterFile, bl);
    }

    public ArrayList<PSDevCenterFile> selectByPPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase) throws Exception {
        return this.selectByPPSDevCenterFile(pSDevCenterFileBase, "", -1);
    }

    public ArrayList<PSDevCenterFile> selectByPPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase, String string) throws Exception {
        return this.selectByPPSDevCenterFile(pSDevCenterFileBase, string, -1);
    }

    public ArrayList<PSDevCenterFile> selectByPPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEVCENTERFILEID", (Object)pSDevCenterFileBase.getPSDevCenterFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDevCenterFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDevCenterFileCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenterFile> selectByRootPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase) throws Exception {
        return this.selectByRootPSDevCenterFile(pSDevCenterFileBase, "", -1);
    }

    public ArrayList<PSDevCenterFile> selectByRootPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase, String string) throws Exception {
        return this.selectByRootPSDevCenterFile(pSDevCenterFileBase, string, -1);
    }

    public ArrayList<PSDevCenterFile> selectByRootPSDevCenterFile(PSDevCenterFileBase pSDevCenterFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ROOTPSDEVCENTERFILEID", (Object)pSDevCenterFileBase.getPSDevCenterFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRootPSDevCenterFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRootPSDevCenterFileCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenterFile> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDevCenterFile> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDevCenterFile> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDevCenterFile> selectByPSNDFile(PSNDFileBase pSNDFileBase) throws Exception {
        return this.selectByPSNDFile(pSNDFileBase, "", -1);
    }

    public ArrayList<PSDevCenterFile> selectByPSNDFile(PSNDFileBase pSNDFileBase, String string) throws Exception {
        return this.selectByPSNDFile(pSNDFileBase, string, -1);
    }

    public ArrayList<PSDevCenterFile> selectByPSNDFile(PSNDFileBase pSNDFileBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSNDFILEID", (Object)pSNDFileBase.getPSNDFileId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSNDFileCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSNDFileCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevCenterFile> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSDevCenterFile> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSDevCenterFile> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSTASKSERVERID", (Object)pSTaskServerBase.getPSTaskServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSTaskServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSTaskServerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByPPSDevCenterFile(pSDevCenterFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERFILE_PSDEVCENTERFILE_PPSDEVCENTERFILEID", "", iDataEntityModel.getName(), "PSDEVCENTERFILE", iDataEntityModel.getDataInfo((IEntity)pSDevCenterFile), arrayList.get(0)));
        }
    }

    public void resetPPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByPPSDevCenterFile(pSDevCenterFile);
        for (PSDevCenterFile pSDevCenterFile2 : arrayList) {
            PSDevCenterFile pSDevCenterFile3 = (PSDevCenterFile)this.getDEModel().createEntity();
            pSDevCenterFile3.setPSDevCenterFileId(pSDevCenterFile2.getPSDevCenterFileId());
            pSDevCenterFile3.setPPSDevCenterFileId(null);
            this.update(pSDevCenterFile3);
        }
    }

    public void removeByPPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        final PSDevCenterFile pSDevCenterFile2 = pSDevCenterFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterFileServiceBase.this.onBeforeRemoveByPPSDevCenterFile(pSDevCenterFile2);
                PSDevCenterFileServiceBase.this.internalRemoveByPPSDevCenterFile(pSDevCenterFile2);
                PSDevCenterFileServiceBase.this.onAfterRemoveByPPSDevCenterFile(pSDevCenterFile2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
    }

    protected void internalRemoveByPPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByPPSDevCenterFile(pSDevCenterFile);
        this.onBeforeRemoveByPPSDevCenterFile(pSDevCenterFile, arrayList);
        for (PSDevCenterFile pSDevCenterFile2 : arrayList) {
            this.remove((IEntity)pSDevCenterFile2);
        }
        this.onAfterRemoveByPPSDevCenterFile(pSDevCenterFile, arrayList);
    }

    protected void onAfterRemoveByPPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
    }

    protected void onBeforeRemoveByPPSDevCenterFile(PSDevCenterFile pSDevCenterFile, ArrayList<PSDevCenterFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDevCenterFile(PSDevCenterFile pSDevCenterFile, ArrayList<PSDevCenterFile> arrayList) throws Exception {
    }

    public void testRemoveByRootPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByRootPSDevCenterFile(pSDevCenterFile, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERFILE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenterFile);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERFILE_PSDEVCENTERFILE_ROOTPSDEVCENTERFILEID", "", iDataEntityModel.getName(), "PSDEVCENTERFILE", iDataEntityModel.getDataInfo((IEntity)pSDevCenterFile), arrayList.get(0)));
        }
    }

    public void resetRootPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByRootPSDevCenterFile(pSDevCenterFile);
        for (PSDevCenterFile pSDevCenterFile2 : arrayList) {
            PSDevCenterFile pSDevCenterFile3 = (PSDevCenterFile)this.getDEModel().createEntity();
            pSDevCenterFile3.setPSDevCenterFileId(pSDevCenterFile2.getPSDevCenterFileId());
            pSDevCenterFile3.setRootPSDevCenterFileId(null);
            this.update(pSDevCenterFile3);
        }
    }

    public void removeByRootPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        final PSDevCenterFile pSDevCenterFile2 = pSDevCenterFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterFileServiceBase.this.onBeforeRemoveByRootPSDevCenterFile(pSDevCenterFile2);
                PSDevCenterFileServiceBase.this.internalRemoveByRootPSDevCenterFile(pSDevCenterFile2);
                PSDevCenterFileServiceBase.this.onAfterRemoveByRootPSDevCenterFile(pSDevCenterFile2);
            }
        });
    }

    protected void onBeforeRemoveByRootPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
    }

    protected void internalRemoveByRootPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByRootPSDevCenterFile(pSDevCenterFile);
        this.onBeforeRemoveByRootPSDevCenterFile(pSDevCenterFile, arrayList);
        for (PSDevCenterFile pSDevCenterFile2 : arrayList) {
            this.remove((IEntity)pSDevCenterFile2);
        }
        this.onAfterRemoveByRootPSDevCenterFile(pSDevCenterFile, arrayList);
    }

    protected void onAfterRemoveByRootPSDevCenterFile(PSDevCenterFile pSDevCenterFile) throws Exception {
    }

    protected void onBeforeRemoveByRootPSDevCenterFile(PSDevCenterFile pSDevCenterFile, ArrayList<PSDevCenterFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRootPSDevCenterFile(PSDevCenterFile pSDevCenterFile, ArrayList<PSDevCenterFile> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByPSDevCenter(pSDevCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDevCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVCENTERFILE_PSDEVCENTER_PSDEVCENTERID", "", iDataEntityModel.getName(), "PSDEVCENTERFILE", iDataEntityModel.getDataInfo((IEntity)pSDevCenter), arrayList.get(0)));
        }
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDevCenterFile pSDevCenterFile : arrayList) {
            PSDevCenterFile pSDevCenterFile2 = (PSDevCenterFile)this.getDEModel().createEntity();
            pSDevCenterFile2.setPSDevCenterFileId(pSDevCenterFile.getPSDevCenterFileId());
            pSDevCenterFile2.setPSDevCenterId(null);
            this.update(pSDevCenterFile2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterFileServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDevCenterFileServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDevCenterFileServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDevCenterFile pSDevCenterFile : arrayList) {
            this.remove((IEntity)pSDevCenterFile);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevCenterFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDevCenterFile> arrayList) throws Exception {
    }

    public void testRemoveByPSNDFile(PSNDFile pSNDFile) throws Exception {
    }

    public void resetPSNDFile(PSNDFile pSNDFile) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByPSNDFile(pSNDFile);
        for (PSDevCenterFile pSDevCenterFile : arrayList) {
            PSDevCenterFile pSDevCenterFile2 = (PSDevCenterFile)this.getDEModel().createEntity();
            pSDevCenterFile2.setPSDevCenterFileId(pSDevCenterFile.getPSDevCenterFileId());
            pSDevCenterFile2.setPSNDFileId(null);
            this.update(pSDevCenterFile2);
        }
    }

    public void removeByPSNDFile(PSNDFile pSNDFile) throws Exception {
        final PSNDFile pSNDFile2 = pSNDFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterFileServiceBase.this.onBeforeRemoveByPSNDFile(pSNDFile2);
                PSDevCenterFileServiceBase.this.internalRemoveByPSNDFile(pSNDFile2);
                PSDevCenterFileServiceBase.this.onAfterRemoveByPSNDFile(pSNDFile2);
            }
        });
    }

    protected void onBeforeRemoveByPSNDFile(PSNDFile pSNDFile) throws Exception {
    }

    protected void internalRemoveByPSNDFile(PSNDFile pSNDFile) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByPSNDFile(pSNDFile);
        this.onBeforeRemoveByPSNDFile(pSNDFile, arrayList);
        for (PSDevCenterFile pSDevCenterFile : arrayList) {
            this.remove((IEntity)pSDevCenterFile);
        }
        this.onAfterRemoveByPSNDFile(pSNDFile, arrayList);
    }

    protected void onAfterRemoveByPSNDFile(PSNDFile pSNDFile) throws Exception {
    }

    protected void onBeforeRemoveByPSNDFile(PSNDFile pSNDFile, ArrayList<PSDevCenterFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSNDFile(PSNDFile pSNDFile, ArrayList<PSDevCenterFile> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSDevCenterFile pSDevCenterFile : arrayList) {
            PSDevCenterFile pSDevCenterFile2 = (PSDevCenterFile)this.getDEModel().createEntity();
            pSDevCenterFile2.setPSDevCenterFileId(pSDevCenterFile.getPSDevCenterFileId());
            pSDevCenterFile2.setPSTaskServerId(null);
            this.update(pSDevCenterFile2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterFileServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSDevCenterFileServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSDevCenterFileServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDevCenterFile> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSDevCenterFile pSDevCenterFile : arrayList) {
            this.remove((IEntity)pSDevCenterFile);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDevCenterFile> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDevCenterFile> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevCenterFile pSDevCenterFile) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDepSlnPackService)ServiceGlobal.getService(PSDepSlnPackService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSlnPackServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterFile(pSDevCenterFile);
        pSCoreSysServiceBase = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterFileServiceBase)pSCoreSysServiceBase).testRemoveByPPSDevCenterFile(pSDevCenterFile);
        pSCoreSysServiceBase = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterFileServiceBase)pSCoreSysServiceBase).testRemoveByRootPSDevCenterFile(pSDevCenterFile);
        pSCoreSysServiceBase = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevCenterFile(pSDevCenterFile);
        super.onBeforeRemove(pSDevCenterFile);
    }

    protected void replaceParentInfo(PSDevCenterFile pSDevCenterFile, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDevCenterFile, cloneSession);
        if (pSDevCenterFile.getPPSDevCenterFileId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERFILE", (Object)pSDevCenterFile.getPPSDevCenterFileId())) != null) {
            this.onFillParentInfo_PPSDevCenterFile(pSDevCenterFile, (PSDevCenterFile)iEntity);
        }
        if (pSDevCenterFile.getRootPSDevCenterFileId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERFILE", (Object)pSDevCenterFile.getRootPSDevCenterFileId())) != null) {
            this.onFillParentInfo_RootPSDevCenterFile(pSDevCenterFile, (PSDevCenterFile)iEntity);
        }
        if (pSDevCenterFile.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDevCenterFile.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDevCenterFile, (PSDevCenter)iEntity);
        }
        if (pSDevCenterFile.getPSNDFileId() != null && (iEntity = cloneSession.getEntity("PSNDFILE", (Object)pSDevCenterFile.getPSNDFileId())) != null) {
            this.onFillParentInfo_PSNDFile(pSDevCenterFile, (PSNDFile)iEntity);
        }
        if (pSDevCenterFile.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSDevCenterFile.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSDevCenterFile, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevCenterFile pSDevCenterFile, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDevCenterFile, bl);
    }

    protected void onCheckEntity(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BizTag(bl, pSDevCenterFile, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileObjSize(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FilePath(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileTag(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileTag2(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FileType(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastCalcTime(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxFileSize(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerId(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerName(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerType(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerTypeName(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevCenterFileId(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterFileId(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterFileName(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSNDFileId(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSNDFileName(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RootPSDevCenterFileId(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RootPSDevCenterFileName(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TotalFileSize(bl, pSDevCenterFile, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDevCenterFile, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BizTag(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isBizTagDirty() : !pSDevCenterFile.isBizTagDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getBizTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BizTag_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BIZTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileObjSize(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isFileObjSizeDirty() : !pSDevCenterFile.isFileObjSizeDirty()) {
            return null;
        }
        Double d = pSDevCenterFile.getFileObjSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FileObjSize_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEOBJSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FilePath(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isFilePathDirty() : !pSDevCenterFile.isFilePathDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getFilePath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FilePath_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileTag(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isFileTagDirty() : !pSDevCenterFile.isFileTagDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getFileTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileTag_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILETAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileTag2(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isFileTag2Dirty() : !pSDevCenterFile.isFileTag2Dirty()) {
            return null;
        }
        String string = pSDevCenterFile.getFileTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FileTag2_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILETAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FileType(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isFileTypeDirty() && !bl2 : !pSDevCenterFile.isFileTypeDirty()) {
            return null;
        }
        Integer n = pSDevCenterFile.getFileType();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILETYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_FileType_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LastCalcTime(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isLastCalcTimeDirty() : !pSDevCenterFile.isLastCalcTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevCenterFile.getLastCalcTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastCalcTime_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTCALCTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxFileSize(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isMaxFileSizeDirty() : !pSDevCenterFile.isMaxFileSizeDirty()) {
            return null;
        }
        Double d = pSDevCenterFile.getMaxFileSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxFileSize_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXFILESIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isMemoDirty() : !pSDevCenterFile.isMemoDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDevCenterFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_OwnerId(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isOwnerIdDirty() : !pSDevCenterFile.isOwnerIdDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getOwnerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerId_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OwnerName(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isOwnerNameDirty() : !pSDevCenterFile.isOwnerNameDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getOwnerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerName_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OwnerType(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isOwnerTypeDirty() : !pSDevCenterFile.isOwnerTypeDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getOwnerType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerType_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OwnerTypeName(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isOwnerTypeNameDirty() : !pSDevCenterFile.isOwnerTypeNameDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getOwnerTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerTypeName_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevCenterFileId(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isPPSDevCenterFileIdDirty() : !pSDevCenterFile.isPPSDevCenterFileIdDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getPPSDevCenterFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevCenterFileId_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVCENTERFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterFileId(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isPSDevCenterFileIdDirty() && !bl2 : !pSDevCenterFile.isPSDevCenterFileIdDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getPSDevCenterFileId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERFILEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterFileId_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterFileName(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isPSDevCenterFileNameDirty() && !bl2 : !pSDevCenterFile.isPSDevCenterFileNameDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getPSDevCenterFileName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERFILENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterFileName_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERFILENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isPSDevCenterIdDirty() && !bl2 : !pSDevCenterFile.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getPSDevCenterId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDevCenterFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isPSDevCenterNameDirty() && !bl2 : !pSDevCenterFile.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getPSDevCenterName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSDevCenterFile, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSNDFileId(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isPSNDFileIdDirty() : !pSDevCenterFile.isPSNDFileIdDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getPSNDFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSNDFileId_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSNDFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSNDFileName(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isPSNDFileNameDirty() : !pSDevCenterFile.isPSNDFileNameDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getPSNDFileName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSNDFileName_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSNDFILENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isPSTaskServerIdDirty() : !pSDevCenterFile.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isPSTaskServerNameDirty() : !pSDevCenterFile.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RootPSDevCenterFileId(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isRootPSDevCenterFileIdDirty() : !pSDevCenterFile.isRootPSDevCenterFileIdDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getRootPSDevCenterFileId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RootPSDevCenterFileId_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROOTPSDEVCENTERFILEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RootPSDevCenterFileName(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isRootPSDevCenterFileNameDirty() : !pSDevCenterFile.isRootPSDevCenterFileNameDirty()) {
            return null;
        }
        String string = pSDevCenterFile.getRootPSDevCenterFileName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RootPSDevCenterFileName_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROOTPSDEVCENTERFILENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TotalFileSize(boolean bl, PSDevCenterFile pSDevCenterFile, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevCenterFile.isTotalFileSizeDirty() : !pSDevCenterFile.isTotalFileSizeDirty()) {
            return null;
        }
        Double d = pSDevCenterFile.getTotalFileSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TotalFileSize_Default((IEntity)pSDevCenterFile, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOTALFILESIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevCenterFile pSDevCenterFile, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDevCenterFile, bl);
    }

    protected void onSyncIndexEntities(PSDevCenterFile pSDevCenterFile, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDevCenterFile, bl);
    }

    public Object getDataContextValue(PSDevCenterFile pSDevCenterFile, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDevCenterFile, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDevCenterFile pSDevCenterFile, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDevCenterFile, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BIZTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BizTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILEOBJSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileObjSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilePath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILETAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILETAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FileType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTCALCTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastCalcTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXFILESIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxFileSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OWNERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OwnerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OWNERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OwnerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OWNERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OwnerType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OWNERTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OwnerTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVCENTERFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevCenterFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVCENTERFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevCenterFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSNDFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSNDFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSNDFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSNDFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROOTPSDEVCENTERFILEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RootPSDevCenterFileId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROOTPSDEVCENTERFILENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RootPSDevCenterFileName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOTALFILESIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TotalFileSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BizTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BIZTAG", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_FileObjSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FilePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILEPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FileTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILETAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FileTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILETAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FileType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LastCalcTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MaxFileSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OwnerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OwnerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OwnerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERTYPE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OwnerTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERTYPENAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevCenterFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVCENTERFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSDEVCENTERFILEID", "PSDEVCENTERFILE", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevCenterFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVCENTERFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSNDFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSNDFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSNDFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSNDFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RootPSDevCenterFileId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROOTPSDEVCENTERFILEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RootPSDevCenterFileName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROOTPSDEVCENTERFILENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TotalFileSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected boolean onMergeChild(String string, String string2, PSDevCenterFile pSDevCenterFile) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDevCenterFile)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevCenterFile pSDevCenterFile) throws Exception {
        super.onUpdateParent((IEntity)pSDevCenterFile);
    }

    @Override
    protected void exportCurXmlModel(PSDevCenterFile pSDevCenterFile, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVCENTERFILE");
        if (!bl) {
            pSDevCenterFile.setCreateDate(null);
            pSDevCenterFile.setCreateMan(null);
            pSDevCenterFile.setPPSDevCenterFileName(null);
            pSDevCenterFile.setPSDevCenterFileId(null);
            pSDevCenterFile.setUpdateDate(null);
            pSDevCenterFile.setUpdateMan(null);
            super.exportCurXmlModel(pSDevCenterFile, xmlNode, bl);
        }
    }
}

