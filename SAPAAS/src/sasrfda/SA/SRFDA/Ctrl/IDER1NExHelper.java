/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DER1NEx;
import SA.SRFDA.Ctrl.IDER1NHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDER1NExHelper
extends IDER1NHelper {
    public void Init(ISRFDAGlobalHelper var1, DER1NEx var2) throws Exception;

    public String getDEId();

    public String getDER1NId();

    public String getMemo();

    public String getDERIndexId();

    public String getIndexDEId();
}

