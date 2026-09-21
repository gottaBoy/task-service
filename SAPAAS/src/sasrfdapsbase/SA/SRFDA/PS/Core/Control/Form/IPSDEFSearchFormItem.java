/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u641c\u7d22\u8868\u5355\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFSFItem")
public interface IPSDEFSearchFormItem
extends IPSDEFFormItem {
    public void init(ISRFDAGlobalHelper var1, IPSDEField var2, IPSDEFSearchMode var3, PSDEFSearchMode var4) throws Exception;

    public IPSDEFSearchMode getPSDEFSearchMode();
}

