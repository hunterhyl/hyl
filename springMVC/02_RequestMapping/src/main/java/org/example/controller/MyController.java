package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*@Controller和@Component一样 都是创建对象 放入容器*/
@Controller
@RequestMapping(value = "/test")/*这个注释的意思是 所有的some.do first.do等等
                                    他的全称是/test/first.do了 方便与包的管理
                                    如下：：*/
//<p><a href="test/first.do">向some。do发送请求</a> </p>
//<p><a href="test/other.do">向other.do发送请求</a> </p>
public class MyController {

    @RequestMapping(value = {"/some.do","/first.do"},method = RequestMethod.GET)

    public ModelAndView doSome(){

        /*ModelAndView
        * Model是数据 就是处理结束之后
        * 返回的数据Request.setAttribute("msg","ni hao yuan ying shi yong  mvc kai fa");
        * View是视图 即 request.getRequestDispatcher("/xxxx").forward*/
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg","ni hao yuan ying shi yong  mvc kai fa");
        mav.addObject("fun","doSome fang fa zhi xing");

//        mav.setViewName("/WEB-INF/view/show.jsp");
        /*因为配置了视图解析器 所以我们只需要如下写即可*/
        mav.setViewName("show");

        return mav;
    }

    @RequestMapping(value = {"other.do","second.do"},method = RequestMethod.POST)
    /*如果 不加 method  则   post  或者是   get 都可以*/
    public ModelAndView doOther(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg","message");
        mav.setViewName("other");
        return mav;
    }

}
