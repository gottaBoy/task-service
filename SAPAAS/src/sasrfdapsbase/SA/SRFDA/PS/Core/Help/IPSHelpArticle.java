/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpArticleType;
import SA.SRFDA.PS.Core.Help.IPSHelpSection;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSHelpArticle;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSHelpArticle
extends IPSSystemObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSHelpArticle var3) throws Exception;

    public String getArticleType();

    public String getHeaderContent();

    public String getContent();

    public String getBottomContent();

    public String getRawHeaderContent();

    public String getRawContent();

    public String getRawBottomContent();

    public String getContent(boolean var1);

    public String getHeaderContent(boolean var1);

    public String getBottomContent(boolean var1);

    public IPSHelpArticleType getPSHelpArticleType();

    public IPSHelpArticleTempl getPSHelpArticleTempl();

    public Iterator<IPSHelpSection> getPSHelpSections();

    public String getTitle();

    public IPSDataEntity getPSDataEntity();

    public String getArticleSN();

    @Override
    public String getCodeName();

    public String getArticleTag();

    public String getArticleTag2();

    public String getArticleVer();

    public Iterator<IPSHelpSection> getAllPSHelpSections();

    public IPSSystemModule getPSSystemModule();
}

