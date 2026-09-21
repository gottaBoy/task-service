/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlHandlerAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSACHandlerAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5f02\u6b65\u5904\u7406\u5668\u884c\u4e3a\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSAjaxControlHandlerActionImpl")
@PSModelPFIgnoreMeta
public interface IPSAjaxHandlerAction
extends IPSModelObject,
IPSControlHandlerAction,
IPSControlAction {
    public void init(ISRFDAGlobalHelper var1, IPSAjaxHandler var2, PSACHandlerAction var3) throws Exception;

    @Override
    public String getActionType();

    @Override
    public int getTimeout();

    public boolean isValid();

    @Override
    public String getActionDesc();

    public IPSAjaxHandler getPSAjaxHandler();
}

