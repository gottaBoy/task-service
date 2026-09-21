/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodInput;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u884c\u4e3a\u8f93\u5165\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="\u5b9e\u4f53\u884c\u4e3a\u8f93\u5165\u6a21\u578b\u662f\u5b9e\u4f53\u884c\u4e3a\u6a21\u578b\u7684\u7ec4\u6210", model="PSDEAction")
public interface IPSDEActionInput
extends IPSDEMethodInput {
    public IPSDEAction getPSDEAction();

    public IPSDEFGroup getPSDEFGroup();

    public Iterator<IPSDEActionParam> getPSDEActionParams();

    public boolean isOutput();

    public IPSDEMethodDTO getPSDEMethodDTO() throws Exception;

    public IPSSysDynaModel getRefPSSysDynaModel();

    public IPSDEField getKeyPSDEField();
}

