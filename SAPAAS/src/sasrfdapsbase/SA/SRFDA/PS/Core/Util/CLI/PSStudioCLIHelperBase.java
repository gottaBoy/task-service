/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Util.CLI;

import SA.SRFDA.PS.Core.Util.CLI.IPSStudioCLIHelper;
import SA.SRFDA.PS.Data.PSTaskServerCmd;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSStudioCLIHelperBase
implements IPSStudioCLIHelper {
    private static final Log log = LogFactory.getLog(PSStudioCLIHelperBase.class);
    private List<String> dcCmdList = new ArrayList<String>();
    private List<String> slnCmdList = new ArrayList<String>();
    private List<String> sysCmdList = new ArrayList<String>();
    private List<String> templCmdList = new ArrayList<String>();
    private Map<String, CLIDataItem[]> cmdDataItemsMap = new HashMap<String, CLIDataItem[]>();

    public PSStudioCLIHelperBase() {
        this.registerDefault();
    }

    protected void registerDefault() {
    }

    protected void registerDCCmdDataItems(String strCmd, CLIDataItem[] cliDataItems) {
        this.dcCmdList.add(strCmd);
        this.cmdDataItemsMap.put(strCmd, cliDataItems);
    }

    protected void registerSlnCmdDataItems(String strCmd, CLIDataItem[] cliDataItems) {
        this.slnCmdList.add(strCmd);
        this.cmdDataItemsMap.put(strCmd, cliDataItems);
    }

    protected void registerSysCmdDataItems(String strCmd, CLIDataItem[] cliDataItems) {
        this.sysCmdList.add(strCmd);
        this.cmdDataItemsMap.put(strCmd, cliDataItems);
    }

    protected void registerTemplCmdDataItems(String strCmd, CLIDataItem[] cliDataItems) {
        this.templCmdList.add(strCmd);
        this.cmdDataItemsMap.put(strCmd, cliDataItems);
    }

    @Override
    public void execute(String strCmd, List<ObjectNode> dataList, PSTaskServerCmd psTaskServerCmd) throws Exception {
        this.onExecute(strCmd, dataList, psTaskServerCmd);
    }

    protected void onExecute(String strCmd, List<ObjectNode> dataList, PSTaskServerCmd psTaskServerCmd) throws Exception {
        CLIDataItem[] cliDataItems = this.cmdDataItemsMap.get(strCmd);
        if (cliDataItems == null) {
            throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u547d\u4ee4[%1$s]\u6570\u636e\u9879\u914d\u7f6e", strCmd));
        }
        for (ObjectNode objNode : dataList) {
            HashMap<String, Object> paramMap = new HashMap<String, Object>();
            CLIDataItem[] cLIDataItemArray = cliDataItems;
            int n = cliDataItems.length;
            int n2 = 0;
            while (n2 < n) {
                CLIDataItem cliDataItem = cLIDataItemArray[n2];
                if (!StringHelper.IsNullOrEmpty((String)cliDataItem.name)) {
                    Object objValue = objNode.get(cliDataItem.name);
                    if (objValue == null) {
                        if (cliDataItem.required) {
                            throw new Exception(String.format("\u672a\u6307\u5b9a\u6570\u636e\u9879[%1$s]\u503c", cliDataItem.name));
                        }
                        objValue = cliDataItem.def;
                    } else {
                        JsonNode jsonNode = objValue;
                        if (jsonNode.isTextual()) {
                            objValue = jsonNode.asText();
                        } else if (jsonNode.isInt()) {
                            objValue = jsonNode.intValue();
                        } else if (jsonNode.isDouble()) {
                            objValue = jsonNode.asDouble();
                        } else {
                            throw new Exception(String.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u9879[%1$s]\u503c[%2$s]", cliDataItem.name, jsonNode));
                        }
                    }
                    paramMap.put(cliDataItem.fieldName, objValue);
                } else {
                    paramMap.put(cliDataItem.fieldName, cliDataItem.def);
                }
                ++n2;
            }
            this.onExecute(strCmd, paramMap, objNode, psTaskServerCmd);
        }
    }

    protected void onExecute(String strCmd, Map<String, Object> paramMap, ObjectNode objectNode, PSTaskServerCmd psTaskServerCmd) throws Exception {
        throw new Exception(String.format("\u672a\u5b9e\u73b0\u547d\u4ee4[%1$s]", strCmd));
    }

    @Override
    public String[] getSupportedDCCmds() {
        if (this.dcCmdList == null || this.dcCmdList.size() == 0) {
            return null;
        }
        return this.dcCmdList.toArray(new String[this.dcCmdList.size()]);
    }

    @Override
    public String[] getSupportedSlnCmds() {
        if (this.slnCmdList == null || this.slnCmdList.size() == 0) {
            return null;
        }
        return this.slnCmdList.toArray(new String[this.slnCmdList.size()]);
    }

    @Override
    public String[] getSupportedSysCmds() {
        if (this.sysCmdList == null || this.sysCmdList.size() == 0) {
            return null;
        }
        return this.sysCmdList.toArray(new String[this.sysCmdList.size()]);
    }

    @Override
    public String[] getSupportedTemplCmds() {
        if (this.templCmdList == null || this.templCmdList.size() == 0) {
            return null;
        }
        return this.templCmdList.toArray(new String[this.templCmdList.size()]);
    }

    protected class CLIDataItem {
        public String name = null;
        public String fieldName = null;
        public boolean required = false;
        public String memo = null;
        public Object def = null;

        public CLIDataItem(String name, String fieldName, boolean required, String memo, Object def) {
            this.name = name;
            this.fieldName = fieldName;
            this.required = required;
            this.memo = memo;
            this.def = def;
        }

        public CLIDataItem(String name, String fieldName, boolean required, String memo) {
            this.name = name;
            this.fieldName = fieldName;
            this.required = required;
            this.memo = memo;
        }
    }
}

