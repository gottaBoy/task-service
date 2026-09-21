/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.config.entity.PSSFStyleVer
 *  net.ibizsys.pscore.srv.config.service.PSSFStyleVerService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSDCBKTask;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.PS.Data.PSSFStyleCode;
import SA.SRFDA.PS.Data.PSSFStyleVer;
import SA.SRFDA.PS.Data.PSSFVerCode;
import SA.SRFDA.PS.Data.PSSFVerCodeItem;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStyleVerDataCtrl
extends PSSFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSSFStyleVerDataCtrl.class);
    public static final String CUSTOMCALL_MERGECODE = "MERGECODE";
    public static final String CUSTOMCALL_PUBLISHSTYLE = "PUBLISHSTYLE";
    public static final String CUSTOMCALL_EXPSTYLEVER = "EXPSTYLEVER";
    public static final String CUSTOMCALL_IMPSTYLEVER = "IMPSTYLEVER";
    public static final String CUSTOMCALL_ASYNCIMPSTYLEVER = "ASYNCIMPSTYLEVER";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_MERGECODE, (boolean)true) == 0) {
            return this.mergeCode(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PUBLISHSTYLE, (boolean)true) == 0) {
            return this.publishStyle(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXPSTYLEVER, (boolean)true) == 0) {
            return this.expStyleVer(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_IMPSTYLEVER, (boolean)true) == 0) {
            return this.impStyleVer(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ASYNCIMPSTYLEVER, (boolean)true) == 0) {
            return this.asyncImpStyleVer(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult mergeCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSFStyleVer psSFStyleVer = new PSSFStyleVer();
            psSFStyleVer.proxy(dataEntity);
            this.onMergeCode(psSFStyleVer);
            String strPSSFStyleVerId = psSFStyleVer.getPSSFSTYLEVERID();
            psSFStyleVer.Reset();
            psSFStyleVer.setPSSFSTYLEVERID(strPSSFStyleVerId);
            return this.Save(false, psSFStyleVer);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5408\u5e76\u6a21\u7248\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onMergeCode(PSSFStyleVer psSFStyleVer) throws Exception {
        Vector psSFVerCodeItems;
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSFSTYLEID", (Object)psSFStyleVer.getPSSFSTYLEID());
        IDEDataCtrl psSFStyleCodeDataCtrl = this.GetRelatedDataCtrl("DE1553");
        Vector psSFStyleCodes = new Vector();
        CallResult callResult = psSFStyleCodeDataCtrl.Select(cond, psSFStyleCodes, PSSFStyleCode.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6846\u67b6\u6837\u5f0f\u5b8f\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        cond.Reset();
        cond.setParamValue("PSSFSTYLEVERID", (Object)psSFStyleVer.getPSSFSTYLEVERID());
        IDEDataCtrl psSFVerCodeDataCtrl = this.GetRelatedDataCtrl("DE1551");
        Vector psSFVerCodes = new Vector();
        callResult = psSFVerCodeDataCtrl.Select(cond, psSFVerCodes, PSSFVerCode.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6846\u67b6\u6837\u5f0f\u89c6\u56fe\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSFVerCode psSFVerCode : psSFVerCodes) {
            String strTEMPLCODE = psSFVerCode.getTEMPLCODE2();
            int i = 0;
            while (i < 10) {
                boolean bChanged = false;
                for (PSSFStyleCode psSFStyleCode : psSFStyleCodes) {
                    String strTag = StringHelper.Format((String)"<#SRFINC(%1$s)>", (Object)psSFStyleCode.getPSSFSTYLECODENAME().toUpperCase());
                    if (strTEMPLCODE.indexOf(strTag) == -1) continue;
                    strTEMPLCODE = strTEMPLCODE.replace(strTag, psSFStyleCode.getSTYLECODE());
                    bChanged = true;
                }
                if (!bChanged) break;
                ++i;
            }
            if (StringHelper.Compare((String)strTEMPLCODE, (String)psSFVerCode.getCODETEMPL(), (boolean)false) == 0) continue;
            psSFVerCode.setCODETEMPL(strTEMPLCODE);
            callResult = psSFVerCodeDataCtrl.Save(false, (BaseDataEntity)psSFVerCode);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u5408\u5e76\u6846\u67b6\u6837\u5f0f\u4ee3\u7801\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IDEDataCtrl psSFVerCodeItemDataCtrl = this.GetRelatedDataCtrl("DE1552");
        callResult = psSFVerCodeItemDataCtrl.Select(cond, psSFVerCodeItems = new Vector(), PSSFVerCodeItem.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6846\u67b6\u6837\u5f0f\u6a21\u7248\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSFVerCodeItem psSFVerCodeItem : psSFVerCodeItems) {
            String strTEMPLCODE = psSFVerCodeItem.getTEMPLCODE2();
            int i = 0;
            while (i < 10) {
                boolean bChanged = false;
                for (PSSFStyleCode psSFStyleCode : psSFStyleCodes) {
                    String strTag = StringHelper.Format((String)"<#SRFINC(%1$s)>", (Object)psSFStyleCode.getPSSFSTYLECODENAME().toUpperCase());
                    if (strTEMPLCODE.indexOf(strTag) == -1) continue;
                    strTEMPLCODE = strTEMPLCODE.replace(strTag, psSFStyleCode.getSTYLECODE());
                    bChanged = true;
                }
                if (!bChanged) break;
                ++i;
            }
            if (StringHelper.Compare((String)strTEMPLCODE, (String)psSFVerCodeItem.getTEMPLCODE(), (boolean)false) == 0) continue;
            psSFVerCodeItem.setTEMPLCODE(strTEMPLCODE);
            callResult = psSFVerCodeItemDataCtrl.Save(false, (BaseDataEntity)psSFVerCodeItem);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u5408\u5e76\u6846\u67b6\u6837\u5f0f\u4ee3\u7801\u6a21\u7248\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    public CallResult publishStyle(BaseDataEntity dataEntity) {
        CallResult callResult = this.mergeCode(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSSFStyleVer psSFStyleVer = new PSSFStyleVer();
            psSFStyleVer.proxy(dataEntity);
            this.getPSModelStorage().getPSSF(psSFStyleVer.getPSSFID()).getPSSFStyle(psSFStyleVer.getPSSFSTYLEID()).resetPSSFStyleVer(psSFStyleVer.getPSSFSTYLEVERID());
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u6846\u67b6\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        PSSFStyleVer psSFStyleVer = new PSSFStyleVer();
        psSFStyleVer.proxy(dataEntity);
        this.getPSModelStorage().getPSSF(psSFStyleVer.getPSSFID()).getPSSFStyle(psSFStyleVer.getPSSFSTYLEID()).resetPSSFStyleVer(psSFStyleVer.getPSSFSTYLEVERID());
    }

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = null;
        PSSFStyleVer psSFStyleVer = new PSSFStyleVer();
        psSFStyleVer.proxy(dataEntity);
        BaseDataEntity psSFStyle = this.GetRelatedData("DE1513", psSFStyleVer.getPSSFSTYLEID(), false);
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1513");
        strRootFolder = iPSTemplDataCtrl.getTemplFolder(psSFStyle);
        return StringHelper.Format((String)"%1$s%2$sPSSFSTYLEVER%2$s%3$s", (Object)strRootFolder, (Object)File.separator, (Object)psSFStyleVer.getPSSFSTYLEVERNAME());
    }

    @Override
    protected void onExportTempl(BaseDataEntity dataEntity) throws Exception {
        super.onExportTempl(dataEntity);
        String strPSSFStyleVerId = dataEntity.getParamStringValue("PSSFSTYLEVERID", "");
        IDEDataCtrl iPSSFVerCodeDataCtrl = this.GetRelatedDataCtrl("DE1551");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSFSTYLEVERID", (Object)strPSSFStyleVerId);
        Vector psSFVerCodeList = new Vector();
        iPSSFVerCodeDataCtrl.Select(cond, psSFVerCodeList);
        for (BaseDataEntity baseDataEntity : psSFVerCodeList) {
            iPSSFVerCodeDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
    }

    public CallResult CopyDetail(BaseDataEntity dataEntity, Object srcKey) {
        CallResult callResult = new CallResult();
        try {
            IDEDataCtrl psSFStyleVerDataCtrl = this.GetRelatedDataCtrl("DE1550");
            IDEDataCtrl psSFVerCodeDataCtrl = this.GetRelatedDataCtrl("DE1551");
            IDEDataCtrl psSFVerCodeItemDataCtrl = this.GetRelatedDataCtrl("DE1552");
            IDEDataCtrl psSFCodeTypeDataCtrl = this.GetRelatedDataCtrl("DE1515");
            PSSFStyleVer oriPSSFStyleVer = new PSSFStyleVer();
            oriPSSFStyleVer.setPSSFSTYLEVERID((String)srcKey);
            callResult = psSFStyleVerDataCtrl.Get((BaseDataEntity)oriPSSFStyleVer);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6e90\u6846\u67b6\u6269\u5c55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            String strPSSFStyleId = dataEntity.getParamStringValue("PSSFSTYLEID", "");
            String strOriPSSFStyleId = oriPSSFStyleVer.getParamStringValue("PSSFSTYLEID", "");
            Vector psSFCodeTypeList = new Vector();
            Vector psSFCodeTypeList2 = new Vector();
            BaseDataEntity cond = new BaseDataEntity();
            cond.set("PSSFSTYLEID", (Object)strPSSFStyleId);
            callResult = psSFCodeTypeDataCtrl.Select(cond, psSFCodeTypeList, PSSFCodeType.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5f53\u524d\u6846\u67b6\u4ee3\u7801\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            cond.Reset();
            cond.set("PSSFSTYLEID", (Object)strOriPSSFStyleId);
            callResult = psSFCodeTypeDataCtrl.Select(cond, psSFCodeTypeList2, PSSFCodeType.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6e90\u6846\u67b6\u4ee3\u7801\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, PSSFCodeType> psSFCodeTypeMap = new HashMap<String, PSSFCodeType>();
            HashMap<String, PSSFCodeType> psSFCodeTypeMap2 = new HashMap<String, PSSFCodeType>();
            for (PSSFCodeType psSFCodeType : psSFCodeTypeList2) {
                psSFCodeTypeMap2.put(psSFCodeType.getTYPECODE(), psSFCodeType);
            }
            for (PSSFCodeType psSFCodeType : psSFCodeTypeList) {
                PSSFCodeType psSFCodeType2 = (PSSFCodeType)((Object)psSFCodeTypeMap2.get(psSFCodeType.getTYPECODE()));
                if (psSFCodeType2 == null) continue;
                psSFCodeTypeMap.put(psSFCodeType2.getPSSFCODETYPEID(), psSFCodeType);
            }
            Vector psSFVerCodeList = new Vector();
            cond.Reset();
            cond.set("PSSFSTYLEVERID", srcKey);
            callResult = psSFVerCodeDataCtrl.Select(cond, psSFVerCodeList, PSSFVerCode.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7248\u672c\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSSFVerCode psSFVerCode : psSFVerCodeList) {
                PSSFVerCode clonePSSFVerCode = new PSSFVerCode();
                psSFVerCode.CopyTo(clonePSSFVerCode, false);
                clonePSSFVerCode.RemoveParam("PSSFVERCODEID");
                PSSFCodeType psSFCodeType = (PSSFCodeType)((Object)psSFCodeTypeMap.get(psSFVerCode.getPSSFCODETYPEID()));
                if (psSFCodeType == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6e90\u4ee3\u7801\u7c7b\u578b[%1$s]\u5bf9\u5e94\u7684\u65b0\u4ee3\u7801\u7c7b\u578b", (Object)psSFVerCode.getPSSFCODETYPENAME()));
                }
                clonePSSFVerCode.setPSSFCODETYPEID(psSFCodeType.getPSSFCODETYPEID());
                clonePSSFVerCode.setPSSFCODETYPENAME(psSFCodeType.getPSSFCODETYPENAME());
                clonePSSFVerCode.setPSSFSTYLEVERID(dataEntity.getParamStringValue("PSSFSTYLEVERID", ""));
                callResult = psSFVerCodeDataCtrl.Save(true, (BaseDataEntity)clonePSSFVerCode);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7248\u672c\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                Vector psSFVerCodeItemList = new Vector();
                cond.Reset();
                cond.set("PSSFVERCODEID", psSFVerCode.getParamValue("PSSFVERCODEID"));
                callResult = psSFVerCodeItemDataCtrl.Select(cond, psSFVerCodeItemList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7248\u672c\u4ee3\u7801\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (BaseDataEntity psSFVerCodeItem : psSFVerCodeItemList) {
                    PSSFVerCodeItem clonePSSFVerCodeItem = new PSSFVerCodeItem();
                    psSFVerCodeItem.CopyTo((BaseDataEntity)clonePSSFVerCodeItem, false);
                    clonePSSFVerCodeItem.RemoveParam("PSSFVERCODEITEMID");
                    clonePSSFVerCodeItem.setPSSFVERCODEID(clonePSSFVerCode.getPSSFVERCODEID());
                    callResult = psSFVerCodeItemDataCtrl.Save(true, (BaseDataEntity)clonePSSFVerCodeItem);
                    if (!callResult.isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7248\u672c\u4ee3\u7801\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult expStyleVer(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSSFStyleVer psSFStyleVer = new PSSFStyleVer();
            dataEntity.CopyTo((BaseDataEntity)psSFStyleVer, false);
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSFStyleVerDataCtrl.this.onExpStyleVer(psSFStyleVer);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u540e\u53f0\u670d\u52a1\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onExpStyleVer(PSSFStyleVer psSFStyleVer) throws Exception {
        PSSFStyleVerService psSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class);
        net.ibizsys.pscore.srv.config.entity.PSSFStyleVer psSFStyleVerV5 = new net.ibizsys.pscore.srv.config.entity.PSSFStyleVer();
        psSFStyleVerV5.setPSSFStyleVerId(psSFStyleVer.getPSSFSTYLEVERID());
        psSFStyleVerV5.set("SRFPRJFOLDER", (Object)StringHelper.Format((String)"%1$s%2$sPSSFSTYLEVERNEW%2$s%3$s", (Object)this.strCodeFolder, (Object)File.separator, (Object)psSFStyleVerV5.getPSSFStyleVerId()));
        psSFStyleVerService.expStyleVer(psSFStyleVerV5);
    }

    public CallResult impStyleVer(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSSFStyleVer psSFStyleVer = new PSSFStyleVer();
            dataEntity.CopyTo((BaseDataEntity)psSFStyleVer, false);
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSFStyleVerDataCtrl.this.onImpStyleVer(psSFStyleVer);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u5165\u540e\u53f0\u670d\u52a1\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onImpStyleVer(PSSFStyleVer psSFStyleVer) throws Exception {
        PSSFStyleVerService psSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class);
        net.ibizsys.pscore.srv.config.entity.PSSFStyleVer psSFStyleVerV5 = new net.ibizsys.pscore.srv.config.entity.PSSFStyleVer();
        psSFStyleVerV5.setPSSFStyleVerId(psSFStyleVer.getPSSFSTYLEVERID());
        psSFStyleVerV5.set("SRFPRJFOLDER", (Object)StringHelper.Format((String)"%1$s%2$sPSSFSTYLEVERNEW%2$s%3$s", (Object)this.strCodeFolder, (Object)File.separator, (Object)psSFStyleVerV5.getPSSFStyleVerId()));
        psSFStyleVerService.impStyleVer(psSFStyleVerV5);
    }

    public CallResult asyncImpStyleVer(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            PSSFStyleVer psSFStyleVer = new PSSFStyleVer();
            psSFStyleVer.proxy(dataEntity);
            this.Get(psSFStyleVer);
            this.onAsyncImpStyleVer(psSFStyleVer);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u5165\u5e94\u7528\u4e2d\u5fc3\u540e\u53f0\u670d\u52a1\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAsyncImpStyleVer(PSSFStyleVer psSFStyleVer) throws Exception {
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        psDCBKTask.setPSDEVCENTERID(psSFStyleVer.getPSDEVCENTERID());
        psDCBKTask.setPSDEVCENTERNAME(psSFStyleVer.getPSDEVCENTERNAME());
        psDCBKTask.setPSDCBKTASKNAME(StringHelper.Format((String)"\u5bfc\u5165\u5e94\u7528\u4e2d\u5fc3\u540e\u53f0\u670d\u52a1\u6a21\u677f[%1$s]", (Object)psSFStyleVer.getPSSFSTYLEVERNAME()));
        psDCBKTask.setTASKSTATE(10);
        psDCBKTask.setORDERVALUE(100);
        psDCBKTask.setTASKTYPE("IMPSFSTYLEVER");
        psDCBKTask.setTASKPARAM(psSFStyleVer.getPSSFSTYLEVERID());
        IDEDataCtrl psDCBKTaskDataCtrl = this.GetRelatedDataCtrl("DE2984");
        CallResult callResult = psDCBKTaskDataCtrl.Save(true, (BaseDataEntity)psDCBKTask);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u521b\u5efa\u5e94\u7528\u4e2d\u5fc3\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask);
    }
}

