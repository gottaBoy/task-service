/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEKanban;
import SA.SRFDA.PS.Core.Control.DataView.PSDEDataViewImpl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"KANBAN"})
public class PSDEKanbanImpl
extends PSDEDataViewImpl
implements IPSDEKanban {
    private static final Log log = LogFactory.getLog(PSDEKanbanImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onGetControlType() {
        return "KANBAN";
    }

    @Override
    public String getModelType() {
        return "PSDEKANBAN";
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u5206\u7ec4\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getUpdateGroupPSControlAction() {
        block4: {
            try {
                if (!this.isReadOnly()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.getPSAjaxControlHandler() != null) {
            try {
               return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("updategroup", true);
            }
            catch (Exception exAjaxAction) {
               log.error((Object)exAjaxAction);
               return null;
            }
        }
        return null;
    }
}

