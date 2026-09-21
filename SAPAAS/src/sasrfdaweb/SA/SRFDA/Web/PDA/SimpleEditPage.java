/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Web.PDA;

import SA.SRFDA.Web.PDA.EditPage;
import SA.SRFramework.DataEx.BaseDataEntity;

public class SimpleEditPage
extends EditPage {
    @Override
    protected String OnGetDataEntityId() {
        return "DE0001";
    }

    @Override
    protected boolean FillDataEntity(BaseDataEntity dataEntity, boolean bKeyOnly) {
        if (bKeyOnly) {
            String strDEId = this.getWebContext().GetParamValue("DEID");
            dataEntity.SetParamValue("DEID", (Object)strDEId);
        }
        return true;
    }
}

