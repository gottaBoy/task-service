/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSEditorType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelIgnoreMeta
public interface IPSEditorType
extends IPSObject {
    public static final String EDITORPARAM_PICKUPVIEW = "PICKUPVIEW";
    public static final String EDITORPARAM_LINKVIEW = "LINKVIEW";
    public static final String EDITORPARAM_USERCONTROL = "USERCONTROL";
    public static final int OUTPUTCODELISTCONFIGMODE_NONE = 0;
    public static final int OUTPUTCODELISTCONFIGMODE_SELECTEDONLY = 1;
    public static final int OUTPUTCODELISTCONFIGMODE_INCLUDECHILD = 2;
    public static final String REFVIEWSHOWMODE_NORMAL = "NORMAL";
    public static final String REFVIEWSHOWMODE_MODAL = "MODAL";
    public static final String REFVIEWSHOWMODE_EMBEDDED = "EMBEDDED";
    public static final String LINKVIEWSHOWMODE_NORMAL = "NORMAL";
    public static final String LINKVIEWSHOWMODE_MODAL = "MODAL";
    public static final String LINKVIEWSHOWMODE_EMBEDDED = "EMBEDDED";

    public void init(ISRFDAGlobalHelper var1, PSEditorType var2) throws Exception;

    public boolean isStandardEditor();

    public String getStandardPSEditorType();

    public boolean isEditable();

    public Properties getEditorParams();

    public int getEditorParam(String var1, int var2);

    public String getEditorParam(String var1, String var2);

    public double getEditorParam(String var1, double var2);

    public boolean getEditorParam(String var1, boolean var2);

    public boolean isConvertToCodeItemText();

    public boolean isNeedCodeListConfig();

    public int getOutputCodeListConfigMode();

    public String getValueProcessor();

    public int getWidth();

    public int getHeight();

    public int getWidth(String var1);

    public int getHeight(String var1);

    public boolean isUserControl();

    public boolean hasPickupView();

    public boolean hasLinkView();

    public String getAjaxHandlerType();

    public String getRefViewShowMode();

    public String getLinkViewShowMode();

    public IPSEditor createPSEditor(IPSEditorContainer var1) throws Exception;

    public boolean isEnableMobileApp();

    public boolean isEnableWebApp();
}

