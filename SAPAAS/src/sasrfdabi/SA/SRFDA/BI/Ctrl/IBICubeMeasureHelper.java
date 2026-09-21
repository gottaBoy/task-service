/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BICubeMeasure;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBICubeMeasureHelper {
    public void Init(ISRFDAGlobalHelper var1, IBICubeHelper var2, BICubeMeasure var3) throws Exception;

    public String getShortId();

    public void setShortId(String var1);

    public String getId();

    public String getUniqueName();

    public IBICubeHelper getBICube();

    public String getMeasureType();

    public int getColumnWidth();

    public String getMeasureGroup();

    public String getLogicName();

    public String getFormat();
}

