/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.TM.Ctrl.Data.TMBTType;
import SA.TM.Ctrl.Data.TMComplexRes;
import SA.TM.Ctrl.Data.TMComplexResDetail;
import SA.TM.Ctrl.Data.TMRBRule;
import SA.TM.Ctrl.Data.TMRBRuleType;
import SA.TM.Ctrl.Data.TMResBT;
import SA.TM.Ctrl.Data.TMResBase;
import SA.TM.Ctrl.Data.TMResCD;
import SA.TM.Ctrl.Data.TMResCatalog;
import SA.TM.Ctrl.Data.TMResType;
import SA.TM.Ctrl.Data.TMResView;
import SA.TM.Ctrl.Data.TMResViewDetail;
import SA.TM.Ctrl.Data.TMTTRC;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.Data.TMTaskResAE;
import SA.TM.Ctrl.Data.TMTaskResAEType;
import SA.TM.Ctrl.Data.TMTaskType;
import SA.TM.Ctrl.Data.TMTimeItem;
import SA.TM.Ctrl.Data.TMTimeRule;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMModelHelper {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public CallResult GetTMTaskType(String var1, TMTaskType var2);

    public CallResult GetTMResType(String var1, TMResType var2);

    public CallResult GetTMResCatalog(String var1, TMResCatalog var2);

    public CallResult GetTMTask(String var1, TMTaskBase var2);

    public CallResult GetTMResource(String var1, TMResBase var2);

    public CallResult GetTMComplexRes(String var1, TMComplexRes var2);

    public CallResult GetTMTasksByMainTask(String var1, Vector<TMTaskBase> var2);

    public CallResult GetTMTTRCs(String var1, Vector<TMTTRC> var2);

    public CallResult GetTMRBRuleType(String var1, TMRBRuleType var2);

    public CallResult GetTMRBRule(String var1, TMRBRule var2);

    public CallResult GetTMComplexResDetails(String var1, Vector<TMComplexResDetail> var2);

    public CallResult GetTMResCDs(String var1, Vector<TMResCD> var2);

    public CallResult GetTMResView(String var1, TMResView var2);

    public CallResult GetTMResViewDetails(String var1, Vector<TMResViewDetail> var2);

    public CallResult GetTMTimeRule(String var1, TMTimeRule var2);

    public CallResult GetTMTimeItems(String var1, Vector<TMTimeItem> var2);

    public CallResult GetTMTaskResAEType(String var1, TMTaskResAEType var2);

    public CallResult GetTMTaskResAE(String var1, TMTaskResAE var2);

    public CallResult GetTMResBT(String var1, TMResBT var2);

    public CallResult GetTMBTType(String var1, TMBTType var2);

    public String GetTMBTPlanJoinQuerySQL(boolean var1, String var2);

    public String GetTMBTPlanJoinQuerySQL(boolean var1, String var2, String var3);

    public String getDBType();
}

