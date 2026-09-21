/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.IDERHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDER1NHelper
extends IDERHelper {
    public void Init(ISRFDAGlobalHelper var1, DER1N var2) throws Exception;

    public String getDERLogicName();

    public String getDescription();

    public String getReserver();

    public String getReserver2();

    public boolean isNullable();

    public boolean isSystem();

    public int getShowOrder();

    public int getDERType();

    public String getMajorDEName();

    public String getMinorDEName();

    public String getDERTypeName();

    public String getMajorKeyDEFName();

    public String getMajorTextDEFName();

    public String getMajorDEId();

    public String getMinorDEId();

    public int getDERSubType();

    public String getDERTypeId();

    public String getMajorDELogicName();

    public String getMinorDELogicName();

    public int getRemoveActionType();

    public boolean isMTField();

    public String getRangeCond();

    public String getShowName1N();

    public String getPickupPageId();

    public String getPickupPageName();

    public String getRelatedPageId() throws Exception;

    public String getRelatedPageName();

    public String getSmallIcon();

    public String getMPickupPageId();

    public String getMPickupPageName();

    public String getTabViewbarCond();

    public boolean isPhysicalMode();

    public String getPhysicalUpdateMode();

    public String getDEACModeId();

    public String getDEACModeName();

    public boolean isForeignKey();

    public int getExportOrder();

    public String getShowNameLanResId();

    public String getShowNameLanResName();

    public boolean isSyncModel();

    public String getQueryModelId();
}

