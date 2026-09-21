/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSException;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSSysBackService;
import SA.SRFDA.PS.Data.PSSystemModule;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class PSSystemException
extends PSException {
    public static final int ERROR_MODULENOTFOUND = 10000;
    public static final int ERROR_CODELISTNOTFOUND = 10001;
    public static final int ERROR_DATAENTITYNOTFOUND = 10002;
    public static final int ERROR_SYSBACKSERVICENOTFOUND = 10003;
    public static final int ERROR_DERNOTFOUND = 10004;
    public static final int ERROR_SYSMSGTARGETNOTFOUND = 10005;
    public static final int ERROR_SYSMSGQUEUENOTFOUND = 10006;
    public static final int ERROR_THRESHOLDGROUPNOTFOUND = 10007;
    private IPSSystem iPSSystem = null;

    public PSSystemException(IPSSystem iPSSystem, int nErrorCode, String strErrorInfo) {
        super(nErrorCode, strErrorInfo);
        this.setPSSystem(iPSSystem);
    }

    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    protected void setPSSystem(IPSSystem iPSSystem) {
        this.iPSSystem = iPSSystem;
    }

    public static PSSystemException create(IPSSystem iPSSystem, int nErrorCode, Object objArg) throws Exception {
        return PSSystemException.create(iPSSystem, nErrorCode, objArg, null);
    }

    public static PSSystemException create(IPSSystem iPSSystem, int nErrorCode, Object objArg, Object objArg2) throws Exception {
        switch (nErrorCode) {
            case 10001: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSCodeList psCodeList = new PSCodeList();
                CallResult callResult = PSSystemException.getPSModelHelper(iPSSystem).getPSCodeList((String)objArg, psCodeList);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSSystem.getId(), (String)psCodeList.getPSSYSTEMID(), (boolean)false) != 0) {
                        return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u4ee3\u7801\u8868[%2$s]\uff0c\u9519\u8bef\u7684\u7cfb\u7edf[%3$s]", (Object)iPSSystem.getName(), (Object)psCodeList.getPSCODELISTNAME(), (Object)psCodeList.getPSSYSTEMNAME()));
                    }
                    return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u4ee3\u7801\u8868[%2$s]", (Object)iPSSystem.getName(), (Object)psCodeList.getPSCODELISTNAME()));
                }
                return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u4ee3\u7801\u8868[%2$s]", (Object)iPSSystem.getName(), (Object)objArg));
            }
            case 10000: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSSystemModule psSystemModule = new PSSystemModule();
                CallResult callResult = PSSystemException.getPSModelHelper(iPSSystem).getPSSystemModule((String)objArg, psSystemModule);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSSystem.getId(), (String)psSystemModule.getPSSYSTEMID(), (boolean)false) != 0) {
                        return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u6a21\u5757[%2$s]\uff0c\u9519\u8bef\u7684\u7cfb\u7edf[%3$s]", (Object)iPSSystem.getName(), (Object)psSystemModule.getPSMODULENAME(), (Object)psSystemModule.getPSSYSTEMNAME()));
                    }
                    return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u6a21\u5757[%2$s]", (Object)iPSSystem.getName(), (Object)psSystemModule.getPSMODULENAME()));
                }
                return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u6a21\u5757[%2$s]", (Object)iPSSystem.getName(), (Object)objArg));
            }
            case 10003: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSSysBackService psSysBackService = new PSSysBackService();
                CallResult callResult = PSSystemException.getPSModelHelper(iPSSystem).getPSSysBackService((String)objArg, psSysBackService);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSSystem.getId(), (String)psSysBackService.getPSSYSTEMID(), (boolean)false) != 0) {
                        return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u540e\u53f0\u670d\u52a1[%2$s]\uff0c\u9519\u8bef\u7684\u7cfb\u7edf[%3$s]", (Object)iPSSystem.getName(), (Object)psSysBackService.getPSSYSBACKSERVICENAME(), (Object)psSysBackService.getPSSYSTEMNAME()));
                    }
                    return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u540e\u53f0\u670d\u52a1[%2$s]", (Object)iPSSystem.getName(), (Object)psSysBackService.getPSSYSBACKSERVICENAME()));
                }
                return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u540e\u53f0\u670d\u52a1[%2$s]", (Object)iPSSystem.getName(), (Object)objArg));
            }
            case 10004: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDER psDER = new PSDER();
                CallResult callResult = PSSystemException.getPSModelHelper(iPSSystem).getPSDER((String)objArg, psDER);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSSystem.getId(), (String)psDER.getPSSYSTEMID(), (boolean)false) != 0) {
                        return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u5b9e\u4f53\u5173\u7cfb[%2$s]\uff0c\u9519\u8bef\u7684\u7cfb\u7edf[%3$s]", (Object)iPSSystem.getName(), (Object)psDER.getPSDERNAME(), (Object)psDER.getPSSYSTEMNAME()));
                    }
                    if (psDER.GetParamIntValue("VALIDFLAG", 1) == 0) {
                        return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u5b9e\u4f53\u5173\u7cfb[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSSystem.getName(), (Object)psDER.getPSDERNAME()));
                    }
                    return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u5b9e\u4f53\u5173\u7cfb[%2$s]", (Object)iPSSystem.getName(), (Object)psDER.getPSDERNAME()));
                }
                return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u5b9e\u4f53\u5173\u7cfb[%2$s]", (Object)iPSSystem.getName(), (Object)objArg));
            }
            case 10002: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDataEntity psDataEntity = new PSDataEntity();
                CallResult callResult = PSSystemException.getPSModelHelper(iPSSystem).getPSDataEntity((String)objArg, psDataEntity);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSSystem.getId(), (String)psDataEntity.getPSSYSTEMID(), (boolean)false) != 0) {
                        return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u5b9e\u4f53[%2$s]\uff0c\u9519\u8bef\u7684\u7cfb\u7edf[%3$s]", (Object)iPSSystem.getName(), (Object)psDataEntity.getPSDATAENTITYNAME(), (Object)psDataEntity.getPSSYSTEMNAME()));
                    }
                    if (psDataEntity.GetParamIntValue("VALIDFLAG", 1) == 0) {
                        return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u5b9e\u4f53[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSSystem.getName(), (Object)psDataEntity.getPSDATAENTITYNAME()));
                    }
                    return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u5b9e\u4f53[%2$s]", (Object)iPSSystem.getName(), (Object)psDataEntity.getPSDATAENTITYNAME()));
                }
                return new PSSystemException(iPSSystem, nErrorCode, StringHelper.Format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u5b9e\u4f53[%2$s]", (Object)iPSSystem.getName(), (Object)objArg));
            }
        }
        if (objArg != null && objArg instanceof String) {
            return new PSSystemException(iPSSystem, nErrorCode, (String)objArg);
        }
        return new PSSystemException(iPSSystem, nErrorCode, null);
    }
}

