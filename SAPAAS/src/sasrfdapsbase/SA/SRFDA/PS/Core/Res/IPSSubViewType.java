/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Data.PSSubViewType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface IPSSubViewType
extends IPSSystemObject {
    public static final String NAMEMODE_APPEND = "APPEND";
    public static final String NAMEMODE_REPLACE = "REPLACE";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSubViewType var3) throws Exception;

    public String getTypeCode();

    public String getNameMode();

    public boolean isExtendView();

    public boolean isExtendCtrl();

    public String getViewParam(String var1, String var2);

    public int getViewParam(String var1, int var2);

    public boolean getViewParam(String var1, boolean var2);

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSUIEngineType getPSUIEngineType();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public boolean isExtendStyleOnly();

    public ObjectNode getViewModel();

    public boolean isReplaceDefault();

    public String getViewType();

    public String getPSSysViewPanelId();
}

