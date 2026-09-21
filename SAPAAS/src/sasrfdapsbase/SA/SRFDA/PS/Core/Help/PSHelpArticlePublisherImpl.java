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

import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpArticlePublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpSection;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionPublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionTempl;
import SA.SRFDA.PS.Core.Help.PSHelpPublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSHelpArticleTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpArticlePublisherImpl
extends PSHelpPublisherImpl
implements IPSHelpArticlePublisher {
    private static final Log log = LogFactory.getLog(PSHelpArticlePublisherImpl.class);
    protected IPSHelpArticleTempl iPSHelpArticleTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSHelpArticle iPSHelpArticle = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSHelpArticleTempl iPSHelpArticleTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSHelpArticleTempl = iPSHelpArticleTempl;
        this.onInit();
    }

    @Override
    public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSHelpArticle iPSHelpArticle) throws Exception {
        this.iPSHelpArticle = iPSHelpArticle;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSSystem = iPSHelpArticle.getPSSystem();
        return this.onGenerateCode();
    }

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(this.iPSHelpArticle);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("publisher", this);
        params.put("item", this.iPSHelpArticle);
        params.put("sys", this.iPSHelpArticle.getPSSystem());
        this.onFillGenerateCodeParams(this.iPSHelpArticle, params);
        PSHelpArticleTempl psHelpArticleTempl = this.iPSHelpArticleTempl.getPSHelpArticleTemplData();
        if (!StringHelper.IsNullOrEmpty((String)psHelpArticleTempl.getTEMPLCODE())) {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)psHelpArticleTempl, "TEMPLCODE", params));
        }
        if (!StringHelper.IsNullOrEmpty((String)psHelpArticleTempl.getTEMPLCODE2())) {
            psGenerateCodeResultImpl.setCode2(PSTemplHelper.generateCode((BaseDataEntity)psHelpArticleTempl, "TEMPLCODE2", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    @Override
    public void saveFile(IPSPublisherContext iPSPublisherContext, IPSHelpArticle iPSHelpArticle) throws Exception {
        this.iPSHelpArticle = iPSHelpArticle;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSSystem = iPSHelpArticle.getPSSystem();
        this.saveFile(this.iPSHelpArticle, StringHelper.Format((String)"%1$s.htm", (Object)iPSHelpArticle.getArticleSN()), "articles", null, this.iPSHelpArticleTempl.getPSHelpArticleTemplData());
    }

    @Override
    protected void onFillGenerateCodeParams(Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(obj, params);
        ArrayList<IPSGenerateCodeResult> list = new ArrayList<IPSGenerateCodeResult>();
        Iterator<IPSHelpSection> psHelpSections = this.iPSHelpArticle.getPSHelpSections();
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
        this.iPSHelpArticle = null;
        this.iPSSystem = null;
        this.onClose();
        if (this.iPSHelpArticleTempl != null) {
            this.iPSHelpArticleTempl.releasePSHelpArticlePublisher(this);
        }
    }

    protected IPSHelpArticleTempl getPSHelpArticleTempl() {
        return this.iPSHelpArticleTempl;
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }
}

