/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridFieldColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSGEIDEFValueRule;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeDataItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeFieldColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.json.JSONObject;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u8868\u683c\u5217\u914d\u7f6e\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEFUIMode")
public interface IPSDEFGridColumn
extends IPSDEFUIItem {
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems();

    @Override
    public String getDataItemName();

    public int getColumnWidth();

    @Override
    public String getCaption(String var1);

    public boolean isEnableSort();

    public IPSSysPFPlugin getRenderPSSysPFPlugin();

    public String getColumnAlign();

    public String getValueItemName(IPSDEGridEditItem var1);

    public String getLinkValueItem(IPSDEGridEditItem var1);

    public boolean getAllowEmpty(IPSDEGridEditItem var1);

    public String getValueItemName(IPSDETreeNodeEditItem var1);

    public String getLinkValueItem(IPSDETreeNodeEditItem var1);

    public boolean getAllowEmpty(IPSDETreeNodeEditItem var1);

    public Iterator<IPSGEIDEFValueRule> getPSGEIDEFValueRules();

    public String getItemHandlerType(IPSDEGridEditItem var1);

    public int getEnableCond();

    public JSONObject getItemParam(IPSDEGridEditItem var1) throws Exception;

    public ArrayList<IPSDEGridDataItem> getPSDEGridDataItems(IPSDEGridFieldColumn var1) throws Exception;

    public String getDataItemName(IPSDEGridFieldColumn var1) throws Exception;

    public String getCLConvertMode();

    public ArrayList<IPSDEGridDataItem> getPSDEGridDataItemsByEditItem(IPSDEGridEditItem var1) throws Exception;

    public ArrayList<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems(IPSDETreeNodeFieldColumn var1) throws Exception;

    public ArrayList<IPSDETreeNodeDataItem> getPSDETreeNodeDataItemsByEditItem(IPSDETreeNodeEditItem var1) throws Exception;

    public String getItemHandlerType(IPSDETreeNodeEditItem var1);

    public JSONObject getItemParam(IPSDETreeNodeEditItem var1) throws Exception;

    public String getDataItemName(IPSDETreeNodeFieldColumn var1) throws Exception;
}

