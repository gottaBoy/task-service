/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSFIDEFValueRule;
import net.ibizsys.model.dataentity.field.IPSDEFUIItem;

public interface IPSDEFFormItem
extends IPSDEFUIItem {
    public int getEditorWidth();

    public int getEditorHeight();

    public String getValueItemName(IPSDEFormItem var1);

    public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules();

    public String getItemHandlerType(IPSDEFormItem var1);

    public int getEnableCond();

    public ObjectNode getItemParam(IPSDEFormItem var1) throws Exception;
}

