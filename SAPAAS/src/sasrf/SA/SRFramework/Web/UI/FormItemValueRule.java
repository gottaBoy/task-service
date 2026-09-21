/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.FormItemValueRulePair;
import java.util.ArrayList;
import java.util.Hashtable;

public class FormItemValueRule
extends XMLConfig {
    public static final String OP = "OP";
    public static final String ARG = "ARG";
    public static final String ERROR = "ERROR";
    public static final String LOGIC = "LOGIC";
    protected boolean bAndLogic = false;
    private ArrayList opPairList = new ArrayList();
    private Hashtable keyList = new Hashtable();
    private String strError = "RuleError";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if ((strName = strName.toUpperCase()).indexOf(OP) == 0) {
            int nIndex = this.GetIndex(strName = strName.replace(OP, ""));
            if (nIndex == -1) {
                return;
            }
            FormItemValueRulePair pair = this.GetPair(nIndex);
            pair.setOperator(strValue);
            return;
        }
        if (strName.indexOf(ARG) == 0) {
            int nIndex = this.GetIndex(strName = strName.replace(ARG, ""));
            if (nIndex == -1) {
                return;
            }
            FormItemValueRulePair pair = this.GetPair(nIndex);
            pair.setArg(strValue);
            return;
        }
        if (strName.compareToIgnoreCase(ERROR) == 0) {
            this.strError = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(LOGIC) == 0) {
            if (StringHelper.Compare("AND", strValue, true) == 0) {
                this.bAndLogic = true;
            }
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    private int GetIndex(String value) {
        block3: {
            try {
                if (StringHelper.Length(value) != 0) break block3;
                return 0;
            }
            catch (Exception ex) {
                return -1;
            }
        }
        return Integer.parseInt(value);
    }

    private FormItemValueRulePair GetPair(int nIndex) {
        if (this.keyList.containsKey(nIndex)) {
            return (FormItemValueRulePair)this.keyList.get(nIndex);
        }
        FormItemValueRulePair pair = new FormItemValueRulePair();
        pair.setIndex(nIndex);
        this.opPairList.add(pair);
        this.keyList.put(nIndex, pair);
        return pair;
    }

    public String getError() {
        return this.strError;
    }

    public boolean getLogic() {
        return this.bAndLogic;
    }

    public ArrayList getOpList() {
        return this.opPairList;
    }
}

