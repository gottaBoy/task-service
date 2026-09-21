/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2OneDataDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER11;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDER1NImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDER11Impl
extends PSDER1NImpl
implements IPSDER11 {
    private static final Log log = LogFactory.getLog(PSDER11Impl.class);
    private IPSOne2OneDataDEField iPSOne2OneDataDEField = null;
    private boolean bCalcPSOne2OneDataDEField = false;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onFillViewParentModeJO(JSONObject jo) {
        super.onFillViewParentModeJO(jo);
        if (!jo.has("SRFDER11ID".toLowerCase())) {
            jo.put("SRFDER11ID".toLowerCase(), (Object)this.getName());
        }
    }

    @Override
    @PSModelRTMeta(description="\u4e00\u5bf9\u4e00\u5173\u7cfb\u6570\u636e\u5c5e\u6027", dumpref=true, ignorepf=true)
    public IPSOne2OneDataDEField getPSOne2OneDataDEField() throws Exception {
        if (this.iPSOne2OneDataDEField == null && !this.bCalcPSOne2OneDataDEField) {
            Iterator<IPSDEField> psDEFields = this.getMajorPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSOne2OneDataDEField iPSOne2OneDataDEField;
                    IPSDEField iPSDEField = psDEFields.next();
                    if (!(iPSDEField instanceof IPSOne2OneDataDEField) || (iPSOne2OneDataDEField = (IPSOne2OneDataDEField)iPSDEField).getPSDER() == null || StringHelper.Compare((String)iPSOne2OneDataDEField.getPSDER().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    if (this.iPSOne2OneDataDEField != null) break;
                    this.iPSOne2OneDataDEField = iPSOne2OneDataDEField;
                    break;
                }
            }
            this.bCalcPSOne2OneDataDEField = true;
        }
        return this.iPSOne2OneDataDEField;
    }
}

