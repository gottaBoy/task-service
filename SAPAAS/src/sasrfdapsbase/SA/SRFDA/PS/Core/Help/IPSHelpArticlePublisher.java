/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpPublisher;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSHelpArticlePublisher
extends IPSHelpPublisher {
    public void init(ISRFDAGlobalHelper var1, IPSHelpArticleTempl var2) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext var1, IPSHelpArticle var2) throws Exception;

    public void saveFile(IPSPublisherContext var1, IPSHelpArticle var2) throws Exception;
}

