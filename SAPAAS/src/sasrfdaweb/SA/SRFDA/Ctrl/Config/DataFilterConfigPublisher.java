/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Model.SearchItemConfig
 *  SA.SRFramework.DataEx.ConditionHelper
 *  SA.SRFramework.DataEx.Conditions
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.DAConfigPublisher;
import SA.SRFDA.Ctrl.Config.IDataFilterConfigPublishContext;
import SA.SRFDA.Ctrl.Config.IDataFilterConfigPublisherContext;
import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFramework.DataEx.ConditionHelper;
import SA.SRFramework.DataEx.Conditions;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SA.SRFramework.XML.XMLNode;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;

public class DataFilterConfigPublisher
extends DAConfigPublisher<IDataFilterConfigPublishContext>
implements IDataFilterConfigPublisherContext {
    protected Hashtable<String, String> ignoreConditionMap = new Hashtable();
    protected Hashtable<String, String> ignoreConditionMap2 = new Hashtable();

    public DataFilterConfigPublisher() {
        this.ignoreConditionMap.put("==", "==");
        this.ignoreConditionMap.put("IN", "IN");
        this.ignoreConditionMap.put("NOTIN", "NOTIN");
        this.ignoreConditionMap2.put(">", ">");
        this.ignoreConditionMap2.put(">=", ">=");
        this.ignoreConditionMap2.put("<", "<");
        this.ignoreConditionMap2.put("<=", "<=");
        this.ignoreConditionMap2.put("LIKE", "LIKE");
        this.ignoreConditionMap2.put("LEFTLIKE", "LEFTLIKE");
        this.ignoreConditionMap2.put("RIGHTLIKE", "RIGHTLIKE");
    }

    @Override
    protected String OnGetConfigId(IDataFilterConfigPublishContext iDAConfigPublishContext) throws Exception {
        String strConfigId = "";
        strConfigId = StringHelper.Format((String)"DE%1$s.DATAFILTER_%2$s", (Object)iDAConfigPublishContext.getDEHelper().getId(), (Object)iDAConfigPublishContext.getDEHelper().getVersion());
        strConfigId = DataFilterConfigPublisher.AppendPageId(strConfigId, iDAConfigPublishContext);
        return strConfigId;
    }

    @Override
    protected XMLNode OnPublish(IDataFilterConfigPublishContext iPublishContext) throws Exception {
        IDEHelper iDEHelper = iPublishContext.getDEHelper();
        if (iDEHelper == null) {
            throw new Exception("\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548");
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFDADATAFILTER");
        XMLNode dataFilterItemsNode = new XMLNode();
        dataFilterItemsNode.setNodeName("DATAFILTERITEMS");
        rootNode.AddNode(dataFilterItemsNode);
        Vector<IDEFHelper> sortedDEFHelpers = new Vector<IDEFHelper>();
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            if (!iDEFHelper.IsUserVisible()) continue;
            sortedDEFHelpers.add(iDEFHelper);
        }
        DEFieldComparator deFieldComparator = new DEFieldComparator();
        deFieldComparator.setLanguage(this.getLanguage());
        Collections.sort(sortedDEFHelpers, deFieldComparator);
        for (IDEFHelper iDEFHelper : sortedDEFHelpers) {
            XMLNode dataFilterItemNode = new XMLNode();
            dataFilterItemNode.setNodeName("DATAFILTERITEM");
            dataFilterItemNode.SetValue("ID", iDEFHelper.getName());
            dataFilterItemNode.SetValue("NAME", iDEFHelper.getLogicName(this.getLanguage()));
            dataFilterItemNode.SetValue("STDDATATYPE", iDEFHelper.GetStdDataType());
            dataFilterItemNode.SetValue("DATATYPE", iDEFHelper.GetDataType());
            if (iDEFHelper.IsEnableDEFieldPriv()) {
                String strPrivilegeId = StringHelper.Format((String)"%1$s|%1$s_%2$s", (Object)iDEHelper.getName(), (Object)iDEFHelper.getName());
                dataFilterItemNode.SetValue("PRIVILEGEID", strPrivilegeId);
            }
            String strConditions = "";
            Vector<String> conditions = ConditionHelper.GetDataTypeSupportConditions((String)iDEFHelper.GetStdDataType());
            for (String strCondition : conditions) {
                if (this.ignoreConditionMap.containsKey(strCondition) || !StringHelper.IsNullOrEmpty((String)iDEFHelper.GetCodeList()) && this.ignoreConditionMap2.containsKey(strCondition)) continue;
                if (!StringHelper.IsNullOrEmpty((String)strConditions)) {
                    strConditions = String.valueOf(strConditions) + ";";
                }
                strConditions = String.valueOf(strConditions) + StringHelper.Format((String)"%1$s|%2$s", (Object)Conditions.GetConditionLogicName((ISRFExGlobalHelper)this.getDAGlobalHelper(), (String)this.getLanguage(), (String)strCondition), (Object)strCondition);
            }
            dataFilterItemNode.SetValue("CONDITIONS", strConditions);
            XMLNode dataFilterItemCtrlsNode = new XMLNode();
            dataFilterItemCtrlsNode.setNodeName("DATAFILTERITEMCTRLS");
            dataFilterItemNode.AddNode(dataFilterItemCtrlsNode);
            SearchItemConfig searchItemConfig = new SearchItemConfig();
            searchItemConfig.setAction("EQ");
            XMLNode formItemNode = this.getDAGlobalHelper().getDAFormItemHelper().GetSearchFormCtrlNode(this.getDAConfigHelperContext().getPageModel(), this.getLanguage(), iDEHelper, iDEFHelper, searchItemConfig);
            if (formItemNode == null) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5c5e\u6027[%1$s]\u641c\u7d22\u8868\u5355\u63a7\u4ef6\u914d\u7f6e\u5931\u8d25", (Object)iDEFHelper.getId()));
            }
            ((XMLNode)formItemNode.getChildNodes().get(0)).setID(iDEFHelper.getName());
            formItemNode.RemoveExtValue("ALLOWEMPTY");
            formItemNode.RemoveExtValue("CAPTION");
            formItemNode.setID("EQ");
            dataFilterItemCtrlsNode.AddNode(formItemNode);
            dataFilterItemsNode.AddNode(dataFilterItemNode);
        }
        return rootNode;
    }

    public String GetConfigFilePath(String strConfigId) throws Exception {
        return ConfigPathHelper.GetRuntimeDataFilterConfigPath((String)this.getDAGlobalHelper().GetAppRootPath(), (String)strConfigId);
    }

    public class DEFieldComparator
    implements Comparator<IDEFHelper> {
        RuleBasedCollator collator = (RuleBasedCollator)Collator.getInstance(Locale.CHINA);
        private String strLanguage = "";

        public final void setLanguage(String strLanguage) {
            this.strLanguage = strLanguage;
            this.collator = StringHelper.IsNullOrEmpty((String)this.getLanguage()) || StringHelper.Compare((String)strLanguage, (String)"ZHCN", (boolean)true) == 0 || StringHelper.Compare((String)strLanguage, (String)"TW", (boolean)true) == 0 ? (RuleBasedCollator)Collator.getInstance(Locale.CHINA) : (RuleBasedCollator)Collator.getInstance(Locale.ENGLISH);
        }

        public final String getLanguage() {
            return this.strLanguage;
        }

        @Override
        public int compare(IDEFHelper o1, IDEFHelper o2) {
            return this.collator.compare(o1.getLogicName(this.getLanguage()), o2.getLogicName(this.getLanguage()));
        }
    }
}
