/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.CaseFormat
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEActionService
 */
package SA.SRFDA.PS.Core.Util;

import com.google.common.base.CaseFormat;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;

public class PSModelCodeNameUtils {
    private static Map<String, String> defaultUpperCamelCodeNameMap;

    static {
        String strCodeName;
        defaultUpperCamelCodeNameMap = new HashMap<String, String>();
        defaultUpperCamelCodeNameMap.put("EditView", "");
        defaultUpperCamelCodeNameMap.put("EditView2", "");
        defaultUpperCamelCodeNameMap.put("EditView3", "");
        defaultUpperCamelCodeNameMap.put("FormPickupDataView", "");
        defaultUpperCamelCodeNameMap.put("GridView", "");
        defaultUpperCamelCodeNameMap.put("IndexPickupDataView", "");
        defaultUpperCamelCodeNameMap.put("MobEditView", "");
        defaultUpperCamelCodeNameMap.put("MobFormPickupMDView", "");
        defaultUpperCamelCodeNameMap.put("MobIndexPickupMDView", "");
        defaultUpperCamelCodeNameMap.put("MobMDView", "");
        defaultUpperCamelCodeNameMap.put("MobMPickupView", "");
        defaultUpperCamelCodeNameMap.put("MobPickupMDView", "");
        defaultUpperCamelCodeNameMap.put("MobPickupView", "");
        defaultUpperCamelCodeNameMap.put("MobRedirectView", "");
        defaultUpperCamelCodeNameMap.put("MPickupView", "");
        defaultUpperCamelCodeNameMap.put("PickupGridView", "");
        defaultUpperCamelCodeNameMap.put("PickupView", "");
        defaultUpperCamelCodeNameMap.put("RedirectView", "");
        String[] stringArray = PSDEActionService.DEACTIONS;
        int n = PSDEActionService.DEACTIONS.length;
        int n2 = 0;
        while (n2 < n) {
            strCodeName = stringArray[n2];
            defaultUpperCamelCodeNameMap.put(strCodeName, "");
            ++n2;
        }
        stringArray = PSDEActionService.DEACTIONS2;
        n = PSDEActionService.DEACTIONS2.length;
        n2 = 0;
        while (n2 < n) {
            strCodeName = stringArray[n2];
            defaultUpperCamelCodeNameMap.put(strCodeName, "");
            ++n2;
        }
    }

    public static String to(String strCodeNameMode, String strCodeName) {
        return PSModelCodeNameUtils.to(strCodeNameMode, null, strCodeName, null);
    }

    public static String to(String strCodeNameMode, String strPrefix, String strCodeName) {
        return PSModelCodeNameUtils.to(strCodeNameMode, strPrefix, strCodeName, null);
    }

