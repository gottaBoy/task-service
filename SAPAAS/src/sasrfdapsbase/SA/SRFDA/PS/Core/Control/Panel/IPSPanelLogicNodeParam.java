/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicNode;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogicParam;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSPanelLogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPanelLogicNodeParam
extends IPSObject {
    public static final String PARAMTYPE_SETMODEL = "SETMODEL";
    public static final String PARAMTYPE_RESETMODEL = "RESETMODEL";
    public static final String PARAMTYPE_COPYMODEL = "COPYMODEL";
    public static final String PARAMTYPE_PUSHARRAY = "PUSHARRAY";
    public static final String SRCVALUETYPE_SRCMODEL = "SRCMODEL";
    public static final String SRCVALUETYPE_WEBCONTEXT = "WEBCONTEXT";
    public static final String SRCVALUETYPE_NONEVALUE = "NONEVALUE";
    public static final String SRCVALUETYPE_NULLVALUE = "NULLVALUE";
    public static final String SRCVALUETYPE_SRCVALUE = "SRCVALUE";

    public void init(ISRFDAGlobalHelper var1, IPSPanelLogicNode var2, PSPanelLogicNodeParam var3) throws Exception;

    public IPSPanelLogicNode getPSPanelLogicNode();

    public String getLogicNodeParamType();

    public IPSPanelLogicParam getDstPSPanelLogicParam() throws Exception;

    public String getDstFieldName() throws Exception;

    public IPSPanelLogicParam getSrcPSPanelLogicParam() throws Exception;

    public String getSrcFieldName() throws Exception;

    public String getSrcValue();

    public String getDirectCode();

    public String getSrcValueType();
}

