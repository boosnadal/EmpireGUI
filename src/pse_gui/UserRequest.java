package pse_gui;
// How should we know that RpxWeakStub was modified ?
// We know that its field target was modified via the field associated to it.
// But I have no clue on how to know that RpxWeakStub was the modified module/agent/stagger ?
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRequest {
	private List<Field> fieldList;
	private String endpoint;
	private Communication.METHODS method;
	private ItemType type;
	
	private SharedCentralisedClass sharedClass;
	
	public UserRequest(SharedCentralisedClass sharedClass, Communication.METHODS method, List<Field> fieldList, ItemType type, Map<String, Object> objectMap){
		this.sharedClass = sharedClass;
		this.method = method;
		this.type = type;
		if (fieldList == null)
			this.fieldList = new ArrayList<Field>();
		else
			this.fieldList = fieldList;
		this.endpoint = type.getStringValue() + "/" + getEndpoint(objectMap);
	}
	
	public UserRequest(SharedCentralisedClass sharedClass, Communication.METHODS method, List<Field> fieldList, ItemType type){
		this.sharedClass = sharedClass;
		this.method = method;
		this.type = type;
		if (fieldList == null)
			this.fieldList = new ArrayList<Field>();
		else
			this.fieldList = fieldList;
		this.endpoint = type.getStringValue();
	}
	
	public UserRequest(SharedCentralisedClass sharedClass, Communication.METHODS method, List<Field> fieldList, ItemType type, String endpoint){
		this.sharedClass = sharedClass;
		this.method = method;
		this.type = type;
		if (fieldList == null)
			this.fieldList = new ArrayList<Field>();
		else
			this.fieldList = fieldList;
		this.endpoint = endpoint;
	}
	
	private String getEndpoint(Map<String, Object> objectMap){
		Object value = objectMap.get(PSEConstants.ENDPOINT_NAME_KEY);
		if (value instanceof String)
			return (String)value;
		else
			throw new RuntimeException("Invalid value in UserRequest.getEndpoint(). Expected a string.");
	}
	
	
	public void addField(Field field){
		this.fieldList.add(field);
	}
	
	public List<Field> getFieldList(){
		return this.fieldList;
	}
	
	public Field getFieldFromName(String name){
		for(Field f : this.getFieldList()){
			if(f.getName().equals(name))
				return f;
		}
		return null;
	}
	
	public String getEndpoint(){
		return this.endpoint;
	}
	
	public Communication.METHODS getMethod(){
		return method;
	}
	
	public ItemType getType(){
		return this.type;
	}
}
