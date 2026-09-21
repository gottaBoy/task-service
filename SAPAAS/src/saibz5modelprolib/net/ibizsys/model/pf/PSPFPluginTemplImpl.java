/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pf;

import java.util.HashMap;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSPFPluginTempl;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFPluginTemplRuntime;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPluginTemplImpl
extends PSObjectImpl
implements IPSPFPluginTemplRuntime {
    protected PSPFPluginTempl psPFPluginTempl = null;
    private static final Log log = LogFactory.getLog(PSPFPluginTemplImpl.class);
    private IPSPF iPSPF = null;
    private HashMap<String, PSPFPluginTempl> psPFPluginTemplMap = new HashMap();
    private String strPSPFPubCodeId = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSPFPluginTempl psPFPluginTempl) throws Exception {
        this.psPFPluginTempl = psPFPluginTempl;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(this.psPFPluginTempl.getPSPFPLUGINTEMPLID());
        this.setName(this.psPFPluginTempl.getPSPFPLUGINTEMPLNAME());
        this.setPSObjectData(this.psPFPluginTempl);
        this.iPSPF = this.getPSModelStorageContext().getPSPF(this.psPFPluginTempl.getPSPFID());
        this.strPSPFPubCodeId = this.psPFPluginTempl.getPSPFPUBCODEID();
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
            this.psPFPluginTempl.copyTo((IDataObject)psPFPluginTempl, false);
            this.psPFPluginTemplMap.put(iPSPFStyle.getId(), psPFPluginTempl);
            return psPFPluginTempl;
        }
    }
}

