/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysEditorStyle;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

public interface IPSSysEditorStyle
extends IPSSystemObject {
    public static final String EDITORPARAM_REALSTYLECODE = "REALSTYLECODE";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysEditorStyle var3) throws Exception;

    public String getPSEditorTypeId();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public boolean isReplaceDefault();

    public double getEditorWidth();

    public double getEditorHeight();

    public Properties getEditorParams();

    public int getEditorParam(String var1, int var2);

    public String getEditorParam(String var1, String var2);

    public double getEditorParam(String var1, double var2);

    public boolean getEditorParam(String var1, boolean var2);

    public String getAjaxHandlerType();

    public String getPSAjaxHandlerId();

    public IPSEditorType getPSEditorType() throws Exception;

    public String getRefViewShowMode();

    public String getLinkViewShowMode();

    public String getStyleCode();

    public String getEditorType();

    public String getContainerType();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public IPSSysCss getPSSysCss();

    public boolean isExtendStyleOnly();
}

