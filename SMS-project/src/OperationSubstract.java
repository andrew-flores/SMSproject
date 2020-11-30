//Strategy design pattern #3
//subtracting two numbers
public class OperationSubstract implements Strategy {
	
	@Override
	public double doOperation(double num1, double num2) {
		return num1 - num2;
	}
}
