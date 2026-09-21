/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRS;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSNavParam;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeRSParamImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSDETreeNodeRSNavParamImpl
extends PSDETreeNodeRSParamImpl
implements IPSDETreeNodeRSNavParam {
    private boolean bRawValue = false;

    public void init(ISRFDAGlobalHelper iDGlobalHelper, IPSDETreeNodeRS iPSDETreeNodeRS, String strKey, String strValue, String strDesc, boolean bRawValue) throws Exception {
        super.init(iDGlobalHelper, iPSDETreeNodeRS, strKey, strValue, strDesc);
        this.bRawValue = bRawValue;
    }

    @Override
    public String getModelType() {
        return "PSDETREENODERSNAVPARAM";
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c")
    public boolean isRawValue() {
        return this.bRawValue;
    }
}

