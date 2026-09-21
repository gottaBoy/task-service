/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Model.QueryModelDeclare;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import java.util.Vector;

public class DefaultDAQueryModelUserContext
implements IDAQueryModelUserContext {
    private TreeMap<String, QueryModelDeclare> qmDeclareMap = new TreeMap();

    @Override
    public boolean isContainsQMDeclare(String strDeclareName) {
        strDeclareName = strDeclareName.toUpperCase();
        return this.qmDeclareMap.containsKey(strDeclareName);
    }

    @Override
    public void RegisterQMDeclare(String strDeclareName, QueryModelDeclare qmDeclare) {
        strDeclareName = strDeclareName.toUpperCase();
        this.qmDeclareMap.put(strDeclareName, qmDeclare);
    }

    @Override
    public String GetQMDeclareScript() {
        String strQMDeclareScript = "";
        for (String strName : this.qmDeclareMap.keySet()) {
            QueryModelDeclare qmDeclare = this.qmDeclareMap.get(strName);
            strQMDeclareScript = String.valueOf(strQMDeclareScript) + qmDeclare.getDeclareCode();
            strQMDeclareScript = String.valueOf(strQMDeclareScript) + "\n";
        }
        return strQMDeclareScript;
    }

    @Override
    public void FillQMDeclareParams(Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId) {
        this.FillQMDeclareParams(list, webContext, globalHelperEx, strCurPersonId, null);
    }

    @Override
    public void FillQMDeclareParams(Vector<CallParam> list, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelperEx, String strCurPersonId, BaseDataEntity baseDataEntity) {
        CallResult callResult = null;
        for (String strName : this.qmDeclareMap.keySet()) {
            QueryModelDeclare qmDeclare = this.qmDeclareMap.get(strName);
            for (CallParam callParam : qmDeclare.getParams()) {
                Object objValue;
                CallParam cp = callParam.Clone();
                callResult = MacroHelper.GetValue(cp.getParamName(), webContext, globalHelperEx, strCurPersonId, baseDataEntity);
                if (callResult.getRetCode() == 0 && ((objValue = callResult.getUserObject()) == null || StringHelper.Compare((String)objValue.toString(), (String)cp.getParamName(), (boolean)true) != 0)) {
                    cp.setValue(objValue);
                }
                list.add(cp);
            }
        }
    }
}

