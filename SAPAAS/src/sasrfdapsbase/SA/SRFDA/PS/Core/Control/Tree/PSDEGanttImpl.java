/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDEGantt;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeGridExImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSControl", typevalues={"GANTT"})
public class PSDEGanttImpl
extends PSDETreeGridExImpl
implements IPSDEGantt {
    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u65f6\u95f4\u6570\u636e\u9879")
    public String getBeginDataItemName() {
        return "begin";
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u65f6\u95f4\u6570\u636e\u9879")
    public String getEndDataItemName() {
        return "end";
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u53f7\u6570\u636e\u9879")
    public String getSNDataItemName() {
        return "sn";
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7f6e\u6570\u636e\u9879")
    public String getPrevDataItemName() {
        return "prev";
    }

    @Override
    @PSModelRTMeta(description="\u603b\u91cf\u6570\u636e\u9879")
    public String getTotalDataItemName() {
        return "total";
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6210\u91cf\u6570\u636e\u9879")
    public String getFinishDataItemName() {
        return "finish";
    }

    @Override
    protected String onGetControlType() {
        return "GANTT";
    }

    @Override
    public String getModelType() {
        return "PSDEGANTT";
    }
}

