/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEMainAction;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDEMainActionHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IDEHelper var2, DEMainAction var3) throws Exception;

    public String getLogicName(String var1);

    public String getDEBehaviorId();

    public String getMemo();

    public String getFormId();

    public IDEMAFieldHelper FindDEMAField(String var1);

    public boolean isUpdateMAFOnly();

    public String getActionType();

    public boolean isSystemReserver();

    public String getActionMode();

    public String getDataAccessAction();
}

