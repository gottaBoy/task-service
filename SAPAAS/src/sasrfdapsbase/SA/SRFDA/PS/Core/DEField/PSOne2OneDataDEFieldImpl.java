/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSOne2OneDataDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFieldImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER11;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSOne2OneDataDEFieldImpl
extends PSDEFieldImpl
implements IPSOne2OneDataDEField {
    private static final Log log = LogFactory.getLog(PSOne2OneDataDEFieldImpl.class);
    private IPSDERBase iPSDERBase = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4e00\u5bf9\u4e00\u5173\u7cfb", dumpref=true, allowempty=false, fields={"O2OPSDERID"})
    public IPSDERBase getPSDER() throws Exception {
        if (this.iPSDERBase != null) {
            return this.iPSDERBase;
        }
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEFieldData().getO2OPSDERID())) {
            throw new Exception(StringHelper.Format((String)"\u4e00\u5bf9\u4e00\u5173\u7cfb\u6570\u636e\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb", (Object)this.getFullModelName()));
        }
        IPSDERBase iPSDER = this.getPSDataEntity().getPSDER(true, this.getPSDEFieldData().getO2OPSDERID());
        if (!(iPSDER instanceof IPSDER11) && !(iPSDER instanceof IPSDERCustom)) {
            throw new Exception(StringHelper.Format((String)"\u4e00\u5bf9\u4e00\u5173\u7cfb\u6570\u636e\u5c5e\u6027[%1$s]\u5b9e\u4f53\u5173\u7cfb[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.getFullModelName(), (Object)iPSDER.getName()));
        }
        this.iPSDERBase = iPSDER;
        return this.iPSDERBase;
    }
}

