/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfactor.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="d7e9d51ebd8eee667063d9a75cf2455a",name="IndexDER",queries= {})

/**
 *  实体索引实体类型数据集合[IndexDER]模型基类
 */
public abstract class WFActorIndexDERDSModelBase extends net.ibizsys.paas.demodel.CodeListDEDataSetModelBase {
    public WFActorIndexDERDSModelBase() {
        super();

        this.initAnnotation(WFActorIndexDERDSModelBase.class);
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.demodel.CodeListDEDataSetModelBase#getCodeList()
     */
    @Override
    protected ICodeList getCodeList() throws Exception {
        return (ICodeList)CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFActorTypeCodeListModel");
    }


}