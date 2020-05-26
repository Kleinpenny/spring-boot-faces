package com.auth0.samples.bootfaces.controller;

import com.auth0.samples.bootfaces.mapper.BookMapper;
import com.auth0.samples.bootfaces.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CategoryController {
    @Autowired BookMapper bookMapper;

    @RequestMapping("/shopcategorie.html")
    public String books(Model model1 , @RequestParam(value = "book", defaultValue = "0") int book, @RequestParam(value = "category", defaultValue = "0") int category, @RequestParam(value = "choice", defaultValue = "0") int choice, @RequestParam(value = "pages", defaultValue = "1") int pages) {
        int size;
        List<List<Book>> pgs = new ArrayList<List<Book>>();
        if (choice==0){//如果不选择category的话，就全输出
            List<Book> cs = bookMapper.findAll();


            pgs.clear();
            model1.addAttribute("allcatebooks",cs);//应对所有的类别
            for(int i=0; i<cs.size();i++){
                if(i%5==0){
                    List<Book> pb = new ArrayList<Book>();
                    for(int j=0; j<5;j++){
                        if((i+j)<cs.size())//保证不满5本，有多少本，赋值多少本
                            pb.add(cs.get(i+j));
                    }
                    pgs.add(pb);

                }
            }
            size=cs.size();
            model1.addAttribute("books", pgs.get(pages-1));//把书分成每页5个(应对分页的类别)
            //model1.addAttribute("totalsum", cs.size());

        } else {//如果选择category的话，并且需要分页了
            List<Book> cs = bookMapper.findBooks(category);

            pgs.clear();

            model1.addAttribute("allcatebooks",cs);//应对所有的类别
            if(cs.size()!=0) {
                for (int i = 0; i < cs.size(); i++) {
                    if (i % 5 == 0) {//从0开始，把5本书的信息
                        List<Book> pb = new ArrayList<Book>();
                        for (int j = 0; j < 5; j++) {
                            if ((i + j) < cs.size())//保证不满5本，有多少本，赋值多少本
                                pb.add(cs.get(i + j));
                        }
                        pgs.add(pb);
                    }
                }
                model1.addAttribute("books", pgs.get(pages-1));//把书分成每页5个(应对分页的类别)
            }
            else{
                model1.addAttribute("books", cs);//不然就空
            }
            size=cs.size();

            // model1.addAttribute("books", cs);
        }
        List<Book> wg = bookMapper.findCate();
        model1.addAttribute("pages",pages);
        model1.addAttribute("category",category);
        model1.addAttribute("book", book);
        model1.addAttribute("cate", wg);
        model1.addAttribute("relation", size);//由category给出书的数目
        return "shopcategorie";
    }

        @RequestMapping("/single-product.html")
        public String details(Model m , @RequestParam(value = "book", defaultValue = "1") int id) {
            List<Book> wg = bookMapper.findCate();
            m.addAttribute("cate", wg);
            List<Book> details =bookMapper.findBook(id);//只找一本书
            m.addAttribute("books", details);
           // m.addAttribute("book", book);
            return "single-product";
    }


    @RequestMapping("/hello")
    public String hello3(Model model3) {
        model3.addAttribute("name", "thymeleaf");
        return "hello";
    }

    @RequestMapping("/cart.html")
    public String cart(Model m) {
        List<Book> wg = bookMapper.findCate();
        m.addAttribute("cate", wg);
        //m.addAttribute("name", "thymeleaf");
        return "cart";
    }
    @RequestMapping("/checkout.html")
    public String checkout(Model m) {
        List<Book> wg = bookMapper.findCate();
        m.addAttribute("cate", wg);
        //m.addAttribute("name", "thymeleaf");
        return "checkout";
    }
    @RequestMapping("/confirmpage.html")
    public String confirm(Model m) {
        List<Book> wg = bookMapper.findCate();
        m.addAttribute("cate", wg);
        //m.addAttribute("name", "thymeleaf");
        return "confirmpage";
    }
    @RequestMapping("/my-account.html")
    public String myaccount(Model m) {
        List<Book> wg = bookMapper.findCate();
        m.addAttribute("cate", wg);
        //m.addAttribute("name", "thymeleaf");
        return "my-account";
    }
    @RequestMapping("/my-account-login.html")
    public String login(Model m) {
        List<Book> wg = bookMapper.findCate();
        m.addAttribute("cate", wg);
        //m.addAttribute("name", "thymeleaf");
        return "my-account-login";
    }
    @RequestMapping("/Thankyou.html")
    public String QQ(Model m) {
        List<Book> wg = bookMapper.findCate();
        m.addAttribute("cate", wg);
        //m.addAttribute("name", "thymeleaf");
        return "Thankyou";
    }
    @RequestMapping("/index.html")
    public String home(Model m) {
        List<Book> wg = bookMapper.findCate();
        m.addAttribute("cate", wg);
        //m.addAttribute("name", "thymeleaf");
        return "index";
    }

}
