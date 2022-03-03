package org.example.controller;


import org.example.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping(value = "/receivePara")

    public ModelAndView doSome(String name,Integer age){
/*这里演示的是逐个接收参数 在表单中 有name 和age 那么这里的参数也只能叫 name和age
* 不能是其他 而且输入的时候虽然都是在text文本框输入的 框架会自动根据类型转换
* 但是输入的是float类型 像转换成Integer类型就不行 */

        ModelAndView mav=new ModelAndView();
        mav.addObject("user_name",name);
        mav.addObject("user_age",age);
        mav.setViewName("show");/*这是一个跳转操作*/

        return mav;
    }


    @RequestMapping(value = "/receivePara11")

    public ModelAndView doSome11(@RequestParam(value = "rname",required = false) String name,
                                 @RequestParam(value = "rage",required = false) Integer age)
    /*意思是 rage 的值赋给age 并且 这个参数可以不传值 如果是true（默认就是true） 那么不传值就会报错400*/
    {
        /*这里演示的是逐个接收参数 在表单中 有name 和age 那么这里的参数也只能叫 name和age
         * 不能是其他 而且输入的时候虽然都是在text文本框输入的 框架会自动根据类型转换
         * 但是输入的是float类型 像转换成Integer类型就不行 */

        ModelAndView mav=new ModelAndView();
        mav.addObject("user_name",name);
        mav.addObject("user_age",age);
//        mav.setViewName("show");
        mav.setViewName("redirect:/hello.jsp");
//        http://localhost:8080/03_receivePara_war_exploded/hello.jsp?user_name=zhangsan&user_age=23
        /*重定向执行如下 在访问的时候 第一个requst 执行了
        mav.addObject("user_name",name);
        mav.addObject("user_age",age);这两行代码
        所以第一个request是带着值的 然后向hello.jsp发起第二次请求
        在请求中带有user_name=zhangsan&user_age=23这两个值
        但是第二次请求中的request是不带值的 反而在url中带值
        所以想要拿到值 需要在hello.jsp中使用
        ${param.user_name}  ${param.user_age} 这种写法
        同样的 redirect和forward都是无视 视图解析器的存在的写法 也就是说需要写文件全称
        且不能访问WEB-INF下的文件*/
        return mav;
    }


    @RequestMapping(value = "/receiveObject")

    public ModelAndView doSome22(Student student)
            /*框架会创建student对象 然后根据相同的名字 调用对应的set方法赋值*/
    {
        ModelAndView mav=new ModelAndView();
        mav.addObject("user_name",student.getStudent_name());
        mav.addObject("user_age",student.getStudent_age());
        mav.addObject("student",student);
//        mav.setViewName("other");
        /*因为我们配置了视图解析器 所以 /WEB-INF/view/other.jsp 可以简写成other
        * 那么如果我想此时访问 /webapp/hello.jsp 怎么办？ 如果直接写/webapp/hello.jsp
        * 那么其实访问的是 /WEB-INF/view/hello.jsp.jsp  很显然 是错误的
        * 所以需要这样写*/
        mav.setViewName("forward:/hello.jsp");

        return mav;
    }


}
