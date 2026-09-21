/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.SummaryPage;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface ISummaryPageHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, SummaryPage var2) throws Exception;

    public String getSPType();

    public String getDEId();

    public String getFormId();

    public String getPageId();

    public String getDERTypeId();

    public String getSmallIcon();

    public int getDERShowOrder();

    public int getSumShowOrder();

    public String getAppendparam();

    public String getDescription();

    public String getNameLanResId();
}

