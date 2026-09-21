/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pf;

import java.util.HashMap;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSPFPubCode;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.IPSPFPubCodeRuntime;
import net.ibizsys.model.pf.PSPFObjectImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPubCodeImpl
extends PSPFObjectImpl
implements IPSPFPubCodeRuntime {
    protected PSPFPubCode psPFPubCode = null;
    private static final Log log = LogFactory.getLog(PSPFPubCodeImpl.class);
    private boolean bPreviewPubCode = false;
    private boolean bDynaViewCode = false;
    private boolean bDynaModelCode = false;
    private String strPreviewCode = "";
    private String strPluginTemplCode = "";
    protected HashMap<String, IPSPFPubCode> psPFPubCodeMap = null;
    private IPSPFPubCode parentPSPFPubCode = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPF iPSPF, IPSPFPubCode parentPSPFPubCode, PSPFPubCode psPFPubCode) throws Exception {
        this.psPFPubCode = psPFPubCode;
        this.setPSPF(iPSPF);
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(this.psPFPubCode.getPSPFPUBCODEID());
        this.setName(this.psPFPubCode.getPSPFPUBCODENAME());
        this.setPSObjectData(this.psPFPubCode);
        this.parentPSPFPubCode = parentPSPFPubCode;
        if (!this.psPFPubCode.isPREVIEWFLAGNull()) {
            this.bPreviewPubCode = this.psPFPubCode.getPREVIEWFLAG();
        }
        if (!this.psPFPubCode.isDYNAVIEWFLAGNull()) {
            this.bDynaViewCode = this.psPFPubCode.getDYNAVIEWFLAG();
        }
        if (!this.psPFPubCode.isDYNAMODELFLAGNull()) {
            this.bDynaModelCode = this.psPFPubCode.getDYNAMODELFLAG();
        }
        this.strPluginTemplCode = this.psPFPubCode.getPITEMPLCODE();
        this.strPreviewCode = this.psPFPubCode.getPREVIEWCODE();
        this.onInit();
    }

    @Override
    public String getTargetType() {
        return this.psPFPubCode.getTARGETTYPE();
    }

    @Override
    public String getPreviewCode() {
        return this.strPreviewCode;
    }

    @Override
    public String getPluginTemplCode() {
        return this.strPluginTemplCode;
    }

    @Override
    public boolean isDynaViewPubCode() {
        return this.bDynaViewCode;
    }

    @Override
    public boolean isDynaModelPubCode() {
        return this.bDynaModelCode;
    }
}

