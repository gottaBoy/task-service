/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelObject;

public interface IPSPanelModel
extends IPSPanelObject {
    public static final String DATATYPE_OBJECT = "OBJECT";
    public static final String DATATYPE_OBJECTARRAY = "OBJECTARRAY";
    public static final String DATATYPE_STRING = "STRING";
    public static final String DATATYPE_STRINGARRAY = "STRINGARRAY";
    public static final String DATATYPE_INT = "INT";
    public static final String DATATYPE_INTARRAY = "INTARRAY";
    public static final String DATATYPE_NUMBER = "NUMBER";
    public static final String DATATYPE_NUMBERARRAY = "NUMBERARRAY";
    public static final String DATATYPE_BOOL = "BOOL";
    public static final String MODELTYPE_PANELMODEL = "PANELMODEL";
    public static final String MODELTYPE_VIEWMODEL = "VIEWMODEL";
    public static final String MODELTYPE_CTRLMODEL = "CTRLMODEL";
    public static final String MODELTYPE_CONTEXTMODEL = "CONTEXTMODEL";

    @Override
    public String getCodeName();

    @Override
    public IPSPanel getPSPanel();

    public String getType();

    public String getDataType();

    public IPSPanelItem getPSPanelItem() throws Exception;

    public boolean isContextModel();

    public boolean isViewModel();

    public boolean isPanelModel();

    public boolean isCtrlModel();
}

