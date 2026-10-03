/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.codeitem.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="60a039b41c39edc7ff965f1c0958232d",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="05FAA261-0651-458F-8269-ECD08771AFD9",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class CodeItemDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public CodeItemDefaultDSModelBase() {
        super();

        this.initAnnotation(CodeItemDefaultDSModelBase.class);
    }




}