/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DERType;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDERTypeHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, DERType var2) throws Exception;

    public String getDEName();

    public String getDEId();

    public String getDescription();

    public String getSmallIcon();

    public String getReserver();

    public String getReserver2();

    public int getOrderFlag();

    public boolean isCollapse();

    public String getDERTypeNameLanResId();

    public String getDERTypeNameLanResName();
}

