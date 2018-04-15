package com.realestate.service;
//import java.util.List;
import com.realestate.entity.Owner;

public interface  IOwnerService {
	Owner findByName(String name);
}
