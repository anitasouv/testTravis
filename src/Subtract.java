
public class Subtract implements Operation{
	@Override
	public int calculate(int a, int b) {
		System.out.println("Subtract");
		return a - b;
	}

}
