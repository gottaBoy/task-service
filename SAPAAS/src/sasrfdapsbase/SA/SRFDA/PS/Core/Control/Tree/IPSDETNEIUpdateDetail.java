/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItemUpdate;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDETEIUDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDETEIUDetail")
public interface IPSDETNEIUpdateDetail
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDETreeNodeEditItemUpdate var2, PSDETEIUDetail var3) throws Exception;

    @Override
    public String getName();

    public IPSDETreeNodeEditItemUpdate getPSDETreeNodeEditItemUpdate();
}

