/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.DGModelJoinQueryConfig;
import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Web.Utility.GlobalHelperEx;

public interface IDAQueryHelper {
    public void Init(IDEHelper var1, GlobalHelperEx var2);

    public boolean SetMainQuery(DGModelMainQueryConfig var1);

    public boolean AddCondition(DEField var1, SearchItemConfig var2, String var3);

    public boolean AddCondition(DEField var1, String var2, String var3, String var4);

    public void AddJoinQuery(DGModelJoinQueryConfig var1);

    public void AddJoinQuery(String var1, String var2);

    public void SetPageInfo(int var1, int var2);

    public void SetOrderInfo(String var1, String var2, String var3, String var4);

    public void SetCurUserId(String var1);

    public String GetTotalRowSQL();

    public String GetQuerySQL();
}

