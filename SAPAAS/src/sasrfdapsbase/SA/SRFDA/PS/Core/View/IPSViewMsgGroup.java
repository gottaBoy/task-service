/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.view.IViewMsgGroup
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroupDetail;
import SA.SRFDA.PS.Data.PSViewMsgGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.view.IViewMsgGroup;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u89c6\u56fe\u6d88\u606f\u7ec4\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSViewMsgGroup")
public interface IPSViewMsgGroup
extends IPSSystemObject,
IViewMsgGroup {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSViewMsgGroup var3) throws Exception;

    @Override
    public String getCodeName();

    public Iterator<? extends IPSViewMsgGroupDetail> getPSViewMsgGroupDetails();

    public IPSSystemModule getPSSystemModule();

    public String getTopStyle();

    public String getBottomStyle();

    public String getBodyStyle();

    public String getUniqueTag();
}

