/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSPickupObjectDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFieldImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSPickupObjectDEFieldImpl
extends PSDEFieldImpl
implements IPSPickupObjectDEField {
    private static final Log log = LogFactory.getLog(PSPickupObjectDEFieldImpl.class);
    private IPSDER1N iPSDER1N = null;
    private IPSDERBase iPSDERBase = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4e00\u5bf9\u591a\u5173\u7cfb", dumpref=true, allowempty=false, fields={"PSDERID"})
    public IPSDERBase getPSDER() throws Exception {
        if (this.iPSDERBase != null) {
            return this.iPSDERBase;
        }
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEFieldData().getPSDERID())) {
            throw new Exception(StringHelper.Format((String)"\u5916\u952e\u503c\u5bf9\u8c61\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb", (Object)this.getFullModelName()));
        }
        IPSDERBase iPSDER = this.getPSDataEntity().getPSDER(false, this.getPSDEFieldData().getPSDERID());
        if (!(iPSDER instanceof IPSDER1N) && !(iPSDER instanceof IPSDERCustom)) {
            throw new Exception(StringHelper.Format((String)"\u5916\u952e\u503c\u5bf9\u8c61\u5c5e\u6027[%1$s]\u5b9e\u4f53\u5173\u7cfb[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.getFullModelName(), (Object)iPSDER.getName()));
        }
        this.iPSDERBase = iPSDER;
        return this.iPSDERBase;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb")
    public synchronized IPSDER1N getPSDER1N() throws Exception {
        if (this.iPSDER1N != null) {
            return this.iPSDER1N;
        }
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEFieldData().getPSDERID())) {
            throw new Exception(StringHelper.Format((String)"\u5916\u952e\u503c\u5bf9\u8c61\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb", (Object)this.getFullModelName()));
        }
        IPSDERBase iPSDERBase = this.getPSDataEntity().getPSDER(false, this.getPSDEFieldData().getPSDERID());
        if (!(iPSDERBase instanceof IPSDER1N)) {
            throw new Exception(StringHelper.Format((String)"\u5916\u952e\u503c\u5bf9\u8c61\u5c5e\u6027[%1$s]\u5b9e\u4f53\u5173\u7cfb[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.getFullModelName(), (Object)iPSDERBase.getName()));
        }
        this.iPSDER1N = (IPSDER1N)iPSDERBase;
        return this.iPSDER1N;
    }
}

