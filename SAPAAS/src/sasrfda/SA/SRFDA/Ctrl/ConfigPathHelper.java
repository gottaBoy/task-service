/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import java.io.File;

public class ConfigPathHelper {
    public static String GetConfigFilePath(String strRoot, String strConfigFolder, String strConfigType, String strConfigId) {
        String strFile = String.valueOf(strRoot) + strConfigFolder;
        strFile = String.valueOf(strFile) + File.separator;
        strFile = String.valueOf(strFile) + strConfigType.toLowerCase();
        strFile = String.valueOf(strFile) + File.separator;
        strConfigId = strConfigId.toUpperCase();
        String[] strParts = strConfigId.split("[.]");
        int i = 0;
        while (i < strParts.length - 1) {
            strFile = String.valueOf(strFile) + strParts[i];
            strFile = String.valueOf(strFile) + File.separator;
            ++i;
        }
        File file = new File(strFile);
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        strFile = String.valueOf(strFile) + strParts[strParts.length - 1];
        strFile = String.valueOf(strFile) + ".xml";
        return strFile;
    }

    public static String GetSPConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "searchpanel", strConfigId);
    }

    public static String GetRuntimeSPConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetSPConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetMainMenuConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "menuex", strConfigId);
    }

    public static String GetRuntimeMainMenuConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetMainMenuConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetDGConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "datagrid", strConfigId);
    }

    public static String GetRuntimeDGConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetDGConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetTVConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "tabview", strConfigId);
    }

    public static String GetTreeViewConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "treeview", strConfigId);
    }

    public static String GetRuntimeTreeViewConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetTreeViewConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetRuntimeTVConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetTVConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetDBCallConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "dbcall", strConfigId);
    }

    public static String GetRuntimeDBCallConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetDBCallConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetCtrlConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "adv_ctrl", strConfigId);
    }

    public static String GetRuntimeCtrlConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetCtrlConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetDPConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "dynamicpanel", strConfigId);
    }

    public static String GetRuntimeDPConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetDPConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetAdvDPConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetDPConfigPath(strRoot, "configex_srfadv", strConfigId);
    }

    public static String GetToolbarConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "toolbar", strConfigId);
    }

    public static String GetRuntimeToolbarConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetToolbarConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetCommonConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "common", strConfigId);
    }

    public static String GetRuntimeCommonConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetCommonConfigPath(strRoot, "configex_runtime", strConfigId);
    }

    public static String GetDataFilterConfigPath(String strRoot, String strConfigFolder, String strConfigId) {
        return ConfigPathHelper.GetConfigFilePath(strRoot, strConfigFolder, "datafilter", strConfigId);
    }

    public static String GetRuntimeDataFilterConfigPath(String strRoot, String strConfigId) {
        return ConfigPathHelper.GetDataFilterConfigPath(strRoot, "configex_runtime", strConfigId);
    }
}

