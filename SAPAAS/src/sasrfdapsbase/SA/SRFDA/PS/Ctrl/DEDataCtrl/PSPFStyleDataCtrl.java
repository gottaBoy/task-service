/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.config.entity.PSPFCTDetail
 *  net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl
 *  net.ibizsys.pscore.srv.config.entity.PSPFEditorTempl
 *  net.ibizsys.pscore.srv.config.entity.PSPFStyle
 *  net.ibizsys.pscore.srv.config.service.PSPFCTDetailService
 *  net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService
 *  net.ibizsys.pscore.srv.config.service.PSPFEditorTemplService
 *  net.ibizsys.pscore.srv.config.service.PSPFStyleService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSTemplDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSPFTemplDataCtrlBase;
import SA.SRFDA.PS.Data.PSDCBKTask;
import SA.SRFDA.PS.Data.PSPF;
import SA.SRFDA.PS.Data.PSPFAppTempl;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFDA.PS.Data.PSPFCtrlTemplDetail;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.PS.Data.PSPFPkg;
import SA.SRFDA.PS.Data.PSPFPkgVer;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFDA.PS.Data.PSPFStyle;
import SA.SRFDA.PS.Data.PSPFStyleCode;
import SA.SRFDA.PS.Data.PSPFStylePkg;
import SA.SRFDA.PS.Data.PSPFStylePrj;
import SA.SRFDA.PS.Data.PSPFUIActionTempl;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.PS.Data.PSPFViewTempl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPFCTDetail;
import net.ibizsys.pscore.srv.config.service.PSPFCTDetailService;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSPFStyleDataCtrl
extends PSPFTemplDataCtrlBase {
    private static final Log log = LogFactory.getLog(PSPFStyleDataCtrl.class);
    public static final String CUSTOMCALL_MERGECODE = "MERGECODE";
    public static final String CUSTOMCALL_PUBLISHSTYLE = "PUBLISHSTYLE";
    public static final String CUSTOMCALL_EXPSTYLE = "EXPSTYLE";
    public static final String CUSTOMCALL_IMPSTYLE = "IMPSTYLE";
    public static final String CUSTOMCALL_ASYNCIMPSTYLE = "ASYNCIMPSTYLE";
    public static final String CUSTOMCALL_MERGEDYNADEPCODE = "MERGEDYNADEPCODE";

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_IMPSTYLE, (boolean)true) == 0) {
            return this.impStyle(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ASYNCIMPSTYLE, (boolean)true) == 0) {
            return this.asyncImpStyle(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_MERGEDYNADEPCODE, (boolean)true) == 0) {
            return this.mergeDynaDepCode(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult mergeCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.Get(dataEntity);
            PSPFStyle psPFStyle = new PSPFStyle();
            psPFStyle.proxy(dataEntity);
            this.onMergeCode(psPFStyle);
            String strPSPFStyleId = psPFStyle.getPSPFSTYLEID();
            psPFStyle.Reset();
            psPFStyle.setPSPFSTYLEID(strPSPFStyleId);
            return this.Save(false, psPFStyle);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5408\u5e76\u5e94\u7528\u6a21\u7248\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onMergeCode(PSPFStyle psPFStyle) throws Exception {
        Vector vector;
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSPFSTYLEID", (Object)psPFStyle.getPSPFSTYLEID());
        IDEDataCtrl psPFStyleCodeDataCtrl = this.GetRelatedDataCtrl("DE1800");
        Vector<PSPFStyleCode> psPFStyleCodes = new Vector<PSPFStyleCode>();
        boolean bHasStyleCode = false;
        CallResult callResult = psPFStyleCodeDataCtrl.Select(cond, psPFStyleCodes, PSPFStyleCode.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5c55\u73b0\u6837\u5f0f\u5b8f\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        bHasStyleCode = psPFStyleCodes.size() > 0;
        HashMap<String, PSPFStyleCode> psPFStyleCodeMap = new HashMap<String, PSPFStyleCode>();
        for (PSPFStyleCode psPFStyleCode : psPFStyleCodes) {
            psPFStyleCodeMap.put(psPFStyleCode.getPSPFSTYLECODENAME(), psPFStyleCode);
        }
        IDEDataCtrl psPFViewTemplDataCtrl = this.GetRelatedDataCtrl("DE1801");
        IDEDataCtrl psPFAppTemplDataCtrl = this.GetRelatedDataCtrl("DE1808");
        HashMap<String, PSPFStyle> templPSPFStyleMap = new HashMap<String, PSPFStyle>();
        templPSPFStyleMap.put(psPFStyle.getPSPFSTYLEID(), psPFStyle);
        HashMap<String, Object> templPSPFViewTemplMap = new HashMap<String, Object>();
        String strTemplPSPFStyleId = psPFStyle.getTEMPLPSPFSTYLEID();
        while (!StringHelper.IsNullOrEmpty((String)strTemplPSPFStyleId)) {
            if (templPSPFStyleMap.containsKey(strTemplPSPFStyleId)) break;
            cond.Reset();
            cond.setParamValue("PSPFSTYLEID", (Object)strTemplPSPFStyleId);
            Vector psPFStyleCodeList = new Vector();
            callResult = psPFStyleCodeDataCtrl.Select(cond, psPFStyleCodeList, PSPFStyleCode.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5c55\u73b0\u6837\u5f0f\u5b8f\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSPFStyleCode pSPFStyleCode : psPFStyleCodeList) {
                if (psPFStyleCodeMap.containsKey(pSPFStyleCode.getPSPFSTYLECODENAME())) continue;
                psPFStyleCodes.add(pSPFStyleCode);
                psPFStyleCodeMap.put(pSPFStyleCode.getPSPFSTYLECODENAME(), pSPFStyleCode);
            }
            if (bHasStyleCode) {
                Vector vector2 = new Vector();
                callResult = psPFViewTemplDataCtrl.Select(cond, vector2, PSPFViewTempl.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5c55\u73b0\u6837\u5f0f\u89c6\u56fe\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (Object psPFViewTempl : vector2) {
                    String strTag;
                    if (StringHelper.IsNullOrEmpty((String)((PSPFViewTempl)((Object)psPFViewTempl)).getTEMPLCODE2()) || templPSPFViewTemplMap.containsKey(strTag = StringHelper.Format((String)"%1$s_%2$s", (Object)((PSPFViewTempl)((Object)psPFViewTempl)).getPSVIEWTYPEID(), (Object)((PSPFViewTempl)((Object)psPFViewTempl)).getPSPFPUBCODEID()))) continue;
                    templPSPFViewTemplMap.put(strTag, psPFViewTempl);
                }
            }
            PSPFStyle pSPFStyle = new PSPFStyle();
            pSPFStyle.setPSPFSTYLEID(strTemplPSPFStyleId);
            callResult = this.Get(pSPFStyle);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7ee7\u627f\u6837\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            templPSPFStyleMap.put(strTemplPSPFStyleId, pSPFStyle);
            strTemplPSPFStyleId = pSPFStyle.getTEMPLPSPFSTYLEID();
        }
        cond.Reset();
        cond.setParamValue("PSPFSTYLEID", (Object)psPFStyle.getPSPFSTYLEID());
        Vector psPFViewTempls = new Vector();
        callResult = psPFViewTemplDataCtrl.Select(cond, psPFViewTempls, PSPFViewTempl.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5c55\u73b0\u6837\u5f0f\u89c6\u56fe\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSPFViewTempl pSPFViewTempl : psPFViewTempls) {
            String strViewTemplTag = StringHelper.Format((String)"%1$s_%2$s", (Object)pSPFViewTempl.getPSVIEWTYPEID(), (Object)pSPFViewTempl.getPSPFPUBCODEID());
            PSPFViewTempl templPSPFViewTempl = (PSPFViewTempl)((Object)templPSPFViewTemplMap.remove(strViewTemplTag));
            String strTEMPLCODE = pSPFViewTempl.getTEMPLCODE2();
            if (StringHelper.IsNullOrEmpty((String)strTEMPLCODE) && templPSPFViewTempl != null) {
                strTEMPLCODE = templPSPFViewTempl.getTEMPLCODE2();
            }
            int i = 0;
            while (i < 10) {
                boolean bChanged = false;
                for (PSPFStyleCode psPFStyleCode : psPFStyleCodes) {
                    String strTag = StringHelper.Format((String)"<#SRFINC(%1$s)>", (Object)psPFStyleCode.getPSPFSTYLECODENAME().toUpperCase());
                    if (strTEMPLCODE.indexOf(strTag) == -1) continue;
                    strTEMPLCODE = strTEMPLCODE.replace(strTag, psPFStyleCode.getSTYLECODE());
                    bChanged = true;
                }
                if (!bChanged) break;
                ++i;
            }
            if (StringHelper.Compare((String)strTEMPLCODE, (String)pSPFViewTempl.getTEMPLCODE(), (boolean)false) == 0) continue;
            pSPFViewTempl.setTEMPLCODE(strTEMPLCODE);
            callResult = psPFViewTemplDataCtrl.Save(false, (BaseDataEntity)pSPFViewTempl);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u5408\u5e76\u5c55\u73b0\u6837\u5f0f\u89c6\u56fe\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (templPSPFViewTemplMap.size() > 0) {
            for (Map.Entry entry : templPSPFViewTemplMap.entrySet()) {
                String strTEMPLCODE = ((PSPFViewTempl)((Object)entry.getValue())).getTEMPLCODE2();
                int i = 0;
                while (i < 10) {
                    boolean bChanged = false;
                    for (PSPFStyleCode psPFStyleCode : psPFStyleCodes) {
                        String strTag = StringHelper.Format((String)"<#SRFINC(%1$s)>", (Object)psPFStyleCode.getPSPFSTYLECODENAME().toUpperCase());
                        if (strTEMPLCODE.indexOf(strTag) == -1) continue;
                        strTEMPLCODE = strTEMPLCODE.replace(strTag, psPFStyleCode.getSTYLECODE());
                        bChanged = true;
                    }
                    if (!bChanged) break;
                    ++i;
                }
                String strCode1 = strTEMPLCODE.replace("\r\n", "\n").trim();
                String strCode2 = ((PSPFViewTempl)((Object)entry.getValue())).getTEMPLCODE().replace("\r\n", "\n").trim();
                if (StringHelper.Compare((String)strCode1, (String)strCode2, (boolean)false) == 0) continue;
                PSPFViewTempl psPFViewTempl = new PSPFViewTempl();
                ((PSPFViewTempl)((Object)entry.getValue())).CopyTo(psPFViewTempl, false);
                psPFViewTempl.setPSPFSTYLEID(psPFStyle.getPSPFSTYLEID());
                psPFViewTempl.setPSPFSTYLENAME(psPFStyle.getPSPFSTYLENAME());
                psPFViewTempl.setTEMPLCODE2("");
                psPFViewTempl.setTEMPLCODE(strTEMPLCODE);
                psPFViewTempl.RemoveParam("PSPFVIEWTEMPLID");
                psPFViewTempl.RemoveParam("PSPFVIEWTEMPLNAME");
                callResult = psPFViewTemplDataCtrl.Save(true, (BaseDataEntity)psPFViewTempl);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u65b0\u5efa\u5c55\u73b0\u6837\u5f0f\u89c6\u56fe\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        if ((callResult = psPFAppTemplDataCtrl.Select(cond, vector = new Vector(), PSPFAppTempl.class.getName())).isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5c55\u73b0\u6837\u5f0f\u5e94\u7528\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSPFAppTempl psPFAppTempl : vector) {
            String strTEMPLCODE = psPFAppTempl.getTEMPLCODE2();
            int i = 0;
            while (i < 10) {
                boolean bChanged = false;
                for (PSPFStyleCode psPFStyleCode : psPFStyleCodes) {
                    String strTag = StringHelper.Format((String)"<#SRFINC(%1$s)>", (Object)psPFStyleCode.getPSPFSTYLECODENAME().toUpperCase());
                    if (strTEMPLCODE.indexOf(strTag) == -1) continue;
                    strTEMPLCODE = strTEMPLCODE.replace(strTag, psPFStyleCode.getSTYLECODE());
                    bChanged = true;
                }
                if (!bChanged) break;
                ++i;
            }
            if (StringHelper.Compare((String)strTEMPLCODE, (String)psPFAppTempl.getTEMPLCODE(), (boolean)false) == 0) continue;
            psPFAppTempl.setTEMPLCODE(strTEMPLCODE);
            callResult = psPFAppTemplDataCtrl.Save(false, (BaseDataEntity)psPFAppTempl);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u5408\u5e76\u5c55\u73b0\u6837\u5f0f\u89c6\u56fe\u6a21\u7248\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    public CallResult publishStyle(BaseDataEntity dataEntity) {
        CallResult callResult = this.mergeCode(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSPFStyle psPFStyle = new PSPFStyle();
            psPFStyle.proxy(dataEntity);
            this.getPSModelStorage().getPSPF(psPFStyle.getPSPFID()).resetPSPFStyle(psPFStyle.getPSPFSTYLEID());
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u53d1\u5e03\u5e94\u7528\u6a21\u7248\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    @Override
    public String getTemplFolder(BaseDataEntity dataEntity) throws Exception {
        PSPFStyle psPFStyle = new PSPFStyle();
        psPFStyle.proxy(dataEntity);
        PSPF psPF = new PSPF();
        psPF.setPSPFID(psPFStyle.getPSPFID());
        IPSTemplDataCtrl iPSTemplDataCtrl = (IPSTemplDataCtrl)this.GetRelatedDataCtrl("DE1503");
        String strRootFolder = iPSTemplDataCtrl.getTemplFolder(psPF);
        return StringHelper.Format((String)"%1$s%2$s%3$s%2$s%4$s", (Object)strRootFolder, (Object)File.separator, (Object)this.GetDEHelper().getName(), (Object)psPFStyle.getSTYLECODE());
    }

    @Override
    protected void onExportTempl(BaseDataEntity dataEntity) throws Exception {
        super.onExportTempl(dataEntity);
        String strPSPFStyleId = dataEntity.getParamStringValue("PSPFSTYLEID", "");
        IDEDataCtrl iPSPFCtrlTemplDataCtrl = this.GetRelatedDataCtrl("DE1802");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSPFSTYLEID", (Object)strPSPFStyleId);
        Vector psPFCtrlTemplList = new Vector();
        iPSPFCtrlTemplDataCtrl.Select(cond, psPFCtrlTemplList);
        for (BaseDataEntity baseDataEntity : psPFCtrlTemplList) {
            iPSPFCtrlTemplDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
        IDEDataCtrl iPSPFViewTemplDataCtrl = this.GetRelatedDataCtrl("DE1801");
        cond = new BaseDataEntity();
        cond.setParamValue("PSPFSTYLEID", (Object)strPSPFStyleId);
        Vector psPFViewTemplList = new Vector();
        iPSPFViewTemplDataCtrl.Select(cond, psPFViewTemplList);
        for (BaseDataEntity baseDataEntity : psPFViewTemplList) {
            iPSPFViewTemplDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
        IDEDataCtrl iPSPFAppTemplDataCtrl = this.GetRelatedDataCtrl("DE1808");
        cond = new BaseDataEntity();
        cond.setParamValue("PSPFSTYLEID", (Object)strPSPFStyleId);
        Vector psPFAppTemplList = new Vector();
        iPSPFAppTemplDataCtrl.Select(cond, psPFAppTemplList);
        for (BaseDataEntity baseDataEntity : psPFAppTemplList) {
            iPSPFAppTemplDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
        IDEDataCtrl iPSPFStyleCodeDataCtrl = this.GetRelatedDataCtrl("DE1800");
        cond = new BaseDataEntity();
        cond.setParamValue("PSPFSTYLEID", (Object)strPSPFStyleId);
        Vector psPFStyleCodeList = new Vector();
        iPSPFStyleCodeDataCtrl.Select(cond, psPFStyleCodeList);
        for (BaseDataEntity baseDataEntity : psPFStyleCodeList) {
            iPSPFStyleCodeDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
        IDEDataCtrl iPSPFEditorTemplDataCtrl = this.GetRelatedDataCtrl("DE1804");
        cond = new BaseDataEntity();
        cond.setParamValue("PSPFSTYLEID", (Object)strPSPFStyleId);
        Vector psPFEditorTemplList = new Vector();
        iPSPFEditorTemplDataCtrl.Select(cond, psPFEditorTemplList);
        for (BaseDataEntity baseDataEntity : psPFEditorTemplList) {
            iPSPFEditorTemplDataCtrl.CustomCall("EXPORTTEMPL", baseDataEntity);
        }
    }

    public CallResult CopyDetail(BaseDataEntity dataEntity, Object srcKey) {
        CallResult callResult = new CallResult();
        try {
            BaseDataEntity cond;
            IDEDataCtrl psPFStyleCodeDataCtrl = this.GetRelatedDataCtrl("DE1800");
            IDEDataCtrl psPFViewTemplDataCtrl = this.GetRelatedDataCtrl("DE1801");
            IDEDataCtrl psPFCtrlTemplDataCtrl = this.GetRelatedDataCtrl("DE1802");
            IDEDataCtrl psPFCtrlTemplDetailDataCtrl = this.GetRelatedDataCtrl("DE1803");
            IDEDataCtrl psPFEditorTemplDataCtrl = this.GetRelatedDataCtrl("DE1804");
            IDEDataCtrl psPFUIActionTemplDataCtrl = this.GetRelatedDataCtrl("DE1805");
            IDEDataCtrl psPFViewLogicTemplDataCtrl = this.GetRelatedDataCtrl("DE1806");
            IDEDataCtrl psPFAppTemplDataCtrl = this.GetRelatedDataCtrl("DE1808");
            IDEDataCtrl psPFStylePrjDataCtrl = this.GetRelatedDataCtrl("DE1597");
            IDEDataCtrl psPFCodeFolderDataCtrl = this.GetRelatedDataCtrl("DE1592");
            IDEDataCtrl psPFPubCodeDataCtrl = this.GetRelatedDataCtrl("DE1596");
            IDEDataCtrl psPFStylePkgDataCtrl = this.GetRelatedDataCtrl("DE1674");
            IDEDataCtrl psPFPkgDataCtrl = this.GetRelatedDataCtrl("DE1672");
            IDEDataCtrl psPFPkgVerDataCtrl = this.GetRelatedDataCtrl("DE1673");
            IDEDataCtrl psPFStyleDataCtrl = this.GetRelatedDataCtrl("DE1595");
            String strPSPFId = dataEntity.getParamStringValue("PSPFID", "");
            String strPSPFName = dataEntity.getParamStringValue("PSPFNAME", "");
            String strPSPFStyleId = dataEntity.getParamStringValue("PSPFSTYLEID", "");
            String strPSPFStyleName = dataEntity.getParamStringValue("PSPFSTYLENAME", "");
            PSPFStyle psPFStyle = new PSPFStyle();
            psPFStyle.setPSPFSTYLEID((String)srcKey);
            callResult = psPFStyleDataCtrl.Get((BaseDataEntity)psPFStyle);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6e90\u6837\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, PSPFPubCode> clonePSPFPubCodeMap = null;
            HashMap<String, PSPFPkg> clonePSPFPkgMap = null;
            HashMap<String, PSPFPkgVer> clonePSPFPkgVerMap = null;
            if (StringHelper.Compare((String)psPFStyle.getPSPFID(), (String)strPSPFId, (boolean)false) != 0) {
                Iterator strPSPFPubCodeName;
                cond = new BaseDataEntity();
                cond.Reset();
                cond.set("PSPFID", (Object)psPFStyle.getPSPFID());
                Vector psPFPubCodeList = new Vector();
                callResult = psPFPubCodeDataCtrl.Select(cond, psPFPubCodeList, PSPFPubCode.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                cond.Reset();
                cond.set("PSPFID", (Object)strPSPFId);
                Vector psPFPubCodeList2 = new Vector();
                callResult = psPFPubCodeDataCtrl.Select(cond, psPFPubCodeList2, PSPFPubCode.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u7c7b\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                clonePSPFPubCodeMap = new HashMap<String, PSPFPubCode>();
                block2: for (PSPFPubCode psPFPubCode : psPFPubCodeList) {
                    String strPSPFPubCodeId = psPFPubCode.getPSPFPUBCODEID();
                    strPSPFPubCodeName = psPFPubCode.getPSPFPUBCODENAME();
                    for (PSPFPubCode clonePSPFPubCode : psPFPubCodeList2) {
                        String strPSPFPubCodeName2 = clonePSPFPubCode.getPSPFPUBCODENAME();
                        if (StringHelper.Compare((String)((Object)strPSPFPubCodeName), (String)strPSPFPubCodeName2, (boolean)false) != 0) continue;
                        clonePSPFPubCodeMap.put(strPSPFPubCodeId, clonePSPFPubCode);
                        continue block2;
                    }
                }
                cond.Reset();
                cond.set("PSPFID", (Object)psPFStyle.getPSPFID());
                Vector psPFPkgList = new Vector();
                callResult = psPFPkgDataCtrl.Select(cond, psPFPkgList, PSPFPkg.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7ec4\u4ef6\u5305\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                cond.Reset();
                cond.set("PSPFID", (Object)strPSPFId);
                Vector psPFPkgList2 = new Vector();
                callResult = psPFPkgDataCtrl.Select(cond, psPFPkgList2, PSPFPkg.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7ec4\u4ef6\u5305\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                clonePSPFPkgMap = new HashMap<String, PSPFPkg>();
                strPSPFPubCodeName = psPFPkgList.iterator();
                block4: while (strPSPFPubCodeName.hasNext()) {
                    PSPFPkg psPFPkg = (PSPFPkg)((Object)strPSPFPubCodeName.next());
                    String strPSPFPkgId = psPFPkg.getPSPFPKGID();
                    String strPSPFPkgName = psPFPkg.getPSPFPKGNAME();
                    for (PSPFPkg clonePSPFPkg : psPFPkgList2) {
                        String strPSPFPkgName2 = clonePSPFPkg.getPSPFPKGNAME();
                        if (StringHelper.Compare((String)strPSPFPkgName, (String)strPSPFPkgName2, (boolean)false) != 0) continue;
                        clonePSPFPkgMap.put(strPSPFPkgId, clonePSPFPkg);
                        continue block4;
                    }
                }
                clonePSPFPkgVerMap = new HashMap<String, PSPFPkgVer>();
                for (String strPSPFPkgId : clonePSPFPkgMap.keySet()) {
                    PSPFPkg clonePSPFPkg = (PSPFPkg)((Object)clonePSPFPkgMap.get(strPSPFPkgId));
                    cond.Reset();
                    cond.set("PSPFPKGID", (Object)strPSPFPkgId);
                    Vector psPFPkgVerList = new Vector();
                    callResult = psPFPkgVerDataCtrl.Select(cond, psPFPkgVerList, PSPFPkgVer.class.getName());
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7ec4\u4ef6\u5305\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    cond.Reset();
                    cond.set("PSPFPKGID", (Object)clonePSPFPkg.getPSPFPKGID());
                    Vector psPFPkgVerList2 = new Vector();
                    callResult = psPFPkgVerDataCtrl.Select(cond, psPFPkgVerList2, PSPFPkgVer.class.getName());
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7ec4\u4ef6\u5305\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    block7: for (Object psPFPkgVer : psPFPkgVerList) {
                        String strPSPFPkgVerId = ((PSPFPkgVer)((Object)psPFPkgVer)).getPSPFPKGVERID();
                        String strPSPFPkgVerName = ((PSPFPkgVer)((Object)psPFPkgVer)).getPSPFPKGVERNAME();
                        for (PSPFPkgVer clonePSPFPkgVer : psPFPkgVerList2) {
                            String strPSPFPkgVerName2 = clonePSPFPkgVer.getPSPFPKGVERNAME();
                            if (StringHelper.Compare((String)strPSPFPkgVerName, (String)strPSPFPkgVerName2, (boolean)false) != 0) continue;
                            clonePSPFPkgVerMap.put(strPSPFPkgVerId, clonePSPFPkgVer);
                            continue block7;
                        }
                    }
                }
            }
            cond = new BaseDataEntity();
            cond.set("PSPFSTYLEID", srcKey);
            Vector psPFStyleCodeList = new Vector();
            callResult = psPFStyleCodeDataCtrl.Select(cond, psPFStyleCodeList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4ee3\u7801\u5b8f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psPFStyleCode : psPFStyleCodeList) {
                PSPFStyleCode clonePSPFStyleCode = new PSPFStyleCode();
                psPFStyleCode.CopyTo((BaseDataEntity)clonePSPFStyleCode, false);
                clonePSPFStyleCode.RemoveParam("PSPFSTYLECODEID");
                clonePSPFStyleCode.setPSPFSTYLEID(strPSPFStyleId);
                clonePSPFStyleCode.setPSPFSTYLENAME(strPSPFStyleName);
                callResult = psPFStyleCodeDataCtrl.Save(true, (BaseDataEntity)clonePSPFStyleCode);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u4ee3\u7801\u5b8f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            cond.Reset();
            cond.set("PSPFSTYLEID", srcKey);
            Vector psPFStylePkgList = new Vector();
            callResult = psPFStylePkgDataCtrl.Select(cond, psPFStylePkgList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6837\u5f0f\u7ec4\u4ef6\u5305\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psPFStylePkg : psPFStylePkgList) {
                PSPFStylePkg clonePSPFStylePkg = new PSPFStylePkg();
                psPFStylePkg.CopyTo((BaseDataEntity)clonePSPFStylePkg, false);
                clonePSPFStylePkg.RemoveParam("PSPFSTYLEPKGID");
                clonePSPFStylePkg.setPSPFSTYLEID(strPSPFStyleId);
                clonePSPFStylePkg.setPSPFSTYLENAME(strPSPFStyleName);
                if (clonePSPFPkgMap != null) {
                    PSPFPkg clonePSPFPkg = (PSPFPkg)((Object)clonePSPFPkgMap.get(clonePSPFStylePkg.getPSPFPKGID()));
                    if (clonePSPFPkg == null) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6e90\u524d\u7aef\u7ec4\u4ef6\u5305[%1$s]\u5bf9\u5e94\u7684\u7ec4\u4ef6\u5305", (Object)clonePSPFStylePkg.getPSPFPKGID()));
                    }
                    clonePSPFStylePkg.setPSPFPKGID(clonePSPFPkg.getPSPFPKGID());
                    clonePSPFStylePkg.setPSPFPKGNAME(clonePSPFPkg.getPSPFPKGNAME());
                }
                if (clonePSPFPkgVerMap != null) {
                    PSPFPkgVer clonePSPFPkgVer = (PSPFPkgVer)((Object)clonePSPFPkgVerMap.get(clonePSPFStylePkg.getPSPFPKGVERID()));
                    if (clonePSPFPkgVer == null) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6e90\u524d\u7aef\u7ec4\u4ef6\u5305\u7248\u672c[%1$s]\u5bf9\u5e94\u7684\u7ec4\u4ef6\u5305\u7248\u672c", (Object)clonePSPFStylePkg.getPSPFPKGVERID()));
                    }
                    clonePSPFStylePkg.setPSPFPKGVERID(clonePSPFPkgVer.getPSPFPKGVERID());
                    clonePSPFStylePkg.setPSPFPKGVERNAME(clonePSPFPkgVer.getPSPFPKGVERNAME());
                }
                if (!(callResult = psPFStylePkgDataCtrl.Save(true, (BaseDataEntity)clonePSPFStylePkg)).isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u6837\u5f0f\u7ec4\u4ef6\u5305\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            cond.Reset();
            cond.set("PSPFSTYLEID", srcKey);
            Vector psPFViewTemplList = new Vector();
            callResult = psPFViewTemplDataCtrl.Select(cond, psPFViewTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psPFViewTempl : psPFViewTemplList) {
                PSPFViewTempl clonePSPFViewTempl = new PSPFViewTempl();
                psPFViewTempl.CopyTo((BaseDataEntity)clonePSPFViewTempl, false);
                clonePSPFViewTempl.RemoveParam("PSPFVIEWTEMPLID");
                clonePSPFViewTempl.RemoveParam("PSPFVIEWTEMPLNAME");
                clonePSPFViewTempl.setPSPFSTYLEID(strPSPFStyleId);
                clonePSPFViewTempl.setPSPFSTYLENAME(strPSPFStyleName);
                if (clonePSPFPubCodeMap != null) {
                    PSPFPubCode clonePSPFPubCode;
                    clonePSPFPubCode = (PSPFPubCode)((Object)clonePSPFPubCodeMap.get(clonePSPFViewTempl.getPSPFPUBCODEID()));
                    clonePSPFViewTempl.setPSPFPUBCODEID(clonePSPFPubCode.getPSPFPUBCODEID());
                    clonePSPFViewTempl.setPSPFPUBCODENAME(clonePSPFPubCode.getPSPFPUBCODENAME());
                }
                clonePSPFViewTempl.setPSPFID(strPSPFId);
                clonePSPFViewTempl.setPSPFNAME(strPSPFName);
                callResult = psPFViewTemplDataCtrl.Save(true, (BaseDataEntity)clonePSPFViewTempl);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u89c6\u56fe\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            Vector psPFCtrlTemplList = new Vector();
            cond.Reset();
            cond.set("PSPFSTYLEID", srcKey);
            callResult = psPFCtrlTemplDataCtrl.Select(cond, psPFCtrlTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u4ef6\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psPFCtrlTempl : psPFCtrlTemplList) {
                PSPFCtrlTempl clonePSPFCtrlTempl = new PSPFCtrlTempl();
                psPFCtrlTempl.CopyTo((BaseDataEntity)clonePSPFCtrlTempl, false);
                clonePSPFCtrlTempl.RemoveParam("PSPFCTRLTEMPLID");
                clonePSPFCtrlTempl.RemoveParam("PSPFCTRLTEMPLNAME");
                clonePSPFCtrlTempl.setPSPFSTYLEID(strPSPFStyleId);
                clonePSPFCtrlTempl.setPSPFSTYLENAME(strPSPFStyleName);
                if (clonePSPFPubCodeMap != null) {
                    PSPFPubCode clonePSPFPubCode = (PSPFPubCode)((Object)clonePSPFPubCodeMap.get(clonePSPFCtrlTempl.getPSPFPUBCODEID()));
                    clonePSPFCtrlTempl.setPSPFPUBCODEID(clonePSPFPubCode.getPSPFPUBCODEID());
                    clonePSPFCtrlTempl.setPSPFPUBCODENAME(clonePSPFPubCode.getPSPFPUBCODENAME());
                }
                clonePSPFCtrlTempl.setPSPFID(strPSPFId);
                clonePSPFCtrlTempl.setPSPFNAME(strPSPFName);
                callResult = psPFCtrlTemplDataCtrl.Save(true, (BaseDataEntity)clonePSPFCtrlTempl);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u90e8\u4ef6\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                Vector psPFCtrlTemplDetailList = new Vector();
                cond.Reset();
                cond.set("PSPFCTRLTEMPLID", psPFCtrlTempl.getParamValue("PSPFCTRLTEMPLID"));
                callResult = psPFCtrlTemplDetailDataCtrl.Select(cond, psPFCtrlTemplDetailList);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u90e8\u4ef6\u6a21\u677f\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (BaseDataEntity psPFCtrlTemplDetail : psPFCtrlTemplDetailList) {
                    PSPFCtrlTemplDetail clonePSPFCtrlTemplDetail = new PSPFCtrlTemplDetail();
                    psPFCtrlTemplDetail.CopyTo((BaseDataEntity)clonePSPFCtrlTemplDetail, false);
                    clonePSPFCtrlTemplDetail.RemoveParam("PSPFCTDETAILID");
                    clonePSPFCtrlTemplDetail.setPSPFCTRLTEMPLID(clonePSPFCtrlTempl.getPSPFCTRLTEMPLID());
                    callResult = psPFCtrlTemplDetailDataCtrl.Save(true, (BaseDataEntity)clonePSPFCtrlTemplDetail);
                    if (!callResult.isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u90e8\u4ef6\u6a21\u677f\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            cond.Reset();
            cond.set("PSPFSTYLEID", srcKey);
            Vector psPFEditorTemplList = new Vector();
            callResult = psPFEditorTemplDataCtrl.Select(cond, psPFEditorTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7f16\u8f91\u5668\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psPFEditorTempl : psPFEditorTemplList) {
                PSPFEditorTempl clonePSPFEditorTempl = new PSPFEditorTempl();
                psPFEditorTempl.CopyTo((BaseDataEntity)clonePSPFEditorTempl, false);
                clonePSPFEditorTempl.RemoveParam("PSPFEDITORTEMPLID");
                clonePSPFEditorTempl.RemoveParam("PSPFEDITORTEMPLNAME");
                clonePSPFEditorTempl.setPSPFSTYLEID(strPSPFStyleId);
                clonePSPFEditorTempl.setPSPFSTYLENAME(strPSPFStyleName);
                if (clonePSPFPubCodeMap != null) {
                    PSPFPubCode clonePSPFPubCode = (PSPFPubCode)((Object)clonePSPFPubCodeMap.get(clonePSPFEditorTempl.getPSPFPUBCODEID()));
                    clonePSPFEditorTempl.setPSPFPUBCODEID(clonePSPFPubCode.getPSPFPUBCODEID());
                    clonePSPFEditorTempl.setPSPFPUBCODENAME(clonePSPFPubCode.getPSPFPUBCODENAME());
                }
                clonePSPFEditorTempl.setPSPFID(strPSPFId);
                clonePSPFEditorTempl.setPSPFNAME(strPSPFName);
                callResult = psPFEditorTemplDataCtrl.Save(true, (BaseDataEntity)clonePSPFEditorTempl);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7f16\u8f91\u5668\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            cond.Reset();
            cond.set("PSPFSTYLEID", srcKey);
            Vector psPFUIActionTemplList = new Vector();
            callResult = psPFUIActionTemplDataCtrl.Select(cond, psPFUIActionTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u754c\u9762\u884c\u4e3a\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psPFUIActionTempl : psPFUIActionTemplList) {
                PSPFUIActionTempl clonePSPFUIActionTempl = new PSPFUIActionTempl();
                psPFUIActionTempl.CopyTo((BaseDataEntity)clonePSPFUIActionTempl, false);
                clonePSPFUIActionTempl.RemoveParam("PSPFUATEMPLID");
                clonePSPFUIActionTempl.RemoveParam("PSPFUATEMPLNAME");
                clonePSPFUIActionTempl.setPSPFSTYLEID(strPSPFStyleId);
                clonePSPFUIActionTempl.setPSPFSTYLENAME(strPSPFStyleName);
                if (clonePSPFPubCodeMap != null) {
                    PSPFPubCode clonePSPFPubCode = (PSPFPubCode)((Object)clonePSPFPubCodeMap.get(clonePSPFUIActionTempl.getPSPFPUBCODEID()));
                    clonePSPFUIActionTempl.setPSPFPUBCODEID(clonePSPFPubCode.getPSPFPUBCODEID());
                    clonePSPFUIActionTempl.setPSPFPUBCODENAME(clonePSPFPubCode.getPSPFPUBCODENAME());
                }
                clonePSPFUIActionTempl.setPSPFID(strPSPFId);
                clonePSPFUIActionTempl.setPSPFNAME(strPSPFName);
                callResult = psPFUIActionTemplDataCtrl.Save(true, (BaseDataEntity)clonePSPFUIActionTempl);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u754c\u9762\u884c\u4e3a\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            cond.Reset();
            cond.set("PSPFSTYLEID", srcKey);
            Vector psPFViewLogicTemplList = new Vector();
            callResult = psPFViewLogicTemplDataCtrl.Select(cond, psPFViewLogicTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u903b\u8f91\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psPFViewLogicTempl : psPFViewLogicTemplList) {
                PSPFViewLogicTempl clonePSPFViewLogicTempl = new PSPFViewLogicTempl();
                psPFViewLogicTempl.CopyTo((BaseDataEntity)clonePSPFViewLogicTempl, false);
                clonePSPFViewLogicTempl.RemoveParam("PSPFVLTEMPLID");
                clonePSPFViewLogicTempl.RemoveParam("PSPFVLTEMPLNAME");
                clonePSPFViewLogicTempl.setPSPFSTYLEID(strPSPFStyleId);
                clonePSPFViewLogicTempl.setPSPFSTYLENAME(strPSPFStyleName);
                if (clonePSPFPubCodeMap != null) {
                    PSPFPubCode clonePSPFPubCode = (PSPFPubCode)((Object)clonePSPFPubCodeMap.get(clonePSPFViewLogicTempl.getPSPFPUBCODEID()));
                    clonePSPFViewLogicTempl.setPSPFPUBCODEID(clonePSPFPubCode.getPSPFPUBCODEID());
                    clonePSPFViewLogicTempl.setPSPFPUBCODENAME(clonePSPFPubCode.getPSPFPUBCODENAME());
                }
                clonePSPFViewLogicTempl.setPSPFID(strPSPFId);
                clonePSPFViewLogicTempl.setPSPFNAME(strPSPFName);
                callResult = psPFViewLogicTemplDataCtrl.Save(true, (BaseDataEntity)clonePSPFViewLogicTempl);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u89c6\u56fe\u903b\u8f91\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            cond.Reset();
            cond.set("PSPFSTYLEID", srcKey);
            Vector psPFAppTemplList = new Vector();
            callResult = psPFAppTemplDataCtrl.Select(cond, psPFAppTemplList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u4ee3\u7801\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psPFAppTempl : psPFAppTemplList) {
                PSPFAppTempl clonePSPFAppTempl = new PSPFAppTempl();
                psPFAppTempl.CopyTo((BaseDataEntity)clonePSPFAppTempl, false);
                clonePSPFAppTempl.RemoveParam("PSPFAPPTEMPLID");
                clonePSPFAppTempl.RemoveParam("PSPFAPPTEMPLNAME");
                clonePSPFAppTempl.setPSPFSTYLEID(strPSPFStyleId);
                clonePSPFAppTempl.setPSPFSTYLENAME(strPSPFStyleName);
                if (clonePSPFPubCodeMap != null) {
                    PSPFPubCode clonePSPFPubCode = (PSPFPubCode)((Object)clonePSPFPubCodeMap.get(clonePSPFAppTempl.getPSPFPUBCODEID()));
                    clonePSPFAppTempl.setPSPFPUBCODEID(clonePSPFPubCode.getPSPFPUBCODEID());
                    clonePSPFAppTempl.setPSPFPUBCODENAME(clonePSPFPubCode.getPSPFPUBCODENAME());
                }
                clonePSPFAppTempl.setPSPFID(strPSPFId);
                clonePSPFAppTempl.setPSPFNAME(strPSPFName);
                callResult = psPFAppTemplDataCtrl.Save(true, (BaseDataEntity)clonePSPFAppTempl);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u5e94\u7528\u4ee3\u7801\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            cond.Reset();
            cond.set("PSPFSTYLEID", srcKey);
            Vector psPFStylePrjList = new Vector();
            callResult = psPFStylePrjDataCtrl.Select(cond, psPFStylePrjList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u53d1\u5e03\u9879\u76ee\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (BaseDataEntity psPFStylePrj : psPFStylePrjList) {
                PSPFStylePrj clonePSPFStylePrj = new PSPFStylePrj();
                psPFStylePrj.CopyTo((BaseDataEntity)clonePSPFStylePrj, false);
                clonePSPFStylePrj.RemoveParam("PSPFSTYLEPRJID");
                clonePSPFStylePrj.setPSPFSTYLEID(strPSPFStyleId);
                clonePSPFStylePrj.setPSPFSTYLENAME(strPSPFStyleName);
                callResult = psPFStylePrjDataCtrl.Save(true, (BaseDataEntity)clonePSPFStylePrj);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u53d1\u5e03\u9879\u76ee\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
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
            final PSPFStyle psPFStyle = new PSPFStyle();
            dataEntity.CopyTo((BaseDataEntity)psPFStyle, false);
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSPFStyleDataCtrl.this.onExpStyle(psPFStyle);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u524d\u7aef\u5e94\u7528\u6837\u5f0f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onExpStyle(PSPFStyle psPFStyle) throws Exception {
        PSPFStyleService psPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class);
        net.ibizsys.pscore.srv.config.entity.PSPFStyle psPFStyleV5 = new net.ibizsys.pscore.srv.config.entity.PSPFStyle();
        psPFStyleV5.setPSPFStyleId(psPFStyle.getPSPFSTYLEID());
        psPFStyleV5.set("SRFPRJFOLDER", (Object)StringHelper.Format((String)"%1$s%2$sPSPFSTYLEV2%2$s%3$s", (Object)this.strCodeFolder, (Object)File.separator, (Object)psPFStyleV5.getPSPFStyleId()));
        psPFStyleService.expStyle(psPFStyleV5);
    }

    public CallResult impStyle(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSPFStyle psPFStyle = new PSPFStyle();
            dataEntity.CopyTo((BaseDataEntity)psPFStyle, false);
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSPFStyleDataCtrl.this.onImpStyle(psPFStyle);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u5165\u524d\u7aef\u5e94\u7528\u6837\u5f0f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onImpStyle(PSPFStyle psPFStyle) throws Exception {
        PSPFStyleService psPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class);
        net.ibizsys.pscore.srv.config.entity.PSPFStyle psPFStyleV5 = new net.ibizsys.pscore.srv.config.entity.PSPFStyle();
        psPFStyleV5.setPSPFStyleId(psPFStyle.getPSPFSTYLEID());
        psPFStyleV5.set("SRFPRJFOLDER", (Object)StringHelper.Format((String)"%1$s%2$sPSPFSTYLENEW%2$s%3$s", (Object)this.strCodeFolder, (Object)File.separator, (Object)psPFStyleV5.getPSPFStyleId()));
        psPFStyleService.impStyle(psPFStyleV5);
    }

    public CallResult asyncImpStyle(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            PSPFStyle psPFStyle = new PSPFStyle();
            psPFStyle.proxy(dataEntity);
            this.Get(psPFStyle);
            this.onAsyncImpStyle(psPFStyle);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u5165\u5e94\u7528\u4e2d\u5fc3\u524d\u53f0\u6837\u5f0f\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAsyncImpStyle(PSPFStyle psPFStyle) throws Exception {
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        psDCBKTask.setPSDEVCENTERID(psPFStyle.getPSDEVCENTERID());
        psDCBKTask.setPSDEVCENTERNAME(psPFStyle.getPSDEVCENTERNAME());
        psDCBKTask.setPSDCBKTASKNAME(StringHelper.Format((String)"\u5bfc\u5165\u5e94\u7528\u4e2d\u5fc3\u524d\u53f0\u6837\u5f0f\u6a21\u677f[%1$s]", (Object)psPFStyle.getPSPFSTYLENAME()));
        psDCBKTask.setTASKSTATE(10);
        psDCBKTask.setORDERVALUE(100);
        psDCBKTask.setTASKTYPE("IMPPFSTYLE");
        psDCBKTask.setTASKPARAM(psPFStyle.getPSPFSTYLEID());
        IDEDataCtrl psDCBKTaskDataCtrl = this.GetRelatedDataCtrl("DE2984");
        CallResult callResult = psDCBKTaskDataCtrl.Save(true, (BaseDataEntity)psDCBKTask);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u521b\u5efa\u5e94\u7528\u4e2d\u5fc3\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask);
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSPFId = dataEntity.getParamStringValue("PSPFID", "");
        String strPSPFStyleId = dataEntity.getParamStringValue("PSPFSTYLEID", "");
        IPSPF iPSPF = this.getPSModelStorage().getPSPF(strPSPFId);
        iPSPF.resetPSPFStyle(strPSPFStyleId);
        iPSPF.getPSPFStyle(strPSPFStyleId);
    }

    public CallResult mergeDynaDepCode(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.Get(dataEntity);
            PSPFStyle psPFStyle = new PSPFStyle();
            psPFStyle.proxy(dataEntity);
            if (!psPFStyle.getDYNADEPSTYLEFLAG()) {
                throw new Exception("\u6837\u5f0f\u4e0d\u662f\u52a8\u6001\u90e8\u7f72\u6837\u5f0f");
            }
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final net.ibizsys.pscore.srv.config.entity.PSPFStyle psPFStyle2 = new net.ibizsys.pscore.srv.config.entity.PSPFStyle();
            PSDEDataCtrl.convertEntity2(psPFStyle, (IEntity)psPFStyle2);
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSPFStyleDataCtrl.this.onMergeDynaDepCode(psPFStyle2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5408\u5e76\u52a8\u6001\u90e8\u7f72\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onMergeDynaDepCode(net.ibizsys.pscore.srv.config.entity.PSPFStyle psPFStyle) throws Exception {
        PSPFCtrlTemplService psPFCtrlTemplService = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSPFEditorTemplService psPFEditorTemplService = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psPFCtrlTemplService.removeByPSPFStyle(psPFStyle);
        psPFEditorTemplService.removeByPSPFStyle(psPFStyle);
        this.copyPSPFTempls(psPFStyle, psPFStyle.getTemplPSPFStyle());
    }

    protected void copyPSPFTempls(net.ibizsys.pscore.srv.config.entity.PSPFStyle psPFStyle, net.ibizsys.pscore.srv.config.entity.PSPFStyle clonePSPFStyle) throws Exception {
        PSPFCtrlTemplService psPFCtrlTemplService = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSPFEditorTemplService psPFEditorTemplService = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSPFCTDetailService psPFCTDetailService = (PSPFCTDetailService)ServiceGlobal.getService(PSPFCTDetailService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        if (clonePSPFStyle == null) {
            SelectCond selectCond = new SelectCond();
            selectCond.setIsNull("PSPFSTYLEID");
            selectCond.set("PSPFID", (Object)psPFStyle.getPSPFId());
            ArrayList psPFEditorTemplList = psPFEditorTemplService.select((ISelectCond)selectCond);
            for (net.ibizsys.pscore.srv.config.entity.PSPFEditorTempl psPFEditorTempl : psPFEditorTemplList) {
                psPFEditorTempl.resetPSPFEditorTemplId();
                psPFEditorTempl.setPSPFStyleId(psPFStyle.getPSPFStyleId());
                psPFEditorTempl.setPSPFStyleName(psPFStyle.getPSPFStyleName());
                if (psPFEditorTemplService.checkKey((IEntity)psPFEditorTempl) != 0) continue;
                psPFEditorTemplService.create((IEntity)psPFEditorTempl);
            }
        } else {
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSPFSTYLEID", (Object)clonePSPFStyle.getPSPFStyleId());
            selectCond.set("PSPFID", (Object)psPFStyle.getPSPFId());
            ArrayList psPFEditorTemplList = psPFEditorTemplService.select((ISelectCond)selectCond);
            for (net.ibizsys.pscore.srv.config.entity.PSPFEditorTempl psPFEditorTempl : psPFEditorTemplList) {
                psPFEditorTempl.resetPSPFEditorTemplId();
                psPFEditorTempl.setPSPFStyleId(psPFStyle.getPSPFStyleId());
                psPFEditorTempl.setPSPFStyleName(psPFStyle.getPSPFStyleName());
                if (psPFEditorTemplService.checkKey((IEntity)psPFEditorTempl) != 0) continue;
                psPFEditorTemplService.create((IEntity)psPFEditorTempl);
            }
            selectCond = new SelectCond();
            selectCond.set("PSPFSTYLEID", (Object)clonePSPFStyle.getPSPFStyleId());
            selectCond.set("PSPFID", (Object)psPFStyle.getPSPFId());
            ArrayList psPFCtrlTemplList = psPFCtrlTemplService.select((ISelectCond)selectCond);
            for (net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl psPFCtrlTempl : psPFCtrlTemplList) {
                net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl psPFCtrlTempl2 = new net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl();
                psPFCtrlTempl.copyTo((IDataObject)psPFCtrlTempl2, false);
                psPFCtrlTempl2.resetPSPFCtrlTemplId();
                psPFCtrlTempl2.setPSPFStyleId(psPFStyle.getPSPFStyleId());
                psPFCtrlTempl2.setPSPFStyleName(psPFStyle.getPSPFStyleName());
                if (psPFCtrlTemplService.checkKey((IEntity)psPFCtrlTempl2) != 0) continue;
                psPFCtrlTemplService.create((IEntity)psPFCtrlTempl2);
                ArrayList psPFCTDetailList = psPFCtrlTempl.getPSPFCTDetails();
                Iterator iterator = psPFCTDetailList.iterator();
                while (iterator.hasNext()) {
                    PSPFCTDetail psPFCTDetail;
                    PSPFCTDetail psPFCTDetail2 = psPFCTDetail = (PSPFCTDetail)iterator.next();
                    psPFCTDetail2.resetPSPFCTDetailId();
                    psPFCTDetail2.setPSPFCtrlTemplId(psPFCtrlTempl2.getPSPFCtrlTemplId());
                    psPFCTDetail2.setPSPFCtrlTemplName(psPFCtrlTempl2.getPSPFCtrlTemplName());
                    psPFCTDetailService.create((IEntity)psPFCTDetail2, false);
                }
            }
            this.copyPSPFTempls(psPFStyle, clonePSPFStyle.getTemplPSPFStyle());
        }
    }
}

