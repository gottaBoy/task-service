/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Mobile.Panel;

import SA.SRFDA.Mobile.Panel.BaseMainPanel;
import SA.SRFDA.Mobile.UIPart.IMobilePublishContext;
import SA.SRFDA.Mobile.UIPart.IMobileUIPart;
import SA.SRFDA.Mobile.UIPart.JSObjectConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;
import java.util.TreeMap;

public abstract class BaseListPanel
extends BaseMainPanel {
    public static final String JSFUNC_CREATEMAINLISTSTORE = "createMainListStore";
    protected String strMBFullListId = "";
    public static final String JSMAINLIST = "MainList";
    public static final String JSMAINLISTSTORE = "MainListStore";

    protected abstract String OnGetMBListId() throws Exception;

    @Override
    protected void OnCalcRelatedParts() throws Exception {
        super.OnCalcRelatedParts();
        this.strMBFullListId = this.OnGetMBListId();
        this.relatedParts.add(this.strMBFullListId);
    }

    @Override
    protected void OnUIPartCodeRegisterFunctions(IMobilePublishContext context, Hashtable<String, Integer> functions) throws Exception {
        super.OnUIPartCodeRegisterFunctions(context, functions);
        functions.put("createMainItem", 0);
        functions.put(JSFUNC_CREATEMAINLISTSTORE, 0);
    }

    @Override
    protected void OnUIPartCodePrepareFunction(IMobilePublishContext context, String strFunctionName, TreeMap<Integer, String> codeMap, Hashtable<String, Integer> functions) throws Exception {
        super.OnUIPartCodePrepareFunction(context, strFunctionName, codeMap, functions);
        if (StringHelper.Compare((String)strFunctionName, (String)"createMainItem", (boolean)false) == 0) {
            StringBuilderEx sb = new StringBuilderEx();
            this.OnCreateMainItemCodeGenerate(context, functions, sb);
            BaseListPanel.AppendCode(codeMap, 10, sb.toString());
            return;
        }
        if (StringHelper.Compare((String)strFunctionName, (String)JSFUNC_CREATEMAINLISTSTORE, (boolean)false) == 0) {
            StringBuilderEx sb = new StringBuilderEx();
            this.OnCreateMainListStoreCodeGenerate(context, functions, sb);
            BaseListPanel.AppendCode(codeMap, 10, sb.toString());
            return;
        }
    }

    protected void OnCreateMainItemCodeGenerate(IMobilePublishContext context, Hashtable<String, Integer> functions, StringBuilderEx sb) throws Exception {
        IMobileUIPart listUIPart = context.FindUIPart(this.strMBFullListId);
        if (listUIPart == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u754c\u9762\u90e8\u4ef6[%1$s]", (Object)this.strMBFullListId));
        }
        boolean bFirst = true;
        JSObjectConfig mainListConfig = this.GetJSObjectCfg(JSMAINLIST);
        mainListConfig.getProperties().remove("store");
        sb.Append("this.mainList=new %1$s.%2$s({\r\n", (Object)"sasrfmb", (Object)listUIPart.getUniqueName());
        for (String strProperty : mainListConfig.getProperties().keySet()) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append(",");
            }
            sb.Append("%1$s:%2$s\r\n", (Object)strProperty, (Object)mainListConfig.getProperties().get(strProperty));
        }
        if (bFirst) {
            bFirst = false;
        } else {
            sb.Append(",");
        }
        sb.Append("store:this.%1$s()\r\n", (Object)JSFUNC_CREATEMAINLISTSTORE);
        if (mainListConfig.getListeners().size() > 0) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append(",");
            }
            sb.Append("listeners:");
            this.OnJSObjListenersCodeGenerate(context, mainListConfig, sb);
        }
        sb.Append("});\r\n");
        sb.Append("return this.mainList;\r\n");
    }

    protected void OnCreateMainListStoreCodeGenerate(IMobilePublishContext context, Hashtable<String, Integer> functions, StringBuilderEx sb) throws Exception {
        JSObjectConfig mainListStoreConfig = this.GetJSObjectCfg(JSMAINLISTSTORE);
        IMobileUIPart listUIPart = context.FindUIPart(this.strMBFullListId);
        if (listUIPart == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u754c\u9762\u90e8\u4ef6[%1$s]", (Object)this.strMBFullListId));
        }
        boolean bFirst = true;
        mainListStoreConfig.getProperties().put("model", StringHelper.Format((String)"'%1$sModel'", (Object)listUIPart.getUniqueName()));
        sb.Append("this.mainListStore=new Ext.data.Store({\r\n", (Object)"sasrfmb", (Object)listUIPart.getUniqueName());
        for (String strProperty : mainListStoreConfig.getProperties().keySet()) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append(",");
            }
            sb.Append("%1$s:%2$s\r\n", (Object)strProperty, (Object)mainListStoreConfig.getProperties().get(strProperty));
        }
        if (mainListStoreConfig.getListeners().size() > 0) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append(",");
            }
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append(",");
            }
            sb.Append("listeners:");
            this.OnJSObjListenersCodeGenerate(context, mainListStoreConfig, sb);
        }
        sb.Append("});\r\n");
        sb.Append("return this.mainListStore;\r\n");
    }

    @Override
    protected void OnPreparePublish(IMobilePublishContext context) throws Exception {
        super.OnPreparePublish(context);
        JSObjectConfig mainListConfig = this.GetJSObjectCfg(JSMAINLIST);
        mainListConfig.getListeners().put("selectionchange", 2);
        JSObjectConfig mainListStoreConfig = this.GetJSObjectCfg(JSMAINLISTSTORE);
        mainListStoreConfig.getProperties().put("remoteFilter", "true");
        mainListStoreConfig.getProperties().put("remoteSort", "true");
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("{\r\n");
        sb.Append("type:'ajax'\r\n");
        sb.Append(",url:'%1$s'\r\n", (Object)this.OnGetMainListStoreUrl(context));
        sb.Append(",reader:{type:'json',root:'items'}\r\n");
        sb.Append("}\r\n");
        mainListStoreConfig.getProperties().put("proxy", sb.toString());
    }

    protected abstract String OnGetMainListStoreUrl(IMobilePublishContext var1) throws Exception;
}

