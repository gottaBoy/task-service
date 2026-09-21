/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.DevScriptSet
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Dev.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DevScriptSet;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ScriptSetHelper {
    private static final Log log = LogFactory.getLog(ScriptSetHelper.class);

    public static CallResult ExportJS(ISRFDAGlobalHelper iGlobalHelper, boolean bReleaseMode) {
        OutputStream out;
        String strSQL = "select * from T_SRFDEVScriptSet where VALIDFLAG=1 order by CODEORDER";
        Vector list = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)iGlobalHelper, (String)strSQL, null, list, (String)DevScriptSet.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5f00\u53d1\u811a\u672c\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        TreeMap<Integer, OutputStream> jsFuncMap = new TreeMap<Integer, OutputStream>();
        jsFuncMap.put(Integer.MAX_VALUE, null);
        jsFuncMap.put(141, null);
        jsFuncMap.put(125, null);
        if (iGlobalHelper.getDAModelVersion() >= 10022300) {
            Vector pages;
            strSQL = StringHelper.Format((String)"select t1.PAGEFUNC,t2.PAGEFUNC AS PTPAGEFUNC from t_SRFPage  t1 LEFT JOIN T_SRFPageTempl t2 ON t1.PAGETEMPLID=t2.PAGETEMPLID  ");
            callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)iGlobalHelper, (String)strSQL, null, pages = new Vector(), (String)Page.class.getName());
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u9875\u9762\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            for (Page page : pages) {
                jsFuncMap.put(page.getRealPageFunc(), null);
            }
        }
        String strRTFolder = String.valueOf(iGlobalHelper.GetAppRootPath()) + "jscript";
        strRTFolder = String.valueOf(strRTFolder) + File.separator;
        strRTFolder = String.valueOf(strRTFolder) + "rt";
        strRTFolder = String.valueOf(strRTFolder) + File.separator;
        Iterator<Object> iterator = jsFuncMap.keySet().iterator();
        while (iterator.hasNext()) {
            int nFunc = (Integer)iterator.next();
            try {
                String strFilePath = StringHelper.Format((String)"%1$s%2$s.js", (Object)strRTFolder, (Object)nFunc);
                File file = new File(strFilePath);
                if (file.exists()) {
                    file.delete();
                }
                out = new FileOutputStream(strFilePath);
                out.write(new byte[]{-17, -69, -65});
                jsFuncMap.put(nFunc, out);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        for (DevScriptSet scriptSet : list) {
            Iterator iterator2 = jsFuncMap.keySet().iterator();
            while (iterator2.hasNext()) {
                int nFunc = (Integer)iterator2.next();
                if ((nFunc & scriptSet.getSCRIPTGROUP()) <= 0) continue;
                try {
                    out = (OutputStream)jsFuncMap.get(nFunc);
                    if (out == null) continue;
                    out.write(scriptSet.getRCODE().getBytes("UTF-8"));
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        iterator = jsFuncMap.keySet().iterator();
        while (iterator.hasNext()) {
            int nFunc = (Integer)iterator.next();
            try {
                OutputStream out2 = (OutputStream)jsFuncMap.get(nFunc);
                if (out2 == null) continue;
                out2.flush();
                out2.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return callResult;
    }
}

