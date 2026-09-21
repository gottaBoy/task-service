/*
 * Decompiled with CFR 0.152.
 */
package SA.TM.Ctrl;

import SA.TM.Ctrl.Data.TMComplexResDetail;
import SA.TM.Ctrl.ITMResBaseHelper;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMComplexResHelper
extends ITMResBaseHelper {
    public Vector<TMComplexResDetail> getComplexResDetails();

    public String getLogicResType();
}

