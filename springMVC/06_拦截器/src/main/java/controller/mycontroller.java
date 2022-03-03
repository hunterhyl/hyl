package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mycontroller {

    @RequestMapping("/some.do")
    public ModelAndView doSome(String name,Integer age) {
        ModelAndView andView=new ModelAndView();
        andView.addObject("name",name);
        andView.addObject("age",age);
        andView.setViewName("show");
        return andView;

    }

}
