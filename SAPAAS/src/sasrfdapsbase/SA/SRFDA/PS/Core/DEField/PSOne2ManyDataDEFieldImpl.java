/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSOne2ManyDataDEField;
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
public class PSOne2ManyDataDEFieldImpl
extends PSDEFieldImpl
implements IPSOne2ManyDataDEField {
    private static final Log log = LogFactory.getLog(PSOne2ManyDataDEFieldImpl.class);
    private IPSDER1N iPSDER1N = null;
    private IPSDERBase iPSDERBase = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4e00\u5bf9\u591a\u5173\u7cfb", dumpref=true, allowempty=false, fields={"O2MPSDERID"})
    public IPSDERBase getPSDER() throws Exception {
        if (this.iPSDERBase != null) {
            return this.iPSDERBase;
        }
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEFieldData().getO2MPSDERID())) {
            throw new Exception(StringHelper.Format((String)"\u4e00\u5bf9\u591a\u5173\u7cfb\u6570\u636e\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb", (Object)this.getFullModelName()));
        }
        IPSDERBase iPSDER = this.getPSDataEntity().getPSDER(true, this.getPSDEFieldData().getO2MPSDERID());
        if (!(iPSDER instanceof IPSDER1N) && !(iPSDER instanceof IPSDERCustom)) {
            throw new Exception(StringHelper.Format((String)"\u4e00\u5bf9\u591a\u5173\u7cfb\u6570\u636e\u5c5e\u6027[%1$s]\u5b9e\u4f53\u5173\u7cfb[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.getFullModelName(), (Object)iPSDER.getName()));
        }
        this.iPSDERBase = iPSDER;
        return this.iPSDERBase;
    }

    @Override
    public synchronized IPSDER1N getPSDER1N() throws Exception {
        if (this.iPSDER1N != null) {
            return this.iPSDER1N;
        }
        if (this.getPSDER() instanceof IPSDER1N) {
            this.iPSDER1N = (IPSDER1N)this.getPSDER();
        }
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="Map\u5f62\u5f0f", ignoredumpvalues="false")
    public boolean isMap() {
        return "ONE2MANYDATA_MAP".equalsIgnoreCase(this.getDataType());
    }
}

