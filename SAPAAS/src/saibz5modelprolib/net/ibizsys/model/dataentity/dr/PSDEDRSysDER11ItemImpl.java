/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.dr.IPSDEDRSysDER11Item
 *  net.ibizsys.model.der.IPSDER11
 *  net.ibizsys.model.der.IPSDERBase
 *  net.ibizsys.model.res.IPSSysImage
 */
package net.ibizsys.model.dataentity.dr;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.dr.IPSDEDRSysDER11Item;
import net.ibizsys.model.dataentity.dr.PSDEDRItemImpl;
import net.ibizsys.model.der.IPSDER11;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.res.IPSSysImage;

public class PSDEDRSysDER11ItemImpl
extends PSDEDRItemImpl
implements IPSDEDRSysDER11Item {
    private IPSDER11 iPSDER11 = null;
    private IPSDataEntity minorPSDataEntity = null;

    @Override
    protected void onInit() throws Exception {
        IPSDERBase iPSDERBase = this.getPSDataEntity().getPSSystem().getPSDER(this.getPSDEDRItemData().getPSDERID());
        if (iPSDERBase != null && iPSDERBase instanceof IPSDER11) {
            this.iPSDER11 = (IPSDER11)iPSDERBase;
        }
        if (this.iPSDER11 != null) {
            this.minorPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity(this.iPSDER11.getMinorDEId());
        }
        super.onInit();
    }

    @PSModelRTMeta(description="1:1\u5173\u7cfb\u5bf9\u8c61")
    public IPSDER11 getPSDER11() {
        return this.iPSDER11;
    }

    public String getPSDER11Name() {
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
    protected void onFillViewParamJO(ObjectNode viewParamJO) throws Exception {
        if (!viewParamJO.has("SRFPARENTTYPE")) {
            viewParamJO.put("SRFPARENTTYPE", "DER11");
        }
        if (!viewParamJO.has("SRFDER11ID")) {
            viewParamJO.put("SRFDER11ID", this.getPSDER11Name());
        }
        super.onFillViewParamJO(viewParamJO);
    }
}

