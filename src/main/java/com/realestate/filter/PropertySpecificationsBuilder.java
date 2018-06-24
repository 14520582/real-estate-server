package com.realestate.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.realestate.entity.Property;

public class PropertySpecificationsBuilder {
    private List<SearchCriteria> params;
    
    public PropertySpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
 
    public PropertySpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
 
    public Specification<Property> build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<Specification<Property>> specs = new ArrayList<Specification<Property>>();
        for (SearchCriteria param : params) {
            specs.add(new PropertySpecification(param));
        }
 
        Specification<Property> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }
}
