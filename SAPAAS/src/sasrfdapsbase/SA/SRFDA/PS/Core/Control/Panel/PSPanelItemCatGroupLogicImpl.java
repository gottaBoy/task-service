/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemCatGroupLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemGroupLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemLogic;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItemSingleLogic;
import SA.SRFDA.PS.Core.Control.Panel.PSPanelItemGroupLogicImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSPanelItemCatGroupLogicImpl
extends PSPanelItemGroupLogicImpl
implements IPSPanelItemCatGroupLogic {
    private Map<String, String> relatedItemNameMap = null;

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u7c7b\u522b", codelist="FDLogicCat", fields={"LOGICCAT"})
    public String getLogicCat() {
        return this.psPanelItemLogic.getLOGICCAT();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.fillRelatedItemNames(this);
    }

    @Override
    @PSModelRTMeta(description="\u5173\u8054\u6210\u5458\u540d\u79f0\u96c6\u5408", child=true)
    public Iterator<String> getRelatedItemNames() {
        if (this.relatedItemNameMap == null || this.relatedItemNameMap.size() == 0) {
            return null;
        }
        return this.relatedItemNameMap.keySet().iterator();
    }

    protected void fillRelatedItemNames(IPSPanelItemLogic iPSPanelItemLogic) throws Exception {
        IPSPanelItemGroupLogic iPSDEFDGroupLogic;
        Iterator<IPSPanelItemLogic> psDEFDLogics;
        String strItemName;
        if (iPSPanelItemLogic instanceof IPSPanelItemSingleLogic && !StringHelper.isNullOrEmpty((String)(strItemName = ((IPSPanelItemSingleLogic)iPSPanelItemLogic).getDstModelField()))) {
            if (this.relatedItemNameMap == null) {
                this.relatedItemNameMap = new LinkedHashMap<String, String>();
            }
            this.relatedItemNameMap.put(strItemName.toLowerCase(), "");
        }
        if (iPSPanelItemLogic instanceof IPSPanelItemGroupLogic && (psDEFDLogics = (iPSDEFDGroupLogic = (IPSPanelItemGroupLogic)iPSPanelItemLogic).getPSPanelItemLogics()) != null) {
            while (psDEFDLogics.hasNext()) {
                this.fillRelatedItemNames(psDEFDLogics.next());
            }
        }
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        objectNode.remove("name");
    }
}

