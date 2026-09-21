/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.form.IForm
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.Res.IPSAppDEFInputTipSet;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDRUIPart;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormFormPart;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemVR;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormMDCtrl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormPage;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSThickness;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;
import net.ibizsys.paas.control.form.IForm;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u5355\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSDEForm")
public interface IPSDEForm
extends IPSAjaxControl,
IForm,
IPSLayoutContainer,
IPSControlContainer {
    public static final String FORMFUNCMODE_WFACTION = "WFACTION";
    public static final String FORMFUNCMODE_WIZARDFORM = "WIZARDFORM";
    public static final String FORMSTYLE_SEARCHBAR = "SEARCHBAR";
    public static final String FORMSTYLE_SEARCHBAR2 = "SEARCHBAR2";
    public static final String FORMSTYLE_MOBSEARCHBAR = "MOBSEARCHBAR";
    public static final String FORMSTYLE_MOBSEARCHBAR2 = "MOBSEARCHBAR2";
    public static final String TABHEADERPOS_LEFT = "LEFT";
    public static final String TABHEADERPOS_TOP = "TOP";
    public static final String TABHEADERPOS_RIGHT = "RIGHT";
    public static final String TABHEADERPOS_BOTTOM = "BOTTOM";

    public Iterator<IPSDEFormPage> getPSDEFormPages();

    public int getPSDEFormPageCount();

    public IPSDEFormPage getPSDEFormPage(int var1) throws Exception;

    public Iterator<IPSDEFormItem> getPSDEFormItems();

    public Iterator<IPSDEFormDetail> getAllPSDEFormDetails();

    public Iterator<IPSDEFormDetail> getPSDEFormDetails();

    public IPSDEFormItem getPSDEFormItem(String var1) throws Exception;

    public IPSDEFormItem getPSDEFormItem(String var1, boolean var2) throws Exception;

    public int getDefaultLabelWidth();

    public boolean isNoTabHeader();

    public double getFormWidth();

    public Iterator<IPSDEFormDRUIPart> getPSDEFormDRUIParts();

    public IPSThickness getDefaultGroupMargin(boolean var1);

    public IPSThickness getDefaultGroupPadding(boolean var1);

    public Iterator<IPSDEFormItemUpdate> getPSDEFormItemUpdates();

    public IPSDEFormItemUpdate getPSDEFormItemUpdate(String var1) throws Exception;

    public String getPFType();

    public int getFirstLabelColSpan();

    public int getLabelColSpan();

    public int getCtrlColSpan();

    public String getLayoutMode();

    public String getFormFuncMode();

    public Iterator<IPSDEFormItemVR> getPSDEFormItemVRs();

    public IPSDEFormItemVR getPSDEFormItemVR(String var1) throws Exception;

    public String getFormStyle();

    public void hookPSDEFormItem(String var1, Object var2) throws Exception;

    public boolean isHookPSDEFormItem(String var1);

    public Iterator<String> getHookPSDEFormItems();

    public String getDefaultDetailStyle();

    public String getDefaultFormItemStyle();

    public IPSDEFormDetail getPSDEFormDetail(String var1, boolean var2) throws Exception;

    public IPSDEFormDetail getPSDEFormDetail(String var1) throws Exception;

    public Iterator<IPSDEFormMDCtrl> getPSDEFormMDCtrls();

    public Iterator<IPSDEFormFormPart> getPSDEFormFormParts();

    public String getTabHeaderPos();

    public boolean isMobileControl();

    public Iterator<? extends IPSDEFormLogic> getPSDEFormLogics();

    public boolean isEnableItemFilter();

    public IPSAppDEFInputTipSet getPSAppDEFInputTipSet();
}

