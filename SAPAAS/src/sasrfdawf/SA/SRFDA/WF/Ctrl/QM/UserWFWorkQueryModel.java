/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Model.DGModelMainQueryConfig
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.WF.Ctrl.QM;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public class UserWFWorkQueryModel
extends BaseDAQueryModelHelper {
    private static String strQUERYSQL = " select t3.WFWORKFLOWID,t3.WFWORKFLOWNAME,t1.WFPLOGICNAME,t4.ACTORID,t1.WFSTEPNAME,t2.USERDATA4 from T_SRFWFSTEP t1 INNER JOIN t_SRFWFINSTANCE t2 on  t2.ACTIVESTEPID = t1.WFSTEPID AND ( t2.ISCLOSE IS NULL OR t2.ISCLOSE=0) INNER JOIN T_SRFWFWORKFLOW t3 on t2.WFWORKFLOWID = t3.WFWORKFLOWID  INNER JOIN T_SRFWFSTEPACTOR t4 on  t4.WFSTEPID = t1.WFSTEPID  LEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=T4.ACTORID and  t5.WFSTEPID = t2.ACTIVESTEPID AND  t5.CONNECTIONNAME<>'SRFWFRESUBMIT' AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT') where t5.WFSTEPDATAID IS NULL AND t4.ACTORID=? ";

    public CallResult CompileEx(DGModelMainQueryConfig mainQueryConfig, DGModelMainQueryConfig mainQueryConfig2, boolean control, Vector<Vector<DGModelMainQueryConfig>> notQueryConfigs, Vector<Vector<DGModelMainQueryConfig>> orQueryConfigs, boolean bDeleteMode) {
        CallParam opPerson = new CallParam();
        opPerson.setParamName("%%SRFOPPERSON()%%");
        this.callParams.add(opPerson);
        this.strQueryScript = strQUERYSQL;
        return new CallResult();
    }
}

