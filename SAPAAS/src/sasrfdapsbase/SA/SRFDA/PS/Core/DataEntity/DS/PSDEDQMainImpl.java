/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQMain;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQJoinImpl;

public class PSDEDQMainImpl
extends PSDEDQJoinImpl
implements IPSDEDQMain {
    @Override
    public boolean isExcludeMode() {
        return false;
    }

    @Override
    public boolean isDistinctMode() {
        return false;
    }
}

