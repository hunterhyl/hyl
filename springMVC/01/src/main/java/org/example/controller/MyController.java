package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*@Controller和@Component一样 都是创建对象 放入容器*/
@Controller
public class MyController {

    @RequestMapping(value = {"/some.do","/first.do"})
    /*这个注解可以 让一个请求对应一个方法 指定some.do请求交给doSome这个方法处理
    就相当于servlet中的doget 和dopost 都是用来处理请求的
    这是个数组 可以把很多请求都交给这个方法来处理 唯一不能重复
    不然不知道到底该交给那个方法处理*/
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

    @RequestMapping(value = {"other.do","second.do"})
    public ModelAndView doOther(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg","message");
        mav.setViewName("other");
        return mav;
    }

}
