/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpArticlePublisher;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleTempl;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSHelpArticle;
import SA.SRFDA.PS.Data.PSHelpArticleType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSHelpArticleType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSHelpArticleType var2) throws Exception;

    public void initModel(IPSSystem var1, PSHelpArticle var2) throws Exception;

    public IPSHelpArticle createPSHelpArticle(PSHelpArticle var1) throws Exception;

    public IPSHelpArticlePublisher createPSHelpArticlePublisher() throws Exception;

    public IPSHelpArticleTempl getDefaultPSHelpArticleTempl();
}

