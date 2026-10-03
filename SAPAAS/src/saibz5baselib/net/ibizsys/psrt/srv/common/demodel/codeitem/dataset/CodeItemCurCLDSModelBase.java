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

@DEDataSet(id="C40C4852-F6B8-4983-9153-212BC11E92A2",name="CurCL",queries= {
    @DEDataSetQuery(queryid="399859EB-1BCC-4F4B-8EC2-719F1D27DF8E",queryname="CurCL")
})

/**
 *  实体数据集合[当前代码表]模型基类
 */
public abstract class CodeItemCurCLDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public CodeItemCurCLDSModelBase() {
        super();

        this.initAnnotation(CodeItemCurCLDSModelBase.class);
    }




}