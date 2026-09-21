/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.TM.Ctrl.ITMTaskHelper;
import SA.TM.Ctrl.TMTaskBaseHelper;

public class TMTaskHelper
extends TMTaskBaseHelper
implements ITMTaskHelper {
    public ITMTaskHelper getUnionTask() {
        return null;
    }

    public boolean isGroupTask() {
        return false;
    }

    public boolean isMainTask() {
        return false;
    }

    public BaseDataEntity getSummaryInfo() {
        return this.OmGetSummaryInfo();
    }

    protected BaseDataEntity OmGetSummaryInfo() {
        return null;
    }
}

