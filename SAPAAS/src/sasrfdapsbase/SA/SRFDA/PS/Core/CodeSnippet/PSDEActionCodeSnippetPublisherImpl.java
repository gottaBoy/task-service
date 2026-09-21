/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSCodeSnippetPublisherImplBase;
import java.util.HashMap;

public class PSDEActionCodeSnippetPublisherImpl
extends PSCodeSnippetPublisherImplBase {
    private IPSDEAction iPSDEAction = null;

    @Override
    protected IPSGenerateCodeResult onGenerateCode(IPSObject iPSObject) throws Exception {
        if (!(iPSObject instanceof IPSDEAction)) {
            throw new Exception("\u6a21\u578b\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iPSDEAction = (IPSDEAction)iPSObject;
        return super.onGenerateCode(iPSObject);
    }

    @Override
    protected void onFillGenerateCodeParams(String strObjType, Object obj, HashMap<String, Object> params) throws Exception {
        if (this.getPSDataEntity() != null) {
            params.put("de", this.getPSDataEntity());
            params.put("sys", this.getPSDataEntity().getPSSystem());
        }
        super.onFillGenerateCodeParams(strObjType, obj, params);
    }

    @Override
    protected void onClose() {
        this.iPSDEAction = null;
        super.onClose();
    }

    protected IPSDataEntity getPSDataEntity() {
        return this.iPSDEAction.getPSDataEntity();
    }
}

