
public class Multiply implements Operation{
	@Override
	public int calculate(int a, int b) {
		System.out.println("Multiply");
		return a * b;
	}
}
