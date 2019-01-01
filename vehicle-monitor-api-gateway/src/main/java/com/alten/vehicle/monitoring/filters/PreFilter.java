package com.alten.vehicle.monitoring.filters;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(PreFilter.class);
  
  @Override
  public String filterType() {
    return "pre";
  }
 
  @Override
  public int filterOrder() {
    return 1;
  }
 
  @Override
  public boolean shouldFilter() {
    return true;
  }
 
  @Override
  public Object run() {
    System.out.println("Inside Pre Filter");
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
 
    log.info("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
   
    return null;
  }

}
