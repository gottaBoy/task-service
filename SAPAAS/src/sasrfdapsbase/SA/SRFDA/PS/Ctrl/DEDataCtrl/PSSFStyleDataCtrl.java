/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.config.entity.PSSFStyle
 *  net.ibizsys.pscore.srv.config.service.PSSFStyleService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSSFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSSF;
import SA.SRFDA.PS.Data.PSSFCodeFolder;
import SA.SRFDA.PS.Data.PSSFCodeTempl;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.PS.Data.PSSFStyleCode;
import SA.SRFDA.PS.Data.PSSFStylePkg;
import SA.SRFDA.PS.Data.PSSFStylePrj;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStyleDataCtrl
extends PSSFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSSFStyleDataCtrl.class);
    public static final String CUSTOMCALL_MERGECODE = "MERGECODE";
    public static final String CUSTOMCALL_PUBLISHSTYLE = "PUBLISHSTYLE";
    public static final String CUSTOMCALL_EXPSTYLE = "EXPSTYLE";

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_EXPSTYLE, (boolean)true) == 0) {
            return this.expStyle(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult mergeCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            SA.SRFDA.PS.Data.PSSFStyle psSFStyle = new SA.SRFDA.PS.Data.PSSFStyle();
            psSFStyle.proxy(dataEntity);
            this.onMergeCode(psSFStyle);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5408\u5e76\u670d\u52a1\u6837\u5f0f\u6a21\u7248\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onMergeCode(SA.SRFDA.PS.Data.PSSFStyle psSFStyle) throws Exception {
        Vector<PSSFCodeTempl> psSFCodeTempls;
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSFSTYLEID", (Object)psSFStyle.getPSSFSTYLEID());
        IDEDataCtrl psSFStyleCodeDataCtrl = this.GetRelatedDataCtrl("DE1553");
        Vector<PSSFStyleCode> psSFStyleCodes = new Vector<PSSFStyleCode>();
        CallResult callResult = psSFStyleCodeDataCtrl.Select(cond, psSFStyleCodes, PSSFStyleCode.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6846\u67b6\u6837\u5f0f\u5b8f\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        cond.Reset();
        cond.setParamValue("PSSFSTYLEID", (Object)psSFStyle.getPSSFSTYLEID());
        IDEDataCtrl psSFCodeTypeDataCtrl = this.GetRelatedDataCtrl("DE1515");
        Vector<PSSFCodeType> psSFCodeTypes = new Vector<PSSFCodeType>();
        callResult = psSFCodeTypeDataCtrl.Select(cond, psSFCodeTypes, PSSFCodeType.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6846\u67b6\u6837\u5f0f\u89c6\u56fe\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, String> headerCodeMap = new HashMap<String, String>();
        for (PSSFCodeType psSFCodeType : psSFCodeTypes) {
            String strTEMPLCODE = psSFCodeType.getTEMPLCODE2();
            if (!StringHelper.IsNullOrEmpty((String)psSFCodeType.getHEADERCODE())) {
                strTEMPLCODE = String.valueOf(psSFCodeType.getHEADERCODE()) + "\r\n" + strTEMPLCODE;
                headerCodeMap.put(psSFCodeType.getPSSFCODETYPEID(), psSFCodeType.getHEADERCODE());
            }
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
            if (StringHelper.Compare((String)strTEMPLCODE, (String)psSFCodeType.getCODETEMPL(), (boolean)false) == 0) continue;
            psSFCodeType.setCODETEMPL(strTEMPLCODE);
            callResult = psSFCodeTypeDataCtrl.Save(false, (BaseDataEntity)psSFCodeType);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u5408\u5e76\u6846\u67b6\u6837\u5f0f\u4ee3\u7801\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IDEDataCtrl psSFCodeTemplDataCtrl = this.GetRelatedDataCtrl("DE1516");
        callResult = psSFCodeTemplDataCtrl.Select(cond, psSFCodeTempls = new Vector<PSSFCodeTempl>(), PSSFCodeTempl.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6846\u67b6\u6837\u5f0f\u6a21\u7248\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSFCodeTempl psSFCodeTempl : psSFCodeTempls) {
            String strTEMPLCODE = psSFCodeTempl.getTEMPLCODE2();
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
            if (StringHelper.Compare((String)strTEMPLCODE, (String)psSFCodeTempl.getTEMPLCODE(), (boolean)false) == 0) continue;
            psSFCodeTempl.setTEMPLCODE(strTEMPLCODE);
            callResult = psSFCodeTemplDataCtrl.Save(false, (BaseDataEntity)psSFCodeTempl);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u5408\u5e76\u6846\u67b6\u6837\u5f0f\u4ee3\u7801\u6a21\u7248\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    public CallResult publishStyle(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            SA.SRFDA.PS.Data.PSSFStyle psSFStyle = new SA.SRFDA.PS.Data.PSSFStyle();
            psSFStyle.proxy(dataEntity);
            this.onMergeCode(psSFStyle);
            this.getPSModelStorage().getPSSF(psSFStyle.getPSSFID()).resetPSSFStyle(psSFStyle.getPSSFSTYLEID());
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
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        SA.SRFDA.PS.Data.PSSFStyle psSFStyle = new SA.SRFDA.PS.Data.PSSFStyle();
        psSFStyle.proxy(dataEntity);
        PSSF psSF = new PSSF();
        psSF.setPSSFID(psSFStyle.getPSSFID());
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1502");
        String strRootFolder = iPSTemplDataCtrl.getTemplFolder(psSF);
        return StringHelper.Format((String)"%1$s%2$s%3$s%2$s%4$s", (Object)strRootFolder, (Object)File.separator, (Object)this.GetDEHelper().getName(), (Object)psSFStyle.getPSSFSTYLEID());
    }

    @Override
    protected void onExportTempl(BaseDataEntity dataEntity) throws Exception {
        super.onExportTempl(dataEntity);
        String strPSSFStyleId = dataEntity.getParamStringValue("PSSFSTYLEID", "");
        IDEDataCtrl iPSSFStyleCodeDataCtrl = this.GetRelatedDataCtrl("DE1553");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSFSTYLEID", (Object)strPSSFStyleId);
        Vector<BaseDataEntity> psSFStyleCodeList = new Vector<BaseDataEntity>();
        iPSSFStyleCodeDataCtrl.Select(cond, psSFStyleCodeList);
        for (BaseDataEntity baseDataEntity : psSFStyleCodeList) {
            iPSSFStyleCodeDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
        IDEDataCtrl iPSSFCodeTypeDataCtrl = this.GetRelatedDataCtrl("DE1515");
        cond = new BaseDataEntity();
        cond.setParamValue("PSSFSTYLEID", (Object)strPSSFStyleId);
        Vector<BaseDataEntity> psSFCodeTypeList = new Vector<BaseDataEntity>();
        iPSSFCodeTypeDataCtrl.Select(cond, psSFCodeTypeList);
        for (BaseDataEntity baseDataEntity : psSFCodeTypeList) {
            iPSSFCodeTypeDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
        IDEDataCtrl iPSSFStyleVerDataCtrl = this.GetRelatedDataCtrl("DE1550");
        cond = new BaseDataEntity();
        cond.setParamValue("PSSFSTYLEID", (Object)strPSSFStyleId);
        Vector<BaseDataEntity> psSFStyleVerList = new Vector<BaseDataEntity>();
        iPSSFStyleVerDataCtrl.Select(cond, psSFStyleVerList);
        for (BaseDataEntity baseDataEntity : psSFStyleVerList) {
            iPSSFStyleVerDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
    }

    public CallResult CopyDetail(BaseDataEntity dataEntity, Object srcKey) {
        CallResult callResult = new CallResult();
        try {
            IDEDataCtrl psSFCodeFolderDataCtrl = this.GetRelatedDataCtrl("DE1514");
            IDEDataCtrl psSFStyleCodeDataCtrl = this.GetRelatedDataCtrl("DE1553");
            IDEDataCtrl psSFCodeTypeDataCtrl = this.GetRelatedDataCtrl("DE1515");
            IDEDataCtrl psSFCodeTemplDataCtrl = this.GetRelatedDataCtrl("DE1516");
            IDEDataCtrl psSFStylePrjDataCtrl = this.GetRelatedDataCtrl("DE1655");
            IDEDataCtrl psSFStylePkgDataCtrl = this.GetRelatedDataCtrl("DE1654");
            String strPSSFStyleId = dataEntity.getParamStringValue("PSSFSTYLEID", "");
            BaseDataEntity cond = new BaseDataEntity();
            cond.set("PSSFSTYLEID", srcKey);
            Vector<BaseDataEntity> psSFStyleCodeList = new Vector<BaseDataEntity>();
            callResult = psSFStyleCodeDataCtrl.Select(cond, psSFStyleCodeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u5b8f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psSFStyleCode : psSFStyleCodeList) {
                PSSFStyleCode clonePSSFCodeFoler = new PSSFStyleCode();
                psSFStyleCode.CopyTo((BaseDataEntity)clonePSSFCodeFoler, false);
                clonePSSFCodeFoler.RemoveParam("PSSFSTYLECODEID");
                clonePSSFCodeFoler.setPSSFSTYLEID(strPSSFStyleId);
                callResult = psSFStyleCodeDataCtrl.Save(true, (BaseDataEntity)clonePSSFCodeFoler);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4ee3\u7801\u5b8f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            cond.Reset();
            cond.set("PSSFSTYLEID", srcKey);
            Vector<BaseDataEntity> psSFStylePrjList = new Vector<BaseDataEntity>();
            callResult = psSFStylePrjDataCtrl.Select(cond, psSFStylePrjList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u53d1\u5e03\u9879\u76ee\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, Object> psSFStylePrjMap = new HashMap<String, Object>();
            for (BaseDataEntity psSFStylePrj : psSFStylePrjList) {
                PSSFStylePrj clonePSSFStylePrj = new PSSFStylePrj();
                psSFStylePrj.CopyTo((BaseDataEntity)clonePSSFStylePrj, false);
                clonePSSFStylePrj.RemoveParam("PSSFSTYLEPRJID");
                clonePSSFStylePrj.setPSSFSTYLEID(strPSSFStyleId);
                callResult = psSFStylePrjDataCtrl.Save(true, (BaseDataEntity)clonePSSFStylePrj);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u53d1\u5e03\u9879\u76ee\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSFStylePrjMap.put(psSFStylePrj.getParamStringValue("PSSFSTYLEPRJID", ""), (Object)clonePSSFStylePrj);
            }
            cond.Reset();
            cond.set("PSSFSTYLEID", srcKey);
            Vector<BaseDataEntity> psSFCodeFolderList = new Vector<BaseDataEntity>();
            callResult = psSFCodeFolderDataCtrl.Select(cond, psSFCodeFolderList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u76ee\u5f55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psSFCodeFolder : psSFCodeFolderList) {
                PSSFCodeFolder clonePSSFCodeFoler = new PSSFCodeFolder();
                psSFCodeFolder.CopyTo((BaseDataEntity)clonePSSFCodeFoler, false);
                clonePSSFCodeFoler.RemoveParam("PSSFCODEFOLDERID");
                clonePSSFCodeFoler.setPSSFSTYLEID(strPSSFStyleId);
                if (!StringHelper.IsNullOrEmpty((String)clonePSSFCodeFoler.getPSSFSTYLEPRJID())) {
                    clonePSSFCodeFoler.setPSSFSTYLEPRJID(((PSSFStylePrj)((Object)psSFStylePrjMap.get(clonePSSFCodeFoler.getPSSFSTYLEPRJID()))).getPSSFSTYLEPRJID());
                }
                if ((callResult = psSFCodeFolderDataCtrl.Save(true, (BaseDataEntity)clonePSSFCodeFoler)).isError()) {
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4ee3\u7801\u76ee\u5f55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                Vector<BaseDataEntity> psSFCodeTypeList = new Vector<BaseDataEntity>();
                cond.Reset();
                cond.set("PSSFCODEFOLDERID", psSFCodeFolder.getParamValue("PSSFCODEFOLDERID"));
                callResult = psSFCodeTypeDataCtrl.Select(cond, psSFCodeTypeList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (BaseDataEntity psSFCodeType : psSFCodeTypeList) {
                    PSSFCodeType clonePSSFCodeType = new PSSFCodeType();
                    psSFCodeType.CopyTo((BaseDataEntity)clonePSSFCodeType, false);
                    clonePSSFCodeType.RemoveParam("PSSFCODETYPEID");
                    clonePSSFCodeType.setPSSFSTYLEID(strPSSFStyleId);
                    clonePSSFCodeType.setPSSFCODEFOLDERID(clonePSSFCodeFoler.getPSSFCODEFOLDERID());
                    callResult = psSFCodeTypeDataCtrl.Save(true, (BaseDataEntity)clonePSSFCodeType);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4ee3\u7801\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    Vector<BaseDataEntity> psSFCodeTemplList = new Vector<BaseDataEntity>();
                    cond.Reset();
                    cond.set("PSSFCODETYPEID", psSFCodeType.getParamValue("PSSFCODETYPEID"));
                    callResult = psSFCodeTemplDataCtrl.Select(cond, psSFCodeTemplList);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u7c7b\u578b\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    for (BaseDataEntity psSFCodeTempl : psSFCodeTemplList) {
                        PSSFCodeTempl clonePSSFCodeTempl = new PSSFCodeTempl();
                        psSFCodeTempl.CopyTo((BaseDataEntity)clonePSSFCodeTempl, false);
                        clonePSSFCodeTempl.RemoveParam("PSSFCODETEMPLID");
                        clonePSSFCodeTempl.setPSSFSTYLEID(strPSSFStyleId);
                        clonePSSFCodeTempl.setPSSFCODETYPEID(clonePSSFCodeType.getPSSFCODETYPEID());
                        callResult = psSFCodeTemplDataCtrl.Save(true, (BaseDataEntity)clonePSSFCodeTempl);
                        if (!callResult.isError()) continue;
                        throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4ee3\u7801\u7c7b\u578b\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
            }
            cond.Reset();
            cond.set("PSSFSTYLEID", srcKey);
            Vector<BaseDataEntity> psSFStylePkgList = new Vector<BaseDataEntity>();
            callResult = psSFStylePkgDataCtrl.Select(cond, psSFStylePkgList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7ec4\u4ef6\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psSFStylePkg : psSFStylePkgList) {
                PSSFStylePkg clonePSSFStylePkg = new PSSFStylePkg();
                psSFStylePkg.CopyTo((BaseDataEntity)clonePSSFStylePkg, false);
                clonePSSFStylePkg.RemoveParam("PSSFSTYLEPKGID");
                clonePSSFStylePkg.setPSSFSTYLEID(strPSSFStyleId);
                callResult = psSFStylePkgDataCtrl.Save(true, (BaseDataEntity)clonePSSFStylePkg);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7ec4\u4ef6\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult expStyle(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final SA.SRFDA.PS.Data.PSSFStyle psSFStyle = new SA.SRFDA.PS.Data.PSSFStyle();
            dataEntity.CopyTo((BaseDataEntity)psSFStyle, false);
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSSFStyleDataCtrl.this.onExpStyle(psSFStyle);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u540e\u53f0\u670d\u52a1\u6846\u67b6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onExpStyle(SA.SRFDA.PS.Data.PSSFStyle psSFStyle) throws Exception {
        PSSFStyleService psSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class);
        PSSFStyle psSFStyleV5 = new PSSFStyle();
        psSFStyleV5.setPSSFStyleId(psSFStyle.getPSSFSTYLEID());
        psSFStyleV5.set("SRFPRJFOLDER", (Object)StringHelper.Format((String)"%1$s%2$sPSSFSTYLEV2%2$s%3$s", (Object)this.strCodeFolder, (Object)File.separator, (Object)psSFStyleV5.getPSSFStyleId()));
        psSFStyleService.expStyle(psSFStyleV5);
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSSFId = dataEntity.getParamStringValue("PSSFID", "");
        String strPSSFStyleId = dataEntity.getParamStringValue("PSSFSTYLEID", "");
        IPSSF iPSSF = this.getPSModelStorage().getPSSF(strPSSFId);
        iPSSF.resetPSSFStyle(strPSSFStyleId);
        iPSSF.getPSSFStyle(strPSSFStyleId);
    }
}

