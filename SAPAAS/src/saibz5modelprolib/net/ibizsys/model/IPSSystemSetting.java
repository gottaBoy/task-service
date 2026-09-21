/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.paas.core.ISystemSetting
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSSysEngineConfig;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.core.ISystemSetting;

public interface IPSSystemSetting
extends IPSModelObject,
ISystemSetting {
    public static final String DEFSORTMODE_NAME = "NAME";
    public static final String DEFSORTMODE_CREATEDATE = "CREATEDATE";
    public static final String DEFSORTMODE_NAME_PDT = "NAME_PDT";
    public static final String DEFSORTMODE_CREATEDATE_PDT = "CREATEDATE_PDT";
    public static final int SERVICEAPI_NOTSUPPORT = 0;
    public static final int SERVICEAPI_SUPPORT = 1;
    public static final int BUGFIXS_GRIDDATAITEMNAME = 1;
    public static final int BUGFIXS_GRIDCOLDATAITEM = 2;
    public static final int BUGFIXS_MDCTRLWFDATAITEMS = 4;

    public String getDEFieldSortMode();

    public String getCLEmptyText();

    public String getCLEmptyTextPSLanguageResId();

    public IPSSysEngineConfig getPSSysEngineConfig();

    public int getDEDataExportMaxRowCount();

    public int getServiceAPIMode();

    public int getDataAccCtrlArch();

    public int getEngineBugFixs();

    public int getDEFSFItemWidth();

    public String getValueFormat();
}

