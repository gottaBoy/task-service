/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEMAField;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDEMAFieldHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IDEMainActionHelper var2, DEMAField var3) throws Exception;

    public String getDEFId();

    public String getCodelistId();

    public String getFormItemStyle();

    public boolean isEnableModify();

    public String getUpdateMode();

    public String getUpdateValue();
}

