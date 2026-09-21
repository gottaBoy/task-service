/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSFIDEFValueRule;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;
import net.sf.json.JSONObject;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u9884\u5b9a\u4e49\u8868\u5355\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEFFormItemImpl", model="PSDEFUIMode")
public interface IPSDEFFormItem
extends IPSDEFUIItem {
    public int getEditorWidth();

    public int getEditorHeight();

    public String getValueItemName(IPSDEFormItem var1);

    public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules();

    public String getItemHandlerType(IPSDEFormItem var1);

    public int getEnableCond();

    public JSONObject getItemParam(IPSDEFormItem var1) throws Exception;

    public boolean getAllowEmpty(IPSDEFormItem var1);
}

