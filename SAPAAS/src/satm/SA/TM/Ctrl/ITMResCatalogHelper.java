/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMResCD;
import SA.TM.Ctrl.Data.TMResCatalog;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMResCatalogHelper {
    public void Init(ISRFDAGlobalHelper var1, TMResCatalog var2) throws Exception;

    public String getId();

    public String getName();

    public int getVersion();

    public Vector<TMResCD> getResCatalogDetails();

    public String getTMTaskResAEId();
}

