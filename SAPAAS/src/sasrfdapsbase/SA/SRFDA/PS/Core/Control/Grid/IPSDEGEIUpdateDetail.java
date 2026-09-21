/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEGEIUDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEGEIUDetail")
public interface IPSDEGEIUpdateDetail
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEGridEditItemUpdate var2, PSDEGEIUDetail var3) throws Exception;

    @Override
    public String getName();

    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate();

    public String getPSDEGridColumnName();

    public String getPSDEGridColumnId();
}

