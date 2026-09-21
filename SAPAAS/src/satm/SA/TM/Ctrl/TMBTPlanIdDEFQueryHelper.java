/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Model.QueryModelDeclare
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Model.QueryModelDeclare;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class TMBTPlanIdDEFQueryHelper
implements IDEFQueryHelper {
    public String GetConditionSQL(IDAQueryModelUserContext iQMUserContext, BaseDAQueryModelHelper daQueryModelHelper, String strFieldName, String strCondition, String strValue, String strParamName) {
        if (StringHelper.Compare((String)daQueryModelHelper.GetDBType(), (String)"DB2", (boolean)true) == 0) {
            return this.OnGetDB2ConditionSQL(iQMUserContext, daQueryModelHelper, strFieldName, strCondition, strValue, strParamName);
        }
        if (StringHelper.Compare((String)daQueryModelHelper.GetDBType(), (String)"ORACLE", (boolean)true) == 0) {
            return this.OnGetOracleConditionSQL(iQMUserContext, daQueryModelHelper, strFieldName, strCondition, strValue, strParamName);
        }
        return null;
    }

    protected String OnGetDB2ConditionSQL(IDAQueryModelUserContext iQMUserContext, BaseDAQueryModelHelper daQueryModelHelper, String strFieldName, String strCondition, String strValue, String strParamName) {
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            QueryModelDeclare qmDeclare = new QueryModelDeclare();
            StringBuilderEx script = new StringBuilderEx();
            script.Append("with rpl (TMBTPLANID,PTMBTPLANID) as \t(\t select TMBTPLANID,PTMBTPLANID  from SRFT_TMBTPLAN_BASE  where TMBTPLANID= '%1$s' \t union all \t select  parent.TMBTPLANID,parent.PTMBTPLANID from rpl child, SRFT_TMBTPLAN_BASE parent where child.PTMBTPLANID=parent.TMBTPLANID \t) \n", (Object)strValue);
            qmDeclare.setDeclareCode(script.toString());
            if (!daQueryModelHelper.isContainsQMDeclare("TMBTPLANID") && iQMUserContext != null) {
                iQMUserContext.RegisterQMDeclare("TMBTPLANID", qmDeclare);
            }
            strValue = strValue.replace("'", "''");
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
                return StringHelper.Format((String)"(%1$s in (SELECT PTMBTPLANID FROM rpl) or %1$s='%2$s')", (Object)strFieldName, (Object)strValue);
            }
        } else {
            QueryModelDeclare qmDeclare = new QueryModelDeclare();
            StringBuilderEx script = new StringBuilderEx();
            script.Append("with rpl (TMBTPLANID,PTMBTPLANID) as \t(\t select TMBTPLANID,PTMBTPLANID  from SRFT_TMBTPLAN_BASE  where TMBTPLANID=? \t union all \t select  parent.TMBTPLANID,parent.PTMBTPLANID from rpl child, SRFT_TMBTPLAN_BASE parent where child.PTMBTPLANID=parent.TMBTPLANID \t) \n", (Object)strValue);
            qmDeclare.setDeclareCode(script.toString());
            CallParam callParam = new CallParam();
            callParam.setParamName(strParamName);
            callParam.setValue((Object)strValue.toUpperCase());
            qmDeclare.getParams().add(callParam);
            if (!daQueryModelHelper.isContainsQMDeclare("TMBTPLANID") && iQMUserContext != null) {
                iQMUserContext.RegisterQMDeclare("TMBTPLANID", qmDeclare);
            }
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue.toUpperCase());
                return StringHelper.Format((String)"(%1$s in (select PTMBTPLANID from rpl) or %1$s=?)", (Object)strFieldName);
            }
        }
        return "";
    }

    protected String OnGetOracleConditionSQL(IDAQueryModelUserContext iQMUserContext, BaseDAQueryModelHelper daQueryModelHelper, String strFieldName, String strCondition, String strValue, String strParamName) {
        if (StringHelper.IsNullOrEmpty((String)strParamName)) {
            strValue = strValue.replace("'", "''");
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s in ( select TMBTPLANID from (select PTMBTPLANID,TMBTPLANID from srft_TMBTPLAN_base ) t connect by prior t.PTMBTPLANID = t.TMBTPLANID start with t.TMBTPLANID = '%2$s')", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s = '%2$s' ", (Object)strFieldName, (Object)strValue);
            }
            if (StringHelper.Compare((String)strCondition, (String)"ISNULL", (boolean)true) == 0) {
                return StringHelper.Format((String)" %1$s is null ", (Object)strFieldName);
            }
        } else {
            if (StringHelper.Compare((String)strCondition, (String)"=", (boolean)true) == 0) {
                daQueryModelHelper.RegisterCallParam(strParamName, (Object)strValue);
                return StringHelper.Format((String)"(%1$s in ( select TMBTPLANID from (select PTMBTPLANID,TMBTPLANID from srft_TMBTPLAN_base ) t connect by prior t.PTMBTPLANID = t.TMBTPLANID start with t.TMBTPLANID =  ? ))", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"==", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s =  ? ", (Object)strFieldName);
            }
            if (StringHelper.Compare((String)strCondition, (String)"ISNULL", (boolean)true) == 0) {
                return StringHelper.Format((String)" %1$s is null ", (Object)strFieldName, (Object)strValue.toUpperCase());
            }
        }
        return "";
    }
}

