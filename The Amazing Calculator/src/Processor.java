
public class Processor {
	
	private double fNum;
	private double sNum;
	private String operation;
	private String output;
	
	public Processor(double fNum, double sNum, String operation) {
		this.fNum = fNum;
		this.sNum = sNum;
		this.operation = operation;
	}
	
	//doing the math..
	public String process() {
		double intOutput = 0;
		switch(operation) {
		case "+":
			intOutput =  fNum+sNum;
			break;
		case "-":
			intOutput = fNum-sNum;
			break;
		case "*":
			intOutput = fNum*sNum;
			break;
		case "/":
			intOutput = fNum/sNum;
			break;
		}
		return fNum+" "+operation+" "+ sNum +" = "+ intOutput;
	}
	
}
