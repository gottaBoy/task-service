/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFDCatGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDGroupLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic;
import SA.SRFDA.PS.Core.Control.Form.PSDEFDGroupLogicImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFDCatGroupLogicImpl
extends PSDEFDGroupLogicImpl
implements IPSDEFDCatGroupLogic {
    private Map<String, String> relatedDetailNameMap = null;

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u7c7b\u522b", codelist="FDLogicCat", fields={"LOGICCAT"})
    public String getLogicCat() {
        return this.psDEFDLogic.getLOGICCAT();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.fillRelatedDetailNames(this);
    }

    @Override
    @PSModelRTMeta(description="\u5173\u8054\u6210\u5458\u540d\u79f0\u96c6\u5408", child=true)
    public Iterator<String> getRelatedDetailNames() {
        if (this.relatedDetailNameMap == null || this.relatedDetailNameMap.size() == 0) {
            return null;
        }
        return this.relatedDetailNameMap.keySet().iterator();
    }

    protected void fillRelatedDetailNames(IPSDEFDLogic iPSDEFDLogic) throws Exception {
        IPSDEFDGroupLogic iPSDEFDGroupLogic;
        Iterator<IPSDEFDLogic> psDEFDLogics;
        String strDetailName;
        if (iPSDEFDLogic instanceof IPSDEFDSingleLogic && !StringHelper.isNullOrEmpty((String)(strDetailName = ((IPSDEFDSingleLogic)iPSDEFDLogic).getDEFDName()))) {
            if (this.relatedDetailNameMap == null) {
                this.relatedDetailNameMap = new LinkedHashMap<String, String>();
            }
            this.relatedDetailNameMap.put(strDetailName.toLowerCase(), "");
        }
        if (iPSDEFDLogic instanceof IPSDEFDGroupLogic && (psDEFDLogics = (iPSDEFDGroupLogic = (IPSDEFDGroupLogic)iPSDEFDLogic).getPSDEFDLogics()) != null) {
            while (psDEFDLogics.hasNext()) {
                this.fillRelatedDetailNames(psDEFDLogics.next());
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", fields={"CONDVALUE"})
    public String getScriptCode() {
        if (StringHelper.isNullOrEmpty((String)this.getLogicCat())) {
            return "";
        }
        if (this.getLogicCat().indexOf("SCRIPTCODE_") == 0) {
            return this.psDEFDLogic.getCONDVALUE();
        }
        return "";
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        objectNode.remove("name");
    }
}

