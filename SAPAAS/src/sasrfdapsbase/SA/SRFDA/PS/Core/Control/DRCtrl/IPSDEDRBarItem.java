/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBar;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRBarGroup;
import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u8fb9\u680f\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDRDetail")
public interface IPSDEDRBarItem
extends IPSDEDRCtrlItem,
IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEDRBar var2, IPSDEDRBarGroup var3, IPSDEDRDetail var4) throws Exception;

    public IPSDEDRBarGroup getPSDEDRBarGroup();
}