    public static String to(String strCodeNameMode, String strPrefix, String strCodeName, String strSuffix) {
        StringBuilderEx sb;
        block81: {
            block79: {
                block77: {
                    if (StringHelper.isNullOrEmpty((String)strCodeNameMode) || "NONE".equalsIgnoreCase(strCodeNameMode)) {
                        if (StringHelper.isNullOrEmpty((String)strPrefix) && StringHelper.isNullOrEmpty((String)strSuffix)) {
                            return strCodeName;
                        }
                        StringBuilderEx sb2 = new StringBuilderEx();
                        if (!StringHelper.isNullOrEmpty((String)strPrefix)) {
                            sb2.append(strPrefix);
                        }
                        if (!StringHelper.isNullOrEmpty((String)strCodeName)) {
                            sb2.append(strCodeName);
                        }
                        if (!StringHelper.isNullOrEmpty((String)strSuffix)) {
                            sb2.append(strSuffix);
                        }
                        return sb2.toString();
                    }
                    boolean bRemoveConsecutiveUppercase = false;
                    switch (strCodeNameMode) {
                        case "LOWER_HYPHEN": 
                        case "LOWER_UNDERSCORE": 
                        case "UPPER_UNDERSCORE": {
                            bRemoveConsecutiveUppercase = true;
                        }
                    }
                    if (!StringHelper.isNullOrEmpty((String)strPrefix)) {
                        strPrefix = PSModelCodeNameUtils.toUpperCamel(strPrefix, bRemoveConsecutiveUppercase);
                    }
                    if (!StringHelper.isNullOrEmpty((String)strCodeName)) {
                        strCodeName = PSModelCodeNameUtils.toUpperCamel(strCodeName, bRemoveConsecutiveUppercase);
                    }
                    if (!StringHelper.isNullOrEmpty((String)strSuffix)) {
                        strSuffix = PSModelCodeNameUtils.toUpperCamel(strSuffix, bRemoveConsecutiveUppercase);
                    }
                    sb = new StringBuilderEx();
                    if (StringHelper.isNullOrEmpty((String)strPrefix)) break block77;
                    switch (strCodeNameMode) {
                        case "LOWER_UNDERSCORE": {
                            sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, strPrefix));
                            sb.append("_");
                            break;
                        }
                        case "UPPER_UNDERSCORE": {
                            sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, strPrefix));
                            sb.append("_");
                            break;
                        }
                        case "LOWER_HYPHEN": {
                            sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, strPrefix));
                            sb.append("-");
                            break;
                        }
                        case "LOWER": {
                            sb.append(strPrefix.toLowerCase());
                            break;
                        }
                        case "UPPER": {
                            sb.append(strPrefix.toUpperCase());
                            break;
                        }
                        default: {
                            sb.append(strPrefix);
                        }
                    }
                }
                if (StringHelper.isNullOrEmpty((String)strCodeName)) break block79;
                switch (strCodeNameMode) {
                    case "LOWER_UNDERSCORE": {
                        sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, strCodeName));
                        break;
                    }
                    case "UPPER_UNDERSCORE": {
                        sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, strCodeName));
                        break;
                    }
                    case "LOWER_HYPHEN": {
                        sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, strCodeName));
                        break;
                    }
                    case "LOWER": {
                        sb.append(strCodeName.toLowerCase());
                        break;
                    }
                    case "UPPER": {
                        sb.append(strCodeName.toUpperCase());
                        break;
                    }
                    default: {
                        sb.append(strCodeName);
                    }
                }
            }
            if (StringHelper.isNullOrEmpty((String)strSuffix)) break block81;
            switch (strCodeNameMode) {
                case "LOWER_UNDERSCORE": {
                    sb.append("_");
                    sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, strSuffix));
                    break;
                }
                case "UPPER_UNDERSCORE": {
                    sb.append("_");
                    sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, strSuffix));
                    break;
                }
                case "LOWER_HYPHEN": {
                    sb.append("-");
                    sb.append(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, strSuffix));
                    break;
                }
                case "LOWER": {
                    sb.append(strSuffix.toLowerCase());
                    break;
                }
                case "UPPER": {
                    sb.append(strSuffix.toUpperCase());
                    break;
                }
                default: {
                    sb.append(strSuffix);
                }
            }
        }
        return sb.toString();
    }

    public static String toUpperCamel(String strCodeName, boolean bRemoveConsecutiveUppercase) {
        if (StringHelper.isNullOrEmpty((String)strCodeName)) {
            return strCodeName;
        }
        if (bRemoveConsecutiveUppercase) {
            StringBuilderEx sb = new StringBuilderEx();
            boolean bLastUpper = false;
            boolean bUpper = false;
            int i = 0;
            while (i < strCodeName.length()) {
                if (i == 0) {
                    sb.append(strCodeName.substring(i, i + 1).toUpperCase());
                    bLastUpper = true;
                } else {
                    String strItem = strCodeName.substring(i, i + 1);
                    if (!strItem.toUpperCase().equals(strItem)) {
                        sb.append(strItem);
                        bLastUpper = false;
                    } else if (i == strCodeName.length() - 1) {
                        if (bLastUpper) {
                            sb.append(strItem.toLowerCase());
                            bLastUpper = false;
                        } else {
                            sb.append(strItem);
                            bLastUpper = true;
                            bUpper = true;
                        }
                    } else if (bLastUpper) {
                        String strItem2 = strCodeName.substring(i + 1, i + 2);
                        if (strItem2.toUpperCase().equals(strItem2)) {
                            sb.append(strItem.toLowerCase());
                        } else {
                            sb.append(strItem);
                            bLastUpper = true;
                            bUpper = true;
                        }
                    } else {
                        sb.append(strItem);
                        bLastUpper = true;
                        bUpper = true;
                    }
                }
                ++i;
            }
            strCodeName = sb.toString();
        }
        if (strCodeName.indexOf("_") != -1) {
            if (!strCodeName.equals(strCodeName.toLowerCase())) {
                StringBuilderEx sb2 = new StringBuilderEx();
                int i = 0;
                while (i < strCodeName.length()) {
                    if (i == 0) {
                        sb2.append(strCodeName.substring(i, i + 1).toLowerCase());
                    } else {
                        String strItem = strCodeName.substring(i, i + 1);
                        if (!strItem.toUpperCase().equals(strItem)) {
                            sb2.append(strItem);
                        } else {
                            sb2.append("_");
                            sb2.append(strItem.toLowerCase());
                        }
                    }
                    ++i;
                }
                strCodeName = sb2.toString();
            }
            strCodeName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, strCodeName);
        }
        return strCodeName;
    }

    public static String getDefaultUpperCamelCodeName(String strCodeName) {
        return defaultUpperCamelCodeNameMap.get(strCodeName);
    }

    public static String capitalize(String strCodeName) {
        if (!StringHelper.isNullOrEmpty((String)strCodeName)) {
            String strHeader = strCodeName.substring(0, 1).toUpperCase();
            return String.format("%1$s%2$s", strHeader, strCodeName.substring(1));
        }
        return strCodeName;
    }
}

