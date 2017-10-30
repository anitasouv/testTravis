
public class Divide implements Operation {
	@Override
	public int calculate(int a, int b) {
		System.out.println("Divide");
		return a / b;
	}
}