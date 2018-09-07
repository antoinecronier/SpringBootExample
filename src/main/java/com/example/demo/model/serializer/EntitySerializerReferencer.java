package com.example.demo.model.serializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EntitySerializerReferencer {

    private EntitySerializerReferencer()
    {
    	this.itemChecker = new HashMap<Object, Integer>();
    }

    private static EntitySerializerReferencer INSTANCE = null;
     
    public static synchronized EntitySerializerReferencer getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new EntitySerializerReferencer(); 
        }
        return INSTANCE;
    }
    
    private Integer maxDeep = 1;

	public Integer getMaxDeep() {
		return maxDeep;
	}

	public void setMaxDeep(Integer maxDeep) {
		this.maxDeep = maxDeep;
	}
	
	/////////////////////////////////////////
	// Model deep reference ocurence check //
	/////////////////////////////////////////
	private Map<Object,Integer> itemChecker;

	public Map<Object, Integer> getItemChecker() {
		return itemChecker;
	}

	public void setItemChecker(Map<Object, Integer> itemChecker) {
		this.itemChecker = itemChecker;
	}
	
	public Boolean isDeepStop(Object object) {
		Boolean result = false;
		
		if (object != null) {
			if (!itemChecker.containsKey(object)) {
				itemChecker.put(object, 0);
			}
			
			for (Entry<Object, Integer> iterable_element : itemChecker.entrySet()) {
				if (object.equals(iterable_element.getKey())) {
					
					if (iterable_element.getValue() >= maxDeep) {
						result = true;
						break;
					}
					
					iterable_element.setValue(iterable_element.getValue() + 1);
				}
			}
		}
		return result;
	}
}
