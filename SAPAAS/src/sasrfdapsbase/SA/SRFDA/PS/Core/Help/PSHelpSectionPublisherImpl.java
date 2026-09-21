/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpSection;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionPublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionTempl;
import SA.SRFDA.PS.Core.Help.PSHelpPublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSHelpSectionTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpSectionPublisherImpl
extends PSHelpPublisherImpl
implements IPSHelpSectionPublisher {
    private static final Log log = LogFactory.getLog(PSHelpSectionPublisherImpl.class);
    protected IPSHelpSectionTempl iPSHelpSectionTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSHelpSection iPSHelpSection = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSHelpSectionTempl iPSHelpSectionTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSHelpSectionTempl = iPSHelpSectionTempl;
        this.onInit();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSHelpSection iPSHelpSection) throws Exception {
        this.iPSHelpSection = iPSHelpSection;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSSystem = iPSHelpSection.getPSHelpArticle().getPSSystem();
        return this.onGenerateCode();
    }

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(this.iPSHelpSection);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("publisher", this);
        params.put("item", this.iPSHelpSection);
        params.put("sys", this.iPSHelpSection.getPSHelpArticle().getPSSystem());
        this.onFillGenerateCodeParams(this.iPSHelpSection, params);
        PSHelpSectionTempl psHelpSectionTempl = this.iPSHelpSectionTempl.getPSHelpSectionTemplData();
        if (!StringHelper.IsNullOrEmpty((String)psHelpSectionTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psHelpSectionTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psHelpSectionTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psHelpSectionTempl, "TEMPLCODE2", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    @Override
    protected void onFillGenerateCodeParams(Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(obj, params);
        ArrayList<IPSGenerateCodeResult> list = new ArrayList<IPSGenerateCodeResult>();
        Iterator<IPSHelpSection> psHelpSections = this.iPSHelpSection.getPSHelpSections();
        if (psHelpSections != null) {
            while (psHelpSections.hasNext()) {
                IPSHelpSection iPSHelpSection = psHelpSections.next();
                IPSHelpSectionTempl iPSHelpSectionTempl = iPSHelpSection.getPSHelpSectionTempl();
                if (iPSHelpSectionTempl == null) continue;
                IPSHelpSectionPublisher iPSHelpSectionPublisher = iPSHelpSectionTempl.getPSHelpSectionPublisher();
                list.add(iPSHelpSectionPublisher.generateCode(this.iPSPublisherContext, iPSHelpSection));
                iPSHelpSectionPublisher.close();
            }
        }
        params.put("sections", list);
    }

    @Override
    public void close() {
        this.iPSPublisherContext = null;
        this.iPSHelpSection = null;
        this.iPSSystem = null;
        this.onClose();
        if (this.iPSHelpSectionTempl != null) {
            this.iPSHelpSectionTempl.releasePSHelpSectionPublisher(this);
        }
    }

    protected IPSHelpSectionTempl getPSHelpSectionTempl() {
        return this.iPSHelpSectionTempl;
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }
}

