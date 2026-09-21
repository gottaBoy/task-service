/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFormItemVR;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u5355\u9879\u503c\u89c4\u5219\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFormItemVR")
public interface IPSDEFormItemVR
extends IPSModelObject {
    public static final int CHECKMODE_FRONT = 1;
    public static final int CHECKMODE_BACKEND = 2;
    public static final int CHECKMODE_ALL = 3;
    public static final String VRTYPE_DEFVALUERULE = "DEFVALUERULE";
    public static final String VRTYPE_SYSVALUERULE = "SYSVALUERULE";

    public void init(ISRFDAGlobalHelper var1, IPSDEForm var2, PSDEFormItemVR var3) throws Exception;

    public String getPSDEFormItemName();

    public IPSDEForm getPSDEForm();

    public IPSDEFValueRule getPSDEFValueRule();

    public IPSDEFormItem getPSDEFormItem();

    public int getCheckMode();

    public String getValueRuleType();

    public IPSSysValueRule getPSSysValueRule();

    public int getModelState();
}

