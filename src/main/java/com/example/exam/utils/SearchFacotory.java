package com.example.exam.utils;

import com.example.exam.model.SearchCriteria;
import com.example.exam.spec.SearchSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Component
public class SearchFacotory<T,S extends SearchSpecification<T>> {

    public SearchFacotory() {}

    public  Specification<T> buildSearch(Map<String,String> searchParams, Class spec ){
        Specification<T> result = null;
        var it = searchParams.entrySet().iterator();
            if(!it.hasNext())
                return  result;
        try {
            var specInst = (S) spec.getConstructors()[0].newInstance();
            var item = it.next();
            specInst.setCriteria( new SearchCriteria( item.getKey(), ":", item.getValue()));
            result =specInst;

            while(it.hasNext()){
                specInst = (S) spec.getConstructors()[0].newInstance();
                item = it.next();
                specInst.setCriteria( new SearchCriteria( item.getKey(), ":", item.getValue()));
                result =result.and(specInst);
            }


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  result;
    }


}
