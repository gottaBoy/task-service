/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Mobile.UIPart;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Mobile.UIPart.IMobilePublishContext;
import SA.SRFDA.Mobile.UIPart.IMobileUIPart;
import SA.SRFDA.Mobile.UIPart.JSObjectConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Hashtable;
import java.util.TreeMap;

public abstract class BaseMobileUIPart
implements IMobileUIPart {
    public static final String JSFUNC_INITCOMPONENT = "initComponent";
    protected Hashtable<String, JSObjectConfig> jsObjectCfgMap = new Hashtable();
    private String strId = "";
    private String strUniqueName = "";
    protected ISRFDAGlobalHelper iDAGlobalHelper;
    protected IDEHelper iDEHelper;
    protected String strDEJSObjectName = "";
    public static final String DEFAULTNS = "sasrfmb";
    public static final int CODEPOS_FIRST = 1;
    public static final int CODEPOS_MIDDLE = 10;
    public static final int CODEPOS_LAST = 20;

    @Override
    public String getId() {
        return this.strId;
    }

    @Override
    public String getUniqueName() {
        return this.strUniqueName;
    }

    protected void BaseInit(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper, String strId) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iDEHelper = iDEHelper;
        this.strId = strId;
        this.strDEJSObjectName = this.getDEHelper().getName();
        if (this.iDAGlobalHelper == null) {
            throw new Exception("\u5168\u5c40\u5bf9\u8c61\u65e0\u6548");
        }
        if (this.iDEHelper == null) {
            throw new Exception("\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
        }
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    @Override
    public ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    @Override
    public void Publish(IMobilePublishContext context) throws Exception {
        this.OnPublish(context);
    }

    protected void OnPublish(IMobilePublishContext context) throws Exception {
        this.OnPublishCSSFile(context);
        this.OnPublishJSFile(context);
    }

    protected void OnPublishCSSFile(IMobilePublishContext context) throws Exception {
        String strCSSFileName = this.OnGetPublishCSSFileName();
        if (StringHelper.IsNullOrEmpty((String)strCSSFileName)) {
            return;
        }
        String strLocalFileName = String.valueOf(context.getRuntimeFolder()) + strCSSFileName;
        File file = new File(strLocalFileName);
        if (!file.exists() || context.getAlwaysCreate()) {
            OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strLocalFileName), "UTF-8");
            StringBuilderEx sb = new StringBuilderEx((Writer)out);
            out.flush();
            out.close();
        }
        context.RegisterCSSFile(strCSSFileName);
    }

    protected void OnPublishJSFile(IMobilePublishContext context) throws Exception {
        String strJSFileName = this.OnGetPublishJSFileName();
        if (StringHelper.IsNullOrEmpty((String)strJSFileName)) {
            return;
        }
        strJSFileName = strJSFileName.toLowerCase();
        String strLocalFileName = String.valueOf(context.getRuntimeFolder()) + strJSFileName;
        File file = new File(strLocalFileName);
        if (!file.exists() || context.getAlwaysCreate()) {
            OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strLocalFileName), "GBK");
            StringBuilderEx sb = new StringBuilderEx();
            this.OnUIPartCodeGenerate(context, sb);
            String strContent = sb.toString();
            out.write(strContent);
            out.flush();
            out.close();
        }
        context.RegisterJSFile(strJSFileName);
    }

    protected String OnGetPublishCSSFileName() {
        return "";
    }

    protected String OnGetPublishJSFileName() {
        return "";
    }

    @Override
    public void PreparePublish(IMobilePublishContext context) throws Exception {
        this.strUniqueName = this.OnGetUniqueName(context);
        this.OnPreparePublish(context);
    }

    protected void OnPreparePublish(IMobilePublishContext context) throws Exception {
    }

    protected abstract String OnGetUniqueName(IMobilePublishContext var1) throws Exception;

    protected void OnUIPartCodeGenerate(IMobilePublishContext context, StringBuilderEx sb) throws Exception {
        Hashtable<String, String> properties = new Hashtable<String, String>();
        this.OnUIPartCodePrepareProperties(context, properties);
        Hashtable<String, Integer> functions = new Hashtable<String, Integer>();
        this.OnUIPartCodeRegisterFunctions(context, functions);
        sb.Append("%1$s.%2$s = Ext.extend(%3$s,{\r\n", (Object)DEFAULTNS, (Object)this.getUniqueName(), (Object)this.OnUIPartCodeGetExtendClass(context));
        boolean bFirst = true;
        if (properties.size() > 0) {
            for (String strKey : properties.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sb.Append(",");
                }
                sb.Append("%1$s:%2$s", (Object)strKey, (Object)properties.get(strKey));
            }
        }
        if (functions.size() > 0) {
            TreeMap<Integer, String> codeMap = new TreeMap<Integer, String>();
            for (String strKey : functions.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sb.Append(",");
                }
                int nParamCount = functions.get(strKey);
                sb.Append("%1$s:function(", (Object)strKey);
                int i = 0;
                while (i < nParamCount) {
                    if (i > 0) {
                        sb.Append(",");
                    }
                    sb.Append("_%1$s", (Object)(i + 1));
                    ++i;
                }
                sb.Append("){\r\n", (Object)strKey);
                codeMap.clear();
                this.OnUIPartCodePrepareFunction(context, strKey, codeMap, functions);
                for (Integer nKey : codeMap.keySet()) {
                    sb.Append("//code %1$s\r\n", (Object)nKey);
                    sb.Append(codeMap.get(nKey));
                }
                sb.Append("}\r\n");
            }
        }
        sb.Append("});\r\n");
        sb.Append("Ext.reg('%3$s',%1$s.%2$s);\r\n", (Object)DEFAULTNS, (Object)this.getUniqueName(), (Object)this.getUniqueName().toLowerCase());
    }

    protected void OnUIPartCodePrepareProperties(IMobilePublishContext context, Hashtable<String, String> properties) throws Exception {
    }

    protected void OnUIPartCodeRegisterFunctions(IMobilePublishContext context, Hashtable<String, Integer> functions) throws Exception {
        functions.put(JSFUNC_INITCOMPONENT, 0);
        for (JSObjectConfig jsObjCfg : this.jsObjectCfgMap.values()) {
            for (String strListen : jsObjCfg.listeners.keySet()) {
                functions.put(StringHelper.Format((String)"on%1$s_%2$s", (Object)jsObjCfg.getName(), (Object)strListen), jsObjCfg.listeners.get(strListen));
            }
        }
    }

    protected void OnUIPartCodePrepareFunction(IMobilePublishContext context, String strFunctionName, TreeMap<Integer, String> codeMap, Hashtable<String, Integer> functions) throws Exception {
        if (StringHelper.Compare((String)strFunctionName, (String)JSFUNC_INITCOMPONENT, (boolean)false) == 0) {
            BaseMobileUIPart.AppendCode(codeMap, 20, StringHelper.Format((String)"%1$s.%2$s.superclass.initComponent.apply(this, arguments);\r\n", (Object)DEFAULTNS, (Object)this.getUniqueName()));
            return;
        }
    }

    protected static void AppendCode(TreeMap<Integer, String> codeMap, Integer nPos, String strCode) {
        String strLastCode = codeMap.get(nPos);
        if (strLastCode != null) {
            strLastCode = String.valueOf(strLastCode) + "\r\n";
            strLastCode = String.valueOf(strLastCode) + strCode;
            codeMap.put(nPos, strLastCode);
        } else {
            codeMap.put(nPos, strCode);
        }
    }

    protected abstract String OnUIPartCodeGetExtendClass(IMobilePublishContext var1);

    public static String CalcUIPartUniqueId(String strUIPartType, String strDEId, String strUIPartId) {
        return StringHelper.Format((String)"%1$s;%2$s;%3$s", (Object)strUIPartType, (Object)strDEId, (Object)strUIPartId);
    }

    protected JSObjectConfig GetJSObjectCfg(String strObjectName) {
        if (this.jsObjectCfgMap.containsKey(strObjectName)) {
            return this.jsObjectCfgMap.get(strObjectName);
        }
        JSObjectConfig jsObjectCfg = new JSObjectConfig();
        jsObjectCfg.setName(strObjectName);
        this.jsObjectCfgMap.put(strObjectName, jsObjectCfg);
        return jsObjectCfg;
    }

    protected void OnJSObjListenersCodeGenerate(IMobilePublishContext context, JSObjectConfig jsObjConfig, StringBuilderEx sb) throws Exception {
        boolean bFirst = true;
        sb.Append("{\r\n");
        for (String strListener : jsObjConfig.getListeners().keySet()) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append(",");
            }
            sb.Append("%1$s:{fn:this.on%2$s_%1$s,scope:this}\r\n", (Object)strListener, (Object)jsObjConfig.getName());
        }
        sb.Append("}\r\n");
    }
}

