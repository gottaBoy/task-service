/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDataDEField;
import SA.SRFDA.PS.Core.DEField.PSLinkDEFieldImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSPickupDataDEFieldImpl
extends PSLinkDEFieldImpl
implements IPSPickupDataDEField {
    private static final Log log = LogFactory.getLog(PSPickupDataDEFieldImpl.class);
    protected IPSPickupDEField psPickupDEField = null;
    private IPSDER1N iPSDER1N = null;
    private boolean bEnableWriteBack = false;
    private IPSDEField realWriteBackPSDEField = null;
    private boolean bDefinedEnableWriteBack = false;
    private boolean bIgnoreRefresh = false;

    @Override
    public void setInitParam(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSDEFieldType iPSDEFieldType, PSDEField psDEField) {
        if (!psDEField.isENAWRITEBACKNull()) {
            this.bEnableWriteBack = psDEField.getENAWRITEBACK() == 1;
            this.bIgnoreRefresh = psDEField.getENAWRITEBACK() == 2;
            this.bDefinedEnableWriteBack = true;
        }
        super.setInitParam(iDAGlobalHelper, iPSDataEntity, iPSDEFieldType, psDEField);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027", ignoredumpvalues="true")
    public boolean isPhisicalDEField() {
        if (this.getPSDEFieldData().getDEFTYPE() == 1) {
            return true;
        }
        return super.isPhisicalDEField();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u952e\u5c5e\u6027")
    public synchronized IPSPickupDEField getPSPickupDEField() throws Exception {
        if (this.psPickupDEField != null) {
            return this.psPickupDEField;
        }
        Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
            if (!(iPSDEField instanceof IPSLinkDEField)) {
                throw new Exception(StringHelper.Format((String)"[%1$s]\u4e0d\u662f\u5173\u7cfb\u5c5e\u6027", (Object)iPSDEField.getFullName()));
            }
            IPSLinkDEField iPSLinkDEField = (IPSLinkDEField)iPSDEField;
            if (StringHelper.Compare((String)iPSLinkDEField.getPSDER().getName(), (String)this.getPSDER().getName(), (boolean)false) != 0) continue;
            if (!(iPSDEField instanceof IPSPickupDEField)) {
                throw new Exception(StringHelper.Format((String)"[%1$s]\u4e0d\u662f\u5916\u952e\u503c\u5c5e\u6027", (Object)iPSDEField.getFullName()));
            }
            this.psPickupDEField = (IPSPickupDEField)iPSLinkDEField;
            break;
        }
        return this.psPickupDEField;
    }

    @Override
    @PSModelRTMeta(description="1:N\u5173\u7cfb\u5bf9\u8c61")
    public synchronized IPSDER1N getPSDER1N() throws Exception {
        if (this.iPSDER1N != null) {
            return this.iPSDER1N;
        }
        if (!(this.getPSDER() instanceof IPSDER1N)) {
            throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53\u5173\u7cfb[%1$s]\u4e0d\u662f1:N\u5173\u7cfb", (Object)this.getPSDER().getName()));
        }
        this.iPSDER1N = (IPSDER1N)this.getPSDER();
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u56de\u5199", ignoredumpvalues="false")
    public boolean isEnableWriteBack() throws Exception {
        if (this.isDefinedEnableWriteBack()) {
            return this.bEnableWriteBack;
        }
        return this.getPSDER1N().isEnableDEFieldWriteBackDefault();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u56de\u5199\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getRealWriteBackPSDEField() throws Exception {
        this.prepareRealWriteBackPSDEField();
        return this.realWriteBackPSDEField;
    }

    protected synchronized void prepareRealWriteBackPSDEField() throws Exception {
        if (this.realWriteBackPSDEField != null || !this.isEnableWriteBack()) {
            return;
        }
        this.realWriteBackPSDEField = this.getRelatedPSDEField();
    }

    protected boolean isDefinedEnableWriteBack() {
        return this.bDefinedEnableWriteBack;
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u5237\u65b0\u5f15\u7528\u5c5e\u6027\u503c", ignoredumpvalues="false")
    public boolean isIgnoreRefresh() throws Exception {
        if (this.isPhisicalDEField()) {
            if (this.isDefinedEnableWriteBack()) {
                return this.bIgnoreRefresh;
            }
            return this.getPSDER1N().isIngoreDEFieldRefreshDefault();
        }
        return false;
    }
}

