/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFFormItemConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public interface IDEFFormCtrl {
    public CallResult Init(IDEFHelper var1, DEFFormItemConfig var2, ISRFDAGlobalHelper var3);

    public String GetFormCtrlId();

    public boolean IsAllowEmpty();

    public boolean IsEnableFormCreate();

    public boolean IsEnableFormUpdate();

    public String GetUserParam();

    public boolean IsReadonly();

    public int GetStringLengthRule();

    public String GetItemFormat();

    public String GetFormItemStyle();

    public boolean IsKey();

    public String GetUserControlConfig();

    public String GetDefaultValueType();

    public String GetDefaultValue();
}

