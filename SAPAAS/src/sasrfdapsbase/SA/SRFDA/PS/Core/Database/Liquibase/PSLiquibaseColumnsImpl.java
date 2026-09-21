/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumn;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseColumns;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseColumnImpl;
import SA.SRFDA.PS.Core.DynaModel.PSXmlNodesImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@PSModelIgnoreMeta
public class PSLiquibaseColumnsImpl
extends PSXmlNodesImpl<IPSLiquibaseColumn>
implements IPSLiquibaseColumns {
    @Override
    protected IPSLiquibaseColumn getItem(String strName, Node xmlNode) throws Exception {
        if (!(xmlNode instanceof Element)) {
            return null;
        }
        Element xmlElement = (Element)xmlNode;
        if (StringHelper.compare((String)"column", (String)xmlElement.getNodeName(), (boolean)false) != 0) {
            return null;
        }
        return this.getPSLiquibaseColumn(strName, xmlElement);
    }

    protected IPSLiquibaseColumn getPSLiquibaseColumn(String strName, Element xmlElement) throws Exception {
        PSLiquibaseColumnImpl psLiquibaseColumnImpl = new PSLiquibaseColumnImpl();
        psLiquibaseColumnImpl.init(this.getDAGlobalHelper(), this, strName, xmlElement);
        return psLiquibaseColumnImpl;
    }

    @Override
    protected String getItemNameFormat() {
        return "column%1$s";
    }

    @Override
    public String getModelType() {
        return "PSLIQUIBASECOLUMNS$" + this.getPSXmlNodeOwner().getModelType();
    }
}

