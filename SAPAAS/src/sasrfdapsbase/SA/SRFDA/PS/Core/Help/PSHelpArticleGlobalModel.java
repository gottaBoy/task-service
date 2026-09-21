/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleType;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSHelpArticle;
import SA.SRFDA.PS.Data.PSHelpSection;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpArticleGlobalModel
extends PSSystemGlobalModelBase<String, PSHelpArticle, IPSHelpArticle> {
    private static final Log log = LogFactory.getLog(PSHelpArticleGlobalModel.class);

    @Override
    protected PSHelpArticle GetObject(String strPSHelpArticleId) {
        return null;
    }

    @Override
    protected IPSHelpArticle OnCreateModelHelper(PSHelpArticle vt) throws Exception {
        IPSHelpArticleType iPSHelpArticleType = this.iPSModelStorage.getPSHelpArticleType(vt.getARTICLETYPE());
        IPSHelpArticle iPSHelpArticle = iPSHelpArticleType.createPSHelpArticle(vt);
        iPSHelpArticle.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSHelpArticle;
    }

    @Override
    protected Boolean TestObjectRenew(PSHelpArticle obj) {
        return false;
    }

    @Override
    protected IPSHelpArticle registerModel(PSHelpArticle vt) throws Exception {
        IPSHelpArticle iPSHelpArticle = (IPSHelpArticle)this.InternalGetModelHelper(vt.getPSHELPARTICLEID());
        if (iPSHelpArticle != null) {
            return iPSHelpArticle;
        }
        this.setModel(vt.getPSHELPARTICLEID(), vt, null);
        iPSHelpArticle = (IPSHelpArticle)this.FindModelHelper(vt.getPSHELPARTICLEID());
        return iPSHelpArticle;
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSHelpArticle> getAllModels() throws Exception {
        Vector<PSHelpArticle> list = new Vector<PSHelpArticle>();
        CallResult callResult = this.iPSModelHelper.getAllPSHelpArticles(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u5e2e\u52a9\u6587\u7ae0\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSHelpSection> list2 = new Vector<PSHelpSection>();
        callResult = this.iPSModelHelper.getAllPSHelpSections(this.iPSSystem.getId(), list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u5e2e\u52a9\u7ae0\u8282\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSHelpArticle> psHelpArticleMap = new HashMap<String, PSHelpArticle>();
        for (PSHelpArticle psHelpArticle : list) {
            psHelpArticleMap.put(psHelpArticle.getPSHELPARTICLEID(), psHelpArticle);
        }
        HashMap<String, PSHelpSection> psHelpSectionMap = new HashMap<String, PSHelpSection>();
        for (PSHelpSection psHelpSection : list2) {
            psHelpSectionMap.put(psHelpSection.getPSHELPSECTIONID(), psHelpSection);
        }
        for (PSHelpSection psHelpSection : list2) {
            if (StringHelper.IsNullOrEmpty((String)psHelpSection.getPPSHELPSECTIONID())) {
                PSHelpArticle psHelpArticle = (PSHelpArticle)((Object)psHelpArticleMap.get(psHelpSection.getPSHELPARTICLEID()));
                if (psHelpArticle == null) continue;
                psHelpArticle.getRootPSHelpSections(true).add(psHelpSection);
                continue;
            }
            PSHelpSection parentPSHelpSection = (PSHelpSection)((Object)psHelpSectionMap.get(psHelpSection.getPPSHELPSECTIONID()));
            if (parentPSHelpSection == null) continue;
            parentPSHelpSection.getChildPSHelpSections(true).add(psHelpSection);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSHelpArticle vt) {
        return vt.getPSHELPARTICLEID();
    }
}

