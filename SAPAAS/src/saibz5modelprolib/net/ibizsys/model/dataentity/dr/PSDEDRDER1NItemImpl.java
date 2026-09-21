/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDER1NItem
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.model.der.IPSDERBase
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.dr;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.dr.IPSDEDRDER1NItem;
import net.ibizsys.model.dataentity.dr.PSDEDRItemImpl;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.util.StringHelper;

public class PSDEDRDER1NItemImpl
extends PSDEDRItemImpl
implements IPSDEDRDER1NItem {
    private IPSDER1N iPSDER1N = null;
    private IPSDataEntity minorPSDataEntity = null;
    private String strCountId = null;

    @Override
    protected void onInit() throws Exception {
        IPSDERBase iPSDERBase = this.getPSDataEntity().getPSSystem().getPSDER(this.getPSDEDRItemData().getPSDERID());
        if (iPSDERBase != null && iPSDERBase instanceof IPSDER1N) {
            this.iPSDER1N = (IPSDER1N)iPSDERBase;
        }
        if (this.iPSDER1N != null) {
            this.minorPSDataEntity = this.getPSDataEntity().getPSSystem().getPSDataEntity(this.iPSDER1N.getMinorDEId());
        }
        super.onInit();
    }

    @PSModelRTMeta(description="1:N\u5173\u7cfb\u5bf9\u8c61")
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    public String getPSDER1NName() {
        return this.getPSDEDRItemData().getPSDERNAME();
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
    protected void onFillViewParamJO(ObjectNode viewParamJO) throws Exception {
        if (!viewParamJO.has("SRFPARENTTYPE")) {
            viewParamJO.put("SRFPARENTTYPE", "DER1N");
        }
        if (!viewParamJO.has("SRFDER1NID")) {
            viewParamJO.put("SRFDER1NID", this.getPSDER1NName());
        }
        super.onFillViewParamJO(viewParamJO);
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bc6")
    public String getCounterId() {
        String strCounterId = super.getCounterId();
        if (!StringHelper.isNullOrEmpty((String)strCounterId)) {
            return strCounterId;
        }
        return this.strCountId;
    }
}

