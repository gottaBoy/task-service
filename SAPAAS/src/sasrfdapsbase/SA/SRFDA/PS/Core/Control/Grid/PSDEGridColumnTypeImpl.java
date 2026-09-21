/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumnType;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeColumn;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeDEFColumnImpl;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeFieldColumnImpl;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeUAColumnImpl;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeUAColumnImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.PS.Data.PSDEGridColumnType;
import SA.SRFDA.PS.Data.PSDETreeColumn;
import SA.SRFDA.PS.Data.PSDETreeNodeColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEGridColumnTypeImpl
extends PSObjectImpl
implements IPSDEGridColumnType {
    protected PSDEGridColumnType psDEGridColumnType = null;
    private static final Log log = LogFactory.getLog(PSDEGridColumnTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDEGridColumnType psDEGridColumnType) throws Exception {
        this.psDEGridColumnType = psDEGridColumnType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDEGridColumnType.getPSDEGCTYPEID());
        this.setName(psDEGridColumnType.getPSDEGCTYPENAME());
        this.onInit();
    }

    @Override
    public IPSDEGridColumn createPSDEGridColumn(PSDEGridColumn psDEGridColumn) throws Exception {
        return (IPSDEGridColumn)ObjectHelper.Create((String)this.psDEGridColumnType.getCOLUMNOBJ());
    }

    @Override
    public IPSDETreeColumn createPSDETreeColumn(PSDETreeColumn psDETreeColumn) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.psDEGridColumnType.getTREECOLUMNOBJ())) {
            if (StringHelper.Compare((String)psDETreeColumn.getGRIDCOLTYPE(), (String)"DEFGRIDCOLUMN", (boolean)false) == 0) {
                return new PSDETreeDEFColumnImpl();
            }
            if (StringHelper.Compare((String)psDETreeColumn.getGRIDCOLTYPE(), (String)"UAGRIDCOLUMN", (boolean)false) == 0) {
                return new PSDETreeUAColumnImpl();
            }
            throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u6811\u8868\u683c\u5217\u5bf9\u8c61");
        }
        return (IPSDETreeColumn)ObjectHelper.Create((String)this.psDEGridColumnType.getTREECOLUMNOBJ());
    }

    @Override
    public IPSDETreeNodeColumn createPSDETreeNodeColumn(PSDETreeNodeColumn psDETreeNodeColumn) throws Exception {
        if (StringHelper.Compare((String)psDETreeNodeColumn.getGRIDCOLTYPE(), (String)"DEFGRIDCOLUMN", (boolean)false) == 0) {
            return new PSDETreeNodeFieldColumnImpl();
        }
        if (StringHelper.Compare((String)psDETreeNodeColumn.getGRIDCOLTYPE(), (String)"UAGRIDCOLUMN", (boolean)false) == 0) {
            return new PSDETreeNodeUAColumnImpl();
        }
        throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u6811\u8868\u683c\u5217\u5bf9\u8c61");
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

