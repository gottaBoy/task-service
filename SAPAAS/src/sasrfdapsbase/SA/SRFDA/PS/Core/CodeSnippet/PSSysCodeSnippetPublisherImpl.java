/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSCodeSnippetPublisherImplBase;
import java.util.HashMap;

public class PSSysCodeSnippetPublisherImpl
extends PSCodeSnippetPublisherImplBase {
    private IPSSystem iPSSystem = null;

    @Override
    protected IPSGenerateCodeResult onGenerateCode(IPSObject iPSObject) throws Exception {
        IPSSystem iPSSystem = null;
        if (iPSObject instanceof IPSSystem) {
            iPSSystem = (IPSSystem)iPSObject;
        } else if (iPSObject instanceof IPSSysSFPub) {
            iPSSystem = ((IPSSysSFPub)iPSObject).getPSSystem();
        }
        if (iPSSystem == null) {
            throw new Exception("\u6a21\u578b\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iPSSystem = iPSSystem;
        return super.onGenerateCode(iPSObject);
    }

    @Override
    protected void onFillGenerateCodeParams(String strObjType, Object obj, HashMap<String, Object> params) throws Exception {
        if (this.getPSSystem() != null) {
            params.put("sys", this.getPSSystem());
        }
        super.onFillGenerateCodeParams(strObjType, obj, params);
    }

    @Override
    protected void onClose() {
        this.iPSSystem = null;
        super.onClose();
    }

    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }
}

