/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSListItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEListItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5217\u8868\u90e8\u4ef6\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEListItem")
public interface IPSDEListItem
extends IPSListItem {
    public void init(ISRFDAGlobalHelper var1, IPSDEList var2, PSDEListItem var3) throws Exception;

    public IPSDEList getPSDEList();

    public int getWidth();

    public String getDataItemName();

    public String getValueFormat();

    public IPSDEField getPSDEField();

    public IPSAppDEField getPSAppDEField();

    public IPSDEUIActionGroup getPSDEUIActionGroup();

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;
}

