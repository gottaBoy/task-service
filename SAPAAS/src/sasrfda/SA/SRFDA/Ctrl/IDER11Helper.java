/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.IDERHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDER11Helper
extends IDERHelper {
    public void Init(ISRFDAGlobalHelper var1, DER11 var2) throws Exception;

    public boolean isSystem();

    public int getRemoveActionType();

    public String getMajorDEName();

    public String getMajorDEId();

    public String getMinorDEId();

    public String getMinorDEName();

    public String getMajorDELogicName();

    public String getMinorDELogicName();

    public String getDERLogicName();

    public int getShowOrder();

    public String getEditPageId();

    public String getEditPageName();

    public String getDERTypeId();

    public String getDERTypeName();

    public String getSmallIcon();

    public String getShowName();
}

