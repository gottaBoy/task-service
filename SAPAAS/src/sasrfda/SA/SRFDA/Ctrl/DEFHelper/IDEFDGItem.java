/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFDGItemConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public interface IDEFDGItem {
    public CallResult Init(IDEFHelper var1, DEFDGItemConfig var2, ISRFDAGlobalHelper var3);

    public String GetItemFormat(DGModeDetail var1);

    public String GetCaption(DGModeDetail var1, String var2);

    public String GetCustom(DGModeDetail var1);

    public String GetAlign(DGModeDetail var1);

    public String GetEditorParam(DGModeDetail var1);

    public String GetEditorStyle(DGModeDetail var1);

    public boolean isEnableEdit(DGModeDetail var1);

    public String GetDefaultValueType(DGModeDetail var1);

    public String GetDefaultValue(DGModeDetail var1);

    public boolean isSortable(DGModeDetail var1);

    public String GetFIUpdateMode(DGModeDetail var1, String var2);

    public boolean isExclude();
}

