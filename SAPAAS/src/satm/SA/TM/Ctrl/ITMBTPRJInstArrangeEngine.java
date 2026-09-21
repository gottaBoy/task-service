/*
 * Decompiled with CFR 0.152.
 */
package SA.TM.Ctrl;

import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTPRJInstHelper;

public interface ITMBTPRJInstArrangeEngine {
    public void Init(ITMActionContext var1, ITMBTPRJInstHelper var2) throws Exception;

    public void Arrange() throws Exception;

    public void setUserStop() throws Exception;

    public boolean isStop();
}

