package org.dpl.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.PageData;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	protected BaseService baseservice;

	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		HttpSession session = getRequest().getSession();
		@SuppressWarnings("unchecked")
		Map<String, Object> userInfo = (Map<String, Object>) session.getAttribute("user");
		return userInfo;
	}

	/**
	 * 得到PageData
	 */
	public PageData getPageData() {
		// 从request获取PD转换的值,PD已在拦截器转换过
		return (PageData) getRequest().getAttribute("resPageData");// new PageData(this.getRequest());
	}

	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView() {
		return new ModelAndView();
	}

	// /**
	// * 获取message.properties
	// *
	// * @param msg
	// * @return
	// */
	// public String getMessageProp(String msg){
	// return baseInfoCache.getLogProp("message", msg);
	// }

}
