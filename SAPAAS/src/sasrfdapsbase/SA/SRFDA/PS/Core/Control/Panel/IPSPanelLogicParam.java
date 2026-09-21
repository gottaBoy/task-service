/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelModel;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSPanelLogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPanelLogicParam
extends IPSObject {
    public static final String PARAMTYPE_INPUT = "INPUT";
    public static final String PARAMTYPE_TEMP = "TEMP";
    public static final String PARAMTYPE_PANELMODEL = "PANELMODEL";
    public static final String DATATYPE_OBJECT = "OBJECT";
    public static final String DATATYPE_OBJECTARRAY = "OBJECTARRAY";
    public static final String DATATYPE_STRING = "STRING";
    public static final String DATATYPE_STRINGARRAY = "STRINGARRAY";
    public static final String DATATYPE_INT = "INT";
    public static final String DATATYPE_INTARRAY = "INTARRAY";
    public static final String DATATYPE_NUMBER = "NUMBER";
    public static final String DATATYPE_NUMBERARRAY = "NUMBERARRAY";
    public static final String DATATYPE_BOOL = "BOOL";

    public void init(ISRFDAGlobalHelper var1, IPSPanelLogic var2, PSPanelLogicParam var3) throws Exception;

    public IPSPanelLogic getPSPanelLogic();

    public String getCodeName();

    public String getType();

    public String getDataType();

    public IPSPanelModel getPSPanelModel();
}

