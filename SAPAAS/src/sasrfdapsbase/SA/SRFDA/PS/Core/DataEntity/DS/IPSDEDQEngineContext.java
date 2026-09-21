/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Model.QueryModelDeclare
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.Model.QueryModelDeclare;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Vector;

@PSModelIgnoreMeta
public interface IPSDEDQEngineContext {
    public void registerQMDeclare(String var1, QueryModelDeclare var2);

    public String getQMDeclareScript();

    public void fillQMDeclareParams(Vector<CallParam> var1, ISRFDAWebContext var2, ISRFDAGlobalHelper var3, String var4);

    public void fillQMDeclareParams(Vector<CallParam> var1, ISRFDAWebContext var2, ISRFDAGlobalHelper var3, String var4, BaseDataEntity var5);

    public boolean isContainsQMDeclare(String var1);
}

