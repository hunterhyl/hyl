package ExceptionHadler;


import ControllerException.AgeException;
import ControllerException.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice       /*见名知意 控制增强  */
public class exception_handler {


    @ExceptionHandler(NameException.class)/*意思就是 当抛出了NameException的时候 这个方法来处理*/
    public ModelAndView NameException_handler(Exception ex){
        ModelAndView andView=new ModelAndView();
        andView.addObject("nameError_message","name is error");
        andView.addObject("ex",ex);
        andView.setViewName("ShowNameError");
        return andView;
    }


    @ExceptionHandler(AgeException.class)/*意思就是 当抛出了AgeException的时候 这个方法来处理*/
    public ModelAndView AgeException_handler(Exception ex){
        ModelAndView andView=new ModelAndView();
        andView.addObject("ageError_message","age is error");
        andView.addObject("ex",ex);
        andView.setViewName("ShowAgeError");
        return andView;
    }

    @ExceptionHandler()/*意思就是 其他的所有方法 都交给这个处理*/
    public ModelAndView OtherException_handler(Exception ex){
        ModelAndView andView=new ModelAndView();
        andView.addObject("otherError_message","Other error");
        andView.addObject("ex",ex);
        andView.setViewName("ShowOtherError");
        return andView;
    }

}
