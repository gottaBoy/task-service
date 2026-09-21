/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.HashMap;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSPFPluginTempl;
import net.ibizsys.model.entity.PSSysPFPluginTempl;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.model.res.IPSSysPFPluginTemplRuntime;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPFPluginTemplImpl
extends PSSystemObjectImpl
implements IPSSysPFPluginTemplRuntime {
    protected PSSysPFPluginTempl psSysPFPluginTempl = null;
    private static final Log log = LogFactory.getLog(PSSysPFPluginTemplImpl.class);
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSPF iPSPF = null;
    private HashMap<String, PSSysPFPluginTempl> psSysPFPluginTemplMap = new HashMap();
    private String strPSPFPubCodeId = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSysPFPlugin iPSSysPFPlugin, PSSysPFPluginTempl psSysPFPluginTempl) throws Exception {
        this.psSysPFPluginTempl = psSysPFPluginTempl;
        this.iPSSysPFPlugin = iPSSysPFPlugin;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(this.psSysPFPluginTempl.getPSSYSPFPITEMPLID());
        this.setName(this.psSysPFPluginTempl.getPSSYSPFPITEMPLNAME());
        this.setPSObjectData(this.psSysPFPluginTempl);
        if (!StringHelper.isNullOrEmpty((String)this.psSysPFPluginTempl.getTEMPLCODE2EX())) {
            this.psSysPFPluginTempl.setTEMPLCODE2(this.psSysPFPluginTempl.getTEMPLCODE2EX());
        }
        this.iPSPF = this.getPSModelStorageContext().getPSPF(this.psSysPFPluginTempl.getPSPFID());
        this.strPSPFPubCodeId = this.psSysPFPluginTempl.getPSPFPUBCODEID();
        this.onInit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public PSSysPFPluginTempl getPSSysPFPluginTemplData(IPSPFStyle iPSPFStyle) throws Exception {
        if (iPSPFStyle == null) {
            return this.psSysPFPluginTempl;
        }
        HashMap<String, PSSysPFPluginTempl> hashMap = this.psSysPFPluginTemplMap;
        synchronized (hashMap) {
            PSSysPFPluginTempl psSysPFPluginTempl = this.psSysPFPluginTemplMap.get(iPSPFStyle.getId());
            if (psSysPFPluginTempl != null) {
                return psSysPFPluginTempl;
            }
            psSysPFPluginTempl = new PSSysPFPluginTempl();
            this.psSysPFPluginTempl.copyTo((IDataObject)psSysPFPluginTempl, false);
            this.psSysPFPluginTemplMap.put(iPSPFStyle.getId(), psSysPFPluginTempl);
            return psSysPFPluginTempl;
        }
    }

    @Override
    public IPSPF getPSPF() {
        return this.iPSPF;
    }

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    public String getCode(String strCodeTag) {
        String strCodeTag2 = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeTag);
        return this.psSysPFPluginTempl.getParamStringValue(strCodeTag2, "");
    }

    @Override
    public String getPSPFPubCodeId() {
        return this.strPSPFPubCodeId;
    }

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSPFPluginTempl psPFPluginTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public BaseDataEntity getPSPFPluginTemplData(IPSPFStyle iPSPFStyle) throws Exception {
        return this.getPSSysPFPluginTemplData(iPSPFStyle);
    }
}

