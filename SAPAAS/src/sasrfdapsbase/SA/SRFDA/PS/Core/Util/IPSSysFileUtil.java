/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;

public interface IPSSysFileUtil
extends IPSSysUtil {
    public IPSDataEntity getStoagePSDataEntity();

    public IPSDEAction getGetPSDEAction();

    public IPSDEAction getCreatePSDEAction();

    public IPSDEAction getUpdatePSDEAction();

    public IPSDEAction getRemovePSDEAction();

    public IPSDEField getSysIdPSDEField();

    public IPSDEField getModelPSDEField();

    public IPSDEField getModelIdPSDEField();
}

