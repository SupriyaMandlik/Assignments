package com.cts.customTag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHandler extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		System.out.println("from doStartTag()");

		JspWriter out = pageContext.getOut();
		try {
			out.write("<h1>" + new Date() + "</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// return super.doStartTag();
		return EVAL_BODY_INCLUDE; // used to include content inside tag body
		// return SKIP_BODY; // it skips the content inside body of tag

	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("from doEndTag()");

		// return super.doEndTag();
		// return SKIP_PAGE; // it skips content of the page or content which is outside tag
		return EVAL_PAGE; // used to show content of page 
	}
}
