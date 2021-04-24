package com.meditation.factory;

import com.meditation.pojo.books;
import com.meditation.pojo.user;

import java.util.ArrayList;
import java.util.List;

public class userfactoy2 {
    public user getuser(String name) {
        books book = new books(1, "西游记", "赞赏");
        List<books> list = new ArrayList<>();
        list.add(book);

        user user = new user(name, "18", "篮球", list);
        return user;
    }
}
