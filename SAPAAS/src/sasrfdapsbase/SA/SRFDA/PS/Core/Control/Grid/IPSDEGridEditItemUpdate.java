/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGEIUpdateDetail;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEGEIUpdate;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEGEIUpdate")
public interface IPSDEGridEditItemUpdate
extends IPSObject,
IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEGrid var2, PSDEGEIUpdate var3) throws Exception;

    public IPSDEGrid getPSDEGrid();

    @Override
    public String getCodeName();

    public Iterator<IPSDEGEIUpdateDetail> getPSDEGEIUpdateDetails();

    public IPSDEAction getPSDEAction() throws Exception;

    public boolean isShowBusyIndicator();

    public IPSAppDEMethod getPSAppDEMethod() throws Exception;

    public boolean isCustomCode();

    public String getScriptCode();
}

