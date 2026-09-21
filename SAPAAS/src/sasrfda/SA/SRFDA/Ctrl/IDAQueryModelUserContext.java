/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Model.QueryModelDeclare;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Vector;

public interface IDAQueryModelUserContext {
    public void RegisterQMDeclare(String var1, QueryModelDeclare var2);

    public String GetQMDeclareScript();

    public void FillQMDeclareParams(Vector<CallParam> var1, ISRFDAWebContext var2, ISRFDAGlobalHelper var3, String var4);

    public void FillQMDeclareParams(Vector<CallParam> var1, ISRFDAWebContext var2, ISRFDAGlobalHelper var3, String var4, BaseDataEntity var5);

    public boolean isContainsQMDeclare(String var1);
}

