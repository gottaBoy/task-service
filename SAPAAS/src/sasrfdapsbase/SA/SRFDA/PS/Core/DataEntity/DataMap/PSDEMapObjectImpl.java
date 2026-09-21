/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataMap;

import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapObject;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFramework.Utility.StringHelper;

public abstract class PSDEMapObjectImpl
extends PSObjectImpl
implements IPSDEMapObject {
    private IPSDEMap iPSDEMap = null;

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6620\u5c04\u5bf9\u8c61")
    public IPSDEMap getPSDEMap() {
        return this.iPSDEMap;
    }

    protected void setPSDEMap(IPSDEMap iPSDEMap) {
        this.iPSDEMap = iPSDEMap;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEMap().getPSSysModelInstId();
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEMap().getModelId(), (Object)super.getModelId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEMap().getPSDataEntity().getPSSystem());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSDEMap();
    }
}

