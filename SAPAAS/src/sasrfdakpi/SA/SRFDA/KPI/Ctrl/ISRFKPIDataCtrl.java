/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  javax.servlet.ServletContext
 */
package SA.SRFDA.KPI.Ctrl;

import SA.SRFDA.KPI.Ctrl.Data.KPIInst;
import SA.SRFDA.KPI.Ctrl.Data.KPIInstData;
import SA.SRFDA.KPI.Ctrl.Data.KPIMP;
import SA.SRFDA.KPI.Ctrl.Data.KPIPoint;
import SA.SRFDA.KPI.Ctrl.Data.KPISet;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;
import javax.servlet.ServletContext;

public interface ISRFKPIDataCtrl {
    public void Init(ServletContext var1, BaseDBCallerHelperEx var2);

    public CallResult GetKPISet(String var1, KPISet var2);

    public CallResult GetKPIInst(String var1, KPIInst var2);

    public CallResult GetKPIMP(String var1, KPIMP var2);

    public CallResult GetKPISetPoints(String var1, String var2, Vector<KPIPoint> var3);

    public CallResult GetKPIInst(String var1, String var2, String var3, String var4, String var5, int var6, KPIInst var7);

    public CallResult GetKPIInstDatas(String var1, Vector<KPIInstData> var2);

    public CallResult AddKPIInst(KPIInst var1, String var2);

    public CallResult AddKPIInstData(KPIInstData var1, String var2);

    public CallResult ExecRawSql(String var1);
}

