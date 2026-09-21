/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExFormSystemAction;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;
import java.io.Writer;
import java.util.Vector;

public class SRFExFormEnableAction
extends SRFExFormSystemAction {
    public SRFExFormEnableAction() {
        this.strActionName = "enable";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write(StringHelper.Format((String)"%1$s:function(_ID,_V){\r\n", (Object)this.getActionName()));
            this.OutputBeforeCode(writer);
            this.RenderRealCode(writer);
            this.OutputAfterCode(writer);
            writer.write("}");
            writer.write(StringHelper.Format((String)",isenable:function(_ID){return $V(%1$s._LE[_ID],false);}", (Object)this.getForm().getFormId()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void RenderRealCode(Writer writer) {
        try {
            writer.write("if(_V==undefined||_V==null)return;\r\n");
            writer.write(StringHelper.Format((String)"%1$s._LE[_ID]=_V;\r\n", (Object)this.getForm().getFormId()));
            writer.write("switch(_ID){\r\n");
            Vector<String> list1 = new Vector<String>();
            Vector<String> list2 = new Vector<String>();
            Vector<String> list3 = new Vector<String>();
            Vector<String> emptylist = new Vector<String>();
            Vector controls = this.getForm().getFormControls();
            int i = 0;
            while (i < controls.size()) {
                SRFExControl control = (SRFExControl)controls.get(i);
                if (control instanceof ISRFExFormItem) {
                    ISRFExFormItem formItem = (ISRFExFormItem)((Object)control);
                    String strEnableCall = formItem.getItemEnableStateJSCall();
                    if (StringHelper.Length((String)(strEnableCall = strEnableCall.trim())) > 0) {
                        if (StringHelper.Compare((String)"$FEI(_ID,_V);", (String)strEnableCall, (boolean)false) == 0) {
                            list1.add(control.getUniqueID());
                        } else if (StringHelper.Compare((String)"$FEI2(_ID,_V);", (String)strEnableCall, (boolean)false) == 0) {
                            list2.add(control.getUniqueID());
                        } else if (StringHelper.Compare((String)"$FEI3(_ID,_V);", (String)strEnableCall, (boolean)false) == 0) {
                            list3.add(control.getUniqueID());
                        } else {
                            writer.write(StringHelper.Format((String)"case '%1$s':%2$sbreak;\r\n", (Object)control.getUniqueID(), (Object)strEnableCall));
                        }
                    } else {
                        emptylist.add(control.getUniqueID());
                    }
                }
                ++i;
            }
            if (list2.size() > 0) {
                for (String strId : list2) {
                    writer.write(StringHelper.Format((String)"case '%1$s':", (Object)strId));
                }
                writer.write(StringHelper.Format((String)"$FEI2(_ID,_V);break;\r\n"));
            }
            if (list3.size() > 0) {
                for (String strId : list3) {
                    writer.write(StringHelper.Format((String)"case '%1$s':", (Object)strId));
                }
                writer.write(StringHelper.Format((String)"$FEI3(_ID,_V);break;\r\n"));
            }
            if (emptylist.size() > 0) {
                for (String strId : emptylist) {
                    writer.write(StringHelper.Format((String)"case '%1$s':", (Object)strId));
                }
                writer.write(StringHelper.Format((String)"break;\r\n"));
            }
            if (list1.size() > 0) {
                writer.write(StringHelper.Format((String)"default:$FEI(_ID,_V);break;"));
            }
            writer.write("}\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

