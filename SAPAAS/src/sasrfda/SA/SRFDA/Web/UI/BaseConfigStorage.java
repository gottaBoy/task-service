/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.UI;

import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;

public abstract class BaseConfigStorage {
    protected ArrayList arrConfigPaths = null;

    public void setConfigPaths(ArrayList arrConfigPaths) {
        this.arrConfigPaths = arrConfigPaths;
    }

    public String GetConfigFilePath(String strPartFilePath) throws Exception {
        int nCount = this.arrConfigPaths.size();
        int i = 0;
        while (i < nCount) {
            String strFilePath = String.valueOf(this.arrConfigPaths.get(i).toString()) + strPartFilePath;
            File file = new File(strFilePath);
            if (file.exists()) {
                return strFilePath;
            }
            ++i;
        }
        throw new Exception(StringHelper.Format((String)"\u6307\u5b9a\u914d\u7f6e\u8def\u5f84[%1$s]\u4e0d\u5b58\u5728", (Object)strPartFilePath));
    }

    protected abstract String GetConfigRootFolder();

    public String GetRealConfigFilePath(String strConfigId) throws Exception {
        return this.GetConfigFilePath(String.valueOf(this.GetConfigRootFolder()) + File.separator + this.GetRealPath(strConfigId) + this.GetFileExt());
    }

    protected String GetFileExt() {
        return ".xml";
    }

    public String GetRealPath(String strPath) throws Exception {
        int nPos;
        if (StringHelper.StringLength((String)strPath) == 0) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u4f20\u5165\u8def\u5f84");
        }
        ArrayList<String> arrList = new ArrayList<String>();
        String strRealPath = "";
        while ((nPos = strPath.indexOf(".")) != -1) {
            String strPartA = strPath.substring(0, nPos);
            arrList.add(strPartA);
            strPath = strPath.substring(nPos + 1);
        }
        arrList.add(strPath);
        int i = 0;
        while (i < arrList.size()) {
            if (strRealPath.length() != 0) {
                strRealPath = String.valueOf(strRealPath) + File.separator;
            }
            strRealPath = String.valueOf(strRealPath) + (String)arrList.get(i);
            ++i;
        }
        return strRealPath;
    }
}

