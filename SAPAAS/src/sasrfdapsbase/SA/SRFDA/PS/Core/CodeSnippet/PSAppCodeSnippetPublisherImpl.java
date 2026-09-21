/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSCodeSnippetPublisherImplBase;
import java.util.HashMap;

public class PSAppCodeSnippetPublisherImpl
extends PSCodeSnippetPublisherImplBase {
    private IPSApplication iPSApplication = null;

    @Override
    protected IPSGenerateCodeResult onGenerateCode(IPSObject iPSObject) throws Exception {
        IPSApplication iPSApplication = null;
        if (iPSObject instanceof IPSApplication) {
            iPSApplication = (IPSApplication)iPSObject;
        }
        if (iPSApplication == null) {
            throw new Exception("\u6a21\u578b\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iPSApplication = iPSApplication;
        return super.onGenerateCode(iPSObject);
    }

    @Override
    protected void onFillGenerateCodeParams(String strObjType, Object obj, HashMap<String, Object> params) throws Exception {
        if (this.getPSApplication() != null) {
            params.put("app", this.getPSApplication());
            params.put("sys", this.getPSApplication().getPSSystem());
        }
        super.onFillGenerateCodeParams(strObjType, obj, params);
    }

    @Override
    protected void onClose() {
        this.iPSApplication = null;
        super.onClose();
    }

    protected IPSApplication getPSApplication() {
        return this.iPSApplication;
    }
}

