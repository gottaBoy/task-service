/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Button;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Button.SRFExAjaxButton;
import SA.SRFramework.WebEx.Button.SRFExButtonAjaxResultAction;
import java.io.IOException;
import java.io.Writer;
import java.util.Hashtable;
import java.util.Vector;

public class SRFExButtonAjaxSuccessAction
extends SRFExButtonAjaxResultAction {
    private Vector rets = new Vector();
    private Hashtable processCodes = new Hashtable();

    public SRFExButtonAjaxSuccessAction() {
        this.RegisterRetCode(0);
        this.RegisterRetCode(1);
        this.RegisterRetCode(2);
        this.RegisterRetCode(3);
        this.RegisterRetCode(4);
        this.RegisterRetCode(5);
        this.RegisterRetCode(6);
    }

    protected void RegisterRetCode(int nRetCode) {
        if (this.rets.contains(nRetCode)) {
            return;
        }
        this.rets.add(nRetCode);
    }

    public void RegisterProcessCode(int nRetCode, String strCode) {
        this.RegisterRetCode(nRetCode);
        String strLastCode = "";
        if (this.processCodes.containsKey(nRetCode)) {
            strLastCode = (String)this.processCodes.get(nRetCode);
        }
        strLastCode = String.valueOf(strLastCode) + strCode;
        this.processCodes.put(nRetCode, strLastCode);
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExAjaxButton ajaxButton = this.getAjaxButton();
            writer.write(StringHelper.Format((String)"%1$s:function(_RO){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"this.%1$sfinish();\r\n", (Object)ajaxButton.getRequestAction().getActionName()));
            writer.write("var _RT = _RO.responseText;\r\n");
            writer.write("if(_RT != undefined &&_RT != null && _RT != ''){\r\n");
            writer.write("var _JO = eval(\"(\"+_RT+\")\");\r\n");
            writer.write("if(_JO == undefined ||_JO == null || _JO.ret == undefined){\r\n");
            writer.write(StringHelper.Format((String)"this.%1$s(_RO);\r\n", (Object)ajaxButton.getAjaxFailedAction().getActionName()));
            writer.write("}");
            writer.write("else{\r\n");
            writer.write("if(_RO.argument && _RO.argument.cb)\r\n");
            writer.write("_RO.argument.cb(_RO,true,_JO);\r\n");
            writer.write("switch(_JO.ret){");
            int i = 0;
            while (i < this.rets.size()) {
                writer.write(StringHelper.Format((String)"case %1$s:{", this.rets.get(i)));
                this.OnRenderProcessOnRet((Integer)this.rets.get(i), writer);
                if (this.processCodes.containsKey(i)) {
                    writer.write(this.processCodes.get(i).toString());
                }
                writer.write(StringHelper.Format((String)"}break;"));
                ++i;
            }
            writer.write(StringHelper.Format((String)"default:"));
            writer.write(StringHelper.Format((String)"alert('\u672a\u77e5\u7684\u5904\u7406\u8fd4\u56de\u503c['+_JO.ret+']\uff0c\u8bf7\u5411\u7ba1\u7406\u5458\u8054\u7cfb\u786e\u8ba4\uff01');"));
            writer.write(StringHelper.Format((String)"break;"));
            writer.write("}\r\n");
            writer.write("$ARP(_JO);\r\n");
            writer.write("}\r\n");
            writer.write("}\r\n");
            writer.write("else{");
            writer.write("alert('empty');");
            writer.write(StringHelper.Format((String)"this.%1$s(_RO);\r\n", (Object)ajaxButton.getAjaxFailedAction().getActionName()));
            writer.write("}\r\n");
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void OnRenderProcessOnRet(int nRetCode, Writer writer) throws IOException {
        switch (nRetCode) {
            case 0: {
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                if (this.processCodes.containsKey(nRetCode)) break;
                writer.write(StringHelper.Format((String)"alert($P.msg.fmt($P.msg['%1$s'],_JO.info));", (Object)nRetCode));
                break;
            }
            default: {
                if (this.processCodes.containsKey(nRetCode)) break;
                writer.write(StringHelper.Format((String)"alert($P.msg.fmt2(_JO.ret));"));
            }
        }
    }
}

