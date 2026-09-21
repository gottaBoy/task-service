/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DBIndex;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DETrigger;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.TriggerCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public interface IDBModelHelper {
    public CallResult Init(DataEntity var1, ISRFDAGlobalHelper var2);

    public CallResult CreateTableAndView();

    public CallResult CreateView();

    public CallResult AddColumn(DEField var1);

    public CallResult AddDER1N(DER1N var1);

    public CallResult AddTrigger(DETrigger var1, TriggerCode var2);

    public CallResult DropTrigger(DETrigger var1);

    public String GetDBType();

    public CallResult AddIndex(DBIndex var1);

    public CallResult DropIndex(DBIndex var1);
}

