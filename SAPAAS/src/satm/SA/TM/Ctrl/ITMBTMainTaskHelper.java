/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBTPRJMT;
import SA.TM.Ctrl.ITMBTTaskHelper;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMBTMainTaskHelper {
    public void Init(ISRFDAGlobalHelper var1, TMBTPRJMT var2) throws Exception;

    public Vector<ITMBTTaskHelper> getBTTasks();

    public boolean isExtracted();

    public boolean isCancelable();
}

