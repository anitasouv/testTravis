
public class OperationalFactory {
	public static Operation getOperation(String operation) {
		
		if (operation == null) {
			return null;
		}
		if (operation.equalsIgnoreCase("DIVIDE")) {
			return new Divide();
		} else if (operation.equalsIgnoreCase("SUBTRACT")) {
			return new Subtract();
		} else if (operation.equalsIgnoreCase("ADD")) {
			return new Add();
		} else if (operation.equalsIgnoreCase("MULTIPLY")) {
			return new Multiply();
		}
		
		return null;
	} 
}
