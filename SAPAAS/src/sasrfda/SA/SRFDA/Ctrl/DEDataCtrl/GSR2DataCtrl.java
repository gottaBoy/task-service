/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.IGSR2DataCtrl;
import SA.SRFDA.Ctrl.Data.GSR2Dimension;
import SA.SRFDA.Ctrl.Data.GSR2Dimension2;
import SA.SRFDA.Ctrl.Data.GSR2Measure;
import SA.SRFDA.Ctrl.Data.GSR2SumTable;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class GSR2DataCtrl
extends BaseDEDataCtrl
implements IGSR2DataCtrl {
    @Override
    public CallResult ListDimensions(String strGSR2Id, Vector<GSR2Dimension> dimensions) {
        String strSQL = "select * from V_SRFGSR2DIMENSION WHERE GSR2ID = ? ORDER BY ORDERFLAG";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strGSR2Id);
        return BaseDEDataCtrl.SelectMultiEx(this.getGlobalHelper(), this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), dimensions, GSR2Dimension.class.getName());
    }

    @Override
    public CallResult ListMeasures(String strGSR2Id, Vector<GSR2Measure> measures) {
        String strSQL = "select * from V_SRFGSR2MEASURE WHERE GSR2ID = ? ORDER BY ORDERFLAG";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strGSR2Id);
        return BaseDEDataCtrl.SelectMultiEx(this.getGlobalHelper(), this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), measures, GSR2Measure.class.getName());
    }

    @Override
    public CallResult ListSumTables(String strGSR2Id, Vector<GSR2SumTable> sumTables) {
        String strSQL = "select t1.*,t2.ITEMFORMAT from V_SRFGSR2SUMTABLE t1 INNER JOIN T_SRFGSR2TD t2 ON t1.TD = t2.GSR2TDID WHERE t1.GSR2ID = ?  order by t1.orderflag ,t2.orderflag ";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strGSR2Id);
        return BaseDEDataCtrl.SelectMultiEx(this.getGlobalHelper(), this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), sumTables, GSR2SumTable.class.getName());
    }

    @Override
    public CallResult ListDimensions2(String strGSR2Id, Vector<GSR2Dimension2> dimensions2) {
        String strSQL = "select * from V_SRFGSR2DIMENSION2 WHERE GSR2ID = ? ORDER BY ORDERFLAG";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strGSR2Id);
        return BaseDEDataCtrl.SelectMultiEx(this.getGlobalHelper(), this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), dimensions2, GSR2Dimension2.class.getName());
    }
}

