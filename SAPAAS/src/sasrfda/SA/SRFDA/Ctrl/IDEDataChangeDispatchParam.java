/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEDataChg;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.XML.XMLNode;

public interface IDEDataChangeDispatchParam {
    public DEDataChg getDEDataChg();

    public XMLNode getExportNode();

    public IDEHelper getDEHelper();

    public BaseDataEntity getLogicData();
}

