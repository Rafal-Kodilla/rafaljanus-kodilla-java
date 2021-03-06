package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMain {
    public static void main(String[] args) {
        int k = 0;
        BigDecimal a = new BigDecimal("1000");
        for (BigDecimal i = new BigDecimal("0"); i.compareTo(a) < 0; i = i.add(BigDecimal.ONE)) {
            k = k + 1;
            System.out.println(i + " " + k);
        }

        Forum newForum = new Forum();
        Map<Integer, ForumUser> userMap = newForum.getUserList().stream()
                .filter(user -> user.getUserSex() == 'F')
                .filter(user -> user.getUserBirthday().getYear() > 1997)
                .filter(user -> user.getNumberOfPosts() == 0)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        System.out.println(userMap.size());

        userMap.entrySet().stream()
                .map(user -> user.getKey() + " -- " + user.getValue())
                .forEach(user -> System.out.println(user));

        BigDecimal sandQuantity = new BigDecimal("12345678901234567890");
        sandQuantity.setScale(5, 3);
        System.out.println(sandQuantity.scale());
        //for(BigDecimal i = sandQuantity; i < BigDecimal.ONE; i.subtract(1))
    }
}