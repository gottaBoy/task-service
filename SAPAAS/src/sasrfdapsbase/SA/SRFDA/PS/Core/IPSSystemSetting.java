/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ISystemSetting
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import net.ibizsys.paas.core.ISystemSetting;

@PSModelIgnoreMeta
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
    public static final int BUGFIXS_ORACLEDATETIME = 8;
    public static final int BUGFIXS_PICKUPTEXTUIALLOWEMPTY = 16;
    public static final int BUGFIXS_ACMODEDEFAULTITEM = 32;
    public static final int BUGFIXS_DEFSFITEMCAPTION = 64;
    public static final int BUGFIXS_V2MODELRT = 128;
    public static final int BUGFIXS_SERVICEAPIMODELEX = 256;
    public static final int BUGFIXS_DEFSEARCHMODEMODELEX = 512;
    public static final int BUGFIXS_UIMODELEX = 1024;
    public static final int BUGFIXS_CODENAMECAPITALIZE = 2048;
    public static final int BUGFIXS_CODENAMEUPPERCAMEL = 4096;
    public static final int BUGFIXS_DESAVEACTIONMODELEX = 8192;
    public static final int BUGFIXS_DEINHERITMODELEX = 16384;
    public static final int BUGFIXS_DEGETDRAFTACTIONMODELEX = 32768;

    public String getDEFieldSortMode();

    public String getCLEmptyText();

    public String getCLEmptyTextPSLanguageResId();

    public IPSSysEngineConfig getPSSysEngineConfig();

    public int getDEDataExportMaxRowCount();

    public int getDEDataSetMaxRowCount();

    public int getServiceAPIMode();

    public int getDataAccCtrlArch();

    public int getEngineBugFixs();

    public int getDEFSFItemWidth();

    public String getValueFormat();

    public boolean isPubDBModel();

    public boolean isEnableLanResDefaultContent();

    public boolean isEnableDEDataVer();

    public int getDEMSActionLogicMode();

    public int getSubSysDEMSActionLogicMode();

    public boolean isEnableDERFKey();

    public boolean isAppendCtrlDEItems();

    public boolean isAutoCalcDER1NExtRestrict();

    public boolean isEnableDEFieldRestrictedUI();

    public boolean isPanelItemAutoShowCaption();

    public boolean isEnableDEFieldAudit();

    public boolean isEnableServiceAPIModelEx();

    public boolean isEnableDEFSearchModeModelEx();

    public boolean isEnableUIModelEx();

    public boolean isFixCodeNameAutoCapitalize();

    public boolean isEnableDESaveActionModelEx();

    public boolean isEnableDEInheritModelEx();

    public boolean isEnableDEGetDraftActionModelEx();
}

