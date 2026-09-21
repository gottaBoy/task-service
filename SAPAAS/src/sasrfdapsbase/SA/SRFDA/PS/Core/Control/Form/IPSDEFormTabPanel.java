/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u5355\u5206\u9875\u90e8\u4ef6\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"TABPANEL"})
public interface IPSDEFormTabPanel
extends IPSDEFormDetail {
    public Iterator<IPSDEFormTabPage> getPSDEFormTabPages();

    public String getDataRelationTag();

    public IPSDEDataRelation getPSDEDataRelation();

    public int getInsertPos();
}

