/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFIUpdateDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEFIUpdate;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u5355\u9879\u66f4\u65b0\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFIUpdate")
public interface IPSDEFormItemUpdate
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEForm var2, PSDEFIUpdate var3) throws Exception;

    public IPSDEForm getPSDEForm();

    @Override
    public String getCodeName();

    public Iterator<IPSDEFIUpdateDetail> getPSDEFIUpdateDetails();

    public IPSDEAction getPSDEAction() throws Exception;

    public boolean isShowBusyIndicator();

    public IPSAppDEMethod getPSAppDEMethod() throws Exception;

    public boolean isCustomCode();

    public String getScriptCode();

    public int getModelState();
}

