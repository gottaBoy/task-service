/*
 * Decompiled with CFR 0.152.
 */
package SA.TM.Ctrl.Model;

import SA.TM.Ctrl.ITMResBaseHelper;
import SA.TM.Ctrl.Model.BaseTMObjectModel;

public class TMResourceModel
extends BaseTMObjectModel {
    protected ITMResBaseHelper iTMResBaseHelper = null;

    public TMResourceModel(ITMResBaseHelper iTMResBaseHelper) {
        this.iTMResBaseHelper = iTMResBaseHelper;
        this.setId(iTMResBaseHelper.getId());
        this.setName(iTMResBaseHelper.getName());
        this.setVersion(iTMResBaseHelper.getVersion());
    }
}

