package pse_gui;

public class Field {
	private String name, description, value;
	private Boolean required;
	
	private SharedCentralisedClass sharedClass;
	
	public Field(SharedCentralisedClass sharedClass, String Name, String Description, String Value, Boolean Required){
		this.sharedClass = sharedClass;
		this.name = Name;
		this.description = Description;
		if (Value != null && !Value.isEmpty())
			this.value = Value;
		else
			this.value = "";
		this.required = Required;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public boolean isRequired() {
		return required;
	}
	
	@Override
	public String toString(){
		return "FIELD: name: \"" + name + "\", description: \"" + description + "\", value: \"" + (value == null ? "[null]":value) + "\", Required: " + required.toString(); 
	}
	
	public Field copy(){
		return new Field(this.sharedClass, name, description, value, required);
	}
}
