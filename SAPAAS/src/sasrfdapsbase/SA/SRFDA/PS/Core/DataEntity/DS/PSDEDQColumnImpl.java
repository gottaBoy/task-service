/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQColumn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQJoin;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;

public class PSDEDQColumnImpl
extends PSObjectImpl
implements IPSDEDQColumn {
    private String strName = null;
    private String strAlias = null;
    private IPSDEDQJoin iPSDEDQJoin = null;

    @Override
    @PSModelRTMeta(description="\u5217\u540d\u79f0")
    public String getName() {
        return this.strName;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u522b\u540d")
    public String getAlias() {
        return this.strAlias;
    }

    @Override
    public void setName(String strName) {
        this.strName = strName;
    }

    public void setAlias(String strAlias) {
        this.strAlias = strAlias;
    }

    public void setPSDEDQJoin(IPSDEDQJoin iPSDEDQJoin) {
        this.iPSDEDQJoin = iPSDEDQJoin;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSDEDQJoin != null) {
            return this.iPSDEDQJoin.getPSSysModelInstId();
        }
        return null;
    }
}

