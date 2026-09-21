/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Deploy.IPSSVNInstRepo;
import SA.SRFDA.PS.Core.DevStudio.StartupExPSSysDevBKTaskImpl;
import SA.SRFDA.PS.Core.DevStudio.SysTemplV2PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.IPSDevSlnSysRuntime;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSDevSln;
import SA.SRFDA.PS.Data.PSDevSlnSys;
import SA.SRFramework.DataEx.CallResult;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SysBeginPubCodePSSysDevBKTaskImpl
extends SysTemplV2PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SysBeginPubCodePSSysDevBKTaskImpl.class);

    @Override
    protected String getCommand(IPSDevSlnSys iPSDevSlnSys, IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst) throws Exception {
        String strCommandFile = this.getCommandFile(iPSDevSlnSys, iPSDevSlnSysDynaInst);
        if (this.getPSSysRunSession() != null) {
            return StringHelper.format((String)"%1$s begin %2$s", (Object)strCommandFile, (Object)this.getPSSysRunSession().getRunMode());
        }
        return StringHelper.format((String)"%1$s begin", (Object)strCommandFile);
    }

    @Override
    protected void onFillTemplateParams(Map<String, Object> paramsMap) throws Exception {
        String strUserName = "\u7cfb\u7edf\u5185\u7f6e\u7528\u6237";
        if (this.getParentPSBKTask() != null) {
            strUserName = this.getParentPSBKTask().getCreateMan();
        }
        String strMemo = strUserName;
        if (this.getParentPSBKTask() != null) {
            strMemo = String.valueOf(strMemo) + " " + this.getParentPSBKTask().getName();
        }
        if (this.getPSSysRunSession() != null) {
            IPSSVNInstRepo iPSSVNInstRepo;
            if (this.getPSSysRunSession().getPSSysSFPub() != null) {
                strMemo = String.valueOf(strMemo) + " [";
                strMemo = String.valueOf(strMemo) + StringHelper.format((String)"%1$s", (Object)this.getPSSysRunSession().getPSSysSFPub().getName());
                if (this.getPSSysRunSession().getPSApplication() != null) {
                    strMemo = String.valueOf(strMemo) + StringHelper.format((String)"\uff0c%1$s", (Object)this.getPSSysRunSession().getPSApplication().getName());
                } else if (this.getPSSysRunSession().getPSSysServiceAPI() != null) {
                    strMemo = String.valueOf(strMemo) + StringHelper.format((String)"\uff0c%1$s", (Object)this.getPSSysRunSession().getPSSysServiceAPI().getName());
                }
                strMemo = String.valueOf(strMemo) + "]";
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSSysRunSession().getMemo())) {
                strMemo = String.valueOf(strMemo) + "\uff0c" + this.getPSSysRunSession().getMemo();
            }
            String strAppResPath = "";
            String strAppResPath2 = "";
            int i = 0;
            while (i < 2) {
                String strResPath;
                IPSApplication iPSApplication = null;
                iPSApplication = i == 0 ? this.getPSSysRunSession().getPSApplication() : this.getPSSysRunSession().getPSApplication2();
                if (iPSApplication != null && iPSApplication.getPSPFStyle() != null && iPSApplication.getPSPFStyle() instanceof IPSPFStyle2 && !StringHelper.isNullOrEmpty((String)(strResPath = iPSApplication.getPSPFStyle().getStyleParam("%RESPATH%", "")))) {
                    HashMap<String, Object> paramsMap2 = new HashMap<String, Object>();
                    paramsMap2.putAll(paramsMap);
                    paramsMap2.put("app", iPSApplication);
                    String strCode = PSTemplHelper.generateCode(strResPath, paramsMap2);
                    if (!PSTemplHelper.hasError(strCode)) {
                        if (i == 0) {
                            strAppResPath = strCode;
                        } else {
                            strAppResPath2 = strCode;
                        }
                    }
                }
                ++i;
            }
            if (!StringHelper.isNullOrEmpty((String)strAppResPath)) {
                paramsMap.put("app_respath", strAppResPath);
            }
            if (!StringHelper.isNullOrEmpty((String)strAppResPath2)) {
                paramsMap.put("app2_respath", strAppResPath2);
            }
            if ((iPSSVNInstRepo = this.getPSSysRunSession().getPSSystem().getPSSVNInstRepo()) != null && iPSSVNInstRepo.getPSSVNServer() != null && StringHelper.compare((String)iPSSVNInstRepo.getSVNType(), (String)"GIT", (boolean)false) == 0 && StringHelper.compare((String)iPSSVNInstRepo.getGitRepo(), (String)"IBIZ", (boolean)false) == 0) {
                paramsMap.put("gituser", iPSSVNInstRepo.getPSSVNServer().getGitUserName());
                paramsMap.put("gitpass", iPSSVNInstRepo.getPSSVNServer().getGitPassword());
            }
        }
        if (!StringHelper.isNullOrEmpty((String)strMemo)) {
            strMemo = strMemo.replace("\r\n", " ");
            strMemo = strMemo.replace("\r", " ");
            strMemo = strMemo.replace("\n", " ");
        }
        if (StringHelper.length((String)strMemo) > 200) {
            strMemo = String.valueOf(strMemo.substring(0, 197)) + "...";
        }
        paramsMap.put("memo", strMemo);
        String strCallbackUrl = this.getCallbackUrl();
        if (!StringHelper.isNullOrEmpty((String)strCallbackUrl)) {
            paramsMap.put("callbackurl", strCallbackUrl);
        }
        if (this.getParentPSBKTask() instanceof StartupExPSSysDevBKTaskImpl) {
            StartupExPSSysDevBKTaskImpl startupExPSSysDevBKTaskImpl = (StartupExPSSysDevBKTaskImpl)this.getParentPSBKTask();
            if (startupExPSSysDevBKTaskImpl.getNodePSDCRegistryItem() != null) {
                paramsMap.put("dstimagename", startupExPSSysDevBKTaskImpl.getNodePSDCRegistryItem().getPSDCRegistryItemName());
                paramsMap.put("packmode", "none");
            } else if (startupExPSSysDevBKTaskImpl.getPSDCRegistryItem() != null) {
                paramsMap.put("dstimagename", startupExPSSysDevBKTaskImpl.getPSDCRegistryItem().getPSDCRegistryItemName());
                paramsMap.put("packmode", "all");
                if (this.getPSSysRunSession() != null && this.getPSSysRunSession().isQuickMode() && startupExPSSysDevBKTaskImpl.getLastPSDCRegistryItem() != null) {
                    paramsMap.put("packmode", "model");
                    paramsMap.put("srcimagename", startupExPSSysDevBKTaskImpl.getLastPSDCRegistryItem().getPSDCRegistryItemName());
                }
            }
        }
        super.onFillTemplateParams(paramsMap);
    }

    protected String getCallbackUrl() {
        PSDevSln psDevSln;
        String strDeploySystemId;
        String strRunMode;
        String strImageName;
        HashMap<String, String> params;
        String strDevCallbackUrl;
        block34: {
            String strCallbackUrl;
            CallResult callResult;
            PSDevSlnSys psDevSlnSys;
            block33: {
                block32: {
                    try {
                        String strCallbackUrl2;
                        strDevCallbackUrl = PSTaskServerEnvImpl.getCurrent().getDevCallbackUrl();
                        params = new HashMap<String, String>();
                        strImageName = "";
                        if (this.getParentPSBKTask() instanceof StartupExPSSysDevBKTaskImpl) {
                            PSDCRegistryItem psDCRegistryItem = null;
                            StartupExPSSysDevBKTaskImpl startupExPSSysDevBKTaskImpl = (StartupExPSSysDevBKTaskImpl)this.getParentPSBKTask();
                            if (startupExPSSysDevBKTaskImpl.getNodePSDCRegistryItem() != null) {
                                psDCRegistryItem = startupExPSSysDevBKTaskImpl.getNodePSDCRegistryItem();
                            } else if (startupExPSSysDevBKTaskImpl.getPSDCRegistryItem() != null) {
                                psDCRegistryItem = startupExPSSysDevBKTaskImpl.getPSDCRegistryItem();
                            }
                            if (psDCRegistryItem != null) {
                                params.put("PSDCREGISTRYITEMID", psDCRegistryItem.getPSDCRegistryItemId());
                                strImageName = psDCRegistryItem.getPSDCRegistryItemName();
                            }
                            if (this.getPSSysRunSession() != null) {
                                if (StringHelper.compare((String)startupExPSSysDevBKTaskImpl.getTaskType(), (String)"STARTUPEX5", (boolean)false) == 0) {
                                    if (this.getPSSysRunSession().getPSDevSlnMSDepAPI() != null) {
                                        params.put("PSDEVSLNMSDEPAPIID", this.getPSSysRunSession().getPSDevSlnMSDepAPI().getId());
                                        if (this.getPSSysRunSession().getPSDevSlnMSDepAPI().getPSDCMSPlatform() != null) {
                                            params.put("PSDCMSPLATFORMID", this.getPSSysRunSession().getPSDevSlnMSDepAPI().getPSDCMSPlatform().getId());
                                        }
                                        if (this.getPSSysRunSession().getPSDevSlnMSDepAPI().getPSDCMSPlatformNode() != null) {
                                            params.put("PSDCMSPLATFORMNODEID", this.getPSSysRunSession().getPSDevSlnMSDepAPI().getPSDCMSPlatformNode().getId());
                                        }
                                        if (this.getPSSysRunSession().isDebugMode()) {
                                            params.put("DEBUGMODE", "TRUE");
                                        }
                                    }
                                } else if (StringHelper.compare((String)startupExPSSysDevBKTaskImpl.getTaskType(), (String)"STARTUPEX6", (boolean)false) == 0 && this.getPSSysRunSession().getPSDevSlnMSDepApp() != null) {
                                    params.put("PSDEVSLNMSDEPAPPID", this.getPSSysRunSession().getPSDevSlnMSDepApp().getId());
                                    if (this.getPSSysRunSession().getPSDevSlnMSDepApp().getPSDCMSPlatform() != null) {
                                        params.put("PSDCMSPLATFORMID", this.getPSSysRunSession().getPSDevSlnMSDepApp().getPSDCMSPlatform().getId());
                                    }
                                    if (this.getPSSysRunSession().getPSDevSlnMSDepApp().getPSDCMSPlatformNode() != null) {
                                        params.put("PSDCMSPLATFORMNODEID", this.getPSSysRunSession().getPSDevSlnMSDepApp().getPSDCMSPlatformNode().getId());
                                    }
                                    if (this.getPSSysRunSession().isDebugMode()) {
                                        params.put("DEBUGMODE", "TRUE");
                                    }
                                }
                                if (this.getPSSysRunSession().getPSSystem() != null) {
                                    params.put("PSDEVCENTERID", this.getPSSysRunSession().getPSSystem().getPSDevCenterId());
                                }
                                if (!StringHelper.isNullOrEmpty((String)this.getPSSysRunSession().getRunParam11())) {
                                    params.put("PSDEVSLNPIPELINEID", this.getPSSysRunSession().getRunParam11());
                                }
                            }
                        }
                        strRunMode = "";
                        if (this.getPSSysRunSession() != null) {
                            strRunMode = this.getPSSysRunSession().getRunMode();
                        }
                        psDevSlnSys = new PSDevSlnSys();
                        callResult = this.getPSModelHelper(null).getPSDevSlnSys(this.getPSDevSlnSysId(), psDevSlnSys);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        strDeploySystemId = psDevSlnSys.getDEPLOYSYSID();
                        if (StringHelper.isNullOrEmpty((String)strDeploySystemId)) {
                            strDeploySystemId = psDevSlnSys.getPSDEVSLNSYSNAME().toLowerCase();
                        }
                        if (psDevSlnSys.isENABLECALLBACKNull()) break block32;
                        if (psDevSlnSys.getENABLECALLBACK() && !StringHelper.isNullOrEmpty((String)(strCallbackUrl2 = psDevSlnSys.getCALLBACKURL()))) {
                            return this.getRealCallbackUrl(strCallbackUrl2, this.getPSDevSlnSysId(), psDevSlnSys.getPSDEVSLNID(), strRunMode, strDeploySystemId, strImageName, psDevSlnSys.getCALLBACKTAG(), params);
                        }
                        if (!StringHelper.isNullOrEmpty((String)strDevCallbackUrl)) break block32;
                        return "";
                    }
                    catch (Exception ex) {
                        log.error((Object)StringHelper.format((String)"\u8ba1\u7b97\u56de\u8c03\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                        return "";
                    }
                }
                if (StringHelper.isNullOrEmpty((String)psDevSlnSys.getMAINPSDEVSLNSYSID())) break block33;
                String strMainPSDevSlnSysId = psDevSlnSys.getMAINPSDEVSLNSYSID();
                psDevSlnSys.Reset();
                callResult = this.getPSModelHelper(null).getPSDevSlnSys(strMainPSDevSlnSysId, psDevSlnSys);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                if (psDevSlnSys.isENABLECALLBACKNull()) break block33;
                if (psDevSlnSys.getENABLECALLBACK() && !StringHelper.isNullOrEmpty((String)(strCallbackUrl = psDevSlnSys.getCALLBACKURL()))) {
                    return this.getRealCallbackUrl(strCallbackUrl, this.getPSDevSlnSysId(), psDevSlnSys.getPSDEVSLNID(), strRunMode, strDeploySystemId, strImageName, psDevSlnSys.getCALLBACKTAG(), params);
                }
                if (!StringHelper.isNullOrEmpty((String)strDevCallbackUrl)) break block33;
                return "";
            }
            psDevSln = new PSDevSln();
            callResult = this.getPSModelHelper(null).getPSDevSln(psDevSlnSys.getPSDEVSLNID(), psDevSln);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (psDevSln.isENABLECALLBACKNull()) break block34;
            if (psDevSln.getENABLECALLBACK() && !StringHelper.isNullOrEmpty((String)(strCallbackUrl = psDevSln.getCALLBACKURL()))) {
                return this.getRealCallbackUrl(strCallbackUrl, this.getPSDevSlnSysId(), psDevSln.getPSDEVSLNID(), strRunMode, strDeploySystemId, strImageName, psDevSln.getCALLBACKTAG(), params);
            }
            if (!StringHelper.isNullOrEmpty((String)strDevCallbackUrl)) break block34;
            return "";
        }
        if (!StringHelper.isNullOrEmpty((String)strDevCallbackUrl)) {
            return this.getRealCallbackUrl(strDevCallbackUrl, this.getPSDevSlnSysId(), psDevSln.getPSDEVSLNID(), strRunMode, strDeploySystemId, strImageName, psDevSln.getCALLBACKTAG(), params);
        }
        return "";
    }

    protected String getRealCallbackUrl(String strUrl, String strPSDevSlnSysId, String strDevSlnId, String strRunMode, String strDeploySystemId, String strImage, String strToken, Map<String, String> params) {
        strUrl = strUrl.replace("{psdevslnsysid}", WebUtility.encodeURLParamValue((String)strPSDevSlnSysId)).replace("{psdevslnid}", WebUtility.encodeURLParamValue((String)strDevSlnId)).replace("{runmode}", WebUtility.encodeURLParamValue((String)strRunMode)).replace("{system}", WebUtility.encodeURLParamValue((String)strDeploySystemId)).replace("{image}", WebUtility.encodeURLParamValue((String)strImage)).replace("{token}", WebUtility.encodeURLParamValue((String)strToken));
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String strTag = String.format("{%1$s}", entry.getKey()).toLowerCase();
                String strValue = WebUtility.encodeURLParamValue((String)entry.getValue());
                if (strUrl.indexOf(strTag) != -1) {
                    strUrl = strUrl.replace(strTag, strValue);
                    continue;
                }
                strUrl = strUrl.indexOf("?") == -1 ? String.valueOf(strUrl) + "?" : String.valueOf(strUrl) + "&";
                strUrl = String.valueOf(strUrl) + String.format("%1$s=%2$s", entry.getKey().toUpperCase(), strValue);
            }
        }
        return strUrl;
    }

    @Override
    protected String executeCmd() throws Exception {
        String strResult = super.executeCmd();
        if (StringHelper.isNullOrEmpty((String)this.getPSDynaInstId())) {
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
            ((IPSDevSlnSysRuntime)((Object)iPSDevSlnSys)).reloadSystemTempls();
        }
        return strResult;
    }
}

