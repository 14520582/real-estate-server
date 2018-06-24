package com.realestate.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.realestate.entity.Property;

public class PropertySpecification implements Specification<Property> {
	private SearchCriteria criteria;
	
	public PropertySpecification(SearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Property> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
          if (criteria.getKey().equalsIgnoreCase("numofbedroom")) {
        	if(criteria.getOperation().equalsIgnoreCase(">"))
        		return builder.greaterThanOrEqualTo(
        				root.<String> get(criteria.getKey()), criteria.getValue().toString());
        	if(criteria.getOperation().equalsIgnoreCase("<"))
        		return builder.lessThanOrEqualTo(
        				root.<String> get(criteria.getKey()), criteria.getValue().toString());
           	if(criteria.getOperation().equalsIgnoreCase(":"))
	           return builder.equal(root.get(criteria.getKey()), criteria.getValue());
          }
          if (criteria.getKey().equalsIgnoreCase("numofbathroom")) {
        	if(criteria.getOperation().equalsIgnoreCase(">"))
        		return builder.greaterThanOrEqualTo(
        				root.<String> get(criteria.getKey()), criteria.getValue().toString());
        	if(criteria.getOperation().equalsIgnoreCase("<"))
        		return builder.lessThanOrEqualTo(
        				root.<String> get(criteria.getKey()), criteria.getValue().toString());
           	if(criteria.getOperation().equalsIgnoreCase(":"))
	            return builder.equal(root.get(criteria.getKey()), criteria.getValue());           	
          }
	      if (criteria.getKey().equalsIgnoreCase("city")) {
	    	  return builder.equal(root.get("address").get("city").get("id"), criteria.getValue());
	      }
	      if (criteria.getKey().equalsIgnoreCase("ward")) {
	    	  return builder.equal(root.get("address").get("ward").get("id"), criteria.getValue());
	      }
	      if (criteria.getKey().equalsIgnoreCase("district")) {
	    	  return builder.equal(root.get("address").get("district").get("id"), criteria.getValue());
	      }
	      if (criteria.getKey().equalsIgnoreCase("type")) {
	    	  return builder.equal(root.get("type"), criteria.getValue());
	      } 
	      if (criteria.getKey().equalsIgnoreCase("price")) {
	        	if(criteria.getOperation().equalsIgnoreCase(">"))
	        		return builder.greaterThanOrEqualTo(
	        				root.<String> get(criteria.getKey()), criteria.getValue().toString());
	        	if(criteria.getOperation().equalsIgnoreCase("<"))
	        		return builder.lessThanOrEqualTo(
	        				root.<String> get(criteria.getKey()), criteria.getValue().toString());
	           	if(criteria.getOperation().equalsIgnoreCase(":"))
		           return builder.equal(root.get(criteria.getKey()), criteria.getValue());
//	           	if(criteria.getOperation().equalsIgnoreCase("^"))
//		           return builder.
	      }
	      if (criteria.getKey().equalsIgnoreCase("area")) {
	        	if(criteria.getOperation().equalsIgnoreCase(">"))
	        		return builder.greaterThanOrEqualTo(
	        				root.<String> get(criteria.getKey()), criteria.getValue().toString());
	        	if(criteria.getOperation().equalsIgnoreCase("<"))
	        		return builder.lessThanOrEqualTo(
	        				root.<String> get(criteria.getKey()), criteria.getValue().toString());
	           	if(criteria.getOperation().equalsIgnoreCase(":"))
		           return builder.equal(root.get(criteria.getKey()), criteria.getValue());
	      }
	      if (criteria.getKey().equalsIgnoreCase("numoffloor")) {
	        	if(criteria.getOperation().equalsIgnoreCase(">"))
	        		return builder.greaterThanOrEqualTo(
	        				root.<String> get(criteria.getKey()), criteria.getValue().toString());
	        	if(criteria.getOperation().equalsIgnoreCase("<"))
	        		return builder.lessThanOrEqualTo(
	        				root.<String> get(criteria.getKey()), criteria.getValue().toString());
	           	if(criteria.getOperation().equalsIgnoreCase(":"))
		           return builder.equal(root.get(criteria.getKey()), criteria.getValue());
	      }
	      if (criteria.getKey().equalsIgnoreCase("direction")) {
	    	  return builder.equal(root.get("direction"), criteria.getValue());
	      }
	      if (criteria.getKey().equalsIgnoreCase("form")) {
	    	  return builder.equal(root.get("form"), criteria.getValue());
	      }
        return null;
	}

}
