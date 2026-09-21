/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Tree.IPSDETree
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub.Preview;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewCtrlCodePublisherImpl;
import java.util.HashMap;

public class PSPreviewDETreeControllerCodePublisherImpl
extends PSPreviewCtrlCodePublisherImpl {
    protected IPSDETree iPSDETree = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDETree = (IPSDETree)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }

    protected void onClose() {
        this.iPSDETree = null;
        super.onClose();
    }
}

