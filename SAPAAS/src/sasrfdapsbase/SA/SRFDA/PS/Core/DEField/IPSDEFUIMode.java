/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u914d\u7f6e\u6a21\u5f0f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFUIMode")
public interface IPSDEFUIMode
extends IPSDEFieldObject {
    public static final String TYPE_DEFAULT = "DEFAULT";
    public static final String TYPE_CUSTOM = "CUSTOM";
    public static final String TYPE_MOBILEDEFAULT = "MOBILEDEFAULT";
    public static final String TYPE_APPDEFAULT = "APPDEFAULT";

    public void init(ISRFDAGlobalHelper var1, IPSDEField var2, PSDEFUIMode var3) throws Exception;

    public IPSDEFFormItem getPSDEFFormItem();

    public IPSDEFGridColumn getPSDEFGridColumn();

    public boolean isMobileMode();

    @Override
    public String getCodeName();

    public String getType();
}

