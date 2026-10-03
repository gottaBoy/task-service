/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.ibizsys.paas.web.tags;

import javax.servlet.jsp.JspException;

import org.springframework.context.NoSuchMessageException;

import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;


/**
 * JSP消息标记
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class MessageTag extends org.springframework.web.servlet.tags.MessageTag {

	private String strCode = null;
	
	private String strText = null;
	
	
	@Override
	public void setCode(String code) {
		this.strCode = code;
		super.setCode(code);
	}
	
	

	
	
	@Override
	public void setText(String text) {
		this.strText = text;
		super.setText(text);
	}
	
	@Override
	protected String resolveMessage() throws JspException, NoSuchMessageException {
		
		IWebContext iWebContext = WebContext.getCurrent();
		if(iWebContext!=null)
			return iWebContext.getLocalization(this.strCode,this.strText);
		
		return super.resolveMessage();
	}
	
	
}
