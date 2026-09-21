/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseService
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.BaseService;
import SA.SRFDA.EAI.Ctrl.EAIServiceMgr;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class EAIService
extends BaseService {
    public static final String TAG_SRFDAEAISERVICEMGR = "{753F59D7-C01F-4b0a-A0C9-2EAD77744308}";
    public static final String TAG_CONFIGPATH = "CONFIGPATH";
    public static final String TAG_EAICOMMAND = "EAICOMMAND";
    public static final String TAG_EAIDATACTRL = "EAIDATACTRL";
    protected EAIServiceMgr eaiServiceMgr;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        this.eaiServiceMgr = new EAIServiceMgr(this.iDAGlobalHelper);
        this.iDAGlobalHelper.SetGlobalValue(TAG_SRFDAEAISERVICEMGR, (Object)this.eaiServiceMgr);
        String strConfigPath = this.GetServiceParam(TAG_CONFIGPATH);
        if (StringHelper.IsNullOrEmpty((String)strConfigPath)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u96c6\u6210\u670d\u52a1\u914d\u7f6e\u8def\u5f84");
            return callResult;
        }
        String strEAICommand = this.GetServiceParam(TAG_EAICOMMAND);
        if (StringHelper.IsNullOrEmpty((String)strEAICommand)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u96c6\u6210\u670d\u52a1\u547d\u4ee4");
            return callResult;
        }
        this.eaiServiceMgr = new EAIServiceMgr(this.iDAGlobalHelper);
        this.eaiServiceMgr.setServiceParams(this.serviceParams);
        this.eaiServiceMgr.setConfigPath(strConfigPath);
        this.eaiServiceMgr.setEAICommand(strEAICommand);
        this.eaiServiceMgr.setEAIDataCtrl(this.GetServiceParam(TAG_EAIDATACTRL));
        return callResult;
    }

    protected CallResult OnQuit() {
        this.iDAGlobalHelper.SetGlobalValue(TAG_SRFDAEAISERVICEMGR, null);
        return super.OnQuit();
    }

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            callResult = this.eaiServiceMgr.Start();
            this.iDAGlobalHelper.SetGlobalValue(TAG_SRFDAEAISERVICEMGR, (Object)this.eaiServiceMgr);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult OnStop() {
        CallResult callResult = this.eaiServiceMgr.Stop();
        if (callResult.IsError()) {
            return callResult;
        }
        return super.OnStop();
    }
}

