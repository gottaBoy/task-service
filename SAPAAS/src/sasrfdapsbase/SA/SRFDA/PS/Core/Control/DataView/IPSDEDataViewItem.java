/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.Control.IPSControlItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEDataViewItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5361\u7247\u89c6\u56fe\u90e8\u4ef6\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataViewItem")
public interface IPSDEDataViewItem
extends IPSModelObject,
IPSControlItem {
    public static final String ITEMTYPE_ACTIONITEM = "ACTIONITEM";
    public static final String ITEMTYPE_DATAITEM = "DATAITEM";

    public void init(ISRFDAGlobalHelper var1, IPSDEDataView var2, PSDEDataViewItem var3) throws Exception;

    public IPSDEDataView getPSDEDataView();

    public String getDataItemName();

    public String getValueFormat();

    public String[] getFields();

    public IPSCodeList getPSCodeList();

    public String getCLConvertMode();

    public IPSDEField getPSDEField();

    public IPSAppDEField getPSAppDEField();

    public String getCaption();

    public IPSLanguageRes getCapPSLanguageRes();

    public boolean isEnableSort();

    public IPSDEUIActionGroup getPSDEUIActionGroup();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public String getItemType();

    public boolean isCustomCode();

    public String getScriptCode();
}

