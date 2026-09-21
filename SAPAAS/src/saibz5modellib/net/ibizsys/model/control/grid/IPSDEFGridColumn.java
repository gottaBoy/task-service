/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model.control.grid;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.control.grid.IPSDEGridFieldColumn;
import net.ibizsys.model.control.grid.IPSGEIDEFValueRule;
import net.ibizsys.model.dataentity.field.IPSDEFUIItem;

public interface IPSDEFGridColumn
extends IPSDEFUIItem {
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems();

    @Override
    public String getDataItemName();

    public int getColumnWidth();

    @Override
    public String getCaption(String var1);

    public boolean isEnableSort();

    public String getColumnAlign();

    public Iterator<IPSGEIDEFValueRule> getPSGEIDEFValueRules();

    public String getItemHandlerType(IPSDEGridEditItem var1);

    public int getEnableCond();

    public ObjectNode getItemParam(IPSDEGridEditItem var1) throws Exception;

    public ArrayList<IPSDEGridDataItem> getPSDEGridDataItems(IPSDEGridFieldColumn var1) throws Exception;

    public String getDataItemName(IPSDEGridFieldColumn var1) throws Exception;

    public String getCLConvertMode();
}

