/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Database.Liquibase;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseAction;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseActions;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseCreateTable;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseCreateTableImpl;
import SA.SRFDA.PS.Core.DynaModel.PSXmlNodesImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@PSModelIgnoreMeta
public class PSLiquibaseActionsImpl
extends PSXmlNodesImpl<IPSLiquibaseAction>
implements IPSLiquibaseActions {
    @Override
    protected IPSLiquibaseAction getItem(String strName, Node xmlNode) throws Exception {
        if (!(xmlNode instanceof Element)) {
            return null;
        }
        Element xmlElement = (Element)xmlNode;
        if (StringHelper.compare((String)"createTable", (String)xmlElement.getNodeName(), (boolean)false) == 0) {
            return this.getPSLiquibaseCreateTable(strName, xmlElement);
        }
        return null;
    }

    protected IPSLiquibaseCreateTable getPSLiquibaseCreateTable(String strName, Element xmlElement) throws Exception {
        PSLiquibaseCreateTableImpl psLiquibaseCreateTableImpl = new PSLiquibaseCreateTableImpl();
        psLiquibaseCreateTableImpl.init(this.getDAGlobalHelper(), this, strName, xmlElement);
        return psLiquibaseCreateTableImpl;
    }

    @Override
    protected String getItemNameFormat() {
        return "action%1$s";
    }

    @Override
    public String getModelType() {
        return "PSLIQUIBASEACTIONS$" + this.getPSXmlNodeOwner().getModelType();
    }
}

