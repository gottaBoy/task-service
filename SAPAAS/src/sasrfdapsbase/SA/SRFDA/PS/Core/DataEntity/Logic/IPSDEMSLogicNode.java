/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLink;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u4e3b\u72b6\u6001\u903b\u8f91\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="logicNodeType", implement="PSDEMSLogicNodeImpl", model="PSDELogicNode")
@PSModelPFIgnoreMeta
public interface IPSDEMSLogicNode
extends IPSDELogicNodeBase {
    public static final String LOGICNODETYPE_MAINSTATE = "MAINSTATE";

    public void init(ISRFDAGlobalHelper var1, IPSDEMSLogic var2, PSDELogicNode var3) throws Exception;

    public Iterator<IPSDEMSLogicLink> getPSDEMSLogicLinks();

    public IPSDEMSLogic getPSDEMSLogic();

    public IPSDEMainState getPSDEMainState();

    @Override
    public int getLeftPos();

    @Override
    public int getTopPos();

    public boolean isDefaultMode();

    public boolean isActionAllowMode();

    public boolean isOPPrivAllowMode();

    public boolean isFieldAllowMode();

    public String getStateValue();

    public Iterator<String> getOPPrivs();

    public Iterator<String> getActions();

    public Iterator<String> getFields();

    public String getCssClass();

    public String getColor();

    public String getBKColor();

    public int getOrderValue();
}

