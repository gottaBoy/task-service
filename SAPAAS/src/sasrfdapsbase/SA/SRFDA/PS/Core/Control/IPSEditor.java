/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.Control.IPSEditorItem;
import SA.SRFDA.PS.Core.Control.IPSEditorParam;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysDictCat;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u7f16\u8f91\u5668\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="editorType", implement="PSEditorImpl")
public interface IPSEditor
extends IPSModelObject {
    public static final String EDITORTYPE_AC = "AC";
    public static final String EDITORTYPE_AC_FS = "AC_FS";
    public static final String EDITORTYPE_AC_FS_NOBUTTON = "AC_FS_NOBUTTON";
    public static final String EDITORTYPE_AC_NOBUTTON = "AC_NOBUTTON";
    public static final String EDITORTYPE_ADDRESSPICKUP = "ADDRESSPICKUP";
    public static final String EDITORTYPE_ADDRESSPICKUP_AC = "ADDRESSPICKUP_AC";
    public static final String EDITORTYPE_CHECKBOX = "CHECKBOX";
    public static final String EDITORTYPE_CHECKBOXLIST = "CHECKBOXLIST";
    public static final String EDITORTYPE_DATEPICKER = "DATEPICKER";
    public static final String EDITORTYPE_DATEPICKEREX = "DATEPICKEREX";
    public static final String EDITORTYPE_DATEPICKEREX_HOUR = "DATEPICKEREX_HOUR";
    public static final String EDITORTYPE_DATEPICKEREX_MINUTE = "DATEPICKEREX_MINUTE";
    public static final String EDITORTYPE_DATEPICKEREX_NODAY = "DATEPICKEREX_NODAY";
    public static final String EDITORTYPE_DATEPICKEREX_NODAY_NOSECOND = "DATEPICKEREX_NODAY_NOSECOND";
    public static final String EDITORTYPE_DATEPICKEREX_NOTIME = "DATEPICKEREX_NOTIME";
    public static final String EDITORTYPE_DATEPICKEREX_SECOND = "DATEPICKEREX_SECOND";
    public static final String EDITORTYPE_DROPDOWNLIST = "DROPDOWNLIST";
    public static final String EDITORTYPE_DROPDOWNLIST_100 = "DROPDOWNLIST_100";
    public static final String EDITORTYPE_FILEUPLOADER = "FILEUPLOADER";
    public static final String EDITORTYPE_FILEUPLOADER_ONE = "FILEUPLOADERONE";
    public static final String EDITORTYPE_HIDDEN = "HIDDEN";
    public static final String EDITORTYPE_HTMLEDITOR = "HTMLEDITOR";
    public static final String EDITORTYPE_IPADDRESSTEXTBOX = "IPADDRESSTEXTBOX";
    public static final String EDITORTYPE_LISTBOX = "LISTBOX";
    public static final String EDITORTYPE_LISTBOXPICKUP = "LISTBOXPICKUP";
    public static final String EDITORTYPE_MDROPDOWNLIST = "MDROPDOWNLIST";
    public static final String EDITORTYPE_MOB2DBARCODEREADER = "MOB2DBARCODEREADER";
    public static final String EDITORTYPE_MOBBARCODEREADER = "MOBBARCODEREADER";
    public static final String EDITORTYPE_MOBCHECKLIST = "MOBCHECKLIST";
    public static final String EDITORTYPE_MOBDATE = "MOBDATE";
    public static final String EDITORTYPE_MOBDROPDOWNLIST = "MOBDROPDOWNLIST";
    public static final String EDITORTYPE_MOBHTMLTEXT = "MOBHTMLTEXT";
    public static final String EDITORTYPE_MOBMPICKER = "MOBMPICKER";
    public static final String EDITORTYPE_MOBMULTIFILEUPLOAD = "MOBMULTIFILEUPLOAD";
    public static final String EDITORTYPE_MOBNUMBER = "MOBNUMBER";
    public static final String EDITORTYPE_MOBPASSWORD = "MOBPASSWORD";
    public static final String EDITORTYPE_MOBPICKER = "MOBPICKER";
    public static final String EDITORTYPE_MOBPICKER_DROPDOWNVIEW = "MOBPICKER_DROPDOWNVIEW";
    public static final String EDITORTYPE_MOBPICTURE = "MOBPICTURE";
    public static final String EDITORTYPE_MOBPICTURELIST = "MOBPICTURELIST";
    public static final String EDITORTYPE_MOBRADIOLIST = "MOBRADIOLIST";
    public static final String EDITORTYPE_MOBRATING = "MOBRATING";
    public static final String EDITORTYPE_MOBSINGLEFILEUPLOAD = "MOBSINGLEFILEUPLOAD";
    public static final String EDITORTYPE_MOBSLIDER = "MOBSLIDER";
    public static final String EDITORTYPE_MOBSTEPPER = "MOBSTEPPER";
    public static final String EDITORTYPE_MOBSWITCH = "MOBSWITCH";
    public static final String EDITORTYPE_MOBTEXT = "MOBTEXT";
    public static final String EDITORTYPE_MOBTEXTAREA = "MOBTEXTAREA";
    public static final String EDITORTYPE_NUMBER = "NUMBER";
    public static final String EDITORTYPE_OFFICEEDITOR = "OFFICEEDITOR";
    public static final String EDITORTYPE_OFFICEEDITOR2 = "OFFICEEDITOR2";
    public static final String EDITORTYPE_PASSWORD = "PASSWORD";
    public static final String EDITORTYPE_PICKER = "PICKER";
    public static final String EDITORTYPE_PICKEREX_DROPDOWNVIEW = "PICKEREX_DROPDOWNVIEW";
    public static final String EDITORTYPE_PICKEREX_DROPDOWNVIEW_LINK = "PICKEREX_DROPDOWNVIEW_LINK";
    public static final String EDITORTYPE_PICKEREX_LINK = "PICKEREX_LINK";
    public static final String EDITORTYPE_PICKEREX_LINKONLY = "PICKEREX_LINKONLY";
    public static final String EDITORTYPE_PICKEREX_NOAC = "PICKEREX_NOAC";
    public static final String EDITORTYPE_PICKEREX_NOAC_LINK = "PICKEREX_NOAC_LINK";
    public static final String EDITORTYPE_PICKEREX_NOBUTTON = "PICKEREX_NOBUTTON";
    public static final String EDITORTYPE_PICKEREX_TRIGGER = "PICKEREX_TRIGGER";
    public static final String EDITORTYPE_PICKEREX_TRIGGER_LINK = "PICKEREX_TRIGGER_LINK";
    public static final String EDITORTYPE_PICKUPVIEW = "PICKUPVIEW";
    public static final String EDITORTYPE_PICTURE = "PICTURE";
    public static final String EDITORTYPE_PICTURE_ONE = "PICTURE_ONE";
    public static final String EDITORTYPE_RADIOBUTTONLIST = "RADIOBUTTONLIST";
    public static final String EDITORTYPE_RATING = "RATING";
    public static final String EDITORTYPE_RAW = "RAW";
    public static final String EDITORTYPE_SLIDER = "SLIDER";
    public static final String EDITORTYPE_SPAN = "SPAN";
    public static final String EDITORTYPE_SPANEX = "SPANEX";
    public static final String EDITORTYPE_SPAN_LINK = "SPAN_LINK";
    public static final String EDITORTYPE_STEPPER = "STEPPER";
    public static final String EDITORTYPE_SWITCH = "SWITCH";
    public static final String EDITORTYPE_TEXTAREA = "TEXTAREA";
    public static final String EDITORTYPE_TEXTAREA_10 = "TEXTAREA_10";
    public static final String EDITORTYPE_TEXTBOX = "TEXTBOX";
    public static final String EDITORTYPE_USERCONTROL = "USERCONTROL";
    public static final String EDITORTYPE_MARKDOWN = "MARKDOWN";
    public static final String EDITORTYPE_MOBMARKDOWN = "MOBMARKDOWN";
    public static final String EDITORTYPE_CODE = "CODE";
    public static final String EDITORTYPE_MOBCODE = "MOBCODE";
    public static final String EDITORTYPE_NUMBERRANGE = "NUMBERRANGE";
    public static final String EDITORTYPE_MOBNUMBERRANGE = "MOBNUMBERRANGE";
    public static final String EDITORTYPE_DATERANGE = "DATERANGE";
    public static final String EDITORTYPE_MOBDATERANGE = "MOBDATERANGE";
    public static final String EDITORTYPE_HTMLVIEWER = "HTMLVIEWER";
    public static final String EDITORTYPE_PICTUREVIEWER = "PICTUREVIEWER";
    public static final String EDITORTYPE_VIDEOVIEWER = "VIDEOVIEWER";
    public static final String EDITORTYPE_MARKDOWNVIEWER = "MARKDOWNVIEWER";
    public static final String EDITORTYPE_PREDEFINED = "PREDEFINED";
    public static final String EDITORTYPE_CASCADER = "CASCADER";
    public static final String EDITORTYPE_MOBCASCADER = "MOBCASCADER";
    public static final String EDITORTYPE_MAPPICKER = "MAPPICKER";
    public static final String EDITORTYPE_MOBMAPPICKER = "MOBMAPPICKER";
    public static final String EDITORTYPE_ARRAY = "ARRAY";
    public static final String EDITORTYPE_MOBARRAY = "MOBARRAY";
    public static final String EDITORTYPE_COLORPICKER = "COLORPICKER";
    public static final String EDITORTYPE_MOBCOLORPICKER = "MOBCOLORPICKER";
    public static final String EDITORPARAM_READONLY = "READONLY";
    public static final String EDITORPARAM_DEFAULTREADONLY = "DEFAULTREADONLY";
    public static final String EDITORPARAM_DISABLED = "DISABLED";
    public static final String EDITORPARAM_DEFAULTDISABLED = "DEFAULTDISABLED";
    public static final String EDITORPARAM_VALUETYPE = "VALUETYPE";
    public static final String EDITORPARAM_DEFAULTVALUETYPE = "DEFAULTVALUETYPE";
    public static final String EDITORPARAM_OBJECTNAMEFIELD = "OBJECTNAMEFIELD";
    public static final String EDITORPARAM_OBJECTIDFIELD = "OBJECTIDFIELD";
    public static final String EDITORPARAM_OBJECTVALUEFIELD = "OBJECTVALUEFIELD";
    public static final String EDITORPARAM_DEFAULTOBJECTNAMEFIELD = "DEFAULTOBJECTNAMEFIELD";
    public static final String EDITORPARAM_DEFAULTOBJECTIDFIELD = "DEFAULTOBJECTIDFIELD";
    public static final String EDITORPARAM_DEFAULTOBJECTVALUEFIELD = "DEFAULTOBJECTVALUEFIELD";
    public static final String EDITORPARAM_VALUESEPARATOR = "VALUESEPARATOR";
    public static final String EDITORPARAM_TEXTSEPARATOR = "TEXTSEPARATOR";
    public static final String EDITORPARAM_DEFAULTVALUESEPARATOR = "DEFAULTVALUESEPARATOR";
    public static final String EDITORPARAM_DEFAULTTEXTSEPARATOR = "DEFAULTTEXTSEPARATOR";
    public static final String EDITORVALUETYPE_SIMPLE = "SIMPLE";
    public static final String EDITORVALUETYPE_SIMPLES = "SIMPLES";
    public static final String EDITORVALUETYPE_OBJECT = "OBJECT";
    public static final String EDITORVALUETYPE_OBJECTS = "OBJECTS";

    public void init(ISRFDAGlobalHelper var1, IPSEditorContainer var2, String var3, IPSEditorParam var4) throws Exception;

    public IPSEditorContainer getPSEditorContainer();

    public String getEditorType();

    public String getEditorStyle();

    public double getEditorWidth();

    public double getEditorHeight();

    public boolean isEditable();

    public String getEditorCssStyle();

    public Properties getEditorParams();

    public Integer getEditorParam(String var1, Integer var2);

    public String getEditorParam(String var1, String var2);

    public Double getEditorParam(String var1, Double var2);

    public Boolean getEditorParam(String var1, Boolean var2);

    public String getEditorParam(String var1);

    public IPSSysPFPlugin getPSSysPFPlugin();

    public String getPlaceHolder();

    public IPSSysDictCat getPSSysDictCat();

    public IPSPFXCodeObject getRender();

    public IPSSysCss getPSSysCss();

    public boolean isReadOnly();

    public boolean isDisabled();

    public String getPredefinedType();

    public String getCssStyle();

    public String getDynaClass();

    public String getValueType();

    public String getObjectNameField();

    public String getObjectIdField();

    public String getObjectValueField();

    public String getValueSeparator();

    public String getTextSeparator();

    public Iterator<? extends IPSEditorItem> getPSEditorItems() throws Exception;

    public Iterator<? extends IPSControlLogic> getPSControlLogics();

    public Iterator<? extends IPSControlAttribute> getPSControlAttributes();

    public Iterator<? extends IPSControlRender> getPSControlRenders();
}

