/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8fde\u63a5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELogicLink")
public interface IPSDEUILogicLink
extends IPSDELogicLinkBase {
    public static final int LINKMODE_COMMON = 0;
    public static final int LINKMODE_DEFAULT = 1;
    public static final int LINKMODE_FULFILLED = 2;
    public static final int LINKMODE_REJECTED = 3;
    public static final int LINKMODE_CATCH = 9;
    public static final int LINKMODE_SUBCALL = 10;

    public void init(ISRFDAGlobalHelper var1, IPSDEUILogic var2, PSDELogicLink var3) throws Exception;

    public IPSDEUILogicLinkGroupCond getPSDEUILogicLinkGroupCond();

    public IPSDEUILogicNode getDstPSDEUILogicNode() throws Exception;

    public IPSDEUILogicNode getSrcPSDEUILogicNode() throws Exception;

    public IPSDEUILogic getPSDEUILogic();

    public Iterator<? extends IPSDEUILogicLinkCond> getAllPSDEUILogicLinkConds();

    public int getLinkMode();

    public boolean isDefaultLink();

    public boolean isFulfilledLink();

    public boolean isRejectedLink();

    public boolean isCatchLink();

    public boolean isSubCallLink();

    public String getLinkCond();
}

