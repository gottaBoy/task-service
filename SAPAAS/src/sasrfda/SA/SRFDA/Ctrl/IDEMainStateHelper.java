/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEMSMA;
import SA.SRFDA.Ctrl.Data.DEMainState;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Enumeration;

public interface IDEMainStateHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, IDEHelper var2, DEMainState var3) throws Exception;

    public String getLogicName(String var1);

    public String getQueryModelId();

    public String getSDPageId();

    public String getMDPageId();

    public boolean isEnableUserCreate();

    public boolean isEnableUserUpdate();

    public boolean isEnableUserDelete();

    public boolean isEnableUserView();

    public Enumeration<DEMSMA> getDEMainActions();

    public String getStateTestSql() throws Exception;

    public IDEMainActionHelper getEditDEMainAction() throws Exception;

    public boolean isMapTo(String var1, String var2);

    public boolean isMapTo(String var1);

    public boolean isWFMode();

    public boolean isDefaultState();

    public String getDERGroupId();
}

