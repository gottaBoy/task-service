/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import java.util.Comparator;

public class DEFHelperComparator
implements Comparator<IDEFHelper> {
    @Override
    public int compare(IDEFHelper arg0, IDEFHelper arg1) {
        int nValue1 = arg0.getDEField().getORDERFLAG();
        int nValue2 = arg1.getDEField().getORDERFLAG();
        return nValue1 - nValue2;
    }
}

