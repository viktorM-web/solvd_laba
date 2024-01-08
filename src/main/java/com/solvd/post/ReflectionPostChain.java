package com.solvd.post;

import com.solvd.post.entity.PostalChain;
import com.solvd.post.util.Creator;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.*;
import java.util.Arrays;

@Slf4j
public class ReflectionPostChain {

    public static PostalChain getPostChain() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<PostalChain> postalChainConstructors = PostalChain.class.getDeclaredConstructor();
        postalChainConstructors.setAccessible(true);
        PostalChain postalChain = postalChainConstructors.newInstance();
        Method toString = PostalChain.class.getMethod("toString");
        Object result = toString.invoke(postalChain);
        log.info(result.toString());

        Method createPostSystem = Creator.class.getMethod("createPostSystem");
        postalChain = (PostalChain) createPostSystem.invoke(Creator.class);

        result = toString.invoke(postalChain);
        log.info(result.toString());

        getAllInfoAboutPostalChainClass();

        return postalChain;
    }

    private static void getAllInfoAboutPostalChainClass() {
        Constructor<?>[] constructors = PostalChain.class.getDeclaredConstructors();
        Method[] methods = PostalChain.class.getDeclaredMethods();
        Field[] fields = PostalChain.class.getDeclaredFields();
        log.info("FIELDS");
        Arrays.stream(fields)
                .forEach(v->{
                    log.info(Modifier.toString(v.getModifiers())+" " + v.getType()+" " +v.getName());
                });
        log.info("METHODS");
        Arrays.stream(methods)
                .forEach(v->{
                    log.info(Modifier.toString(v.getModifiers())+" " + v.getReturnType()+" " + v.getName()+" "+ Arrays.toString(v.getParameters()));
                });
        log.info("CONSTRUCTORS");
        Arrays.stream(constructors)
                .forEach(v->{
                    log.info(Modifier.toString(v.getModifiers())+" " + v.getName()+" "+ Arrays.toString(v.getParameters()));
                });
    }
}
