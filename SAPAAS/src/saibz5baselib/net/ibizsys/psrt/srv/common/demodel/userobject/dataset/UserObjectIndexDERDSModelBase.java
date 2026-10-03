/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userobject.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="e560c77eda8c75691964f30fa7b826c7",name="IndexDER",queries= {})

/**
 *  实体索引实体类型数据集合[IndexDER]模型基类
 */
public abstract class UserObjectIndexDERDSModelBase extends net.ibizsys.paas.demodel.CodeListDEDataSetModelBase {
    public UserObjectIndexDERDSModelBase() {
        super();

        this.initAnnotation(UserObjectIndexDERDSModelBase.class);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.CodeListDEDataSetModelBase#getCodeList()
     */
    @Override
    protected ICodeList getCodeList() throws Exception {
        return (ICodeList)CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList5CodeListModel");
    }


}