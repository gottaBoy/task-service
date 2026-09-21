/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRCustomItem;
import SA.SRFDA.PS.Core.DataEntity.DR.PSDEDRItemImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDRItem", typevalues={"CUSTOM"})
public class PSDEDRCustomItemImpl
extends PSDEDRItemImpl
implements IPSDEDRCustomItem {
    private IPSDataEntity minorPSDataEntity = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEDRItemData().getVIEWPSDEID())) {
            this.minorPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.getPSDEDRItemData().getVIEWPSDEID());
        }
        this.fillParentDataJO(null);
        super.onInit();
    }

    public IPSDataEntity getMinorPSDataEntity() {
        return this.minorPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        if (super.getPSSysImage() == null && this.minorPSDataEntity != null) {
            return this.minorPSDataEntity.getPSSysImage();
        }
        return super.getPSSysImage();
    }

    @Override
    protected void fillParentDataJO(IPSDERBase iPSDERBase) throws Exception {
        super.fillParentDataJO(iPSDERBase);
        JSONObject parentDataJO = this.getParentDataJO(true);
        if (parentDataJO != null && !parentDataJO.has("SRFPARENTTYPE")) {
            parentDataJO.put("SRFPARENTTYPE", (Object)"CUSTOM");
        }
    }
}

