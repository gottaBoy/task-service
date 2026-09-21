/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.DEDCPageProcess;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;

public class DEDCPageSendRedirectProcess
extends DEDCPageProcess {
    @Override
    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = super.Execute(dedcContext, processConfig);
        if (callResult.IsError()) {
            return callResult;
        }
        if (dedcContext.GetPage() == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5f53\u524d\u4e0a\u4e0b\u6587\u6ca1\u6709\u6307\u5b9a\u9875\u9762\u5bf9\u8c61"));
            dedcContext.Log(1, (Object)dedcContext, callResult.getErrorInfo());
            return callResult;
        }
        if (dedcContext.GetWebContext() == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5f53\u524d\u4e0a\u4e0b\u6587\u6ca1\u6709\u6307\u5b9a\u9875\u9762\u4e0a\u4e0b\u6587\u8bbf\u95ee\u5bf9\u8c61"));
            dedcContext.Log(1, (Object)dedcContext, callResult.getErrorInfo());
            return callResult;
        }
        String strSrcDataEntity = processConfig.getDEDCProcess().getSRCDATAENTITY();
        BaseDataEntity srcDataEntity = null;
        srcDataEntity = dedcContext.GetDataEntity(strSrcDataEntity);
        if (srcDataEntity == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strSrcDataEntity));
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strSrcDataEntity));
        dedcContext.GetWebContext().RemoveParam("SRFPAGEID");
        DEDCPageSendRedirectProcess.FillWebContext(dedcContext, "DEPARAM", processConfig, srcDataEntity);
        String strPageType = processConfig.getDEDCProcess().getPARAM3();
        if (StringHelper.Compare((String)strPageType, (String)"SCRIPT", (boolean)true) == 0) {
            String strScript = processConfig.getDEDCProcess().getPARAM5();
            dedcContext.GetPage().OutputScript(strScript);
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8f93\u51fa\u811a\u672c\r\n{%1$s\r\n}", (Object)strScript));
            callResult.setRetCode(1000);
            callResult.setErrorInfo("\u6267\u884c\u91cd\u5b9a\u5411\u64cd\u4f5c");
            return callResult;
        }
        String strURL = processConfig.getDEDCProcess().getPARAM4();
        if (StringHelper.Compare((String)strPageType, (String)"PAGE", (boolean)true) == 0) {
            String strPageId = processConfig.getDEDCProcess().getPARAM1();
            if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5185\u7f6e\u9875\u9762\u7f16\u53f7"));
                return callResult;
            }
            Page page = dedcContext.GetGlobalHelper().getDAModelStorage().FindPage(strPageId);
            if (page == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)strPageId));
                dedcContext.Log(1, (Object)dedcContext, callResult.getErrorInfo());
                return callResult;
            }
            strURL = page.GetTotalPagePath();
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u8ba1\u7b97\u7f51\u9875\u8def\u5f84[%1$s]", (Object)strURL));
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        strURL = String.valueOf(strURL) + dedcContext.GetWebContext().GetQueryString();
        callResult.setRetCode(1000);
        callResult.setErrorInfo("\u6267\u884c\u91cd\u5b9a\u5411\u64cd\u4f5c");
        try {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u7f51\u9875\u8df3\u8f6c\u8def\u5f84[%1$s]", (Object)strURL));
            if (dedcContext.GetPage() instanceof SRFDAPage) {
                SRFDAPage daPage = (SRFDAPage)dedcContext.GetPage();
                if (StringHelper.IsNullOrEmpty((String)daPage.getPageModel())) {
                    daPage.getResponse().sendRedirect(strURL);
                } else {
                    daPage.getResponse().getWriter().write(SRFDAPage.OutputRedirectModel((String)strURL));
                }
            } else {
                dedcContext.GetPage().getResponse().sendRedirect(strURL);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return callResult;
    }
}

