/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorContainer;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u7f16\u8f91\u5668\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSEditorItem
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSEditor var2, IPSEditorContainer var3, String var4, boolean var5) throws Exception;

    public IPSEditor getPSEditor();

    public IPSDataEntity getPSDataEntity() throws Exception;

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public IPSDEACMode getPSDEACMode() throws Exception;

    public IPSAppDataEntity getPSAppDataEntity() throws Exception;

    public IPSAppDEDataSet getPSAppDEDataSet() throws Exception;

    public IPSAppDEACMode getPSAppDEACMode() throws Exception;
}

