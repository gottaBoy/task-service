/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSPF;
import SA.SRFDA.PS.Data.PSPFCodeFolder;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.PS.Data.PSPFPkg;
import SA.SRFDA.PS.Data.PSPFPkgCat;
import SA.SRFDA.PS.Data.PSPFPkgVer;
import SA.SRFDA.PS.Data.PSPFPkgVerCDN;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFDataCtrl
extends PSPFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSPFDataCtrl.class);
    public static final String CUSTOMCALL_INITPUBOBJ = "INITPUBOBJ";

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
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_INITPUBOBJ, (boolean)true) == 0) {
            return this.initPubObj(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSPFId = dataEntity.getParamStringValue("PSPFID", "");
        this.getPSModelStorage().resetPSPF(strPSPFId);
        IPSPF iPSPF = this.getPSModelStorage().getPSPF(strPSPFId);
    }

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        String strRootFolder = this.getRootFolder();
        return StringHelper.format((String)"%1$s%2$s%3$s", (Object)strRootFolder, (Object)File.separator, (Object)dataEntity.getParamStringValue("PSPFID", ""));
    }

    @Override
    protected void onExportTempl(BaseDataEntity dataEntity) throws Exception {
        super.onExportTempl(dataEntity);
        String strPSPFId = dataEntity.getParamStringValue("PSPFID", "");
        IDEDataCtrl iPSPFStyleDataCtrl = this.GetRelatedDataCtrl("DE1595");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSPFID", (Object)strPSPFId);
        Vector<BaseDataEntity> psPFStyleList = new Vector<BaseDataEntity>();
        iPSPFStyleDataCtrl.Select(cond, psPFStyleList);
        for (BaseDataEntity baseDataEntity : psPFStyleList) {
            iPSPFStyleDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
        IDEDataCtrl iPSPFEditorTemplDataCtrl = this.GetRelatedDataCtrl("DE1804");
        cond = new BaseDataEntity();
        cond.setParamValue("PSPFID", (Object)strPSPFId);
        Vector<BaseDataEntity> psPFEditorTemplList = new Vector<BaseDataEntity>();
        iPSPFEditorTemplDataCtrl.Select(cond, psPFEditorTemplList);
        for (BaseDataEntity baseDataEntity : psPFEditorTemplList) {
            String strPSPFStyleId = baseDataEntity.getParamStringValue("PSPFSTYLEID", "");
            if (!StringHelper.isNullOrEmpty((String)strPSPFStyleId)) continue;
            iPSPFEditorTemplDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
    }

    public CallResult CopyDetail(BaseDataEntity dataEntity, Object srcKey) {
        CallResult callResult = new CallResult();
        try {
            IDEDataCtrl psPFCodeFolderDataCtrl = this.GetRelatedDataCtrl("DE1592");
            IDEDataCtrl psPFPubCodeDataCtrl = this.GetRelatedDataCtrl("DE1596");
            IDEDataCtrl psPFEditorTemplDataCtrl = this.GetRelatedDataCtrl("DE1804");
            IDEDataCtrl psPFPkgCatDataCtrl = this.GetRelatedDataCtrl("DE1671");
            IDEDataCtrl psPFPkgDataCtrl = this.GetRelatedDataCtrl("DE1672");
            IDEDataCtrl psPFPkgVerDataCtrl = this.GetRelatedDataCtrl("DE1673");
            IDEDataCtrl psPFPkgVerCDNDataCtrl = this.GetRelatedDataCtrl("DE1676");
            String strPSPFId = dataEntity.getParamStringValue("PSPFID", "");
            String strPSPFName = dataEntity.getParamStringValue("PSPFNAME", "");
            BaseDataEntity cond = new BaseDataEntity();
            cond.set("PSPFID", srcKey);
            Vector<BaseDataEntity> psPFCodeFolderList = new Vector<BaseDataEntity>();
            callResult = psPFCodeFolderDataCtrl.Select(cond, psPFCodeFolderList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u4ee3\u7801\u76ee\u5f55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, PSPFCodeFolder> clonePSPFCodeFolderMap = new HashMap<String, PSPFCodeFolder>();
            for (BaseDataEntity psPFCodeFolder : psPFCodeFolderList) {
                PSPFCodeFolder clonePSPFCodeFolder = new PSPFCodeFolder();
                psPFCodeFolder.CopyTo((BaseDataEntity)clonePSPFCodeFolder, false);
                clonePSPFCodeFolder.RemoveParam("PSPFCODEFOLDERID");
                clonePSPFCodeFolder.setPSPFID(strPSPFId);
                clonePSPFCodeFolder.setPSPFNAME(strPSPFName);
                callResult = psPFCodeFolderDataCtrl.Save(true, (BaseDataEntity)clonePSPFCodeFolder);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u4ee3\u7801\u76ee\u5f55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                clonePSPFCodeFolderMap.put(psPFCodeFolder.getParamStringValue("PSPFCODEFOLDERID", ""), clonePSPFCodeFolder);
            }
            cond.Reset();
            cond.set("PSPFID", srcKey);
            Vector<BaseDataEntity> psPFPubCodeList = new Vector<BaseDataEntity>();
            callResult = psPFPubCodeDataCtrl.Select(cond, psPFPubCodeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u4ee3\u7801\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, PSPFPubCode> clonePSPFPubCodeMap = new HashMap<String, PSPFPubCode>();
            for (BaseDataEntity psPFPubCode : psPFPubCodeList) {
                PSPFPubCode clonePSPFPubCode = new PSPFPubCode();
                psPFPubCode.CopyTo((BaseDataEntity)clonePSPFPubCode, false);
                clonePSPFPubCode.RemoveParam("PSPFPUBCODEID");
                clonePSPFPubCode.setPSPFID(strPSPFId);
                clonePSPFPubCode.setPSPFNAME(strPSPFName);
                PSPFCodeFolder clonePSPFCodeFolder = (PSPFCodeFolder)((Object)clonePSPFCodeFolderMap.get(psPFPubCode.getParamStringValue("PSPFCODEFOLDERID", "")));
                if (clonePSPFCodeFolder == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u53d1\u5e03\u4ee3\u7801[%1$s]\u5bf9\u4e8e\u7684\u4ee3\u7801\u76ee\u5f55[%2$s]", (Object)psPFPubCode.getParamStringValue("PSPFPUBCODENAME", ""), (Object)psPFPubCode.getParamStringValue("PSPFCODEFOLDERNAME", "")));
                }
                clonePSPFPubCode.setPSPFCODEFOLDERID(clonePSPFCodeFolder.getPSPFCODEFOLDERID());
                clonePSPFPubCode.setPSPFCODEFOLDERNAME(clonePSPFCodeFolder.getPSPFCODEFOLDERNAME());
                callResult = psPFPubCodeDataCtrl.Save(true, (BaseDataEntity)clonePSPFPubCode);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u4ee3\u7801\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                clonePSPFPubCodeMap.put(psPFPubCode.getParamStringValue("PSPFPUBCODEID", ""), clonePSPFPubCode);
            }
            cond.Reset();
            cond.set("PSPFID", srcKey);
            Vector<BaseDataEntity> psPFPkgCatList = new Vector<BaseDataEntity>();
            callResult = psPFPkgCatDataCtrl.Select(cond, psPFPkgCatList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7ec4\u4ef6\u5305\u5206\u7c7b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, PSPFPkgCat> clonePSPFPkgCatMap = new HashMap<String, PSPFPkgCat>();
            for (BaseDataEntity psPFPkgCat : psPFPkgCatList) {
                PSPFPkgCat clonePSPFPkgCat = new PSPFPkgCat();
                psPFPkgCat.CopyTo((BaseDataEntity)clonePSPFPkgCat, false);
                clonePSPFPkgCat.RemoveParam("PSPFPKGCATID");
                clonePSPFPkgCat.setPSPFID(strPSPFId);
                clonePSPFPkgCat.setPSPFNAME(strPSPFName);
                callResult = psPFPkgCatDataCtrl.Save(true, (BaseDataEntity)clonePSPFPkgCat);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7ec4\u4ef6\u5305\u5206\u7c7b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                clonePSPFPkgCatMap.put(psPFPkgCat.getParamStringValue("PSPFPKGCATID", ""), clonePSPFPkgCat);
            }
            cond.Reset();
            cond.set("PSPFID", srcKey);
            Vector<BaseDataEntity> psPFPkgList = new Vector<BaseDataEntity>();
            callResult = psPFPkgDataCtrl.Select(cond, psPFPkgList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7ec4\u4ef6\u5305\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, PSPFPkg> clonePSPFPkgMap = new HashMap<String, PSPFPkg>();
            for (BaseDataEntity psPFPkg : psPFPkgList) {
                PSPFPkg clonePSPFPkg = new PSPFPkg();
                psPFPkg.CopyTo((BaseDataEntity)clonePSPFPkg, false);
                clonePSPFPkg.RemoveParam("PSPFPKGID");
                clonePSPFPkg.setPSPFID(strPSPFId);
                clonePSPFPkg.setPSPFNAME(strPSPFName);
                PSPFPkgCat clonePSPFPkgCat = (PSPFPkgCat)((Object)clonePSPFPkgCatMap.get(psPFPkg.getParamStringValue("PSPFPKGCATID", "")));
                if (clonePSPFPkgCat == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7ec4\u4ef6\u5305[%1$s]\u5bf9\u4e8e\u7684\u5206\u7c7b[%2$s]", (Object)psPFPkg.getParamStringValue("PSPFPKGNAME", ""), (Object)psPFPkg.getParamStringValue("PSPFPKGCATNAME", "")));
                }
                clonePSPFPkg.setPSPFPKGCATID(clonePSPFPkgCat.getPSPFPKGCATID());
                clonePSPFPkg.setPSPFPKGCATNAME(clonePSPFPkgCat.getPSPFPKGCATNAME());
                callResult = psPFPkgDataCtrl.Save(true, (BaseDataEntity)clonePSPFPkg);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7ec4\u4ef6\u5305\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                clonePSPFPkgMap.put(psPFPkg.getParamStringValue("PSPFPKGID", ""), clonePSPFPkg);
                cond.Reset();
                cond.set("PSPFPKGID", (Object)psPFPkg.getParamStringValue("PSPFPKGID", ""));
                Vector<BaseDataEntity> psPFPkgVerList = new Vector<BaseDataEntity>();
                callResult = psPFPkgVerDataCtrl.Select(cond, psPFPkgVerList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7ec4\u4ef6\u5305\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (BaseDataEntity psPFPkgVer : psPFPkgVerList) {
                    PSPFPkgVer clonePSPFPkgVer = new PSPFPkgVer();
                    psPFPkgVer.CopyTo((BaseDataEntity)clonePSPFPkgVer, false);
                    clonePSPFPkgVer.RemoveParam("PSPFPKGVERID");
                    clonePSPFPkgVer.setPSPFPKGID(clonePSPFPkg.getPSPFPKGID());
                    clonePSPFPkgVer.setPSPFPKGNAME(clonePSPFPkg.getPSPFPKGNAME());
                    callResult = psPFPkgVerDataCtrl.Save(true, (BaseDataEntity)clonePSPFPkgVer);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7ec4\u4ef6\u5305\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    cond.Reset();
                    cond.set("PSPFPKGVERID", (Object)psPFPkgVer.getParamStringValue("PSPFPKGVERID", ""));
                    Vector<BaseDataEntity> psPFPkgVerCDNList = new Vector<BaseDataEntity>();
                    callResult = psPFPkgVerCDNDataCtrl.Select(cond, psPFPkgVerCDNList);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7ec4\u4ef6\u5305\u7248\u672cCDN\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    for (BaseDataEntity psPFPkgVerCDN : psPFPkgVerCDNList) {
                        PSPFPkgVerCDN clonePSPFPkgVerCDN = new PSPFPkgVerCDN();
                        psPFPkgVerCDN.CopyTo((BaseDataEntity)clonePSPFPkgVerCDN, false);
                        clonePSPFPkgVerCDN.RemoveParam("PSPFPKGVERCDNID");
                        clonePSPFPkgVerCDN.setPSPFPKGID(clonePSPFPkg.getPSPFPKGID());
                        clonePSPFPkgVerCDN.setPSPFPKGNAME(clonePSPFPkg.getPSPFPKGNAME());
                        clonePSPFPkgVerCDN.setPSPFPKGVERID(clonePSPFPkgVer.getPSPFPKGVERID());
                        clonePSPFPkgVerCDN.setPSPFPKGVERNAME(clonePSPFPkgVer.getPSPFPKGVERNAME());
                        clonePSPFPkgVerCDN.setPSPFID(strPSPFId);
                        clonePSPFPkgVerCDN.setPSPFNAME(strPSPFName);
                        callResult = psPFPkgVerCDNDataCtrl.Save(true, (BaseDataEntity)clonePSPFPkgVerCDN);
                        if (!callResult.isError()) continue;
                        throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7ec4\u4ef6\u5305\u7248\u672cCDN\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
            }
            cond.Reset();
            cond.set("PSPFID", srcKey);
            Vector<BaseDataEntity> psPFEditorTemplList = new Vector<BaseDataEntity>();
            callResult = psPFEditorTemplDataCtrl.Select(cond, psPFEditorTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7f16\u8f91\u5668\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psPFEditorTempl : psPFEditorTemplList) {
                PSPFEditorTempl clonePSPFEditorTempl = new PSPFEditorTempl();
                psPFEditorTempl.CopyTo((BaseDataEntity)clonePSPFEditorTempl, false);
                if (!StringHelper.isNullOrEmpty((String)clonePSPFEditorTempl.getPSPFSTYLEID())) continue;
                clonePSPFEditorTempl.RemoveParam("PSPFEDITORTEMPLID");
                clonePSPFEditorTempl.RemoveParam("PSPFEDITORTEMPLNAME");
                clonePSPFEditorTempl.setPSPFID(strPSPFId);
                clonePSPFEditorTempl.setPSPFNAME(strPSPFName);
                PSPFPubCode clonePSPFPubCode = (PSPFPubCode)((Object)clonePSPFPubCodeMap.get(psPFEditorTempl.getParamStringValue("PSPFPUBCODEID", "")));
                clonePSPFEditorTempl.setPSPFPUBCODEID(clonePSPFPubCode.getPSPFPUBCODEID());
                clonePSPFEditorTempl.setPSPFPUBCODENAME(clonePSPFPubCode.getPSPFPUBCODENAME());
                callResult = psPFEditorTemplDataCtrl.Save(true, (BaseDataEntity)clonePSPFEditorTempl);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7f16\u8f91\u5668\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult initPubObj(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.onInitPubObj(dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u5e03\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitPubObj(BaseDataEntity dataEntity) throws Exception {
        PSPF psPF = new PSPF();
        psPF.proxy(dataEntity);
    }
}
