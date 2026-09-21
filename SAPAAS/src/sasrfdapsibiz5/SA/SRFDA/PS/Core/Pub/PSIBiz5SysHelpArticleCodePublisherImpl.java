/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Help.IPSHelpArticle
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysHelpArticleCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psHelpArticles = this.iPSSystem.getAllPSHelpArticles();
        if (psHelpArticles != null) {
            while (psHelpArticles.hasNext()) {
                IPSHelpArticle iPSHelpArticle = (IPSHelpArticle)psHelpArticles.next();
                if (iPSHelpArticle.getPSSystemModule() != null && iPSHelpArticle.getPSSystemModule().isSubSysModule() && !iPSHelpArticle.getPSSystemModule().isSubSysAsCloud() || iPSHelpArticle.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSHelpArticle.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSHelpArticle, null);
            }
        }
    }

    protected void onGenerateCode(IPSHelpArticle iPSHelpArticle, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSHelpArticle, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSHelpArticle) {
            IPSHelpArticle iPSHelpArticle = (IPSHelpArticle)iPSObject;
            if (iPSHelpArticle.getPSSystemModule() != null && iPSHelpArticle.getPSSystemModule().isSubSysModule() && !iPSHelpArticle.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSHelpArticle.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSHelpArticle.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSHelpArticle, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        super.onClose();
    }
}

