/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.entity.PSPFEditorTempl;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFEditorTemplRuntime;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pf.PSPFStyleObjectImpl;
import net.ibizsys.model.pub.IPSPFEditorCodePublisher;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFEditorTemplImpl
extends PSPFStyleObjectImpl
implements IPSPFEditorTemplRuntime {
    protected PSPFEditorTempl psPFEditorTempl = null;
    private static final Log log = LogFactory.getLog(PSPFEditorTemplImpl.class);
    private IPSEditorType iPSEditorType = null;
    private String strContainerType = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFEditorTempl psPFEditorTempl) throws Exception {
        this.psPFEditorTempl = psPFEditorTempl;
        this.setPSPF(iPSPF);
        this.setPSPFStyle(iPSPFStyle);
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(this.psPFEditorTempl.getPSPFEDITORTEMPLID());
        this.setName(this.psPFEditorTempl.getPSPFEDITORTEMPLNAME());
        this.setPSObjectData(this.psPFEditorTempl);
        this.iPSEditorType = this.getPSModelStorageContext().getPSEditorType(psPFEditorTempl.getPSEDITORTYPEID());
        this.strContainerType = psPFEditorTempl.getCONTAINERTYPE();
        this.onInit();
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.getPSPF().getPSPFPubCode(this.psPFEditorTempl.getPSPFPUBCODEID());
    }

    @Override
    public IPSPFEditorCodePublisher getPSPFEditorCodePublisher() throws Exception {
        IPSPFEditorCodePublisher iPSPFEditorCodePublisher = this.createPSPFEditorCodePublisher();
        iPSPFEditorCodePublisher.init(this.getPSModelStorageContext(), this);
        return iPSPFEditorCodePublisher;
    }

    protected IPSPFEditorCodePublisher createPSPFEditorCodePublisher() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psPFEditorTempl.getPUBOBJ())) {
            return (IPSPFEditorCodePublisher)this.getPSModelStorageContext().createObject(this.psPFEditorTempl.getPUBOBJ());
        }
        if (this.getPSPFStyle() != null) {
            IPSPFStyle templPSPFStyle = this.getPSPFStyle().getTemplPSPFStyle();
            while (templPSPFStyle != null) {
                IPSPFEditorTempl iPSPFEditorTempl = templPSPFStyle.getPSPFEditorTempl(this.getPSEditorType(), this.getContainerType(), this.getPSPFPubCode());
                if (iPSPFEditorTempl == null) break;
                if (StringHelper.isNullOrEmpty((String)((IPSPFEditorTemplRuntime)iPSPFEditorTempl).getPSPFEditorTemplData().getPUBOBJ())) {
                    if (iPSPFEditorTempl.getPSPFStyle() == null) break;
                    templPSPFStyle = iPSPFEditorTempl.getPSPFStyle().getTemplPSPFStyle();
                    continue;
                }
                return (IPSPFEditorCodePublisher)this.getPSModelStorageContext().createObject(((IPSPFEditorTemplRuntime)iPSPFEditorTempl).getPSPFEditorTemplData().getPUBOBJ());
            }
        }
        return this.getPSPF().createPSPFEditorCodePublisher();
    }

    @Override
    public PSPFEditorTempl getPSPFEditorTemplData() {
        return this.psPFEditorTempl;
    }

    public IPSEditorType getPSEditorType() {
        return this.iPSEditorType;
    }

    public String getContainerType() {
        return this.strContainerType;
    }
}

