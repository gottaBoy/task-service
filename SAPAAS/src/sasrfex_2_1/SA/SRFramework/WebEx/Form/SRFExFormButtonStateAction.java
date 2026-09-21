/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormButtonState;
import SA.SRFramework.WebEx.Form.SRFExFormSystemAction;
import SA.SRFramework.WebEx.Script.ButtonJSHelper;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class SRFExFormButtonStateAction
extends SRFExFormSystemAction {
    protected ArrayList<SRFExFormButtonState> buttonStates = null;
    protected Hashtable<String, String> formHasKeyButtons = null;

    public SRFExFormButtonStateAction() {
        this.strActionName = "buttonstate";
    }

    public synchronized void RegisterFormHasKeyButton(String strButtonId) {
        if (this.formHasKeyButtons == null) {
            this.formHasKeyButtons = new Hashtable();
        }
        this.formHasKeyButtons.put(strButtonId, strButtonId);
    }

    public synchronized void UnregisterFormHasKeyButton(String strButtonId) {
        if (this.formHasKeyButtons != null) {
            this.formHasKeyButtons.remove(strButtonId);
            if (this.formHasKeyButtons.size() == 0) {
                this.formHasKeyButtons = null;
            }
        }
    }

    public synchronized void RegisterButtonState(String strButtonId, String strState, boolean bDefault) {
        if (this.buttonStates == null) {
            this.buttonStates = new ArrayList();
        }
        SRFExFormButtonState bs = new SRFExFormButtonState(strButtonId, strState, bDefault);
        this.buttonStates.add(bs);
    }

    public synchronized void UnregisterButtonState(String strButtonId) {
        if (this.buttonStates != null) {
            int nCount = this.buttonStates.size();
            int i = 0;
            while (i < nCount) {
                SRFExFormButtonState bs = this.buttonStates.get(i);
                if (StringHelper.Compare((String)bs.getButtonId(), (String)strButtonId, (boolean)true) == 0) {
                    this.buttonStates.remove(bs);
                    break;
                }
                ++i;
            }
            if (this.buttonStates.size() == 0) {
                this.buttonStates = null;
            }
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            SRFExFormButtonState bs;
            SRFExFormButtonState bs2;
            ArrayList<SRFExFormButtonState> tempbs = new ArrayList<SRFExFormButtonState>();
            if (this.buttonStates != null) {
                if (this.formHasKeyButtons != null) {
                    Hashtable<String, String> tempHasKeyButtons = new Hashtable<String, String>();
                    int nCount = this.buttonStates.size();
                    int i = 0;
                    while (i < nCount) {
                        bs2 = this.buttonStates.get(i);
                        if (this.formHasKeyButtons.containsKey(bs2.getButtonId())) {
                            tempHasKeyButtons.put(bs2.getButtonId(), "");
                            bs2.setFormHasKey(true);
                        } else {
                            bs2.setFormHasKey(false);
                        }
                        tempbs.add(bs2);
                        ++i;
                    }
                    Enumeration<String> en = this.formHasKeyButtons.keys();
                    while (en.hasMoreElements()) {
                        String strButtonId = en.nextElement();
                        if (tempHasKeyButtons.containsKey(strButtonId)) continue;
                        SRFExFormButtonState bs3 = new SRFExFormButtonState(strButtonId, "", true);
                        bs3.setFormHasKey(true);
                        tempbs.add(bs3);
                    }
                } else {
                    int nCount = this.buttonStates.size();
                    int i = 0;
                    while (i < nCount) {
                        bs = this.buttonStates.get(i);
                        bs.setFormHasKey(false);
                        tempbs.add(bs);
                        ++i;
                    }
                }
            } else if (this.formHasKeyButtons != null) {
                Enumeration<String> en = this.formHasKeyButtons.keys();
                while (en.hasMoreElements()) {
                    String strButtonId = en.nextElement();
                    bs = new SRFExFormButtonState(strButtonId, "", true);
                    bs.setFormHasKey(true);
                    tempbs.add(bs);
                }
            }
            SRFExForm form = (SRFExForm)this.getForm();
            writer.write(StringHelper.Format((String)"%1$s:function(_JO){", (Object)this.getActionName()));
            this.OutputBeforeCode(writer);
            writer.write(StringHelper.Format((String)"var _fm=%1$s;\r\n", (Object)form.getFormId()));
            writer.write(StringHelper.Format((String)"var _2=_fm.haskeys();"));
            writer.write("var _FS={};");
            writer.write("if(_JO&&_JO.formstate)");
            writer.write("_FS = _JO.formstate;\r\n");
            int nCount = tempbs.size();
            int i = 0;
            while (i < nCount) {
                bs2 = (SRFExFormButtonState)tempbs.get(i);
                if (StringHelper.Length((String)bs2.getButtonStateId()) == 0) {
                    writer.write(StringHelper.Format((String)"if(_2){%1$s}else{%2$s}\r\n", (Object)ButtonJSHelper.getSafeEnableScript(bs2.getButtonId()), (Object)ButtonJSHelper.getSafeDisableScript(bs2.getButtonId())));
                } else if (bs2.isDefault()) {
                    if (bs2.isFormHasKey()) {
                        writer.write(StringHelper.Format((String)"if(_2){%1$s}else{%2$s}\r\n", (Object)ButtonJSHelper.getSafeEnableScript(bs2.getButtonId()), (Object)ButtonJSHelper.getSafeDisableScript(bs2.getButtonId())));
                        writer.write(StringHelper.Format((String)"if(_2&&$V(_FS.%1$s,true)){%2$s}else{%3$s}\r\n", (Object)bs2.getButtonStateId(), (Object)ButtonJSHelper.getSafeEnableScript(bs2.getButtonId()), (Object)ButtonJSHelper.getSafeDisableScript(bs2.getButtonId())));
                    } else {
                        writer.write(StringHelper.Format((String)"%1$s\r\n", (Object)ButtonJSHelper.getSafeEnableScript(bs2.getButtonId())));
                        writer.write(StringHelper.Format((String)"if($V(_FS.%1$s,true)){%2$s}else{%3$s}\r\n", (Object)bs2.getButtonStateId(), (Object)ButtonJSHelper.getSafeEnableScript(bs2.getButtonId()), (Object)ButtonJSHelper.getSafeDisableScript(bs2.getButtonId())));
                    }
                } else {
                    writer.write(StringHelper.Format((String)"%1$s\r\n", (Object)ButtonJSHelper.getSafeDisableScript(bs2.getButtonId())));
                    if (bs2.isFormHasKey()) {
                        writer.write(StringHelper.Format((String)"if(_2 && $V(_FS.%1$s,false)){%2$s}else{%3$s}\r\n", (Object)bs2.getButtonStateId(), (Object)ButtonJSHelper.getSafeEnableScript(bs2.getButtonId()), (Object)ButtonJSHelper.getSafeDisableScript(bs2.getButtonId())));
                    } else {
                        writer.write(StringHelper.Format((String)"if($V(_FS.%1$s,false)){%2$s}else{%3$s}\r\n", (Object)bs2.getButtonStateId(), (Object)ButtonJSHelper.getSafeEnableScript(bs2.getButtonId()), (Object)ButtonJSHelper.getSafeDisableScript(bs2.getButtonId())));
                    }
                }
                ++i;
            }
            this.OutputAfterCode(writer);
            writer.write("}");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

