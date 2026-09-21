/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u5355\u6210\u5458\u903b\u8f91\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="logicType", model="PSDEFDLogic")
public interface IPSDEFDLogic
extends IPSModelObject {
    public static final String LOGICCAT_PANELVISIBLE = "PANELVISIBLE";
    public static final String LOGICCAT_ITEMENABLE = "ITEMENABLE";
    public static final String LOGICCAT_ITEMBLANK = "ITEMBLANK";
    public static final String LOGICCAT_SCRIPTCODE_CHANGE = "SCRIPTCODE_CHANGE";
    public static final String LOGICCAT_SCRIPTCODE_CLICK = "SCRIPTCODE_CLICK";
    public static final String LOGICCAT_SCRIPTCODE_FOCUS = "SCRIPTCODE_FOCUS";
    public static final String LOGICCAT_SCRIPTCODE_BLUR = "SCRIPTCODE_BLUR";
    public static final String LOGICCAT_SCRIPTCODE_PREFIX = "SCRIPTCODE_";
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";

    public void init(ISRFDAGlobalHelper var1, IPSDEFormDetail var2, IPSDEFDLogic var3, PSDEFDLogic var4) throws Exception;

    public IPSDEFormDetail getPSDEFormDetail();

    public String getLogicCat();

    public String getLogicType();
}

