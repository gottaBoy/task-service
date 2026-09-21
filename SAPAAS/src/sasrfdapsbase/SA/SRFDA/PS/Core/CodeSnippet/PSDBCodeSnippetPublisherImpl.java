/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSCodeSnippetPublisherImplBase;
import java.util.HashMap;

public class PSDBCodeSnippetPublisherImpl
extends PSCodeSnippetPublisherImplBase {
    private IPSSystemDBConfig iPSSystemDBConfig = null;

    @Override
    protected IPSGenerateCodeResult onGenerateCode(IPSObject iPSObject) throws Exception {
        IPSSystemDBConfig iPSSystemDBConfig = null;
        if (iPSObject instanceof IPSSystemDBConfig) {
            iPSSystemDBConfig = (IPSSystemDBConfig)iPSObject;
        }
        if (iPSSystemDBConfig == null) {
            throw new Exception("\u6a21\u578b\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iPSSystemDBConfig = iPSSystemDBConfig;
        return super.onGenerateCode(iPSObject);
    }

    @Override
    protected void onFillGenerateCodeParams(String strObjType, Object obj, HashMap<String, Object> params) throws Exception {
        if (this.getPSSystemDBConfig() != null) {
            params.put("db", this.getPSSystemDBConfig());
            params.put("sys", this.getPSSystemDBConfig().getPSSystem());
        }
        super.onFillGenerateCodeParams(strObjType, obj, params);
    }

    @Override
    protected void onClose() {
        this.iPSSystemDBConfig = null;
        super.onClose();
    }

    protected IPSSystemDBConfig getPSSystemDBConfig() {
        return this.iPSSystemDBConfig;
    }
}

