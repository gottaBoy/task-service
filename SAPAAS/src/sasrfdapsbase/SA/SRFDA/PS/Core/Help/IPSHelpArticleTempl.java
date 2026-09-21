/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpArticlePublisher;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSHelpArticleTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSHelpArticleTempl
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSHelpArticleTempl var2) throws Exception;

    public IPSHelpArticlePublisher getPSHelpArticlePublisher() throws Exception;

    public void releasePSHelpArticlePublisher(IPSHelpArticlePublisher var1);

    public PSHelpArticleTempl getPSHelpArticleTemplData();
}

