package com.example.spc.myapplication;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ExpandedMenuView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Created by JokAr on 16/8/6.
 */
public class InjectActivity {
    private static final ArrayMap<String, Object> injectMap = new ArrayMap<>();

    public static void inject(AppCompatActivity activity) {
        String className = activity.getClass().getName();
        try {
            Object inject = injectMap.get(className);

            if (inject == null) {
                Class<?> aClass = Class.forName(className + "$$InjectActivity");
                inject = aClass.newInstance();
                injectMap.put(className, inject);
            }
            Method m1 = inject.getClass().getDeclaredMethod("inject", activity.getClass());
            m1.invoke(inject, activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
