package com.auth0.samples.bootfaces.mapper;

import com.auth0.samples.bootfaces.pojo.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Mapper
@Service
public interface BookMapper {

    @Select("select book_name,book_price,book_id,book_sum,book_autor,book_info,book_verlag,book_sort,book_url from buch ")
    @Results({
            @Result(property = "name", column = "book_name"),
            @Result(property = "price", column = "book_price"),
            @Result(property = "id", column = "book_id"),
            @Result(property = "sum", column = "book_sum"),
            @Result(property = "autor", column = "book_autor"),
            @Result(property = "info", column = "book_info"),
            @Result(property = "verlag", column = "book_verlag"),
           // @Result(property = "update_time", column = "book_update_time"),
             @Result(property = "sort", column = "book_sort"),
            @Result(property = "url", column = "book_url")
    })
    public List<Book> findAll();

    @Select("select name,category_id from kategorien ")
    @Results({
            @Result(property = "wg_name", column = "name"),
            //@Result(property = "wg_amount", column = "WG_amount"),
            @Result(property = "wg_id", column = "category_id"),
            @Result(property = "wg_update_time", column = "create_time")
    })
    public List<Book> findCate();

    @Select("select buch_book_id from kategorien_has_buch where kategorien_category_id=#{cate_id}")
    @Results({
            @Result(property = "id", column = "Buch_book_id")
    })
    public List<Book> findRela(int cate_id);//通过数和类别关联表找到类别下面的书

    @Select("select book_name,book_price,book_id,book_sum,book_autor,book_info,book_verlag,book_sort,book_url from buch where book_id in (SELECT Buch_book_id FROM kategorien_has_buch WHERE Kategorien_category_id=#{cate_id}) ")
    @Results({
            @Result(property = "name", column = "book_name"),
            @Result(property = "price", column = "book_price"),
            @Result(property = "id", column = "book_id"),
            @Result(property = "sum", column = "book_sum"),
            @Result(property = "autor", column = "book_autor"),
            @Result(property = "info", column = "book_info"),
            @Result(property = "verlag", column = "book_verlag"),
            // @Result(property = "update_time", column = "book_update_time"),
            @Result(property = "sort", column = "book_sort"),
            @Result(property = "url", column = "book_url")
    })
    public List<Book> findBooks(int cate_id);

    @Select("select book_name,book_price,book_id,book_sum,book_autor,book_info,book_verlag,book_sort,book_url from buch where book_id =#{id} ")//注意这里要引用单个变量要用#{}而不是${}
    @Results({
            @Result(property = "name", column = "book_name"),
            @Result(property = "price", column = "book_price"),
            @Result(property = "id", column = "book_id"),
            @Result(property = "sum", column = "book_sum"),
            @Result(property = "autor", column = "book_autor"),
            @Result(property = "info", column = "book_info"),
            @Result(property = "verlag", column = "book_verlag"),
            // @Result(property = "update_time", column = "book_update_time"),
            @Result(property = "sort", column = "book_sort"),
            @Result(property = "url", column = "book_url")
    })
    public List<Book> findBook(int id);

   /* @Insert(" insert into buch ( book_name ) values (#{name}) ")
    public int save(Book book);

    @Delete(" delete from buch where book_id= #{id} ")
    public void delete(int id);

    @Select("select * from buch where book_id= #{id} ")
    public Book get(int id);

    @Update("update buch set name=#{name} where book_id=#{id} ")
    public int update(Book book);*/

}
