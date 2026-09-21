/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.dr.IPSDEDRCustomItem
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.dr.IPSDEDRCustomItem;
import net.ibizsys.model.dataentity.dr.PSDEDRItemImpl;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.util.StringHelper;

public class PSDEDRCustomItemImpl
extends PSDEDRItemImpl
implements IPSDEDRCustomItem {
    private IPSDataEntity minorPSDataEntity = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEDRItemData().getVIEWPSDEID())) {
            this.minorPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity(this.getPSDEDRItemData().getVIEWPSDEID());
        }
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
}

