package com.alten.vehicle.monitoring.filters;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class RouteFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return "route";
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
   System.out.println("Inside Route Filter");
   RequestContext ctx = RequestContext.getCurrentContext();
   HttpServletRequest request = ctx.getRequest();

   System.out.println("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
  
    return null;
  }

}
