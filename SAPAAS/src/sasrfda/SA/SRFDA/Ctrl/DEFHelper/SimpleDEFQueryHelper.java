/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Model.QueryModelDeclare;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class SimpleDEFQueryHelper
implements IDEFQueryHelper {
    @Override
    public String GetConditionSQL(IDAQueryModelUserContext iQMUserContext, BaseDAQueryModelHelper daQueryModelHelper, String strFieldName, String strCondition, String strValue, String strParamName) {
        QueryModelDeclare qmDeclare = new QueryModelDeclare();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("WITH temptab(deptid, empcount, superdept) AS \n");
        script.Append("(SELECT root.deptid, root.empcount, root.superdept \n");
        script.Append(" FROM departments root \n");
        script.Append("WHERE deptname=? \n");
        script.Append(") \n");
        qmDeclare.setDeclareCode(script.toString());
        CallParam callParam = new CallParam();
        callParam.setParamName("%%SRFSV(aaaa)%%");
        callParam.setValue((Object)"X");
        qmDeclare.getParams().add(callParam);
        daQueryModelHelper.RegisterQMDeclare("DEPT", qmDeclare);
        if (!daQueryModelHelper.isContainsQMDeclare("DEPT")) {
            iQMUserContext.RegisterQMDeclare("DEPT", qmDeclare);
        }
        return "";
    }
}

