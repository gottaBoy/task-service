/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpResource;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionType;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Data.PSHelpSection;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;

public interface IPSHelpSection
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSHelpArticle var2, IPSHelpSection var3, PSHelpSection var4) throws Exception;

    public IPSHelpSection getParentPSHelpSection();

    public IPSHelpArticle getPSHelpArticle();

    public String getContent();

    public String getHeaderContent();

    public String getBottomContent();

    public String getRawHeaderContent();

    public String getRawBottomContent();

    public String getRawContent();

    public String getContent(boolean var1);

    public String getHeaderContent(boolean var1);

    public String getBottomContent(boolean var1);

    public String getSectionType();

    public Iterator<IPSHelpSection> getPSHelpSections();

    public String getTitle();

    public boolean isOutputDir();

    public IPSDEField getPSDEField();

    public IPSCodeList getPSCodeList();

    public IPSHelpArticle getRefPSHelpArticle();

    public boolean isContentAsCode();

    public int getSectionLevel();

    public IPSHelpResource getImagePSHelpResource();

    public IPSHelpResource getLinkPSHelpResource();

    public IPSHelpSection getPSHelpSectionByUserTag(String var1);

    public IPSHelpSection getPSHelpSectionByUserTag2(String var1);

    public String getSectionTag();

    public String getSectionTag2();

    @Override
    public String getCodeName();

    public IPSDEUIAction getPSDEUIAction();

    public IPSHelpSectionTempl getPSHelpSectionTempl();

    public IPSHelpSectionType getPSHelpSectionType();

    public void fillChildPSHelpSectionList(ArrayList<IPSHelpSection> var1);
}

