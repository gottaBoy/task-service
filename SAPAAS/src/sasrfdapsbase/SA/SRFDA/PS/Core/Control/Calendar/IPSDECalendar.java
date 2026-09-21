/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Calendar;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Calendar.IPSCalendar;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u65e5\u5386\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysCalendar")
public interface IPSDECalendar
extends IPSCalendar {
    public static final String LEGENDPOS_NONE = "NONE";
    public static final String LEGENDPOS_TOP = "TOP";
    public static final String LEGENDPOS_BOTTOM = "BOTTOM";
    public static final String LEGENDPOS_LEFT = "LEFT";
    public static final String LEGENDPOS_RIGHT = "RIGHT";
    public static final String GROUPMODE_NONE = "NONE";
    public static final String GROUPMODE_AUTO = "AUTO";
    public static final String GROUPMODE_CODELIST = "CODELIST";
    public static final String GROUPLAYOUT_ROW = "ROW";
    public static final String GROUPLAYOUT_COLUMN = "COLUMN";

    public IPSAppDEField getGroupPSAppDEField();

    public boolean isEnableGroup();

    public String getGroupMode();

    public String getGroupLayout();

    public IPSDEField getGroupPSDEField();

    public IPSCodeList getGroupPSCodeList();

    public IPSDEField getGroupTextPSDEField();

    public IPSAppDEField getGroupTextPSAppDEField();

    public String getLegendPos();

    public int getGroupWidth();

    public int getGroupHeight();

    public IPSSysCss getGroupPSSysCss();

    public IPSSysPFPlugin getGroupPSSysPFPlugin();

    public IPSPFXCodeObject getGroupRender();
}

