/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.field.IPSLinkDEField
 *  net.ibizsys.model.dataentity.field.IPSPickupDEField
 *  net.ibizsys.model.dataentity.field.IPSPickupDataDEField
 *  net.ibizsys.model.der.IPSDER1N
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity.field;

import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.dataentity.field.IPSLinkDEField;
import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.model.dataentity.field.IPSPickupDataDEField;
import net.ibizsys.model.dataentity.field.PSLinkDEFieldImpl;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.paas.util.StringHelper;

public class PSPickupDataDEFieldImpl
extends PSLinkDEFieldImpl
implements IPSPickupDataDEField {
    protected IPSPickupDEField psPickupDEField = null;
    private IPSDER1N iPSDER1N = null;
    private boolean bEnableWriteBack = false;

    @Override
    public void setInitParam(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, IPSDEFieldType iPSDEFieldType, PSDEField psDEField) {
        if (!psDEField.isENAWRITEBACKNull()) {
            this.bEnableWriteBack = psDEField.getENAWRITEBACK();
        }
        super.setInitParam(iPSModelStorageContext, iPSDataEntity, iPSDEFieldType, psDEField);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027")
    public boolean isPhisicalDEField() {
        if (this.getPSDEFieldData().getDEFTYPE() == 1) {
            return true;
        }
        return super.isPhisicalDEField();
    }

    @PSModelRTMeta(description="\u5916\u952e\u5c5e\u6027")
    public synchronized IPSPickupDEField getPSPickupDEField() throws Exception {
        if (this.psPickupDEField != null) {
            return this.psPickupDEField;
        }
        Iterator psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
            if (StringHelper.compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
            if (!(iPSDEField instanceof IPSLinkDEField)) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u4e0d\u662f\u5173\u7cfb\u5c5e\u6027", (Object)iPSDEField.getFullName()));
            }
            IPSLinkDEField iPSLinkDEField = (IPSLinkDEField)iPSDEField;
            if (StringHelper.compare((String)iPSLinkDEField.getPSDER().getName(), (String)this.getPSDER().getName(), (boolean)false) != 0) continue;
            if (!(iPSDEField instanceof IPSPickupDEField)) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u4e0d\u662f\u5916\u952e\u503c\u5c5e\u6027", (Object)iPSDEField.getFullName()));
            }
            this.psPickupDEField = (IPSPickupDEField)iPSLinkDEField;
            break;
        }
        return this.psPickupDEField;
    }

    @PSModelRTMeta(description="1:N\u5173\u7cfb\u5bf9\u8c61")
    public synchronized IPSDER1N getPSDER1N() throws Exception {
        if (this.iPSDER1N != null) {
            return this.iPSDER1N;
        }
        if (!(this.getPSDER() instanceof IPSDER1N)) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u5173\u7cfb[%1$s]\u4e0d\u662f1:N\u5173\u7cfb", (Object)this.getPSDER().getName()));
        }
        this.iPSDER1N = (IPSDER1N)this.getPSDER();
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u56de\u5199")
    public boolean isEnableWriteBack() {
        return this.bEnableWriteBack;
    }
}

