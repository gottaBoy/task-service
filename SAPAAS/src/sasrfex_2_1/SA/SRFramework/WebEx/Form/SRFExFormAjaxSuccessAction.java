/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxResultAction;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Hashtable;
import java.util.Vector;

public class SRFExFormAjaxSuccessAction
extends SRFExFormAjaxResultAction {
    private Vector rets = new Vector();
    private Hashtable processCodes = new Hashtable();
    protected boolean bDefaultProcess = false;

    public void setActionName(String strActionName) {
        this.strActionName = strActionName;
    }

    public SRFExFormAjaxSuccessAction() {
        this.RegisterRetCode(0);
        this.RegisterRetCode(1);
        this.RegisterRetCode(2);
        this.RegisterRetCode(3);
        this.RegisterRetCode(4);
        this.RegisterRetCode(5);
        this.RegisterRetCode(6);
        this.RegisterRetCode(1000);
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
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_RO){\r\n", (Object)this.getActionName()));
            writer.write(StringHelper.Format((String)"var _F=%1$s;\r\n", (Object)form.getFormId()));
            this.OutputBeforeCode(writer);
            if (form.getRequestAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"%1$s.%2$sfinish();\r\n", (Object)form.getFormId(), (Object)form.getRequestAction().getActionName()));
            }
            writer.write("var _JO=SRFUtility.parseresponse(_RO);\r\n");
            writer.write("if((!_JO)||_JO.ret==undefined){");
            if (form.getAjaxFailedAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"%1$s.%2$s(_RO);", (Object)form.getFormId(), (Object)form.getAjaxFailedAction().getActionName()));
            } else {
                writer.write(";");
            }
            writer.write("}else{");
            writer.write("$URC(_RO,true,_JO);");
            writer.write("$ARPB(_JO);\r\n");
            writer.write("var _DATAURL=_JO.dataurl;\r\n");
            writer.write("switch(_JO.ret){");
            StringWriter sw = new StringWriter();
            int i = 0;
            while (i < this.rets.size()) {
                this.bDefaultProcess = false;
                this.OnRenderProcessOnRet((Integer)this.rets.get(i), sw);
                if (!this.bDefaultProcess) {
                    writer.write(StringHelper.Format((String)"case %1$s:{", this.rets.get(i)));
                    this.OnRenderProcessOnRet((Integer)this.rets.get(i), writer);
                    if (this.processCodes.containsKey((Integer)this.rets.get(i))) {
                        writer.write(this.processCodes.get((Integer)this.rets.get(i)).toString());
                    }
                    writer.write(StringHelper.Format((String)"}break;"));
                }
                ++i;
            }
            writer.write(StringHelper.Format((String)"default:"));
            writer.write(StringHelper.Format((String)"SRFForm.showAjaxError(_JO);"));
            writer.write(StringHelper.Format((String)"break;"));
            writer.write("}\r\n");
            if (form.getButtonStateAction().getEnabled()) {
                writer.write(StringHelper.Format((String)"%1$s.%2$s(_JO);", (Object)form.getFormId(), (Object)form.getButtonStateAction().getActionName()));
            }
            writer.write("$ARP(_JO);");
            writer.write("if(_DATAURL!=undefined&&_DATAURL!=''){window.location.href=_DATAURL;}");
            writer.write("}");
            this.OutputAfterCode(writer);
            writer.write("}\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void OnRenderProcessOnRet(int nRetCode, Writer writer) throws IOException {
        SRFExForm form = (SRFExForm)this.getForm();
        switch (nRetCode) {
            case 0: {
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 6: {
                if (this.processCodes.containsKey(nRetCode)) break;
                this.bDefaultProcess = true;
                writer.write(StringHelper.Format((String)"alert($P.msg.fmt($P.msg['%1$s'],_JO.info));", (Object)nRetCode));
                if (nRetCode != 10) break;
                writer.write(StringHelper.Format((String)"if(confirm($P.msg['form_reloadmsg'])){%1$s.load();}", (Object)form.getFormId()));
                break;
            }
            case 10: {
                if (this.processCodes.containsKey(nRetCode)) break;
                this.bDefaultProcess = false;
                writer.write(StringHelper.Format((String)"alert($P.msg.fmt($P.msg['%1$s'],_JO.info));", (Object)nRetCode));
                writer.write(StringHelper.Format((String)"if(confirm($P.msg['form_reloadmsg'])){%1$s.load();}", (Object)form.getFormId()));
                break;
            }
            case 5: {
                if (this.processCodes.containsKey(nRetCode)) break;
                this.bDefaultProcess = false;
                if (form.getShowErrorAction().getEnabled()) {
                    writer.write(StringHelper.Format((String)"%1$s.%2$s(_JO);\r\n", (Object)form.getFormId(), (Object)form.getShowErrorAction().getActionName()));
                }
                writer.write(StringHelper.Format((String)"alert($P.msg.fmt($P.msg['%1$s'],_JO.info));", (Object)nRetCode));
                break;
            }
            case 1000: {
                if (this.processCodes.containsKey(nRetCode)) break;
                this.bDefaultProcess = true;
                writer.write(StringHelper.Format((String)"alert('\u7cfb\u7edf\u5904\u7406\u5931\u8d25\uff0c\u539f\u56e0\u662f\uff1a'+_JO.info);"));
                break;
            }
            default: {
                if (this.processCodes.containsKey(nRetCode)) break;
                writer.write(StringHelper.Format((String)"alert($P.msg.fmt2(_JO.ret));"));
            }
        }
    }
}

