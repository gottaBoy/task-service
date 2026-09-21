/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeLog;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeLogOwner;
import SA.SRFDA.PS.Core.Database.Liquibase.IPSLiquibaseChangeSets;
import SA.SRFDA.PS.Core.Database.Liquibase.PSLiquibaseChangeLogImpl;
import SA.SRFDA.PS.Core.DynaModel.IPSXmlNodeOwner;
import SA.SRFDA.PS.Core.DynaModel.PSSysDynaModelImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@PSModelImplementMeta(implement="IPSSysDynaModel", typevalues={"LIQUIBASECHANGELOG"})
public class PSLiquibaseChangeLogModelImpl
extends PSSysDynaModelImpl
implements IPSLiquibaseChangeLog,
IPSLiquibaseChangeLogOwner {
    private static final Log log = LogFactory.getLog(PSLiquibaseChangeLogModelImpl.class);
    private IPSLiquibaseChangeLog iPSLiquibaseChangeLog = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onPreparePSSysDynaModelAttrs() throws Exception {
        String strXML = null;
        if (!StringHelper.isNullOrEmpty((String)this.getJOString())) {
            strXML = this.getJOString();
        }
        if (StringHelper.isNullOrEmpty(strXML)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u53d8\u66f4\u65e5\u5fd7");
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        ByteArrayInputStream is = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
        Document doc = documentBuilder.parse(is);
        PSLiquibaseChangeLogImpl psLiquibaseChangeLogImpl = new PSLiquibaseChangeLogImpl();
        psLiquibaseChangeLogImpl.init(this.getDAGlobalHelper(), this, this.getName(), doc.getFirstChild());
        this.iPSLiquibaseChangeLog = psLiquibaseChangeLogImpl;
    }

    @Override
    public String getModelType() {
        return "PSLIQUIBASECHANGELOG";
    }

    @Override
    public IPSLiquibaseChangeLog getPSLiquibaseChangeLog() {
        return this.iPSLiquibaseChangeLog;
    }

    @Override
    public IPSXmlNodeOwner getPSXmlNodeOwner() {
        return null;
    }

    @Override
    public Node getXmlNode() {
        if (this.getPSLiquibaseChangeLog() != null) {
            return this.getPSLiquibaseChangeLog().getXmlNode();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u53d8\u66f4\u96c6\u96c6\u5408")
    public IPSLiquibaseChangeSets getPSLiquibaseChangeSets() {
        if (this.getPSLiquibaseChangeLog() != null) {
            return this.getPSLiquibaseChangeLog().getPSLiquibaseChangeSets();
        }
        return null;
    }

    @Override
    public Element getXmlElement() {
        if (this.getPSLiquibaseChangeLog() != null) {
            return this.getPSLiquibaseChangeLog().getXmlElement();
        }
        return null;
    }

    @Override
    public String getElementId() {
        if (this.getPSLiquibaseChangeLog() != null) {
            return this.getPSLiquibaseChangeLog().getElementId();
        }
        return null;
    }

    @Override
    public String getNodeName() {
        if (this.getPSLiquibaseChangeLog() != null) {
            return this.getPSLiquibaseChangeLog().getNodeName();
        }
        return null;
    }

    @Override
    public String getNodeValue() {
        if (this.getPSLiquibaseChangeLog() != null) {
            return this.getPSLiquibaseChangeLog().getNodeValue();
        }
        return null;
    }
}

