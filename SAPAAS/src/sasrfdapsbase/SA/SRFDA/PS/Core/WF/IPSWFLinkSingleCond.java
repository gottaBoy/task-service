/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFLinkSingleCondModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCond;
import net.ibizsys.pswf.core.IWFLinkSingleCondModel;

@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u5904\u7406\u8fde\u63a5\u5355\u9879\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SINGLE"})
@PSModelPFIgnoreMeta
public interface IPSWFLinkSingleCond
extends IPSWFLinkCond,
IWFLinkSingleCondModel {
    public static final String PARAMTYPE_ENTITYFIELD = "ENTITYFIELD";
    public static final String PARAMTYPE_CURTIME = "CURTIME";
    public static final String PARAMTYPE_TIMERULE = "TIMERULE";

    public String getFieldName() throws Exception;

    public String getPSDBValueOPId();

    public String getParamType();

    public String getParamValue();

    public String getCondOP();
}

