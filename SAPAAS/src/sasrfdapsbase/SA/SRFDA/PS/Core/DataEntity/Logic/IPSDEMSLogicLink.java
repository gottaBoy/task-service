/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLinkGroupCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicNode;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u4e3b\u72b6\u6001\u903b\u8f91\u8fde\u63a5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELogicLink")
public interface IPSDEMSLogicLink
extends IPSDELogicLinkBase {
    public void init(ISRFDAGlobalHelper var1, IPSDEMSLogic var2, PSDELogicLink var3) throws Exception;

    public IPSDEMSLogicLinkGroupCond getPSDEMSLogicLinkGroupCond();

    public IPSDEMSLogicNode getDstPSDEMSLogicNode() throws Exception;

    public IPSDEMSLogicNode getSrcPSDEMSLogicNode() throws Exception;

    public IPSDEMSLogic getPSDEMSLogic();

    public Iterator<? extends IPSDEMSLogicLinkCond> getAllPSDEMSLogicLinkConds();

    public boolean isDefaultLink();
}

