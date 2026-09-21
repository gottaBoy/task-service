/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEViewLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicImpl;

public class PSDEViewLogicImpl
extends PSDEUILogicImpl
implements IPSDEViewLogic,
IPSAppDEUILogic {
    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEUILOGIC";
        }
        return "PSDEUILOGIC";
    }
}

