/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeColumn;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.PS.Data.PSDEGridColumnType;
import SA.SRFDA.PS.Data.PSDETreeColumn;
import SA.SRFDA.PS.Data.PSDETreeNodeColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDEGridColumnType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDEGridColumnType var2) throws Exception;

    public IPSDEGridColumn createPSDEGridColumn(PSDEGridColumn var1) throws Exception;

    public IPSDETreeColumn createPSDETreeColumn(PSDETreeColumn var1) throws Exception;

    public IPSDETreeNodeColumn createPSDETreeNodeColumn(PSDETreeNodeColumn var1) throws Exception;
}

