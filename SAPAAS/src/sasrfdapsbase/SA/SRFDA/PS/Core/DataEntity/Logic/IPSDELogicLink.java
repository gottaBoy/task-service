/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELogicLink")
public interface IPSDELogicLink
extends IPSDELogicLinkBase {
    public static final int LINKMODE_COMMON = 0;
    public static final int LINKMODE_DEFAULT = 1;
    public static final int LINKMODE_CATCH = 9;
    public static final int LINKMODE_SUBCALL = 10;

    public void init(ISRFDAGlobalHelper var1, IPSDELogic var2, PSDELogicLink var3) throws Exception;

    public IPSDELogicLinkGroupCond getPSDELogicLinkGroupCond();

    public IPSDELogicNode getDstPSDELogicNode() throws Exception;

    public IPSDELogicNode getSrcPSDELogicNode() throws Exception;

    public IPSDELogic getPSDELogic();

    public Iterator<? extends IPSDELogicLinkCond> getAllPSDELogicLinkConds();

    public boolean isDefaultLink();

    public boolean isCatchLink();

    public boolean isSubCallLink();
}

