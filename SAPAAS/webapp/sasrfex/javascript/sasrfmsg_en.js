if ($P && $P.msg) {
    $P.msg['networkerror'] = '向服务器发送处理请求出现故障，请确认您的网络连接是否正常！';
    $P.msg['1'] = "系统内部发生错误";
    $P.msg['2'] = "访问被拒绝，可能由于权限原因导致";
    $P.msg['3'] = "数据不存在";
    $P.msg['4'] = "数据的索引条件有误或不足";
    $P.msg['5'] = "数据的信息有误或不足";
    $P.msg['6'] = "重复的数据键";
    $P.msg['7'] = "重复的数据";
    $P.msg['8'] = "删除拒绝，可能由于权限原因导致";
    $P.msg['9'] = "逻辑处理错误";
    $P.msg['10'] = "数据不匹配";

   

    $P.msg['20'] = "没有实现指定功能";
    $P.msg.fmt = function(_1, _2) { return '系统处理失败，原因是：' + _1 + '。详细信息:' + _2; };
    $P.msg.fmt2 = function(_1) { return '已经注册了返回值[' + _1 + ']，但没有处理，请向管理员联系确认！'; };
    /*表格相关消息*/
    $P.msg['dgnotload'] = '<SPAN class=\'sx-normaltext\'>The datagrid has not yet loaded, click [Search] button to load the data.</SPAN>';
    $P.msg['dgnorecord'] = '<SPAN class=\'sx-normaltext\'>No data found that match your requirements.</SPAN>';

    $P.msg['dgrowunsave'] = '表格中还有未保存的的数据，取消行编辑模式将丢失这些数据，确实要继续么？';
    $P.msg['dgrowunsave2'] = '表格中还有未保存的的数据，重新载入表格数据将丢失这些数据，确实要继续么？';
    $P.msg['dgexport'] = '选择确定导出当前分页数据，选择取消导出符合条件但最多不超过1000条记录？';
    $P.msg.dgexportfmt = function(_1) { return '选择确定导出当前分页数据，选择取消导出符合条件但最多不超过' + _1 + '条记录？'; };
    $P.msg.dgexportfmt2 = function(_1) { return '选择确定继续上一次导出，从第' + _1 + '行开始，选择取消从第一行记录开始？'; };
    $P.msg.dgexportfmt3 = function(_1) { return '选择确定继续上一次导出，从第' + _1 + '行开始？'; };
    $P.msg['errorresponse'] = 'System does not respond to your request, please try again!';
    $P.msg['processing'] = 'System processing, please wait...';
    $P.msg['formmodifyalert'] = 'Form the content has changed, you have to leave Why?';
    $P.msg['10000'] = '界面中不存在主表单，无法进行保存操作';
    $P.msg['10001'] = '界面中不存在主表单，无法进行删除操作';
    $P.msg['10002'] = '界面中不存在主表单，无法进行新建操作';
    $P.msg['10100'] = '选择确定只导出与框架相关的信息，选择取消则全部导出？';
    $P.msg['spex_custompage'] = 'Custom';
    $P.msg['spex_custombtn_text'] = ' Custom ';
    $P.msg['spex_custom_groupand'] = 'AND';
    $P.msg['spex_custom_groupor'] = 'OR';
    $P.msg['spex_nocondition'] = 'No condition';
    $P.msg['spex_saveload'] = 'Save/Load Condition';
    $P.msg['spex_condname'] = 'Theme';
    $P.msg['spex_newcond'] = '<<New>>';
    $P.msg['spex_selectcond'] = 'Select Theme';
    $P.msg['spex_saveloadbtn_save'] = 'Save';
    $P.msg['spex_saveloadbtn_remove'] = 'Remove';
    $P.msg['spex_inputthemenamemsg'] = 'Please input theme name!';


    $P.msg['uploader_removetips'] = 'Remove this file.';
    $P.msg.uploader_removeconfirm = function (_1) { return 'Remove ' + _1 + ' ?'; };
    $P.msg.uploader_uploadlimit = function (_1) { return 'Upload files limit the number to ' + _1 + ' ,can not upload anymore！'; };

    $P.msg['form_reloadmsg'] = 'Reload form data？';
 
}
//Ext.Msg.buttonText = { ok: "OK", cancel: "Cancel", yes: "Yes", no: "No" };