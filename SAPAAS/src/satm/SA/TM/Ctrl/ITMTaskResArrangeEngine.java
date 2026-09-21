/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBTPlanTaskRes;
import SA.TM.Ctrl.Data.TMBTTaskRes;
import SA.TM.Ctrl.Data.TMTaskRes;
import SA.TM.Ctrl.Data.TMTaskResAE;
import SA.TM.Ctrl.ITMActionContext;
import java.util.Hashtable;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMTaskResArrangeEngine {
    public void Init(ISRFDAGlobalHelper var1, TMTaskResAE var2) throws Exception;

    public String getId();

    public String getName();

    public int getVersion();

    public void Arrange(ITMActionContext var1, Vector<TMTaskRes> var2) throws Exception;

    public String CalcResCDScore(ITMActionContext var1, TMTaskRes var2, Hashtable<String, Float> var3, Hashtable<String, String> var4) throws Exception;

    public String CalcResCDScore(ITMActionContext var1, TMBTTaskRes var2, TMBTPlanTaskRes var3, Hashtable<String, Float> var4, Hashtable<String, String> var5) throws Exception;
}

