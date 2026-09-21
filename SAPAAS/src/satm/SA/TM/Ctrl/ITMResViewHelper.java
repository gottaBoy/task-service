/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMResView;
import SA.TM.Ctrl.Data.TMResViewDetail;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMResViewHelper {
    public void Init(ISRFDAGlobalHelper var1, TMResView var2) throws Exception;

    public int getVersion();

    public String getId();

    public String getName();

    public String getUserId();

    public Vector<TMResViewDetail> getResViewDetails();
}

