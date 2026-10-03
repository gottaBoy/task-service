/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Pub.IPSSFSysCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSDBPublishContextImpl;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Core.Pub.PSSysSFPubImpl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSAppDEView;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEDataQuery;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSSysApp;
import SA.SRFDA.PS.Data.PSSysSFPub;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDataEntityDataCtrl
extends PSModelDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDataEntityDataCtrl.class);
    public static final String CUSTOMCALL_PUBLISHDB = "PUBLISHDB";
    public static final String CUSTOMCALL_PUBLISHDB2 = "PUBLISHDB2";
    public static final String CUSTOMCALL_GENERATECODE = "GENERATECODE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSDataEntity psDataEntity = new PSDataEntity();
            psDataEntity.proxy(dataEntity);
            String strPSDATAENTITYNAME = psDataEntity.getPSDATAENTITYNAME().toUpperCase();
            psDataEntity.setPSDATAENTITYNAME(strPSDATAENTITYNAME);
            psDataEntity.setPSDATAENTITYID(Helper.GenUniqueId((String)psDataEntity.getPSSYSTEMID(), (String)strPSDATAENTITYNAME));
            if (psDataEntity.getSYSTEMFLAG()) {
                if (psDataEntity.isTABLENAMENull()) {
                    psDataEntity.setTABLENAME(StringHelper.Format((String)"st_%1$s", (Object)strPSDATAENTITYNAME));
                }
                if (psDataEntity.isVIEWNAMENull()) {
                    psDataEntity.setVIEWNAME(StringHelper.Format((String)"sv_%1$s", (Object)strPSDATAENTITYNAME));
                }
            } else {
                if (psDataEntity.isTABLENAMENull()) {
                    psDataEntity.setTABLENAME(StringHelper.Format((String)"t_%1$s", (Object)strPSDATAENTITYNAME));
                }
                if (psDataEntity.isVIEWNAMENull()) {
                    psDataEntity.setVIEWNAME(StringHelper.Format((String)"v_%1$s", (Object)strPSDATAENTITYNAME));
                }
            }
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSDataEntity psDataEntity = new PSDataEntity();
            psDataEntity.proxy(dataEntity);
        }
        return callResult;
    }

    protected CallResult OnBeforeRemove(String strActionMode, BaseDataEntity dataEntity) {
        return super.OnBeforeRemove(strActionMode, dataEntity);
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        return super.OnAfterRemoveOK(strActionMode, dataEntity);
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSSystemId = dataEntity.getParamStringValue("PSSYSTEMID", "");
        String strPSDataEntityName = dataEntity.getParamStringValue("PSDATAENTITYNAME", "");
        IPSSystem ipsSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        ipsSystem.resetPSDataEntity(strPSDataEntityName);
        ipsSystem.getPSDataEntity(strPSDataEntityName, false);
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PUBLISHDB, (boolean)true) == 0) {
            return this.publishDBModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PUBLISHDB2, (boolean)true) == 0) {
            return this.publishDBModel2(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GENERATECODE, (boolean)true) == 0) {
            return this.generateCode(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult publishDBModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            PSDataEntity psDataEntity = new PSDataEntity();
            psDataEntity.proxy(dataEntity);
            this.onPublishDBModel(psDataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u6570\u636e\u5e93\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onPublishDBModel(PSDataEntity psDataEntity) throws Exception {
        String strPSSystemId = psDataEntity.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl((IDEDataCtrl)this);
        Iterator<String> dbTypes = iPSSystem.getSupportDBTypes();
        while (dbTypes.hasNext()) {
            IPSDataEntity iPSDataEntity;
            IPSDEDBConfig iPSDEDBConfig;
            String strDBType = dbTypes.next();
            IPSSystemDBConfig iPSSystemDBConfig = iPSSystem.getPSSystemDBConfig(strDBType);
            IPSDBDevInst iPSDBDevInst = null;
            if (!StringHelper.IsNullOrEmpty((String)iPSSystemDBConfig.getPSDBDevInstId())) {
                iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSSystemDBConfig.getPSDBDevInstId());
            }
            if (!(iPSDEDBConfig = (iPSDataEntity = iPSSystem.getPSDataEntity(psDataEntity.getPSDATAENTITYNAME(), true)).getPSDEDBConfig(strDBType)).isValidFlag() || !iPSDEDBConfig.isPubModel()) continue;
            iPSDEDBConfig.publishDBModel(psPublishContextImpl, iPSDBDevInst);
        }
        log.info((Object)StringHelper.Format((String)"\u53d1\u5e03\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psDataEntity.getPSDATAENTITYNAME()));
    }

    public CallResult publishDBModel2(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            PSDataEntity psDataEntity = new PSDataEntity();
            psDataEntity.proxy(dataEntity);
            this.onPublishDBModel2(psDataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u6570\u636e\u5e93\u6a21\u578b2\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onPublishDBModel2(PSDataEntity psDataEntity) throws Exception {
        String strPSSystemId = psDataEntity.getPSSYSTEMID();
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        Iterator<String> dbTypes = iPSSystem.getSupportDBTypes();
        while (dbTypes.hasNext()) {
            IPSDataEntity iPSDataEntity;
            IPSDEDBConfig iPSDEDBConfig;
            String strDBType = dbTypes.next();
            PSDBPublishContextImpl psPublishContextImpl = new PSDBPublishContextImpl((IDEDataCtrl)this);
            IPSSystemDBConfig iPSSystemDBConfig = iPSSystem.getPSSystemDBConfig(strDBType);
            psPublishContextImpl.setPSSystemDBConfig(iPSSystemDBConfig);
            IPSDBDevInst iPSDBDevInst = null;
            if (!StringHelper.IsNullOrEmpty((String)iPSSystemDBConfig.getPSDBDevInstId())) {
                iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSSystemDBConfig.getPSDBDevInstId());
            }
            if (!(iPSDEDBConfig = (iPSDataEntity = iPSSystem.getPSDataEntity(psDataEntity.getPSDATAENTITYNAME(), true)).getPSDEDBConfig(strDBType)).isValidFlag() || !iPSDEDBConfig.isPubModel()) continue;
            iPSDataEntity.getPSDEDBConfig(strDBType).publishDBModel2(psPublishContextImpl, iPSDBDevInst);
        }
        log.info((Object)StringHelper.Format((String)"\u53d1\u5e03\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b2", (Object)psDataEntity.getPSDATAENTITYNAME()));
        Vector<PSDEDataQuery> psDEDataQueryList = new Vector<PSDEDataQuery>();
        IDEDataCtrl psDEDataQueryDataCtrl = this.GetRelatedDataCtrl("DE2057");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDEID", (Object)psDataEntity.getPSDATAENTITYID());
        CallResult callResult = psDEDataQueryDataCtrl.Select(cond, psDEDataQueryList, PSDEDataQuery.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5b9e\u4f53\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEDataQuery psDEDataQuery : psDEDataQueryList) {
            psDEDataQueryDataCtrl.CustomCall(CUSTOMCALL_GENERATECODE, (BaseDataEntity)psDEDataQuery);
        }
    }

    public CallResult generateCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDataEntity psDataEntity = new PSDataEntity();
            psDataEntity.proxy(dataEntity);
            IPSSystem ipsSystem = this.getPSModelStorage().getPSSystem(psDataEntity.getPSSYSTEMID());
            ipsSystem.resetPSDataEntity(psDataEntity.getPSDATAENTITYNAME());
            ipsSystem.getPSDataEntity(psDataEntity.getPSDATAENTITYNAME(), false);
            this.onGenerateDEAppCode(psDataEntity);
            this.onGenerateDESysCode(psDataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u5b9e\u4f53\u5e94\u7528\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGenerateDEAppCode(PSDataEntity psDataEntity) throws Exception {
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSYSTEMID", (Object)psDataEntity.getPSSYSTEMID());
        cond.setParamValue("DEFAULTPUB", (Object)1);
        IDEDataCtrl psAppViewDataCtrl = this.GetRelatedDataCtrl("DE2506");
        IDEDataCtrl psSysAppDataCtrl = this.GetRelatedDataCtrl("DE2500");
        Vector<PSSysApp> psSysAppList = new Vector<PSSysApp>();
        CallResult callResult = psSysAppDataCtrl.Select(cond, psSysAppList, PSSysApp.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u9ed8\u8ba4\u5e94\u7528\u53d1\u5e03\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSAppDEView> psAppDEViewList = new Vector<PSAppDEView>();
        String strSQL = "select t1.* from v_srfpsappdeview t1 inner join T_SRFPSDEVIEWBASE t2 on t1.PSDEVIEWBASEID = t2.PSDEVIEWBASEID where t2.PSDEID=? and t1.PSSYSAPPID=?";
        for (PSSysApp psSysApp : psSysAppList) {
            CallParamList callParamList = new CallParamList();
            callParamList.Add((Object)psDataEntity.getPSDATAENTITYID());
            callParamList.Add((Object)psSysApp.getPSSYSAPPID());
            psAppDEViewList.clear();
            callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getGlobalHelper(), (Connection)this.getConnection(), (String)"", (String)strSQL, (Vector)callParamList.GetList(), psAppDEViewList, (String)PSAppDEView.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (psAppDEViewList.size() == 0) continue;
            IPSApplication iPSApplication = this.getPSModelStorage().getPSSystem(psDataEntity.getPSSYSTEMID()).getPSApplication(psSysApp.getPSSYSAPPID());
            for (PSAppDEView psAppDEView : psAppDEViewList) {
                iPSApplication.resetPSAppView(psAppDEView.getPSAPPDEVIEWID());
            }
            for (PSAppDEView psAppDEView : psAppDEViewList) {
                PSAppView psAppView = new PSAppView();
                psAppView.setPSAPPVIEWID(psAppDEView.getPSAPPDEVIEWID());
                callResult = psAppViewDataCtrl.CustomCall(CUSTOMCALL_GENERATECODE, (BaseDataEntity)psAppView);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5e94\u7528\u89c6\u56fe\u751f\u6210\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
    }

    protected void onGenerateDESysCode(PSDataEntity psDataEntity) throws Exception {
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSYSTEMID", (Object)psDataEntity.getPSSYSTEMID());
        cond.setParamValue("DEFAULTPUB", (Object)1);
        IDEDataCtrl psAppViewDataCtrl = this.GetRelatedDataCtrl("DE2506");
        IDEDataCtrl psSysSFPubDataCtrl = this.GetRelatedDataCtrl("DE2800");
        Vector<PSSysSFPub> psSysSFPubList = new Vector<PSSysSFPub>();
        CallResult callResult = psSysSFPubDataCtrl.Select(cond, psSysSFPubList, PSSysSFPub.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u9ed8\u8ba4\u670d\u52a1\u53d1\u5e03\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysSFPub psSysSFPub : psSysSFPubList) {
            this.onGenerateSysCode(psSysSFPub, psDataEntity);
        }
    }

    protected void onGenerateSysCode(PSSysSFPub psSysSFPub, PSDataEntity psDataEntity) throws Exception {
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(psSysSFPub.getPSSYSTEMID());
        PSSysSFPubImpl psSysSFPubImpl = new PSSysSFPubImpl();
        psSysSFPubImpl.init(this.getGlobalHelper(), iPSSystem, psSysSFPub);
        IPSSFStyle iPSSFStyle = this.getPSModelStorage().getPSSF(iPSSystem.getSFType()).getPSSFStyle(psSysSFPubImpl.getSFStyle());
        Iterator<IPSSFCodeFolder> psSFCodeFolders = iPSSFStyle.getPSSFCodeFolders();
        while (psSFCodeFolders.hasNext()) {
            IPSSFCodeFolder iPSSFCodeFolder = psSFCodeFolders.next();
            Iterator<IPSSFCodeType> psSFCodeTypes = iPSSFCodeFolder.getPSSFCodeTypes();
            while (psSFCodeTypes.hasNext()) {
                IPSSFCodeType iPSSFCodeType = psSFCodeTypes.next();
                PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl((IDEDataCtrl)this);
                psPublishContextImpl.setUserTag("DEFILTER", psDataEntity.getPSDATAENTITYID());
                IPSSFSysCodePublisher iPSSFSysCodePublisher = iPSSFCodeType.getPSSFSysCodePublisher();
                iPSSFSysCodePublisher.generateCode(psPublishContextImpl, psSysSFPubImpl);
                iPSSFSysCodePublisher.close();
            }
        }
    }
}
