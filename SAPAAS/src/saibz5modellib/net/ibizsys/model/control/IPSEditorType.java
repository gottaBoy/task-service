/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control;

import java.util.Properties;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSEditorType
extends IPSModelObject {
    public static final String EDITORTYPE_TEXTBOX = "TEXTBOX";
    public static final String EDITORTYPE_USERCONTROL = "USERCONTROL";
    public static final String EDITORTYPE_HIDDEN = "HIDDEN";
    public static final String EDITORTYPE_IPADDRESSTEXTBOX = "IPADDRESSTEXTBOX";
    public static final String EDITORTYPE_SPAN = "SPAN";
    public static final String EDITORTYPE_TEXTAREA = "TEXTAREA";
    public static final String EDITORTYPE_PICKER = "PICKER";
    public static final String EDITORTYPE_DROPDOWNLIST = "DROPDOWNLIST";
    public static final String EDITORTYPE_HTMLEDITOR = "HTMLEDITOR";
    public static final String EDITORTYPE_RAW = "RAW";
    public static final String EDITORTYPE_DATEPICKER = "DATEPICKER";
    public static final String EDITORTYPE_LISTBOX = "LISTBOX";
    public static final String EDITORTYPE_CHECKBOXLIST = "CHECKBOXLIST";
    public static final String EDITORTYPE_CHECKBOX = "CHECKBOX";
    public static final String EDITORTYPE_RADIOBUTTONLIST = "RADIOBUTTONLIST";
    public static final String EDITORTYPE_FILEUPLOADER = "FILEUPLOADER";
    public static final String EDITORTYPE_PICKEREX_TRIGGER = "PICKEREX_TRIGGER";
    public static final String EDITORTYPE_TEXTAREA_10 = "TEXTAREA_10";
    public static final String EDITORTYPE_AC = "AC";
    public static final String EDITORTYPE_AC_FS = "AC_FS";
    public static final String MBEDITORTYPE_MOB2DBARCODEREADER = "MOB2DBARCODEREADER";
    public static final String MBEDITORTYPE_MOBBARCODEREADER = "MOBBARCODEREADER";
    public static final String MBEDITORTYPE_MOBCHECKLIST = "MOBCHECKLIST";
    public static final String MBEDITORTYPE_MOBDATE = "MOBDATE";
    public static final String MBEDITORTYPE_MOBDROPDOWNLIST = "MOBDROPDOWNLIST";
    public static final String MBEDITORTYPE_MOBPICKER = "MOBPICKER";
    public static final String MBEDITORTYPE_MOBPICTURE = "MOBPICTURE";
    public static final String MBEDITORTYPE_MOBPICTURELIST = "MOBPICTURELIST";
    public static final String MBEDITORTYPE_MOBRADIOLIST = "MOBRADIOLIST";
    public static final String MBEDITORTYPE_MOBSWITCH = "MOBSWITCH";
    public static final String MBEDITORTYPE_MOBTEXT = "MOBTEXT";
    public static final String MBEDITORTYPE_MOBTEXTAREA = "MOBTEXTAREA";
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
}

