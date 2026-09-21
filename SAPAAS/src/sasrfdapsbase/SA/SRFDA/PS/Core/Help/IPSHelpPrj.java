/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpModule;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjTempl;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjType;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSHelpPrj;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSHelpPrj
extends IPSSystemObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSHelpPrj var3) throws Exception;

    public String getPrjType();

    public String getHeaderContent();

    public String getContent();

    public String getBottomContent();

    public String getRawHeaderContent();

    public String getRawContent();

    public String getRawBottomContent();

    public String getContent(boolean var1);

    public String getHeaderContent(boolean var1);

    public String getBottomContent(boolean var1);

    public Iterator<IPSHelpModule> getPSHelpModules();

    public String getTitle();

    public String getPrjSN();

    public Iterator<IPSHelpModule> getAllPSHelpModules();

    @Override
    public String getCodeName();

    public String getPrjTag();

    public String getPrjTag2();

    public IPSSystemModule getPSSystemModule();

    public IPSHelpPrjTempl getPSHelpPrjTempl();

    public IPSHelpPrjType getPSHelpPrjType();
}

