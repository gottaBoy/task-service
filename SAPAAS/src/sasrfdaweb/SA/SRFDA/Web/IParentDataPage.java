/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;

public interface IParentDataPage {
    public Object getParentKey() throws Exception;

    public IPickupDEFHelper getPickupDEFHelper() throws Exception;

    public Object getPickupDEFValue() throws Exception;

    public IDEHelper getParentDEHelper() throws Exception;

    public BaseDataEntity getParentData() throws Exception;

    public boolean isEnableParentData() throws Exception;

    public boolean isParentDataInWorkflow() throws Exception;

    public boolean isParentDataEnableWFSubmit() throws Exception;

    public boolean isParentDataEnableWFUpdate() throws Exception;

    public boolean isParentDataTempMode() throws Exception;
}

