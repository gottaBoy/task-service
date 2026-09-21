/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.view.IPSUIAction
 *  net.ibizsys.model.view.IPSUIActionGroup
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSUIActionGroup;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSUIActionImpl
extends PSObjectImpl
implements IPSUIAction {
    public void fillUIActionItem(Object objUIActionItem) throws Exception {
        if (objUIActionItem instanceof PSDEToolbarItem) {
            this.onFillPSDEToolbarItem((PSDEToolbarItem)((Object)objUIActionItem));
            return;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u586b\u5145\u754c\u9762\u64cd\u4f5c\u9879\uff0c\u7c7b\u578b\u4e3a[%1$s]", (Object)objUIActionItem.getClass().getCanonicalName()));
    }

    protected void onFillPSDEToolbarItem(PSDEToolbarItem psDEToolbarItem) throws Exception {
    }

    public IPSUIActionGroup getPSUIActionGroup(Object obj) throws Exception {
        return null;
    }

    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"type", (Object)this.getUIActionType());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"mode", (Object)this.getUIActionMode());
        JsonNodeHelper.put((ObjectNode)objectNode, (String)"tag", (Object)this.getUIActionFullTag());
    }
}

