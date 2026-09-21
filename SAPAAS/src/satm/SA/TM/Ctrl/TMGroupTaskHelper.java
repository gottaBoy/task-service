/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.TM.Ctrl.ITMGroupTaskHelper;
import SA.TM.Ctrl.TMTaskBaseHelper;

public class TMGroupTaskHelper
extends TMTaskBaseHelper
implements ITMGroupTaskHelper {
    public boolean isGroupTask() {
        return true;
    }

    public boolean isMainTask() {
        return false;
    }

    public BaseDataEntity getSummaryInfo() {
        return null;
    }
}

