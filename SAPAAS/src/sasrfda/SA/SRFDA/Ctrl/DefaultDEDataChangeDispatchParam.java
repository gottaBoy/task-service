/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEDataChg;
import SA.SRFDA.Ctrl.IDEDataChangeDispatchParam;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;

public class DefaultDEDataChangeDispatchParam
implements IDEDataChangeDispatchParam {
    private DEDataChg deDataChg = null;
    private XMLNode xmlNode = null;
    private IDEHelper iDEHelper = null;
    private BaseDataEntity logicData = null;

    @Override
    public DEDataChg getDEDataChg() {
        return this.deDataChg;
    }

    public void setDEDataChg(DEDataChg deDataChg) {
        this.deDataChg = deDataChg;
        this.logicData = null;
    }

    @Override
    public XMLNode getExportNode() {
        if (this.xmlNode == null) {
            if (this.getDEDataChg() == null) {
                return null;
            }
            XMLNode xmlNode = new XMLNode();
            String strData = this.getDEDataChg().getDATA();
            if (!StringHelper.IsNullOrEmpty((String)strData)) {
                XMLConfig.LoadFromXML((String)strData, (XMLConfig)xmlNode);
            }
            return xmlNode;
        }
        return this.xmlNode;
    }

    public void setExportNode(XMLNode xmlNode) {
        this.xmlNode = xmlNode;
    }

    @Override
    public IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    public void setDEHelper(IDEHelper iDEHelper) {
        this.iDEHelper = iDEHelper;
    }

    @Override
    public BaseDataEntity getLogicData() {
        if (this.deDataChg == null) {
            return null;
        }
        if (this.logicData == null) {
            this.logicData = BaseDataEntity.FromString((String)this.deDataChg.getLOGICDATA());
        }
        return this.logicData;
    }
}

