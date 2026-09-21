/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Mobile.Panel;

import SA.SRFDA.Mobile.Panel.BaseMobilePanel;
import SA.SRFDA.Mobile.UIPart.IMobilePublishContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;

public abstract class BaseMainPanel
extends BaseMobilePanel {
    public static final String JSFUNC_CREATEMAINITEM = "createMainItem";
    public static final String JSFUNC_CREATEMAINITEM2 = "createMainItem2";

    @Override
    protected void OnUIPartCodePrepareFunction(IMobilePublishContext context, String strFunctionName, TreeMap<Integer, String> codeMap, Hashtable<String, Integer> functions) throws Exception {
        super.OnUIPartCodePrepareFunction(context, strFunctionName, codeMap, functions);
        if (StringHelper.Compare((String)strFunctionName, (String)"initComponent", (boolean)false) == 0) {
            StringBuilderEx sb = new StringBuilderEx();
            this.OnPanelItemsCodeGenerate(context, functions, sb);
            BaseMainPanel.AppendCode(codeMap, 10, sb.toString());
            return;
        }
    }

    protected void OnPanelItemsCodeGenerate(IMobilePublishContext context, Hashtable<String, Integer> functions, StringBuilderEx sb) throws Exception {
        Vector<String> mainItems = new Vector<String>();
        if (functions.containsKey(JSFUNC_CREATEMAINITEM)) {
            sb.Append("this.mainItem=this.%1$s();\r\n", (Object)JSFUNC_CREATEMAINITEM);
            mainItems.add("this.mainItem");
        }
        if (functions.containsKey(JSFUNC_CREATEMAINITEM2)) {
            sb.Append("this.mainItem2=this.%1$s();\r\n", (Object)JSFUNC_CREATEMAINITEM2);
            mainItems.add("this.mainItem2");
        }
        if (mainItems.size() > 0) {
            if (mainItems.size() == 1) {
                sb.Append("this.items=%1$s;\r\n", mainItems.get(0));
            } else {
                sb.Append("this.items=[");
                boolean bFirst = true;
                for (String strItem : mainItems) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        sb.Append(",");
                    }
                    sb.Append(strItem);
                }
                sb.Append("];\r\n");
            }
        }
    }
}

