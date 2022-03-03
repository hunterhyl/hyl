package controller;

import ControllerException.AgeException;
import ControllerException.MyException;
import ControllerException.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mycontroller {

    @RequestMapping("/ecxeption.do")
    public ModelAndView doSome(String name,Integer age) throws MyException {

        ModelAndView andView=new ModelAndView();

        if (!name.equals("zs")){
            throw new NameException("name is error should be zs ");
        }
        if (age!=23){
            throw new AgeException("age is error should be 23");
        }

        andView.addObject("name",name);
        andView.addObject("age",age);
        andView.setViewName("show");

        return andView;


    }


}
