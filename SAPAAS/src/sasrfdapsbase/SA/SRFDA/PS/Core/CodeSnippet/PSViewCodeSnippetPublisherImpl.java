/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSCodeSnippetPublisherImplBase;
import java.util.HashMap;

public class PSViewCodeSnippetPublisherImpl
extends PSCodeSnippetPublisherImplBase {
    private IPSAppView iPSAppView = null;

    @Override
    protected IPSGenerateCodeResult onGenerateCode(IPSObject iPSObject) throws Exception {
        IPSAppView iPSAppView = null;
        if (iPSObject instanceof IPSAppView) {
            iPSAppView = (IPSAppView)iPSObject;
        }
        if (iPSAppView == null) {
            throw new Exception("\u6a21\u578b\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iPSAppView = iPSAppView;
        return super.onGenerateCode(iPSObject);
    }

    @Override
    protected void onFillGenerateCodeParams(String strObjType, Object obj, HashMap<String, Object> params) throws Exception {
        if (this.getPSAppView() != null) {
            IPSAppDEView iPSAppDEView;
            params.put("appview", this.getPSAppView());
            if (this.getPSAppView().getPSAppDataEntity() != null) {
                params.put("appde", this.getPSAppView().getPSAppDataEntity());
            }
            if (this.getPSAppView() instanceof IPSAppDEView && (iPSAppDEView = (IPSAppDEView)this.getPSAppView()).getPSDataEntity() != null) {
                params.put("de", iPSAppDEView.getPSDataEntity());
            }
            params.put("app", this.getPSAppView().getPSApplication());
            params.put("sys", this.getPSAppView().getPSSystem());
        }
        super.onFillGenerateCodeParams(strObjType, obj, params);
    }

    @Override
    protected void onClose() {
        this.iPSAppView = null;
        super.onClose();
    }

    protected IPSAppView getPSAppView() {
        return this.iPSAppView;
    }
}

