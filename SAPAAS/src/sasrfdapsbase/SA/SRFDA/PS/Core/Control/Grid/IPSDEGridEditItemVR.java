/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEGridEditItemVR;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u683c\u7f16\u8f91\u9879\u503c\u89c4\u5219\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEGEIVR")
public interface IPSDEGridEditItemVR
extends IPSModelObject {
    public static final int CHECKMODE_FRONT = 1;
    public static final int CHECKMODE_BACKEND = 2;
    public static final int CHECKMODE_ALL = 3;
    public static final String VRTYPE_DEFVALUERULE = "DEFVALUERULE";
    public static final String VRTYPE_SYSVALUERULE = "SYSVALUERULE";

    public void init(ISRFDAGlobalHelper var1, IPSDEGrid var2, PSDEGridEditItemVR var3) throws Exception;

    public String getPSDEGridEditItemName();

    public IPSDEGrid getPSDEGrid();

    public IPSDEFValueRule getPSDEFValueRule();

    public IPSDEGridEditItem getPSDEGridEditItem();

    public int getCheckMode();

    public String getValueRuleType();

    public IPSSysValueRule getPSSysValueRule();
}

