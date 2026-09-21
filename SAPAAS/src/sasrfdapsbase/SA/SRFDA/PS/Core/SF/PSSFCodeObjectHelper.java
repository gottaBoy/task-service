/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.HashMap;
import java.util.Properties;

public class PSSFCodeObjectHelper {
    private static HashMap<String, String> deCodeTypeMap = new HashMap();

    static {
        deCodeTypeMap.put("DAO", "");
        deCodeTypeMap.put("DAOBASE", "");
        deCodeTypeMap.put("SERVICE", "");
        deCodeTypeMap.put("SERVICEBASE", "");
        deCodeTypeMap.put("DEMODEL", "");
        deCodeTypeMap.put("DEMODELBASE", "");
        deCodeTypeMap.put("ENTITY", "");
        deCodeTypeMap.put("ENTITYBASE", "");
    }

    public static String getClassOrPkgName(IPSSFCodeObject iPSSFCodeObject, IPSSFCodeObject parentPSSFCodeObject, Properties classOrPkgNameMap, String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        String strFullKey = StringHelper.Format((String)"%1$s.%2$s", (Object)strCodeType, (Object)iPSSysSFPub.getSFStyle());
        String strClsOrPkgName = PropertiesHelper.GetProperty((Properties)classOrPkgNameMap, (String)strFullKey);
        if (!StringHelper.IsNullOrEmpty((String)strClsOrPkgName)) {
            strClsOrPkgName = strClsOrPkgName.trim();
        }
        if (!StringHelper.IsNullOrEmpty((String)strClsOrPkgName)) {
            return strClsOrPkgName;
        }
        strClsOrPkgName = PropertiesHelper.GetProperty((Properties)classOrPkgNameMap, (String)strCodeType);
        if (!StringHelper.IsNullOrEmpty((String)strClsOrPkgName)) {
            strClsOrPkgName = strClsOrPkgName.trim();
        }
        if (!StringHelper.IsNullOrEmpty((String)strClsOrPkgName)) {
            return strClsOrPkgName;
        }
        if (parentPSSFCodeObject != null) {
            if (iPSSFCodeObject != null && !StringHelper.IsNullOrEmpty((String)iPSSFCodeObject.getCodeName())) {
                strFullKey = StringHelper.Format((String)"[%1$s].%2$s", (Object)iPSSFCodeObject.getCodeName().toUpperCase(), (Object)strCodeType);
                strClsOrPkgName = parentPSSFCodeObject.getClassOrPkgName(strCodeType, iPSSysSFPub);
                if (!StringHelper.IsNullOrEmpty((String)strClsOrPkgName)) {
                    strClsOrPkgName = strClsOrPkgName.trim();
                }
                if (!StringHelper.IsNullOrEmpty((String)strClsOrPkgName)) {
                    return strClsOrPkgName;
                }
            }
            return parentPSSFCodeObject.getClassOrPkgName(strCodeType, iPSSysSFPub);
        }
        return iPSSysSFPub.getPSSFStyle().getClassOrPkgName(strCodeType);
    }
}

