/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpArticle;
import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Data.PSHelpModule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;

public interface IPSHelpModule
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSHelpPrj var2, IPSHelpModule var3, PSHelpModule var4) throws Exception;

    public IPSHelpModule getParentPSHelpModule();

    public IPSHelpPrj getPSHelpPrj();

    public Iterator<IPSHelpModule> getPSHelpModules();

    public String getTitle();

    public boolean isOutputDir();

    public int getModuleLevel();

    public IPSHelpArticle getPSHelpArticle();

    public void fillChildPSHelpModuleList(ArrayList<IPSHelpModule> var1);

    public String getArticleUrl();

    @Override
    public String getCodeName();

    public String getModuleTag();

    public String getModuleTag2();
}

