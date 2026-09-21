/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.Control.Calendar.IPSSysCalendarItem;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSSysCalendarItemRV;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u65e5\u5386\u90e8\u4ef6\u9879\u5173\u8054\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysCalendarItemRV")
public interface IPSSysCalendarItemRV
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysCalendarItem var2, PSSysCalendarItemRV var3) throws Exception;

    public String getPSDEViewBaseId();

    public IPSSysCalendarItem getPSSysCalendarItem();

    public String getViewParam();
}

