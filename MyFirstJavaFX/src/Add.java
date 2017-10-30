

public class Add implements Operation{
	@Override
	public int calculate(int a, int b) {
		System.out.println("Add");
		return a + b;
	}

}
