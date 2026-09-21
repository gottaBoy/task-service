/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.StringBuilderEx;

public class TemplFileHelper {
    public static final String IBIZTEMPLATE_HEADER = "<#ibiztemplate>";
    public static final String IBIZTEMPLATE_BOTTOM = "</#ibiztemplate>";
    public static final String IBIZINCLUDE_HEADER = "<#ibizinclude>";
    public static final String IBIZINCLUDE_BOTTOM = "</#ibizinclude>";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_TEMPLATE = "TEMPLATE";
    private int nLoopCount = 0;
    private HashMap<String, String> fileMap = new HashMap();
    private String strRootPath = null;

    public BaseDataEntity getTemplData(File file, File rootFile) throws Exception {
        this.nLoopCount = 0;
        this.fileMap.clear();
        this.strRootPath = rootFile.getCanonicalPath();
        BaseDataEntity baseDataEntity = this.getTemplData2(file, "");
        return baseDataEntity;
    }

    protected BaseDataEntity getTemplData2(File file, String strIncFile) throws Exception {
        String strFileName = file.getCanonicalPath();
        if (strFileName.indexOf(this.strRootPath) != 0) {
            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u5f15\u7528\u8d8a\u754c", (Object)strIncFile));
        }
        String templFileName = strFileName.substring(this.strRootPath.length());
        if (this.fileMap.containsKey(strFileName)) {
            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u51fa\u73b0\u5f15\u7528\u9012\u5f52", (Object)templFileName));
        }
        this.fileMap.put(strFileName, "");
        ++this.nLoopCount;
        StringBuilderEx sbContent = new StringBuilderEx();
        StringBuilderEx sbTemplate = new StringBuilderEx();
        String strContent = TemplFileHelper.readFile(file.getCanonicalPath());
        boolean bTemplateTag = false;
        while (!StringHelper.IsNullOrEmpty((String)strContent)) {
            int nTemplatePos = -1;
            if (!bTemplateTag) {
                nTemplatePos = strContent.indexOf(IBIZTEMPLATE_HEADER);
            }
            int nIncludePos = strContent.indexOf(IBIZINCLUDE_HEADER);
            if (nTemplatePos == -1 && nIncludePos == -1) {
                sbContent.append(strContent);
                break;
            }
            if (nIncludePos >= 0 && (nTemplatePos < 0 || nIncludePos < nTemplatePos)) {
                String strSubContent;
                sbContent.append(strContent.substring(0, nIncludePos));
                strContent = strContent.substring(nIncludePos + IBIZINCLUDE_HEADER.length());
                int nIncludePos2 = strContent.indexOf(IBIZINCLUDE_BOTTOM);
                if (nIncludePos2 == -1) {
                    throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u4e0d\u80fd\u5339\u914d[%2$s]", (Object)templFileName, (Object)IBIZINCLUDE_HEADER));
                }
                String strIncludeFile = strContent.substring(0, nIncludePos2);
                strContent = strContent.substring(nIncludePos2 + IBIZINCLUDE_BOTTOM.length());
                strIncludeFile = strIncludeFile.replace("\r", "");
                strIncludeFile = strIncludeFile.replace("\n", "");
                if (StringHelper.IsNullOrEmpty((String)(strIncludeFile = strIncludeFile.trim()))) {
                    throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u5f15\u7528[%2$s]\u4e0d\u5b58\u5728", (Object)templFileName, (Object)strIncludeFile));
                }
                File includeFile = null;
                includeFile = strIncludeFile.indexOf("/") == 0 ? new File(String.valueOf(this.strRootPath) + strIncludeFile) : new File(String.valueOf(file.getParent()) + File.separator + strIncludeFile);
                if (!includeFile.exists()) {
                    throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u5f15\u7528[%2$s]\u4e0d\u5b58\u5728", (Object)templFileName, (Object)strIncludeFile));
                }
                String strIncFileName = includeFile.getCanonicalPath();
                if (strIncFileName.indexOf(this.strRootPath) != 0) {
                    throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u5f15\u7528[%2$s]\u4e0d\u5b58\u5728", (Object)templFileName, (Object)strIncludeFile));
                }
                BaseDataEntity incData = this.getTemplData2(includeFile, strIncludeFile);
                String strSubTemplate = incData.getParamStringValue(FIELD_TEMPLATE, "");
                if (!StringHelper.IsNullOrEmpty((String)strSubTemplate)) {
                    if (!StringHelper.IsNullOrEmpty((String)sbTemplate.toString())) {
                        sbTemplate.append("\r\n");
                    }
                    sbTemplate.append(strSubTemplate);
                }
                if (StringHelper.IsNullOrEmpty((String)(strSubContent = incData.getParamStringValue(FIELD_CONTENT, "")))) continue;
                sbContent.append(strSubContent);
                continue;
            }
            sbContent.append(strContent.substring(0, nTemplatePos));
            strContent = strContent.substring(nTemplatePos + IBIZTEMPLATE_HEADER.length());
            int nTemplatePos2 = strContent.indexOf(IBIZTEMPLATE_BOTTOM);
            if (nTemplatePos2 == -1) {
                throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u4e0d\u80fd\u5339\u914d[%2$s]", (Object)templFileName, (Object)IBIZTEMPLATE_HEADER));
            }
            String strTemplate = strContent.substring(0, nTemplatePos2);
            strContent = strContent.substring(nTemplatePos2 + IBIZTEMPLATE_BOTTOM.length());
            if (!StringHelper.IsNullOrEmpty((String)strTemplate)) {
                if (!StringHelper.IsNullOrEmpty((String)sbTemplate.toString())) {
                    sbTemplate.append("\r\n");
                }
                sbTemplate.append(strTemplate);
            }
            if (strContent.indexOf("\r\n") == 0) {
                strContent = strContent.substring(2);
                continue;
            }
            if (strContent.indexOf("\r") == 0) {
                strContent = strContent.substring(1);
                continue;
            }
            if (strContent.indexOf("\n") != 0) continue;
            strContent = strContent.substring(1);
        }
        this.fileMap.remove(strFileName);
        BaseDataEntity baseDataEntity = new BaseDataEntity();
        baseDataEntity.set(FIELD_CONTENT, (Object)sbContent.toString());
        baseDataEntity.set(FIELD_TEMPLATE, (Object)sbTemplate.toString());
        return baseDataEntity;
    }

    static String readFile(String strFilePath) throws Exception {
        StringBuffer sb;
        block15: {
            sb = new StringBuffer();
            InputStreamReader reader = null;
            try {
                try {
                    int nLength;
                    FileInputStream fis = new FileInputStream(strFilePath);
                    reader = new InputStreamReader((InputStream)fis, "UTF-8");
                    char[] buf = new char[4096];
                    while ((nLength = reader.read(buf)) != -1) {
                        sb.append(new String(buf, 0, nLength));
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    if (reader != null) {
                        try {
                            reader.close();
                        }
                        catch (IOException iOException) {}
                    }
                    break block15;
                }
            }
            catch (Throwable throwable) {
                if (reader != null) {
                    try {
                        reader.close();
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                }
                throw throwable;
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
        return sb.toString();
    }

    public static String replaceMacros(String strContent, Properties macroParams) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strContent) || strContent.indexOf("%") == -1) {
            return strContent;
        }
        if (macroParams != null) {
            for (Map.Entry<Object, Object> entry : macroParams.entrySet()) {
                String strKey = (String)entry.getKey();
                if (strKey.indexOf("%") != 0) continue;
                String strValue = (String)entry.getValue();
                strContent = strContent.replace(strKey, strValue);
            }
        }
        return strContent;
    }
}

