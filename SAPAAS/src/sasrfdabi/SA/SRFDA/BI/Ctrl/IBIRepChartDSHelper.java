/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepChartDS;
import SA.SRFDA.BI.Ctrl.IBIRepChartHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepChartDSHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIRepChartHelper var2, BIRepChartDS var3) throws Exception;

    public String getCatalogField();

    public String getAxisXField();

    public String getValueField();

    public String getValue2Field();

    public String getValue3Field();

    public String getValue4Field();

    public String getValueCaption();

    public String getValue2Caption();

    public String getValue3Caption();

    public String getValue4Caption();

    public String getChartType();
}

