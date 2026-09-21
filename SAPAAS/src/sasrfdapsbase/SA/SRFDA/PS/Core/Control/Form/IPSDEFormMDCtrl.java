/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupBase;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;
import java.util.Properties;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u5355\u591a\u9879\u6570\u636e\u90e8\u4ef6\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"MDCTRL"})
public interface IPSDEFormMDCtrl
extends IPSDEFormDetail,
IPSDEFormGroupBase {
    public static final int MDCTRLACTION_CREATE = 1;
    public static final int MDCTRLACTION_UPDATE = 2;
    public static final int MDCTRLACTION_REMOVE = 4;
    public static final int MDCTRLACTION_ALL = 7;
    public static final String CONTENTTYPE_LIST = "LIST";
    public static final String CONTENTTYPE_FORM = "FORM";
    public static final String CONTENTTYPE_GRID = "GRID";
    public static final String CONTENTTYPE_DATAVIEW = "DATAVIEW";
    public static final String CONTENTTYPE_REPEATER = "REPEATER";

    public String getContentType();

    public IPSControl getContentPSControl();

    public IPSDER1N getPSDER1N();

    public boolean isEnableBuildInAction(int var1);

    public int getBuildInActions();

    public IPSDEField getPSDEField();

    public String getResetItemName();

    public Iterator<String> getResetItemNames();

    public IPSAppDEField getPSAppDEField();

    public boolean isOne2OneForm();

    public String getFieldName();

    public String getPSDEFIUpdateId();

    public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception;

    public String getSubCaption();

    public IPSUIActionGroup getPSUIActionGroup();

    public String getActionGroupExtractMode();

    public Properties getCtrlParams();
}

