/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRSysDER1NItem;
import SA.SRFDA.PS.Core.DataEntity.DR.PSDEDRItemImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import net.sf.json.JSONObject;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDRItem", typevalues={"SYSDER1N"})
public class PSDEDRSysDER1NItemImpl
extends PSDEDRItemImpl
implements IPSDEDRSysDER1NItem {
    private IPSDER1N iPSDER1N = null;
    private IPSDataEntity minorPSDataEntity = null;
    private IPSDERBase iPSDERBase = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSDERBase = this.getPSDataEntity().getPSSystem().getPSDER(this.getPSDEDRItemData().getPSDERID());
        if (this.iPSDERBase != null && this.iPSDERBase instanceof IPSDER1N) {
            this.iPSDER1N = (IPSDER1N)this.iPSDERBase;
        }
        this.minorPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.iPSDERBase.getMinorDEId());
        this.fillParentDataJO(this.iPSDERBase);
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="1:N\u5173\u7cfb\u5bf9\u8c61")
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u5bf9\u8c61", dumpref=true, fields={"PSDERID"})
    public synchronized IPSDERBase getPSDER() throws Exception {
        return this.iPSDERBase;
    }

    @Override
    public String getPSDER1NName() {
        return this.getPSDEDRItemData().getPSDERNAME();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        if (super.getPSSysImage() == null && this.minorPSDataEntity != null) {
            return this.minorPSDataEntity.getPSSysImage();
        }
        return super.getPSSysImage();
    }

    @Override
    protected void onFillViewParamJO(JSONObject viewParamJO) throws Exception {
        if (!viewParamJO.has("SRFPARENTTYPE")) {
            viewParamJO.put("SRFPARENTTYPE", (Object)"DER1N");
        }
        if (!viewParamJO.has("SRFDER1NID")) {
            viewParamJO.put("SRFDER1NID", (Object)this.getPSDER1NName());
        }
        super.onFillViewParamJO(viewParamJO);
    }

    @Override
    protected IPSDataEntity onGetViewPSDataEntity() throws Exception {
        return this.minorPSDataEntity;
    }
}

