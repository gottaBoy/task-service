/*
 * Decompiled with CFR 0.152.
 */
package SA.TM.Ctrl;

import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMGroupTaskHelper;

public interface ITMMainTaskHelper
extends ITMGroupTaskHelper {
    public void ExtractTasks(ITMActionContext var1) throws Exception;

    public boolean isExtracted();
}

