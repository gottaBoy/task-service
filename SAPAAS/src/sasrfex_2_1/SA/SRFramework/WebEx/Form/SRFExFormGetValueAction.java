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

public class SRFExFormGetValueAction
extends SRFExFormSystemAction {
    public SRFExFormGetValueAction() {
        this.strActionName = "getvalue";
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write(StringHelper.Format((String)"%1$s:function(_ID){\r\n", (Object)this.getActionName()));
            writer.write("var _V='';\r\n");
            this.OutputBeforeCode(writer);
            this.RenderRealCode(writer);
            this.OutputAfterCode(writer);
            writer.write("return _V;");
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void RenderRealCode(Writer writer) {
        try {
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
                    String strGetValueCall = formItem.getItemValueJSCall(true);
                    if (StringHelper.Length((String)(strGetValueCall = strGetValueCall.trim())) > 0) {
                        if (StringHelper.Compare((String)"_V=$FGV(_ID);", (String)strGetValueCall, (boolean)false) == 0) {
                            list1.add(control.getUniqueID());
                        } else if (StringHelper.Compare((String)"_V=$FGV2(_ID);", (String)strGetValueCall, (boolean)false) == 0) {
                            list2.add(control.getUniqueID());
                        } else if (StringHelper.Compare((String)"_V=$FGV3(_ID);", (String)strGetValueCall, (boolean)false) == 0) {
                            list3.add(control.getUniqueID());
                        } else {
                            writer.write(StringHelper.Format((String)"case '%1$s':%2$sbreak;\r\n", (Object)control.getUniqueID(), (Object)strGetValueCall));
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
                writer.write(StringHelper.Format((String)"_V=$FGV2(_ID);break;\r\n"));
            }
            if (list3.size() > 0) {
                for (String strId : list3) {
                    writer.write(StringHelper.Format((String)"case '%1$s':", (Object)strId));
                }
                writer.write(StringHelper.Format((String)"_V=$FGV3(_ID);break;\r\n"));
            }
            if (emptylist.size() > 0) {
                for (String strId : emptylist) {
                    writer.write(StringHelper.Format((String)"case '%1$s':", (Object)strId));
                }
                writer.write(StringHelper.Format((String)"break;\r\n"));
            }
            if (list1.size() > 0) {
                writer.write(StringHelper.Format((String)"default:_V=$FGV(_ID);break;"));
            }
            writer.write("}\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

