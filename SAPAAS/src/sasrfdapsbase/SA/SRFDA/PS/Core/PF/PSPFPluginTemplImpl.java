/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPluginTemplImpl
extends PSObjectImpl
implements IPSPFPluginTempl {
    protected PSPFPluginTempl psPFPluginTempl = null;
    private static final Log log = LogFactory.getLog(PSPFPluginTemplImpl.class);
    private IPSPF iPSPF = null;
    private HashMap<String, PSPFPluginTempl> psPFPluginTemplMap = new HashMap();
    private String strPSPFPubCodeId = null;
    private String strPSPFPubCodeName = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSPFPluginTempl psPFPluginTempl) throws Exception {
        this.psPFPluginTempl = psPFPluginTempl;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFPluginTempl.getPSPFPLUGINTEMPLID());
        this.setName(this.psPFPluginTempl.getPSPFPLUGINTEMPLNAME());
        this.setPSObjectData(this.psPFPluginTempl);
        this.iPSPF = this.getPSModelStorage().getPSPF(this.psPFPluginTempl.getPSPFID());
        this.strPSPFPubCodeId = this.psPFPluginTempl.getPSPFPUBCODEID();
        this.strPSPFPubCodeName = this.psPFPluginTempl.getPSPFPUBCODENAME();
        this.onInit();
    }

    @Override
    public String getCode(String strCodeTag) {
        String strCodeTag2 = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeTag);
        return this.psPFPluginTempl.getParamStringValue(strCodeTag2, "");
    }

    @Override
    public String getPSPFPubCodeId() {
        return this.strPSPFPubCodeId;
    }

    @Override
    public String getPSPFPubCodeName() {
        return this.strPSPFPubCodeName;
    }

    @Override
    public String getModelType() {
        return "PSPFPLUGINTEMPL";
    }

    @Override
    public IPSPF getPSPF() {
        return this.iPSPF;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public BaseDataEntity getPSPFPluginTemplData(IPSPFStyle iPSPFStyle) throws Exception {
        if (iPSPFStyle == null) {
            return this.psPFPluginTempl;
        }
        HashMap<String, PSPFPluginTempl> hashMap = this.psPFPluginTemplMap;
        synchronized (hashMap) {
            PSPFPluginTempl psPFPluginTempl = this.psPFPluginTemplMap.get(iPSPFStyle.getId());
            if (psPFPluginTempl != null) {
                return psPFPluginTempl;
            }
            psPFPluginTempl = new PSPFPluginTempl();
            this.psPFPluginTempl.CopyTo(psPFPluginTempl, false);
            psPFPluginTempl.setTEMPLCODE(iPSPFStyle.replacePFStyleCode(this.psPFPluginTempl.getTEMPLCODE()));
            psPFPluginTempl.setTEMPLCODE2(iPSPFStyle.replacePFStyleCode(this.psPFPluginTempl.getTEMPLCODE2()));
            psPFPluginTempl.setTEMPLCODE3(iPSPFStyle.replacePFStyleCode(this.psPFPluginTempl.getTEMPLCODE3()));
            psPFPluginTempl.setTEMPLCODE4(iPSPFStyle.replacePFStyleCode(this.psPFPluginTempl.getTEMPLCODE4()));
            this.psPFPluginTemplMap.put(iPSPFStyle.getId(), psPFPluginTempl);
            return psPFPluginTempl;
        }
    }
}

